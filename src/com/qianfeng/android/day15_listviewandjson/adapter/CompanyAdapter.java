package com.qianfeng.android.day15_listviewandjson.adapter;

import java.util.List;

import com.qianfeng.android.day15_listviewandjson.R;
import com.qianfeng.android.day15_listviewandjson.asyncTask.DownloadImageAsyncTask;
import com.qianfeng.android.day15_listviewandjson.bean.Company;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyAdapter extends CommonAdapter<Company> {
	private Context context;
	

	public CompanyAdapter(Context context, int layoutId, List<Company> list) {
		super(context, layoutId, list);
		this.context=context;
	}

	@Override
	public void convert(ViewHolderM holderM, Company bean) {
		ImageView imageView=(ImageView)holderM.getView(R.id.iv_icon);
		TextView textView=(TextView)holderM.getView(R.id.tv_company_name);
		
		textView.setText(bean.getName());
		new DownloadImageAsyncTask(context, imageView).execute(bean.getIcon());
		
	}

}
