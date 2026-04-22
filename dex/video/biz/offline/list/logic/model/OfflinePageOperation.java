package video.biz.offline.list.logic.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflinePageOperation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "", "<init>", "(Ljava/lang/String;I)V", "SEARCH_ICON", "DELETE_TEXT", "DANMAKU_TEXT", "SETTING_ICON", "SETTING_TEXT", "EDIT_ICON", "EDIT_TEXT", "CONTINUOUS_PLAY_ICON_TEXT", "MANAGE_TEXT", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum OfflinePageOperation {
    SEARCH_ICON,
    DELETE_TEXT,
    DANMAKU_TEXT,
    SETTING_ICON,
    SETTING_TEXT,
    EDIT_ICON,
    EDIT_TEXT,
    CONTINUOUS_PLAY_ICON_TEXT,
    MANAGE_TEXT;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<OfflinePageOperation> getEntries() {
        return $ENTRIES;
    }
}