package tv.danmaku.bili.ui.garb.digital.lockcard;

import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: DigitalCommonParamToUrlRequestInterceptor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/DigitalCommonParamToUrlRequestInterceptor;", "Lcom/bilibili/okretro/interceptor/DefaultRequestInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Request;", "origin", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCommonParamToUrlRequestInterceptor extends DefaultRequestInterceptor {
    public static final int $stable = 8;

    public Request intercept(Request origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Request request = super.intercept(origin);
        Request.Builder requestBuilder = request.newBuilder();
        if (!Intrinsics.areEqual("GET", origin.method())) {
            addCommonParamToUrl(origin.url(), requestBuilder);
        }
        Request build = requestBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}