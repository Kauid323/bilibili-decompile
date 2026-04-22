package tv.danmaku.biliplayerimpl.report;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.droid.media.AudioManagerHelper;
import com.bilibili.ids.Ids;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accountinfo.model.VipUserInfo;
import com.bilibili.lib.heartbeat.HeartBeatReport;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.PlayerCodecConfig;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.SamplesKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatDataModel;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver;
import tv.danmaku.biliplayerv2.service.IPlayerSpeedChangedObserver;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.report.NormalDataModel;
import tv.danmaku.biliplayerv2.service.report.PlayScene;
import tv.danmaku.biliplayerv2.service.report.PlayerReportCommonField;
import tv.danmaku.biliplayerv2.service.report.ReportStrategy;
import tv.danmaku.biliplayerv2.service.report.VideoFormat;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: DataReporterService.kt */
@Metadata(d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\t&),/258;>\b\u0000\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001kB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001cH\u0002J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u001a\u0010G\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010H\u001a\u00020B2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010I\u001a\u00020B2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010J\u001a\u00020BH\u0016J\u0010\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020\u0006H\u0016J\b\u0010M\u001a\u00020BH\u0016J\b\u0010N\u001a\u00020\u0017H\u0016J\u0012\u0010O\u001a\u00020B2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u001a\u0010R\u001a\u00020B2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020\u000eH\u0016J\u0010\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020\u0010H\u0016J\u0010\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u0014H\u0016J\u001e\u0010Z\u001a\u00020B2\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cH\u0016J\b\u0010\\\u001a\u00020BH\u0016J\u0010\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0002J\n\u0010b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010c\u001a\u00020BH\u0002J2\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020\u00172\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001c2\b\b\u0002\u0010g\u001a\u00020 H\u0002J\u0012\u0010h\u001a\u00020B2\b\u0010i\u001a\u0004\u0018\u00010jH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020 8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u0010\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?¨\u0006l"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/DataReporterService;", "Ltv/danmaku/biliplayerv2/service/report/IReporterService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mEventReportCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "mReporterData", "Ltv/danmaku/biliplayerv2/service/report/NormalDataModel;", "mReportStrategy", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "mPlayerShotByOther", "", "mScreenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "mSpeed", "", "mScene", "Ltv/danmaku/biliplayerv2/service/report/PlayScene;", "mIsBuffering", "mSession", "", "waitReportEnd", "getWaitReportEnd", "()Z", "mExtraReportParams", "", "mStartTimeMs", "", "mMaxVolume", "", "getMMaxVolume", "()I", "mCurrentVolume", "getMCurrentVolume", "mAppHeartBeatListener", "tv/danmaku/biliplayerimpl/report/DataReporterService$mAppHeartBeatListener$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mAppHeartBeatListener$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerStateObserver$1;", "mPlayerSeekObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerSeekObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerSeekObserver$1;", "mBufferingObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mBufferingObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mBufferingObserver$1;", "mPlaySpeedObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mPlaySpeedObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mPlaySpeedObserver$1;", "mMediaResourceUpdateObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mMediaResourceUpdateObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mMediaResourceUpdateObserver$1;", "mPlayerReleaseObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerReleaseObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mPlayerReleaseObserver$1;", "mErrorObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mErrorObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mErrorObserver$1;", "mRenderStartObserver", "tv/danmaku/biliplayerimpl/report/DataReporterService$mRenderStartObserver$1", "Ltv/danmaku/biliplayerimpl/report/DataReporterService$mRenderStartObserver$1;", "buildAppHeartBeatReportParams", "onCollectSharedParams", "", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onAttachByShared", "onStart", "restoreFromShare", "onStop", "bindPlayerContainer", "playerContainer", "onPlayerReset", "getSession", "notifyVideoChanged", "commonField", "Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;", "updateVideoInfo", "videoFormat", "Ltv/danmaku/biliplayerv2/service/report/VideoFormat;", "isLocalVideo", "notifyScreenModeTypeChanged", "screenType", "notifySceneChange", LoginSceneProcessor.SCENE_KEY, "notifyExtraReportParamsChanged", "extraReportParams", "resetSession", "report", "event", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "getHeartbeatDataModel", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatDataModel;", "getLatestReportData", "resetState", "reportTech", "eventId", "params", "sample", "updateVideoInfoFromMediaResource", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DataReporterService extends AbsCorePlayerService implements IReporterService {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_SHARE_REPORTER_SESSION = "key_share_data_reporter_session";
    private static final String TAG = "PlayerReportService";
    private Map<String, String> mExtraReportParams;
    private boolean mIsBuffering;
    private PlayerContainerImpl mPlayerContainer;
    private boolean mPlayerShotByOther;
    private NormalDataModel mReporterData;
    private ScreenModeType mScreenModeType;
    private String mSession;
    private float mSpeed;
    private long mStartTimeMs;
    private final AtomicInteger mEventReportCount = new AtomicInteger(0);
    private ReportStrategy mReportStrategy = ReportStrategy.DEFAULT.INSTANCE;
    private PlayScene mScene = PlayScene.DEFAULT;
    private int mMaxVolume = -1;
    private int mCurrentVolume = -1;
    private final DataReporterService$mAppHeartBeatListener$1 mAppHeartBeatListener = new HeartBeatReport.HeartBeatListener() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mAppHeartBeatListener$1
        public Map<String, String> extraParams() {
            Map buildAppHeartBeatReportParams;
            buildAppHeartBeatReportParams = DataReporterService.this.buildAppHeartBeatReportParams();
            return EnhancedUnmodifiabilityKt.unmodifiable(buildAppHeartBeatReportParams);
        }
    };
    private final DataReporterService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mPlayerStateObserver$1
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
            if (r0 != false) goto L24;
         */
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPlayerStateChanged(int state) {
            ReportStrategy reportStrategy;
            boolean z;
            ReportStrategy reportStrategy2;
            ReportStrategy reportStrategy3;
            ReportStrategy reportStrategy4;
            switch (state) {
                case 3:
                    reportStrategy = DataReporterService.this.mReportStrategy;
                    if (!Intrinsics.areEqual(reportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
                        z = DataReporterService.this.mPlayerShotByOther;
                        break;
                    }
                    DataReporterService.this.report(NeuronsEvents.Start.INSTANCE);
                    DataReporterService.this.mPlayerShotByOther = false;
                    return;
                case 4:
                    reportStrategy2 = DataReporterService.this.mReportStrategy;
                    if (Intrinsics.areEqual(reportStrategy2, ReportStrategy.DEFAULT.INSTANCE)) {
                        DataReporterService.this.report(NeuronsEvents.Resume.INSTANCE);
                        return;
                    }
                    return;
                case 5:
                    reportStrategy3 = DataReporterService.this.mReportStrategy;
                    if (Intrinsics.areEqual(reportStrategy3, ReportStrategy.DEFAULT.INSTANCE)) {
                        DataReporterService.this.report(NeuronsEvents.Pause.INSTANCE);
                        return;
                    }
                    return;
                case 6:
                case 7:
                    reportStrategy4 = DataReporterService.this.mReportStrategy;
                    if (Intrinsics.areEqual(reportStrategy4, ReportStrategy.DEFAULT.INSTANCE)) {
                        DataReporterService.this.report(new NeuronsEvents.End(NeuronsEvents.End.Type.NORMAL));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final DataReporterService$mPlayerSeekObserver$1 mPlayerSeekObserver = new PlayerSeekObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mPlayerSeekObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekComplete(long position) {
            ReportStrategy reportStrategy;
            boolean waitReportEnd;
            reportStrategy = DataReporterService.this.mReportStrategy;
            if (Intrinsics.areEqual(reportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
                DataReporterService.this.report(new NeuronsEvents.SeekEnd());
                waitReportEnd = DataReporterService.this.getWaitReportEnd();
                if (!waitReportEnd) {
                    DataReporterService.this.report(NeuronsEvents.Start.INSTANCE);
                }
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekStart(long position) {
            ReportStrategy reportStrategy;
            reportStrategy = DataReporterService.this.mReportStrategy;
            if (Intrinsics.areEqual(reportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
                DataReporterService.this.report(new NeuronsEvents.SeekStart());
            }
        }
    };
    private final DataReporterService$mBufferingObserver$1 mBufferingObserver = new BufferingObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mBufferingObserver$1
        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingStart(int extra) {
            DataReporterService.this.mIsBuffering = true;
        }

        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingEnd() {
            DataReporterService.this.mIsBuffering = false;
        }
    };
    private final DataReporterService$mPlaySpeedObserver$1 mPlaySpeedObserver = new IPlayerSpeedChangedObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mPlaySpeedObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerSpeedChangedObserver
        public void onChanged(float speed) {
            ReportStrategy reportStrategy;
            DataReporterService.this.mSpeed = speed;
            reportStrategy = DataReporterService.this.mReportStrategy;
            if (Intrinsics.areEqual(reportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
                DataReporterService.this.report(NeuronsEvents.SwitchSpeed.INSTANCE);
            }
        }
    };
    private final DataReporterService$mMediaResourceUpdateObserver$1 mMediaResourceUpdateObserver = new IMediaResourceObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mMediaResourceUpdateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ boolean onPrepared(MediaResource mediaResource) {
            return IMediaResourceObserver.CC.$default$onPrepared(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public void onUpdated(MediaResource resource) {
            ReportStrategy reportStrategy;
            reportStrategy = DataReporterService.this.mReportStrategy;
            if (Intrinsics.areEqual(reportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
                DataReporterService.this.updateVideoInfoFromMediaResource(resource);
            }
        }
    };
    private final DataReporterService$mPlayerReleaseObserver$1 mPlayerReleaseObserver = new IPlayerReleaseObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mPlayerReleaseObserver$1
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
            DataReporterService.this.report(new NeuronsEvents.End(NeuronsEvents.End.Type.NORMAL));
            DataReporterService.this.mPlayerShotByOther = true;
        }
    };
    private final DataReporterService$mErrorObserver$1 mErrorObserver = new PlayerErrorObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mErrorObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerErrorObserver
        public void onPlayerError(IMediaPlayer player, int what, int extra) {
            Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
            Map map = MapsKt.mapOf(new Pair[]{TuplesKt.to("code", String.valueOf(what)), TuplesKt.to("error_msg", String.valueOf(extra))});
            DataReporterService.this.reportTech("player.tech.track.play.error", map, 20);
        }
    };
    private final DataReporterService$mRenderStartObserver$1 mRenderStartObserver = new IRenderStartObserver() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$mRenderStartObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public /* synthetic */ void onAudioRenderStart() {
            IRenderStartObserver.CC.$default$onAudioRenderStart(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onVideoRenderStart() {
            DataReporterService.this.mStartTimeMs = 0L;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getWaitReportEnd() {
        return this.mSession != null;
    }

    private final int getMMaxVolume() {
        if (this.mPlayerContainer != null && this.mMaxVolume < 0) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            PlayerContainerImpl playerContainerImpl2 = null;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            Context context = playerContainerImpl.getContext();
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl2 = playerContainerImpl3;
            }
            this.mMaxVolume = AudioManagerHelper.getStreamMaxVolume(context, playerContainerImpl2.getPlayerParams().getConfig().getIjkAudioStreamType());
        }
        return this.mMaxVolume;
    }

    private final int getMCurrentVolume() {
        if (this.mPlayerContainer != null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            PlayerContainerImpl playerContainerImpl2 = null;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            Context context = playerContainerImpl.getContext();
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl2 = playerContainerImpl3;
            }
            this.mCurrentVolume = AudioManagerHelper.getStreamVolume(context, playerContainerImpl2.getPlayerParams().getConfig().getIjkAudioStreamType());
        }
        return this.mCurrentVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> buildAppHeartBeatReportParams() {
        HeartbeatDataModel heartbeatDataModel = getHeartbeatDataModel();
        if (heartbeatDataModel == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(MapsKt.emptyMap());
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        if (!playerContainerImpl.getPlayerCoreService().isCorePlayerActive()) {
            return EnhancedUnmodifiabilityKt.unmodifiable(MapsKt.emptyMap());
        }
        Map params = new LinkedHashMap();
        params.put("avid", heartbeatDataModel.getAvid());
        params.put("cid", heartbeatDataModel.getCid());
        params.put("seasonid", heartbeatDataModel.getSeasonid());
        params.put("epid", heartbeatDataModel.getEpid());
        params.put("playback_status", heartbeatDataModel.getPlaybackStatus());
        params.put("playback_time", heartbeatDataModel.getPlaybackTime());
        params.put("playback_rate", heartbeatDataModel.getPlaybackRate());
        params.put("is_buffering", String.valueOf(heartbeatDataModel.isBuffering()));
        params.put("video_quality", heartbeatDataModel.getVideoQuality());
        params.put("track_id", heartbeatDataModel.getTrackid());
        params.put("from_spmid", heartbeatDataModel.getFromSpmid());
        params.put("spmid", heartbeatDataModel.getSpmid());
        params.put(LoginSceneProcessor.SCENE_KEY, heartbeatDataModel.getScene());
        params.put("playerSessionId", getSession());
        return EnhancedUnmodifiabilityKt.unmodifiable(params);
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
            bundle2.putString(KEY_SHARE_REPORTER_SESSION, str2);
        }
        HeartBeatReport.INSTANCE.unregisterHeartBeatListener(this.mAppHeartBeatListener);
        resetState();
        this.mSession = null;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        HeartBeatReport.INSTANCE.registerHeartBeatListener(this.mAppHeartBeatListener);
        restoreFromShare(bundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        HeartBeatReport.INSTANCE.registerHeartBeatListener(this.mAppHeartBeatListener);
        restoreFromShare(bundle);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerCoreService $this$onStart_u24lambda_u240 = playerContainerImpl.getPlayerCoreService();
        $this$onStart_u24lambda_u240.registerState(this.mPlayerStateObserver, 5, 4, 3, 6, 7);
        $this$onStart_u24lambda_u240.addPlayerSpeedChangedObserver(this.mPlaySpeedObserver);
        $this$onStart_u24lambda_u240.registerSeekObserver(this.mPlayerSeekObserver);
        $this$onStart_u24lambda_u240.addMediaResourceObserver(this.mMediaResourceUpdateObserver);
        $this$onStart_u24lambda_u240.registerBufferingState(this.mBufferingObserver);
        $this$onStart_u24lambda_u240.addPlayerReleaseObserver(this.mPlayerReleaseObserver);
        $this$onStart_u24lambda_u240.registerPlayerErrorObserver(this.mErrorObserver);
        $this$onStart_u24lambda_u240.addRenderStartObserver(this.mRenderStartObserver);
    }

    private final void restoreFromShare(PlayerSharingBundle bundle) {
        Bundle bundle2;
        String str = null;
        if (bundle != null && (bundle2 = bundle.getBundle()) != null) {
            str = bundle2.getString(KEY_SHARE_REPORTER_SESSION, null);
        }
        this.mSession = str;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        if (getWaitReportEnd()) {
            report(new NeuronsEvents.End(NeuronsEvents.End.Type.NORMAL));
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerCoreService $this$onStop_u24lambda_u240 = playerContainerImpl.getPlayerCoreService();
        $this$onStop_u24lambda_u240.unregisterState(this.mPlayerStateObserver);
        $this$onStop_u24lambda_u240.removePlayerSpeedChangedObserver(this.mPlaySpeedObserver);
        $this$onStop_u24lambda_u240.unregisterSeekObserver(this.mPlayerSeekObserver);
        $this$onStop_u24lambda_u240.removeMediaResourceObserver(this.mMediaResourceUpdateObserver);
        $this$onStop_u24lambda_u240.unregisterBufferingState(this.mBufferingObserver);
        $this$onStop_u24lambda_u240.removePlayerReleaseObserver(this.mPlayerReleaseObserver);
        $this$onStop_u24lambda_u240.unregisterPlayerErrorObserver(this.mErrorObserver);
        $this$onStop_u24lambda_u240.removeRenderStartObserver(this.mRenderStartObserver);
        HeartBeatReport.INSTANCE.unregisterHeartBeatListener(this.mAppHeartBeatListener);
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onPlayerReset() {
        resetSession();
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public String getSession() {
        String str = this.mSession;
        if (str == null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            return playerContainerImpl.getHeartbeatService().getSession();
        }
        return str;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void notifyVideoChanged(PlayerReportCommonField commonField) {
        if (this.mPlayerContainer == null) {
            BLog.i(TAG, "set report info not ready");
            return;
        }
        PlayerContainerImpl playerContainerImpl = null;
        if (commonField == null) {
            BLog.i(TAG, "set report info null");
            this.mReporterData = null;
            this.mReportStrategy = ReportStrategy.DEFAULT.INSTANCE;
            return;
        }
        BLog.i(TAG, "set report info avid:" + commonField.getAvid() + " cid:" + commonField.getVideoId());
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        PlayerCodecConfig playerConfig = playerContainerImpl2.getPlayerCoreService().getPlayerCodecConfig();
        this.mReporterData = new NormalDataModel(commonField, playerConfig);
        if (Intrinsics.areEqual(this.mReportStrategy, ReportStrategy.DEFAULT.INSTANCE)) {
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl = playerContainerImpl3;
            }
            updateVideoInfoFromMediaResource(playerContainerImpl.getPlayerCoreService().getMediaResource());
        } else {
            NormalDataModel normalDataModel = this.mReporterData;
            if (normalDataModel != null) {
                normalDataModel.updateVideoInfo(commonField.getVideoFormat(), commonField.isLocalVideo());
            }
        }
        this.mReportStrategy = commonField.getCustomized();
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void updateVideoInfo(VideoFormat videoFormat, boolean isLocalVideo) {
        NormalDataModel normalDataModel = this.mReporterData;
        if (normalDataModel != null) {
            normalDataModel.updateVideoInfo(videoFormat, Boolean.valueOf(isLocalVideo));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void notifyScreenModeTypeChanged(ScreenModeType screenType) {
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        this.mScreenModeType = screenType;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void notifySceneChange(PlayScene scene) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        this.mScene = scene;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void notifyExtraReportParamsChanged(Map<String, String> map) {
        Map extraReportParams = EnhancedUnmodifiabilityKt.unmodifiable(map);
        this.mExtraReportParams = extraReportParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void resetSession() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getHeartbeatService().resetSession();
    }

    @Override // tv.danmaku.biliplayerv2.service.report.IReporterService
    public void report(NeuronsEvents.Event event) {
        String playerClarity;
        Object obj;
        VipUserInfo vipInfo;
        VipUserInfo vipInfo2;
        VipUserInfo vipInfo3;
        VipUserInfo vipInfo4;
        String valueOf;
        VipUserInfo vipInfo5;
        VipUserInfo vipInfo6;
        int status;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mPlayerContainer == null) {
            return;
        }
        if (Intrinsics.areEqual(event.getEvent(), NeuronsEvents.END) && !getWaitReportEnd()) {
            BLog.i("wait report start");
        } else if (Intrinsics.areEqual(event.getEvent(), NeuronsEvents.START) && getWaitReportEnd()) {
            BLog.i("has report start");
        } else {
            NormalDataModel normalDataModel = getLatestReportData();
            if (normalDataModel == null) {
                return;
            }
            String eventType = event.getEvent();
            HashMap argsMap = new HashMap();
            event.dumpTo(argsMap);
            String fromSpmid = normalDataModel.getFromSpmid();
            String seasonId = normalDataModel.getSeasonId();
            int type = normalDataModel.getType();
            int subType = normalDataModel.getSubType();
            String epId = normalDataModel.getEpId();
            String progress = normalDataModel.getProgress();
            String avid = normalDataModel.getAvid();
            String cid = normalDataModel.getCid();
            int networkType = normalDataModel.getNetworkType();
            int danmaku = normalDataModel.getDanmaku();
            int status2 = normalDataModel.getStatus();
            int playMethod = normalDataModel.getPlayMethod();
            int playType = normalDataModel.getPlayType();
            String playerSessionId = getSession();
            String speed = normalDataModel.getSpeed();
            String playerClarity2 = normalDataModel.getPlayerClarity();
            int isAutoplay = normalDataModel.isAutoplay();
            int videoFormat = normalDataModel.getVideoFormat();
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_IS_VERTICAL_VIDEO, normalDataModel.isVertical());
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_SPMID, normalDataModel.getSpmid());
            this.mEventReportCount.incrementAndGet();
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_STATE, normalDataModel.getPlayerState());
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_SEQUENCE, String.valueOf(this.mEventReportCount.get()));
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_IS_BACKGROUND, BiliContext.isVisible() ? "2" : "1");
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_SCENE, normalDataModel.getScene());
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_IS_LANGUAGE, normalDataModel.getLanguage());
            Map<String, String> extraParams = normalDataModel.getExtraParams();
            if (!(extraParams == null || extraParams.isEmpty())) {
                Map<String, String> extraParams2 = normalDataModel.getExtraParams();
                Intrinsics.checkNotNull(extraParams2);
                argsMap.putAll(extraParams2);
            }
            AccountInfo account = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
            String event2 = event.getEvent();
            switch (event2.hashCode()) {
                case -556972998:
                    if (event2.equals(NeuronsEvents.START)) {
                        playerClarity = playerClarity2;
                        argsMap.put("oaid", Ids.INSTANCE.getOaid());
                        argsMap.put("android_id", Ids.INSTANCE.getAndroidId());
                        argsMap.put("max_system_volume", String.valueOf(getMMaxVolume()));
                        argsMap.put("original_system_volume", String.valueOf(getMCurrentVolume()));
                        argsMap.put("track_id", normalDataModel.getTrackId());
                        argsMap.put("vip_type", (account == null || (vipInfo2 = account.getVipInfo()) == null || (r8 = String.valueOf(vipInfo2.getVipType())) == null) ? "" : "");
                        String str = (String) argsMap.put("vip_status", (account == null || (vipInfo = account.getVipInfo()) == null || (r8 = String.valueOf(vipInfo.getVipStatus())) == null) ? "" : "");
                        this.mSession = playerSessionId;
                        obj = NeuronsEvents.START;
                        this.mStartTimeMs = System.currentTimeMillis();
                        BLog.i(TAG, "report player start session:" + playerSessionId + " aid:" + avid + " cid:" + cid);
                        break;
                    }
                    obj = NeuronsEvents.START;
                    playerClarity = playerClarity2;
                    break;
                case 1765966369:
                    if (event2.equals(NeuronsEvents.END)) {
                        this.mSession = null;
                        argsMap.put("vip_type", (account == null || (vipInfo4 = account.getVipInfo()) == null || (valueOf = String.valueOf(vipInfo4.getVipType())) == null) ? "" : valueOf);
                        String str2 = (String) argsMap.put("vip_status", (account == null || (vipInfo3 = account.getVipInfo()) == null || (r8 = String.valueOf(vipInfo3.getVipStatus())) == null) ? "" : "");
                        BLog.i(TAG, "report player end session:" + playerSessionId + " aid:" + avid + " cid:" + cid);
                        obj = NeuronsEvents.START;
                        playerClarity = playerClarity2;
                        break;
                    }
                    obj = NeuronsEvents.START;
                    playerClarity = playerClarity2;
                    break;
                case 2106437480:
                    if (event2.equals(NeuronsEvents.SWITCH)) {
                        argsMap.put("vip_type", (account == null || (vipInfo6 = account.getVipInfo()) == null || (r6 = String.valueOf(vipInfo6.getVipType())) == null) ? "" : "");
                        argsMap.put("vip_status", (account == null || (vipInfo5 = account.getVipInfo()) == null || (r6 = String.valueOf(vipInfo5.getVipStatus())) == null) ? "" : "");
                        argsMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, playerClarity2);
                        obj = NeuronsEvents.START;
                        playerClarity = playerClarity2;
                        break;
                    }
                    obj = NeuronsEvents.START;
                    playerClarity = playerClarity2;
                    break;
                default:
                    obj = NeuronsEvents.START;
                    playerClarity = playerClarity2;
                    break;
            }
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_IS_LOCAL_VIDEO, normalDataModel.isLocalVideo());
            argsMap.put(NeuronsEvents.PLAYER_EVENT_EX_KEY_DM_SERVICE_SWITCH, normalDataModel.getDmServiceSwitch());
            Map extraParams3 = this.mExtraReportParams;
            if (!(extraParams3 == null || extraParams3.isEmpty())) {
                argsMap.putAll(extraParams3);
            }
            if (!BuildConfig.DEBUG) {
                status = status2;
            } else if (Intrinsics.areEqual(event.getEvent(), NeuronsEvents.END) || Intrinsics.areEqual(event.getEvent(), obj)) {
                status = status2;
                BLog.i(TAG, "report player params status:" + status + " params:" + argsMap);
            } else {
                status = status2;
            }
            Neurons.reportPlayer(true, eventType, fromSpmid, seasonId, type, subType, epId, progress, avid, cid, networkType, danmaku, status, playMethod, playType, playerSessionId, speed, playerClarity, isAutoplay, videoFormat, argsMap);
            if (Intrinsics.areEqual(event, NeuronsEvents.Start.INSTANCE)) {
                AppsFlyerWrapper.logEvent("media_play");
            }
            if (Intrinsics.areEqual(event.getEvent(), NeuronsEvents.END) && this.mStartTimeMs > 0) {
                Map map = MapsKt.mapOf(TuplesKt.to("wait_time", String.valueOf(System.currentTimeMillis() - this.mStartTimeMs)));
                reportTech("player.tech.track.end.error", map, 5);
            }
        }
    }

    private final HeartbeatDataModel getHeartbeatDataModel() {
        NormalDataModel reportData = getLatestReportData();
        if (reportData == null) {
            return null;
        }
        return HeartbeatDataModel.Companion.generateFromReportInfo(reportData, this.mIsBuffering);
    }

    private final NormalDataModel getLatestReportData() {
        String progress;
        float playSpeed$default;
        PlayIndex playIndex;
        NormalDataModel reportData = this.mReporterData;
        PlayerContainerImpl playerContainerImpl = null;
        if (reportData == null) {
            return null;
        }
        if (reportData.getProgressStrategy() == null) {
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl2 = null;
            }
            progress = String.valueOf(playerContainerImpl2.getPlayerCoreService().getRealCurrentPosition());
        } else {
            Function0<Long> progressStrategy = reportData.getProgressStrategy();
            Intrinsics.checkNotNull(progressStrategy);
            progress = String.valueOf(((Number) progressStrategy.invoke()).longValue());
        }
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        int networkType = playerContainerImpl3.getPlayerNetworkMonitor().getNetworkState();
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        boolean isDanmakuShow = playerContainerImpl4.getInteractLayerService().isDanmakuVisible();
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        int playMode = playerContainerImpl5.getPlayerSettingService().getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0);
        if (!(this.mSpeed == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
            playSpeed$default = this.mSpeed;
        } else {
            PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
            if (playerContainerImpl6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl6 = null;
            }
            playSpeed$default = IPlayerCoreService.CC.getPlaySpeed$default(playerContainerImpl6.getPlayerCoreService(), false, 1, null);
        }
        float speed = playSpeed$default;
        PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
        if (playerContainerImpl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl7 = null;
        }
        MediaResource mediaResource = playerContainerImpl7.getPlayerCoreService().getMediaResource();
        Integer quality = (mediaResource == null || (playIndex = mediaResource.getPlayIndex()) == null) ? null : Integer.valueOf(playIndex.mQuality);
        PlayerContainerImpl playerContainerImpl8 = this.mPlayerContainer;
        if (playerContainerImpl8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl8 = null;
        }
        boolean isAutoPlay = playerContainerImpl8.getPlayerSettingService().getCloudConfig().shouldAutoPlayWhenEnterDetailPage();
        PlayerContainerImpl playerContainerImpl9 = this.mPlayerContainer;
        if (playerContainerImpl9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl9 = null;
        }
        int playState = playerContainerImpl9.getPlayerCoreService().getState();
        PlayerContainerImpl playerContainerImpl10 = this.mPlayerContainer;
        if (playerContainerImpl10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl10 = null;
        }
        MediaResource mediaResource2 = playerContainerImpl10.getPlayerCoreService().getMediaResource();
        String language = (mediaResource2 == null || (r3 = mediaResource2.getCurrentLanguage()) == null) ? "" : "";
        PlayerContainerImpl playerContainerImpl11 = this.mPlayerContainer;
        if (playerContainerImpl11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl = playerContainerImpl11;
        }
        boolean isDanmakuClosed = playerContainerImpl.getInteractLayerService().getDanmakuParams().isDanmakuClosed();
        reportData.refreshPlayableData(progress, networkType, isDanmakuShow, this.mScreenModeType, playMode, speed, quality, isAutoPlay, playState, isDanmakuClosed, this.mScene, language);
        return reportData;
    }

    private final void resetState() {
        this.mScreenModeType = null;
        this.mSpeed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mScene = PlayScene.DEFAULT;
        this.mIsBuffering = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportTech$default(DataReporterService dataReporterService, String str, Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        if ((i2 & 4) != 0) {
            i = 5;
        }
        dataReporterService.reportTech(str, map, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportTech(String eventId, Map<String, String> map, final int sample) {
        String state;
        String cid;
        Map params = EnhancedUnmodifiabilityKt.unmodifiable(map);
        if (this.mPlayerContainer == null) {
            return;
        }
        HashMap argsMap = new HashMap();
        NormalDataModel normalDataModel = this.mReporterData;
        String str = "";
        argsMap.put("from_spmid", (normalDataModel == null || (r1 = normalDataModel.getFromSpmid()) == null) ? "" : "");
        NormalDataModel normalDataModel2 = this.mReporterData;
        argsMap.put("spmid", (normalDataModel2 == null || (r1 = normalDataModel2.getSpmid()) == null) ? "" : "");
        NormalDataModel normalDataModel3 = this.mReporterData;
        argsMap.put("avid", (normalDataModel3 == null || (r1 = normalDataModel3.getAvid()) == null) ? "" : "");
        NormalDataModel normalDataModel4 = this.mReporterData;
        if (normalDataModel4 != null && (cid = normalDataModel4.getCid()) != null) {
            str = cid;
        }
        argsMap.put(DownloadedPageActivity.KEY_VIDEO_ID, str);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        MediaResource mediaResource = playerContainerImpl.getPlayerCoreService().getMediaResource();
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        if (playerContainerImpl3.getPlayerCoreService().isCorePlayerActive()) {
            state = "no_player";
        } else if (mediaResource == null) {
            state = "no_resource";
        } else if (mediaResource.isPlayable()) {
            state = "unplayable";
        } else {
            PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
            if (playerContainerImpl4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl4 = null;
            }
            String playFailReason = playerContainerImpl4.getPlayerCoreService().getPlayFailReason();
            if (playFailReason == null) {
                playFailReason = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
            }
            argsMap.put("error_msg", playFailReason);
            state = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
        }
        argsMap.put("state", state);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        argsMap.put("current_video_url", IPlayerCoreService.CC.getCurrentPlayUrl$default(playerContainerImpl5.getPlayerCoreService(), false, 1, null));
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl6;
        }
        argsMap.put("current_audio_url", playerContainerImpl2.getPlayerCoreService().getCurrentPlayUrl(true));
        if (params != null) {
            argsMap.putAll(params);
        }
        Neurons.trackT$default(false, eventId, argsMap, 0, new Function0() { // from class: tv.danmaku.biliplayerimpl.report.DataReporterService$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean sample2;
                sample2 = SamplesKt.sample(sample);
                return Boolean.valueOf(sample2);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVideoInfoFromMediaResource(MediaResource resource) {
        VideoFormat.FLV videoFormat;
        PlayIndex playIndex;
        String str = null;
        if (resource == null) {
            videoFormat = null;
        } else {
            videoFormat = resource.getDashResource() != null ? VideoFormat.DASH.INSTANCE : VideoFormat.FLV.INSTANCE;
        }
        if (resource != null && (playIndex = resource.getPlayIndex()) != null) {
            str = playIndex.mFrom;
        }
        boolean isLocalVideo = Intrinsics.areEqual(str, "downloaded");
        NormalDataModel normalDataModel = this.mReporterData;
        if (normalDataModel != null) {
            normalDataModel.updateVideoInfo(videoFormat, Boolean.valueOf(isLocalVideo));
        }
    }

    /* compiled from: DataReporterService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/DataReporterService$Companion;", "", "<init>", "()V", "TAG", "", "KEY_SHARE_REPORTER_SESSION", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}