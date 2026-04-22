package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.Request;
import kntr.base.net.RequestResponseHook;
import kntr.base.net.Response;
import kntr.base.net.comm.FlowControlException;
import kntr.base.net.comm.GFlowControls;
import kntr.base.net.tags.Call;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: InitGFlowControls.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideGFlowControlsRequest", "Lkntr/base/net/GInterceptor;", "flowControl", "Lkntr/base/net/comm/GFlowControls;", "flow_control_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGFlowControlsKt {
    public static final GInterceptor provideGFlowControlsRequest(final GFlowControls flowControl) {
        Intrinsics.checkNotNullParameter(flowControl, "flowControl");
        return new RequestResponseHook("flow_control", new Function1() { // from class: kntr.base.net.comm.imp.InitGFlowControlsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideGFlowControlsRequest$lambda$0;
                provideGFlowControlsRequest$lambda$0 = InitGFlowControlsKt.provideGFlowControlsRequest$lambda$0(GFlowControls.this, (Request) obj);
                return provideGFlowControlsRequest$lambda$0;
            }
        }, new Function1() { // from class: kntr.base.net.comm.imp.InitGFlowControlsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Response provideGFlowControlsRequest$lambda$1;
                provideGFlowControlsRequest$lambda$1 = InitGFlowControlsKt.provideGFlowControlsRequest$lambda$1(GFlowControls.this, (Response) obj);
                return provideGFlowControlsRequest$lambda$1;
            }
        }, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideGFlowControlsRequest$lambda$0(GFlowControls $flowControl, Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if ($flowControl.hiltFlowControl(request.getHost(), request.getPath())) {
            GnetKt.log(request, "flowControl", "hiltFlowControl");
            throw new FlowControlException();
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response provideGFlowControlsRequest$lambda$1(GFlowControls $flowControl, Response response) {
        String host;
        String path;
        Intrinsics.checkNotNullParameter(response, "response");
        String header = response.header("x-bili-retry-after");
        Integer after = header != null ? Integer.valueOf(Integer.parseInt(header)) : null;
        Call call = (Call) response.getRequest().tag(Reflection.getOrCreateKotlinClass(Call.class));
        if (call == null || (host = call.getHost()) == null) {
            host = response.getHost();
        }
        if (call == null || (path = call.getPath()) == null) {
            path = response.getPath();
        }
        $flowControl.updateFlowControl(host, path, response.getHttpStatus().getValue(), after);
        return response;
    }
}