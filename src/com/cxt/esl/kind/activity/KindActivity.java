package com.cxt.esl.kind.activity;

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
import com.cxt.esl.kind.adapter.KindListAdapter;
import com.cxt.esl.kind.domain.Kind;

public class KindActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	SimpleExpandableListAdapter sela;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kind);

		List<Map<String, Kind>> groups = new ArrayList<Map<String, Kind>>();
		List<List<Map<String, Kind>>> childs = new ArrayList<List<Map<String, Kind>>>();
		for(int i = 0; i < 100; i++){
			Map<String, Kind> group1 = new HashMap<String, Kind>();
			Kind k = new Kind(10013L,"Ƭ��", "Ƭ��");
			group1.put("group", k);
			groups.add(group1);
			
			List<Map<String, Kind>> child1 = new ArrayList<Map<String, Kind>>();
			Map<String, Kind> child1Data1 = new HashMap<String, Kind>();
			child1Data1.put("child", k);
			Map<String, Kind> child1Data2 = new HashMap<String, Kind>();
			child1Data2.put("child", k);
			Map<String, Kind> child1Data3 = new HashMap<String, Kind>();
			child1Data3.put("child", k);
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
		sela = new KindListAdapter(
				this, groups, R.layout.kind_group, new String[] { "group" },
				new int[] { R.id.kindGroupTo }, childs, R.layout.kind_child,
				new String[] { "child" }, new int[] { R.id.kindChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
		
		ExpandableListView expandableListView = this.getExpandableListView();
		Button addBtn = (Button) this.findViewById(R.id.kind_add_btn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(KindActivity.this, KindAddActivity.class);
				KindActivity.this.startActivity(intent);
			}
		});
	
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
        
	}
	
	
}
