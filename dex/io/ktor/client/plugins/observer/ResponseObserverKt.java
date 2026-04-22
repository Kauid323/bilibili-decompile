package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a=\u0010\b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002&\u0010\u0007\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001j\u0002`\u0006¢\u0006\u0004\b\b\u0010\t\"#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0012\n\u0004\b\b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e*B\u0010\u0011\"\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "", "Lio/ktor/client/plugins/observer/ResponseHandler;", "block", "ResponseObserver", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/observer/ResponseObserverConfig;", "Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver$annotations", "()V", "ResponseHandler", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ResponseObserverKt {
    private static final ClientPlugin<ResponseObserverConfig> ResponseObserver = CreatePluginUtilsKt.createClientPlugin("ResponseObserver", ResponseObserverKt$ResponseObserver$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.observer.ResponseObserverKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit ResponseObserver$lambda$0;
            ResponseObserver$lambda$0 = ResponseObserverKt.ResponseObserver$lambda$0((ClientPluginBuilder) obj);
            return ResponseObserver$lambda$0;
        }
    });

    public static /* synthetic */ void getResponseObserver$annotations() {
    }

    public static final ClientPlugin<ResponseObserverConfig> getResponseObserver() {
        return ResponseObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResponseObserver$lambda$0(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        Function2 responseHandler = ((ResponseObserverConfig) $this$createClientPlugin.getPluginConfig()).getResponseHandler$ktor_client_core();
        Function1 filter = ((ResponseObserverConfig) $this$createClientPlugin.getPluginConfig()).getFilter$ktor_client_core();
        $this$createClientPlugin.on(AfterReceiveHook.INSTANCE, new ResponseObserverKt$ResponseObserver$2$1(filter, $this$createClientPlugin, responseHandler, null));
        return Unit.INSTANCE;
    }

    public static final void ResponseObserver(HttpClientConfig<?> httpClientConfig, final Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        httpClientConfig.install(ResponseObserver, new Function1() { // from class: io.ktor.client.plugins.observer.ResponseObserverKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit ResponseObserver$lambda$1;
                ResponseObserver$lambda$1 = ResponseObserverKt.ResponseObserver$lambda$1(function2, (ResponseObserverConfig) obj);
                return ResponseObserver$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResponseObserver$lambda$1(Function2 $block, ResponseObserverConfig $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        $this$install.setResponseHandler$ktor_client_core($block);
        return Unit.INSTANCE;
    }
}