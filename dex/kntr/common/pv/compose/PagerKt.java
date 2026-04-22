package kntr.common.pv.compose;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvState;
import kntr.common.pv.TransformerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u000e"}, d2 = {"rememberPvEventTrigger", "Lkntr/common/pv/PvEventTrigger;", "eventId", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "currentIndex", "", "(Ljava/lang/String;Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/runtime/Composer;I)Lkntr/common/pv/PvEventTrigger;", "visibleStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/common/pv/PvState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PagerKt {
    public static final PvEventTrigger rememberPvEventTrigger(String eventId, PagerState pagerState, int currentIndex, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        ComposerKt.sourceInformationMarkerStart($composer, -979210020, "C(rememberPvEventTrigger)N(eventId,pagerState,currentIndex)29@899L24,31@960L116,35@1128L7,39@1317L189:Pager.kt#yg035s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-979210020, $changed, -1, "kntr.common.pv.compose.rememberPvEventTrigger (Pager.kt:28)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        CoroutineScope scope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -422984976, "CC(remember):Pager.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(eventId)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(pagerState)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(currentIndex)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = visibleStateFlow(pagerState, scope, currentIndex);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        StateFlow pagerVisibleState = (StateFlow) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        StateFlow visibleState = FlowKt.stateIn(TransformerKt.combineAtMost(TransformerKt.toPvStateFlow(((LifecycleOwner) consume).getLifecycle()), pagerVisibleState), scope, SharingStarted.Companion.getLazily(), PvState.Invisible);
        ComposerKt.sourceInformationMarkerStart($composer, -422973479, "CC(remember):Pager.kt#9igjgp");
        boolean invalid$iv2 = (((($changed & 14) ^ 6) > 4 && $composer.changed(eventId)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(pagerState)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(currentIndex)) || ($changed & 384) == 256);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            PvEventTrigger it = new PvEventTrigger(visibleState, eventId);
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$rememberPvEventTrigger$1$1$1(it, null), 3, (Object) null);
            $composer.updateRememberedValue(it);
            it$iv2 = it;
        }
        PvEventTrigger pvEventTrigger = (PvEventTrigger) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return pvEventTrigger;
    }

    public static final StateFlow<PvState> visibleStateFlow(final PagerState $this$visibleStateFlow, CoroutineScope scope, final int currentIndex) {
        Intrinsics.checkNotNullParameter($this$visibleStateFlow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.pv.compose.PagerKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean visibleStateFlow$lambda$0;
                visibleStateFlow$lambda$0 = PagerKt.visibleStateFlow$lambda$0($this$visibleStateFlow, currentIndex);
                return Boolean.valueOf(visibleStateFlow$lambda$0);
            }
        });
        return FlowKt.stateIn(new Flow<PvState>() { // from class: kntr.common.pv.compose.PagerKt$visibleStateFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.common.pv.compose.PagerKt$visibleStateFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.common.pv.compose.PagerKt$visibleStateFlow$$inlined$map$1$2", f = "Pager.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.common.pv.compose.PagerKt$visibleStateFlow$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    boolean it = ((Boolean) value).booleanValue();
                                    PvState pvState = it ? PvState.Visible : PvState.Invisible;
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(pvState, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
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
        }, scope, SharingStarted.Companion.getLazily(), PvState.Invisible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean visibleStateFlow$lambda$0(PagerState $this_visibleStateFlow, int $currentIndex) {
        if ($this_visibleStateFlow.getCurrentPage() == $currentIndex && $this_visibleStateFlow.getTargetPage() == $currentIndex) {
            return ($this_visibleStateFlow.getCurrentPageOffsetFraction() > 0.0f ? 1 : ($this_visibleStateFlow.getCurrentPageOffsetFraction() == 0.0f ? 0 : -1)) == 0;
        }
        return false;
    }
}