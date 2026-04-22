package tv.danmaku.ijk.media.player;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import j$.util.Objects;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.ijk.media.player.IjkPerformanceManager;
import tv.danmaku.ijk.media.player.utils.IjkAudioKit;
import tv.danmaku.ijk.media.player.utils.IjkDrmUtils;
import tv.danmaku.ijk.media.player.utils.IjkMediaPlayerMonitor;
import tv.danmaku.ijk.media.player.utils.IjkNetworkManager;
import tv.danmaku.ijk.media.player.utils.P2PManuscriptInfo;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;
import video.base.utils.VBNumberExtKt;
import video.biz.offline.list.logic.tree.VideoFile;

public class IjkMediaPlayerItem implements IjkNetworkManager.NetWorkChangeListener {
    private static final int DASH_CODECID_AV1 = 13;
    private static final int DASH_CODECID_H264 = 7;
    private static final int DASH_CODECID_H265 = 12;
    private static final int DASH_CODECID_H266 = 14;
    private static final int DO_CHECK_CONNECT = 0;
    private static final int DO_CREATE = 1;
    private static final int DO_ITEM_CONNECT = 6;
    private static final int DO_P2P_LIVE_REPORT = 14;
    private static final int DO_RELEASE = 3;
    private static final int DO_RESET = 10;
    private static final int DO_SETDATASOURCE = 5;
    private static final int DO_SET_MULTI_AUDIO_STREAM = 18;
    private static final int DO_SET_P2P_MANUSCRIPT_INFO = 15;
    private static final int DO_SET_PARAMS = 7;
    private static final int DO_SET_PLAYERITEM_PRIORITY = 16;
    private static final int DO_SET_PLAY_POSITION = 11;
    private static final int DO_SET_RENDER_AFTER_PREPARED = 13;
    private static final int DO_START = 2;
    private static final int DO_STOP = 4;
    private static final int DO_UPDATEDATASOURCE = 9;
    private static final int DO_UPDATE_MEDIA_ASSET = 0;
    private static final int DO_UPDATE_NETWORK = 1;
    private static final int FFP_ITEM_PROP_INT64_ALLOW_ENHANCE = 15;
    private static final int FFP_ITEM_PROP_INT64_CID = 8;
    private static final int FFP_ITEM_PROP_INT64_DEVICE_LEVEL = 16;
    private static final int FFP_ITEM_PROP_INT64_ENABLE_JITTER_BUFFER = 11;
    private static final int FFP_ITEM_PROP_INT64_ENABLE_SKIP_FRAME = 10;
    private static final int FFP_ITEM_PROP_INT64_EXPECT_LATENCY = 9;
    private static final int FFP_ITEM_PROP_INT64_IS_ABLE_LOW_LATENCY = 12;
    private static final int FFP_ITEM_PROP_INT64_NETWORK_TYPE = 6;
    private static final int FFP_ITEM_PROP_INT64_NOTIFY_CPU_USAGE = 13;
    private static final int FFP_ITEM_PROP_INT64_PLAYER_ITEM_PRIORITY = 3;
    private static final int FFP_ITEM_PROP_INT64_SOFT_ACTIVATION_DECISION = 14;
    private static final int FFP_ITEM_PROP_INT64_START_POSITION = 5;
    private static final int ITEM_OPT_CATEGORY_CODEC = 2;
    private static final int ITEM_OPT_CATEGORY_FORMAT = 1;
    private static final int ITEM_OPT_CATEGORY_ITEM = 4;
    private static final int ITEM_OPT_CATEGORY_PLAYER = 3;
    private static final int MAX_VIVID_METADATA_QUEUE = 100;
    private static final int NOTIFY_ONNATIVEINVOKE = 8;
    private static final int RENDER_ACCURATE_SEEK = 2;
    private static final int RENDER_NOMAL = 0;
    private static final int RENDER_SEEK = 1;
    private static final long ReconnectThreshold = 20000;
    public static final int SCHEME_GIF = 7;
    public static final int SCHEME_GIF_OFFLINE = 8;
    public static final int SCHEME_LIVE = 1;
    public static final int SCHEME_LIVE_STORY = 9;
    public static final int SCHEME_MUSIC = 4;
    public static final int SCHEME_OFFLINE = 5;
    public static final int SCHEME_VOD = 2;
    public static final int SCHEME_VOD_SHORT = 3;
    public static final int SCHEME_VOD_STORY = 6;
    private static final String TAG = "IjkMediaPlayerItem";
    public static final int WRAP_INET6_FAMILY = 10;
    public static final int WRAP_INET_FAMILY = 2;
    public static final int WRAP_UNKNOWN_FAMILY = 0;
    private int itemPriority;
    private int mAssetChangeCount;
    private ParcelFileDescriptor mAssetFd;
    public String mAudioIp;
    public String[] mAudioMixUrls;
    private int mAv1SoftMaxQn;
    private String mBuvid;
    private long mCid;
    private IjkMediaPlayerItemBinder mClient;
    private Context mContext;
    private int mCurAudioId;
    private int mCurVideoId;
    private String mDashCachePath;
    private boolean mDisableFreeUrl;
    private String mDolbyConfigPath;
    private boolean mEnableChangeStartAudioQn;
    private int[] mEnhanceQnList;
    private EventHandler mEventHandler;
    private HashMap<String, String> mExtraMapInfo;
    private int mFirstRenderMode;
    private long mFormat;
    private long mGetFreeUrlStartTime;
    private HandlerThread mHandleThread;
    private int mHdrRenderType;
    private int mHdrVideoType;
    private IjkMediaConfigParams mIjkMediaConfigParams;
    private IjkMediaPlayerTracker mIjkMediaPlayerTracker;
    private final PerformanceTracker mIjkProcessPerformance;
    private int mIoInterrupt;
    private boolean mIsReleased;
    private boolean mIsReset;
    private boolean mIsSetPriority;
    private boolean mIsStart;
    private boolean mIsStop;
    private IIjkMediaPlayerItem mItem;
    private boolean mLastAudioConnected;
    private long mLastStartTime;
    private boolean mLastVideoConnected;
    private IjkMediaPlayerItemAssetUpdateListener mListener;
    private final PerformanceTracker mMainProcessPerformance;
    private int mMaxQn;
    private IjkMediaAsset mMediaAsset;
    private int mMinQn;
    private int mMode;
    private IjkNetworkUtils.NetWorkType mNetWorkType;
    private int mNoAssetUpdateListenerCount;
    private IMediaPlayer.OnTrackerListener mOnTrackerListener;
    private final ArrayList<Message> mPendingList;
    private boolean mPktCountGot;
    private long mPlayPosition;
    private final ArrayList<PlayerItemPriority> mPriorityList;
    private final Object mPriorityLock;
    private Map<String, ArrayList<IJKQnCoverRuleItem>> mQnCoverRules;
    private Map<String, ArrayList<IjkMediaAsset.MediaAssetStream>> mQnCoverStreams;
    private int mScheme;
    private int mScreenState;
    private SharedPreferences mSharedPreferences;
    private SoftActivatedType mSoftActivatedType;
    private SomeWorkHandler mSomeWorkHandle;
    private STATE mState;
    private long mStepWaitCounter;
    private long mStepWaitStartTime;
    private long mStepWaitTime;
    private final Object mStopLock;
    IMediaPlayer.OnTrackerListener mTrackListener;
    private int mUrlFormat;
    private int mUrlInfo;
    private String mVideoCachePath;
    private int mVideoCodecType;
    public String mVideoIp;
    private final Queue<Pair<ByteBuffer, Long>> mVividDataList;
    private VodType mVodType;
    private final ArrayList<Message> mWaitList;
    public static String IJK_PROCESS = "IjkProcess";
    public static String MAIN_PROCESS = "MainProcess";
    private static boolean sSharePreInit = false;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IJKQnCoverRuleItem {
        public long solutionQn;
        public String solutionType;
        public long targetQn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum STATE {
        DISCONNECTED,
        CONNECTTING,
        CONNECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum SoftActivatedType {
        SOFT_NO,
        SOFT_AV1,
        SOFT_H266
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VodType {
        VOD_NONE,
        VOD_NORMAL,
        VOD_MULTI_SEGMENGT,
        VOD_DASH,
        VOD_HLS
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PerformanceTracker {
        public long counter;
        public double cpu;
        public int curBatteryLevel;
        public long mem;
        public String name;
        public long thread;
        public HashMap<String, Integer> threadMap;

        private PerformanceTracker(String processName) {
            this.threadMap = new HashMap<>();
            this.name = processName;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum PlayerItemPriority {
        PLAYER_FOR_CURRENT_PRIORITY(0),
        PRIORITY_1(1),
        PRIORITY_2(2),
        PRIORITY_3(3),
        PRIORITY_4(4),
        PRIORITY_5(5),
        PRIORITY_6(6),
        PRIORITY_7(7);
        
        private final int priorityValue;

        PlayerItemPriority(int value) {
            this.priorityValue = value;
        }

        public int PriorityToValue() {
            return this.priorityValue;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IjkMediaPlayerItemAssetUpdateListener {
        IjkMediaAsset onAssetUpdate(IjkAssetUpdateReason ijkAssetUpdateReason);

        String onMeteredNetworkUrlHook(String str, IjkNetworkUtils.NetWorkType netWorkType, int i);

        /* renamed from: tv.danmaku.ijk.media.player.IjkMediaPlayerItem$IjkMediaPlayerItemAssetUpdateListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static String $default$onMeteredNetworkUrlHook(IjkMediaPlayerItemAssetUpdateListener _this, String url, IjkNetworkUtils.NetWorkType type, int reasonType) {
                return url;
            }
        }
    }

    public IjkMediaPlayerItem(Context context, int scheme) {
        this(null, context, scheme);
    }

    public IjkMediaPlayerItem(IjkLibLoader libLoader, Context context, int scheme) {
        this(libLoader, context, null, scheme);
    }

    public IjkMediaPlayerItem(IjkLibLoader libLoader, Context context, Looper looper, int scheme) {
        this.mWaitList = new ArrayList<>();
        this.mPendingList = new ArrayList<>();
        this.mPriorityList = new ArrayList<>();
        this.mVividDataList = new LinkedList();
        this.mClient = null;
        this.mListener = null;
        this.mNoAssetUpdateListenerCount = 0;
        this.mItem = null;
        this.mIsStop = false;
        this.mIsReleased = false;
        this.mStopLock = new Object();
        this.mTrackListener = null;
        this.mIjkMediaPlayerTracker = null;
        this.mMainProcessPerformance = new PerformanceTracker(MAIN_PROCESS);
        this.mIjkProcessPerformance = new PerformanceTracker(IJK_PROCESS);
        this.mState = STATE.DISCONNECTED;
        this.mIsSetPriority = false;
        this.mIoInterrupt = 0;
        this.mVodType = VodType.VOD_NONE;
        this.mDolbyConfigPath = null;
        this.mVideoCachePath = null;
        this.mDashCachePath = null;
        this.mAssetFd = null;
        this.mPlayPosition = 0L;
        this.mMode = 0;
        this.mCid = 0L;
        this.mBuvid = null;
        this.mExtraMapInfo = new HashMap<>();
        this.mCurVideoId = 0;
        this.mCurAudioId = 0;
        this.mMaxQn = 0;
        this.mMinQn = 999;
        this.mScreenState = -1;
        this.mGetFreeUrlStartTime = 0L;
        this.mDisableFreeUrl = false;
        this.mOnTrackerListener = null;
        this.mFirstRenderMode = 0;
        this.mStepWaitTime = 0L;
        this.mStepWaitStartTime = 0L;
        this.mStepWaitCounter = 0L;
        this.mPktCountGot = false;
        this.mAssetChangeCount = 0;
        this.mLastVideoConnected = true;
        this.mLastAudioConnected = true;
        this.mUrlInfo = 0;
        this.mFormat = 0L;
        this.mUrlFormat = 0;
        this.mVideoCodecType = 0;
        this.itemPriority = PlayerItemPriority.PRIORITY_7.PriorityToValue();
        this.mPriorityLock = new Object();
        this.mLastStartTime = -1L;
        this.mEnableChangeStartAudioQn = true;
        this.mSoftActivatedType = SoftActivatedType.SOFT_NO;
        this.mAv1SoftMaxQn = 0;
        this.mVideoIp = null;
        this.mAudioIp = null;
        this.mQnCoverRules = null;
        this.mQnCoverStreams = null;
        String looperType = "None";
        if (looper != null) {
            looperType = "Reuse";
        } else if (Looper.myLooper() != null) {
            looperType = "Mylooper";
            looper = Looper.myLooper();
        } else if (Looper.getMainLooper() != null) {
            looperType = "MainLooper";
            looper = Looper.getMainLooper();
        }
        this.mScheme = scheme;
        this.mContext = context.getApplicationContext();
        IjkMediaPlayerMonitor.getInstance().init(context).start();
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        }
        BLog.i(TAG, "[" + this + "] IjkMediaPlayerItem");
        this.mClient = new IjkMediaPlayerItemBinder(this);
        this.mHandleThread = new HandlerThread("ijk_java_item");
        this.mHandleThread.start();
        this.mSomeWorkHandle = new SomeWorkHandler(this, this.mHandleThread.getLooper());
        IjkMediaPlayer.startIjkServer(libLoader, this.mContext);
        this.mSomeWorkHandle.obtainMessage(0).sendToTarget();
        this.mSharedPreferences = this.mContext.getSharedPreferences("ijkplayer", 0);
        IjkNetworkManager.getInstance(this.mContext).registerListener(this);
        this.mNetWorkType = IjkMediaPlayerMonitor.getInstance().getNetworkState();
        BLog.i(TAG, "[" + this + "] item create mNetWorkType " + this.mNetWorkType + ", looperType = " + looperType);
        this.mIsStart = false;
        this.mIsStop = false;
    }

    private void adjustConfigParams() {
        if (this.mIjkMediaConfigParams.mEnableAlphaLayer) {
            this.mIjkMediaConfigParams.mEnableHwCodec = false;
            this.mIjkMediaConfigParams.mEnableDecodeSwitch = false;
        }
        if (this.mIjkMediaConfigParams.mHdrVideoType != 0) {
            this.mIjkMediaConfigParams.mEnableHwCodec = true;
            this.mIjkMediaConfigParams.mEnableH265Codec = true;
            this.mIjkMediaConfigParams.mEnableDecodeSwitch = false;
        }
        int drmType = this.mMediaAsset.getDrmType();
        BLog.i(TAG, "[" + this + "] drmType:" + drmType);
        if (drmType == IjkDrmUtils.DrmType.DRM_WIDEVINE.getValue()) {
            this.mIjkMediaConfigParams.mEnableDecodeSwitch = false;
        }
    }

    private void sendAsyncMessage(int msgType) {
        synchronized (this.mWaitList) {
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(msgType).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(msgType));
            }
        }
    }

    public void init(IjkMediaAsset asset, IjkMediaConfigParams params) {
        if (checkIsReleased() || !checkStateValid(STATE.DISCONNECTED, "init") || asset == null || this.mMediaAsset != null) {
            return;
        }
        BLog.i(TAG, "[" + this + "] init");
        this.mIjkMediaConfigParams = params == null ? new IjkMediaConfigParams() : params;
        IjkCodecHelper.addUnusedLowLatencyDevices(this.mIjkMediaConfigParams.mUnusedLowLatencyCodecList);
        this.mMediaAsset = asset;
        parseMediaAsset();
        if (params.mStartOfPostion > 0) {
            this.mFirstRenderMode = 1;
        }
        BLog.i(TAG, "[" + this + "] setDataSource, mHdrVideoType : " + params.mHdrVideoType + " mHdrRenderType : " + params.mHdrRenderType);
        this.mHdrVideoType = params.mHdrVideoType;
        this.mHdrRenderType = params.mHdrRenderType;
        this.mDolbyConfigPath = params.mDolbyConfigPath;
        adjustConfigParams();
        sendAsyncMessage(5);
        sendAsyncMessage(7);
    }

    public int addMediaAssetStream(IjkMediaAsset.MediaAssetStream stream) {
        IjkMediaAsset.MediaAssetStream[] streams = {stream};
        return addMediaAssetStreamList(streams);
    }

    public int addMediaAssetStreamList(IjkMediaAsset.MediaAssetStream[] streams) {
        if (checkIsReleased() || this.mMediaAsset == null) {
            return -1;
        }
        BLog.i(TAG, "[" + this + "] addMediaAssetStreamList");
        if (this.mVodType == VodType.VOD_DASH) {
            synchronized (this.mStopLock) {
                for (IjkMediaAsset.MediaAssetStream stream : streams) {
                    this.mMediaAsset.getStreamList().add(stream);
                }
            }
            sendAsyncMessage(9);
            return 0;
        }
        return -1;
    }

    public void notifyBackgroundStatus(boolean isBackground, boolean isMiniScreenSwitchOn, boolean isBackgroundMusicOn) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "[PlayRecordDetail][notifyBackgroundStatus] isBackground=" + isBackground + ", isMiniScreenSwitchOn=" + isMiniScreenSwitchOn + ", isBackgroundMusicOn=" + isBackgroundMusicOn);
            this.mIjkMediaPlayerTracker.updateBackgroundState(isBackground, isMiniScreenSwitchOn, isBackgroundMusicOn);
        }
    }

    public void setAssetUpdateListener(IjkMediaPlayerItemAssetUpdateListener listener) {
        if (listener == null) {
            BLog.w(TAG, "[" + this + "] setAssetUpdateListener is null");
        } else {
            BLog.i(TAG, "[" + this + "] setAssetUpdateListener");
        }
        this.mListener = listener;
    }

    public void setOnTrackerListener(IMediaPlayer.OnTrackerListener listener) {
        BLog.i(TAG, "[" + this + "] setOnTrackerListener");
        if (this.mIjkMediaPlayerTracker == null) {
            this.mOnTrackerListener = listener;
            this.mIjkMediaPlayerTracker = new IjkMediaPlayerTracker(listener, this.mContext);
            initTrackerInfo();
        }
    }

    private void initTrackerInfo() {
        if (this.mMode != 0 && this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.initTracker(this.mMode, this.mCid, this.mExtraMapInfo);
            this.mIjkMediaPlayerTracker.initLiveHeartbeat(this, this.mIjkMediaConfigParams.mLiveHeartbeatInterval, this.mIjkMediaConfigParams.mAppVersion);
        }
    }

    public void initIjkMediaPlayerTracker(int mode, long cid, String buvid, HashMap<String, String> extraMapInfo) {
        BLog.i(TAG, "[" + this + "] initIjkMediaPlayerTracker");
        if (this.mScheme == 6) {
            switch (mode) {
                case 5:
                case IjkMediaItem.BLIJKPlayMode_VOD_STORY_CM_FREE /* 501 */:
                case IjkMediaItem.BLIJKPlayMode_VOD_STORY_UNICOM_FREE /* 502 */:
                case IjkMediaItem.BLIJKPlayMode_VOD_STORY_TELCOM_FREE /* 503 */:
                    break;
                default:
                    BLog.e(TAG, "Story Mode Assertion fail! mode = " + mode);
                    break;
            }
        } else if (this.mScheme == 9) {
            switch (mode) {
                case 8:
                case 801:
                case 802:
                case IjkMediaItem.BLIJKPlayMode_VOD_LIVE_STORY_TELCOM_FREE /* 803 */:
                    break;
                default:
                    BLog.e(TAG, "Story Live Mode Assertion fail! mode = " + mode);
                    break;
            }
        } else if (this.mScheme == 7 || this.mScheme == 8) {
            switch (mode) {
                case 7:
                case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                    break;
                default:
                    BLog.e(TAG, "Gif Mode Assertion fail! mode = " + mode);
                    break;
            }
        }
        this.mMode = mode;
        this.mCid = cid;
        this.mBuvid = buvid;
        this.mExtraMapInfo = extraMapInfo;
        initTrackerInfo();
    }

    public void setQnCoverRules(Map<String, ArrayList<IJKQnCoverRuleItem>> qnCoverRules) {
        BLog.i(TAG, "[" + this + "][strategyPlatformRequire] setQnCoverRules");
        synchronized (this.mStopLock) {
            this.mQnCoverRules = qnCoverRules;
        }
    }

    public int setQnCoverStreams(Map<String, ArrayList<IjkMediaAsset.MediaAssetStream>> qnCoverStreams) {
        if (checkIsReleased()) {
            return -1;
        }
        BLog.i(TAG, "[" + this + "][strategyPlatformRequire] setCoverStreams");
        synchronized (this.mStopLock) {
            this.mQnCoverStreams = qnCoverStreams;
        }
        sendAsyncMessage(9);
        return 0;
    }

    public void setMediaFeature(String mediaFeature) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "setMediaFeature media feature = " + mediaFeature);
            this.mIjkMediaPlayerTracker.setMediaFeature(mediaFeature);
        }
    }

    public void setLiveExperimentalInfo(String expInfo) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "setLiveExperimentalInfo = " + expInfo);
            this.mIjkMediaPlayerTracker.setLiveExperimentalInfo(expInfo);
        }
    }

