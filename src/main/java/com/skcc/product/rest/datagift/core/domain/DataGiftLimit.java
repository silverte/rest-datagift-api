package com.skcc.product.rest.datagift.core.domain;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class DataGiftLimit {
    public final static long generalCount = 2;
    public static long extraCount = 0;
	
	public static void getSendCountLimit(ProductGroup productGroup) {
	
		switch(productGroup.name()) {
		case "UNLIMITED": extraCount = 99999;
		     break;
		case "FAMILY_VIP": extraCount = 6;
		     break;
		case "FAMILY": extraCount = 2;
	         break;
	    default: extraCount = 0;
		}
		
		log.debug("[extraCount ()]", extraCount);
	}

}
