package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.facade.protocol.IDataStorage;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Idle;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$1$1", f = "OfflineResloveStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineResolveDataStore$machine$1$1$1 extends SuspendLambda implements Function2<State<OfflineResolveState.Idle>, Continuation<? super ChangedState<? extends OfflineResolveState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineResolveDataStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineResolveDataStore$machine$1$1$1(OfflineResolveDataStore offlineResolveDataStore, Continuation<? super OfflineResolveDataStore$machine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = offlineResolveDataStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineResolveDataStore$machine$1$1$1 = new OfflineResolveDataStore$machine$1$1$1(this.this$0, continuation);
        offlineResolveDataStore$machine$1$1$1.L$0 = obj;
        return offlineResolveDataStore$machine$1$1$1;
    }

    public final Object invoke(State<OfflineResolveState.Idle> state, Continuation<? super ChangedState<? extends OfflineResolveState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$1$1$1", f = "OfflineResloveStateMachine.kt", i = {0, 0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-OfflineResolveDataStore$machine$1$1$1$1$1", "it", "$i$a$-let-OfflineResolveDataStore$machine$1$1$1$1$1$1"}, s = {"L$0", "L$1", "I$0", "J$0", "I$1"}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ OfflineResolveDataStore this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineResolveDataStore offlineResolveDataStore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = offlineResolveDataStore;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            String str;
            List list;
            Object videosByVideoId$default;
            CoroutineScope $this$launch = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        OfflineResolveDataStore offlineResolveDataStore = this.this$0;
                        Result.Companion companion = Result.Companion;
                        str = offlineResolveDataStore.videoId;
                        Long longOrNull = StringsKt.toLongOrNull(str);
                        if (longOrNull == null) {
                            list = null;
                            break;
                        } else {
                            long it = longOrNull.longValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.L$1 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.I$0 = 0;
                            this.J$0 = it;
                            this.I$1 = 0;
                            this.label = 1;
                            videosByVideoId$default = IDataStorage.CC.getVideosByVideoId$default(OfflineFacadeImpl_androidKt.getOfflineFacadeImpl(), it, null, this, 2, null);
                            if (videosByVideoId$default != coroutine_suspended) {
                                list = (List) videosByVideoId$default;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        }
                    case 1:
                        int i = this.I$1;
                        long j = this.J$0;
                        int i2 = this.I$0;
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                        ResultKt.throwOnFailure($result);
                        videosByVideoId$default = $result;
                        list = (List) videosByVideoId$default;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl(list);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            OfflineResolveDataStore offlineResolveDataStore2 = this.this$0;
            if (Result.isSuccess-impl(obj)) {
                List offlineVideos = (List) obj;
                offlineResolveDataStore2.dispatch(new OfflineResolvePageEvent.VideosLoaded(offlineVideos == null ? CollectionsKt.emptyList() : offlineVideos));
            }
            OfflineResolveDataStore offlineResolveDataStore3 = this.this$0;
            if (Result.exceptionOrNull-impl(obj) != null) {
                offlineResolveDataStore3.dispatch(OfflineResolvePageEvent.VideosLoadFailed.INSTANCE);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope coroutineScope;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                coroutineScope = this.this$0.scope;
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineResolveState.Loading invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineResolveDataStore$machine$1$1$1.invokeSuspend$lambda$0((OfflineResolveState.Idle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineResolveState.Loading invokeSuspend$lambda$0(OfflineResolveState.Idle $this$override) {
        return OfflineResolveState.Loading.INSTANCE;
    }
}