package com.cxt.esl.good.activity;

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
import com.cxt.esl.good.adapter.GoodListAdapter;
import com.cxt.esl.good.domain.Good;

public class GoodActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	SimpleExpandableListAdapter sela;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.model);

		List<Map<String, Good>> groups = new ArrayList<Map<String, Good>>();
		List<List<Map<String, Good>>> childs = new ArrayList<List<Map<String, Good>>>();
		for(int i = 0; i < 100; i++){
			Map<String, Good> group1 = new HashMap<String, Good>();
			Good good = new Good((long) (101056+i), "BW˫�����ڷ�Һ(��ݸ����)", "BW˫�����ڷ�Һ", 12.6f+i, 9.0f - i, "��", "2014-09-30 12:09:45");
			group1.put("group", good);
			groups.add(group1);
			
			List<Map<String, Good>> child1 = new ArrayList<Map<String, Good>>();
			Map<String, Good> child1Data1 = new HashMap<String, Good>();
			child1Data1.put("child", good);
			Map<String, Good> child1Data2 = new HashMap<String, Good>();
			child1Data2.put("child", good);
			Map<String, Good> child1Data3 = new HashMap<String, Good>();
			child1Data3.put("child", good);
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
		sela = new GoodListAdapter(
				this, groups, R.layout.good_group, new String[] { "group" },
				new int[] { R.id.goodGroupTo }, childs, R.layout.good_child,
				new String[] { "child" }, new int[] { R.id.goodChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
		
		ExpandableListView expandableListView = this.getExpandableListView();
		Button addBtn = (Button) this.findViewById(R.id.good_add_btn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GoodActivity.this, GoodAddActivity.class);
				GoodActivity.this.startActivity(intent);
			}
		});
	
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
        
	}
	
	
}