    public void setFocusState(int focusState) {
        if (this.mIjkMediaPlayerTracker != null) {
            BLog.i(TAG, "setFocusState = " + focusState);
            this.mIjkMediaPlayerTracker.setFocusState(focusState);
        }
    }

    public void setMultiAudioStream(String[] urls) {
        BLog.i(TAG, "setMultiAudioStream urls.length = " + urls.length);
        if (urls.length <= 0) {
            return;
        }
        this.mAudioMixUrls = urls;
        synchronized (this.mWaitList) {
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(18, 0, 0, urls).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(18, 0, 0, urls));
            }
        }
    }

    public void setPlayPosition(long millisecond) {
        this.mPlayPosition = millisecond;
        BLog.i(TAG, "[" + this + "] setPlayPosition " + millisecond);
        if (millisecond > 0) {
            this.mFirstRenderMode = 2;
        }
        synchronized (this.mWaitList) {
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(11, Long.valueOf(millisecond)).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(11, Long.valueOf(millisecond)));
            }
        }
    }

    public long getPlayPosition() {
        return this.mPlayPosition;
    }

    public void setRenderAfterPrepared(boolean renderAfterPrepared) {
        BLog.i(TAG, "[" + this + "] setPlayPosition " + renderAfterPrepared);
        synchronized (this.mWaitList) {
            int i = 1;
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                SomeWorkHandler someWorkHandler = this.mSomeWorkHandle;
                if (!renderAfterPrepared) {
                    i = 0;
                }
                someWorkHandler.obtainMessage(13, i, 0).sendToTarget();
            } else {
                ArrayList<Message> arrayList = this.mWaitList;
                SomeWorkHandler someWorkHandler2 = this.mSomeWorkHandle;
                if (!renderAfterPrepared) {
                    i = 0;
                }
                arrayList.add(someWorkHandler2.obtainMessage(13, i, 0));
            }
        }
    }

    public void setP2pManuscriptInfo(P2PManuscriptInfo info) {
        BLog.i(TAG, "[" + this + "] setP2pManuscriptInfo " + info.toJsonString());
        synchronized (this.mWaitList) {
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(15, 0, 0, info).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(15, 0, 0, info));
            }
        }
    }

    public void setPlayerItemPriority(PlayerItemPriority priority) {
        synchronized (this.mPriorityLock) {
            if (priority == PlayerItemPriority.PLAYER_FOR_CURRENT_PRIORITY) {
                return;
            }
            BLog.i(TAG, "[" + this + "] EnterSetPriority=" + priority.priorityValue);
            if (this.mItem == null || !IjkMediaPlayer.msIjkserviceIsConnected) {
                synchronized (this.mWaitList) {
                    this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(16, priority));
                }
            }
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                setPlayerItemPriorityReal(priority);
            }
        }
    }

    public void setStartPosition(long startPosition) {
        BLog.i(TAG, "setStartPosition " + startPosition);
        this.mIjkMediaConfigParams.mStartOfPostion = (int) startPosition;
        if (this.mIsStart) {
            try {
                this.mItem.setPropertyLong(5, startPosition);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
    }

    public long getStartPosition() {
        return this.mIjkMediaConfigParams.mStartOfPostion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerItemPriorityReal(PlayerItemPriority priority) {
        try {
            this.mItem.setPropertyLong(3, priority.PriorityToValue());
            this.itemPriority = priority.PriorityToValue();
        } catch (RemoteException e) {
        } catch (RuntimeException e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkType(IjkNetworkUtils.NetWorkType networkType) {
        int userNetworkType = 0;
        if (networkType == IjkNetworkUtils.NetWorkType.NONE) {
            userNetworkType = 3;
        } else if (networkType == IjkNetworkUtils.NetWorkType.MOBILE) {
            userNetworkType = 2;
        } else if (networkType == IjkNetworkUtils.NetWorkType.WIFI) {
            userNetworkType = 1;
        }
        try {
            this.mItem.setPropertyLong(6, userNetworkType);
        } catch (RemoteException e) {
        } catch (RuntimeException e2) {
        }
    }

    public IjkMediaPlayerTracker getIjkMediaPlayerTracker() {
        return this.mIjkMediaPlayerTracker;
    }

    public void start() {
        if (checkIsReleased()) {
            BLog.i(TAG, "[" + this + "] can not start, item is released");
            return;
        }
        if (this.mVodType == VodType.VOD_DASH) {
            BLog.i(TAG, "[PlayRecordDetail][recordQn][dash] defaultVideoQn=" + this.mCurVideoId + ", defaultAudioQn=" + this.mCurAudioId);
        } else {
            BLog.i(TAG, "[PlayRecordDetail][recordQn][normal] videoQn=" + this.mCurVideoId + ", audioQn=" + this.mCurAudioId);
        }
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.setUrlInfo(this.mUrlInfo);
            this.mIjkMediaPlayerTracker.setFileFormat(this.mFormat);
            this.mIjkMediaPlayerTracker.setCurQn(this.mCurVideoId, this.mCurAudioId);
            this.mIjkMediaPlayerTracker.itemStart(this, SystemClock.elapsedRealtime(), null);
            this.mIjkMediaPlayerTracker.recordMaxAndMinQn(this.mMaxQn, this.mMinQn);
            if (this.mIjkMediaConfigParams != null && this.mIjkMediaConfigParams.mEnableReportWidevineType) {
                this.mIjkMediaPlayerTracker.setSupportWidevineType(IjkDrmUtils.getSupportWidevineType());
            }
        }
        synchronized (this.mWaitList) {
            if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                this.mSomeWorkHandle.removeMessages(4);
                this.mSomeWorkHandle.obtainMessage(2).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(2));
            }
        }
    }

    public long getPlayableDuration() {
        if (!checkIsReleased() && this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                return this.mItem.getPlayableDuration();
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
        return 0L;
    }

    private void willItemStop() {
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.itemStop(this, SystemClock.elapsedRealtime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doP2pLiveReport() {
        IjkMediaPlayerTracker tracker = this.mIjkMediaPlayerTracker;
        if (tracker != null) {
            tracker.P2PReport(this);
        }
    }

    public void stop() {
        synchronized (this) {
            if (checkIsReleased()) {
                return;
            }
            willItemStop();
            if (!checkStateValid(STATE.DISCONNECTED, "stop")) {
                BLog.i(TAG, "[" + this + "] penging msg 4");
                this.mPendingList.add(this.mSomeWorkHandle.obtainMessage(4));
                return;
            }
            if (!this.mPktCountGot && this.mStepWaitStartTime > 0) {
                this.mStepWaitTime += SystemClock.elapsedRealtime() - this.mStepWaitStartTime;
                this.mStepWaitStartTime = 0L;
            }
            BLog.i(TAG, "[" + this + "] stop ");
            IjkMediaPlayerTracker tracker = this.mIjkMediaPlayerTracker;
            synchronized (this.mWaitList) {
                if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                    this.mSomeWorkHandle.obtainMessage(4, tracker).sendToTarget();
                } else {
                    this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(4, tracker));
                }
            }
        }
    }

    public void reset() {
        synchronized (this) {
            if (!checkIsReleased() && checkStateValid(STATE.DISCONNECTED, "reset")) {
                if (!this.mPktCountGot && this.mStepWaitStartTime > 0) {
                    this.mStepWaitTime += SystemClock.elapsedRealtime() - this.mStepWaitStartTime;
                    this.mStepWaitStartTime = 0L;
                }
                BLog.i(TAG, "[" + this + "] reset ");
                IjkMediaPlayerTracker tracker = this.mIjkMediaPlayerTracker;
                if (this.mIjkMediaPlayerTracker != null) {
                    this.mIjkMediaPlayerTracker.itemStop(this, SystemClock.elapsedRealtime());
                    if (this.mOnTrackerListener != null) {
                        this.mIjkMediaPlayerTracker = new IjkMediaPlayerTracker(this.mOnTrackerListener, this.mContext);
                        initTrackerInfo();
                    }
                }
                synchronized (this.mWaitList) {
                    if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                        this.mSomeWorkHandle.obtainMessage(10, tracker).sendToTarget();
                    } else {
                        this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(10, tracker));
                    }
                }
            }
        }
    }

    public void release() {
        synchronized (this) {
            if (checkIsReleased()) {
                return;
            }
            if (!checkStateValid(STATE.DISCONNECTED, "release")) {
                BLog.i(TAG, "[" + this + "] penging msg 3");
                this.mPendingList.add(this.mSomeWorkHandle.obtainMessage(3));
                return;
            }
            if (!this.mPktCountGot && this.mStepWaitStartTime > 0) {
                this.mStepWaitTime += SystemClock.elapsedRealtime() - this.mStepWaitStartTime;
                this.mStepWaitStartTime = 0L;
            }
            this.mIsReleased = true;
            IjkMediaPlayerMonitor.getInstance().pause();
            BLog.i(TAG, "[PlayRecordDetail][releaseItem] [" + this + "] cid = " + this.mCid);
            if (this.mIjkMediaPlayerTracker != null) {
                this.mIjkMediaPlayerTracker.itemStop(this, SystemClock.elapsedRealtime());
            }
            synchronized (this.mWaitList) {
                if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                    this.mSomeWorkHandle.obtainMessage(3, this.mIjkMediaPlayerTracker).sendToTarget();
                } else {
                    this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(3, this.mIjkMediaPlayerTracker));
                }
            }
        }
    }

    private boolean checkStateValid(STATE target, String caller) {
        if (this.mState != target) {
            BLog.w(TAG, "[" + this + "] [" + caller + "] mState " + this.mState + " target " + target);
            return false;
        }
        return true;
    }

    private boolean checkIsReleased() {
        if (this.mIsReleased) {
            return true;
        }
        return false;
    }

    public boolean connect() {
        synchronized (this) {
            if (!checkIsReleased() && checkStateValid(STATE.DISCONNECTED, "connect")) {
                this.mState = STATE.CONNECTTING;
                synchronized (this.mWaitList) {
                    if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                        this.mSomeWorkHandle.obtainMessage(6).sendToTarget();
                    } else {
                        this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(6));
                    }
                }
                return true;
            }
            return false;
        }
    }

    public boolean disconnect() {
        synchronized (this) {
            this.mState = STATE.DISCONNECTED;
            BLog.i(TAG, "[" + this + "] disconnected ");
            BLog.i(TAG, "[PlayRecordDetail][removeItem] from player, cid = " + this.mCid);
            Iterator<Message> it = this.mPendingList.iterator();
            while (it.hasNext()) {
                Message msg = it.next();
                BLog.i(TAG, "[" + this + "] call penging msg " + msg.what);
                switch (msg.what) {
                    case 3:
                        release();
                        break;
                    case 4:
                        stop();
                        break;
                }
            }
            this.mPendingList.clear();
        }
        return true;
    }

    public boolean isConnected() {
        return this.mState == STATE.CONNECTED;
    }

    public IIjkMediaPlayerItem getItem() {
        return this.mItem;
    }

    private synchronized String getCodecName(String mime) {
        if (TextUtils.isEmpty(mime)) {
            return "";
        }
        if (!sSharePreInit) {
            this.mSharedPreferences.edit().clear().apply();
            sSharePreInit = true;
        }
        String codecName = this.mSharedPreferences.getString(mime, "");
        BLog.i(TAG, "[" + this + "]  codecName " + codecName);
        if (TextUtils.isEmpty(codecName)) {
            codecName = IjkCodecHelper.getBestCodecNameEnter(mime);
            if (TextUtils.isEmpty(codecName)) {
                codecName = "";
            } else {
                this.mSharedPreferences.edit().putString(mime, codecName).apply();
            }
        }
        return codecName;
    }

    private void fillMediaCodecOptions(Bundle bundle) {
        String avcCodecName = getCodecName("video/avc");
        String hevcCodecName = getCodecName("video/hevc");
        String av1CodecName = getCodecName("video/av01");
        if (!TextUtils.isEmpty(av1CodecName)) {
            this.mIjkMediaConfigParams.mEnableAv1Codec = true;
        }
        IjkMediaAsset.VideoCodecType codecType = IjkMediaAsset.VideoCodecType.UNKNOWN;
        Iterator<IjkMediaAsset.MediaAssetStream> it = this.mMediaAsset.getStreamList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IjkMediaAsset.MediaAssetStream stream = it.next();
            if (this.mMediaAsset.defaultVideoId == stream.getQualityId()) {
                IjkMediaAsset.VideoCodecType curCodecType = stream.getVideoCodecType();
                if (this.mIjkMediaConfigParams.mEnableAv1Codec && curCodecType == IjkMediaAsset.VideoCodecType.AV1) {
                    codecType = curCodecType;
                    break;
                } else if (this.mIjkMediaConfigParams.mEnableH265Codec && curCodecType == IjkMediaAsset.VideoCodecType.H265) {
                    codecType = curCodecType;
                } else if (curCodecType == IjkMediaAsset.VideoCodecType.H264 && codecType != IjkMediaAsset.VideoCodecType.H265) {
                    codecType = curCodecType;
                }
            }
        }
        String videoMime = "";
        String defaultCodecName = "";
        if (codecType == IjkMediaAsset.VideoCodecType.H264) {
            videoMime = "video/avc";
            this.mVideoCodecType = 7;
            defaultCodecName = avcCodecName;
        } else if (codecType == IjkMediaAsset.VideoCodecType.H265) {
            videoMime = "video/hevc";
            this.mVideoCodecType = 12;
            defaultCodecName = hevcCodecName;
        } else if (codecType == IjkMediaAsset.VideoCodecType.AV1) {
            videoMime = "video/av01";
            this.mVideoCodecType = 13;
            defaultCodecName = av1CodecName;
        }
        if (this.mIjkMediaConfigParams.mEnableHwCodec) {
            if (!TextUtils.isEmpty(avcCodecName)) {
                bundle.putLong("mediacodec", 1L);
                bundle.putString("mediacodec-default-avc-name", avcCodecName);
            }
            if (this.mIjkMediaConfigParams.mEnableH265Codec) {
                bundle.putLong("mediacodec-hevc", 1L);
                if (!TextUtils.isEmpty(hevcCodecName)) {
                    bundle.putString("mediacodec-default-hevc-name", hevcCodecName);
                }
            }
            if (this.mIjkMediaConfigParams.mEnableAv1Codec) {
                bundle.putLong("mediacodec-av1", 1L);
                bundle.putString("mediacodec-default-av1-name", av1CodecName);
            }
            if (!TextUtils.isEmpty(defaultCodecName) && !this.mIjkMediaConfigParams.mEnableDolbyVisionCodec) {
                bundle.putLong("async-init-decoder", 1L);
                bundle.putString("video-mime-type", videoMime);
                bundle.putString("mediacodec-default-name", defaultCodecName);
            }
        }
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.setDefaultCodecName(defaultCodecName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemOptions() throws RemoteException {
        Bundle bundle = new Bundle();
        boolean enableEarlyDrop = this.mIjkMediaConfigParams.mEnableEarlyFrameDrop;
        if (this.mIjkMediaConfigParams.mGetFrameMode) {
            bundle.putLong("an", 1L);
            bundle.putLong("get-frame-mode", 1L);
            enableEarlyDrop = false;
        }
        if (this.mIjkMediaConfigParams.mHdrVideoType != 0) {
            if (this.mIjkMediaConfigParams.mEnableDolbyVisionCodec) {
                bundle.putLong("mediacodec-dolbyvision", 1L);
            } else {
                bundle.putLong("mediacodec-dolbyvision", 0L);
            }
        }
        bundle.putLong("hdr-video-type", this.mIjkMediaConfigParams.mHdrVideoType);
        if (this.mIjkMediaConfigParams.mStartOnPrepared) {
            bundle.putLong(IjkOptionsHelper.k_start_on_prepared, 1L);
        } else {
            bundle.putLong(IjkOptionsHelper.k_start_on_prepared, 0L);
        }
        if (this.mIjkMediaConfigParams.mEnableDecodeSwitch) {
            bundle.putLong("enable-decoder-switch", 1L);
        } else {
            bundle.putLong("enable-decoder-switch", 0L);
        }
        int decoderType = 0;
        int enableDecoderRace = 0;
        if (!this.mIjkMediaConfigParams.mEnableDecodeSwitch) {
            if (!this.mIjkMediaConfigParams.mEnableHwCodec) {
                decoderType = 1;
            }
            if (this.mIjkMediaConfigParams.mHdrVideoType != 0 || this.mMediaAsset.getDrmType() == IjkDrmUtils.DrmType.DRM_WIDEVINE.getValue()) {
                decoderType = 2;
            }
        } else {
            enableDecoderRace = 1;
        }
        bundle.putLong("decoder_type", decoderType);
        bundle.putLong("enable_decoder_race", enableDecoderRace);
        if (this.mIjkMediaConfigParams.mEnableAudioOpenSLES) {
            bundle.putLong("opensles", 1L);
        } else {
            bundle.putLong("opensles", 0L);
        }
        if (!isLive()) {
            bundle.putLong("enable-accurate-seek", 1L);
        }
        if (this.mIjkMediaConfigParams.mEnableDropFrame) {
            bundle.putLong("framedrop", 1L);
        }
        fillMediaCodecOptions(bundle);
        bundle.putLong("max-buffer-size", this.mIjkMediaConfigParams.mMaxCacheSize);
        if (this.mIjkMediaConfigParams.mForceRenderLastFrame) {
            bundle.putLong("force-render-last-frame", 1L);
        }
        if (this.mPlayPosition > 0) {
            bundle.putLong("seek-at-start", this.mPlayPosition);
        }
        if (this.mContext != null) {
            AudioManager am = (AudioManager) this.mContext.getSystemService("audio");
            if (am != null && am.isBluetoothA2dpOn()) {
                BLog.i(TAG, "AudioManager.isBluetoothA2dpOn() : " + am.isBluetoothA2dpOn());
            } else if (am != null) {
                BLog.i(TAG, "AudioManager.isBluetoothA2dpOn() : " + am.isBluetoothA2dpOn());
            } else {
                BLog.i(TAG, "AudioManager.isBluetoothA2dpOn() is null ");
            }
        }
        if (isOffline()) {
            bundle.putLong("offline", 1L);
        }
        if (this.mIjkMediaConfigParams.mEnableRawData) {
            bundle.putLong("rawdata", 1L);
        }
        if (isStory() && !isLive()) {
            bundle.putLong("loop", 0L);
            bundle.putLong("av-delay-adjust", 5000000L);
        } else {
            bundle.putLong("loop", this.mIjkMediaConfigParams.mLoop);
            bundle.putLong("av-delay-adjust", 0L);
        }
        bundle.putLong("render-after-prepare", this.mIjkMediaConfigParams.mRenderAfterPrepare ? 1L : 0L);
        bundle.putLong("audio-stream-type", this.mIjkMediaConfigParams.mAudioTrackStreamType);
        bundle.putLong("eac3-type", this.mIjkMediaConfigParams.mEac3Type);
        bundle.putLong("enable_amend_external_clock", this.mIjkMediaConfigParams.mEnableAmendExternalClock ? 1L : 0L);
        if (IjkAudioKit.sharedInstance(this.mContext.getApplicationContext()).getEndpoint() == IjkAudioKit.IjkAudioKitEndpoint.IjkAudioKitEndpointSpeaker) {
            this.mIjkMediaConfigParams.mEndpoint = 1L;
        } else {
            this.mIjkMediaConfigParams.mEndpoint = 2L;
        }
        if (isEac3HwRender()) {
            this.mIjkMediaConfigParams.mVirtualizerOnnoff = 0L;
            this.mIjkMediaConfigParams.mDialogEnhancementGain = 0L;
        }
        bundle.putLong("endpoint", this.mIjkMediaConfigParams.mEndpoint);
        bundle.putLong("virtualizer_onoff", this.mIjkMediaConfigParams.mVirtualizerOnnoff);
        bundle.putLong("dialog_enhancement_gain", this.mIjkMediaConfigParams.mDialogEnhancementGain);
        bundle.putLong("output_reference_level", this.mIjkMediaConfigParams.mOutputReferenceLevel);
        bundle.putLong("presentation_id", this.mIjkMediaConfigParams.mPresentationId);
        bundle.putLong("main_asso_pref", this.mIjkMediaConfigParams.mMainAssoPref);
        bundle.putLong("super-resolution", this.mIjkMediaConfigParams.mSuperResolution);
        bundle.putLong("enable_ignore_discard_pkt", this.mIjkMediaConfigParams.mEnableIgnoreDiscardPkt ? 1L : 0L);
        bundle.putLong("disable_flush_black_frame", this.mIjkMediaConfigParams.mDisableFlushBlack ? 1L : 0L);
        String afilter = null;
        if (this.mIjkMediaConfigParams.mLoudnormType != IjkMediaConfigParams.LoudnormType.LOUDNORM_NONE && (afilter = getAFilter(this.mIjkMediaConfigParams)) != null) {
            bundle.putString("af", afilter);
        }
        bundle.putLong("enable_ijkhevc", this.mIjkMediaConfigParams.mEnableAlphaLayer ? 1L : 0L);
        IjkDeviceScoreInfo deviceScoreInfo = IjkDeviceScoreInfo.getInstance(null);
        int deviceSupportQn = deviceScoreInfo == null ? -1 : deviceScoreInfo.getDeviceSupportQn();
        if (deviceSupportQn != -1) {
            BLog.i(TAG, "Adjust OriginMaxRecommendedQn=" + this.mIjkMediaConfigParams.mMaxRecommendedQn + " ,deviceSupportQn=" + deviceSupportQn);
            this.mIjkMediaConfigParams.mMaxRecommendedQn = Math.min(this.mIjkMediaConfigParams.mMaxRecommendedQn, deviceSupportQn);
        }
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.addSwitchOnInfo("enableLoudnorm", afilter == null ? 0 : 1);
            this.mIjkMediaPlayerTracker.addSwitchOnInfo("isInLiveRoom", this.mIjkMediaConfigParams.mIsInLiveRoom ? 1 : 0);
            this.mIjkMediaPlayerTracker.addSwitchOnInfo("useRecommendedQn", this.mIjkMediaConfigParams.mUseRecommendedQn ? 1 : 0);
            this.mIjkMediaPlayerTracker.addSwitchOnInfo("variableWh", this.mIjkMediaConfigParams.mEnableVariableWh ? 1 : 0);
            this.mIjkMediaPlayerTracker.setDrmType(this.mMediaAsset.getDrmType());
            this.mIjkMediaPlayerTracker.recordRecommendedMaxQn(this.mIjkMediaConfigParams.mMaxRecommendedQn);
        }
        this.mItem.setOptionBundle(3, bundle);
        bundle.clear();
        bundle.putString("user_agent", this.mIjkMediaConfigParams.mUserAgent);
        if (this.mIjkMediaConfigParams.mReferer != null) {
            bundle.putString("referer", this.mIjkMediaConfigParams.mReferer);
        }
        bundle.putLong("timeout", this.mIjkMediaConfigParams.mTcpReadWriteTimeOut);
        bundle.putString("protocol_whitelist", "ijkio,ijkcdnwrap,async,cache,crypto,file,http,https,ijkhttphook,ijkfilehook, ijkinject,ijklivehook,ijklongurl,ijksegment,pipe,rtp,tcp,tls,udp,ijkurlhook,data,ijkdummyhook,ijkp2p,ijknetwork");
        bundle.putLong("auto_convert", 0L);
        bundle.putLong("safe", 0L);
        bundle.putLong("async-forwards-capacity", 2097152L);
        bundle.putLong("async-backwards-capacity", VBNumberExtKt.MB);
        if (isCachable()) {
            IjkCacheManager cacheManager = IjkCacheManager.getInstance(this.mContext);
            this.mVideoCachePath = cacheManager.acquireVideoCache();
            if (!TextUtils.isEmpty(this.mVideoCachePath)) {
                bundle.putLong("cache_file_close", 0L);
                bundle.putString("cache_file_path", this.mVideoCachePath + "/video_cache");
                bundle.putString("cache_map_path", this.mVideoCachePath + "/video_cache_map");
                bundle.putLong("cache_max_capacity", cacheManager.getCacheSpace());
            } else {
                bundle.putLong("cache_file_close", 1L);
            }
            this.mDashCachePath = cacheManager.acquireDashCache();
            if (!TextUtils.isEmpty(this.mDashCachePath)) {
                bundle.putString("cache-dir", this.mDashCachePath);
            }
        }
        if (this.mIjkMediaConfigParams.mUseRecommendedQn) {
            bundle.putLong("dash-use-recommended-qn", 1L);
            bundle.putLong("dash-start-screen-ratio", this.mIjkMediaConfigParams.mStartScreenRatio);
        }
        if (!isOffline() && !isLive() && ((isVod() || isGif()) && (this.mVodType == VodType.VOD_DASH || this.mVodType == VodType.VOD_MULTI_SEGMENGT || this.mVodType == VodType.VOD_NORMAL))) {
            bundle.putLong("check-http-response", 1L);
        }
        if (this.mIjkMediaConfigParams.mEnableP2PDownload) {
            if (((!isStory() && isVod()) || (isStory() && isVod() && this.mIjkMediaConfigParams.mEnableStoryP2PDownload)) && (this.mVodType == VodType.VOD_DASH || this.mVodType == VodType.VOD_MULTI_SEGMENGT || this.mVodType == VodType.VOD_NORMAL)) {
                bundle.putLong("ijkp2penable", 1L);
            } else if (isLive()) {
                bundle.putLong("ijkp2penable", 1L);
            }
        }
        bundle.putString("ijkp2pstreamaid", this.mIjkMediaConfigParams.mAVid);
        if (isLive()) {
            bundle.putLong("enable_ijkmov", 1L);
            bundle.putString("error_list_for_backup_url", this.mIjkMediaConfigParams.mErrorListForUseBackupUrl);
            bundle.putLong("live_qn", this.mCurVideoId);
            bundle.putLong("enable_auto_append_query", 1L);
            bundle.putLong("discontinue_when_eof", this.mIjkMediaConfigParams.mLiveDiscontinueWhenEOF ? 1L : 0L);
            bundle.putLong("expect_start_latency", this.mIjkMediaConfigParams.mExpectStartLatency);
            bundle.putLong("is_hdr_vivid", this.mIjkMediaConfigParams.mHdrVideoType == 6 ? 1L : 0L);
        }
        this.mItem.setOptionBundle(1, bundle);
        bundle.clear();
        bundle.putLong("skip_frame", this.mIjkMediaConfigParams.mSkipFrame);
        bundle.putLong("skip_loop_filter", this.mIjkMediaConfigParams.mSkipLoopFilter);
        this.mItem.setOptionBundle(2, bundle);
        bundle.clear();
        bundle.putLong("early_framedrop", enableEarlyDrop ? 1L : 0L);
        if (isLive()) {
            bundle.putLong("high-fps", 0L);
        } else {
            bundle.putLong("high-fps", 1L);
        }
        if (isLive()) {
            bundle.putLong("multi-buffering-control", this.mIjkMediaConfigParams.mMultiBufferingControl);
            bundle.putLong("is_in_live_room", this.mIjkMediaConfigParams.mIsInLiveRoom ? 1L : 0L);
        }
        if (this.mIjkMediaConfigParams.mForceRenderLastFrame) {
            bundle.putLong("accurate-seek-timeout", PlayerToastConfig.DURATION_2);
        } else if (isStory() || isGif()) {
            bundle.putLong("accurate-seek-timeout", 50L);
        } else {
            bundle.putLong("accurate-seek-timeout", this.mIjkMediaConfigParams.mAccurateSeekTimeout);
        }
        bundle.putLong("enable-variable-wh", this.mIjkMediaConfigParams.mEnableVariableWh ? 1L : 0L);
        bundle.putLong("max-cache-time", this.mIjkMediaConfigParams.mInitCacheTime);
        bundle.putLong("start-position", this.mIjkMediaConfigParams.mStartOfPostion);
        if (this.mIjkMediaConfigParams.mUseRecommendedQn) {
            bundle.putLong("use-recommended-qn", 1L);
        } else {
            bundle.putLong("use-recommended-qn", 0L);
        }
        bundle.putLong("max-recommended-qn", this.mIjkMediaConfigParams.mMaxRecommendedQn);
        bundle.putLong("min-recommended-qn", this.mIjkMediaConfigParams.mMinRecommendedQn);
        if (isLive()) {
            bundle.putLong("sei_sidedata", 1L);
            bundle.putLong("is_live", 1L);
            bundle.putLong("is_story_live", this.mScheme == 9 ? 1L : 0L);
        }
        bundle.putLong("is_story", (!isStory() || isLive()) ? 0L : 1L);
        if (this.mEnableChangeStartAudioQn && !isOffline()) {
            bundle.putLong("enable_change_start_audio_qn", 1L);
        }
        bundle.putLong("is_hdr_vivid", this.mIjkMediaConfigParams.mHdrVideoType == 6 ? 1L : 0L);
        bundle.putLong("exp_hdr_max_lum", this.mIjkMediaConfigParams.mExpHdrMaxDisplayLum);
        if (this.mSoftActivatedType == SoftActivatedType.SOFT_H266) {
            bundle.putLong("soft-activated-type", 2L);
        } else if (this.mSoftActivatedType == SoftActivatedType.SOFT_AV1) {
            bundle.putLong("soft-activated-type", 1L);
        }
        this.mItem.setOptionBundle(4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mediaAssetToUrl(int segmentIndex, int retryCounter) {
        String url = "";
        BLog.i(TAG, "[" + this + "] mediaAssetToUrl retryCounter " + retryCounter);
        synchronized (this.mStopLock) {
            while (true) {
                try {
                    if (retryCounter > 0) {
                        url = this.mMediaAsset.getStreamList().get(0).getMediaAssertSegments().get(segmentIndex).changeUrl();
                        if (TextUtils.isEmpty(url)) {
                        }
                    } else {
                        url = this.mMediaAsset.getStreamList().get(0).getMediaAssertSegments().get(segmentIndex).getUrl();
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (retryCounter <= 0) {
                        break;
                    }
                    retryCounter = 0;
                }
            }
        }
        BLog.i(TAG, "[" + this + "] mediaAssetToUrl retryCounter " + retryCounter + " url " + url);
        return url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean makeSureExtName(String url, String ext) {
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(ext)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(url);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && !pathSegments.isEmpty()) {
                int length = pathSegments.size();
                String urlExt = pathSegments.get(length - 1);
                return urlExt.endsWith(ext);
            }
        } catch (Exception e) {
            BLog.w(TAG, url, e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object handleLocalUrl(int segmentIndex, int retryCounter) {
        try {
            if (this.mAssetFd != null) {
                try {
                    this.mAssetFd.close();
                } catch (IOException e) {
                }
                this.mAssetFd = null;
            }
            String url = mediaAssetToUrl(segmentIndex, retryCounter);
            if (!TextUtils.isEmpty(url) && url.startsWith("content:")) {
                Uri uri = Uri.parse(url);
                try {
                    try {
                        ContentResolver resolver = this.mContext.getContentResolver();
                        AssetFileDescriptor fd = resolver.openAssetFileDescriptor(uri, "r");
                        if (fd == null) {
                            return null;
                        }
                        ParcelFileDescriptor pFd = ParcelFileDescriptor.dup(fd.getFileDescriptor());
                        fd.close();
                        BLog.i(TAG, "[" + this + "] handleLocalUrl asset create, fd " + pFd.getFd());
                        this.mAssetFd = pFd;
                        return pFd;
                    } catch (IOException ex) {
                        BLog.w(TAG, "[" + this + "] handleLocalUrl " + ex);
                        return null;
                    }
                } catch (FileNotFoundException ignored) {
                    BLog.w(TAG, "[" + this + "] handleLocalUrl " + ignored);
                    return null;
                }
            }
            String url2 = Uri.decode(url);
            if (this.mVodType == VodType.VOD_NORMAL) {
                return "ijkofflinehook:ijkfilehook:" + url2;
            }
            return "ijkfilehook:" + url2;
        } catch (IndexOutOfBoundsException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUrlInfo() {
        this.mUrlInfo = 0;
        try {
            int streamSize = this.mMediaAsset.getStreamList().size();
            int i = 0;
            while (true) {
                if (i >= streamSize) {
                    break;
                }
                IjkMediaAsset.MediaAssetStream assetStream = this.mMediaAsset.getStreamList().get(i);
                IjkMediaAsset.StreamType streamType = assetStream.getStreamType();
                if (streamType == IjkMediaAsset.StreamType.NORMAL || ((streamType == IjkMediaAsset.StreamType.DASH_VIDEO && this.mUrlInfo < 10) || (streamType == IjkMediaAsset.StreamType.DASH_AUDIO && this.mUrlInfo % 10 == 0))) {
                    String baseUrl = assetStream.getMediaAssertSegments().get(0).getUrl();
                    int urlCounts = assetStream.getMediaAssertSegments().get(0).getBackupUrls().size();
                    if (!TextUtils.isEmpty(baseUrl)) {
                        urlCounts++;
                    }
                    if (streamType == IjkMediaAsset.StreamType.NORMAL) {
                        this.mUrlInfo = 0;
                        this.mUrlInfo += urlCounts * 11;
                        break;
                    } else if (streamType == IjkMediaAsset.StreamType.DASH_VIDEO) {
                        this.mUrlInfo += urlCounts * 10;
                    } else if (streamType == IjkMediaAsset.StreamType.DASH_AUDIO) {
                        this.mUrlInfo += urlCounts;
                    }
                }
                i++;
            }
            int i2 = this.mUrlInfo;
            this.mUrlInfo = Math.min(i2, 33);
        } catch (Exception e) {
            this.mUrlInfo = 0;
        }
    }

    private void parseMediaAsset() {
        this.mCurVideoId = this.mMediaAsset.defaultVideoId;
        this.mCurAudioId = this.mMediaAsset.defaultAudioId;
        updateUrlInfo();
        try {
            int streamSize = this.mMediaAsset.getStreamList().size();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= streamSize) {
                    break;
                }
                IjkMediaAsset.MediaAssetStream assetStream = this.mMediaAsset.getStreamList().get(i);
                if (assetStream.getStreamType() == IjkMediaAsset.StreamType.DASH_AUDIO && assetStream.getQualityId() == this.mMediaAsset.defaultAudioId) {
                    if (assetStream.getAudioQualityType() != IjkMediaAsset.AudioQualityType.NORMAL) {
                        z = false;
                    }
                    this.mEnableChangeStartAudioQn = z;
                }
                i++;
            }
            if (streamSize == 1 && this.mMediaAsset.getStreamList().get(0).getStreamType() == IjkMediaAsset.StreamType.NORMAL) {
                String url = this.mMediaAsset.getStreamList().get(0).getMediaAssertSegments().get(0).getUrl();
                if (makeSureExtName(url, ".m3u8")) {
                    this.mUrlFormat = 4;
                } else if (makeSureExtName(url, ".flv")) {
                    this.mUrlFormat = 5;
                } else if (makeSureExtName(url, ".mp4")) {
                    this.mUrlFormat = 6;
                }
                if (this.mMediaAsset.getStreamList().get(0).getMediaAssertSegments().size() == 1) {
                    if (isLive()) {
                        this.mFormat = 5L;
                        return;
                    } else if (isVod() || isGif() || isOffline()) {
                        if (makeSureExtName(url, ".m3u8")) {
                            this.mFormat = 4L;
                            return;
                        } else if (url.contains(".mp4")) {
                            this.mFormat = 1L;
                            return;
                        } else {
                            this.mFormat = 2L;
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.mFormat = 2L;
            } else if (streamSize > 0) {
                this.mFormat = 3L;
                if (this.mUrlInfo % 10 == 0) {
                    BLog.i(TAG, "[PlayProblem] PlaySilentReason=dash_no_audio_url");
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean isSameVideoCodec(IjkMediaAsset.VideoCodecType videoCodecType, int codec_id) {
        if (videoCodecType == IjkMediaAsset.VideoCodecType.H264 && codec_id == 7) {
            return true;
        }
        if (videoCodecType == IjkMediaAsset.VideoCodecType.H265 && codec_id == 12) {
            return true;
        }
        if (videoCodecType == IjkMediaAsset.VideoCodecType.AV1 && codec_id == 13) {
            return true;
        }
        return videoCodecType == IjkMediaAsset.VideoCodecType.H266 && codec_id == 14;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006e, code lost:
        if (r8 >= r7) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
        r9 = r4.getMediaAssertSegments().get(0).getBackupUrls().get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0088, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008a, code lost:
        r1 = r1 + ",\"backupUrl" + r8 + "\":\"" + tv.danmaku.ijk.media.player.utils.IjkUtils.getUrlHostAndPort(r9) + "\"";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b4, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cb, code lost:
        r1 = r1 + "}";
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        r5 = r4.getMediaAssertSegments().get(0).getUrl();
        r1 = "{\"baseUrl\":\"" + tv.danmaku.ijk.media.player.utils.IjkUtils.getUrlHostAndPort(r5) + "\"";
        r7 = r4.getMediaAssertSegments().get(0).getBackupUrls().size();
        r8 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getBackupUrlInfo(int curQn) {
        String backupUrlInfo = "";
        try {
            int streamSize = this.mMediaAsset.getStreamList().size();
            int i = 0;
            while (true) {
                if (i >= streamSize) {
                    break;
                }
                IjkMediaAsset.MediaAssetStream assetStream = this.mMediaAsset.getStreamList().get(i);
                if (assetStream.getQualityId() == curQn && isSameVideoCodec(assetStream.getVideoCodecType(), this.mVideoCodecType)) {
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            backupUrlInfo = "";
        }
        BLog.i(TAG, "[getBackupUrlInfo] " + backupUrlInfo);
        return backupUrlInfo;
    }

    private String getCodecTypeName(IjkMediaAsset.MediaAssetStream stream) {
        if (stream.getStreamType() == IjkMediaAsset.StreamType.DASH_AUDIO) {
            return IjkMediaMeta.IJKM_DASH_KEY_AUDIO;
        }
        if (stream.getStreamType() == IjkMediaAsset.StreamType.DASH_VIDEO) {
            IjkMediaAsset.VideoCodecType videoCodecType = stream.getVideoCodecType();
            if (videoCodecType == IjkMediaAsset.VideoCodecType.H264) {
                return IjkMediaMeta.IJKM_DASH_KEY_VIDEO_264;
            }
            if (videoCodecType == IjkMediaAsset.VideoCodecType.H265) {
                return IjkMediaMeta.IJKM_DASH_KEY_VIDEO_265;
            }
            if (videoCodecType == IjkMediaAsset.VideoCodecType.AV1) {
                return IjkMediaMeta.IJKM_DASH_KEY_VIDEO_AV1;
            }
            if (videoCodecType == IjkMediaAsset.VideoCodecType.H266) {
                return IjkMediaMeta.IJKM_DASH_KEY_VIDEO_266;
            }
            BLog.e(TAG, "unknown codecType for dash video");
            return IjkMediaMeta.IJKM_ASSET_KEY_NORMAL_VIDEO;
        }
        return IjkMediaMeta.IJKM_ASSET_KEY_NORMAL_VIDEO;
    }

    private String handleDashBaseUrl(String baseUrl) {
        if (baseUrl != null && !TextUtils.isEmpty(baseUrl) && (baseUrl.startsWith("file:") || !baseUrl.contains(":"))) {
            return Uri.decode(baseUrl);
        }
        return baseUrl;
    }

    private String generateOneStreamString(IjkMediaAsset.MediaAssetStream stream) {
        HashMap<String, String> streamMap = new HashMap<>();
        IjkMediaAsset.MediaAssertSegment segment = stream.getMediaAssertSegments().get(0);
        int qn = stream.getQualityId();
        if (stream.getStreamType() == IjkMediaAsset.StreamType.DASH_VIDEO) {
            this.mMaxQn = Math.max(this.mMaxQn, qn);
            this.mMinQn = Math.min(this.mMinQn, qn);
        }
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_CODEC_TYPE, getCodecTypeName(stream));
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_STREAM_ID, String.valueOf(qn));
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_STREAM_BANDWIDTH, String.valueOf(stream.getBandWidth()));
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_RELATED_AUDIO_ID, String.valueOf(stream.getRelatedAudioId()));
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_DRM_TYPE, String.valueOf(stream.getDrmType()));
        streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_DRM_KID, String.valueOf(stream.getDrmKid()));
        int usageScenario = stream.getUsageScenario();
        if (usageScenario > 0) {
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_TARGET_QN, String.valueOf(stream.getTargetQn()));
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_SOLUTION_TYPE, String.valueOf(stream.getSolutionType()));
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_USAGE_SCENARIO, String.valueOf(usageScenario));
        }
        try {
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_STREAM_SIZE, String.valueOf(segment.getSize()));
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_BASE_URL, handleDashBaseUrl(segment.getUrl()));
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_BACKUP_URL0, segment.getBackupUrls().get(0));
            streamMap.put(IjkMediaMeta.IJKM_ASSET_KEY_BACKUP_URL1, segment.getBackupUrls().get(1));
        } catch (IndexOutOfBoundsException e) {
        }
        JSONObject jsonObject = new JSONObject(streamMap);
        return jsonObject.toString();
    }

    private void addQnCoverStreamInfo(String scene, int sceneType) {
        ArrayList<IJKQnCoverRuleItem> qnCoverRules = this.mQnCoverRules.get(scene);
        if (qnCoverRules == null) {
            return;
        }
        Iterator<IJKQnCoverRuleItem> it = qnCoverRules.iterator();
        while (it.hasNext()) {
            IJKQnCoverRuleItem rule = it.next();
            ArrayList<IjkMediaAsset.MediaAssetStream> qnCoverQnStreams = this.mQnCoverStreams.get(rule.solutionType);
            if (qnCoverQnStreams != null) {
                Iterator<IjkMediaAsset.MediaAssetStream> it2 = qnCoverQnStreams.iterator();
                while (it2.hasNext()) {
                    IjkMediaAsset.MediaAssetStream stream = it2.next();
                    if (stream != null && stream.getQualityId() == rule.solutionQn) {
                        stream.setTargetQn((int) rule.targetQn);
                        stream.setSolutionType(rule.solutionType);
                        stream.addUsageScenario(sceneType);
                    }
                }
            }
        }
    }

    private List<String> generateQnCoverStreams() {
        List<String> list = new ArrayList<>();
        addQnCoverStreamInfo("low_ratio", IjkMediaAsset.STREAM_USAGE_SCENARIO_LOW_RATIO);
        addQnCoverStreamInfo("high_ratio", IjkMediaAsset.STREAM_USAGE_SCENARIO_HIGH_RATIO);
        for (ArrayList<IjkMediaAsset.MediaAssetStream> qnCoverQnStreams : this.mQnCoverStreams.values()) {
            Iterator<IjkMediaAsset.MediaAssetStream> it = qnCoverQnStreams.iterator();
            while (it.hasNext()) {
                IjkMediaAsset.MediaAssetStream stream = it.next();
                if (stream != null && stream.getUsageScenario() > 0) {
                    list.add(generateOneStreamString(stream));
                }
            }
        }
        return list;
    }

    private int generateStreamStringByList(List<String> list, List<IjkMediaAsset.MediaAssetStream> streams) {
        for (IjkMediaAsset.MediaAssetStream stream : streams) {
            list.add(generateOneStreamString(stream));
        }
        return streams.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] mediaAssetToJson() {
        String[] strArr;
        synchronized (this.mStopLock) {
            List<String> list = new ArrayList<>();
            List<IjkMediaAsset.MediaAssetStream> h264Videos = new ArrayList<>();
            List<IjkMediaAsset.MediaAssetStream> h265Videos = new ArrayList<>();
            List<IjkMediaAsset.MediaAssetStream> av1Videos = new ArrayList<>();
            List<IjkMediaAsset.MediaAssetStream> h266Videos = new ArrayList<>();
            for (IjkMediaAsset.MediaAssetStream stream : this.mMediaAsset.getStreamList()) {
                if (stream.getStreamType() == IjkMediaAsset.StreamType.DASH_VIDEO) {
                    IjkMediaAsset.VideoCodecType codecType = stream.getVideoCodecType();
                    if (codecType == IjkMediaAsset.VideoCodecType.H265) {
                        h265Videos.add(stream);
                    } else if (codecType == IjkMediaAsset.VideoCodecType.AV1) {
                        if (this.mSoftActivatedType != SoftActivatedType.SOFT_AV1 || stream.getQualityId() <= this.mAv1SoftMaxQn) {
                            av1Videos.add(stream);
                        }
                    } else if (codecType == IjkMediaAsset.VideoCodecType.H266) {
                        if (this.mSoftActivatedType != SoftActivatedType.SOFT_H266 || stream.getBandWidth() <= AbrParamsInterface.getH266SoftMaxBitrate()) {
                            h266Videos.add(stream);
                        }
                    } else {
                        h264Videos.add(stream);
                    }
                } else {
                    list.add(generateOneStreamString(stream));
                }
            }
            int videoStreamCount = generateStreamStringByList(list, h264Videos);
            if (this.mIjkMediaConfigParams.mEnableH265Codec || videoStreamCount == 0) {
                videoStreamCount += generateStreamStringByList(list, h265Videos);
            }
            if (IjkCodecHelper.isAv1SupportInternal() || this.mSoftActivatedType == SoftActivatedType.SOFT_AV1 || videoStreamCount == 0) {
                videoStreamCount += generateStreamStringByList(list, av1Videos);
            }
            if (this.mSoftActivatedType == SoftActivatedType.SOFT_H266 || videoStreamCount == 0) {
                int generateStreamStringByList = videoStreamCount + generateStreamStringByList(list, h266Videos);
            }
            if (this.mQnCoverStreams != null && this.mQnCoverRules != null) {
                list.addAll(generateQnCoverStreams());
            }
            if (this.mIjkMediaPlayerTracker != null) {
                this.mIjkMediaPlayerTracker.recordMaxAndMinQn(this.mMaxQn, this.mMinQn);
            }
            strArr = (String[]) list.toArray(new String[0]);
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getDataSource() {
        StringBuilder concat;
        synchronized (this.mStopLock) {
            if (this.mMediaAsset != null && this.mMediaAsset.getStreamList().size() > 0) {
                List<IjkMediaAsset.MediaAssetStream> streamList = this.mMediaAsset.getStreamList();
                if (streamList.size() == 1 && streamList.get(0).getStreamType() == IjkMediaAsset.StreamType.NORMAL) {
                    if (streamList.get(0).getMediaAssertSegments().size() == 1) {
                        String url = streamList.get(0).getMediaAssertSegments().get(0).getUrl();
                        if (isLive()) {
                            return mediaAssetToJson();
                        } else if (isOffline()) {
                            this.mVodType = VodType.VOD_NORMAL;
                            return handleLocalUrl(0, 0);
                        } else {
                            if (isVod() || isGif()) {
                                if (makeSureExtName(url, ".m3u8")) {
                                    url = "ijkhttphook:" + url;
                                    this.mVodType = VodType.VOD_HLS;
                                } else {
                                    url = "ijkio:cache:ffio:ijkhttphook:ijkp2p:" + url;
                                    this.mVodType = VodType.VOD_NORMAL;
                                }
                            }
                            BLog.i(TAG, "[" + this + "] get data source mVodType " + this.mVodType + " mScheme " + this.mScheme + " url " + url);
                            return url;
                        }
                    }
                    this.mVodType = VodType.VOD_MULTI_SEGMENGT;
                    if (isOffline()) {
                        concat = new StringBuilder("ijkofflinehook:ffconcat version 1.0\n");
                    } else {
                        concat = new StringBuilder("ffconcat version 1.0\n");
                    }
                    int segment_id = 0;
                    for (IjkMediaAsset.MediaAssertSegment segment : streamList.get(0).getMediaAssertSegments()) {
                        concat.append("file ijksegment:");
                        concat.append(segment_id);
                        concat.append(VideoFile.TREE_END);
                        concat.append("duration ");
                        concat.append(segment.getDuration() / IjkMediaCodecInfo.RANK_MAX);
                        if (segment.getDuration() % IjkMediaCodecInfo.RANK_MAX != 0) {
                            concat.append(".");
                            concat.append(segment.getDuration() % IjkMediaCodecInfo.RANK_MAX);
                        }
                        concat.append(VideoFile.TREE_END);
                        segment_id++;
                    }
                    BLog.i(TAG, "[" + this + "] get data source mVodType " + this.mVodType);
                    return concat.toString();
                }
                this.mVodType = VodType.VOD_DASH;
                BLog.i(TAG, "[" + this + "] get data source mVodType " + this.mVodType);
                return mediaAssetToJson();
            }
            BLog.w(TAG, "[" + this + "] asset is null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String TryGetFreeFlowUrl(String url) {
        int reasonType = this.mDisableFreeUrl ? 5 : 3;
        if (this.mIoInterrupt != 0) {
            return url;
        }
        if ((this.mNetWorkType != IjkNetworkUtils.NetWorkType.MOBILE && this.mNetWorkType != IjkNetworkUtils.NetWorkType.WIFI_METERED) || this.mListener == null) {
            return url;
        }
        synchronized (this) {
            this.mStepWaitCounter++;
            if (this.mStepWaitCounter == 1) {
                this.mStepWaitStartTime = SystemClock.elapsedRealtime();
            }
        }
        this.mGetFreeUrlStartTime = SystemClock.elapsedRealtime();
        String result = this.mListener.onMeteredNetworkUrlHook(url, this.mNetWorkType, reasonType);
        this.mGetFreeUrlStartTime = 0L;
        synchronized (this) {
            if (!this.mPktCountGot && this.mStepWaitCounter == 1 && this.mStepWaitStartTime > 0) {
                long diff = SystemClock.elapsedRealtime() - this.mStepWaitStartTime;
                this.mStepWaitTime += diff;
                BLog.i(TAG, "[" + this + "] onMeteredNetworkUrlHook take time " + diff);
            }
            if (this.mStepWaitCounter == 1) {
                this.mStepWaitStartTime = 0L;
            }
            this.mStepWaitCounter--;
        }
        BLog.i(TAG, "[" + this + "] after onMeteredNetworkUrlHook url " + result);
        return result;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class EventHandler extends Handler {
        private IjkMediaAsset mIjkMediaAsset;
        private final WeakReference<IjkMediaPlayerItem> mWeakItem;

        public EventHandler(IjkMediaPlayerItem item, Looper looper) {
            super(looper);
            this.mIjkMediaAsset = null;
            this.mWeakItem = new WeakReference<>(item);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IjkMediaPlayerItem item = this.mWeakItem.get();
            if (item == null) {
                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  IjkMediaPlayerItem is null ");
                return;
            }
            switch (msg.what) {
                case 0:
                    IjkAssetUpdateReason reason = (IjkAssetUpdateReason) msg.obj;
                    if (reason == null) {
                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  got DO_UPDATE_MEDIA_ASSET reason is null");
                        return;
                    }
                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  got DO_UPDATE_MEDIA_ASSET " + reason.getReason() + " mNetWorkType " + item.mNetWorkType);
                    reason.setCurrentNetWork(item.mNetWorkType);
                    reason.setOldNetWork(item.mNetWorkType);
                    reason.setFormat(item.mUrlFormat);
                    reason.setVideoCodecType(item.mVideoCodecType);
                    switch (reason.getReason()) {
                        case 0:
                            synchronized (item) {
                                item.mIoInterrupt = 0;
                                item.mAssetChangeCount = 0;
                                try {
                                    if (item.mItem != null) {
                                        item.mItem.ioInterrupt(item.mIoInterrupt);
                                    }
                                } catch (RemoteException e) {
                                } catch (RuntimeException e2) {
                                }
                            }
                            synchronized (item.mStopLock) {
                                item.mMediaAsset = this.mIjkMediaAsset == null ? item.mMediaAsset : this.mIjkMediaAsset;
                                item.mStopLock.notifyAll();
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  handled msg ASSET_UPDATE_REASON_INIT_RESOLVE");
                            }
                            return;
                        default:
                            IjkMediaAsset newMediaAsset = null;
                            IjkMediaPlayerItemAssetUpdateListener listener = item.mListener;
                            if (listener != null && item.mNetWorkType != IjkNetworkUtils.NetWorkType.NONE) {
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reason=" + reason.getReason() + ",codec=" + reason.getVideoCodecType() + ",format=" + reason.getFormat() + "; will call onAssetUpdate");
                                synchronized (item) {
                                    item.mNoAssetUpdateListenerCount = 0;
                                    item.mStepWaitCounter++;
                                    if (item.mStepWaitCounter == 1) {
                                        item.mStepWaitStartTime = SystemClock.elapsedRealtime();
                                    }
                                }
                                long startTime = SystemClock.elapsedRealtime();
                                IjkMediaAsset newMediaAsset2 = listener.onAssetUpdate((IjkAssetUpdateReason) msg.obj);
                                long duration = SystemClock.elapsedRealtime() - startTime;
                                BLog.i(IjkMediaPlayerItem.TAG, "[PlayRecordDetail][changeUrl] [" + this + "] cost time = " + duration + "ms, get newMediaAsset = " + (newMediaAsset2 != null) + ", cid = " + item.mCid);
                                if (item.mIjkMediaPlayerTracker != null) {
                                    item.mIjkMediaPlayerTracker.addUpAssetChange();
                                    item.mIjkMediaPlayerTracker.addAssetUpdateTime(duration);
                                }
                                synchronized (item) {
                                    if (item.mStepWaitCounter == 1 && item.mStepWaitStartTime > 0) {
                                        long diff = SystemClock.elapsedRealtime() - item.mStepWaitStartTime;
                                        if (!item.mPktCountGot) {
                                            item.mStepWaitTime += diff;
                                        }
                                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] onAssetUpdate take time " + diff);
                                    }
                                    if (item.mStepWaitCounter == 1) {
                                        item.mStepWaitStartTime = 0L;
                                    }
                                    item.mStepWaitCounter--;
                                }
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reason is " + reason.getReason() + "; did call onAssetUpdate");
                                newMediaAsset = newMediaAsset2;
                            } else if (listener == null) {
                                synchronized (item) {
                                    item.mNoAssetUpdateListenerCount++;
                                }
                                BLog.w(IjkMediaPlayerItem.TAG, "[" + this + "] no listener, can not do update asset");
                            } else {
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] network disconnected, no need to call onAssetUpdate");
                            }
                            if (newMediaAsset != null) {
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] newMediaAsset is ok");
                            }
                            this.mIjkMediaAsset = newMediaAsset == null ? this.mIjkMediaAsset : newMediaAsset;
                            item.updateUrlInfo();
                            item.mAssetChangeCount++;
                            synchronized (item.mStopLock) {
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  handled msg default");
                                item.mMediaAsset = this.mIjkMediaAsset == null ? item.mMediaAsset : this.mIjkMediaAsset;
                                item.mStopLock.notifyAll();
                            }
                            return;
                    }
                case 1:
                    IjkMediaAsset newMediaAsset3 = null;
                    if (!item.isOffline()) {
                        synchronized (item) {
                            item.mIoInterrupt = 1;
                            try {
                                if (item.mItem != null) {
                                    item.mItem.ioInterrupt(item.mIoInterrupt);
                                }
                            } catch (RemoteException e3) {
                            } catch (RuntimeException e4) {
                            }
                        }
                        IjkNetworkUtils.NetWorkType oldType = IjkNetworkUtils.NetWorkType.values()[msg.arg1];
                        IjkNetworkUtils.NetWorkType newType = IjkNetworkUtils.NetWorkType.values()[msg.arg2];
                        item.mNetWorkType = newType;
                        item.setNetworkType(item.mNetWorkType);
                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] update network oldType " + oldType + " newType " + newType);
                        IjkAssetUpdateReason reason2 = new IjkAssetUpdateReason(2, 0, 0);
                        reason2.setCurrentNetWork(newType);
                        reason2.setOldNetWork(oldType);
                        reason2.setFormat(item.mUrlFormat);
                        reason2.setVideoCodecType(item.mVideoCodecType);
                        IjkMediaPlayerItemAssetUpdateListener listener2 = item.mListener;
                        if (listener2 != null) {
                            if (item.mIjkMediaPlayerTracker != null) {
                                item.mIjkMediaPlayerTracker.addUpAssetChange();
                                item.mIjkMediaPlayerTracker.addNetworkChange();
                            }
                            BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reason=" + reason2.getReason() + ",codec=" + reason2.getVideoCodecType() + ",format=" + reason2.getFormat() + "; will call onAssetUpdate");
                            long startTime2 = SystemClock.elapsedRealtime();
                            newMediaAsset3 = listener2.onAssetUpdate(reason2);
                            BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reason is " + reason2.getReason() + "; did call onAssetUpdate");
                            BLog.i(IjkMediaPlayerItem.TAG, "[PlayRecordDetail][changeUrl] [" + this + "] cost time = " + (SystemClock.elapsedRealtime() - startTime2) + "ms, get newMediaAsset = " + (newMediaAsset3 != null) + ", cid = " + item.mCid);
                        }
                        if (newMediaAsset3 != null) {
                            BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] newMediaAsset is ok");
                        }
                        this.mIjkMediaAsset = newMediaAsset3 == null ? this.mIjkMediaAsset : newMediaAsset3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SomeWorkHandler extends Handler {
        private final WeakReference<IjkMediaPlayerItem> mWeakItem;

        public SomeWorkHandler(IjkMediaPlayerItem item, Looper looper) {
            super(looper);
            this.mWeakItem = new WeakReference<>(item);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IjkMediaPlayerItem item = this.mWeakItem.get();
            if (item == null) {
                BLog.w(IjkMediaPlayerItem.TAG, "[" + this + "] IjkMediaPlayerItem went away with unhandled events");
                return;
            }
            switch (msg.what) {
                case 0:
                    if (IjkMediaPlayer.msIjkserviceIsConnected) {
                        obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        sendMessageDelayed(obtainMessage(0), 10L);
                        return;
                    }
                case 1:
                    if (item.mClient != null) {
                        IIjkMediaPlayerItem iitem = IjkMediaPlayer.msIjkMediaPlayerServiceConnection.registerItemClient(item.mClient.hashCode(), item.mClient, item);
                        synchronized (item.mWaitList) {
                            int listSize = item.mWaitList.size();
                            if (listSize > 0) {
                                for (int i = 0; i < listSize; i++) {
                                    sendMessage((Message) item.mWaitList.get(i));
                                }
                                item.mWaitList.clear();
                            }
                            item.mItem = iitem;
                        }
                    }
                    IIjkMediaPlayerItem iitem2 = item.mItem;
                    if (iitem2 == null) {
                        removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                case 2:
                    if (item.mIjkMediaPlayerTracker != null && !item.mIsStart) {
                        item.mIsStart = true;
                    }
                    item.mLastStartTime = SystemClock.elapsedRealtime();
                    item.mIsSetPriority = true;
                    Iterator it = item.mPriorityList.iterator();
                    while (it.hasNext()) {
                        PlayerItemPriority priority = (PlayerItemPriority) it.next();
                        item.setPlayerItemPriorityReal(priority);
                    }
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.setPropertyLong(8, item.mCid);
                            item.mItem.start();
                        }
                        if (item.isLive() && item.mIjkMediaConfigParams.mEnableP2PDownload && !hasMessages(14)) {
                            sendMessageDelayed(obtainMessage(14), 300000L);
                        }
                    } catch (RemoteException e) {
                    } catch (RuntimeException e2) {
                    }
                    item.mIsStop = false;
                    item.mPriorityList.clear();
                    return;
                case 3:
                case 10:
                    item.clearVividDataList();
                    if (msg.obj != null) {
                        IjkMediaPlayerTracker tracker = (IjkMediaPlayerTracker) msg.obj;
                        tracker.P2PReport(item);
                    }
                    synchronized (item.mStopLock) {
                        item.mIsStop = true;
                        item.mStopLock.notifyAll();
                    }
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.stop();
                        }
                    } catch (RemoteException e3) {
                    } catch (RuntimeException e4) {
                    }
                    item.mStepWaitTime = 0L;
                    item.mPktCountGot = false;
                    item.mIsStart = false;
                    removeMessages(14);
                    if (msg.what == 10) {
                        try {
                            if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                                item.mItem.reset();
                                IjkCacheManager.deleteDir(item.mDashCachePath);
                                IjkCacheManager.deleteDir(item.mVideoCachePath);
                                if (item.mAssetFd != null) {
                                    try {
                                        item.mAssetFd.close();
                                    } catch (IOException e5) {
                                    }
                                    item.mAssetFd = null;
                                }
                                synchronized (item) {
                                    item.mItem.ioInterrupt(item.mIoInterrupt);
                                }
                                item.mIsReset = true;
                                if (item.mMediaAsset != null) {
                                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reset with asset");
                                    Object source = item.getDataSource();
                                    if (source != null) {
                                        if (source instanceof String) {
                                            item.mItem.setDataSource((String) source);
                                        } else if (source instanceof ParcelFileDescriptor) {
                                            item.mItem.setDataSourceFd((ParcelFileDescriptor) source);
                                        } else {
                                            if (item.isLive()) {
                                                item.mItem.setDataSource("ijklivehook");
                                            } else if (item.isOffline()) {
                                                item.mItem.setDataSource("ijkofflinehook:ijkdash");
                                            } else {
                                                item.mItem.setDataSource("ijkdash");
                                            }
                                            item.mItem.setDataSourceJson(item.mediaAssetToJson(), item.mMediaAsset.getDefaultAudioId(), item.mMediaAsset.getDefaultVideoId());
                                        }
                                        item.setNetworkType(item.mNetWorkType);
                                        item.setItemOptions();
                                    } else {
                                        return;
                                    }
                                } else {
                                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] reset without asset");
                                }
                            }
                        } catch (RemoteException e6) {
                        } catch (RuntimeException e7) {
                        }
                        item.mIsStop = false;
                        return;
                    } else if (msg.what == 3) {
                        try {
                            item.reportPerformanceForSoftStrategy();
                            if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                                item.mItem.release();
                                IjkMediaPlayer.msIjkMediaPlayerServiceConnection.unregisterItemClient(item.mClient.hashCode());
                            }
                            IjkCacheManager.deleteDir(item.mDashCachePath);
                            IjkCacheManager.deleteDir(item.mVideoCachePath);
                            item.mHandleThread.quit();
                            IjkNetworkManager.getInstance(item.mContext).unRegisterListener(item);
                            if (item.mAssetFd != null) {
                                try {
                                    item.mAssetFd.close();
                                } catch (IOException e8) {
                                }
                                item.mAssetFd = null;
                                return;
                            }
                            return;
                        } catch (RemoteException e9) {
                            return;
                        } catch (RuntimeException e10) {
                            return;
                        }
                    } else {
                        return;
                    }
                case 4:
                    if (item.isVod() && item.mIjkMediaConfigParams.mEnableAutoResetStartPosition && item.mPlayPosition == 0) {
                        item.setStartPosition(item.mIjkMediaConfigParams.mStartOfPostion);
                    }
                    item.clearVividDataList();
                    return;
                case 5:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            IjkMediaPlayer.msIjkMediaPlayerServiceConnection.initP2PClient();
                            IjkMediaPlayer.msIjkMediaPlayerServiceConnection.initAbrParamsInterfaceClient();
                            AbrParamsInterface.updateParams();
                            AbrParamsInterface.setEnableHighExperience();
                            item.UpdateSoftActivationType();
                            Object source2 = item.getDataSource();
                            if (source2 != null) {
                                if (source2 instanceof String) {
                                    item.mItem.setDataSource((String) source2);
                                    return;
                                } else if (source2 instanceof ParcelFileDescriptor) {
                                    item.mItem.setDataSourceFd((ParcelFileDescriptor) source2);
                                    return;
                                } else {
                                    if (item.isLive()) {
                                        item.mItem.setDataSource("ijklivehook:");
                                    } else if (item.isOffline()) {
                                        item.mItem.setDataSource("ijkofflinehook:ijkdash");
                                    } else {
                                        item.mItem.setDataSource("ijkdash");
                                    }
                                    item.mItem.setDataSourceJson((String[]) source2, item.mMediaAsset.getDefaultAudioId(), item.mMediaAsset.getDefaultVideoId());
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (RemoteException e11) {
                        return;
                    } catch (RuntimeException e12) {
                        return;
                    }
                case 6:
                    synchronized (item) {
                        if (item.mState == STATE.CONNECTTING) {
                            if (item.mIjkMediaConfigParams.mSoftReconnect && item.mLastStartTime >= 0 && SystemClock.elapsedRealtime() - item.mLastStartTime > IjkMediaPlayerItem.ReconnectThreshold) {
                                try {
                                    if (item.mItem != null) {
                                        item.mIoInterrupt = 1;
                                        item.mItem.ioInterrupt(item.mIoInterrupt);
                                    }
                                } catch (RemoteException e13) {
                                }
                            }
                            item.mLastStartTime = -1L;
                            item.mState = STATE.CONNECTED;
                        }
                    }
                    return;
                case 7:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.setNetworkType(item.mNetWorkType);
                            item.setItemOptions();
                            return;
                        }
                        return;
                    } catch (RemoteException e14) {
                        return;
                    } catch (RuntimeException e15) {
                        return;
                    }
                case 8:
                    item.trackerIjkNativeInvokeMsg(msg.arg1, (Bundle) msg.obj);
                    return;
                case 9:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.setDataSourceJson(item.mediaAssetToJson(), item.mMediaAsset.getDefaultAudioId(), item.mMediaAsset.getDefaultVideoId());
                            return;
                        }
                        return;
                    } catch (RemoteException e16) {
                        return;
                    } catch (RuntimeException e17) {
                        return;
                    }
                case 11:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.setOptionLong(3, "seek-at-start", ((Long) msg.obj).longValue());
                            return;
                        }
                        return;
                    } catch (RemoteException e18) {
                        return;
                    } catch (RuntimeException e19) {
                        return;
                    }
                case 12:
                case 17:
                default:
                    BLog.e(IjkMediaPlayerItem.TAG, "[" + this + "] SomeWorkHandler Unknown message type " + msg.what);
                    return;
                case 13:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.setOptionLong(3, "render-after-prepare", msg.arg1);
                            return;
                        }
                        return;
                    } catch (RemoteException e20) {
                        return;
                    } catch (RuntimeException e21) {
                        return;
                    }
                case 14:
                    try {
                        item.doP2pLiveReport();
                        sendMessageDelayed(obtainMessage(14), 300000L);
                        return;
                    } catch (RuntimeException e22) {
                        return;
                    }
                case 15:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            P2PManuscriptInfo info = (P2PManuscriptInfo) msg.obj;
                            item.mItem.setPropertyString(IjkMediaPlayer.FFP_PROP_STRING_P2P_MANUSCRIPT_INFO, info.toJsonString());
                            return;
                        }
                        return;
                    } catch (RemoteException e23) {
                        return;
                    } catch (RuntimeException e24) {
                        return;
                    }
                case 16:
                    if (item.mIsSetPriority) {
                        item.setPlayerItemPriorityReal((PlayerItemPriority) msg.obj);
                        return;
                    } else {
                        item.mPriorityList.add((PlayerItemPriority) msg.obj);
                        return;
                    }
                case 18:
                    try {
                        if (item.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
                            item.mItem.setMultiAudioStream((String[]) msg.obj);
                            return;
                        }
                        return;
                    } catch (RemoteException e25) {
                        return;
                    } catch (RuntimeException e26) {
                        return;
                    }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class IjkMediaPlayerItemBinder extends IIjkMediaPlayerItemClient.Stub {
        private final WeakReference<IjkMediaPlayerItem> mWeakItem;

        public IjkMediaPlayerItemBinder(IjkMediaPlayerItem item) {
            this.mWeakItem = new WeakReference<>(item);
        }

        private long doRetryDelayStrategy(IjkMediaPlayerItem item) {
            long delayMs;
            if (item.mAssetChangeCount < 3) {
                delayMs = item.mAssetChangeCount * 100;
            } else if (item.mAssetChangeCount == 3) {
                delayMs = PlayerToastConfig.DURATION_2;
            } else {
                delayMs = PlayerToastConfig.DURATION_5;
            }
            BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] after " + delayMs + "ms get more urls");
            return delayMs;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x030f A[Catch: all -> 0x0362, TryCatch #2 {all -> 0x0362, blocks: (B:88:0x02d2, B:95:0x02e8, B:96:0x02f9, B:102:0x0309, B:104:0x030f, B:110:0x0323, B:107:0x031c), top: B:217:0x02d2 }] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x034b  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0360 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0374  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0382  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x040c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x00a2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02c4  */
        /* JADX WARN: Type inference failed for: r13v12 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onNativeInvoke(int what, Bundle args) {
            boolean z;
            Bundle bundle;
            int i;
            int videoCodecId;
            int error;
            int httpCode;
            int retryCounter;
            int segmentIndex;
            String url;
            ?? r13;
            int i2;
            int httpCode2;
            int segmentIndex2;
            int retryCounter2;
            int videoCodecId2;
            IjkAssetUpdateReason reason;
            int segmentIndex3;
            IjkMediaPlayerItem item = this.mWeakItem.get();
            if (item == null) {
                return false;
            }
            switch (what) {
                case 1:
                case 9:
                    z = true;
                    bundle = args;
                    i = 0;
                    break;
                case 2:
                    z = true;
                    bundle = args;
                    int isAudio = bundle.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_IS_AUDIO, 0);
                    int httpCode3 = bundle.getInt("http_code", 0);
                    int httpError = bundle.getInt("error", 0);
                    String ip = bundle.getString("ip", null);
                    if (isAudio != 0) {
                        item.mAudioIp = ip;
                    } else {
                        item.mVideoIp = ip;
                    }
                    boolean connected = false;
                    if (httpError >= 0 && httpCode3 >= 200 && httpCode3 < 400) {
                        connected = true;
                    }
                    if (isAudio == 0) {
                        item.mLastVideoConnected = connected;
                    } else {
                        item.mLastAudioConnected = connected;
                    }
                    if (!item.mLastVideoConnected || !item.mLastAudioConnected) {
                        i = 0;
                        break;
                    } else {
                        i = 0;
                        item.mAssetChangeCount = 0;
                        break;
                    }
                    break;
                case 7:
                    if (item.mIjkMediaPlayerTracker != null) {
                        IjkMediaPlayerTracker.UrlChangeInfo urlChangeInfo = new IjkMediaPlayerTracker.UrlChangeInfo(args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_IS_AUDIO, 0), args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_URL_CHANGE_COUNT, 0), args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_FORMAT_CHANGE_COUNT, 0), args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_CODEC_CHANGE_COUNT, 0), args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN_CHANGE_COUNT, 0));
                        item.mIjkMediaPlayerTracker.updateUrlChangeCount(item, urlChangeInfo);
                        return true;
                    }
                    return true;
                case IjkMediaPlayer.OnNativeInvokeListener.EVENT_THROUGHPUT_STATISTIC /* 74247 */:
                    int[] throughputSpeed = args.getIntArray(IjkMediaPlayer.OnNativeInvokeListener.ARG_THROUGHPUT_SPEED);
                    int[] throughputDuration = args.getIntArray(IjkMediaPlayer.OnNativeInvokeListener.ARG_THROUGHPUT_DURATION);
                    int num = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_THROUGHPUT_NUM, 0);
                    if (item.mIjkMediaPlayerTracker != null) {
                        item.mIjkMediaPlayerTracker.ijkThroughputStatistic(throughputSpeed, throughputDuration, num);
                        return true;
                    }
                    return true;
                case 131075:
                case 131077:
                case 131079:
                case IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_FILE_OPEN /* 131081 */:
                    String url2 = args.getString("url");
                    int segmentIndex4 = args.getInt("segment_index");
                    int retryCounter3 = args.getInt("retry_counter");
                    int isAudio2 = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_IS_AUDIO);
                    int error2 = args.getInt("error");
                    int httpCode4 = args.getInt("http_code");
                    int videoCodecId3 = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_VIDEO_CODEC_ID);
                    item.setNetworkType(item.mNetWorkType);
                    if (what == 131075 || what == 131077) {
                        long timestamp = args.getLong("timestamp", 0L);
                        if (item.mIjkMediaPlayerTracker != null) {
                            videoCodecId = videoCodecId3;
                            error = error2;
                            httpCode = httpCode4;
                            retryCounter = retryCounter3;
                            segmentIndex = segmentIndex4;
                            url = url2;
                            r13 = 1;
                            item.mIjkMediaPlayerTracker.httpWillRebuild(item, url2, retryCounter3, timestamp, isAudio2, error, httpCode, args);
                        } else {
                            videoCodecId = videoCodecId3;
                            error = error2;
                            httpCode = httpCode4;
                            retryCounter = retryCounter3;
                            segmentIndex = segmentIndex4;
                            url = url2;
                            r13 = 1;
                        }
                    } else {
                        videoCodecId = videoCodecId3;
                        error = error2;
                        httpCode = httpCode4;
                        retryCounter = retryCounter3;
                        segmentIndex = segmentIndex4;
                        url = url2;
                        r13 = 1;
                    }
                    int error3 = error;
                    if (error3 == -1431652088 && item.mState == STATE.CONNECTED) {
                        item.mDisableFreeUrl = r13;
                        BLog.i(IjkMediaPlayerItem.TAG, "free url unreachable, will fallback to base url");
                    }
                    if (IjkMediaPlayerItem.makeSureExtName(url, ".ts")) {
                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] skip all steps for ts");
                        return false;
                    }
                    if (item.mVodType != VodType.VOD_DASH || what == 131081) {
                        if (item.isLive()) {
                            i2 = 131077;
                            if (what != 131077) {
                                httpCode2 = httpCode;
                                videoCodecId2 = videoCodecId;
                                retryCounter2 = retryCounter;
                                segmentIndex2 = segmentIndex;
                            }
                        } else {
                            i2 = 131077;
                        }
                        if (what == 131079) {
                            segmentIndex2 = segmentIndex;
                            if (TextUtils.isEmpty(item.mediaAssetToUrl(segmentIndex2, 0))) {
                                httpCode2 = httpCode;
                                IjkAssetUpdateReason reason2 = new IjkAssetUpdateReason(r13, error3, httpCode2, segmentIndex2);
                                reason = reason2;
                                videoCodecId2 = videoCodecId;
                                retryCounter2 = retryCounter;
                                BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  item.mVodType " + item.mVodType + " what = " + what);
                                if (reason != null) {
                                    Message msg = item.mEventHandler.obtainMessage(0, reason);
                                    synchronized (item.mStopLock) {
                                        try {
                                            try {
                                                try {
                                                    if (item.mIsStop) {
                                                        return false;
                                                    }
                                                    long startTime = SystemClock.elapsedRealtime();
                                                    long delayMs = doRetryDelayStrategy(item);
                                                    item.mEventHandler.sendMessageDelayed(msg, delayMs);
                                                    while (!item.mIsStop) {
                                                        try {
                                                            item.mStopLock.wait();
                                                            if (item.mIjkMediaPlayerTracker == null) {
                                                                long endime = SystemClock.elapsedRealtime();
                                                                int onAssetError = 0;
                                                                if (item.mListener == null) {
                                                                    onAssetError = -2;
                                                                } else if (item.mIsStop) {
                                                                    onAssetError = -1;
                                                                }
                                                                segmentIndex3 = segmentIndex2;
                                                                try {
                                                                    item.mIjkMediaPlayerTracker.assetChangeBuild(item, reason, SystemClock.elapsedRealtime(), endime - startTime, onAssetError);
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    throw th;
                                                                }
                                                            } else {
                                                                segmentIndex3 = segmentIndex2;
                                                            }
                                                            if (item.mIsStop) {
                                                                return false;
                                                            }
                                                        } catch (InterruptedException e) {
                                                        }
                                                    }
                                                    if (item.mIjkMediaPlayerTracker == null) {
                                                    }
                                                    if (item.mIsStop) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                } else {
                                    segmentIndex3 = segmentIndex2;
                                }
                                if (what == 131079) {
                                    if (!item.isOffline()) {
                                        if (item.isVod() || item.isGif()) {
                                            args.putString("url", "ijkio:cache:ffio:ijkhttphook:" + item.mediaAssetToUrl(segmentIndex3, 0));
                                            return true;
                                        }
                                        return true;
                                    }
                                    Object ob = item.handleLocalUrl(segmentIndex3, 0);
                                    if (ob == null) {
                                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] CONCAT_RESOLVE_SEGMENT fail!!! segmentIndex " + segmentIndex3 + " retryCounter 0");
                                        return true;
                                    } else if (ob instanceof ParcelFileDescriptor) {
                                        args.putParcelable("fd", (ParcelFileDescriptor) ob);
                                        return true;
                                    } else {
                                        args.putString("url", (String) ob);
                                        return true;
                                    }
                                } else if (what == 131081) {
                                    Object source = item.getDataSource();
                                    if (source != null) {
                                        try {
                                            item.mItem.setDataSourceJson(item.mediaAssetToJson(), item.mMediaAsset.getDefaultAudioId(), item.mMediaAsset.getDefaultVideoId());
                                            return true;
                                        } catch (RemoteException e2) {
                                            return true;
                                        } catch (RuntimeException e3) {
                                            return true;
                                        }
                                    }
                                    return true;
                                } else if (what == 131077) {
                                    Object source2 = item.getDataSource();
                                    if (source2 != null) {
                                        try {
                                            item.mItem.setDataSourceJson(item.mediaAssetToJson(), item.mMediaAsset.getDefaultAudioId(), item.mMediaAsset.getDefaultVideoId());
                                            return true;
                                        } catch (RemoteException e4) {
                                            return true;
                                        } catch (RuntimeException e5) {
                                            return true;
                                        }
                                    }
                                    return true;
                                } else {
                                    if (what == 131075 && (item.mVodType == VodType.VOD_NORMAL || item.mVodType == VodType.VOD_MULTI_SEGMENGT || item.mVodType == VodType.VOD_HLS)) {
                                        url = item.mediaAssetToUrl(segmentIndex3, 0);
                                    }
                                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] onNativeInvoke url " + url + " segmentIndex " + segmentIndex3);
                                    String url3 = item.TryGetFreeFlowUrl(url);
                                    if (TextUtils.isEmpty(url3)) {
                                        return false;
                                    }
                                    args.putString("url", url3);
                                    return true;
                                }
                            }
                            httpCode2 = httpCode;
                        } else {
                            httpCode2 = httpCode;
                            segmentIndex2 = segmentIndex;
                        }
                        if (item.mIoInterrupt == r13) {
                            BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] do ASSET_UPDATE_REASON_INIT_RESOLVE  what = " + what + " item.mVodType " + item.mVodType);
                            IjkAssetUpdateReason reason3 = new IjkAssetUpdateReason(0, error3, httpCode2);
                            reason = reason3;
                            videoCodecId2 = videoCodecId;
                            retryCounter2 = retryCounter;
                        } else {
                            retryCounter2 = retryCounter;
                            if (retryCounter2 < r13) {
                                videoCodecId2 = videoCodecId;
                            } else if (error3 == -1230129400) {
                                IjkAssetUpdateReason reason4 = new IjkAssetUpdateReason(4, error3, httpCode2);
                                reason = reason4;
                                videoCodecId2 = videoCodecId;
                            } else if (item.mDisableFreeUrl) {
                                IjkAssetUpdateReason reason5 = new IjkAssetUpdateReason(5, error3, httpCode2);
                                reason = reason5;
                                videoCodecId2 = videoCodecId;
                            } else if (what == 131081) {
                                IjkAssetUpdateReason reason6 = new IjkAssetUpdateReason(3, error3, httpCode2);
                                videoCodecId2 = videoCodecId;
                                if (videoCodecId2 > 0) {
                                    item.mVideoCodecType = videoCodecId2;
                                }
                                reason = reason6;
                            } else {
                                videoCodecId2 = videoCodecId;
                                if (what == i2) {
                                    IjkAssetUpdateReason reason7 = new IjkAssetUpdateReason(3, error3, httpCode2);
                                    reason = reason7;
                                } else {
                                    BLog.w(IjkMediaPlayerItem.TAG, "[" + this + "]  network error !! error " + error3 + " httpCode " + httpCode2);
                                    if (TextUtils.isEmpty(item.mediaAssetToUrl(segmentIndex2, retryCounter2))) {
                                        IjkAssetUpdateReason reason8 = new IjkAssetUpdateReason(3, error3, httpCode2);
                                        reason = reason8;
                                    }
                                }
                            }
                        }
                        BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  item.mVodType " + item.mVodType + " what = " + what);
                        if (reason != null) {
                        }
                        if (what == 131079) {
                        }
                    } else {
                        httpCode2 = httpCode;
                        videoCodecId2 = videoCodecId;
                        retryCounter2 = retryCounter;
                        segmentIndex2 = segmentIndex;
                    }
                    reason = null;
                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "]  item.mVodType " + item.mVodType + " what = " + what);
                    if (reason != null) {
                    }
                    if (what == 131079) {
                    }
                    break;
                case IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_FILE_IO_OPEN /* 131082 */:
                    IjkMediaAsset asset = item.mMediaAsset;
                    if (asset == null) {
                        return true;
                    }
                    int segmentIndex5 = args.getInt("segment_index");
                    int qn = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN);
                    Iterator<IjkMediaAsset.MediaAssetStream> it = asset.getStreamList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            IjkMediaAsset.MediaAssetStream stream = it.next();
                            if (stream.getQualityId() == qn || asset.getStreamList().size() == 1) {
                                try {
                                    long fileSize = stream.getMediaAssertSegments().get(segmentIndex5).getSize();
                                    BLog.i(IjkMediaPlayerItem.TAG, "[" + this + "] qn " + qn + " segmentIndex " + segmentIndex5 + " fileSize " + fileSize);
                                    args.putLong("file_size", fileSize);
                                } catch (IndexOutOfBoundsException e6) {
                                }
                            }
                            if (!it.hasNext()) {
                            }
                        }
                    }
                    return true;
                default:
                    return true;
            }
            item.mSomeWorkHandle.obtainMessage(8, what, i, bundle).sendToTarget();
            if (what == 9) {
                item.mPktCountGot = z;
            }
            return z;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        public int addHdrVividMetadata(byte[] data, int size, long pts) {
            IjkMediaPlayerItem item = this.mWeakItem.get();
            if (item == null) {
                return -1;
            }
            synchronized (item.mVividDataList) {
                while (item.mVividDataList.size() >= 100) {
                    item.mVividDataList.poll();
                }
                ByteBuffer buffer = ByteBuffer.wrap(data, 0, size);
                Pair<ByteBuffer, Long> dataPair = new Pair<>(buffer, Long.valueOf(pts));
                item.mVividDataList.add(dataPair);
            }
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        public void onEventHandler(int what, int arg1, int arg2, long timestamp, String str) {
        }
    }

    @Override // tv.danmaku.ijk.media.player.utils.IjkNetworkManager.NetWorkChangeListener
    public void onNetWorkChange(IjkNetworkUtils.NetWorkType cur, IjkNetworkUtils.NetWorkType old) {
        BLog.i(TAG, "[" + this + "]  onNetWorkChange cur " + cur + " old " + old);
        Message msg = this.mEventHandler.obtainMessage(1, old.ordinal(), cur.ordinal(), null);
        this.mEventHandler.sendMessage(msg);
    }

    public void setRecommendedQn(boolean useRecommendedQn, int minRecommendedQn, int maxRecommendedQn) {
        if (this.mIjkMediaConfigParams != null) {
            this.mIjkMediaConfigParams.mUseRecommendedQn = useRecommendedQn;
            this.mIjkMediaConfigParams.mMinRecommendedQn = minRecommendedQn;
            this.mIjkMediaConfigParams.mMaxRecommendedQn = maxRecommendedQn;
        }
    }

    public void setStoryMode(int storyMode) {
    }

    public void setCidToNative() {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                this.mItem.setPropertyLong(8, this.mCid);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
    }

    public void setExpectLatency(int latency, int enableSkipFrame, int enableJitterBuffer) {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                if (this.mIjkMediaPlayerTracker != null) {
                    this.mIjkMediaPlayerTracker.setExpectLatency(latency, enableSkipFrame, enableJitterBuffer);
                }
                this.mItem.setPropertyLong(9, latency);
                this.mItem.setPropertyLong(10, enableSkipFrame);
                this.mItem.setPropertyLong(11, enableJitterBuffer);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
    }

    public void setIsAbleLowLatency(int isAbleLowLatency) {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                if (this.mIjkMediaPlayerTracker != null) {
                    this.mIjkMediaPlayerTracker.setIsAbleLowLatency(isAbleLowLatency);
                }
                this.mItem.setPropertyLong(12, isAbleLowLatency);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
    }

    public void setGuid(String guid) {
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.setGuid(guid);
        }
    }

    public void setItemMaxQn(int maxQn) {
        BLog.i(TAG, "setItemMaxQn=" + maxQn);
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.setItemMaxQn(maxQn);
        }
    }

    public void setScreenState(int state) {
        BLog.i(TAG, "[PlayRecordDetail][setScreenState] " + state);
        this.mScreenState = state;
        if (this.mIjkMediaPlayerTracker != null) {
            this.mIjkMediaPlayerTracker.setScreenState(state);
        }
    }

    public int getScreenState() {
        return this.mScreenState;
    }

    public long getCid() {
        return this.mCid;
    }

    public String getNativePropertyString(int propId) {
        String nativeInfo = "";
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                nativeInfo = this.mItem.getPropertyString(propId);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
        if (nativeInfo == null) {
            return "";
        }
        return nativeInfo;
    }

    public long getNativePropertyLong(int property, long defaultValue) {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                return this.mItem.getPropertyLong(property, defaultValue);
            } catch (RemoteException e) {
                return 0L;
            } catch (RuntimeException e2) {
                return 0L;
            }
        }
        return 0L;
    }

    public long getTcpSpeed() {
        return getNativePropertyLong(IjkMediaPlayer.FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public long getFormat() {
        return getNativePropertyLong(IjkMediaPlayer.FFP_PROP_INT64_FILE_TYPE, 0L);
    }

    public long getPlayerError() {
        return getNativePropertyLong(IjkMediaPlayer.FFP_PROP_INT64_PLAYER_ERROR_CODE, 0L);
    }

    public long getItemError() {
        return getNativePropertyLong(IjkMediaPlayer.FFP_PROP_INT64_ITEM_ERROR_CODE, 0L);
    }

    public long getRecommendedQn() {
        return getNativePropertyLong(IjkMediaPlayer.FFP_PROP_INT64_RECOMMENDED_QN, 0L);
    }

    public float getDropFrameRate() {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                return this.mItem.getPropertyFloat(10007, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
        return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }

    public String getDolbyConfigPath() {
        return this.mDolbyConfigPath;
    }

    public int getHDRVideoType() {
        return this.mHdrVideoType;
    }

    public int getHDRRenderType() {
        return this.mHdrRenderType;
    }

    public boolean isTryHwHdr() {
        return this.mIjkMediaConfigParams.mTryHwHdr;
    }

    public boolean isDisableFlushBlack() {
        return this.mIjkMediaConfigParams.mDisableFlushBlack;
    }

    public boolean isDisableSurfaceAlign() {
        return this.mIjkMediaConfigParams.mDisableSurfaceAlign;
    }

    public boolean isEnableIgnoreOnlyVideoBufferingReport() {
        return this.mIjkMediaConfigParams.mEnableIgnoreOnlyVideoBufferingReport;
    }

    public Bundle getPropertiesBundle(int... keys) {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                return this.mItem.getPropertiesBundle(keys);
            } catch (RemoteException e) {
                return null;
            } catch (RuntimeException e2) {
                return null;
            }
        }
        return null;
    }

    public int getFirstRenderMode() {
        return this.mFirstRenderMode;
    }

    public long getStepWaitTime() {
        return this.mStepWaitTime;
    }

    public boolean isGetFreeUrlBlocked() {
        return this.mGetFreeUrlStartTime > 0 && SystemClock.elapsedRealtime() - this.mGetFreeUrlStartTime > PlayerToastConfig.DURATION_3;
    }

    public int GetNoAssetUpdateListenerCount() {
        return this.mNoAssetUpdateListenerCount;
    }

    public int getCurQn() {
        return this.mCurVideoId;
    }

    public HashMap<String, String> getP2PStreamState(HashMap<String, String> p2pKeyMap) {
        HashMap<String, String> ret = new HashMap<>();
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                Bundle bundle = new Bundle();
                this.mItem.getPropBundle(IjkMediaPlayer.FFP_PROP_BUNDLE_P2P_STREAM_STATE, bundle);
                for (String key : p2pKeyMap.keySet()) {
                    String keyValue = p2pKeyMap.get(key);
                    Object object = bundle.get(keyValue);
                    if (object != null) {
                        if (object instanceof String) {
                            ret.put(key, (String) object);
                        } else if (object instanceof Long) {
                            ret.put(key, String.valueOf(((Long) object).longValue()));
                        } else if (object instanceof Integer) {
                            ret.put(key, String.valueOf(((Integer) object).intValue()));
                        }
                    }
                }
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackerIjkNativeInvokeMsg(int what, Bundle args) {
        switch (what) {
            case 1:
                if (this.mIjkMediaPlayerTracker != null) {
                    String httpUrl = args.getString("url", null);
                    int isAudio = args.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_IS_AUDIO, 0);
                    this.mIjkMediaPlayerTracker.updateUrl(httpUrl, isAudio);
                    return;
                }
                return;
            case 2:
                if (this.mIjkMediaPlayerTracker != null) {
                    this.mIjkMediaPlayerTracker.httpBuild(this, args);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean isEqualsToInternal(String name) {
        if (this.mItem != null && IjkMediaPlayer.msIjkserviceIsConnected) {
            try {
                return this.mItem.isEqualsToInternal(name);
            } catch (RemoteException e) {
                return false;
            } catch (RuntimeException e2) {
                return false;
            }
        }
        return false;
    }

    public int getScheme() {
        return this.mScheme;
    }

    public boolean isLive() {
        return this.mScheme == 1 || this.mScheme == 9;
    }

    public boolean isVod() {
        return this.mScheme == 2 || this.mScheme == 3 || this.mScheme == 6;
    }

    public boolean isGif() {
        return this.mScheme == 7 || this.mScheme == 8;
    }

    public boolean isOffline() {
        return this.mScheme == 5 || this.mScheme == 8;
    }

    public boolean isCachable() {
        return this.mScheme == 2 || this.mScheme == 3 || this.mScheme == 6 || this.mScheme == 7;
    }

    public boolean isStory() {
        return this.mScheme == 6 || this.mScheme == 9;
    }

    public boolean isPreload() {
        Bundle bundle = getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_PACKETS, IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_AUDIO_CACHED_PACKETS);
        long audioCachePackets = 0;
        long videoCachePackets = 0;
        if (bundle != null) {
            try {
                audioCachePackets = Long.valueOf(bundle.getString(String.valueOf((int) IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_AUDIO_CACHED_PACKETS))).longValue();
                videoCachePackets = Long.valueOf(bundle.getString(String.valueOf((int) IjkMediaPlayer.FFP_PROP_INT64_BUFFERING_VIDEO_CACHED_PACKETS))).longValue();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return (audioCachePackets == 0 && videoCachePackets == 0) ? false : true;
    }

    public boolean isEac3HwRender() {
        if (this.mIjkMediaConfigParams.mDoblyCheckMediaCodec) {
            return IjkCodecHelper.isEac3MediaCodecSupport();
        }
        return false;
    }

    public boolean isEnableAlphaLayer() {
        if (this.mIjkMediaConfigParams != null) {
            return this.mIjkMediaConfigParams.mEnableAlphaLayer;
        }
        return false;
    }

    private boolean isValid(double value, double left, double right) {
        return !Double.isNaN(value) && value >= left && value <= right;
    }

    private boolean isMeasuredParamsValid(IjkMediaConfigParams params) {
        double[] paramMin = IjkMediaConfigParams.kIJKLoudNormParamMin;
        double[] paramMax = IjkMediaConfigParams.kIJKLoudNormParamMax;
        return isValid(params.mMeasuredI, paramMin[0], paramMax[0]) && isValid(params.mMeasuredLRA, paramMin[1], paramMax[1]) && isValid(params.mMeasuredTP, paramMin[2], paramMax[2]) && isValid(params.mMeasuredThreshold, paramMin[3], paramMax[3]) && isValid(params.mTargetOffset, paramMin[4], paramMax[4]);
    }

    private boolean isTargetParamsValid(IjkMediaConfigParams params) {
        double[] paramMin = IjkMediaConfigParams.kIJKLoudNormParamMin;
        double[] paramMax = IjkMediaConfigParams.kIJKLoudNormParamMax;
        return isValid(params.mTargetI, paramMin[5], paramMax[5]) && isValid(params.mTargetTP, paramMin[6], paramMax[6]);
    }

    private boolean checkParams(IjkMediaConfigParams params) {
        if (!isTargetParamsValid(params)) {
            BLog.e(TAG, "disable loudnorm: loudnorm target params not found or not in range");
            params.mLoudnormType = params.mLoudnormType == IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI ? IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI_WITH_ERROR : IjkMediaConfigParams.LoudnormType.LOUDNORM_OFF_ERROR;
            return false;
        } else if (!isMeasuredParamsValid(params)) {
            BLog.i(TAG, "disable loudnorm: loudnorm param not found (check the video date), or not in range");
            params.mLoudnormType = params.mLoudnormType == IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI ? IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI_WITH_NO_MEASURED : IjkMediaConfigParams.LoudnormType.LOUDNORM_OFF_NO_MEASURED;
            return false;
        } else if (params.mMeasuredI < params.mUndersizedTargetI) {
            BLog.i(TAG, "disable loudnorm: measured_i (" + params.mMeasuredI + ") < undersized_target_i (" + params.mUndersizedTargetI + ")");
            params.mLoudnormType = params.mLoudnormType == IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI ? IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI_WITH_SMALL_MEASURED_I : IjkMediaConfigParams.LoudnormType.LOUDNORM_OFF_SMALL_MEASURED_I;
            return false;
        } else {
            return true;
        }
    }

    private boolean setTargetIFromMap(IjkMediaConfigParams params) {
        Map<String, String> multiSceneArgs = params.mMultiSceneArgs;
        try {
            params.mUndersizedTargetI = Double.parseDouble((String) Objects.requireNonNull(multiSceneArgs.get("undersized_target_i"), "undersized_target_i"));
            if (params.mLoudnormType == IjkMediaConfigParams.LoudnormType.LOUDNORM_NORMAL_TYPE) {
                params.mTargetI = Double.parseDouble((String) Objects.requireNonNull(multiSceneArgs.get("normal_target_i"), "normal_target_i"));
                return true;
            } else if (params.mLoudnormType == IjkMediaConfigParams.LoudnormType.LOUDNORM_HIGH_DYNAMIC_TYPE) {
                params.mTargetI = Double.parseDouble((String) Objects.requireNonNull(multiSceneArgs.get("high_dynamic_target_i"), "high_dynamic_target_i"));
                return true;
            } else {
                BLog.e(TAG, "disable loudnorm: loudnorm type is illegal");
                return false;
            }
        } catch (NullPointerException e) {
            BLog.e(TAG, "disable loudnorm: multiSceneArgs return value=null for key=" + e.getMessage());
            return false;
        } catch (NumberFormatException e2) {
            BLog.e(TAG, "disable loudnorm: multiSceneArgs return value is not a number for key=" + e2.getMessage());
            return false;
        }
    }

    private String getAFString(IjkMediaConfigParams params) {
        StringBuilder afBuilder = new StringBuilder("aresample=ochl=stereo:resampler=soxr,ijkloudnorm=");
        afBuilder.append("measured_i=").append(params.mMeasuredI).append(":").append("measured_lra=").append(params.mMeasuredLRA).append(":").append("measured_tp=").append(params.mMeasuredTP).append(":").append("measured_thresh=").append(params.mMeasuredThreshold).append(":").append("offset=").append(params.mTargetOffset).append(":").append("I=").append(params.mTargetI).append(":").append("tp=").append(params.mTargetTP).append(":").append("linear=true:print_format=summary");
        BLog.i(TAG, "enable loudnorm: measured_i=" + params.mMeasuredI + ",target_i=" + params.mTargetI);
        return afBuilder.toString();
    }

    private String getAFilter(IjkMediaConfigParams params) {
        if (params.mMultiSceneArgs == null || params.mMultiSceneArgs.isEmpty()) {
            BLog.w(TAG, "loudnorm: multiSceneArgs is null or empty, check target_i");
            params.mUndersizedTargetI = -28.0d;
            params.mLoudnormType = IjkMediaConfigParams.LoudnormType.LOUDNORM_NO_MULTI;
        } else if (!setTargetIFromMap(params)) {
            params.mLoudnormType = IjkMediaConfigParams.LoudnormType.LOUDNORM_OFF_ERROR;
            return null;
        }
        if (checkParams(params)) {
            return getAFString(params);
        }
        return null;
    }

    private void UpdateThreadMap(HashMap<String, Integer> threadMap, Bundle sampleRecord) {
        if (threadMap != null && sampleRecord != null) {
            for (String key : sampleRecord.keySet()) {
                Integer lastCount = threadMap.get(key);
                if (lastCount != null) {
                    threadMap.put(key, Integer.valueOf(lastCount.intValue() + sampleRecord.getInt(key)));
                } else {
                    threadMap.put(key, Integer.valueOf(sampleRecord.getInt(key)));
                }
            }
        }
    }

    public void AddPerformanceSampleValue(IjkPerformanceManager.SampleValue mainSample, IjkPerformanceManager.SampleValue ijkSample) {
        synchronized (this.mIjkProcessPerformance) {
            this.mIjkProcessPerformance.cpu += ijkSample.cpu;
            this.mIjkProcessPerformance.thread += ijkSample.thread;
            this.mIjkProcessPerformance.mem += ijkSample.memory;
            UpdateThreadMap(this.mIjkProcessPerformance.threadMap, ijkSample.threadRecord);
            this.mIjkProcessPerformance.counter++;
        }
        synchronized (this.mMainProcessPerformance) {
            this.mMainProcessPerformance.cpu += mainSample.cpu;
            this.mMainProcessPerformance.thread += mainSample.thread;
            this.mMainProcessPerformance.mem += mainSample.memory;
            UpdateThreadMap(this.mMainProcessPerformance.threadMap, mainSample.threadRecord);
            this.mMainProcessPerformance.counter++;
            this.mMainProcessPerformance.curBatteryLevel = mainSample.curBatteryLevel;
        }
    }

    private void GenerateReportPerformance(PerformanceTracker performanceTracker, PerformanceTracker reportPeformance) {
        if (performanceTracker.counter > 0) {
            long count = performanceTracker.counter;
            reportPeformance.cpu = (int) (performanceTracker.cpu / count);
            reportPeformance.mem = performanceTracker.mem / count;
            reportPeformance.thread = performanceTracker.thread / count;
            for (Map.Entry<String, Integer> entry : performanceTracker.threadMap.entrySet()) {
                int avgCount = (int) (entry.getValue().intValue() / count);
                reportPeformance.threadMap.put(entry.getKey(), Integer.valueOf(avgCount));
            }
        }
    }

    public int GetCurBatteryLevel() {
        return this.mMainProcessPerformance.curBatteryLevel;
    }

    public PerformanceTracker GetPerformance(String name) {
        PerformanceTracker reportPerformance = new PerformanceTracker(name);
        boolean isIjkProcess = name.equals(IJK_PROCESS);
        if (isIjkProcess) {
            synchronized (this.mIjkProcessPerformance) {
                GenerateReportPerformance(this.mIjkProcessPerformance, reportPerformance);
            }
        } else {
            synchronized (this.mMainProcessPerformance) {
                GenerateReportPerformance(this.mMainProcessPerformance, reportPerformance);
            }
        }
        return reportPerformance;
    }

    public Queue<Pair<ByteBuffer, Long>> getVividDataList() {
        return this.mVividDataList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVividDataList() {
        synchronized (this.mVividDataList) {
            if (!this.mVividDataList.isEmpty()) {
                this.mVividDataList.clear();
                BLog.i(TAG, "[VividDataList LifeCycle] clearVividDataList: mVividDataList.clear()");
            }
        }
    }

    private boolean hasStream(IjkMediaAsset.VideoCodecType codecType) {
        for (IjkMediaAsset.MediaAssetStream stream : this.mMediaAsset.getStreamList()) {
            if (stream.getStreamType() == IjkMediaAsset.StreamType.DASH_VIDEO && stream.getVideoCodecType() == codecType) {
                return true;
            }
        }
        return false;
    }

    private void setDeviceLevel() {
        try {
            IjkDeviceScoreInfo deviceScoreInfo = IjkDeviceScoreInfo.getInstance(null);
            int deviceLevel = deviceScoreInfo == null ? -1 : deviceScoreInfo.getDeviceLevel();
            this.mItem.setPropertyLong(16, deviceLevel);
        } catch (Exception e) {
            BLog.w(TAG, e);
        }
    }

    private boolean applyForActivation() {
        try {
            if (this.mItem.getPropertyLong(IjkMediaPlayer.FFP_PROP_INT64_SOFT_ACTIVATION, 0L) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            BLog.w(TAG, e);
            return false;
        }
    }

    private void applyActivationDecision(boolean decision) {
        try {
            this.mItem.setPropertyLong(14, decision ? 1L : 0L);
        } catch (Exception e) {
            BLog.w(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateSoftActivationType() {
        if (this.mItem == null || this.mMediaAsset == null || !this.mIjkMediaConfigParams.mEnableDecodeSwitch) {
            return;
        }
        if ((!IjkCodecHelper.isH266SupportSoft(this.mContext) && !IjkCodecHelper.isAv1SupportSoft(this.mContext)) || this.mSoftActivatedType != SoftActivatedType.SOFT_NO) {
            return;
        }
        setDeviceLevel();
        if (IjkCodecHelper.isH266SupportSoft(this.mContext) && hasStream(IjkMediaAsset.VideoCodecType.H266)) {
            if (applyForActivation()) {
                this.mSoftActivatedType = SoftActivatedType.SOFT_H266;
            }
        } else if (IjkCodecHelper.isAv1SupportSoft(this.mContext) && AbrParamsInterface.IsEnableVodUseAv1Soft() && hasStream(IjkMediaAsset.VideoCodecType.AV1)) {
            if (applyForActivation()) {
                this.mSoftActivatedType = SoftActivatedType.SOFT_AV1;
                this.mAv1SoftMaxQn = AbrParamsInterface.getAv1SoftMaxQn();
            }
        } else {
            applyActivationDecision(false);
        }
        BLog.i(TAG, "[softStrategy] activated soft codecType=" + this.mSoftActivatedType + ", cid=" + this.mCid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPerformanceForSoftStrategy() {
        if (this.mItem != null) {
            if (!IjkCodecHelper.isAv1SupportSoft(this.mContext) && !IjkCodecHelper.isH266SupportSoft(this.mContext)) {
                return;
            }
            try {
                PerformanceTracker report = GetPerformance(IJK_PROCESS);
                this.mItem.setPropertyLong(13, (long) report.cpu);
            } catch (RemoteException e) {
            } catch (RuntimeException e2) {
            }
        }
    }

    public void setEnhanceQnList(int[] qnList) {
        boolean enable = AbrParamsInterface.IsEnableVodEnhance();
        BLog.i(TAG, "setEnhanceQnList qnList.length = " + qnList.length + " enableVodEnhance = " + enable);
        if (this.mItem == null || qnList.length == 0 || !enable) {
            return;
        }
        this.mEnhanceQnList = qnList;
        try {
            this.mItem.setPropertyLong(15, 1L);
        } catch (RemoteException e) {
        } catch (RuntimeException e2) {
        }
    }

    public boolean qnShouldEnhance(int curQn) {
        int[] iArr;
        if (this.mEnhanceQnList == null || this.mEnhanceQnList.length == 0) {
            return false;
        }
        for (int qn : this.mEnhanceQnList) {
            if (qn == curQn) {
                return true;
            }
        }
        return false;
    }
}