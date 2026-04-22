package kntr.compose.avatar.internal.painters;

import androidx.compose.ui.graphics.drawscope.Fill;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.NativeDrawType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDrawPainter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000eX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkntr/compose/avatar/internal/painters/NativeFillDrawPainter;", "Lkntr/compose/avatar/internal/painters/NativeDrawPainter;", "drawType", "Lkntr/compose/avatar/model/common/NativeDrawType;", "color", "Landroidx/compose/ui/graphics/Color;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "<init>", "(Lkntr/compose/avatar/model/common/NativeDrawType;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIntrinsicSize-NH-jbRc", "()J", "J", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/Fill;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/Fill;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NativeFillDrawPainter extends NativeDrawPainter {
    public static final int $stable = 0;
    private final Fill drawStyle;
    private final long intrinsicSize;

    public /* synthetic */ NativeFillDrawPainter(NativeDrawType nativeDrawType, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeDrawType, j, j2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private NativeFillDrawPainter(NativeDrawType drawType, long color, long intrinsicSize) {
        super(drawType, color, null);
        Intrinsics.checkNotNullParameter(drawType, "drawType");
        this.intrinsicSize = intrinsicSize;
        this.drawStyle = Fill.INSTANCE;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m2521getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.compose.avatar.internal.painters.NativeDrawPainter
    public Fill getDrawStyle() {
        return this.drawStyle;
    }
}