package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kntr.base.moss.platform.IPlatformRoomService;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KRoomService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/base/moss/api/KRoomService;", "", "real", "Lkntr/base/moss/platform/IPlatformRoomService;", "<init>", "(Lkntr/base/moss/platform/IPlatformRoomService;)V", "start", "", "stop", "register", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "respHandler", "Companion", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KRoomService {
    public static final Companion Companion = new Companion(null);
    private static final KRoomService shared = new KRoomService(((IPlatformRoomServiceBuilder) KRoomServiceKt.getKRoomServiceBuilder().invoke()).getShared());
    private final IPlatformRoomService real;

    public KRoomService(IPlatformRoomService real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.real = real;
    }

    /* compiled from: KRoomService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkntr/base/moss/api/KRoomService$Companion;", "", "<init>", "()V", "shared", "Lkntr/base/moss/api/KRoomService;", "getShared", "()Lkntr/base/moss/api/KRoomService;", "build", "stream", "Lkntr/base/moss/api/KMossStream;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KRoomService getShared() {
            return KRoomService.shared;
        }

        public final KRoomService build(KMossStream stream) {
            Intrinsics.checkNotNullParameter(stream, "stream");
            return new KRoomService(((IPlatformRoomServiceBuilder) KRoomServiceKt.getKRoomServiceBuilder().invoke()).build(stream.getReal$moss_debug()));
        }
    }

    public final void start() {
        this.real.start();
    }

    public final void stop() {
        this.real.stop();
    }

    public final IPlatformResponseHandler register(IPlatformResponseHandler respHandler) {
        return this.real.register(respHandler);
    }
}