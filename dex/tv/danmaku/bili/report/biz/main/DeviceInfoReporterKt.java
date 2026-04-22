package tv.danmaku.bili.report.biz.main;

import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.DeviceUtil;
import tv.danmaku.bili.BR;

/* compiled from: DeviceInfoReporter.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"reportInfo", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeviceInfoReporterKt {
    public static final void reportInfo() {
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.report.biz.main.DeviceInfoReporterKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceInfoReporterKt.reportInfo$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportInfo$lambda$0() {
        Map deviceInfo = DeviceUtil.getDeviceInfo(BiliContext.application());
        Intrinsics.checkNotNull(deviceInfo);
        Neurons.trackT(false, "public.device.info.track", deviceInfo, 1, new Function0() { // from class: tv.danmaku.bili.report.biz.main.DeviceInfoReporterKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean reportInfo$lambda$0$0;
                reportInfo$lambda$0$0 = DeviceInfoReporterKt.reportInfo$lambda$0$0();
                return Boolean.valueOf(reportInfo$lambda$0$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportInfo$lambda$0$0() {
        return true;
    }
}