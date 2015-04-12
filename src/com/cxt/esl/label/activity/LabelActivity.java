package com.cxt.esl.label.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import com.cxt.esl.R;
import com.cxt.esl.label.adapter.LabelListAdapter;
import com.cxt.esl.label.model.Label;

/*
 * ����һ��Activity���̳�ExpandableListAcitivty
 */
public class LabelActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	SimpleExpandableListAdapter sela;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.label);

		List<Map<String, Label>> groups = new ArrayList<Map<String, Label>>();
		List<List<Map<String, Label>>> childs = new ArrayList<List<Map<String, Label>>>();
		for(int i = 0; i < 100; i++){
			Map<String, Label> group1 = new HashMap<String, Label>();
			Label label = new Label(3123123123L, "101002__E����������(�ͼǻ���)__350.00", "2.1��ƽ��ҩ��8������", 0, 452324213L, "ble2.1w");
			group1.put("group", label);
			groups.add(group1);
			
			List<Map<String, Label>> child1 = new ArrayList<Map<String, Label>>();
			Map<String, Label> child1Data1 = new HashMap<String, Label>();
			child1Data1.put("child", label);
			Map<String, Label> child1Data2 = new HashMap<String, Label>();
			child1Data2.put("child", label);
			Map<String, Label> child1Data3 = new HashMap<String, Label>();
			child1Data3.put("child", label);
			Map<String, Label> child1Data4 = new HashMap<String, Label>();
			child1Data4.put("child", label);
			Map<String, Label> child1Data5 = new HashMap<String, Label>();
			child1Data5.put("child", label);
			child1.add(child1Data1);
			child1.add(child1Data2);
			child1.add(child1Data3);
			child1.add(child1Data4);
			child1.add(child1Data5);
			childs.add(child1);
		}
		
		

		
		// ����һ��SimpleExpandableListAdapter����
		// 1.context
		// 2.һ����Ŀ������
		// 3.��������һ����Ŀ��ʽ�Ĳ����ļ�
		// 4.ָ��һ����Ŀ���ݵ�key
		// 5.ָ��һ����Ŀ������ʾ�ؼ���id
		// 6.ָ��������Ŀ������
		// 7.�������ö�����Ŀ��ʽ�Ĳ����ļ�
		// 8.ָ��������Ŀ���ݵ�key
		// 9.ָ��������Ŀ������ʾ�ؼ���id
		sela = new LabelListAdapter(
				this, groups, R.layout.label_group, new String[] { "group" },
				new int[] { R.id.labelGroupTo }, childs, R.layout.label_child,
				new String[] { "child" }, new int[] { R.id.lableChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
		
		ExpandableListView expandableListView = this.getExpandableListView();
		Button searchBtn = (Button) this.findViewById(R.id.label_search_btn);
		searchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(LabelActivity.this, "��ѯ",
						Toast.LENGTH_SHORT).show();
			}
		});
		Button resetBtn = (Button) this.findViewById(R.id.label_reset_btn);
		resetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Activity ctx = LabelActivity.this;
				((EditText)ctx.findViewById(R.id.e_esl_id)).setText("");
				((EditText)ctx.findViewById(R.id.e_ap_id)).setText("");
				((EditText)ctx.findViewById(R.id.e_work_status)).setText("");
			}
		});
		
		Button addBtn = (Button) this.findViewById(R.id.label_add_btn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LabelActivity.this, LabelAddActivity.class);
				LabelActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
        
	}
	
	
}