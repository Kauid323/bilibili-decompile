package tv.danmaku.bili.auth.modify;

import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.ModifyAllowBean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliAuthModifyFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$getModifyAllow$2", f = "BiliAuthModifyFragment.kt", i = {}, l = {BR.half}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliAuthModifyFragment$getModifyAllow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthModifyFragment$getModifyAllow$2(Continuation<? super BiliAuthModifyFragment$getModifyAllow$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliAuthModifyFragment$getModifyAllow$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation continuation = cancellableContinuationImpl;
                BiliAuthServiceHelper.getBiliPassportServiceHelper().getModifyAllow(new BiliApiDataCallback<ModifyAllowBean>() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$getModifyAllow$2$1$1
                    public void onError(Throwable t) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(false));
                        BLog.e(BiliAuthModifyFragment.TAG, "request modifyAllow error: " + (t != null ? t.getMessage() : null));
                    }

                    public void onDataSuccess(ModifyAllowBean data) {
                        if (data != null) {
                            Result.Companion companion = Result.Companion;
                            continuation.resumeWith(Result.constructor-impl(Boolean.valueOf(data.getAllow())));
                            return;
                        }
                        Result.Companion companion2 = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(false));
                    }
                });
                continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$getModifyAllow$2$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((Throwable) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable it) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(false));
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}