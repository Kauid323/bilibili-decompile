package video.interfacee.bridge.freeBandwidth;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: KFreeBandwidth.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"KFreeBandwidth", "Lvideo/interfacee/bridge/freeBandwidth/IFreeBandwidth;", "getKFreeBandwidth", "()Lvideo/interfacee/bridge/freeBandwidth/IFreeBandwidth;", "freeBandwidthBridge", "getFreeBandwidthBridge", "freeBandwidthBridge$delegate", "Lkotlin/Lazy;", "bridge_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class KFreeBandwidthKt {
    private static final IFreeBandwidth KFreeBandwidth = new IFreeBandwidth() { // from class: video.interfacee.bridge.freeBandwidth.KFreeBandwidthKt$KFreeBandwidth$1
        @Override // video.interfacee.bridge.freeBandwidth.IFreeBandwidth
        public boolean isFreeBandwidthActive() {
            return KFreeBandwidthKt.getFreeBandwidthBridge().isFreeBandwidthActive();
        }

        @Override // video.interfacee.bridge.freeBandwidth.IFreeBandwidth
        public BandwidthResult transformUrl(String url, boolean isVideo, String httpMethod) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
            return KFreeBandwidthKt.getFreeBandwidthBridge().transformUrl(url, isVideo, httpMethod);
        }
    };
    private static final Lazy freeBandwidthBridge$delegate = LazyKt.lazy(new Function0() { // from class: video.interfacee.bridge.freeBandwidth.KFreeBandwidthKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IFreeBandwidth freeBandwidthBridge_delegate$lambda$0;
            freeBandwidthBridge_delegate$lambda$0 = KFreeBandwidthKt.freeBandwidthBridge_delegate$lambda$0();
            return freeBandwidthBridge_delegate$lambda$0;
        }
    });

    public static final IFreeBandwidth getKFreeBandwidth() {
        return KFreeBandwidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFreeBandwidth freeBandwidthBridge_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((FreeBandwidthEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(FreeBandwidthEntryPoint.class))).getFreeBandwidth();
    }

    public static final IFreeBandwidth getFreeBandwidthBridge() {
        return (IFreeBandwidth) freeBandwidthBridge$delegate.getValue();
    }
}