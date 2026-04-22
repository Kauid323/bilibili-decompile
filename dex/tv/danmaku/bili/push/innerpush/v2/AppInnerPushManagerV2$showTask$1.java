package tv.danmaku.bili.push.innerpush.v2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.preSaleCountdownVisible, BR.qrCode}, m = "showTask", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$showTask$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$showTask$1(AppInnerPushManagerV2 appInnerPushManagerV2, Continuation<? super AppInnerPushManagerV2$showTask$1> continuation) {
        super(continuation);
        this.this$0 = appInnerPushManagerV2;
    }

    public final Object invokeSuspend(Object obj) {
        Object showTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showTask = this.this$0.showTask(null, null, null, null, null, (Continuation) this);
        return showTask;
    }
}