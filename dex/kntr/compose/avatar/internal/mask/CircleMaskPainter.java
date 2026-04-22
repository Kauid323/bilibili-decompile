package kntr.compose.avatar.internal.mask;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.DpSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskPainter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017J\u0010\u0010\u000e\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lkntr/compose/avatar/internal/mask/CircleMaskPainter;", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "size", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "painterWithMask", "Landroidx/compose/ui/graphics/painter/Painter;", "contentPainter", "component1", "component1-MYxV2XQ", "()J", "copy", "copy-EaSLcWc", "(J)Lkntr/compose/avatar/internal/mask/CircleMaskPainter;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CircleMaskPainter implements MaskPainter {
    public static final int $stable = 0;
    private final long size;

    public /* synthetic */ CircleMaskPainter(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: component1-MYxV2XQ  reason: not valid java name */
    private final long m2515component1MYxV2XQ() {
        return this.size;
    }

    /* renamed from: copy-EaSLcWc$default  reason: not valid java name */
    public static /* synthetic */ CircleMaskPainter m2516copyEaSLcWc$default(CircleMaskPainter circleMaskPainter, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = circleMaskPainter.size;
        }
        return circleMaskPainter.m2517copyEaSLcWc(j);
    }

    /* renamed from: copy-EaSLcWc  reason: not valid java name */
    public final CircleMaskPainter m2517copyEaSLcWc(long j) {
        return new CircleMaskPainter(j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CircleMaskPainter) && DpSize.equals-impl0(this.size, ((CircleMaskPainter) obj).size);
    }

    public int hashCode() {
        return DpSize.hashCode-impl(this.size);
    }

    public String toString() {
        return "CircleMaskPainter(size=" + DpSize.toString-impl(this.size) + ")";
    }

    private CircleMaskPainter(long size) {
        this.size = size;
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Modifier getModifier() {
        return ClipKt.clip(SizeKt.size-6HolHcs(Modifier.Companion, this.size), RoundedCornerShapeKt.getCircleShape());
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Painter painterWithMask(Painter contentPainter) {
        Intrinsics.checkNotNullParameter(contentPainter, "contentPainter");
        return contentPainter;
    }
}