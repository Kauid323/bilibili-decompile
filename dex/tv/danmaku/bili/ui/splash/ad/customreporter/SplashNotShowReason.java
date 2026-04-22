package tv.danmaku.bili.ui.splash.ad.customreporter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCustomReporter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/customreporter/SplashNotShowReason;", "", "reason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "DISABLE_SPLASH", "SHOW_FORBID", "LOCAL_SHOW_FORBID", "SHOW_COUNT_LIMIT", "NO_RES", "NO_LOCAL_DATA", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum SplashNotShowReason {
    DISABLE_SPLASH("disable_splash"),
    SHOW_FORBID("show_forbid"),
    LOCAL_SHOW_FORBID("local_show_forbid"),
    SHOW_COUNT_LIMIT("show_count_limit"),
    NO_RES("no_res"),
    NO_LOCAL_DATA("no_local_data");
    
    private final String reason;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SplashNotShowReason> getEntries() {
        return $ENTRIES;
    }

    SplashNotShowReason(String reason) {
        this.reason = reason;
    }

    public final String getReason() {
        return this.reason;
    }
}