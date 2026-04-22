package im.base;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;

/* compiled from: LiveBadge.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0015R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, d2 = {"Lim/base/LiveIconPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "phase", "Landroidx/compose/runtime/MutableIntState;", "lines", "", "Lim/base/LiveLineState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAni", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveIconPainter extends Painter {
    public static final int $stable = 0;
    private final long color;
    private final List<LiveLineState> lines;
    private final MutableIntState phase;

    public /* synthetic */ LiveIconPainter(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private LiveIconPainter(long color) {
        this.color = color;
        this.phase = SnapshotIntStateKt.mutableIntStateOf(0);
        this.lines = CollectionsKt.listOf(new LiveLineState[]{new LiveLineState(this.phase, 0, 0, 0, 8, null), new LiveLineState(this.phase, 1, 10, 0, 8, null), new LiveLineState(this.phase, 2, 15, 0, 8, null)});
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3096getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3097getIntrinsicSizeNHjbRc() {
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    protected void onDraw(DrawScope $this$onDraw) {
        float access$getK$p;
        LiveIconPainter liveIconPainter = this;
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        Iterable $this$forEach$iv = liveIconPainter.lines;
        for (Object element$iv : $this$forEach$iv) {
            LiveLineState line = (LiveLineState) element$iv;
            long j = $this$onDraw.getSize-NH-jbRc();
            float unitSize$iv = Size.getMinDimension-impl(j) / LiveLineState.access$getUnitCount$p(line);
            float unitSize$iv$iv = Size.getMinDimension-impl(j) / LiveLineState.access$getUnitCount$p(line);
            int intValue = ((Number) LiveLineState.access$getParentPhase$p(line).getValue()).intValue() + LiveLineState.access$getPhaseDiff$p(line);
            int access$getFrameCount$p = LiveLineState.access$getFrameCount$p(line);
            int i2 = intValue % access$getFrameCount$p;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            int currentPhase$iv$iv = i2 + (((((-i2) | i2) & (i2 ^ access$getFrameCount$p)) >> 31) & access$getFrameCount$p);
            if (currentPhase$iv$iv < 10) {
                access$getK$p = (LiveLineState.access$getA$p(line) * currentPhase$iv$iv) + 1;
            } else if (currentPhase$iv$iv == 10) {
                access$getK$p = 2.3333f;
            } else {
                access$getK$p = (LiveLineState.access$getK$p(line) * currentPhase$iv$iv) + LiveLineState.access$getB$p(line);
            }
            float currentHeight$iv = access$getK$p * LiveLineState.access$getLineBaseHeightInUnit$p(line) * unitSize$iv$iv;
            float left$iv = ((LiveLineState.access$getLineWidthInUnit$p(line) * 2 * LiveLineState.access$getIndex$p(line)) + LiveLineState.access$getLineStartInUnit$p(line)) * unitSize$iv;
            float width$iv = LiveLineState.access$getLineWidthInUnit$p(line) * unitSize$iv;
            int bits$iv$iv$iv$iv = (int) (j & 4294967295L);
            float bottom$iv = Float.intBitsToFloat(bits$iv$iv$iv$iv) - LiveLineState.access$getLineBottomInUnit$p(line);
            float top$iv = bottom$iv - currentHeight$iv;
            long v1$iv$iv$iv = Float.floatToRawIntBits(left$iv);
            long v2$iv$iv$iv = Float.floatToRawIntBits(top$iv);
            long v1$iv$iv$iv2 = Offset.constructor-impl((v1$iv$iv$iv << 32) | (v2$iv$iv$iv & 4294967295L));
            long v1$iv$iv$iv3 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv$iv2 = Float.floatToRawIntBits(currentHeight$iv);
            Rect rect = RectKt.Rect-tz77jQw(v1$iv$iv$iv2, Size.constructor-impl((v1$iv$iv$iv3 << 32) | (v2$iv$iv$iv2 & 4294967295L)));
            long j2 = liveIconPainter.color;
            long j3 = rect.getTopLeft-F1C5BW0();
            long j4 = rect.getSize-NH-jbRc();
            float x$iv = RangesKt.coerceAtMost(rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop()) / 2;
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(x$iv);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$onDraw, j2, j3, j4, CornerRadius.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), (DrawStyle) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, 0, (int) TbsListener.ErrorCode.TPATCH_VERSION_FAILED, (Object) null);
            liveIconPainter = this;
            $this$forEach$iv = $this$forEach$iv2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startAni(Continuation<? super Unit> continuation) {
        LiveIconPainter$startAni$1 liveIconPainter$startAni$1;
        LiveIconPainter liveIconPainter;
        long j;
        if (continuation instanceof LiveIconPainter$startAni$1) {
            liveIconPainter$startAni$1 = (LiveIconPainter$startAni$1) continuation;
            if ((liveIconPainter$startAni$1.label & Integer.MIN_VALUE) != 0) {
                liveIconPainter$startAni$1.label -= Integer.MIN_VALUE;
                Object $result = liveIconPainter$startAni$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (liveIconPainter$startAni$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        liveIconPainter = this;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        liveIconPainter = this;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (JobKt.isActive(liveIconPainter$startAni$1.getContext())) {
                    MutableIntState mutableIntState = liveIconPainter.phase;
                    mutableIntState.setValue(mutableIntState.getValue().intValue() + 1);
                    j = LiveBadgeKt.frameDuration;
                    liveIconPainter$startAni$1.label = 1;
                    if (DelayKt.delay-VtjQ1oo(j, liveIconPainter$startAni$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        liveIconPainter$startAni$1 = new LiveIconPainter$startAni$1(this, continuation);
        Object $result2 = liveIconPainter$startAni$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (liveIconPainter$startAni$1.label) {
        }
        while (JobKt.isActive(liveIconPainter$startAni$1.getContext())) {
        }
        return Unit.INSTANCE;
    }
}