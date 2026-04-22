package video.interfacee.bridge.dolbyReporrt;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: KDolbyReport.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"KDolbyReport", "Lvideo/interfacee/bridge/dolbyReporrt/IDolbyReport;", "getKDolbyReport", "()Lvideo/interfacee/bridge/dolbyReporrt/IDolbyReport;", "dolbyReportBridge", "getDolbyReportBridge", "dolbyReportBridge$delegate", "Lkotlin/Lazy;", "bridge_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class KDolbyReportKt {
    private static final IDolbyReport KDolbyReport = new IDolbyReport() { // from class: video.interfacee.bridge.dolbyReporrt.KDolbyReportKt$KDolbyReport$1
        @Override // video.interfacee.bridge.dolbyReporrt.IDolbyReport
        public void report(long aid, long cid, int videoType) {
            KDolbyReportKt.getDolbyReportBridge().report(aid, cid, videoType);
        }
    };
    private static final Lazy dolbyReportBridge$delegate = LazyKt.lazy(new Function0() { // from class: video.interfacee.bridge.dolbyReporrt.KDolbyReportKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IDolbyReport dolbyReportBridge_delegate$lambda$0;
            dolbyReportBridge_delegate$lambda$0 = KDolbyReportKt.dolbyReportBridge_delegate$lambda$0();
            return dolbyReportBridge_delegate$lambda$0;
        }
    });

    public static final IDolbyReport getKDolbyReport() {
        return KDolbyReport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IDolbyReport dolbyReportBridge_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((DolbyReportEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DolbyReportEntryPoint.class))).getDolbyReport();
    }

    public static final IDolbyReport getDolbyReportBridge() {
        return (IDolbyReport) dolbyReportBridge$delegate.getValue();
    }
}