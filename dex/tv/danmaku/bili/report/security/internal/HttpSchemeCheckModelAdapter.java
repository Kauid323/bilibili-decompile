package tv.danmaku.bili.report.security.internal;

import android.app.Activity;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: HttpSchemeCheckModelAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/report/security/internal/HttpSchemeCheckModelAdapter;", "", "<init>", "()V", "adapt", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "rate", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HttpSchemeCheckModelAdapter {
    public static final int $stable = 0;
    public static final HttpSchemeCheckModelAdapter INSTANCE = new HttpSchemeCheckModelAdapter();

    private HttpSchemeCheckModelAdapter() {
    }

    public final Map<String, String> adapt(NetworkEvent event, float rate) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(event, "event");
        Pair[] pairArr = new Pair[8];
        Activity activity = BiliContext.topActivitiy();
        pairArr[0] = TuplesKt.to("top_activity", (activity == null || (cls = activity.getClass()) == null || (r1 = cls.getName()) == null) ? "" : "");
        pairArr[1] = TuplesKt.to("real_scheme", event.getRealScheme());
        pairArr[2] = TuplesKt.to("real_host", event.getRealHost());
        pairArr[3] = TuplesKt.to("real_url", event.getRealUrl());
        pairArr[4] = TuplesKt.to("scheme", event.getScheme());
        pairArr[5] = TuplesKt.to(ReportEvent.Tag.HOST, event.getHost());
        pairArr[6] = TuplesKt.to("url", event.getUrl());
        pairArr[7] = TuplesKt.to("rate", String.valueOf(rate));
        return MapsKt.mapOf(pairArr);
    }
}