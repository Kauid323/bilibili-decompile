package kntr.common.compose.res;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;

/* compiled from: RefreshAnimatePainter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\f\u0010\u0019\u001a\u00020\u0013*\u00020\u001aH\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkntr/common/compose/res/AnimatePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "painterList", "", "interval", "Lkotlin/time/Duration;", "<init>", "(Ljava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "<set-?>", "", "currentIndex", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex$delegate", "Landroidx/compose/runtime/MutableState;", "startAnimation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "compose-res_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnimatePainter extends Painter {
    public static final int $stable = 8;
    private final MutableState currentIndex$delegate;
    private final long interval;
    private final long intrinsicSize;
    private final List<Painter> painterList;

    public /* synthetic */ AnimatePainter(List list, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j);
    }

    private AnimatePainter(List<? extends Painter> list, long interval) {
        Intrinsics.checkNotNullParameter(list, "painterList");
        this.painterList = list;
        this.interval = interval;
        this.currentIndex$delegate = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        Iterator<T> it = this.painterList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Painter it2 = (Painter) it.next();
        int bits$iv$iv$iv = (int) (it2.getIntrinsicSize-NH-jbRc() >> 32);
        float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
        while (it.hasNext()) {
            Painter it3 = (Painter) it.next();
            int bits$iv$iv$iv2 = (int) (it3.getIntrinsicSize-NH-jbRc() >> 32);
            intBitsToFloat = Math.max(intBitsToFloat, Float.intBitsToFloat(bits$iv$iv$iv2));
        }
        Iterator<T> it4 = this.painterList.iterator();
        if (!it4.hasNext()) {
            throw new NoSuchElementException();
        }
        Painter it5 = (Painter) it4.next();
        float width$iv = intBitsToFloat;
        int bits$iv$iv$iv3 = (int) (it5.getIntrinsicSize-NH-jbRc() & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(bits$iv$iv$iv3);
        while (it4.hasNext()) {
            Painter it6 = (Painter) it4.next();
            int bits$iv$iv$iv4 = (int) (it6.getIntrinsicSize-NH-jbRc() & 4294967295L);
            intBitsToFloat2 = Math.max(intBitsToFloat2, Float.intBitsToFloat(bits$iv$iv$iv4));
        }
        float height$iv = intBitsToFloat2;
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        this.intrinsicSize = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
    }

    private final int getCurrentIndex() {
        State $this$getValue$iv = this.currentIndex$delegate;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    private final void setCurrentIndex(int i) {
        MutableState $this$setValue$iv = this.currentIndex$delegate;
        Object value$iv = Integer.valueOf(i);
        $this$setValue$iv.setValue(value$iv);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startAnimation(Continuation<? super Unit> continuation) {
        AnimatePainter$startAnimation$1 animatePainter$startAnimation$1;
        AnimatePainter animatePainter;
        if (continuation instanceof AnimatePainter$startAnimation$1) {
            animatePainter$startAnimation$1 = (AnimatePainter$startAnimation$1) continuation;
            if ((animatePainter$startAnimation$1.label & Integer.MIN_VALUE) != 0) {
                animatePainter$startAnimation$1.label -= Integer.MIN_VALUE;
                Object $result = animatePainter$startAnimation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (animatePainter$startAnimation$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        animatePainter = this;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        animatePainter = this;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (JobKt.isActive(animatePainter$startAnimation$1.getContext())) {
                    animatePainter.setCurrentIndex((animatePainter.getCurrentIndex() + 1) % animatePainter.painterList.size());
                    long j = animatePainter.interval;
                    animatePainter$startAnimation$1.label = 1;
                    if (DelayKt.delay-VtjQ1oo(j, animatePainter$startAnimation$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        animatePainter$startAnimation$1 = new AnimatePainter$startAnimation$1(this, continuation);
        Object $result2 = animatePainter$startAnimation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (animatePainter$startAnimation$1.label) {
        }
        while (JobKt.isActive(animatePainter$startAnimation$1.getContext())) {
        }
        return Unit.INSTANCE;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m1874getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    protected void onDraw(DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        Painter $this$onDraw_u24lambda_u240 = this.painterList.get(getCurrentIndex());
        $this$onDraw.getDrawContext().getTransform().translate(0.0f, 0.0f);
        try {
            Offset.minus-MK-Hz9U(SizeKt.getCenter-uvyYCjk(m1874getIntrinsicSizeNHjbRc()), SizeKt.getCenter-uvyYCjk($this$onDraw_u24lambda_u240.getIntrinsicSize-NH-jbRc()));
            Painter.draw-x_KDEd0$default($this$onDraw_u24lambda_u240, $this$onDraw, $this$onDraw.getSize-NH-jbRc(), 0.0f, (ColorFilter) null, 6, (Object) null);
        } finally {
            $this$onDraw.getDrawContext().getTransform().translate(-0.0f, -0.0f);
        }
    }
}