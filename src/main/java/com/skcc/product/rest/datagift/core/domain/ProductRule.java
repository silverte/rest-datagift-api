package com.skcc.product.rest.datagift.core.domain;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class ProductRule {
	
	public ProductGroup getProductGroup(String svcMgmtNum, String feeProdId) {
		
		log.debug("서비스상품그룹, 상품그룹, 체크 !!! ");
		
		String groupCode = "NA00005958";
        ProductGroup productGroup = ProductGroup.findByProductCode(groupCode);
		
		return productGroup;
	}
	
}
