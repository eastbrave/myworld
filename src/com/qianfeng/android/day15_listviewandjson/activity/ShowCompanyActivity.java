package com.qianfeng.android.day15_listviewandjson.activity;

import com.qianfeng.android.day15_listviewandjson.R;
import com.qianfeng.android.day15_listviewandjson.asyncTask.DownloadImageAsyncTask;
import com.qianfeng.android.day15_listviewandjson.bean.Company;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowCompanyActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_company);
		
		Intent intent=getIntent();
		Company company=(Company) intent.getSerializableExtra("company");
		
		
		TextView textView=(TextView) findViewById(R.id.tv_company_name);
		textView.setText(company.getName());
		
		
		ImageView imageView=(ImageView)findViewById(R.id.iv_show_company);
		
		new DownloadImageAsyncTask(this, imageView).execute(company.getIcon());
	}

}
