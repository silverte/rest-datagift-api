package com.skcc.product.rest.datagift.infrastructure.external_system;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.skcc.product.rest.common.error.handler.RestTemplateErrorHandler;
import com.skcc.product.rest.common.intercept.RestTemplateClientHttpRequestInterceptor;
import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;
import com.skcc.product.rest.datagift.core.port_infra.external_system.IExternalSampleSystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalSampleSystem_BTYPE implements IExternalSampleSystem {

    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
    
    public ExternalSampleSystem_BTYPE(){
        
        restTemplateBuilder = new RestTemplateBuilder();

        restTemplate = restTemplateBuilder.rootUri("http://localhost:8080")
                                        .additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
                                        .errorHandler(new RestTemplateErrorHandler())
                                        .setConnectTimeout(Duration.ofMinutes(3))
                                        .build();
    }

    @Override
    public ResponseEntity<String> doSomeExternalLogic( final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ) {
        log.debug("[ExternalSampleSystem_BTYPE Called] doSomeExternalLogic");

        ResponseEntity<String> result = restTemplate.getForEntity("/404", String.class);
        
        return result;
    }

}