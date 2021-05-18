package com.skcc.product.rest.datagift.core.port_infra.persistent;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO.SampleDomainKeyType;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;

public interface IDataGiftCustomQueryRepository {

    public Page<DataGiftAggregate> searchAllAnd(final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable );

    public Page<DataGiftAggregate> searchAllOr(final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable );
}