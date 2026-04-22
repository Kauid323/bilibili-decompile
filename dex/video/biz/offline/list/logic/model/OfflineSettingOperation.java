package video.biz.offline.list.logic.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflinePageOperation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflineSettingOperation;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_SELECT", "AUTO_DOWNLOAD", "OFFLINE_DIAGNOSIS", "STORAGE_TEST", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum OfflineSettingOperation {
    STORAGE_SELECT,
    AUTO_DOWNLOAD,
    OFFLINE_DIAGNOSIS,
    STORAGE_TEST;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<OfflineSettingOperation> getEntries() {
        return $ENTRIES;
    }
}