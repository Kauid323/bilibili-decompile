package tv.danmaku.biliplayerv2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ControlContainerType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/ControlContainerType;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "NONE", "HALF_SCREEN", "LANDSCAPE_FULLSCREEN", "VERTICAL_FULLSCREEN", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum ControlContainerType {
    INITIAL,
    NONE,
    HALF_SCREEN,
    LANDSCAPE_FULLSCREEN,
    VERTICAL_FULLSCREEN;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ControlContainerType> getEntries() {
        return $ENTRIES;
    }
}