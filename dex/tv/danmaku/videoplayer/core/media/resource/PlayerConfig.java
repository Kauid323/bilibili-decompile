package tv.danmaku.videoplayer.core.media.resource;

public class PlayerConfig {
    public static final int PLAYER_IJK = 1;
    public static final int PLAYER_NONE = 0;
    public boolean mUseIJKMediaCodec;
    public boolean mUseListPlayer;
    public int mPlayer = 0;
    public int mRetryCount = 0;
    public int mTotalRetryCount = 2;
    public String mCacheFilePath = null;
    public String mCacheMapPath = null;

    public boolean isIJKPlayer() {
        return this.mPlayer == 1;
    }

    public boolean is3rd() {
        return this.mPlayer > 1;
    }
}