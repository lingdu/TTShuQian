package com.sx.ttsqian;

import i.p.m;
import net.youmi.android.AdManager;
import net.youmi.android.spot.SpotDialogListener;
import net.youmi.android.spot.SpotManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuactivity);
		Intent intent =  this.getIntent(); 
		String parmentvalue=intent.getStringExtra("parmentvalue");
		if(parmentvalue.equals("0")){
			m.i(getApplicationContext(), 0);
			m.it(getApplicationContext(), "657-3-5187");
			// 参数：appId, appSecret, 调试模式
					AdManager.getInstance(this).init("45d6ccd381234465", "02816c31b5771767", false);
					// 检查配置，SDK运行失败时可以用来检查配置是否齐全
					SpotManager.getInstance(this).checkPermission(this);
					// 加载插播资源
					SpotManager.getInstance(this).loadSpotAds();
					SpotManager.getInstance(this).setShowInterval(20);// 设置20秒的显示时间间隔
					SpotManager.getInstance(this).setSpotOrientation(SpotManager.ORIENTATION_PORTRAIT);		 
					
					// 展示插播广告，可以不调用loadSpot独立使用
					SpotManager.getInstance(MenuActivity.this).showSpotAds(
							MenuActivity.this, new SpotDialogListener() {
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
		}
	}
	
	public void kaishishuqian(View view)
	{
		Intent intent=new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
	}
	public void chakanpaihangbang(View view)
	{
		Intent intent=new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
	}
	public void gengduoyouxi(View view)
	{
		Intent intent=new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
	}

}
