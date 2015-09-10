package com.bigledger.emp_to_db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InvStockDeltaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String guid;
	private Long pkid; // Primary Key
	private String namespace;
	private String txnType;
	private String txnCode;
	private String serial;
	private Integer personInCharge;
	private Integer processNode;
	private Integer stockId;
	private Integer refStockId;
	private Integer itemId;
	private BigDecimal quantity = new BigDecimal(0);
	private String currency;
	private BigDecimal unitPrice = new BigDecimal(0);
	private String currency2;
	private BigDecimal unitPrice2 = new BigDecimal(0);
	private Timestamp txnTime;
	private Timestamp schTime;
	private String remarks;
	private Integer intReserved1;
	private String strReserved1; // permit
	private String strReserved2;
	private String strReserved3;
	private String strReserved4;
	private String entityTable;
	private Integer entityId;
	private String docTable;
	private Long docKey;
	private boolean fifoBin;
	private BigDecimal fifoBalQty;
	private boolean fifoCalculated;
	private BigDecimal fifoAmt;
	private BigDecimal balQty;
	private BigDecimal unitCostMA;
	private BigDecimal unitCostWA;
	private BigDecimal unitCostLast;
	private BigDecimal unitCostReplacement;
	private String state;
	private String status;
	private Integer userIdEdit;
	private Timestamp timeEdit;
	private BigDecimal deltaPriceRetailAmt;
	private BigDecimal deltaPriceRetailPct;
	private BigDecimal deltaPriceDealerAmt;
	private BigDecimal deltaPriceDealerPct;
	private BigDecimal deltaPriceOutletAmt;
	private BigDecimal deltaPriceOutletPct;
	private Integer shelfLife;
	private BigDecimal commissionPctSales1;
	private BigDecimal commissionPctSales2;
	private BigDecimal commissionPctSales3;
	private BigDecimal commissionPctSales4;
	private BigDecimal commissionPctPartner;
	private BigDecimal commissionPctGp;
	private Integer pcCenter;
	private Integer branch;
	private Integer location;
	private String taxType;
	private BigDecimal taxAmt;
	private BigDecimal unitDiscount;
	private BigDecimal unitRebate;
	private BigDecimal unitPointsRedeem;
	private BigDecimal unitPointsReward;
	private String codeProject;
	private String codeDepartment;
	private String codeDealer;
	private String codeSalesman;
	private String displayLogic;
	private String displayCode;
	private String displayName;
	private String displayDescription;
	private BigDecimal unitListPrice = new BigDecimal(0);
	private BigDecimal unitSalePrice = new BigDecimal(0);
	private BigDecimal unitDisc1Price = new BigDecimal(0);
	private BigDecimal unitDisc2Price = new BigDecimal(0);
	private BigDecimal unitDisc3Price = new BigDecimal(0);
	private String loyaltyLogic = "";
	private BigDecimal loyaltyPointsAwarded = new BigDecimal(0);
	private BigDecimal loyaltyPointsRedeemed = new BigDecimal(0);
	private BigDecimal unitCostCsg = new BigDecimal(0);
	private String batchNumber;
	private Timestamp expiryDate;
	private String uom;
	private BigDecimal uomRatio = new BigDecimal(0);
	private String hierarchyOption;
	private Integer hierarchyUserid01;
	private Integer hierarchyUserid02;
	private Integer hierarchyUserid03;
	private Integer hierarchyUserid04;
	private Integer hierarchyUserid05;
	private Integer hierarchyUserid06;
	private Integer hierarchyUserid07;
	private Integer hierarchyUserid08;
	private Integer hierarchyUserid09;
	private Integer hierarchyUserid10;
	private String serialNumberList;
	
	public String getGuid() {
		return guid;
	}
	public Long getPkid() {
		return pkid;
	}
	public String getNamespace() {
		return namespace;
	}
	public String getTxnType() {
		return txnType;
	}
	public String getTxnCode() {
		return txnCode;
	}
	public String getSerial() {
		return serial;
	}
	public Integer getPersonInCharge() {
		return personInCharge;
	}
	public Integer getProcessNode() {
		return processNode;
	}
	public Integer getStockId() {
		return stockId;
	}
	public Integer getRefStockId() {
		return refStockId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public String getCurrency() {
		return currency;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public String getCurrency2() {
		return currency2;
	}
	public BigDecimal getUnitPrice2() {
		return unitPrice2;
	}
	public Timestamp getTxnTime() {
		return txnTime;
	}
	public Timestamp getSchTime() {
		return schTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public Integer getIntReserved1() {
		return intReserved1;
	}
	public String getStrReserved1() {
		return strReserved1;
	}
	public String getStrReserved2() {
		return strReserved2;
	}
	public String getStrReserved3() {
		return strReserved3;
	}
	public String getStrReserved4() {
		return strReserved4;
	}
	public String getEntityTable() {
		return entityTable;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public String getDocTable() {
		return docTable;
	}
	public Long getDocKey() {
		return docKey;
	}
	public boolean isFifoBin() {
		return fifoBin;
	}
	public BigDecimal getFifoBalQty() {
		return fifoBalQty;
	}
	public boolean isFifoCalculated() {
		return fifoCalculated;
	}
	public BigDecimal getFifoAmt() {
		return fifoAmt;
	}
	public BigDecimal getBalQty() {
		return balQty;
	}
	public BigDecimal getUnitCostMA() {
		return unitCostMA;
	}
	public BigDecimal getUnitCostWA() {
		return unitCostWA;
	}
	public BigDecimal getUnitCostLast() {
		return unitCostLast;
	}
	public BigDecimal getUnitCostReplacement() {
		return unitCostReplacement;
	}
	public String getState() {
		return state;
	}
	public String getStatus() {
		return status;
	}
	public Integer getUserIdEdit() {
		return userIdEdit;
	}
	public Timestamp getTimeEdit() {
		return timeEdit;
	}
	public BigDecimal getDeltaPriceRetailAmt() {
		return deltaPriceRetailAmt;
	}
	public BigDecimal getDeltaPriceRetailPct() {
		return deltaPriceRetailPct;
	}
	public BigDecimal getDeltaPriceDealerAmt() {
		return deltaPriceDealerAmt;
	}
	public BigDecimal getDeltaPriceDealerPct() {
		return deltaPriceDealerPct;
	}
	public BigDecimal getDeltaPriceOutletAmt() {
		return deltaPriceOutletAmt;
	}
	public BigDecimal getDeltaPriceOutletPct() {
		return deltaPriceOutletPct;
	}
	public Integer getShelfLife() {
		return shelfLife;
	}
	public BigDecimal getCommissionPctSales1() {
		return commissionPctSales1;
	}
	public BigDecimal getCommissionPctSales2() {
		return commissionPctSales2;
	}
	public BigDecimal getCommissionPctSales3() {
		return commissionPctSales3;
	}
	public BigDecimal getCommissionPctSales4() {
		return commissionPctSales4;
	}
	public BigDecimal getCommissionPctPartner() {
		return commissionPctPartner;
	}
	public BigDecimal getCommissionPctGp() {
		return commissionPctGp;
	}
	public Integer getPcCenter() {
		return pcCenter;
	}
	public Integer getBranch() {
		return branch;
	}
	public Integer getLocation() {
		return location;
	}
	public String getTaxType() {
		return taxType;
	}
	public BigDecimal getTaxAmt() {
		return taxAmt;
	}
	public BigDecimal getUnitDiscount() {
		return unitDiscount;
	}
	public BigDecimal getUnitRebate() {
		return unitRebate;
	}
	public BigDecimal getUnitPointsRedeem() {
		return unitPointsRedeem;
	}
	public BigDecimal getUnitPointsReward() {
		return unitPointsReward;
	}
	public String getCodeProject() {
		return codeProject;
	}
	public String getCodeDepartment() {
		return codeDepartment;
	}
	public String getCodeDealer() {
		return codeDealer;
	}
	public String getCodeSalesman() {
		return codeSalesman;
	}
	public String getDisplayLogic() {
		return displayLogic;
	}
	public String getDisplayCode() {
		return displayCode;
	}
	public String getDisplayName() {
		return displayName;
	}
	public String getDisplayDescription() {
		return displayDescription;
	}
	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}
	public BigDecimal getUnitSalePrice() {
		return unitSalePrice;
	}
	public BigDecimal getUnitDisc1Price() {
		return unitDisc1Price;
	}
	public BigDecimal getUnitDisc2Price() {
		return unitDisc2Price;
	}
	public BigDecimal getUnitDisc3Price() {
		return unitDisc3Price;
	}
	public String getLoyaltyLogic() {
		return loyaltyLogic;
	}
	public BigDecimal getLoyaltyPointsAwarded() {
		return loyaltyPointsAwarded;
	}
	public BigDecimal getLoyaltyPointsRedeemed() {
		return loyaltyPointsRedeemed;
	}
	public BigDecimal getUnitCostCsg() {
		return unitCostCsg;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public String getUom() {
		return uom;
	}
	public BigDecimal getUomRatio() {
		return uomRatio;
	}
	public String getHierarchyOption() {
		return hierarchyOption;
	}
	public Integer getHierarchyUserid01() {
		return hierarchyUserid01;
	}
	public Integer getHierarchyUserid02() {
		return hierarchyUserid02;
	}
	public Integer getHierarchyUserid03() {
		return hierarchyUserid03;
	}
	public Integer getHierarchyUserid04() {
		return hierarchyUserid04;
	}
	public Integer getHierarchyUserid05() {
		return hierarchyUserid05;
	}
	public Integer getHierarchyUserid06() {
		return hierarchyUserid06;
	}
	public Integer getHierarchyUserid07() {
		return hierarchyUserid07;
	}
	public Integer getHierarchyUserid08() {
		return hierarchyUserid08;
	}
	public Integer getHierarchyUserid09() {
		return hierarchyUserid09;
	}
	public Integer getHierarchyUserid10() {
		return hierarchyUserid10;
	}
	public String getSerialNumberList() {
		return serialNumberList;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public void setPersonInCharge(Integer personInCharge) {
		this.personInCharge = personInCharge;
	}
	public void setProcessNode(Integer processNode) {
		this.processNode = processNode;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public void setRefStockId(Integer refStockId) {
		this.refStockId = refStockId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	public void setUnitPrice2(BigDecimal unitPrice2) {
		this.unitPrice2 = unitPrice2;
	}
	public void setTxnTime(Timestamp txnTime) {
		this.txnTime = txnTime;
	}
	public void setSchTime(Timestamp schTime) {
		this.schTime = schTime;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setIntReserved1(Integer intReserved1) {
		this.intReserved1 = intReserved1;
	}
	public void setStrReserved1(String strReserved1) {
		this.strReserved1 = strReserved1;
	}
	public void setStrReserved2(String strReserved2) {
		this.strReserved2 = strReserved2;
	}
	public void setStrReserved3(String strReserved3) {
		this.strReserved3 = strReserved3;
	}
	public void setStrReserved4(String strReserved4) {
		this.strReserved4 = strReserved4;
	}
	public void setEntityTable(String entityTable) {
		this.entityTable = entityTable;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public void setDocTable(String docTable) {
		this.docTable = docTable;
	}
	public void setDocKey(Long docKey) {
		this.docKey = docKey;
	}
	public void setFifoBin(boolean fifoBin) {
		this.fifoBin = fifoBin;
	}
	public void setFifoBalQty(BigDecimal fifoBalQty) {
		this.fifoBalQty = fifoBalQty;
	}
	public void setFifoCalculated(boolean fifoCalculated) {
		this.fifoCalculated = fifoCalculated;
	}
	public void setFifoAmt(BigDecimal fifoAmt) {
		this.fifoAmt = fifoAmt;
	}
	public void setBalQty(BigDecimal balQty) {
		this.balQty = balQty;
	}
	public void setUnitCostMA(BigDecimal unitCostMA) {
		this.unitCostMA = unitCostMA;
	}
	public void setUnitCostWA(BigDecimal unitCostWA) {
		this.unitCostWA = unitCostWA;
	}
	public void setUnitCostLast(BigDecimal unitCostLast) {
		this.unitCostLast = unitCostLast;
	}
	public void setUnitCostReplacement(BigDecimal unitCostReplacement) {
		this.unitCostReplacement = unitCostReplacement;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUserIdEdit(Integer userIdEdit) {
		this.userIdEdit = userIdEdit;
	}
	public void setTimeEdit(Timestamp timeEdit) {
		this.timeEdit = timeEdit;
	}
	public void setDeltaPriceRetailAmt(BigDecimal deltaPriceRetailAmt) {
		this.deltaPriceRetailAmt = deltaPriceRetailAmt;
	}
	public void setDeltaPriceRetailPct(BigDecimal deltaPriceRetailPct) {
		this.deltaPriceRetailPct = deltaPriceRetailPct;
	}
	public void setDeltaPriceDealerAmt(BigDecimal deltaPriceDealerAmt) {
		this.deltaPriceDealerAmt = deltaPriceDealerAmt;
	}
	public void setDeltaPriceDealerPct(BigDecimal deltaPriceDealerPct) {
		this.deltaPriceDealerPct = deltaPriceDealerPct;
	}
	public void setDeltaPriceOutletAmt(BigDecimal deltaPriceOutletAmt) {
		this.deltaPriceOutletAmt = deltaPriceOutletAmt;
	}
	public void setDeltaPriceOutletPct(BigDecimal deltaPriceOutletPct) {
		this.deltaPriceOutletPct = deltaPriceOutletPct;
	}
	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}
	public void setCommissionPctSales1(BigDecimal commissionPctSales1) {
		this.commissionPctSales1 = commissionPctSales1;
	}
	public void setCommissionPctSales2(BigDecimal commissionPctSales2) {
		this.commissionPctSales2 = commissionPctSales2;
	}
	public void setCommissionPctSales3(BigDecimal commissionPctSales3) {
		this.commissionPctSales3 = commissionPctSales3;
	}
	public void setCommissionPctSales4(BigDecimal commissionPctSales4) {
		this.commissionPctSales4 = commissionPctSales4;
	}
	public void setCommissionPctPartner(BigDecimal commissionPctPartner) {
		this.commissionPctPartner = commissionPctPartner;
	}
	public void setCommissionPctGp(BigDecimal commissionPctGp) {
		this.commissionPctGp = commissionPctGp;
	}
	public void setPcCenter(Integer pcCenter) {
		this.pcCenter = pcCenter;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}
	public void setUnitDiscount(BigDecimal unitDiscount) {
		this.unitDiscount = unitDiscount;
	}
	public void setUnitRebate(BigDecimal unitRebate) {
		this.unitRebate = unitRebate;
	}
	public void setUnitPointsRedeem(BigDecimal unitPointsRedeem) {
		this.unitPointsRedeem = unitPointsRedeem;
	}
	public void setUnitPointsReward(BigDecimal unitPointsReward) {
		this.unitPointsReward = unitPointsReward;
	}
	public void setCodeProject(String codeProject) {
		this.codeProject = codeProject;
	}
	public void setCodeDepartment(String codeDepartment) {
		this.codeDepartment = codeDepartment;
	}
	public void setCodeDealer(String codeDealer) {
		this.codeDealer = codeDealer;
	}
	public void setCodeSalesman(String codeSalesman) {
		this.codeSalesman = codeSalesman;
	}
	public void setDisplayLogic(String displayLogic) {
		this.displayLogic = displayLogic;
	}
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}
	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}
	public void setUnitSalePrice(BigDecimal unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}
	public void setUnitDisc1Price(BigDecimal unitDisc1Price) {
		this.unitDisc1Price = unitDisc1Price;
	}
	public void setUnitDisc2Price(BigDecimal unitDisc2Price) {
		this.unitDisc2Price = unitDisc2Price;
	}
	public void setUnitDisc3Price(BigDecimal unitDisc3Price) {
		this.unitDisc3Price = unitDisc3Price;
	}
	public void setLoyaltyLogic(String loyaltyLogic) {
		this.loyaltyLogic = loyaltyLogic;
	}
	public void setLoyaltyPointsAwarded(BigDecimal loyaltyPointsAwarded) {
		this.loyaltyPointsAwarded = loyaltyPointsAwarded;
	}
	public void setLoyaltyPointsRedeemed(BigDecimal loyaltyPointsRedeemed) {
		this.loyaltyPointsRedeemed = loyaltyPointsRedeemed;
	}
	public void setUnitCostCsg(BigDecimal unitCostCsg) {
		this.unitCostCsg = unitCostCsg;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public void setUomRatio(BigDecimal uomRatio) {
		this.uomRatio = uomRatio;
	}
	public void setHierarchyOption(String hierarchyOption) {
		this.hierarchyOption = hierarchyOption;
	}
	public void setHierarchyUserid01(Integer hierarchyUserid01) {
		this.hierarchyUserid01 = hierarchyUserid01;
	}
	public void setHierarchyUserid02(Integer hierarchyUserid02) {
		this.hierarchyUserid02 = hierarchyUserid02;
	}
	public void setHierarchyUserid03(Integer hierarchyUserid03) {
		this.hierarchyUserid03 = hierarchyUserid03;
	}
	public void setHierarchyUserid04(Integer hierarchyUserid04) {
		this.hierarchyUserid04 = hierarchyUserid04;
	}
	public void setHierarchyUserid05(Integer hierarchyUserid05) {
		this.hierarchyUserid05 = hierarchyUserid05;
	}
	public void setHierarchyUserid06(Integer hierarchyUserid06) {
		this.hierarchyUserid06 = hierarchyUserid06;
	}
	public void setHierarchyUserid07(Integer hierarchyUserid07) {
		this.hierarchyUserid07 = hierarchyUserid07;
	}
	public void setHierarchyUserid08(Integer hierarchyUserid08) {
		this.hierarchyUserid08 = hierarchyUserid08;
	}
	public void setHierarchyUserid09(Integer hierarchyUserid09) {
		this.hierarchyUserid09 = hierarchyUserid09;
	}
	public void setHierarchyUserid10(Integer hierarchyUserid10) {
		this.hierarchyUserid10 = hierarchyUserid10;
	}
	public void setSerialNumberList(String serialNumberList) {
		this.serialNumberList = serialNumberList;
	}
	
	public InvStockDeltaEntity() {
		
		this.fifoBin = false;
		this.fifoCalculated = false;
	}
	
	
}
