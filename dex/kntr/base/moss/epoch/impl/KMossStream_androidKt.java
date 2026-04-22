package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GMossStreamServiceBuilder;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMossStream;
import kntr.base.moss.platform.IPlatformMossStreamBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossStream.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"builder", "Lcom/bilibili/gripper/api/moss/GMossStreamServiceBuilder;", "platformMossStreamBuilder", "Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "getPlatformMossStreamBuilder", "()Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossStream_androidKt {
    private static final GMossStreamServiceBuilder builder;
    private static final IPlatformMossStreamBuilder platformMossStreamBuilder;

    static {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GMossStreamServiceBuilder.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        builder = (GMossStreamServiceBuilder) suspendProducer.get();
        platformMossStreamBuilder = new IPlatformMossStreamBuilder() { // from class: kntr.base.moss.epoch.impl.KMossStream_androidKt$platformMossStreamBuilder$1
            @Override // kntr.base.moss.platform.IPlatformMossStreamBuilder
            public IPlatformMossStream build(boolean hp, String tag, String host, int port) {
                GMossStreamServiceBuilder gMossStreamServiceBuilder;
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(host, "host");
                gMossStreamServiceBuilder = KMossStream_androidKt.builder;
                return new PlatformMossStream(gMossStreamServiceBuilder.build(hp, tag, host, port));
            }

            @Override // kntr.base.moss.platform.IPlatformMossStreamBuilder
            public IPlatformMossStream getShared() {
                return PlatformMossStream.Companion.getShared();
            }
        };
    }

    public static final IPlatformMossStreamBuilder getPlatformMossStreamBuilder() {
        return platformMossStreamBuilder;
    }
}