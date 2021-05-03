package com.skcc.product.rest.datagift.core.application.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.port_infra.external_system.IExternalSampleSystem;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftCommmandRepository;
import com.skcc.product.rest.datagift.infrastructure.external_system.ExternalSampleSystem_ATYPE;
import com.skcc.product.rest.datagift.infrastructure.external_system.ExternalSampleSystem_BTYPE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataGiftApplicationService implements IDataGiftCommandApplicationService {

    private final IDataGiftCommmandRepository dataGiftCommmandRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public void insertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - insertUserStory [{}]", dataGiftCommandApiRequestDTO);

        Optional<DataGiftAggregate> queriedSampleDomainAggregate =  dataGiftCommmandRepository.findById(dataGiftCommandApiRequestDTO.getId());
        queriedSampleDomainAggregate.ifPresent( c -> {throw new IllegalArgumentException("이미 존재하는 객체 입니다.");} );

        DataGiftAggregate dataGiftAggregate = modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class);
        dataGiftCommmandRepository.save( dataGiftAggregate );
    };

    @Transactional
    @Override
    public void updateUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - updateUserStory [{}]", dataGiftCommandApiRequestDTO);
 
        Optional<DataGiftAggregate> queriedSampleDomainAggregate =  dataGiftCommmandRepository.findById(dataGiftCommandApiRequestDTO.getId());
        queriedSampleDomainAggregate.orElseThrow( () -> new IllegalArgumentException("존재하지 않는 객체 입니다.") );

        if(dataGiftCommandApiRequestDTO.getSampleData1() != null) queriedSampleDomainAggregate.get().setSampleData1( dataGiftCommandApiRequestDTO.getSampleData1() );
        if(dataGiftCommandApiRequestDTO.getSampleData2() != null) queriedSampleDomainAggregate.get().setSampleData2( dataGiftCommandApiRequestDTO.getSampleData2() );
    };

    @Override
    public void updateOrInsertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - updateOrInsertUserStory [{}]", dataGiftCommandApiRequestDTO);

        DataGiftAggregate dataGiftAggregate = modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class);

        dataGiftCommmandRepository.save(dataGiftAggregate);
    };


    @Override
    public void deleteUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - deleteUserStory [{}]", dataGiftCommandApiRequestDTO);

        DataGiftAggregate dataGiftAggregate = modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class);

        dataGiftCommmandRepository.delete(dataGiftAggregate);
    };

    @Override
    public ResponseEntity<String> doInterfaceExternalSystem(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - doInterfaceExternalSystem [{}]", dataGiftCommandApiRequestDTO);

        IExternalSampleSystem externalSampleSystem;
        
        if ("A".equals(dataGiftCommandApiRequestDTO.getExternalSystemType())){
            externalSampleSystem = new ExternalSampleSystem_ATYPE();
        } else {
            externalSampleSystem = new ExternalSampleSystem_BTYPE();
        }

        //do Some Logic with External System
        return externalSampleSystem.doSomeExternalLogic( dataGiftCommandApiRequestDTO );
    }
}
