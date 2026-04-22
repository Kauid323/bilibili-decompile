package kntr.app.deepsearch.ui.ae;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentList;
import kntr.app.deepsearch.ui.input.ImeVisibleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KeepBottomEffect.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"keepBottom", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/foundation/lazy/LazyListState;", "list", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "backFromLogin", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/foundation/lazy/LazyListState;Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;ZLandroidx/compose/runtime/Composer;I)V", "compose_debug", "shouldAutoScroll", "isAtBottom", "layoutCount", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KeepBottomEffectKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepBottom$lambda$13(LazyListState lazyListState, DeepSearchContentList deepSearchContentList, boolean z, int i, Composer composer, int i2) {
        keepBottom(lazyListState, deepSearchContentList, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void keepBottom(final LazyListState $this$keepBottom, final DeepSearchContentList list, final boolean backFromLogin, Composer $composer, final int $changed) {
        boolean z;
        MutableState isAtBottom$delegate;
        String str;
        Intrinsics.checkNotNullParameter($this$keepBottom, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        Composer $composer2 = $composer.startRestartGroup(1995593437);
        ComposerKt.sourceInformation($composer2, "C(keepBottom)N(list,backFromLogin)30@1183L46,34@1271L7,37@1323L192,42@1516L31,44@1571L46,48@1642L90,54@1787L574,54@1738L623,71@2388L123,71@2367L144,79@2554L561,79@2517L598,95@3138L12,98@3217L884,98@3190L911:KeepBottomEffect.kt#q34eke");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$keepBottom) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(backFromLogin) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1995593437, $dirty2, -1, "kntr.app.deepsearch.ui.ae.keepBottom (KeepBottomEffect.kt:29)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2085084373, "CC(remember):KeepBottomEffect.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState shouldAutoScroll$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Lifecycle lifecycle = ((LifecycleOwner) consume).getLifecycle();
            ComposerKt.sourceInformationMarkerStart($composer2, -2085079747, "CC(remember):KeepBottomEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(lifecycle);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                final Flow $this$map$iv = lifecycle.getCurrentStateFlow();
                Object value$iv2 = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$lambda$3$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$lambda$3$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$lambda$3$$inlined$map$1$2", f = "KeepBottomEffect.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$lambda$3$$inlined$map$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, (Continuation) this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Boolean boxBoolean = Boxing.boxBoolean(it.isAtLeast(Lifecycle.State.STARTED));
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$map_u24lambda_u245.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            int i = $continuation.I$0;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj = $continuation.L$2;
                                            AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                            Object value2 = $continuation.L$0;
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State pageVisibility = SnapshotStateKt.collectAsState((Flow) it$iv2, false, (CoroutineContext) null, $composer2, 48, 2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2085071957, "CC(remember):KeepBottomEffect.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                z = false;
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                z = false;
            }
            MutableState isAtBottom$delegate2 = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2085069641, "CC(remember):KeepBottomEffect.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int keepBottom$lambda$7$0;
                        keepBottom$lambda$7$0 = KeepBottomEffectKt.keepBottom$lambda$7$0($this$keepBottom);
                        return Integer.valueOf(keepBottom$lambda$7$0);
                    }
                });
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            State layoutCount$delegate = (State) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Boolean valueOf = Boolean.valueOf(backFromLogin);
            Integer valueOf2 = Integer.valueOf(keepBottom$lambda$8(layoutCount$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -2085064517, "CC(remember):KeepBottomEffect.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4 ? true : z) | $composer2.changedInstance(list) | $composer2.changedInstance(lifecycle);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv5 == Composer.Companion.getEmpty()) {
                isAtBottom$delegate = isAtBottom$delegate2;
                str = "CC(remember):KeepBottomEffect.kt#9igjgp";
                value$iv5 = new KeepBottomEffectKt$keepBottom$1$1($this$keepBottom, list, lifecycle, shouldAutoScroll$delegate, layoutCount$delegate, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                str = "CC(remember):KeepBottomEffect.kt#9igjgp";
                isAtBottom$delegate = isAtBottom$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(list, valueOf, valueOf2, (Function2) value$iv5, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112));
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2085045736, str);
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function2) new KeepBottomEffectKt$keepBottom$2$1($this$keepBottom, isAtBottom$delegate, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer2, 6);
            Object value = pageVisibility.getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, -2085039986, str);
            boolean invalid$iv4 = $composer2.changed(pageVisibility) | (($dirty2 & 14) == 4);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv7 = (Function2) new KeepBottomEffectKt$keepBottom$3$1(pageVisibility, $this$keepBottom, shouldAutoScroll$delegate, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(value, (Function2) it$iv6, $composer2, 0);
            boolean imeVisible = ImeVisibleKt.imeVisible($composer2, 0);
            Boolean valueOf3 = Boolean.valueOf(imeVisible);
            ComposerKt.sourceInformationMarkerStart($composer2, -2085018447, str);
            boolean invalid$iv5 = $composer2.changed(imeVisible) | (($dirty2 & 14) == 4);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv8 = (Function2) new KeepBottomEffectKt$keepBottom$4$1(imeVisible, $this$keepBottom, isAtBottom$delegate, null);
                $composer2.updateRememberedValue(value$iv8);
                it$iv7 = value$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv7, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit keepBottom$lambda$13;
                    keepBottom$lambda$13 = KeepBottomEffectKt.keepBottom$lambda$13($this$keepBottom, list, backFromLogin, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return keepBottom$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keepBottom$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepBottom$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keepBottom$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepBottom$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int keepBottom$lambda$8(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int keepBottom$lambda$7$0(LazyListState $this_keepBottom) {
        return $this_keepBottom.getLayoutInfo().getTotalItemsCount();
    }
}