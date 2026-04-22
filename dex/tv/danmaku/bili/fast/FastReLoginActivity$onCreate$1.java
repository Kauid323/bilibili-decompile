package tv.danmaku.bili.fast;

import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fast.FastReLoginActivity$onCreate$1", f = "FastReLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FastReLoginActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastReLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReLoginActivity$onCreate$1(FastReLoginActivity fastReLoginActivity, Continuation<? super FastReLoginActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = fastReLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FastReLoginActivity$onCreate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FastReLoginViewModel viewModel;
        MutableStateFlow mutableStateFlow;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                viewModel = this.this$0.getViewModel();
                SimpleAccountItem account = viewModel.getAccount();
                BLog.i(FastReLoginActivityKt.TAG, "Showing account of " + account);
                if (account != null) {
                    mutableStateFlow = this.this$0.pageStateFlow;
                    mutableStateFlow.setValue(new FastReLoginState(account, false, false, false, 14, null));
                } else {
                    this.this$0.routeToLogin();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}