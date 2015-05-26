package com.cxt.esl.good.listener;

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
import android.widget.Toast;

import com.cxt.esl.R;
import com.cxt.esl.good.activity.GoodUpdateActivity;
import com.cxt.esl.good.adapter.GoodAdapter;
import com.cxt.esl.good.dao.GoodDao;
import com.cxt.esl.good.domain.Good;
import com.cxt.esl.sale.activity.SaleActivity;
import com.cxt.esl.sale.adapter.SaleAdapter;

public class GoodItemClickListener implements OnItemClickListener{
	private Context ctx;
	private List<Good> goodList;
	private GoodDao goodDao;
	private GoodAdapter adapter;
	
	

	public GoodItemClickListener(Context ctx, List<Good> goodList,
			GoodDao goodDao, GoodAdapter adapter) {
		super();
		this.ctx = ctx;
		this.goodList = goodList;
		this.goodDao = goodDao;
		this.adapter = adapter;
	}



	public GoodItemClickListener(SaleActivity ctx2, List<Good> goodList2,
			GoodDao goodDao2, SaleAdapter adapter2) {
		this.ctx = ctx2;
		this.goodList = goodList2;
		this.goodDao = goodDao2;
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		final Good good = goodList.get(position);
		
		// ����ʱ����һ���Ի���
				AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
				builder.setItems(R.array.good_menu,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// �鿴����
								if (which == 0) {
									Intent intent = new Intent(ctx, GoodUpdateActivity.class);
									intent.putExtra("good", good);
									ctx.startActivity(intent);
								}
								// ɾ��
								else if (which == 1) {
									AlertDialog.Builder d2 = new AlertDialog.Builder(
											ctx);
									d2.setTitle("ɾ������Ʒ");
									d2.setMessage("ȷ��ɾ������Ʒ");
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
														goodDao.delete(good);
														goodList = goodDao.queryAll();
														adapter = new GoodAdapter(ctx,
																R.layout.good_item, goodList);
														ListView listView = (ListView) ((Activity) ctx).findViewById(R.id.good_list);
														listView.setAdapter(adapter);
													} catch (SQLException e) {
														e.printStackTrace();
													}
												}
											});
									d2.show();
								}
								else if(which == 2){
									AlertDialog.Builder d2 = new AlertDialog.Builder(
											ctx);
									d2.setTitle("�¼ܸ���Ʒ");
									d2.setMessage("ȷ���¼ܸ���Ʒ");
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
														Toast.makeText(ctx, "�¼ܳɹ�", Toast.LENGTH_SHORT).show();
												}
											});
									d2.show();
								}
							}
							
						});
				builder.show();
	}




}