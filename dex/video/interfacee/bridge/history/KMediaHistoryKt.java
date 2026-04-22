package video.interfacee.bridge.history;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: KMediaHistory.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"KMediaHistory", "Lvideo/interfacee/bridge/history/IMediaHistory;", "getKMediaHistory", "()Lvideo/interfacee/bridge/history/IMediaHistory;", "historyBridge", "getHistoryBridge", "historyBridge$delegate", "Lkotlin/Lazy;", "bridge_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class KMediaHistoryKt {
    private static final IMediaHistory KMediaHistory = new IMediaHistory() { // from class: video.interfacee.bridge.history.KMediaHistoryKt$KMediaHistory$1
        @Override // video.interfacee.bridge.history.IMediaHistory
        public long read(long cid) {
            return KMediaHistoryKt.getHistoryBridge().read(cid);
        }
    };
    private static final Lazy historyBridge$delegate = LazyKt.lazy(new Function0() { // from class: video.interfacee.bridge.history.KMediaHistoryKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IMediaHistory historyBridge_delegate$lambda$0;
            historyBridge_delegate$lambda$0 = KMediaHistoryKt.historyBridge_delegate$lambda$0();
            return historyBridge_delegate$lambda$0;
        }
    });

    public static final IMediaHistory getKMediaHistory() {
        return KMediaHistory;
    }

    public static final IMediaHistory getHistoryBridge() {
        return (IMediaHistory) historyBridge$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMediaHistory historyBridge_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((MediaHistoryEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(MediaHistoryEntryPoint.class))).getMediaHistory();
    }
}