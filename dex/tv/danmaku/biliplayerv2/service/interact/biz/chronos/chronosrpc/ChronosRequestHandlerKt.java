package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosResponseWrapper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosRequestHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aK\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u00032#\b\u0004\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\bø\u0001\u0000\u001ab\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u00032:\b\u0004\u0010\u0004\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\f0\n¢\u0006\u0002\b\rH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"chronosRequestHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "Request", "Response", "handle", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "failableChronosRequestHandler", "Lkotlin/Function2;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/FailableChronosRequestHandlerScope;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosResponseWrapper;", "Lkotlin/ExtensionFunctionType;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosRequestHandlerKt {
    public static final /* synthetic */ <Request, Response> ChronosRequestHandler<Request, Response> chronosRequestHandler(final Function1<? super Request, ? extends Response> function1) {
        Intrinsics.checkNotNullParameter(function1, "handle");
        Intrinsics.needClassReification();
        return new ChronosRequestHandler<Request, Response>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandlerKt$chronosRequestHandler$1
            private final boolean requestNullable;

            /* JADX WARN: Multi-variable type inference failed */
            {
                Intrinsics.reifiedOperationMarker(6, "Request");
                KType kType = null;
                kType.isMarkedNullable();
                throw null;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public Class<Request> getRequestClass() {
                Intrinsics.reifiedOperationMarker(4, "Request");
                return Object.class;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public boolean getRequestNullable() {
                return this.requestNullable;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public ChronosResponseWrapper<Response> handle(Request request) {
                return new ChronosResponseWrapper.Success(function1.invoke(request));
            }
        };
    }

    public static final /* synthetic */ <Request, Response> ChronosRequestHandler<Request, Response> failableChronosRequestHandler(final Function2<? super FailableChronosRequestHandlerScope<Response>, ? super Request, ? extends ChronosResponseWrapper<? extends Response>> function2) {
        Intrinsics.checkNotNullParameter(function2, "handle");
        Intrinsics.needClassReification();
        return new ChronosRequestHandler<Request, Response>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandlerKt$failableChronosRequestHandler$1
            private final boolean requestNullable;

            /* JADX WARN: Multi-variable type inference failed */
            {
                Intrinsics.reifiedOperationMarker(6, "Request");
                KType kType = null;
                kType.isMarkedNullable();
                throw null;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public Class<Request> getRequestClass() {
                Intrinsics.reifiedOperationMarker(4, "Request");
                return Object.class;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public boolean getRequestNullable() {
                return this.requestNullable;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler
            public ChronosResponseWrapper<Response> handle(Request request) {
                FailableChronosRequestHandlerScope scope = new FailableChronosRequestHandlerScope();
                return (ChronosResponseWrapper) function2.invoke(scope, request);
            }
        };
    }
}