package com.skcc.product.rest.datagift.core.port_infra.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistoryId;

public interface IDataGiftQueryRepository extends IDataGiftCustomQueryRepository, JpaRepository<DataGiftHistory, DataGiftHistoryId>, QuerydslPredicateExecutor<DataGiftHistory> {

}
