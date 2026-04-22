package tv.danmaku.bili.fullscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullscreenLoginViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel", f = "FullscreenLoginViewModel.kt", i = {1}, l = {BR.chatRoomConfig, 100}, m = "interceptAction", n = {"toIntercept"}, s = {"I$0"}, v = 1)
public final class FullscreenLoginViewModel$interceptAction$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginViewModel$interceptAction$1(FullscreenLoginViewModel fullscreenLoginViewModel, Continuation<? super FullscreenLoginViewModel$interceptAction$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenLoginViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object interceptAction;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        interceptAction = this.this$0.interceptAction(null, (Continuation) this);
        return interceptAction;
    }
}