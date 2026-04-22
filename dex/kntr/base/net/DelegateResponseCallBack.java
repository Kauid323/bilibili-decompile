package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012#\b\u0002\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R5\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R5\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkntr/base/net/DelegateResponseCallBack;", "Lkntr/base/net/ResponseCallBack;", "handler", "hook", "Lkotlin/Function1;", "Lkntr/base/net/Response;", "Lkotlin/ParameterName;", "name", "origin", "", "error", "", "e", "<init>", "(Lkntr/base/net/ResponseCallBack;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getHook", "()Lkotlin/jvm/functions/Function1;", "setHook", "(Lkotlin/jvm/functions/Function1;)V", "getError", "setError", "onResponse", "response", "onError", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DelegateResponseCallBack implements ResponseCallBack {
    private Function1<? super Throwable, Unit> error;
    private ResponseCallBack handler;
    private Function1<? super Response, Unit> hook;

    public DelegateResponseCallBack(ResponseCallBack handler, Function1<? super Response, Unit> function1, Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(function1, "hook");
        Intrinsics.checkNotNullParameter(function12, "error");
        this.handler = handler;
        this.hook = function1;
        this.error = function12;
    }

    public /* synthetic */ DelegateResponseCallBack(final ResponseCallBack responseCallBack, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(responseCallBack, (i & 2) != 0 ? new Function1() { // from class: kntr.base.net.DelegateResponseCallBack$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = DelegateResponseCallBack._init_$lambda$0(ResponseCallBack.this, (Response) obj);
                return _init_$lambda$0;
            }
        } : function1, (i & 4) != 0 ? new Function1() { // from class: kntr.base.net.DelegateResponseCallBack$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = DelegateResponseCallBack._init_$lambda$1(ResponseCallBack.this, (Throwable) obj);
                return _init_$lambda$1;
            }
        } : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ResponseCallBack $handler, Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $handler.onResponse(it);
        return Unit.INSTANCE;
    }

    public final Function1<Response, Unit> getHook() {
        return this.hook;
    }

    public final void setHook(Function1<? super Response, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.hook = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(ResponseCallBack $handler, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $handler.onError(it);
        return Unit.INSTANCE;
    }

    public final Function1<Throwable, Unit> getError() {
        return this.error;
    }

    public final void setError(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.error = function1;
    }

    @Override // kntr.base.net.ResponseCallBack
    public void onResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            this.hook.invoke(response);
        } catch (Throwable e) {
            onError(e);
        }
    }

    @Override // kntr.base.net.ResponseCallBack
    public void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.error.invoke(e);
    }
}