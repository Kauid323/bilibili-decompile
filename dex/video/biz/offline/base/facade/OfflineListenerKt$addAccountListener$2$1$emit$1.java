package video.biz.offline.base.facade;

import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import util.LiveGiftShieldFeaturUtilsKt;
import video.biz.offline.base.facade.OfflineListenerKt$addAccountListener$2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineListener.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.OfflineListenerKt$addAccountListener$2$1", f = "OfflineListener.kt", i = {0, 1, 2}, l = {IjkMediaMeta.FF_PROFILE_H264_BASELINE, LiveGiftShieldFeaturUtilsKt.SPECIAL_TYPE_MULTI_VOICE, 75}, m = "emit", n = {"state", "state", "state"}, s = {"L$0", "L$0", "L$0"}, v = 1)
public final class OfflineListenerKt$addAccountListener$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineListenerKt$addAccountListener$2.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfflineListenerKt$addAccountListener$2$1$emit$1(OfflineListenerKt$addAccountListener$2.AnonymousClass1<? super T> anonymousClass1, Continuation<? super OfflineListenerKt$addAccountListener$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((AccountState) null, (Continuation) this);
    }
}