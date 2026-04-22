package tv.danmaku.bili.ui.login.helper.reducer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneInfoCheckReducer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.reducer.PhoneInfoCheckReducer", f = "PhoneInfoCheckReducer.kt", i = {0}, l = {BR.bgAlpha}, m = "afterCheck", n = {"result"}, s = {"L$0"}, v = 1)
public final class PhoneInfoCheckReducer$afterCheck$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PhoneInfoCheckReducer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneInfoCheckReducer$afterCheck$1(PhoneInfoCheckReducer phoneInfoCheckReducer, Continuation<? super PhoneInfoCheckReducer$afterCheck$1> continuation) {
        super(continuation);
        this.this$0 = phoneInfoCheckReducer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.afterCheck(null, null, (Continuation) this);
    }
}