package tv.danmaku.bili.ui.intent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: Reporter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/intent/Phase;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_OP", "X86", "AI", "FROM_HISTORY", "FROM_URI", "FROM_LAHUO", "BLANK", "USER_PROTOCOL", "THIRD_FOLLOW_PUBLISH", "DIRECT_BACK", "FOREGROUND", "NORMAL", "ERROR", "ERROR_IN_FOLLOW", "FROM_WX", "FROM_WX_AI", "FROM_WX_PROTOCOL", "FROM_INSTANT_WEB", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum Phase {
    NO_OP(0),
    X86(1),
    AI(2),
    FROM_HISTORY(3),
    FROM_URI(4),
    FROM_LAHUO(5),
    BLANK(6),
    USER_PROTOCOL(7),
    THIRD_FOLLOW_PUBLISH(8),
    DIRECT_BACK(9),
    FOREGROUND(10),
    NORMAL(11),
    ERROR(12),
    ERROR_IN_FOLLOW(13),
    FROM_WX(14),
    FROM_WX_AI(15),
    FROM_WX_PROTOCOL(16),
    FROM_INSTANT_WEB(17);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<Phase> getEntries() {
        return $ENTRIES;
    }

    Phase(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}