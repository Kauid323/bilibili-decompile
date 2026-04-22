package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMossStream;
import kntr.base.moss.platform.IPlatformMossStreamBuilder;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossStream.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ(\u0010\u000b\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u0012\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/base/moss/api/KMossStream;", "", "real", "Lkntr/base/moss/platform/IPlatformMossStream;", "<init>", "(Lkntr/base/moss/platform/IPlatformMossStream;)V", "getReal$moss_debug", "()Lkntr/base/moss/platform/IPlatformMossStream;", "start", "", "stop", "register", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "request", "", "respHandler", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "unregister", "Companion", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossStream {
    public static final Companion Companion = new Companion(null);
    private static final KMossStream shared = new KMossStream(((IPlatformMossStreamBuilder) KMossStreamKt.getKMossStreamBuilder().invoke()).getShared());
    private final IPlatformMossStream real;

    public KMossStream(IPlatformMossStream real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.real = real;
    }

    public final IPlatformMossStream getReal$moss_debug() {
        return this.real;
    }

    /* compiled from: KMossStream.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/base/moss/api/KMossStream$Companion;", "", "<init>", "()V", "shared", "Lkntr/base/moss/api/KMossStream;", "getShared", "()Lkntr/base/moss/api/KMossStream;", "build", "highPriority", "", "tag", "", "host", "port", "", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KMossStream getShared() {
            return KMossStream.shared;
        }

        public final KMossStream build(boolean highPriority, String tag, String host, int port) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(host, "host");
            return new KMossStream(((IPlatformMossStreamBuilder) KMossStreamKt.getKMossStreamBuilder().invoke()).build(highPriority, tag, host, port));
        }
    }

    public final void start() {
        this.real.start();
    }

    public final void stop() {
        this.real.stop();
    }

    public final void register(KMethodDescriptor<?, ?> kMethodDescriptor, byte[] request, IPlatformResponseHandler respHandler) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        Intrinsics.checkNotNullParameter(request, "request");
        this.real.register(kMethodDescriptor, request, respHandler);
    }

    public final void unregister(KMethodDescriptor<?, ?> kMethodDescriptor) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        this.real.unregister(kMethodDescriptor);
    }
}