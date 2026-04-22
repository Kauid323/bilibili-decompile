package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.comm.GLbs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGLbs.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideLbsRequest", "Lkntr/base/net/GInterceptor;", "lbs", "Lkntr/base/net/comm/GLbs;", "lbs_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGLbsKt {
    public static final GInterceptor provideLbsRequest(final GLbs lbs) {
        Intrinsics.checkNotNullParameter(lbs, "lbs");
        return new RequestHook("lbs", PHASE.LBS, new Function1() { // from class: kntr.base.net.comm.imp.InitGLbsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideLbsRequest$lambda$0;
                provideLbsRequest$lambda$0 = InitGLbsKt.provideLbsRequest$lambda$0(GLbs.this, (Request) obj);
                return provideLbsRequest$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideLbsRequest$lambda$0(GLbs $lbs, Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        String it = $lbs.lbs(req.getHost());
        if (it != null) {
            GnetKt.log(req, "lbs", "host " + req.getHost() + "->" + it);
            MutableRequest request = req.copy();
            request.setHost(it);
            if (request != null) {
                return request;
            }
        }
        return req;
    }
}