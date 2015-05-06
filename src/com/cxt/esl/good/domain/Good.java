package com.cxt.esl.good.domain;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;


public class Good implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3200816997494620276L;
	
	private  int goods_id;// int(11) NOT NULL AUTO_INCREMENT COMMENT '��Ʒid',
	private  String bar_code;// varchar(100) NOT NULL COMMENT '��Ʒ�����룩��ţ�ͬposϵͳ��',
	private  String pos_name;// varchar(100) DEFAULT NULL COMMENT '��Ʒ����ͬposϵͳ��',
	private  String esl_name;// varchar(100) DEFAULT NULL COMMENT '��ʾ����ESLϵͳ��',
	private  String goods_series;// varchar(50) DEFAULT NULL COMMENT '��Ʒϵ�У�ͬposϵͳ��',
	private  String goods_desc;// varchar(200) DEFAULT NULL COMMENT '��Ʒ������ͬposϵͳ��',
	private  float orig_price;// decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'ԭ�ۣ�ͬposϵͳ��',
	private  float pres_price;// decimal(15,2) DEFAULT '0.00' COMMENT '�ּۣ�ͬposϵͳ��',
	private  int rate;// tinyint(4) DEFAULT NULL COMMENT '�ۿ��ʣ�ͬposϵͳ��',
	private  String prod_area;// varchar(100) DEFAULT NULL COMMENT '���أ�ͬposϵͳ��',
	private  String model;// varchar(50) DEFAULT NULL COMMENT '����ͺ�',
	private  stock bigint(20) DEFAULT NULL COMMENT '���:��POSͬ���������',
	private salable int(11) DEFAULT NULL COMMENT '�ϼ�����',
	private  saled bigint(20) DEFAULT NULL COMMENT '��������',
	private  remarks varchar(200) DEFAULT NULL COMMENT '��ע',
	private  upd_time datetime DEFAULT NULL,
	private  kind_id int(11) DEFAULT NULL COMMENT '��������',
	private  guid varchar(40) DEFAULT NULL,
	private  promote1 varchar(50) DEFAULT NULL COMMENT '������Ϣ1',
	private  promote2 varchar(50) DEFAULT NULL COMMENT '������Ϣ2',
	private  status tinyint(4) NOT NULL DEFAULT '0' COMMENT '"0-������Ĭ�ϣ���Ʒ��Ϣ��ESL��ȷ��Ӧ��\n1-��Ʒ��Ϣ�޸ģ�������ʾ�У�����Ʒ��ص�ESL������ʾδ��ɣ��ݲ������ۣ�"',
	private  user_modi_time datetime DEFAULT NULL COMMENT 'MIS���û����һ���޸ĵ�ʱ��',
	private  pos_modi_time datetime DEFAULT NULL COMMENT '������棬�ϼ�����������������POSд��',
	private  memb_price decimal(15,2) DEFAULT NULL COMMENT '��Ա��',
	private  memb_rate tinyint(4) DEFAULT NULL COMMENT '��Ա�ۿ�',
	private  tax decimal(10,2) DEFAULT NULL COMMENT '˰��',
	private  tax_rate tinyint(4) DEFAULT NULL COMMENT '˰��',
	private  order_num int(16) DEFAULT '0' COMMENT '���',
	private  product_date datetime DEFAULT NULL COMMENT '��������',
	private  good_bar_code char(12) DEFAULT NULL COMMENT '����ͳһ����',
	private  price_unit varchar(20) DEFAULT NULL COMMENT '�Ƽ۵�λ',
	private  level varchar(20) DEFAULT NULL COMMENT '�ȼ�',
	private  pm varchar(100) DEFAULT NULL COMMENT '���Ա',
	private  promote_start_time datetime DEFAULT NULL COMMENT '������ʼ����',
	private  promote_end_time datetime DEFAULT NULL COMMENT '������������',
	private  price_down_flag int(2) DEFAULT '0' COMMENT '�Ż�ֱ�� �������� 1���� 0������',
	private  memb_owner int(2) DEFAULT '0' COMMENT '��Աר�� �������� 1���� 0����',
	
	
}