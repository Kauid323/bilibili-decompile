package tv.danmaku.ijk.media.player;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerService;
import tv.danmaku.ijk.media.player.pragma.DebugLog;
import tv.danmaku.ijk.media.player.services.IjkMediaPlayerService;

public final class IjkMediaMetadataRetriever {
    public static final int CUR_FRAME_IMAGE = 1;
    private static final int DO_ADDFRAMEOUTPUTTASK = 14;
    private static final int DO_CREATE = 0;
    private static final int DO_PREPAREASYNC = 1;
    private static final int DO_RELEASE = 3;
    private static final int DO_SEEKTO = 7;
    private static final int DO_SETDATASOURCE = 4;
    private static final int DO_SETDATASOURCEBASE64 = 5;
    private static final int DO_SETDATASOURCEFD = 6;
    private static final int DO_SETIJKMEDIAPLAYERITEM = 32;
    private static final int DO_SETOPTIONLONG = 9;
    private static final int DO_SETOPTIONSTRING = 8;
    private static final int DO_START = 2;
    public static final int FFP_PROP_INT64_DELETE_FRAMEOUTPUT_TASK = 30001;
    public static final int FRAME_OUTPUT_ERROR = -1;
    public static final int HD_IMAGE = 2;
    public static final int IJK_ONERROR = -10000;
    public static final int IJK_SERVICE_DISCONNECTED = -10001;
    public static final int LD_IMAGE = 0;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_GET_IMG_STATE = 6;
    private static final int MEDIA_PREPARED = 1;
    private static final int NOTIFY_ONNATIVEINVOKE = 12;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int ORIGIN_IMAGE = 3;
    public static final int PLAYER_ACTION_IS_INIT = 10001;
    public static final int PLAYER_ACTION_IS_RELEASE = 10002;
    public static final int SD_IMAGE = 1;
    private static final int SERVICE_CONNECTED = 10;
    private static final int SERVICE_DISCONNECTED = 11;
    private static final String TAG = IjkMediaMetadataRetriever.class.getName();
    public static final int TARGET_FRAME_IMAGE = 0;
    private IjkMediaPlayerBinder mClient;
    private Context mContext;
    private String mDataSource;
    private HandlerThread mHandleThread;
    private IjkMediaPlayerServiceConnection mIjkMediaPlayerServiceConnection;
    private OnControlMessageListener mOnControlMessageListener;
    private OnErrorListener mOnErrorListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private OnPreparedListener mOnPreparedListener;
    private OnServiceIsConnectedListener mOnServiceIsConnectedListener;
    private IIjkMediaPlayer mPlayer;
    private int mPlayerAction;
    private IIjkMediaPlayerService mService;
    private boolean mServiceIsConnected;
    private SomeWorkHandler mSomeWorkHandle;
    private final ArrayList<Message> mWaitList = new ArrayList<>();
    private boolean mHappenAnr = false;
    private long mStartTime = 0;
    private int mFrameInterval = 0;
    private int mNum = 0;
    private int mImgDefinition = 0;
    private int mFrameType = 0;
    private String mImgCachePath = null;
    private IjkMediaPlayerItem mItem = null;
    private OnFrameGenerateListener mOnFrameGenerateListener = null;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnErrorListener {
        boolean onError();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnFrameGenerateListener {
        boolean onFrameGenerate(int i, int i2, String str);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IjkMediaMetadataRetriever ijkMediaMetadataRetriever, String str, int i, int i2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_FILE_SIZE = "file_size";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_IP = "ip";
        public static final String ARG_IS_URL_CHANGED = "is_url_changed";
        public static final String ARG_PORT = "port";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_WILL_HTTP_OPEN = 1;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnPreparedListener {
        boolean onPrepared();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnServiceIsConnectedListener {
        void onServiceIsConnected(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SomeWorkHandler extends Handler {
        private final WeakReference<IjkMediaMetadataRetriever> mWeakPlayer;

        public SomeWorkHandler(IjkMediaMetadataRetriever mp, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mp);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Pair<String, String> option;
            Pair<String, Long> option2;
            IjkMediaMetadataRetriever player = this.mWeakPlayer.get();
            if (player == null) {
                DebugLog.w(IjkMediaMetadataRetriever.TAG, "IjkMediaMetadataRetriever went away with unhandled events");
                return;
            }
            switch (msg.what) {
                case 0:
                    try {
                        if (player.mService != null && player.mClient != null) {
                            player.mPlayer = player.mService.create(player.mClient.hashCode(), player.mClient);
                        } else {
                            removeCallbacksAndMessages(null);
                        }
                        return;
                    } catch (RemoteException e) {
                        player.onBuglyReport(e);
                        removeCallbacksAndMessages(null);
                        return;
                    } catch (NullPointerException e2) {
                        player.onBuglyReport(e2);
                        removeCallbacksAndMessages(null);
                        return;
                    }
                case 1:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.prepareAsync();
                            return;
                        }
                        return;
                    } catch (RemoteException e3) {
                        player.onBuglyReport(e3);
                        return;
                    } catch (IllegalStateException e4) {
                        player.notifyOnError();
                        return;
                    }
                case 2:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.start();
                            return;
                        }
                        return;
                    } catch (RemoteException e5) {
                        player.onBuglyReport(e5);
                        return;
                    }
                case 3:
                    player.handleRelease();
                    return;
                case 4:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.setDataSource((String) msg.obj);
                            return;
                        }
                        return;
                    } catch (RemoteException e6) {
                        player.onBuglyReport(e6);
                        return;
                    }
                case 5:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.setDataSourceBase64((String) msg.obj);
                            return;
                        }
                        return;
                    } catch (RemoteException e7) {
                        player.onBuglyReport(e7);
                        return;
                    }
                case 6:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.setDataSourceFd((ParcelFileDescriptor) msg.obj);
                            return;
                        }
                        return;
                    } catch (RemoteException e8) {
                        player.onBuglyReport(e8);
                        return;
                    }
                case 7:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.seekTo(((Long) msg.obj).longValue(), msg.arg1);
                            return;
                        }
                        return;
                    } catch (RemoteException e9) {
                        player.onBuglyReport(e9);
                        return;
                    }
                case 8:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected && (option = (Pair) msg.obj) != null) {
                            player.mPlayer.setOptionString(msg.arg1, (String) option.first, (String) option.second);
                            return;
                        }
                        return;
                    } catch (RemoteException e10) {
                        player.onBuglyReport(e10);
                        return;
                    }
                case 9:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected && (option2 = (Pair) msg.obj) != null) {
                            player.mPlayer.setOptionLong(msg.arg1, (String) option2.first, ((Long) option2.second).longValue());
                            return;
                        }
                        return;
                    } catch (RemoteException e11) {
                        player.onBuglyReport(e11);
                        return;
                    }
                case 10:
                    synchronized (player.mWaitList) {
                        int listSize = player.mWaitList.size();
                        if (listSize > 0) {
                            for (int i = 0; i < listSize; i++) {
                                sendMessage((Message) player.mWaitList.get(i));
                            }
                            player.mWaitList.clear();
                        }
                        player.mServiceIsConnected = true;
                        if (player.mOnServiceIsConnectedListener != null) {
                            player.mOnServiceIsConnectedListener.onServiceIsConnected(true);
                        }
                    }
                    return;
                case 11:
                    return;
                case 12:
                    if (player.mOnNativeInvokeListener != null) {
                        player.mOnNativeInvokeListener.onNativeInvoke(msg.arg1, (Bundle) msg.obj);
                        return;
                    }
                    return;
                case 14:
                    try {
                        if (player.mPlayer != null && player.mServiceIsConnected) {
                            player.mPlayer.addFrameOutputTask(player.mImgCachePath, player.mStartTime, player.mFrameInterval, player.mNum, player.mImgDefinition, player.mFrameType);
                            return;
                        }
                        return;
                    } catch (RemoteException e12) {
                        player.onBuglyReport(e12);
                        return;
                    }
                case 32:
                    try {
                        synchronized (player) {
                            if (player.mPlayer != null && player.mServiceIsConnected) {
                                IjkMediaPlayerItem item = (IjkMediaPlayerItem) msg.obj;
                                if (player.mPlayerAction != 10002) {
                                    if (item == null || player.mItem == item) {
                                        if (item != null && !item.isConnected()) {
                                            sendMessageAtFrontOfQueue(obtainMessage(32, msg.obj));
                                            return;
                                        } else if (item == null) {
                                            player.mPlayer.setIjkMediaPlayerItem(null);
                                        } else if (item.getItem() != null) {
                                            player.mPlayer.setIjkMediaPlayerItem(item.getItem());
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (RemoteException e13) {
                        player.onBuglyReport(e13);
                        return;
                    }
                default:
                    DebugLog.e(IjkMediaMetadataRetriever.TAG, "SomeWorkHandler Unknown message type " + msg.what);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class IjkMediaPlayerBinder extends IIjkMediaPlayerClient.Stub {
        private final WeakReference<IjkMediaMetadataRetriever> mWeakPlayer;

        public IjkMediaPlayerBinder(IjkMediaMetadataRetriever player) {
            this.mWeakPlayer = new WeakReference<>(player);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public String onMediaCodecSelect(String mimeType, int profile, int level) throws RemoteException {
            if (IjkMediaMetadataRetriever.this.mOnMediaCodecSelectListener == null) {
                IjkMediaMetadataRetriever.this.mOnMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
            }
            IjkMediaMetadataRetriever player = this.mWeakPlayer.get();
            if (player == null) {
                return null;
            }
            return IjkMediaMetadataRetriever.this.mOnMediaCodecSelectListener.onMediaCodecSelect(player, mimeType, profile, level);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onRawDataWrite(byte[] data, int offset, int size, int freq, int channels, int samples) throws RemoteException {
            return size;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoPacketCallback(byte[] au_buf, int size, long timeUs, int flag) {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onSetDolbyModel(int model) {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoDisplay(double pts, double duration) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onFirstVideoRender() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDrmEvent(int event, Bundle args) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDownloadSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onMetaDataWrite(byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public boolean onNativeInvoke(int what, Bundle args) {
            switch (what) {
                case 1:
                case 2:
                    IjkMediaMetadataRetriever.this.mSomeWorkHandle.obtainMessage(12, what, 0, args).sendToTarget();
                    return true;
                default:
                    if (IjkMediaMetadataRetriever.this.mOnNativeInvokeListener != null) {
                        IjkMediaMetadataRetriever.this.mOnNativeInvokeListener.onNativeInvoke(what, args);
                        return true;
                    }
                    return true;
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onEventHandler(int what, int arg1, int arg2, long timestamp, Bundle bundle) throws RemoteException {
            IjkMediaMetadataRetriever player = this.mWeakPlayer.get();
            if (player == null) {
                return;
            }
            String str = null;
            switch (what) {
                case 1:
                    if (IjkMediaMetadataRetriever.this.mOnPreparedListener != null) {
                        IjkMediaMetadataRetriever.this.mOnPreparedListener.onPrepared();
                        return;
                    }
                    return;
                case 6:
                    if (IjkMediaMetadataRetriever.this.mOnFrameGenerateListener != null) {
                        OnFrameGenerateListener onFrameGenerateListener = IjkMediaMetadataRetriever.this.mOnFrameGenerateListener;
                        if (bundle != null) {
                            str = bundle.getString("file_name", "");
                        }
                        onFrameGenerateListener.onFrameGenerate(arg1, arg2, str);
                        return;
                    }
                    return;
                case 100:
                    if (IjkMediaMetadataRetriever.this.mOnFrameGenerateListener != null) {
                        IjkMediaMetadataRetriever.this.mOnFrameGenerateListener.onFrameGenerate(0, IjkMediaMetadataRetriever.IJK_ONERROR, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onReportAnr(int what) {
            DebugLog.w(IjkMediaMetadataRetriever.TAG, "IjkMediaMetadataRetriever happen anr in what =" + what);
            IjkMediaMetadataRetriever.this.mHappenAnr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class IjkMediaPlayerServiceConnection implements ServiceConnection {
        private final WeakReference<IjkMediaMetadataRetriever> mWeakPlayer;

        public IjkMediaPlayerServiceConnection(IjkMediaMetadataRetriever player) {
            this.mWeakPlayer = new WeakReference<>(player);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            BLog.i(IjkMediaMetadataRetriever.TAG, "IjkMediaMetadataRetriever onServiceConnected\n");
            if (IjkMediaMetadataRetriever.this.mServiceIsConnected || IjkMediaMetadataRetriever.this.mPlayerAction == 10002) {
                return;
            }
            IjkMediaMetadataRetriever.this.mService = IIjkMediaPlayerService.Stub.asInterface(service);
            IjkMediaMetadataRetriever player = this.mWeakPlayer.get();
            IjkMediaMetadataRetriever.this.mSomeWorkHandle.obtainMessage(0).sendToTarget();
            if (player != null) {
                player.mSomeWorkHandle.obtainMessage(10).sendToTarget();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            BLog.i(IjkMediaMetadataRetriever.TAG, "IjkMediaMetadataRetriever onServiceDisconnected\n");
            IjkMediaMetadataRetriever.this.mServiceIsConnected = false;
            if (IjkMediaMetadataRetriever.this.mOnServiceIsConnectedListener != null) {
                IjkMediaMetadataRetriever.this.mOnServiceIsConnectedListener.onServiceIsConnected(false);
            }
            if (IjkMediaMetadataRetriever.this.mPlayerAction != 10002) {
                IjkMediaMetadataRetriever.this.serviceDisConnectedHandle();
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

    public IjkMediaMetadataRetriever(IjkLibLoader libLoader, Context context) {
        BLog.i(TAG, "IjkMediaPlayer create\n");
        this.mServiceIsConnected = false;
        this.mPlayerAction = 10001;
        this.mContext = context;
        this.mClient = new IjkMediaPlayerBinder(this);
        this.mIjkMediaPlayerServiceConnection = new IjkMediaPlayerServiceConnection(this);
        this.mHandleThread = new HandlerThread("ijk_java_metadata");
        this.mHandleThread.start();
        this.mSomeWorkHandle = new SomeWorkHandler(this, this.mHandleThread.getLooper());
        Intent intent = new Intent(this.mContext, IjkMediaPlayerService.class);
        Bundle bundle = new Bundle();
        File file = libLoader.findLibrary("ijkffmpeg");
        if (file != null && file.exists()) {
            bundle.putString("ijkffmpeg", file.getAbsolutePath());
        }
        File file2 = libLoader.findLibrary("ijksdl");
        if (file2 != null && file2.exists()) {
            bundle.putString("ijksdl", file2.getAbsolutePath());
        }
        File file3 = libLoader.findLibrary("ijkplayer");
        if (file3 != null && file3.exists()) {
            bundle.putString("ijkplayer", file3.getAbsolutePath());
        }
        intent.putExtras(bundle);
        this.mContext.bindService(intent, this.mIjkMediaPlayerServiceConnection, 1);
    }

    public IjkMediaMetadataRetriever(Context context) {
        BLog.i(TAG, "IjkMediaPlayer create\n");
        this.mServiceIsConnected = false;
        this.mPlayerAction = 10001;
        this.mContext = context;
        this.mClient = new IjkMediaPlayerBinder(this);
        this.mIjkMediaPlayerServiceConnection = new IjkMediaPlayerServiceConnection(this);
        this.mHandleThread = new HandlerThread("ijk_java_metadata");
        this.mHandleThread.start();
        this.mSomeWorkHandle = new SomeWorkHandler(this, this.mHandleThread.getLooper());
        Intent intent = new Intent(this.mContext, IjkMediaPlayerService.class);
        this.mContext.bindService(intent, this.mIjkMediaPlayerServiceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBuglyReport(Exception e) {
        if (this.mHappenAnr) {
            BLog.w(TAG, "Service ANR");
        } else {
            BLog.w(TAG, "Call Service Api Fail");
        }
        this.mHappenAnr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceDisConnectedHandle() {
        if (this.mOnFrameGenerateListener != null) {
            this.mOnFrameGenerateListener.onFrameGenerate(0, IJK_SERVICE_DISCONNECTED, null);
        }
    }

    public boolean serviceIsConnected() {
        return this.mServiceIsConnected;
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
        if (0 == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (0 == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        android.util.Log.d(tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r11.toString(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException {
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

    public void setDataSource(String path) {
        this.mDataSource = path;
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(4, path).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(4, path).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(4, path));
            }
        }
    }

    public void setDataSourceBase64(String path) {
        this.mDataSource = path;
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(5, path).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(5, path).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(5, path));
            }
        }
    }

    public void setDataSource(String path, Map<String, String> headers) throws IOException {
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
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(path);
    }

    public void setDataSource(FileDescriptor fd) throws IOException {
        ParcelFileDescriptor pfd = ParcelFileDescriptor.dup(fd);
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(6, pfd).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(6, pfd).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(6, pfd));
            }
        }
    }

    private void setDataSource(FileDescriptor fd, long offset, long length) throws IOException {
        setDataSource(fd);
    }

    public void setIjkMediaPlayerItem(IjkMediaPlayerItem item) {
        if (item == null || !item.connect() || this.mItem != null) {
            BLog.w(TAG, "setIjkMediaPlayerItem use error item or mItem != null mItem = " + this.mItem);
            return;
        }
        BLog.i(TAG, "setIjkMediaPlayerItem " + item);
        synchronized (this) {
            this.mItem = item;
        }
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(32, item).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(32, item).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(32, item));
            }
        }
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public void prepareAsync() {
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(1).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(1).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(1));
            }
        }
    }

    public void handleRelease() {
        this.mServiceIsConnected = false;
        resetListeners();
        this.mSomeWorkHandle.removeCallbacksAndMessages(null);
        synchronized (this.mWaitList) {
            this.mWaitList.clear();
        }
        if (this.mPlayer != null) {
            try {
                this.mPlayer.release();
                if (this.mService != null && this.mClient != null) {
                    this.mService.removeClient(this.mClient.hashCode());
                }
            } catch (RemoteException e) {
                onBuglyReport(e);
            }
        }
        this.mHandleThread.quit();
        if (this.mIjkMediaPlayerServiceConnection != null) {
            try {
                this.mContext.unbindService(this.mIjkMediaPlayerServiceConnection);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            this.mIjkMediaPlayerServiceConnection = null;
        }
    }

    public void release() {
        if (this.mPlayerAction == 10002) {
            return;
        }
        synchronized (this) {
            if (this.mItem != null) {
                this.mItem.disconnect();
                this.mItem.stop();
                this.mItem = null;
            }
        }
        this.mPlayerAction = 10002;
        if (this.mPlayer != null && this.mServiceIsConnected) {
            try {
                this.mPlayer.pause();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.mSomeWorkHandle.obtainMessage(3).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                try {
                    this.mPlayer.pause();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                this.mSomeWorkHandle.obtainMessage(3).sendToTarget();
                return;
            }
            synchronized (this.mWaitList) {
                this.mWaitList.clear();
            }
            if (this.mIjkMediaPlayerServiceConnection != null) {
                try {
                    this.mContext.unbindService(this.mIjkMediaPlayerServiceConnection);
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                }
                this.mIjkMediaPlayerServiceConnection = null;
            }
            this.mSomeWorkHandle.removeCallbacksAndMessages(null);
            this.mHandleThread.quit();
            try {
                this.mHandleThread.join();
                return;
            } catch (InterruptedException e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    public void syncReset() {
        synchronized (this.mWaitList) {
            this.mSomeWorkHandle.removeCallbacksAndMessages(null);
            this.mWaitList.clear();
        }
        try {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mPlayer.pause();
                this.mPlayer.reset();
            }
        } catch (RemoteException e) {
            onBuglyReport(e);
        }
    }

    public void start() {
        setOption(4, "seek-at-start", this.mStartTime);
        prepareAsync();
    }

    public void setOption(int category, String name, String value) {
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(8, category, 0, new Pair(name, value)).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(8, category, 0, new Pair(name, value)).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(8, category, 0, new Pair(name, value)));
            }
        }
    }

    public void setOption(int category, String name, long value) {
        if (this.mPlayer != null && this.mServiceIsConnected) {
            this.mSomeWorkHandle.obtainMessage(9, category, 0, new Pair(name, Long.valueOf(value))).sendToTarget();
            return;
        }
        synchronized (this.mWaitList) {
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(9, category, 0, new Pair(name, Long.valueOf(value))).sendToTarget();
            } else {
                this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(9, category, 0, new Pair(name, Long.valueOf(value))));
            }
        }
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

    public void resetListeners() {
        this.mOnNativeInvokeListener = null;
        this.mOnServiceIsConnectedListener = null;
        this.mOnMediaCodecSelectListener = null;
        this.mOnFrameGenerateListener = null;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever.OnMediaCodecSelectListener
        public String onMediaCodecSelect(IjkMediaMetadataRetriever mp, String mimeType, int profile, int level) {
            String[] types;
            IjkMediaCodecInfo candidate;
            if (TextUtils.isEmpty(mimeType)) {
                return null;
            }
            int i = 0;
            int i2 = 1;
            Log.i(IjkMediaMetadataRetriever.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", mimeType, Integer.valueOf(profile), Integer.valueOf(level)));
            ArrayList<IjkMediaCodecInfo> candidateCodecList = new ArrayList<>();
            int numCodecs = MediaCodecList.getCodecCount();
            int i3 = 0;
            while (i3 < numCodecs) {
                MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i3);
                String str = IjkMediaMetadataRetriever.TAG;
                Locale locale = Locale.US;
                Object[] objArr = new Object[i2];
                objArr[i] = codecInfo.getName();
                Log.d(str, String.format(locale, "  found codec: %s", objArr));
                if (!codecInfo.isEncoder() && (types = codecInfo.getSupportedTypes()) != null) {
                    int length = types.length;
                    int i4 = i;
                    while (i4 < length) {
                        String type = types[i4];
                        if (!TextUtils.isEmpty(type)) {
                            String str2 = IjkMediaMetadataRetriever.TAG;
                            Locale locale2 = Locale.US;
                            Object[] objArr2 = new Object[i2];
                            objArr2[i] = type;
                            Log.d(str2, String.format(locale2, "    mime: %s", objArr2));
                            if (type.equalsIgnoreCase(mimeType) && (candidate = IjkMediaCodecInfo.setupCandidate(codecInfo, mimeType, profile, level)) != null) {
                                candidateCodecList.add(candidate);
                                Log.i(IjkMediaMetadataRetriever.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfo.getName(), Integer.valueOf(candidate.mRank)));
                                candidate.dumpProfileLevels(mimeType);
                            }
                        }
                        i4++;
                        i = 0;
                        i2 = 1;
                    }
                }
                i3++;
                i = 0;
                i2 = 1;
            }
            if (candidateCodecList.isEmpty()) {
                return null;
            }
            IjkMediaCodecInfo bestCodec = candidateCodecList.get(0);
            Iterator<IjkMediaCodecInfo> it = candidateCodecList.iterator();
            while (it.hasNext()) {
                IjkMediaCodecInfo codec = it.next();
                if (codec.mRank > bestCodec.mRank) {
                    bestCodec = codec;
                }
            }
            if (bestCodec.mRank < 600) {
                Log.w(IjkMediaMetadataRetriever.TAG, String.format(Locale.US, "unaccetable codec: %s", bestCodec.mCodecInfo.getName()));
                return null;
            }
            Log.i(IjkMediaMetadataRetriever.TAG, String.format(Locale.US, "selected codec: %s rank=%d", bestCodec.mCodecInfo.getName(), Integer.valueOf(bestCodec.mRank)));
            return bestCodec.mCodecInfo.getName();
        }
    }

    public void setFrameTimeCallback(OnFrameGenerateListener listener) {
        this.mOnFrameGenerateListener = listener;
    }

    public boolean init(String imgCachePath, long startTime, long endTime, int num, int imgDefinition) {
        if (!TextUtils.isEmpty(imgCachePath) && startTime >= 0 && endTime >= 0 && num > 0 && endTime >= startTime) {
            this.mStartTime = startTime;
            if (num == 1) {
                this.mFrameInterval = 0;
            } else {
                this.mFrameInterval = ((int) (endTime - startTime)) / (num - 1);
            }
            this.mNum = num;
            this.mImgDefinition = imgDefinition;
            this.mImgCachePath = imgCachePath;
            this.mFrameType = 0;
            if (this.mPlayer != null && this.mServiceIsConnected) {
                this.mSomeWorkHandle.obtainMessage(14).sendToTarget();
            } else {
                synchronized (this.mWaitList) {
                    if (this.mPlayer != null && this.mServiceIsConnected) {
                        this.mSomeWorkHandle.obtainMessage(14).sendToTarget();
                    } else {
                        this.mWaitList.add(this.mSomeWorkHandle.obtainMessage(14));
                    }
                }
            }
            return true;
        }
        return false;
    }

    public long getDuration() {
        if (this.mPlayer != null && this.mServiceIsConnected) {
            try {
                return this.mPlayer.getDuration();
            } catch (RemoteException e) {
                onBuglyReport(e);
                return 0L;
            }
        }
        return 0L;
    }

    public final void setOnPreparedListener(OnPreparedListener listener) {
        this.mOnPreparedListener = listener;
    }

    public int addFrameOutputTask(String imgCachePath, long startTime, int frameInterval, int count, int imgDefinition, int frameType) {
        if (this.mPlayer == null || !this.mServiceIsConnected) {
            return -1;
        }
        try {
            return this.mPlayer.addFrameOutputTask(imgCachePath, startTime, frameInterval, count, imgDefinition, frameType);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public int deleteCurrentFrameOutputTask(long startTime) {
        if (this.mPlayer != null && this.mServiceIsConnected) {
            try {
                this.mPlayer.setPropertyLong(FFP_PROP_INT64_DELETE_FRAMEOUTPUT_TASK, startTime);
                return 0;
            } catch (RemoteException e) {
                return -1;
            }
        }
        return -1;
    }

    public final void setOnErrorListener(OnErrorListener listener) {
        this.mOnErrorListener = listener;
    }

    protected final boolean notifyOnError() {
        return this.mOnErrorListener != null && this.mOnErrorListener.onError();
    }
}