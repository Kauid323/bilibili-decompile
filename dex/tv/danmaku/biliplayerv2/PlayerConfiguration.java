package tv.danmaku.biliplayerv2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: PlayerParamsV2.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u001a\u0010>\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\u001a\u0010A\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006Q"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerConfiguration;", "", "<init>", "()V", "initialControlContainerType", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "getInitialControlContainerType", "()Ltv/danmaku/biliplayerv2/ControlContainerType;", "setInitialControlContainerType", "(Ltv/danmaku/biliplayerv2/ControlContainerType;)V", "value", "", "controlContainerShowForever", "getControlContainerShowForever", "()Z", "setControlContainerShowForever", "(Z)V", "controlContainerShowDuration", "", "getControlContainerShowDuration", "()J", "setControlContainerShowDuration", "(J)V", "hideControlInFullScreen", "getHideControlInFullScreen", "setHideControlInFullScreen", "controlContainerLazyMode", "getControlContainerLazyMode", "setControlContainerLazyMode", "controlContainerInheritsVisibility", "getControlContainerInheritsVisibility", "setControlContainerInheritsVisibility", "disallowParentIntercept", "getDisallowParentIntercept", "setDisallowParentIntercept", "defaultAspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "getDefaultAspectRatio", "()Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "setDefaultAspectRatio", "(Ltv/danmaku/videoplayer/core/videoview/AspectRatio;)V", "theme", "", "getTheme", "()I", "setTheme", "(I)V", "allowReusePlayerCore", "getAllowReusePlayerCore", "setAllowReusePlayerCore", "mLoadingDelayTime", "getMLoadingDelayTime", "setMLoadingDelayTime", "videoRenderLayerType", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "getVideoRenderLayerType", "()Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "setVideoRenderLayerType", "(Ltv/danmaku/render/core/IVideoRenderLayer$Type;)V", "updateVideoRenderViewPortEnable", "getUpdateVideoRenderViewPortEnable", "setUpdateVideoRenderViewPortEnable", "wholeSceneEnable", "getWholeSceneEnable", "setWholeSceneEnable", "ijkAudioStreamType", "getIjkAudioStreamType", "setIjkAudioStreamType", "directorVersion", "Ltv/danmaku/biliplayerv2/DirectorVersion;", "getDirectorVersion", "()Ltv/danmaku/biliplayerv2/DirectorVersion;", "setDirectorVersion", "(Ltv/danmaku/biliplayerv2/DirectorVersion;)V", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "getPlayerType", "()Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "setPlayerType", "(Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;)V", "Theme", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerConfiguration {
    private boolean allowReusePlayerCore;
    private boolean controlContainerInheritsVisibility;
    private boolean controlContainerLazyMode;
    private boolean controlContainerShowForever;
    private boolean hideControlInFullScreen;
    private long mLoadingDelayTime;
    private boolean updateVideoRenderViewPortEnable;
    private IVideoRenderLayer.Type videoRenderLayerType;
    private ControlContainerType initialControlContainerType = ControlContainerType.HALF_SCREEN;
    private long controlContainerShowDuration = PlayerToastConfig.DURATION_5;
    private boolean disallowParentIntercept = true;
    private AspectRatio defaultAspectRatio = AspectRatio.RATIO_ADJUST_CONTENT;
    private int theme = 1;
    private boolean wholeSceneEnable = true;
    private int ijkAudioStreamType = 3;
    private DirectorVersion directorVersion = DirectorVersion.V1;
    private PlayerType playerType = PlayerType.Single;

    public final ControlContainerType getInitialControlContainerType() {
        return this.initialControlContainerType;
    }

    public final void setInitialControlContainerType(ControlContainerType controlContainerType) {
        Intrinsics.checkNotNullParameter(controlContainerType, "<set-?>");
        this.initialControlContainerType = controlContainerType;
    }

    public final boolean getControlContainerShowForever() {
        return this.controlContainerShowForever;
    }

    public final void setControlContainerShowForever(boolean value) {
        this.controlContainerShowForever = value;
    }

    public final long getControlContainerShowDuration() {
        return this.controlContainerShowDuration;
    }

    public final void setControlContainerShowDuration(long j) {
        this.controlContainerShowDuration = j;
    }

    public final boolean getHideControlInFullScreen() {
        return this.hideControlInFullScreen;
    }

    public final void setHideControlInFullScreen(boolean z) {
        this.hideControlInFullScreen = z;
    }

    public final boolean getControlContainerLazyMode() {
        return this.controlContainerLazyMode;
    }

    public final void setControlContainerLazyMode(boolean value) {
        this.controlContainerLazyMode = value;
    }

    public final boolean getControlContainerInheritsVisibility() {
        return this.controlContainerInheritsVisibility;
    }

    public final void setControlContainerInheritsVisibility(boolean value) {
        this.controlContainerInheritsVisibility = value;
    }

    public final boolean getDisallowParentIntercept() {
        return this.disallowParentIntercept;
    }

    public final void setDisallowParentIntercept(boolean z) {
        this.disallowParentIntercept = z;
    }

    public final AspectRatio getDefaultAspectRatio() {
        return this.defaultAspectRatio;
    }

    public final void setDefaultAspectRatio(AspectRatio aspectRatio) {
        Intrinsics.checkNotNullParameter(aspectRatio, "<set-?>");
        this.defaultAspectRatio = aspectRatio;
    }

    public final int getTheme() {
        return this.theme;
    }

    public final void setTheme(int i) {
        this.theme = i;
    }

    public final boolean getAllowReusePlayerCore() {
        return this.allowReusePlayerCore;
    }

    public final void setAllowReusePlayerCore(boolean z) {
        this.allowReusePlayerCore = z;
    }

    public final long getMLoadingDelayTime() {
        return this.mLoadingDelayTime;
    }

    public final void setMLoadingDelayTime(long j) {
        this.mLoadingDelayTime = j;
    }

    public final IVideoRenderLayer.Type getVideoRenderLayerType() {
        return this.videoRenderLayerType;
    }

    public final void setVideoRenderLayerType(IVideoRenderLayer.Type type) {
        this.videoRenderLayerType = type;
    }

    public final boolean getUpdateVideoRenderViewPortEnable() {
        return this.updateVideoRenderViewPortEnable;
    }

    public final void setUpdateVideoRenderViewPortEnable(boolean z) {
        this.updateVideoRenderViewPortEnable = z;
    }

    public final boolean getWholeSceneEnable() {
        return this.wholeSceneEnable;
    }

    public final void setWholeSceneEnable(boolean z) {
        this.wholeSceneEnable = z;
    }

    public final int getIjkAudioStreamType() {
        return this.ijkAudioStreamType;
    }

    public final void setIjkAudioStreamType(int i) {
        this.ijkAudioStreamType = i;
    }

    public final DirectorVersion getDirectorVersion() {
        return this.directorVersion;
    }

    public final void setDirectorVersion(DirectorVersion directorVersion) {
        Intrinsics.checkNotNullParameter(directorVersion, "<set-?>");
        this.directorVersion = directorVersion;
    }

    public final PlayerType getPlayerType() {
        return this.playerType;
    }

    public final void setPlayerType(PlayerType playerType) {
        Intrinsics.checkNotNullParameter(playerType, "<set-?>");
        this.playerType = playerType;
    }

    /* compiled from: PlayerParamsV2.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerConfiguration$Theme;", "", "<init>", "()V", "PINK", "", "GREEN", "PURPLE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Theme {
        public static final int GREEN = 2;
        public static final Theme INSTANCE = new Theme();
        public static final int PINK = 1;
        public static final int PURPLE = 3;

        private Theme() {
        }
    }
}