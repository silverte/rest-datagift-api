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

public class DataGiftHistory extends AbstractAuditEntity {
	
	@Id
	@Column(nullable = false, length = 10)
	private String svcMgmtNum;
	
	@Id
	@Column(nullable = false, length = 14)
	private String opDtm;
	
	@Column(nullable = false, length = 10)
	private String befrSvcMgmtNum;
	
	@Column(nullable = false, length = 1)
	private String dataGiftOpStCd;
	
	@Column(nullable = false, length = 9)
	private String giftDataQty;
	
	@Column(nullable = false, length = 10)
	private String opSaleOrgId;
	
	@Column(nullable = false, length = 10)
	private String oprId;
	
	@Column(nullable = true, length = 10)
	private String prodId;
	
	@Column(nullable = true, length = 10)
	private String befrProdId;
	
	@Column(nullable = true, length = 10)
	private String custNum;
	
	@Column(nullable = true, length = 10)
	private String befrCustNum;
	
	@Column(nullable = true, length = 4)
	private String giftIFRsltCd;

	@Column(nullable = true, length = 2)
	@Builder.Default String dataGiftTypCd = "G1";
	
	@Column(nullable = false, length = 1)
	@Builder.Default private String afmlyGiftYn = "N";
	
	@Column(nullable = false, length = 2)
	@Builder.Default private String giftDayClCd = "00";

	@Column(nullable = true, length = 9)
	private long rlGiftDataQty;
	
	@Column(nullable = true, length = 2)
	private String autoChrgOpCd;
	
	@Column(nullable = true, length = 15)
	private long autoGiftSerNum;
	
	@Column(nullable = true, length = 2)
	private long giftReqCnt;
	
	@Column(nullable = true, length = 2)
	private long giftOpRsltCnt;
	
	@Column(nullable = true, length = 14)
	private String giftReqFstOpDtm;	

}