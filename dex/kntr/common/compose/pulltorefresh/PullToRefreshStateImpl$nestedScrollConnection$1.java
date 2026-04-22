package kntr.common.compose.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PullToRefreshState.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"kntr/common/compose/pulltorefresh/PullToRefreshStateImpl$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "dragUp", "(J)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "dragDown", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-pulltorefresh_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PullToRefreshStateImpl$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ float $dragMultiplier;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PullToRefreshStateImpl$nestedScrollConnection$1(boolean $enabled, PullToRefreshStateImpl $receiver, float $dragMultiplier) {
        this.$enabled = $enabled;
        this.this$0 = $receiver;
        this.$dragMultiplier = $dragMultiplier;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1872onPreScrollOzD1aCk(long j, int i) {
        if (this.$enabled) {
            if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getDrag-WNlRxjI())) {
                int bits$iv$iv$iv = (int) (4294967295L & j);
                if (Float.intBitsToFloat(bits$iv$iv$iv) < 0.0f) {
                    return dragUp(j);
                }
            }
            return Offset.Companion.getZero-F1C5BW0();
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    private final long dragUp(long available) {
        this.this$0.set_isPullInProgress(true);
        int bits$iv$iv$iv = (int) (available & 4294967295L);
        float newOffset = RangesKt.coerceAtLeast((Float.intBitsToFloat(bits$iv$iv$iv) * this.$dragMultiplier) + this.this$0.getContentOffset(), 0.0f);
        float dragConsumed = newOffset - this.this$0.getContentOffset();
        if (Math.abs(dragConsumed) >= 0.5f) {
            BuildersKt.launch$default(this.this$0.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshStateImpl$nestedScrollConnection$1$dragUp$1(this.this$0, dragConsumed, null), 3, (Object) null);
            int bits$iv$iv$iv2 = (int) (available & 4294967295L);
            float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
            long v1$iv$iv = Float.floatToRawIntBits(0.0f);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1870onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.$enabled) {
            if (!this.this$0.isRefreshing() || this.this$0.getContentOffset() < this.this$0.getRefreshingOffsetPx()) {
                if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getDrag-WNlRxjI())) {
                    int bits$iv$iv$iv = (int) (4294967295L & j2);
                    if (Float.intBitsToFloat(bits$iv$iv$iv) > 0.0f) {
                        return dragDown(j2);
                    }
                }
                return Offset.Companion.getZero-F1C5BW0();
            }
            return Offset.Companion.getZero-F1C5BW0();
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    private final long dragDown(long available) {
        this.this$0.set_isPullInProgress(true);
        BuildersKt.launch$default(this.this$0.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1(this.this$0, available, this.$dragMultiplier, null), 3, (Object) null);
        int bits$iv$iv$iv = (int) (available & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1871onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1;
        Animatable animatable;
        if (continuation instanceof PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) {
            pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 = (PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) continuation;
            if ((pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                Object $result = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.this$0.isRefreshing() && this.this$0.getContentOffset() >= this.this$0.getRefreshTriggerDistancePx()) {
                            this.this$0.startRefresh();
                        }
                        this.this$0.set_isPullInProgress(false);
                        if (Velocity.getY-impl(j) < (-this.this$0.getRefreshingOffsetPx()) && this.this$0.getContentOffset() > 0.0f && this.this$0.isRefreshing()) {
                            KLog_androidKt.getKLog().d("refresh", "enter onPreFling " + Velocity.toString-impl(j));
                            animatable = this.this$0._contentOffset;
                            Float boxFloat = Boxing.boxFloat(0.0f);
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.J$0 = j;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label = 1;
                            if (animatable.snapTo(boxFloat, pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        j = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.box-impl(this.this$0.getContentOffset() < this.this$0.getRefreshingOffsetPx() ? j : Velocity.Companion.getZero-9UxMQ8M());
            }
        }
        pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 = new PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1(this, continuation);
        Object $result2 = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label) {
        }
        return Velocity.box-impl(this.this$0.getContentOffset() < this.this$0.getRefreshingOffsetPx() ? j : Velocity.Companion.getZero-9UxMQ8M());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fe  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1869onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1 pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1;
        PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1 pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12;
        Animatable animatable;
        float offset;
        float offset2;
        Animatable animatable2;
        long j3 = j;
        long j4 = j2;
        if (continuation instanceof PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1) {
            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1 = (PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1;
                Object $result = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (this.this$0.isPullInProgress() || Velocity.getY-impl(j2) <= 1000.0f) {
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0 = j3;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1 = j4;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.label = 3;
                            $result = NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j, j2, pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12);
                            return $result == coroutine_suspended ? coroutine_suspended : $result;
                        }
                        KLog_androidKt.getKLog().d("refresh", "onPostFling " + Velocity.toString-impl(j2));
                        float availableOffset = this.this$0.isRefreshing() ? (Velocity.getY-impl(j2) / 30) + this.this$0.getContentOffset() : Velocity.getY-impl(j2) / 100;
                        float offset3 = Math.min(availableOffset, this.this$0.getRefreshingOffsetPx());
                        animatable = this.this$0._contentOffset;
                        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0 = j3;
                        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1 = j4;
                        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$0 = availableOffset;
                        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$1 = offset3;
                        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.label = 1;
                        if (Animatable.animateTo$default(animatable, Boxing.boxFloat(offset3), new SpringSpec(0.0f, 10000.0f, (Object) null, 5, (DefaultConstructorMarker) null), (Object) null, (Function1) null, pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12, 12, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        offset = availableOffset;
                        offset2 = offset3;
                        if (!this.this$0.isRefreshing()) {
                            animatable2 = this.this$0._contentOffset;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0 = j3;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1 = j4;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$0 = offset;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$1 = offset2;
                            pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.label = 2;
                            if (Animatable.animateTo$default(animatable2, Boxing.boxFloat(0.0f), new SpringSpec(0.0f, 400.0f, (Object) null, 5, (DefaultConstructorMarker) null), (Object) null, (Function1) null, pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12, 12, (Object) null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Velocity.box-impl(j4);
                    case 1:
                        offset2 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$1;
                        offset = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$0;
                        j4 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1;
                        j3 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                        if (!this.this$0.isRefreshing()) {
                        }
                        return Velocity.box-impl(j4);
                    case 2:
                        long j5 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$1;
                        float f = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.F$0;
                        j4 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1;
                        long j6 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                        return Velocity.box-impl(j4);
                    case 3:
                        long j7 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$1;
                        long j8 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1 = new PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1(this, continuation);
        pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1;
        Object $result2 = pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$12.label) {
        }
    }
}