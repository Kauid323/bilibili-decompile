package tv.danmaku.bili.splash.ad.reporter.tech;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: SplashCustomReporter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/splash/ad/reporter/tech/SplashShowType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TOP_VIEW", "REAL_TIME_SPLASH", "SHOW_DISPLAY", "LOCAL_SHOW_DISPLAY", "NOT_SHOW", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum SplashShowType {
    TOP_VIEW("top_view"),
    REAL_TIME_SPLASH("real_time_splash"),
    SHOW_DISPLAY("show_display"),
    LOCAL_SHOW_DISPLAY("local_show_display"),
    NOT_SHOW(MineReporter.PUBLISH_NOT_SHOW);
    
    private final String type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SplashShowType> getEntries() {
        return $ENTRIES;
    }

    SplashShowType(String type) {
        this.type = type;
    }

    public final String getType() {
        return this.type;
    }
}