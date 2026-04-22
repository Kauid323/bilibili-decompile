package tv.danmaku.bili.auth.v2;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;

/* compiled from: BiliOverrideStep2Fragment.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment$requestData$2", f = "BiliOverrideStep2Fragment.kt", i = {}, l = {BR.headerVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliOverrideStep2Fragment$requestData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ String $overrideMid;
    final /* synthetic */ String $requestId;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliOverrideStep2Fragment$requestData$2(String str, String str2, Continuation<? super BiliOverrideStep2Fragment$requestData$2> continuation) {
        super(2, continuation);
        this.$requestId = str;
        this.$overrideMid = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliOverrideStep2Fragment$requestData$2(this.$requestId, this.$overrideMid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = this.$requestId;
                String str2 = this.$overrideMid;
                this.L$0 = str;
                this.L$1 = str2;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation it = cancellableContinuationImpl;
                BiliAuthServiceHelper.getBiliPassportServiceHelper().overrideRealName(str, str2, new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment$requestData$2$1$1
                    public void onDataSuccess(Void data) {
                        Result.Companion companion = Result.Companion;
                        Result result = Result.box-impl(Result.constructor-impl(true));
                        Result.Companion companion2 = Result.Companion;
                        it.resumeWith(Result.constructor-impl(result));
                    }

                    public void onError(Throwable t) {
                        Result.Companion companion = Result.Companion;
                        Intrinsics.checkNotNull(t);
                        Result result = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(t)));
                        Result.Companion companion2 = Result.Companion;
                        it.resumeWith(Result.constructor-impl(result));
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
                String str3 = (String) this.L$1;
                String str4 = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}