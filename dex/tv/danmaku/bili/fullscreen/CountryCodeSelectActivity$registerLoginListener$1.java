package tv.danmaku.bili.fullscreen;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import kotlin.Metadata;
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
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CountryCodeSelectActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$registerLoginListener$1", f = "CountryCodeSelectActivity.kt", i = {}, l = {BR.episodesScrollerContentDescription}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CountryCodeSelectActivity$registerLoginListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CountryCodeSelectActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryCodeSelectActivity$registerLoginListener$1(CountryCodeSelectActivity countryCodeSelectActivity, Continuation<? super CountryCodeSelectActivity$registerLoginListener$1> continuation) {
        super(2, continuation);
        this.this$0 = countryCodeSelectActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CountryCodeSelectActivity$registerLoginListener$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final CountryCodeSelectActivity countryCodeSelectActivity = this.this$0;
                this.L$0 = countryCodeSelectActivity;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuation it = cancellableContinuationImpl;
                final PassportObserver listener = new PassportObserver() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$registerLoginListener$1$1$listener$1
                    public final void onChange(Topic it2) {
                        CountryCodeSelectActivity.this.finish();
                    }
                };
                BiliAccounts.get((Context) countryCodeSelectActivity).subscribe(Topic.SIGN_IN, listener);
                it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$registerLoginListener$1$1$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((Throwable) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable it2) {
                        BiliAccounts.get((Context) CountryCodeSelectActivity.this).unsubscribeAll(listener);
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                }
                if (result != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                CountryCodeSelectActivity countryCodeSelectActivity2 = (CountryCodeSelectActivity) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}