package tv.danmaku.biliplayerv2.service;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IActivityStateService.kt */
@Deprecated(message = "Use androidx Lifecycle.")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "ACTIVITY_CREATE", "FRAGMENT_CREATE_VIEW", "FRAGMENT_VIEW_CREATED", "ACTIVITY_START", "ACTIVITY_RESUME", "ACTIVITY_PAUSE", "ACTIVITY_STOP", "ACTIVITY_DESTROY", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum LifecycleState {
    INITIAL,
    ACTIVITY_CREATE,
    FRAGMENT_CREATE_VIEW,
    FRAGMENT_VIEW_CREATED,
    ACTIVITY_START,
    ACTIVITY_RESUME,
    ACTIVITY_PAUSE,
    ACTIVITY_STOP,
    ACTIVITY_DESTROY;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<LifecycleState> getEntries() {
        return $ENTRIES;
    }
}