package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosResponseWrapper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosRequestHandler.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/FailableChronosRequestHandlerScope;", "Response", "", "<init>", "()V", "success", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosResponseWrapper$Success;", "response", "(Ljava/lang/Object;)Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosResponseWrapper$Success;", "failure", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosResponseWrapper$Failure;", "code", "", "description", "", "(Ljava/lang/Integer;Ljava/lang/String;)Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosResponseWrapper$Failure;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FailableChronosRequestHandlerScope<Response> {
    public final ChronosResponseWrapper.Success<Response> success(Response response) {
        return new ChronosResponseWrapper.Success<>(response);
    }

    public final ChronosResponseWrapper.Failure failure(Integer code, String description) {
        return new ChronosResponseWrapper.Failure(code, description);
    }
}