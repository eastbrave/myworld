package com.qianfeng.android.day15_listviewandjson;

import java.util.ArrayList;
import java.util.List;

import com.qianfeng.android.day15_listviewandjson.activity.ShowCompanyActivity;
import com.qianfeng.android.day15_listviewandjson.adapter.CompanyAdapter;
import com.qianfeng.android.day15_listviewandjson.asyncTask.DownloadJosnTask;
import com.qianfeng.android.day15_listviewandjson.asyncTask.DownloadJosnTask.CallBack;
import com.qianfeng.android.day15_listviewandjson.bean.Company;
import com.qianfeng.android.day15_listviewandjson.common.ApiConstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private List<Company> list;
	private ListView listView;
	private CompanyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化数据
		initData();
		//初始化视图
		initView();
		//初始化适配器
		initAdapter();
		//绑定适配器
		bindAdapter();
		//初始化监听
		initListener();
	}

	private void initListener() {
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, ShowCompanyActivity.class);
				Company company=list.get(position);
				intent.putExtra("company", company);
				startActivity(intent);
			}
		});
	}

	private void bindAdapter() {
		listView.setAdapter(adapter);
	}

	private void initAdapter() {
		adapter=new CompanyAdapter(MainActivity.this, R.layout.item_company, list);
	}

	private void initView() {
		listView=(ListView) findViewById(R.id.lv_show);
		TextView tvEmpty=(TextView)findViewById(R.id.tv_empty_view);
		listView.setEmptyView(tvEmpty);
	}

	private void initData() {
		list=new ArrayList<Company>();
		new DownloadJosnTask(MainActivity.this, new CallBack() {
			
			@Override
			public void callback(List<Company> list) {
				MainActivity.this.list.addAll(list);
				
				adapter.notifyDataSetChanged();
			}
		}).execute(ApiConstant.URL_COMPANY);
	}


}
