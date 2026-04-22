package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.tags.Call;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Init.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideInitPhase", "Lkntr/base/net/GInterceptor;", "net_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitKt {
    public static final GInterceptor provideInitPhase() {
        return new RequestHook("call_init", PHASE.INIT, new Function1() { // from class: kntr.base.net.InitKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideInitPhase$lambda$0;
                provideInitPhase$lambda$0 = InitKt.provideInitPhase$lambda$0((Request) obj);
                return provideInitPhase$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideInitPhase$lambda$0(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.tag(Reflection.getOrCreateKotlinClass(Call.class), new Call(request.getHost(), request.getPath()));
        return request;
    }
}