package tv.danmaku.bili.ui.login.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuickLoginHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.HistoryAutoLogin", f = "QuickLoginHelper.kt", i = {0, 0, 0}, l = {BR.labelVisible, BR.landscape}, m = "tryLogin", n = {AudioIntentHelper.FROM_ACTIVITY, "spmId", "helper"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class HistoryAutoLogin$tryLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HistoryAutoLogin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryAutoLogin$tryLogin$1(HistoryAutoLogin historyAutoLogin, Continuation<? super HistoryAutoLogin$tryLogin$1> continuation) {
        super(continuation);
        this.this$0 = historyAutoLogin;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryLogin(null, (Continuation) this);
    }
}