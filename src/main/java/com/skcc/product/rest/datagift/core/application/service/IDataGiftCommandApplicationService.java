package com.skcc.product.rest.datagift.core.application.service;

import org.springframework.http.ResponseEntity;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;

public interface IDataGiftCommandApplicationService {
    
    public void insertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void updateOrInsertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void updateUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void deleteUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public ResponseEntity<String> doInterfaceExternalSystem(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

}
