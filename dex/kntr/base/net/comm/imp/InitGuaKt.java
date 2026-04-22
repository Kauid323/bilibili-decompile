package kntr.base.net.comm.imp;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GNetPublicHeader;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.Param;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.comm.GUA;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGua.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"provideUaRequest", "Lkntr/base/net/GInterceptor;", "ua", "Lkntr/base/net/comm/GUA;", "provideUaHeader", "Lkntr/base/net/GNetPublicHeader;", "ua_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGuaKt {
    public static final GInterceptor provideUaRequest(final GUA ua) {
        Intrinsics.checkNotNullParameter(ua, "ua");
        return new RequestHook("ua", null, new Function1() { // from class: kntr.base.net.comm.imp.InitGuaKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideUaRequest$lambda$0;
                provideUaRequest$lambda$0 = InitGuaKt.provideUaRequest$lambda$0(GUA.this, (Request) obj);
                return provideUaRequest$lambda$0;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideUaRequest$lambda$0(GUA $ua, Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        String it = $ua.ua(req.getHost(), req.header("User-Agent"));
        if (it != null) {
            MutableRequest request = req.copy();
            request.header("User-Agent", it);
            String host = req.getHost();
            String path = req.getPath();
            String header = req.header("User-Agent");
            GnetKt.log(request, "ua", "header User-Agent=" + it + " request " + host + " " + path + " " + header + " " + request.header("User-Agent"));
            if (request != null) {
                return request;
            }
        }
        return req;
    }

    public static final GNetPublicHeader provideUaHeader(final GUA ua) {
        Intrinsics.checkNotNullParameter(ua, "ua");
        return new GNetPublicHeader() { // from class: kntr.base.net.comm.imp.InitGuaKt$provideUaHeader$1
            @Override // kntr.base.net.GNetPublicHeader
            public List<Param> header() {
                List<Param> listOf;
                String it = GUA.this.defaultUA();
                return (it == null || (listOf = CollectionsKt.listOf(new Param("User-Agent", it))) == null) ? CollectionsKt.emptyList() : listOf;
            }
        };
    }
}