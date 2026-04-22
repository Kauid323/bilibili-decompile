package video.biz.offline.list.logic.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineCacheCardModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/CardTag;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "CHARGE", "BANGUMI", "MOVIE", "DOCUMENTARY", "CN_BANGUMI", "TV_SERIES", "VARIETY", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum CardTag {
    NONE,
    CHARGE,
    BANGUMI,
    MOVIE,
    DOCUMENTARY,
    CN_BANGUMI,
    TV_SERIES,
    VARIETY;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CardTag> getEntries() {
        return $ENTRIES;
    }
}