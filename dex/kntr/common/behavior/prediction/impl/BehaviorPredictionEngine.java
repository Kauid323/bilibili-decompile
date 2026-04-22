package kntr.common.behavior.prediction.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.utils.CoroutineExKt;
import kntr.common.behavior.prediction.BehaviorPredictionService;
import kntr.common.behavior.prediction.IBehaviorData;
import kntr.common.behavior.prediction.IPredictionContext;
import kntr.common.behavior.prediction.IPredictionResult;
import kntr.common.behavior.prediction.event.IBPNeuronEventHandler;
import kntr.common.behavior.prediction.event.VideoQualityEventHandler;
import kntr.common.behavior.prediction.predictor.IBehaviorPredictor;
import kntr.common.behavior.prediction.predictor.VideoQualityPredictor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BehaviorPredictionEngine.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkntr/common/behavior/prediction/impl/BehaviorPredictionEngine;", "Lkntr/common/behavior/prediction/BehaviorPredictionService;", "<init>", "()V", "cache", "Lkntr/common/behavior/prediction/impl/BPCache;", "isInitialized", "Lkotlinx/atomicfu/AtomicBoolean;", "disabledPredictorNames", "", "", "enableObserveNeuron", "", "disabledEventHandlerNames", "predictors", "", "Lkntr/common/behavior/prediction/predictor/IBehaviorPredictor;", "neuronEventHandlers", "Lkntr/common/behavior/prediction/event/IBPNeuronEventHandler;", "observerScope", "Lkotlinx/coroutines/CoroutineScope;", "start", "", "update", "data", "Lkntr/common/behavior/prediction/IBehaviorData;", "predict", "Lkntr/common/behavior/prediction/IPredictionResult;", "context", "Lkntr/common/behavior/prediction/IPredictionContext;", "onEvent", "event", "Lkntr/base/neuron/IPlatformNeuron$Event;", "(Lkntr/base/neuron/IPlatformNeuron$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BehaviorPredictionEngine implements BehaviorPredictionService {
    private final List<IBPNeuronEventHandler> neuronEventHandlers;
    private final CoroutineScope observerScope;
    private final List<IBehaviorPredictor> predictors;
    private final BPCache cache = new BPCache(0, 1, null);
    private final AtomicBoolean isInitialized = AtomicFU.atomic(false);
    private final Set<String> disabledPredictorNames = UtilsKt.getSetValue$default(KConfig.INSTANCE, "bp.disabled_predictor_names", null, null, 6, null);
    private final boolean enableObserveNeuron = KConfig.INSTANCE.ff("bp.enable_observe_neuron", false);
    private final Set<String> disabledEventHandlerNames = UtilsKt.getSetValue$default(KConfig.INSTANCE, "bp.disabled_neuron_event_handler_names", null, null, 6, null);

    public BehaviorPredictionEngine() {
        List it;
        List $this$predictors_u24lambda_u240 = CollectionsKt.createListBuilder();
        if (!this.disabledPredictorNames.contains("video-quality")) {
            $this$predictors_u24lambda_u240.add(new VideoQualityPredictor(this.cache));
        }
        List it2 = CollectionsKt.build($this$predictors_u24lambda_u240);
        UtilsKt.logI("Engine", "predictors: " + CollectionsKt.joinToString$default(it2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.common.behavior.prediction.impl.BehaviorPredictionEngine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence predictors$lambda$1$0;
                predictors$lambda$1$0 = BehaviorPredictionEngine.predictors$lambda$1$0((IBehaviorPredictor) obj);
                return predictors$lambda$1$0;
            }
        }, 30, (Object) null));
        this.predictors = it2;
        if (!this.enableObserveNeuron) {
            it = CollectionsKt.emptyList();
        } else {
            Iterable $this$filter$iv = CollectionsKt.listOf(new VideoQualityEventHandler(null, 1, null));
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                if (!this.disabledEventHandlerNames.contains(((IBPNeuronEventHandler) element$iv$iv).getName())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            it = (List) destination$iv$iv;
            UtilsKt.logI("Engine", "neuronEventHandlers: " + CollectionsKt.joinToString$default(it, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.common.behavior.prediction.impl.BehaviorPredictionEngine$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    CharSequence neuronEventHandlers$lambda$1$0;
                    neuronEventHandlers$lambda$1$0 = BehaviorPredictionEngine.neuronEventHandlers$lambda$1$0((IBPNeuronEventHandler) obj);
                    return neuronEventHandlers$lambda$1$0;
                }
            }, 30, (Object) null));
        }
        this.neuronEventHandlers = it;
        this.observerScope = this.enableObserveNeuron ? CoroutineExKt.createIOScope() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence predictors$lambda$1$0(IBehaviorPredictor p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return p.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence neuronEventHandlers$lambda$1$0(IBPNeuronEventHandler e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return e.getName();
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void start() {
        UtilsKt.logI("Engine", "start");
        if (!this.isInitialized.getValue()) {
            this.isInitialized.setValue(true);
            Iterable $this$forEach$iv = this.predictors;
            for (Object element$iv : $this$forEach$iv) {
                IBehaviorPredictor it = (IBehaviorPredictor) element$iv;
                it.start();
            }
            CoroutineScope coroutineScope = this.observerScope;
            if (coroutineScope != null) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BehaviorPredictionEngine$start$2(this, null), 3, (Object) null);
            }
            UtilsKt.logI("Engine", "isInitialized");
        }
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void update(IBehaviorData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterable $this$forEach$iv = this.predictors;
        for (Object element$iv : $this$forEach$iv) {
            IBehaviorPredictor it = (IBehaviorPredictor) element$iv;
            it.update(data);
        }
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public IPredictionResult predict(IPredictionContext context) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(context, "context");
        Iterable $this$firstOrNull$iv = this.predictors;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                IBehaviorPredictor it2 = (IBehaviorPredictor) element$iv;
                if (it2.canPredict(context)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        IBehaviorPredictor iBehaviorPredictor = (IBehaviorPredictor) element$iv;
        if (iBehaviorPredictor != null) {
            return iBehaviorPredictor.predict(context);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0091 -> B:20:0x009b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onEvent(IPlatformNeuron.Event event, Continuation<? super Unit> continuation) {
        BehaviorPredictionEngine$onEvent$1 behaviorPredictionEngine$onEvent$1;
        int $i$f$forEach;
        Iterable $this$forEach$iv;
        Iterator it;
        BehaviorPredictionEngine behaviorPredictionEngine;
        Object $result;
        Iterable $this$forEach$iv2;
        Iterator it2;
        int $i$f$forEach2;
        BehaviorPredictionEngine behaviorPredictionEngine2;
        Object obj;
        IBehaviorData data;
        if (continuation instanceof BehaviorPredictionEngine$onEvent$1) {
            behaviorPredictionEngine$onEvent$1 = (BehaviorPredictionEngine$onEvent$1) continuation;
            if ((behaviorPredictionEngine$onEvent$1.label & Integer.MIN_VALUE) != 0) {
                behaviorPredictionEngine$onEvent$1.label -= Integer.MIN_VALUE;
                Object $result2 = behaviorPredictionEngine$onEvent$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (behaviorPredictionEngine$onEvent$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Iterable $this$forEach$iv3 = this.neuronEventHandlers;
                        $i$f$forEach = 0;
                        $this$forEach$iv = $this$forEach$iv3;
                        it = $this$forEach$iv3.iterator();
                        behaviorPredictionEngine = this;
                        break;
                    case 1:
                        int i = behaviorPredictionEngine$onEvent$1.I$1;
                        int $i$f$forEach3 = behaviorPredictionEngine$onEvent$1.I$0;
                        IBPNeuronEventHandler iBPNeuronEventHandler = (IBPNeuronEventHandler) behaviorPredictionEngine$onEvent$1.L$4;
                        Object obj2 = behaviorPredictionEngine$onEvent$1.L$3;
                        event = (IPlatformNeuron.Event) behaviorPredictionEngine$onEvent$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$forEach$iv2 = (Iterable) behaviorPredictionEngine$onEvent$1.L$1;
                        obj = $result3;
                        it2 = (Iterator) behaviorPredictionEngine$onEvent$1.L$2;
                        $result = $result2;
                        $i$f$forEach2 = $i$f$forEach3;
                        behaviorPredictionEngine2 = this;
                        data = (IBehaviorData) $result2;
                        if (data != null) {
                            behaviorPredictionEngine2.update(data);
                        }
                        $result2 = $result;
                        $result3 = obj;
                        behaviorPredictionEngine = behaviorPredictionEngine2;
                        $i$f$forEach = $i$f$forEach2;
                        it = it2;
                        $this$forEach$iv = $this$forEach$iv2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    IBPNeuronEventHandler it3 = (IBPNeuronEventHandler) element$iv;
                    behaviorPredictionEngine$onEvent$1.L$0 = event;
                    behaviorPredictionEngine$onEvent$1.L$1 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                    behaviorPredictionEngine$onEvent$1.L$2 = it;
                    behaviorPredictionEngine$onEvent$1.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
                    behaviorPredictionEngine$onEvent$1.L$4 = SpillingKt.nullOutSpilledVariable(it3);
                    behaviorPredictionEngine$onEvent$1.I$0 = $i$f$forEach;
                    behaviorPredictionEngine$onEvent$1.I$1 = 0;
                    behaviorPredictionEngine$onEvent$1.label = 1;
                    Object handle = it3.handle(event, behaviorPredictionEngine$onEvent$1);
                    if (handle == $result3) {
                        return $result3;
                    }
                    Object obj3 = $result3;
                    $result = $result2;
                    $result2 = handle;
                    $this$forEach$iv2 = $this$forEach$iv;
                    it2 = it;
                    $i$f$forEach2 = $i$f$forEach;
                    behaviorPredictionEngine2 = behaviorPredictionEngine;
                    obj = obj3;
                    data = (IBehaviorData) $result2;
                    if (data != null) {
                    }
                    $result2 = $result;
                    $result3 = obj;
                    behaviorPredictionEngine = behaviorPredictionEngine2;
                    $i$f$forEach = $i$f$forEach2;
                    it = it2;
                    $this$forEach$iv = $this$forEach$iv2;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        behaviorPredictionEngine$onEvent$1 = new BehaviorPredictionEngine$onEvent$1(this, continuation);
        Object $result22 = behaviorPredictionEngine$onEvent$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (behaviorPredictionEngine$onEvent$1.label) {
        }
        if (it.hasNext()) {
        }
    }
}