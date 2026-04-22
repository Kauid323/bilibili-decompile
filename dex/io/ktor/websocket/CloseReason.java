package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.upper.comm.statistics.StatisticsHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: CloseReason.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lio/ktor/websocket/CloseReason;", Column.INVAL_VALUE, Column.INVAL_VALUE, "code", Column.INVAL_VALUE, "message", "<init>", "(SLjava/lang/String;)V", "Lio/ktor/websocket/CloseReason$Codes;", "(Lio/ktor/websocket/CloseReason$Codes;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "()S", "component2", "copy", "(SLjava/lang/String;)Lio/ktor/websocket/CloseReason;", StatisticsHelper.PAGE_RELATION_FROM_OTHER, Column.INVAL_VALUE, "equals", "(Ljava/lang/Object;)Z", Column.INVAL_VALUE, "hashCode", "()I", "S", "getCode", "Ljava/lang/String;", "getMessage", "getKnownReason", "()Lio/ktor/websocket/CloseReason$Codes;", "knownReason", "Codes", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CloseReason {
    private final short code;
    private final String message;

    public static /* synthetic */ CloseReason copy$default(CloseReason closeReason, short s, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            s = closeReason.code;
        }
        if ((i & 2) != 0) {
            str = closeReason.message;
        }
        return closeReason.copy(s, str);
    }

    public final short component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final CloseReason copy(short s, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new CloseReason(s, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloseReason) {
            CloseReason closeReason = (CloseReason) obj;
            return this.code == closeReason.code && Intrinsics.areEqual(this.message, closeReason.message);
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
    }

    public CloseReason(short code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = code;
        this.message = message;
    }

    public final short getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes code, String message) {
        this(code.getCode(), message);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final Codes getKnownReason() {
        return Codes.Companion.byCode(this.code);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("CloseReason(reason=");
        Object knownReason = getKnownReason();
        if (knownReason == null) {
            knownReason = Short.valueOf(this.code);
        }
        return append.append(knownReason).append(", message=").append(this.message).append(')').toString();
    }

    /* compiled from: CloseReason.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes;", Column.INVAL_VALUE, Column.INVAL_VALUE, "code", "<init>", "(Ljava/lang/String;IS)V", "S", "getCode", "()S", "Companion", "NORMAL", "GOING_AWAY", "PROTOCOL_ERROR", "CANNOT_ACCEPT", "CLOSED_ABNORMALLY", "NOT_CONSISTENT", "VIOLATED_POLICY", "TOO_BIG", "NO_EXTENSION", "INTERNAL_ERROR", "SERVICE_RESTART", "TRY_AGAIN_LATER", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public enum Codes {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);
        
        public static final Codes UNEXPECTED_CONDITION;
        private static final Map<Short, Codes> byCodeMap;
        private final short code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        public static final Companion Companion = new Companion(null);

        Codes(short code) {
            this.code = code;
        }

        public final short getCode() {
            return this.code;
        }

        static {
            Iterable $this$associateBy$iv = getEntries();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                Codes it = (Codes) element$iv$iv;
                destination$iv$iv.put(Short.valueOf(it.code), element$iv$iv);
            }
            byCodeMap = destination$iv$iv;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        /* compiled from: CloseReason.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u0003¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes$Companion;", Column.INVAL_VALUE, "<init>", "()V", Column.INVAL_VALUE, "code", "Lio/ktor/websocket/CloseReason$Codes;", "byCode", "(S)Lio/ktor/websocket/CloseReason$Codes;", Column.INVAL_VALUE, "byCodeMap", "Ljava/util/Map;", "UNEXPECTED_CONDITION", "Lio/ktor/websocket/CloseReason$Codes;", "getUNEXPECTED_CONDITION$annotations", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Use INTERNAL_ERROR instead.", replaceWith = @ReplaceWith(expression = "INTERNAL_ERROR", imports = {"io.ktor.websocket.CloseReason.Codes.INTERNAL_ERROR"}))
            public static /* synthetic */ void getUNEXPECTED_CONDITION$annotations() {
            }

            private Companion() {
            }

            public final Codes byCode(short code) {
                return (Codes) Codes.byCodeMap.get(Short.valueOf(code));
            }
        }

        public static EnumEntries<Codes> getEntries() {
            return $ENTRIES;
        }
    }
}