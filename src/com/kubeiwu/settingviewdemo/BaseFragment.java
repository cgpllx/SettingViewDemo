package com.kubeiwu.settingviewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.kubeiwu.commontool.view.setting.GroupView;
import com.kubeiwu.commontool.view.setting.KSettingView;
import com.kubeiwu.commontool.view.setting.RowView;
import com.kubeiwu.commontool.view.setting.viewimpl.CheckBoxRowView;
import com.kubeiwu.commontool.view.setting.viewimpl.DefaultRowView;
import com.kubeiwu.commontool.view.setting.viewimpl.EditTextRowView;
import com.kubeiwu.commontool.view.setting.viewimpl.ListRowView;
import com.kubeiwu.commontool.view.util.DisplayOptions;
import com.kubeiwu.commontool.view.util.OnRowClickListener;
import com.kubeiwu.commontool.view.util.RowViewActionEnum;
import com.kubeiwu.settingviewdemo.ParaSetting.ParaUtil;

public class BaseFragment extends Fragment {
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ParaUtil.initPrar(getActivity());

	};

	protected View initView(DisplayOptions selectorPara) {
		KSettingView containerView = new KSettingView(getActivity());

		containerView.setDisplayOptions(selectorPara);
		GroupView groupView1 = containerView.addGroupViewItem(-1);
		GroupView groupView2 = containerView.addGroupViewItem(2, "常用功能");
		GroupView groupView3 = containerView.addGroupViewItem(3, "其他样式");

		groupView1.addRowViewItem(CheckBoxRowView.class, 2, "个人中心", R.drawable.qq1, R.drawable.setting_view_item_selector, ParaSetting.xiazshud2)//
				.setOnRowClickListener(getOnRowClickListener(CheckBoxRowView.class));

		groupView1.addRowViewItem(DefaultRowView.class, 3, "我的电脑", R.drawable.qq2, R.drawable.arrow_to_right, ParaSetting.xiazshud3)//
				.setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));

		groupView2.addRowViewItem(CheckBoxRowView.class, 1, "空间动态", R.drawable.qq3, R.drawable.setting_view_item_selector, ParaSetting.xiazshud4);
		groupView2.addRowViewItem(DefaultRowView.class, 2, "文件管理", R.drawable.qq4, R.drawable.arrow_to_right, ParaSetting.xiazshud5)//
				.setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		groupView2.addRowViewItem(CheckBoxRowView.class, 2, "游戏", R.drawable.qq5, R.drawable.setting_view_item_selector, ParaSetting.xiazshud6);

		groupView3.addRowViewItem(ListRowView.class, 1, "同时下载线程数", R.drawable.qq6, R.drawable.arrow_to_right, ParaSetting.xiazshud7)//
				.setEntries("1个", "2个", "3个", "4个", "5个")//
				.setEntryValues(1, 2, 3, 4, 5);//
		groupView3.addRowViewItem(EditTextRowView.class, 2, "收藏", R.drawable.qq7, R.drawable.arrow_to_right, ParaSetting.xiazshud8);
		groupView3.addRowViewItem(DefaultRowView.class, 3, "附近的人", R.drawable.qq8, R.drawable.arrow_to_right, ParaSetting.xiazshud9)//
				.setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		 
		groupView3.addRowViewItem(DefaultRowView.class, 4, "扫一扫", R.drawable.qq9, R.drawable.arrow_to_right, ParaSetting.xiazshud9).setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		groupView3.addRowViewItem(DefaultRowView.class, 12, "无图片效果", R.drawable.qq11, R.drawable.arrow_to_right, ParaSetting.xiazshud9).setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		groupView3.addRowViewItem(DefaultRowView.class, 11, "圆角效果", R.drawable.qq10, R.drawable.arrow_to_right, ParaSetting.xiazshud9).setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		groupView3.addRowViewItem(DefaultRowView.class, 13, "无圆角效果", R.drawable.qq12, R.drawable.arrow_to_right, ParaSetting.xiazshud9).setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));
		groupView3.addRowViewItem(DefaultRowView.class, 14, "扫一扫", R.drawable.qq13, R.drawable.arrow_to_right, ParaSetting.xiazshud9).setOnRowClickListener(getOnRowClickListener(DefaultRowView.class));

		containerView.commit();
		return containerView;
	}

	public <T extends RowView> OnRowClickListener<T> getOnRowClickListener(Class<T> clazz) {
		return new OnRowClickListener<T>() {
			@Override
			public void onRowClick(T rowView, RowViewActionEnum action) {
				switch (rowView.getItemId()) {
				case 11:
					FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new RoundCornerFragment());
					ft.commitAllowingStateLoss();
					break;
				case 13:
					ft = getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new NullRoundCornerFragment());
					ft.commit();
					break;

				default:
					break;
				}

				if (toast == null) {
					toast = Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);
				}
				toast.setText(rowView.getTitle());
				toast.show();
			}
		};
	}

	private Toast toast;
}
