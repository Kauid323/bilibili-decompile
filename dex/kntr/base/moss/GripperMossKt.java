package kntr.base.moss;

import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMossServiceKt;
import kntr.base.moss.api.KMossStreamKt;
import kntr.base.moss.api.KRoomServiceKt;
import kntr.base.moss.platform.IPlatformMoss;
import kntr.base.moss.platform.IPlatformMossStreamBuilder;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GripperMoss.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"initKmoss", "", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GripperMossKt {
    @PreTrigger(awaitComplete = true, trigger = "OnCreate")
    public static final void initKmoss() {
        KMossServiceKt.setKMossServiceImpl(new Function0() { // from class: kntr.base.moss.GripperMossKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                IPlatformMoss initKmoss$lambda$0;
                initKmoss$lambda$0 = GripperMossKt.initKmoss$lambda$0();
                return initKmoss$lambda$0;
            }
        });
        KMossStreamKt.setKMossStreamBuilder(new Function0() { // from class: kntr.base.moss.GripperMossKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                IPlatformMossStreamBuilder initKmoss$lambda$1;
                initKmoss$lambda$1 = GripperMossKt.initKmoss$lambda$1();
                return initKmoss$lambda$1;
            }
        });
        KRoomServiceKt.setKRoomServiceBuilder(new Function0() { // from class: kntr.base.moss.GripperMossKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                IPlatformRoomServiceBuilder initKmoss$lambda$2;
                initKmoss$lambda$2 = GripperMossKt.initKmoss$lambda$2();
                return initKmoss$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformMoss initKmoss$lambda$0() {
        return SharedMossEntryPoint.INSTANCE.getPlatformMoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformMossStreamBuilder initKmoss$lambda$1() {
        return SharedMossEntryPoint.INSTANCE.getPlatformMossStreamBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlatformRoomServiceBuilder initKmoss$lambda$2() {
        return SharedMossEntryPoint.INSTANCE.getPlatformRoomServiceBuilder();
    }
}