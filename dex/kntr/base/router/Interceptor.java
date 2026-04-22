package kntr.base.router;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.RouterTarget;
import kotlin.Metadata;
import kotlin.reflect.KType;

/* compiled from: Interceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/base/router/Interceptor;", "", "intercept", "Lkntr/base/router/Response;", "chain", "Lkntr/base/router/Interceptor$Chain;", "Chain", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface Interceptor {
    Response intercept(Chain chain);

    /* compiled from: Interceptor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/base/router/Interceptor$Chain;", "", "target", "Lkntr/base/router/target/RouterTarget;", "getTarget", "()Lkntr/base/router/target/RouterTarget;", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "getUri", "()Lcom/bilibili/lib/brouter/uri/Uri;", "getUriParam", "", "key", "find", "contextUnsafe", "type", "Lkotlin/reflect/KType;", "proceed", "Lkntr/base/router/Response;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Chain {
        Object contextUnsafe(KType kType);

        RouterTarget find(Uri uri);

        RouterTarget getTarget();

        Uri getUri();

        String getUriParam(String str);

        Response proceed(RouterTarget routerTarget, Uri uri);

        /* compiled from: Interceptor.kt */
        /* renamed from: kntr.base.router.Interceptor$Chain$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ Response proceed$default(Chain chain, RouterTarget routerTarget, Uri uri, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        routerTarget = chain.getTarget();
                    }
                    if ((i & 2) != 0) {
                        uri = chain.getUri();
                    }
                    return chain.proceed(routerTarget, uri);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: proceed");
            }
        }

        /* compiled from: Interceptor.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
        }
    }
}