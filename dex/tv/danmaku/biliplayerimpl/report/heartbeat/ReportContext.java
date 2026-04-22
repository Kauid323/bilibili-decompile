package tv.danmaku.biliplayerimpl.report.heartbeat;

import android.app.Application;
import android.content.Context;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.BiliContext;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.VipUserInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.media.util.NetworkUtil;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportMetaInfo;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.share.SharableObject;

/* compiled from: ReportContext.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\bQ\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001J$\u0010\u0088\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020#J\u0011\u0010\u008b\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u008a\u0001\u001a\u00020#J\u0007\u0010\u008c\u0001\u001a\u00020\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001e\u00107\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\u001e\u0010:\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R \u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR \u0010@\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR \u0010C\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000fR \u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\r\"\u0004\bH\u0010\u000fR \u0010I\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010\u000fR\u001e\u0010L\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR&\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00058\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR\u001e\u0010S\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR\u001e\u0010V\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0007\"\u0004\bX\u0010\tR\u001e\u0010Y\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0007\"\u0004\b[\u0010\tR\u001e\u0010\\\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR\u001e\u0010_\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R\u001e\u0010b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0007\"\u0004\bd\u0010\tR\u001e\u0010e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010\tR \u0010h\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\r\"\u0004\bj\u0010\u000fR \u0010k\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000fR \u0010n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\r\"\u0004\bp\u0010\u000fR \u0010q\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\r\"\u0004\bs\u0010\u000fR \u0010t\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\r\"\u0004\bv\u0010\u000fR\u001e\u0010w\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0007\"\u0004\by\u0010\tR\u001a\u0010z\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0007\"\u0004\b|\u0010\tR+\u0010}\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010~X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u008e\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/ReportContext;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "<init>", "()V", "mStartElapsed", "", "getMStartElapsed", "()J", "setMStartElapsed", "(J)V", "mSession", "", "getMSession", "()Ljava/lang/String;", "setMSession", "(Ljava/lang/String;)V", "mMid", "getMMid", "setMMid", "mAid", "getMAid", "setMAid", "mCid", "getMCid", "setMCid", "mSid", "getMSid", "setMSid", "mEpid", "getMEpid", "setMEpid", "mType", "getMType", "setMType", "mSubType", "", "getMSubType", "()I", "setMSubType", "(I)V", "mQuality", "getMQuality", "setMQuality", "mIsAutoQn", "", "getMIsAutoQn", "()Z", "setMIsAutoQn", "(Z)V", "mVideoDuration", "getMVideoDuration", "setMVideoDuration", "mPlayType", "getMPlayType", "setMPlayType", "mNetworkType", "getMNetworkType", "setMNetworkType", "mJumpFrom", "getMJumpFrom", "setMJumpFrom", "mFromSpmid", "getMFromSpmid", "setMFromSpmid", "mSpmid", "getMSpmid", "setMSpmid", "mEpStatus", "getMEpStatus", "setMEpStatus", "mPlayStatus", "getMPlayStatus", "setMPlayStatus", "mUserStatus", "getMUserStatus", "setMUserStatus", "mLastProcessTime", "getMLastProcessTime", "setMLastProcessTime", "value", "mMaxPlayProgressTime", "getMMaxPlayProgressTime", "setMMaxPlayProgressTime", "mTotalTime", "getMTotalTime", "setMTotalTime", "mPausedTime", "getMPausedTime", "setMPausedTime", "mPlayedTime", "getMPlayedTime", "setMPlayedTime", "mActualPlayedTime", "getMActualPlayedTime", "setMActualPlayedTime", "mAutoPlay", "getMAutoPlay", "setMAutoPlay", "mListPlayTime", "getMListPlayTime", "setMListPlayTime", "mMiniPlayTime", "getMMiniPlayTime", "setMMiniPlayTime", "mPlayMode", "getMPlayMode", "setMPlayMode", "mLanguage", "getMLanguage", "setMLanguage", "mPerferType", "getMPerferType", "setMPerferType", "mTrackId", "getMTrackId", "setMTrackId", "mHash", "getMHash", "setMHash", "mServerTime", "getMServerTime", "setMServerTime", "mLastActionMills", "getMLastActionMills", "setMLastActionMills", "mExtraParams", "", "getMExtraParams", "()Ljava/util/Map;", "setMExtraParams", "(Ljava/util/Map;)V", "getCacheFilePath", "updateCommonParamsFromShare", "", "commonParams", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "refreshMutableState", "qualityId", "currentPosition", "refreshProgress", "copy", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReportContext extends SharableObject {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ReportContext";
    @JSONField(name = "actual_played_time")
    private long mActualPlayedTime;
    @JSONField(name = "aid")
    private long mAid;
    @JSONField(name = "auto_play")
    private int mAutoPlay;
    @JSONField(name = "cid")
    private long mCid;
    @JSONField(name = "epid_status")
    private String mEpStatus;
    @JSONField(name = "epid")
    private long mEpid;
    private Map<String, String> mExtraParams;
    @JSONField(name = "from_spmid")
    private String mFromSpmid;
    @JSONField(name = "hash")
    private String mHash;
    @JSONField(name = "is_auto_qn")
    private boolean mIsAutoQn;
    @JSONField(name = "from")
    private int mJumpFrom;
    @JSONField(name = IjkMediaMeta.IJKM_KEY_LANGUAGE)
    private String mLanguage;
    private transient long mLastActionMills;
    @JSONField(name = "last_play_progress_time")
    private long mLastProcessTime;
    @JSONField(name = "list_play_time")
    private long mListPlayTime;
    @JSONField(name = "max_play_progress_time")
    private long mMaxPlayProgressTime;
    @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
    private long mMid;
    @JSONField(name = "miniplayer_play_time")
    private long mMiniPlayTime;
    @JSONField(name = "network_type")
    private int mNetworkType;
    @JSONField(name = "paused_time")
    private long mPausedTime;
    @JSONField(name = "perfer_type")
    private String mPerferType;
    @JSONField(name = Player.PLAYER_REPORT_KEY_PLAY_MODE)
    private String mPlayMode;
    @JSONField(name = "play_status")
    private String mPlayStatus;
    @JSONField(name = "play_type")
    private String mPlayType;
    @JSONField(name = "played_time")
    private long mPlayedTime;
    @JSONField(name = AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY)
    private int mQuality;
    @JSONField(name = "start_ts")
    private long mServerTime;
    @JSONField(name = "session")
    private String mSession;
    @JSONField(name = "sid")
    private String mSid;
    @JSONField(name = "spmid")
    private String mSpmid;
    private transient long mStartElapsed;
    @JSONField(name = "sub_type")
    private int mSubType;
    @JSONField(name = "total_time")
    private long mTotalTime;
    @JSONField(name = "track_id")
    private String mTrackId;
    @JSONField(name = "type")
    private String mType;
    @JSONField(name = "user_status")
    private String mUserStatus;
    @JSONField(name = "video_duration")
    private long mVideoDuration;

    /* compiled from: ReportContext.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/ReportContext$Companion;", "", "<init>", "()V", "TAG", "", "generate", "Ltv/danmaku/biliplayerimpl/report/heartbeat/ReportContext;", "commonParams", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "session", IjkMediaMeta.IJKM_KEY_LANGUAGE, "perferType", "qualityId", "", "duration", "currentPosition", "isAutoQn", "", "getNetworkType", "context", "Landroid/content/Context;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReportContext generate(ReportMetaInfo commonParams, String session, String language, String perferType, int qualityId, int duration, int currentPosition, boolean isAutoQn) {
            Intrinsics.checkNotNullParameter(commonParams, "commonParams");
            Intrinsics.checkNotNullParameter(session, "session");
            ReportContext reportContext = new ReportContext();
            reportContext.setMServerTime(HeartbeatService.Companion.currentTimeMillis());
            reportContext.setMStartElapsed(HeartbeatService.Companion.currentElapsedMillis());
            reportContext.setMLastActionMills(reportContext.getMStartElapsed());
            reportContext.setMSession(session);
            reportContext.setMHash(UUID.randomUUID().toString());
            Application context = BiliContext.application();
            if (context != null) {
                reportContext.setMMid(BiliAccounts.get(BiliContext.application()).mid());
                reportContext.setMAid(commonParams.getAvid());
                reportContext.setMCid(commonParams.getCid());
                reportContext.setMSid(String.valueOf(commonParams.getSeasonId()));
                Long longOrNull = StringsKt.toLongOrNull(commonParams.getEpId());
                reportContext.setMEpid(longOrNull != null ? longOrNull.longValue() : 0L);
                reportContext.setMType(String.valueOf(commonParams.getType()));
                reportContext.setMAutoPlay(commonParams.getFromAutoPlay());
                reportContext.setMSubType(commonParams.getSubType());
                reportContext.setMQuality(qualityId);
                reportContext.setMIsAutoQn(isAutoQn);
                reportContext.setMVideoDuration(duration / 1000);
                reportContext.setMPlayType(commonParams.getPlayType());
                reportContext.setMNetworkType(ReportContext.Companion.getNetworkType(context));
                reportContext.setMEpStatus(commonParams.getEpStatus());
                reportContext.setMPlayStatus(commonParams.getPlayStatus());
                VipUserInfo vipInfo = BiliAccountInfo.Companion.get().getVipInfo();
                boolean z = false;
                if (vipInfo != null && vipInfo.isEffectiveVip()) {
                    z = true;
                }
                reportContext.setMUserStatus(z ? "1" : "0");
                reportContext.setMLastProcessTime(currentPosition / 1000);
                reportContext.setMMaxPlayProgressTime(currentPosition / 1000);
                Integer intOrNull = StringsKt.toIntOrNull(commonParams.getJumpFrom());
                reportContext.setMJumpFrom(intOrNull != null ? intOrNull.intValue() : 6);
                reportContext.setMFromSpmid(commonParams.getFromSpmid());
                reportContext.setMSpmid(commonParams.getSpmid());
                reportContext.setMPlayMode(commonParams.getPlayMode());
                reportContext.setMLanguage(language);
                reportContext.setMPerferType(perferType);
                reportContext.setMTrackId(commonParams.getTrackId());
                reportContext.setMExtraParams(ReportContextKt.getExtraParams$default(commonParams, null, 1, null));
            }
            return reportContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getNetworkType(Context context) {
            int state = NetworkUtil.getNetworkState(context);
            switch (state) {
                case -1:
                    return 2;
                case 0:
                    if (!FreeDataManager.getInstance().isTf()) {
                        return 1;
                    }
                    return 3;
                case 1:
                    return 1;
                default:
                    return state;
            }
        }
    }

    public final long getMStartElapsed() {
        return this.mStartElapsed;
    }

    public final void setMStartElapsed(long j) {
        this.mStartElapsed = j;
    }

    public final String getMSession() {
        return this.mSession;
    }

    public final void setMSession(String str) {
        this.mSession = str;
    }

    public final long getMMid() {
        return this.mMid;
    }

    public final void setMMid(long j) {
        this.mMid = j;
    }

    public final long getMAid() {
        return this.mAid;
    }

    public final void setMAid(long j) {
        this.mAid = j;
    }

    public final long getMCid() {
        return this.mCid;
    }

    public final void setMCid(long j) {
        this.mCid = j;
    }

    public final String getMSid() {
        return this.mSid;
    }

    public final void setMSid(String str) {
        this.mSid = str;
    }

    public final long getMEpid() {
        return this.mEpid;
    }

    public final void setMEpid(long j) {
        this.mEpid = j;
    }

    public final String getMType() {
        return this.mType;
    }

    public final void setMType(String str) {
        this.mType = str;
    }

    public final int getMSubType() {
        return this.mSubType;
    }

    public final void setMSubType(int i) {
        this.mSubType = i;
    }

    public final int getMQuality() {
        return this.mQuality;
    }

    public final void setMQuality(int i) {
        this.mQuality = i;
    }

    public final boolean getMIsAutoQn() {
        return this.mIsAutoQn;
    }

    public final void setMIsAutoQn(boolean z) {
        this.mIsAutoQn = z;
    }

    public final long getMVideoDuration() {
        return this.mVideoDuration;
    }

    public final void setMVideoDuration(long j) {
        this.mVideoDuration = j;
    }

    public final String getMPlayType() {
        return this.mPlayType;
    }

    public final void setMPlayType(String str) {
        this.mPlayType = str;
    }

    public final int getMNetworkType() {
        return this.mNetworkType;
    }

    public final void setMNetworkType(int i) {
        this.mNetworkType = i;
    }

    public final int getMJumpFrom() {
        return this.mJumpFrom;
    }

    public final void setMJumpFrom(int i) {
        this.mJumpFrom = i;
    }

    public final String getMFromSpmid() {
        return this.mFromSpmid;
    }

    public final void setMFromSpmid(String str) {
        this.mFromSpmid = str;
    }

    public final String getMSpmid() {
        return this.mSpmid;
    }

    public final void setMSpmid(String str) {
        this.mSpmid = str;
    }

    public final String getMEpStatus() {
        return this.mEpStatus;
    }

    public final void setMEpStatus(String str) {
        this.mEpStatus = str;
    }

    public final String getMPlayStatus() {
        return this.mPlayStatus;
    }

    public final void setMPlayStatus(String str) {
        this.mPlayStatus = str;
    }

    public final String getMUserStatus() {
        return this.mUserStatus;
    }

    public final void setMUserStatus(String str) {
        this.mUserStatus = str;
    }

    public final long getMLastProcessTime() {
        return this.mLastProcessTime;
    }

    public final void setMLastProcessTime(long j) {
        this.mLastProcessTime = j;
    }

    public final long getMMaxPlayProgressTime() {
        return this.mMaxPlayProgressTime;
    }

    public final void setMMaxPlayProgressTime(long value) {
        if (value > this.mMaxPlayProgressTime) {
            this.mMaxPlayProgressTime = value;
        }
    }

    public final long getMTotalTime() {
        return this.mTotalTime;
    }

    public final void setMTotalTime(long j) {
        this.mTotalTime = j;
    }

    public final long getMPausedTime() {
        return this.mPausedTime;
    }

    public final void setMPausedTime(long j) {
        this.mPausedTime = j;
    }

    public final long getMPlayedTime() {
        return this.mPlayedTime;
    }

    public final void setMPlayedTime(long j) {
        this.mPlayedTime = j;
    }

    public final long getMActualPlayedTime() {
        return this.mActualPlayedTime;
    }

    public final void setMActualPlayedTime(long j) {
        this.mActualPlayedTime = j;
    }

    public final int getMAutoPlay() {
        return this.mAutoPlay;
    }

    public final void setMAutoPlay(int i) {
        this.mAutoPlay = i;
    }

    public final long getMListPlayTime() {
        return this.mListPlayTime;
    }

    public final void setMListPlayTime(long j) {
        this.mListPlayTime = j;
    }

    public final long getMMiniPlayTime() {
        return this.mMiniPlayTime;
    }

    public final void setMMiniPlayTime(long j) {
        this.mMiniPlayTime = j;
    }

    public final String getMPlayMode() {
        return this.mPlayMode;
    }

    public final void setMPlayMode(String str) {
        this.mPlayMode = str;
    }

    public final String getMLanguage() {
        return this.mLanguage;
    }

    public final void setMLanguage(String str) {
        this.mLanguage = str;
    }

    public final String getMPerferType() {
        return this.mPerferType;
    }

    public final void setMPerferType(String str) {
        this.mPerferType = str;
    }

    public final String getMTrackId() {
        return this.mTrackId;
    }

    public final void setMTrackId(String str) {
        this.mTrackId = str;
    }

    public final String getMHash() {
        return this.mHash;
    }

    public final void setMHash(String str) {
        this.mHash = str;
    }

    public final long getMServerTime() {
        return this.mServerTime;
    }

    public final void setMServerTime(long j) {
        this.mServerTime = j;
    }

    public final long getMLastActionMills() {
        return this.mLastActionMills;
    }

    public final void setMLastActionMills(long j) {
        this.mLastActionMills = j;
    }

    public final Map<String, String> getMExtraParams() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.mExtraParams);
    }

    public final void setMExtraParams(Map<String, String> map) {
        this.mExtraParams = map;
    }

    public final String getCacheFilePath() {
        File file;
        try {
            Application application = BiliContext.application();
            if (application != null && (file = application.getExternalFilesDir(HeartBeatCacheManager.FILE_TYPE)) != null) {
                String path = file.getPath();
                return path + File.separator + this.mHash;
            }
            return null;
        } catch (NullPointerException e) {
            PlayerLog.e(TAG, "Get cache file path failed!");
            return null;
        }
    }

    public final void updateCommonParamsFromShare(ReportMetaInfo commonParams) {
        Intrinsics.checkNotNullParameter(commonParams, "commonParams");
        this.mAid = commonParams.getAvid();
        this.mCid = commonParams.getCid();
        this.mSid = String.valueOf(commonParams.getSeasonId());
        Long longOrNull = StringsKt.toLongOrNull(commonParams.getEpId());
        this.mEpid = longOrNull != null ? longOrNull.longValue() : 0L;
        this.mType = String.valueOf(commonParams.getType());
        this.mAutoPlay = commonParams.getFromAutoPlay();
        this.mSubType = commonParams.getSubType();
        this.mPlayType = commonParams.getPlayType();
        this.mEpStatus = commonParams.getEpStatus();
        this.mPlayStatus = commonParams.getPlayStatus();
        Integer intOrNull = StringsKt.toIntOrNull(commonParams.getJumpFrom());
        this.mJumpFrom = intOrNull != null ? intOrNull.intValue() : 6;
        this.mFromSpmid = commonParams.getFromSpmid();
        this.mSpmid = commonParams.getSpmid();
        this.mPlayMode = commonParams.getPlayMode();
        this.mTrackId = commonParams.getTrackId();
        this.mExtraParams = ReportContextKt.getExtraParams$default(commonParams, null, 1, null);
    }

    public final void refreshMutableState(ReportMetaInfo commonParams, int qualityId, int currentPosition) {
        Intrinsics.checkNotNullParameter(commonParams, "commonParams");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        this.mMid = BiliAccounts.get(BiliContext.application()).mid();
        this.mAutoPlay = commonParams.getFromAutoPlay();
        this.mQuality = qualityId;
        this.mNetworkType = Companion.getNetworkType(context);
        VipUserInfo vipInfo = BiliAccountInfo.Companion.get().getVipInfo();
        boolean z = false;
        if (vipInfo != null && vipInfo.isEffectiveVip()) {
            z = true;
        }
        this.mUserStatus = z ? "1" : "0";
        refreshProgress(currentPosition);
        Integer intOrNull = StringsKt.toIntOrNull(commonParams.getJumpFrom());
        this.mJumpFrom = intOrNull != null ? intOrNull.intValue() : 6;
        this.mFromSpmid = commonParams.getFromSpmid();
        this.mSpmid = commonParams.getSpmid();
        this.mPlayMode = commonParams.getPlayMode();
        this.mTrackId = commonParams.getTrackId();
    }

    public final void refreshProgress(int currentPosition) {
        this.mLastProcessTime = currentPosition / 1000;
        setMMaxPlayProgressTime(currentPosition / 1000);
        this.mTotalTime = HeartbeatService.Companion.currentElapsedMillis() - this.mStartElapsed;
    }

    public final ReportContext copy() {
        ReportContext replica = new ReportContext();
        replica.mStartElapsed = this.mStartElapsed;
        replica.mSession = this.mSession;
        replica.mMid = this.mMid;
        replica.mAid = this.mAid;
        replica.mCid = this.mCid;
        replica.mSid = this.mSid;
        replica.mEpid = this.mEpid;
        replica.mType = this.mType;
        replica.mSubType = this.mSubType;
        replica.mQuality = this.mQuality;
        replica.mIsAutoQn = this.mIsAutoQn;
        replica.mVideoDuration = this.mVideoDuration;
        replica.mPlayType = this.mPlayType;
        replica.mNetworkType = this.mNetworkType;
        replica.mJumpFrom = this.mJumpFrom;
        replica.mFromSpmid = this.mFromSpmid;
        replica.mSpmid = this.mSpmid;
        replica.mEpStatus = this.mEpStatus;
        replica.mPlayStatus = this.mPlayStatus;
        replica.mUserStatus = this.mUserStatus;
        replica.mLastProcessTime = this.mLastProcessTime;
        replica.setMMaxPlayProgressTime(this.mMaxPlayProgressTime);
        replica.mTotalTime = this.mTotalTime;
        replica.mPausedTime = this.mPausedTime;
        replica.mPlayedTime = this.mPlayedTime;
        replica.mActualPlayedTime = this.mActualPlayedTime;
        replica.mAutoPlay = this.mAutoPlay;
        replica.mListPlayTime = this.mListPlayTime;
        replica.mMiniPlayTime = this.mMiniPlayTime;
        replica.mLanguage = this.mLanguage;
        replica.mPerferType = this.mPerferType;
        replica.mLastActionMills = this.mLastActionMills;
        replica.mServerTime = this.mServerTime;
        replica.mHash = this.mHash;
        replica.mPlayMode = this.mPlayMode;
        replica.mTrackId = this.mTrackId;
        replica.mExtraParams = this.mExtraParams;
        return replica;
    }
}