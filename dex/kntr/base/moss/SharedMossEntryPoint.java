package kntr.base.moss;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.moss.platform.IPlatformMoss;
import kntr.base.moss.platform.IPlatformMossStreamBuilder;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: GripperMoss.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkntr/base/moss/SharedMossEntryPoint;", "", "<init>", "()V", "platformMoss", "Lkntr/base/moss/platform/IPlatformMoss;", "getPlatformMoss", "()Lkntr/base/moss/platform/IPlatformMoss;", "platformMoss$delegate", "Lkotlin/Lazy;", "platformMossStreamBuilder", "Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "getPlatformMossStreamBuilder", "()Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "platformMossStreamBuilder$delegate", "platformRoomServiceBuilder", "Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "getPlatformRoomServiceBuilder", "()Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "platformRoomServiceBuilder$delegate", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharedMossEntryPoint {
    public static final SharedMossEntryPoint INSTANCE = new SharedMossEntryPoint();
    private static final Lazy platformMoss$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.moss.SharedMossEntryPoint$$ExternalSyntheticLambda0
        public final Object invoke() {
            IPlatformMoss platformMoss_delegate$lambda$0;
            platformMoss_delegate$lambda$0 = SharedMossEntryPoint.platformMoss_delegate$lambda$0();
            return platformMoss_delegate$lambda$0;
        }
    });
    private static final Lazy platformMossStreamBuilder$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.moss.SharedMossEntryPoint$$ExternalSyntheticLambda1
        public final Object invoke() {
            IPlatformMossStreamBuilder platformMossStreamBuilder_delegate$lambda$0;
            platformMossStreamBuilder_delegate$lambda$0 = SharedMossEntryPoint.platformMossStreamBuilder_delegate$lambda$0();
            return platformMossStreamBuilder_delegate$lambda$0;
        }
    });
    private static final Lazy platformRoomServiceBuilder$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.moss.SharedMossEntryPoint$$ExternalSyntheticLambda2
        public final Object invoke() {
            IPlatformRoomServiceBuilder platformRoomServiceBuilder_delegate$lambda$0;
            platformRoomServiceBuilder_delegate$lambda$0 = SharedMossEntryPoint.platformRoomServiceBuilder_delegate$lambda$0();
            return platformRoomServiceBuilder_delegate$lambda$0;
        }
    });

    private SharedMossEntryPoint() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformMoss platformMoss_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((MossEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(MossEntryPoint.class))).getMoss();
    }

    public final IPlatformMoss getPlatformMoss() {
        return (IPlatformMoss) platformMoss$delegate.getValue();
    }

    public final IPlatformMossStreamBuilder getPlatformMossStreamBuilder() {
        return (IPlatformMossStreamBuilder) platformMossStreamBuilder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformMossStreamBuilder platformMossStreamBuilder_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((MossEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(MossEntryPoint.class))).getMossStreamBuilder();
    }

    public final IPlatformRoomServiceBuilder getPlatformRoomServiceBuilder() {
        return (IPlatformRoomServiceBuilder) platformRoomServiceBuilder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformRoomServiceBuilder platformRoomServiceBuilder_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((MossEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(MossEntryPoint.class))).getRoomServiceBuilder();
    }
}