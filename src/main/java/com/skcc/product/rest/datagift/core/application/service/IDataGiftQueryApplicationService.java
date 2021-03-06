package com.skcc.product.rest.datagift.core.application.service;

import org.springframework.data.domain.Page;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;

public interface IDataGiftQueryApplicationService {
    
    public Page<DataGiftHistory> queryDataGiftHistory(final DataGiftQueryRequestDTO dataGiftQueryRequestDTO);

}
