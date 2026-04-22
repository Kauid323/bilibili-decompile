package tv.danmaku.bili.ui.intent;

import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Reporter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0003¨\u0006\t"}, d2 = {"doAwakeReport", "", "originUrl", "", "aiUrl", "target", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/intent/Phase;", "result", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReporterKt {
    public static final void doAwakeReport(String originUrl, String aiUrl, Pair<String, ? extends Phase> pair, String result) {
        Intrinsics.checkNotNullParameter(pair, "target");
        Neurons.trackT$default(true, "public.launcher.wake.up.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("originUrl", originUrl), TuplesKt.to("url", aiUrl), TuplesKt.to("finalUrl", pair.getFirst()), TuplesKt.to("phase", String.valueOf(((Phase) pair.getSecond()).getValue())), TuplesKt.to("result", result)}), 0, new Function0() { // from class: tv.danmaku.bili.ui.intent.ReporterKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean doAwakeReport$lambda$0;
                doAwakeReport$lambda$0 = ReporterKt.doAwakeReport$lambda$0();
                return Boolean.valueOf(doAwakeReport$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean doAwakeReport$lambda$0() {
        return true;
    }
}