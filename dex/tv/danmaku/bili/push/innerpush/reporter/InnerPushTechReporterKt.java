package tv.danmaku.bili.push.innerpush.reporter;

import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushTechReporter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"reportInnerPushFilterShow", "", "reason", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushTechReporterKt {
    public static final void reportInnerPushFilterShow(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Neurons.trackT$default(false, "push.inner.filter.track", MapsKt.mapOf(TuplesKt.to("reason", reason)), 0, (Function0) null, 24, (Object) null);
    }
}