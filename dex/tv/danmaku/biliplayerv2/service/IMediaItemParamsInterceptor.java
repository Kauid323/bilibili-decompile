package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "", "interceptMediaItemParams", "", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "itemParamsBuilder", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Builder;", "isUpdate", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaItemParamsInterceptor {
    boolean interceptMediaItemParams(Video.PlayableParams playableParams, MediaItemParams.Builder builder, boolean z);

    /* compiled from: IVideoPlayDirectorService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean interceptMediaItemParams$default(IMediaItemParamsInterceptor iMediaItemParamsInterceptor, Video.PlayableParams playableParams, MediaItemParams.Builder builder, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return iMediaItemParamsInterceptor.interceptMediaItemParams(playableParams, builder, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: interceptMediaItemParams");
        }
    }
}