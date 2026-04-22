package kntr.base.net;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkntr/base/net/RealInterceptorChain;", "Lkntr/base/net/GInterceptor$Chain;", "interceptors", "", "Lkntr/base/net/GInterceptor;", "index", "", "request", "Lkntr/base/net/Request;", "<init>", "(Ljava/util/List;ILkntr/base/net/Request;)V", "getRequest", "()Lkntr/base/net/Request;", "setRequest", "(Lkntr/base/net/Request;)V", "proceed", "", "handler", "Lkntr/base/net/ResponseCallBack;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealInterceptorChain implements GInterceptor.Chain {
    private final int index;
    private final List<GInterceptor> interceptors;
    private Request request;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(List<? extends GInterceptor> list, int index, Request request) {
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.interceptors = list;
        this.index = index;
        this.request = request;
    }

    @Override // kntr.base.net.GInterceptor.Chain
    public Request getRequest() {
        return this.request;
    }

    @Override // kntr.base.net.GInterceptor.Chain
    public void setRequest(Request request) {
        Intrinsics.checkNotNullParameter(request, "<set-?>");
        this.request = request;
    }

    @Override // kntr.base.net.GInterceptor.Chain
    public void proceed(Request request, ResponseCallBack handler) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        RealInterceptorChain next = new RealInterceptorChain(this.interceptors, this.index + 1, request);
        GInterceptor interceptor = this.interceptors.get(this.index);
        try {
            interceptor.intercept(next, handler);
        } catch (Throwable e) {
            handler.onError(e);
        }
    }
}