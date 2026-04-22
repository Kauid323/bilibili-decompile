package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.SmsLoginService", f = "SmsLoginService.kt", i = {0, 1}, l = {BR.currentEpisodeListIsReversed, BR.dialogStyleType, BR.displayingBanner}, m = "registerBySms", n = {"registerLoginWay", "registerLoginWay"}, s = {"L$0", "L$0"}, v = 1)
public final class SmsLoginService$registerBySms$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SmsLoginService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginService$registerBySms$1(SmsLoginService smsLoginService, Continuation<? super SmsLoginService$registerBySms$1> continuation) {
        super(continuation);
        this.this$0 = smsLoginService;
    }

    public final Object invokeSuspend(Object obj) {
        Object registerBySms;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        registerBySms = this.this$0.registerBySms(null, null, null, null, null, (Continuation) this);
        return registerBySms;
    }
}