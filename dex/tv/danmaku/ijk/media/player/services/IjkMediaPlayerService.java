package tv.danmaku.ijk.media.player.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.bilibili.lib.spy.generated.android_app_Service;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.io.File;
import java.lang.ref.WeakReference;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IAbrParamsInterface;
import tv.danmaku.ijk.media.player.IIjkMediaPlayer;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerService;
import tv.danmaku.ijk.media.player.IP2P;
import tv.danmaku.ijk.media.player.IjkJNILibManager;
import tv.danmaku.ijk.media.player.IjkLibLoader;

public class IjkMediaPlayerService extends android_app_Service {
    private static final String TAG = "IjkMediaPlayerService";
    private Context mContext;
    private static P2PClient sP2PClinet = null;
    private static AbrParamsInterfaceClient abrClient = null;
    private static boolean mEnableNewFFmpeg = true;
    private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.services.IjkMediaPlayerService.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String libName) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(libName);
        }

        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public File findLibrary(String libName) {
            return null;
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private final SparseArray<WeakReference<IIjkMediaPlayer>> mClients = new SparseArray<>();
    private final SparseArray<WeakReference<IIjkMediaPlayerItem>> mItemClients = new SparseArray<>();
    IIjkMediaPlayerService.Stub mBinder = new IIjkMediaPlayerServiceStubWrapper(this);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static void loadLibrariesOnce(Bundle bundle) {
        String[] loadLibs;
        synchronized (IjkMediaPlayerService.class) {
            if (mEnableNewFFmpeg) {
            }
            if (mEnableNewFFmpeg) {
            }
            if (!mIsLibLoaded) {
                boolean enable_ffmpeg_v2 = bundle.getBoolean("enable_ffmpeg_v2", false);
                String lib_path = bundle.getString("lib_path", null);
                IjkJNILibManager.getInstance().init(enable_ffmpeg_v2, lib_path != null ? new File(lib_path) : null);
                for (String lib : IjkJNILibManager.getInstance().getLoadLibs()) {
                    if (bundle != null && bundle.get(lib) != null) {
                        BLog.i(TAG, "Load library " + lib + " for System .");
                        String lib_name = bundle.get(lib).toString();
                        if (enable_ffmpeg_v2 && lib_path != null) {
                            String lib_name2 = lib_path + "/lib" + lib_name + ".so";
                            BLog.i(TAG, "Load library from path: " + lib_name2);
                            System.load(lib_name2);
                        } else {
                            System.loadLibrary(lib_name);
                        }
                    } else {
                        BLog.i(TAG, "Load library " + lib + " for LocalLibLoader .");
                        sLocalLibLoader.loadLibrary(lib);
                    }
                }
                mIsLibLoaded = true;
            }
        }
    }

    public void onCreate() {
        BLog.i(TAG, "onCreate");
        super.onCreate();
        BLog.i(TAG, "onCreate=0");
        this.mContext = super.getApplicationContext();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkMediaPlayerDeathHandler implements IBinder.DeathRecipient {
        private int mConnId;
        private final WeakReference<IjkMediaPlayerService> mWeakMediaPlayerService;

        public IjkMediaPlayerDeathHandler(int connId, IjkMediaPlayerService service) {
            this.mConnId = connId;
            this.mWeakMediaPlayerService = new WeakReference<>(service);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            IjkMediaPlayerService service = this.mWeakMediaPlayerService.get();
            if (service != null) {
                synchronized (service.mClients) {
                    WeakReference<IIjkMediaPlayer> v = (WeakReference) service.mClients.get(this.mConnId);
                    if (v != null) {
                        IIjkMediaPlayer iIjkMediaPlayer = v.get();
                        if (iIjkMediaPlayer != null && (iIjkMediaPlayer instanceof IjkMediaPlayerClient)) {
                            ((IjkMediaPlayerClient) iIjkMediaPlayer).unlinkDeathHandler();
                            ((IjkMediaPlayerClient) iIjkMediaPlayer).clientDeathHandle();
                        }
                        service.mClients.remove(this.mConnId);
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IjkMediaPlayerItemDeathHandler implements IBinder.DeathRecipient {
        private int mConnId;
        private final WeakReference<IjkMediaPlayerService> mWeakMediaPlayerService;

        public IjkMediaPlayerItemDeathHandler(int connId, IjkMediaPlayerService service) {
            this.mConnId = connId;
            this.mWeakMediaPlayerService = new WeakReference<>(service);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            IjkMediaPlayerService service = this.mWeakMediaPlayerService.get();
            if (service != null) {
                synchronized (service.mItemClients) {
                    WeakReference<IIjkMediaPlayerItem> v = (WeakReference) service.mItemClients.get(this.mConnId);
                    if (v != null) {
                        IIjkMediaPlayerItem iIjkMediaPlayerItem = v.get();
                        if (iIjkMediaPlayerItem != null && (iIjkMediaPlayerItem instanceof IjkMediaPlayerItemClient)) {
                            ((IjkMediaPlayerItemClient) iIjkMediaPlayerItem).unlinkDeathHandler();
                            ((IjkMediaPlayerItemClient) iIjkMediaPlayerItem).clientDeathHandle();
                        }
                        service.mItemClients.remove(this.mConnId);
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IIjkMediaPlayerServiceStubWrapper extends IIjkMediaPlayerService.Stub {
        private final WeakReference<IjkMediaPlayerService> mWeakMediaPlayerService;

        public IIjkMediaPlayerServiceStubWrapper(IjkMediaPlayerService service) {
            this.mWeakMediaPlayerService = new WeakReference<>(service);
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IIjkMediaPlayer create(int connId, IIjkMediaPlayerClient client) {
            IjkMediaPlayerClient c;
            if (this.mWeakMediaPlayerService == null) {
                BLog.w(IjkMediaPlayerService.TAG, "mWeakMediaPlayerService " + this.mWeakMediaPlayerService);
                return null;
            }
            IjkMediaPlayerService ijkMediaPlayerService = this.mWeakMediaPlayerService.get();
            if (ijkMediaPlayerService != null) {
                synchronized (ijkMediaPlayerService.mClients) {
                    c = new IjkMediaPlayerClient(client, ijkMediaPlayerService.mContext);
                    c.linkDeathHandler(new IjkMediaPlayerDeathHandler(connId, ijkMediaPlayerService));
                    ijkMediaPlayerService.mClients.put(connId, new WeakReference(c));
                    BLog.i(IjkMediaPlayerService.TAG, "IIjkMediaPlayerService create mClients.size() = " + ijkMediaPlayerService.mClients.size());
                }
                return c;
            }
            BLog.w(IjkMediaPlayerService.TAG, "ijkMediaPlayerService " + ijkMediaPlayerService);
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public void removeClient(int connId) {
            IjkMediaPlayerService ijkMediaPlayerService;
            IIjkMediaPlayer iIjkMediaPlayer;
            if (this.mWeakMediaPlayerService == null || (ijkMediaPlayerService = this.mWeakMediaPlayerService.get()) == null) {
                return;
            }
            synchronized (ijkMediaPlayerService.mClients) {
                int blockCount = 0;
                WeakReference<IIjkMediaPlayer> v = (WeakReference) ijkMediaPlayerService.mClients.get(connId);
                ijkMediaPlayerService.mClients.remove(connId);
                if (v != null && (iIjkMediaPlayer = v.get()) != null && (iIjkMediaPlayer instanceof IjkMediaPlayerClient)) {
                    ((IjkMediaPlayerClient) iIjkMediaPlayer).unlinkDeathHandler();
                    ((IjkMediaPlayerClient) iIjkMediaPlayer).quitHandleThread();
                }
                int size = ijkMediaPlayerService.mClients.size();
                for (int i = 0; i < size; i++) {
                    WeakReference<IIjkMediaPlayer> value = (WeakReference) ijkMediaPlayerService.mClients.valueAt(i);
                    if (value != null) {
                        IIjkMediaPlayer client = value.get();
                        if ((client instanceof IjkMediaPlayerClient) && ((IjkMediaPlayerClient) client).mBlocked) {
                            blockCount++;
                        }
                    }
                }
                if (blockCount > 0) {
                    BLog.w(IjkMediaPlayerService.TAG, "MediaPlayerService blockCount = " + blockCount + ",mClients.size = " + size);
                    if (size == blockCount || blockCount >= 3) {
                        BLog.e(IjkMediaPlayerService.TAG, "ANR happened, IjkMediaPlayerService will reboot");
                        IjkMediaPlayerService.systemExit();
                    }
                }
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IIjkMediaPlayerItem createItem(int connId, IIjkMediaPlayerItemClient itemClient) throws RemoteException {
            IjkMediaPlayerItemClient c;
            if (this.mWeakMediaPlayerService == null) {
                BLog.w(IjkMediaPlayerService.TAG, "mWeakMediaPlayerService " + this.mWeakMediaPlayerService);
                return null;
            }
            IjkMediaPlayerService ijkMediaPlayerService = this.mWeakMediaPlayerService.get();
            if (ijkMediaPlayerService != null) {
                synchronized (ijkMediaPlayerService.mItemClients) {
                    c = new IjkMediaPlayerItemClient(itemClient);
                    c.linkDeathHandler(new IjkMediaPlayerItemDeathHandler(connId, ijkMediaPlayerService));
                    ijkMediaPlayerService.mItemClients.put(connId, new WeakReference(c));
                    BLog.i(IjkMediaPlayerService.TAG, "IIjkMediaPlayerService create mItemClients.size() = " + ijkMediaPlayerService.mItemClients.size());
                }
                return c;
            }
            BLog.w(IjkMediaPlayerService.TAG, "ijkMediaPlayerService " + ijkMediaPlayerService);
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public void removeItemClient(int connId) throws RemoteException {
            IjkMediaPlayerService ijkMediaPlayerService;
            IIjkMediaPlayerItem iIjkMediaPlayerItem;
            if (this.mWeakMediaPlayerService == null || (ijkMediaPlayerService = this.mWeakMediaPlayerService.get()) == null) {
                return;
            }
            synchronized (ijkMediaPlayerService.mItemClients) {
                WeakReference<IIjkMediaPlayerItem> v = (WeakReference) ijkMediaPlayerService.mItemClients.get(connId);
                ijkMediaPlayerService.mItemClients.remove(connId);
                if (v != null && (iIjkMediaPlayerItem = v.get()) != null && (iIjkMediaPlayerItem instanceof IjkMediaPlayerItemClient)) {
                    ((IjkMediaPlayerItemClient) iIjkMediaPlayerItem).unlinkDeathHandler();
                }
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public synchronized IP2P createP2P(Bundle configs) {
            if (this.mWeakMediaPlayerService == null) {
                BLog.w(IjkMediaPlayerService.TAG, "mWeakMediaPlayerService " + this.mWeakMediaPlayerService);
                return null;
            } else if (IjkMediaPlayerService.sP2PClinet != null) {
                return IjkMediaPlayerService.sP2PClinet;
            } else {
                IjkMediaPlayerService ijkMediaPlayerService = this.mWeakMediaPlayerService.get();
                if (ijkMediaPlayerService != null) {
                    IjkMediaPlayerService.sP2PClinet = new P2PClient(configs);
                    return IjkMediaPlayerService.sP2PClinet;
                }
                return null;
            }
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public synchronized IAbrParamsInterface createAbrParamsInterface() {
            if (this.mWeakMediaPlayerService == null) {
                return null;
            }
            if (IjkMediaPlayerService.abrClient != null) {
                return IjkMediaPlayerService.abrClient;
            }
            IjkMediaPlayerService ijkMediaPlayerService = this.mWeakMediaPlayerService.get();
            if (ijkMediaPlayerService != null) {
                IjkMediaPlayerService.abrClient = new AbrParamsInterfaceClient();
                return IjkMediaPlayerService.abrClient;
            }
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        BLog.i(TAG, "onBind");
        Bundle bundle = intent.getExtras();
        try {
            loadLibrariesOnce(bundle);
            BLog.i(TAG, "onBind=0");
            return this.mBinder;
        } catch (Throwable e) {
            BLog.e(TAG, "loadLibrariesOnce Error: " + e);
            e.printStackTrace();
            return null;
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        BLog.i(TAG, "onStartCommand ");
        Bundle bundle = intent == null ? null : intent.getExtras();
        BLog.i(TAG, "onStartCommand");
        if (bundle != null) {
            try {
                loadLibrariesOnce(bundle);
            } catch (Throwable e) {
                BLog.e(TAG, "loadLibrariesOnce Error: " + e);
                e.printStackTrace();
            }
        }
        BLog.i(TAG, "onStartCommand=0");
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        BLog.i(TAG, "onUnbind");
        return false;
    }

    public void onDestroy() {
        BLog.i(TAG, "onDestroy");
        super.onDestroy();
        BLog.i(TAG, "onDestroy=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void systemExit() {
        System.exit(0);
    }
}