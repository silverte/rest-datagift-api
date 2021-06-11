package com.skcc.product.rest.datagift.infrastructure.persistent;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.entity.QDataGiftHistory;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftQueryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DataGiftQueryDslRepository extends QuerydslRepositorySupport implements IDataGiftQueryRepository {

    public DataGiftQueryDslRepository() {
        super(DataGiftAggregate.class);
    }

    @Override
    public Page<DataGiftHistory> searchAll( final String svcMgmtNum
                                               , final String fromDate
                                               , final String toDate
                                               , final Pageable pageable){

        log.debug("[Service] DataGiftQueryDslRepository Called - searchAllAnd [{}][{}][{}][{}]", svcMgmtNum, fromDate, toDate, pageable);

        final QDataGiftHistory dataGiftHistory = QDataGiftHistory.dataGiftHistory;
        final JPQLQuery<DataGiftHistory> query;

        query = from(dataGiftHistory);
        
        // where 조건 생성
        BooleanBuilder whereBuilder = new BooleanBuilder();
        
        whereBuilder.and(dataGiftHistory.svcMgmtNum.eq(svcMgmtNum));
        
        // where절 설정
        query.where(whereBuilder);

        final List<DataGiftHistory> queryResults = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(queryResults, pageable, query.fetchCount());
    }

}