package com.skcc.product.rest.datagift.core.domain.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataGiftHistoryCount {
	private final long generalCount;
	private final long extraCount;
	private final long sentGeneralCount;
	private final long sentExtraCount;
}
