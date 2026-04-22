package tv.danmaku.ijk.media.player.utils;

import android.graphics.Bitmap;
import java.io.File;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkLibLoader;

public class IjkImageRecorder implements IIjkImageRecorder {
    private ByteBuffer mDataSoruce;
    private boolean mEnableCopyDataSource;
    private long mNativeDataSoruce;
    private int mNativeDataSoruceSize;
    private long mNativeIjkImageRecorder;
    private long mStartTime;

    private native long _getDuration();

    private native long[] _getDurations();

    private native IjkBitmap _getFrame(int i);

    private native int _getHeight();

    private native int _getWidth();

    private native void _native_finalize();

    private native void _native_setup(long j, int i, long j2, boolean z, int i2, int i3);

    private native void _native_setup(ByteBuffer byteBuffer, long j, boolean z, int i, int i2);

    private static native void _releaseBitmap(long j);

    private static native void _transformBitmap(Bitmap bitmap, int i, int i2, long j, int i3, int i4);

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public IjkBitmap getFrame(int number) {
        return _getFrame(number);
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public int getWidth() {
        return _getWidth();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public int getHeight() {
        return _getHeight();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public long getDuration() {
        return _getDuration();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public long[] getDurations() {
        return _getDurations();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkImageRecorderBuilder {
        private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.utils.IjkImageRecorder.IjkImageRecorderBuilder.1
            @Override // tv.danmaku.ijk.media.player.IjkLibLoader
            public void loadLibrary(String libName) throws UnsatisfiedLinkError, SecurityException {
                System.loadLibrary(libName);
            }

            @Override // tv.danmaku.ijk.media.player.IjkLibLoader
            public File findLibrary(String libName) {
                return null;
            }
        };
        private boolean mLibLoaded = false;
        private ByteBuffer mDataSoruce = null;
        private long mNativeDataSoruce = 0;
        private int mNativeDataSoruceSize = 0;
        private long mStartTime = 0;
        private IjkLibLoader mLibLoder = null;
        private boolean mEnableCopyDataSource = false;
        private int mCacheSize = 10;
        private int mPrefetchSize = 3;

        public IjkImageRecorderBuilder setLibLoader(IjkLibLoader loader) {
            this.mLibLoder = loader;
            return this;
        }

        public IjkImageRecorderBuilder setDataSource(ByteBuffer dataSource, boolean isCopy) {
            this.mDataSoruce = dataSource;
            this.mEnableCopyDataSource = isCopy;
            return this;
        }

        public IjkImageRecorderBuilder setDataSource(long dataSource, int size, boolean isCopy) {
            this.mNativeDataSoruce = dataSource;
            this.mNativeDataSoruceSize = size;
            this.mEnableCopyDataSource = isCopy;
            return this;
        }

        public IjkImageRecorderBuilder setStartTime(long startTime) {
            this.mStartTime = startTime;
            return this;
        }

        public IjkImageRecorderBuilder setCacheSize(int cacheSize) {
            this.mCacheSize = cacheSize;
            return this;
        }

        public IjkImageRecorderBuilder setPrefetchSize(int prefetchSize) {
            this.mPrefetchSize = prefetchSize;
            return this;
        }

        public IjkImageRecorder build() {
            if (!this.mLibLoaded) {
                try {
                    synchronized (IjkImageRecorder.class) {
                        String[] libNames = {"ijk", "ijkffmpeg", "ijksdl", "ijkplayer"};
                        for (int i = 0; i < libNames.length; i++) {
                            if (this.mLibLoder != null) {
                                File file = this.mLibLoder.findLibrary(libNames[i]);
                                if (file != null && file.exists()) {
                                    System.load(file.getAbsolutePath());
                                }
                            } else {
                                sLocalLibLoader.loadLibrary(libNames[i]);
                            }
                        }
                        this.mLibLoaded = true;
                    }
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
            if (this.mDataSoruce != null) {
                return new IjkImageRecorder(this.mDataSoruce, this.mStartTime, this.mEnableCopyDataSource, this.mCacheSize, this.mPrefetchSize);
            }
            return new IjkImageRecorder(this.mNativeDataSoruce, this.mNativeDataSoruceSize, this.mStartTime, this.mEnableCopyDataSource, this.mCacheSize, this.mPrefetchSize);
        }
    }

    private IjkImageRecorder(ByteBuffer data, long startTime, boolean isCopy, int cacheSize, int prefetchSize) {
        if (!data.isDirect()) {
            int sizeInBytes = data.limit() - data.position();
            ByteBuffer newBuffer = ByteBuffer.allocateDirect(sizeInBytes);
            newBuffer.put(data);
            this.mDataSoruce = newBuffer;
        } else {
            this.mDataSoruce = data;
        }
        this.mStartTime = startTime;
        this.mEnableCopyDataSource = isCopy;
        _native_setup(this.mDataSoruce, this.mStartTime, this.mEnableCopyDataSource, cacheSize, prefetchSize);
    }

    private IjkImageRecorder(long data, int size, long startTime, boolean isCopy, int cacheSize, int prefetchSize) {
        this.mNativeDataSoruce = data;
        this.mNativeDataSoruceSize = size;
        this.mStartTime = startTime;
        this.mEnableCopyDataSource = isCopy;
        _native_setup(this.mNativeDataSoruce, this.mNativeDataSoruceSize, this.mStartTime, this.mEnableCopyDataSource, cacheSize, prefetchSize);
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkImageRecorder
    public void release() {
        _native_finalize();
    }

    public static void transformBitmap(Bitmap bitmap, int dst_width, int dst_height, long src_bitmap, int src_width, int src_height) {
        _transformBitmap(bitmap, dst_width, dst_height, src_bitmap, src_width, src_height);
    }

    public static void releaseBitmap(long bitmap) {
        _releaseBitmap(bitmap);
    }

    private IjkBitmap createBitmap(long data, int width, int height, long duration) {
        IjkBitmap output = new IjkBitmap();
        output.bitmap = data;
        output.width = width;
        output.height = height;
        output.duration = duration;
        return output;
    }
}