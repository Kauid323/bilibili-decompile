package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkntr/base/net/GetResponseCallBack;", "Lkntr/base/net/ResponseCallBack;", "<init>", "()V", "response", "Lkntr/base/net/Response;", "getResponse", "()Lkntr/base/net/Response;", "setResponse", "(Lkntr/base/net/Response;)V", "error", "", "getError", "()Ljava/lang/Throwable;", "setError", "(Ljava/lang/Throwable;)V", "onResponse", "", "onError", "e", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class GetResponseCallBack implements ResponseCallBack {
    private Throwable error;
    private Response response;

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response) {
        this.response = response;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final void setError(Throwable th) {
        this.error = th;
    }

    @Override // kntr.base.net.ResponseCallBack
    public void onResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.response = response;
    }

    @Override // kntr.base.net.ResponseCallBack
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.error = e;
    }
}