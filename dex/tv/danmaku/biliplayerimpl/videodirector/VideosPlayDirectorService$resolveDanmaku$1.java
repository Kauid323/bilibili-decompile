package tv.danmaku.biliplayerimpl.videodirector;

import android.text.TextUtils;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.danmaku.DanmakuRpcWrapper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: VideosPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$resolveDanmaku$1", f = "VideosPlayDirectorService.kt", i = {}, l = {1157}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VideosPlayDirectorService$resolveDanmaku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Video.DanmakuResolveParams $danmakuResolveParams;
    final /* synthetic */ Video.PlayableParams $playableParams;
    int label;
    final /* synthetic */ VideosPlayDirectorService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideosPlayDirectorService$resolveDanmaku$1(VideosPlayDirectorService videosPlayDirectorService, Video.DanmakuResolveParams danmakuResolveParams, Video.PlayableParams playableParams, Continuation<? super VideosPlayDirectorService$resolveDanmaku$1> continuation) {
        super(2, continuation);
        this.this$0 = videosPlayDirectorService;
        this.$danmakuResolveParams = danmakuResolveParams;
        this.$playableParams = playableParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideosPlayDirectorService$resolveDanmaku$1(this.this$0, this.$danmakuResolveParams, this.$playableParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r4 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PlayerContainerImpl playerContainerImpl;
        String str;
        PlayerContainerImpl playerContainerImpl2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                playerContainerImpl = this.this$0.mPlayerContainer;
                if (playerContainerImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl = null;
                }
                MediaResource mediaResource = playerContainerImpl.getPlayerCoreService().getMediaResource();
                if ((mediaResource != null ? mediaResource.getLanguage() : null) == null) {
                    if (mediaResource == null) {
                        str = null;
                        break;
                    } else {
                        str = mediaResource.getCurrentLanguage();
                        break;
                    }
                }
                this.$danmakuResolveParams.setLanguage(mediaResource.getCurrentLanguage());
                this.$danmakuResolveParams.setProductionType(mediaResource.getCurProductionType());
                this.label = 1;
                Object requestDmView = DanmakuRpcWrapper.INSTANCE.requestDmView(this.$danmakuResolveParams, (Continuation) this);
                if (requestDmView != coroutine_suspended) {
                    $result = requestDmView;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DmViewReply result = (DmViewReply) $result;
        Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        if (result != null) {
            if (TextUtils.equals(this.$playableParams.id(), currentPlayableParams != null ? currentPlayableParams.id() : null)) {
                playerContainerImpl2 = this.this$0.mPlayerContainer;
                if (playerContainerImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl2 = null;
                }
                playerContainerImpl2.getInteractLayerService().setDmViewReply(result);
                this.this$0.mDanmakuJob = null;
                return Unit.INSTANCE;
            }
        }
        PlayerLog.i("VideosPlayDirectorService", "danmaku resolver succeed:" + this.$playableParams.id() + " from:" + this.$playableParams.getFrom() + ", but video changed");
        this.this$0.mDanmakuJob = null;
        return Unit.INSTANCE;
    }
}