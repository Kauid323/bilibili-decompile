package kntr.base.net.comm.imp;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GNetPublicHeader;
import kntr.base.net.GnetKt;
import kntr.base.net.HttpStatus;
import kntr.base.net.MutableRequest;
import kntr.base.net.Param;
import kntr.base.net.Request;
import kntr.base.net.RequestResponseHook;
import kntr.base.net.Response;
import kntr.base.net.comm.GAurora;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGAurora.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"provideGAuroraRequest", "Lkntr/base/net/GInterceptor;", "aurora", "Lkntr/base/net/comm/GAurora;", "provideAuroraHeader", "Lkntr/base/net/GNetPublicHeader;", "aurora_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGAuroraKt {
    public static final GInterceptor provideGAuroraRequest(final GAurora aurora) {
        Intrinsics.checkNotNullParameter(aurora, "aurora");
        return new RequestResponseHook("aurora", new Function1() { // from class: kntr.base.net.comm.imp.InitGAuroraKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideGAuroraRequest$lambda$0;
                provideGAuroraRequest$lambda$0 = InitGAuroraKt.provideGAuroraRequest$lambda$0(GAurora.this, (Request) obj);
                return provideGAuroraRequest$lambda$0;
            }
        }, new Function1() { // from class: kntr.base.net.comm.imp.InitGAuroraKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Response provideGAuroraRequest$lambda$1;
                provideGAuroraRequest$lambda$1 = InitGAuroraKt.provideGAuroraRequest$lambda$1(GAurora.this, (Response) obj);
                return provideGAuroraRequest$lambda$1;
            }
        }, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideGAuroraRequest$lambda$0(GAurora $aurora, Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        MutableRequest request = req.copy();
        if (request.header("x-bili-trace-id") == null) {
            GnetKt.log(request, "aurora", "header x-bili-trace-id=" + $aurora.xtraceId());
            request.header("x-bili-trace-id", $aurora.xtraceId());
        }
        GnetKt.log(request, "aurora", "header x-bili-aurora-eid=" + $aurora.eid());
        request.header("x-bili-aurora-eid", $aurora.eid());
        GnetKt.log(request, "aurora", "header x-bili-mid=" + $aurora.mid());
        request.header("x-bili-mid", $aurora.mid());
        String zone = $aurora.zone(request.getHost(), request.getPath());
        GnetKt.log(request, "aurora", "header x-bili-aurora-zone=" + zone);
        request.header("x-bili-aurora-zone", zone);
        GnetKt.log(request, "aurora", "header GuestId=" + $aurora.guestId());
        request.header("GuestId", $aurora.guestId());
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        if ((r4.length() > 0) == true) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Response provideGAuroraRequest$lambda$1(GAurora $aurora, Response response) {
        boolean z;
        Intrinsics.checkNotNullParameter(response, "response");
        String host = response.getHost();
        String path = response.getPath();
        HttpStatus httpStatus = response.getHttpStatus();
        String zone = response.header("x-bili-aurora-zone");
        String pathRoute = response.header("x-bili-aurora-path-route");
        int value = httpStatus.getValue();
        boolean z2 = true;
        if (400 <= value && value < 600) {
            if (zone != null) {
                if (zone.length() > 0) {
                    z = true;
                    if (z) {
                        GnetKt.log(response, "aurora", "aurora.clearRoute " + httpStatus.getValue());
                        $aurora.clearRoute(host, path);
                        return response;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        if (pathRoute != null) {
        }
        z2 = false;
        if (z2) {
            GnetKt.log(response, "aurora", "pathRoute=" + pathRoute + ", zone=" + zone);
            $aurora.updateRoute(host, pathRoute, zone);
        }
        return response;
    }

    public static final GNetPublicHeader provideAuroraHeader(final GAurora aurora) {
        Intrinsics.checkNotNullParameter(aurora, "aurora");
        return new GNetPublicHeader() { // from class: kntr.base.net.comm.imp.InitGAuroraKt$provideAuroraHeader$1
            @Override // kntr.base.net.GNetPublicHeader
            public List<Param> header() {
                return CollectionsKt.listOf(new Param[]{new Param("x-bili-trace-id", GAurora.this.xtraceId()), new Param("x-bili-aurora-eid", GAurora.this.eid()), new Param("x-bili-mid", GAurora.this.mid()), new Param("GuestId", GAurora.this.guestId())});
            }
        };
    }
}