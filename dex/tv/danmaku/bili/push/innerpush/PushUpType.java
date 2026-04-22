package tv.danmaku.bili.push.innerpush;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: PushRpc.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/push/innerpush/PushUpType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_UNKNOWN", "TYPE_ACK", "TYPE_FILTER", "TYPE_SHOW", "TYPE_CLICK", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum PushUpType {
    TYPE_UNKNOWN,
    TYPE_ACK,
    TYPE_FILTER,
    TYPE_SHOW,
    TYPE_CLICK;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<PushUpType> getEntries() {
        return $ENTRIES;
    }
}