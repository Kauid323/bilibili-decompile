package tv.danmaku.bili.bilow.flowcontrol;

import com.bilibili.api.FlowControlException;
import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: FlowControlInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/bilow/flowcontrol/FlowControlInterceptor;", "Lokhttp3/Interceptor;", "flowControl", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "<init>", "(Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;)V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FlowControlInterceptor implements Interceptor {
    private final FlowControl flowControl;

    public FlowControlInterceptor(FlowControl flowControl) {
        Intrinsics.checkNotNullParameter(flowControl, "flowControl");
        this.flowControl = flowControl;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl url = request.url();
        String host = url.host();
        String path = url.encodedPath();
        FlowControl flowControl = this.flowControl;
        Intrinsics.checkNotNull(host);
        Intrinsics.checkNotNull(path);
        if (flowControl.onRequest(host, path)) {
            throw new FlowControlException();
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }
}