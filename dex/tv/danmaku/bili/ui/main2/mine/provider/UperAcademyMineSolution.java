package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.xpref.Xpref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;
import tv.danmaku.bili.ui.uper.UperRepoter;

public class UperAcademyMineSolution implements IMinePageInfo {
    private String TAG = "UperAcademyMineSolution";
    private AcademyMenuItemSolution mMenuSolution = new AcademyMenuItemSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.UperAcademyMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            UperAcademyMineSolution.this.linkTo(context, menuData);
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item menuData) {
            return menuData.needLogin == 1;
        }
    };

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.mMenuSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.mRedirection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void linkTo(Activity context, MenuGroup.Item menuData) {
        if (!TextUtils.isEmpty(menuData.uri)) {
            Uri uri = Uri.parse(menuData.uri);
            String link = uri.getQueryParameter("redirect");
            if (!TextUtils.isEmpty(link)) {
                IntentHelper.intentTo(context, Uri.parse(link));
                return;
            } else {
                BLog.e(this.TAG, "---link--empty--");
                return;
            }
        }
        BLog.e(this.TAG, "---uri--empty--");
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class AcademyMenuItemSolution extends DefaultMineMenuSolution {
        AcademyMenuItemSolution() {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onLoginStateChanged(Context context, MenuGroup.Item item) {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            if (TeenagersMode.getInstance().getEntranceState("upper") == 0 || RestrictedMode.isEnable(RestrictedType.LESSONS, "uper")) {
                setVisible(item, false);
            }
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemClick(Context context, MenuGroup.Item menuData) {
            Xpref.getDefaultSharedPreferences(context).edit().putBoolean("ui.main.NavigationFragment.is_show_academy_new" + BiliAccounts.get(context).mid(), false).apply();
            UperRepoter.ugcCenterCourseClick(context);
        }
    }
}