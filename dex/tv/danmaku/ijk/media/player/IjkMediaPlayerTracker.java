package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.WindowManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.utils.IjkMediaPlayerMonitor;
import tv.danmaku.ijk.media.player.utils.IjkUtils;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public class IjkMediaPlayerTracker {
    private static final int BLIJKPlayMode_UNKNOWN = 0;
    private static final int BLIJKPlayMode_VOD = 1;
    public static final int BLIJK_EV_ASSET_CHANGE_BUILD = 2012;
    public static final int BLIJK_EV_ASSET_ITEM_START = 2010;
    public static final int BLIJK_EV_ASSET_ITEM_STOP = 2011;
    public static final int BLIJK_EV_AUDIO_COMPONET_OPEN = 1004;
    public static final int BLIJK_EV_BUFFERING_END = 1023;
    public static final int BLIJK_EV_BUFFERING_START = 1022;
    public static final int BLIJK_EV_DASH_DID_SWITCH_QN = 1015;
    public static final int BLIJK_EV_DASH_WILL_SWITCH_QN = 1014;
    public static final int BLIJK_EV_DECODE_SWITCH = 1024;
    public static final int BLIJK_EV_DID_ACCURATE_SEEK = 1011;
    public static final int BLIJK_EV_DID_FIND_STREAM_INFO = 1003;
    public static final int BLIJK_EV_DID_SEEK = 1021;
    public static final int BLIJK_EV_DID_SHUTDOWN = 1019;
    public static final int BLIJK_EV_DNS_BUILD = 2002;
    public static final int BLIJK_EV_FIRST_AUDIO_DATA = 2005;
    public static final int BLIJK_EV_FIRST_AUDIO_DECODED = 1006;
    public static final int BLIJK_EV_FIRST_AUDIO_PKG = 2006;
    public static final int BLIJK_EV_FIRST_AUDIO_RENDER = 1008;
    public static final int BLIJK_EV_FIRST_VIDEO_DATA = 2007;
    public static final int BLIJK_EV_FIRST_VIDEO_DECODED = 1007;
    public static final int BLIJK_EV_FIRST_VIDEO_PKG = 2008;
    public static final int BLIJK_EV_FIRST_VIDEO_RENDER = 1009;
    public static final int BLIJK_EV_HTTP_BUILD = 2004;
    public static final int BLIJK_EV_HTTP_SEEK_BUILD = 2009;
    public static final int BLIJK_EV_HTTP_WILL_REBUILD = 2001;
    public static final int BLIJK_EV_LIVE_HEARTBEAT = 2016;
    public static final int BLIJK_EV_P2P_STATUS = 2014;
    public static final int BLIJK_EV_REPLACE_ITEM = 1010;
    public static final int BLIJK_EV_ROTATE_QUALITY = 2017;
    public static final int BLIJK_EV_SET_AUTO_SWITCH = 1017;
    public static final int BLIJK_EV_START_PREPARE = 1002;
    public static final int BLIJK_EV_TRANSPORT_BUILD = 2003;
    public static final int BLIJK_EV_VIDEO_COMPONET_OPEN = 1005;
    public static final int BLIJK_EV_VIDEO_SIZE_CHANGE = 1016;
    public static final int BLIJK_EV_WILL_PREPARE = 1001;
    public static final int BLIJK_EV_WILL_SEEK = 1020;
    public static final int BLIJK_EV_WILL_SHUTDOWN = 1018;
    public static final int CHANGE_ASSET_ERROR_BLOCKED = -1;
    public static final int CHANGE_ASSET_ERROR_NO_LISTENER = -2;
    public static final int FFP_PROPV_FILE_TYPE_DASH = 3;
    public static final int FFP_PROPV_FILE_TYPE_FLV = 2;
    public static final int FFP_PROPV_FILE_TYPE_FLV_LIVE = 5;
    public static final int FFP_PROPV_FILE_TYPE_HLS = 4;
    public static final int FFP_PROPV_FILE_TYPE_MP4 = 1;
    public static final int FFP_PROPV_FILE_TYPE_P2P_LIVE = 6;
    private static final long ITEM_OPENING = 1;
    private static final int LIVE_HEARTBEAT_CHANGE_QN_REPORT = 3;
    private static final int LIVE_HEARTBEAT_CYCLE_REPORT = 1;
    private static final int LIVE_HEARTBEAT_STOP_REPORT = 2;
    private static final String TAG = "IjkMediaPlayerTracker";
    private static String[] mFromKeyList;
    public int mAccurateSeekToTargetTime;
    private String mAcodec;
    private String mAssetItemSession;
    private long mAudioDnsTime;
    private String mAudioHost;
    private String mAudioIp;
    private long mAudioMcdnReadBytes;
    private long mAudioNetError;
    private int mAudioPort;
    private long mAudioReadBytes;
    private long mAudioTcpTime;
    private int mChangeAssetReason;
    private long mCid;
    private Context mContext;
    private String mCpuName;
    private int mDashAuto;
    private int mDashCurQn;
    private int mDashTargetQn;
    private long mEnterBackgroundDuration;
    private long mEnterBackgroundStartTime;
    private int mFirstRenderMode;
    private long mFirstVideoDidFindStreamTimestamp;
    private long mFirstVideoDidHttpTimestamp;
    private long mFirstVideoPlayerDecodeTimestamp;
    private long mFirstVideoPlayerRecvPktTimestamp;
    private long mFirstVideoPlayerRenderTimestamp;
    private long mFirstVideoRecvPacketTimestamp;
    private long mFirstVideoWillFindStreamTimestamp;
    private long mFirstVideoWillHttpTimestamp;
    private long mHttpUrlRetryCount;
    private long mIijkProcessThread;
    private int mIjkProcessCpu;
    private long mIjkProcessMem;
    private String mIjkProcessThreadMap;
    private long mLastAudioNetError;
    private long mLastVideoNetError;
    private int mMainProcessCpu;
    private long mMainProcessMem;
    private long mMainProcessThread;
    private String mMainProcessThreadMap;
    private IMediaPlayer.OnTrackerListener mOnTrackerListener;
    private long mP2PCDNDownloadSize;
    private long mP2PDownloadSize;
    private HashMap<String, String> mP2PStreamState;
    private long mP2PTcpDownloadSize;
    private long mPlayStartTimestamp;
    private int mSocketNum;
    private int mSocketReuse;
    private int mStepWaitTime;
    private String mVcodec;
    private String mVdecoder;
    private String mVfps;
    private long mVideoDnsTime;
    private String mVideoHost;
    private String mVideoIp;
    private long mVideoMcdnReadBytes;
    private long mVideoNetError;
    private int mVideoPort;
    private long mVideoReadBytes;
    private long mVideoTcpTime;
    private long mWillAccurateSeekToTime;
    private long mWillPrerollTime;
    private long mWillSeekToTime;
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static String[] mKeySetWhiteList = {MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE, "season_id", "epid", MediaItemParams.IJK_REPORT_KEY_IS_DRM_RESOURCE};
    public static final HashMap<String, String> mP2PKeyMap = new HashMap<>();
    private int mMode = 0;
    private String mFrom = "";
    private String mMediaFeature = "";
    private String mLiveExpInfo = "";
    private int mFocusState = 1;
    private int mDeviceCapability = 0;
    private long mItemOpenStatus = 0;
    private int mSeekDiff = 0;
    private int mFirstRenderStart = 0;
    private long mError = 0;
    private long mJavaError = 0;
    private int mItemPlay = 0;
    private int mFormat = 0;
    private long mAssetItemTimeOfSession = 0;
    private float mPlaybackRate = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private int mBufferingCount = 0;
    private int mFirstAudioTime = 0;
    private int mFirstVideoTime = 0;
    private int mFirstVideoReadyTime = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private float mSar = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private int mAudioBitrate = 0;
    private int mVideoBitrate = 0;
    private long mAudioDuration = 0;
    private long mVideoDuration = 0;
    private boolean mHasVideoStream = true;
    private float mVdropRate = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private IjkMediaPlayer.LiveSwitchQnMode mSwitchQnMode = IjkMediaPlayer.LiveSwitchQnMode.MODE_DEFAULT;
    private int mDecoderSwtichSoftFrames = 0;
    private int mAvUnsyncCount = 0;
    private String mAudioUrl = "";
    private String mCleanAudioUrl = "";
    private String mVideoUrl = "";
    private String mCleanVideoUrl = "";
    private String mStreamType = "";
    private String mMuxer = "";
    private boolean mIsLive = false;
    private String mVideoTraceidInfo = "";
    private String mAudioTraceidInfo = "";
    private long mAudioConsumeBytes = 0;
    private long mVideoConsumeBytes = 0;
    private int mVideoHttpCode = 0;
    private int mAudioHttpCode = 0;
    private String mLiveP2pInfo = "";
    private int mVideoId = -1;
    private int mAudioId = -1;
    private int mChangeAssetError = 0;
    private int mIsPlayComplete = 0;
    private int mAssetUpdateCount = 0;
    private long mAssetUpdateTime = 0;
    private int mUrlInfo = 0;
    private String mBackupUrlInfo = "";
    private float mCurQoe = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private long mMediacodecOpenTime = 0;
    private long mIjkserviceInitTime = 0;
    private long mHttpByFFmpeg = 0;
    private long mPlayerSessionCreateTime = 0;
    private long mAssetSessionCreateTime = 0;
    private long mAssetItemSessionCreateTime = 0;
    private boolean mSeekStarted = false;
    private long mCurrentQnStartTime = 0;
    private int mAudioChangeCount = 0;
    private int mVideoChangeCount = 0;
    private int mFormatChangeCount = 0;
    private int mCodecChangeCount = 0;
    private int mQnChangeCount = 0;
    private int mPauseCount = 0;
    private long mLastPauseTimestamp = 0;
    private int mSetAudioOnlyCount = 0;
    private boolean mHasAnr = false;
    private boolean mHasIjkProcessError = false;
    private boolean mPlayerGetFirstPkt = false;
    private long mNativeErrorCode = 0;
    private long mSeekFirstPkgTime = 0;
    private long mSeekBufferingAccTime = 0;
    private int mNetFamily = 0;
    private int mBitrateSwitchCount = 0;
    private int mMaxQn = 0;
    private int mMinQn = 999;
    private long mDuration360p = 0;
    private long mDuration480p = 0;
    private long mDuration720p = 0;
    private long mDuration1080p = 0;
    private long mDurationOthers = 0;
    private long mSwitchDuration = 0;
    private long mSwitchDurationCount = 0;
    private long mBufferingDurationCount = 0;
    private int mSwitchLowerBitrateCount = 0;
    private int mSwitchHigherBitrateCount = 0;
    private String mTrackerServerHost = "";
    private String mThroughputSpeed = "";
    private String mSeekRecord = "";
    private String mBufferingRecord = "";
    private String mResolutionRecord = "";
    private String mPlayRecord = "";
    private long mNetworkWave = -10000;
    private long mAveNetworkSpeed = 0;
    private String mItemMinSpeedRecord = "";
    private String mIjkVersion = "";
    private int mSeekCount = 0;
    private int mSwitchNonAutoTargetQn = 0;
    private long mCurCacheTime = 0;
    private long mCurPlayableCacheTime = 0;
    private long mCacheWaveRange = 0;
    private int mStoryMode = 0;
    private int mStartNetwork = 0;
    private int mStartBatteryLevel = 0;
    private int mEndBatteryLevel = 0;
    private int mNetworkChangeCount = 0;
    private int mStreamResetReason = 0;
    private int mSkipFrameCount = 0;
    private long mHlsMaxUpdateDuration = 0;
    private int mHlsStartSeqCount = 0;
    private int mExpectLatency = 0;
    private int mEnableSkipFrame = 1;
    private int mEnableJitterBuffer = 1;
    private int mIsAbleLowLatency = 1;
    private long mRenderingStuckCount = 0;
    private long mRenderingStuckDuration = 0;
    private long mRenderingStuckReason = 0;
    private long mActualPlaybackDuration = 0;
    private int mNetworkLevel = -1;
    private int mAliveItemNum = 0;
    private int mAlivePlayerNum = 0;
    private int mAudioTpError = 0;
    private int mForceReport = 0;
    private HashMap<String, String> mExtraMapInfo = new HashMap<>();
    private String mSwitchOnInfo = "";
    private int mRecordSwitchTimes = 0;
    private int mItemMaxQn = 0;
    private int mRecommendedMaxQn = 0;
    private int mAutoMaxQn = 0;
    private int mUserQn = 0;
    private int mScreenState = -1;
    private IjkMediaScreenInfo mScreenInfoTracker = new IjkMediaScreenInfo();
    private float mDeviceScore = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private boolean mIsBackground = false;
    private int mIsMiniScreenSwitchOn = 0;
    private int mIsBackgroundMusicOn = 0;
    private int mEnterBackgroundCount = 0;
    private float mMaxSpeed = 1.0f;
    private String mAv1CodecName = "";
    private String mDefaultCodecName = "";
    private int mIsSupport4k = 0;
    private long mLastEventTimestamp = 0;
    private float mLastBufferingStartQoe = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private long[] mBufferingEndTimestamp = new long[10];
    int mP2PBufferingCount = 0;
    long mP2PAssetItemTimeOfSession = 0;
    private HashMap<String, Integer> mP2PIntDotMapValue = new HashMap<>();
    private HashMap<String, Long> mP2PLongDotMapValue = new HashMap<>();
    private int mSupportWidevineType = 0;
    private int mDrmType = 0;
    private long mAnalysisUserPropose = 0;
    private long mAnalysisInternalPropose = 0;
    private Timer mSSTimer = null;
    private int mEnhanceType = -1;
    private LiveHeartbeat mLiveHeartbeat = null;

    static {
        mP2PKeyMap.put("f135", "p2p_connect_count");
        mP2PKeyMap.put("f136", "p2p_connect_success_count");
        mP2PKeyMap.put("f137", "p2p_subscribe_count");
        mP2PKeyMap.put("f138", "p2p_subscribe_success_count");
        mP2PKeyMap.put("f139", "p2p_subscribe_and_download_complete_count");
        mP2PKeyMap.put("f142", "p2p_download_size");
        mP2PKeyMap.put("f143", "p2p_upload_bandwidth");
        mP2PKeyMap.put("f144", "p2p_uploaded_bytes");
        mP2PKeyMap.put("f145", "nat_type");
        mP2PKeyMap.put("f146", "p2p_task_count");
        mP2PKeyMap.put("f147", "p2p_download_complete_task_count");
        mP2PKeyMap.put("f150", "p2p_nat_type_connect_count");
        mP2PKeyMap.put("f151", "p2p_nat_type_connect_success_count");
        mP2PKeyMap.put("f152", "p2p_download_repeat_size");
        mP2PKeyMap.put("f154", "p2p_stun_local_count");
        mP2PKeyMap.put("f155", "p2p_upnp_router_count");
        mP2PKeyMap.put("f156", "p2p_stun_reflex_count");
        mP2PKeyMap.put("f157", "p2p_total_uploaded_bytes");
        mP2PKeyMap.put("f158", "p2p_hot_push_uploaded_bytes");
        mP2PKeyMap.put("f164", "p2p_cdn_download_bytes");
        mP2PKeyMap.put("f168", "p2p_stun_extra_reflex_count");
        mP2PKeyMap.put("f176", "p2p_cur_storage_cap");
        mP2PKeyMap.put("f178", "p2p_total_uploaded_arq_ack_bytes");
        mP2PKeyMap.put("f182", "p2p_max_connection_count");
        mP2PKeyMap.put("f183", "p2p_max_upload_count");
        mP2PKeyMap.put("f184", "p2p_max_connecting_count");
        mP2PKeyMap.put("f201", "p2p_download_block_count");
        mP2PKeyMap.put("f202", "p2p_download_switch_count");
        mP2PKeyMap.put("f216", "p2p_audio_download_bytes");
        mP2PKeyMap.put("f217", "p2p_cdn_download_count");
        mP2PKeyMap.put("f220", "p2p_onrequest_count");
        mP2PKeyMap.put("f225", "peer_nodes_is_enough");
        mP2PKeyMap.put("f226", "p2p_peer_srtt");
        mP2PKeyMap.put("f230", "p2p_nat_detect_init_count");
        mP2PKeyMap.put("f238", "p2p_reflex_ip");
        mP2PKeyMap.put("f239", "p2p_reflex_port");
        mP2PKeyMap.put("f254", "p2p_video_normal_peer_infos");
        mP2PKeyMap.put("f255", "p2p_video_abnormal_peer_infos");
        mP2PKeyMap.put("f256", "p2p_audio_normal_peer_infos");
        mP2PKeyMap.put("f257", "p2p_audio_abnormal_peer_infos");
        mP2PKeyMap.put("f261", "p2p_live_overload_tasks_count");
        mP2PKeyMap.put("f262", "p2p_task_count");
        mP2PKeyMap.put("f263", "p2p_live_overload_connection_count");
        mP2PKeyMap.put("f264", "p2p_timeout_task_connection_count");
        mP2PKeyMap.put("f265", "p2p_player_cache");
        mP2PKeyMap.put("f266", "p2p_progress");
        mP2PKeyMap.put("f283", "p2p_current_peers_count");
        mP2PKeyMap.put("f284", "p2p_upload_overload");
        mP2PKeyMap.put("f286", "p2p_hot_push_connect_count");
        mP2PKeyMap.put("f288", "p2p_http_video_total_time");
        mP2PKeyMap.put("f289", "p2p_http_video_dns_time");
        mP2PKeyMap.put("f290", "p2p_http_video_connect_time");
        mP2PKeyMap.put("f291", "p2p_http_video_first_packet_time");
        mP2PKeyMap.put("f292", "p2p_http_video_open_retry_count");
        mP2PKeyMap.put("f293", "p2p_http_video_net_error");
        mP2PKeyMap.put("f294", "p2p_http_video_total_retry_count");
        mP2PKeyMap.put("f295", "p2p_http_video_open_succ_start_time");
        mP2PKeyMap.put("f296", "p2p_http_audio_total_time");
        mP2PKeyMap.put("f297", "p2p_http_audio_dns_time");
        mP2PKeyMap.put("f298", "p2p_http_audio_connect_time");
        mP2PKeyMap.put("f299", "p2p_http_audio_first_packet_time");
        mP2PKeyMap.put("f300", "p2p_http_audio_open_retry_count");
        mP2PKeyMap.put("f301", "p2p_http_audio_net_error");
        mP2PKeyMap.put("f302", "p2p_http_audio_total_retry_count");
        mP2PKeyMap.put("f303", "p2p_http_audio_open_succ_start_time");
        mP2PKeyMap.put("f304", "p2p_friendconnection_count");
        mP2PKeyMap.put("f307", "p2p_cdn_download_fail_count");
        mP2PKeyMap.put("f314", "p2p_cdn_redundant_bytes");
        mP2PKeyMap.put("f312", "p2p_nat_type_connect_count_add");
        mP2PKeyMap.put("f313", "p2p_nat_type_connect_success_count_add");
        mP2PKeyMap.put("f324", "p2p_tcp_download_size");
        mP2PKeyMap.put("f336", "p2p_grpc_tracker_error_count");
        mP2PKeyMap.put("f371", "fail_crc_check_count");
        mP2PKeyMap.put("f372", "video_fail_crc_check_devices");
        mP2PKeyMap.put("f373", "audio_fail_crc_check_devices");
        mP2PKeyMap.put("f378", "p2p_video_seek_count");
        mP2PKeyMap.put("f379", "p2p_audio_current_peer_count");
        mP2PKeyMap.put("f380", "p2p_audio_connect_count");
        mP2PKeyMap.put("f381", "p2p_audio_connect_success_count");
        mP2PKeyMap.put("f382", "p2p_current_udp_fd_count");
        mP2PKeyMap.put("f388", "p2p_get_peer_count");
        mP2PKeyMap.put("f389", "p2p_get_peer_last_timecost");
        mP2PKeyMap.put("f394", "http_server_request_url");
        mP2PKeyMap.put("f395", "http_server_p2p_download_size");
        mP2PKeyMap.put("f396", "http_server_cdn_download_size");
        mP2PKeyMap.put("f397", "http_server_download_switch_count");
        mP2PKeyMap.put("f398", "http_server_download_block_count");
        mP2PKeyMap.put("f399", "http_server_download_count");
        mP2PKeyMap.put("f400", "http_server_download_fail_count");
        mP2PKeyMap.put("f413", "p2p_dns_cache_count");
        mP2PKeyMap.put("f414", "p2p_dns_local_and_http_count");
        mP2PKeyMap.put("f415", "p2p_dns_http_first_count");
        mP2PKeyMap.put("f416", "p2p_dns_local_first_count");
        mP2PKeyMap.put("f419", "p2p_dns_http_query_v6_count");
        mP2PKeyMap.put("f420", "p2p_total_storage_cap");
        mP2PKeyMap.put("f424", "p2p_thread_freeze_time_ms");
        mP2PKeyMap.put("f425", "p2p_item_priority");
        mP2PKeyMap.put("f426", "p2p_buffering_network_history");
        mP2PKeyMap.put("f428", "p2p_max_cdn_p2p_download_speed_kbps");
        mP2PKeyMap.put("f432", "upload_file_info0");
        mP2PKeyMap.put("f433", "upload_file_info1");
        mP2PKeyMap.put("f434", "upload_file_info2");
        mP2PKeyMap.put("f435", "upload_file_info3");
        mP2PKeyMap.put("f441", "p2p_video_check_cache_count");
        mP2PKeyMap.put("f442", "p2p_audio_check_cache_count");
        mP2PKeyMap.put("f446", "p2p_udp_network_quality_level");
        mP2PKeyMap.put("f447", "p2p_udp_loss_rate_avg_permillage");
        mP2PKeyMap.put("f448", "p2p_udp_loss_rate_sd_permillage");
        mP2PKeyMap.put("f449", "p2p_udp_rtt_avg");
        mP2PKeyMap.put("f450", "p2p_udp_rtt_sd");
        mP2PKeyMap.put("f454", "p2p_tridinfo_video");
        mP2PKeyMap.put("f455", "p2p_tridinfo_audio");
        mP2PKeyMap.put("f459", "p2p_kcp_update_subsegment_count");
        mP2PKeyMap.put("f469", "p2p_fec_recvd_count");
        mP2PKeyMap.put("f471", "p2p_bilidns_request_total_count");
        mP2PKeyMap.put("f472", "p2p_bilidns_request_success_count");
        mP2PKeyMap.put("f473", "p2p_ailidns_request_total_count");
        mP2PKeyMap.put("f477", "p2p_total_recved_bytes");
        mP2PKeyMap.put("f478", "p2p_total_recved_arq_ack_bytes");
        mP2PKeyMap.put("f479", "p2p_ipv6_ip");
        mP2PKeyMap.put("f480", "p2p_host_info_video");
        mP2PKeyMap.put("f481", "p2p_host_info_audio");
        mP2PKeyMap.put("f482", "p2p_stun_ipv6_count");
        mP2PKeyMap.put("f483", "p2p_ipv6_downloaded_bytes");
        mP2PKeyMap.put("f485", "p2p_buffering_sence");
        mP2PKeyMap.put("f486", "p2p_buffering_udp_avg_rtt");
        mP2PKeyMap.put("f487", "p2p_buffering_start_time");
        mP2PKeyMap.put("f488", "p2p_buffering_end_time");
        mP2PKeyMap.put("f489", "p2p_item_sence_history");
        mP2PKeyMap.put("f490", "p2p_cdn_download_bytes_preload");
        mP2PKeyMap.put("f491", "p2p_cdn_download_bytes_start_playback");
        mP2PKeyMap.put("f492", "p2p_cdn_download_bytes_quality_switch");
        mP2PKeyMap.put("f493", "p2p_cdn_download_bytes_seek");
        mP2PKeyMap.put("f494", "p2p_cdn_download_bytes_playback");
        mP2PKeyMap.put("f495", "p2p_cdn_download_bytes_net_switch");
        mP2PKeyMap.put("f496", "p2p_buffering_total_time");
        mP2PKeyMap.put("f502", "p2p_filesize_not_match");
        mP2PKeyMap.put("f503", "p2p_item_first_open_count");
        mP2PKeyMap.put("f504", "p2p_item_first_open_info");
        mP2PKeyMap.put("f516", "p2p_network_rtt_churns_count");
        mP2PKeyMap.put("f518", "p2p_main_thread_lifetime");
        mP2PKeyMap.put("f519", "p2p_current_net_lifetime");
        mP2PKeyMap.put("f520", "p2p_speed_avg_before_churns");
        mP2PKeyMap.put("f521", "p2p_speed_sd_before_churns");
        mP2PKeyMap.put("f526", "p2p_http_video_host_info");
        mP2PKeyMap.put("f529", "p2p_http_redirect_count");
        mP2PKeyMap.put("f533", "p2p_http_video_download_given_gap_time_cost");
        mFromKeyList = new String[]{MediaItemParams.IJK_REPORT_KEY_MEDIA_SOURCE, "spmid", MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, "from_spmid", MediaItemParams.IJK_REPORT_KEY_FLASH, MediaItemParams.IJK_REPORT_KEY_LIVE_SCENE, MediaItemParams.IJK_REPORT_KEY_LIVE_MODE};
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class UrlChangeInfo {
        int codecChangeCount;
        int formatChangeCount;
        int isAudio;
        int qnChangeCount;
        int urlChangeCount;

        public UrlChangeInfo(int isAudio, int urlChangeCount, int formatChangeCount, int codecChangeCount, int qnChangeCount) {
            this.isAudio = isAudio;
            this.urlChangeCount = urlChangeCount;
            this.formatChangeCount = formatChangeCount;
            this.codecChangeCount = codecChangeCount;
            this.qnChangeCount = qnChangeCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class LiveHeartbeat {
        public static final String mSeiPrefix = "BVCLIVESTREAMHOP";
        public String mAppVersion;
        public int mBufferingCount;
        public long mBufferingDuration;
        public String mGuid;
        public int mInterval;
        public long mLastTs;
        public int mLiveEnterBackgroundCount;
        public long mLiveEnterBackgroundDuration;
        public long mPlayDuration;
        public int mPlaybackState;
        public String mSeiData;
        public Timer mTimer;

        private LiveHeartbeat() {
            this.mTimer = null;
            this.mInterval = 60000;
            this.mLastTs = 0L;
            this.mPlayDuration = 0L;
            this.mBufferingCount = 0;
            this.mBufferingDuration = 0L;
            this.mLiveEnterBackgroundCount = 0;
            this.mLiveEnterBackgroundDuration = 0L;
            this.mAppVersion = "";
            this.mGuid = "";
            this.mPlaybackState = 0;
            this.mSeiData = "";
        }

        public void startTimer() {
            if (this.mTimer != null) {
                return;
            }
            this.mTimer = new Timer("IjkLiveHeartBeat");
            this.mTimer.schedule(new TimerTask() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayerTracker.LiveHeartbeat.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    LiveHeartbeat.this.reportLiveHeartbeat(1, SystemClock.elapsedRealtime());
                }
            }, this.mInterval, this.mInterval);
        }

        public void cancelTimer(long currentTs, int reportMode) {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
                IjkMediaPlayerTracker.this.mLiveHeartbeat.reportLiveHeartbeat(reportMode, currentTs);
                if (reportMode == 2) {
                    resetParams();
                } else {
                    startTimer();
                }
            }
        }

        public void resetParams() {
            this.mLastTs = 0L;
            this.mPlayDuration = 0L;
            this.mBufferingCount = 0;
            this.mBufferingDuration = 0L;
            this.mLiveEnterBackgroundCount = 0;
            this.mLiveEnterBackgroundDuration = 0L;
            this.mPlaybackState = 0;
            this.mSeiData = "";
        }

        private long getLiveHeartbeatDuration(long currentTs) {
            if (this.mLastTs == 0) {
                this.mLastTs = IjkMediaPlayerTracker.this.mAssetItemSessionCreateTime;
            }
            this.mPlayDuration = currentTs - this.mLastTs;
            this.mLastTs = currentTs;
            return this.mPlayDuration;
        }

        public void updateBufferingInfo(long currentTs) {
            if (IjkMediaPlayerTracker.this.mWillPrerollTime < this.mLastTs) {
                this.mBufferingDuration += currentTs - this.mLastTs;
                this.mBufferingCount++;
                return;
            }
            this.mBufferingDuration += currentTs - IjkMediaPlayerTracker.this.mWillPrerollTime;
        }

        private void setBufferingInfo(HashMap<String, String> simplyExtensions, long currentTs) {
            if (IjkMediaPlayerTracker.this.mWillPrerollTime > 0) {
                long addDuration = currentTs - IjkMediaPlayerTracker.this.mWillPrerollTime;
                this.mBufferingDuration += Math.max(addDuration, 0L);
                this.mBufferingDuration = Math.min(this.mBufferingDuration, this.mPlayDuration);
                if (this.mBufferingCount == 0) {
                    this.mBufferingCount = 1;
                }
            }
            simplyExtensions.put("buffering_count", String.valueOf(this.mBufferingCount));
            simplyExtensions.put("buffering_time", String.valueOf(this.mBufferingDuration));
            this.mBufferingCount = 0;
            this.mBufferingDuration = 0L;
        }

        public void updateBackgroundInfo(long currentTs) {
            if (IjkMediaPlayerTracker.this.mEnterBackgroundStartTime < this.mLastTs) {
                this.mLiveEnterBackgroundDuration += currentTs - this.mLastTs;
                this.mLiveEnterBackgroundCount++;
                return;
            }
            this.mLiveEnterBackgroundDuration += currentTs - IjkMediaPlayerTracker.this.mEnterBackgroundStartTime;
        }

        private void setBackgroundInfo(HashMap<String, String> simplyExtensions, long currentTs) {
            if (IjkMediaPlayerTracker.this.mEnterBackgroundStartTime > 0) {
                long addDuration = currentTs - IjkMediaPlayerTracker.this.mEnterBackgroundStartTime;
                this.mLiveEnterBackgroundDuration += Math.max(addDuration, 0L);
                this.mLiveEnterBackgroundDuration = Math.min(this.mLiveEnterBackgroundDuration, this.mPlayDuration);
                if (this.mLiveEnterBackgroundCount == 0) {
                    this.mLiveEnterBackgroundCount = 1;
                }
            }
            simplyExtensions.put("enter_background_count", String.valueOf(this.mLiveEnterBackgroundCount));
            simplyExtensions.put("enter_background_duration", String.valueOf(this.mLiveEnterBackgroundDuration));
            this.mLiveEnterBackgroundCount = 0;
            this.mLiveEnterBackgroundDuration = 0L;
        }

        private void setStopInfo(HashMap<String, String> simplyExtensions) {
            simplyExtensions.put("stop_step_wait_time", String.valueOf(IjkMediaPlayerTracker.this.mStepWaitTime));
            simplyExtensions.put("stop_buffering_count", String.valueOf(IjkMediaPlayerTracker.this.mBufferingCount));
            simplyExtensions.put("stop_buffering_time", String.valueOf(IjkMediaPlayerTracker.this.mBufferingDurationCount));
            simplyExtensions.put("stop_playable_cache_time", String.valueOf(IjkMediaPlayerTracker.this.mCurPlayableCacheTime));
            simplyExtensions.put("stop_asset_time_of_session", String.valueOf(IjkMediaPlayerTracker.this.mAssetItemTimeOfSession));
            simplyExtensions.put("stop_cur_vid", String.valueOf(IjkMediaPlayerTracker.this.mDashCurQn));
            simplyExtensions.put("stop_error_code", String.valueOf(IjkMediaPlayerTracker.this.mError));
        }

        private String getCompleteSei() {
            String result = "";
            String originSei = this.mSeiData;
            String url = IjkMediaPlayerTracker.this.mVideoUrl;
            if (TextUtils.isEmpty(originSei)) {
                return "";
            }
            try {
                int startIndex = originSei.lastIndexOf("{");
                int lastIndex = originSei.lastIndexOf("]");
                result = originSei.substring(0, startIndex);
                String jsonStr = originSei.substring(startIndex, lastIndex);
                JSONObject jsonObj = new JSONObject(jsonStr);
                jsonObj.put("author", "android");
                jsonObj.put("author_ver", this.mAppVersion);
                if (url.contains("127.0.0.1:")) {
                    jsonObj.put("protocol", "p2p");
                    jsonObj.put("muxer", "fmp4");
                } else if (url.contains("index.m3u8")) {
                    jsonObj.put("protocol", "http");
                    jsonObj.put("muxer", "fmp4");
                } else if (url.contains(".flv")) {
                    jsonObj.put("protocol", "http");
                    jsonObj.put("muxer", "flv");
                }
                return result + jsonObj.toString() + "]";
            } catch (Exception e) {
                return result;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reportLiveHeartbeat(int reportMode, long currentTs) {
            if (IjkMediaPlayerTracker.this.mAssetItemSessionCreateTime == 0 || IjkMediaPlayerTracker.this.mAssetItemSession == null) {
                return;
            }
            String simplyEventId = IjkMediaPlayerTracker.this.getSimplyEventId(IjkMediaPlayerTracker.BLIJK_EV_LIVE_HEARTBEAT);
            HashMap<String, String> simplyExtensions = new HashMap<>();
            simplyExtensions.put("report_mode", String.valueOf(reportMode));
            simplyExtensions.put("room_id", String.valueOf(IjkMediaPlayerTracker.this.mCid));
            simplyExtensions.put("guid", this.mGuid);
            simplyExtensions.put("asset_session", IjkMediaPlayerTracker.this.mAssetItemSession);
            int renderFirstVideoTime = IjkMediaPlayerTracker.this.mHasVideoStream ? IjkMediaPlayerTracker.this.mFirstVideoTime : IjkMediaPlayerTracker.this.mFirstAudioTime;
            simplyExtensions.put("render_first_video_time", String.valueOf(renderFirstVideoTime));
            if (this.mLastTs == 0) {
                simplyExtensions.put("network_first_frame_time", String.valueOf(IjkMediaPlayerTracker.this.mFirstVideoRecvPacketTimestamp - IjkMediaPlayerTracker.this.mFirstVideoWillHttpTimestamp));
            }
            simplyExtensions.put("play_duration", String.valueOf(getLiveHeartbeatDuration(currentTs)));
            simplyExtensions.put("screen_state", String.valueOf(IjkMediaPlayerTracker.this.mScreenState));
            simplyExtensions.put("from", String.valueOf(IjkMediaPlayerTracker.this.mFrom));
            simplyExtensions.put("live_exp_info", String.valueOf(IjkMediaPlayerTracker.this.mLiveExpInfo));
            simplyExtensions.put("media_feature", String.valueOf(IjkMediaPlayerTracker.this.mMediaFeature));
            simplyExtensions.put("item_play", String.valueOf(IjkMediaPlayerTracker.this.mItemPlay));
            simplyExtensions.put("video_host", String.valueOf(IjkMediaPlayerTracker.this.mVideoHost));
            simplyExtensions.put("video_ip", String.valueOf(IjkMediaPlayerTracker.this.mVideoIp));
            simplyExtensions.put("live_p2p_info", String.valueOf(IjkMediaPlayerTracker.this.mLiveP2pInfo));
            simplyExtensions.put("video_url", String.valueOf(IjkMediaPlayerTracker.this.mVideoUrl));
            setBufferingInfo(simplyExtensions, currentTs);
            setBackgroundInfo(simplyExtensions, currentTs);
            simplyExtensions.put("sei_latency", getCompleteSei());
            simplyExtensions.put("error_code", String.valueOf(IjkMediaPlayerTracker.this.mVideoNetError));
            simplyExtensions.put("playback_state", String.valueOf(this.mPlaybackState));
            simplyExtensions.put(Player.PLAYER_REPORT_KEY_PLAY_MODE, String.valueOf(IjkMediaPlayerTracker.this.mMode));
            if (reportMode == 2) {
                setStopInfo(simplyExtensions);
            } else if (reportMode == 3) {
                simplyExtensions.put("stop_cur_vid", String.valueOf(IjkMediaPlayerTracker.this.mDashCurQn));
                simplyExtensions.put("switch_qn_mode", String.valueOf(IjkMediaPlayerTracker.this.mSwitchQnMode.ordinal()));
            }
            IjkMediaPlayerTracker.this.trackerReport(true, simplyEventId, simplyExtensions);
        }
    }

    public IjkMediaPlayerTracker(IMediaPlayer.OnTrackerListener onTrackerListener, Context context) {
        this.mOnTrackerListener = null;
        this.mOnTrackerListener = onTrackerListener;
        this.mContext = context;
    }

    private String constructFromString(HashMap<String, String> extraMapInfo) {
        String[] strArr;
        String from = "";
        for (String key : mFromKeyList) {
            String value = extraMapInfo.get(key);
            if (value != null) {
                String addString = key + "=" + value;
                if (TextUtils.isEmpty(from)) {
                    from = from + addString;
                } else {
                    from = from + "," + addString;
                }
            }
        }
        return from;
    }

    public void initTracker(int mode, long cid, HashMap<String, String> extraMapInfo) {
        String[] strArr;
        this.mMode = mode;
        this.mCid = cid;
        this.mCpuName = IjkMediaPlayerMonitor.getInstance().getCpuName();
        if (extraMapInfo != null) {
            String forceReport = extraMapInfo.get(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT);
            if (forceReport != null) {
                this.mForceReport = Integer.parseInt(forceReport);
            }
            for (String key : mKeySetWhiteList) {
                String value = extraMapInfo.get(key);
                if (value != null) {
                    this.mExtraMapInfo.put(key, value);
                }
            }
            this.mFrom = constructFromString(extraMapInfo);
        }
    }

    public void setMediaFeature(String mediaFeature) {
        this.mMediaFeature = mediaFeature;
    }

    public void setLiveExperimentalInfo(String expInfo) {
        this.mLiveExpInfo = expInfo;
    }

    public void setFocusState(int focusState) {
        this.mFocusState = focusState;
    }

    public void initLiveHeartbeat(IjkMediaPlayerItem item, int interval, String appVersion) {
        if (item.isLive()) {
            if (this.mLiveHeartbeat == null) {
                this.mLiveHeartbeat = new LiveHeartbeat();
            }
            if (interval <= 0) {
                interval = 60000;
            }
            this.mLiveHeartbeat.mInterval = interval;
            this.mLiveHeartbeat.mAppVersion = appVersion;
        }
    }

    public void setSeiData(byte[] data) {
        if (this.mLiveHeartbeat != null) {
            String sei = new String(data);
            if (sei.startsWith(LiveHeartbeat.mSeiPrefix)) {
                this.mLiveHeartbeat.mSeiData = sei;
            }
        }
    }

    public void setGuid(String guid) {
        if (this.mLiveHeartbeat != null && guid != null) {
            this.mLiveHeartbeat.mGuid = guid;
        }
    }

    public static String signMD5(String source) {
        return signMD5(source.getBytes());
    }

    public static String signMD5(byte[] source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return signDigest(source, digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String signSHA1(String source) {
        return signSHA1(source.getBytes());
    }

    public static String signSHA1(byte[] source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            return signDigest(source, digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String signDigest(byte[] source, MessageDigest digest) {
        digest.update(source);
        byte[] data = digest.digest();
        int j = data.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (byte byte0 : data) {
            int k2 = k + 1;
            str[k] = HEX_DIGITS[(byte0 >>> 4) & 15];
            k = k2 + 1;
            str[k2] = HEX_DIGITS[byte0 & 15];
        }
        return new String(str).toLowerCase();
    }

    private int getDashCurQn(Bundle extra, IjkMediaPlayer player) {
        this.mDashCurQn = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_VIDEO_ID);
        IjkMediaPlayerItem curItem = player.getIjkMediaPlayerItem();
        if (curItem != null && ((int) curItem.getFormat()) != 3) {
            this.mDashCurQn = curItem.getCurQn();
        }
        return this.mDashCurQn;
    }

    private void FillHttpInfoExtensions(HashMap<String, String> simplyExtensions) {
        simplyExtensions.put("audio_url", String.valueOf(this.mAudioUrl));
        simplyExtensions.put("audio_net_error", String.valueOf(this.mAudioNetError));
        simplyExtensions.put("audio_http_code", String.valueOf(this.mAudioHttpCode));
        simplyExtensions.put("audio_ip", String.valueOf(this.mAudioIp));
        simplyExtensions.put("audio_host", String.valueOf(this.mAudioHost));
        simplyExtensions.put("audio_port", String.valueOf(this.mAudioPort));
        simplyExtensions.put("audio_dns_time", String.valueOf(this.mAudioDnsTime));
        simplyExtensions.put("audio_tcp_time", String.valueOf(this.mAudioTcpTime));
        simplyExtensions.put("video_url", String.valueOf(this.mVideoUrl));
        simplyExtensions.put("video_net_error", String.valueOf(this.mVideoNetError));
        simplyExtensions.put("video_http_code", String.valueOf(this.mVideoHttpCode));
        simplyExtensions.put("video_ip", String.valueOf(this.mVideoIp));
        simplyExtensions.put("video_host", String.valueOf(this.mVideoHost));
        simplyExtensions.put("video_port", String.valueOf(this.mVideoPort));
        simplyExtensions.put("video_dns_time", String.valueOf(this.mVideoDnsTime));
        simplyExtensions.put("video_tcp_time", String.valueOf(this.mVideoTcpTime));
        simplyExtensions.put("live_p2p_info", String.valueOf(this.mLiveP2pInfo));
    }

    private HashMap<String, String> getSimplyExtensions(int isAudio, int event) {
        String eventString = getSimplyEventId(event);
        if (TextUtils.isEmpty(eventString)) {
            return null;
        }
        HashMap<String, String> SimplyExtensionMap = new HashMap<>();
        SimplyExtensionMap.put("cid", String.valueOf(this.mCid));
        SimplyExtensionMap.put("mode", String.valueOf(this.mMode));
        SimplyExtensionMap.put("from", String.valueOf(this.mFrom));
        SimplyExtensionMap.put("error", String.valueOf(this.mError));
        SimplyExtensionMap.put("item_play", String.valueOf(this.mItemPlay));
        SimplyExtensionMap.put("iformat", String.valueOf(this.mFormat));
        SimplyExtensionMap.put("asset_item_time_of_session", String.valueOf(this.mAssetItemTimeOfSession));
        SimplyExtensionMap.put("asset_item_session", String.valueOf(this.mAssetItemSession));
        SimplyExtensionMap.put("playback_rate", String.valueOf(this.mPlaybackRate));
        SimplyExtensionMap.put("buffering_count", String.valueOf(this.mBufferingCount));
        SimplyExtensionMap.put("first_audio_time", String.valueOf(this.mFirstAudioTime));
        SimplyExtensionMap.put("first_video_time", String.valueOf(this.mFirstVideoTime));
        SimplyExtensionMap.put("first_video_ready_time", String.valueOf(this.mFirstVideoReadyTime));
        SimplyExtensionMap.put("width", String.valueOf(this.mWidth));
        SimplyExtensionMap.put("height", String.valueOf(this.mHeight));
        SimplyExtensionMap.put("vcodec", String.valueOf(this.mVcodec));
        SimplyExtensionMap.put("vdecoder", String.valueOf(this.mVdecoder));
        SimplyExtensionMap.put("dash_cur_qn", String.valueOf(this.mDashCurQn));
        SimplyExtensionMap.put("dash_auto", String.valueOf(this.mDashAuto));
        SimplyExtensionMap.put(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT, String.valueOf(0));
        SimplyExtensionMap.put("audio_duration", String.valueOf(this.mAudioDuration));
        SimplyExtensionMap.put("video_duration", String.valueOf(this.mVideoDuration));
        SimplyExtensionMap.put("net_family", String.valueOf(this.mNetFamily));
        SimplyExtensionMap.put(DownloadedPageActivity.KEY_VIDEO_ID, String.valueOf(this.mVideoId));
        SimplyExtensionMap.put("audio_id", String.valueOf(this.mAudioId));
        SimplyExtensionMap.put("ijkversion", String.valueOf(this.mIjkVersion));
        SimplyExtensionMap.put("cur_qoe", String.valueOf(this.mCurQoe));
        SimplyExtensionMap.put("story_mode", String.valueOf(this.mStoryMode));
        SimplyExtensionMap.put("screen_state", String.valueOf(this.mScreenState));
        SimplyExtensionMap.put("drm_type", String.valueOf(this.mDrmType));
        switch (event) {
            case BLIJK_EV_FIRST_VIDEO_RENDER /* 1009 */:
                SimplyExtensionMap.put("audio_bitrate", String.valueOf(this.mAudioBitrate));
                SimplyExtensionMap.put("video_bitrate", String.valueOf(this.mVideoBitrate));
                SimplyExtensionMap.put("decode_switch_soft_frame", String.valueOf(this.mDecoderSwtichSoftFrames));
                SimplyExtensionMap.put("step_wait_time", String.valueOf(this.mStepWaitTime));
                SimplyExtensionMap.put("first_render_mode", String.valueOf(this.mFirstRenderMode));
                SimplyExtensionMap.put("url_info", String.valueOf(this.mUrlInfo));
                SimplyExtensionMap.put("asset_update_count", String.valueOf(this.mAssetUpdateCount));
                SimplyExtensionMap.put("user_qn", String.valueOf(this.mUserQn));
                FillHttpInfoExtensions(SimplyExtensionMap);
                SimplyExtensionMap.put("switch_on_info", String.valueOf(this.mSwitchOnInfo));
                SimplyExtensionMap.put("first_video_will_http_timestamp", String.valueOf(this.mFirstVideoWillHttpTimestamp));
                SimplyExtensionMap.put("first_video_did_http_timestamp", String.valueOf(this.mFirstVideoDidHttpTimestamp));
                SimplyExtensionMap.put("first_video_will_find_stream_timestamp", String.valueOf(this.mFirstVideoWillFindStreamTimestamp));
                SimplyExtensionMap.put("first_video_did_find_stream_timestamp", String.valueOf(this.mFirstVideoDidFindStreamTimestamp));
                SimplyExtensionMap.put("revc_video_first_pkg_timestamp", String.valueOf(this.mFirstVideoRecvPacketTimestamp));
                SimplyExtensionMap.put("player_get_first_pkg_time", String.valueOf(this.mFirstVideoPlayerRecvPktTimestamp));
                SimplyExtensionMap.put("decode_first_video_frame_time", String.valueOf(this.mFirstVideoPlayerDecodeTimestamp));
                SimplyExtensionMap.put("first_video_player_render_timestamp", String.valueOf(this.mFirstVideoPlayerRenderTimestamp));
                SimplyExtensionMap.put("play_start_timestamp", String.valueOf(this.mPlayStartTimestamp));
                break;
            case BLIJK_EV_DASH_DID_SWITCH_QN /* 1015 */:
                SimplyExtensionMap.put("dash_target_qn", String.valueOf(this.mDashTargetQn));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_DASH_SWITCH_DURATION, String.valueOf(this.mSwitchDuration));
                break;
            case BLIJK_EV_BUFFERING_START /* 1022 */:
            case BLIJK_EV_BUFFERING_END /* 1023 */:
                FillHttpInfoExtensions(SimplyExtensionMap);
                SimplyExtensionMap.put("analysis_user_propose", String.valueOf(this.mAnalysisUserPropose));
                SimplyExtensionMap.put("analysis_internal_propose", String.valueOf(this.mAnalysisInternalPropose));
                SimplyExtensionMap.put("network_level", String.valueOf(this.mNetworkLevel));
                break;
            case 2011:
            case BLIJK_EV_P2P_STATUS /* 2014 */:
                SimplyExtensionMap.put("audio_bitrate", String.valueOf(this.mAudioBitrate));
                SimplyExtensionMap.put("video_bitrate", String.valueOf(this.mVideoBitrate));
                SimplyExtensionMap.put("vdrop_rate", String.valueOf(this.mVdropRate));
                SimplyExtensionMap.put("decode_switch_soft_frame", String.valueOf(this.mDecoderSwtichSoftFrames));
                SimplyExtensionMap.put("step_wait_time", String.valueOf(this.mStepWaitTime));
                SimplyExtensionMap.put("audio_read_bytes", String.valueOf(this.mAudioReadBytes));
                SimplyExtensionMap.put("video_read_bytes", String.valueOf(this.mVideoReadBytes));
                SimplyExtensionMap.put("audio_mcdn_read_bytes", String.valueOf(this.mAudioMcdnReadBytes));
                SimplyExtensionMap.put("video_mcdn_read_bytes", String.valueOf(this.mVideoMcdnReadBytes));
                SimplyExtensionMap.put("p2p_download_size", String.valueOf(this.mP2PDownloadSize));
                SimplyExtensionMap.put("p2p_cdn_download_bytes", String.valueOf(this.mP2PCDNDownloadSize));
                SimplyExtensionMap.put("p2p_tcp_download_size", String.valueOf(this.mP2PTcpDownloadSize));
                SimplyExtensionMap.put("audio_consume_bytes", String.valueOf(this.mAudioConsumeBytes));
                SimplyExtensionMap.put("video_consume_bytes", String.valueOf(this.mVideoConsumeBytes));
                SimplyExtensionMap.put("first_render_mode", String.valueOf(this.mFirstRenderMode));
                SimplyExtensionMap.put("first_video_will_http_timestamp", String.valueOf(this.mFirstVideoWillHttpTimestamp));
                SimplyExtensionMap.put("revc_video_first_pkg_timestamp", String.valueOf(this.mFirstVideoRecvPacketTimestamp));
                SimplyExtensionMap.put("player_get_first_pkg_time", String.valueOf(this.mFirstVideoPlayerRecvPktTimestamp));
                SimplyExtensionMap.put("play_start_timestamp", String.valueOf(this.mPlayStartTimestamp));
                SimplyExtensionMap.put("is_complete", String.valueOf(this.mIsPlayComplete));
                SimplyExtensionMap.put("main_cpu_rate", String.valueOf(this.mMainProcessCpu));
                SimplyExtensionMap.put("main_thread_num", String.valueOf(this.mMainProcessThread));
                SimplyExtensionMap.put("main_mem", String.valueOf(this.mMainProcessMem));
                SimplyExtensionMap.put("main_thread_map", String.valueOf(this.mMainProcessThreadMap));
                SimplyExtensionMap.put("ijk_cpu_rate", String.valueOf(this.mIjkProcessCpu));
                SimplyExtensionMap.put("ijk_thread_num", String.valueOf(this.mIijkProcessThread));
                SimplyExtensionMap.put("ijk_mem", String.valueOf(this.mIjkProcessMem));
                SimplyExtensionMap.put("ijk_thread_map", String.valueOf(this.mIjkProcessThreadMap));
                SimplyExtensionMap.put("cur_battery_level", String.valueOf(this.mEndBatteryLevel));
                SimplyExtensionMap.put("battery_cost", String.valueOf(this.mEndBatteryLevel - this.mStartBatteryLevel));
                SimplyExtensionMap.put("url_info", String.valueOf(this.mUrlInfo));
                SimplyExtensionMap.put("user_qn", String.valueOf(this.mUserQn));
                SimplyExtensionMap.put("backup_url_info", String.valueOf(this.mBackupUrlInfo));
                SimplyExtensionMap.put("asset_update_count", String.valueOf(this.mAssetUpdateCount));
                SimplyExtensionMap.put("asset_change_error", String.valueOf(this.mChangeAssetError));
                SimplyExtensionMap.put("stream_reset_reason", String.valueOf(this.mStreamResetReason));
                SimplyExtensionMap.put("url_change_count", String.valueOf(this.mVideoChangeCount + this.mAudioChangeCount));
                SimplyExtensionMap.put("asset_update_time", String.valueOf(this.mAssetUpdateTime));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_SOCKET_REUSE, String.valueOf(this.mSocketReuse));
                SimplyExtensionMap.put("socket_num", String.valueOf(this.mSocketNum));
                SimplyExtensionMap.put("mediacodec_open_time", String.valueOf(this.mMediacodecOpenTime));
                SimplyExtensionMap.put("ijk_init_time", String.valueOf(this.mIjkserviceInitTime));
                SimplyExtensionMap.put(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT, String.valueOf(this.mForceReport));
                if (this.mFirstAudioTime == 0 && this.mFirstVideoTime == 0 && this.mFirstVideoReadyTime == 0 && this.mAssetItemTimeOfSession - this.mStepWaitTime > PlayerToastConfig.DURATION_3) {
                    SimplyExtensionMap.put(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT, String.valueOf(1));
                }
                SimplyExtensionMap.putAll(this.mExtraMapInfo);
                FillHttpInfoExtensions(SimplyExtensionMap);
                SimplyExtensionMap.put("bitrate_switch_count", String.valueOf(this.mBitrateSwitchCount));
                SimplyExtensionMap.put("max_qn", String.valueOf(this.mMaxQn));
                SimplyExtensionMap.put("min_qn", String.valueOf(this.mMinQn));
                SimplyExtensionMap.put("duration_360p", String.valueOf(this.mDuration360p));
                SimplyExtensionMap.put("duration_480p", String.valueOf(this.mDuration480p));
                SimplyExtensionMap.put("duration_720p", String.valueOf(this.mDuration720p));
                SimplyExtensionMap.put("duration_1080p", String.valueOf(this.mDuration1080p));
                SimplyExtensionMap.put("duration_others", String.valueOf(this.mDurationOthers));
                SimplyExtensionMap.put("switch_duration_count", String.valueOf(this.mSwitchDurationCount));
                SimplyExtensionMap.put("buffering_duration_count", String.valueOf(this.mBufferingDurationCount));
                SimplyExtensionMap.put("switch_lower_bitrate_count", String.valueOf(this.mSwitchLowerBitrateCount));
                SimplyExtensionMap.put("switch_higher_bitrate_count", String.valueOf(this.mSwitchHigherBitrateCount));
                SimplyExtensionMap.put("p2p_tracker_server_host", String.valueOf(this.mTrackerServerHost));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_THROUGHPUT_SPEED, String.valueOf(this.mThroughputSpeed));
                SimplyExtensionMap.put("ijk_network_wave", String.valueOf(this.mNetworkWave));
                SimplyExtensionMap.put("ijk_ave_network_speed", String.valueOf(this.mAveNetworkSpeed));
                SimplyExtensionMap.put("item_min_speed_record", String.valueOf(this.mItemMinSpeedRecord));
                SimplyExtensionMap.put("cpu_hardware", String.valueOf(this.mCpuName));
                SimplyExtensionMap.put("play_record", String.valueOf(this.mPlayRecord));
                SimplyExtensionMap.putAll(convertP2PStreamStateToSimply(this.mP2PStreamState));
                SimplyExtensionMap.put("max_speed", String.valueOf(this.mMaxSpeed));
                SimplyExtensionMap.put("av1_codec_name", String.valueOf(this.mAv1CodecName));
                SimplyExtensionMap.put("default_mediacodec_name", String.valueOf(this.mDefaultCodecName));
                SimplyExtensionMap.put("is_support_4k", String.valueOf(this.mIsSupport4k));
                SimplyExtensionMap.put("seek_count", String.valueOf(this.mSeekCount));
                SimplyExtensionMap.put("seek_diff", String.valueOf(this.mSeekDiff));
                SimplyExtensionMap.put("seek_first_pkg_time", String.valueOf(this.mSeekFirstPkgTime));
                SimplyExtensionMap.put("seek_buffering_acc_time", String.valueOf(this.mSeekBufferingAccTime));
                SimplyExtensionMap.put("cur_cache_time", String.valueOf(this.mCurCacheTime));
                SimplyExtensionMap.put("cur_playable_cache_time", String.valueOf(this.mCurPlayableCacheTime));
                SimplyExtensionMap.put("cache_wave_range", String.valueOf(this.mCacheWaveRange));
                SimplyExtensionMap.put("supprot_widevine_type", String.valueOf(this.mSupportWidevineType));
                if (event == 2014 && this.mP2PStreamState != null) {
                    SimplyExtensionMap.put("buffering_count", String.valueOf(this.mP2PBufferingCount));
                    SimplyExtensionMap.put("asset_item_time_of_session", String.valueOf(this.mP2PAssetItemTimeOfSession));
                }
                SimplyExtensionMap.put("switch_on_info", String.valueOf(this.mSwitchOnInfo));
                SimplyExtensionMap.put("start_network", String.valueOf(this.mStartNetwork));
                SimplyExtensionMap.put("network_change_count", String.valueOf(this.mNetworkChangeCount));
                SimplyExtensionMap.put("video_traceid_info", String.valueOf(this.mVideoTraceidInfo));
                SimplyExtensionMap.put("audio_traceid_info", String.valueOf(this.mAudioTraceidInfo));
                SimplyExtensionMap.put("http_by_ffmpeg", String.valueOf(this.mHttpByFFmpeg));
                SimplyExtensionMap.put("skip_frame_count", String.valueOf(this.mSkipFrameCount));
                SimplyExtensionMap.put("hls_max_update_duration", String.valueOf(this.mHlsMaxUpdateDuration));
                SimplyExtensionMap.put("hls_start_seq_count", String.valueOf(this.mHlsStartSeqCount));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FORMAT_CHANGE_COUNT, String.valueOf(this.mFormatChangeCount));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_CODEC_CHANGE_COUNT, String.valueOf(this.mCodecChangeCount));
                SimplyExtensionMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN_CHANGE_COUNT, String.valueOf(this.mQnChangeCount));
                SimplyExtensionMap.put("pause_count", String.valueOf(this.mPauseCount));
                SimplyExtensionMap.put("set_audio_only_count", String.valueOf(this.mSetAudioOnlyCount));
                SimplyExtensionMap.put("expect_latency", String.valueOf(this.mExpectLatency));
                SimplyExtensionMap.put("rendering_stuck_count", String.valueOf(this.mRenderingStuckCount));
                SimplyExtensionMap.put("rendering_stuck_duration", String.valueOf(this.mRenderingStuckDuration));
                SimplyExtensionMap.put("rendering_stuck_reason", String.valueOf(this.mRenderingStuckReason));
                SimplyExtensionMap.put("actual_playback_duration", String.valueOf(this.mActualPlaybackDuration));
                SimplyExtensionMap.put("analysis_user_propose", String.valueOf(this.mAnalysisUserPropose));
                SimplyExtensionMap.put("analysis_internal_propose", String.valueOf(this.mAnalysisInternalPropose));
                SimplyExtensionMap.put("network_level", String.valueOf(this.mNetworkLevel));
                SimplyExtensionMap.put("item_max_qn", String.valueOf(this.mItemMaxQn));
                SimplyExtensionMap.put("recommended_max_qn", String.valueOf(this.mRecommendedMaxQn));
                SimplyExtensionMap.put("auto_max_qn", String.valueOf(this.mAutoMaxQn));
                SimplyExtensionMap.put("alive_item_num", String.valueOf(this.mAliveItemNum));
                SimplyExtensionMap.put("alive_player_num", String.valueOf(this.mAlivePlayerNum));
                SimplyExtensionMap.put("audio_tp_error", String.valueOf(this.mAudioTpError));
                SimplyExtensionMap.put("av_unsync_count", String.valueOf(this.mAvUnsyncCount));
                SimplyExtensionMap.put("media_feature", String.valueOf(this.mMediaFeature));
                SimplyExtensionMap.put("enhance_type", String.valueOf(this.mEnhanceType));
                SimplyExtensionMap.put("enter_background_count", String.valueOf(this.mEnterBackgroundCount));
                SimplyExtensionMap.put("enter_background_duration", String.valueOf(this.mEnterBackgroundDuration));
                SimplyExtensionMap.put("is_mini_screen_switch_on", String.valueOf(this.mIsMiniScreenSwitchOn));
                SimplyExtensionMap.put("is_background_music_switch_on", String.valueOf(this.mIsBackgroundMusicOn));
                SimplyExtensionMap.put("screen_width", String.valueOf(this.mScreenInfoTracker.screenWidth));
                SimplyExtensionMap.put("screen_height", String.valueOf(this.mScreenInfoTracker.screenHeight));
                SimplyExtensionMap.put("screen_density_dpi", String.valueOf(this.mScreenInfoTracker.screenDensityDpi));
                SimplyExtensionMap.put("screen_wide_color_gamut", String.valueOf(this.mScreenInfoTracker.screenWideColorGamut));
                SimplyExtensionMap.put("screen_refresh_rate", String.valueOf(this.mScreenInfoTracker.screenRefreshRate));
                SimplyExtensionMap.put("device_score", String.valueOf(this.mDeviceScore));
                SimplyExtensionMap.put("focus_state", String.valueOf(this.mFocusState));
                SimplyExtensionMap.put("device_media_capability", String.valueOf(this.mDeviceCapability));
                break;
            case BLIJK_EV_ROTATE_QUALITY /* 2017 */:
                SimplyExtensionMap.put("item_max_qn", String.valueOf(this.mItemMaxQn));
                break;
        }
        return SimplyExtensionMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSimplyEventId(int event) {
        switch (event) {
            case 1001:
                return "main.ijk.will_prepare.tracker";
            case BLIJK_EV_FIRST_VIDEO_RENDER /* 1009 */:
                return "main.ijk.first_video_render.tracker";
            case BLIJK_EV_REPLACE_ITEM /* 1010 */:
                return "main.ijk.replace_item.tracker";
            case BLIJK_EV_DASH_DID_SWITCH_QN /* 1015 */:
                return "main.ijk.dash_did_switch_qn.tracker";
            case BLIJK_EV_SET_AUTO_SWITCH /* 1017 */:
                return "main.ijk.set_auto_switch.tracker";
            case BLIJK_EV_BUFFERING_START /* 1022 */:
                return "main.ijk.buffering_start.tracker";
            case BLIJK_EV_BUFFERING_END /* 1023 */:
                return "main.ijk.buffering_end.tracker";
            case 1024:
                return "main.ijk.decode_switch.tracker";
            case BLIJK_EV_HTTP_BUILD /* 2004 */:
                return "main.ijk.http_build.tracker";
            case BLIJK_EV_ASSET_ITEM_START /* 2010 */:
                return "main.ijk.asset_item_start.tracker";
            case 2011:
                return "main.ijk.asset_item_stop.tracker";
            case BLIJK_EV_P2P_STATUS /* 2014 */:
                return "main.ijk.p2p_status.tracker";
            case BLIJK_EV_LIVE_HEARTBEAT /* 2016 */:
                return "main.ijk.liveheartbeat.tracker";
            case BLIJK_EV_ROTATE_QUALITY /* 2017 */:
                return "main.ijk.rotate_quality.tracker";
            default:
                return null;
        }
    }

    private int updateP2PIntDotValue(String key, int value) {
        boolean flag = this.mP2PIntDotMapValue.containsKey(key);
        int newValue = value;
        if (flag) {
            newValue = value - this.mP2PIntDotMapValue.get(key).intValue();
        }
        this.mP2PIntDotMapValue.put(key, Integer.valueOf(value));
        return newValue;
    }

    private long updateP2PLongDotValue(String key, long value) {
        boolean flag = this.mP2PLongDotMapValue.containsKey(key);
        long newValue = value;
        if (flag) {
            newValue = value - this.mP2PLongDotMapValue.get(key).longValue();
        }
        this.mP2PLongDotMapValue.put(key, Long.valueOf(value));
        return newValue;
    }

    private void ijktrackerReport(int isAudio, int event) {
        if (this.mOnTrackerListener == null) {
            return;
        }
        if (event == 2014 && this.mP2PStreamState != null) {
            this.mP2PBufferingCount = updateP2PIntDotValue("buffering_count", this.mBufferingCount);
            this.mP2PAssetItemTimeOfSession = updateP2PLongDotValue("asset_item_time_of_session", this.mAssetItemTimeOfSession);
        }
        if (event == 2011) {
            trackerReport(true, getSimplyEventId(event), getSimplyExtensions(isAudio, event));
        } else {
            trackerReport(false, getSimplyEventId(event), getSimplyExtensions(isAudio, event));
        }
    }

    public String getOriginQn(String url) {
        int endPos;
        int startPos;
        if (url != null && (endPos = url.indexOf(EntryScannerKt.DASH_FILE_SUFFIX)) >= 0 && (startPos = url.lastIndexOf("-", endPos)) >= 0) {
            return url.substring(startPos + 1, endPos);
        }
        return "";
    }

    public synchronized void httpWillRebuild(IjkMediaPlayerItem item, String url, int retryCounter, long timestamp, int isAudio, int httpError, int httpCode, Bundle extra) {
        if (item == null) {
            return;
        }
        if (this.mMode == 0) {
            return;
        }
        recordNetState(url, isAudio == 1, httpCode, httpError);
        this.mHttpUrlRetryCount = retryCounter;
    }

    public synchronized void httpBuild(IjkMediaPlayerItem item, Bundle args) {
        if (item != null) {
            if (this.mAssetSessionCreateTime > 0 && this.mMode != 0) {
                String url = args.getString("url", null);
                int error = args.getInt("error", 0);
                int httpCode = args.getInt("http_code", 0);
                int isAudio = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_IS_AUDIO, 0);
                String ip = args.getString("ip", null);
                int port = args.getInt("port", 0);
                int family = args.getInt("family", 0);
                if (this.mNetFamily != 10) {
                    this.mNetFamily = family;
                }
                if (isAudio > 0) {
                    this.mAudioIp = ip;
                    this.mAudioPort = port;
                } else {
                    this.mVideoIp = ip;
                    this.mVideoPort = port;
                }
                recordNetState(url, isAudio == 1, httpCode, error);
                this.mStepWaitTime = (int) item.getStepWaitTime();
            }
        }
    }

    public synchronized void updateUrlChangeCount(IjkMediaPlayerItem item, UrlChangeInfo urlChangeInfo) {
        if (urlChangeInfo.isAudio > 0) {
            this.mAudioChangeCount = urlChangeInfo.urlChangeCount;
        } else {
            this.mVideoChangeCount = urlChangeInfo.urlChangeCount;
        }
        if (this.mFormatChangeCount != urlChangeInfo.formatChangeCount) {
            BLog.w(TAG, "[updateUrlChangeCount] formatChangeCount=" + urlChangeInfo.formatChangeCount);
            this.mFormatChangeCount = urlChangeInfo.formatChangeCount;
        }
        if (this.mCodecChangeCount != urlChangeInfo.codecChangeCount) {
            BLog.w(TAG, "[updateUrlChangeCount] codecChangeCount=" + urlChangeInfo.codecChangeCount);
            this.mCodecChangeCount = urlChangeInfo.codecChangeCount;
        }
        if (this.mQnChangeCount != urlChangeInfo.qnChangeCount) {
            BLog.w(TAG, "[updateUrlChangeCount] qnChangeCount=" + urlChangeInfo.qnChangeCount);
            this.mQnChangeCount = urlChangeInfo.qnChangeCount;
        }
    }

    public synchronized void getFirstVideoStatistic(IjkMediaPlayer player, IjkMediaPlayerItem item) {
        if (player == null || item == null) {
            return;
        }
        Bundle itemPkgStatics = item.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_WILL_HTTP_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_DID_HTTP_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_WILL_FIND_STREAM_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_DID_FIND_STREAM_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_REVC_VIDEO_FIRST_PACKET_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_FIRST_FRAME_DECODED_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_FIRST_FRAME_RENDER_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_PLAY_START_TIMESTAMP, IjkMediaPlayer.FFP_PROP_INT64_FILE_TYPE);
        this.mFirstVideoWillHttpTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_WILL_HTTP_TIMESTAMP);
        this.mFirstVideoDidHttpTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_DID_HTTP_TIMESTAMP);
        this.mFirstVideoWillFindStreamTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_WILL_FIND_STREAM_TIMESTAMP);
        this.mFirstVideoDidFindStreamTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FIRST_VIDEO_DID_FIND_STREAM_TIMESTAMP);
        this.mFirstVideoRecvPacketTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_REVC_VIDEO_FIRST_PACKET_TIMESTAMP);
        this.mFirstVideoPlayerRecvPktTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER);
        this.mFirstVideoPlayerDecodeTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_FIRST_FRAME_DECODED_TIMESTAMP);
        this.mFirstVideoPlayerRenderTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_FIRST_FRAME_RENDER_TIMESTAMP);
        this.mPlayStartTimestamp = getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_PLAY_START_TIMESTAMP);
        this.mFormat = (int) getPropetyLong(itemPkgStatics, IjkMediaPlayer.FFP_PROP_INT64_FILE_TYPE);
        this.mStartBatteryLevel = item.GetCurBatteryLevel();
    }

    public synchronized void willReplaceItem(IjkMediaPlayer player, IjkMediaPlayerItem newItem, long timestamp) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mIjkVersion = player.getIjkVersion();
                this.mAssetItemSession = signMD5(String.format(Locale.US, "%s%s", UUID.randomUUID().toString(), String.valueOf(timestamp)));
                this.mCurrentQnStartTime = timestamp;
                this.mAssetItemSessionCreateTime = timestamp;
                if (newItem != null && this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.startTimer();
                }
                this.mAssetItemTimeOfSession = 0L;
            }
        }
    }

    public synchronized void willPrepare(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mMode != 0 && this.mPlayerSessionCreateTime <= 0) {
                this.mIjkVersion = player.getIjkVersion();
                this.mBufferingCount = 0;
                this.mFirstRenderStart = 0;
                this.mAssetItemSession = signMD5(String.format(Locale.US, "%s%s", UUID.randomUUID().toString(), String.valueOf(timestamp)));
                this.mPlayerSessionCreateTime = timestamp;
                this.mCurrentQnStartTime = timestamp;
                this.mAssetItemSessionCreateTime = timestamp;
                this.mAssetItemTimeOfSession = 0L;
                IjkMediaPlayerItem item = player.getIjkMediaPlayerItem();
                for (int index = 0; index < 10; index++) {
                    this.mBufferingEndTimestamp[index] = 0;
                }
                if (item != null && this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.startTimer();
                }
            }
        }
    }

    public synchronized void ijkStartPrepare(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mIjkVersion = player.getIjkVersion();
            }
        }
    }

    public synchronized void didFirstAudioRendered(IjkMediaPlayer player, IjkMediaPlayerItem item, long timestamp) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                if (item != null) {
                    Bundle itemStatics = item.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_FILE_TYPE, IjkMediaPlayer.FFP_PROP_INT64_HAS_VIDEO_STREAM);
                    this.mFormat = (int) getPropetyLong(itemStatics, IjkMediaPlayer.FFP_PROP_INT64_FILE_TYPE);
                    this.mStepWaitTime = (int) item.getStepWaitTime();
                    this.mHasVideoStream = getPropetyInt(itemStatics, IjkMediaPlayer.FFP_PROP_INT64_HAS_VIDEO_STREAM) == 1;
                }
                this.mFirstRenderStart = 1 | this.mFirstRenderStart;
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mFirstAudioTime = (int) (timestamp - this.mAssetItemSessionCreateTime);
                }
            }
        }
    }

    private void updateScreenInfo() {
        WindowManager wm = (WindowManager) this.mContext.getSystemService("window");
        this.mScreenInfoTracker = IjkMediaScreenInfo.getScreenInfo(wm);
    }

    private void updateMetaData(IjkMediaPlayer player, Bundle extra) {
        MediaInfo mih;
        IjkMediaMeta imm;
        Bundle media_meta = extra.getBundle("media_meta");
        if (media_meta == null) {
            mih = player.getMediaInfo();
        } else {
            mih = player.getMediaInfoInternal(media_meta);
        }
        if (mih != null && (imm = mih.mMeta) != null) {
            IjkMediaMeta.IjkStreamMeta vsm = imm.mVideoStream;
            if (vsm != null) {
                this.mVideoBitrate = (int) vsm.mBitrate;
                this.mAudioBitrate = (int) vsm.mBitrate;
                this.mVfps = vsm.getFpsInline();
                this.mVcodec = vsm.getCodecLongNameInline();
                this.mVdecoder = mih.mVideoDecoder + ":" + mih.mVideoDecoderImpl;
                this.mSar = vsm.mSarDen / vsm.mSarNum;
            }
            IjkMediaMeta.IjkStreamMeta asm = imm.mAudioStream;
            if (asm != null) {
                this.mAcodec = asm.getCodecLongNameInline();
                this.mAudioBitrate = (int) asm.mBitrate;
            }
        }
    }

    public synchronized void didFirstVideoRendered(IjkMediaPlayer player, IjkMediaPlayerItem item, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                getFirstVideoStatistic(player, item);
                if (extra == null) {
                    extra = player.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION, 10003, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_VIDEO_ID, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_AUDIO_ID, IjkMediaPlayer.FFP_PROP_INT64_STREAM_RESET_REASON);
                }
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                }
                long timeOfVideo = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION);
                this.mPlaybackRate = getPropetyFloat(extra, 10003);
                this.mAudioDuration = player.getDuration();
                this.mVideoDuration = player.getDuration();
                updateMetaData(player, extra);
                updateScreenInfo();
                this.mFirstRenderStart |= 2;
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mFirstVideoTime = (int) (timestamp - this.mAssetItemSessionCreateTime);
                    long firstVideoReadyTime = extra.getLong(ChronosDanmakuSender.KEY_CMTIME_START, 0L);
                    this.mFirstVideoReadyTime = (int) (firstVideoReadyTime - this.mAssetItemSessionCreateTime);
                }
                this.mDashCurQn = getDashCurQn(extra, player);
                this.mVideoId = this.mDashCurQn;
                this.mAudioId = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_AUDIO_ID);
                if (this.mResolutionRecord.length() > 0) {
                    this.mResolutionRecord += ",";
                }
                this.mResolutionRecord += "{\"" + String.valueOf(this.mFirstVideoTime) + "\":" + getOriginQn(this.mVideoUrl) + "}";
                if (this.mSeekRecord.length() > 0) {
                    this.mSeekRecord += ",";
                }
                this.mSeekRecord += "{\"" + String.valueOf(this.mAssetItemTimeOfSession) + "\":" + String.valueOf(timeOfVideo) + "}";
                this.mStreamResetReason = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_STREAM_RESET_REASON);
                getCurQoe(timestamp, BLIJK_EV_FIRST_VIDEO_RENDER);
                if (item != null) {
                    this.mStepWaitTime = (int) item.getStepWaitTime();
                    int screenState = item.getScreenState();
                    setScreenState(screenState);
                    this.mFirstRenderMode = item.getFirstRenderMode();
                    Bundle itemStatics = item.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_SOFT_DECODE_FRAME_COUNT);
                    this.mDecoderSwtichSoftFrames = (int) getPropetyLong(itemStatics, IjkMediaPlayer.FFP_PROP_INT64_SOFT_DECODE_FRAME_COUNT);
                }
                ijktrackerReport(0, BLIJK_EV_FIRST_VIDEO_RENDER);
            }
        }
    }

    public synchronized void didAccurateSeek(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                if (extra == null) {
                    extra = player.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION);
                }
                long timeOfVideo = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION);
                this.mSeekDiff = Math.abs(this.mAccurateSeekToTargetTime - ((int) timeOfVideo));
                this.mSeekBufferingAccTime = timestamp - this.mWillAccurateSeekToTime;
                this.mWillAccurateSeekToTime = 0L;
                this.mAccurateSeekToTargetTime = 0;
            }
        }
    }

    public synchronized void didSeekVideoRendered(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                if (extra == null) {
                    extra = player.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION);
                }
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                }
                long timeOfVideo = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CURRENT_POSITION);
                if (this.mSeekRecord.length() > 0) {
                    this.mSeekRecord += ",";
                }
                this.mSeekRecord += "{\"" + String.valueOf(this.mAssetItemTimeOfSession) + "\":" + String.valueOf(timeOfVideo) + "}";
                this.mSeekStarted = false;
            }
        }
    }

    public synchronized void didSeekAudioRendered(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mSeekStarted = false;
            }
        }
    }

    public synchronized void didDashSwitch(IjkMediaPlayer player, int curId, int nextId, boolean isAudio, int autoSwitch, long timestamp, long switchDuration, Bundle extra) {
        Bundle extra2;
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0) {
                if (this.mMode == 0) {
                }
                if (extra != null) {
                    extra2 = extra;
                } else {
                    extra2 = player.getPropertiesBundle(10003);
                }
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                }
                this.mPlaybackRate = getPropetyFloat(extra2, 10003);
                if (isAudio) {
                    this.mAudioId = nextId;
                } else {
                    this.mVideoId = nextId;
                }
                this.mSwitchDuration = switchDuration;
                this.mSwitchDurationCount += switchDuration;
                if (this.mResolutionRecord.length() > 0) {
                    this.mResolutionRecord += ",";
                }
                this.mResolutionRecord += "{\"" + String.valueOf(this.mAssetItemTimeOfSession) + "\":" + getOriginQn(this.mVideoUrl) + "}";
                if (curId > nextId) {
                    this.mSwitchLowerBitrateCount++;
                } else if (curId < nextId) {
                    this.mSwitchHigherBitrateCount++;
                }
                if (nextId != 0 && curId != nextId) {
                    this.mBitrateSwitchCount++;
                }
                this.mDashCurQn = curId;
                this.mDashTargetQn = nextId;
                getCurQoe(timestamp, BLIJK_EV_DASH_DID_SWITCH_QN);
                int oldAutoSwitch = this.mDashAuto;
                this.mDashAuto = autoSwitch;
                setQnDuration(this.mDashCurQn, timestamp);
                this.mCurrentQnStartTime = timestamp;
                ijktrackerReport(0, BLIJK_EV_DASH_DID_SWITCH_QN);
                this.mDashCurQn = this.mDashTargetQn;
                this.mDashAuto = oldAutoSwitch;
            }
        }
    }

    public synchronized void didDashAudioSwitch(int nextId) {
        this.mAudioId = nextId;
    }

    public synchronized void updateBackgroundState(boolean isBackground, boolean isMiniScreenSwitchOn, boolean isBackgroundMusicOn) {
        int i;
        if (isBackground != this.mIsBackground) {
            long timestamp = SystemClock.elapsedRealtime();
            int i2 = 1;
            if (isBackground) {
                this.mEnterBackgroundCount++;
                this.mEnterBackgroundStartTime = timestamp;
                if (this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.mLiveEnterBackgroundCount++;
                }
            } else if (this.mEnterBackgroundStartTime > 0) {
                if (this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.updateBackgroundInfo(timestamp);
                }
                this.mEnterBackgroundDuration += timestamp - this.mEnterBackgroundStartTime;
                this.mEnterBackgroundStartTime = 0L;
            }
            if (isMiniScreenSwitchOn) {
                i = 1;
            } else {
                i = 0;
            }
            this.mIsMiniScreenSwitchOn = i;
            if (!isBackgroundMusicOn) {
                i2 = 0;
            }
            this.mIsBackgroundMusicOn = i2;
            this.mIsBackground = isBackground;
        }
    }

    public synchronized void notifyP2pUrlChange(String newUrl, String extraInfo) {
        this.mLiveP2pInfo = extraInfo;
        updateUrl(newUrl, 0);
    }

    public synchronized void notifyLiveQnChange(IjkMediaPlayer player, int curQn, int targetQn, String newUrl, IjkMediaPlayer.LiveSwitchQnMode switchQnMode) {
        long timestamp = SystemClock.elapsedRealtime();
        this.mSwitchQnMode = switchQnMode;
        if (this.mLiveHeartbeat != null) {
            this.mLiveHeartbeat.cancelTimer(timestamp, 3);
        }
        updateUrl(newUrl, 0);
        int isAuto = switchQnMode == IjkMediaPlayer.LiveSwitchQnMode.MODE_AUTO ? 1 : 0;
        didDashSwitch(player, curQn, targetQn, false, isAuto, timestamp, 0L, null);
    }

    public synchronized void videoSizeChange(IjkMediaPlayer player, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mWidth = player.getVideoWidth();
                this.mHeight = player.getVideoHeight();
                updateMetaData(player, extra);
            }
        }
    }

    public synchronized void setDashAutoSwitch(boolean dashAutoSwitch) {
        int autoSwitch = dashAutoSwitch ? 1 : 0;
        if (autoSwitch != this.mDashAuto) {
            this.mDashTargetQn = this.mSwitchNonAutoTargetQn;
            this.mDashAuto = autoSwitch;
        }
        recordAutoMaxQn();
    }

    public synchronized boolean getDashAuto() {
        return this.mDashAuto == 1;
    }

    public synchronized void willSeekTo(IjkMediaPlayer player, long targetPos, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mSeekStarted = true;
                this.mAccurateSeekToTargetTime = (int) targetPos;
                this.mWillSeekToTime = timestamp;
            }
        }
    }

    public synchronized void didSeekTo(IjkMediaPlayer player, int seekBufferWaterMark, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                this.mWillAccurateSeekToTime = timestamp;
                this.mSeekCount++;
                this.mSeekFirstPkgTime = timestamp - this.mWillSeekToTime;
            }
        }
    }

    public synchronized void willPreroll(IjkMediaPlayer player, int reason, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                long timeOfVideo = player.getCurrentPosition();
                if (timeOfVideo <= 0) {
                    return;
                }
                MediaInfo mediaInfo = player.getMediaInfo();
                IjkMediaPlayerItem curItem = player.getIjkMediaPlayerItem();
                if (mediaInfo == null || mediaInfo.mMeta == null || !((mediaInfo.mMeta.mAudioStream == null || mediaInfo.mMeta.mAudioStream.mSampleRate == 0) && curItem != null && curItem.isEnableIgnoreOnlyVideoBufferingReport())) {
                    Bundle extra2 = extra == null ? player.getPropertiesBundle(10003, IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_DURATION, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_VIDEO_ID, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL) : extra;
                    this.mPlaybackRate = getPropetyFloat(extra2, 10003);
                    if (this.mAssetItemSessionCreateTime > 0) {
                        this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                    }
                    int isSeekBuffering = 0;
                    isSeekBuffering = (this.mSeekStarted || reason == 1) ? 1 : 1;
                    long videoCacheDuration = getPropetyLong(extra2, IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_DURATION);
                    this.mDashCurQn = getDashCurQn(extra2, player);
                    this.mNetworkLevel = getPropetyInt(extra2, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL);
                    IjkMediaPlayerItem item = player.getIjkMediaPlayerItem();
                    if (item != null) {
                        Bundle propose = item.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_USER_PROPOSE, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_INTERNAL_PROPOSE);
                        this.mAnalysisUserPropose = getPropetyLong(propose, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_USER_PROPOSE);
                        this.mAnalysisInternalPropose = getPropetyLong(propose, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_INTERNAL_PROPOSE);
                    }
                    if (reason != 2 && isSeekBuffering == 0 && videoCacheDuration < PlayerToastConfig.DURATION_10) {
                        this.mBufferingCount++;
                        if (this.mLiveHeartbeat != null) {
                            this.mLiveHeartbeat.mBufferingCount++;
                        }
                        this.mWillPrerollTime = timestamp;
                        this.mError = reason;
                        getCurQoe(timestamp, BLIJK_EV_BUFFERING_START);
                        ijktrackerReport(0, BLIJK_EV_BUFFERING_START);
                        this.mError = 0L;
                    }
                }
            }
        }
    }

    public synchronized void didPreroll(IjkMediaPlayer player, int reason, long timestamp, Bundle extra) {
        if (player != null) {
            if (this.mPlayerSessionCreateTime > 0 && this.mMode != 0) {
                if (extra == null) {
                    extra = player.getPropertiesBundle(10003, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_VIDEO_ID, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL);
                }
                this.mPlaybackRate = getPropetyFloat(extra, 10003);
                if (this.mWillPrerollTime <= 0) {
                    return;
                }
                getCurQoe(timestamp, BLIJK_EV_BUFFERING_END);
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                }
                long timeOfEvent = timestamp - this.mWillPrerollTime;
                this.mBufferingDurationCount += timeOfEvent;
                if (this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.updateBufferingInfo(timestamp);
                }
                if (this.mBufferingRecord.length() > 0) {
                    this.mBufferingRecord += ",";
                }
                long startTime = this.mAssetItemTimeOfSession - timeOfEvent;
                this.mBufferingRecord += "{\"" + String.valueOf(startTime) + "\":" + String.valueOf(timeOfEvent) + "}";
                this.mDashCurQn = getDashCurQn(extra, player);
                this.mError = reason;
                this.mNetworkLevel = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL);
                ijktrackerReport(0, BLIJK_EV_BUFFERING_END);
                this.mError = 0L;
                this.mWillPrerollTime = 0L;
            }
        }
    }

    public synchronized void itemStart(IjkMediaPlayerItem item, long timestamp, Bundle extra) {
        if (item != null) {
            if (this.mMode != 0 && this.mAssetSessionCreateTime <= 0) {
                this.mAssetSessionCreateTime = timestamp;
                this.mDashCurQn = item.getCurQn();
                this.mDashTargetQn = item.getCurQn();
                this.mIsLive = item.isLive();
                recordUserPlayPrefer();
                recordUserQn();
            }
        }
    }

    private static long getPropetyLong(Bundle bundle, int key) {
        if (bundle == null) {
            return 0L;
        }
        try {
            long ret = Long.valueOf(bundle.getString(String.valueOf(key))).longValue();
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return 0L;
        }
    }

    private static int getPropetyInt(Bundle bundle, int key) {
        if (bundle == null) {
            return 0;
        }
        try {
            int ret = Integer.valueOf(bundle.getString(String.valueOf(key))).intValue();
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return 0;
        }
    }

    private static float getPropetyFloat(Bundle bundle, int key) {
        float ret = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        if (bundle != null) {
            try {
                ret = Float.valueOf(bundle.getString(String.valueOf(key))).floatValue();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return Float.isNaN(ret) ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : ret;
    }

    public long getLoadFailNetworkError(long error) {
        if ((IjkMediaPlayer.IJK_SERVICE_ERROR_BASE & error) != 0) {
            return error | 60;
        }
        if (this.mHasAnr) {
            return error | 61;
        }
        if ((512 & error) != 0) {
            if ((4096 & error) != 0) {
                return error | 63;
            }
            if ((65536 & error) != 0) {
                return error | 64;
            }
            return error | 62;
        } else if (!this.mPlayerGetFirstPkt) {
            int error_code = (int) this.mVideoNetError;
            int error_code2 = error_code < 0 ? error_code : (int) this.mAudioNetError;
            int error_code3 = error_code2 < 0 ? error_code2 : (int) this.mLastVideoNetError;
            int error_code4 = error_code3 < 0 ? error_code3 : (int) this.mLastAudioNetError;
            if (error_code4 < 0) {
                switch (error_code4) {
                    case -2005:
                        return error | 4;
                    case -2004:
                        return error | 3;
                    case -1002:
                        return error | 7;
                    case IjkAssetUpdateReason.ASSET_UPDATE_REASON_ERROR_CODE_CONNECTION_TIMED_OUT /* -1001 */:
                        return error | 5;
                    case -404:
                        return error | 16;
                    case -403:
                        return error | 15;
                    case -401:
                        return error | 20;
                    case -400:
                        return error | 19;
                    case -113:
                        return error | 44;
                    case -111:
                        return error | 42;
                    case -104:
                        return error | 45;
                    case -103:
                        return error | 40;
                    case -101:
                        return error | 41;
                    case -5:
                        return error | 43;
                    default:
                        if (error_code4 <= -500 && error_code4 > -600) {
                            return error | 18;
                        }
                        if (error_code4 <= -400 && error_code4 > -500) {
                            return error | 17;
                        }
                        if (error_code4 < 0) {
                            return error | 99;
                        }
                        return error;
                }
            } else if (this.mIsLive && this.mItemOpenStatus == 1) {
                return error | 21;
            } else {
                if ((this.mAudioReadBytes > 0 && this.mVideoReadBytes > 0) || (this.mFormat != 3 && this.mVideoReadBytes > 0)) {
                    return error | 8;
                }
                if ((255 & error) == 0) {
                    if (this.mAudioReadBytes > 0) {
                        return error | 10;
                    }
                    if (this.mVideoReadBytes > 0) {
                        return error | 9;
                    }
                    return error | 100;
                }
                return error;
            }
        } else {
            return error | 30;
        }
    }

    public String getLoadFailNetworkErrorString(long error) {
        long javaError = error & 255;
        if (javaError == 1) {
            return "no_item_or_url";
        }
        long finalError = getLoadFailNetworkError(error);
        long networkError = 255 & finalError;
        if (networkError == 0) {
            return "";
        }
        if (networkError == 60) {
            return "ijk_service_cant_run";
        }
        if (networkError == 61) {
            return "ijk_service_anr";
        }
        if (networkError == 62 || networkError == 63 || networkError == 64) {
            return "item_exit_error";
        }
        if (networkError == 30) {
            return "get_pkt_but_no_render";
        }
        return "network_error_" + networkError;
    }

    private void checkLoadFailSupplementReason(IjkMediaPlayerItem item) {
        String abnormal_supplement_reason = "";
        if (item.isGetFreeUrlBlocked()) {
            abnormal_supplement_reason = "get_free_url_blocked";
        } else if (this.mDrmType > 0) {
            abnormal_supplement_reason = "drm_black_screen";
        } else if (item.GetNoAssetUpdateListenerCount() >= 3) {
            abnormal_supplement_reason = "no_asset_update_listener";
        }
        if (!abnormal_supplement_reason.isEmpty()) {
            BLog.w(TAG, "[PlayProblem] abnormal_supplement_reason=" + abnormal_supplement_reason);
        }
    }

    private void updateAnalysisPropose(Bundle extra) {
        this.mAnalysisUserPropose = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_USER_PROPOSE);
        if (this.mAnalysisUserPropose == 0 && (this.mHasAnr || this.mHasIjkProcessError)) {
            this.mAnalysisUserPropose = 104L;
        }
        this.mAnalysisInternalPropose = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_INTERNAL_PROPOSE);
        if (this.mAnalysisInternalPropose == 0) {
            if (this.mHasAnr || this.mHasIjkProcessError) {
                this.mAnalysisInternalPropose = 301L;
            }
        }
    }

    private void getNativeDataItemStop(IjkMediaPlayerItem item) {
        Bundle extra = item.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_MCDN_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_MCDN_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_MCDN_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_PLAYER_ERROR_CODE_WITH_LOG, IjkMediaPlayer.FFP_PROP_INT64_ITEM_ERROR_CODE_WITH_LOG, IjkMediaPlayer.FFP_PROP_INT64_P2P_DOWNLOAD_SIZE, IjkMediaPlayer.FFP_PROP_INT64_P2P_CDN_DOWNLOAD_SIZE, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_CONSUME_BYTES, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CONSUME_BYTES, IjkMediaPlayer.FFP_PROP_INT64_P2P_TCP_DOWNLOAD_SIZE, IjkMediaPlayer.FFP_PROP_INT64_HLS_MAX_UPDATE_DURATION, IjkMediaPlayer.FFP_PROP_INT64_HLS_START_SEQ_COUNT, IjkMediaPlayer.FFP_PROP_INT64_CACHE_VIDEO_BITRATE, IjkMediaPlayer.FFP_PROP_INT64_CACHE_AUDIO_BITRATE, IjkMediaPlayer.FFP_PROP_INT64_MEDIACODEC_OPEN_TIME, IjkMediaPlayer.FFP_PROP_INT64_ITEM_OPEN_STATUS, IjkMediaPlayer.FFP_PROP_INT64_HTTP_BY_FFMPEG, IjkMediaPlayer.FFP_PROP_INT64_ALIVE_ITEM_NUM, IjkMediaPlayer.FFP_PROP_INT64_ALIVE_PLAYER_NUM, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_USER_PROPOSE, IjkMediaPlayer.FFP_PROP_INT64_ANALYSIS_INTERNAL_PROPOSE, 20300, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_DNS_TIME, IjkMediaPlayer.FFP_PROP_INT64_SOCKET_NUM, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_TCP_TIME, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_TCP_TIME, IjkMediaPlayer.FFP_PROP_INT64_IS_SOCKET_REUSE, IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER, IjkMediaPlayer.FFP_PROP_INT64_AVE_NETWORK_SPEED, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_WAVE, IjkMediaPlayer.FFP_PROP_INT64_CUR_BUF_CACHE_TIME, IjkMediaPlayer.FFP_PROP_INT64_CUR_PLAYABLE_CACHE_TIME, IjkMediaPlayer.FFP_PROP_INT64_SKIP_FRAME_COUNT, IjkMediaPlayer.FFP_PROP_INT64_CACHE_WAVE_RANGE, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_COUNT, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_DURATION, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_REASON, IjkMediaPlayer.FFP_PROP_INT64_ACTUAL_PLAYBACK_DURATION, IjkMediaPlayer.FFP_PROP_INT64_SET_AUDIO_ONLY_COUNT, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_AUDIO_ID, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_TP_ERROR, 10007, IjkMediaPlayer.FFP_PROP_INT64_SOFT_DECODE_FRAME_COUNT, IjkMediaPlayer.FFP_PROP_FLOAT_MAX_SPEED, IjkMediaPlayer.FFP_PROP_INT64_AV_UNSYNC_COUNT);
        long dashVideoReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_BYTE_COUNT);
        long normalReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT);
        long dashAudioMcdnReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_MCDN_BYTE_COUNT);
        long dashVideoMcdnReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_MCDN_BYTE_COUNT);
        long normalMcdnReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_MCDN_BYTE_COUNT);
        this.mAudioReadBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_BYTE_COUNT);
        this.mVideoReadBytes = dashVideoReadBytes + normalReadBytes;
        this.mAudioMcdnReadBytes = dashAudioMcdnReadBytes;
        this.mVideoMcdnReadBytes = dashVideoMcdnReadBytes + normalMcdnReadBytes;
        this.mP2PDownloadSize = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_P2P_DOWNLOAD_SIZE);
        this.mP2PCDNDownloadSize = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_P2P_CDN_DOWNLOAD_SIZE);
        this.mP2PTcpDownloadSize = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_P2P_TCP_DOWNLOAD_SIZE);
        this.mMediacodecOpenTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_MEDIACODEC_OPEN_TIME);
        this.mHttpByFFmpeg = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_HTTP_BY_FFMPEG);
        BLog.i(TAG, "item stop p2p_download_size :" + this.mP2PDownloadSize + " p2p_cdn_download_size :" + this.mP2PCDNDownloadSize + " tcp:" + this.mP2PTcpDownloadSize);
        this.mAudioConsumeBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_CONSUME_BYTES);
        this.mVideoConsumeBytes = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CONSUME_BYTES);
        this.mHlsMaxUpdateDuration = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_HLS_MAX_UPDATE_DURATION);
        this.mHlsStartSeqCount = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_HLS_START_SEQ_COUNT);
        this.mItemOpenStatus = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ITEM_OPEN_STATUS);
        this.mAliveItemNum = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ALIVE_ITEM_NUM);
        this.mAlivePlayerNum = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ALIVE_PLAYER_NUM);
        this.mAudioId = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_AUDIO_ID);
        this.mDecoderSwtichSoftFrames = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_SOFT_DECODE_FRAME_COUNT);
        this.mAvUnsyncCount = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_AV_UNSYNC_COUNT);
        if (item.isLive()) {
            this.mVideoBitrate = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CACHE_VIDEO_BITRATE);
            this.mAudioBitrate = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CACHE_AUDIO_BITRATE);
        }
        updateAnalysisPropose(extra);
        this.mNetworkWave = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_WAVE);
        this.mAveNetworkSpeed = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_AVE_NETWORK_SPEED);
        this.mCurCacheTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CUR_BUF_CACHE_TIME);
        this.mCurPlayableCacheTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CUR_PLAYABLE_CACHE_TIME);
        this.mCacheWaveRange = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_CACHE_WAVE_RANGE);
        this.mSkipFrameCount = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_SKIP_FRAME_COUNT);
        this.mRenderingStuckCount = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_COUNT);
        this.mRenderingStuckDuration = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_DURATION);
        this.mRenderingStuckReason = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_RENDERING_STUCK_REASON);
        this.mActualPlaybackDuration = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ACTUAL_PLAYBACK_DURATION);
        this.mSetAudioOnlyCount = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_SET_AUDIO_ONLY_COUNT);
        this.mNetworkLevel = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_NETWORK_LEVEL);
        this.mAudioTpError = getPropetyInt(extra, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_TP_ERROR);
        this.mVdropRate = getPropetyFloat(extra, 10007);
        this.mMaxSpeed = getPropetyFloat(extra, IjkMediaPlayer.FFP_PROP_FLOAT_MAX_SPEED);
        this.mVideoDnsTime = getPropetyLong(extra, 20300);
        this.mAudioDnsTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_DNS_TIME);
        this.mVideoTcpTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_TCP_TIME);
        this.mAudioTcpTime = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_TCP_TIME);
        this.mSocketReuse = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_IS_SOCKET_REUSE);
        this.mSocketNum = (int) getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_SOCKET_NUM);
        this.mPlayerGetFirstPkt = getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER) != 0;
        this.mNativeErrorCode = Math.abs(getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_ITEM_ERROR_CODE_WITH_LOG));
        this.mNativeErrorCode |= Math.abs(getPropetyLong(extra, IjkMediaPlayer.FFP_PROP_INT64_PLAYER_ERROR_CODE_WITH_LOG));
    }

    public synchronized void itemStop(IjkMediaPlayerItem item, long timestamp) {
        if (item != null) {
            if (this.mAssetSessionCreateTime > 0 && this.mMode != 0) {
                IjkDeviceScoreInfo deviceScoreInfo = IjkDeviceScoreInfo.getInstance(null);
                this.mDeviceScore = deviceScoreInfo == null ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : deviceScoreInfo.getTotalScore();
                getCurQoe(timestamp, 2011);
                if (this.mAssetItemSessionCreateTime > 0) {
                    this.mAssetItemTimeOfSession = timestamp - this.mAssetItemSessionCreateTime;
                }
                getNativeDataItemStop(item);
                setQnDuration(this.mDashCurQn, timestamp);
                if (TextUtils.isEmpty(this.mBackupUrlInfo)) {
                    this.mBackupUrlInfo = item.getBackupUrlInfo(this.mDashCurQn);
                }
                this.mAudioTraceidInfo = item.getNativePropertyString(IjkMediaPlayer.FFP_PROP_STRING_TRACEID_RECORD_AUDIO);
                this.mVideoTraceidInfo = item.getNativePropertyString(IjkMediaPlayer.FFP_PROP_STRING_TRACEID_RECORD_VIDEO);
                this.mItemMinSpeedRecord = item.getNativePropertyString(IjkMediaPlayer.FFP_PROP_STRING_MIN_SPEED_RECORD);
                this.mFirstRenderMode = item.getFirstRenderMode();
                this.mStepWaitTime = (int) item.getStepWaitTime();
                this.mAv1CodecName = IjkCodecHelper.getBestCodecNameEnter("video/av01");
                this.mIsSupport4k = IjkCodecHelper.isUhdSupport() ? 1 : 0;
                this.mDeviceCapability = IjkCodecHelper.getDeviceCapability((WindowManager) this.mContext.getSystemService("window"));
                if (item.isLive() && this.mRecordSwitchTimes == 0) {
                    addSwitchOnInfo("enableSkipFrame", this.mEnableSkipFrame > 0 ? 1 : 0);
                    addSwitchOnInfo("enableJitterBuffer", this.mEnableJitterBuffer > 0 ? 1 : 0);
                    addSwitchOnInfo("isAbleLowLatency", this.mIsAbleLowLatency > 0 ? 1 : 0);
                }
                long error = this.mNativeErrorCode | Math.abs(this.mJavaError);
                BLog.w(TAG, "Item stop error code | add item error : " + error);
                if (this.mFirstRenderStart == 0 && this.mAssetItemTimeOfSession > this.mStepWaitTime + 3000) {
                    if ((error & 255) == 0) {
                        error = getLoadFailNetworkError(error);
                    }
                    long load_fail_error = 255 & error;
                    checkLoadFailSupplementReason(item);
                    BLog.w(TAG, "[PlayProblem] load failed, cid=" + this.mCid + ", load_fail_error=" + load_fail_error + ", user_propose=" + this.mAnalysisUserPropose + ", internal_propose=" + this.mAnalysisInternalPropose);
                }
                this.mError = -Math.abs(error);
                BLog.w(TAG, "Item stop error code | return error : " + this.mError);
                if (this.mWillPrerollTime > 0) {
                    long timeOfEvent = timestamp - this.mWillPrerollTime;
                    this.mBufferingDurationCount += timeOfEvent;
                    if (this.mBufferingRecord.length() > 0) {
                        this.mBufferingRecord += ",";
                    }
                    long startTime = this.mAssetItemTimeOfSession - timeOfEvent;
                    this.mBufferingRecord += "{\"" + String.valueOf(startTime) + "\":" + String.valueOf(timeOfEvent) + "}";
                    BLog.w(TAG, "[PlayProblem] stop in buffering, cid=" + this.mCid + ", user_propose=" + this.mAnalysisUserPropose + ", internal_propose=" + this.mAnalysisInternalPropose);
                }
                this.mPlayRecord = "{\"buffering\":[" + this.mBufferingRecord + "],\"resolution\":[" + this.mResolutionRecord + "],\"seek\":[" + this.mSeekRecord + "]}";
                BLog.i(TAG, "[PlayRecordDetail][playRecord] cid=" + this.mCid + ", record=" + this.mPlayRecord);
                if (item.mAudioMixUrls != null && item.mAudioMixUrls.length > 0) {
                    this.mAudioUrl = item.mAudioMixUrls[0];
                }
                if (this.mLiveHeartbeat != null) {
                    this.mLiveHeartbeat.cancelTimer(timestamp, 2);
                }
                cancelSSTimer();
                if (this.mEnterBackgroundStartTime > 0) {
                    this.mEnterBackgroundDuration += timestamp - this.mEnterBackgroundStartTime;
                    this.mEnterBackgroundStartTime = 0L;
                }
                if (this.mPauseCount > 0 && timestamp - this.mLastPauseTimestamp < 1000) {
                    this.mPauseCount--;
                }
                recordUserPlayPrefer();
                recordUserQn();
                recordAutoMaxQn();
                UpdateReportPerformance(item);
                ijktrackerReport(0, 2011);
                this.mAssetSessionCreateTime = 0L;
                this.mRecordSwitchTimes++;
            }
        }
    }

    public void P2PReport(IjkMediaPlayerItem item) {
        long nP2PDownLoadBytes;
        long nP2PCDNDownLoadBytes;
        int nRate;
        long startMs = SystemClock.elapsedRealtime();
        HashMap<String, String> p2pStreamState = item.getP2PStreamState(mP2PKeyMap);
        this.mAudioTraceidInfo = item.getNativePropertyString(IjkMediaPlayer.FFP_PROP_STRING_TRACEID_RECORD_AUDIO);
        this.mVideoTraceidInfo = item.getNativePropertyString(IjkMediaPlayer.FFP_PROP_STRING_TRACEID_RECORD_VIDEO);
        BLog.i(TAG, "[IjkMediaPlayerTracker@0x" + Integer.toHexString(hashCode()) + "]P2PReport: getP2PStreamState cost " + (SystemClock.elapsedRealtime() - startMs) + "ms");
        synchronized (this) {
            try {
                try {
                    if (this.mAssetItemSessionCreateTime > 0) {
                        try {
                            this.mAssetItemTimeOfSession = SystemClock.elapsedRealtime() - this.mAssetItemSessionCreateTime;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    recordTrackerServerHost();
                    this.mP2PStreamState = p2pStreamState;
                    String P2PDownloadBytes = this.mP2PStreamState.get("f142");
                    nP2PDownLoadBytes = P2PDownloadBytes != null ? Long.valueOf(P2PDownloadBytes).longValue() : 0L;
                    String P2PCDNDownloadBytes = this.mP2PStreamState.get("f164");
                    nP2PCDNDownLoadBytes = P2PCDNDownloadBytes != null ? Long.valueOf(P2PCDNDownloadBytes).longValue() : 0L;
                    long totalBytes = this.mAudioReadBytes + this.mVideoReadBytes + nP2PDownLoadBytes;
                    nRate = 0;
                    if (0 < totalBytes) {
                        try {
                            nRate = (int) ((nP2PDownLoadBytes * 100) / totalBytes);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    String AudioValue = this.mP2PStreamState.get("f216");
                    long nP2PAudioDownloadBytes = AudioValue != null ? Long.valueOf(AudioValue).longValue() : 0L;
                    long nAudioReadBytes = this.mAudioReadBytes + nP2PAudioDownloadBytes;
                    int nAudioRate = 0 < nAudioReadBytes ? (int) ((nP2PAudioDownloadBytes * 100) / nAudioReadBytes) : 0;
                    long nP2PVideoDownloadBytes = nP2PDownLoadBytes - nP2PAudioDownloadBytes;
                    long nVideoReadBytes = this.mVideoReadBytes + nP2PVideoDownloadBytes;
                    int nVideoRate = 0;
                    if (0 < nVideoReadBytes) {
                        nVideoRate = (int) ((100 * nP2PVideoDownloadBytes) / nVideoReadBytes);
                    }
                    BLog.i(TAG, "p2p rate:" + nRate + ",audio rate:" + nAudioRate + ",video rate:" + nVideoRate + " p2p_download_size :" + nP2PDownLoadBytes + " p2p_cdn_download_size :" + nP2PCDNDownLoadBytes);
                    ijktrackerReport(0, BLIJK_EV_P2P_STATUS);
                } catch (Throwable th4) {
                    th = th4;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public synchronized void assetChangeBuild(IjkMediaPlayerItem item, IjkAssetUpdateReason reason, long timestamp, long duration, int error) {
        if (item != null) {
            if (this.mMode != 0) {
                this.mChangeAssetReason = reason.getReason();
                if (error == -1 && duration < PlayerToastConfig.DURATION_5) {
                    this.mChangeAssetError = 0;
                } else {
                    this.mChangeAssetError = error;
                }
            }
        }
    }

    public synchronized void initTrackFromCurPlayer(IjkMediaPlayerTracker dst) {
        dst.mPlayerSessionCreateTime = this.mPlayerSessionCreateTime;
        dst.mItemPlay = this.mItemPlay;
    }

    private String GetThreadMapString(HashMap<String, Integer> threadMap) {
        int allNum = 0;
        String moduleString = "{";
        for (Map.Entry<String, Integer> entry : threadMap.entrySet()) {
            long count = entry.getValue().intValue();
            allNum = (int) (allNum + count);
            moduleString = moduleString + "\"" + String.valueOf(entry.getKey()) + "\":" + String.valueOf(count) + ",";
        }
        if (moduleString.length() > 1) {
            moduleString = moduleString.substring(0, moduleString.length() - 1);
        }
        String moduleString2 = moduleString + "}";
        String ijkMapString = "{\"ijk_all\":" + allNum;
        return ((ijkMapString + ",") + "\"ijk_module_detail\":" + moduleString2) + "}";
    }

    public void UpdateReportPerformance(IjkMediaPlayerItem item) {
        IjkMediaPlayerItem.PerformanceTracker ijkPerformance = item.GetPerformance(IjkMediaPlayerItem.IJK_PROCESS);
        IjkMediaPlayerItem.PerformanceTracker mainPerformance = item.GetPerformance(IjkMediaPlayerItem.MAIN_PROCESS);
        this.mIjkProcessCpu = (int) ijkPerformance.cpu;
        this.mIijkProcessThread = ijkPerformance.thread;
        this.mIjkProcessMem = ijkPerformance.mem;
        this.mIjkProcessThreadMap = GetThreadMapString(ijkPerformance.threadMap);
        String ijkDetail = "\"cpu\":" + this.mIjkProcessCpu + ",\"thread\":" + this.mIijkProcessThread + ",\"mem\":" + this.mIjkProcessMem + ",\"threadMap\":" + this.mIjkProcessThreadMap;
        this.mMainProcessCpu = (int) mainPerformance.cpu;
        this.mMainProcessThread = mainPerformance.thread;
        this.mMainProcessMem = mainPerformance.mem;
        this.mMainProcessThreadMap = GetThreadMapString(mainPerformance.threadMap);
        String mainDetail = "\"cpu\":" + this.mMainProcessCpu + ",\"thread\":" + this.mMainProcessThread + ",\"mem\":" + this.mMainProcessMem + ",\"threadMap\":" + this.mMainProcessThreadMap;
        this.mEndBatteryLevel = item.GetCurBatteryLevel();
        String batteryDetail = "\"startBattery\":" + this.mStartBatteryLevel + ",\"endBattery\":" + this.mEndBatteryLevel;
        BLog.i("life.event", "{\"type\":\"[PlayRecordDetail] ijk_apm\",\"event_details\":{\"IjkProcess\":{" + ijkDetail + "},\"MainProcess\":{" + mainDetail + "},\"BatteryInfo\":{" + batteryDetail + "}}}");
    }

    public void updateUrl(String url, int isAudio) {
        if (isAudio != 0) {
            this.mAudioUrl = url;
            this.mAudioHost = IjkUtils.getUrlHost(this.mAudioUrl);
            return;
        }
        this.mVideoUrl = url;
        this.mVideoHost = IjkUtils.getUrlHost(this.mVideoUrl);
    }

    public void playerComplete(boolean isComplete) {
        this.mIsPlayComplete = isComplete ? 1 : 0;
    }

    public void updatePlayerState(long javaError, long ijkInitTime) {
        this.mJavaError = javaError;
        this.mIjkserviceInitTime = ijkInitTime;
    }

    public void recordHasAnr() {
        this.mHasAnr = true;
    }

    public void recordIjkProcessError() {
        this.mHasIjkProcessError = true;
    }

    private void updateVideoUrl() {
        String url = this.mVideoUrl == null ? "" : this.mVideoUrl;
        String[] split = url.split("\\?");
        this.mCleanVideoUrl = split.length > 0 ? split[0] : "";
        String[] split2 = this.mCleanVideoUrl.split("://");
        this.mStreamType = split2.length > 0 ? split2[0] : "";
        if (this.mIsLive) {
            String[] split3 = this.mCleanVideoUrl.split("\\.");
            String ext = split3.length > 0 ? split3[split3.length - 1] : "";
            if (ext.equals("m3u8")) {
                this.mMuxer = "hls";
                return;
            } else {
                this.mMuxer = ext;
                return;
            }
        }
        switch (this.mFormat) {
            case 1:
                this.mMuxer = "mp4";
                return;
            case 2:
                this.mMuxer = "flv";
                return;
            case 3:
                this.mMuxer = "dash";
                return;
            case 4:
                this.mMuxer = "hls";
                return;
            default:
                this.mMuxer = "";
                return;
        }
    }

    private void updateAudioUrl() {
        String url = this.mAudioUrl == null ? "" : this.mAudioUrl;
        String[] split = url.split("\\?");
        if (split.length > 0) {
            this.mCleanAudioUrl = split[0];
        } else {
            this.mCleanAudioUrl = "";
        }
    }

    private void recordNetState(String url, boolean isAudio, int httpCode, int error) {
        updateUrl(url, isAudio ? 1 : 0);
        if (httpCode >= 400) {
            error = -httpCode;
        }
        if (isAudio) {
            if (httpCode > 0) {
                this.mAudioHttpCode = httpCode;
            }
            this.mAudioNetError = error;
            if (error < 0) {
                this.mLastAudioNetError = error;
            }
            updateAudioUrl();
            return;
        }
        if (httpCode > 0) {
            this.mVideoHttpCode = httpCode;
        }
        this.mVideoNetError = error;
        if (error < 0) {
            this.mLastVideoNetError = error;
        }
        updateVideoUrl();
    }

    public void addUpAssetChange() {
        this.mAssetUpdateCount++;
    }

    public void addAssetUpdateTime(long costTime) {
        this.mAssetUpdateTime += costTime;
    }

    public void setUrlInfo(int ret) {
        this.mUrlInfo = ret;
    }

    public void setFileFormat(long format) {
        this.mFormat = (int) format;
    }

    public void setCurQn(int curVideoId, int curAudioId) {
        if (curVideoId > 0) {
            this.mDashCurQn = curVideoId;
        }
        if (curAudioId > 0) {
            this.mAudioId = curAudioId;
        }
    }

    public int getCurVideoId() {
        return this.mDashCurQn;
    }

    public int getCurAudioId() {
        return this.mAudioId;
    }

    public void setItemPlay(int itemPlay) {
        this.mItemPlay = itemPlay;
    }

    public void addSwitchOnInfo(String switchName, int switchOpenType) {
        if (switchOpenType >= 1) {
            if (this.mSwitchOnInfo.length() > 0) {
                this.mSwitchOnInfo += EntryScannerKt.PATH_SEPARATOR;
            }
            this.mSwitchOnInfo += switchName;
            if (switchOpenType > 1) {
                this.mSwitchOnInfo += ":" + switchOpenType;
            }
        }
    }

    public void setSupportWidevineType(int type) {
        this.mSupportWidevineType = type;
    }

    public void setDrmType(int drmType) {
        this.mDrmType = drmType;
    }

    public void setEnhanceType(int enhanceType) {
        this.mEnhanceType = enhanceType;
    }

    private void recordUserPlayPrefer() {
        this.mStoryMode = AbrParamsInterface.getUserPlayPrefer();
    }

    public void setItemMaxQn(int maxQn) {
        this.mItemMaxQn = maxQn;
    }

    private void recordUserQn() {
        this.mUserQn = AbrParamsInterface.getUserQn();
    }

    private void recordAutoMaxQn() {
        this.mAutoMaxQn = AbrParamsInterface.getMaxQn();
    }

    public void setScreenState(int screenState) {
        if (this.mScreenState == screenState) {
            return;
        }
        if (screenState == 1) {
            startSSTimer();
        }
        if (this.mScreenState == -1 || screenState != 0) {
            this.mScreenState = screenState;
        }
    }

    public void startSSTimer() {
        if (this.mSSTimer != null) {
            return;
        }
        this.mSSTimer = new Timer("IjkScreenState");
        this.mSSTimer.schedule(new TimerTask() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayerTracker.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IjkMediaPlayerTracker.this.reportScreenState();
            }
        }, PlayerToastConfig.DURATION_10);
    }

    public void cancelSSTimer() {
        if (this.mSSTimer == null) {
            return;
        }
        this.mSSTimer.cancel();
        this.mSSTimer = null;
    }

    public synchronized void reportScreenState() {
        if (this.mAssetSessionCreateTime > 0 && this.mMode != 0) {
            long currentTime = SystemClock.elapsedRealtime();
            if (this.mAssetItemSessionCreateTime > 0) {
                this.mAssetItemTimeOfSession = currentTime - this.mAssetItemSessionCreateTime;
            }
            trackerReport(true, getSimplyEventId(BLIJK_EV_ROTATE_QUALITY), getSimplyExtensions(0, BLIJK_EV_ROTATE_QUALITY));
            cancelSSTimer();
        }
    }

    public void recordMaxAndMinQn(int maxQuality, int minQuality) {
        if (maxQuality > this.mMaxQn) {
            this.mMaxQn = maxQuality;
        }
        if (minQuality < this.mMinQn) {
            this.mMinQn = minQuality;
        }
    }

    public void recordRecommendedMaxQn(int recommendedMaxQn) {
        this.mRecommendedMaxQn = recommendedMaxQn;
    }

    public void setQnDuration(int qnBeforeSwitch, long timestamp) {
        if (this.mCurrentQnStartTime <= 0) {
            return;
        }
        long duration = timestamp - this.mCurrentQnStartTime;
        switch (qnBeforeSwitch) {
            case 16:
                this.mDuration360p += duration;
                return;
            case 32:
                this.mDuration480p += duration;
                return;
            case 64:
                this.mDuration720p += duration;
                return;
            case 80:
                this.mDuration1080p += duration;
                return;
            default:
                this.mDurationOthers += duration;
                return;
        }
    }

    public void ijkThroughputStatistic(int[] speed, int[] duration, int num) {
        for (int index = 0; index < num; index++) {
            int timedelta = duration[index] / 10;
            byte[] hexContent = new byte[3];
            hexContent[0] = (byte) ((65280 & timedelta) >> 8);
            hexContent[1] = (byte) (timedelta & 255);
            int speedHigh = speed[index] / PersonInfoLoadFragment.ERROR_CODE_MODIFY_FORBIDDEN;
            if (speedHigh < 200) {
                int speedLow = speedHigh >> 1;
                hexContent[2] = (byte) (hexContent[2] | speedLow);
            } else if (speedHigh >= 200 && speedHigh <= 900) {
                int speedLow2 = (speedHigh - 200) / 10;
                hexContent[2] = (byte) (speedLow2 | 128);
            } else {
                hexContent[2] = -1;
            }
            StringBuilder buf = new StringBuilder(hexContent.length * 2);
            for (byte b : hexContent) {
                buf.append(String.format("%02x", new Integer(b & 255)));
            }
            this.mThroughputSpeed += buf.toString();
        }
    }

    public float getQoeByQn(int targetQn) {
        switch (targetQn) {
            case 16:
                return 56.0f;
            case 32:
                return 73.8f;
            case 64:
                return 79.6f;
            default:
                return 81.5f;
        }
    }

    private float getMinuteBufferCount() {
        float playTimeInMinute = ((float) (SystemClock.elapsedRealtime() - this.mAssetItemSessionCreateTime)) / 60000.0f;
        if (this.mAssetItemSessionCreateTime <= 0 || playTimeInMinute <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        int bufferCount = this.mBufferingCount;
        return bufferCount / playTimeInMinute;
    }

    private long getNetError() {
        long netError = this.mVideoNetError;
        if (netError >= 0) {
            return this.mAudioNetError;
        }
        return netError;
    }

    private String getAbrTypeName() {
        return "pensieve";
    }

    public int getBufferCountWithDuration(long timestamp) {
        int bufferCountWithDuration = 0;
        for (int index = 0; index < 10; index++) {
            if (timestamp - this.mBufferingEndTimestamp[index] < 30000) {
                bufferCountWithDuration++;
            } else {
                this.mBufferingEndTimestamp[index] = 0;
            }
        }
        return bufferCountWithDuration;
    }

    public void recordBufferEndTimestamp(long timestamp) {
        int baseIndex = 0;
        for (int index = 0; index < 10; index++) {
            if (this.mBufferingEndTimestamp[index] < this.mBufferingEndTimestamp[baseIndex]) {
                baseIndex = index;
            }
        }
        this.mBufferingEndTimestamp[baseIndex] = timestamp;
    }

    public float getBufferTime(long timestamp) {
        if (((float) this.mWillPrerollTime) > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && this.mLastBufferingStartQoe > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            float bufferTimedelta = ((float) (timestamp - this.mWillPrerollTime)) / 1000.0f;
            if (bufferTimedelta > 0.2f) {
                return bufferTimedelta;
            }
        }
        return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }

    public float getBufferPunish(long timestamp, float bufferTime) {
        float bufferTimePunish;
        float bufferCountPunish;
        long playTimedelta = (this.mWillPrerollTime - this.mAssetItemSessionCreateTime) / 1000;
        if (bufferTime == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || (playTimedelta <= 1 && bufferTime <= 3.0f)) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        if (bufferTime <= 3.0f) {
            bufferTimePunish = (1.62f * bufferTime) + 3.24f;
        } else {
            bufferTimePunish = 2.7f * bufferTime;
        }
        int bufferCountWithDuration = getBufferCountWithDuration(timestamp) + 1;
        if (bufferCountWithDuration <= 2) {
            bufferCountPunish = bufferCountWithDuration * 3.12f;
        } else {
            bufferCountPunish = bufferCountWithDuration * 2.16f;
        }
        return bufferTimePunish + bufferCountPunish;
    }

    public float getRecoverQoe(long timestamp) {
        float qoeByCurQn = getQoeByQn(this.mDashCurQn);
        long timedelta = (timestamp - this.mLastEventTimestamp) / 1000;
        if (timedelta < 30 && Math.abs(qoeByCurQn - this.mCurQoe) > 1.0f) {
            float powValue = (float) Math.pow(0.8999999761581421d, timedelta);
            return (this.mCurQoe * powValue) + ((1.0f - powValue) * qoeByCurQn);
        }
        return qoeByCurQn;
    }

    public void recordPlayStatus(long timestamp, int currentEvent, float curQoe, float bufferTime) {
        if ((currentEvent == 1023 || currentEvent == 2011 || currentEvent == 2014) && bufferTime > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            recordBufferEndTimestamp(timestamp);
            this.mLastBufferingStartQoe = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        } else if (currentEvent == 1022) {
            this.mLastBufferingStartQoe = this.mCurQoe;
        }
        this.mLastEventTimestamp = timestamp;
    }

    public void getCurQoe(long timestamp, int currentEvent) {
        float bufferTime = getBufferTime(timestamp);
        float bufferPunish = getBufferPunish(timestamp, bufferTime);
        if (bufferPunish > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            this.mCurQoe = Math.max((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, this.mLastBufferingStartQoe - bufferPunish);
        } else {
            this.mCurQoe = getRecoverQoe(timestamp);
        }
        recordPlayStatus(timestamp, currentEvent, this.mCurQoe, bufferTime);
    }

    public void setSwitchNonAutoTargetQn(int qn) {
        this.mSwitchNonAutoTargetQn = qn;
    }

    public void setExpectLatency(int latency, int enableSkipFrame, int enableJitterBuffer) {
        this.mExpectLatency = latency;
        this.mEnableSkipFrame = enableSkipFrame;
        this.mEnableJitterBuffer = enableJitterBuffer;
    }

    public void updateIjkStatus(IjkStatus ijkStatus) {
        ijkStatus.playbackStrategy.enableJitterBuffer = this.mIsAbleLowLatency == 1 && this.mEnableJitterBuffer == 1;
        ijkStatus.playbackStrategy.enableSkipFrame = this.mIsAbleLowLatency == 1 && this.mEnableSkipFrame == 1;
        ijkStatus.playbackStrategy.enableAbr = this.mDashAuto == 1;
        ijkStatus.playbackStrategy.abrType = getAbrTypeName();
        ijkStatus.playbackStrategy.abrSwitchHighCount = this.mSwitchHigherBitrateCount;
        ijkStatus.playbackStrategy.abrSwitchLowCount = this.mSwitchLowerBitrateCount;
        ijkStatus.firstPlayInfo.renderFirstVideoTime = this.mFirstVideoTime;
        ijkStatus.firstPlayInfo.networkFirstFrameTime = this.mFirstVideoRecvPacketTimestamp - this.mFirstVideoWillHttpTimestamp;
        ijkStatus.streamInfo.streamType = this.mStreamType;
        ijkStatus.streamInfo.muxer = this.mMuxer;
        ijkStatus.streamInfo.videoUrl = this.mCleanVideoUrl;
        ijkStatus.streamInfo.audioUrl = this.mCleanAudioUrl;
        ijkStatus.playbackInfo.minuteBufferCount = getMinuteBufferCount();
        ijkStatus.playbackInfo.lastestNetError = getNetError();
    }

    public void setStartNetwork(int network) {
        this.mStartNetwork = network;
    }

    public void addNetworkChange() {
        this.mNetworkChangeCount++;
    }

    public void recordPause() {
        this.mLastPauseTimestamp = SystemClock.elapsedRealtime();
        this.mPauseCount++;
    }

    public void setIsAbleLowLatency(int isAbleLowLatency) {
        this.mIsAbleLowLatency = isAbleLowLatency;
    }

    public void recordTrackerServerHost() {
        if (GrpcClient.getInstance() != null) {
            if (this.mMode == 2) {
                this.mTrackerServerHost = GrpcClient.getInstance().getLiveTrackerServerHost();
            } else {
                this.mTrackerServerHost = GrpcClient.getInstance().getTrackerServerHost();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackerReport(boolean force, String simplyEventId, Map<String, String> simplyExtensions) {
        if (this.mOnTrackerListener != null) {
            this.mOnTrackerListener.onTrackerReport(force, simplyEventId, simplyExtensions);
        }
    }

    private HashMap<String, String> convertP2PStreamStateToSimply(HashMap<String, String> state) {
        HashMap<String, String> ret = new HashMap<>();
        if (state == null) {
            return ret;
        }
        for (String key : state.keySet()) {
            String keyValue = mP2PKeyMap.get(key);
            if (keyValue != null) {
                ret.put(keyValue, state.get(key));
            }
        }
        return ret;
    }

    public String getLastUrl(boolean isAudio) {
        if (isAudio) {
            return this.mAudioUrl;
        }
        return this.mVideoUrl;
    }

    public int getBitrate(boolean isAudio) {
        if (isAudio) {
            return this.mAudioBitrate;
        }
        return this.mVideoBitrate;
    }

    public void setPlaybackState(int state) {
        if (this.mLiveHeartbeat != null) {
            this.mLiveHeartbeat.mPlaybackState = state;
        }
    }

    public void setDefaultCodecName(String defaultCodecName) {
        this.mDefaultCodecName = defaultCodecName;
    }
}