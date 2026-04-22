package video.interfacee.bridge.ogv;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: KOGVBridge.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"KOGVBridge", "Lvideo/interfacee/bridge/ogv/IOGVBridge;", "getKOGVBridge", "()Lvideo/interfacee/bridge/ogv/IOGVBridge;", "ogvBridge", "getOgvBridge", "ogvBridge$delegate", "Lkotlin/Lazy;", "bridge_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class KOGVBridgeKt {
    private static final IOGVBridge KOGVBridge = new IOGVBridge() { // from class: video.interfacee.bridge.ogv.KOGVBridgeKt$KOGVBridge$1
        @Override // video.interfacee.bridge.ogv.IOGVBridge
        public boolean hasReserve() {
            return KOGVBridgeKt.getOgvBridge().hasReserve();
        }
    };
    private static final Lazy ogvBridge$delegate = LazyKt.lazy(new Function0() { // from class: video.interfacee.bridge.ogv.KOGVBridgeKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IOGVBridge ogvBridge_delegate$lambda$0;
            ogvBridge_delegate$lambda$0 = KOGVBridgeKt.ogvBridge_delegate$lambda$0();
            return ogvBridge_delegate$lambda$0;
        }
    });

    public static final IOGVBridge getKOGVBridge() {
        return KOGVBridge;
    }

    public static final IOGVBridge getOgvBridge() {
        return (IOGVBridge) ogvBridge$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IOGVBridge ogvBridge_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((OGVBridgeEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(OGVBridgeEntryPoint.class))).getOgvBridge();
    }
}