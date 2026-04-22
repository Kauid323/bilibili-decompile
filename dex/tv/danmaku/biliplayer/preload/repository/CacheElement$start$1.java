package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CacheElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.CacheElement$start$1", f = "CacheElement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CacheElement$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CacheElement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheElement$start$1(CacheElement cacheElement, Continuation<? super CacheElement$start$1> continuation) {
        super(2, continuation);
        this.this$0 = cacheElement;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CacheElement$start$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MediaResource mediaResource;
        Function1 function1;
        long j;
        boolean z;
        Function1 function12;
        String str;
        Function2 function2;
        Function1 function13;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                MediaItem<?> mediaItem = null;
                try {
                    str = this.this$0.flashJson;
                    IResolveParams resolverParams = this.this$0.getResolverParams();
                    function2 = this.this$0.flashMediaResourceCreator;
                    function13 = this.this$0.paramsMediaResourceCreator;
                    mediaResource = PreloadResolverKt.resolveMediaResource(str, resolverParams, function2, function13);
                } catch (Exception e) {
                    BLog.e("PlayerPreloadElement", "media resource error id:" + this.this$0.getId() + " identity:" + this.this$0.getIdentity() + " " + e.getStackTrace());
                    mediaResource = null;
                }
                if (mediaResource == null) {
                    BLog.i("PlayerPreloadElement", "media resource is null");
                    return Unit.INSTANCE;
                }
                if (this.this$0.getStartPosition() > 0) {
                    mediaResource.startPosition = this.this$0.getStartPosition();
                }
                this.this$0.setMediaResource(mediaResource);
                CacheElement cacheElement = this.this$0;
                function1 = this.this$0.mediaItemCreator;
                if (function1 != null) {
                    function12 = this.this$0.mediaItemCreator;
                    if (function12 != null) {
                        mediaItem = (MediaItem) function12.invoke(mediaResource);
                    }
                } else {
                    PreloadReportData reportData = this.this$0.getReportData();
                    IResolveParams resolverParams2 = this.this$0.getResolverParams();
                    j = this.this$0.cacheTimeMs;
                    mediaItem = PreloadResolverKt.createMediaItem(mediaResource, reportData, resolverParams2, j);
                }
                cacheElement.setMediaItem(mediaItem);
                if (this.this$0.getMediaItem() != null) {
                    z = this.this$0.suppress;
                    int itemPriority = !z ? this.this$0.m2139getPriority3gV422k() : PreloadPriority.Companion.m2154getDefault3gV422k();
                    MediaItem<?> mediaItem2 = this.this$0.getMediaItem();
                    if (mediaItem2 != null) {
                        mediaItem2.setIdleBufferInfo(PreloadResolverKt.m2162toIjkPriorityEJy1Qw(itemPriority));
                    }
                    this.this$0.attachItem();
                    MediaItem<?> mediaItem3 = this.this$0.getMediaItem();
                    if (mediaItem3 != null) {
                        mediaItem3.start();
                    }
                    return Unit.INSTANCE;
                }
                BLog.i("PlayerPreloadElement", "media resource is not playable, id:" + this.this$0.getId() + " identity:" + this.this$0.getIdentity());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}