package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GMossResponseHandler;
import com.bilibili.gripper.api.moss.GRoomService;
import com.bilibili.gripper.api.moss.GRoomServiceBuilder;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kntr.base.moss.platform.IPlatformRoomService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KRoomService.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/base/moss/epoch/impl/PlatformRoomService;", "Lkntr/base/moss/platform/IPlatformRoomService;", "real", "Lcom/bilibili/gripper/api/moss/GRoomService;", "<init>", "(Lcom/bilibili/gripper/api/moss/GRoomService;)V", "start", "", "stop", "register", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "respHandler", "Companion", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlatformRoomService implements IPlatformRoomService {
    public static final Companion Companion = new Companion(null);
    private static final PlatformRoomService shared;
    private final GRoomService real;

    public PlatformRoomService(GRoomService real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.real = real;
    }

    /* compiled from: KRoomService.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/moss/epoch/impl/PlatformRoomService$Companion;", "", "<init>", "()V", "shared", "Lkntr/base/moss/epoch/impl/PlatformRoomService;", "getShared", "()Lkntr/base/moss/epoch/impl/PlatformRoomService;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformRoomService getShared() {
            return PlatformRoomService.shared;
        }
    }

    static {
        GRoomServiceBuilder gRoomServiceBuilder;
        gRoomServiceBuilder = KRoomService_androidKt.builder;
        shared = new PlatformRoomService(gRoomServiceBuilder.getShared());
    }

    @Override // kntr.base.moss.platform.IPlatformRoomService
    public void start() {
        this.real.start();
    }

    @Override // kntr.base.moss.platform.IPlatformRoomService
    public void stop() {
        this.real.stop();
    }

    @Override // kntr.base.moss.platform.IPlatformRoomService
    public IPlatformResponseHandler register(IPlatformResponseHandler respHandler) {
        GMossResponseHandler reqHandler = this.real.register(new RoomRespHandlerAdapter(respHandler));
        return reqHandler != null ? new RoomReqHandlerAdapter(reqHandler) : null;
    }
}