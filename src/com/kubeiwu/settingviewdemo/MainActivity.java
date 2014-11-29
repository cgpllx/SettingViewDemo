package com.kubeiwu.settingviewdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new NullRoundCornerFragment());
		ft.commitAllowingStateLoss();
//		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.qq1));
	}

}
