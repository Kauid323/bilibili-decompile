package kntr.base.moss.platform;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMethodDescriptor;
import kntr.base.moss.api.KMossHttpRule;
import kntr.base.moss.api.KMossServiceComponent;
import kotlin.Metadata;

/* compiled from: IPlatformMoss.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/platform/IPlatformMoss;", "", "asyncUnaryCall", "", "service", "Lkntr/base/moss/api/KMossServiceComponent;", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "request", "", "handler", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "rule", "Lkntr/base/moss/api/KMossHttpRule;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformMoss {
    void asyncUnaryCall(KMossServiceComponent kMossServiceComponent, KMethodDescriptor<?, ?> kMethodDescriptor, byte[] bArr, IPlatformResponseHandler iPlatformResponseHandler, KMossHttpRule kMossHttpRule);

    /* compiled from: IPlatformMoss.kt */
    /* renamed from: kntr.base.moss.platform.IPlatformMoss$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void asyncUnaryCall$default(IPlatformMoss iPlatformMoss, KMossServiceComponent kMossServiceComponent, KMethodDescriptor kMethodDescriptor, byte[] bArr, IPlatformResponseHandler iPlatformResponseHandler, KMossHttpRule kMossHttpRule, int i, Object obj) {
            KMossHttpRule kMossHttpRule2;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncUnaryCall");
            }
            if ((i & 16) == 0) {
                kMossHttpRule2 = kMossHttpRule;
            } else {
                kMossHttpRule2 = null;
            }
            iPlatformMoss.asyncUnaryCall(kMossServiceComponent, kMethodDescriptor, bArr, iPlatformResponseHandler, kMossHttpRule2);
        }
    }

    /* compiled from: IPlatformMoss.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}