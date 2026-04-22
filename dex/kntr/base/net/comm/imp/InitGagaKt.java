package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.comm.GGaia;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGaga.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideGaiaRequest", "Lkntr/base/net/GInterceptor;", "gaia", "Lkntr/base/net/comm/GGaia;", "gaia_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGagaKt {
    public static final GInterceptor provideGaiaRequest(final GGaia gaia) {
        Intrinsics.checkNotNullParameter(gaia, "gaia");
        return new RequestHook("gaia", null, new Function1() { // from class: kntr.base.net.comm.imp.InitGagaKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideGaiaRequest$lambda$0;
                provideGaiaRequest$lambda$0 = InitGagaKt.provideGaiaRequest$lambda$0(GGaia.this, (Request) obj);
                return provideGaiaRequest$lambda$0;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideGaiaRequest$lambda$0(GGaia $gaia, Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        MutableRequest request = req.copy();
        String token = $gaia.gaiaToken(request.getHost(), request.getPath());
        GnetKt.log(request, "gaia", "header x-bili-gaia-vtoken=" + token);
        request.header("x-bili-gaia-vtoken", token);
        return request;
    }
}