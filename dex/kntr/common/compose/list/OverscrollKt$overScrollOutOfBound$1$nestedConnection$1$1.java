package kntr.common.compose.list;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0019H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0019H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"kntr/common/compose/list/OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "visibilityThreshold", "", "getVisibilityThreshold", "()F", "lastFlingAnimator", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getLastFlingAnimator", "()Landroidx/compose/animation/core/Animatable;", "setLastFlingAnimator", "(Landroidx/compose/animation/core/Animatable;)V", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAnimatorIfRunning", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-list_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 implements NestedScrollConnection {
    final /* synthetic */ NestedScrollDispatcher $dispatcher;
    final /* synthetic */ State<Boolean> $isVertical$delegate;
    final /* synthetic */ State<Boolean> $nestedScrollToParent$delegate;
    final /* synthetic */ MutableFloatState $offset$delegate;
    final /* synthetic */ MutableFloatState $onScrollEasingSlowDownRate$delegate;
    final /* synthetic */ MutableState<Boolean> $remainingPostFlingHasReachedPeak$delegate;
    final /* synthetic */ MutableState<Float> $remainingPostFlingOffset$delegate;
    final /* synthetic */ MutableState<Float> $remainingPostFlingVelocity$delegate;
    final /* synthetic */ State<Function2<Float, Float, Float>> $scrollEasing$delegate;
    final /* synthetic */ State<Float> $springDamp$delegate;
    final /* synthetic */ State<Float> $springStiff$delegate;
    private Animatable<Float, AnimationVector1D> lastFlingAnimator;
    private final float visibilityThreshold = 0.5f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1(NestedScrollDispatcher $dispatcher, State<Boolean> state, State<Boolean> state2, MutableFloatState $offset$delegate, State<? extends Function2<? super Float, ? super Float, Float>> state3, MutableFloatState $onScrollEasingSlowDownRate$delegate, MutableState<Float> mutableState, MutableState<Float> mutableState2, MutableState<Boolean> mutableState3, State<Float> state4, State<Float> state5) {
        this.$dispatcher = $dispatcher;
        this.$nestedScrollToParent$delegate = state;
        this.$isVertical$delegate = state2;
        this.$offset$delegate = $offset$delegate;
        this.$scrollEasing$delegate = state3;
        this.$onScrollEasingSlowDownRate$delegate = $onScrollEasingSlowDownRate$delegate;
        this.$remainingPostFlingVelocity$delegate = mutableState;
        this.$remainingPostFlingOffset$delegate = mutableState2;
        this.$remainingPostFlingHasReachedPeak$delegate = mutableState3;
        this.$springDamp$delegate = state4;
        this.$springStiff$delegate = state5;
    }

    public final float getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public final Animatable<Float, AnimationVector1D> getLastFlingAnimator() {
        return this.lastFlingAnimator;
    }

    public final void setLastFlingAnimator(Animatable<Float, AnimationVector1D> animatable) {
        this.lastFlingAnimator = animatable;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1864onPreScrollOzD1aCk(long j, int i) {
        boolean overScrollOutOfBound$lambda$0$0;
        long realAvailable;
        boolean overScrollOutOfBound$lambda$0$4;
        float intBitsToFloat;
        float overScrollOutOfBound$lambda$0$11;
        float overScrollOutOfBound$lambda$0$112;
        Function2 overScrollOutOfBound$lambda$0$1;
        float overScrollOutOfBound$lambda$0$113;
        float overScrollOutOfBound$lambda$0$114;
        float overScrollOutOfBound$lambda$0$115;
        boolean overScrollOutOfBound$lambda$0$42;
        boolean overScrollOutOfBound$lambda$0$43;
        if (!NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            return this.$dispatcher.dispatchPreScroll-OzD1aCk(j, i);
        }
        Animatable<Float, AnimationVector1D> animatable = this.lastFlingAnimator;
        if (animatable != null && animatable.isRunning()) {
            BuildersKt.launch$default(this.$dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1(this, null), 3, (Object) null);
        }
        overScrollOutOfBound$lambda$0$0 = OverscrollKt.overScrollOutOfBound$lambda$0$0(this.$nestedScrollToParent$delegate);
        if (overScrollOutOfBound$lambda$0$0) {
            realAvailable = Offset.minus-MK-Hz9U(j, this.$dispatcher.dispatchPreScroll-OzD1aCk(j, i));
        } else {
            realAvailable = j;
        }
        overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
        if (overScrollOutOfBound$lambda$0$4) {
            int bits$iv$iv$iv = (int) (realAvailable & 4294967295L);
            intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
        } else {
            int bits$iv$iv$iv2 = (int) (realAvailable >> 32);
            intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv2);
        }
        float realOffset = intBitsToFloat;
        float signum = Math.signum(realOffset);
        overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
        boolean isSameDirection = signum == Math.signum(overScrollOutOfBound$lambda$0$11);
        overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
        if (Math.abs(overScrollOutOfBound$lambda$0$112) > this.visibilityThreshold && !isSameDirection) {
            overScrollOutOfBound$lambda$0$1 = OverscrollKt.overScrollOutOfBound$lambda$0$1(this.$scrollEasing$delegate);
            overScrollOutOfBound$lambda$0$113 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
            float offsetAtLast = ((Number) overScrollOutOfBound$lambda$0$1.invoke(Float.valueOf(overScrollOutOfBound$lambda$0$113), Float.valueOf(realOffset))).floatValue();
            overScrollOutOfBound$lambda$0$114 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
            if (Math.signum(overScrollOutOfBound$lambda$0$114) == Math.signum(offsetAtLast)) {
                MutableFloatState mutableFloatState = this.$onScrollEasingSlowDownRate$delegate;
                overScrollOutOfBound$lambda$0$115 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                mutableFloatState.setFloatValue((offsetAtLast - overScrollOutOfBound$lambda$0$115) / realOffset);
                this.$offset$delegate.setFloatValue(offsetAtLast);
                overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                if (overScrollOutOfBound$lambda$0$42) {
                    int bits$iv$iv$iv3 = (int) (j >> 32);
                    int bits$iv$iv$iv4 = (int) (realAvailable >> 32);
                    float x$iv = Float.intBitsToFloat(bits$iv$iv$iv3) - Float.intBitsToFloat(bits$iv$iv$iv4);
                    int bits$iv$iv$iv5 = (int) (j & 4294967295L);
                    float y$iv = Float.intBitsToFloat(bits$iv$iv$iv5);
                    long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                    return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                }
                int bits$iv$iv$iv6 = (int) (j >> 32);
                float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv6);
                int bits$iv$iv$iv7 = (int) (j & 4294967295L);
                int bits$iv$iv$iv8 = (int) (realAvailable & 4294967295L);
                float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv7) - Float.intBitsToFloat(bits$iv$iv$iv8);
                long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
                long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
                return Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2));
            }
            this.$offset$delegate.setFloatValue(0.0f);
            this.$onScrollEasingSlowDownRate$delegate.setFloatValue(1.0f);
            overScrollOutOfBound$lambda$0$43 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
            if (overScrollOutOfBound$lambda$0$43) {
                int bits$iv$iv$iv9 = (int) (j >> 32);
                int bits$iv$iv$iv10 = (int) (realAvailable >> 32);
                float x$iv3 = Float.intBitsToFloat(bits$iv$iv$iv9) - Float.intBitsToFloat(bits$iv$iv$iv10);
                int bits$iv$iv$iv11 = (int) (j & 4294967295L);
                int bits$iv$iv$iv12 = (int) (realAvailable & 4294967295L);
                float y$iv3 = (Float.intBitsToFloat(bits$iv$iv$iv11) - Float.intBitsToFloat(bits$iv$iv$iv12)) + realOffset;
                long v1$iv$iv3 = Float.floatToRawIntBits(x$iv3);
                long v2$iv$iv3 = Float.floatToRawIntBits(y$iv3);
                return Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
            }
            int bits$iv$iv$iv13 = (int) (j >> 32);
            int bits$iv$iv$iv14 = (int) (realAvailable >> 32);
            float x$iv4 = (Float.intBitsToFloat(bits$iv$iv$iv13) - Float.intBitsToFloat(bits$iv$iv$iv14)) + realOffset;
            int bits$iv$iv$iv15 = (int) (j & 4294967295L);
            int bits$iv$iv$iv16 = (int) (realAvailable & 4294967295L);
            float y$iv4 = Float.intBitsToFloat(bits$iv$iv$iv15) - Float.intBitsToFloat(bits$iv$iv$iv16);
            long v1$iv$iv4 = Float.floatToRawIntBits(x$iv4);
            long v2$iv$iv4 = Float.floatToRawIntBits(y$iv4);
            return Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L));
        }
        return Offset.minus-MK-Hz9U(j, realAvailable);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1862onPostScrollDzOQY0M(long j, long j2, int i) {
        boolean overScrollOutOfBound$lambda$0$0;
        boolean overScrollOutOfBound$lambda$0$4;
        float intBitsToFloat;
        Function2 overScrollOutOfBound$lambda$0$1;
        float overScrollOutOfBound$lambda$0$11;
        float overScrollOutOfBound$lambda$0$112;
        boolean overScrollOutOfBound$lambda$0$42;
        if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            overScrollOutOfBound$lambda$0$0 = OverscrollKt.overScrollOutOfBound$lambda$0$0(this.$nestedScrollToParent$delegate);
            long realAvailable = overScrollOutOfBound$lambda$0$0 ? Offset.minus-MK-Hz9U(j2, this.$dispatcher.dispatchPostScroll-DzOQY0M(j, j2, i)) : j2;
            overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
            if (overScrollOutOfBound$lambda$0$4) {
                int bits$iv$iv$iv = (int) (realAvailable & 4294967295L);
                intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
            } else {
                int bits$iv$iv$iv2 = (int) (realAvailable >> 32);
                intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv2);
            }
            float realOffset = intBitsToFloat;
            overScrollOutOfBound$lambda$0$1 = OverscrollKt.overScrollOutOfBound$lambda$0$1(this.$scrollEasing$delegate);
            overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
            float targetOffset = ((Number) overScrollOutOfBound$lambda$0$1.invoke(Float.valueOf(overScrollOutOfBound$lambda$0$11), Float.valueOf(realOffset))).floatValue();
            MutableFloatState mutableFloatState = this.$onScrollEasingSlowDownRate$delegate;
            overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
            mutableFloatState.setFloatValue((targetOffset - overScrollOutOfBound$lambda$0$112) / realOffset);
            this.$offset$delegate.setFloatValue(targetOffset);
            overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
            if (overScrollOutOfBound$lambda$0$42) {
                int bits$iv$iv$iv3 = (int) (j2 >> 32);
                int bits$iv$iv$iv4 = (int) (realAvailable >> 32);
                float x$iv = Float.intBitsToFloat(bits$iv$iv$iv3) - Float.intBitsToFloat(bits$iv$iv$iv4);
                int bits$iv$iv$iv5 = (int) (j2 & 4294967295L);
                float y$iv = Float.intBitsToFloat(bits$iv$iv$iv5);
                long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
            }
            int bits$iv$iv$iv6 = (int) (j2 >> 32);
            float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv6);
            int bits$iv$iv$iv7 = (int) (j2 & 4294967295L);
            int bits$iv$iv$iv8 = (int) (realAvailable & 4294967295L);
            float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv7) - Float.intBitsToFloat(bits$iv$iv$iv8);
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            return Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2));
        }
        return this.$dispatcher.dispatchPreScroll-OzD1aCk(j2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f7  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1863onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        Continuation<? super Unit> overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1;
        long j2;
        boolean overScrollOutOfBound$lambda$0$0;
        long j3;
        long j4;
        Object obj;
        long parentConsumed;
        Ref.FloatRef leftVelocity;
        boolean overScrollOutOfBound$lambda$0$4;
        float overScrollOutOfBound$lambda$0$8;
        float overScrollOutOfBound$lambda$0$11;
        Ref.FloatRef leftVelocity2;
        float overScrollOutOfBound$lambda$0$112;
        float overScrollOutOfBound$lambda$0$113;
        long j5;
        Ref.FloatRef leftVelocity3;
        float overScrollOutOfBound$lambda$0$3;
        float overScrollOutOfBound$lambda$0$2;
        Object animateTo;
        Ref.FloatRef floatRef;
        long j6;
        long parentConsumed2;
        long realAvailable;
        float overScrollOutOfBound$lambda$0$82;
        float overScrollOutOfBound$lambda$0$114;
        float f;
        boolean overScrollOutOfBound$lambda$0$42;
        AnimationResult animationResult;
        AnimationState endState;
        if (continuation instanceof OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1) {
            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1 = (OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1) continuation;
            if ((overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label -= Integer.MIN_VALUE;
                Object $result = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        OverscrollKt.overScrollOutOfBound$lambda$0$15(this.$remainingPostFlingVelocity$delegate, 0.0f);
                        OverscrollKt.overScrollOutOfBound$lambda$0$18(this.$remainingPostFlingOffset$delegate, 0.0f);
                        OverscrollKt.overScrollOutOfBound$lambda$0$21(this.$remainingPostFlingHasReachedPeak$delegate, false);
                        j2 = j;
                        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0 = j2;
                        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label = 1;
                        if (stopAnimatorIfRunning(overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        j2 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        j2 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        long j7 = j2;
                        j3 = ((Velocity) obj).unbox-impl();
                        j4 = j7;
                        parentConsumed = j3;
                        long realAvailable2 = Velocity.minus-AH228Gc(j4, parentConsumed);
                        leftVelocity = new Ref.FloatRef();
                        overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                        leftVelocity.element = overScrollOutOfBound$lambda$0$4 ? Velocity.getY-impl(realAvailable2) : Velocity.getX-impl(realAvailable2);
                        overScrollOutOfBound$lambda$0$8 = OverscrollKt.overScrollOutOfBound$lambda$0$8(this.$onScrollEasingSlowDownRate$delegate);
                        if (!Float.isNaN(overScrollOutOfBound$lambda$0$8)) {
                            float f2 = leftVelocity.element;
                            overScrollOutOfBound$lambda$0$82 = OverscrollKt.overScrollOutOfBound$lambda$0$8(this.$onScrollEasingSlowDownRate$delegate);
                            leftVelocity.element = f2 * overScrollOutOfBound$lambda$0$82;
                            overScrollOutOfBound$lambda$0$114 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                            if (!(overScrollOutOfBound$lambda$0$114 == 0.0f)) {
                                leftVelocity.element *= 0.5f;
                            }
                        }
                        overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                        if (Math.abs(overScrollOutOfBound$lambda$0$11) >= this.visibilityThreshold) {
                            float signum = Math.signum(leftVelocity.element);
                            overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                            if (!(signum == Math.signum(overScrollOutOfBound$lambda$0$112))) {
                                overScrollOutOfBound$lambda$0$113 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                                Animatable $this$onPreFling_QWom1Mo_u24lambda_u240 = AnimatableKt.Animatable$default(overScrollOutOfBound$lambda$0$113, 0.0f, 2, (Object) null);
                                if (leftVelocity.element < 0.0f) {
                                    Animatable.updateBounds$default($this$onPreFling_QWom1Mo_u24lambda_u240, Boxing.boxFloat(0.0f), (Object) null, 2, (Object) null);
                                } else if (leftVelocity.element > 0.0f) {
                                    Animatable.updateBounds$default($this$onPreFling_QWom1Mo_u24lambda_u240, (Object) null, Boxing.boxFloat(0.0f), 1, (Object) null);
                                }
                                this.lastFlingAnimator = $this$onPreFling_QWom1Mo_u24lambda_u240;
                                Animatable<Float, AnimationVector1D> animatable = this.lastFlingAnimator;
                                if (animatable == null) {
                                    j5 = j4;
                                    leftVelocity3 = leftVelocity;
                                    floatRef = leftVelocity;
                                    leftVelocity2 = leftVelocity3;
                                    f = 0.0f;
                                    j4 = j5;
                                    floatRef.element = f;
                                    overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                                    return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                                }
                                Float boxFloat = Boxing.boxFloat(0.0f);
                                overScrollOutOfBound$lambda$0$3 = OverscrollKt.overScrollOutOfBound$lambda$0$3(this.$springDamp$delegate);
                                overScrollOutOfBound$lambda$0$2 = OverscrollKt.overScrollOutOfBound$lambda$0$2(this.$springStiff$delegate);
                                Float boxFloat2 = Boxing.boxFloat(leftVelocity.element);
                                final State<Function2<Float, Float, Float>> state = this.$scrollEasing$delegate;
                                final MutableFloatState mutableFloatState = this.$offset$delegate;
                                Function1 function1 = new Function1() { // from class: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj2) {
                                        Unit onPreFling_QWom1Mo$lambda$1;
                                        onPreFling_QWom1Mo$lambda$1 = OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.onPreFling_QWom1Mo$lambda$1(state, mutableFloatState, (Animatable) obj2);
                                        return onPreFling_QWom1Mo$lambda$1;
                                    }
                                };
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.L$0 = leftVelocity;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.L$1 = leftVelocity;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0 = j4;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$1 = parentConsumed;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$2 = realAvailable2;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label = 3;
                                animateTo = animatable.animateTo(boxFloat, AnimationSpecKt.spring(overScrollOutOfBound$lambda$0$3, overScrollOutOfBound$lambda$0$2, Boxing.boxFloat(this.visibilityThreshold)), boxFloat2, function1, overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1);
                                if (animateTo == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                floatRef = leftVelocity;
                                j6 = j4;
                                parentConsumed2 = parentConsumed;
                                realAvailable = realAvailable2;
                                leftVelocity3 = floatRef;
                                animationResult = (AnimationResult) animateTo;
                                if (animationResult == null && (endState = animationResult.getEndState()) != null) {
                                    f = ((Number) endState.getVelocity()).floatValue();
                                    parentConsumed = parentConsumed2;
                                    leftVelocity2 = leftVelocity3;
                                    j4 = j6;
                                    floatRef.element = f;
                                    overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                                    return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                                }
                                parentConsumed = parentConsumed2;
                                j5 = j6;
                                leftVelocity = floatRef;
                                floatRef = leftVelocity;
                                leftVelocity2 = leftVelocity3;
                                f = 0.0f;
                                j4 = j5;
                                floatRef.element = f;
                                overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                                return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                            }
                        }
                        leftVelocity2 = leftVelocity;
                        overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                        return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                    case 3:
                        realAvailable = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$2;
                        parentConsumed2 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$1;
                        j6 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0;
                        floatRef = (Ref.FloatRef) overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.L$1;
                        leftVelocity3 = (Ref.FloatRef) overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        animateTo = $result;
                        animationResult = (AnimationResult) animateTo;
                        if (animationResult == null) {
                            break;
                        }
                        parentConsumed = parentConsumed2;
                        j5 = j6;
                        leftVelocity = floatRef;
                        floatRef = leftVelocity;
                        leftVelocity2 = leftVelocity3;
                        f = 0.0f;
                        j4 = j5;
                        floatRef.element = f;
                        overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                        return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                overScrollOutOfBound$lambda$0$0 = OverscrollKt.overScrollOutOfBound$lambda$0$0(this.$nestedScrollToParent$delegate);
                if (overScrollOutOfBound$lambda$0$0) {
                    long j8 = j2;
                    j3 = Velocity.Companion.getZero-9UxMQ8M();
                    j4 = j8;
                    parentConsumed = j3;
                    long realAvailable22 = Velocity.minus-AH228Gc(j4, parentConsumed);
                    leftVelocity = new Ref.FloatRef();
                    overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                    leftVelocity.element = overScrollOutOfBound$lambda$0$4 ? Velocity.getY-impl(realAvailable22) : Velocity.getX-impl(realAvailable22);
                    overScrollOutOfBound$lambda$0$8 = OverscrollKt.overScrollOutOfBound$lambda$0$8(this.$onScrollEasingSlowDownRate$delegate);
                    if (!Float.isNaN(overScrollOutOfBound$lambda$0$8)) {
                    }
                    overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                    if (Math.abs(overScrollOutOfBound$lambda$0$11) >= this.visibilityThreshold) {
                    }
                    leftVelocity2 = leftVelocity;
                    overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                    return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
                }
                NestedScrollDispatcher nestedScrollDispatcher = this.$dispatcher;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.J$0 = j2;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label = 2;
                obj = nestedScrollDispatcher.dispatchPreFling-QWom1Mo(j2, overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long j72 = j2;
                j3 = ((Velocity) obj).unbox-impl();
                j4 = j72;
                parentConsumed = j3;
                long realAvailable222 = Velocity.minus-AH228Gc(j4, parentConsumed);
                leftVelocity = new Ref.FloatRef();
                overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                leftVelocity.element = overScrollOutOfBound$lambda$0$4 ? Velocity.getY-impl(realAvailable222) : Velocity.getX-impl(realAvailable222);
                overScrollOutOfBound$lambda$0$8 = OverscrollKt.overScrollOutOfBound$lambda$0$8(this.$onScrollEasingSlowDownRate$delegate);
                if (!Float.isNaN(overScrollOutOfBound$lambda$0$8)) {
                }
                overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                if (Math.abs(overScrollOutOfBound$lambda$0$11) >= this.visibilityThreshold) {
                }
                leftVelocity2 = leftVelocity;
                overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                return Velocity.box-impl(overScrollOutOfBound$lambda$0$42 ? VelocityKt.Velocity(Velocity.getX-impl(parentConsumed), Velocity.getY-impl(j4) - leftVelocity2.element) : VelocityKt.Velocity(Velocity.getX-impl(j4) - leftVelocity2.element, Velocity.getY-impl(parentConsumed)));
            }
        }
        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1 = new OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1(this, continuation);
        Object $result2 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1.label) {
        }
        overScrollOutOfBound$lambda$0$0 = OverscrollKt.overScrollOutOfBound$lambda$0$0(this.$nestedScrollToParent$delegate);
        if (overScrollOutOfBound$lambda$0$0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPreFling_QWom1Mo$lambda$1(State $scrollEasing$delegate, MutableFloatState $offset$delegate, Animatable $this$animateTo) {
        Function2 overScrollOutOfBound$lambda$0$1;
        float overScrollOutOfBound$lambda$0$11;
        float overScrollOutOfBound$lambda$0$112;
        Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
        overScrollOutOfBound$lambda$0$1 = OverscrollKt.overScrollOutOfBound$lambda$0$1($scrollEasing$delegate);
        overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11($offset$delegate);
        Float valueOf = Float.valueOf(overScrollOutOfBound$lambda$0$11);
        float floatValue = ((Number) $this$animateTo.getValue()).floatValue();
        overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11($offset$delegate);
        $offset$delegate.setFloatValue(((Number) overScrollOutOfBound$lambda$0$1.invoke(valueOf, Float.valueOf(floatValue - overScrollOutOfBound$lambda$0$112))).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0175  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1861onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1;
        OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12;
        boolean overScrollOutOfBound$lambda$0$0;
        long j3;
        long j4;
        Object obj;
        long realAvailable;
        long j5;
        long realAvailable2;
        float overScrollOutOfBound$lambda$0$11;
        Animatable<Float, AnimationVector1D> animatable;
        long j6;
        float overScrollOutOfBound$lambda$0$3;
        float overScrollOutOfBound$lambda$0$2;
        boolean overScrollOutOfBound$lambda$0$4;
        Ref.FloatRef lastVelocity;
        long j7;
        long j8;
        Ref.FloatRef lastDelta;
        long realAvailable3;
        boolean overScrollOutOfBound$lambda$0$42;
        long Velocity;
        long j9 = j2;
        if (continuation instanceof OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1) {
            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1 = (OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1) continuation;
            if ((overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1.label -= Integer.MIN_VALUE;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1;
                Object $result = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        overScrollOutOfBound$lambda$0$0 = OverscrollKt.overScrollOutOfBound$lambda$0$0(this.$nestedScrollToParent$delegate);
                        if (overScrollOutOfBound$lambda$0$0) {
                            NestedScrollDispatcher nestedScrollDispatcher = this.$dispatcher;
                            j3 = j;
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$0 = j3;
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$1 = j9;
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$2 = j9;
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.label = 1;
                            Object obj2 = nestedScrollDispatcher.dispatchPostFling-RZ2iAVY(j, j2, overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                            realAvailable = j9;
                            j5 = realAvailable;
                            j4 = Velocity.minus-AH228Gc(realAvailable, ((Velocity) obj).unbox-impl());
                            j9 = j5;
                            break;
                        } else {
                            j3 = j;
                            j4 = j9;
                            break;
                        }
                    case 1:
                        realAvailable = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$2;
                        j5 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$1;
                        long j10 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                        j3 = j10;
                        obj = $result;
                        j4 = Velocity.minus-AH228Gc(realAvailable, ((Velocity) obj).unbox-impl());
                        j9 = j5;
                        break;
                    case 2:
                        realAvailable3 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$2;
                        j7 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$1;
                        j8 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$0;
                        lastVelocity = (Ref.FloatRef) overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.L$1;
                        lastDelta = (Ref.FloatRef) overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.L$0;
                        ResultKt.throwOnFailure($result);
                        AnimationResult animationResult = (AnimationResult) $result;
                        realAvailable2 = realAvailable3;
                        j6 = j7;
                        OverscrollKt.overScrollOutOfBound$lambda$0$15(this.$remainingPostFlingVelocity$delegate, 0.0f);
                        OverscrollKt.overScrollOutOfBound$lambda$0$18(this.$remainingPostFlingOffset$delegate, 0.0f);
                        OverscrollKt.overScrollOutOfBound$lambda$0$21(this.$remainingPostFlingHasReachedPeak$delegate, false);
                        overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                        if (overScrollOutOfBound$lambda$0$42) {
                            Velocity = VelocityKt.Velocity(Velocity.getX-impl(j6) - Velocity.getX-impl(realAvailable2), Velocity.getY-impl(j6));
                        } else {
                            Velocity = VelocityKt.Velocity(Velocity.getX-impl(j6), Velocity.getY-impl(j6) - Velocity.getY-impl(realAvailable2));
                        }
                        return Velocity.box-impl(Velocity);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                realAvailable2 = j4;
                overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                this.lastFlingAnimator = AnimatableKt.Animatable$default(overScrollOutOfBound$lambda$0$11, 0.0f, 2, (Object) null);
                final Ref.FloatRef lastDelta2 = new Ref.FloatRef();
                final Ref.FloatRef lastVelocity2 = new Ref.FloatRef();
                lastVelocity2.element = Velocity.getY-impl(realAvailable2);
                animatable = this.lastFlingAnimator;
                if (animatable != null) {
                    j6 = j9;
                    OverscrollKt.overScrollOutOfBound$lambda$0$15(this.$remainingPostFlingVelocity$delegate, 0.0f);
                    OverscrollKt.overScrollOutOfBound$lambda$0$18(this.$remainingPostFlingOffset$delegate, 0.0f);
                    OverscrollKt.overScrollOutOfBound$lambda$0$21(this.$remainingPostFlingHasReachedPeak$delegate, false);
                    overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                    if (overScrollOutOfBound$lambda$0$42) {
                    }
                    return Velocity.box-impl(Velocity);
                }
                Float boxFloat = Boxing.boxFloat(0.0f);
                overScrollOutOfBound$lambda$0$3 = OverscrollKt.overScrollOutOfBound$lambda$0$3(this.$springDamp$delegate);
                overScrollOutOfBound$lambda$0$2 = OverscrollKt.overScrollOutOfBound$lambda$0$2(this.$springStiff$delegate);
                AnimationSpec spring = AnimationSpecKt.spring(overScrollOutOfBound$lambda$0$3, overScrollOutOfBound$lambda$0$2, Boxing.boxFloat(this.visibilityThreshold));
                overScrollOutOfBound$lambda$0$4 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                Float boxFloat2 = Boxing.boxFloat(overScrollOutOfBound$lambda$0$4 ? Velocity.getY-impl(realAvailable2) : Velocity.getX-impl(realAvailable2));
                final MutableState<Float> mutableState = this.$remainingPostFlingVelocity$delegate;
                final MutableState<Float> mutableState2 = this.$remainingPostFlingOffset$delegate;
                final MutableState<Boolean> mutableState3 = this.$remainingPostFlingHasReachedPeak$delegate;
                final State<Function2<Float, Float, Float>> state = this.$scrollEasing$delegate;
                final MutableFloatState mutableFloatState = this.$offset$delegate;
                Function1 function1 = new Function1() { // from class: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj3) {
                        Unit onPostFling_RZ2iAVY$lambda$2;
                        onPostFling_RZ2iAVY$lambda$2 = OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.onPostFling_RZ2iAVY$lambda$2(lastVelocity2, lastDelta2, mutableState, mutableState2, mutableState3, state, mutableFloatState, (Animatable) obj3);
                        return onPostFling_RZ2iAVY$lambda$2;
                    }
                };
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.L$0 = SpillingKt.nullOutSpilledVariable(lastDelta2);
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.L$1 = SpillingKt.nullOutSpilledVariable(lastVelocity2);
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$0 = j3;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$1 = j9;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.J$2 = realAvailable2;
                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.label = 2;
                long j11 = j9;
                Object animateTo = animatable.animateTo(boxFloat, spring, boxFloat2, function1, overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12);
                if (animateTo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lastVelocity = lastVelocity2;
                j7 = j11;
                j8 = j3;
                lastDelta = lastDelta2;
                $result = animateTo;
                realAvailable3 = realAvailable2;
                AnimationResult animationResult2 = (AnimationResult) $result;
                realAvailable2 = realAvailable3;
                j6 = j7;
                OverscrollKt.overScrollOutOfBound$lambda$0$15(this.$remainingPostFlingVelocity$delegate, 0.0f);
                OverscrollKt.overScrollOutOfBound$lambda$0$18(this.$remainingPostFlingOffset$delegate, 0.0f);
                OverscrollKt.overScrollOutOfBound$lambda$0$21(this.$remainingPostFlingHasReachedPeak$delegate, false);
                overScrollOutOfBound$lambda$0$42 = OverscrollKt.overScrollOutOfBound$lambda$0$4(this.$isVertical$delegate);
                if (overScrollOutOfBound$lambda$0$42) {
                }
                return Velocity.box-impl(Velocity);
            }
        }
        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1 = new OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1(this, continuation);
        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1;
        Object $result2 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$12.label) {
        }
        realAvailable2 = j4;
        overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
        this.lastFlingAnimator = AnimatableKt.Animatable$default(overScrollOutOfBound$lambda$0$11, 0.0f, 2, (Object) null);
        final Ref.FloatRef lastDelta22 = new Ref.FloatRef();
        final Ref.FloatRef lastVelocity22 = new Ref.FloatRef();
        lastVelocity22.element = Velocity.getY-impl(realAvailable2);
        animatable = this.lastFlingAnimator;
        if (animatable != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPostFling_RZ2iAVY$lambda$2(Ref.FloatRef $lastVelocity, Ref.FloatRef $lastDelta, MutableState $remainingPostFlingVelocity$delegate, MutableState $remainingPostFlingOffset$delegate, MutableState $remainingPostFlingHasReachedPeak$delegate, State $scrollEasing$delegate, MutableFloatState $offset$delegate, Animatable $this$animateTo) {
        boolean overScrollOutOfBound$lambda$0$20;
        Function2 overScrollOutOfBound$lambda$0$1;
        float overScrollOutOfBound$lambda$0$11;
        float overScrollOutOfBound$lambda$0$112;
        Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
        if (!(((Number) $this$animateTo.getValue()).floatValue() == 0.0f)) {
            OverscrollKt.overScrollOutOfBound$lambda$0$15($remainingPostFlingVelocity$delegate, ((Number) $this$animateTo.getVelocity()).floatValue());
            OverscrollKt.overScrollOutOfBound$lambda$0$18($remainingPostFlingOffset$delegate, ((Number) $this$animateTo.getValue()).floatValue());
        }
        float newDelta = ((Number) $this$animateTo.getVelocity()).floatValue() - $lastVelocity.element;
        overScrollOutOfBound$lambda$0$20 = OverscrollKt.overScrollOutOfBound$lambda$0$20($remainingPostFlingHasReachedPeak$delegate);
        if (!overScrollOutOfBound$lambda$0$20 && $lastDelta.element * newDelta < 0.0f) {
            OverscrollKt.overScrollOutOfBound$lambda$0$21($remainingPostFlingHasReachedPeak$delegate, true);
        } else {
            $lastDelta.element = newDelta;
            $lastVelocity.element = ((Number) $this$animateTo.getVelocity()).floatValue();
        }
        overScrollOutOfBound$lambda$0$1 = OverscrollKt.overScrollOutOfBound$lambda$0$1($scrollEasing$delegate);
        overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11($offset$delegate);
        Float valueOf = Float.valueOf(overScrollOutOfBound$lambda$0$11);
        float floatValue = ((Number) $this$animateTo.getValue()).floatValue();
        overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11($offset$delegate);
        $offset$delegate.setFloatValue(((Number) overScrollOutOfBound$lambda$0$1.invoke(valueOf, Float.valueOf(floatValue - overScrollOutOfBound$lambda$0$112))).floatValue());
        return Unit.INSTANCE;
    }

    public final Object stopAnimatorIfRunning(Continuation<? super Unit> continuation) {
        Animatable<Float, AnimationVector1D> animatable;
        Animatable<Float, AnimationVector1D> animatable2 = this.lastFlingAnimator;
        boolean z = false;
        if (animatable2 != null && animatable2.isRunning()) {
            z = true;
        }
        if (!z || (animatable = this.lastFlingAnimator) == null) {
            return Unit.INSTANCE;
        }
        Object stop = animatable.stop(continuation);
        return stop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? stop : Unit.INSTANCE;
    }
}