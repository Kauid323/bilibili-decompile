package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;

/* compiled from: IMediaPlayParams.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "", "mediaPlayAdapterFactory", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayAdapterFactory;", "externalRender", "", "forbidReusePlayerCore", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayParams {
    boolean externalRender();

    boolean forbidReusePlayerCore();

    IMediaPlayAdapterFactory mediaPlayAdapterFactory();

    PlayerType playerType();

    /* compiled from: IMediaPlayParams.kt */
    /* renamed from: tv.danmaku.videoplayer.coreV2.IMediaPlayParams$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static IMediaPlayAdapterFactory $default$mediaPlayAdapterFactory(IMediaPlayParams _this) {
            return new DefaultMediaPlayAdapterFactory();
        }

        public static boolean $default$forbidReusePlayerCore(IMediaPlayParams _this) {
            return false;
        }
    }
}