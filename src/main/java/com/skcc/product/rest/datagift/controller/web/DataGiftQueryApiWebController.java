package com.skcc.product.rest.datagift.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO;
import com.skcc.product.rest.datagift.core.application.service.IDataGiftQueryApplicationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/datagift")
public class DataGiftQueryApiWebController {

    @Autowired
    IDataGiftQueryApplicationService dataGiftQueryApplicationService;

    @GetMapping("/and")
    public ResponseEntity<Object> getAndSampleDomainAggregate( final DataGiftQueryRequestDTO dataGiftQueryRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - getSampleDomainAggregate");
        
        return new ResponseEntity<>( dataGiftQueryApplicationService.queryDataGiftHistory(dataGiftQueryRequestDTO)
                                    , HttpStatus.OK);
    }
    
    @GetMapping("hello")
    public ResponseEntity<Object> hello(){
    	return new ResponseEntity<>("hello world!", HttpStatus.OK);
    }
} 