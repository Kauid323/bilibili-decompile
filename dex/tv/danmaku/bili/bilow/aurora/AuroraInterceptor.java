package tv.danmaku.bili.bilow.aurora;

import com.bilibili.lib.okhttp.track.tag.RpcTag;
import com.bilibili.lib.okhttp.track.tag.RpcTagKt;
import com.bilibili.lib.okhttp.track.utils.TagUtilsKt;
import com.bilibili.lib.rpc.track.model.RpcExtra;
import com.bilibili.lib.rpc.track.model.RpcSample;
import com.bilibili.lib.rpc.track.model.Tunnel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestTag;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.aurora.api.ids.AuroraIds;
import tv.danmaku.bili.aurora.api.trace.XTrace;
import tv.danmaku.bili.aurora.api.zone.AuroraZone;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: AuroraInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/bilow/aurora/AuroraInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuroraInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String host = request.url().host();
        String path = request.url().encodedPath();
        AuroraZone auroraZone = AuroraZone.INSTANCE;
        Intrinsics.checkNotNull(host);
        Intrinsics.checkNotNull(path);
        String zone = auroraZone.onAuroraReq(host, path);
        RpcTag rpcTag = TagUtilsKt.getRpcTag(request.tag());
        RpcExtra extra = rpcTag != null ? rpcTag.getExtra() : null;
        if (extra == null) {
            extra = new RpcExtra(Tunnel.OKHTTP, (String) null, false, false, (RpcSample) null, (String) null, (String) null, XTrace.INSTANCE.id(), (String) null, (int) BR.needShowTitle, (DefaultConstructorMarker) null);
            Object tag = request.tag();
            RequestTag requestTag = tag instanceof RequestTag ? (RequestTag) tag : null;
            if (requestTag != null) {
                RpcTagKt.attachRpcTag(requestTag, new RpcTag(extra));
            }
            Object tag2 = chain.call().request().tag();
            RequestTag requestTag2 = tag2 instanceof RequestTag ? (RequestTag) tag2 : null;
            if (requestTag2 != null) {
                RpcTagKt.attachRpcTag(requestTag2, new RpcTag(extra));
            }
        }
        extra.setZone(zone);
        Response proceed = chain.proceed(request.newBuilder().header("x-bili-trace-id", extra.getXtraceId()).header("x-bili-aurora-eid", AuroraIds.INSTANCE.eid()).header("x-bili-mid", AuroraIds.INSTANCE.mid()).header("x-bili-aurora-zone", extra.getZone()).build());
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }
}