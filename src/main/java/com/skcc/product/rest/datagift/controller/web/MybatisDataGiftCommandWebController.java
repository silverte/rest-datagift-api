package com.skcc.product.rest.datagift.controller.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;
import com.skcc.product.rest.datagift.core.application.service.IMybatisDataGiftCommandApplicationService;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/sample/mybatis")
public class MybatisDataGiftCommandWebController {
    @Autowired
    IMybatisDataGiftCommandApplicationService iMybatisSampleDomainCommandApplicationService;

    @PostMapping
    public ResponseEntity<Object> postSampleDomainAggregate(@RequestBody @Valid DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] MybatisDataGiftCommandWebController Called - postSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.insertUserStory(dataGiftCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> putSampleDomainAggregate( @RequestBody @Valid final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] MybatisDataGiftCommandWebController Called - putSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.updateOrInsertUserStory(dataGiftCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<Object> patchSampleDomainAggregate(@RequestBody @Valid final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] MybatisDataGiftCommandWebController Called - patchSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.updateUserStory(dataGiftCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSampleDomainAggregate(String id){
        log.debug("[Controller] SampleDomainWebController Called - deleteSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.deleteUserStory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
