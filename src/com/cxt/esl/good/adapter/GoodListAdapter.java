package com.cxt.esl.good.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.cxt.esl.R;
import com.cxt.esl.good.domain.Good;
import com.cxt.esl.good.listener.GoodGroupLongClickListener;

public class GoodListAdapter extends SimpleExpandableListAdapter{

	private Context context;
	private int groupLayoutId;
	private int childLayoutId;
	
	
	public GoodListAdapter(Context context,
			List<? extends Map<String, Good>> groupData, int expandedGroupLayout,
			int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
			List<? extends List<? extends Map<String, Good>>> childData,
			int childLayout, int lastChildLayout, String[] childFrom,
			int[] childTo) {
		super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom,
				groupTo, childData, childLayout, lastChildLayout, childFrom, childTo);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public GoodListAdapter(Context context,
			List<? extends Map<String, Good>> groupData, int expandedGroupLayout,
			int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
			List<? extends List<? extends Map<String, Good>>> childData,
			int childLayout, String[] childFrom, int[] childTo) {
		super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom,
				groupTo, childData, childLayout, childFrom, childTo);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public GoodListAdapter(Context context,
			List<? extends Map<String, Good>> groupData, int groupLayout,
			String[] groupFrom, int[] groupTo,
			List<? extends List<? extends Map<String, Good>>> childData,
			int childLayout, String[] childFrom, int[] childTo) {
		super(context, groupData, groupLayout, groupFrom, groupTo, childData,
				childLayout, childFrom, childTo);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.groupLayoutId = groupLayout;
		this.childLayoutId = childLayout;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		Good g = ((Map<String, Good>) getChild(groupPosition, childPosition)).get("child"); // ��ȡ��ǰ���Patternʵ��
		View view = LayoutInflater.from(this.context).inflate(this.childLayoutId, null);
		TextView textView = (TextView) view.findViewById(R.id.goodChildTo);
		switch (childPosition) {
		case 0:
			textView.setText("��Ʒ��:" + g.getEslName());
			break;
		case 1:
			textView.setText("��ʾ����:" + g.getPosName());
			break;
		case 2:
			textView.setText("�ּ�:" + g.getPresPrice());
			break;
		default:
			break;
		}
		view.setOnLongClickListener(new GoodGroupLongClickListener(groupPosition, this, this.context));
		return view;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		Good g = ((Map<String, Good>)getGroup(groupPosition)).get("group"); // ��ȡ��ǰ���Modelʵ��
		View view = LayoutInflater.from(this.context).inflate(this.groupLayoutId, null);
		TextView textView = (TextView) view.findViewById(R.id.goodGroupTo);
		textView.setText("��Ʒ����:" + g.getBarCode());
		return view;
	}

	
	
	

}
