package com.skcc.product.rest.datagift.core.port_infra.external_system;

import org.springframework.http.ResponseEntity;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;

public interface IExternalSampleSystem {

    public ResponseEntity<String> doSomeExternalLogic(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

}