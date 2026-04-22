package im.session.di;

import im.base.IMLog;
import im.session.log.LogTagKt;
import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMCacheObserver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/base/account/AccountState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.di.IMCacheObserverKt$establishCacheObserver$1$accountEvent$1", f = "IMCacheObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMCacheObserverKt$establishCacheObserver$1$accountEvent$1 extends SuspendLambda implements Function2<AccountState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMCacheObserverKt$establishCacheObserver$1$accountEvent$1(Continuation<? super IMCacheObserverKt$establishCacheObserver$1$accountEvent$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMCacheObserverKt$establishCacheObserver$1$accountEvent$1 = new IMCacheObserverKt$establishCacheObserver$1$accountEvent$1(continuation);
        iMCacheObserverKt$establishCacheObserver$1$accountEvent$1.L$0 = obj;
        return iMCacheObserverKt$establishCacheObserver$1$accountEvent$1;
    }

    public final Object invoke(AccountState accountState, Continuation<? super Unit> continuation) {
        return create(accountState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AccountState it = (AccountState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getCacheLogTag(), "账号状态变化 " + it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}