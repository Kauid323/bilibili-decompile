package tv.danmaku.ijk.media.player.services;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IIjkMediaPlayer;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IjkPerformanceManager;
import tv.danmaku.ijk.media.player.ffmpeg.FFmpegApi;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.render.IjkNativeWindowHelper;
import tv.danmaku.ijk.media.player.services.IjkMediaPlayerService;

public class IjkMediaPlayerClient extends IIjkMediaPlayer.Stub {
    private static final int IJK_ANALYSIS_PROPOSE_INTERNAL_PLAYER_PROCESS_ERROR = 301;
    private static final int IJK_ANALYSIS_PROPOSE_USER_PROCESS_ERROR = 104;
    private static final int MAX_PROTECT_DELAY = 30000;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_GET_IMG_STATE = 6;
    private static final int MSG_NATIVE_PROTECT_ADDFRAMEOUTPUTTASK = 37;
    private static final int MSG_NATIVE_PROTECT_CREATE = 1;
    private static final int MSG_NATIVE_PROTECT_GETADUIOCODECINFO = 27;
    private static final int MSG_NATIVE_PROTECT_GETAUDIOSESSIONID = 25;
    private static final int MSG_NATIVE_PROTECT_GETCOLORFORMATNAME = 32;
    private static final int MSG_NATIVE_PROTECT_GETCURRENTPOSITION = 16;
    private static final int MSG_NATIVE_PROTECT_GETDASHSTREAMINFO = 38;
    private static final int MSG_NATIVE_PROTECT_GETDURATION = 17;
    private static final int MSG_NATIVE_PROTECT_GETLOOPCOUNT = 19;
    private static final int MSG_NATIVE_PROTECT_GETMEDIAMETA = 30;
    private static final int MSG_NATIVE_PROTECT_GETPROPERTIES = 48;
    private static final int MSG_NATIVE_PROTECT_GETPROPERTYFLOAT = 20;
    private static final int MSG_NATIVE_PROTECT_GETPROPERTYLOOG = 22;
    private static final int MSG_NATIVE_PROTECT_GETPROPERTYSTRING = 52;
    private static final int MSG_NATIVE_PROTECT_GETVIDEOCODECINFO = 26;
    private static final int MSG_NATIVE_PROTECT_GET_SURFACE_HEIGHT = 47;
    private static final int MSG_NATIVE_PROTECT_GET_SURFACE_WIDTH = 46;
    private static final int MSG_NATIVE_PROTECT_GET_VERSION = 50;
    private static final int MSG_NATIVE_PROTECT_ISPLAYING = 14;
    private static final int MSG_NATIVE_PROTECT_NATIVEFINALIZE = 31;
    private static final int MSG_NATIVE_PROTECT_NATIVEPROFILEBEGIN = 33;
    private static final int MSG_NATIVE_PROTECT_NATIVEPROFILEEND = 34;
    private static final int MSG_NATIVE_PROTECT_NATIVESETLOGLEVEL = 35;
    private static final int MSG_NATIVE_PROTECT_PAUSE = 3;
    private static final int MSG_NATIVE_PROTECT_PREPAREASYNC = 12;
    private static final int MSG_NATIVE_PROTECT_RELEASE = 5;
    private static final int MSG_NATIVE_PROTECT_RESET = 6;
    private static final int MSG_NATIVE_PROTECT_SAMPLE_PERFORMANCE = 44;
    private static final int MSG_NATIVE_PROTECT_SEEKTO = 15;
    private static final int MSG_NATIVE_PROTECT_SETANDROIDIOCALLBACK = 36;
    private static final int MSG_NATIVE_PROTECT_SETDASHAUTO = 41;
    private static final int MSG_NATIVE_PROTECT_SETDATASOURCE = 8;
    private static final int MSG_NATIVE_PROTECT_SETDATASOURCEBASE64 = 9;
    private static final int MSG_NATIVE_PROTECT_SETDATASOURCEFD = 11;
    private static final int MSG_NATIVE_PROTECT_SETDATASOURCEKEY = 10;
    private static final int MSG_NATIVE_PROTECT_SETEXTERNALSURFACE = 45;
    private static final int MSG_NATIVE_PROTECT_SETIJKPLAYERITEM = 43;
    private static final int MSG_NATIVE_PROTECT_SETLOOPCOUNT = 18;
    private static final int MSG_NATIVE_PROTECT_SETOPTIONLONG = 29;
    private static final int MSG_NATIVE_PROTECT_SETOPTIONSTRING = 28;
    private static final int MSG_NATIVE_PROTECT_SETPROPERTYFLOAT = 21;
    private static final int MSG_NATIVE_PROTECT_SETPROPERTYLOOG = 23;
    private static final int MSG_NATIVE_PROTECT_SETSTREAMSELECTED = 13;
    private static final int MSG_NATIVE_PROTECT_SETSURFACE = 7;
    private static final int MSG_NATIVE_PROTECT_SETVOLUME = 24;
    private static final int MSG_NATIVE_PROTECT_START = 2;
    private static final int MSG_NATIVE_PROTECT_STOP = 4;
    private static final int MSG_NATIVE_PROTECT_SWITCHDASHAUDIOSTREAM = 40;
    private static final int MSG_NATIVE_PROTECT_SWITCHDASHVIDEOSTREAM = 39;
    private static final String TAG = "IjkMediaPlayerClient";
    private IIjkMediaPlayerClient mClient;
    private HandlerThread mHandlerThread;
    private Context mIjkServiceContext;
    private int mListenerContext;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayerClient;
    private int mNativeSurfaceTexture;
    private IjkPerformanceManager.SampleValue mPerformanceSampleValue;
    private Handler mProtectHandle;
    public boolean mBlocked = false;
    private IjkMediaPlayerService.IjkMediaPlayerDeathHandler mClientDeathHandler = null;
    private int mRelease = 0;
    private Lock mLock = new ReentrantLock();
    private Surface mSurface = null;
    private Surface mInternalSurface = null;
    private Surface mAvcSurface = null;
    private int mProtectDelay = 5000;

