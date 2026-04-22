package kntr.base.moss.platform;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMossException;
import kotlin.Metadata;

/* compiled from: IPlatformResponseHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/platform/IPlatformResponseHandler;", "", "onNext", "", "value", "", "onError", "t", "Lkntr/base/moss/api/KMossException;", "onCompleted", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformResponseHandler {
    void onCompleted();

    void onError(KMossException kMossException);

    void onNext(byte[] bArr);

    /* compiled from: IPlatformResponseHandler.kt */
    /* renamed from: kntr.base.moss.platform.IPlatformResponseHandler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCompleted(IPlatformResponseHandler _this) {
        }
    }

    /* compiled from: IPlatformResponseHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onCompleted(IPlatformResponseHandler $this) {
            CC.$default$onCompleted($this);
        }
    }
}