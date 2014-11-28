package com.kubeiwu.settingviewdemo;

import com.kubeiwu.commontool.view.util.Para;
import com.kubeiwu.commontool.view.util.SettingsUtil;

import android.content.Context;

public interface ParaSetting {
	Para<Boolean> xiazshud1 = new Para<Boolean>("key1", true);
	Para<Boolean> xiazshud2 = new Para<Boolean>("key2", true);
	Para<String> xiazshud3 = new Para<String>("key3", "");
	Para<Boolean> xiazshud4 = new Para<Boolean>("key4", true);
	Para<String> xiazshud5 = new Para<String>("key5", "");
	Para<Boolean> xiazshud6 = new Para<Boolean>("key6", true);
	Para<Integer> xiazshud7 = new Para<Integer>("key7", 3);
	Para<String> xiazshud8 = new Para<String>("key8", "收藏");
	Para<String> xiazshud9 = new Para<String>("key9", "搜索附近的人");
//	Para<String> xiazshud9 = new Para<String>("key9", "搜索附近的人");

	public class ParaUtil {


		public static void initPrar(Context context) {
			SettingsUtil settingsUtil = new SettingsUtil(context);

			settingsUtil.initParaFromPreferences(xiazshud1);
			settingsUtil.initParaFromPreferences(xiazshud2);
			settingsUtil.initParaFromPreferences(xiazshud3);
			settingsUtil.initParaFromPreferences(xiazshud4);
			settingsUtil.initParaFromPreferences(xiazshud5);
			settingsUtil.initParaFromPreferences(xiazshud6);
			settingsUtil.initParaFromPreferences(xiazshud7);
			settingsUtil.initParaFromPreferences(xiazshud8);
			settingsUtil.initParaFromPreferences(xiazshud9);
		}
	}
}
