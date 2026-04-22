package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/common/share/common/MarkPointContent;", "", "tid", "", "<init>", "(Ljava/lang/String;)V", "getTid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MarkPointContent {
    public static final int $stable = 0;
    private final String tid;

    public MarkPointContent() {
        this(null, 1, null);
    }

    public static /* synthetic */ MarkPointContent copy$default(MarkPointContent markPointContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markPointContent.tid;
        }
        return markPointContent.copy(str);
    }

    public final String component1() {
        return this.tid;
    }

    public final MarkPointContent copy(String str) {
        return new MarkPointContent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MarkPointContent) && Intrinsics.areEqual(this.tid, ((MarkPointContent) obj).tid);
    }

    public int hashCode() {
        if (this.tid == null) {
            return 0;
        }
        return this.tid.hashCode();
    }

    public String toString() {
        return "MarkPointContent(tid=" + this.tid + ")";
    }

    public MarkPointContent(String tid) {
        this.tid = tid;
    }

    public /* synthetic */ MarkPointContent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getTid() {
        return this.tid;
    }
}