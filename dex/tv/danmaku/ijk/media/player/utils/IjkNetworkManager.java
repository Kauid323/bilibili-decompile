package tv.danmaku.ijk.media.player.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;

public class IjkNetworkManager {
    private static final String TAG = "IjkNetworkManager";
    private static IjkNetworkManager sIjkNetworkManager = null;
    private Context mAppContext;
    private ArrayList<WeakReference<NetWorkChangeListener>> mListeners = new ArrayList<>();
    private NetworkChangeReceiver mNetworkChangeReceiver;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface NetWorkChangeListener {
        void onNetWorkChange(IjkNetworkUtils.NetWorkType netWorkType, IjkNetworkUtils.NetWorkType netWorkType2);
    }

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter);
    }

    public static synchronized IjkNetworkManager getInstance(Context context) {
        IjkNetworkManager ijkNetworkManager;
        synchronized (IjkNetworkManager.class) {
            if (sIjkNetworkManager == null) {
                sIjkNetworkManager = new IjkNetworkManager(context);
            }
            ijkNetworkManager = sIjkNetworkManager;
        }
        return ijkNetworkManager;
    }

    private IjkNetworkManager(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(990);
        this.mAppContext = context.getApplicationContext();
        this.mNetworkChangeReceiver = new NetworkChangeReceiver(this);
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.mAppContext, this.mNetworkChangeReceiver, intentFilter);
    }

    public void registerListener(NetWorkChangeListener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            Iterator<WeakReference<NetWorkChangeListener>> it = this.mListeners.iterator();
            while (it.hasNext()) {
                WeakReference<NetWorkChangeListener> obj = it.next();
                if (obj != null && obj.get() == listener) {
                    return;
                }
            }
            this.mListeners.add(new WeakReference<>(listener));
        }
    }

    public synchronized void unRegisterListener(NetWorkChangeListener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            Iterator<WeakReference<NetWorkChangeListener>> it = this.mListeners.iterator();
            while (it.hasNext()) {
                WeakReference<NetWorkChangeListener> obj = it.next();
                if (obj != null && obj.get() == listener) {
                    this.mListeners.remove(obj);
                    return;
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class NetworkChangeReceiver extends BroadcastReceiver {
        private IjkNetworkUtils.NetWorkType mNetWorktype;
        private final IjkNetworkManager mNetworkManger;

        public NetworkChangeReceiver(IjkNetworkManager networkManager) {
            this.mNetworkManger = networkManager;
            this.mNetWorktype = IjkNetworkUtils.getNetworkState(this.mNetworkManger.mAppContext);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<NetWorkChangeListener>[] listeners;
            IjkNetworkUtils.NetWorkType currentNetWorkType = IjkNetworkUtils.getNetworkState(this.mNetworkManger.mAppContext);
            BLog.i(IjkNetworkManager.TAG, "NetworkChangeReceiver  currentNetWorkType " + currentNetWorkType + " mNetWorktype " + this.mNetWorktype);
            if (this.mNetWorktype != currentNetWorkType) {
                synchronized (this.mNetworkManger) {
                    listeners = new WeakReference[this.mNetworkManger.mListeners.size()];
                    this.mNetworkManger.mListeners.toArray(listeners);
                }
                for (WeakReference<NetWorkChangeListener> obj : listeners) {
                    NetWorkChangeListener listener = obj.get();
                    if (listener != null) {
                        listener.onNetWorkChange(currentNetWorkType, this.mNetWorktype);
                    }
                }
            }
            this.mNetWorktype = currentNetWorkType;
        }
    }
}