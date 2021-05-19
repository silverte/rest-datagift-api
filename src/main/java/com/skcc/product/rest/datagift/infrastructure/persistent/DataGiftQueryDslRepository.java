package com.skcc.product.rest.datagift.infrastructure.persistent;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO.SampleDomainKeyType;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.QDataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.QDataGiftHistory;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftCustomQueryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.NoRepositoryBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoRepositoryBean
public class DataGiftQueryDslRepository extends QuerydslRepositorySupport implements IDataGiftCustomQueryRepository {

    public DataGiftQueryDslRepository() {
        super(DataGiftAggregate.class);
    }

    @Override
    public Page<DataGiftAggregate> searchAllAnd( final List<SampleDomainKeyType> searchKeys
                                                        , final List<String> searchvalues
                                                        , final Pageable pageable){

        log.debug("[Service] DataGiftQueryDslRepository Called - searchAllAnd [{}][{}][{}]", searchKeys, searchvalues, pageable);

        final QDataGiftAggregate dataGiftAggregate = QDataGiftAggregate.dataGiftAggregate;
        final JPQLQuery<DataGiftAggregate> query;

        query = from(dataGiftAggregate);

        if (searchKeys != null && searchKeys.size() > 0){
            // where 조건 생성
            BooleanBuilder whereBuilder = new BooleanBuilder();

            for(int i=0; i<searchKeys.size(); i++){
                
                SampleDomainKeyType key = searchKeys.get(i);
                String value = searchvalues.get(i);

                switch (key) {
                    case id:{
                        whereBuilder.and(dataGiftAggregate.id.eq(value));
                        break;
                    } case sampleData1:{
                        whereBuilder.and(dataGiftAggregate.sampleData1.eq(value));
                        break;
                    } case sampleData2:{
                        whereBuilder.and(dataGiftAggregate.sampleData2.eq(value));
                        break;
                    } default:{
                        throw new IllegalArgumentException();
                    }
                }
            }
            // where절 설정
            query.where(whereBuilder);
        }

        final List<DataGiftAggregate> queryResults = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(queryResults, pageable, query.fetchCount());
    }

    @Override
    public Page<DataGiftAggregate> searchAllOr( final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable){

        log.debug("[Service] DataGiftQueryDslRepository Called - searchAllOr [{}][{}][{}]", searchKeys, searchvalues, pageable);
        final QDataGiftAggregate dataGiftAggregate = QDataGiftAggregate.dataGiftAggregate;
        final JPQLQuery<DataGiftAggregate> query;

        query = from(dataGiftAggregate);

        if (searchKeys != null && searchKeys.size() > 0){
            // where 조건 생성
            BooleanBuilder whereBuilder = new BooleanBuilder();

            for(int i=0; i<searchKeys.size(); i++){
                
                SampleDomainKeyType key = searchKeys.get(i);
                String value = searchvalues.get(i);

                switch (key) {
                    case id:{
                        whereBuilder.or(dataGiftAggregate.id.eq(value));
                        break;
                    } case sampleData1:{
                        whereBuilder.or(dataGiftAggregate.sampleData1.eq(value));
                        break;
                    } case sampleData2:{
                        whereBuilder.or(dataGiftAggregate.sampleData2.eq(value));
                        break;
                    } default:{
                        throw new IllegalArgumentException();
                    }
                }
            }
            // where절 설정
            query.where(whereBuilder);
        }

        final List<DataGiftAggregate> queryResults = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(queryResults, pageable, query.fetchCount());
    }

	@Override
	public QueryResults<Tuple> getMonthDataGiftSendHistoryCount(long svcMgmtNum, String yyyymm) {
		log.debug("svgMgmtNum [{}]", svcMgmtNum);
		final QDataGiftHistory hist = QDataGiftHistory.dataGiftHistory;
		
		return from(hist)
				.where(hist.opDtm.like(yyyymm))
				.groupBy(hist.afmlyGiftYn)
				.select(hist.afmlyGiftYn, hist.afmlyGiftYn.count())
				.fetchResults();
	}
}