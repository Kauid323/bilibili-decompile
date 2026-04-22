package tv.danmaku.bili.ui.freedata.unicom;

import android.app.Application;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.fd_service.demiware.DemiwareConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.moduleservice.freedata.FreedataDemiwareService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;

/* compiled from: UnicomDemiwareConfig.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\f\u0010\u0010\u001a\u00020\u0011*\u00020\tH\u0002J\f\u0010\u0012\u001a\u00020\t*\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/freedata/unicom/UnicomDemiwareConfig;", "Lcom/bilibili/fd_service/demiware/DemiwareConfig;", "Lcom/bilibili/moduleservice/freedata/FreedataDemiwareService;", "<init>", "()V", "callbackFreedataDemiwareActive", "", "callbackFreedataPlayerDemiwareShown", "getCurrentTime", "", "getServerTime", "getDemiwareShownData", "getDemiwareActiveData", "canDemiware", "", "getDemiwareTime", "toDataString", "", "toTimeMillis", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UnicomDemiwareConfig extends DemiwareConfig implements FreedataDemiwareService {
    public static final int $stable = 8;

    public void callbackFreedataDemiwareActive() {
        Application $this$callbackFreedataDemiwareActive_u24lambda_u240 = BiliContext.application();
        if ($this$callbackFreedataDemiwareActive_u24lambda_u240 != null) {
            long now = getCurrentTime();
            BiliGlobalPreferenceHelper.getInstance($this$callbackFreedataDemiwareActive_u24lambda_u240).edit().putLong("key_unicom_freedata_demiware_active_data", now).apply();
        }
    }

    public void callbackFreedataPlayerDemiwareShown() {
        Application $this$callbackFreedataPlayerDemiwareShown_u24lambda_u240 = BiliContext.application();
        if ($this$callbackFreedataPlayerDemiwareShown_u24lambda_u240 != null) {
            long now = getCurrentTime();
            BiliGlobalPreferenceHelper.getInstance($this$callbackFreedataPlayerDemiwareShown_u24lambda_u240).edit().putLong("key_unicom_freedata_demiware_shown_data", now).apply();
        }
    }

    private final long getCurrentTime() {
        if (BuildConfig.DEBUG) {
            return System.currentTimeMillis();
        }
        return getServerTime();
    }

    private final long getServerTime() {
        long it = ServerClock.now();
        if (it <= 0) {
            return System.currentTimeMillis();
        }
        return it;
    }

    private final long getDemiwareShownData() {
        Application it = BiliContext.application();
        if (it != null) {
            return BiliGlobalPreferenceHelper.getInstance(it).optLong("key_unicom_freedata_demiware_shown_data", 0L);
        }
        return 0L;
    }

    private final long getDemiwareActiveData() {
        Application it = BiliContext.application();
        if (it != null) {
            return BiliGlobalPreferenceHelper.getInstance(it).optLong("key_unicom_freedata_demiware_active_data", 0L);
        }
        return 0L;
    }

    public boolean canDemiware() {
        boolean enable = Intrinsics.areEqual(ConfigManager.Companion.ab().get("ff_unicom_freedata_demiware_enable", true), true);
        if (!enable) {
            return false;
        }
        long j = 0;
        try {
            String str = (String) ConfigManager.Companion.config().get("freedata.unicom_freedata_demiware_ask_for_cd_time", "0");
            if (str != null) {
                j = Long.parseLong(str);
            }
        } catch (Exception e) {
        }
        long showCD = toTimeMillis(j);
        long j2 = 168;
        try {
            String str2 = (String) ConfigManager.Companion.config().get("freedata.unicom_freedata_demiware_active_cd", "168");
            if (str2 != null) {
                j2 = Long.parseLong(str2);
            }
        } catch (Exception e2) {
        }
        long activeCD = toTimeMillis(j2);
        long now = getCurrentTime();
        long lastShowData = getDemiwareShownData();
        long lastActiveData = getDemiwareActiveData();
        String dataString = toDataString(now);
        BLog.i("tf.UnicomDemiwareConfig", "show cd = " + showCD + ", active cd = " + activeCD + ", now = " + dataString + ", next show data = " + toDataString(lastShowData + showCD) + ",  next active data = " + toDataString(activeCD + lastActiveData));
        return lastShowData + showCD < now && activeCD + lastActiveData < now;
    }

    public long getDemiwareTime() {
        try {
            String str = (String) ConfigManager.Companion.config().get("freedata.unicom_freedata_demiware_time", String.valueOf(360000L));
            if (str != null) {
                return Long.parseLong(str);
            }
            return 360000L;
        } catch (Exception e) {
            return 360000L;
        }
    }

    private final String toDataString(long $this$toDataString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String format = dateFormat.format(new Date($this$toDataString));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception e) {
            return "";
        }
    }

    private final long toTimeMillis(long $this$toTimeMillis) {
        long j = 60;
        return $this$toTimeMillis * j * j * 1000;
    }
}