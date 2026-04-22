package tv.danmaku.bili.update.internal.network.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import bolts.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.android.log.BLog;

public final class ConnectivityMonitor {
    private static volatile ConnectivityMonitor INSTANCE = null;
    public static final int NET_ETHERNET = 5;
    public static final int NET_MOBILE = 2;
    public static final int NET_MOBILE_2G = 22;
    public static final int NET_MOBILE_3G = 32;
    public static final int NET_MOBILE_4G = 42;
    public static final int NET_MOBILE_5G = 52;
    public static final int NET_NO_CONNECTIVITY = 3;
    public static final int NET_OTHER = 4;
    public static final int NET_WIFI = 1;
    private static final String TAG = "ConnectivityMonitor";
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private IntentFilter mIntentFilter;
    private String mSpeedDesc;
    private String mSubtype;
    private String mType;
    private int mNetwork = 3;
    private int mNetworkDetail = 3;
    private long mCachedTime = 0;
    private int mLastNetwork = 3;
    private NetworkInfo mRaw = null;
    private final List<OnNetworkChangedListener> mListeners = Collections.synchronizedList(new ArrayList(4));

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter);
    }

    private ConnectivityMonitor() {
    }

    public static ConnectivityMonitor getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectivityMonitor.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectivityMonitor();
                }
            }
        }
        return INSTANCE;
    }

    public void startup(Context context) {
        this.mContext = context.getApplicationContext();
        updateNetworkInfo();
        this.mBroadcastReceiver = new MyBroadcastReceiver();
        this.mIntentFilter = new IntentFilter();
        this.mIntentFilter.setPriority(990);
        this.mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.mContext, this.mBroadcastReceiver, this.mIntentFilter);
    }

    public void teardown() {
        if (this.mContext == null || this.mBroadcastReceiver == null) {
            return;
        }
        try {
            this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        } catch (Exception e) {
        }
        this.mContext = null;
        this.mBroadcastReceiver = null;
        this.mIntentFilter = null;
    }

    public String getSpeedDesc() {
        String str;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            str = this.mSpeedDesc;
        }
        return str;
    }

    public String getTypeString() {
        String str;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            str = this.mType;
        }
        return str;
    }

    public String getSubtypeString() {
        String str;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            str = this.mSubtype;
        }
        return str;
    }

    private void refreshIfNeed() {
        if (SystemClock.elapsedRealtime() - this.mCachedTime < 1000) {
            return;
        }
        fillNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetworkInfo() {
        if (this.mContext == null) {
            resetNetworkInfo();
        } else {
            fillNetworkInfo();
        }
    }

    private void resetNetworkInfo() {
        synchronized (ConnectivityMonitor.class) {
            this.mCachedTime = 0L;
            this.mNetwork = 3;
            this.mType = "";
            this.mSubtype = "";
            this.mSpeedDesc = "";
            this.mLastNetwork = 3;
            this.mRaw = null;
        }
    }

    private void setActiveNetworkInfo(NetworkInfo info) {
        int network;
        if (info == null || !Connectivity.isConnected(info)) {
            network = 3;
        } else if (Connectivity.isConnectedWifi(info)) {
            network = 1;
        } else if (Connectivity.isConnectedMobile(info)) {
            network = 2;
        } else if (Connectivity.isConnectedEthernet(info)) {
            network = 5;
        } else {
            network = 4;
        }
        this.mCachedTime = SystemClock.elapsedRealtime();
        if (this.mNetwork == network) {
            return;
        }
        synchronized (ConnectivityMonitor.class) {
            if (this.mNetwork == network) {
                return;
            }
            String type = info == null ? "" : info.getTypeName();
            String subtype = info == null ? "" : info.getSubtypeName();
            String speed = info == null ? "" : Connectivity.getNetworkSpeed(info.getType(), info.getSubtype());
            int networkDetail = info == null ? 4 : Connectivity.getNetworkDetail(info.getType(), info.getSubtype());
            BLog.event("Network", "network changed: " + this.mNetwork + "=>" + network);
            this.mLastNetwork = this.mNetwork;
            this.mNetwork = network;
            this.mType = type;
            this.mSubtype = subtype;
            this.mSpeedDesc = speed;
            this.mNetworkDetail = networkDetail;
            this.mRaw = info;
            notifyChanged();
        }
    }

    private void fillNetworkInfo() {
        NetworkInfo networkInfo = Connectivity.getActiveNetworkInfo(this.mContext);
        setActiveNetworkInfo(networkInfo);
    }

    public int getNetwork() {
        int i;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            i = this.mNetwork;
        }
        return i;
    }

    public int getNetworkWithoutCache() {
        fillNetworkInfo();
        return this.mNetwork;
    }

    public int getNetworkDetail() {
        int i;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            i = this.mNetworkDetail;
        }
        return i;
    }

    public boolean isWifiActive() {
        boolean z;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            z = true;
            if (1 != this.mNetwork) {
                z = false;
            }
        }
        return z;
    }

    public boolean isMobileActive() {
        boolean z;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            z = 2 == this.mNetwork;
        }
        return z;
    }

    public boolean isNetworkActive() {
        boolean z;
        refreshIfNeed();
        synchronized (ConnectivityMonitor.class) {
            z = true;
            if (1 != this.mNetwork && 2 != this.mNetwork && 5 != this.mNetwork) {
                z = false;
            }
        }
        return z;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private final class MyBroadcastReceiver extends BroadcastReceiver {
        final Runnable mAction;

        private MyBroadcastReceiver() {
            this.mAction = new Runnable() { // from class: tv.danmaku.bili.update.internal.network.connectivity.ConnectivityMonitor.MyBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectivityMonitor.this.updateNetworkInfo();
                }
            };
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Task.BACKGROUND_EXECUTOR.execute(this.mAction);
        }
    }

    public void register(OnNetworkChangedListener listener) {
        synchronized (this.mListeners) {
            if (this.mListeners.contains(listener)) {
                throw new IllegalStateException("already exists");
            }
            this.mListeners.add(listener);
        }
    }

    public boolean hasListener(OnNetworkChangedListener listener) {
        boolean contains;
        synchronized (this.mListeners) {
            contains = this.mListeners.contains(listener);
        }
        return contains;
    }

    public void unregister(OnNetworkChangedListener listener) {
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                return;
            }
            this.mListeners.remove(listener);
        }
    }

    private void notifyChanged() {
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                return;
            }
            synchronized (this.mListeners) {
                int net = this.mNetwork;
                for (OnNetworkChangedListener listener : this.mListeners) {
                    if (listener != null) {
                        Task.UI_THREAD_EXECUTOR.execute(new Notify(listener, net, this.mLastNetwork, this.mRaw));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Notify implements Runnable {
        int lastNet;
        OnNetworkChangedListener listener;
        int net;
        NetworkInfo raw;

        Notify(OnNetworkChangedListener listener, int net, int lastNet, NetworkInfo raw) {
            this.listener = listener;
            this.net = net;
            this.lastNet = lastNet;
            this.raw = raw;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.onChanged(this.net);
            this.listener.onChanged(this.net, this.lastNet, this.raw);
            BLog.d(ConnectivityMonitor.TAG, "newNet = " + this.net + ", preNet = " + this.lastNet);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnNetworkChangedListener {
        @Deprecated
        void onChanged(int i);

        void onChanged(int i, int i2, NetworkInfo networkInfo);

        /* renamed from: tv.danmaku.bili.update.internal.network.connectivity.ConnectivityMonitor$OnNetworkChangedListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onChanged(OnNetworkChangedListener _this, int newNet, int preNet, NetworkInfo details) {
            }
        }
    }
}