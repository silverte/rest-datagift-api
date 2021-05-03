package com.skcc.product.rest.datagift.core.port_infra.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;

@Repository
public interface IDataGiftCommmandRepository extends JpaRepository<DataGiftAggregate, String> {
}