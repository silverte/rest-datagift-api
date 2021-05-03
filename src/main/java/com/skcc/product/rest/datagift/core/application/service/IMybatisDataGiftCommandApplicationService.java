package com.skcc.product.rest.datagift.core.application.service;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;

public interface IMybatisDataGiftCommandApplicationService {
    public void insertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void updateOrInsertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void updateUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO);

    public void deleteUserStory(final String id);

}
