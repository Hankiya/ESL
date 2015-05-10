package com.cxt.esl.good.domain;

import java.io.Serializable;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "esls_good")
public class Good implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3200816997494620276L;
	
	@DatabaseField(columnName = "goods_id", generatedId = true, canBeNull = false)
	private  int goodsId;// int(11) NOT NULL AUTO_INCREMENT COMMENT '��Ʒid',
	@DatabaseField(columnName = "bar_code", canBeNull = false,defaultValue="")
	private  String barCode;// varchar(100) NOT NULL COMMENT '��Ʒ�����룩��ţ�ͬposϵͳ��',
	@DatabaseField(columnName = "pos_name")
	private  String posName;// varchar(100) DEFAULT NULL COMMENT '��Ʒ����ͬposϵͳ��',
	@DatabaseField(columnName = "esl_name")
	private  String eslName;// varchar(100) DEFAULT NULL COMMENT '��ʾ����ESLϵͳ��',
	@DatabaseField(columnName = "img_url",defaultValue="")
	private String imgUrl;
	@DatabaseField(columnName = "img_id")
	private int imgId;
	@DatabaseField(columnName = "goods_series")
	private  String goodsSeries;// varchar(50) DEFAULT NULL COMMENT '��Ʒϵ�У�ͬposϵͳ��',
	@DatabaseField(columnName = "goods_desc")
	private  String goodsDesc;// varchar(200) DEFAULT NULL COMMENT '��Ʒ������ͬposϵͳ��',
	@DatabaseField(columnName = "orig_price",defaultValue="0.00")
	private  float origPrice;// decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'ԭ�ۣ�ͬposϵͳ��',
	@DatabaseField(columnName = "pres_price",defaultValue="0.00")
	private  float presPrice;// decimal(15,2) DEFAULT '0.00' COMMENT '�ּۣ�ͬposϵͳ��',
	@DatabaseField(columnName = "rate")
	private  int rate;// tinyint(4) DEFAULT NULL COMMENT '�ۿ��ʣ�ͬposϵͳ��',
	@DatabaseField(columnName = "prod_area")
	private  String prodArea;// varchar(100) DEFAULT NULL COMMENT '���أ�ͬposϵͳ��',
	@DatabaseField(columnName = "model")
	private  String model;// varchar(50) DEFAULT NULL COMMENT '����ͺ�',
	@DatabaseField(columnName = "stock")
	private  int stock;// bigint(20) DEFAULT NULL COMMENT '���:��POSͬ���������',
	@DatabaseField(columnName = "salable")
	private int salable;// int(11) DEFAULT NULL COMMENT '�ϼ�����',
	@DatabaseField(columnName = "saled")
	private  int saled;// bigint(20) DEFAULT NULL COMMENT '��������',
	@DatabaseField(columnName = "remarks")
	private  String remarks;// varchar(200) DEFAULT NULL COMMENT '��ע',
	@DatabaseField(columnName = "upd_time")
	private  Date updTime;// datetime DEFAULT NULL,
	@DatabaseField(columnName = "kind_id")
	private  int kindId;// int(11) DEFAULT NULL COMMENT '��������',
	@DatabaseField(columnName = "guid")
	private  String guid;// varchar(40) DEFAULT NULL,
	@DatabaseField(columnName = "promote1")
	private  String promote1;// varchar(50) DEFAULT NULL COMMENT '������Ϣ1',
	@DatabaseField(columnName = "promote2")
	private  String promote2;// varchar(50) DEFAULT NULL COMMENT '������Ϣ2',
	@DatabaseField(columnName = "status",defaultValue="0")
	private  int status;// tinyint(4) NOT NULL DEFAULT '0' COMMENT '"0-������Ĭ�ϣ���Ʒ��Ϣ��ESL��ȷ��Ӧ��\n1-��Ʒ��Ϣ�޸ģ�������ʾ�У�����Ʒ��ص�ESL������ʾδ��ɣ��ݲ������ۣ�"',
	@DatabaseField(columnName = "user_modi_time")
	private   Date userModiTime;// datetime DEFAULT NULL COMMENT 'MIS���û����һ���޸ĵ�ʱ��',
	@DatabaseField(columnName = "pos_modi_time")
	private  Date posModiTime;// datetime DEFAULT NULL COMMENT '������棬�ϼ�����������������POSд��',
	@DatabaseField(columnName = "memb_price")
	private  float membPrice;// decimal(15,2) DEFAULT NULL COMMENT '��Ա��',
	@DatabaseField(columnName = "memb_rate")
	private  int membRate;// tinyint(4) DEFAULT NULL COMMENT '��Ա�ۿ�',
	@DatabaseField(columnName = "tax")
	private  float tax;// decimal(10,2) DEFAULT NULL COMMENT '˰��',
	@DatabaseField(columnName = "tax_rate")
	private  int taxRate;// tinyint(4) DEFAULT NULL COMMENT '˰��',
	@DatabaseField(columnName = "order_num",defaultValue="0")
	private  int orderNum;// int(16) DEFAULT '0' COMMENT '���',
	@DatabaseField(columnName = "product_date")
	private  Date productDate;// datetime DEFAULT NULL COMMENT '��������',
	@DatabaseField(columnName = "good_bar_code")
	private  String goodBarCode;// char(12) DEFAULT NULL COMMENT '����ͳһ����',
	@DatabaseField(columnName = "price_unit")
	private  String priceUnit;// varchar(20) DEFAULT NULL COMMENT '�Ƽ۵�λ',
	@DatabaseField(columnName = "level")
	private  String level;// varchar(20) DEFAULT NULL COMMENT '�ȼ�',
	@DatabaseField(columnName = "pm")
	private  String pm;// varchar(100) DEFAULT NULL COMMENT '���Ա',
	@DatabaseField(columnName = "promote_start_time")
	private  Date promoteStartTime;// datetime DEFAULT NULL COMMENT '������ʼ����',
	@DatabaseField(columnName = "promote_end_time")
	private  Date promoteEndTime;// datetime DEFAULT NULL COMMENT '������������',
	@DatabaseField(columnName = "price_down_flag",defaultValue="0")
	private  int priceDownFlag;// int(2) DEFAULT '0' COMMENT '�Ż�ֱ�� �������� 1���� 0������',
	@DatabaseField(columnName = "memb_owner",defaultValue="0")
	private  int membOwner;//int(2) DEFAULT '0' COMMENT '��Աר�� �������� 1���� 0����',
	
	public Good() {
		super();
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getEslName() {
		return eslName;
	}

	public void setEslName(String eslName) {
		this.eslName = eslName;
	}

	public String getGoodsSeries() {
		return goodsSeries;
	}

	public void setGoodsSeries(String goodsSeries) {
		this.goodsSeries = goodsSeries;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public float getOrigPrice() {
		return origPrice;
	}

	public void setOrigPrice(float origPrice) {
		this.origPrice = origPrice;
	}

	public float getPresPrice() {
		return presPrice;
	}

	public void setPresPrice(float presPrice) {
		this.presPrice = presPrice;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getProdArea() {
		return prodArea;
	}

	public void setProdArea(String prodArea) {
		this.prodArea = prodArea;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSalable() {
		return salable;
	}

	public void setSalable(int salable) {
		this.salable = salable;
	}

	public int getSaled() {
		return saled;
	}

	public void setSaled(int saled) {
		this.saled = saled;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	public int getKindId() {
		return kindId;
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPromote1() {
		return promote1;
	}

	public void setPromote1(String promote1) {
		this.promote1 = promote1;
	}

	public String getPromote2() {
		return promote2;
	}

	public void setPromote2(String promote2) {
		this.promote2 = promote2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUserModiTime() {
		return userModiTime;
	}

	public void setUserModiTime(Date userModiTime) {
		this.userModiTime = userModiTime;
	}

	public Date getPosModiTime() {
		return posModiTime;
	}

	public void setPosModiTime(Date posModiTime) {
		this.posModiTime = posModiTime;
	}

	public float getMembPrice() {
		return membPrice;
	}

	public void setMembPrice(float membPrice) {
		this.membPrice = membPrice;
	}

	public int getMembRate() {
		return membRate;
	}

	public void setMembRate(int membRate) {
		this.membRate = membRate;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getGoodBarCode() {
		return goodBarCode;
	}

	public void setGoodBarCode(String goodBarCode) {
		this.goodBarCode = goodBarCode;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public Date getPromoteStartTime() {
		return promoteStartTime;
	}

	public void setPromoteStartTime(Date promoteStartTime) {
		this.promoteStartTime = promoteStartTime;
	}

	public Date getPromoteEndTime() {
		return promoteEndTime;
	}

	public void setPromoteEndTime(Date promoteEndTime) {
		this.promoteEndTime = promoteEndTime;
	}

	public int getPriceDownFlag() {
		return priceDownFlag;
	}

	public void setPriceDownFlag(int priceDownFlag) {
		this.priceDownFlag = priceDownFlag;
	}

	public int getMembOwner() {
		return membOwner;
	}

	public void setMembOwner(int membOwner) {
		this.membOwner = membOwner;
	}


	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}



}