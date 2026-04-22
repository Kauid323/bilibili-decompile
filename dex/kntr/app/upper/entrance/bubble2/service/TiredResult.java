package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BubbleTiredService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/TiredResult;", "", "type", "Lkntr/app/upper/entrance/bubble2/service/TiredType2;", "msg", "", "<init>", "(Lkntr/app/upper/entrance/bubble2/service/TiredType2;Ljava/lang/String;)V", "getType", "()Lkntr/app/upper/entrance/bubble2/service/TiredType2;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TiredResult {
    private final String msg;
    private final TiredType2 type;

    public static /* synthetic */ TiredResult copy$default(TiredResult tiredResult, TiredType2 tiredType2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            tiredType2 = tiredResult.type;
        }
        if ((i & 2) != 0) {
            str = tiredResult.msg;
        }
        return tiredResult.copy(tiredType2, str);
    }

    public final TiredType2 component1() {
        return this.type;
    }

    public final String component2() {
        return this.msg;
    }

    public final TiredResult copy(TiredType2 tiredType2, String str) {
        Intrinsics.checkNotNullParameter(tiredType2, "type");
        Intrinsics.checkNotNullParameter(str, "msg");
        return new TiredResult(tiredType2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TiredResult) {
            TiredResult tiredResult = (TiredResult) obj;
            return this.type == tiredResult.type && Intrinsics.areEqual(this.msg, tiredResult.msg);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.msg.hashCode();
    }

    public String toString() {
        TiredType2 tiredType2 = this.type;
        return "TiredResult(type=" + tiredType2 + ", msg=" + this.msg + ")";
    }

    public TiredResult(TiredType2 type, String msg) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.type = type;
        this.msg = msg;
    }

    public final TiredType2 getType() {
        return this.type;
    }

    public final String getMsg() {
        return this.msg;
    }
}