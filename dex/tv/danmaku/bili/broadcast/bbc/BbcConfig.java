package tv.danmaku.bili.broadcast.bbc;

import com.bilibili.comm.bbc.service.BbcClientManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.moss.api.MossBroadcast;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: BbcConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/broadcast/bbc/BbcConfig;", "Lcom/bilibili/comm/bbc/service/BbcClientManager$Config;", "<init>", "()V", "disabled", "", "getDisabled", "()Z", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BbcConfig implements BbcClientManager.Config {
    public static final int $stable = 0;
    public static final BbcConfig INSTANCE = new BbcConfig();
    private static final boolean disabled = INSTANCE.disabled();

    private BbcConfig() {
    }

    public boolean getDisabled() {
        return disabled;
    }

    private final boolean disabled() {
        boolean mossEnabled = MossBroadcast.enabled();
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "bbc_shutdown_complete", (Object) null, 2, (Object) null);
        boolean result = true;
        boolean b = bool != null ? bool.booleanValue() : true;
        result = (mossEnabled && b) ? false : false;
        if (result) {
            BLog.w("BbcClientManager", "Bbc broadcast disabled.");
        } else {
            BLog.i("BbcClientManager", "Bbc broadcast enabled.");
        }
        return result;
    }
}