package dev.chrisbanes.snapper;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: SnapperFlingBehavior.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001Bm\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012>\b\u0002\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u0010BC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0002\u0010\u0013B}\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012<\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0002\u0010\u0014J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\"\u0010#\u001a\u00020$*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002J%\u0010%\u001a\u00020\u0006*\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J7\u0010)\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001d\u0010-\u001a\u00020\u0006*\u00020&2\u0006\u0010\u001e\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.JK\u0010/\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000201002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00060\u0012H\u0002J/\u00104\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u00105R/\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "layoutInfo", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapIndex", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "startIndex", "targetIndex", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function3;)V", "maximumFlingDistance", "Lkotlin/Function1;", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "animationTarget", "getAnimationTarget", "()Ljava/lang/Integer;", "setAnimationTarget", "(Ljava/lang/Integer;)V", "animationTarget$delegate", "Landroidx/compose/runtime/MutableState;", "calculateSnapBack", "initialVelocity", "currentItem", "Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;", "consumeVelocityIfNotAtScrollEdge", "velocity", "canDecayBeyondCurrentItem", "", "flingToIndex", "Landroidx/compose/foundation/gestures/ScrollScope;", "index", "(Landroidx/compose/foundation/gestures/ScrollScope;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDecayFling", "initialItem", "flingThenSpring", "(Landroidx/compose/foundation/gestures/ScrollScope;Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;IFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performSnapBackIfNeeded", "Landroidx/compose/animation/core/AnimationScope;", "Landroidx/compose/animation/core/AnimationVector1D;", "scrollBy", "pixels", "performSpringFling", "(Landroidx/compose/foundation/gestures/ScrollScope;Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SnapperFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final MutableState animationTarget$delegate;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final SnapperLayoutInfo layoutInfo;
    private final Function1<SnapperLayoutInfo, Float> maximumFlingDistance;
    private final Function3<SnapperLayoutInfo, Integer, Integer, Integer> snapIndex;
    private final AnimationSpec<Float> springAnimationSpec;

    /* JADX WARN: Multi-variable type inference failed */
    private SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> function3, Function1<? super SnapperLayoutInfo, Float> function1) {
        this.layoutInfo = layoutInfo;
        this.decayAnimationSpec = decayAnimationSpec;
        this.springAnimationSpec = animationSpec;
        this.snapIndex = function3;
        this.maximumFlingDistance = function1;
        this.animationTarget$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ SnapperFlingBehavior(SnapperLayoutInfo snapperLayoutInfo, DecayAnimationSpec decayAnimationSpec, AnimationSpec<Float> animationSpec, Function3<SnapperLayoutInfo, Integer, Integer, Integer> function3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapperLayoutInfo, decayAnimationSpec, (i2 & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec, (i2 & 8) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSnapIndex() : function3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> function3) {
        this(layoutInfo, decayAnimationSpec, animationSpec, function3, SnapperFlingBehaviorDefaults.INSTANCE.getMaximumFlingDistance());
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(animationSpec, "springAnimationSpec");
        Intrinsics.checkNotNullParameter(function3, "snapIndex");
    }

    public /* synthetic */ SnapperFlingBehavior(SnapperLayoutInfo snapperLayoutInfo, DecayAnimationSpec decayAnimationSpec, AnimationSpec<Float> animationSpec, Function1<SnapperLayoutInfo, Float> function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapperLayoutInfo, decayAnimationSpec, (i2 & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec, (i2 & 8) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getMaximumFlingDistance() : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "The maximumFlingDistance parameter has been replaced with snapIndex")
    public SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function1<? super SnapperLayoutInfo, Float> function1) {
        this(layoutInfo, decayAnimationSpec, animationSpec, SnapperFlingBehaviorDefaults.INSTANCE.getSnapIndex(), function1);
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(animationSpec, "springAnimationSpec");
        Intrinsics.checkNotNullParameter(function1, "maximumFlingDistance");
    }

    private final void setAnimationTarget(Integer num) {
        MutableState $this$setValue$iv = this.animationTarget$delegate;
        $this$setValue$iv.setValue(num);
    }

    public final Integer getAnimationTarget() {
        State $this$getValue$iv = this.animationTarget$delegate;
        return (Integer) $this$getValue$iv.getValue();
    }

    public Object performFling(ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> continuation) {
        if (!this.layoutInfo.canScrollTowardsStart() || !this.layoutInfo.canScrollTowardsEnd()) {
            return Boxing.boxFloat(initialVelocity);
        }
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        float maxFlingDistance = ((Number) this.maximumFlingDistance.invoke(this.layoutInfo)).floatValue();
        boolean z = true;
        if (!(maxFlingDistance > CropImageView.DEFAULT_ASPECT_RATIO)) {
            throw new IllegalArgumentException("Distance returned by maximumFlingDistance should be greater than 0".toString());
        }
        SnapperLayoutItemInfo initialItem = this.layoutInfo.getCurrentItem();
        if (initialItem == null) {
            return Boxing.boxFloat(initialVelocity);
        }
        int target = this.layoutInfo.determineTargetIndex(initialVelocity, this.decayAnimationSpec, maxFlingDistance);
        int targetIndex = ((Number) this.snapIndex.invoke(this.layoutInfo, Boxing.boxInt(initialVelocity < CropImageView.DEFAULT_ASPECT_RATIO ? initialItem.getIndex() + 1 : initialItem.getIndex()), Boxing.boxInt(target))).intValue();
        if (targetIndex < 0 || targetIndex >= this.layoutInfo.getTotalItemsCount()) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return flingToIndex($this$performFling, targetIndex, initialVelocity, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flingToIndex(ScrollScope $this$flingToIndex, int index, float f2, Continuation<? super Float> continuation) {
        Continuation $continuation;
        SnapperFlingBehavior snapperFlingBehavior;
        float initialVelocity;
        float velocityLeft;
        int index2;
        ScrollScope $this$flingToIndex2;
        float initialVelocity2;
        Object performDecayFling$default;
        SnapperFlingBehavior snapperFlingBehavior2;
        int index3;
        ScrollScope $this$flingToIndex3;
        SnapperLayoutItemInfo currentItem;
        Object performSpringFling;
        if (continuation instanceof SnapperFlingBehavior$flingToIndex$1) {
            Continuation continuation2 = (SnapperFlingBehavior$flingToIndex$1) continuation;
            if ((continuation2.label & Integer.MIN_VALUE) != 0) {
                continuation2.label -= Integer.MIN_VALUE;
                $continuation = continuation2;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        snapperFlingBehavior = this;
                        initialVelocity = f2;
                        SnapperLayoutItemInfo initialItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
                        if (initialItem == null) {
                            return Boxing.boxFloat(initialVelocity);
                        }
                        if (initialItem.getIndex() != index || snapperFlingBehavior.layoutInfo.distanceToIndexSnap(initialItem.getIndex()) != 0) {
                            velocityLeft = initialVelocity;
                            if (!snapperFlingBehavior.canDecayBeyondCurrentItem(snapperFlingBehavior.decayAnimationSpec, initialVelocity, initialItem)) {
                                index2 = index;
                                $this$flingToIndex2 = $this$flingToIndex;
                                break;
                            } else {
                                $continuation.L$0 = snapperFlingBehavior;
                                $continuation.L$1 = $this$flingToIndex;
                                $continuation.I$0 = index;
                                $continuation.F$0 = initialVelocity;
                                $continuation.label = 1;
                                initialVelocity2 = initialVelocity;
                                performDecayFling$default = performDecayFling$default(snapperFlingBehavior, $this$flingToIndex, initialItem, index, velocityLeft, false, $continuation, 8, null);
                                if (performDecayFling$default != coroutine_suspended) {
                                    snapperFlingBehavior2 = snapperFlingBehavior;
                                    index3 = index;
                                    $this$flingToIndex3 = $this$flingToIndex;
                                    velocityLeft = ((Number) performDecayFling$default).floatValue();
                                    snapperFlingBehavior = snapperFlingBehavior2;
                                    initialVelocity = initialVelocity2;
                                    index2 = index3;
                                    $this$flingToIndex2 = $this$flingToIndex3;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            SnapperLog snapperLog = SnapperLog.INSTANCE;
                            return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(initialVelocity));
                        }
                        break;
                    case 1:
                        float initialVelocity3 = $continuation.F$0;
                        index3 = $continuation.I$0;
                        $this$flingToIndex3 = (ScrollScope) $continuation.L$1;
                        snapperFlingBehavior2 = (SnapperFlingBehavior) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        initialVelocity2 = initialVelocity3;
                        performDecayFling$default = $result;
                        velocityLeft = ((Number) performDecayFling$default).floatValue();
                        snapperFlingBehavior = snapperFlingBehavior2;
                        initialVelocity = initialVelocity2;
                        index2 = index3;
                        $this$flingToIndex2 = $this$flingToIndex3;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        snapperFlingBehavior = (SnapperFlingBehavior) $continuation.L$0;
                        performSpringFling = $result;
                        velocityLeft = ((Number) performSpringFling).floatValue();
                        return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(velocityLeft));
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                currentItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
                if (currentItem != null) {
                    return Boxing.boxFloat(initialVelocity);
                }
                if (currentItem.getIndex() != index2 || snapperFlingBehavior.layoutInfo.distanceToIndexSnap(index2) != 0) {
                    $continuation.L$0 = snapperFlingBehavior;
                    $continuation.L$1 = null;
                    $continuation.label = 2;
                    performSpringFling = snapperFlingBehavior.performSpringFling($this$flingToIndex2, currentItem, index2, velocityLeft, $continuation);
                    if (performSpringFling == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    velocityLeft = ((Number) performSpringFling).floatValue();
                }
                return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(velocityLeft));
            }
        }
        $continuation = new SnapperFlingBehavior$flingToIndex$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        currentItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
        if (currentItem != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performDecayFling(final ScrollScope scrollScope, SnapperLayoutItemInfo initialItem, final int targetIndex, float initialVelocity, boolean flingThenSpring, Continuation<? super Float> continuation) {
        SnapperFlingBehavior$performDecayFling$1 snapperFlingBehavior$performDecayFling$1;
        SnapperFlingBehavior snapperFlingBehavior;
        Ref.FloatRef velocityLeft;
        if (continuation instanceof SnapperFlingBehavior$performDecayFling$1) {
            snapperFlingBehavior$performDecayFling$1 = (SnapperFlingBehavior$performDecayFling$1) continuation;
            if ((snapperFlingBehavior$performDecayFling$1.label & Integer.MIN_VALUE) != 0) {
                snapperFlingBehavior$performDecayFling$1.label -= Integer.MIN_VALUE;
                Object $result = snapperFlingBehavior$performDecayFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapperFlingBehavior$performDecayFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (initialItem.getIndex() == targetIndex && this.layoutInfo.distanceToIndexSnap(initialItem.getIndex()) == 0) {
                            SnapperLog snapperLog = SnapperLog.INSTANCE;
                            return Boxing.boxFloat(consumeVelocityIfNotAtScrollEdge(initialVelocity));
                        }
                        SnapperLog snapperLog2 = SnapperLog.INSTANCE;
                        final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                        velocityLeft2.element = initialVelocity;
                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                        boolean canSpringThenFling = flingThenSpring && Math.abs(targetIndex - initialItem.getIndex()) >= 2;
                        try {
                            setAnimationTarget(Boxing.boxInt(targetIndex));
                            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default((float) CropImageView.DEFAULT_ASPECT_RATIO, initialVelocity, 0L, 0L, false, 28, (Object) null);
                            DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
                            final boolean z = canSpringThenFling;
                            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: dev.chrisbanes.snapper.SnapperFlingBehavior$performDecayFling$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                    invoke((AnimationScope) p1);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    SnapperLayoutInfo snapperLayoutInfo;
                                    boolean performSnapBackIfNeeded;
                                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateDecay");
                                    float delta = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
                                    float consumed = scrollScope.scrollBy(delta);
                                    floatRef.element = ((Number) animationScope.getValue()).floatValue();
                                    velocityLeft2.element = ((Number) animationScope.getVelocity()).floatValue();
                                    if (Math.abs(delta - consumed) > 0.5f) {
                                        animationScope.cancelAnimation();
                                    }
                                    snapperLayoutInfo = this.layoutInfo;
                                    SnapperLayoutItemInfo currentItem = snapperLayoutInfo.getCurrentItem();
                                    if (currentItem == null) {
                                        animationScope.cancelAnimation();
                                        return;
                                    }
                                    if (animationScope.isRunning() && z) {
                                        if (((Number) animationScope.getVelocity()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO && currentItem.getIndex() == targetIndex - 1) {
                                            animationScope.cancelAnimation();
                                        } else if (((Number) animationScope.getVelocity()).floatValue() < CropImageView.DEFAULT_ASPECT_RATIO && currentItem.getIndex() == targetIndex) {
                                            animationScope.cancelAnimation();
                                        }
                                    }
                                    if (animationScope.isRunning()) {
                                        performSnapBackIfNeeded = this.performSnapBackIfNeeded(animationScope, currentItem, targetIndex, new AnonymousClass1(scrollScope));
                                        if (performSnapBackIfNeeded) {
                                            animationScope.cancelAnimation();
                                        }
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: SnapperFlingBehavior.kt */
                                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                                /* renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performDecayFling$4$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                                public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
                                    AnonymousClass1(Object obj) {
                                        super(1, obj, ScrollScope.class, "scrollBy", "scrollBy(F)F", 0);
                                    }

                                    public final Float invoke(float p0) {
                                        return Float.valueOf(((ScrollScope) this.receiver).scrollBy(p0));
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke(((Number) p1).floatValue());
                                    }
                                }
                            };
                            snapperFlingBehavior$performDecayFling$1.L$0 = this;
                            snapperFlingBehavior$performDecayFling$1.L$1 = velocityLeft2;
                            snapperFlingBehavior$performDecayFling$1.label = 1;
                            try {
                                if (SuspendAnimationKt.animateDecay$default(AnimationState$default, decayAnimationSpec, false, function1, snapperFlingBehavior$performDecayFling$1, 2, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                velocityLeft = velocityLeft2;
                                snapperFlingBehavior = this;
                                snapperFlingBehavior.setAnimationTarget(null);
                                SnapperLog snapperLog3 = SnapperLog.INSTANCE;
                                return Boxing.boxFloat(velocityLeft.element);
                            } catch (Throwable th) {
                                th = th;
                                snapperFlingBehavior = this;
                                snapperFlingBehavior.setAnimationTarget(null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            snapperFlingBehavior = this;
                        }
                        break;
                    case 1:
                        velocityLeft = (Ref.FloatRef) snapperFlingBehavior$performDecayFling$1.L$1;
                        snapperFlingBehavior = (SnapperFlingBehavior) snapperFlingBehavior$performDecayFling$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            snapperFlingBehavior.setAnimationTarget(null);
                            SnapperLog snapperLog32 = SnapperLog.INSTANCE;
                            return Boxing.boxFloat(velocityLeft.element);
                        } catch (Throwable th3) {
                            th = th3;
                            snapperFlingBehavior.setAnimationTarget(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        snapperFlingBehavior$performDecayFling$1 = new SnapperFlingBehavior$performDecayFling$1(this, continuation);
        Object $result2 = snapperFlingBehavior$performDecayFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapperFlingBehavior$performDecayFling$1.label) {
        }
    }

    static /* synthetic */ Object performDecayFling$default(SnapperFlingBehavior snapperFlingBehavior, ScrollScope scrollScope, SnapperLayoutItemInfo snapperLayoutItemInfo, int i2, float f2, boolean z, Continuation continuation, int i3, Object obj) {
        boolean z2;
        if ((i3 & 8) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
        return snapperFlingBehavior.performDecayFling(scrollScope, snapperLayoutItemInfo, i2, f2, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performSpringFling(final ScrollScope $this$performSpringFling, SnapperLayoutItemInfo initialItem, final int targetIndex, float f2, Continuation<? super Float> continuation) {
        SnapperFlingBehavior$performSpringFling$1 snapperFlingBehavior$performSpringFling$1;
        SnapperFlingBehavior snapperFlingBehavior;
        Ref.FloatRef velocityLeft;
        if (continuation instanceof SnapperFlingBehavior$performSpringFling$1) {
            snapperFlingBehavior$performSpringFling$1 = (SnapperFlingBehavior$performSpringFling$1) continuation;
            if ((snapperFlingBehavior$performSpringFling$1.label & Integer.MIN_VALUE) != 0) {
                snapperFlingBehavior$performSpringFling$1.label -= Integer.MIN_VALUE;
                Object $result = snapperFlingBehavior$performSpringFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapperFlingBehavior$performSpringFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        float initialVelocity = f2;
                        SnapperLog snapperLog = SnapperLog.INSTANCE;
                        final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                        if ((targetIndex <= initialItem.getIndex() || initialVelocity <= CropImageView.DEFAULT_ASPECT_RATIO) && (targetIndex > initialItem.getIndex() || initialVelocity >= CropImageView.DEFAULT_ASPECT_RATIO)) {
                            initialVelocity = 0.0f;
                        }
                        velocityLeft2.element = initialVelocity;
                        final Ref.FloatRef lastValue = new Ref.FloatRef();
                        try {
                            setAnimationTarget(Boxing.boxInt(targetIndex));
                            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(lastValue.element, velocityLeft2.element, 0L, 0L, false, 28, (Object) null);
                            Float boxFloat = Boxing.boxFloat(this.layoutInfo.distanceToIndexSnap(targetIndex));
                            AnimationSpec<Float> animationSpec = this.springAnimationSpec;
                            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: dev.chrisbanes.snapper.SnapperFlingBehavior$performSpringFling$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                    invoke((AnimationScope) p1);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    SnapperLayoutInfo snapperLayoutInfo;
                                    boolean performSnapBackIfNeeded;
                                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
                                    float delta = ((Number) animationScope.getValue()).floatValue() - lastValue.element;
                                    float consumed = $this$performSpringFling.scrollBy(delta);
                                    lastValue.element = ((Number) animationScope.getValue()).floatValue();
                                    velocityLeft2.element = ((Number) animationScope.getVelocity()).floatValue();
                                    snapperLayoutInfo = this.layoutInfo;
                                    SnapperLayoutItemInfo currentItem = snapperLayoutInfo.getCurrentItem();
                                    if (currentItem != null) {
                                        performSnapBackIfNeeded = this.performSnapBackIfNeeded(animationScope, currentItem, targetIndex, new AnonymousClass1($this$performSpringFling));
                                        if (performSnapBackIfNeeded) {
                                            animationScope.cancelAnimation();
                                            return;
                                        } else if (Math.abs(delta - consumed) > 0.5f) {
                                            animationScope.cancelAnimation();
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    animationScope.cancelAnimation();
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: SnapperFlingBehavior.kt */
                                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                                /* renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performSpringFling$3$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                                public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
                                    AnonymousClass1(Object obj) {
                                        super(1, obj, ScrollScope.class, "scrollBy", "scrollBy(F)F", 0);
                                    }

                                    public final Float invoke(float p0) {
                                        return Float.valueOf(((ScrollScope) this.receiver).scrollBy(p0));
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke(((Number) p1).floatValue());
                                    }
                                }
                            };
                            snapperFlingBehavior$performSpringFling$1.L$0 = this;
                            snapperFlingBehavior$performSpringFling$1.L$1 = velocityLeft2;
                            snapperFlingBehavior$performSpringFling$1.label = 1;
                            try {
                                if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec, false, function1, snapperFlingBehavior$performSpringFling$1, 4, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                velocityLeft = velocityLeft2;
                                snapperFlingBehavior = this;
                                snapperFlingBehavior.setAnimationTarget(null);
                                SnapperLog snapperLog2 = SnapperLog.INSTANCE;
                                return Boxing.boxFloat(velocityLeft.element);
                            } catch (Throwable th) {
                                th = th;
                                snapperFlingBehavior = this;
                                snapperFlingBehavior.setAnimationTarget(null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            snapperFlingBehavior = this;
                        }
                        break;
                    case 1:
                        velocityLeft = (Ref.FloatRef) snapperFlingBehavior$performSpringFling$1.L$1;
                        snapperFlingBehavior = (SnapperFlingBehavior) snapperFlingBehavior$performSpringFling$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            snapperFlingBehavior.setAnimationTarget(null);
                            SnapperLog snapperLog22 = SnapperLog.INSTANCE;
                            return Boxing.boxFloat(velocityLeft.element);
                        } catch (Throwable th3) {
                            th = th3;
                            snapperFlingBehavior.setAnimationTarget(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        snapperFlingBehavior$performSpringFling$1 = new SnapperFlingBehavior$performSpringFling$1(this, continuation);
        Object $result2 = snapperFlingBehavior$performSpringFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapperFlingBehavior$performSpringFling$1.label) {
        }
    }

    static /* synthetic */ Object performSpringFling$default(SnapperFlingBehavior snapperFlingBehavior, ScrollScope scrollScope, SnapperLayoutItemInfo snapperLayoutItemInfo, int i2, float f2, Continuation continuation, int i3, Object obj) {
        float f3;
        if ((i3 & 4) == 0) {
            f3 = f2;
        } else {
            f3 = 0.0f;
        }
        return snapperFlingBehavior.performSpringFling(scrollScope, snapperLayoutItemInfo, i2, f3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean performSnapBackIfNeeded(AnimationScope<Float, AnimationVector1D> animationScope, SnapperLayoutItemInfo currentItem, int targetIndex, Function1<? super Float, Float> function1) {
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        int snapBackAmount = calculateSnapBack(((Number) animationScope.getVelocity()).floatValue(), currentItem, targetIndex);
        if (snapBackAmount != 0) {
            SnapperLog snapperLog2 = SnapperLog.INSTANCE;
            function1.invoke(Float.valueOf(snapBackAmount));
            return true;
        }
        return false;
    }

    private final boolean canDecayBeyondCurrentItem(DecayAnimationSpec<Float> decayAnimationSpec, float velocity, SnapperLayoutItemInfo currentItem) {
        if (Math.abs(velocity) < 0.5f) {
            return false;
        }
        float flingDistance = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, (float) CropImageView.DEFAULT_ASPECT_RATIO, velocity);
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        return velocity < CropImageView.DEFAULT_ASPECT_RATIO ? flingDistance <= ((float) this.layoutInfo.distanceToIndexSnap(currentItem.getIndex())) : flingDistance >= ((float) this.layoutInfo.distanceToIndexSnap(currentItem.getIndex() + 1));
    }

    private final int calculateSnapBack(float initialVelocity, SnapperLayoutItemInfo currentItem, int targetIndex) {
        if (initialVelocity > CropImageView.DEFAULT_ASPECT_RATIO && currentItem.getIndex() >= targetIndex) {
            return this.layoutInfo.distanceToIndexSnap(currentItem.getIndex());
        }
        if (initialVelocity < CropImageView.DEFAULT_ASPECT_RATIO && currentItem.getIndex() <= targetIndex - 1) {
            return this.layoutInfo.distanceToIndexSnap(currentItem.getIndex() + 1);
        }
        return 0;
    }

    private final float consumeVelocityIfNotAtScrollEdge(float velocity) {
        if (velocity < CropImageView.DEFAULT_ASPECT_RATIO && !this.layoutInfo.canScrollTowardsStart()) {
            return velocity;
        }
        if (velocity <= CropImageView.DEFAULT_ASPECT_RATIO || this.layoutInfo.canScrollTowardsEnd()) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return velocity;
    }
}