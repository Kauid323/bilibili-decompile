package tv.danmaku.bili.ui.freedata;

import com.bilibili.base.BiliContext;
import com.bilibili.fd_service.FreeDataDelegate;
import com.bilibili.fd_service.demiware.DemiwareConfig;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import tv.danmaku.bili.ui.freedata.unicom.UnicomDemiwareConfig;

public class FreeDataDelegateImpl implements FreeDataDelegate {
    private static final String DEFAULT_VALIDITY_HOURS = "168";

    public String getAccessKey() {
        return BiliAccounts.get(BiliContext.application()).getAccessKey();
    }

    public DemiwareConfig getUnicomDemiwareConfig() {
        return new UnicomDemiwareConfig();
    }

    public boolean isLogin() {
        return BiliAccounts.get(BiliContext.application()).isLogin();
    }

    public int getUserActiveCacheValidTime() {
        try {
            String hour = (String) ConfigManager.config().get("freedata.free_hours", DEFAULT_VALIDITY_HOURS);
            if (hour != null) {
                return Integer.valueOf(hour).intValue();
            }
        } catch (Exception e) {
        }
        return Integer.valueOf(DEFAULT_VALIDITY_HOURS).intValue();
    }
}