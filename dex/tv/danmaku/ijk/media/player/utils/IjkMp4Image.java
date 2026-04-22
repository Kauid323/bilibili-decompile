package tv.danmaku.ijk.media.player.utils;

import java.nio.ByteBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.utils.IjkImageRecorder;

public class IjkMp4Image implements IIjkMp4Image {
    private static final String TAG = "IjkMp4Image";
    private IIjkImageRecorder mRecorder;
    private int mSizeInBytes;

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public int getWidth() {
        if (this.mRecorder == null) {
            return 0;
        }
        return this.mRecorder.getWidth();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public int getHeight() {
        if (this.mRecorder == null) {
            return 0;
        }
        return this.mRecorder.getHeight();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public long getDuration() {
        if (this.mRecorder == null) {
            return 0L;
        }
        return this.mRecorder.getDuration();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public int getLoopCount() {
        if (this.mRecorder == null) {
            return 0;
        }
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public long[] getFrameDurations() {
        if (this.mRecorder == null) {
            return null;
        }
        return this.mRecorder.getDurations();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public int getFrameCount() {
        if (this.mRecorder == null) {
            return 0;
        }
        return this.mRecorder.getDurations().length;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public void dispose() {
        BLog.i(TAG, "dispose");
        if (this.mRecorder == null) {
            return;
        }
        this.mRecorder.release();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public boolean doesRenderSupportScaling() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public IIjkMp4Frame getFrame(int number) {
        IjkBitmap bmp;
        if (this.mRecorder == null || (bmp = this.mRecorder.getFrame(number)) == null) {
            return null;
        }
        IIjkMp4Frame frame = new IjkMp4Frame(bmp);
        return frame;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public IjkMp4FrameInfo getFrameInfo(int number) {
        if (this.mRecorder == null) {
            return null;
        }
        return new IjkMp4FrameInfo(number, getWidth(), getHeight());
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMp4Image
    public int getSizeInBytes() {
        if (this.mRecorder == null) {
            return 0;
        }
        return this.mSizeInBytes;
    }

    private IjkMp4Image(ByteBuffer byteBuffer, IjkLibLoader libLoader, boolean isCopy, int cacheSize, int prefetchSize) {
        BLog.i(TAG, "create using byteBuffer");
        this.mSizeInBytes = byteBuffer.limit() - byteBuffer.position();
        this.mRecorder = new IjkImageRecorder.IjkImageRecorderBuilder().setLibLoader(libLoader).setDataSource(byteBuffer, isCopy).setCacheSize(cacheSize).setPrefetchSize(prefetchSize).build();
    }

    private IjkMp4Image(long mNativePtr, int sizeInBytes, IjkLibLoader libLoader, boolean isCopy, int cacheSize, int prefetchSize) {
        BLog.i(TAG, "create using mNativePtr");
        this.mSizeInBytes = sizeInBytes;
        this.mRecorder = new IjkImageRecorder.IjkImageRecorderBuilder().setLibLoader(libLoader).setDataSource(mNativePtr, sizeInBytes, isCopy).setCacheSize(cacheSize).setPrefetchSize(prefetchSize).build();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkMp4ImageBuilder {
        private ByteBuffer mByteBuffer;
        private int mCacheSize;
        private boolean mEnableCopyDataSource;
        private IjkLibLoader mLibLoader;
        private long mNativePtr;
        private int mPrefetchSize;
        private int mSizeInBytes;

        public IjkMp4ImageBuilder decode(long nativePtr, int sizeInBytes) {
            this.mNativePtr = nativePtr;
            this.mByteBuffer = null;
            this.mSizeInBytes = sizeInBytes;
            return this;
        }

        public IjkMp4ImageBuilder decode(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            this.mNativePtr = 0L;
            return this;
        }

        public IjkMp4ImageBuilder setLibloader(IjkLibLoader libLoader) {
            this.mLibLoader = libLoader;
            return this;
        }

        public IjkMp4ImageBuilder enableCopyDataSource(boolean enable) {
            this.mEnableCopyDataSource = enable;
            return this;
        }

        public IjkMp4ImageBuilder setCacheSize(int cacheSize) {
            this.mCacheSize = cacheSize;
            return this;
        }

        public IjkMp4ImageBuilder setPrefetchSize(int prefetchSize) {
            this.mPrefetchSize = prefetchSize;
            return this;
        }

        public IIjkMp4Image build() {
            IjkMp4Image image;
            if (this.mByteBuffer != null) {
                image = new IjkMp4Image(this.mByteBuffer, this.mLibLoader, this.mEnableCopyDataSource, this.mCacheSize, this.mPrefetchSize);
            } else {
                image = new IjkMp4Image(this.mNativePtr, this.mSizeInBytes, this.mLibLoader, this.mEnableCopyDataSource, this.mCacheSize, this.mPrefetchSize);
            }
            try {
                if (image.getFrameDurations().length <= 0) {
                    image.dispose();
                    return null;
                }
                return image;
            } catch (Throwable th) {
                return null;
            }
        }
    }
}