package kntr.compose.avatar.internal.painters;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.NativeDrawType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDrawPainter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u0010X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u0014X\u0094\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkntr/compose/avatar/internal/painters/NativeStrokeDrawPainter;", "Lkntr/compose/avatar/internal/painters/NativeDrawPainter;", "drawType", "Lkntr/compose/avatar/model/common/NativeDrawType;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeSizePx", "", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "<init>", "(Lkntr/compose/avatar/model/common/NativeDrawType;JFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIntrinsicSize-NH-jbRc", "()J", "J", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "offset", "Landroidx/compose/ui/geometry/Offset;", "getOffset-F1C5BW0", "radius", "getRadius", "()F", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NativeStrokeDrawPainter extends NativeDrawPainter {
    public static final int $stable = 0;
    private final Stroke drawStyle;
    private final long intrinsicSize;
    private final long offset;
    private final float radius;

    public /* synthetic */ NativeStrokeDrawPainter(NativeDrawType nativeDrawType, long j, float f, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeDrawType, j, f, j2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private NativeStrokeDrawPainter(NativeDrawType drawType, long color, float strokeSizePx, long intrinsicSize) {
        super(drawType, color, null);
        Intrinsics.checkNotNullParameter(drawType, "drawType");
        this.intrinsicSize = intrinsicSize;
        this.drawStyle = new Stroke(strokeSizePx, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float f = 2;
        float x$iv = strokeSizePx / f;
        float y$iv = strokeSizePx / f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        this.offset = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv = (int) (m2523getIntrinsicSizeNHjbRc() >> 32);
        this.radius = (Float.intBitsToFloat(bits$iv$iv$iv) - strokeSizePx) / f;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m2523getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.compose.avatar.internal.painters.NativeDrawPainter
    public Stroke getDrawStyle() {
        return this.drawStyle;
    }

    @Override // kntr.compose.avatar.internal.painters.NativeDrawPainter
    /* renamed from: getOffset-F1C5BW0 */
    protected long mo2520getOffsetF1C5BW0() {
        return this.offset;
    }

    @Override // kntr.compose.avatar.internal.painters.NativeDrawPainter
    protected float getRadius() {
        return this.radius;
    }
}