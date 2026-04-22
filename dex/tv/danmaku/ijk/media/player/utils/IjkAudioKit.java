package tv.danmaku.ijk.media.player.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.android.log.BLog;

public class IjkAudioKit {
    private static IjkAudioKit sSharedInstance;
    private Context mContext;
    private AudioManager mManager;
    private final String TAG = "IjkAudioKit";
    private ArrayList<IjkAudioKitCallback> mListeners = new ArrayList<>();
    private HeadsetDetectReceiver mReceiver = new HeadsetDetectReceiver();
    HeadphoneStatus mWiredHeadphoneStatus = HeadphoneStatus.StatusUnknown;
    HeadphoneStatus mBluetoothHeadphoneStatus = HeadphoneStatus.StatusUnknown;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum HeadphoneStatus {
        StatusUnknown,
        StatusOn,
        StatusOff
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IjkAudioKitCallback {
        void onEndpointChange(IjkAudioKitEndpoint ijkAudioKitEndpoint);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum IjkAudioKitEndpoint {
        IjkAudioKitEndpointUnknown,
        IjkAudioKitEndpointSpeaker,
        IjkAudioKitEndpointHeadphone
    }

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter);
    }

    public static IjkAudioKit sharedInstance(Context context) {
        if (sSharedInstance == null) {
            sSharedInstance = new IjkAudioKit(context);
        }
        return sSharedInstance;
    }

    public IjkAudioKitEndpoint getEndpoint() {
        if (this.mWiredHeadphoneStatus == HeadphoneStatus.StatusOn || this.mBluetoothHeadphoneStatus == HeadphoneStatus.StatusOn) {
            return IjkAudioKitEndpoint.IjkAudioKitEndpointHeadphone;
        }
        if (this.mWiredHeadphoneStatus == HeadphoneStatus.StatusOff && this.mBluetoothHeadphoneStatus == HeadphoneStatus.StatusOff) {
            return IjkAudioKitEndpoint.IjkAudioKitEndpointSpeaker;
        }
        return getDeviceEndpoint();
    }

    public IjkAudioKitEndpoint getDeviceEndpoint() {
        AudioDeviceInfo[] devices = this.mManager.getDevices(2);
        this.mWiredHeadphoneStatus = HeadphoneStatus.StatusOff;
        this.mBluetoothHeadphoneStatus = HeadphoneStatus.StatusOff;
        for (AudioDeviceInfo device : devices) {
            if (device.getType() == 3 || device.getType() == 4) {
                this.mWiredHeadphoneStatus = HeadphoneStatus.StatusOn;
            }
            if (device.getType() == 8 || device.getType() == 7) {
                this.mBluetoothHeadphoneStatus = HeadphoneStatus.StatusOn;
            }
            if (this.mWiredHeadphoneStatus == HeadphoneStatus.StatusOn || this.mBluetoothHeadphoneStatus == HeadphoneStatus.StatusOn) {
                return IjkAudioKitEndpoint.IjkAudioKitEndpointHeadphone;
            }
        }
        return IjkAudioKitEndpoint.IjkAudioKitEndpointSpeaker;
    }

    private IjkAudioKit(Context context) {
        this.mContext = context.getApplicationContext();
        this.mManager = (AudioManager) this.mContext.getSystemService("audio");
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.HEADSET_PLUG");
        filter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.mContext, this.mReceiver, filter);
    }

    public void addListener(IjkAudioKitCallback listener) {
        this.mListeners.add(listener);
    }

    public void removeListener(IjkAudioKitCallback listener) {
        this.mListeners.remove(listener);
    }

    public void removeAllListener() {
        this.mListeners.clear();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class HeadsetDetectReceiver extends BroadcastReceiver {
        public HeadsetDetectReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            char c;
            String action = intent.getAction();
            switch (action.hashCode()) {
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    BLog.i("IjkAudioKit", "ACTION_HEADSET_PLUG");
                    if (intent.hasExtra("state")) {
                        if (intent.getIntExtra("state", 0) == 0) {
                            IjkAudioKit.this.mWiredHeadphoneStatus = HeadphoneStatus.StatusOff;
                        } else {
                            IjkAudioKit.this.mWiredHeadphoneStatus = HeadphoneStatus.StatusOn;
                        }
                        Iterator it = IjkAudioKit.this.mListeners.iterator();
                        while (it.hasNext()) {
                            IjkAudioKitCallback listener = (IjkAudioKitCallback) it.next();
                            listener.onEndpointChange(IjkAudioKit.this.getEndpoint());
                        }
                        return;
                    }
                    return;
                case 1:
                    BLog.i("IjkAudioKit", "ACTION_CONNECTION_STATE_CHANGED");
                    if (intent.hasExtra("android.bluetooth.profile.extra.STATE")) {
                        if (intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 2) {
                            IjkAudioKit.this.mBluetoothHeadphoneStatus = HeadphoneStatus.StatusOn;
                        } else {
                            IjkAudioKit.this.mBluetoothHeadphoneStatus = HeadphoneStatus.StatusOff;
                        }
                        Iterator it2 = IjkAudioKit.this.mListeners.iterator();
                        while (it2.hasNext()) {
                            IjkAudioKitCallback listener2 = (IjkAudioKitCallback) it2.next();
                            listener2.onEndpointChange(IjkAudioKit.this.getEndpoint());
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}