package video.biz.offline.base.facade;

import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.download.PauseType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineListener.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.OfflineListenerKt$addAccountListener$2", f = "OfflineListener.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineListenerKt$addAccountListener$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineListenerKt$addAccountListener$2(Continuation<? super OfflineListenerKt$addAccountListener$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineListenerKt$addAccountListener$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OfflineListenerKt.updateVipState((AccountState) KAccountStoreKt.getAccountHolder().getState().getValue());
                this.label = 1;
                if (FlowKt.drop(KAccountStoreKt.getAccountHolder().getState(), 1).collect(AnonymousClass1.INSTANCE, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* renamed from: video.biz.offline.base.facade.OfflineListenerKt$addAccountListener$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public static final AnonymousClass1<T> INSTANCE = new AnonymousClass1<>();

        AnonymousClass1() {
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((AccountState) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c1 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(AccountState state, Continuation<? super Unit> continuation) {
            OfflineListenerKt$addAccountListener$2$1$emit$1 offlineListenerKt$addAccountListener$2$1$emit$1;
            IOfflineFacade offlineFacadeImpl;
            PauseType pauseType;
            if (continuation instanceof OfflineListenerKt$addAccountListener$2$1$emit$1) {
                offlineListenerKt$addAccountListener$2$1$emit$1 = (OfflineListenerKt$addAccountListener$2$1$emit$1) continuation;
                if ((offlineListenerKt$addAccountListener$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    offlineListenerKt$addAccountListener$2$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineListenerKt$addAccountListener$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineListenerKt$addAccountListener$2$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            LogKt.getVBLog().info("Account state changed: " + state);
                            OfflineListenerKt.updateVipState(state);
                            if (state instanceof AccountState.Idle) {
                                IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                offlineListenerKt$addAccountListener$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                offlineListenerKt$addAccountListener$2$1$emit$1.label = 1;
                                if (offlineFacadeImpl2.setMaxConcurrent(1, offlineListenerKt$addAccountListener$2$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (!(state instanceof AccountState.Logged)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                if (((AccountState.Logged) state).getUserInfo().getVip().getStatus() != 1) {
                                    IOfflineFacade offlineFacadeImpl3 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    offlineListenerKt$addAccountListener$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                    offlineListenerKt$addAccountListener$2$1$emit$1.label = 2;
                                    if (offlineFacadeImpl3.setMaxConcurrent(1, offlineListenerKt$addAccountListener$2$1$emit$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            pauseType = PauseType.PAUSE_LOGOUT;
                            offlineListenerKt$addAccountListener$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            offlineListenerKt$addAccountListener$2$1$emit$1.label = 3;
                            if (offlineFacadeImpl.pauseAll(pauseType, offlineListenerKt$addAccountListener$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            state = (AccountState) offlineListenerKt$addAccountListener$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            pauseType = PauseType.PAUSE_LOGOUT;
                            offlineListenerKt$addAccountListener$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            offlineListenerKt$addAccountListener$2$1$emit$1.label = 3;
                            if (offlineFacadeImpl.pauseAll(pauseType, offlineListenerKt$addAccountListener$2$1$emit$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            state = (AccountState) offlineListenerKt$addAccountListener$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            pauseType = PauseType.PAUSE_LOGOUT;
                            offlineListenerKt$addAccountListener$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            offlineListenerKt$addAccountListener$2$1$emit$1.label = 3;
                            if (offlineFacadeImpl.pauseAll(pauseType, offlineListenerKt$addAccountListener$2$1$emit$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 3:
                            AccountState accountState = (AccountState) offlineListenerKt$addAccountListener$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            offlineListenerKt$addAccountListener$2$1$emit$1 = new OfflineListenerKt$addAccountListener$2$1$emit$1(this, continuation);
            Object $result2 = offlineListenerKt$addAccountListener$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (offlineListenerKt$addAccountListener$2$1$emit$1.label) {
            }
        }
    }
}