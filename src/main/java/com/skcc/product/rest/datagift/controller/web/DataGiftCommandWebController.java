package com.skcc.product.rest.datagift.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;
import com.skcc.product.rest.datagift.core.application.service.IDataGiftCommandApplicationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/sample")
public class DataGiftCommandWebController {

    @Autowired
    IDataGiftCommandApplicationService dataGiftCommandApplicationService;

    @PostMapping
    public ResponseEntity<Object> postSampleDomainAggregate( @RequestBody @Valid DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - postSampleDomainAggregate");

        dataGiftCommandApplicationService.insertUserStory(dataGiftCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> putSampleDomainAggregate( @RequestBody @Valid final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - putSampleDomainAggregate");

        dataGiftCommandApplicationService.updateOrInsertUserStory(dataGiftCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Object> patchSampleDomainAggregate(@RequestBody @Valid final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - patchSampleDomainAggregate");

        dataGiftCommandApplicationService.updateUserStory(dataGiftCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSampleDomainAggregate(@RequestBody @Valid final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - deleteSampleDomainAggregate");

        dataGiftCommandApplicationService.deleteUserStory(dataGiftCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/external")
    public ResponseEntity<String> doInterfaceExternalSystem( @RequestBody DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - doInterfaceExternalSystem");

        return dataGiftCommandApplicationService.doInterfaceExternalSystem(dataGiftCommandApiRequestDTO);
    }

}