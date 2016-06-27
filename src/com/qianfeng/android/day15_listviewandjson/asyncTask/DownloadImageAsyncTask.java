package com.qianfeng.android.day15_listviewandjson.asyncTask;

import java.io.IOException;

import com.qianfeng.android.day15_listviewandjson.utils.HttpUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
	private Context context;
	private ImageView imageView;

	public DownloadImageAsyncTask(Context context,ImageView imageView) {
		this.context = context;
		this.imageView=imageView;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		try {
			Bitmap bitmap = getBitmapFromNetwrok(params[0]);
			return bitmap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Bitmap getBitmapFromNetwrok(String imgString) throws IOException {
		if (HttpUtils.isNetWorkConn(context)) {
			byte[] buffer = HttpUtils.getNetWorkResult(imgString);
			if (buffer != null) {
				Bitmap bitmap = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
				return bitmap;
			}
		}

		return null;
	}
	
	@Override
	protected void onPostExecute(Bitmap bitmap) {
		imageView.setImageBitmap(bitmap);
	}

}
