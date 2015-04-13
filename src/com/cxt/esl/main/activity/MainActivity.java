package com.cxt.esl.main.activity;

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
import com.cxt.esl.good.activity.GoodActivity;
import com.cxt.esl.kind.activity.KindActivity;
import com.cxt.esl.label.activity.LabelActivity;
import com.cxt.esl.model.activity.ModelActivity;
import com.cxt.esl.pattern.activity.PatternActivity;

/*
 * ����һ��Activity���̳�ExpandableListAcitivty
 */
public class MainActivity extends ExpandableListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		group4.put("group", "AP ����");
		groups.add(group4);
		Map<String, String> group5 = new HashMap<String, String>();
		group5.put("group", "��ع���");
		groups.add(group5);
		
		List<Map<String, String>> child1 = new ArrayList<Map<String, String>>();
		Map<String, String> child1Data1 = new HashMap<String, String>();
		child1Data1.put("child", "�û�����");
		child1.add(child1Data1);
		Map<String, String> child1Data2 = new HashMap<String, String>();
		child1Data2.put("child", "��ɫ����");
		child1.add(child1Data2);
		Map<String, String> child1Data3 = new HashMap<String, String>();
		child1Data3.put("child", "ģ�鶨��");
		child1.add(child1Data3);
		Map<String, String> child1Data4 = new HashMap<String, String>();
		child1Data4.put("child", "���ܶ���");
		child1.add(child1Data4);
		Map<String, String> child1Data5 = new HashMap<String, String>();
		child1Data5.put("child", "Ȩ�޿���");
		child1.add(child1Data5);
		Map<String, String> child1Data6 = new HashMap<String, String>();
		child1Data6.put("child", "���ʿ���");
		child1.add(child1Data6);
		Map<String, String> child1Data7 = new HashMap<String, String>();
		child1Data7.put("child", "��־����");
		child1.add(child1Data7);
		Map<String, String> child1Data8 = new HashMap<String, String>();
		child1Data8.put("child", "�ֶ�posͬ������");
		child1.add(child1Data8);
		Map<String, String> child1Data9 = new HashMap<String, String>();
		child1Data9.put("child", "�Զ�posͬ������");
		child1.add(child1Data9);
		Map<String, String> child1Data10 = new HashMap<String, String>();
		child1Data10.put("child", "��������");
		child1.add(child1Data10);
		Map<String, String> child1Data11 = new HashMap<String, String>();
		child1Data11.put("child", "�۸����ʱ��");
		child1.add(child1Data11);
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
		child3Data4.put("child", "pos���ٰ�");
		child3.add(child3Data4);
		Map<String, String> child3Data5 = new HashMap<String, String>();
		child3Data5.put("child", "��Ʒ�滻");
		child3.add(child3Data5);
		Map<String, String> child3Data6 = new HashMap<String, String>();
		child3Data6.put("child", "��Ʒ����ת��");
		child3.add(child3Data6);
		Map<String, String> child3Data7 = new HashMap<String, String>();
		child3Data7.put("child", "��Ʒ������ʷ");
		child3.add(child3Data7);
		childs.add(child3);
		
		List<Map<String, String>> child4 = new ArrayList<Map<String, String>>();
		Map<String, String> child4Data1 = new HashMap<String, String>();
		child4Data1.put("child", "AP����");
		child4.add(child4Data1);
		childs.add(child4);
		
		List<Map<String, String>> child5 = new ArrayList<Map<String, String>>();
		Map<String, String> child5Data1 = new HashMap<String, String>();
		child5Data1.put("child", "�ɹ���ʾ�ı�ǩ");
		child5.add(child5Data1);
		Map<String, String> child5Data2 = new HashMap<String, String>();
		child5Data2.put("child", "��Ʒ�޸���ʷ");
		child5.add(child5Data2);
		Map<String, String> child5Data3 = new HashMap<String, String>();
		child5Data3.put("child", "�豸��Ϣ���");
		child5.add(child5Data3);
		Map<String, String> child5Data4 = new HashMap<String, String>();
		child5Data4.put("child", "���ݸ�����ʷ");
		child5.add(child5Data4);
		Map<String, String> child5Data5 = new HashMap<String, String>();
		child5Data5.put("child", "ͼƬ�����б�");
		child5.add(child5Data5);
		Map<String, String> child5Data6 = new HashMap<String, String>();
		child5Data6.put("child", "ESL���߼��");
		child5.add(child5Data6);
		childs.add(child5);
		

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
		}
		return false;
	}
}