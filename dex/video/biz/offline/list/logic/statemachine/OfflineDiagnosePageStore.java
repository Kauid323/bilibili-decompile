package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.base.router.Router;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.statemachine.DiagnosticState;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;
import video.biz.offline.list.logic.statemachine.Tag;

/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageStore;", "", "router", "Lkntr/base/router/Router;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/base/router/Router;Lkotlinx/coroutines/CoroutineScope;)V", "storeMachine", "Lkntr/base/udf/StoreMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "getStoreMachine$annotations", "()V", "getStoreMachine", "()Lkntr/base/udf/StoreMachine;", "dispatch", "", "event", "getResolvedTagBy", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDiagnosePageStore {
    public static final int $stable = 8;
    private final Router router;
    private final CoroutineScope scope;
    private final StoreMachine<OfflineDiagnoseState, OfflineDiagnosePageEvent> storeMachine;

    public static /* synthetic */ void getStoreMachine$annotations() {
    }

    public OfflineDiagnosePageStore(Router router, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.router = router;
        this.scope = scope;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = OfflineDiagnoseState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit storeMachine$lambda$0;
                storeMachine$lambda$0 = OfflineDiagnosePageStore.storeMachine$lambda$0(OfflineDiagnosePageStore.this, (FlowReduxStoreBuilder) obj);
                return storeMachine$lambda$0;
            }
        };
        this.storeMachine = new StoreMachine<>(initialState$iv, specBlock$iv);
    }

    public final StoreMachine<OfflineDiagnoseState, OfflineDiagnosePageEvent> getStoreMachine() {
        return this.storeMachine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeMachine$lambda$0(final OfflineDiagnosePageStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit storeMachine$lambda$0$0;
                storeMachine$lambda$0$0 = OfflineDiagnosePageStore.storeMachine$lambda$0$0((InStateBuilderBlock) obj);
                return storeMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineDiagnoseState.Idle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit storeMachine$lambda$0$1;
                storeMachine$lambda$0$1 = OfflineDiagnosePageStore.storeMachine$lambda$0$1(OfflineDiagnosePageStore.this, (InStateBuilderBlock) obj);
                return storeMachine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineDiagnoseState.Loading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit storeMachine$lambda$0$2;
                storeMachine$lambda$0$2 = OfflineDiagnosePageStore.storeMachine$lambda$0$2(OfflineDiagnosePageStore.this, (InStateBuilderBlock) obj);
                return storeMachine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineDiagnoseState.Success.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeMachine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineDiagnosePageStore$storeMachine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineDiagnosePageEvent.FetchAllVideos.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeMachine$lambda$0$1(OfflineDiagnosePageStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new OfflineDiagnosePageStore$storeMachine$1$2$1($this$inState, this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineDiagnosePageStore$storeMachine$1$2$2(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineDiagnosePageEvent.VideosLoaded.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineDiagnosePageStore$storeMachine$1$2$3(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineDiagnosePageEvent.VideosLoadFailed.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeMachine$lambda$0$2(OfflineDiagnosePageStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineDiagnosePageStore$storeMachine$1$3$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineDiagnosePageEvent.NavToDiagnoseResultBy.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineDiagnosePageStore$storeMachine$1$3$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineDiagnosePageEvent.FetchAllVideos.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    public final void dispatch(OfflineDiagnosePageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDiagnosePageStore$dispatch$1(this, event, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getResolvedTagBy(OfflineVideoEntity videoEntity, Continuation<? super Tag> continuation) {
        OfflineDiagnosePageStore$getResolvedTagBy$1 offlineDiagnosePageStore$getResolvedTagBy$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof OfflineDiagnosePageStore$getResolvedTagBy$1) {
            offlineDiagnosePageStore$getResolvedTagBy$1 = (OfflineDiagnosePageStore$getResolvedTagBy$1) continuation;
            if ((offlineDiagnosePageStore$getResolvedTagBy$1.label & Integer.MIN_VALUE) != 0) {
                offlineDiagnosePageStore$getResolvedTagBy$1.label -= Integer.MIN_VALUE;
                Object $result = offlineDiagnosePageStore$getResolvedTagBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineDiagnosePageStore$getResolvedTagBy$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        offlineDiagnosePageStore$getResolvedTagBy$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        offlineDiagnosePageStore$getResolvedTagBy$1.label = 1;
                        from = companion.from(videoEntity, offlineDiagnosePageStore$getResolvedTagBy$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) offlineDiagnosePageStore$getResolvedTagBy$1.L$0;
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                state = (DiagnosticState) from;
                if (state instanceof DiagnosticState.Completed) {
                    if (state instanceof DiagnosticState.Damaged) {
                        return new Tag.Damage(null, null, 3, null);
                    }
                    if (state instanceof DiagnosticState.Incomplete) {
                        return new Tag.Incomplete(null, null, 3, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new Tag.Complete(null, null, 3, null);
            }
        }
        offlineDiagnosePageStore$getResolvedTagBy$1 = new OfflineDiagnosePageStore$getResolvedTagBy$1(this, continuation);
        Object $result2 = offlineDiagnosePageStore$getResolvedTagBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineDiagnosePageStore$getResolvedTagBy$1.label) {
        }
        state = (DiagnosticState) from;
        if (state instanceof DiagnosticState.Completed) {
        }
    }
}