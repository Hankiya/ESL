package com.cxt.esl.good.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cxt.esl.R;
import com.cxt.esl.good.domain.GoodUpdateHistory;

public class GoodUpdateHistoryAdapter extends ArrayAdapter<GoodUpdateHistory> {

	private int resourceId;
	private static final String STR_GOOD_ID = "��Ʒ����:";
	private static final String STR_POS_NAME = "��Ʒ����:";
	private static final String STR_ESL_NAME = "��ʾ����:";
	private static final String STR_ORGI__PRICE = "ԭ��:";
	private static final String STR_PRES__PRICE = "�ּ�:";
	private static final String STR_UPD__TIME = "�޸�:";
	private static final String STR_STATUS = "ͼƬ����״̬:";
	private static final String STR_REASON = "�޸�ԭ��:";
	
	public GoodUpdateHistoryAdapter(Context context, int textViewResourceId,
			List<GoodUpdateHistory> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GoodUpdateHistory goodUpdateHistory = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.goodsId = (TextView) view.findViewById(R.id.goods_id);
			viewHolder.posName = (TextView) view.findViewById(R.id.pos_name);
			viewHolder.eslName = (TextView) view.findViewById(R.id.esl_name);
			viewHolder.origPrice = (TextView) view.findViewById(R.id.orig_price);
			viewHolder.presPrice = (TextView) view.findViewById(R.id.pres_price);
			viewHolder.updTime = (TextView) view.findViewById(R.id.upd_time);
			viewHolder.status = (TextView) view.findViewById(R.id.status);
			viewHolder.reason = (TextView) view.findViewById(R.id.reason);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.posName.setText(STR_POS_NAME+goodUpdateHistory.getPosName());
		viewHolder.goodsId.setText(STR_GOOD_ID+goodUpdateHistory.getGoodsId());
		viewHolder.origPrice.setText(STR_ORGI__PRICE+goodUpdateHistory.getOrigPrice());
		viewHolder.presPrice.setText(STR_PRES__PRICE+goodUpdateHistory.getPresPrice());
		viewHolder.eslName.setText(STR_ESL_NAME+goodUpdateHistory.getEslName());
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		viewHolder.updTime.setText(STR_UPD__TIME+sdf.format(goodUpdateHistory.getUpdTime()));
		viewHolder.reason.setText(STR_REASON+goodUpdateHistory.getReason());
		int sta = goodUpdateHistory.getStatus();
		if(sta == 0)
			viewHolder.status.setText(STR_STATUS+"δ����");
		else if(sta == 1)
			viewHolder.status.setText(STR_STATUS+"������");
		else if(sta == 2)
			viewHolder.status.setText(STR_STATUS+"������");
		return view;
	}
	
	class ViewHolder {
		
		TextView goodsId;
		TextView posName;
		TextView eslName;
		TextView origPrice;
		TextView presPrice;
		TextView updTime;
		TextView status;
		TextView reason;
		
	}
	
	

}
