package com.kubeiwu.settingviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.kubeiwu.commontool.view.setting.CheckBoxRowView;
import com.kubeiwu.commontool.view.setting.DefaultRowView;
import com.kubeiwu.commontool.view.setting.EditTextRowView;
import com.kubeiwu.commontool.view.setting.GroupView;
import com.kubeiwu.commontool.view.setting.KSettingView;
import com.kubeiwu.commontool.view.setting.ListRowView;
import com.kubeiwu.commontool.view.util.DisplayOptions;
import com.kubeiwu.commontool.view.util.ItemBgSelectorUtil.RowStyle;
import com.kubeiwu.settingviewdemo.ParaSetting.ParaUtil;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		ParaUtil.initPrar(getApplicationContext());
		ScrollView scrollView = new ScrollView(this);
		View view = init5();
		view.setPadding(20, 10, 20, 10);
		scrollView.addView(view);
		setContentView(scrollView);
	}

	View init5() {
		KSettingView containerView = new KSettingView(MainActivity.this);
		DisplayOptions selectorPara = new DisplayOptions.Builder()//
				.setGroupTitleSizePx(18)//
				.setOut_circle_Size(0)//
				.setRowStyle(RowStyle.ALL_AROUND).setRowleftpadding(21)//
				.build();
		containerView.setDisplayOptions(selectorPara);
		GroupView groupView1 = containerView.addGroupViewItem(-1);
		GroupView groupView2 = containerView.addGroupViewItem(2, "常用功能");
		GroupView groupView3 = containerView.addGroupViewItem(3, "其他设置");

		groupView1.addRowViewItem(CheckBoxRowView.class, 2, "个人中心", R.drawable.qq1, R.drawable.setting_view_item_selector, ParaSetting.xiazshud2);
		groupView1.addRowViewItem(DefaultRowView.class, 3, "我的电脑", R.drawable.qq2, R.drawable.arrow_to_right, ParaSetting.xiazshud3);

		groupView2.addRowViewItem(CheckBoxRowView.class, 1, "空间动态", R.drawable.qq3, R.drawable.setting_view_item_selector, ParaSetting.xiazshud4);
		groupView2.addRowViewItem(DefaultRowView.class, 2, "文件管理", R.drawable.qq4, R.drawable.arrow_to_right, ParaSetting.xiazshud5);
		groupView2.addRowViewItem(CheckBoxRowView.class, 2, "游戏", R.drawable.qq5, R.drawable.setting_view_item_selector, ParaSetting.xiazshud6);

		groupView3.addRowViewItem(ListRowView.class, 1, "同时下载线程数", R.drawable.qq6, R.drawable.arrow_to_right, ParaSetting.xiazshud7)//
				.setEntries("1个", "2个", "3个", "4个", "5个")//
				.setEntryValues(1, 2, 3, 4, 5);//
		groupView3.addRowViewItem(EditTextRowView.class, 2, "收藏", R.drawable.qq7, R.drawable.arrow_to_right, ParaSetting.xiazshud8);
		groupView3.addRowViewItem(DefaultRowView.class, 3, "附近的人", R.drawable.qq8, R.drawable.arrow_to_right, ParaSetting.xiazshud9);
		groupView3.addRowViewItem(DefaultRowView.class, 4, "扫一扫", R.drawable.qq9, R.drawable.arrow_to_right, ParaSetting.xiazshud9);

		containerView.commit();
		return containerView;
	}
}
