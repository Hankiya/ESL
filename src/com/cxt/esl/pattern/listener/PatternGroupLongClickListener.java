package com.cxt.esl.pattern.listener;

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
import com.cxt.esl.label.activity.LabelUpdateActivity;
import com.cxt.esl.label.domain.Label;
import com.cxt.esl.pattern.activity.PatternUpdateActivity;
import com.cxt.esl.pattern.domain.Pattern;

public class PatternGroupLongClickListener implements OnLongClickListener {
	private Context context;
	private SimpleExpandableListAdapter sela;
	private int position;

	public PatternGroupLongClickListener(int position,
			SimpleExpandableListAdapter sela, Context context) {
		super();
		this.context = context;
		this.sela = sela;
		this.position = position;
	}

	@Override
	public boolean onLongClick(View v) {
		// ȡ����������groupview����Ķ���ͨ��sela���adapterȥ��Pattern
		final Pattern p = ((Map<String, Pattern>) this.sela.getGroup(position))
				.get("group");
		// ����ʱ����һ���Ի���
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setItems(R.array.pattern_menu,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// �鿴
						if (which == 0) {
							AlertDialog.Builder d1 = new AlertDialog.Builder(context);
							CharSequence[] items = new CharSequence[5];
							items[0] = "���кţ�" + p.getOrderNum();
							items[1] = "ģ�����ƣ�" + p.getPatternName();
							items[2] = "�����ͺţ�" + p.getModelName();
							items[3] = "readme��" + p.getReadme();
							items[4] = "html���룺" + p.getCode();
							d1.setItems(items, null);
							d1.show();
						}
						// ����
						else if (which == 1) {
							Intent intent = new Intent(context, PatternUpdateActivity.class);
							ArrayList<Pattern> list = new ArrayList<Pattern>();
							list.add(p);
							intent.putParcelableArrayListExtra("pattern", list );
							context.startActivity(intent);
						}
						// ɾ��
						else if (which == 2) {
							AlertDialog.Builder d2 = new AlertDialog.Builder(
									context);
							d2.setTitle("ɾ����ESLģ��");
							d2.setMessage("ȷ��ɾ����ESLģ��");
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
