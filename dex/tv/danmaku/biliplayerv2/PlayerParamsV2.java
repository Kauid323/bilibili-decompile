package tv.danmaku.biliplayerv2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.VideoRenderLayerFactory;

/* compiled from: PlayerParamsV2.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "", "<init>", "()V", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "getSharingBundle", "()Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "setSharingBundle", "(Ltv/danmaku/biliplayerv2/PlayerSharingBundle;)V", "playerDataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "getPlayerDataSource", "()Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "setPlayerDataSource", "(Ltv/danmaku/biliplayerv2/service/PlayerDataSource;)V", "config", "Ltv/danmaku/biliplayerv2/PlayerConfiguration;", "getConfig", "()Ltv/danmaku/biliplayerv2/PlayerConfiguration;", "setConfig", "(Ltv/danmaku/biliplayerv2/PlayerConfiguration;)V", "videoRenderLayerFactory", "Ltv/danmaku/render/core/VideoRenderLayerFactory;", "getVideoRenderLayerFactory", "()Ltv/danmaku/render/core/VideoRenderLayerFactory;", "setVideoRenderLayerFactory", "(Ltv/danmaku/render/core/VideoRenderLayerFactory;)V", "playerCoreServiceDecorator", "Lkotlin/Function1;", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "getPlayerCoreServiceDecorator", "()Lkotlin/jvm/functions/Function1;", "setPlayerCoreServiceDecorator", "(Lkotlin/jvm/functions/Function1;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerParamsV2 {
    private PlayerConfiguration config = new PlayerConfiguration();
    private Function1<? super IPlayerCoreService, ? extends IPlayerCoreService> playerCoreServiceDecorator;
    private PlayerDataSource playerDataSource;
    private PlayerSharingBundle sharingBundle;
    private VideoRenderLayerFactory videoRenderLayerFactory;

    public final PlayerSharingBundle getSharingBundle() {
        return this.sharingBundle;
    }

    public final void setSharingBundle(PlayerSharingBundle playerSharingBundle) {
        this.sharingBundle = playerSharingBundle;
    }

    public final PlayerDataSource getPlayerDataSource() {
        return this.playerDataSource;
    }

    public final void setPlayerDataSource(PlayerDataSource playerDataSource) {
        this.playerDataSource = playerDataSource;
    }

    public final PlayerConfiguration getConfig() {
        return this.config;
    }

    public final void setConfig(PlayerConfiguration playerConfiguration) {
        Intrinsics.checkNotNullParameter(playerConfiguration, "<set-?>");
        this.config = playerConfiguration;
    }

    public final VideoRenderLayerFactory getVideoRenderLayerFactory() {
        return this.videoRenderLayerFactory;
    }

    public final void setVideoRenderLayerFactory(VideoRenderLayerFactory videoRenderLayerFactory) {
        this.videoRenderLayerFactory = videoRenderLayerFactory;
    }

    public final Function1<IPlayerCoreService, IPlayerCoreService> getPlayerCoreServiceDecorator() {
        return this.playerCoreServiceDecorator;
    }

    public final void setPlayerCoreServiceDecorator(Function1<? super IPlayerCoreService, ? extends IPlayerCoreService> function1) {
        this.playerCoreServiceDecorator = function1;
    }
}