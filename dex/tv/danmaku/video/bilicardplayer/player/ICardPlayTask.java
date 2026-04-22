package tv.danmaku.video.bilicardplayer.player;

import android.view.ViewGroup;
import com.bilibili.playerbizcommon.features.hardware.IHardwareDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.service.ICurrentPositionInterceptor;
import tv.danmaku.biliplayerv2.service.IDurationInterceptor;
import tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor;
import tv.danmaku.biliplayerv2.service.ISeekInterceptor;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.CardPlayerLayer;
import tv.danmaku.video.bilicardplayer.CardTaskRepository;
import tv.danmaku.video.bilicardplayer.ICardPlayBufferingCallback;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerInfoListener;
import tv.danmaku.video.bilicardplayer.IControlContainerChangedCallback;
import tv.danmaku.video.bilicardplayer.IControlContainerVisibleCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuParamsChangedCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuStateChangedCallback;
import tv.danmaku.video.bilicardplayer.INetworkAlertCallback;
import tv.danmaku.video.bilicardplayer.IPlayerRenderCallback;
import tv.danmaku.video.bilicardplayer.IPlayerSeekCallback;
import tv.danmaku.video.bilicardplayer.IVideoEnvironmentChangedCallback;

/* compiled from: IBiliCardPlayer.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003STUJ\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0000H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rH&J\b\u0010\u0015\u001a\u00020\bH&J\b\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\rH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001fH&J\b\u0010\"\u001a\u00020 H&J\n\u0010#\u001a\u0004\u0018\u00010$H&J\b\u0010%\u001a\u00020\bH&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\rH&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\rH&J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\rH&J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\rH&J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\rH&J\u000e\u00100\u001a\b\u0012\u0004\u0012\u0002010\rH&J\n\u00102\u001a\u0004\u0018\u000103H&J\b\u00104\u001a\u00020\bH&J\b\u00105\u001a\u00020\bH&J\b\u00106\u001a\u00020\bH&J\n\u00107\u001a\u0004\u0018\u000108H&J\b\u00109\u001a\u00020:H&J\b\u0010;\u001a\u00020\bH&J\b\u0010<\u001a\u00020\bH&J\b\u0010=\u001a\u00020:H&J\b\u0010>\u001a\u00020\u0018H&J\b\u0010?\u001a\u00020\bH&J\b\u0010@\u001a\u00020\bH&J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0005H&J\n\u0010C\u001a\u0004\u0018\u00010DH&J\n\u0010E\u001a\u0004\u0018\u00010FH&J\b\u0010G\u001a\u00020HH&J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\bH&J\b\u0010L\u001a\u00020\bH&J\b\u0010M\u001a\u00020\bH&J\n\u0010N\u001a\u0004\u0018\u00010OH&J\b\u0010P\u001a\u00020\bH&J\b\u0010Q\u001a\u00020RH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006VÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask;", "", "getContainer", "Landroid/view/ViewGroup;", "getPlayableParamsList", "", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "different", "", "cardPlayTask", "getPlayerLayerDescriptors", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$PlayerLayerDescriptor;", "getPlayerStateChangedCallbacks", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerCallbacksInfo;", "Ltv/danmaku/video/bilicardplayer/ICardPlaySateChangedCallback;", "getPlayerRenderCallbacks", "Ltv/danmaku/video/bilicardplayer/IPlayerRenderCallback;", "getPlayerSeekCallbacks", "Ltv/danmaku/video/bilicardplayer/IPlayerSeekCallback;", "getPlayerBufferingCallback", "Ltv/danmaku/video/bilicardplayer/ICardPlayBufferingCallback;", "shouldShowWhenFirstRender", "isMute", "getDesiredQuality", "", "getMaxQuality", "getCardPlayInfoListeners", "Ltv/danmaku/video/bilicardplayer/ICardPlayerInfoListener;", "getCommonTaskProvider", "Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "getControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "getInitializedControlContainerType", "getHardwareDelegate", "Lcom/bilibili/playerbizcommon/features/hardware/IHardwareDelegate;", "enableGravitySensor", "getControlContainerChangedCallbacks", "Ltv/danmaku/video/bilicardplayer/IControlContainerChangedCallback;", "getControlContainerVisibleCallbacks", "Ltv/danmaku/video/bilicardplayer/IControlContainerVisibleCallback;", "getDanmakuStateChangedCallbacks", "Ltv/danmaku/video/bilicardplayer/IDanmakuStateChangedCallback;", "getDanmakuParamsChangedCallbacks", "Ltv/danmaku/video/bilicardplayer/IDanmakuParamsChangedCallback;", "getNetworkAlertCallbacks", "Ltv/danmaku/video/bilicardplayer/INetworkAlertCallback;", "getVideoEnvironmentChangedCallbacks", "Ltv/danmaku/video/bilicardplayer/IVideoEnvironmentChangedCallback;", "getCardTaskRepository", "Ltv/danmaku/video/bilicardplayer/CardTaskRepository;", "enableNetworkToast", "enableNetworkAlert", "isAutoShowControlContainer", "getMediaHistoryReader", "Ltv/danmaku/video/bilicardplayer/player/IMediaHistoryReader;", "getStartPosition", "", "isDanmakuInlineMode", "isDanmakuSwitchShareEnable", "getCustomFakeDuration", "getSharedRecordId", "enableChronos", "enableDaltonismFilter", "getSeekInterceptor", "Ltv/danmaku/biliplayerv2/service/ISeekInterceptor;", "getCurrentPositionInterceptor", "Ltv/danmaku/biliplayerv2/service/ICurrentPositionInterceptor;", "getDurationInterceptor", "Ltv/danmaku/biliplayerv2/service/IDurationInterceptor;", "getDanmakuInteractConf", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$DanmakuInteractConf;", "getCardPlayerReportScene", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$CardPlayerReportScene;", "enablePreLoad", "useTransparentLayer", "isInnerTouchEventForbidden", "getMediaItemSettingInterceptor", "Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "enableResetAudioIndex", "getLiveScene", "", "PlayerLayerDescriptor", "DanmakuInteractConf", "CardPlayerReportScene", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ICardPlayTask {

    /* compiled from: IBiliCardPlayer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$CardPlayerReportScene;", "", "<init>", "(Ljava/lang/String;I)V", "Inline", "MiniScreen", "Undefined", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum CardPlayerReportScene {
        Inline,
        MiniScreen,
        Undefined;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<CardPlayerReportScene> getEntries() {
            return $ENTRIES;
        }
    }

    boolean different(ICardPlayTask iCardPlayTask);

    boolean enableChronos();

    boolean enableDaltonismFilter();

    boolean enableGravitySensor();

    boolean enableNetworkAlert();

    boolean enableNetworkToast();

    boolean enablePreLoad();

    boolean enableResetAudioIndex();

    CardPlayerCallbacksInfo<ICardPlayerInfoListener> getCardPlayInfoListeners();

    CardPlayerReportScene getCardPlayerReportScene();

    CardTaskRepository getCardTaskRepository();

    CommonResolveTaskProvider getCommonTaskProvider();

    ViewGroup getContainer();

    CardPlayerCallbacksInfo<IControlContainerChangedCallback> getControlContainerChangedCallbacks();

    Map<ControlContainerType, ControlContainerConfig> getControlContainerConfig();

    CardPlayerCallbacksInfo<IControlContainerVisibleCallback> getControlContainerVisibleCallbacks();

    ICurrentPositionInterceptor getCurrentPositionInterceptor();

    long getCustomFakeDuration();

    DanmakuInteractConf getDanmakuInteractConf();

    CardPlayerCallbacksInfo<IDanmakuParamsChangedCallback> getDanmakuParamsChangedCallbacks();

    CardPlayerCallbacksInfo<IDanmakuStateChangedCallback> getDanmakuStateChangedCallbacks();

    int getDesiredQuality();

    IDurationInterceptor getDurationInterceptor();

    IHardwareDelegate getHardwareDelegate();

    ControlContainerType getInitializedControlContainerType();

    String getLiveScene();

    int getMaxQuality();

    IMediaHistoryReader getMediaHistoryReader();

    IMediaItemParamsInterceptor getMediaItemSettingInterceptor();

    CardPlayerCallbacksInfo<INetworkAlertCallback> getNetworkAlertCallbacks();

    List<Video.PlayableParams> getPlayableParamsList();

    CardPlayerCallbacksInfo<ICardPlayBufferingCallback> getPlayerBufferingCallback();

    List<PlayerLayerDescriptor> getPlayerLayerDescriptors();

    CardPlayerCallbacksInfo<IPlayerRenderCallback> getPlayerRenderCallbacks();

    CardPlayerCallbacksInfo<IPlayerSeekCallback> getPlayerSeekCallbacks();

    CardPlayerCallbacksInfo<ICardPlaySateChangedCallback> getPlayerStateChangedCallbacks();

    List<ISeekInterceptor> getSeekInterceptor();

    int getSharedRecordId();

    long getStartPosition();

    CardPlayerCallbacksInfo<IVideoEnvironmentChangedCallback> getVideoEnvironmentChangedCallbacks();

    boolean isAutoShowControlContainer();

    boolean isDanmakuInlineMode();

    boolean isDanmakuSwitchShareEnable();

    boolean isInnerTouchEventForbidden();

    boolean isMute();

    boolean shouldShowWhenFirstRender();

    boolean useTransparentLayer();

    /* compiled from: IBiliCardPlayer.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.player.ICardPlayTask$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: IBiliCardPlayer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$PlayerLayerDescriptor;", "", "over", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "layer", "Ltv/danmaku/video/bilicardplayer/CardPlayerLayer;", "<init>", "(Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;Ltv/danmaku/video/bilicardplayer/CardPlayerLayer;)V", "getOver", "()Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "getLayer", "()Ltv/danmaku/video/bilicardplayer/CardPlayerLayer;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class PlayerLayerDescriptor {
        private final CardPlayerLayer layer;
        private final BuiltInLayer over;

        public PlayerLayerDescriptor(BuiltInLayer over, CardPlayerLayer layer) {
            Intrinsics.checkNotNullParameter(over, "over");
            Intrinsics.checkNotNullParameter(layer, "layer");
            this.over = over;
            this.layer = layer;
        }

        public final CardPlayerLayer getLayer() {
            return this.layer;
        }

        public final BuiltInLayer getOver() {
            return this.over;
        }
    }

    /* compiled from: IBiliCardPlayer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$DanmakuInteractConf;", "", "click", "", "longClick", "<init>", "(ZZ)V", "getClick", "()Z", "getLongClick", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuInteractConf {
        private final boolean click;
        private final boolean longClick;

        public DanmakuInteractConf(boolean click, boolean longClick) {
            this.click = click;
            this.longClick = longClick;
        }

        public final boolean getClick() {
            return this.click;
        }

        public final boolean getLongClick() {
            return this.longClick;
        }
    }
}