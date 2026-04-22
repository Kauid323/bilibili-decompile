package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.PhoneService", f = "PhoneService.kt", i = {}, l = {BR.backgroundHeaderImageUrl}, m = "getPhoneInfo", n = {}, s = {}, v = 1)
public final class PhoneService$getPhoneInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PhoneService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneService$getPhoneInfo$1(PhoneService phoneService, Continuation<? super PhoneService$getPhoneInfo$1> continuation) {
        super(continuation);
        this.this$0 = phoneService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPhoneInfo((Continuation) this);
    }
}