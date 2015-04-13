package com.cxt.esl.model.listener;

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
import com.cxt.esl.model.activity.ModelUpdateActivity;
import com.cxt.esl.model.domain.Model;

public class ModelGroupLongClickListener implements OnLongClickListener {
	private Context context;
	private SimpleExpandableListAdapter sela;
	private int position;

	public ModelGroupLongClickListener(int position,
			SimpleExpandableListAdapter sela, Context context) {
		super();
		this.context = context;
		this.sela = sela;
		this.position = position;
	}

	@Override
	public boolean onLongClick(View v) {
		// ȡ����������groupview����Ķ���ͨ��sela���adapterȥ��Pattern
		final Model m = ((Map<String, Model>) this.sela.getGroup(position))
				.get("group");
		// ����ʱ����һ���Ի���
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setItems(R.array.model_menu,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// �鿴
						if (which == 0) {
							AlertDialog.Builder d1 = new AlertDialog.Builder(context);
							CharSequence[] items = new CharSequence[7];
							items[0] = "����ͺţ�" + m.getModelName();
							items[1] = "�ߴ磺" + m.getInch();
							items[2] = "�ͺſ�ȣ�" + m.getWidth();
							items[3] = "�ͺŸ߶ȣ�" + m.getHeight();
							items[4] = "��ת�Ƕȣ�" + m.getRotate();
							items[5] = "���أ�" + m.getRotate();
							items[6] = "�ͺ�������" + m.getModelNote();
							d1.setItems(items, null);
							d1.show();
						}
						// ����
						else if (which == 1) {
							Intent intent = new Intent(context, ModelUpdateActivity.class);
							ArrayList<Model> list = new ArrayList<Model>();
							list.add(m);
							intent.putParcelableArrayListExtra("model", list );
							context.startActivity(intent);
						}
						// ɾ��
						else if (which == 2) {
							AlertDialog.Builder d2 = new AlertDialog.Builder(
									context);
							d2.setTitle("ɾ����ESL�ͺ�");
							d2.setMessage("ȷ��ɾ����ESL�ͺ�");
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
