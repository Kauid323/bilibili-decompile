package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.login.OnePassLoginCheckViewModel", f = "OnePassLoginCheckViewModel.kt", i = {}, l = {BR.bgWidth}, m = "dispose", n = {}, s = {}, v = 1)
public final class OnePassLoginCheckViewModel$dispose$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnePassLoginCheckViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginCheckViewModel$dispose$1(OnePassLoginCheckViewModel onePassLoginCheckViewModel, Continuation<? super OnePassLoginCheckViewModel$dispose$1> continuation) {
        super(continuation);
        this.this$0 = onePassLoginCheckViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.dispose((Continuation) this);
    }
}