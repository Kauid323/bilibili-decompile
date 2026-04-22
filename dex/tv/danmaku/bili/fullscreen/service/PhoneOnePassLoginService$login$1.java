package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneOnePassLoginService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.PhoneOnePassLoginService", f = "PhoneOnePassLoginService.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {BR.avatarList, BR.backImageUrl, BR.badgeBgColorNight, BR.badgeVisibility, BR.bannerItems}, m = "login", n = {"loginWay", "phone", "reportParam", "loginWay", "phone", "loginWay", "phone"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class PhoneOnePassLoginService$login$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PhoneOnePassLoginService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOnePassLoginService$login$1(PhoneOnePassLoginService phoneOnePassLoginService, Continuation<? super PhoneOnePassLoginService$login$1> continuation) {
        super(continuation);
        this.this$0 = phoneOnePassLoginService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.login(null, null, null, (Continuation) this);
    }
}