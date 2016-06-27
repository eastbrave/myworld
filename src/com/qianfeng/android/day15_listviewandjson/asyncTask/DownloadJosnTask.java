package com.qianfeng.android.day15_listviewandjson.asyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qianfeng.android.day15_listviewandjson.bean.Company;
import com.qianfeng.android.day15_listviewandjson.utils.HttpUtils;
import com.qianfeng.android.day15_listviewandjson.utils.JsonUtils;

import android.content.Context;
import android.os.AsyncTask;

public class DownloadJosnTask extends AsyncTask<String, Void, List<Company>> {
	private Context context;
	private CallBack mCallBack;

	public DownloadJosnTask(Context context, CallBack mCallBack) {
		this.context = context;
		this.mCallBack = mCallBack;
	}

	@Override
	protected List<Company> doInBackground(String... params) {
		try {
			List<Company> result = getAllCompany(params[0]);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(List<Company> result) {
		mCallBack.callback(result);
	}

	private List<Company> getAllCompany(String urlString) throws IOException {
		if (HttpUtils.isNetWorkConn(context)) {
			byte[] buffer = HttpUtils.getNetWorkResult(urlString);
			if (buffer != null) {
				String jsonString = new String(buffer);
				return JsonUtils.parseJson(jsonString);
			}
		}
		return null;
	}

	public interface CallBack {
		public void callback(List<Company> list);
	}

}
