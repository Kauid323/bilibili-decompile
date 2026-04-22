package tv.danmaku.bili.ui.login.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuickLoginHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.QuickLoginHelper", f = "QuickLoginHelper.kt", i = {0, 0}, l = {BR.coverHorizontal}, m = "goLogin", n = {"context", "data"}, s = {"L$0", "L$1"}, v = 1)
public final class QuickLoginHelper$goLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickLoginHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginHelper$goLogin$1(QuickLoginHelper quickLoginHelper, Continuation<? super QuickLoginHelper$goLogin$1> continuation) {
        super(continuation);
        this.this$0 = quickLoginHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.goLogin(null, null, 0, (Continuation) this);
    }
}