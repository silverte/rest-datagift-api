package com.skcc.product.rest.datagift.core.application.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataGiftQueryApplicationService implements IDataGiftQueryApplicationService {

    private final IDataGiftQueryRepository dataGiftQueryRepository;
    
    @Override
    public Page<DataGiftAggregate> queryAllAndUserStorySampleDomain(final DataGiftQueryRequestDTO dataGiftQueryRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - queryAllAndUserStorySampleDomain [{}]", dataGiftQueryRequestDTO);

        return dataGiftQueryRepository.searchAllAnd( dataGiftQueryRequestDTO.getSearchKeys()
                                                        , dataGiftQueryRequestDTO.getSearchvalues()
                                                        , dataGiftQueryRequestDTO.of() );
    }

    @Override
    public Page<DataGiftAggregate> queryAllOrUserStorySampleDomain(DataGiftQueryRequestDTO dataGiftQueryRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - queryAllOrUserStorySampleDomain [{}]", dataGiftQueryRequestDTO);

        return dataGiftQueryRepository.searchAllOr( dataGiftQueryRequestDTO.getSearchKeys()
                                                        , dataGiftQueryRequestDTO.getSearchvalues()
                                                        , dataGiftQueryRequestDTO.of() );
    }
}
