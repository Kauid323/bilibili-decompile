package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lkntr/base/net/RequestResponseHook;", "Lkntr/base/net/GInterceptor;", "name", "", "request", "Lkotlin/Function1;", "Lkntr/base/net/Request;", "Lkotlin/ParameterName;", "origin", "response", "Lkntr/base/net/Response;", "phase", "Lkntr/base/net/PHASE;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkntr/base/net/PHASE;)V", "getName", "()Ljava/lang/String;", "getRequest", "()Lkotlin/jvm/functions/Function1;", "setRequest", "(Lkotlin/jvm/functions/Function1;)V", "getResponse", "setResponse", "getPhase", "()Lkntr/base/net/PHASE;", "intercept", "", "chain", "Lkntr/base/net/GInterceptor$Chain;", "pre", "Lkntr/base/net/ResponseCallBack;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class RequestResponseHook implements GInterceptor {
    private final String name;
    private final PHASE phase;
    private Function1<? super Request, ? extends Request> request;
    private Function1<? super Response, ? extends Response> response;

    public RequestResponseHook(String name, Function1<? super Request, ? extends Request> function1, Function1<? super Response, ? extends Response> function12, PHASE phase) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function1, "request");
        Intrinsics.checkNotNullParameter(function12, "response");
        Intrinsics.checkNotNullParameter(phase, "phase");
        this.name = name;
        this.request = function1;
        this.response = function12;
        this.phase = phase;
    }

    public /* synthetic */ RequestResponseHook(String str, Function1 function1, Function1 function12, PHASE phase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function1() { // from class: kntr.base.net.RequestResponseHook$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return RequestResponseHook._init_$lambda$0((Request) obj);
            }
        } : function1, (i & 4) != 0 ? new Function1() { // from class: kntr.base.net.RequestResponseHook$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return RequestResponseHook._init_$lambda$1((Response) obj);
            }
        } : function12, (i & 8) != 0 ? PHASE.COMM : phase);
    }

    @Override // kntr.base.net.GInterceptor
    public String getName() {
        return this.name;
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
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.net.RequestResponseHook._init_$lambda$0(kntr.base.net.Request):kntr.base.net.Request");
    }

    public final Function1<Request, Request> getRequest() {
        return this.request;
    }

    public final void setRequest(Function1<? super Request, ? extends Request> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.request = function1;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.base.net.Response _init_$lambda$1(kntr.base.net.Response r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.net.RequestResponseHook._init_$lambda$1(kntr.base.net.Response):kntr.base.net.Response");
    }

    public final Function1<Response, Response> getResponse() {
        return this.response;
    }

    public final void setResponse(Function1<? super Response, ? extends Response> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.response = function1;
    }

    @Override // kntr.base.net.GInterceptor
    public PHASE getPhase() {
        return this.phase;
    }

    @Override // kntr.base.net.GInterceptor
    public void intercept(GInterceptor.Chain chain, final ResponseCallBack pre) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(pre, "pre");
        chain.proceed((Request) this.request.invoke(chain.getRequest()), new DelegateResponseCallBack(pre, new Function1() { // from class: kntr.base.net.RequestResponseHook$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit intercept$lambda$0;
                intercept$lambda$0 = RequestResponseHook.intercept$lambda$0(ResponseCallBack.this, this, (Response) obj);
                return intercept$lambda$0;
            }
        }, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit intercept$lambda$0(ResponseCallBack $pre, RequestResponseHook this$0, Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $pre.onResponse((Response) this$0.response.invoke(it));
        return Unit.INSTANCE;
    }
}