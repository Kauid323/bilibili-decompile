package tv.danmaku.bili.ui.login.helper.reducer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkCheckReducer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.reducer.NetworkCheckReducer", f = "NetworkCheckReducer.kt", i = {0}, l = {22}, m = "check", n = {"data"}, s = {"L$0"}, v = 1)
public final class NetworkCheckReducer$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkCheckReducer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkCheckReducer$check$1(NetworkCheckReducer networkCheckReducer, Continuation<? super NetworkCheckReducer$check$1> continuation) {
        super(continuation);
        this.this$0 = networkCheckReducer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.check(null, null, null, (Continuation) this);
    }
}