package tv.danmaku.ijk.media.player.services;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.ffmpeg.FFmpegApi;
import tv.danmaku.ijk.media.player.services.IjkMediaPlayerService;

public class IjkMediaPlayerItemClient extends IIjkMediaPlayerItem.Stub {
    private static final String TAG = "IjkPlayerItemClient";
    private IIjkMediaPlayerItemClient mClient;
    private long mNativeMediaPlayerItemClient;
    private IjkMediaPlayerService.IjkMediaPlayerItemDeathHandler mClientDeathHandler = null;
    private ParcelFileDescriptor mAssetFd = null;

    private native long _getPlayableDuration();

    private native Bundle _getPropertiesBundle(int[] iArr);

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getPropertyString(int i);

    private native void _io_interrupt(int i);

    private native boolean _isEqualsToInternal(String str) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _native_finalize();

    private native void _native_setup(Object obj);

    private native void _release();

    private native void _reset();

    private native void _setDashAudioMixDataSource(String[] strArr) throws IllegalArgumentException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IllegalArgumentException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IllegalArgumentException, IllegalStateException;

    private native void _setDataSourceJson(String[] strArr, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private native void _setOption(int i, String str, long j) throws IllegalStateException;

    private native void _setOption(int i, String str, String str2) throws IllegalStateException;

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setPropertyString(int i, String str);

    private native void _start() throws IllegalStateException;

    private native void _stop();

    public IjkMediaPlayerItemClient(IIjkMediaPlayerItemClient client) {
        this.mClient = null;
        this.mClient = client;
        _native_setup(new WeakReference(this));
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void start() throws RemoteException {
        Log.d(TAG, "start");
        try {
            _start();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void ioInterrupt(int interrupt) throws RemoteException {
        Log.d(TAG, "ioInterrupt " + interrupt);
        _io_interrupt(interrupt);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void stop() throws RemoteException {
        Log.d(TAG, "stop");
        _stop();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void reset() throws RemoteException {
        Log.d(TAG, "reset");
        _reset();
        if (this.mAssetFd != null) {
            try {
                this.mAssetFd.close();
            } catch (IOException e) {
            }
            this.mAssetFd = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void release() throws RemoteException {
        Log.d(TAG, "release");
        _release();
        if (this.mAssetFd != null) {
            try {
                this.mAssetFd.close();
            } catch (IOException e) {
            }
            this.mAssetFd = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setDataSource(String path) throws RemoteException {
        Log.d(TAG, "setDataSource");
        if (path != null) {
            try {
                if (path.startsWith("ffconcat version 1.0") || path.startsWith("ijkofflinehook:ffconcat version 1.0")) {
                    StringBuilder sb = new StringBuilder();
                    if (path.startsWith("ijkofflinehook:")) {
                        sb.append("ijkofflinehook:");
                        path = path.replace("ijkofflinehook:", "");
                    }
                    sb.append("data:content/type;base64,");
                    sb.append(FFmpegApi.av_base64_encode(path.getBytes()));
                    path = sb.toString();
                }
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return;
            } catch (IllegalStateException ex2) {
                ex2.printStackTrace();
                return;
            }
        }
        _setDataSource(path, null, null);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setDataSourceJson(String[] dataSourceJson, int defaultAudioId, int defaultVideoId) {
        Log.d(TAG, "setDataSourceJson");
        try {
            _setDataSourceJson(dataSourceJson, defaultAudioId, defaultVideoId);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex2) {
            ex2.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setDataSourceFd(ParcelFileDescriptor fd) {
        try {
            _setDataSource("ijkofflinehook:ijkfilehook:pipe:" + fd.getFd(), null, null);
            this.mAssetFd = fd;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex2) {
            ex2.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setMultiAudioStream(String[] urls) {
        try {
            _setDashAudioMixDataSource(urls);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex2) {
            ex2.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public long getPlayableDuration() throws RemoteException {
        Log.d(TAG, "getPlayableDuration");
        return _getPlayableDuration();
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public float getPropertyFloat(int property, float defaultValue) throws RemoteException {
        return _getPropertyFloat(property, defaultValue);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setPropertyFloat(int property, float value) throws RemoteException {
        _setPropertyFloat(property, value);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public long getPropertyLong(int property, long defaultValue) throws RemoteException {
        return _getPropertyLong(property, defaultValue);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setPropertyLong(int property, long value) throws RemoteException {
        _setPropertyLong(property, value);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setOptionString(int category, String name, String value) throws RemoteException {
        _setOption(category, name, value);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setOptionLong(int category, String name, long value) throws RemoteException {
        _setOption(category, name, value);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public Bundle getPropertiesBundle(int[] keys) {
        return _getPropertiesBundle(keys);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public String getPropertyString(int propId) throws RemoteException {
        return _getPropertyString(propId);
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setOptionBundle(int category, Bundle bundle) throws RemoteException {
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (value instanceof String) {
                _setOption(category, key, (String) value);
            } else if (value instanceof Long) {
                _setOption(category, key, ((Long) value).longValue());
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public boolean isEqualsToInternal(String name) throws RemoteException {
        try {
            boolean ret = _isEqualsToInternal(name);
            return ret;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return false;
        } catch (IllegalStateException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void getPropBundle(int propId, Bundle args) throws RemoteException {
        switch (propId) {
            case IjkMediaPlayer.FFP_PROP_BUNDLE_P2P_STREAM_STATE /* 40000 */:
                String propStr = _getPropertyString(propId);
                if (propStr != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(propStr);
                        Iterator<String> it = jsonObject.keys();
                        while (it.hasNext()) {
                            String key = it.next();
                            Object value = jsonObject.get(key);
                            if (value instanceof String) {
                                args.putString(key, (String) value);
                            } else if (value instanceof Long) {
                                args.putLong(key, ((Long) value).longValue());
                            } else if (value instanceof Integer) {
                                args.putInt(key, ((Integer) value).intValue());
                            }
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
    public void setPropertyString(int property, String value) throws RemoteException {
        _setPropertyString(property, value);
    }

    public void linkDeathHandler(IjkMediaPlayerService.IjkMediaPlayerItemDeathHandler handler) {
        this.mClientDeathHandler = handler;
        if (this.mClientDeathHandler != null && this.mClient != null) {
            try {
                this.mClient.asBinder().linkToDeath(this.mClientDeathHandler, 0);
            } catch (RemoteException e) {
                Log.i(TAG, "IjkMediaPlayerClient linkToDeath fail");
            }
        }
    }

    public void unlinkDeathHandler() {
        if (this.mClientDeathHandler != null && this.mClient != null) {
            this.mClient.asBinder().unlinkToDeath(this.mClientDeathHandler, 0);
        }
        this.mClient = null;
    }

    public void clientDeathHandle() {
        _release();
    }

    private static boolean onNativeInvoke(Object weakThiz, int what, Bundle args) {
        BLog.i(TAG, "onNativeInvoke what = " + what);
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            BLog.e(TAG, "onNativeInvoke IllegalStateException 0");
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        WeakReference<IjkMediaPlayerItemClient> weakItem = (WeakReference) weakThiz;
        IjkMediaPlayerItemClient item = weakItem.get();
        if (item == null) {
            BLog.e(TAG, "onNativeInvoke IllegalStateException 1");
            throw new IllegalStateException("<null weakItem>.onNativeInvoke()");
        }
        int index = args.getInt("segment_index");
        int retryCounter = args.getInt("retry_counter");
        String url = args.getString("url");
        String ip = args.getString("ip");
        int error = args.getInt("error");
        int http_code = args.getInt("http_code");
        boolean ret = false;
        try {
            ret = item.mClient.onNativeInvoke(what, args);
        } catch (RemoteException exception) {
            BLog.w(TAG, exception);
        }
        if (what == 131079) {
            Object object = args.getParcelable("fd");
            if (object != null && (object instanceof ParcelFileDescriptor)) {
                ParcelFileDescriptor fd = (ParcelFileDescriptor) object;
                if (item.mAssetFd != null) {
                    try {
                        item.mAssetFd.close();
                    } catch (IOException e) {
                    }
                }
                item.mAssetFd = fd;
                args.putString("url", "ijkfilehook:pipe:" + fd.getFd());
                BLog.i(TAG, " use pipe url " + args.getString("url") + " object " + object);
            }
        }
        BLog.i(TAG, "onNativeInvoke what = " + what + ",index = " + index + ",retryCounter = " + retryCounter + ",url = " + url + " ip " + ip + " error " + error + " http_code " + http_code + " ret " + ret);
        return ret;
    }

    private static int addHdrVividMetadata(Object weakThiz, byte[] data, int size, long pts) {
        if (weakThiz == null || !(weakThiz instanceof WeakReference)) {
            BLog.e(TAG, "addHdrVividMetadata IllegalStateException 0");
            throw new IllegalStateException("<null weakThiz>.addHdrVividMetadata()");
        }
        WeakReference<IjkMediaPlayerItemClient> weakItem = (WeakReference) weakThiz;
        IjkMediaPlayerItemClient item = weakItem.get();
        if (item == null) {
            BLog.e(TAG, "addHdrVividMetadata IllegalStateException 1");
            throw new IllegalStateException("<null weakItem>.addHdrVividMetadata()");
        }
        try {
            int ret = item.mClient.addHdrVividMetadata(data, size, pts);
            return ret;
        } catch (RemoteException exception) {
            BLog.w(TAG, exception);
            return -1;
        }
    }
}