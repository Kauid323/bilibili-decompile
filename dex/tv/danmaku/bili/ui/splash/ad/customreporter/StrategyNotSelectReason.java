package tv.danmaku.bili.ui.splash.ad.customreporter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StrategyNotSelectReason.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/customreporter/StrategyNotSelectReason;", "", "reason", "", "<init>", "(Ljava/lang/String;II)V", "getReason", "()I", "SELECTED", "STRATEGY_TIME_INVALID", "SPLASH_TIME_INVALID", "SPLASH_MISMATCH_SCENE", "REACH_MAX_SHOW_COUNT", "PROGRAM_EXPOSED", "RESOURCE_NOT_READY", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum StrategyNotSelectReason {
    SELECTED(0),
    STRATEGY_TIME_INVALID(1),
    SPLASH_TIME_INVALID(2),
    SPLASH_MISMATCH_SCENE(3),
    REACH_MAX_SHOW_COUNT(4),
    PROGRAM_EXPOSED(5),
    RESOURCE_NOT_READY(6);
    
    private final int reason;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<StrategyNotSelectReason> getEntries() {
        return $ENTRIES;
    }

    StrategyNotSelectReason(int reason) {
        this.reason = reason;
    }

    public final int getReason() {
        return this.reason;
    }
}