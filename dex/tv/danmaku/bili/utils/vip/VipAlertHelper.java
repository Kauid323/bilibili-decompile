package tv.danmaku.bili.utils.vip;

import android.content.Context;
import bili.resource.playerbaseres.R;
import com.bilibili.base.Applications;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;

public class VipAlertHelper {
    private VipAlertHelper() {
    }

    public static boolean vipAccountFrozen() {
        Context context = Applications.getCurrent();
        AccountInfo myInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        if (myInfo != null && myInfo.getVipInfo() != null && myInfo.getVipInfo().isFrozen()) {
            String msg = context.getString(R.string.playerbaseres_global_string_1303);
            ToastHelper.showToastLong(context, msg);
            return true;
        }
        return false;
    }
}