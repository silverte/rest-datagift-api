package com.skcc.product.rest.datagift.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "ZORD_DATA_GIFT_HST")
@Builder
@IdClass(DataGiftHistoryId.class)

public class DataGiftHistory {
	
	@Id
	@Column(nullable = false, length = 10)
	private String svcMgmtNum;
	
	@Id
	@Column(nullable = false, length = 14)
	private String opDtm;
	
	@Column(nullable = false, length = 10)
	private String befrSvcMgmtNum;
	
	@Column(nullable = false, length = 15)
	private String befrSvcNum;
	
	// 1:요청 2:성공 3:실패
	@Column(nullable = false, length = 1)
	private String dataGiftOpStCd;
	
	@Column(nullable = false, length = 9)
	private String giftDataQty;
	
	@Column(nullable = true, length = 10)
	private String prodId;
	
	@Column(nullable = true, length = 10)
	private String befrProdId;
	
	@Column(nullable = true, length = 10)
	private String custNum;
	
	@Column(nullable = true, length = 10)
	private String befrCustNum;

	// G1:데이터선물 GC:자동선물 GD:선물Day 
	@Column(nullable = true, length = 2)
	@Builder.Default String dataGiftTypCd = "G1";
	
	@Column(nullable = false, length = 1)
	@Builder.Default private String afmlyGiftYn = "N";

}