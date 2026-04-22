package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\u0002\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/base/net/RequestHook;", "Lkntr/base/net/RequestResponseHook;", "name", "", "phase", "Lkntr/base/net/PHASE;", "hook", "Lkotlin/Function1;", "Lkntr/base/net/Request;", "Lkotlin/ParameterName;", "origin", "<init>", "(Ljava/lang/String;Lkntr/base/net/PHASE;Lkotlin/jvm/functions/Function1;)V", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class RequestHook extends RequestResponseHook {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestHook(String name, PHASE phase, Function1<? super Request, ? extends Request> function1) {
        super(name, function1, null, phase, 4, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(function1, "hook");
    }

    public /* synthetic */ RequestHook(String str, PHASE phase, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? PHASE.COMM : phase, (i & 4) != 0 ? new Function1() { // from class: kntr.base.net.RequestHook$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return RequestHook._init_$lambda$0((Request) obj);
            }
        } : function1);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.base.net.Request _init_$lambda$0(kntr.base.net.Request r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.net.RequestHook._init_$lambda$0(kntr.base.net.Request):kntr.base.net.Request");
    }
}