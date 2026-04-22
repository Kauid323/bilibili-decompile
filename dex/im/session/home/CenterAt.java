package im.session.home;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import im.session.log.LogTagKt;
import io.ktor.http.ContentDisposition;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: QuickLinkBubble.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001d"}, d2 = {"Lim/session/home/CenterAt;", "Landroidx/compose/ui/Alignment;", "center", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "align", "Landroidx/compose/ui/unit/IntOffset;", ContentDisposition.Parameters.Size, "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component1-YbymL2g", "()J", "copy", "copy-ozmzZPI", "(J)Lim/session/home/CenterAt;", "equals", "", "other", "", "hashCode", "", "toString", "", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CenterAt implements Alignment {
    public static final int $stable = 0;
    private final long center;

    public /* synthetic */ CenterAt(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: component1-YbymL2g  reason: not valid java name */
    private final long m3302component1YbymL2g() {
        return this.center;
    }

    /* renamed from: copy-ozmzZPI$default  reason: not valid java name */
    public static /* synthetic */ CenterAt m3303copyozmzZPI$default(CenterAt centerAt, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = centerAt.center;
        }
        return centerAt.m3305copyozmzZPI(j);
    }

    /* renamed from: copy-ozmzZPI  reason: not valid java name */
    public final CenterAt m3305copyozmzZPI(long j) {
        return new CenterAt(j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CenterAt) && IntSize.equals-impl0(this.center, ((CenterAt) obj).center);
    }

    public int hashCode() {
        return IntSize.hashCode-impl(this.center);
    }

    public String toString() {
        return "CenterAt(center=" + IntSize.toString-impl(this.center) + ")";
    }

    private CenterAt(long center) {
        this.center = center;
    }

    /* renamed from: align-KFBX0sM  reason: not valid java name */
    public long m3304alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int $i$f$unpackInt1 = (int) (j >> 32);
        int x$iv = RangesKt.coerceIn(((int) (this.center >> 32)) - (((int) (j >> 32)) / 2), 0, ((int) (j2 >> 32)) - $i$f$unpackInt1);
        int $i$f$unpackInt2 = (int) (this.center & 4294967295L);
        int y$iv = RangesKt.coerceIn($i$f$unpackInt2 - (((int) (j & 4294967295L)) / 2), 0, ((int) (j2 & 4294967295L)) - ((int) (j & 4294967295L)));
        long j3 = IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L));
        ILogger kLog = KLog_androidKt.getKLog();
        String SessionLogTag = LogTagKt.SessionLogTag("UI-QuickLink-bubble");
        String str = IntSize.toString-impl(this.center);
        String str2 = IntSize.toString-impl(j);
        String str3 = IntSize.toString-impl(j2);
        kLog.d(SessionLogTag, "Center " + str + " size " + str2 + " space " + str3 + " offset " + IntOffset.toString-impl(j3));
        return j3;
    }
}