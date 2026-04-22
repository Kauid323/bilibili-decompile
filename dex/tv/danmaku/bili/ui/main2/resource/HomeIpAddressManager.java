package tv.danmaku.bili.ui.main2.resource;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: HomeIpAddressManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/HomeIpAddressManager;", "", "<init>", "()V", "TAG", "", "initialized", "", "fetching", "ipInfo", "Ltv/danmaku/bili/ui/main2/resource/IpAddressInfo;", "ipKv", "Lcom/bilibili/lib/blkv/RawKV;", "initIp", "", "fetchIpInfo", "isInHkMoTw", "isOverseas", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeIpAddressManager {
    private static final String TAG = "HomeIpAddressManager";
    private static volatile boolean fetching;
    private static volatile boolean initialized;
    private static volatile IpAddressInfo ipInfo;
    private static RawKV ipKv;
    public static final HomeIpAddressManager INSTANCE = new HomeIpAddressManager();
    public static final int $stable = 8;

    private HomeIpAddressManager() {
    }

    public final void initIp() {
        if (initialized || fetching || ipInfo != null) {
            return;
        }
        if (ipKv == null) {
            Application application = BiliContext.application();
            ipKv = application != null ? BLKV.getKvs$default(application, "network_msg", true, 0, 4, (Object) null) : null;
        }
        fetchIpInfo();
    }

    private final void fetchIpInfo() {
        fetching = true;
        BiliCall<GeneralResponse<IpAddressInfo>> ipLocationInfo = ((IpLocationApi) ServiceGenerator.createService(IpLocationApi.class)).getIpLocationInfo();
        if (ipLocationInfo != null) {
            ipLocationInfo.enqueue(new Callback<GeneralResponse<IpAddressInfo>>() { // from class: tv.danmaku.bili.ui.main2.resource.HomeIpAddressManager$fetchIpInfo$1
                /* JADX WARN: Code restructure failed: missing block: B:13:0x006d, code lost:
                    r2 = tv.danmaku.bili.ui.main2.resource.HomeIpAddressManager.ipKv;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(Call<GeneralResponse<IpAddressInfo>> call, Response<GeneralResponse<IpAddressInfo>> response) {
                    boolean isOverseas;
                    RawKV rawKV;
                    RawKV rawKV2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    HomeIpAddressManager homeIpAddressManager = HomeIpAddressManager.INSTANCE;
                    HomeIpAddressManager.initialized = true;
                    HomeIpAddressManager homeIpAddressManager2 = HomeIpAddressManager.INSTANCE;
                    HomeIpAddressManager.fetching = false;
                    GeneralResponse generalResponse = (GeneralResponse) response.body();
                    IpAddressInfo data = generalResponse != null ? (IpAddressInfo) generalResponse.data : null;
                    if (response.isSuccessful() && data != null) {
                        HomeIpAddressManager homeIpAddressManager3 = HomeIpAddressManager.INSTANCE;
                        HomeIpAddressManager.ipInfo = data;
                        BLog.i("HomeIpAddressManager", "fetchIpInfo succeed " + HomeIpAddressManager.INSTANCE.isInHkMoTw() + " " + data);
                        isOverseas = HomeIpAddressManager.INSTANCE.isOverseas();
                        rawKV = HomeIpAddressManager.ipKv;
                        if (rawKV != null) {
                            rawKV.putBoolean("is_oversea", isOverseas);
                        }
                        if (!isOverseas || rawKV2 == null) {
                            return;
                        }
                        rawKV2.putLong("oversea_ts", System.currentTimeMillis());
                        return;
                    }
                    BLog.i("HomeIpAddressManager", "fetchIpInfo failed");
                }

                public void onFailure(Call<GeneralResponse<IpAddressInfo>> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    HomeIpAddressManager homeIpAddressManager = HomeIpAddressManager.INSTANCE;
                    HomeIpAddressManager.initialized = true;
                    HomeIpAddressManager homeIpAddressManager2 = HomeIpAddressManager.INSTANCE;
                    HomeIpAddressManager.fetching = false;
                    BLog.i("HomeIpAddressManager", "fetchIpInfo failed", t);
                }
            });
        }
    }

    public final boolean isInHkMoTw() {
        IpAddressInfo ipAddressInfo = ipInfo;
        if (ipAddressInfo != null) {
            return ipAddressInfo.isInHkMoTw();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOverseas() {
        IpAddressInfo ipAddressInfo = ipInfo;
        if (ipAddressInfo != null) {
            return ipAddressInfo.isOverseas();
        }
        return false;
    }
}