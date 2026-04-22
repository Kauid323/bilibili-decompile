package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.list.logic.model.OfflineDownloadingCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/StartAll;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$3", f = "OfflineDownloadingPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineDownloadingPageStateMachine$childSpec$3 extends SuspendLambda implements Function3<StartAll, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineDownloadingPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDownloadingPageStateMachine$childSpec$3(OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine, Continuation<? super OfflineDownloadingPageStateMachine$childSpec$3> continuation) {
        super(3, continuation);
        this.this$0 = offlineDownloadingPageStateMachine;
    }

    public final Object invoke(StartAll startAll, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineDownloadingPageStateMachine$childSpec$3 offlineDownloadingPageStateMachine$childSpec$3 = new OfflineDownloadingPageStateMachine$childSpec$3(this.this$0, continuation);
        offlineDownloadingPageStateMachine$childSpec$3.L$0 = state;
        return offlineDownloadingPageStateMachine$childSpec$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean freeBandwidthError;
        CoroutineScope coroutineScope;
        OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine;
        boolean z;
        final OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine2;
        Iterable $this$any$iv;
        boolean isFreeBandWidthError;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().info("start all downloading tasks.");
                if (Config.Companion.getHitFreeBandWidthFix865()) {
                    Iterable $this$any$iv2 = ((OfflinePageState) state.getSnapshot()).getDownloading();
                    if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                        $this$any$iv = null;
                    } else {
                        Iterator<T> it = $this$any$iv2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv = it.next();
                                OfflineDownloadingCardModel it2 = (OfflineDownloadingCardModel) element$iv;
                                isFreeBandWidthError = OfflineDownloadingPageStateMachineKt.isFreeBandWidthError(it2.getErrorCode());
                                if (isFreeBandWidthError) {
                                    $this$any$iv = 1;
                                }
                            } else {
                                $this$any$iv = null;
                            }
                        }
                    }
                    if ($this$any$iv != null) {
                        freeBandwidthError = true;
                        coroutineScope = this.this$0.scope;
                        offlineDownloadingPageStateMachine = this.this$0;
                        z = freeBandwidthError;
                        offlineDownloadingPageStateMachine2 = this.this$0;
                        if (UtilsKt.checkNetworkState(coroutineScope, offlineDownloadingPageStateMachine, z, new Function0() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = OfflineDownloadingPageStateMachine$childSpec$3.invokeSuspend$lambda$1(OfflineDownloadingPageStateMachine.this);
                                return invokeSuspend$lambda$1;
                            }
                        })) {
                            this.this$0.processWithLoading(this.this$0, new AnonymousClass2(null));
                        }
                        return state.noChange();
                    }
                }
                freeBandwidthError = false;
                coroutineScope = this.this$0.scope;
                offlineDownloadingPageStateMachine = this.this$0;
                if (freeBandwidthError) {
                }
                offlineDownloadingPageStateMachine2 = this.this$0;
                if (UtilsKt.checkNetworkState(coroutineScope, offlineDownloadingPageStateMachine, z, new Function0() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$3$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = OfflineDownloadingPageStateMachine$childSpec$3.invokeSuspend$lambda$1(OfflineDownloadingPageStateMachine.this);
                        return invokeSuspend$lambda$1;
                    }
                })) {
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(OfflineDownloadingPageStateMachine this$0) {
        if (Config.Companion.getHitFreeBandWidthFix865()) {
            Config.Companion.setEnableDownloadWithWWAN(true);
        }
        this$0.processWithLoading(this$0, new OfflineDownloadingPageStateMachine$childSpec$3$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineDownloadingPageStateMachine.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$3$2", f = "OfflineDownloadingPageStateMachine.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$3$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().startAll((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}