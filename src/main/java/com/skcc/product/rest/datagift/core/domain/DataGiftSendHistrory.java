package com.skcc.product.rest.datagift.core.domain;

import java.util.List;

import com.querydsl.core.types.Predicate;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftQueryRepository;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class DataGiftSendHistrory {
	IDataGiftQueryRepository repo;
	
    public void geMonthlySendHistory() {
    	Predicate predicate = null;
    	repo.count(predicate);    	
    }
}
