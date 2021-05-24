package com.skcc.product.rest.datagift.core.port_infra.persistent;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;

public interface IDataGiftHistoryQueryRepository {
	public QueryResults<Tuple> getMonthDataGiftSendHistoryCount(String svcMgmtNum, String yyyymm);
}
