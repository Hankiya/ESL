package com.cxt.esl.pattern.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
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
import com.cxt.esl.pattern.adapter.PatternListAdapter;
import com.cxt.esl.pattern.domain.Pattern;

/*
 * ����һ��Activity���̳�ExpandableListAcitivty
 */
public class PatternActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	SimpleExpandableListAdapter sela;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pattern);

		List<Map<String, Pattern>> groups = new ArrayList<Map<String, Pattern>>();
		List<List<Map<String, Pattern>>> childs = new ArrayList<List<Map<String, Pattern>>>();
		for(int i = 0; i < 100; i++){
			Map<String, Pattern> group1 = new HashMap<String, Pattern>();
			String code = "<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'172\' height=\'72\' >\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>\n\t\t<span style=\'font-size: 1pt\'>��</span></td>\n\t</tr>\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>��</td>\n\t</tr>\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>��</td>\n\t</tr>\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>��</td>\n\t</tr>\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>��</td>\n\t</tr>\n\t<tr>\n\t\t<td bgcolor=\'#FFFFFF\' width=\'172\' height=\'12\' bordercolor=\'#000000\' style=\'border-bottom-style: solid; border-bottom-width: 1px\'>��</td>\n\t</tr>\n</table>";
			Pattern p = new Pattern(i, "2.1��װ�", "2.1��װ�", "ble2.1w", code);
			group1.put("group", p);
			groups.add(group1);
			
			List<Map<String, Pattern>> child1 = new ArrayList<Map<String, Pattern>>();
			Map<String, Pattern> child1Data1 = new HashMap<String, Pattern>();
			child1Data1.put("child", p);
			Map<String, Pattern> child1Data2 = new HashMap<String, Pattern>();
			child1Data2.put("child", p);
			Map<String, Pattern> child1Data3 = new HashMap<String, Pattern>();
			child1Data3.put("child", p);
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
		sela = new PatternListAdapter(
				this, groups, R.layout.pattern_group, new String[] { "group" },
				new int[] { R.id.patternGroupTo }, childs, R.layout.pattern_child,
				new String[] { "child" }, new int[] { R.id.patternChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
		
		ExpandableListView expandableListView = this.getExpandableListView();
		Button addBtn = (Button) this.findViewById(R.id.pattern_add_btn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PatternActivity.this, PatternAddActivity.class);
				PatternActivity.this.startActivity(intent);
			}
		});
	
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
        
	}
	
	
}