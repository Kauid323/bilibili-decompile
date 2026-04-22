package tv.danmaku.bili.report.platform.neuron;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;

/* compiled from: MisakaApmNeuron.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "sRate", "", "report", "", "data", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaApmNeuronKt {
    private static final String TAG = "misaka.apm.neuron";
    private static final int sRate = OnlineParamsHelper.getMisakaApmDateSampleRate();

    @Deprecated(message = "Report by OkHttp event listener.")
    public static final void report(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
    }
}