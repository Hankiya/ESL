package com.cxt.esl.kind.listener;

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
import com.cxt.esl.kind.activity.KindUpdateActivity;
import com.cxt.esl.kind.domain.Kind;

public class KindGroupLongClickListener implements OnLongClickListener {
	private Context context;
	private SimpleExpandableListAdapter sela;
	private int position;

	public KindGroupLongClickListener(int position,
			SimpleExpandableListAdapter sela, Context context) {
		super();
		this.context = context;
		this.sela = sela;
		this.position = position;
	}

	@Override
	public boolean onLongClick(View v) {
		// ȡ����������groupview����Ķ���ͨ��sela���adapterȥ��Pattern
		final Kind k = ((Map<String, Kind>) this.sela.getGroup(position))
				.get("group");
		// ����ʱ����һ���Ի���
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setItems(R.array.kind_menu,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// �鿴
						if (which == 0) {
							AlertDialog.Builder d1 = new AlertDialog.Builder(context);
							CharSequence[] items = new CharSequence[3];
							items[0] = "����ţ�" + k.getKindId();
							items[1] = "��Ʒ���" + k.getKindname();
							items[2] = "��ע��" + k.getRemarks();
							d1.setItems(items, null);
							d1.show();
						}
						// ����
						else if (which == 1) {
							Intent intent = new Intent(context, KindUpdateActivity.class);
							ArrayList<Kind> list = new ArrayList<Kind>();
							list.add(k);
							intent.putParcelableArrayListExtra("kind", list );
							context.startActivity(intent);
						}
						// ɾ��
						else if (which == 2) {
							AlertDialog.Builder d2 = new AlertDialog.Builder(
									context);
							d2.setTitle("ɾ�������");
							d2.setMessage("ȷ��ɾ�������");
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
