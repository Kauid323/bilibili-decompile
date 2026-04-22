package tv.danmaku.biliplayerimpl.core;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;
import tv.danmaku.videoplayer.core.share.SharableObject;
import tv.danmaku.videoplayer.coreV2.IMediaPlayAdapterFactory;
import tv.danmaku.videoplayer.coreV2.IMediaPlayParams;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/MediaPlayParams;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "<init>", "(Ltv/danmaku/biliplayerv2/PlayerContainer;)V", "mPlayerContainer", "Ljava/lang/ref/WeakReference;", "externalRender", "", "clone", "", "mediaPlayParams", "forbidReusePlayerCore", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayParams extends SharableObject implements IMediaPlayParams {
    private WeakReference<PlayerContainer> mPlayerContainer;

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayParams
    public /* synthetic */ IMediaPlayAdapterFactory mediaPlayAdapterFactory() {
        return IMediaPlayParams.CC.$default$mediaPlayAdapterFactory(this);
    }

    public MediaPlayParams(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = new WeakReference<>(playerContainer);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayParams
    public boolean externalRender() {
        PlayerContainer playerContainer;
        IRenderContainerService renderContainerService;
        WeakReference<PlayerContainer> weakReference = this.mPlayerContainer;
        if (weakReference == null || (playerContainer = weakReference.get()) == null || (renderContainerService = playerContainer.getRenderContainerService()) == null) {
            return true;
        }
        return renderContainerService.useExternalRender();
    }

    public final void clone(IMediaPlayParams mediaPlayParams) {
        Intrinsics.checkNotNullParameter(mediaPlayParams, "mediaPlayParams");
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayParams
    public boolean forbidReusePlayerCore() {
        PlayerContainer playerContainer;
        PlayerParamsV2 playerParams;
        PlayerConfiguration config;
        WeakReference<PlayerContainer> weakReference = this.mPlayerContainer;
        if (weakReference == null || (playerContainer = weakReference.get()) == null || (playerParams = playerContainer.getPlayerParams()) == null || (config = playerParams.getConfig()) == null) {
            return false;
        }
        return config.getAllowReusePlayerCore();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayParams
    public PlayerType playerType() {
        PlayerType playerType;
        PlayerContainer playerContainer;
        PlayerParamsV2 playerParams;
        PlayerConfiguration config;
        PlayerType playerType2;
        WeakReference<PlayerContainer> weakReference = this.mPlayerContainer;
        if (weakReference == null || (playerContainer = weakReference.get()) == null || (playerParams = playerContainer.getPlayerParams()) == null || (config = playerParams.getConfig()) == null || (playerType2 = config.getPlayerType()) == null) {
            playerType = PlayerType.Single;
            return playerType;
        }
        return playerType2;
    }
}