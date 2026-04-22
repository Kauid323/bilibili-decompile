package tv.danmaku.bili.splash.ad.button.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: SplashActionType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "SHAKE", "ROTATE", "ROTATE_BALL", "ROTATE_BALL_THRESHOLD", "SLIDE", "EGG", "CLICKABLE_EGG", "UNDEFINE", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum SplashActionType {
    BUTTON,
    SHAKE,
    ROTATE,
    ROTATE_BALL,
    ROTATE_BALL_THRESHOLD,
    SLIDE,
    EGG,
    CLICKABLE_EGG,
    UNDEFINE;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SplashActionType> getEntries() {
        return $ENTRIES;
    }
}