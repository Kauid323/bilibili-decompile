package kntr.common.pv;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: PvEventTrigger.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eJ\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkntr/common/pv/PvEventTrigger;", "", "stataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/common/pv/PvState;", "eventId", "", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Ljava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "_extraMap", "", "extraMap", "", "getExtraMap", "()Ljava/util/Map;", CommonProjectType.REPORTER, "Lkntr/common/pv/PvReporter;", "startObserve", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExtra", "", "map", "onVisible", "loadType", "Lkntr/common/pv/PageLoadType;", "onInvisible", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PvEventTrigger {
    private final Map<String, String> _extraMap;
    private final String eventId;
    private final PvReporter reporter;
    private final StateFlow<PvState> stataFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public PvEventTrigger(StateFlow<? extends PvState> stateFlow, String eventId) {
        Intrinsics.checkNotNullParameter(stateFlow, "stataFlow");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.stataFlow = stateFlow;
        this.eventId = eventId;
        this._extraMap = new LinkedHashMap();
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        this.reporter = (PvReporter) ((PvReporterEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(PvReporterEntryPoint.class))).getReporter().orNull();
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final Map<String, String> getExtraMap() {
        return this._extraMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: all -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:28:0x007a, B:29:0x007f, B:25:0x0071), top: B:34:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startObserve(Continuation<?> continuation) {
        PvEventTrigger$startObserve$1 pvEventTrigger$startObserve$1;
        try {
            if (continuation instanceof PvEventTrigger$startObserve$1) {
                pvEventTrigger$startObserve$1 = (PvEventTrigger$startObserve$1) continuation;
                if ((pvEventTrigger$startObserve$1.label & Integer.MIN_VALUE) != 0) {
                    pvEventTrigger$startObserve$1.label -= Integer.MIN_VALUE;
                    Object $result = pvEventTrigger$startObserve$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (pvEventTrigger$startObserve$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            final Flow $this$filter$iv = this.stataFlow;
                            pvEventTrigger$startObserve$1.label = 1;
                            if (FlowKt.first(new Flow<PvState>() { // from class: kntr.common.pv.PvEventTrigger$startObserve$$inlined$filter$1

                                /* compiled from: Emitters.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                /* renamed from: kntr.common.pv.PvEventTrigger$startObserve$$inlined$filter$1$2  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class AnonymousClass2<T> implements FlowCollector {
                                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                                    /* compiled from: Emitters.kt */
                                    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                    @DebugMetadata(c = "kntr.common.pv.PvEventTrigger$startObserve$$inlined$filter$1$2", f = "PvEventTrigger.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                    /* renamed from: kntr.common.pv.PvEventTrigger$startObserve$$inlined$filter$1$2$1  reason: invalid class name */
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
                                                        FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                                        AnonymousClass1 anonymousClass1 = $continuation;
                                                        PvState it = (PvState) value;
                                                        if (it == PvState.Visible) {
                                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                            $continuation.I$0 = 0;
                                                            $continuation.label = 1;
                                                            if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                                break;
                                                            } else {
                                                                return coroutine_suspended;
                                                            }
                                                        }
                                                        break;
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
                                    Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                }
                            }, pvEventTrigger$startObserve$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            onVisible(PageLoadType.Show);
                            pvEventTrigger$startObserve$1.label = 2;
                            if (CoroutineScopeKt.coroutineScope(new PvEventTrigger$startObserve$3(this, null), pvEventTrigger$startObserve$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pvEventTrigger$startObserve$1.label = 3;
                            if (DelayKt.awaitCancellation(pvEventTrigger$startObserve$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw new KotlinNothingValueException();
                        case 1:
                            ResultKt.throwOnFailure($result);
                            onVisible(PageLoadType.Show);
                            pvEventTrigger$startObserve$1.label = 2;
                            if (CoroutineScopeKt.coroutineScope(new PvEventTrigger$startObserve$3(this, null), pvEventTrigger$startObserve$1) == coroutine_suspended) {
                            }
                            pvEventTrigger$startObserve$1.label = 3;
                            if (DelayKt.awaitCancellation(pvEventTrigger$startObserve$1) == coroutine_suspended) {
                            }
                            throw new KotlinNothingValueException();
                        case 2:
                            ResultKt.throwOnFailure($result);
                            pvEventTrigger$startObserve$1.label = 3;
                            if (DelayKt.awaitCancellation(pvEventTrigger$startObserve$1) == coroutine_suspended) {
                            }
                            throw new KotlinNothingValueException();
                        case 3:
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (pvEventTrigger$startObserve$1.label) {
            }
        } catch (Throwable th) {
            if (this.stataFlow.getValue() != PvState.Invisible) {
                onInvisible();
            }
            throw th;
        }
        pvEventTrigger$startObserve$1 = new PvEventTrigger$startObserve$1(this, continuation);
        Object $result2 = pvEventTrigger$startObserve$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final void updateExtra(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this._extraMap.putAll(map);
        ILogger kLog = KLog_androidKt.getKLog();
        String str = this.eventId;
        kLog.i(PvReporterKt.TAG, str + " new extra: " + this._extraMap);
        PvReporter pvReporter = this.reporter;
        if (pvReporter != null) {
            pvReporter.updateExtra(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVisible(PageLoadType loadType) {
        KLog_androidKt.getKLog().i(PvReporterKt.TAG, this.eventId + " visible with loadType: " + loadType);
        PvReporter pvReporter = this.reporter;
        if (pvReporter != null) {
            pvReporter.onPageVisible(this, loadType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInvisible() {
        KLog_androidKt.getKLog().i(PvReporterKt.TAG, this.eventId + " invisible");
        PvReporter pvReporter = this.reporter;
        if (pvReporter != null) {
            pvReporter.onPageInvisible(this);
        }
    }
}