package com.cxt.esl.user.listener;

import java.sql.SQLException;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.cxt.esl.R;
import com.cxt.esl.user.activity.UserUpdateActivity;
import com.cxt.esl.user.adapter.UserAdapter;
import com.cxt.esl.user.dao.UserDao;
import com.cxt.esl.user.domain.User;

public class UserItemClickListener implements OnItemClickListener{
	private Context ctx;
	private List<User> userList;
	private UserDao userDao;
	private UserAdapter adapter;
	
	

	public UserItemClickListener(Context ctx, List<User> userList,
			UserDao userDao, UserAdapter adapter) {
		super();
		this.ctx = ctx;
		this.userList = userList;
		this.userDao = userDao;
		this.adapter = adapter;
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		final User user = userList.get(position);
		
		// ����ʱ����һ���Ի���
				AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
				builder.setItems(R.array.user_menu,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// ����
								if (which == 0) {
									Intent intent = new Intent(ctx, UserUpdateActivity.class);
									intent.putExtra("user", user);
									ctx.startActivity(intent);
								}
								// ɾ��
								else if (which == 1) {
									AlertDialog.Builder d2 = new AlertDialog.Builder(
											ctx);
									d2.setTitle("ɾ�����û�");
									d2.setMessage("ȷ��ɾ�����û�");
									d2.setCancelable(false);
									d2.setNegativeButton("��",
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(
														DialogInterface dialog,
														int which) {
												}
											});
									d2.setPositiveButton("��",
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(
														DialogInterface dialog,
														int which) {
													try {
														userDao.delete(user);
														userList = userDao.queryAll();
														adapter = new UserAdapter(ctx,
																R.layout.user_item, userList);
														ListView listView = (ListView) ((Activity) ctx).findViewById(R.id.user_list);
														listView.setAdapter(adapter);
													} catch (SQLException e) {
														e.printStackTrace();
													}
												}
											});
									d2.show();
								}
							}
						});
				builder.show();
	}




}
