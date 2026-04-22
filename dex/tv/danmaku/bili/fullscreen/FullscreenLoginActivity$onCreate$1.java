package tv.danmaku.bili.fullscreen;

import android.app.Application;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;

/* compiled from: FullscreenLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginActivity$onCreate$1", f = "FullscreenLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FullscreenLoginActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginActivity$onCreate$1(FullscreenLoginActivity fullscreenLoginActivity, Continuation<? super FullscreenLoginActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fullscreenLoginActivity$onCreate$1 = new FullscreenLoginActivity$onCreate$1(this.this$0, continuation);
        fullscreenLoginActivity$onCreate$1.L$0 = obj;
        return fullscreenLoginActivity$onCreate$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                FullscreenLoginActivity fullscreenLoginActivity = this.this$0;
                Application application = this.this$0.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
                LoginSuccessProcessorKt.onLoginPageEnter(fullscreenLoginActivity, application, LoginUIType.FULL);
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginActivity$onCreate$1$invokeSuspend$$inlined$awaitCancel$1(null, this.this$0), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}