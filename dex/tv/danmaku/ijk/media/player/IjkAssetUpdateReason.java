package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.IjkNetworkUtils;

public class IjkAssetUpdateReason {
    public static final int ASSET_UPDATE_REASON_ERROR_CODE_CONNECTION_TIMED_OUT = -1001;
    public static final int ASSET_UPDATE_REASON_FREE_URL_UNREACHABLE = 5;
    public static final int ASSET_UPDATE_REASON_HTTP_RESPONSE_INVALID = 4;
    public static final int ASSET_UPDATE_REASON_INIT_RESOLVE = 0;
    public static final int ASSET_UPDATE_REASON_NETWORK_CHANGE = 2;
    public static final int ASSET_UPDATE_REASON_NETWORK_ERROR = 3;
    public static final int ASSET_UPDATE_REASON_REQUEST_SEGMENT = 1;
    private IjkNetworkUtils.NetWorkType mCurrentNetWork;
    private int mErrorCode;
    private int mFormat;
    private int mHttpCode;
    private IjkNetworkUtils.NetWorkType mOldNetWork;
    private int mReason;
    private int mSegmentIndex;
    private int mVideoCodecType;

    public IjkAssetUpdateReason(int reason, int errorCode, int httpCode) {
        this(reason, errorCode, httpCode, 0);
    }

    public IjkAssetUpdateReason(int reason, int errorCode, int httpCode, int segmentIndex) {
        this.mCurrentNetWork = IjkNetworkUtils.NetWorkType.NONE;
        this.mOldNetWork = IjkNetworkUtils.NetWorkType.NONE;
        this.mVideoCodecType = 0;
        this.mFormat = 0;
        this.mErrorCode = errorCode;
        this.mReason = reason;
        this.mHttpCode = httpCode;
    }

    public void setVideoCodecType(int type) {
        this.mVideoCodecType = type;
    }

    public int getVideoCodecType() {
        return this.mVideoCodecType;
    }

    public void setFormat(int format) {
        this.mFormat = format;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getReason() {
        return this.mReason;
    }

    public IjkNetworkUtils.NetWorkType getCurrentNetWork() {
        return this.mCurrentNetWork;
    }

    public void setCurrentNetWork(IjkNetworkUtils.NetWorkType type) {
        this.mCurrentNetWork = type;
    }

    public IjkNetworkUtils.NetWorkType getOldNetWork() {
        return this.mOldNetWork;
    }

    public void setOldNetWork(IjkNetworkUtils.NetWorkType type) {
        this.mOldNetWork = type;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public int getmSegmentIndex() {
        return this.mSegmentIndex;
    }
}