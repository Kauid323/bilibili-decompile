package tv.danmaku.bili.components;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeStatusBarComponent.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt$enterFullscreen$2", f = "HomeStatusBarComponent.kt", i = {}, l = {BR.content}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeStatusBarComponentKt$enterFullscreen$2 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainActivityV2 $this_enterFullscreen;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeStatusBarComponentKt$enterFullscreen$2(MainActivityV2 mainActivityV2, Continuation<? super HomeStatusBarComponentKt$enterFullscreen$2> continuation) {
        super(2, continuation);
        this.$this_enterFullscreen = mainActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> homeStatusBarComponentKt$enterFullscreen$2 = new HomeStatusBarComponentKt$enterFullscreen$2(this.$this_enterFullscreen, continuation);
        homeStatusBarComponentKt$enterFullscreen$2.L$0 = obj;
        return homeStatusBarComponentKt$enterFullscreen$2;
    }

    public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                this.$this_enterFullscreen.getWindow().clearFlags(67108864);
                this.$this_enterFullscreen.getWindow().addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = this.$this_enterFullscreen.getWindow().getDecorView().getSystemUiVisibility() | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText;
                this.$this_enterFullscreen.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
                this.$this_enterFullscreen.getWindow().setStatusBarColor(0);
                ViewTreeObserver viewTreeObserver = this.$this_enterFullscreen.getWindow().getDecorView().getViewTreeObserver();
                final MainActivityV2 mainActivityV2 = this.$this_enterFullscreen;
                viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.components.HomeStatusBarComponentKt$enterFullscreen$2.1
                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowAttached() {
                        BLog.i("[Home]HomeStatusBarComponent", "enterFullscreen, onWindowAttached");
                        MainActivityV2.this.getWindow().getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
                        $this$callbackFlow.trySend-JP2dKIU(true);
                    }

                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowDetached() {
                    }
                });
                this.label = 1;
                if (ProduceKt.awaitClose$default($this$callbackFlow, (Function0) null, (Continuation) this, 1, (Object) null) == coroutine_suspended) {
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
}