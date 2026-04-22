package tv.danmaku.videoplayer.coreV2.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: IjkItemNotifyLiveQnChange.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IjkItemNotifyLiveQnChange;", "", "curQn", "", "targetQn", "newUrl", "", "switchQnMode", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$LiveSwitchQnMode;", "<init>", "(IILjava/lang/String;Ltv/danmaku/ijk/media/player/IjkMediaPlayer$LiveSwitchQnMode;)V", "getCurQn", "()I", "setCurQn", "(I)V", "getTargetQn", "setTargetQn", "getNewUrl", "()Ljava/lang/String;", "setNewUrl", "(Ljava/lang/String;)V", "getSwitchQnMode", "()Ltv/danmaku/ijk/media/player/IjkMediaPlayer$LiveSwitchQnMode;", "setSwitchQnMode", "(Ltv/danmaku/ijk/media/player/IjkMediaPlayer$LiveSwitchQnMode;)V", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkItemNotifyLiveQnChange {
    private int curQn;
    private String newUrl;
    private IjkMediaPlayer.LiveSwitchQnMode switchQnMode;
    private int targetQn;

    public IjkItemNotifyLiveQnChange(int curQn, int targetQn, String newUrl, IjkMediaPlayer.LiveSwitchQnMode switchQnMode) {
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        Intrinsics.checkNotNullParameter(switchQnMode, "switchQnMode");
        this.curQn = curQn;
        this.targetQn = targetQn;
        this.newUrl = newUrl;
        this.switchQnMode = switchQnMode;
    }

    public final int getCurQn() {
        return this.curQn;
    }

    public final String getNewUrl() {
        return this.newUrl;
    }

    public final IjkMediaPlayer.LiveSwitchQnMode getSwitchQnMode() {
        return this.switchQnMode;
    }

    public final int getTargetQn() {
        return this.targetQn;
    }

    public final void setCurQn(int i) {
        this.curQn = i;
    }

    public final void setNewUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newUrl = str;
    }

    public final void setSwitchQnMode(IjkMediaPlayer.LiveSwitchQnMode liveSwitchQnMode) {
        Intrinsics.checkNotNullParameter(liveSwitchQnMode, "<set-?>");
        this.switchQnMode = liveSwitchQnMode;
    }

    public final void setTargetQn(int i) {
        this.targetQn = i;
    }
}