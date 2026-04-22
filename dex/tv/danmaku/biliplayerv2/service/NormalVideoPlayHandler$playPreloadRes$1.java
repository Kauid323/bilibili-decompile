package tv.danmaku.biliplayerv2.service;

import android.app.Application;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.media.resolver2.IResolveParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayer.preload.repository.PreloadOutcome;
import tv.danmaku.biliplayer.preload.repository.PreloadPool;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.utils.MediaItemBuilderExtKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NormalVideoPlayHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$playPreloadRes$1", f = "NormalVideoPlayHandler.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NormalVideoPlayHandler$playPreloadRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoStart;
    final /* synthetic */ CurrentVideoPointer $item;
    final /* synthetic */ Video.PlayableParams $playableParams;
    final /* synthetic */ PreloadPool $pool;
    final /* synthetic */ IResolveParams $resolveParams;
    int label;
    final /* synthetic */ NormalVideoPlayHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalVideoPlayHandler$playPreloadRes$1(PreloadPool preloadPool, IResolveParams iResolveParams, NormalVideoPlayHandler normalVideoPlayHandler, CurrentVideoPointer currentVideoPointer, Video.PlayableParams playableParams, boolean z, Continuation<? super NormalVideoPlayHandler$playPreloadRes$1> continuation) {
        super(2, continuation);
        this.$pool = preloadPool;
        this.$resolveParams = iResolveParams;
        this.this$0 = normalVideoPlayHandler;
        this.$item = currentVideoPointer;
        this.$playableParams = playableParams;
        this.$autoStart = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NormalVideoPlayHandler$playPreloadRes$1(this.$pool, this.$resolveParams, this.this$0, this.$item, this.$playableParams, this.$autoStart, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v8, types: [tv.danmaku.biliplayer.preload.repository.PreloadOutcome] */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    this.label = 1;
                    Object playerItemCache$default = PreloadPool.CC.getPlayerItemCache$default(this.$pool, this.$resolveParams, 0L, (Continuation) this, 2, null);
                    if (playerItemCache$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = playerItemCache$default;
                    break;
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            $result = e;
        }
        try {
            $result = (PreloadOutcome) $result3;
        } catch (Exception e2) {
            Object obj = $result2;
            $result = e2;
            $result = obj;
            PlayerLog.i("NormalVideoPlayHandler", "get player item cache failed, error:" + $result);
            PlayerProfiler playerProfiler = this.this$0.getMPlayerContainer().getPlayerProfiler();
            if (playerProfiler != null) {
                playerProfiler.doProfile(ProfilerTags.START_PLAY_PRELOAD_NORMAL, null);
            }
            this.this$0.resolve(this.$item, 0, this.$autoStart);
            if (BuildConfig.DEBUG) {
                Application fapp = FoundationAlias.getFapp();
                Video.ReportCommonParams reportCommonParams = this.$playableParams.getReportCommonParams();
                ToastHelper.showToast(fapp, "没有命中预加载, " + (reportCommonParams != null ? Boxing.boxLong(reportCommonParams.getCid()) : null), 0);
            }
            return Unit.INSTANCE;
        }
        if ($result != 0) {
            this.this$0.videoItemChange(this.$item);
            PlayerProfiler playerProfiler2 = this.this$0.getMPlayerContainer().getPlayerProfiler();
            if (playerProfiler2 != null) {
                playerProfiler2.doProfile(ProfilerTags.START_PLAY_PRELOAD, null);
            }
            MediaItemParams.Builder $this$invokeSuspend_u24lambda_u240 = MediaItemBuilderExtKt.applyPlayableParams(MediaItemBuilderExtKt.getMediaItemParamsBuilder(this.this$0.getMPlayerContainer(), $result.getMediaResource()), this.$playableParams);
            NormalVideoPlayHandler normalVideoPlayHandler = this.this$0;
            Video.PlayableParams playableParams = this.$playableParams;
            IMediaItemParamsInterceptor mediaItemSettingInterceptor = normalVideoPlayHandler.getMPlayerContainer().getVideoPlayDirectorService().getMediaItemSettingInterceptor();
            if (mediaItemSettingInterceptor != null) {
                Boxing.boxBoolean(mediaItemSettingInterceptor.interceptMediaItemParams(playableParams, $this$invokeSuspend_u24lambda_u240, false));
            }
            MediaItemParams itemParams = $this$invokeSuspend_u24lambda_u240.build();
            this.this$0.setFakeDurationIfNeeded($result.getMediaResource());
            if ($result.getMediaItem() != null) {
                IPlayerCoreService mPlayerCoreService = this.this$0.getMPlayerCoreService();
                MediaItem<?> mediaItem = $result.getMediaItem();
                Intrinsics.checkNotNull(mediaItem);
                mPlayerCoreService.setMediaResource(mediaItem, $result.getMediaResource(), true, itemParams);
            } else {
                this.this$0.getMPlayerCoreService().setMediaResource($result.getMediaResource(), true, itemParams);
            }
            if (BuildConfig.DEBUG) {
                Application fapp2 = FoundationAlias.getFapp();
                Video.ReportCommonParams reportCommonParams2 = this.$playableParams.getReportCommonParams();
                ToastHelper.showToast(fapp2, "命中预加载, " + (reportCommonParams2 != null ? Boxing.boxLong(reportCommonParams2.getCid()) : null), 0);
            }
            this.this$0.getMPlayerContainer().getVideoPlayDirectorService().resolveDanmaku();
            return Unit.INSTANCE;
        }
        throw new Exception("");
    }
}