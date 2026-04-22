package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.Request;
import kntr.base.net.RequestResponseHook;
import kntr.base.net.Response;
import kntr.base.net.comm.GTicket;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGTicket.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideTicketRequest", "Lkntr/base/net/GInterceptor;", "ticker", "Lkntr/base/net/comm/GTicket;", "ticket_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGTicketKt {
    public static final GInterceptor provideTicketRequest(final GTicket ticker) {
        Intrinsics.checkNotNullParameter(ticker, "ticker");
        return new RequestResponseHook("ticker", new Function1() { // from class: kntr.base.net.comm.imp.InitGTicketKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideTicketRequest$lambda$0;
                provideTicketRequest$lambda$0 = InitGTicketKt.provideTicketRequest$lambda$0(GTicket.this, (Request) obj);
                return provideTicketRequest$lambda$0;
            }
        }, new Function1() { // from class: kntr.base.net.comm.imp.InitGTicketKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Response provideTicketRequest$lambda$1;
                provideTicketRequest$lambda$1 = InitGTicketKt.provideTicketRequest$lambda$1(GTicket.this, (Response) obj);
                return provideTicketRequest$lambda$1;
            }
        }, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideTicketRequest$lambda$0(GTicket $ticker, Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        MutableRequest request = req.copy();
        String tick = $ticker.onTicket(request.getHost(), request.getPath());
        GnetKt.log(request, "ticker", "header x-bili-ticket=" + tick);
        request.header("x-bili-ticket", tick);
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response provideTicketRequest$lambda$1(GTicket $ticker, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (Intrinsics.areEqual(response.header("x-ticket-status"), "1")) {
            GnetKt.log(response, "ticker", "update");
            $ticker.update();
        }
        return response;
    }
}