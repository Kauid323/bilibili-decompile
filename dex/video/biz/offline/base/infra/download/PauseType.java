package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OperationDispatcher.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/infra/download/PauseType;", "", "<init>", "(Ljava/lang/String;I)V", "PAUSE_TAP_ALL", "PAUSE_NETWORK_ERROR", "PAUSE_NOT_WIFI", "PAUSE_LOGOUT", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum PauseType {
    PAUSE_TAP_ALL,
    PAUSE_NETWORK_ERROR,
    PAUSE_NOT_WIFI,
    PAUSE_LOGOUT;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<PauseType> getEntries() {
        return $ENTRIES;
    }
}