package tv.danmaku.bili.ui.login.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuickLoginHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.QuickLoginHelper", f = "QuickLoginHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {BR.bottomDisplay4, BR.buttonVisible, BR.calenderVisible}, m = "doCheck", n = {"fromSpmId", "context", "phase", "getPhaseTypeByReducer", "data", "reduce", "index", "fromSpmId", "context", "phase", "getPhaseTypeByReducer", "reduce", "index", "fromSpmId", "context", "phase", "getPhaseTypeByReducer", "result", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class QuickLoginHelper$doCheck$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickLoginHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginHelper$doCheck$1(QuickLoginHelper quickLoginHelper, Continuation<? super QuickLoginHelper$doCheck$1> continuation) {
        super(continuation);
        this.this$0 = quickLoginHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doCheck(null, null, (Continuation) this);
    }
}