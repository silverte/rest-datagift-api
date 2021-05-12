package com.skcc.product.rest.datagift.core.application.service;

import org.springframework.data.domain.Page;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;

public interface IDataGiftQueryApplicationService {
    
    public Page<DataGiftAggregate> queryAllAndUserStorySampleDomain(final DataGiftQueryRequestDTO dataGiftQueryRequestDTO);

    public Page<DataGiftAggregate> queryAllOrUserStorySampleDomain(final DataGiftQueryRequestDTO dataGiftQueryRequestDTO);

}