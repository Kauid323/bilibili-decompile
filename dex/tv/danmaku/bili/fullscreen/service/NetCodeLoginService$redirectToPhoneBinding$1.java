package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeLoginService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.NetCodeLoginService", f = "NetCodeLoginService.kt", i = {0}, l = {BR.bgCover}, m = "redirectToPhoneBinding", n = {AudioIntentHelper.FROM_ACTIVITY}, s = {"L$0"}, v = 1)
public final class NetCodeLoginService$redirectToPhoneBinding$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetCodeLoginService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCodeLoginService$redirectToPhoneBinding$1(NetCodeLoginService netCodeLoginService, Continuation<? super NetCodeLoginService$redirectToPhoneBinding$1> continuation) {
        super(continuation);
        this.this$0 = netCodeLoginService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.redirectToPhoneBinding(null, null, null, null, (Continuation) this);
    }
}