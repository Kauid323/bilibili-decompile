package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GRoomService;
import com.bilibili.gripper.api.moss.GRoomServiceBuilder;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMossStream;
import kntr.base.moss.platform.IPlatformRoomService;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KRoomService.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"builder", "Lcom/bilibili/gripper/api/moss/GRoomServiceBuilder;", "platformRoomServiceBuilder", "Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "getPlatformRoomServiceBuilder", "()Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KRoomService_androidKt {
    private static final GRoomServiceBuilder builder;
    private static final IPlatformRoomServiceBuilder platformRoomServiceBuilder;

    static {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GRoomServiceBuilder.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        builder = (GRoomServiceBuilder) suspendProducer.get();
        platformRoomServiceBuilder = new IPlatformRoomServiceBuilder() { // from class: kntr.base.moss.epoch.impl.KRoomService_androidKt$platformRoomServiceBuilder$1
            @Override // kntr.base.moss.platform.IPlatformRoomServiceBuilder
            public IPlatformRoomService build(IPlatformMossStream stream) {
                GRoomServiceBuilder gRoomServiceBuilder;
                Intrinsics.checkNotNullParameter(stream, "stream");
                PlatformMossStream ms = (PlatformMossStream) stream;
                gRoomServiceBuilder = KRoomService_androidKt.builder;
                GRoomService real = gRoomServiceBuilder.build(ms.getReal$moss_debug());
                return new PlatformRoomService(real);
            }

            @Override // kntr.base.moss.platform.IPlatformRoomServiceBuilder
            public IPlatformRoomService getShared() {
                return PlatformRoomService.Companion.getShared();
            }
        };
    }

    public static final IPlatformRoomServiceBuilder getPlatformRoomServiceBuilder() {
        return platformRoomServiceBuilder;
    }
}