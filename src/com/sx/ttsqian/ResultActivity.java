package com.sx.ttsqian;


import net.youmi.android.AdManager;
import net.youmi.android.spot.SpotDialogListener;
import net.youmi.android.spot.SpotManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity{

	
	TextView tv_result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tv_result=(TextView)findViewById(R.id.textView1);
		tv_result.setText(getIntent().getStringExtra("mony"));
		
		TextView textview=(TextView)findViewById(R.id.chongxin);
		
		// 参数：appId, appSecret, 调试模式
		AdManager.getInstance(this).init("85aa56a59eac8b3d", "a14006f66f58d5d7", false);
		// 检查配置，SDK运行失败时可以用来检查配置是否齐全
		SpotManager.getInstance(this).checkPermission(this);
		// 加载插播资源
		SpotManager.getInstance(this).loadSpotAds();
		SpotManager.getInstance(this).setShowInterval(20);// 设置20秒的显示时间间隔
		SpotManager.getInstance(this).setSpotOrientation(SpotManager.ORIENTATION_PORTRAIT);		 
		
		// 展示插播广告，可以不调用loadSpot独立使用
		SpotManager.getInstance(ResultActivity.this).showSpotAds(
				ResultActivity.this, new SpotDialogListener() {
					@Override
					public void onShowSuccess() {
						Log.i("YoumiAdDemo", "展示成功");
					}

					@Override
					public void onShowFailed() {
						Log.i("YoumiAdDemo", "展示失败");
					}

					@Override
					public void onSpotClosed() {
						Log.e("YoumiAdDemo", "插屏关闭");
					}

		}); // //
		
		textview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inten=new Intent();
				inten.setClass(ResultActivity.this, MenuActivity.class);
				inten.putExtra("parmentvalue", "1");
				startActivity(inten);
				finish();
			}
		});
	}
}
