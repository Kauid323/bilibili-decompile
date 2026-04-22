package tv.danmaku.bili.utils;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.util.GlobalNetworkController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NetworkController.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/NetworkController;", "", "<init>", "()V", "Companion", "NetworkControllerDelegate", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NetworkController {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String KEY_NETWORK_ALLOWED = "bili.network.allowed";
    private static NetworkControllerDelegate controller;

    /* compiled from: NetworkController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/utils/NetworkController$Companion;", "", "<init>", "()V", "KEY_NETWORK_ALLOWED", "", "setNetworkAllow", "", "newState", "", "initNetworkControllerState", "controller", "Ltv/danmaku/bili/utils/NetworkController$NetworkControllerDelegate;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setNetworkAllow(boolean newState) {
            NetworkControllerDelegate networkControllerDelegate = NetworkController.controller;
            if (networkControllerDelegate != null) {
                networkControllerDelegate.setNetworkAllow(newState);
            }
        }

        @JvmStatic
        public final void initNetworkControllerState() {
            NetworkController.controller = new NetworkControllerDelegate();
            GlobalNetworkController.Companion companion = GlobalNetworkController.Companion;
            NetworkControllerDelegate networkControllerDelegate = NetworkController.controller;
            Intrinsics.checkNotNull(networkControllerDelegate);
            companion.setControllerDelegate(networkControllerDelegate);
        }
    }

    @JvmStatic
    public static final void setNetworkAllow(boolean newState) {
        Companion.setNetworkAllow(newState);
    }

    @JvmStatic
    public static final void initNetworkControllerState() {
        Companion.initNetworkControllerState();
    }

    /* compiled from: NetworkController.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/utils/NetworkController$NetworkControllerDelegate;", "Lcom/bilibili/base/util/GlobalNetworkController$GlobalNetwrokControllerDelegate;", "<init>", "()V", "isNetworkAllowed", "", "setNetworkAllow", "", "newState", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NetworkControllerDelegate implements GlobalNetworkController.GlobalNetwrokControllerDelegate {
        public static final int $stable = 0;

        public boolean isNetworkAllowed() {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getBoolean(NetworkController.KEY_NETWORK_ALLOWED, false);
        }

        public final void setNetworkAllow(boolean newState) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putBoolean(NetworkController.KEY_NETWORK_ALLOWED, newState).commit();
            if (newState) {
                DelayInitHelper.Companion.triggerExecute();
            }
        }
    }
}