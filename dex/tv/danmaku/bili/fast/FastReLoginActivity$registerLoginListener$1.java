package tv.danmaku.bili.fast;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.RouteUtilKt;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fast.FastReLoginActivity$registerLoginListener$1", f = "FastReLoginActivity.kt", i = {}, l = {BR.labelVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FastReLoginActivity$registerLoginListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ FastReLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReLoginActivity$registerLoginListener$1(FastReLoginActivity fastReLoginActivity, Continuation<? super FastReLoginActivity$registerLoginListener$1> continuation) {
        super(2, continuation);
        this.this$0 = fastReLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FastReLoginActivity$registerLoginListener$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final FastReLoginActivity fastReLoginActivity = this.this$0;
                this.L$0 = fastReLoginActivity;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuation it = cancellableContinuationImpl;
                final Context context = fastReLoginActivity.getApplicationContext();
                final PassportObserver listener = new PassportObserver() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$registerLoginListener$1$1$listener$1

                    /* compiled from: FastReLoginActivity.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    @DebugMetadata(c = "tv.danmaku.bili.fast.FastReLoginActivity$registerLoginListener$1$1$listener$1$1", f = "FastReLoginActivity.kt", i = {}, l = {BR.errorTip}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: tv.danmaku.bili.fast.FastReLoginActivity$registerLoginListener$1$1$listener$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ FastReLoginActivity this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(FastReLoginActivity fastReLoginActivity, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = fastReLoginActivity;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (DelayKt.delay(500L, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            RouteRequest relayRequest = RouteUtilKt.getForwardRequest(this.this$0.getIntent());
                            if (this.this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) && relayRequest != null && DeviceDecision.INSTANCE.getBoolean("dd_relay_request_on_fast_re_login", true)) {
                                BLRouter.routeTo(relayRequest, (Context) this.this$0);
                            }
                            this.this$0.finish();
                            return Unit.INSTANCE;
                        }
                    }

                    public final void onChange(Topic it2) {
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE.plus(Dispatchers.getMain())), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(FastReLoginActivity.this, null), 3, (Object) null);
                    }
                };
                BiliAccounts.get(context).subscribe(Topic.SIGN_IN, listener);
                it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$registerLoginListener$1$1$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((Throwable) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable it2) {
                        BiliAccounts.get(context).unsubscribeAll(listener);
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
                FastReLoginActivity fastReLoginActivity2 = (FastReLoginActivity) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}