package tv.danmaku.bili.ui.freedata.ui;

import com.bilibili.droid.StringUtil;
import com.bilibili.freedata.ui.telecom.TelecomActivateFragment;
import com.bilibili.lib.config.BLRemoteConfig;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TelecomRouteActiveFragment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/freedata/ui/TelecomRouteActiveFragment;", "Lcom/bilibili/freedata/ui/telecom/TelecomActivateFragment;", "<init>", "()V", "initView", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TelecomRouteActiveFragment extends TelecomActivateFragment {
    public static final int $stable = 8;

    protected void initView() {
        super.initView();
        String tips = BLRemoteConfig.getInstance().getString("telecom_active_page_tips");
        if (StringUtil.isNotBlank(tips)) {
            this.mSecDescTv.setText(tips);
        }
    }
}