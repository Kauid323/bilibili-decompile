package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: CacheElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.CacheElement$syncSuppress$1", f = "CacheElement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CacheElement$syncSuppress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IjkMediaPlayerItem.PlayerItemPriority $itemPriority;
    int label;
    final /* synthetic */ CacheElement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheElement$syncSuppress$1(CacheElement cacheElement, IjkMediaPlayerItem.PlayerItemPriority playerItemPriority, Continuation<? super CacheElement$syncSuppress$1> continuation) {
        super(2, continuation);
        this.this$0 = cacheElement;
        this.$itemPriority = playerItemPriority;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CacheElement$syncSuppress$1(this.this$0, this.$itemPriority, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                MediaItem<?> mediaItem = this.this$0.getMediaItem();
                if (mediaItem != null) {
                    mediaItem.setIdleBufferInfo(this.$itemPriority);
                }
                BLog.d("PlayerPreloadElement", "change idle info,cause suppress itemPriority: " + this.$itemPriority);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}