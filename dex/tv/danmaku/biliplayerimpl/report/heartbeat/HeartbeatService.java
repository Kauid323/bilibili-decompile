package tv.danmaku.biliplayerimpl.report.heartbeat;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import bolts.Task;
import com.bilibili.api.BiliConfig;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ids.Ids;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.report.vt.VideoTimeReportService;
import tv.danmaku.biliplayerv2.PlayerSharedState;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver;
import tv.danmaku.biliplayerv2.service.IPlayerSpeedChangedObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportMetaInfo;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportStrategy;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.videoplayer.core.android.utils.PlayerEncrypt;

/* compiled from: HeartbeatService.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0005*\u0006\u001e!$'*-\b\u0000\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u0002:\u0002\u0086\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00101\u001a\u000202H\u0016J\u001a\u00106\u001a\u0002002\u0006\u00104\u001a\u0002052\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00107\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00108\u001a\u00020\bH\u0002J\b\u00109\u001a\u000200H\u0016J\u0010\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u0006H\u0016J(\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\bH\u0016J\b\u0010B\u001a\u000200H\u0016J\b\u0010C\u001a\u000200H\u0016J\u0010\u0010D\u001a\u0002002\u0006\u0010@\u001a\u00020>H\u0016J(\u0010E\u001a\u0002002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\bH\u0016J0\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\bH\u0002J0\u0010L\u001a\u0002002\u0006\u0010K\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\bH\u0002J\u0010\u0010M\u001a\u0002002\u0006\u0010@\u001a\u00020>H\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010@\u001a\u00020>H\u0016J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\u0011H\u0016J\b\u0010Q\u001a\u000200H\u0016J\u0018\u0010R\u001a\u0002002\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0016J\u0018\u0010S\u001a\u0002002\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0016J\u0018\u0010T\u001a\u0002002\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0002J\u0010\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\bH\u0016J\u0012\u0010W\u001a\u0002002\b\u0010X\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010Y\u001a\u0002002\u0006\u0010Z\u001a\u00020\u000eH\u0016J\u0010\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020>H\u0016J\u0010\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010T\u001a\u000200H\u0016J\b\u0010`\u001a\u00020\u000eH\u0016J\b\u0010a\u001a\u000200H\u0016J\u0010\u0010b\u001a\u0002002\u0006\u0010c\u001a\u00020\bH\u0016J\b\u0010d\u001a\u00020\bH\u0002J\b\u0010e\u001a\u000200H\u0002J\u0018\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\f2\u0006\u0010i\u001a\u00020\bH\u0002J\b\u0010j\u001a\u000200H\u0002J\b\u0010k\u001a\u000200H\u0002J\b\u0010l\u001a\u000200H\u0002J\b\u0010m\u001a\u000200H\u0002J\u0010\u0010n\u001a\u0002002\u0006\u0010K\u001a\u00020\nH\u0002JÁ\u0001\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020r2\u0006\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020r2\u0006\u0010v\u001a\u00020r2\u0006\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020>2\u0006\u0010y\u001a\u00020r2\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020>2\b\u0010Z\u001a\u0004\u0018\u00010\u000e2\b\u0010{\u001a\u0004\u0018\u00010\u000e2\b\u0010|\u001a\u0004\u0018\u00010\u000e2\b\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u0010}\u001a\u00020\u000e2\u0006\u0010~\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u000e2\u0007\u0010\u0080\u0001\u001a\u00020\u000e2\u0018\b\u0002\u0010\u0081\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0082\u0001H\u0002¢\u0006\u0003\u0010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020\u000eH\u0002J\u0018\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0082\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u00020G8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006\u0087\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatServiceInner;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mHitNewVt", "", "mReportMetaInfo", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "mReportContext", "Ltv/danmaku/biliplayerimpl/report/heartbeat/ReportContext;", "mSession", "", "mIsPlaying", "mSpeed", "", "mIsListPlay", "mIsMiniPlayer", "mPendingToShare", "mIsBuffering", "mHasReportStart", "isEnable", "oaid", "getOaid", "()Ljava/lang/String;", "oaid$delegate", "Lkotlin/Lazy;", "mPlayerStateObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerStateObserver$1;", "mBufferingObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mBufferingObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mBufferingObserver$1;", "mPlayerSeekObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerSeekObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerSeekObserver$1;", "mPlaySpeedChangedObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlaySpeedChangedObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlaySpeedChangedObserver$1;", "mPlayerReleaseObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerReleaseObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mPlayerReleaseObserver$1;", "mMediaResourceObserver", "tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mMediaResourceObserver$1", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$mMediaResourceObserver$1;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "restoreFromShare", "calculateTime", "onStop", "bindPlayerContainer", "playerContainer", "notifyVideoStart", "qualityId", "", "duration", "currentPosition", "isAutoQn", "notifyVideoPlay", "notifyVideoPause", "notifyVideoSeekStart", "notifyVideoSeekCompleted", "reportPreferType", "Lcom/bilibili/lib/media/resource/MediaResource;", "getReportPreferType", "(Lcom/bilibili/lib/media/resource/MediaResource;)Ljava/lang/String;", "generateReportContextAndReportStart", "commonParams", "generateReportContextAndReportStartWhenSeekComplete", "notifyVideoBufferingStart", "notifyVideoBufferingEnd", "notifyVideoSpeedChanged", "speed", "notifyActivityResume", "notifyActivityPause", "notifyVideoEnd", "notifyMetaEnd", "notifyMiniPlayerSwitch", "isMiniPlayer", "notifyMetaInfoChanged", "metaInfo", "notifyPlayModeChanged", "playMode", "notifyAutoPlay", "autoPlay", "notifyLifecycleChanged", "event", "Landroidx/lifecycle/Lifecycle$Event;", "getSession", "resetSession", "setEnable", "enable", "disableReport", "requestHeartbeatStartApi", "getHeartbeatParams", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatParams;", "reportContext", "isStart", "requestHeartbeatEndApi", "calculatePlayOrPauseTime", "calculatePlayTime", "calculatePauseTime", "requestReportClickApi", "buildBody", "", "aid", "", "cid", "part", "stime", "ftime", "type", "subType", "sid", "epid", IjkMediaMeta.IJKM_KEY_LANGUAGE, "preferType", "spmid", "fromSpmid", "trackId", "session", "extraParams", "", "(JJIJJIIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)[B", "createSessionId", "getDyeInfo", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HeartbeatService extends AbsCorePlayerService implements IHeartbeatServiceInner {
    private static final String KEY_SHARE_IS_PLAYING = "key_share_is_playing";
    private static final String KEY_SHARE_PLAYER_REPORT_SESSION = "key_share_player_report_session";
    private static final String KEY_SHARE_REPORT_CONTEXT = "key_share_report_context";
    private static final String TAG = "HeartBeatTracker";
    private boolean mHasReportStart;
    private boolean mIsBuffering;
    private boolean mIsListPlay;
    private boolean mIsMiniPlayer;
    private boolean mIsPlaying;
    private boolean mPendingToShare;
    private PlayerContainerImpl mPlayerContainer;
    private ReportContext mReportContext;
    private ReportMetaInfo mReportMetaInfo;
    private String mSession;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Boolean> hitReportDye$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean hitReportDye_delegate$lambda$0;
            hitReportDye_delegate$lambda$0 = HeartbeatService.hitReportDye_delegate$lambda$0();
            return Boolean.valueOf(hitReportDye_delegate$lambda$0);
        }
    });
    private final boolean mHitNewVt = ConfigManager.Companion.isHitFF("ff_vt_switch");
    private float mSpeed = 1.0f;
    private boolean isEnable = true;
    private final Lazy oaid$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda6
        public final Object invoke() {
            String oaid_delegate$lambda$0;
            oaid_delegate$lambda$0 = HeartbeatService.oaid_delegate$lambda$0();
            return oaid_delegate$lambda$0;
        }
    });
    private final HeartbeatService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            PlayerContainerImpl playerContainerImpl;
            PlayerContainerImpl playerContainerImpl2;
            PlayerContainerImpl playerContainerImpl3 = null;
            switch (state) {
                case 3:
                    playerContainerImpl = HeartbeatService.this.mPlayerContainer;
                    if (playerContainerImpl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl3 = playerContainerImpl;
                    }
                    IPlayerCoreService core = playerContainerImpl3.getPlayerCoreService();
                    HeartbeatService.this.notifyVideoStart(core.getCurrentQuality(), core.getRealDuration(), core.getRealCurrentPosition(), core.getDashAuto());
                    return;
                case 4:
                    HeartbeatService.this.notifyVideoPlay();
                    return;
                case 5:
                    HeartbeatService.this.notifyVideoPause();
                    return;
                case 6:
                    HeartbeatService.this.notifyMetaEnd();
                    return;
                case 7:
                    playerContainerImpl2 = HeartbeatService.this.mPlayerContainer;
                    if (playerContainerImpl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl3 = playerContainerImpl2;
                    }
                    IPlayerCoreService core2 = playerContainerImpl3.getPlayerCoreService();
                    HeartbeatService.this.notifyVideoEnd(core2.getCurrentQuality(), core2.getRealCurrentPosition());
                    return;
                default:
                    return;
            }
        }
    };
    private final HeartbeatService$mBufferingObserver$1 mBufferingObserver = new BufferingObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mBufferingObserver$1
        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingStart(int extra) {
            PlayerContainerImpl playerContainerImpl;
            HeartbeatService heartbeatService = HeartbeatService.this;
            playerContainerImpl = HeartbeatService.this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            heartbeatService.notifyVideoBufferingStart(playerContainerImpl.getPlayerCoreService().getRealCurrentPosition());
        }

        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingEnd() {
            PlayerContainerImpl playerContainerImpl;
            HeartbeatService heartbeatService = HeartbeatService.this;
            playerContainerImpl = HeartbeatService.this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            heartbeatService.notifyVideoBufferingEnd(playerContainerImpl.getPlayerCoreService().getRealCurrentPosition());
        }
    };
    private final HeartbeatService$mPlayerSeekObserver$1 mPlayerSeekObserver = new PlayerSeekObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mPlayerSeekObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekComplete(long position) {
            PlayerContainerImpl playerContainerImpl;
            playerContainerImpl = HeartbeatService.this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPlayerCoreService core = playerContainerImpl.getPlayerCoreService();
            HeartbeatService.this.notifyVideoSeekCompleted(core.getCurrentQuality(), core.getRealDuration(), core.getRealCurrentPosition(), core.getDashAuto());
        }

        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekStart(long position) {
            PlayerContainerImpl playerContainerImpl;
            HeartbeatService heartbeatService = HeartbeatService.this;
            playerContainerImpl = HeartbeatService.this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            heartbeatService.notifyVideoSeekStart(playerContainerImpl.getPlayerCoreService().getRealCurrentPosition());
        }
    };
    private final HeartbeatService$mPlaySpeedChangedObserver$1 mPlaySpeedChangedObserver = new IPlayerSpeedChangedObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mPlaySpeedChangedObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerSpeedChangedObserver
        public void onChanged(float speed) {
            HeartbeatService.this.notifyVideoSpeedChanged(speed);
        }
    };
    private final HeartbeatService$mPlayerReleaseObserver$1 mPlayerReleaseObserver = new IPlayerReleaseObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mPlayerReleaseObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public /* synthetic */ void onPlayerItemRelease() {
            IPlayerReleaseObserver.CC.$default$onPlayerItemRelease(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public /* synthetic */ void onPlayerItemWillChanged() {
            IPlayerReleaseObserver.CC.$default$onPlayerItemWillChanged(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public void onPlayerWillRelease() {
            PlayerContainerImpl playerContainerImpl;
            playerContainerImpl = HeartbeatService.this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPlayerCoreService core = playerContainerImpl.getPlayerCoreService();
            HeartbeatService.this.notifyVideoEnd(core.getCurrentQuality(), core.getRealCurrentPosition());
        }
    };
    private final HeartbeatService$mMediaResourceObserver$1 mMediaResourceObserver = new IMediaResourceObserver() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$mMediaResourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ boolean onPrepared(MediaResource mediaResource) {
            return IMediaResourceObserver.CC.$default$onPrepared(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public void onUpdated(MediaResource resource) {
            ReportContext reportContext;
            ReportContext reportContext2;
            String reportPreferType;
            if (resource == null) {
                return;
            }
            reportContext = HeartbeatService.this.mReportContext;
            if (reportContext != null) {
                reportContext.setMLanguage(resource.getCurrentLanguage());
            }
            reportContext2 = HeartbeatService.this.mReportContext;
            if (reportContext2 != null) {
                reportPreferType = HeartbeatService.this.getReportPreferType(resource);
                reportContext2.setMPerferType(reportPreferType);
            }
        }
    };

    /* compiled from: HeartbeatService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$Companion;", "", "<init>", "()V", "TAG", "", "KEY_SHARE_REPORT_CONTEXT", "KEY_SHARE_IS_PLAYING", "KEY_SHARE_PLAYER_REPORT_SESSION", "hitReportDye", "", "getHitReportDye", "()Z", "hitReportDye$delegate", "Lkotlin/Lazy;", "currentElapsedMillis", "", "currentTimeMillis", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getHitReportDye() {
            return ((Boolean) HeartbeatService.hitReportDye$delegate.getValue()).booleanValue();
        }

        public final long currentElapsedMillis() {
            return SystemClock.elapsedRealtime() / 1000;
        }

        public final long currentTimeMillis() {
            return ServerClock.unreliableNow() / 1000;
        }
    }

    static {
        HeartBeatCacheManager.INSTANCE.readCacheFileFromDisk();
        HeartBeatCacheManager.INSTANCE.retryFailedReportContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitReportDye_delegate$lambda$0() {
        return DeviceDecision.INSTANCE.getBoolean("ff_player_report_dye_872", true);
    }

    private final String getOaid() {
        return (String) this.oaid$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String oaid_delegate$lambda$0() {
        return Ids.INSTANCE.getOaid();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        restoreFromShare(bundle, true);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getPlayerCoreService().registerState(this.mPlayerStateObserver, 3, 5, 4, 7, 6);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getPlayerCoreService().registerBufferingState(this.mBufferingObserver);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerCoreService().addPlayerSpeedChangedObserver(this.mPlaySpeedChangedObserver);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerCoreService().addPlayerReleaseObserver(this.mPlayerReleaseObserver);
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl6 = null;
        }
        playerContainerImpl6.getPlayerCoreService().addMediaResourceObserver(this.mMediaResourceObserver);
        PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
        if (playerContainerImpl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl7 = null;
        }
        playerContainerImpl7.getPlayerCoreService().registerSeekObserver(this.mPlayerSeekObserver);
        if (this.mHitNewVt) {
            PlayerContainerImpl playerContainerImpl8 = this.mPlayerContainer;
            if (playerContainerImpl8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl2 = playerContainerImpl8;
            }
            playerContainerImpl2.getPlayerServiceManager().startService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(VideoTimeReportService.class));
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String str = this.mSession;
        if (!(str == null || str.length() == 0)) {
            Bundle bundle2 = bundle.getBundle();
            String str2 = this.mSession;
            Intrinsics.checkNotNull(str2);
            bundle2.putString(KEY_SHARE_PLAYER_REPORT_SESSION, str2);
        }
        ReportContext reportContext = this.mReportContext;
        if (reportContext == null) {
            return;
        }
        calculatePlayOrPauseTime();
        if (this.mIsListPlay) {
            reportContext.setMListPlayTime(reportContext.getMPlayedTime());
        }
        bundle.putSharableObject(KEY_SHARE_REPORT_CONTEXT, reportContext.copy());
        bundle.getBundle().putBoolean(KEY_SHARE_IS_PLAYING, this.mIsPlaying);
        this.mPendingToShare = true;
        this.mIsBuffering = false;
        this.mSession = null;
        this.mReportMetaInfo = null;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        this.mPendingToShare = false;
        restoreFromShare(bundle, false);
    }

    private final void restoreFromShare(PlayerSharingBundle bundle, boolean calculateTime) {
        ReportContext reportContext;
        if (bundle != null) {
            ReportMetaInfo commonParams = this.mReportMetaInfo;
            this.mSession = bundle.getBundle().getString(KEY_SHARE_PLAYER_REPORT_SESSION);
            this.mReportContext = (ReportContext) PlayerSharingBundle.getSharableObject$default(bundle, KEY_SHARE_REPORT_CONTEXT, false, 2, null);
            this.mIsPlaying = bundle.getBundle().getBoolean(KEY_SHARE_IS_PLAYING);
            PlayerSharedState playerSharedState = bundle.getPlayerSharedState();
            this.mSpeed = playerSharedState != null ? playerSharedState.getSpeedRate() : 1.0f;
            if (commonParams != null && (reportContext = this.mReportContext) != null) {
                reportContext.updateCommonParamsFromShare(commonParams);
            }
            this.mHasReportStart = this.mReportContext != null;
            this.mIsListPlay = commonParams != null ? commonParams.isListPlay() : false;
            if (calculateTime) {
                HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        HeartbeatService.this.calculatePlayOrPauseTime();
                    }
                });
                return;
            }
            return;
        }
        this.mReportContext = null;
        this.mIsPlaying = false;
        this.mSpeed = 1.0f;
        this.mIsListPlay = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        if (this.mHasReportStart) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPlayerCoreService core = playerContainerImpl.getPlayerCoreService();
            notifyVideoEnd(core.getCurrentQuality(), core.getRealCurrentPosition());
        }
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getPlayerCoreService().unregisterBufferingState(this.mBufferingObserver);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerCoreService().removePlayerSpeedChangedObserver(this.mPlaySpeedChangedObserver);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerCoreService().removePlayerReleaseObserver(this.mPlayerReleaseObserver);
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl6 = null;
        }
        playerContainerImpl6.getPlayerCoreService().removeMediaResourceObserver(this.mMediaResourceObserver);
        PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
        if (playerContainerImpl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl7 = null;
        }
        playerContainerImpl7.getPlayerCoreService().unregisterSeekObserver(this.mPlayerSeekObserver);
        this.mSession = null;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoStart(int qualityId, int duration, int currentPosition, boolean isAutoQn) {
        ReportMetaInfo commonParams;
        if (disableReport() || (commonParams = this.mReportMetaInfo) == null) {
            return;
        }
        generateReportContextAndReportStart(commonParams, qualityId, duration, currentPosition, isAutoQn);
        this.mIsListPlay = commonParams.isListPlay();
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoPlay() {
        if (!disableReport() && this.mReportContext != null) {
            this.mIsPlaying = true;
            calculatePauseTime();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoPause() {
        if (!disableReport() && this.mReportContext != null) {
            this.mIsPlaying = false;
            if (this.mIsBuffering) {
                calculatePauseTime();
            } else {
                calculatePlayTime();
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoSeekStart(int currentPosition) {
        ReportContext it;
        if (!disableReport() && (it = this.mReportContext) != null) {
            it.refreshProgress(currentPosition);
            calculatePlayOrPauseTime();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoSeekCompleted(int qualityId, int duration, int currentPosition, boolean isAutoQn) {
        ReportMetaInfo commonParams;
        if (disableReport() || (commonParams = this.mReportMetaInfo) == null) {
            return;
        }
        generateReportContextAndReportStartWhenSeekComplete(commonParams, qualityId, duration, currentPosition, isAutoQn);
        ReportContext reportContext = this.mReportContext;
        Intrinsics.checkNotNull(reportContext);
        reportContext.refreshProgress(currentPosition);
        calculatePlayOrPauseTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getReportPreferType(MediaResource $this$reportPreferType) {
        switch ($this$reportPreferType.getCurProductionType()) {
            case 1:
                return "upload";
            case 2:
                return "ai";
            default:
                return null;
        }
    }

    private final void generateReportContextAndReportStart(ReportMetaInfo commonParams, int qualityId, int duration, int currentPosition, boolean isAutoQn) {
        if (this.mReportContext == null) {
            String session = getSession();
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            MediaResource mediaResource = playerContainerImpl.getPlayerCoreService().getMediaResource();
            String language = mediaResource != null ? mediaResource.getCurrentLanguage() : null;
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl2 = null;
            }
            MediaResource mediaResource2 = playerContainerImpl2.getPlayerCoreService().getMediaResource();
            String reportPreferType = mediaResource2 != null ? getReportPreferType(mediaResource2) : null;
            this.mReportContext = ReportContext.Companion.generate(commonParams, session, language, reportPreferType, qualityId, duration, currentPosition, isAutoQn);
            requestHeartbeatStartApi();
            requestReportClickApi(commonParams);
        }
    }

    private final void generateReportContextAndReportStartWhenSeekComplete(ReportMetaInfo commonParams, int qualityId, int duration, int currentPosition, boolean isAutoQn) {
        if (this.mReportContext == null) {
            String session = getSession();
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            MediaResource mediaResource = playerContainerImpl.getPlayerCoreService().getMediaResource();
            String language = mediaResource != null ? mediaResource.getCurrentLanguage() : null;
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl2 = null;
            }
            MediaResource mediaResource2 = playerContainerImpl2.getPlayerCoreService().getMediaResource();
            String reportPreferType = mediaResource2 != null ? getReportPreferType(mediaResource2) : null;
            this.mReportContext = ReportContext.Companion.generate(commonParams, session, language, reportPreferType, qualityId, duration, currentPosition, isAutoQn);
            requestHeartbeatStartApi();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoBufferingStart(int currentPosition) {
        ReportContext it;
        if (!disableReport() && (it = this.mReportContext) != null) {
            it.refreshProgress(currentPosition);
            calculatePlayOrPauseTime();
            this.mIsBuffering = true;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoBufferingEnd(int currentPosition) {
        ReportContext it;
        if (!disableReport() && (it = this.mReportContext) != null) {
            it.refreshProgress(currentPosition);
            calculatePlayOrPauseTime();
            this.mIsBuffering = false;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoSpeedChanged(float speed) {
        if (!disableReport() && this.mReportContext != null) {
            calculatePlayOrPauseTime();
            this.mSpeed = speed;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyActivityResume() {
        final ReportContext it;
        if (!disableReport() && (it = this.mReportContext) != null) {
            HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    HeartbeatService.notifyActivityResume$lambda$0$0(ReportContext.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyActivityResume$lambda$0$0(ReportContext $reportContext) {
        HeartBeatCacheManager.INSTANCE.removeCacheFile($reportContext);
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyActivityPause(int qualityId, int currentPosition) {
        final ReportMetaInfo commonParams;
        final ReportContext it;
        if (!disableReport() && (commonParams = this.mReportMetaInfo) != null && (it = this.mReportContext) != null) {
            it.refreshMutableState(commonParams, qualityId, currentPosition);
            calculatePlayOrPauseTime();
            HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    HeartbeatService.notifyActivityPause$lambda$0$0(ReportContext.this, commonParams, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyActivityPause$lambda$0$0(ReportContext $reportContext, ReportMetaInfo $commonParams, HeartbeatService this$0) {
        $reportContext.setMExtraParams(ReportContextKt.getExtraParams($commonParams, this$0.getDyeInfo()));
        HeartBeatCacheManager.INSTANCE.saveCacheFile($reportContext);
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void notifyVideoEnd(int qualityId, int currentPosition) {
        notifyMetaEnd(qualityId, currentPosition);
        resetSession();
    }

    private final void notifyMetaEnd(int qualityId, int currentPosition) {
        ReportContext it;
        if (disableReport()) {
            resetSession();
            return;
        }
        ReportMetaInfo commonParams = this.mReportMetaInfo;
        if (commonParams != null && (it = this.mReportContext) != null) {
            it.refreshMutableState(commonParams, qualityId, currentPosition);
            calculatePlayOrPauseTime();
            requestHeartbeatEndApi();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyMiniPlayerSwitch(boolean isMiniPlayer) {
        calculatePlayOrPauseTime();
        this.mIsMiniPlayer = isMiniPlayer;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyMetaInfoChanged(ReportMetaInfo metaInfo) {
        this.mReportMetaInfo = metaInfo;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyPlayModeChanged(String playMode) {
        Intrinsics.checkNotNullParameter(playMode, "playMode");
        ReportMetaInfo reportMetaInfo = this.mReportMetaInfo;
        if (reportMetaInfo != null) {
            reportMetaInfo.setPlayMode(playMode);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyAutoPlay(int autoPlay) {
        ReportMetaInfo reportMetaInfo = this.mReportMetaInfo;
        if (reportMetaInfo != null) {
            reportMetaInfo.setFromAutoPlay(autoPlay);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyLifecycleChanged(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_PAUSE) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPlayerCoreService core = playerContainerImpl.getPlayerCoreService();
            notifyActivityPause(core.getCurrentQuality(), core.getRealCurrentPosition());
        } else if (event == Lifecycle.Event.ON_RESUME) {
            notifyActivityResume();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void notifyMetaEnd() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerCoreService core = playerContainerImpl.getPlayerCoreService();
        notifyMetaEnd(core.getCurrentQuality(), core.getRealCurrentPosition());
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public String getSession() {
        String str = this.mSession;
        if (str == null || str.length() == 0) {
            this.mSession = createSessionId();
        }
        String str2 = this.mSession;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner
    public void resetSession() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        if (!playerContainerImpl.isSharing()) {
            this.mSession = null;
        } else {
            BLog.i(TAG, "is sharing, keep session");
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService
    public void setEnable(boolean enable) {
        this.isEnable = enable;
    }

    private final boolean disableReport() {
        if (this.isEnable && !this.mPendingToShare) {
            ReportMetaInfo reportMetaInfo = this.mReportMetaInfo;
            if (!Intrinsics.areEqual(reportMetaInfo != null ? reportMetaInfo.getReportStrategy() : null, ReportStrategy.LIVE.INSTANCE)) {
                return false;
            }
        }
        return true;
    }

    private final void requestHeartbeatStartApi() {
        if (this.mReportContext == null) {
            return;
        }
        ReportContext reportContext = this.mReportContext;
        Intrinsics.checkNotNull(reportContext);
        if (reportContext.getMAid() > 0) {
            ReportContext reportContext2 = this.mReportContext;
            Intrinsics.checkNotNull(reportContext2);
            if (reportContext2.getMCid() > 0) {
                ReportContext reportContext3 = this.mReportContext;
                Intrinsics.checkNotNull(reportContext3);
                if (reportContext3.getMServerTime() == 0) {
                    ReportContext reportContext4 = this.mReportContext;
                    Intrinsics.checkNotNull(reportContext4);
                    reportContext4.setMServerTime(Companion.currentTimeMillis());
                }
                this.mHasReportStart = true;
                ReportContext reportContext5 = this.mReportContext;
                Intrinsics.checkNotNull(reportContext5);
                HeartbeatParams params = getHeartbeatParams(reportContext5, true);
                ReportContext reportContext6 = this.mReportContext;
                Intrinsics.checkNotNull(reportContext6);
                final String sessionBak = reportContext6.getMSession();
                ((HeartbeatApi) ServiceGenerator.createService(HeartbeatApi.class)).reportV2(params).enqueue(new BiliApiDataCallback<String>() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$requestHeartbeatStartApi$1
                    public void onDataSuccess(String data) {
                        ReportContext it;
                        ReportContext reportContext7;
                        it = HeartbeatService.this.mReportContext;
                        if (it != null) {
                            String str = sessionBak;
                            HeartbeatService heartbeatService = HeartbeatService.this;
                            String str2 = data;
                            if (!(str2 == null || str2.length() == 0) && Intrinsics.areEqual(it.getMSession(), str)) {
                                JSONObject json = new JSONObject(data);
                                reportContext7 = heartbeatService.mReportContext;
                                Intrinsics.checkNotNull(reportContext7);
                                reportContext7.setMServerTime(json.optLong("ts", 0L));
                            }
                        }
                    }

                    public void onError(Throwable t) {
                        Intrinsics.checkNotNullParameter(t, "t");
                    }
                });
                BLog.i(TAG, "report heartbeat start, params:" + params);
                return;
            }
        }
        BLog.e(TAG, "request block: a video report heartbeat without avid");
        if (BuildConfig.DEBUG) {
            ToastHelper.showToastLong(BiliContext.application(), "缺失参数，播放时长上报失败!");
        }
    }

    private final HeartbeatParams getHeartbeatParams(ReportContext reportContext, boolean isStart) {
        long mServerTime = isStart ? 0L : reportContext.getMServerTime();
        String mSession = reportContext.getMSession();
        long mMid = reportContext.getMMid();
        long mAid = reportContext.getMAid();
        long mCid = reportContext.getMCid();
        String mSid = reportContext.getMSid();
        long mEpid = reportContext.getMEpid();
        String mType = reportContext.getMType();
        int mSubType = reportContext.getMSubType();
        int mQuality = reportContext.getMQuality();
        long mTotalTime = isStart ? 0L : reportContext.getMTotalTime();
        long mPausedTime = isStart ? 0L : reportContext.getMPausedTime();
        long mPlayedTime = isStart ? 0L : reportContext.getMPlayedTime();
        long mVideoDuration = reportContext.getMVideoDuration();
        String mPlayType = reportContext.getMPlayType();
        int mNetworkType = reportContext.getMNetworkType();
        long mLastProcessTime = isStart ? 0L : reportContext.getMLastProcessTime();
        long mMaxPlayProgressTime = isStart ? 0L : reportContext.getMMaxPlayProgressTime();
        int mJumpFrom = reportContext.getMJumpFrom();
        String mFromSpmid = reportContext.getMFromSpmid();
        String mSpmid = reportContext.getMSpmid();
        String mEpStatus = reportContext.getMEpStatus();
        String mPlayStatus = reportContext.getMPlayStatus();
        String mUserStatus = reportContext.getMUserStatus();
        long mActualPlayedTime = isStart ? 0L : reportContext.getMActualPlayedTime();
        int mAutoPlay = reportContext.getMAutoPlay();
        long mListPlayTime = isStart ? 0L : reportContext.getMListPlayTime();
        long mMiniPlayTime = isStart ? 0L : reportContext.getMMiniPlayTime();
        String mPlayMode = reportContext.getMPlayMode();
        String mLanguage = reportContext.getMLanguage();
        String str = mLanguage == null ? "" : mLanguage;
        String mPerferType = reportContext.getMPerferType();
        String str2 = mPerferType == null ? "" : mPerferType;
        String mTrackId = reportContext.getMTrackId();
        String oaid = getOaid();
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        return new HeartbeatParams(mServerTime, mSession, mMid, mAid, mCid, mSid, mEpid, mType, mSubType, mQuality, mTotalTime, mPausedTime, mPlayedTime, mVideoDuration, mPlayType, mNetworkType, mLastProcessTime, mMaxPlayProgressTime, mJumpFrom, mFromSpmid, mSpmid, mEpStatus, mPlayStatus, mUserStatus, mActualPlayedTime, mAutoPlay, mListPlayTime, mMiniPlayTime, mPlayMode, str, str2, mTrackId, oaid, currentPolarisActionId == null ? "" : currentPolarisActionId, reportContext.getMIsAutoQn(), reportContext.getMExtraParams());
    }

    private final void requestHeartbeatEndApi() {
        if (this.mReportContext == null) {
            return;
        }
        ReportContext reportContext = this.mReportContext;
        Intrinsics.checkNotNull(reportContext);
        if (reportContext.getMAid() <= 0) {
            return;
        }
        ReportContext reportContext2 = this.mReportContext;
        Intrinsics.checkNotNull(reportContext2);
        if (reportContext2.getMServerTime() == 0) {
            ReportContext reportContext3 = this.mReportContext;
            Intrinsics.checkNotNull(reportContext3);
            reportContext3.setMServerTime(Companion.currentTimeMillis());
        }
        this.mHasReportStart = false;
        ReportContext reportContext4 = this.mReportContext;
        if (reportContext4 != null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            reportContext4.setMIsAutoQn(playerContainerImpl.getPlayerCoreService().getDashAuto());
        }
        ReportContext reportContext5 = this.mReportContext;
        if (reportContext5 != null) {
            ReportMetaInfo reportMetaInfo = this.mReportMetaInfo;
            reportContext5.setMExtraParams(reportMetaInfo != null ? ReportContextKt.getExtraParams(reportMetaInfo, getDyeInfo()) : null);
        }
        ReportContext reportContext6 = this.mReportContext;
        Intrinsics.checkNotNull(reportContext6);
        HeartbeatParams params = getHeartbeatParams(reportContext6, false);
        ReportContext reportContext7 = this.mReportContext;
        Intrinsics.checkNotNull(reportContext7);
        ReportContext reportBak = reportContext7.copy();
        ((HeartbeatApi) ServiceGenerator.createService(HeartbeatApi.class)).reportV2(params).enqueue(new HeartbeatService$requestHeartbeatEndApi$1(reportBak));
        BLog.i(TAG, "report heartbeat end, params:" + params);
        this.mReportContext = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calculatePlayOrPauseTime() {
        if (this.mIsPlaying && !this.mIsBuffering) {
            calculatePlayTime();
        } else {
            calculatePauseTime();
        }
    }

    private final void calculatePlayTime() {
        ReportContext it = this.mReportContext;
        if (it != null) {
            long currentTime = Companion.currentElapsedMillis();
            long delta = currentTime - it.getMLastActionMills();
            it.setMPlayedTime(it.getMPlayedTime() + delta);
            it.setMActualPlayedTime(it.getMActualPlayedTime() + (((float) delta) * this.mSpeed));
            if (this.mIsMiniPlayer) {
                it.setMMiniPlayTime(it.getMMiniPlayTime() + delta);
            }
            it.setMLastActionMills(currentTime);
            if (this.mIsListPlay) {
                it.setMListPlayTime(it.getMPlayedTime());
            }
        }
    }

    private final void calculatePauseTime() {
        ReportContext it = this.mReportContext;
        if (it != null) {
            long currentTime = Companion.currentElapsedMillis();
            it.setMPausedTime(it.getMPausedTime() + (currentTime - it.getMLastActionMills()));
            it.setMLastActionMills(currentTime);
        }
    }

    private final void requestReportClickApi(final ReportMetaInfo commonParams) {
        if (commonParams.getAvid() <= 0 || commonParams.getCid() <= 0) {
            long avid = commonParams.getAvid();
            BLog.e(TAG, "player report click(vv): failed! avid:" + avid + ", cid:" + commonParams.getCid());
            if (BuildConfig.DEBUG) {
                ToastHelper.showToastLong(BiliContext.application(), "重要上报vv出错, 请检查参数avid、cid!");
            }
        }
        final String session = getSession();
        final long serverTime = Companion.currentTimeMillis();
        Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit requestReportClickApi$lambda$0;
                requestReportClickApi$lambda$0 = HeartbeatService.requestReportClickApi$lambda$0(serverTime, this, commonParams, session);
                return requestReportClickApi$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit requestReportClickApi$lambda$0(long $serverTime, HeartbeatService this$0, ReportMetaInfo $commonParams, String $session) {
        long ftime;
        String str;
        String str2;
        JSONObject responseJson;
        long ftime2 = EnvironmentManager.getInstance().getPrefHelper().getFirstPlayTime();
        if (ftime2 != -1) {
            ftime = ftime2;
        } else {
            EnvironmentManager.getInstance().getPrefHelper().setFirstPlayTime($serverTime);
            ftime = $serverTime;
        }
        long avid = $commonParams.getAvid();
        long cid = $commonParams.getCid();
        int page = $commonParams.getPage();
        int type = $commonParams.getType();
        int subType = $commonParams.getSubType();
        long seasonId = $commonParams.getSeasonId();
        String epId = $commonParams.getEpId();
        int fromAutoPlay = $commonParams.getFromAutoPlay();
        String playMode = $commonParams.getPlayMode();
        ReportContext reportContext = this$0.mReportContext;
        String str3 = (reportContext == null || (r1 = reportContext.getMLanguage()) == null) ? "" : "";
        ReportContext reportContext2 = this$0.mReportContext;
        String mPerferType = reportContext2 != null ? reportContext2.getMPerferType() : null;
        ReportContext reportContext3 = this$0.mReportContext;
        byte[] body = this$0.buildBody(avid, cid, page, $serverTime, ftime, type, subType, seasonId, epId, fromAutoPlay, playMode, str3, mPerferType, reportContext3 != null ? Boolean.valueOf(reportContext3.getMIsAutoQn()) : null, $commonParams.getSpmid(), $commonParams.getFromSpmid(), $commonParams.getTrackId(), $session, ReportContextKt.getExtraParams$default($commonParams, null, 1, null));
        RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), body);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        Response response = ((HeartbeatApi) ServiceGenerator.createService(HeartbeatApi.class)).reportClick(create).execute();
        int responseCode = response.code();
        String responseMsg = response.message();
        String responseBody = (String) response.body();
        long code = 0;
        try {
            responseJson = new JSONObject(String.valueOf(responseBody));
            if (!responseJson.isNull("data")) {
                JSONObject dataJson = responseJson.getJSONObject("data");
                String did = dataJson.getString(Player.KEY_HEARTBEAT_CLICK_REPORT_DID);
                try {
                    PlayerContainerImpl playerContainerImpl = this$0.mPlayerContainer;
                    if (playerContainerImpl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainerImpl = null;
                    }
                    IPlayerSettingService playerSettingService = playerContainerImpl.getPlayerSettingService();
                    Intrinsics.checkNotNull(did);
                    playerSettingService.putString(Player.KEY_HEARTBEAT_CLICK_REPORT_DID, did);
                } catch (Exception e) {
                    e = e;
                    str = "code";
                    str2 = TAG;
                    BLog.e(str2, "player report click(vv): responseBody parse to json failed!", e);
                    BLog.i(str2, "player report click(vv): responseCode:" + responseCode + ", responseMsg:" + responseMsg + ", responseBody:" + responseBody);
                    if (BuildConfig.DEBUG) {
                        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                HeartbeatService.requestReportClickApi$lambda$0$0();
                            }
                        });
                    }
                    if (code != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
            str = "code";
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (responseJson.isNull(str)) {
                str2 = TAG;
            } else {
                code = responseJson.getLong(str);
                str2 = TAG;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = TAG;
            BLog.e(str2, "player report click(vv): responseBody parse to json failed!", e);
            BLog.i(str2, "player report click(vv): responseCode:" + responseCode + ", responseMsg:" + responseMsg + ", responseBody:" + responseBody);
            if (BuildConfig.DEBUG) {
            }
            if (code != 0) {
            }
            return Unit.INSTANCE;
        }
        BLog.i(str2, "player report click(vv): responseCode:" + responseCode + ", responseMsg:" + responseMsg + ", responseBody:" + responseBody);
        if (BuildConfig.DEBUG && code != 0) {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HeartbeatService.requestReportClickApi$lambda$0$0();
                }
            });
        }
        if (code != 0) {
            HashMap extension = new HashMap();
            extension.put(str, String.valueOf(code));
            extension.put("spmid", $commonParams.getSpmid());
            extension.put("avid", String.valueOf($commonParams.getAvid()));
            extension.put("cid", String.valueOf($commonParams.getCid()));
            extension.put("seasonId", String.valueOf($commonParams.getSeasonId()));
            extension.put("epId", $commonParams.getEpId());
            Neurons.trackT(false, "player.vv_error", extension, 1, new Function0() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean requestReportClickApi$lambda$0$1;
                    requestReportClickApi$lambda$0$1 = HeartbeatService.requestReportClickApi$lambda$0$1();
                    return Boolean.valueOf(requestReportClickApi$lambda$0$1);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestReportClickApi$lambda$0$0() {
        ToastHelper.showToast(BiliContext.application(), "重要上报vv出错, 请检查参数", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestReportClickApi$lambda$0$1() {
        return true;
    }

    static /* synthetic */ byte[] buildBody$default(HeartbeatService heartbeatService, long j, long j2, int i, long j3, long j4, int i2, int i3, long j5, String str, int i4, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, Map map, int i5, Object obj) throws Exception {
        Map map2;
        if ((i5 & 262144) == 0) {
            map2 = map;
        } else {
            map2 = null;
        }
        return heartbeatService.buildBody(j, j2, i, j3, j4, i2, i3, j5, str, i4, str2, str3, str4, bool, str5, str6, str7, str8, map2);
    }

    private final byte[] buildBody(long aid, long cid, int part, long stime, long ftime, int type, int subType, long sid, String epid, int autoPlay, String playMode, String language, String preferType, Boolean isAutoQn, String spmid, String fromSpmid, String trackId, String session, Map<String, String> map) throws Exception {
        String it;
        Map extraParams = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Application context = BiliContext.application();
        BiliAccounts client = BiliAccounts.get(context);
        AccountInfo info = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        long mid = 0;
        int lv = 0;
        if (info != null) {
            mid = info.getMid();
            lv = info.getLevel();
        }
        TreeMap map2 = new TreeMap();
        map2.put("aid", String.valueOf(aid));
        map2.put("cid", String.valueOf(cid));
        map2.put("part", String.valueOf(part));
        map2.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, String.valueOf(mid));
        map2.put("lv", String.valueOf(lv));
        map2.put("ftime", String.valueOf(ftime));
        map2.put("stime", String.valueOf(stime));
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        String did = playerContainerImpl.getPlayerSettingService().getString(Player.KEY_HEARTBEAT_CLICK_REPORT_DID, "");
        map2.put("did", did);
        map2.put("type", String.valueOf(type));
        map2.put("sub_type", String.valueOf(subType));
        map2.put("sid", String.valueOf(sid));
        map2.put("epid", epid);
        map2.put("platform", BiliConfig.getMobiApp());
        map2.put("auto_play", String.valueOf(autoPlay));
        if (client.isLogin()) {
            map2.put("access_key", client.getAccessKey());
        }
        String str = playMode;
        if (!(str == null || str.length() == 0)) {
            map2.put(Player.PLAYER_REPORT_KEY_PLAY_MODE, playMode);
        }
        map2.put("cur_language", language == null ? "" : language);
        map2.put("perfer_type", preferType == null ? "" : preferType);
        map2.put("is_auto_qn", Intrinsics.areEqual(isAutoQn, true) ? "1" : "0");
        map2.put("build", String.valueOf(BiliConfig.getBiliVersionCode()));
        map2.put("mobi_app", BiliConfig.getMobiApp());
        map2.put("spmid", spmid);
        map2.put("from_spmid", fromSpmid);
        map2.put("track_id", trackId);
        map2.put("session", session);
        map2.put("oaid", getOaid());
        TreeMap treeMap = map2;
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        treeMap.put("polaris_action_id", currentPolarisActionId);
        if (extraParams != null) {
            Map $this$forEach$iv = extraParams;
            boolean z = false;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                map2.put(element$iv.getKey(), element$iv.getValue());
                $this$forEach$iv = $this$forEach$iv;
                extraParams = extraParams;
                z = z;
            }
        }
        Map customParams = BiliConfig.getCustomParams();
        if ((customParams != null && (customParams.isEmpty() ^ true)) && (it = (String) customParams.get("statistics")) != null) {
            map2.put("statistics", it);
        }
        StringBuilder builder = new StringBuilder();
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            Iterator it3 = it2;
            BiliAccounts client2 = client;
            builder.append(key).append('=').append(Uri.encode(value == null ? "" : value)).append('&');
            it2 = it3;
            client = client2;
        }
        builder.deleteCharAt(builder.length() - 1);
        String params = builder.toString();
        Intrinsics.checkNotNullExpressionValue(params, "toString(...)");
        String sign = PlayerEncrypt.INSTANCE.getReportClickParamsSign(params);
        BLog.i(TAG, "player report click(vv), params: " + params + " & sign=" + sign);
        builder.append("&sign=").append(sign);
        String rawBody = builder.toString();
        Intrinsics.checkNotNullExpressionValue(rawBody, "toString(...)");
        return PlayerEncrypt.INSTANCE.getReportClickBodyAES(rawBody);
    }

    private final String createSessionId() {
        Random random = new Random();
        String randomStr = BuvidHelper.getBuvid() + System.currentTimeMillis() + random.nextInt(1000000);
        String sha1 = DigestUtils.signSHA1(randomStr);
        if (TextUtils.isEmpty(sha1)) {
            return randomStr;
        }
        Intrinsics.checkNotNull(sha1);
        return sha1;
    }

    private final Map<String, String> getDyeInfo() {
        if (Companion.getHitReportDye()) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            String playUrl = IPlayerCoreService.CC.getCurrentPlayUrl$default(playerContainerImpl.getPlayerCoreService(), false, 1, null);
            if (playUrl.length() == 0) {
                BLog.e(TAG, "get Dye Info error:no play url");
                return EnhancedUnmodifiabilityKt.unmodifiable((Map) null);
            }
            try {
                Uri uri = Uri.parse(playUrl);
                Map extraMap = new LinkedHashMap();
                String lastPathSegment = uri.getLastPathSegment();
                String str = "";
                if (lastPathSegment == null) {
                    lastPathSegment = "";
                }
                extraMap.put("video_file_name", lastPathSegment);
                String queryParameter = uri.getQueryParameter("qn_dyeid");
                if (queryParameter != null) {
                    str = queryParameter;
                }
                extraMap.put("video_dye_id", str);
                return EnhancedUnmodifiabilityKt.unmodifiable(extraMap);
            } catch (Exception e) {
                BLog.e(TAG, "get Dye Info error: " + e.getMessage());
                return EnhancedUnmodifiabilityKt.unmodifiable((Map) null);
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((Map) null);
    }
}