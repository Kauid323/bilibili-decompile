package tv.danmaku.video.bilicardplayer.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;

/* compiled from: PlayerExtraConfiguration.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/PlayerExtraConfiguration;", "", "<init>", "()V", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "getPlayerType", "()Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "setPlayerType", "(Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;)V", "allowReusePlayerCore", "", "getAllowReusePlayerCore", "()Z", "setAllowReusePlayerCore", "(Z)V", "keepRender", "getKeepRender", "setKeepRender", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerExtraConfiguration {
    private boolean allowReusePlayerCore;
    private boolean keepRender;
    private PlayerType playerType = PlayerType.Single;

    public final PlayerType getPlayerType() {
        return this.playerType;
    }

    public final void setPlayerType(PlayerType playerType) {
        Intrinsics.checkNotNullParameter(playerType, "<set-?>");
        this.playerType = playerType;
    }

    public final boolean getAllowReusePlayerCore() {
        return this.allowReusePlayerCore;
    }

    public final void setAllowReusePlayerCore(boolean z) {
        this.allowReusePlayerCore = z;
    }

    public final boolean getKeepRender() {
        return this.keepRender;
    }

    public final void setKeepRender(boolean z) {
        this.keepRender = z;
    }
}