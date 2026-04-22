package tv.danmaku.bili.ui.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion", f = "OnePassLoginGuideHelperV2.kt", i = {0, 0, 0}, l = {BR.onClick}, m = "routeToSmsLoginDialogIfEnableV2", n = {"ctx", "info", "fromVideo"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
public final class OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnePassLoginGuideHelperV2.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1(OnePassLoginGuideHelperV2.Companion companion, Continuation<? super OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object routeToSmsLoginDialogIfEnableV2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        routeToSmsLoginDialogIfEnableV2 = this.this$0.routeToSmsLoginDialogIfEnableV2(false, null, null, false, false, null, (Continuation) this);
        return routeToSmsLoginDialogIfEnableV2;
    }
}