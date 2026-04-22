package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/base/net/GInterceptor;", "", "name", "", "getName", "()Ljava/lang/String;", "phase", "Lkntr/base/net/PHASE;", "getPhase", "()Lkntr/base/net/PHASE;", "intercept", "", "chain", "Lkntr/base/net/GInterceptor$Chain;", "pre", "Lkntr/base/net/ResponseCallBack;", "Chain", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GInterceptor {

    /* compiled from: Gnet.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/net/GInterceptor$Chain;", "", "request", "Lkntr/base/net/Request;", "getRequest", "()Lkntr/base/net/Request;", "setRequest", "(Lkntr/base/net/Request;)V", "proceed", "", "handler", "Lkntr/base/net/ResponseCallBack;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Chain {
        Request getRequest();

        void proceed(Request request, ResponseCallBack responseCallBack);

        void setRequest(Request request);
    }

    String getName();

    PHASE getPhase();

    void intercept(Chain chain, ResponseCallBack responseCallBack);
}