    private native int _addFrameOutputTask(String str, long j, int i, int i2, int i3, int i4) throws IllegalArgumentException, IllegalStateException;

    private native void _flushCache() throws IllegalStateException;

    private native String _getAudioCodecInfo() throws IllegalStateException;

    private native int[] _getAudioStreamsIndex();

    public static native String _getColorFormatName(int i);

    private native int _getCurrentAudioIndex();

    private native Bundle _getDashStreamInfo() throws IllegalStateException;

    private native int _getDefaultAudioIndex();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta() throws IllegalStateException;

    private native Bundle _getPropertiesBundle(int[] iArr);

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo() throws IllegalStateException;

    private native void _native_finalize();

    private static native void _native_init();

    private native void _native_message_loop(Object obj);

    public static native void _native_profileBegin(String str);

    public static native void _native_profileEnd();

    public static native void _native_setLogLevel(int i);

    private native void _native_setup(Object obj);

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDashAuto(boolean z) throws IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setExternalRenderSurface(Surface surface, Surface surface2);

    private native void _setIjkPlayerItem(IjkMediaPlayerItemClient ijkMediaPlayerItemClient) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j) throws IllegalStateException;

    private native void _setOption(int i, String str, String str2) throws IllegalStateException;

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native int _switchAudioStream(int i);

    private native void _switchDashAudioStream(int i) throws IllegalStateException;

    private native void _switchDashVideoStream(int i) throws IllegalStateException;

    public native int _getAudioSessionId();

    public native long _getCurrentPosition();

    public native long _getDuration();

    public native String _getPropertyString(int i);

    public native String _getVersion();

    public native boolean _isPlaying();

    public native void _prepareAsync() throws IllegalStateException;

    public native void _seekTo(long j, int i) throws IllegalStateException;

    public native void _setVolume(float f, float f2);

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class ProtectHandle extends Handler {
        private final WeakReference<IjkMediaPlayerClient> mWeakClient;

        public ProtectHandle(IjkMediaPlayerClient mp, Looper looper) {
            super(looper);
            this.mWeakClient = new WeakReference<>(mp);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int what = msg.what;
            IjkMediaPlayerClient client = this.mWeakClient.get();
            if (client == null) {
                return;
            }
            switch (what) {
                case 5:
                    client.mBlocked = true;
                    if (client.mClient != null) {
                        try {
                            client.mClient.onReportAnr(what);
                            return;
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    BLog.e(IjkMediaPlayerClient.TAG, "[PlayProblem] ANR happened, IjkMediaPlayerService will reboot, anr_error=" + what + ", user_propose=104, internal_propose=301");
                    if (client.mClient != null) {
                        try {
                            client.mClient.onReportAnr(what);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                    IjkMediaPlayerClient.systemExit();
                    return;
            }
        }
    }

    public IjkMediaPlayerClient(IIjkMediaPlayerClient client, Context ijkServiceContext) {
        this.mHandlerThread = null;
        this.mProtectHandle = null;
        this.mClient = null;
        this.mIjkServiceContext = null;
        this.mIjkServiceContext = ijkServiceContext;
        this.mClient = client;
        this.mHandlerThread = new HandlerThread("ijk_java_block");
        this.mHandlerThread.start();
        this.mProtectHandle = new ProtectHandle(this, this.mHandlerThread.getLooper());
        _native_setup(new WeakReference(this));
    }

    public void linkDeathHandler(IjkMediaPlayerService.IjkMediaPlayerDeathHandler handler) {
        this.mClientDeathHandler = handler;
        if (this.mClientDeathHandler != null && this.mClient != null) {
            try {
                this.mClient.asBinder().linkToDeath(this.mClientDeathHandler, 0);
            } catch (RemoteException e) {
                BLog.i(TAG, "IjkMediaPlayerClient linkToDeath fail");
            }
        }
    }

    public void unlinkDeathHandler() {
        if (this.mClientDeathHandler != null && this.mClient != null) {
            this.mClient.asBinder().unlinkToDeath(this.mClientDeathHandler, 0);
        }
    }

    private static boolean onNativeInvoke(Object weakThiz, int what, Bundle args) {
        BLog.i(TAG, "onNativeInvoke what = " + what);
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            BLog.e(TAG, "onNativeInvoke IllegalStateException 0");
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient player = weakPlayer.get();
        if (player == null) {
            BLog.e(TAG, "onNativeInvoke IllegalStateException 1");
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        int index = args.getInt("segment_index");
        int retryCounter = args.getInt("retry_counter");
        String url = args.getString("url");
        boolean ret = player.onNativeInvokeForClient(what, args);
        BLog.i(TAG, "onNativeInvoke what = " + what + ",index = " + index + ",retryCounter = " + retryCounter + ",url = " + url + ", ret = " + ret);
        return ret;
    }

    private boolean onNativeInvokeForClient(int what, Bundle args) {
        BLog.i(TAG, "onNativeInvokeForClient enter");
        if (this.mClient != null) {
            try {
                return this.mClient.onNativeInvoke(what, args);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class SystemApplication {
        public SystemApplication() {
        }

        public void notifyNativeInvoke(int what, Bundle args) {
            if (IjkMediaPlayerClient.this.mClient != null) {
                try {
                    IjkMediaPlayerClient.this.mClient.onNativeInvoke(what, args);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String onSelectCodec(Object weakThiz, String mimeType, int profile, int level) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return null;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return null;
        }
        return ijkClient.onSelectCodecForClient(mimeType, profile, level);
    }

    private String onSelectCodecForClient(String mimeType, int profile, int level) {
        if (this.mClient != null) {
            try {
                return this.mClient.onMediaCodecSelect(mimeType, profile, level);
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static int onRawDataWrite(Object weakThiz, byte[] data, int offset, int size, int freq, int channels, int samples) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onRawDataWrite(data, offset, size, freq, channels, samples);
    }

    private int onRawDataWrite(byte[] data, int offset, int size, int freq, int channels, int samples) {
        if (this.mClient != null) {
            try {
                return this.mClient.onRawDataWrite(data, offset, size, freq, channels, samples);
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    private static int onSeiDataWrite(Object weakThiz, byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onSeiDataWrite(data, size, decodeTimestamp, presentationTimestamp);
    }

    private int onSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
        if (this.mClient != null) {
            try {
                return this.mClient.onSeiDataWrite(data, size, decodeTimestamp, presentationTimestamp);
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    private static int onDownloadSeiDataWrite(Object weakThiz, byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onDownloadSeiDataWrite(data, size, decodeTimestamp, presentationTimestamp);
    }

    private int onDownloadSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) {
        if (this.mClient != null) {
            try {
                return this.mClient.onDownloadSeiDataWrite(data, size, decodeTimestamp, presentationTimestamp);
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    private static int onMetaDataWrite(Object weakThiz, byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onMetaDataWrite(data, size, colorSpace, colorRange, colorTransfer);
    }

    private int onMetaDataWrite(byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) {
        if (this.mClient != null) {
            try {
                return this.mClient.onMetaDataWrite(data, size, colorSpace, colorRange, colorTransfer);
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private static int onVideoDisplay(Object weakThiz, double pts, double duration) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onVideoDisplayCallback(pts, duration);
    }

    private int onVideoDisplayCallback(double pts, double duration) {
        if (this.mClient != null) {
            try {
                return this.mClient.onVideoDisplay(pts, duration);
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private static int onFirstVideoRender(Object weakThiz) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onFirstVideoDisplayCallback();
    }

    private int onFirstVideoDisplayCallback() {
        if (this.mClient != null) {
            try {
                return this.mClient.onFirstVideoRender();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private static int onDrmEvent(Object weakThiz, int event, Bundle args) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            return -1;
        }
        WeakReference<IjkMediaPlayerClient> weakPlayer = (WeakReference) weakThiz;
        IjkMediaPlayerClient ijkClient = weakPlayer.get();
        if (ijkClient == null) {
            return -1;
        }
        return ijkClient.onDrmEventInternal(event, args);
    }

    private int onDrmEventInternal(int event, Bundle args) {
        if (this.mClient != null) {
            try {
                return this.mClient.onDrmEvent(event, args);
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private static void postEventFromNative(Object weakThiz, int what, int arg1, int arg2, long timestamp, Bundle bundle) {
        IjkMediaPlayerClient ijkClient;
        if (weakThiz != null && (ijkClient = (IjkMediaPlayerClient) ((WeakReference) weakThiz).get()) != null) {
            ijkClient.eventHandlerForClient(what, arg1, arg2, timestamp, bundle);
        }
    }

    private static int onVideoPacketCallback(Object weakThiz, byte[] rpuData, int size, long timeUs, int flag) {
        IjkMediaPlayerClient ijkClient;
        if (weakThiz == null || (ijkClient = (IjkMediaPlayerClient) ((WeakReference) weakThiz).get()) == null) {
            return -1;
        }
        return ijkClient.onVideoPacketCallback(rpuData, size, timeUs, flag);
    }

    private int onVideoPacketCallback(byte[] rpuData, int size, long timeUs, int flag) {
        if (this.mClient != null) {
            try {
                return this.mClient.onVideoPacketCallback(rpuData, size, timeUs, flag);
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    private static void onSetDolbyModel(Object weakThiz, int model) {
        IjkMediaPlayerClient ijkClient;
        if (weakThiz != null && (ijkClient = (IjkMediaPlayerClient) ((WeakReference) weakThiz).get()) != null) {
            ijkClient.onSetDolbyModel(model);
        }
    }

    private void onSetDolbyModel(int model) {
        if (this.mClient != null) {
            try {
                this.mClient.onSetDolbyModel(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void eventHandlerForClient(int what, int arg1, int arg2, long timestamp, Bundle bundle) {
        if (this.mClient != null) {
            try {
                this.mClient.onEventHandler(what, arg1, arg2, timestamp, bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void start() {
        this.mProtectHandle.sendEmptyMessageDelayed(2, this.mProtectDelay);
        try {
            _start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(2);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void pause() {
        this.mProtectHandle.sendEmptyMessageDelayed(3, this.mProtectDelay);
        try {
            _pause();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(3);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void stop() {
        this.mProtectHandle.sendEmptyMessageDelayed(4, this.mProtectDelay);
        try {
            _stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(4);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public String getVersion() {
        String ver = "";
        this.mProtectHandle.sendEmptyMessageDelayed(MSG_NATIVE_PROTECT_GET_VERSION, this.mProtectDelay);
        try {
            ver = _getVersion();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(MSG_NATIVE_PROTECT_GET_VERSION);
        return ver;
    }

    public void clientDeathHandle() {
        if (this.mLock.tryLock()) {
            if (this.mRelease > 0) {
                this.mLock.unlock();
                return;
            }
            this.mRelease = 1;
            this.mProtectHandle.sendEmptyMessageDelayed(5, this.mProtectDelay);
            try {
                _pause();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            _release();
            this.mBlocked = false;
            this.mProtectHandle.removeMessages(5);
            this.mLock.unlock();
        }
        this.mHandlerThread.quit();
        try {
            this.mHandlerThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void quitHandleThread() {
        this.mHandlerThread.quit();
        try {
            this.mHandlerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void release() {
        if (this.mLock.tryLock()) {
            if (this.mRelease > 0) {
                this.mLock.unlock();
                return;
            }
            this.mRelease = 1;
            this.mProtectHandle.sendEmptyMessageDelayed(5, this.mProtectDelay);
            _release();
            this.mBlocked = false;
            this.mProtectHandle.removeMessages(5);
            if (this.mSurface != null) {
                this.mSurface.release();
                this.mSurface = null;
            }
            if (this.mAvcSurface != null) {
                this.mAvcSurface.release();
                this.mAvcSurface = null;
            }
            if (this.mInternalSurface != null) {
                this.mInternalSurface.release();
                this.mInternalSurface = null;
            }
            this.mLock.unlock();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void reset() {
        this.mProtectHandle.sendEmptyMessageDelayed(6, this.mProtectDelay);
        _reset();
        this.mProtectHandle.removeMessages(6);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setSurface(Surface surface) {
        this.mProtectHandle.sendEmptyMessageDelayed(7, this.mProtectDelay);
        _setVideoSurface(surface);
        if (this.mSurface != surface) {
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            this.mSurface = surface;
        }
        this.mProtectHandle.removeMessages(7);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setExternalRenderInternalSurface(Surface internal) throws RemoteException {
        if (this.mInternalSurface != internal && this.mInternalSurface != null) {
            this.mInternalSurface.release();
            this.mInternalSurface = null;
        }
        this.mInternalSurface = internal;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setExternalRenderSurface(Surface amcSurface, Surface avcSurface) {
        this.mProtectHandle.sendEmptyMessageDelayed(45, this.mProtectDelay);
        _setExternalRenderSurface(amcSurface, avcSurface);
        if (this.mSurface != amcSurface) {
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            this.mSurface = amcSurface;
        }
        if (this.mAvcSurface != avcSurface) {
            if (this.mAvcSurface != null) {
                this.mAvcSurface.release();
            }
            this.mAvcSurface = avcSurface;
        }
        this.mProtectHandle.removeMessages(45);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getAndroidIOTrafficStatistic() {
        return 0L;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setAndroidIOCallback() {
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setDataSource(String path) {
        this.mProtectHandle.sendEmptyMessageDelayed(8, this.mProtectDelay);
        try {
            _setDataSource(path, null, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
        } catch (IllegalStateException ex3) {
            ex3.printStackTrace();
        } catch (SecurityException ex4) {
            ex4.printStackTrace();
        }
        this.mProtectHandle.removeMessages(8);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setDataSourceBase64(String path) {
        this.mProtectHandle.sendEmptyMessageDelayed(9, this.mProtectDelay);
        try {
            _setDataSource("data:content/type;base64," + FFmpegApi.av_base64_encode(path.getBytes()), null, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
        } catch (IllegalStateException ex3) {
            ex3.printStackTrace();
        } catch (SecurityException ex4) {
            ex4.printStackTrace();
        }
        this.mProtectHandle.removeMessages(9);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setDataSourceKey(String path, String[] keys, String[] values) {
        this.mProtectHandle.sendEmptyMessageDelayed(10, this.mProtectDelay);
        try {
            _setDataSource(path, keys, values);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
        } catch (IllegalStateException ex3) {
            ex3.printStackTrace();
        } catch (SecurityException ex4) {
            ex4.printStackTrace();
        }
        this.mProtectHandle.removeMessages(10);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setDataSourceFd(ParcelFileDescriptor fd) {
        this.mProtectHandle.sendEmptyMessageDelayed(11, this.mProtectDelay);
        try {
            _setDataSourceFd(fd.getFd());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
        } catch (IllegalStateException ex3) {
            ex3.printStackTrace();
        } catch (SecurityException ex4) {
            ex4.printStackTrace();
        }
        this.mProtectHandle.removeMessages(11);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setIjkMediaPlayerItem(IIjkMediaPlayerItem item) throws RemoteException {
        this.mProtectHandle.sendEmptyMessageDelayed(43, this.mProtectDelay);
        try {
            _setIjkPlayerItem((IjkMediaPlayerItemClient) item);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex2) {
            ex2.printStackTrace();
        } catch (SecurityException ex3) {
            ex3.printStackTrace();
        }
        this.mProtectHandle.removeMessages(43);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mProtectHandle.sendEmptyMessageDelayed(12, this.mProtectDelay);
        try {
            _prepareAsync();
        } finally {
            this.mProtectHandle.removeMessages(12);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setStreamSelected(int stream, boolean select) {
        this.mProtectHandle.sendEmptyMessageDelayed(13, this.mProtectDelay);
        _setStreamSelected(stream, select);
        this.mProtectHandle.removeMessages(13);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public boolean isPlaying() {
        this.mProtectHandle.sendEmptyMessageDelayed(14, this.mProtectDelay);
        boolean ret = _isPlaying();
        this.mProtectHandle.removeMessages(14);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void seekTo(long msec, int flag) {
        this.mProtectHandle.sendEmptyMessageDelayed(15, this.mProtectDelay);
        try {
            _seekTo(msec, flag);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(15);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getCurrentPosition() {
        this.mProtectHandle.sendEmptyMessageDelayed(16, this.mProtectDelay);
        long ret = _getCurrentPosition();
        this.mProtectHandle.removeMessages(16);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getDuration() {
        this.mProtectHandle.sendEmptyMessageDelayed(17, this.mProtectDelay);
        long ret = _getDuration();
        this.mProtectHandle.removeMessages(17);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setLoopCount(int loopCount) {
        this.mProtectHandle.sendEmptyMessageDelayed(18, this.mProtectDelay);
        _setLoopCount(loopCount);
        this.mProtectHandle.removeMessages(18);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int getLoopCount() {
        this.mProtectHandle.sendEmptyMessageDelayed(19, this.mProtectDelay);
        int ret = _getLoopCount();
        this.mProtectHandle.removeMessages(19);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public float getPropertyFloat(int property, float defaultValue) {
        this.mProtectHandle.sendEmptyMessageDelayed(20, this.mProtectDelay);
        float ret = _getPropertyFloat(property, defaultValue);
        this.mProtectHandle.removeMessages(20);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setPropertyFloat(int property, float value) {
        this.mProtectHandle.sendEmptyMessageDelayed(21, this.mProtectDelay);
        _setPropertyFloat(property, value);
        this.mProtectHandle.removeMessages(21);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getPropertyLong(int property, long defaultValue) {
        this.mProtectHandle.sendEmptyMessageDelayed(22, this.mProtectDelay);
        long ret = _getPropertyLong(property, defaultValue);
        this.mProtectHandle.removeMessages(22);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setPropertyLong(int property, long value) {
        this.mProtectHandle.sendEmptyMessageDelayed(23, this.mProtectDelay);
        _setPropertyLong(property, value);
        this.mProtectHandle.removeMessages(23);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public Bundle getPropertiesBundle(int[] keys) {
        this.mProtectHandle.sendEmptyMessageDelayed(48, this.mProtectDelay);
        Bundle ret = _getPropertiesBundle(keys);
        this.mProtectHandle.removeMessages(48);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public String getPropertyString(int key) {
        this.mProtectHandle.sendEmptyMessageDelayed(52, this.mProtectDelay);
        String ret = _getPropertyString(key);
        this.mProtectHandle.removeMessages(52);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int getDefaultAudioIndex() throws RemoteException {
        return _getDefaultAudioIndex();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int getCurrentAudioIndex() throws RemoteException {
        return _getCurrentAudioIndex();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int switchAudioStream(int index) throws RemoteException {
        return _switchAudioStream(index);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int[] getAudioStreamsIndex() throws RemoteException {
        return _getAudioStreamsIndex();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setVolume(float leftVolume, float rightVolume) {
        this.mProtectHandle.sendEmptyMessageDelayed(24, this.mProtectDelay);
        _setVolume(leftVolume, rightVolume);
        this.mProtectHandle.removeMessages(24);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int getAudioSessionId() {
        this.mProtectHandle.sendEmptyMessageDelayed(25, this.mProtectDelay);
        int ret = _getAudioSessionId();
        this.mProtectHandle.removeMessages(25);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public String getVideoCodecInfo() {
        this.mProtectHandle.sendEmptyMessageDelayed(26, this.mProtectDelay);
        String ret = null;
        try {
            ret = _getVideoCodecInfo();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(26);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public String getAudioCodecInfo() {
        this.mProtectHandle.sendEmptyMessageDelayed(27, this.mProtectDelay);
        String ret = null;
        try {
            ret = _getAudioCodecInfo();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(27);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setOptionString(int category, String name, String value) {
        if (!TextUtils.isEmpty(name)) {
            this.mProtectHandle.sendEmptyMessageDelayed(28, this.mProtectDelay);
            try {
                _setOption(category, name, value);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            this.mProtectHandle.removeMessages(28);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setOptionLong(int category, String name, long value) {
        if (!TextUtils.isEmpty(name)) {
            this.mProtectHandle.sendEmptyMessageDelayed(29, this.mProtectDelay);
            try {
                _setOption(category, name, value);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            this.mProtectHandle.removeMessages(29);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public Bundle getMediaMeta() {
        this.mProtectHandle.sendEmptyMessageDelayed(30, this.mProtectDelay);
        Bundle ret = null;
        try {
            ret = _getMediaMeta();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(30);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public Bundle getDashStreamInfo() {
        this.mProtectHandle.sendEmptyMessageDelayed(38, this.mProtectDelay);
        Bundle ret = null;
        try {
            ret = _getDashStreamInfo();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(38);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void switchDashVideoStream(int id) {
        this.mProtectHandle.sendEmptyMessageDelayed(39, this.mProtectDelay);
        try {
            _switchDashVideoStream(id);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(39);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void switchDashAudioStream(int id) {
        this.mProtectHandle.sendEmptyMessageDelayed(40, this.mProtectDelay);
        try {
            _switchDashAudioStream(id);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(40);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setAuto(boolean flag) {
        this.mProtectHandle.sendEmptyMessageDelayed(41, this.mProtectDelay);
        try {
            _setDashAuto(flag);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.mProtectHandle.removeMessages(41);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void nativeFinalize() {
        this.mProtectHandle.sendEmptyMessageDelayed(31, this.mProtectDelay);
        _native_finalize();
        this.mProtectHandle.removeMessages(31);
        systemExit();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public String getColorFormatName(int mediaCodecColorFormat) {
        this.mProtectHandle.sendEmptyMessageDelayed(32, this.mProtectDelay);
        String ret = _getColorFormatName(mediaCodecColorFormat);
        this.mProtectHandle.removeMessages(32);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void nativeProfileBegin(String libName) {
        this.mProtectHandle.sendEmptyMessageDelayed(33, this.mProtectDelay);
        _native_profileBegin(libName);
        this.mProtectHandle.removeMessages(33);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void nativeProfileEnd() {
        this.mProtectHandle.sendEmptyMessageDelayed(34, this.mProtectDelay);
        _native_profileEnd();
        this.mProtectHandle.removeMessages(34);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void nativeSetLogLevel(int level) {
        this.mProtectHandle.sendEmptyMessageDelayed(35, this.mProtectDelay);
        _native_setLogLevel(level);
        this.mProtectHandle.removeMessages(35);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public int addFrameOutputTask(String imgCachePath, long startTime, int frame_interval, int count, int imgDefinition, int frameType) {
        int ret = -1;
        this.mProtectHandle.sendEmptyMessageDelayed(37, this.mProtectDelay);
        try {
            ret = _addFrameOutputTask(imgCachePath, startTime, frame_interval, count, imgDefinition, frameType);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        this.mProtectHandle.removeMessages(37);
        return ret;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void SamplePerformance() {
        if (this.mIjkServiceContext == null) {
            return;
        }
        this.mProtectHandle.sendEmptyMessageDelayed(44, this.mProtectDelay);
        IjkPerformanceManager performanceManager = IjkPerformanceManager.getInstance(this.mIjkServiceContext);
        this.mPerformanceSampleValue = performanceManager.sampleState(Process.myPid());
        this.mProtectHandle.removeMessages(44);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public double getSampleCpu() {
        if (this.mPerformanceSampleValue != null) {
            return this.mPerformanceSampleValue.cpu;
        }
        return 0.0d;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getSampleThread() {
        if (this.mPerformanceSampleValue != null) {
            return this.mPerformanceSampleValue.thread;
        }
        return 0L;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public long getSampleMemory() {
        if (this.mPerformanceSampleValue != null) {
            return this.mPerformanceSampleValue.memory;
        }
        return 0L;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public Bundle getSampleThreadRecord() {
        if (this.mPerformanceSampleValue != null) {
            return this.mPerformanceSampleValue.threadRecord;
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public Bundle getSurfaceSize() {
        int width = 0;
        int height = 0;
        Bundle bundle = new Bundle();
        if (this.mInternalSurface != null) {
            width = IjkNativeWindowHelper.getSurfaceWidth(this.mInternalSurface);
            height = IjkNativeWindowHelper.getSurfaceHeight(this.mInternalSurface);
        }
        bundle.putInt(IjkNativeWindowHelper.IJK_WINDOW_WIDTH, width);
        bundle.putInt(IjkNativeWindowHelper.IJK_WINDOW_HEIGHT, height);
        return bundle;
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
    public void setProtectDelay(int protectDelay) {
        if (protectDelay > 0 && protectDelay <= MAX_PROTECT_DELAY) {
            BLog.i(TAG, "ijkMediaPlayerClient protect delay changed from " + this.mProtectDelay + " to " + protectDelay);
            this.mProtectDelay = protectDelay;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void systemExit() {
        System.exit(0);
    }
}