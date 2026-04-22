package kntr.common.compose.list;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1", f = "Overscroll.kt", i = {}, l = {399}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OverscrollKt$overScrollOutOfBound$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NestedScrollDispatcher $dispatcher;
    final /* synthetic */ State<Float> $factor$delegate;
    final /* synthetic */ MutableSharedFlow<Integer> $listCountFlow;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 $nestedConnection;
    final /* synthetic */ MutableFloatState $offset$delegate;
    final /* synthetic */ MutableState<Boolean> $remainingPostFlingHasReachedPeak$delegate;
    final /* synthetic */ MutableState<Float> $remainingPostFlingOffset$delegate;
    final /* synthetic */ MutableState<Float> $remainingPostFlingVelocity$delegate;
    final /* synthetic */ State<Float> $springDamp$delegate;
    final /* synthetic */ State<Float> $springStiff$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverscrollKt$overScrollOutOfBound$1$2$1(MutableSharedFlow<Integer> mutableSharedFlow, OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, NestedScrollDispatcher nestedScrollDispatcher, LazyListState lazyListState, MutableState<Float> mutableState, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState2, MutableState<Float> mutableState3, State<Float> state, State<Float> state2, State<Float> state3, Continuation<? super OverscrollKt$overScrollOutOfBound$1$2$1> continuation) {
        super(2, continuation);
        this.$listCountFlow = mutableSharedFlow;
        this.$nestedConnection = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
        this.$dispatcher = nestedScrollDispatcher;
        this.$listState = lazyListState;
        this.$remainingPostFlingVelocity$delegate = mutableState;
        this.$offset$delegate = mutableFloatState;
        this.$remainingPostFlingHasReachedPeak$delegate = mutableState2;
        this.$remainingPostFlingOffset$delegate = mutableState3;
        this.$factor$delegate = state;
        this.$springDamp$delegate = state2;
        this.$springStiff$delegate = state3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OverscrollKt$overScrollOutOfBound$1$2$1(this.$listCountFlow, this.$nestedConnection, this.$dispatcher, this.$listState, this.$remainingPostFlingVelocity$delegate, this.$offset$delegate, this.$remainingPostFlingHasReachedPeak$delegate, this.$remainingPostFlingOffset$delegate, this.$factor$delegate, this.$springDamp$delegate, this.$springStiff$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Overscroll.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* renamed from: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ NestedScrollDispatcher $dispatcher;
        final /* synthetic */ State<Float> $factor$delegate;
        final /* synthetic */ LazyListState $listState;
        final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 $nestedConnection;
        final /* synthetic */ MutableFloatState $offset$delegate;
        final /* synthetic */ MutableState<Boolean> $remainingPostFlingHasReachedPeak$delegate;
        final /* synthetic */ MutableState<Float> $remainingPostFlingOffset$delegate;
        final /* synthetic */ MutableState<Float> $remainingPostFlingVelocity$delegate;
        final /* synthetic */ State<Float> $springDamp$delegate;
        final /* synthetic */ State<Float> $springStiff$delegate;

        AnonymousClass1(OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, NestedScrollDispatcher nestedScrollDispatcher, LazyListState lazyListState, MutableState<Float> mutableState, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState2, MutableState<Float> mutableState3, State<Float> state, State<Float> state2, State<Float> state3) {
            this.$nestedConnection = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
            this.$dispatcher = nestedScrollDispatcher;
            this.$listState = lazyListState;
            this.$remainingPostFlingVelocity$delegate = mutableState;
            this.$offset$delegate = mutableFloatState;
            this.$remainingPostFlingHasReachedPeak$delegate = mutableState2;
            this.$remainingPostFlingOffset$delegate = mutableState3;
            this.$factor$delegate = state;
            this.$springDamp$delegate = state2;
            this.$springStiff$delegate = state3;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(int itemCount, Continuation<? super Unit> continuation) {
            OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1 overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1;
            float overScrollOutOfBound$lambda$0$11;
            float overScrollOutOfBound$lambda$0$112;
            Object forceScrollBy;
            float overScrollOutOfBound$lambda$0$14;
            float overScrollOutOfBound$lambda$0$113;
            OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
            int itemCount2 = itemCount;
            if (continuation instanceof OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1) {
                overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1 = (OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1) continuation;
                if ((overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (itemCount2 != 0) {
                                overScrollOutOfBound$lambda$0$14 = OverscrollKt.overScrollOutOfBound$lambda$0$14(this.$remainingPostFlingVelocity$delegate);
                                if (Math.abs(overScrollOutOfBound$lambda$0$14) > this.$nestedConnection.getVisibilityThreshold()) {
                                    overScrollOutOfBound$lambda$0$113 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                                    if (!(overScrollOutOfBound$lambda$0$113 == 0.0f)) {
                                        BuildersKt.launch$default(this.$dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new C00061(this.$listState, this.$nestedConnection, this.$offset$delegate, this.$remainingPostFlingHasReachedPeak$delegate, this.$remainingPostFlingOffset$delegate, this.$factor$delegate, this.$springDamp$delegate, this.$springStiff$delegate, this.$remainingPostFlingVelocity$delegate, null), 3, (Object) null);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            overScrollOutOfBound$lambda$0$11 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                            if (!(overScrollOutOfBound$lambda$0$11 == 0.0f)) {
                                ScrollableState scrollableState = this.$listState;
                                if (scrollableState != null) {
                                    overScrollOutOfBound$lambda$0$112 = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                                    overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.I$0 = itemCount2;
                                    overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label = 1;
                                    forceScrollBy = OverscrollKt.forceScrollBy(scrollableState, overScrollOutOfBound$lambda$0$112 * (-1), overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1);
                                    if (forceScrollBy == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Float f = (Float) forceScrollBy;
                                }
                                this.$offset$delegate.setFloatValue(0.0f);
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 = this.$nestedConnection;
                                overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.I$0 = itemCount2;
                                overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label = 2;
                                if (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.stopAnimatorIfRunning(overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            itemCount2 = overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.I$0;
                            ResultKt.throwOnFailure($result);
                            forceScrollBy = $result;
                            Float f2 = (Float) forceScrollBy;
                            this.$offset$delegate.setFloatValue(0.0f);
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 = this.$nestedConnection;
                            overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.I$0 = itemCount2;
                            overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label = 2;
                            if (overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.stopAnimatorIfRunning(overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            int i = overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.I$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1 = new OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1(this, continuation);
            Object $result2 = overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (overscrollKt$overScrollOutOfBound$1$2$1$1$emit$1.label) {
            }
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit(((Number) value).intValue(), $completion);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Overscroll.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1$1", f = "Overscroll.kt", i = {0, 1, 2, 2, 2, 3, 3, 3, 3}, l = {407, 409, 416, 435}, m = "invokeSuspend", n = {"offsetBeforeRest", "offsetBeforeRest", "lastEasingOffset", "offsetBeforeRest", "target", "currentTarget", "it", "offsetBeforeRest", "$i$a$-also-OverscrollKt$overScrollOutOfBound$1$2$1$1$1$2"}, s = {"F$0", "F$0", "L$0", "F$0", "F$1", "L$0", "L$2", "F$0", "I$0"}, v = 1)
        /* renamed from: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ State<Float> $factor$delegate;
            final /* synthetic */ LazyListState $listState;
            final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 $nestedConnection;
            final /* synthetic */ MutableFloatState $offset$delegate;
            final /* synthetic */ MutableState<Boolean> $remainingPostFlingHasReachedPeak$delegate;
            final /* synthetic */ MutableState<Float> $remainingPostFlingOffset$delegate;
            final /* synthetic */ MutableState<Float> $remainingPostFlingVelocity$delegate;
            final /* synthetic */ State<Float> $springDamp$delegate;
            final /* synthetic */ State<Float> $springStiff$delegate;
            float F$0;
            float F$1;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00061(LazyListState lazyListState, OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState, MutableState<Float> mutableState2, State<Float> state, State<Float> state2, State<Float> state3, MutableState<Float> mutableState3, Continuation<? super C00061> continuation) {
                super(2, continuation);
                this.$listState = lazyListState;
                this.$nestedConnection = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
                this.$offset$delegate = mutableFloatState;
                this.$remainingPostFlingHasReachedPeak$delegate = mutableState;
                this.$remainingPostFlingOffset$delegate = mutableState2;
                this.$factor$delegate = state;
                this.$springDamp$delegate = state2;
                this.$springStiff$delegate = state3;
                this.$remainingPostFlingVelocity$delegate = mutableState3;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00061(this.$listState, this.$nestedConnection, this.$offset$delegate, this.$remainingPostFlingHasReachedPeak$delegate, this.$remainingPostFlingOffset$delegate, this.$factor$delegate, this.$springDamp$delegate, this.$springStiff$delegate, this.$remainingPostFlingVelocity$delegate, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0103  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                float offsetBeforeRest;
                Object forceScrollBy;
                boolean overScrollOutOfBound$lambda$0$20;
                float overScrollOutOfBound$lambda$0$14;
                float overScrollOutOfBound$lambda$0$142;
                Animatable animatable;
                OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
                float overScrollOutOfBound$lambda$0$17;
                float overScrollOutOfBound$lambda$0$172;
                float overScrollOutOfBound$lambda$0$5;
                float overScrollOutOfBound$lambda$0$3;
                float overScrollOutOfBound$lambda$0$2;
                float overScrollOutOfBound$lambda$0$143;
                Object animateTo;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        offsetBeforeRest = OverscrollKt.overScrollOutOfBound$lambda$0$11(this.$offset$delegate);
                        ScrollableState scrollableState = this.$listState;
                        if (scrollableState != null) {
                            this.F$0 = offsetBeforeRest;
                            this.label = 1;
                            forceScrollBy = OverscrollKt.forceScrollBy(scrollableState, (-1) * offsetBeforeRest, (Continuation) this);
                            if (forceScrollBy == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Float f = (Float) forceScrollBy;
                        }
                        this.$offset$delegate.setFloatValue(0.0f);
                        this.F$0 = offsetBeforeRest;
                        this.label = 2;
                        if (this.$nestedConnection.stopAnimatorIfRunning((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        overScrollOutOfBound$lambda$0$20 = OverscrollKt.overScrollOutOfBound$lambda$0$20(this.$remainingPostFlingHasReachedPeak$delegate);
                        if (overScrollOutOfBound$lambda$0$20) {
                            OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$12 = this.$nestedConnection;
                            overScrollOutOfBound$lambda$0$17 = OverscrollKt.overScrollOutOfBound$lambda$0$17(this.$remainingPostFlingOffset$delegate);
                            overscrollKt$overScrollOutOfBound$1$nestedConnection$1$12.setLastFlingAnimator(AnimatableKt.Animatable$default(overScrollOutOfBound$lambda$0$17, 0.0f, 2, (Object) null));
                            final Ref.FloatRef lastEasingOffset = new Ref.FloatRef();
                            lastEasingOffset.element = offsetBeforeRest;
                            overScrollOutOfBound$lambda$0$172 = OverscrollKt.overScrollOutOfBound$lambda$0$17(this.$remainingPostFlingOffset$delegate);
                            overScrollOutOfBound$lambda$0$5 = OverscrollKt.overScrollOutOfBound$lambda$0$5(this.$factor$delegate);
                            float target = overScrollOutOfBound$lambda$0$172 * (1.0f - overScrollOutOfBound$lambda$0$5);
                            Animatable<Float, AnimationVector1D> lastFlingAnimator = this.$nestedConnection.getLastFlingAnimator();
                            if (lastFlingAnimator != null) {
                                Float boxFloat = Boxing.boxFloat(target);
                                overScrollOutOfBound$lambda$0$3 = OverscrollKt.overScrollOutOfBound$lambda$0$3(this.$springDamp$delegate);
                                overScrollOutOfBound$lambda$0$2 = OverscrollKt.overScrollOutOfBound$lambda$0$2(this.$springStiff$delegate);
                                AnimationSpec spring = AnimationSpecKt.spring(overScrollOutOfBound$lambda$0$3, overScrollOutOfBound$lambda$0$2, Boxing.boxFloat(this.$nestedConnection.getVisibilityThreshold()));
                                overScrollOutOfBound$lambda$0$143 = OverscrollKt.overScrollOutOfBound$lambda$0$14(this.$remainingPostFlingVelocity$delegate);
                                Float boxFloat2 = Boxing.boxFloat(overScrollOutOfBound$lambda$0$143);
                                final LazyListState lazyListState = this.$listState;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(lastEasingOffset);
                                this.F$0 = offsetBeforeRest;
                                this.F$1 = target;
                                this.label = 3;
                                animateTo = lastFlingAnimator.animateTo(boxFloat, spring, boxFloat2, new Function1() { // from class: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1$1$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        Unit invokeSuspend$lambda$0;
                                        invokeSuspend$lambda$0 = OverscrollKt$overScrollOutOfBound$1$2$1.AnonymousClass1.C00061.invokeSuspend$lambda$0(lazyListState, lastEasingOffset, (Animatable) obj);
                                        return invokeSuspend$lambda$0;
                                    }
                                }, (Continuation) this);
                                if (animateTo == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                AnimationResult animationResult = (AnimationResult) animateTo;
                            }
                        } else {
                            overScrollOutOfBound$lambda$0$14 = OverscrollKt.overScrollOutOfBound$lambda$0$14(this.$remainingPostFlingVelocity$delegate);
                            if (overScrollOutOfBound$lambda$0$14 < 0.0f) {
                                final Ref.FloatRef currentTarget = new Ref.FloatRef();
                                OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$13 = this.$nestedConnection;
                                Animatable it = AnimatableKt.Animatable$default(currentTarget.element, 0.0f, 2, (Object) null);
                                MutableState<Float> mutableState = this.$remainingPostFlingVelocity$delegate;
                                final LazyListState lazyListState2 = this.$listState;
                                overScrollOutOfBound$lambda$0$142 = OverscrollKt.overScrollOutOfBound$lambda$0$14(mutableState);
                                Float boxFloat3 = Boxing.boxFloat(overScrollOutOfBound$lambda$0$142);
                                DecayAnimationSpec exponentialDecay$default = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null);
                                Function1 function1 = new Function1() { // from class: kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1$1$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj) {
                                        Unit invokeSuspend$lambda$1$0;
                                        invokeSuspend$lambda$1$0 = OverscrollKt$overScrollOutOfBound$1$2$1.AnonymousClass1.C00061.invokeSuspend$lambda$1$0(lazyListState2, currentTarget, (Animatable) obj);
                                        return invokeSuspend$lambda$1$0;
                                    }
                                };
                                this.L$0 = SpillingKt.nullOutSpilledVariable(currentTarget);
                                this.L$1 = it;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                                this.L$3 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$13;
                                this.F$0 = offsetBeforeRest;
                                this.I$0 = 0;
                                this.label = 4;
                                if (it.animateDecay(boxFloat3, exponentialDecay$default, function1, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                animatable = it;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$13;
                                overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.setLastFlingAnimator(animatable);
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        offsetBeforeRest = this.F$0;
                        ResultKt.throwOnFailure($result);
                        forceScrollBy = $result;
                        Float f2 = (Float) forceScrollBy;
                        this.$offset$delegate.setFloatValue(0.0f);
                        this.F$0 = offsetBeforeRest;
                        this.label = 2;
                        if (this.$nestedConnection.stopAnimatorIfRunning((Continuation) this) == coroutine_suspended) {
                        }
                        overScrollOutOfBound$lambda$0$20 = OverscrollKt.overScrollOutOfBound$lambda$0$20(this.$remainingPostFlingHasReachedPeak$delegate);
                        if (overScrollOutOfBound$lambda$0$20) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        offsetBeforeRest = this.F$0;
                        ResultKt.throwOnFailure($result);
                        overScrollOutOfBound$lambda$0$20 = OverscrollKt.overScrollOutOfBound$lambda$0$20(this.$remainingPostFlingHasReachedPeak$delegate);
                        if (overScrollOutOfBound$lambda$0$20) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        float f3 = this.F$1;
                        float f4 = this.F$0;
                        Ref.FloatRef floatRef = (Ref.FloatRef) this.L$0;
                        ResultKt.throwOnFailure($result);
                        animateTo = $result;
                        AnimationResult animationResult2 = (AnimationResult) animateTo;
                        return Unit.INSTANCE;
                    case 4:
                        int i = this.I$0;
                        float f5 = this.F$0;
                        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 = (OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1) this.L$3;
                        Animatable animatable2 = (Animatable) this.L$2;
                        animatable = (Animatable) this.L$1;
                        Ref.FloatRef floatRef2 = (Ref.FloatRef) this.L$0;
                        ResultKt.throwOnFailure($result);
                        overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1.setLastFlingAnimator(animatable);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(LazyListState $listState, Ref.FloatRef $lastEasingOffset, Animatable $this$animateTo) {
                float easingOffset = ((Number) $this$animateTo.getValue()).floatValue();
                if ($listState != null) {
                    $listState.dispatchRawDelta($lastEasingOffset.element - easingOffset);
                }
                $lastEasingOffset.element = easingOffset;
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$1$0(LazyListState $listState, Ref.FloatRef $currentTarget, Animatable $this$animateDecay) {
                if ($listState != null) {
                    $listState.dispatchRawDelta($currentTarget.element - ((Number) $this$animateDecay.getValue()).floatValue());
                }
                $currentTarget.element = ((Number) $this$animateDecay.getValue()).floatValue();
                return Unit.INSTANCE;
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$listCountFlow.collect(new AnonymousClass1(this.$nestedConnection, this.$dispatcher, this.$listState, this.$remainingPostFlingVelocity$delegate, this.$offset$delegate, this.$remainingPostFlingHasReachedPeak$delegate, this.$remainingPostFlingOffset$delegate, this.$factor$delegate, this.$springDamp$delegate, this.$springStiff$delegate), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}