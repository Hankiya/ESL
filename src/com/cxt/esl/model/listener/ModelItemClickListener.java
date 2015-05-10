package com.cxt.esl.model.listener;

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
import com.cxt.esl.model.activity.ModelUpdateActivity;
import com.cxt.esl.model.adapter.ModelAdapter;
import com.cxt.esl.model.dao.ModelDao;
import com.cxt.esl.model.domain.Model;


public class ModelItemClickListener implements OnItemClickListener{
	private Context ctx;
	private List<Model> modelList;
	private ModelDao modelDao;
	private ModelAdapter adapter;
	
	

	public ModelItemClickListener(Context ctx, List<Model> modelList,
			ModelDao modelDao, ModelAdapter adapter) {
		super();
		this.ctx = ctx;
		this.modelList = modelList;
		this.modelDao = modelDao;
		this.adapter = adapter;
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		final Model model = modelList.get(position);
		
		// ����ʱ����һ���Ի���
				AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
				builder.setItems(R.array.model_menu,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// ����
								if (which == 0) {
									Intent intent = new Intent(ctx, ModelUpdateActivity.class);
									intent.putExtra("model", model);
									ctx.startActivity(intent);
								}
								// ɾ��
								else if (which == 1) {
									AlertDialog.Builder d2 = new AlertDialog.Builder(
											ctx);
									d2.setTitle("ɾ�����ͺ�");
									d2.setMessage("ȷ��ɾ�����ͺ�");
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
														modelDao.delete(model);
														modelList = modelDao.queryAll();
														adapter = new ModelAdapter(ctx,
																R.layout.model_item, modelList);
														ListView listView = (ListView) ((Activity) ctx).findViewById(R.id.model_list);
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
