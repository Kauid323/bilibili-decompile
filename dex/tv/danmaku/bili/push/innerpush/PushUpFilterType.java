package tv.danmaku.bili.push.innerpush;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: PushRpc.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/push/innerpush/PushUpFilterType;", "", "text", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "RestrictedMode", "Expire", "LoadFail", "OverLoad", "BlacklistDiscard", "RESOURCE_DISCARD", "Logout", "ServerFilter", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum PushUpFilterType {
    RestrictedMode("model"),
    Expire("expire"),
    LoadFail("loadfail"),
    OverLoad("overload"),
    BlacklistDiscard("blacklist_discard"),
    RESOURCE_DISCARD("resource_discard"),
    Logout("logout"),
    ServerFilter("server_filter");
    
    private final String text;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<PushUpFilterType> getEntries() {
        return $ENTRIES;
    }

    PushUpFilterType(String text) {
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }
}