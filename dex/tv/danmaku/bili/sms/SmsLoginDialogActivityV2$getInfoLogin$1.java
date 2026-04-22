package tv.danmaku.bili.sms;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogActivityV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.sms.SmsLoginDialogActivityV2", f = "SmsLoginDialogActivityV2.kt", i = {}, l = {BR.rootViewHeight}, m = "getInfoLogin", n = {}, s = {}, v = 1)
public final class SmsLoginDialogActivityV2$getInfoLogin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SmsLoginDialogActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginDialogActivityV2$getInfoLogin$1(SmsLoginDialogActivityV2 smsLoginDialogActivityV2, Continuation<? super SmsLoginDialogActivityV2$getInfoLogin$1> continuation) {
        super(continuation);
        this.this$0 = smsLoginDialogActivityV2;
    }

    public final Object invokeSuspend(Object obj) {
        Object infoLogin;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        infoLogin = this.this$0.getInfoLogin((Continuation) this);
        return infoLogin;
    }
}