package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lkntr/base/net/PHASE;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "INIT", "COMM", "LBS", "REDIRECT", "FREE_DATA", "MULTI_DOMAIN", "SEND", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum PHASE {
    INIT(0),
    COMM(100),
    LBS(110),
    REDIRECT(111),
    FREE_DATA(BackoffConfigKt.MAX_DELAY_SECONDS),
    MULTI_DOMAIN(130),
    SEND(999);
    
    private final int priority;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<PHASE> getEntries() {
        return $ENTRIES;
    }

    PHASE(int priority) {
        this.priority = priority;
    }

    public final int getPriority() {
        return this.priority;
    }
}