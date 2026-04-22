package tv.danmaku.videoplayer.core.log;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerLog.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/videoplayer/core/log/PlayerLogModule;", "", "<init>", "()V", PlayerLogModule.ActivityState, "", PlayerLogModule.Resolve, PlayerLogModule.Toast, PlayerLogModule.VideoDirector, PlayerLogModule.Danmaku, PlayerLogModule.Playback, "Heartbeat", PlayerLogModule.Controller, PlayerLogModule.Function, PlayerLogModule.KVO, PlayerLogModule.Render, PlayerLogModule.Chronos, PlayerLogModule.Gesture, PlayerLogModule.Volume, PlayerLogModule.Brightness, PlayerLogModule.GIF, PlayerLogModule.Quality, PlayerLogModule.PlaybackV2, PlayerLogModule.BackgroundPlay, "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerLogModule {
    public static final String ActivityState = "ActivityState";
    public static final String BackgroundPlay = "BackgroundPlay";
    public static final String Brightness = "Brightness";
    public static final String Chronos = "Chronos";
    public static final String Controller = "Controller";
    public static final String Danmaku = "Danmaku";
    public static final String Function = "Function";
    public static final String GIF = "GIF";
    public static final String Gesture = "Gesture";
    public static final String Heartbeat = "Heatbeat";
    public static final PlayerLogModule INSTANCE = new PlayerLogModule();
    public static final String KVO = "KVO";
    public static final String Playback = "Playback";
    public static final String PlaybackV2 = "PlaybackV2";
    public static final String Quality = "Quality";
    public static final String Render = "Render";
    public static final String Resolve = "Resolve";
    public static final String Toast = "Toast";
    public static final String VideoDirector = "VideoDirector";
    public static final String Volume = "Volume";

    private PlayerLogModule() {
    }
}