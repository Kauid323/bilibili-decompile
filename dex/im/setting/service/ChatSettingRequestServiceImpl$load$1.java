package im.setting.service;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingRequestService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.service.ChatSettingRequestServiceImpl", f = "SettingRequestService.kt", i = {0, 0}, l = {WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO}, m = "load-IoAF18A", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ChatSettingRequestServiceImpl$load$2"}, s = {"I$0", "I$1"}, v = 1)
public final class ChatSettingRequestServiceImpl$load$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSettingRequestServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSettingRequestServiceImpl$load$1(ChatSettingRequestServiceImpl chatSettingRequestServiceImpl, Continuation<? super ChatSettingRequestServiceImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = chatSettingRequestServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo3406loadIoAF18A = this.this$0.mo3406loadIoAF18A((Continuation) this);
        return mo3406loadIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo3406loadIoAF18A : Result.box-impl(mo3406loadIoAF18A);
    }
}