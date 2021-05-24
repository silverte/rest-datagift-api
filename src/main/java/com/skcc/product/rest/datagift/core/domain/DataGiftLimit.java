package com.skcc.product.rest.datagift.core.domain;

import javax.annotation.Nonnull;

import org.springframework.stereotype.Component;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class DataGiftLimit {
	private ProductGroup productGroup;
    private final long generalCount = 2;
    private long extraCount = 0;
    
    public DataGiftLimit(ProductGroup productGroup) {
    	this.productGroup = productGroup;
    	getSendCountLimit();
    }
	
	public DataGiftLimit getSendCountLimit() {
	
		switch(productGroup.name()) {
		case "UNLIMITED": extraCount = 99999;
		     break;
		case "FAMILY_VIP": extraCount = 6;
		     break;
		case "FAMILY": extraCount = 2;
	         break;
	    default: extraCount = 0;
		}
		
		log.debug("extraCount [{}]", this.extraCount);
		return this;
	}

}
