package im.session.di;

import host.R;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.service.IMSessionDataCacheService;
import kntr.base.account.KAccountStore;
import kntr.common.restricted.IRestrictedMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMCacheObserver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.di.IMCacheObserverKt$establishCacheObserver$1", f = "IMCacheObserver.kt", i = {0, 0}, l = {R.styleable.CameraView_cameraSnapshotMaxWidth}, m = "invokeSuspend", n = {"accountEvent", "restrictedEvent"}, s = {"L$0", "L$1"}, v = 1)
public final class IMCacheObserverKt$establishCacheObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KAccountStore $account;
    final /* synthetic */ IMSessionDataCacheService $cacheService;
    final /* synthetic */ IRestrictedMode $restrictedMode;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMCacheObserverKt$establishCacheObserver$1(KAccountStore kAccountStore, IRestrictedMode iRestrictedMode, IMSessionDataCacheService iMSessionDataCacheService, Continuation<? super IMCacheObserverKt$establishCacheObserver$1> continuation) {
        super(2, continuation);
        this.$account = kAccountStore;
        this.$restrictedMode = iRestrictedMode;
        this.$cacheService = iMSessionDataCacheService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMCacheObserverKt$establishCacheObserver$1(this.$account, this.$restrictedMode, this.$cacheService, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.d(LogTagKt.getCacheLogTag(), "establishCacheObserver");
                Flow accountEvent = FlowKt.onEach(FlowKt.drop(this.$account.getState(), 1), new IMCacheObserverKt$establishCacheObserver$1$accountEvent$1(null));
                Flow restrictedEvent = FlowKt.onEach(this.$restrictedMode.getStateChange(), new IMCacheObserverKt$establishCacheObserver$1$restrictedEvent$1(null));
                Flow merge = FlowKt.merge(new Flow[]{accountEvent, restrictedEvent});
                final IMSessionDataCacheService iMSessionDataCacheService = this.$cacheService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(accountEvent);
                this.L$1 = SpillingKt.nullOutSpilledVariable(restrictedEvent);
                this.label = 1;
                if (merge.collect(new FlowCollector() { // from class: im.session.di.IMCacheObserverKt$establishCacheObserver$1.1
                    public final Object emit(Object obj, Continuation<? super Unit> continuation) {
                        IMLog.Companion.i(LogTagKt.getCacheLogTag(), "将要清除会话列表缓存");
                        IMSessionDataCacheService.this.clearAll();
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Flow flow = (Flow) this.L$1;
                Flow flow2 = (Flow) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}