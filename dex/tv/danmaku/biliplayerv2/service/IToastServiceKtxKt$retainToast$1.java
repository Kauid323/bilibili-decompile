package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IToastServiceKtx.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.IToastServiceKtxKt", f = "IToastServiceKtx.kt", i = {0, 0, 1, 1}, l = {13, 15}, m = "retainToast", n = {"$this$retainToast", "toast", "$this$retainToast", "toast"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class IToastServiceKtxKt$retainToast$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IToastServiceKtxKt$retainToast$1(Continuation<? super IToastServiceKtxKt$retainToast$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IToastServiceKtxKt.retainToast(null, null, (Continuation) this);
    }
}