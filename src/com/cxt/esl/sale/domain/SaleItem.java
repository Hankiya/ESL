package com.cxt.esl.sale.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.cxt.esl.good.domain.Good;

public class SaleItem implements Parcelable{
	private Good good;
	private int count;
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public SaleItem(Good good, int count) {
		super();
		this.good = good;
		this.count = count;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeSerializable(good);
		dest.writeInt(count);
		
	}
	
    //3���Զ��������б��뺬��һ������ΪCREATOR�ľ�̬��Ա���ó�Ա����Ҫ��ʵ��Parcelable.Creator�ӿڼ��䷽��
    public static final Parcelable.Creator<SaleItem> CREATOR = new Parcelable.Creator<SaleItem>() { 
        @Override 
        public SaleItem createFromParcel(Parcel source) { 
            //��Parcel�ж�ȡ����
            //�˴�read˳������write˳��
            return new SaleItem((Good) source.readSerializable(),source.readInt()); 
        } 
        @Override 
        public SaleItem[] newArray(int size) { 
                         
            return new SaleItem[size]; 
        } 
                     
    }; 
	
}
