package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KMossResponseHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u00020\u0002J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/api/KMossResponseHandler;", "V", "", "Lkntr/base/moss/api/KProtoMessage;", "onNext", "", "value", "(Ljava/lang/Object;)V", "onError", "t", "Lkntr/base/moss/api/KMossException;", "onCompleted", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface KMossResponseHandler<V> {
    void onCompleted();

    void onError(KMossException kMossException);

    void onNext(V v);

    /* compiled from: KMossResponseHandler.kt */
    /* renamed from: kntr.base.moss.api.KMossResponseHandler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCompleted(KMossResponseHandler _this) {
        }
    }

    /* compiled from: KMossResponseHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <V> void onCompleted(KMossResponseHandler<V> kMossResponseHandler) {
            CC.$default$onCompleted(kMossResponseHandler);
        }
    }
}