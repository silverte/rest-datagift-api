package com.skcc.product.rest.datagift.core.domain;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataGiftLimit {
    public final long generalCount = 2;
    public long extraCount;
	
	public DataGiftLimit getSendCountLimit(ProductGroup productGroup) {
	
		switch(productGroup.name()) {
		case "UNLIMITED": extraCount = 99999;
		     break;
		case "FAMILY_VIP": extraCount = 6;
		     break;
		case "FAMILY": extraCount = 2;
	         break;
	    default: extraCount = 0;
		}
		
		log.debug("[extraCount ()]", extraCount);;
		return this;
	}

}
