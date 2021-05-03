package com.skcc.product.rest.datagift.core.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftCommandApiRequestDTO;
import com.skcc.product.rest.datagift.core.application.object.command.DataGiftResponseDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.port_infra.persistent.mybatis.IMybatisDataGiftMapper;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MybatisDataGiftCommandApplicationService implements IMybatisDataGiftCommandApplicationService{
    private final IMybatisDataGiftMapper iMybatisSampleDomainMapper;
    private final ModelMapper modelMapper;

    @Override
    public void insertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO){

        log.debug("[Service] MybatisDataGiftCommandApplicationService Called - insertUserStory [{}]", dataGiftCommandApiRequestDTO);

        if(!(null ==iMybatisSampleDomainMapper.findById(dataGiftCommandApiRequestDTO.getId()))){
            throw new IllegalArgumentException("이미 존재하는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.save(modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class));
        }
    }

    @Override
    public void updateUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO){
        log.debug("[Service] MybatisDataGiftCommandApplicationService Called - updateUserStory [{}]", dataGiftCommandApiRequestDTO);

        if(null==iMybatisSampleDomainMapper.findById(dataGiftCommandApiRequestDTO.getId())){
            throw new IllegalArgumentException("존재하지 않는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.update(modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class));
        }
    }

    @Override
    public void deleteUserStory(String id) {
        log.debug("[Service] MybatisDataGiftCommandApplicationService Called - deleteUserStory [{}]", id);

        if(null==iMybatisSampleDomainMapper.findById(id)){
            throw new IllegalArgumentException("존재하지 않는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.delete(id);
        }
    }

    @Override
    public void updateOrInsertUserStory(final DataGiftCommandApiRequestDTO dataGiftCommandApiRequestDTO){
        log.debug("[Service] MybatisDataGiftCommandApplicationService Called - deleteUserStory [{}]", dataGiftCommandApiRequestDTO);

        if(null==iMybatisSampleDomainMapper.findById(dataGiftCommandApiRequestDTO.getId())){
            iMybatisSampleDomainMapper.save(modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class));
        }else{
            iMybatisSampleDomainMapper.update(modelMapper.map(dataGiftCommandApiRequestDTO, DataGiftAggregate.class));
        }
    }

}
