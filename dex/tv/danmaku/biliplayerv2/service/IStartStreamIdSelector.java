package tv.danmaku.biliplayerv2.service;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IStartStreamIdSelector;", "", "onGetVideoStreamId", "", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "onGetAudioStreamId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IStartStreamIdSelector {
    int onGetAudioStreamId(MediaResource mediaResource);

    int onGetVideoStreamId(MediaResource mediaResource);

    /* compiled from: IPlayerCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IStartStreamIdSelector$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static int $default$onGetVideoStreamId(IStartStreamIdSelector _this, MediaResource resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            return -1;
        }

        public static int $default$onGetAudioStreamId(IStartStreamIdSelector _this, MediaResource resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            return -1;
        }
    }
}