package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/base/net/ResponseHook;", "Lkntr/base/net/RequestResponseHook;", "name", "", "hook", "Lkotlin/Function1;", "Lkntr/base/net/Response;", "Lkotlin/ParameterName;", "origin", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getName", "()Ljava/lang/String;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ResponseHook extends RequestResponseHook {
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHook(String name, Function1<? super Response, ? extends Response> function1) {
        super(name, null, function1, null, 10, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function1, "hook");
        this.name = name;
    }

    public /* synthetic */ ResponseHook(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function1() { // from class: kntr.base.net.ResponseHook$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ResponseHook._init_$lambda$0((Response) obj);
            }
        } : function1);
    }

    @Override // kntr.base.net.RequestResponseHook, kntr.base.net.GInterceptor
    public String getName() {
        return this.name;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.base.net.Response _init_$lambda$0(kntr.base.net.Response r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.net.ResponseHook._init_$lambda$0(kntr.base.net.Response):kntr.base.net.Response");
    }
}