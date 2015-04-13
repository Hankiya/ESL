package com.cxt.esl.good.listener;

import java.util.ArrayList;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.SimpleExpandableListAdapter;

import com.cxt.esl.R;
import com.cxt.esl.good.activity.GoodUpdateActivity;
import com.cxt.esl.good.domain.Good;

public class GoodGroupLongClickListener implements OnLongClickListener {
	private Context context;
	private SimpleExpandableListAdapter sela;
	private int position;

	public GoodGroupLongClickListener(int position,
			SimpleExpandableListAdapter sela, Context context) {
		super();
		this.context = context;
		this.sela = sela;
		this.position = position;
	}

	@Override
	public boolean onLongClick(View v) {
		// ȡ����������groupview����Ķ���ͨ��sela���adapterȥ��Pattern
		final Good g = ((Map<String, Good>) this.sela.getGroup(position))
				.get("group");
		// ����ʱ����һ���Ի���
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setItems(R.array.good_menu,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// �鿴
						if (which == 0) {
							AlertDialog.Builder d1 = new AlertDialog.Builder(context);
							CharSequence[] items = new CharSequence[7];
							items[0] = "��Ʒ���룺" + g.getBarCode();
							items[1] = "��Ʒ���ƣ�" + g.getEslName();
							items[2] = "ԭ�ۣ�" + g.getOrigPrice();
							items[3] = "�ּۣ�" + g.getPresPrice();
							items[4] = "�Ƽ۵�λ��" + g.getPriceUnit();
							items[5] = "��ʾ���ƣ�" + g.getPosName();
							items[6] = "����޸�ʱ�䣺" + g.getModiTtime();
							d1.setItems(items, null);
							d1.show();
						}
						// ����
						else if (which == 1) {
							Intent intent = new Intent(context, GoodUpdateActivity.class);
							ArrayList<Good> list = new ArrayList<Good>();
							list.add(g);
							intent.putParcelableArrayListExtra("good", list );
							context.startActivity(intent);
						}
						// ɾ��
						else if (which == 2) {
							AlertDialog.Builder d2 = new AlertDialog.Builder(
									context);
							d2.setTitle("ɾ����ESL��Ʒ");
							d2.setMessage("ȷ��ɾ����ESL��Ʒ");
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
										}
									});
							d2.show();
						}
						// �¼�
						else if (which == 3) {
							AlertDialog.Builder d2 = new AlertDialog.Builder(
									context);
							d2.setTitle("�¼ܸ�ESL��Ʒ");
							d2.setMessage("ȷ���¼ܸ�ESL��Ʒ");
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
								}
							});
							d2.show();
						}
					}
				});
		builder.show();
		return false;
	}

}
