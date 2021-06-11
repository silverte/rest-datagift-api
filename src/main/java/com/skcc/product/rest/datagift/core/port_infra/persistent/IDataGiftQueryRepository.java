package com.skcc.product.rest.datagift.core.port_infra.persistent;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;

public interface IDataGiftQueryRepository {

    public Page<DataGiftHistory> searchAll(final String svcMgmtNum
                                                    , final String fromDate
                                                    , final String toDate
                                                    , final Pageable pageable );
    
}