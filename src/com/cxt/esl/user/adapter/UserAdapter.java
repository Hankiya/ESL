package com.cxt.esl.user.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cxt.esl.R;
import com.cxt.esl.user.domain.User;

public class UserAdapter extends ArrayAdapter<User> {

	private int resourceId;
	private static final String STR_USER_CODE = "�û����:";
	private static final String STR_USER_NAME = "�û�����:";
	private static final String STR_PASSWORD = "�û�����:*****************";
	private static final String STR_STATUS = "״̬:";
	private static final String STR_ROLE_NAME = "��ɫ:";
	private static final String STR_CREATE_DATE = "����ʱ��:";

	public UserAdapter(Context context, int textViewResourceId,
			List<User> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		User u = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.userCode = (TextView) view.findViewById(R.id.user_code);
			viewHolder.userName = (TextView) view.findViewById(R.id.user_name);
			viewHolder.password = (TextView) view.findViewById(R.id.password);
			viewHolder.status = (TextView) view.findViewById(R.id.status);
			viewHolder.roleName = (TextView) view.findViewById(R.id.role_name);
			viewHolder.createDate = (TextView) view
					.findViewById(R.id.create_date);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.userCode.setText(STR_USER_CODE + u.getUserCode());
		viewHolder.userName.setText(STR_USER_NAME + u.getUserName());
		viewHolder.password.setText(STR_PASSWORD);
		viewHolder.createDate.setText(STR_CREATE_DATE + u.getCreateDate());
		viewHolder.status.setText(STR_STATUS
				+ (u.getStatus() == 0 ? "Y-����" : "N����"));
		if (u.getRoleName() == 0) {
			viewHolder.roleName.setText(STR_ROLE_NAME + "ADMIN-ϵͳ����Ա");
		} else if (u.getRoleName() == 1) {
			viewHolder.roleName.setText(STR_ROLE_NAME + "SHOP_MASTER-���о���");
		} else if (u.getRoleName() == 2) {
			viewHolder.roleName.setText(STR_ROLE_NAME + "SHOP_SALES-����ӪҵԱ");
		}
		return view;
	}

	class ViewHolder {

		TextView userCode;
		TextView userName;
		TextView password;
		TextView roleName;
		TextView status;
		TextView createDate;

	}

}
