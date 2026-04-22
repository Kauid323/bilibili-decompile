package tv.danmaku.ijk.media.player;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerService;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkPerformanceManager;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;
import tv.danmaku.ijk.media.player.render.IjkExternalRenderThread;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender;
import tv.danmaku.ijk.media.player.services.IjkMediaPlayerNoUIActivity;
import tv.danmaku.ijk.media.player.services.IjkMediaPlayerService;
import tv.danmaku.ijk.media.player.utils.IjkAudioKit;
import tv.danmaku.ijk.media.player.utils.IjkMediaPlayerMonitor;
import tv.danmaku.ijk.media.player.utils.IjkUtils;
import video.biz.offline.list.logic.tree.VideoFile;

public final class IjkMediaPlayer extends AbstractMediaPlayer {
    public static final long AUDIO_STREAM_ERROR_FILESIZE_INVALID = 65536;
    public static final int BUFFER_CONTROL_LIMITED = 1;
    public static final int BUFFER_CONTROL_UNKNOWN = 0;
    private static final int DO_CHECK_CONNECT = 0;
    private static final int DO_CREATE = 1;
    private static final int DO_MSG_SAVE = 25;
    private static final int DO_NATIVEFINALIZE = 21;
    private static final int DO_NATIVEPROFILEBEGIN = 22;
    private static final int DO_NATIVEPROFILEEND = 23;
    private static final int DO_NATIVESETLOGLEVEL = 24;
    private static final int DO_PAUSE = 5;
    private static final int DO_PREPAREASYNC = 2;
    private static final int DO_RELEASE = 4;
    private static final int DO_RESET = 6;
    private static final int DO_SAMPLECPUMEM = 35;
    private static final int DO_SEEKTO = 14;
    private static final int DO_SETANDROIDIOCALLBACK = 26;
    private static final int DO_SETDASHAUTO = 30;
    private static final int DO_SETDATASOURCE = 9;
    private static final int DO_SETDATASOURCEBASE64 = 10;
    private static final int DO_SETDATASOURCEFD = 12;
    private static final int DO_SETDATASOURCEKEY = 11;
    private static final int DO_SETIJKMEDIAPLAYERITEM = 32;
    private static final int DO_SETLOOPCOUNT = 15;
    private static final int DO_SETOPTIONLONG = 20;
    private static final int DO_SETOPTIONSTRING = 19;
    private static final int DO_SETPROPERTYFLOAT = 16;
    private static final int DO_SETPROPERTYLONG = 17;
    private static final int DO_SETSTREAMSELECTED = 13;
    private static final int DO_SETSURFACE = 8;
    private static final int DO_SETVOLUME = 18;
    private static final int DO_START = 3;
    private static final int DO_STARTIJK = 34;
    private static final int DO_STOP = 7;
    private static final int DO_SWITCHDASHAUDIOSTREAM = 29;
    private static final int DO_SWITCHDASHVIDEOSTREAM = 28;
    public static final int DRM_EVENT_CLOSE = 1;
    public static final int DRM_EVENT_OPEN = 0;
    private static final long EAC3_ENDPOINT_HEADPHONE = 2;
    private static final long EAC3_ENDPOINT_SPEAKER = 1;
    public static final int FFP_BUFFERING_END_REASON_COMPLETED = 260;
    public static final int FFP_BUFFERING_END_REASON_ENOUGH_DURATION = 258;
    public static final int FFP_BUFFERING_END_REASON_ENOUGH_PACKETS = 259;
    public static final int FFP_BUFFERING_END_REASON_ENOUGH_SIZE = 257;
    public static final int FFP_BUFFERING_END_REASON_FIRST_PLAY = 261;
    public static final int FFP_BUFFERING_END_REASON_UNKNOWN = 256;
    public static final int FFP_BUFFERING_START_REASON_BITRATE_HIGHER = 9;
    public static final int FFP_BUFFERING_START_REASON_LOW_PERFORMANCE = 12;
    public static final int FFP_BUFFERING_START_REASON_NETWORK_ERROR = 10;
    public static final int FFP_BUFFERING_START_REASON_SEEK = 1;
    public static final int FFP_BUFFERING_START_REASON_SWITCH_ITEM = 2;
    public static final int FFP_BUFFERING_START_REASON_TCP_READ_TIMEOUT = 7;
    public static final int FFP_BUFFERING_START_REASON_TCP_SPEED_LOW = 8;
    public static final int FFP_BUFFERING_START_REASON_UNKNOW = 6;
    public static final int FFP_BUFFERING_START_REASON_VDECODEC_ERROR = 11;
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_BUNDLE_P2P_STREAM_STATE = 40000;
    public static final int FFP_PROP_FLOAT_AVDIFF = 10005;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_MAX_SPEED = 10011;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_FLOAT_VIDEO_FPS = 10009;
    public static final int FFP_PROP_INT64_ACTUAL_PLAYBACK_DURATION = 20288;
    public static final int FFP_PROP_INT64_ALIVE_ITEM_NUM = 20502;
    public static final int FFP_PROP_INT64_ALIVE_PLAYER_NUM = 20504;
    public static final int FFP_PROP_INT64_ANALYSIS_INTERNAL_PROPOSE = 20290;
    public static final int FFP_PROP_INT64_ANALYSIS_USER_PROPOSE = 20289;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_CONSUME_BYTES = 20264;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_AUDIO_DNS_TIME = 20301;
    public static final int FFP_PROP_INT64_AUDIO_ONLY = 20232;
    public static final int FFP_PROP_INT64_AUDIO_TCP_TIME = 20307;
    public static final int FFP_PROP_INT64_AUDIO_TP_ERROR = 20503;
    public static final int FFP_PROP_INT64_AVE_NETWORK_SPEED = 20267;
    public static final int FFP_PROP_INT64_AV_UNSYNC_COUNT = 20506;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_BUFFERING_AUDIO_CACHED_PACKETS = 20226;
    public static final int FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_DURATION = 20221;
    public static final int FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_PACKETS = 20225;
    public static final int FFP_PROP_INT64_BUFFER_CTRL = 30003;
    public static final int FFP_PROP_INT64_CACHE_AUDIO_BITRATE = 20283;
    public static final int FFP_PROP_INT64_CACHE_CUR_BITRATE = 20218;
    public static final int FFP_PROP_INT64_CACHE_CUR_STABLE_SPEED = 20219;
    public static final int FFP_PROP_INT64_CACHE_CUR_TCP_SPEED = 20220;
    public static final int FFP_PROP_INT64_CACHE_VIDEO_BITRATE = 20282;
    public static final int FFP_PROP_INT64_CACHE_WAVE_RANGE = 20284;
    public static final int FFP_PROP_INT64_CURRENT_PLAY_RATE = 20242;
    public static final int FFP_PROP_INT64_CURRENT_POSITION = 20251;
    public static final int FFP_PROP_INT64_CUR_BUF_CACHE_TIME = 20266;
    public static final int FFP_PROP_INT64_CUR_PLAYABLE_CACHE_TIME = 20279;
    public static final int FFP_PROP_INT64_DASH_AUDIO_TCP_SPEED = 20233;
    public static final int FFP_PROP_INT64_DASH_CUR_AUDIO_ID = 20262;
    public static final int FFP_PROP_INT64_DASH_CUR_VIDEO_ID = 20250;
    public static final int FFP_PROP_INT64_DASH_VIDEO_TCP_SPEED = 20234;
    public static final int FFP_PROP_INT64_EAC3_DIALOG_ENHANCEMENT_GAIN = 30202;
    public static final int FFP_PROP_INT64_EAC3_ENDPOINT = 30200;
    public static final int FFP_PROP_INT64_EAC3_MAIN_ASSO_PREF = 30205;
    public static final int FFP_PROP_INT64_EAC3_OUTPUT_REFERENCE_LEVEL = 30203;
    public static final int FFP_PROP_INT64_EAC3_PRESENTATION_ID = 30204;
    public static final int FFP_PROP_INT64_EAC3_VIRTUALIZER_ONOFF = 30201;
    public static final int FFP_PROP_INT64_ENABLE_VIDEO_DISPLAY_CALLBACK = 40003;
    public static final int FFP_PROP_INT64_FILE_TYPE = 30100;
    public static final int FFP_PROP_INT64_FIRST_PKG_GET_TRACKER = 20240;
    public static final int FFP_PROP_INT64_FIRST_VIDEO_DID_FIND_STREAM_TIMESTAMP = 20274;
    public static final int FFP_PROP_INT64_FIRST_VIDEO_DID_HTTP_TIMESTAMP = 20272;
    public static final int FFP_PROP_INT64_FIRST_VIDEO_WILL_FIND_STREAM_TIMESTAMP = 20273;
    public static final int FFP_PROP_INT64_FIRST_VIDEO_WILL_HTTP_TIMESTAMP = 20271;
    public static final int FFP_PROP_INT64_HAS_VIDEO_STREAM = 30101;
    public static final int FFP_PROP_INT64_HLS_MAX_UPDATE_DURATION = 20281;
    public static final int FFP_PROP_INT64_HLS_START_SEQ_COUNT = 20293;
    public static final int FFP_PROP_INT64_HTTP_BY_FFMPEG = 20501;
    public static final int FFP_PROP_INT64_IS_SOCKET_REUSE = 20305;
    public static final int FFP_PROP_INT64_ITEM_ERROR_CODE = 20248;
    public static final int FFP_PROP_INT64_ITEM_ERROR_CODE_WITH_LOG = 20252;
    public static final int FFP_PROP_INT64_ITEM_OPEN_STATUS = 20299;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LIVE_DELAY = 20287;
    public static final int FFP_PROP_INT64_MEDIACODEC_OPEN_TIME = 20500;
    public static final int FFP_PROP_INT64_NETWORK_LEVEL = 20294;
    public static final int FFP_PROP_INT64_NETWORK_WAVE = 20268;
    public static final int FFP_PROP_INT64_P2P_CDN_DOWNLOAD_SIZE = 20601;
    public static final int FFP_PROP_INT64_P2P_DOWNLOAD_SIZE = 20600;
    public static final int FFP_PROP_INT64_P2P_TCP_DOWNLOAD_SIZE = 20602;
    public static final int FFP_PROP_INT64_PLAYER_ERROR_CODE = 20245;
    public static final int FFP_PROP_INT64_PLAYER_ERROR_CODE_WITH_LOG = 20253;
    public static final int FFP_PROP_INT64_PLAYER_STATUS = 20247;
    public static final int FFP_PROP_INT64_PLAY_START_TIMESTAMP = 20308;
    public static final int FFP_PROP_INT64_REAL_CURRENT_POSITION = 20241;
    public static final int FFP_PROP_INT64_RECOMMENDED_QN = 20507;
    public static final int FFP_PROP_INT64_RENDERING_STUCK_COUNT = 20285;
    public static final int FFP_PROP_INT64_RENDERING_STUCK_DURATION = 20286;
    public static final int FFP_PROP_INT64_RENDERING_STUCK_REASON = 20309;
    public static final int FFP_PROP_INT64_REVC_VIDEO_FIRST_PACKET_TIMESTAMP = 20260;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SET_AUDIO_ONLY_COUNT = 20291;
    public static final int FFP_PROP_INT64_SKIP_FRAME_COUNT = 20280;
    public static final int FFP_PROP_INT64_SOCKET_NUM = 20304;
    public static final int FFP_PROP_INT64_SOFT_ACTIVATION = 20700;
    public static final int FFP_PROP_INT64_SOFT_DECODE_FRAME_COUNT = 20505;
    public static final int FFP_PROP_INT64_STREAM_RESET_REASON = 20278;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_BYTE_COUNT = 20235;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_MCDN_BYTE_COUNT = 30005;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_BYTE_COUNT = 20236;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_MCDN_BYTE_COUNT = 30006;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_MCDN_BYTE_COUNT = 30004;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_CONSUME_BYTES = 20265;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int FFP_PROP_INT64_VIDEO_DNS_TIME = 20300;
    public static final int FFP_PROP_INT64_VIDEO_FIRST_FRAME_DECODED_TIMESTAMP = 20275;
    public static final int FFP_PROP_INT64_VIDEO_FIRST_FRAME_RENDER_TIMESTAMP = 20276;
    public static final int FFP_PROP_INT64_VIDEO_TCP_TIME = 20306;
    public static final int FFP_PROP_STRING_MIN_SPEED_RECORD = 40006;
    public static final int FFP_PROP_STRING_P2P_MANUSCRIPT_INFO = 40001;
    public static final int FFP_PROP_STRING_TRACEID_RECORD_AUDIO = 40005;
    public static final int FFP_PROP_STRING_TRACEID_RECORD_VIDEO = 40004;
    public static final int IJKAVERROR_FREE_URL_UNREACHABLE = -1431652088;
    public static final int IJKAVERROR_HTTP_RESPONSE_INVALID = -1230129400;
    public static final int IJK_ANALYSIS_PROPOSE_INTERNAL_PLAYER_PROCESS_ERROR = 301;
    public static final int IJK_ANALYSIS_PROPOSE_NULL = 0;
    public static final int IJK_ANALYSIS_PROPOSE_USER_PROCESS_ERROR = 104;
    private static final int IJK_ANR_RESET_DELAY = 5100;
    public static final int IJK_COLOR_RANGE_FULL = 1;
    public static final int IJK_COLOR_RANGE_LIMITED = 2;
    public static final int IJK_COLOR_RANGE_UNDEF = 0;
    public static final int IJK_COLOR_SPACE_BT2020 = 3;
    public static final int IJK_COLOR_SPACE_BT601 = 1;
    public static final int IJK_COLOR_SPACE_BT709 = 2;
    public static final int IJK_COLOR_SPACE_UNDEF = 0;
    public static final int IJK_COLOR_TRANSFER_BT470_BG = 3;
    public static final int IJK_COLOR_TRANSFER_BT470_M = 4;
    public static final int IJK_COLOR_TRANSFER_BT709 = 5;
    public static final int IJK_COLOR_TRANSFER_HLG = 8;
    public static final int IJK_COLOR_TRANSFER_LINEAR = 1;
    public static final int IJK_COLOR_TRANSFER_SMPTE_240 = 7;
    public static final int IJK_COLOR_TRANSFER_SMPTE_ST2084 = 6;
    public static final int IJK_COLOR_TRANSFER_SRGB = 2;
    public static final int IJK_COLOR_TRANSFER_UNDEF = 0;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    public static final long IJK_SERVICE_ERROR_BASE = 1152921504606846976L;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_DATASOURCE_CHANGED = 10002;
    private static final int MEDIA_DECODER_SWITCH = 10100;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PLAYER_CLOCK_CHANGE = 300;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_SWITCH_SOURCE = 10101;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int MSG_ERROR_ILLEGAL_PREPARE = 10010;
    public static final long NETWORK_ERROR_DNS_BLOCK = 2;
    public static final long NETWORK_ERROR_DNS_FAIL = 3;
    public static final long NETWORK_ERROR_DNS_TIMEOUT = 4;
    public static final long NETWORK_ERROR_HTTP_BAD_REQUEST = 19;
    public static final long NETWORK_ERROR_HTTP_BUILD_UNFINISHED = 14;
    public static final long NETWORK_ERROR_HTTP_FORBIDDEN = 15;
    public static final long NETWORK_ERROR_HTTP_NOT_FOUND = 16;
    public static final long NETWORK_ERROR_HTTP_OTHER_4XX = 17;
    public static final long NETWORK_ERROR_HTTP_SERVER_ERROR = 18;
    public static final long NETWORK_ERROR_HTTP_UNAUTHORIZED = 20;
    public static final long NETWORK_ERROR_IJK_SERVICE_ANR = 61;
    public static final long NETWORK_ERROR_IJK_SERVICE_CANT_RUN = 60;
    public static final long NETWORK_ERROR_ITEM_EXIT = 62;
    public static final long NETWORK_ERROR_ITEM_EXIT_AUDIO_FILESIZE_INVALID = 64;
    public static final long NETWORK_ERROR_ITEM_EXIT_VIDEO_FILESIZE_INVALID = 63;
    public static final long NETWORK_ERROR_LINUX_ECONNABORTED = 40;
    public static final long NETWORK_ERROR_LINUX_ECONNREFUSED = 42;
    public static final long NETWORK_ERROR_LINUX_ECONNRESET = 45;
    public static final long NETWORK_ERROR_LINUX_EHOSTUNREACH = 44;
    public static final long NETWORK_ERROR_LINUX_EIO = 43;
    public static final long NETWORK_ERROR_LINUX_ENETUNREACH = 41;
    public static final long NETWORK_ERROR_MAX = 255;
    public static final long NETWORK_ERROR_NO_ITEM_OR_URL = 1;
    public static final long NETWORK_ERROR_OPEN_INPUT_UNFINISHED = 21;
    public static final long NETWORK_ERROR_OTHER = 99;
    public static final long NETWORK_ERROR_PLAYER_GET_PKT_NO_RENDER = 30;
    public static final long NETWORK_ERROR_TCP_CONNECT_BLOCK = 6;
    public static final long NETWORK_ERROR_TCP_CONNECT_TIMEOUT = 5;
    public static final long NETWORK_ERROR_TCP_DASH_AUDIO_NO_SPEED = 9;
    public static final long NETWORK_ERROR_TCP_DASH_VIDEO_NO_SPEED = 10;
    public static final long NETWORK_ERROR_TCP_LOW_SPEED = 8;
    public static final long NETWORK_ERROR_TCP_READ_TIMEOUT = 7;
    public static final long NETWORK_ERROR_UNKNOW = 100;
    private static final int NOTIFY_ONNATIVEINVOKE = 27;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int POWER_MODE_LOW_POWER = 1;
    public static final int POWER_MODE_PERFORMANCE = 0;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final int START_IJK_TIMEOUT = 8000;
    public static final long VIDEO_STREAM_ERROR_FILESIZE_INVALID = 4096;
    public static final long VIDEO_STREAM_ERROR_ITEM_EXIT = 512;
    private IjkPerformanceManager.SampleValue ijkSamplePerfromance;
    private boolean isPlaybackComplete;
    private boolean isPrepared;
    private int mBufferControl;
    private IjkMediaPlayerBinder mClient;
    private ClocktHandler mClockHandler;
    private Context mContext;
    private Bundle mDashStreamInfo;
    private String mDataSource;
    private Surface mDisplaySurface;
    private long mDuration;
    private boolean mEnableExternalAfterDrm;
    private boolean mEnableExternalRender;
    private boolean mEventFlushRequest;
    private EventHandler mEventHandler;
    private IJKPlayerExternalRender mExternalRenderCallback;
    private IjkExternalRenderThread mExternalRenderThread;
    private long mFirstRemoteExceptionTime;
    private HandlerThread mHandleThread;
    private boolean mHappenAnr;
    private IjkLibLoader mIjkLibLoader;
    private IjkMediaPlayerTracker mIjkMediaPlayerTracker;
    private boolean mIllegalPrepare;
    boolean mIsActivity;
    private boolean mIsDrm;
    private boolean mIsRelease;
    private IjkMediaPlayerItem mItem;
    private OnControlMessageListener mOnControlMessageListener;
    private OnDownloadSeiDataWriteListener mOnDownloadSeiDataWriteListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private OnRawDataWriteListener mOnRawDataWriteListener;
    private OnSeiDataWriteListener mOnSeiDataWriteListener;
    private OnServiceIsConnectedListener mOnServiceIsConnectedListener;
    private OnVideoDisplayCallback mOnVideoDisplayCallback;
    private OnVideoFirstFrameRenderListener mOnVideoFirstFrameRenderListener;
    private IIjkMediaPlayer mPlayer;
    private final Object mRenderLock;
    private boolean mRunning;
    private boolean mScreenOnWhilePlaying;
    private SomeWorkHandler mSomeWorkHandle;
    private boolean mStartNoUiActivity;
    private long mStartTime;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mTotalRemoteExceptionCount;
    private float mVideoFps;
    private String mVideoHWCodecName;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private final ArrayList<Message> mWaitList;
    private PowerManager.WakeLock mWakeLock;
    private IjkPerformanceManager.SampleValue mainSamplePerfromance;
    private boolean tryEnableHdrLater;
    private static final String TAG = IjkMediaPlayer.class.getName();
    private static String sIjkVersion = "";
    public static final IjkMediaPlayerServiceConnection msIjkMediaPlayerServiceConnection = new IjkMediaPlayerServiceConnection();
    public static volatile boolean msIjkserviceIsConnected = false;
    private static long mIjkserviceStartTs = 0;
    private static long mIjkserviceInitTime = 0;
    private static boolean msIjkserviceAbnormal = false;
    private static IAbrParamsInterface msAbrParamsInterface = null;
    private static final int IJK_MIN_PROTECT_DELAY = 5000;
    private static int mIjkProtectDelay = IJK_MIN_PROTECT_DELAY;
    private static IjkMediaPlayer mCurPlayer = null;
    private static IjkStatus mIjkStatus = new IjkStatus();
    private static long mIjkStatusLastUpdateTs = 0;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum LiveSwitchQnMode {
        MODE_DEFAULT,
        MODE_NOAUTO_SEPARATE,
        MODE_NOAUTO_SMOOTH,
        MODE_AUTO
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnDownloadSeiDataWriteListener {
        int onDownloadSeiDataWrite(IMediaPlayer iMediaPlayer, byte[] bArr, int i, long j, long j2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_CODEC_CHANGE_COUNT = "codec_change_count";
        public static final String ARG_DASH_AUTO_SIWTCH = "auto_switch";
        public static final String ARG_DASH_CUR_ID = "cur_id";
        public static final String ARG_DASH_ERROR = "error";
        public static final String ARG_DASH_NEXT_ID = "next_id";
        public static final String ARG_DASH_SWITCH_DURATION = "switch_duration";
        public static final String ARG_DASH_TIMESTAMP = "timestamp";
        public static final String ARG_DASH_TYPE = "type";
        public static final String ARG_DNS_EVENT_TIME = "dns_time";
        public static final String ARG_DNS_HIT_CACHE = "hit_cache";
        public static final String ARG_DNS_HOST = "host";
        public static final String ARG_DNS_IP = "ip";
        public static final String ARG_DNS_IS_IP = "is_ip";
        public static final String ARG_DNS_TIMESTAMP = "timestamp";
        public static final String ARG_DNS_TYPE = "dns_type";
        public static final String ARG_DURATION = "duration";
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_FILE_SIZE = "file_size";
        public static final String ARG_FORMAT_CHANGE_COUNT = "format_change_count";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_HTTP_URL_CHANGE_COUNT = "http_url_change_count";
        public static final String ARG_IP = "ip";
        public static final String ARG_IS_AUDIO = "is_audio";
        public static final String ARG_IS_URL_CHANGED = "is_url_changed";
        public static final String ARG_PORT = "port";
        public static final String ARG_QN = "qn";
        public static final String ARG_QN_CHANGE_COUNT = "qn_change_count";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_SOCKET_REUSE = "socket_reuse";
        public static final String ARG_TCP_RETRY_COUNT = "tcp_retry_count";
        public static final String ARG_THROUGHPUT_DURATION = "throughput_duration";
        public static final String ARG_THROUGHPUT_NUM = "throughput_num";
        public static final String ARG_THROUGHPUT_SPEED = "throughput_speed";
        public static final String ARG_URL = "url";
        public static final String ARG_VIDEO_CODEC_ID = "video_codec_id";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_FILE_IO_OPEN = 131082;
        public static final int CTRL_WILL_FILE_OPEN = 131081;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_IJK_PKG_COUNT_TRACKER = 9;
        public static final int EVENT_THROUGHPUT_STATISTIC = 74247;
        public static final int EVENT_URL_CHANGED = 7;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final String TIMESTAMP = "timestamp";

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnRawDataWriteListener {
        int onRawDataWrite(IMediaPlayer iMediaPlayer, byte[] bArr, int i, int i2, int i3, int i4, int i5);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnSeiDataWriteListener {
        int onSeiDataWrite(IMediaPlayer iMediaPlayer, byte[] bArr, int i, long j, long j2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnServiceIsConnectedListener {
        void onServiceIsConnected(boolean z);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnVideoDisplayCallback {
        int onVideoDisplay(double d, double d2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnVideoFirstFrameRenderListener {
        int onVideoFirstFrameRender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void willReplaceItem(IjkMediaPlayerItem item, long timestamp) {
        if (!this.mIsRelease) {
            item.start();
            if (this.mIjkMediaPlayerTracker != null) {
                IjkMediaPlayerTracker newTracker = item.getIjkMediaPlayerTracker();
                if (newTracker != null) {
                    if (item.isPreload()) {
                        this.mIjkMediaPlayerTracker.setItemPlay(22);
                    } else {
                        this.mIjkMediaPlayerTracker.setItemPlay(2);
                    }
                    this.mIjkMediaPlayerTracker.initTrackFromCurPlayer(newTracker);
                    this.mIjkMediaPlayerTracker = newTracker;
                }
                this.mIjkMediaPlayerTracker.willReplaceItem(this, item, timestamp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRenderStatus(IjkMediaPlayerItem item) {
        if (item != null && this.mEnableExternalRender && this.mExternalRenderCallback != null) {
            if (item.getHDRRenderType() == 1 && item.getHDRVideoType() != 0) {
                disableExternalRender();
            }
            if (item.getHDRVideoType() == 0 && item.getHDRRenderType() == 0) {
                enableExternalRender();
            }
            if (item.getHDRRenderType() == 0 && item.getHDRVideoType() == 6) {
                isHdrVivid(true);
                this.mExternalRenderCallback.setVividDataList(item.getVividDataList());
            } else {
                isHdrVivid(false);
                this.mExternalRenderCallback.flushVividDataList();
            }
        }
        if (item != null && item.getHDRRenderType() == 0 && item.getHDRVideoType() == 3) {
            enableDolbyHDR(item.getDolbyConfigPath());
        } else {
            disableDolbyHDR();
        }
        if (item != null && this.mExternalRenderThread != null) {
            if (item.isEnableAlphaLayer()) {
                this.mExternalRenderThread.setBackgroundColor(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            }
            this.mExternalRenderThread.setDisableFlashBlack(item.isDisableFlushBlack());
            this.mExternalRenderThread.setDisableSurfaceAlign(item.isDisableSurfaceAlign());
        }
    }

    private void doIjkServiceSetTaskByType(Message msg, IIjkMediaPlayer nativePlayer) {
        try {
            boolean z = true;
            switch (msg.what) {
                case 3:
                    nativePlayer.start();
                    stayAwake(true);
                    msIjkMediaPlayerServiceConnection.initAbrParamsInterfaceClient();
                    return;
                case 4:
                case 12:
                case 27:
                default:
                    DebugLog.e(TAG, "SomeWorkHandler Unknown message type " + msg.what);
                    return;
                case 5:
                    nativePlayer.pause();
                    stayAwake(false);
                    if (this.mIjkMediaPlayerTracker != null) {
                        this.mIjkMediaPlayerTracker.recordPause();
                        return;
                    }
                    return;
                case 6:
                    nativePlayer.reset();
                    stayAwake(false);
                    this.mVideoWidth = 0;
                    this.mVideoHeight = 0;
                    return;
                case 7:
                    nativePlayer.stop();
                    stayAwake(false);
                    return;
                case 8:
                    if (this.mEnableExternalRender) {
                        synchronized (this.mRenderLock) {
                            if (msg.obj != null && this.mExternalRenderThread != null) {
                                this.mExternalRenderThread.setAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
                                this.mExternalRenderThread.setVideoSize(this.mVideoWidth, this.mVideoHeight);
                            }
                        }
                        updateSurfaceScreenOn(false);
                        return;
                    }
                    nativePlayer.setSurface((Surface) msg.obj);
                    updateSurfaceScreenOn(true);
                    return;
                case 9:
                    nativePlayer.setDataSource((String) msg.obj);
                    return;
                case 10:
                    nativePlayer.setDataSourceBase64((String) msg.obj);
                    return;
                case 11:
                    return;
                case 13:
                    int i = msg.arg1;
                    if (msg.arg2 <= 0) {
                        z = false;
                    }
                    nativePlayer.setStreamSelected(i, z);
                    return;
                case 14:
                    nativePlayer.seekTo(((Long) msg.obj).longValue(), msg.arg1);
                    return;
                case 15:
                    nativePlayer.setLoopCount(msg.arg1);
                    return;
                case 16:
                    nativePlayer.setPropertyFloat(msg.arg1, ((Float) msg.obj).floatValue());
                    return;
                case 17:
                    nativePlayer.setPropertyLong(msg.arg1, ((Long) msg.obj).longValue());
                    return;
                case 18:
                    Pair<Float, Float> volume = (Pair) msg.obj;
                    if (volume != null) {
                        nativePlayer.setVolume(((Float) volume.first).floatValue(), ((Float) volume.second).floatValue());
                        return;
                    }
                    return;
                case 19:
                    Pair<String, String> optionString = (Pair) msg.obj;
                    if (optionString != null) {
                        nativePlayer.setOptionString(msg.arg1, (String) optionString.first, (String) optionString.second);
                        return;
                    }
                    return;
                case 20:
                    Pair<String, Long> optionLong = (Pair) msg.obj;
                    if (optionLong != null) {
                        nativePlayer.setOptionLong(msg.arg1, (String) optionLong.first, ((Long) optionLong.second).longValue());
                        return;
                    }
                    return;
                case 21:
                    nativePlayer.nativeFinalize();
                    return;
                case 22:
                    nativePlayer.nativeProfileBegin((String) msg.obj);
                    return;
                case 23:
                    nativePlayer.nativeProfileEnd();
                    return;
                case 24:
                    nativePlayer.nativeSetLogLevel(msg.arg1);
                    return;
                case 25:
                    return;
                case 26:
                    nativePlayer.setAndroidIOCallback();
                    return;
                case 28:
                    nativePlayer.switchDashVideoStream(msg.arg1);
                    return;
                case 29:
                    nativePlayer.switchDashAudioStream(msg.arg1);
                    return;
                case 30:
                    Bundle args = (Bundle) msg.obj;
                    if (args != null) {
                        msIjkMediaPlayerServiceConnection.initAbrParamsInterfaceClient();
                        AbrParamsInterface.updateParams();
                        boolean flag = args.getBoolean("flag", false);
                        nativePlayer.setAuto(flag);
                        if (this.mIjkMediaPlayerTracker != null) {
                            this.mIjkMediaPlayerTracker.setDashAutoSwitch(flag);
                        }
                        return;
                    }
                    return;
            }
        } catch (RemoteException e) {
            BLog.w(TAG, "[PlayProblem] doIjkServiceSetTask exception, task=" + msg.what);
            onBuglyReport(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doIjkServiceSetTask(Message msg) {
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            doIjkServiceSetTaskByType(msg, this.mPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SomeWorkHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public SomeWorkHandler(IjkMediaPlayer mp, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mp);
        }

        private void TrySamplePerformance(IjkMediaPlayer player) {
            if (player.mContext != null) {
                IjkPerformanceManager performanceManager = IjkPerformanceManager.getInstance(player.mContext);
                player.mainSamplePerfromance = performanceManager.sampleState(Process.myPid());
            }
            try {
                if (player.mPlayer != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                    player.mPlayer.SamplePerformance();
                    player.ijkSamplePerfromance.cpu = player.mPlayer.getSampleCpu();
                    player.ijkSamplePerfromance.thread = player.mPlayer.getSampleThread();
                    player.ijkSamplePerfromance.memory = player.mPlayer.getSampleMemory();
                    player.ijkSamplePerfromance.threadRecord = player.mPlayer.getSampleThreadRecord();
                }
            } catch (RemoteException e) {
                player.onBuglyReport(e);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            final IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
                return;
            }
            switch (msg.what) {
                case 0:
                    if (IjkMediaPlayer.msIjkserviceIsConnected) {
                        obtainMessage(1).sendToTarget();
                        removeMessages(34);
                        return;
                    }
                    if (!hasMessages(34)) {
                        sendMessageDelayed(obtainMessage(34), PlayerToastConfig.DURATION_8);
                    }
                    sendMessageDelayed(obtainMessage(0), 10L);
                    return;
                case 1:
                    if (player.mClient != null) {
                        IIjkMediaPlayer iPlayer = IjkMediaPlayer.msIjkMediaPlayerServiceConnection.registerClient(player.mClient.hashCode(), player.mClient, player);
                        if (iPlayer == null) {
                            IjkMediaPlayer.stopIjkServer(player.mContext);
                        }
                        synchronized (player.mWaitList) {
                            int listSize = player.mWaitList.size();
                            if (listSize > 0) {
                                for (int i = 0; i < listSize; i++) {
                                    sendMessage((Message) player.mWaitList.get(i));
                                }
                                player.mWaitList.clear();
                            }
                            player.mPlayer = iPlayer;
                            TrySamplePerformance(player);
                            if (player.mPlayer != null && player.mEnableExternalRender) {
                                try {
                                    synchronized (player.mRenderLock) {
                                        if (player.mExternalRenderThread == null && !player.mIsRelease) {
                                            player.mExternalRenderThread = new IjkExternalRenderThread();
                                            player.mExternalRenderThread.setPlayerPauseStateCallback(new IjkExternalRenderThread.GetPlayerPauseStateCallback() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.SomeWorkHandler.1
                                                @Override // tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.GetPlayerPauseStateCallback
                                                public boolean isPlayerPause() {
                                                    return !player.isPlaying();
                                                }
                                            });
                                            player.mExternalRenderThread.setRenderCallback(player.mExternalRenderCallback);
                                            player.mPlayer.setExternalRenderSurface(player.mExternalRenderThread.getAmcSurface(), player.mExternalRenderThread.getAvSurface());
                                        }
                                    }
                                } catch (Exception e) {
                                    player.onBuglyReport(e);
                                }
                            }
                        }
                    }
                    if (player.mPlayer == null) {
                        removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                case 2:
                    player.mIllegalPrepare = false;
                    try {
                        if (player.mPlayer != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            synchronized (player.mRenderLock) {
                                if (player.mExternalRenderThread != null && player.mDisplaySurface != null && player.mEnableExternalRender) {
                                    BLog.i(IjkMediaPlayer.TAG, "[ IJKExternalRenderSurface ] createWindowSurface() prepare");
                                    player.mExternalRenderThread.createWindowSurface(player.mDisplaySurface);
                                }
                            }
                            player.mPlayer.prepareAsync();
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        player.onBuglyReport(e2);
                        return;
                    } catch (IllegalStateException e3) {
                        BLog.w(IjkMediaPlayer.TAG, e3);
                        player.mIllegalPrepare = true;
                        player.notifyOnError(IjkMediaPlayer.MSG_ERROR_ILLEGAL_PREPARE, 0);
                        return;
                    }
                case 4:
                    player.handleRelease();
                    return;
                case 12:
                    try {
                        ParcelFileDescriptor pfd = (ParcelFileDescriptor) msg.obj;
                        if (pfd != null) {
                            if (player.mPlayer != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                                player.mPlayer.setDataSourceFd(pfd);
                            }
                            pfd.close();
                            return;
                        }
                        return;
                    } catch (RemoteException e4) {
                        player.onBuglyReport(e4);
                        return;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                case 27:
                    try {
                        if (player.mOnNativeInvokeListener != null) {
                            player.mOnNativeInvokeListener.onNativeInvoke(msg.arg1, (Bundle) msg.obj);
                            return;
                        }
                        return;
                    } catch (NullPointerException e6) {
                        BLog.e(IjkMediaPlayer.TAG, "onNativeInvoke IjkMediaPlayer NullPointerException");
                        return;
                    }
                case 32:
                    RemoteException exception = null;
                    Pair<IjkMediaPlayerItem, Bundle> obj = (Pair) msg.obj;
                    IjkMediaPlayerItem item = (IjkMediaPlayerItem) obj.first;
                    Bundle args = (Bundle) obj.second;
                    long timestamp = args.getLong("timestamp", SystemClock.elapsedRealtime());
                    int itemPlay = args.getInt("itemPlay", 1);
                    synchronized (player) {
                        if (player.mPlayer != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            if (!player.mIsRelease) {
                                if (item == null || player.mItem == item) {
                                    if (item != null && !item.isConnected()) {
                                        sendMessageAtFrontOfQueue(obtainMessage(msg.what, msg.obj));
                                        return;
                                    }
                                    if (item != null && itemPlay == 2) {
                                        player.willReplaceItem(item, timestamp);
                                    }
                                    player.checkRenderStatus(item);
                                    if (item != null) {
                                        item.AddPerformanceSampleValue(player.mainSamplePerfromance, player.ijkSamplePerfromance);
                                    }
                                    synchronized (player.mEventHandler) {
                                        try {
                                            if (item == null) {
                                                player.mPlayer.setIjkMediaPlayerItem(null);
                                            } else if (item.getItem() != null) {
                                                item.setCidToNative();
                                                player.mPlayer.setIjkMediaPlayerItem(item.getItem());
                                            }
                                        } catch (RemoteException e7) {
                                            exception = e7;
                                        }
                                        player.mEventFlushRequest = false;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (exception != null) {
                            player.onBuglyReport(exception);
                            return;
                        }
                        return;
                    }
                case 34:
                    BLog.w(IjkMediaPlayer.TAG, "ijk not connect , do unbind and bind .....");
                    IjkMediaPlayer.msIjkserviceAbnormal = true;
                    IjkMediaPlayer.stopIjkServer(player.mContext);
                    if (BuildConfig.ENABLE_IJKSERVICE.booleanValue()) {
                        boolean isNeedServices = false;
                        if ((TextUtils.isEmpty(Build.BRAND) || Build.BRAND.compareToIgnoreCase("SMARTISAN") != 0) && Build.VERSION.SDK_INT > 26 && player.mStartNoUiActivity) {
                            isNeedServices = true;
                        }
                        if (isNeedServices) {
                            player.startijkActivity();
                        }
                    }
                    IjkMediaPlayer.startIjkServer(player.mIjkLibLoader, player.mContext);
                    sendMessageDelayed(obtainMessage(34), PlayerToastConfig.DURATION_8);
                    if (player.mIjkMediaPlayerTracker != null) {
                        player.mIjkMediaPlayerTracker.recordIjkProcessError();
                        return;
                    }
                    return;
                case 35:
                    TrySamplePerformance(player);
                    if (player.mItem != null) {
                        player.mItem.AddPerformanceSampleValue(player.mainSamplePerfromance, player.ijkSamplePerfromance);
                    }
                    sendMessageDelayed(obtainMessage(35), 30000L);
                    return;
                default:
                    player.doIjkServiceSetTask(msg);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class EventHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public EventHandler(IjkMediaPlayer mp, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mp);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
                return;
            }
            switch (msg.what) {
                case 0:
                case 99:
                    return;
                case 1:
                    Bundle args = (Bundle) msg.obj;
                    IjkMediaPlayerItem curItem = player.getIjkMediaPlayerItem();
                    if (args != null) {
                        String itemName = args.getString("item_name", "");
                        Boolean validName = Boolean.valueOf(!TextUtils.isEmpty(itemName));
                        if ((!validName.booleanValue() && curItem != null) || (validName.booleanValue() && (curItem == null || !curItem.isEqualsToInternal(itemName)))) {
                            BLog.e(IjkMediaPlayer.TAG, "msg item mismatch !");
                            return;
                        }
                        player.mDuration = args.getLong("duration", 0L);
                        if (player.mIjkMediaPlayerTracker != null) {
                            player.mIjkMediaPlayerTracker.setStartNetwork(IjkMediaPlayerMonitor.getInstance().getNetworkState().ordinal());
                        }
                        Bundle info = args.getBundle("dash_stream_info");
                        if (info != null) {
                            player.updateDashStreamInfo(info);
                        }
                        player.isPrepared = true;
                    }
                    player.updateEac3Endpoint();
                    player.notifyOnPrepared();
                    if (player.getBufferControl() != 0) {
                        player.updateBufferControl();
                        return;
                    }
                    return;
                case 2:
                    if (player.mIjkMediaPlayerTracker != null) {
                        player.isPlaybackComplete = true;
                        player.mIjkMediaPlayerTracker.playerComplete(true);
                    }
                    player.stayAwake(false);
                    player.notifyOnCompletion();
                    return;
                case 3:
                    long bufferPosition = msg.arg1;
                    if (bufferPosition < 0) {
                        bufferPosition = 0;
                    }
                    long percent = 0;
                    long duration = player.getDuration();
                    if (duration > 0) {
                        percent = (bufferPosition * 100) / duration;
                    }
                    if (percent >= 100) {
                        percent = 100;
                    }
                    player.notifyOnBufferingUpdate((int) percent);
                    return;
                case 4:
                    player.notifyOnSeekComplete();
                    return;
                case 5:
                    if (msg.obj != null) {
                        Bundle args2 = (Bundle) msg.obj;
                        player.mVideoWidth = args2.getInt("width", 0);
                        player.mVideoHeight = args2.getInt("height", 0);
                        player.mVideoSarNum = args2.getInt(IjkMediaMeta.IJKM_KEY_SAR_NUM, 0);
                        player.mVideoSarDen = args2.getInt(IjkMediaMeta.IJKM_KEY_SAR_DEN, 1);
                        player.mVideoFps = IjkUtils.getPropetyFloat(args2, 10009, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                        if (player.mVideoSarNum == 0 || player.mVideoSarDen == 0) {
                            player.mVideoSarDen = 1;
                            player.mVideoSarNum = 1;
                        }
                        long timestamp = ((Bundle) msg.obj).getLong("timestamp", 0L);
                        player.trackerIjkVideoSizeChangeMsg(timestamp, args2);
                        player.notifyOnVideoSizeChanged(player.mVideoWidth, player.mVideoHeight, player.mVideoSarNum, player.mVideoSarDen);
                        if (player.mEnableExternalRender) {
                            synchronized (player.mRenderLock) {
                                if (player.mExternalRenderThread != null) {
                                    player.mExternalRenderThread.setAspectRatio(player.mVideoSarNum, player.mVideoSarDen);
                                    player.mExternalRenderThread.setVideoSize(player.mVideoWidth, player.mVideoHeight);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 100:
                    DebugLog.e(IjkMediaPlayer.TAG, "Error (" + msg.arg1 + "," + msg.arg2 + ")");
                    if (!player.notifyOnError(msg.arg1, msg.arg2)) {
                        player.notifyOnCompletion();
                    }
                    player.stayAwake(false);
                    return;
                case 200:
                    player.notifyOnInfo(msg.arg1, msg.arg2, (Bundle) msg.obj);
                    switch (msg.arg1) {
                        case 3:
                            Bundle args3 = (Bundle) msg.obj;
                            IjkMediaPlayerItem curItem2 = player.getIjkMediaPlayerItem();
                            if (args3 != null) {
                                String itemName2 = args3.getString("item_name", "");
                                Boolean validName2 = Boolean.valueOf(!TextUtils.isEmpty(itemName2));
                                if ((!validName2.booleanValue() && curItem2 != null) || (validName2.booleanValue() && (curItem2 == null || !curItem2.isEqualsToInternal(itemName2)))) {
                                    BLog.e(IjkMediaPlayer.TAG, "[video render start] msg item mismatch !");
                                    return;
                                } else if (curItem2 != null) {
                                    String cur_video_id = args3.getString(String.valueOf((int) IjkMediaPlayer.FFP_PROP_INT64_DASH_CUR_VIDEO_ID), "0");
                                    BLog.i(IjkMediaPlayer.TAG, "[video render start] updateEnhanceStateForQn:" + cur_video_id);
                                    try {
                                        int videoId = Integer.parseInt(cur_video_id);
                                        player.updateEnhanceStateForQn(videoId);
                                        break;
                                    } catch (NumberFormatException e) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 10001:
                            int rotation = msg.arg2;
                            Bundle args4 = (Bundle) msg.obj;
                            if (args4 != null) {
                                if (args4.containsKey("video_rotation")) {
                                    rotation = args4.getInt("video_rotation", rotation);
                                } else if (args4.containsKey("rotation")) {
                                    rotation = args4.getInt("rotation", rotation);
                                }
                            }
                            if (player.mEnableExternalRender && player.mExternalRenderCallback != null) {
                                player.mExternalRenderCallback.rotate(rotation);
                            }
                            BLog.i(IjkMediaPlayer.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED rotation:" + rotation);
                            break;
                        case 10002:
                            Bundle args5 = (Bundle) msg.obj;
                            IjkMediaPlayerItem curItem3 = player.getIjkMediaPlayerItem();
                            if (args5 != null) {
                                String itemName3 = args5.getString("item_name", "");
                                Boolean validName3 = Boolean.valueOf(!TextUtils.isEmpty(itemName3));
                                if ((!validName3.booleanValue() && curItem3 != null) || (validName3.booleanValue() && (curItem3 == null || !curItem3.isEqualsToInternal(itemName3)))) {
                                    BLog.e(IjkMediaPlayer.TAG, "msg item mismatch !");
                                    return;
                                }
                            }
                            break;
                        case IMediaPlayer.MEDIA_INFO_MEDIA_SWITCH_SOURCE /* 10107 */:
                            Bundle bundle = (Bundle) msg.obj;
                            if (bundle != null) {
                                player.mVideoFps = IjkUtils.getPropetyFloat(bundle, 10009, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                                int type = bundle.getInt("type", 0);
                                int errorCode = bundle.getInt("error", 0);
                                int nextId = bundle.getInt(OnNativeInvokeListener.ARG_DASH_NEXT_ID, 0);
                                if (type == 0 && errorCode == 0) {
                                    player.updateEnhanceStateForQn(nextId);
                                    break;
                                }
                            }
                            break;
                        case IMediaPlayer.MEDIA_INFO_MEDIA_START_QUALITY_CHANGED /* 10111 */:
                            int new_start_quality = msg.arg2;
                            if (player.mIjkMediaPlayerTracker != null) {
                                player.mIjkMediaPlayerTracker.setCurQn(new_start_quality, 0);
                                break;
                            }
                            break;
                        case IMediaPlayer.MEDIA_INFO_MEDIA_APP_INFO_TRIGGER /* 10112 */:
                            player.updateIjkStatus();
                            break;
                    }
                    player.trackerIjkInfoMsg(msg.arg1, msg.arg2, (Bundle) msg.obj);
                    return;
                case 10001:
                    player.mVideoSarNum = msg.arg1;
                    player.mVideoSarDen = msg.arg2;
                    player.notifyOnVideoSizeChanged(player.mVideoWidth, player.mVideoHeight, player.mVideoSarNum, player.mVideoSarDen);
                    if (player.mEnableExternalRender) {
                        synchronized (player.mRenderLock) {
                            if (player.mExternalRenderThread != null) {
                                player.mExternalRenderThread.setAspectRatio(player.mVideoSarNum, player.mVideoSarDen);
                            }
                        }
                        return;
                    }
                    return;
                case 10002:
                    player.updateDashStreamInfo((Bundle) msg.obj);
                    return;
                default:
                    DebugLog.e(IjkMediaPlayer.TAG, "EventHandler Unknown message type " + msg.what);
                    return;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class ClocktHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public ClocktHandler(IjkMediaPlayer mp, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mp);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                DebugLog.w(IjkMediaPlayer.TAG, "ClocktHandler: IjkMediaPlayer went away with unhandled events");
                return;
            }
            switch (msg.what) {
                case 300:
                    float rate = msg.arg1 / 1000.0f;
                    long infoSendTime = ((Bundle) msg.obj).getLong("timestamp", 0L);
                    long infoLatency = ((float) (SystemClock.elapsedRealtime() - infoSendTime)) * rate;
                    BLog.i(IjkMediaPlayer.TAG, "MEDIA_PLAYER_CLOCK_CHANGE rate " + rate + " position " + msg.arg2 + " infoLatency " + infoLatency);
                    player.notifyOnPlayerClockChangedListener(rate, msg.arg2 + infoLatency);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkMediaPlayerBinder extends IIjkMediaPlayerClient.Stub {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public IjkMediaPlayerBinder(IjkMediaPlayer player) {
            this.mWeakPlayer = new WeakReference<>(player);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public String onMediaCodecSelect(String mimeType, int profile, int level) throws RemoteException {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return null;
            }
            if (player.mOnMediaCodecSelectListener == null) {
                player.mOnMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
            }
            player.mVideoHWCodecName = player.mOnMediaCodecSelectListener.onMediaCodecSelect(player, mimeType, profile, level);
            return player.mVideoHWCodecName;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onRawDataWrite(byte[] data, int offset, int size, int freq, int channels, int samples) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return -1;
            }
            if (player.mOnRawDataWriteListener == null) {
                player.mOnRawDataWriteListener = DefaultRawDataWriter.sInstance;
            }
            return player.mOnRawDataWriteListener.onRawDataWrite(player, data, offset, size, freq, channels, samples);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return -1;
            }
            if (player.mOnSeiDataWriteListener == null) {
                player.mOnSeiDataWriteListener = DefaultSeiDataWriter.sInstance;
            }
            if (player.mIjkMediaPlayerTracker != null) {
                player.mIjkMediaPlayerTracker.setSeiData(data);
            }
            return player.mOnSeiDataWriteListener.onSeiDataWrite(player, data, size, decodeTimestamp, presentationTimestamp);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDownloadSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return -1;
            }
            if (player.mOnDownloadSeiDataWriteListener == null) {
                player.mOnDownloadSeiDataWriteListener = DefaultOnDownloadSeiDataWriter.sInstance;
            }
            return player.mOnDownloadSeiDataWriteListener.onDownloadSeiDataWrite(player, data, size, decodeTimestamp, presentationTimestamp);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onMetaDataWrite(byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) throws RemoteException {
            BLog.d(IjkMediaPlayer.TAG, String.format("onMetaDataWrite : color_space:%d  | colorRang:%d | colorTransfer:%d", Integer.valueOf(colorSpace), Integer.valueOf(colorRange), Integer.valueOf(colorTransfer)));
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player.mDisplaySurface == null) {
                BLog.i(IjkMediaPlayer.TAG, "onMetaDataWrite no mDisplaySurface, try enableHDR later");
                player.tryEnableHdrLater = true;
            }
            player.updateHdrConfig();
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoPacketCallback(byte[] au_buf, int size, long timeUs, int flag) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player.mEnableExternalRender && player.mExternalRenderCallback != null) {
                player.mExternalRenderCallback.video_packet_callback(au_buf, size, timeUs, flag);
                return 0;
            }
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onSetDolbyModel(int model) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player.mEnableExternalRender && player.mExternalRenderCallback != null) {
                player.mExternalRenderCallback.setDolbyModel(model);
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public boolean onNativeInvoke(int what, Bundle args) {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return false;
            }
            switch (what) {
                case 1:
                case 2:
                    player.mSomeWorkHandle.obtainMessage(27, what, 0, args).sendToTarget();
                    return true;
                case 7:
                    return true;
                default:
                    if (player.mOnNativeInvokeListener != null && player.mOnNativeInvokeListener.onNativeInvoke(what, args)) {
                        return true;
                    }
                    switch (what) {
                        case 131079:
                            OnControlMessageListener onControlMessageListener = player.mOnControlMessageListener;
                            if (onControlMessageListener == null) {
                                return false;
                            }
                            int segmentIndex = args.getInt("segment_index", -1);
                            if (segmentIndex < 0) {
                                throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
                            }
                            String newUrl = onControlMessageListener.onControlResolveSegmentUrl(segmentIndex);
                            if (newUrl == null) {
                                throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
                            }
                            args.putString("url", newUrl);
                            return true;
                        default:
                            return false;
                    }
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onEventHandler(int what, int arg1, int arg2, long timestamp, Bundle bundle) throws RemoteException {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return;
            }
            if (what == 200 && arg1 == 2) {
                player.start();
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putLong("timestamp", timestamp);
            if (what == 300) {
                Handler handler = player.mClockHandler;
                if (handler == null) {
                    Looper clockLooper = player.mPlayerClockLooper;
                    if (clockLooper == null) {
                        clockLooper = Looper.getMainLooper();
                    }
                    ClocktHandler clocktHandler = new ClocktHandler(player, clockLooper);
                    player.mClockHandler = clocktHandler;
                    handler = clocktHandler;
                }
                Message m = handler.obtainMessage(what, arg1, arg2, bundle);
                handler.sendMessage(m);
            } else if (player.mEventHandler != null) {
                synchronized (player.mEventHandler) {
                    if (player.mEventFlushRequest) {
                        return;
                    }
                    Message m2 = player.mEventHandler.obtainMessage(what, arg1, arg2, bundle);
                    player.mEventHandler.sendMessage(m2);
                }
            }
            if (!player.mSomeWorkHandle.hasMessages(35)) {
                player.mSomeWorkHandle.sendMessage(player.mSomeWorkHandle.obtainMessage(35));
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onReportAnr(int what) {
            DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayerService happen anr in what =" + what);
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return;
            }
            player.mHappenAnr = true;
            if (player.mIjkMediaPlayerTracker != null) {
                player.mIjkMediaPlayerTracker.recordHasAnr();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoDisplay(double pts, double duration) throws RemoteException {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null || player.mOnVideoDisplayCallback == null) {
                return 0;
            }
            return player.mOnVideoDisplayCallback.onVideoDisplay(pts, duration);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onFirstVideoRender() throws RemoteException {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return 0;
            }
            if (player.mExternalRenderThread != null && player.mEnableExternalRender) {
                player.mExternalRenderThread.resetFirstFrame();
            }
            if (player.mOnVideoFirstFrameRenderListener == null) {
                return 0;
            }
            return player.mOnVideoFirstFrameRenderListener.onVideoFirstFrameRender();
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDrmEvent(int event, Bundle args) throws RemoteException {
            IjkMediaPlayer player = this.mWeakPlayer.get();
            if (player == null) {
                return 0;
            }
            player.onDrmEvent(event, args);
            return 0;
        }
    }

    private void pauseExternalRender() {
        if (this.mEnableExternalRender) {
            BLog.i(TAG, "pauseExternalRender");
            disableExternalRender();
            this.mEnableExternalAfterDrm = true;
            return;
        }
        this.mEnableExternalAfterDrm = false;
    }

    private void resumeExternalRender() {
        BLog.i(TAG, "resumeExternalRender = " + this.mEnableExternalAfterDrm);
        if (this.mEnableExternalAfterDrm) {
            enableExternalRender();
        } else {
            disableExternalRender();
        }
    }

    public void onDrmEvent(int event, Bundle args) {
        switch (event) {
            case 0:
                if (!this.mIsDrm) {
                    pauseExternalRender();
                    this.mIsDrm = true;
                    return;
                }
                return;
            case 1:
                if (this.mIsDrm) {
                    this.mIsDrm = false;
                    resumeExternalRender();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkMediaPlayerServiceConnection implements ServiceConnection {
        private IIjkMediaPlayerService mServiceInterface = null;
        private final SparseArray<WeakReference<IjkMediaPlayer>> mPlayers = new SparseArray<>();
        private final SparseArray<WeakReference<IjkMediaPlayerItem>> mItems = new SparseArray<>();

        public IIjkMediaPlayer registerClient(int connId, IIjkMediaPlayerClient client, IjkMediaPlayer player) {
            IIjkMediaPlayer iplayer = null;
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null) {
                    try {
                        try {
                            iplayer = this.mServiceInterface.create(connId, client);
                            iplayer.setProtectDelay(IjkMediaPlayer.mIjkProtectDelay);
                            IjkMediaPlayer.mIjkProtectDelay = IjkMediaPlayer.IJK_ANR_RESET_DELAY;
                        } catch (RemoteException e) {
                            BLog.w(IjkMediaPlayer.TAG, e);
                        }
                    } catch (RuntimeException e2) {
                        BLog.w(IjkMediaPlayer.TAG, e2);
                    }
                }
                this.mPlayers.put(connId, new WeakReference<>(player));
            }
            return iplayer;
        }

        public void unregisterClient(int connId) {
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null) {
                    try {
                        this.mPlayers.remove(connId);
                        this.mServiceInterface.removeClient(connId);
                    } catch (RemoteException e) {
                        BLog.w(IjkMediaPlayer.TAG, e);
                    } catch (RuntimeException e2) {
                        BLog.w(IjkMediaPlayer.TAG, e2);
                    }
                }
            }
        }

        public IIjkMediaPlayerItem registerItemClient(int connId, IIjkMediaPlayerItemClient itemClient, IjkMediaPlayerItem item) {
            IIjkMediaPlayerItem iijkMediaPlayeritem = null;
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null) {
                    try {
                        iijkMediaPlayeritem = this.mServiceInterface.createItem(connId, itemClient);
                    } catch (RemoteException e) {
                        BLog.w(IjkMediaPlayer.TAG, e);
                    } catch (RuntimeException e2) {
                        BLog.w(IjkMediaPlayer.TAG, e2);
                    }
                }
                this.mItems.put(connId, new WeakReference<>(item));
            }
            return iijkMediaPlayeritem;
        }

        public void initP2PClient() {
            P2P p2p;
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null && (p2p = P2P.getInstance()) != null) {
                    try {
                        if (p2p.isNeedCreateClient()) {
                            p2p.setBinder(this.mServiceInterface.createP2P(p2p.getConfigs()));
                        }
                    } catch (RemoteException e) {
                        BLog.w(IjkMediaPlayer.TAG, e);
                        if (p2p != null) {
                            p2p.handleClientReboot();
                        }
                    } catch (RuntimeException e2) {
                        BLog.w(IjkMediaPlayer.TAG, e2);
                    }
                }
            }
        }

        public void initAbrParamsInterfaceClient() {
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null) {
                    try {
                        if (IjkMediaPlayer.msAbrParamsInterface == null) {
                            IjkMediaPlayer.msAbrParamsInterface = this.mServiceInterface.createAbrParamsInterface();
                            AbrParamsInterface.setInstance(IjkMediaPlayer.msAbrParamsInterface);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void unregisterItemClient(int connId) {
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                if (this.mServiceInterface != null) {
                    try {
                        this.mItems.remove(connId);
                        this.mServiceInterface.removeItemClient(connId);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            BLog.i(IjkMediaPlayer.TAG, "IjkMediaPlayer onServiceConnected\n");
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                IjkMediaPlayer.mIjkserviceInitTime = SystemClock.elapsedRealtime() - IjkMediaPlayer.mIjkserviceStartTs;
                this.mServiceInterface = IIjkMediaPlayerService.Stub.asInterface(service);
                IjkMediaPlayer.msIjkserviceIsConnected = true;
                IjkMediaPlayer.msIjkserviceAbnormal = false;
                IjkMediaPlayer.msAbrParamsInterface = null;
                IjkMediaPlayer.msIjkMediaPlayerServiceConnection.initAbrParamsInterfaceClient();
                AbrParamsInterface.updateParams();
                int size = this.mPlayers.size();
                for (int i = 0; i < size; i++) {
                    WeakReference<IjkMediaPlayer> value = this.mPlayers.valueAt(i);
                    if (value != null) {
                        try {
                            IjkMediaPlayer iplayer = value.get();
                            if (iplayer != null) {
                                iplayer.serviceConnectedHandle();
                            }
                        } catch (NullPointerException e) {
                            BLog.e(IjkMediaPlayer.TAG, "onServiceConnected IjkMediaPlayer NullPointerException");
                        }
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            BLog.i(IjkMediaPlayer.TAG, "IjkMediaPlayer onServiceDisconnected\n");
            serviceDisconnectedHandle();
            P2P p2p = P2P.getInstance();
            if (p2p != null) {
                p2p.setBinder(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void serviceDisconnectedHandle() {
            synchronized (IjkMediaPlayer.msIjkMediaPlayerServiceConnection) {
                IjkMediaPlayer.msIjkserviceIsConnected = false;
                int size = this.mPlayers.size();
                for (int i = 0; i < size; i++) {
                    WeakReference<IjkMediaPlayer> value = this.mPlayers.valueAt(i);
                    if (value != null) {
                        try {
                            IjkMediaPlayer iplayer = value.get();
                            if (iplayer != null) {
                                iplayer.playerOnServiceDisconnect();
                            }
                        } catch (NullPointerException e) {
                            BLog.e(IjkMediaPlayer.TAG, "onServiceDisconnected IjkMediaPlayer NullPointerException");
                        }
                    }
                }
                this.mPlayers.clear();
                this.mItems.clear();
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private class ServiceException extends Exception {
        public ServiceException() {
        }

        public ServiceException(String detailMessage) {
            super(detailMessage);
        }

        public ServiceException(String detailMessage, Throwable throwable) {
            super(detailMessage, throwable);
        }

        public ServiceException(Throwable throwable) {
            super(throwable);
        }
    }

    public static void startIjkServer(IjkLibLoader libLoader, Context context) {
        File file;
        Context appContext = context.getApplicationContext();
        IjkDeviceScoreInfo.getInstance(appContext);
        BLog.i(TAG, "IjkMediaPlayer startIjkServer " + appContext);
        synchronized (msIjkMediaPlayerServiceConnection) {
            if (!msIjkserviceIsConnected) {
                mIjkserviceStartTs = SystemClock.elapsedRealtime();
                mIjkserviceInitTime = 0L;
                String[] loadLibs = IjkJNILibManager.getInstance().getLoadLibs();
                boolean enable_ffmpeg_v2 = IjkJNILibManager.getInstance().isEnableFFmpegV2();
                BLog.i("IjkMediaPlayer", "startIjkServer: enable_ffmpeg_v2 = " + enable_ffmpeg_v2);
                Intent intent = new Intent(appContext, IjkMediaPlayerService.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("enable_ffmpeg_v2", enable_ffmpeg_v2);
                if (IjkJNILibManager.getInstance().getLibDir() != null) {
                    bundle.putString("lib_path", IjkJNILibManager.getInstance().getLibDir().getAbsolutePath());
                }
                for (String lib : loadLibs) {
                    if (enable_ffmpeg_v2) {
                        bundle.putString(lib, lib);
                    } else if (libLoader != null && (file = libLoader.findLibrary(lib)) != null && file.exists()) {
                        bundle.putString(lib, file.getAbsolutePath());
                    }
                }
                intent.putExtras(bundle);
                try {
                    if (!appContext.bindService(intent, msIjkMediaPlayerServiceConnection, 1)) {
                        BLog.e("[PlayProblem] start ijkMediaPlayer service fail ");
                    }
                } catch (RuntimeException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopIjkServer(Context context) {
        Context appContext = context.getApplicationContext();
        BLog.i(TAG, "[PlayProblem] IjkMediaPlayer stopIjkServer " + appContext);
        Intent intent = new Intent(appContext, IjkMediaPlayerService.class);
        synchronized (msIjkMediaPlayerServiceConnection) {
            try {
                appContext.unbindService(msIjkMediaPlayerServiceConnection);
                appContext.stopService(intent);
                P2P p2p = P2P.getInstance();
                if (p2p != null) {
                    p2p.setBinder(null);
                }
            } catch (RuntimeException e) {
            }
            if (msIjkserviceIsConnected) {
                msIjkserviceIsConnected = false;
                msIjkMediaPlayerServiceConnection.serviceDisconnectedHandle();
            }
        }
        BLog.i(TAG, "IjkMediaPlayer stopIjkServer end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startijkActivity() {
        Context appContext = this.mContext.getApplicationContext();
        BLog.i(TAG, "IjkMediaPlayer startijkActivity " + appContext);
        Intent intent = new Intent(appContext, IjkMediaPlayerNoUIActivity.class);
        intent.addFlags(268435456);
        appContext.startActivity(intent);
    }

    private void setupThreadHanle() {
        String looperType;
        Looper looper = Looper.myLooper();
        if (looper != null) {
            looperType = "Mylooper";
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper2 = Looper.getMainLooper();
            if (looper2 != null) {
                looperType = "MainLooper";
                this.mEventHandler = new EventHandler(this, looper2);
            } else {
                looperType = "Reuse";
                this.mEventHandler = null;
            }
        }
        this.mHandleThread = new HandlerThread("ijk_java_player");
        this.mHandleThread.start();
        this.mSomeWorkHandle = new SomeWorkHandler(this, this.mHandleThread.getLooper());
        BLog.i(TAG, "IjkMediaPlayer setupThreadHanle [" + this + "] looperType = " + looperType);
    }

    private void initIjkMediaPlayer(IjkLibLoader libLoader, Context context) {
        this.mIsRelease = false;
        IjkMediaPlayerMonitor.getInstance().init(context).start();
        this.mClient = new IjkMediaPlayerBinder(this);
        setupThreadHanle();
        this.mContext = context.getApplicationContext();
        this.mIjkLibLoader = libLoader;
        startIjkServer(libLoader, context);
        mCurPlayer = this;
        this.mSomeWorkHandle.obtainMessage(0).sendToTarget();
        addEndpointChangeListener();
        IjkPlayerManager.getInstance().registerPlayer(this);
    }

    public IjkMediaPlayer(IjkLibLoader libLoader, Context context) {
        this.mWakeLock = null;
        this.mVideoFps = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mEventFlushRequest = false;
        this.mWaitList = new ArrayList<>();
        this.mHappenAnr = false;
        this.mIsRelease = false;
        this.mIjkMediaPlayerTracker = null;
        this.mVideoHWCodecName = null;
        this.mItem = null;
        this.mIjkLibLoader = null;
        this.mFirstRemoteExceptionTime = 0L;
        this.mTotalRemoteExceptionCount = 0;
        this.isPlaybackComplete = false;
        this.mIllegalPrepare = false;
        this.mClockHandler = null;
        this.mStartTime = 0L;
        this.isPrepared = false;
        this.mRunning = false;
        this.mDashStreamInfo = null;
        this.mBufferControl = 0;
        this.mEnableExternalRender = false;
        this.mRenderLock = new Object();
        this.mStartNoUiActivity = true;
        this.tryEnableHdrLater = false;
        this.mainSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.ijkSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.mEnableExternalAfterDrm = false;
        BLog.i(TAG, "IjkMediaPlayer enter1\n");
        initIjkMediaPlayer(libLoader, context);
    }

    public IjkMediaPlayer(IjkLibLoader libLoader, Context context, boolean externalRender, boolean startNoUiActivity) {
        this.mWakeLock = null;
        this.mVideoFps = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mEventFlushRequest = false;
        this.mWaitList = new ArrayList<>();
        this.mHappenAnr = false;
        this.mIsRelease = false;
        this.mIjkMediaPlayerTracker = null;
        this.mVideoHWCodecName = null;
        this.mItem = null;
        this.mIjkLibLoader = null;
        this.mFirstRemoteExceptionTime = 0L;
        this.mTotalRemoteExceptionCount = 0;
        this.isPlaybackComplete = false;
        this.mIllegalPrepare = false;
        this.mClockHandler = null;
        this.mStartTime = 0L;
        this.isPrepared = false;
        this.mRunning = false;
        this.mDashStreamInfo = null;
        this.mBufferControl = 0;
        this.mEnableExternalRender = false;
        this.mRenderLock = new Object();
        this.mStartNoUiActivity = true;
        this.tryEnableHdrLater = false;
        this.mainSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.ijkSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.mEnableExternalAfterDrm = false;
        BLog.i(TAG, "IjkMediaPlayer enter1 external render " + externalRender + " startnouiactivity " + startNoUiActivity + VideoFile.TREE_END);
        this.mStartNoUiActivity = startNoUiActivity;
        this.mEnableExternalRender = externalRender;
        if (externalRender) {
            this.mExternalRenderCallback = new IJKPlayerExternalRender();
        }
        initIjkMediaPlayer(libLoader, context);
    }

    public IjkMediaPlayer(IjkLibLoader libLoader, Context context, boolean externalRender) {
        this(libLoader, context, externalRender, false);
    }

    public IjkMediaPlayer(Context context) {
        this.mWakeLock = null;
        this.mVideoFps = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mEventFlushRequest = false;
        this.mWaitList = new ArrayList<>();
        this.mHappenAnr = false;
        this.mIsRelease = false;
        this.mIjkMediaPlayerTracker = null;
        this.mVideoHWCodecName = null;
        this.mItem = null;
        this.mIjkLibLoader = null;
        this.mFirstRemoteExceptionTime = 0L;
        this.mTotalRemoteExceptionCount = 0;
        this.isPlaybackComplete = false;
        this.mIllegalPrepare = false;
        this.mClockHandler = null;
        this.mStartTime = 0L;
        this.isPrepared = false;
        this.mRunning = false;
        this.mDashStreamInfo = null;
        this.mBufferControl = 0;
        this.mEnableExternalRender = false;
        this.mRenderLock = new Object();
        this.mStartNoUiActivity = true;
        this.tryEnableHdrLater = false;
        this.mainSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.ijkSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.mEnableExternalAfterDrm = false;
        BLog.i(TAG, "IjkMediaPlayer enter2\n");
        initIjkMediaPlayer(null, context);
    }

    public IjkMediaPlayer(Context context, boolean externalRender, boolean startNoUiActivity) {
        this.mWakeLock = null;
        this.mVideoFps = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mEventFlushRequest = false;
        this.mWaitList = new ArrayList<>();
        this.mHappenAnr = false;
        this.mIsRelease = false;
        this.mIjkMediaPlayerTracker = null;
        this.mVideoHWCodecName = null;
        this.mItem = null;
        this.mIjkLibLoader = null;
        this.mFirstRemoteExceptionTime = 0L;
        this.mTotalRemoteExceptionCount = 0;
        this.isPlaybackComplete = false;
        this.mIllegalPrepare = false;
        this.mClockHandler = null;
        this.mStartTime = 0L;
        this.isPrepared = false;
        this.mRunning = false;
        this.mDashStreamInfo = null;
        this.mBufferControl = 0;
        this.mEnableExternalRender = false;
        this.mRenderLock = new Object();
        this.mStartNoUiActivity = true;
        this.tryEnableHdrLater = false;
        this.mainSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.ijkSamplePerfromance = new IjkPerformanceManager.SampleValue();
        this.mEnableExternalAfterDrm = false;
        BLog.i(TAG, "IjkMediaPlayer enter2 external render " + externalRender + " startnouiactivity " + startNoUiActivity + VideoFile.TREE_END);
        this.mStartNoUiActivity = startNoUiActivity;
        this.mEnableExternalRender = externalRender;
        if (externalRender) {
            this.mExternalRenderCallback = new IJKPlayerExternalRender();
        }
        initIjkMediaPlayer(null, context);
    }

    public IjkMediaPlayer(Context context, boolean externalRender) {
        this(context, externalRender, false);
    }

    private boolean isIjkServiceNormal() {
        long currentTime = SystemClock.elapsedRealtime();
        if (currentTime - this.mFirstRemoteExceptionTime > PlayerToastConfig.DURATION_5) {
            this.mFirstRemoteExceptionTime = currentTime;
            this.mTotalRemoteExceptionCount = 1;
        } else {
            this.mTotalRemoteExceptionCount++;
            if (currentTime - this.mFirstRemoteExceptionTime > 500 && this.mTotalRemoteExceptionCount >= 3) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBuglyReport(Exception e) {
        if (this.mHappenAnr) {
            BLog.w(TAG, "[PlayProblem] Service ANR");
            mIjkProtectDelay = PersonInfoLoadFragment.ERROR_CODE_MODIFY_FORBIDDEN;
        } else {
            if (this.mIjkMediaPlayerTracker != null) {
                this.mIjkMediaPlayerTracker.recordIjkProcessError();
            }
            BLog.w(TAG, "[PlayProblem] Call Service Api Fail, user_propose=104, internal_propose=301");
        }
        this.mHappenAnr = false;
        if (this.mContext == null || e == null || !(e instanceof RemoteException) || isIjkServiceNormal()) {
            return;
        }
        synchronized (this.mRenderLock) {
            if (this.mExternalRenderThread != null) {
                this.mExternalRenderThread.quitExternalRender();
                this.mExternalRenderThread = null;
                BLog.e(TAG, "ExternalRenderThread Abort");
            }
        }
        stopIjkServer(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackerIjkInfoMsg(int what, int arg, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        long timestamp = bundle.getLong("timestamp", 0L);
        if (this.mIjkMediaPlayerTracker != null) {
            switch (what) {
                case 3:
                    this.mIjkMediaPlayerTracker.didFirstVideoRendered(this, this.mItem, timestamp, bundle);
                    return;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                    this.mIjkMediaPlayerTracker.willPreroll(this, arg, timestamp, bundle);
                    return;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                    this.mIjkMediaPlayerTracker.didPreroll(this, arg, timestamp, bundle);
                    return;
                case 10002:
                    this.mIjkMediaPlayerTracker.didFirstAudioRendered(this, this.mItem, timestamp);
                    return;
                case 10003:
                    return;
                case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /* 10004 */:
                    return;
                case 10005:
                    return;
                case 10007:
                    return;
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                    this.mIjkMediaPlayerTracker.didSeekVideoRendered(this, timestamp, bundle);
                    return;
                case 10009:
                    this.mIjkMediaPlayerTracker.didSeekAudioRendered(this, timestamp, bundle);
                    return;
                case 10100:
                    this.mIjkMediaPlayerTracker.didAccurateSeek(this, timestamp, bundle);
                    return;
                case 10101:
                    this.mIjkMediaPlayerTracker.ijkStartPrepare(this, timestamp, bundle);
                    return;
                case IMediaPlayer.MEDIA_INFO_MEDIA_END_PREPARE /* 10102 */:
                    return;
                case IMediaPlayer.MEDIA_INFO_MEDIA_START_SEEK /* 10103 */:
                    this.mIjkMediaPlayerTracker.willSeekTo(this, arg, timestamp, bundle);
                    return;
                case IMediaPlayer.MEDIA_INFO_MEDIA_END_SEEK /* 10104 */:
                    this.mIjkMediaPlayerTracker.didSeekTo(this, arg, timestamp, bundle);
                    return;
                case IMediaPlayer.MEDIA_INFO_MEDIA_STATE_CHANGED /* 10105 */:
                    this.mIjkMediaPlayerTracker.setPlaybackState(arg);
                    return;
                case IMediaPlayer.MEDIA_INFO_MEDIA_SWITCH_SOURCE /* 10107 */:
                    int curId = bundle.getInt(OnNativeInvokeListener.ARG_DASH_CUR_ID, 0);
                    int nextId = bundle.getInt(OnNativeInvokeListener.ARG_DASH_NEXT_ID, 0);
                    long dashTimestamp = bundle.getLong("timestamp", 0L);
                    int dashAutoSwitch = bundle.getInt(OnNativeInvokeListener.ARG_DASH_AUTO_SIWTCH, 0);
                    int dashType = bundle.getInt("type", 0);
                    long switchDuration = bundle.getLong(OnNativeInvokeListener.ARG_DASH_SWITCH_DURATION, 0L);
                    if (dashType == 0) {
                        this.mIjkMediaPlayerTracker.didDashSwitch(this, curId, nextId, dashType == 1, dashAutoSwitch, dashTimestamp, switchDuration, bundle);
                        return;
                    } else if (dashType == 1) {
                        this.mIjkMediaPlayerTracker.didDashAudioSwitch(nextId);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackerIjkVideoSizeChangeMsg(long timestamp, Bundle extra) {
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.videoSizeChange(this, timestamp, extra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceConnectedHandle() {
        if (this.mOnServiceIsConnectedListener != null) {
            this.mOnServiceIsConnectedListener.onServiceIsConnected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerOnServiceDisconnect() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                if (IjkMediaPlayer.this.mOnServiceIsConnectedListener != null) {
                    IjkMediaPlayer.this.mOnServiceIsConnectedListener.onServiceIsConnected(false);
                }
                if (!IjkMediaPlayer.this.notifyOnError(10001, 0)) {
                    IjkMediaPlayer.this.notifyOnCompletion();
                }
                IjkMediaPlayer.this.stayAwake(false);
            }
        });
        if (this.mContext != null) {
            IjkPerformanceManager.getInstance(this.mContext).reset();
        }
    }

    public String getCodecName() {
        if (TextUtils.isEmpty(this.mVideoHWCodecName)) {
            return "";
        }
        return this.mVideoHWCodecName;
    }

    public boolean serviceIsConnected() {
        return msIjkserviceIsConnected;
    }

    private void doAsyncTask(Message msg) {
        if (this.mIsRelease) {
            return;
        }
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            msg.sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && msIjkserviceIsConnected) {
                msg.sendToTarget();
            } else {
                this.mWaitList.add(msg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHdrConfig() {
        if (this.mEnableExternalRender && this.mExternalRenderCallback != null) {
            if (getIjkMediaPlayerItem() != null && getIjkMediaPlayerItem().getHDRVideoType() == 7 && getIjkMediaPlayerItem().getHDRRenderType() == 0) {
                boolean isTryHwHdr = getIjkMediaPlayerItem().isTryHwHdr();
                BLog.i(TAG, "Live HDR Vivid fallback HDR10, isTryHwHdr:" + isTryHwHdr);
                if (isTryHwHdr) {
                    this.mExternalRenderCallback.enableHDRTryHW_LiveHdrVivid(true);
                    return;
                }
                return;
            }
            if (getIjkMediaPlayerItem() != null && getIjkMediaPlayerItem().getHDRVideoType() != 0 && getIjkMediaPlayerItem().getHDRRenderType() == 0) {
                if (getIjkMediaPlayerItem().isTryHwHdr()) {
                    this.mExternalRenderCallback.enableHDRTryHW(true);
                } else {
                    this.mExternalRenderCallback.enableHDR(true);
                }
            }
            if (getIjkMediaPlayerItem() != null && getIjkMediaPlayerItem().getHDRVideoType() == 0 && getIjkMediaPlayerItem().getHDRRenderType() == 0) {
                if (getIjkMediaPlayerItem().isTryHwHdr()) {
                    this.mExternalRenderCallback.enableHDRTryHW(false);
                } else {
                    this.mExternalRenderCallback.enableHDR(false);
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder sh) {
        Surface surface;
        if (this.mIsRelease) {
            return;
        }
        this.mSurfaceHolder = sh;
        if (sh != null) {
            surface = sh.getSurface();
        } else {
            surface = null;
        }
        this.mDisplaySurface = surface;
        BLog.i(TAG, "setDisplay " + surface);
        if (this.mExternalRenderThread != null && this.mEnableExternalRender) {
            if (surface == null) {
                this.mExternalRenderThread.releaseWindowSurface();
            } else {
                this.mExternalRenderThread.createWindowSurface(surface);
            }
        }
        if (this.tryEnableHdrLater && surface != null) {
            BLog.i(TAG, "setDisplay try enableHdr! surface:" + surface);
            updateHdrConfig();
            this.tryEnableHdrLater = false;
        }
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(8, surface));
    }

    public void resetHasCallFirstFrame() {
        if (this.mExternalRenderThread != null) {
            this.mExternalRenderThread.resetHasCallFirstFrame();
        }
    }

    public boolean isExternalRenderEnable() {
        return this.mEnableExternalRender;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        BLog.i(TAG, "setSurface " + surface);
        if (this.mIsRelease) {
            return;
        }
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        this.mDisplaySurface = surface;
        if (this.mEnableExternalRender && this.mExternalRenderThread != null) {
            if (surface == null) {
                this.mExternalRenderThread.releaseWindowSurface();
            } else {
                this.mExternalRenderThread.createWindowSurface(surface);
            }
        }
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(8, surface));
    }

    public void setAndroidIOCallback() {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(26));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException {
        if (this.mIsRelease) {
            return;
        }
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
        if (0 == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if (0 == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        android.util.Log.d(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r11.toString(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
        return;
     */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "setDataSource " + uri.toString());
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        } else {
            AssetFileDescriptor fd = null;
            try {
                ContentResolver resolver = context.getContentResolver();
                AssetFileDescriptor fd2 = resolver.openAssetFileDescriptor(uri, "r");
                if (fd2 == null) {
                    if (fd2 != null) {
                        fd2.close();
                        return;
                    }
                    return;
                }
                if (fd2.getDeclaredLength() < 0) {
                    setDataSource(fd2.getFileDescriptor());
                } else {
                    setDataSource(fd2.getFileDescriptor(), fd2.getStartOffset(), fd2.getDeclaredLength());
                }
                if (fd2 != null) {
                    fd2.close();
                }
            } catch (IOException e) {
            } catch (SecurityException e2) {
            } catch (Throwable th) {
                if (0 != 0) {
                    fd.close();
                }
                throw th;
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String path) {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "setDataSource " + path);
        this.mDataSource = path;
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(9, path));
    }

    public void setDataSourceBase64(String path) {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "setDataSourceBase64 " + path);
        this.mDataSource = path;
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(10, path));
    }

    public void setDataSource(String path, Map<String, String> headers) throws IOException {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "setDataSource " + path);
        if (headers != null && !headers.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,pipe,rtp,tcp,tls,udp,ijkurlhook,data,ijknetwork");
            }
        }
        setDataSource(path);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fd) throws IOException {
        BLog.i(TAG, "setDataSource " + fd);
        ParcelFileDescriptor pfd = ParcelFileDescriptor.dup(fd);
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(12, pfd));
    }

    private void setDataSource(FileDescriptor fd, long offset, long length) throws IOException {
        BLog.i(TAG, "setDataSource " + fd);
        if (this.mIsRelease) {
            return;
        }
        setDataSource(fd);
    }

    public void setIjkMediaPlayerItem(IjkMediaPlayerItem item) {
        this.mStartTime = SystemClock.elapsedRealtime();
        if (item == null || !item.connect() || this.mItem != null) {
            BLog.w(TAG, "setIjkMediaPlayerItem use error item or mItem != null mItem = " + this.mItem);
            return;
        }
        BLog.i(TAG, "[PlayRecordDetail][setItem] cid = " + item.getCid());
        if (!this.mIsRelease) {
            item.start();
            IjkMediaPlayerTracker track = item.getIjkMediaPlayerTracker();
            if (track != null) {
                this.mIjkMediaPlayerTracker = track;
            }
            synchronized (this) {
                this.mItem = item;
            }
        } else {
            BLog.i(TAG, "can not start, player is released");
        }
        Bundle args = new Bundle();
        args.putLong("timestamp", SystemClock.elapsedRealtime());
        args.putInt("itemPlay", 1);
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(32, new Pair(item, args)));
    }

    public IjkMediaPlayerItem getIjkMediaPlayerItem() {
        return this.mItem;
    }

    public void enableDolbyHDR(String configPath) {
        BLog.i(TAG, "enableDolbyHDR()");
        if (this.mEnableExternalRender) {
            synchronized (this.mRenderLock) {
                if (this.mExternalRenderCallback != null) {
                    this.mExternalRenderCallback.enableDolbyHDR(configPath);
                }
            }
        }
    }

    public void isHdrVivid(boolean enable) {
        BLog.i(TAG, "isHdrVivid()" + enable);
        if (this.mEnableExternalRender) {
            synchronized (this.mRenderLock) {
                if (this.mExternalRenderCallback != null) {
                    this.mExternalRenderCallback.isHdrVivid(enable);
                }
            }
        }
    }

    public void disableDolbyHDR() {
        BLog.i(TAG, "disableDolbyHDR()");
        if (this.mEnableExternalRender) {
            synchronized (this.mRenderLock) {
                if (this.mExternalRenderCallback != null) {
                    this.mExternalRenderCallback.disableDolbyHDR();
                }
            }
        }
    }

    public void disableExternalRender() {
        if (this.mEnableExternalRender) {
            if (this.mIsDrm) {
                BLog.i("cancel mEnableExternalAfterDrm");
            }
            BLog.i(TAG, "disableExternalRender()");
            synchronized (this.mRenderLock) {
                this.mEnableExternalRender = false;
                if (this.mExternalRenderThread != null) {
                    this.mExternalRenderThread.quitExternalRender();
                    this.mExternalRenderThread = null;
                }
                if (this.mPlayer != null && msIjkserviceIsConnected) {
                    try {
                        this.mPlayer.setSurface(null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                setSurface(this.mDisplaySurface);
            }
        }
    }

    public void enableExternalRender() {
        if (this.mEnableExternalRender) {
            return;
        }
        if (this.mIsDrm) {
            BLog.i("enable mEnableExternalAfterDrm");
        }
        BLog.i(TAG, "enableExternalRender()");
        this.mEnableExternalRender = true;
        if (this.mExternalRenderCallback == null) {
            this.mExternalRenderCallback = new IJKPlayerExternalRender();
        }
        synchronized (this.mRenderLock) {
            try {
                if (this.mExternalRenderThread == null && !this.mIsRelease) {
                    this.mExternalRenderThread = new IjkExternalRenderThread();
                    this.mExternalRenderThread.setPlayerPauseStateCallback(new IjkExternalRenderThread.GetPlayerPauseStateCallback() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.2
                        @Override // tv.danmaku.ijk.media.player.render.IjkExternalRenderThread.GetPlayerPauseStateCallback
                        public boolean isPlayerPause() {
                            return !IjkMediaPlayer.this.isPlaying();
                        }
                    });
                    this.mExternalRenderThread.setRenderCallback(this.mExternalRenderCallback);
                }
                if (this.mSomeWorkHandle != null && msIjkserviceIsConnected) {
                    this.mSomeWorkHandle.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (IjkMediaPlayer.this.mPlayer != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                                try {
                                    IjkMediaPlayer.this.mPlayer.setSurface(null);
                                    IjkMediaPlayer.this.mPlayer.setExternalRenderSurface(IjkMediaPlayer.this.mExternalRenderThread.getAmcSurface(), IjkMediaPlayer.this.mExternalRenderThread.getAvSurface());
                                } catch (Exception e) {
                                    BLog.e(IjkMediaPlayer.TAG, e);
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                BLog.e(TAG, e);
            }
        }
    }

    private void stopOldIjkItem(IjkMediaPlayerItem newItem) {
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.updatePlayerState(getJavaErrorCode(), mIjkserviceInitTime);
        }
        synchronized (this) {
            if (this.mItem != null) {
                this.mItem.disconnect();
                this.mItem.stop();
            }
            this.mItem = newItem;
            this.mEventHandler.removeCallbacksAndMessages(null);
            this.mEventFlushRequest = true;
        }
    }

    public void replaceCurrentItem(IjkMediaPlayerItem item) {
        this.mStartTime = SystemClock.elapsedRealtime();
        if (item == null || !item.connect() || item == this.mItem) {
            BLog.w(TAG, "replaceCurrentItem use error item, item connect fail " + item);
            return;
        }
        BLog.i(TAG, "[PlayRecordDetail][replaceItem] cid = " + item.getCid() + " item hdr type :" + item.getHDRVideoType());
        stopOldIjkItem(item);
        Bundle args = new Bundle();
        args.putLong("timestamp", SystemClock.elapsedRealtime());
        args.putInt("itemPlay", 2);
        Long.valueOf(SystemClock.elapsedRealtime());
        this.isPrepared = false;
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            this.mSomeWorkHandle.removeMessages(32);
            this.mSomeWorkHandle.obtainMessage(32, new Pair(item, args)).sendToTarget();
        } else {
            synchronized (this.mWaitList) {
                if (this.mPlayer != null && msIjkserviceIsConnected) {
                    this.mSomeWorkHandle.removeMessages(32);
                    this.mSomeWorkHandle.obtainMessage(32, new Pair(item, args)).sendToTarget();
                } else {
                    this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(32, new Pair(item, args)));
                }
            }
        }
        if (this.mExternalRenderCallback != null) {
            this.mExternalRenderCallback.flushVividDataList();
            this.mExternalRenderCallback.clearEnhanceState();
        }
        BLog.i(TAG, "replaceCurrentItem duration =  " + (SystemClock.elapsedRealtime() - this.mStartTime));
        this.mIsActivity = true;
        IjkPlayerManager.getInstance().updatePlayerActivity();
    }

    public void removeIjkMediaPlayerItem(IjkMediaPlayerItem item) {
        if (this.mItem == null || this.mItem != item) {
            BLog.w(TAG, " removeIjkMediaPlayerItem fail " + item);
            return;
        }
        BLog.i(TAG, "removeIjkMediaPlayerItem");
        this.mIsActivity = false;
        IjkPlayerManager.getInstance().updatePlayerActivity();
        stopOldIjkItem(null);
        Bundle args = new Bundle();
        this.isPrepared = false;
        args.putLong("timestamp", SystemClock.elapsedRealtime());
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            this.mSomeWorkHandle.removeMessages(32);
            this.mSomeWorkHandle.obtainMessage(32, new Pair(null, args)).sendToTarget();
        } else {
            synchronized (this.mWaitList) {
                if (this.mPlayer == null || !msIjkserviceIsConnected) {
                    this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(32, new Pair(null, args)));
                } else {
                    this.mSomeWorkHandle.removeMessages(32);
                    this.mSomeWorkHandle.obtainMessage(32, new Pair(null, args)).sendToTarget();
                }
            }
        }
        if (this.mExternalRenderCallback != null) {
            this.mExternalRenderCallback.flushVividDataList();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "IjkMediaPlayerTracker prepareAsync enter");
        IjkMediaPlayerItem item = getIjkMediaPlayerItem();
        if (this.mIjkMediaPlayerTracker != null) {
            if (item == null) {
                this.mIjkMediaPlayerTracker.setItemPlay(0);
            } else if (item.isPreload()) {
                this.mIjkMediaPlayerTracker.setItemPlay(11);
            } else {
                this.mIjkMediaPlayerTracker.setItemPlay(1);
            }
            this.mIjkMediaPlayerTracker.willPrepare(this, SystemClock.elapsedRealtime(), null);
        }
        this.isPrepared = false;
        this.mRunning = true;
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(2));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "start");
        if (this.isPlaybackComplete) {
            this.isPlaybackComplete = false;
            if (this.mIjkMediaPlayerTracker != null) {
                this.mIjkMediaPlayerTracker.playerComplete(false);
            }
        }
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(3));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "stop");
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(7));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "pause");
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(5));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int mode) {
        boolean washeld = false;
        if (this.mWakeLock != null) {
            if (this.mWakeLock.isHeld()) {
                washeld = true;
                this.mWakeLock.release();
            }
            this.mWakeLock = null;
        }
        PowerManager pm = (PowerManager) context.getSystemService("power");
        this.mWakeLock = pm.newWakeLock(536870912 | mode, IjkMediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
        if (washeld) {
            this.mWakeLock.acquire();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean screenOn) {
        if (this.mScreenOnWhilePlaying != screenOn) {
            if (screenOn && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = screenOn;
            updateSurfaceScreenOn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stayAwake(boolean awake) {
        if (this.mWakeLock != null) {
            if (awake && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!awake && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        if (this.mStayAwake != awake) {
            this.mStayAwake = awake;
            this.mIsActivity = this.mStayAwake;
            IjkPlayerManager.getInstance().updatePlayerActivity();
        }
        updateSurfaceScreenOn(false);
    }

    private void updateSurfaceScreenOn(boolean needSeek) {
        if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
        if (needSeek && this.mItem != null && this.mItem.isLive() && AbrParamsInterface.IsEnableFirstFrameOpt()) {
            return;
        }
        if ((this.mIsDrm && !this.isPlaybackComplete) || (needSeek && this.isPrepared)) {
            seekTo(getCurrentPosition());
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public IjkTrackInfo[] getTrackInfo() {
        Bundle bundle;
        IjkMediaMeta mediaMeta;
        if (this.mIsRelease || (bundle = getMediaMeta()) == null || (mediaMeta = IjkMediaMeta.parse(bundle)) == null || mediaMeta.mStreams == null) {
            return null;
        }
        ArrayList<IjkTrackInfo> trackInfos = new ArrayList<>();
        Iterator<IjkMediaMeta.IjkStreamMeta> it = mediaMeta.mStreams.iterator();
        while (it.hasNext()) {
            IjkMediaMeta.IjkStreamMeta streamMeta = it.next();
            IjkTrackInfo trackInfo = new IjkTrackInfo(streamMeta);
            if (streamMeta.mType.equalsIgnoreCase("video")) {
                trackInfo.setTrackType(1);
            } else if (streamMeta.mType.equalsIgnoreCase("audio")) {
                trackInfo.setTrackType(2);
            } else if (streamMeta.mType.equalsIgnoreCase("timedtext")) {
                trackInfo.setTrackType(3);
            }
            trackInfos.add(trackInfo);
        }
        return (IjkTrackInfo[]) trackInfos.toArray(new IjkTrackInfo[trackInfos.size()]);
    }

    private long getPlayerPropertyLong(int property, long defaultValue) {
        if (this.mIsRelease) {
            return defaultValue;
        }
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getPropertyLong(property, defaultValue);
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return defaultValue;
    }

    private float getPlayerPropertyFloat(int property, float defaultValue) {
        if (this.mIsRelease) {
            return defaultValue;
        }
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getPropertyFloat(property, defaultValue);
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return defaultValue;
    }

    public int getSelectedTrack(int trackType) {
        switch (trackType) {
            case 1:
                return (int) getPlayerPropertyLong(FFP_PROP_INT64_SELECTED_VIDEO_STREAM, -1L);
            case 2:
                return (int) getPlayerPropertyLong(FFP_PROP_INT64_SELECTED_AUDIO_STREAM, -1L);
            case 3:
                return (int) getPlayerPropertyLong(FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM, -1L);
            default:
                return -1;
        }
    }

    public void selectTrack(int track) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(13, track, 1));
    }

    public void deselectTrack(int track) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(13, track, 0));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        if (!this.mIsRelease && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.isPlaying();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long msec) {
        seekTo(msec, false);
    }

    public void seekTo(long msec, boolean accurate) {
        seekTo(msec, accurate, false);
    }

    public void seekTo(long msec, boolean accurate, boolean async) {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "seekTo " + msec + " accurate " + accurate + " async = " + async);
        if (async) {
            doAsyncTask(this.mSomeWorkHandle.obtainMessage(14, accurate ? 1 : 0, 0, Long.valueOf(msec)));
        } else if (this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                this.mPlayer.seekTo(msec, accurate ? 1 : 0);
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        } else {
            seekTo(msec, accurate, true);
        }
        if (this.mExternalRenderCallback != null) {
            this.mExternalRenderCallback.flushVividDataList();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        if (!this.mIsRelease && this.isPrepared && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getCurrentPosition();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return 0L;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        if (this.mIsRelease) {
            return 0L;
        }
        return this.mDuration;
    }

    public void handleRelease() {
        resetListeners();
        getIjkMediaPlayerItem();
        this.mSomeWorkHandle.removeCallbacksAndMessages(null);
        removeEndpointChangeListener();
        synchronized (this.mWaitList) {
            this.mWaitList.clear();
        }
        if (this.mPlayer != null) {
            try {
                this.mPlayer.release();
                if (this.mClient != null) {
                    msIjkMediaPlayerServiceConnection.unregisterClient(this.mClient.hashCode());
                }
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        this.mHandleThread.quit();
        this.mPlayer = null;
        this.mClient = null;
        this.mDisplaySurface = null;
    }

    public void syncRelease() {
        stayAwake(false);
        resetListeners();
        removeEndpointChangeListener();
        getIjkMediaPlayerItem();
        synchronized (this.mWaitList) {
            this.mSomeWorkHandle.removeCallbacksAndMessages(null);
            this.mHandleThread.quit();
            this.mWaitList.clear();
        }
        try {
            this.mHandleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.mPlayer != null) {
            try {
                this.mPlayer.setSurface(null);
                this.mPlayer.pause();
                this.mPlayer.release();
                if (this.mClient != null) {
                    msIjkMediaPlayerServiceConnection.unregisterClient(this.mClient.hashCode());
                }
            } catch (RemoteException e2) {
                onBuglyReport(e2);
            }
        }
        this.mClient = null;
        this.mPlayer = null;
    }

    public IJKPlayerExternalRender getExternalRender() {
        return this.mExternalRenderCallback;
    }

    public void updateEnhanceInfoForTracker(boolean enable, IJKEXTRendererInterface.IjkEnhanceType type) {
        if (this.mIjkMediaPlayerTracker != null) {
            int enhanceType = -1;
            if (enable) {
                enhanceType = type.getValue();
            }
            this.mIjkMediaPlayerTracker.setEnhanceType(enhanceType);
            BLog.i(TAG, "[PlayRecordDetail] update enhance info, enable:%" + enable + ",enhanceType:" + enhanceType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnhanceStateForQn(int qn) {
        if (AbrParamsInterface.IsEnableVodEnhance() && this.mItem != null && this.mEnableExternalRender && this.mExternalRenderCallback != null) {
            boolean enable = this.mItem.qnShouldEnhance(qn);
            BLog.i(TAG, "[PlayRecordDetail] updateEnhanceStateForQn, currentQn:%" + qn + ",shouldEnhance:" + enable);
            this.mExternalRenderCallback.setEnhance(enable, IJKEXTRendererInterface.IjkEnhanceType.ShaderPlus);
            updateEnhanceInfoForTracker(enable, IJKEXTRendererInterface.IjkEnhanceType.ShaderPlus);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "IjkMediaPlayer release [" + this + "]");
        IjkPlayerManager.getInstance().unregisterPlayer(this);
        stopOldIjkItem(null);
        if (this == mCurPlayer) {
            mCurPlayer = null;
        }
        this.mIsRelease = true;
        this.mRunning = false;
        IjkMediaPlayerMonitor.getInstance().pause();
        synchronized (this.mRenderLock) {
            if (this.mExternalRenderThread != null) {
                this.mExternalRenderThread.quitExternalRender();
                this.mExternalRenderThread = null;
            }
        }
        stayAwake(false);
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                this.mPlayer.setSurface(null);
                this.mPlayer.pause();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.mSomeWorkHandle.obtainMessage(4).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && msIjkserviceIsConnected) {
                try {
                    this.mPlayer.pause();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                this.mSomeWorkHandle.obtainMessage(4).sendToTarget();
                return;
            }
            this.mWaitList.clear();
            this.mSomeWorkHandle.removeCallbacksAndMessages(null);
            this.mHandleThread.quit();
            try {
                this.mHandleThread.join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void syncReset() {
        if (this.mIsRelease) {
            return;
        }
        synchronized (this.mWaitList) {
            this.mSomeWorkHandle.removeCallbacksAndMessages(null);
            this.mWaitList.clear();
        }
        try {
            if (this.mPlayer != null && msIjkserviceIsConnected) {
                this.mPlayer.pause();
                this.mPlayer.reset();
                stayAwake(false);
            }
        } catch (RemoteException e) {
            onBuglyReport(e);
        }
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        BLog.i(TAG, "reset ");
        syncReset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean looping) {
        if (this.mIsRelease) {
            return;
        }
        BLog.i(TAG, "setLooping " + looping);
        int loopCount = !looping ? 1 : 0;
        setOption(4, "loop", loopCount);
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(15, loopCount, 0));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        if (this.mIsRelease) {
            return false;
        }
        int loopCount = 0;
        if (this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                loopCount = this.mPlayer.getLoopCount();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return loopCount != 1;
    }

    public void setSpeed(float speed) {
        if (this.mIsRelease) {
            return;
        }
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(16, 10003, 0, Float.valueOf(speed)));
    }

    public float getSpeed(float speed) {
        return getPlayerPropertyFloat(10003, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    public float getAvdiff() {
        return getPlayerPropertyFloat(10005, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    public int getVideoDecoder() {
        return (int) getPlayerPropertyLong(FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    public float getVideoOutputFramesPerSecond() {
        return getPlayerPropertyFloat(10002, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    public float getVideoDecodeFramesPerSecond() {
        return getPlayerPropertyFloat(10001, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    public long getVideoCachedDuration() {
        return getPlayerPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    public long getAudioCachedDuration() {
        return getPlayerPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    public long getVideoCachedBytes() {
        return getPlayerPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    public long getAudioCachedBytes() {
        return getPlayerPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    private long getNativeErrorCode() {
        if (this.mIsRelease || this.mItem == null) {
            return 0L;
        }
        return this.mItem.getPlayerError() | this.mItem.getItemError();
    }

    private long getJavaErrorCode() {
        if (this.mIsRelease) {
            return 0L;
        }
        long ret = this.mIllegalPrepare ? 1L : 0L;
        return ret | (msIjkserviceAbnormal ? IJK_SERVICE_ERROR_BASE : 0L);
    }

    public long getPlayerErrorCode() {
        long javaError = getJavaErrorCode();
        long nativeError = getNativeErrorCode();
        return javaError | nativeError;
    }

    public String getIjkLoadFailReason() {
        if (this.mIjkMediaPlayerTracker == null) {
            return "no_ijk_tracker";
        }
        long playerErrorCode = getPlayerErrorCode();
        return this.mIjkMediaPlayerTracker.getLoadFailNetworkErrorString(playerErrorCode);
    }

    public static IjkStatus getIjkStatus() {
        long currentTs = SystemClock.elapsedRealtime();
        IjkMediaPlayer player = mCurPlayer;
        if (player == null) {
            mIjkStatus = new IjkStatus();
        } else if (currentTs - mIjkStatusLastUpdateTs > 1000) {
            player.updateIjkStatus();
            mIjkStatusLastUpdateTs = currentTs;
        }
        return mIjkStatus;
    }

    public static IjkStatus getIjkStatusThreadSafe() {
        return mIjkStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateIjkStatus() {
        Bundle playerData = getPropertiesBundle(FFP_PROP_INT64_VIDEO_CACHED_DURATION, FFP_PROP_INT64_AUDIO_CACHED_DURATION, FFP_PROP_INT64_LIVE_DELAY, FFP_PROP_INT64_CACHE_CUR_BITRATE, FFP_PROP_INT64_CACHE_CUR_STABLE_SPEED, FFP_PROP_INT64_CACHE_CUR_TCP_SPEED, 10005);
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.updateIjkStatus(mIjkStatus);
        }
        mIjkStatus.playbackStrategy.jitterBufferRatio = getSpeed(1.0f);
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null && mediaInfo.mMeta != null) {
            IjkMediaMeta meta = mediaInfo.mMeta;
            IjkMediaMeta.IjkStreamMeta videoStream = meta.mVideoStream;
            mIjkStatus.streamInfo.videoDecoder = mediaInfo.mVideoDecoder + "," + mediaInfo.mVideoDecoderImpl;
            if (videoStream != null) {
                mIjkStatus.streamInfo.videoFps = videoStream.getFps();
                mIjkStatus.streamInfo.videoResolution = videoStream.getResolution();
                mIjkStatus.streamInfo.videoCodec = videoStream.getCodecShortNameInline();
                mIjkStatus.streamInfo.videoEncoder = videoStream.mEncoder;
            }
            IjkMediaMeta.IjkStreamMeta audioStream = meta.mAudioStream;
            if (audioStream != null) {
                mIjkStatus.streamInfo.sampleRate = audioStream.mSampleRate;
                mIjkStatus.streamInfo.channelLayout = audioStream.mChannelLayout;
                mIjkStatus.streamInfo.audioCodec = audioStream.getCodecShortNameInline();
            }
        }
        mIjkStatus.playbackInfo.videoCache = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
        mIjkStatus.playbackInfo.audioCache = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
        mIjkStatus.playbackInfo.liveDelayTime = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_LIVE_DELAY, 0L);
        mIjkStatus.playbackInfo.curBitrate = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_CACHE_CUR_BITRATE, 0L) * 8;
        mIjkStatus.playbackInfo.curNetSpeed = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_CACHE_CUR_TCP_SPEED, 0L) * 8;
        long curStableSpeed = IjkUtils.getPropetyLong(playerData, FFP_PROP_INT64_CACHE_CUR_STABLE_SPEED, 0L);
        if (curStableSpeed > 0) {
            mIjkStatus.playbackInfo.curStableSpeed = curStableSpeed;
            mIjkStatus.playbackInfo.stableSpeedTimestamp = System.currentTimeMillis();
        }
        mIjkStatus.playbackInfo.avDiff = IjkUtils.getPropetyFloat(playerData, 10005, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        if (this.mItem != null) {
            Bundle itemData = this.mItem.getPropertiesBundle(FFP_PROP_INT64_SKIP_FRAME_COUNT, FFP_PROP_INT64_PLAYER_ERROR_CODE, 10007, FFP_PROP_INT64_ITEM_ERROR_CODE);
            long nativeError = IjkUtils.getPropetyLong(itemData, FFP_PROP_INT64_PLAYER_ERROR_CODE, 0L);
            mIjkStatus.playbackInfo.lastestPlayerError = getJavaErrorCode() | nativeError;
            mIjkStatus.playbackInfo.lastestItemError = IjkUtils.getPropetyLong(itemData, FFP_PROP_INT64_ITEM_ERROR_CODE, 0L);
            mIjkStatus.playbackStrategy.skipFrameCount = (int) IjkUtils.getPropetyLong(itemData, FFP_PROP_INT64_SKIP_FRAME_COUNT, 0L);
            mIjkStatus.playbackInfo.videoDropRate = IjkUtils.getPropetyFloat(itemData, 10007, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
    }

    public long getPlayerStatus() {
        return getPlayerPropertyLong(FFP_PROP_INT64_PLAYER_STATUS, 0L);
    }

    public long getCacheCurBitrate() {
        return getPlayerPropertyLong(FFP_PROP_INT64_CACHE_CUR_BITRATE, 0L);
    }

    public long getCacheCurTcpSpeed() {
        return getPlayerPropertyLong(FFP_PROP_INT64_CACHE_CUR_TCP_SPEED, 0L);
    }

    public long getBufferingVideoCachedPackets() {
        return getPlayerPropertyLong(FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_PACKETS, 0L);
    }

    public long getRealCurrentPosition() {
        if (this.isPrepared) {
            return getPlayerPropertyLong(FFP_PROP_INT64_REAL_CURRENT_POSITION, 0L);
        }
        return 0L;
    }

    public long getTcpSpeed() {
        if (this.mItem != null) {
            return this.mItem.getTcpSpeed();
        }
        return getPlayerPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public float getDropFrameRate() {
        if (this.mItem != null) {
            return this.mItem.getDropFrameRate();
        }
        return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float leftVolume, float rightVolume) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(18, new Pair(Float.valueOf(leftVolume), Float.valueOf(rightVolume))));
    }

    public void setVolume(float volume) {
        setVolume(volume, volume);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        if (!this.mIsRelease && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getAudioSessionId();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return 0;
    }

    public MediaInfo getMediaInfoInternal(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String videoCodecInfo = bundle.getString(IjkMediaMeta.IJKM_VIDEO_CODEC_INFO, "");
        if (!TextUtils.isEmpty(videoCodecInfo)) {
            String[] nodes = videoCodecInfo.split(",");
            if (nodes.length >= 2) {
                mediaInfo.mVideoDecoder = nodes[0];
                mediaInfo.mVideoDecoderImpl = nodes[1];
            } else if (nodes.length >= 1) {
                mediaInfo.mVideoDecoder = nodes[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String audioCodecInfo = bundle.getString(IjkMediaMeta.IJKM_AUDIO_CODEC_INFO, "");
        if (!TextUtils.isEmpty(audioCodecInfo)) {
            String[] nodes2 = audioCodecInfo.split(",");
            if (nodes2.length >= 2) {
                mediaInfo.mAudioDecoder = nodes2[0];
                mediaInfo.mAudioDecoderImpl = nodes2[1];
            } else if (nodes2.length >= 1) {
                mediaInfo.mAudioDecoder = nodes2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = IjkMediaMeta.parse(bundle);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return mediaInfo;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (this.mIsRelease) {
            return null;
        }
        Bundle bundle = getMediaMeta();
        return getMediaInfoInternal(bundle);
    }

    public void setSwitchNonAutoTargetQn(int qn) {
        if (!this.mIsRelease && this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "[setSwitchNonAutoTargetQn] qn=" + qn);
            this.mIjkMediaPlayerTracker.setSwitchNonAutoTargetQn(qn);
        }
    }

    public void switchDashVideoStream(int id) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(28, id, 0));
    }

    public void switchDashAudioStream(int id) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(29, id, 0));
    }

    public void setDashAuto(boolean flag) {
        Bundle args = new Bundle();
        args.putBoolean("flag", flag);
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(30, 0, 0, args));
    }

    public boolean getDashAuto() {
        if (this.mIjkMediaPlayerTracker != null) {
            return this.mIjkMediaPlayerTracker.getDashAuto();
        }
        return false;
    }

    public void notifyLiveQnChange(int curQn, int targetQn, String newUrl, LiveSwitchQnMode switchQnMode) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "[PlayRecordDetail][notifyLiveQnChange] curQn=" + curQn + ", targetQn=" + targetQn + ", switchQnMode=" + switchQnMode);
            this.mIjkMediaPlayerTracker.notifyLiveQnChange(this, curQn, targetQn, newUrl, switchQnMode);
        }
    }

    public void notifyP2pUrlChange(String newUrl, String extraInfo) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "[PlayRecordDetail][notifyP2pUrlChange] newUrl=" + newUrl + ",extraInfo=" + extraInfo);
            this.mIjkMediaPlayerTracker.notifyP2pUrlChange(newUrl, extraInfo);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean enable) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    public void setOption(int category, String name, String value) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(19, category, 0, new Pair(name, value)));
    }

    public void setOption(int category, String name, long value) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(20, category, 0, new Pair(name, Long.valueOf(value))));
    }

    private Bundle getMediaMeta() {
        if (!this.mIsRelease && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getMediaMeta();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDashStreamInfo(Bundle dashStreamInfo) {
        synchronized (this) {
            this.mDashStreamInfo = dashStreamInfo;
        }
    }

    public Bundle getDashStreamInfo() {
        Bundle bundle;
        if (this.mIsRelease || this.mIsDrm) {
            return null;
        }
        synchronized (this) {
            bundle = this.mDashStreamInfo;
        }
        return bundle;
    }

    public String getColorFormatName(int mediaCodecColorFormat) {
        if (!this.mIsRelease && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getColorFormatName(mediaCodecColorFormat);
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int streamtype) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean keepInBackground) {
    }

    protected void finalize() throws Throwable {
        super.finalize();
        stayAwake(false);
        updateSurfaceScreenOn(false);
        resetListeners();
    }

    public void setAudioOnly(boolean enable) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(17, FFP_PROP_INT64_AUDIO_ONLY, 0, Long.valueOf(enable ? 1L : 0L)));
    }

    public void setLiveDelayTime(int time) {
    }

    public boolean isAudioOnly() {
        long ret = getPlayerPropertyLong(FFP_PROP_INT64_AUDIO_ONLY, 0L);
        return ret != 0;
    }

    public Bundle getPropertiesBundle(int... keys) {
        if (!this.mIsRelease && this.mPlayer != null && msIjkserviceIsConnected) {
            try {
                return this.mPlayer.getPropertiesBundle(keys);
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return null;
    }

    public void setOnControlMessageListener(OnControlMessageListener listener) {
        this.mOnControlMessageListener = listener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener listener) {
        this.mOnNativeInvokeListener = listener;
    }

    public void setOnServiceIsConnectedListener(OnServiceIsConnectedListener listener) {
        this.mOnServiceIsConnectedListener = listener;
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener listener) {
        this.mOnMediaCodecSelectListener = listener;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener
        public String onMediaCodecSelect(IMediaPlayer mp, String mimeType, int profile, int level) {
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", mimeType, Integer.valueOf(profile), Integer.valueOf(level)));
            String bestCodecName = IjkCodecHelper.getBestCodecNameWithProfile(mimeType, profile, level);
            if (TextUtils.isEmpty(bestCodecName)) {
                return null;
            }
            return bestCodecName;
        }
    }

    public void setOnRawDataWriteListener(OnRawDataWriteListener listener) {
        this.mOnRawDataWriteListener = listener;
    }

    public void setOnSeiDataWriteListener(OnSeiDataWriteListener listener) {
        this.mOnSeiDataWriteListener = listener;
    }

    public void setOnDownloadSeiDataWriteListener(OnDownloadSeiDataWriteListener listener) {
        this.mOnDownloadSeiDataWriteListener = listener;
    }

    public void setOnVideoDisplayCallback(OnVideoDisplayCallback callback) {
        this.mOnVideoDisplayCallback = callback;
        setPropertyLong(FFP_PROP_INT64_ENABLE_VIDEO_DISPLAY_CALLBACK, callback == null ? 0 : 1);
    }

    public void setOnVideoFirstFrameRenderListener(OnVideoFirstFrameRenderListener listener) {
        this.mOnVideoFirstFrameRenderListener = listener;
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
        this.mOnRawDataWriteListener = null;
        this.mOnSeiDataWriteListener = null;
        this.mOnDownloadSeiDataWriteListener = null;
        this.mOnVideoDisplayCallback = null;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultRawDataWriter implements OnRawDataWriteListener {
        public static final DefaultRawDataWriter sInstance = new DefaultRawDataWriter();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnRawDataWriteListener
        public int onRawDataWrite(IMediaPlayer mp, byte[] data, int offset, int size, int freq, int channels, int samples) {
            return size;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultSeiDataWriter implements OnSeiDataWriteListener {
        public static final DefaultSeiDataWriter sInstance = new DefaultSeiDataWriter();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnSeiDataWriteListener
        public int onSeiDataWrite(IMediaPlayer mp, byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
            return 0;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultOnDownloadSeiDataWriter implements OnDownloadSeiDataWriteListener {
        public static final DefaultOnDownloadSeiDataWriter sInstance = new DefaultOnDownloadSeiDataWriter();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnDownloadSeiDataWriteListener
        public int onDownloadSeiDataWrite(IMediaPlayer mp, byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
            return 0;
        }
    }

    public void nativeProfileBegin(String libName) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(22, libName));
    }

    public void nativeProfileEnd() {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(23));
    }

    public void nativeSetLogLevel(int level) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(24, level, 0));
    }

    public boolean updateDns(boolean updateAll) {
        return true;
    }

    public void flushCache() {
    }

    public void setPropertyLong(int what, long value) {
        doAsyncTask(this.mSomeWorkHandle.obtainMessage(17, what, 0, Long.valueOf(value)));
    }

    private void addEndpointChangeListener() {
        IjkAudioKit.sharedInstance(this.mContext).addListener(new IjkAudioKit.IjkAudioKitCallback() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.4
            @Override // tv.danmaku.ijk.media.player.utils.IjkAudioKit.IjkAudioKitCallback
            public void onEndpointChange(IjkAudioKit.IjkAudioKitEndpoint endpoint) {
                switch (AnonymousClass5.$SwitchMap$tv$danmaku$ijk$media$player$utils$IjkAudioKit$IjkAudioKitEndpoint[endpoint.ordinal()]) {
                    case 1:
                        IjkMediaPlayer.this.setPropertyLong(IjkMediaPlayer.FFP_PROP_INT64_EAC3_ENDPOINT, 1L);
                        return;
                    default:
                        IjkMediaPlayer.this.setPropertyLong(IjkMediaPlayer.FFP_PROP_INT64_EAC3_ENDPOINT, 2L);
                        return;
                }
            }
        });
    }

    /* renamed from: tv.danmaku.ijk.media.player.IjkMediaPlayer$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$tv$danmaku$ijk$media$player$utils$IjkAudioKit$IjkAudioKitEndpoint = new int[IjkAudioKit.IjkAudioKitEndpoint.values().length];

        static {
            try {
                $SwitchMap$tv$danmaku$ijk$media$player$utils$IjkAudioKit$IjkAudioKitEndpoint[IjkAudioKit.IjkAudioKitEndpoint.IjkAudioKitEndpointSpeaker.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$tv$danmaku$ijk$media$player$utils$IjkAudioKit$IjkAudioKitEndpoint[IjkAudioKit.IjkAudioKitEndpoint.IjkAudioKitEndpointHeadphone.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$tv$danmaku$ijk$media$player$utils$IjkAudioKit$IjkAudioKitEndpoint[IjkAudioKit.IjkAudioKitEndpoint.IjkAudioKitEndpointUnknown.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void removeEndpointChangeListener() {
        IjkAudioKit.sharedInstance(this.mContext).removeAllListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEac3Endpoint() {
        if (IjkAudioKit.sharedInstance(this.mContext).getEndpoint() == IjkAudioKit.IjkAudioKitEndpoint.IjkAudioKitEndpointSpeaker) {
            setPropertyLong(FFP_PROP_INT64_EAC3_ENDPOINT, 1L);
        } else {
            setPropertyLong(FFP_PROP_INT64_EAC3_ENDPOINT, 2L);
        }
    }

    public int getCurrentVideoId() {
        if (this.mIjkMediaPlayerTracker != null) {
            return this.mIjkMediaPlayerTracker.getCurVideoId();
        }
        return 0;
    }

    public int getCurrentAudioId() {
        if (this.mIjkMediaPlayerTracker != null) {
            return this.mIjkMediaPlayerTracker.getCurAudioId();
        }
        return 0;
    }

    public String getTrackerUrl(boolean isAudio) {
        if (this.mIjkMediaPlayerTracker != null) {
            return this.mIjkMediaPlayerTracker.getLastUrl(isAudio);
        }
        return null;
    }

    public int getTrackerBitrate(boolean isAudio) {
        if (this.mIjkMediaPlayerTracker != null) {
            return this.mIjkMediaPlayerTracker.getBitrate(isAudio);
        }
        return 0;
    }

    public String getIjkVersion() {
        if (!TextUtils.isEmpty(sIjkVersion)) {
            return sIjkVersion;
        }
        if (msIjkserviceIsConnected && this.mPlayer != null) {
            try {
                sIjkVersion = this.mPlayer.getVersion();
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        return sIjkVersion;
    }

    public float getVideoFps() {
        return this.mVideoFps;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBufferControl() {
        setBufferControlInternal(this.mBufferControl);
    }

    public void setBufferControl(int bufferControl) {
        if (this.mBufferControl != bufferControl) {
            setBufferControlInternal(bufferControl);
            this.mBufferControl = bufferControl;
        }
    }

    public int getBufferControl() {
        return this.mBufferControl;
    }

    private void setBufferControlInternal(int bufferControl) {
        BLog.i(TAG, "setBufferControlInternal bufferControl = " + bufferControl);
        setPropertyLong(FFP_PROP_INT64_BUFFER_CTRL, bufferControl);
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public boolean isReleased() {
        return this.mIsRelease;
    }

    public int getDefaultAudioIndex() {
        if (this.mIsRelease || this.mPlayer == null || !msIjkserviceIsConnected) {
            return -1;
        }
        try {
            return this.mPlayer.getDefaultAudioIndex();
        } catch (RemoteException e) {
            onBuglyReport(e);
            return -1;
        }
    }

    public int getCurrentAudioIndex() {
        if (this.mIsRelease || this.mPlayer == null || !msIjkserviceIsConnected) {
            return -1;
        }
        try {
            return this.mPlayer.getCurrentAudioIndex();
        } catch (RemoteException e) {
            onBuglyReport(e);
            return -1;
        }
    }

    public int switchAudioStream(int index) {
        if (this.mIsRelease || this.mPlayer == null || !msIjkserviceIsConnected) {
            return -1;
        }
        try {
            return this.mPlayer.switchAudioStream(index);
        } catch (RemoteException e) {
            onBuglyReport(e);
            return -1;
        }
    }

    public int[] getAudioStreamsIndex() {
        if (this.mIsRelease || this.mPlayer == null || !msIjkserviceIsConnected) {
            return new int[0];
        }
        try {
            return this.mPlayer.getAudioStreamsIndex();
        } catch (RemoteException e) {
            onBuglyReport(e);
            return new int[0];
        }
    }
}