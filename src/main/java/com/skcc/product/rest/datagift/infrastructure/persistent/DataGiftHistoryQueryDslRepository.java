package com.skcc.product.rest.datagift.infrastructure.persistent;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.entity.QDataGiftHistory;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftCustomQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.NoRepositoryBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoRepositoryBean
public class DataGiftHistoryQueryDslRepository extends QuerydslRepositorySupport implements IDataGiftCustomQueryRepository {

    public DataGiftHistoryQueryDslRepository() {
        super(DataGiftHistory.class);
    }

	@Override
	public QueryResults<Tuple> getMonthDataGiftSendHistoryCount(final long svcMgmtNum, final String yyyymm) {
		log.debug("svgMgmtNum [{}]", svcMgmtNum);
		final QDataGiftHistory hist = QDataGiftHistory.dataGiftHistory;
		
		return from(hist)
				.where(hist.opDtm.like(yyyymm))
				.groupBy(hist.afmlyGiftYn)
				.select(hist.afmlyGiftYn, hist.afmlyGiftYn.count())
				.fetchResults();
	}
}