package com.skcc.product.rest.datagift.core.port_infra.persistent.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.skcc.product.rest.datagift.core.application.object.command.DataGiftResponseDTO;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;

import java.util.List;

@Mapper
public interface IMybatisDataGiftMapper {
    List<DataGiftAggregate> findAll();
    DataGiftAggregate findById(String id);
    void save(DataGiftAggregate dataGiftAggregate);
    void update(DataGiftAggregate dataGiftAggregate);
    void delete(String id);
}
