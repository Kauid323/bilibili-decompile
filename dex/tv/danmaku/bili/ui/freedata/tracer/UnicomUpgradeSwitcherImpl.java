package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.unicom.UnicomUpgradeSwitcher;

public class UnicomUpgradeSwitcherImpl implements UnicomUpgradeSwitcher {
    private static final UnicomUpgradeSwitcherImpl instance = new UnicomUpgradeSwitcherImpl();

    private UnicomUpgradeSwitcherImpl() {
    }

    public static UnicomUpgradeSwitcherImpl getInstance() {
        return instance;
    }

    public boolean enableUnicomUpgrade() {
        return FreeDataMainModuleHelper.enableUnicomUpgrade();
    }
}