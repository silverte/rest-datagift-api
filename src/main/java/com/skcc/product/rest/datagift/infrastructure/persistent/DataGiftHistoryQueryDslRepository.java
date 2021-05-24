package com.skcc.product.rest.datagift.infrastructure.persistent;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.entity.QDataGiftHistory;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryQueryRepository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DataGiftHistoryQueryDslRepository extends QuerydslRepositorySupport implements IDataGiftHistoryQueryRepository {

    public DataGiftHistoryQueryDslRepository() {
        super(DataGiftHistory.class);
    }

	//@Override
	public QueryResults<Tuple> getMonthDataGiftSendHistoryCount(String svcMgmtNum, String yyyymm) {
		log.debug("svgMgmtNum [{}]", svcMgmtNum);
		final QDataGiftHistory hist = QDataGiftHistory.dataGiftHistory;
		
		return from(hist)
				.where(hist.opDtm.like(yyyymm))
				.groupBy(hist.afmlyGiftYn)
				.select(hist.afmlyGiftYn, hist.afmlyGiftYn.count())
				.fetchResults();
	}
}