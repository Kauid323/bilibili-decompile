package tv.danmaku.bili.overseas.internal;

import android.app.Application;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.preferences.fragment.PrefProvider;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.BiliAuthActivity;
import tv.danmaku.bili.overseas.internal.httpdns.AppHttpDnsKt;
import tv.danmaku.bili.report.InfoEyesOperatingDataPublicQueryString;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: NetChange.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/overseas/internal/NetChange;", "Lcom/bilibili/base/connectivity/ConnectivityMonitor$OnNetworkChangedListener;", "<init>", "()V", "canRequestGoogle", "", "canRequestLocation", "prefs", "Lcom/bilibili/lib/blkv/RawKV;", "setSp", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "sp", "", "init", "app", "Landroid/app/Application;", "onChanged", InfoEyesOperatingDataPublicQueryString.KEY_NET, "", "checkCanRequestGoogle", "requestGoogle", "checkCanLocation", "requestLocation", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetChange implements ConnectivityMonitor.OnNetworkChangedListener {
    private boolean canRequestGoogle;
    private boolean canRequestLocation;
    private RawKV prefs;
    private Function1<? super String, Unit> setSp;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<NetChange> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda1
        public final Object invoke() {
            NetChange instance_delegate$lambda$0;
            instance_delegate$lambda$0 = NetChange.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });

    public /* synthetic */ void onChanged(int i, int i2, NetworkInfo networkInfo) {
        ConnectivityMonitor.OnNetworkChangedListener.-CC.$default$onChanged(this, i, i2, networkInfo);
    }

    public NetChange() {
        this.canRequestGoogle = DnsProviderConfig.INSTANCE.getGoogleCD() >= 0;
        this.canRequestLocation = DnsProviderConfig.INSTANCE.getLocationCD() >= 0;
        this.setSp = new Function1() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit sp$lambda$0;
                sp$lambda$0 = NetChange.setSp$lambda$0((String) obj);
                return sp$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSp$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void init(Application app, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(function1, "setSp");
        this.setSp = function1;
        this.prefs = BLKV.getKvs(app, "network_msg", true, (int) MisakaHelper.MAX_REPORT_SIZE);
        RawKV rawKV = this.prefs;
        if (rawKV == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            rawKV = null;
        }
        boolean netAutoSelected = rawKV.getBoolean("net_auto_selected", true);
        if (netAutoSelected && DnsProviderConfig.INSTANCE.getTotalSwitcher() && !DnsProviderConfig.INSTANCE.getNetSwitchDisable()) {
            ConnectivityMonitor.getInstance().unregister(this);
            ConnectivityMonitor.getInstance().register(this);
        }
        if (netAutoSelected && DnsProviderConfig.INSTANCE.getTotalSwitcher()) {
            checkCanRequestGoogle();
        } else {
            AppHttpDnsKt.setRuntimeProvier(PrefProvider.MAINLAND, function1);
        }
    }

    /* compiled from: NetChange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/overseas/internal/NetChange$Companion;", "", "<init>", "()V", "instance", "Ltv/danmaku/bili/overseas/internal/NetChange;", "getInstance", "()Ltv/danmaku/bili/overseas/internal/NetChange;", "instance$delegate", "Lkotlin/Lazy;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetChange getInstance() {
            return (NetChange) NetChange.instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetChange instance_delegate$lambda$0() {
        return new NetChange();
    }

    public void onChanged(int net) {
        switch (net) {
            case 1:
            case 2:
            case 5:
                checkCanRequestGoogle();
                return;
            case 3:
            case 4:
            default:
                return;
        }
    }

    private final void checkCanRequestGoogle() {
        if (this.canRequestGoogle) {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    NetChange.checkCanRequestGoogle$lambda$0(NetChange.this);
                }
            });
            requestGoogle();
            return;
        }
        checkCanLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.bili.overseas.internal.NetChange$checkCanRequestGoogle$1$1] */
    public static final void checkCanRequestGoogle$lambda$0(final NetChange this$0) {
        final long googleCD = DnsProviderConfig.INSTANCE.getGoogleCD();
        ?? r2 = new CountDownTimer(googleCD) { // from class: tv.danmaku.bili.overseas.internal.NetChange$checkCanRequestGoogle$1$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                NetChange.this.canRequestGoogle = true;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long left) {
            }
        };
        BLog.i(NetChangeKt.TAG, "request google cd " + DnsProviderConfig.INSTANCE.getGoogleCD() + " s");
        r2.start();
        this$0.canRequestGoogle = false;
    }

    private final void requestGoogle() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit requestGoogle$lambda$0;
                requestGoogle$lambda$0 = NetChange.requestGoogle$lambda$0(NetChange.this);
                return requestGoogle$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda6
            public final Object then(Task task) {
                Unit requestGoogle$lambda$1;
                requestGoogle$lambda$1 = NetChange.requestGoogle$lambda$1(task);
                return requestGoogle$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGoogle$lambda$0(NetChange this$0) {
        URL url = new URL("https://dns.google/resolve?name=app.bilibili.com");
        URLConnection openConnection = url.openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection conn = (HttpURLConnection) openConnection;
        conn.setConnectTimeout(BiliAuthActivity.PERMISSION_REQUEST_CODE);
        conn.setReadTimeout(BiliAuthActivity.PERMISSION_REQUEST_CODE);
        try {
            try {
                int code = conn.getResponseCode();
                if (code == 200) {
                    this$0.checkCanLocation();
                    BLog.i(NetChangeKt.TAG, "requestGoogle succeed: 200");
                } else {
                    AppHttpDnsKt.setRuntimeProvier(PrefProvider.MAINLAND, this$0.setSp);
                }
            } catch (IOException e) {
                AppHttpDnsKt.setRuntimeProvier(PrefProvider.MAINLAND, this$0.setSp);
            }
            conn.disconnect();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            conn.disconnect();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGoogle$lambda$1(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        BLog.e(NetChangeKt.TAG, "msg> " + task.getError().getMessage());
        return Unit.INSTANCE;
    }

    private final void checkCanLocation() {
        if (this.canRequestLocation) {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    NetChange.checkCanLocation$lambda$0(NetChange.this);
                }
            });
            requestLocation();
            return;
        }
        AppHttpDnsKt.setRuntimeProvier(PrefProvider.MAINLAND, this.setSp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.bili.overseas.internal.NetChange$checkCanLocation$1$1] */
    public static final void checkCanLocation$lambda$0(final NetChange this$0) {
        final long locationCD = DnsProviderConfig.INSTANCE.getLocationCD();
        ?? r2 = new CountDownTimer(locationCD) { // from class: tv.danmaku.bili.overseas.internal.NetChange$checkCanLocation$1$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                NetChange.this.canRequestLocation = true;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long left) {
            }
        };
        BLog.i(NetChangeKt.TAG, "request location cd " + DnsProviderConfig.INSTANCE.getLocationCD() + " s");
        this$0.canRequestLocation = false;
        r2.start();
    }

    private final void requestLocation() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object requestLocation$lambda$0;
                requestLocation$lambda$0 = NetChange.requestLocation$lambda$0(NetChange.this);
                return requestLocation$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.overseas.internal.NetChange$$ExternalSyntheticLambda4
            public final Object then(Task task) {
                Unit requestLocation$lambda$1;
                requestLocation$lambda$1 = NetChange.requestLocation$lambda$1(task);
                return requestLocation$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestLocation$lambda$0(final NetChange this$0) {
        BiliCall<GeneralResponse<IpAddressInfo>> ipLocationInfo = ((IpLocationApi) ServiceGenerator.createService(IpLocationApi.class)).getIpLocationInfo();
        if (ipLocationInfo != null) {
            ipLocationInfo.enqueue(new Callback<GeneralResponse<IpAddressInfo>>() { // from class: tv.danmaku.bili.overseas.internal.NetChange$requestLocation$1$1
                public void onResponse(Call<GeneralResponse<IpAddressInfo>> call, Response<GeneralResponse<IpAddressInfo>> response) {
                    Function1 function1;
                    PrefProvider provider;
                    Function1 function12;
                    RawKV rawKV;
                    Integer countryCode;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    GeneralResponse generalResponse = (GeneralResponse) response.body();
                    RawKV rawKV2 = null;
                    IpAddressInfo data = generalResponse != null ? (IpAddressInfo) generalResponse.data : null;
                    if (response.isSuccessful() && data != null) {
                        boolean isOversea = data.getCountryCode() != null && ((countryCode = data.getCountryCode()) == null || countryCode.intValue() != 86);
                        if (isOversea) {
                            rawKV = NetChange.this.prefs;
                            if (rawKV == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            } else {
                                rawKV2 = rawKV;
                            }
                            rawKV2.putLong("oversea_ts", System.currentTimeMillis());
                            provider = PrefProvider.OVERSEAS;
                        } else {
                            provider = PrefProvider.MAINLAND;
                        }
                        BLog.i(NetChangeKt.TAG, "fetchIpInfo succeed: " + data);
                        function12 = NetChange.this.setSp;
                        AppHttpDnsKt.setRuntimeProvier(provider, function12);
                        return;
                    }
                    BLog.i(NetChangeKt.TAG, "fetchIpInfo failed");
                    PrefProvider prefProvider = PrefProvider.MAINLAND;
                    function1 = NetChange.this.setSp;
                    AppHttpDnsKt.setRuntimeProvier(prefProvider, function1);
                }

                public void onFailure(Call<GeneralResponse<IpAddressInfo>> call, Throwable t) {
                    Function1 function1;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    BLog.i(NetChangeKt.TAG, "fetchIpInfo failed", t);
                    PrefProvider prefProvider = PrefProvider.MAINLAND;
                    function1 = NetChange.this.setSp;
                    AppHttpDnsKt.setRuntimeProvier(prefProvider, function1);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestLocation$lambda$1(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        BLog.e(NetChangeKt.TAG, "msg> " + task.getError().getMessage());
        return Unit.INSTANCE;
    }
}