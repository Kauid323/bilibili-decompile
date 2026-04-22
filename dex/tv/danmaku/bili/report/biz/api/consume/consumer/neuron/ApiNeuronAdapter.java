package tv.danmaku.bili.report.biz.api.consume.consumer.neuron;

import com.bilibili.lib.rpc.track.model.NetworkEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.EventsKt;

/* compiled from: ApiNeuronAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/neuron/ApiNeuronAdapter;", "", "<init>", "()V", "KEY_TOTAL_TIME", "", "KEY_RESPCODE", "KEY_MSG", "KEY_REQUEST", "KEY_X_CACHE", "adapt", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ApiNeuronAdapter {
    public static final ApiNeuronAdapter INSTANCE = new ApiNeuronAdapter();
    private static final String KEY_MSG = "msg";
    private static final String KEY_REQUEST = "request";
    private static final String KEY_RESPCODE = "respcode";
    private static final String KEY_TOTAL_TIME = "total_time";
    private static final String KEY_X_CACHE = "x_cache";

    private ApiNeuronAdapter() {
    }

    public final Map<String, String> adapt(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(KEY_TOTAL_TIME, String.valueOf(event.getTotalTime())), TuplesKt.to("respcode", String.valueOf(event.getHttpCode())), TuplesKt.to("msg", EventsKt.getHttpMessage(event)), TuplesKt.to(KEY_REQUEST, event.getUrl()), TuplesKt.to(KEY_X_CACHE, event.getHeader().getXcache())});
    }
}