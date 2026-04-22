package tv.danmaku.bili.fullscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullscreenLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginActivity$onCreate$2$2$1", f = "FullscreenLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginActivity$onCreate$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFullscreenLoginState $page;
    int label;
    final /* synthetic */ FullscreenLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginActivity$onCreate$2$2$1(IFullscreenLoginState iFullscreenLoginState, FullscreenLoginActivity fullscreenLoginActivity, Continuation<? super FullscreenLoginActivity$onCreate$2$2$1> continuation) {
        super(2, continuation);
        this.$page = iFullscreenLoginState;
        this.this$0 = fullscreenLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginActivity$onCreate$2$2$1(this.$page, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$page.getCurrentPage().getLoggedIn()) {
                    BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Logged in, close page");
                    super/*tv.danmaku.bili.fullscreen.Hilt_FullscreenLoginActivity*/.finish();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}