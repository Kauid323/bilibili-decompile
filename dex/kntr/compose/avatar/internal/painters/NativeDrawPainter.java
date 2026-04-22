package kntr.compose.avatar.internal.painters;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.NativeDrawType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDrawPainter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000eX\u0094\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkntr/compose/avatar/internal/painters/NativeDrawPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "drawType", "Lkntr/compose/avatar/model/common/NativeDrawType;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Lkntr/compose/avatar/model/common/NativeDrawType;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "offset", "Landroidx/compose/ui/geometry/Offset;", "getOffset-F1C5BW0", "()J", "radius", "", "getRadius", "()F", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class NativeDrawPainter extends Painter {
    public static final int $stable = 0;
    private final long color;
    private final NativeDrawType drawType;
    private final long offset;

    /* compiled from: NativeDrawPainter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NativeDrawType.values().length];
            try {
                iArr[NativeDrawType.Invalid.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NativeDrawType.Circle.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NativeDrawType.Rect.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ NativeDrawPainter(NativeDrawType nativeDrawType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeDrawType, j);
    }

    protected abstract DrawStyle getDrawStyle();

    private NativeDrawPainter(NativeDrawType drawType, long color) {
        Intrinsics.checkNotNullParameter(drawType, "drawType");
        this.drawType = drawType;
        this.color = color;
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        this.offset = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
    }

    /* renamed from: getOffset-F1C5BW0  reason: not valid java name */
    protected long mo2520getOffsetF1C5BW0() {
        return this.offset;
    }

    protected float getRadius() {
        int bits$iv$iv$iv = (int) (getIntrinsicSize-NH-jbRc() >> 32);
        return Float.intBitsToFloat(bits$iv$iv$iv) / 2;
    }

    protected final void onDraw(DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[this.drawType.ordinal()]) {
            case 1:
                return;
            case 2:
                long j = this.color;
                int bits$iv$iv$iv = (int) (getIntrinsicSize-NH-jbRc() >> 32);
                DrawScope.-CC.drawCircle-VaOC9Bg$default($this$onDraw, j, Float.intBitsToFloat(bits$iv$iv$iv) / 2, 0L, 0.0f, getDrawStyle(), (ColorFilter) null, 0, (int) ConstantsKt.RESERVATION_CARD_HEIGHT, (Object) null);
                return;
            case 3:
                DrawScope.-CC.drawRect-n-J9OG0$default($this$onDraw, this.color, mo2520getOffsetF1C5BW0(), getIntrinsicSize-NH-jbRc(), 0.0f, getDrawStyle(), (ColorFilter) null, 0, 104, (Object) null);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}