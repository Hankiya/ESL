package com.cxt.esl.main.activity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.cxt.esl.R;
import com.cxt.esl.bind.activity.QuickBindActivity;
import com.cxt.esl.good.activity.GoodActivity;
import com.cxt.esl.kind.activity.KindActivity;
import com.cxt.esl.label.activity.LabelActivity;
import com.cxt.esl.model.activity.ModelActivity;
import com.cxt.esl.pattern.activity.PatternActivity;
import com.cxt.esl.util.db.ESLDatebaseHelper;

/*
 * ����һ��Activity���̳�ExpandableListAcitivty
 */
public class MainActivity extends ExpandableListActivity {
	private ESLDatebaseHelper helper;
	/** Called when the activity is first created. */
	
	private void init(){
		helper = ESLDatebaseHelper.getHelper(this.getApplicationContext());
		helper.getWritableDatabase();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		setContentView(R.layout.main);
		
		List<Map<String, String>> groups = new ArrayList<Map<String, String>>();
		List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();

		Map<String, String> group1 = new HashMap<String, String>();
		group1.put("group", "ϵͳ����");
		groups.add(group1);
		Map<String, String> group2 = new HashMap<String, String>();
		group2.put("group", "��ǩ����");
		groups.add(group2);
		Map<String, String> group3 = new HashMap<String, String>();
		group3.put("group", "��Ʒ����");
		groups.add(group3);
		Map<String, String> group4 = new HashMap<String, String>();
		group4.put("group", "��ع���");
		groups.add(group4);
		
		List<Map<String, String>> child1 = new ArrayList<Map<String, String>>();
		Map<String, String> child1Data1 = new HashMap<String, String>();
		child1Data1.put("child", "�û�����");
		child1.add(child1Data1);
		Map<String, String> child1Data2 = new HashMap<String, String>();
		child1Data2.put("child", "��������");
		child1.add(child1Data2);
		childs.add(child1);
		
		List<Map<String, String>> child2 = new ArrayList<Map<String, String>>();
		Map<String, String> child2Data1 = new HashMap<String, String>();
		child2Data1.put("child", "��ǩ�б�");
		child2.add(child2Data1);
		Map<String, String> child2Data2 = new HashMap<String, String>();
		child2Data2.put("child", "ģ���б�");
		child2.add(child2Data2);
		Map<String, String> child2Data3 = new HashMap<String, String>();
		child2Data3.put("child", "�ͺ��б�");
		child2.add(child2Data3);
		childs.add(child2);
		
		
		List<Map<String, String>> child3 = new ArrayList<Map<String, String>>();
		Map<String, String> child3Data1 = new HashMap<String, String>();
		child3Data1.put("child", "��Ʒ�б�");
		child3.add(child3Data1);
		Map<String, String> child3Data2 = new HashMap<String, String>();
		child3Data2.put("child", "������");
		child3.add(child3Data2);
		Map<String, String> child3Data3 = new HashMap<String, String>();
		child3Data3.put("child", "���ٰ�");
		child3.add(child3Data3);
		Map<String, String> child3Data4 = new HashMap<String, String>();
		child3Data4.put("child", "��Ʒ�滻");
		child3.add(child3Data4);
		childs.add(child3);
		
		List<Map<String, String>> child4 = new ArrayList<Map<String, String>>();
		Map<String, String> child4Data1 = new HashMap<String, String>();
		child4Data1.put("child", "�ɹ���ʾ�ı�ǩ");
		child4.add(child4Data1);
		Map<String, String> child4Data2 = new HashMap<String, String>();
		child4Data2.put("child", "��Ʒ�޸���ʷ");
		child4.add(child4Data2);
		childs.add(child4);
		

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
		SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(
				this, groups, R.layout.main_group, new String[] { "group" },
				new int[] { R.id.mainGroupTo }, childs, R.layout.main_child,
				new String[] { "child" }, new int[] { R.id.mianChildTo });
		// ��SimpleExpandableListAdapter�������ø���ǰ��ExpandableListActivity
		setListAdapter(sela);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Log.d("Test", groupPosition + " " + childPosition + " " + id);
		if(groupPosition == 1){
			if(childPosition == 0){
				Intent intent = new Intent(MainActivity.this, LabelActivity.class);
				startActivity(intent);
				return true;
			}
			else if(childPosition == 1){
				Intent intent = new Intent(MainActivity.this, PatternActivity.class);
				startActivity(intent);
				return true;
			}
			else if(childPosition == 2){
				Intent intent = new Intent(MainActivity.this, ModelActivity.class);
				startActivity(intent);
				return true;
			}
		}
		else if(groupPosition == 2){
			if(childPosition == 0){
				Intent intent = new Intent(MainActivity.this, GoodActivity.class);
				startActivity(intent);
				return true;
			}else if(childPosition == 1){
				Intent intent = new Intent(MainActivity.this, KindActivity.class);
				startActivity(intent);
				return true;
			}
			else if(childPosition == 2){
				Intent intent = new Intent(MainActivity.this, QuickBindActivity.class);
				startActivity(intent);
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		helper.close();
	}
	
}