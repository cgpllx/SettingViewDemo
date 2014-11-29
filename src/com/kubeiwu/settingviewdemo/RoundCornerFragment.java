package com.kubeiwu.settingviewdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.kubeiwu.commontool.view.util.DisplayOptions;
import com.kubeiwu.commontool.view.util.ItemBgSelectorUtil.RowStyle;

public class RoundCornerFragment extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		DisplayOptions selectorPara = new DisplayOptions.Builder()//
		.setGroupTitleSizePx(15)//
		.setOut_circle_Size(15)//
		.setRowStyle(RowStyle.ALL_AROUND).setRowleftpadding(21)//
		.build();
		
		ScrollView scrollView = new ScrollView(getActivity());
		View view = initView(selectorPara);
		view.setPadding(20, 10, 20, 10);
		scrollView.addView(view);
		
		return scrollView;
	}
	
	 
}
