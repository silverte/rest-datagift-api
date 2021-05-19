package com.skcc.product.rest.datagift.core.domain.vo;

import lombok.Data;

@Data
public class DataGiftHistoryCount {
	long generalCount;
	long extraCount;
	long sentGeneralCount;
	long sentExtraCount;
}
