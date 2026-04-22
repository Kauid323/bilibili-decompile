package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GMossStreamService;
import com.bilibili.gripper.api.moss.GMossStreamServiceBuilder;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMethodDescriptor;
import kntr.base.moss.platform.IPlatformMossStream;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossStream.android.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J*\u0010\u000b\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/base/moss/epoch/impl/PlatformMossStream;", "Lkntr/base/moss/platform/IPlatformMossStream;", "real", "Lcom/bilibili/gripper/api/moss/GMossStreamService;", "<init>", "(Lcom/bilibili/gripper/api/moss/GMossStreamService;)V", "getReal$moss_debug", "()Lcom/bilibili/gripper/api/moss/GMossStreamService;", "start", "", "stop", "register", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "request", "", "respHandler", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "unregister", "Companion", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlatformMossStream implements IPlatformMossStream {
    public static final Companion Companion = new Companion(null);
    private static final PlatformMossStream shared;
    private final GMossStreamService real;

    public PlatformMossStream(GMossStreamService real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.real = real;
    }

    public final GMossStreamService getReal$moss_debug() {
        return this.real;
    }

    /* compiled from: KMossStream.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/moss/epoch/impl/PlatformMossStream$Companion;", "", "<init>", "()V", "shared", "Lkntr/base/moss/epoch/impl/PlatformMossStream;", "getShared", "()Lkntr/base/moss/epoch/impl/PlatformMossStream;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformMossStream getShared() {
            return PlatformMossStream.shared;
        }
    }

    static {
        GMossStreamServiceBuilder gMossStreamServiceBuilder;
        gMossStreamServiceBuilder = KMossStream_androidKt.builder;
        shared = new PlatformMossStream(gMossStreamServiceBuilder.getShared());
    }

    @Override // kntr.base.moss.platform.IPlatformMossStream
    public void start() {
        this.real.start();
    }

    @Override // kntr.base.moss.platform.IPlatformMossStream
    public void stop() {
        this.real.stop();
    }

    @Override // kntr.base.moss.platform.IPlatformMossStream
    public void register(KMethodDescriptor<?, ?> kMethodDescriptor, byte[] request, IPlatformResponseHandler respHandler) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        Intrinsics.checkNotNullParameter(request, "request");
        RespHandlerAdapter handler = new RespHandlerAdapter(respHandler);
        this.real.register(KMoss_androidKt.toGMethodDescriptor(kMethodDescriptor), request, handler);
    }

    @Override // kntr.base.moss.platform.IPlatformMossStream
    public void unregister(KMethodDescriptor<?, ?> kMethodDescriptor) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        this.real.unregister(KMoss_androidKt.toGMethodDescriptor(kMethodDescriptor));
    }
}