package tv.danmaku.bili.report.umeng;

import com.bilibili.homepage.UmengDeviceInfoService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import kotlin.Metadata;
import okhttp3.Request;
import tv.danmaku.bili.BR;

/* compiled from: UmengRequestInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/report/umeng/UmengRequestInterceptor;", "Lcom/bilibili/okretro/interceptor/DefaultRequestInterceptor;", "<init>", "()V", "addHeader", "", "builder", "Lokhttp3/Request$Builder;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UmengRequestInterceptor extends DefaultRequestInterceptor {
    public static final int $stable = 8;

    protected void addHeader(Request.Builder builder) {
        super.addHeader(builder);
        if (builder != null) {
            UmengDeviceInfoService umengDeviceInfoService = (UmengDeviceInfoService) BLRouter.get$default(BLRouter.INSTANCE, UmengDeviceInfoService.class, (String) null, 2, (Object) null);
            builder.addHeader("DeviceInfo", (umengDeviceInfoService == null || (r0 = umengDeviceInfoService.getDeviceInfo()) == null) ? "" : "");
        }
    }
}