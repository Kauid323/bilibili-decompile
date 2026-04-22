package tv.danmaku.bili.ui.splash.ad.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashTopViewType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashTopViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "ALPHA_EGG", "TRANSITION_MODE", "TV_CLOSE", "BG_DISAPPEAR", "LAUNCH_DANMAKU", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum SplashTopViewType {
    NONE(-1),
    ALPHA_EGG(1),
    TRANSITION_MODE(2),
    TV_CLOSE(3),
    BG_DISAPPEAR(4),
    LAUNCH_DANMAKU(5);
    
    private final int type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SplashTopViewType> getEntries() {
        return $ENTRIES;
    }

    SplashTopViewType(int type) {
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }
}