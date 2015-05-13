package com.cxt.esl.config.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cxt.esl.R;
import com.cxt.esl.config.domain.Config;

public class ConfigAdapter extends ArrayAdapter<Config> {

	private int resourceId;
	private static final String STR_KEYE = "��:";
	private static final String STR_VALUE = "ֵ:";
	private static final String STR_TYPE = "���:";
	private static final String STR_NOTE = "��ע:";

	public ConfigAdapter(Context context, int textViewResourceId,
			List<Config> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Config c = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.ckey = (TextView) view.findViewById(R.id.ckey);
			viewHolder.cvalue = (TextView) view.findViewById(R.id.cvalue);
			viewHolder.ctype = (TextView) view.findViewById(R.id.ctype);
			viewHolder.note = (TextView) view.findViewById(R.id.note);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.ckey.setText(STR_KEYE + c.getCkey());
		viewHolder.cvalue.setText(STR_VALUE + c.getCvalue());
		viewHolder.ctype.setText(STR_TYPE + (c.getCtype()==0?"ϵͳ����":"posͬ��"));
		viewHolder.note.setText(STR_NOTE + c.getNote());
		return view;
	}

	class ViewHolder {

		TextView ckey;
		TextView cvalue;
		TextView ctype;
		TextView note;

	}

}
