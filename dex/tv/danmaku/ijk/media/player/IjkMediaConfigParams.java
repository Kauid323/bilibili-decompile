package tv.danmaku.ijk.media.player;

import java.util.Map;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class IjkMediaConfigParams {
    public static final long IJK_EAC3_DEFAULT_DIALOGENHANCEMENTGAIN = 6;
    public static final long IJK_EAC3_DEFAULT_ENDPOINT = 2;
    public static final long IJK_EAC3_DEFAULT_MAINASSOPREF = -32;
    public static final long IJK_EAC3_DEFAULT_OUTPUTREFERENCELEVEL = -14;
    public static final long IJK_EAC3_DEFAULT_PRESENTATIONID = 65535;
    public static final long IJK_EAC3_DEFAULT_VIRTUALIZERONNOFF = 1;
    public static final int IJK_LOUDNORM_PARAM_MEASURED_I = 0;
    public static final int IJK_LOUDNORM_PARAM_MEASURED_LRA = 1;
    public static final int IJK_LOUDNORM_PARAM_MEASURED_THRESHOLD = 3;
    public static final int IJK_LOUDNORM_PARAM_MEASURED_TP = 2;
    public static final int IJK_LOUDNORM_PARAM_TARGET_I = 5;
    public static final int IJK_LOUDNORM_PARAM_TARGET_OFFSET = 4;
    public static final int IJK_LOUDNORM_PARAM_TARGET_TP = 6;
    public static final double[] kIJKLoudNormParamMin = {-99.0d, 0.0d, -99.0d, -99.0d, -99.0d, -70.0d, -9.0d};
    public static final double[] kIJKLoudNormParamMax = {0.0d, 99.0d, 99.0d, 0.0d, 99.0d, -5.0d, 0.0d};
    public long mInitCacheTime = PlayerToastConfig.DURATION_3;
    public int mStartOfPostion = 0;
    public boolean mEnableHwCodec = true;
    public long mTcpReadWriteTimeOut = 2000000;
    public boolean mStartOnPrepared = false;
    public boolean mEnableDecodeSwitch = false;
    public boolean mEnableAudioOpenSLES = false;
    public long mSkipLoopFilter = 48;
    public long mSkipFrame = 0;
    public boolean mEnableDropFrame = true;
    public String mErrorListForUseBackupUrl = "";
    public String mUserAgent = "Bilibili Freedoooooom/MarkII";
    public String mReferer = null;
    public int mMultiBufferingControl = 0;
    public boolean mForceRenderLastFrame = false;
    public boolean mEnableH265Codec = false;
    public boolean mEnableAv1Codec = false;
    public boolean mEnableDolbyVisionCodec = false;
    public boolean mEnableVariableSeekBuffer = false;
    public int mAccurateSeekTimeout = 500;
    public boolean mEnableRawData = false;
    public boolean mGetFrameMode = false;
    public int mLoop = 1;
    public boolean mRenderAfterPrepare = true;
    public boolean mEnableVariableWh = false;
    public boolean mEnableP2PDownload = false;
    public String mAVid = "";
    public int mHdrVideoType = 0;
    public int mHdrRenderType = 0;
    public boolean mTryHwHdr = false;
    public long mExpHdrMaxDisplayLum = 0;
    public boolean mUseRecommendedQn = false;
    public int mMaxRecommendedQn = 0;
    public int mMinRecommendedQn = 0;
    public int mStartScreenRatio = 0;
    public int mLiveHeartbeatInterval = 60000;
    public String mAppVersion = "";
    public boolean mEnableReportWidevineType = false;
    public int mAudioTrackStreamType = 3;
    public long mEac3Type = 0;
    public long mEndpoint = 2;
    public long mVirtualizerOnnoff = 1;
    public long mDialogEnhancementGain = 6;
    public long mOutputReferenceLevel = -14;
    public long mPresentationId = IJK_EAC3_DEFAULT_PRESENTATIONID;
    public long mMainAssoPref = -32;
    public LoudnormType mLoudnormType = LoudnormType.LOUDNORM_NONE;
    public double mMeasuredI = Double.NaN;
    public double mMeasuredLRA = Double.NaN;
    public double mMeasuredTP = Double.NaN;
    public double mMeasuredThreshold = Double.NaN;
    public double mTargetOffset = Double.NaN;
    public double mTargetI = Double.NaN;
    public double mTargetTP = Double.NaN;
    public double mUndersizedTargetI = Double.NaN;
    public Map<String, String> mMultiSceneArgs = null;
    public boolean mDoblyCheckMediaCodec = true;
    public int mSuperResolution = 0;
    public boolean mEnableCarRetryStrategy = false;
    public boolean mEnableStoryP2PDownload = false;
    public String mDolbyConfigPath = "";
    public String mUnusedLowLatencyCodecList = "";
    public long mMaxCacheSize = 157286400;
    public boolean mEnableAutoResetStartPosition = false;
    public boolean mEnableEarlyFrameDrop = true;
    public boolean mDisableFlushBlack = false;
    public boolean mLiveDiscontinueWhenEOF = true;
    public boolean mEnableAmendExternalClock = false;
    public boolean mEnableIgnoreOnlyVideoBufferingReport = false;
    public boolean mSoftReconnect = false;
    public boolean mDisableSurfaceAlign = false;
    public boolean mEnableAlphaLayer = false;
    public boolean mIsInLiveRoom = false;
    public int mExpectStartLatency = 0;
    public boolean mEnableIgnoreDiscardPkt = false;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum LoudnormType {
        LOUDNORM_NONE,
        LOUDNORM_NORMAL_TYPE,
        LOUDNORM_HIGH_DYNAMIC_TYPE,
        LOUDNORM_OFF_SMALL_MEASURED_I,
        LOUDNORM_OFF_NO_MEASURED,
        LOUDNORM_OFF_ERROR,
        LOUDNORM_NO_MULTI,
        LOUDNORM_NO_MULTI_WITH_SMALL_MEASURED_I,
        LOUDNORM_NO_MULTI_WITH_NO_MEASURED,
        LOUDNORM_NO_MULTI_WITH_ERROR
    }
}