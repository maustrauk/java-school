package com.lambdaschool.schools.services;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.models.adviceapp.Advice;
import com.lambdaschool.schools.models.adviceapp.Slip;
import com.lambdaschool.schools.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorrepos;

    @Override
    public Instructor addAdvice(long id) {
        Instructor currentInstuctor = instructorrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor with id = "+ id + " not found!"));

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://api.adviceslip.com/advice";
        ParameterizedTypeReference<Advice> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<Advice> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);


        Slip newSlip = responseEntity.getBody().getSlip();

        currentInstuctor.setAdvice(newSlip.getAdvice());


        return currentInstuctor;
    }
}
