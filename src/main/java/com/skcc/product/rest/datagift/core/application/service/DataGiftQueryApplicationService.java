package com.skcc.product.rest.datagift.core.application.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.skcc.product.rest.datagift.core.application.object.query.DataGiftQueryRequestDTO;
import com.skcc.product.rest.datagift.core.domain.DataGift;
import com.skcc.product.rest.datagift.core.domain.DonorServiceInfo;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftAggregate;
import com.skcc.product.rest.datagift.core.domain.entity.DataGiftHistory;
import com.skcc.product.rest.datagift.core.domain.vo.DataGiftHistoryCount;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftCommmandRepository;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryCommmandRepository;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftHistoryQueryRepository;
import com.skcc.product.rest.datagift.core.port_infra.persistent.IDataGiftQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataGiftQueryApplicationService implements IDataGiftQueryApplicationService {

    private final IDataGiftQueryRepository dataGiftQueryRepository;
    private final IDataGiftHistoryCommmandRepository repo;

	@Override
	public Page<DataGiftHistory> queryDataGiftHistory(DataGiftQueryRequestDTO dataGiftQueryRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - queryAllOrUserStorySampleDomain [{}]", dataGiftQueryRequestDTO);

        
        DataGiftHistory hist = DataGiftHistory.builder()
                .svcMgmtNum("7123456789")
                .opDtm("20210501092530")
                .befrCustNum("9777755550")
                .befrProdId("NA00006404")
                .befrSvcMgmtNum("7777755555")
                .befrSvcNum("01091110424")
                .custNum("9888855550")
                .dataGiftOpStCd("1")
                .dataGiftTypCd("G1")
                .giftDataQty("1024")
                .prodId("NA00006404")
                .build();
		log.debug(hist.toString());
		repo.save(hist);
        
		return dataGiftQueryRepository.searchAll(dataGiftQueryRequestDTO.getSvcMgmtNum()
				                                   , dataGiftQueryRequestDTO.getFromDate()
				                                   , dataGiftQueryRequestDTO.getToDate()
				                                   , dataGiftQueryRequestDTO.of());
	}

}
