package com.cxt.esl.model.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.cxt.esl.R;
import com.cxt.esl.model.adapter.ModelListAdapter;
import com.cxt.esl.model.domain.Model;

public class ModelActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	SimpleExpandableListAdapter sela;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.model);

		List<Map<String, Model>> groups = new ArrayList<Map<String, Model>>();
		List<List<Map<String, Model>>> childs = new ArrayList<List<Map<String, Model>>>();
		for(int i = 0; i < 100; i++){
			Map<String, Model> group1 = new HashMap<String, Model>();
			Model m = new Model("ble2.1w", "2.1", 3, 2, 30, 1, "2.1������4���Ҷ�90�ȷ�ת");
			group1.put("group", m);
			groups.add(group1);
			
			List<Map<String, Model>> child1 = new ArrayList<Map<String, Model>>();
			Map<String, Model> child1Data1 = new HashMap<String, Model>();
			child1Data1.put("child", m);
			Map<String, Model> child1Data2 = new HashMap<String, Model>();
			child1Data2.put("child", m);
			Map<String, Model> child1Data3 = new HashMap<String, Model>();
			child1Data3.put("child", m);
			child1.add(child1Data1);
			child1.add(child1Data2);
			child1.add(child1Data3);
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
		sela = new ModelListAdapter(
				this, groups, R.layout.model_group, new String[] { "group" },
				new int[] { R.id.modelGroupTo }, childs, R.layout.model_child,
				new String[] { "child" }, new int[] { R.id.modelChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
		
		ExpandableListView expandableListView = this.getExpandableListView();
		Button addBtn = (Button) this.findViewById(R.id.model_add_btn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ModelActivity.this, ModelAddActivity.class);
				ModelActivity.this.startActivity(intent);
			}
		});
	
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
        
	}
	
	
}