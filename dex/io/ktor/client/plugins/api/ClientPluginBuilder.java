package io.ktor.client.plugins.api;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentDisposition;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientPluginBuilder.kt */
@KtorDsl
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B-\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ`\u0010\u0016\u001a\u00020\u00132Q\u0010\u0015\u001aM\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u0016\u0010\u0017JK\u0010\u001c\u001a\u00020\u00132<\u0010\u0015\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u001c\u0010\u001dJy\u0010#\u001a\u00020\u00132j\u0010\u0015\u001af\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(!\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\b\u0014¢\u0006\u0004\b#\u0010$Jw\u0010(\u001a\u00020\u00132h\u0010\u0015\u001ad\b\u0001\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110&¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b('\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\b\u0014¢\u0006\u0004\b(\u0010$J\u001b\u0010*\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130)¢\u0006\u0004\b*\u0010+J)\u00100\u001a\u00020\u0013\"\u0004\b\u0001\u0010,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010/\u001a\u00028\u0001¢\u0006\u0004\b0\u00101R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b6\u00107R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010:R$\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030<0;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010+¨\u0006E"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "PluginConfig", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/api/ClientPluginInstance;", q.KEY_RES_9_KEY, "Lio/ktor/client/HttpClient;", "client", "pluginConfig", "<init>", "(Lio/ktor/util/AttributeKey;Lio/ktor/client/HttpClient;Ljava/lang/Object;)V", "Lkotlin/Function4;", "Lio/ktor/client/plugins/api/OnRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, SocialConstants.TYPE_REQUEST, q.KEY_RES_9_CONTENT, "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "onRequest", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/Function3;", "Lio/ktor/client/plugins/api/OnResponseContext;", "Lio/ktor/client/statement/HttpResponse;", "response", "onResponse", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "Lio/ktor/util/reflect/TypeInfo;", "bodyType", "Lio/ktor/http/content/OutgoingContent;", "transformRequestBody", "(Lkotlin/jvm/functions/Function5;)V", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "Lio/ktor/utils/io/ByteReadChannel;", "requestedType", "transformResponseBody", "Lkotlin/Function0;", "onClose", "(Lkotlin/jvm/functions/Function0;)V", "HookHandler", "Lio/ktor/client/plugins/api/ClientHook;", "hook", "handler", "on", "(Lio/ktor/client/plugins/api/ClientHook;Ljava/lang/Object;)V", "Lio/ktor/util/AttributeKey;", "getKey$ktor_client_core", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "Ljava/lang/Object;", "getPluginConfig", "()Ljava/lang/Object;", "", "Lio/ktor/client/plugins/api/HookHandler;", "hooks", "Ljava/util/List;", "getHooks$ktor_client_core", "()Ljava/util/List;", "Lkotlin/jvm/functions/Function0;", "getOnClose$ktor_client_core", "()Lkotlin/jvm/functions/Function0;", "setOnClose$ktor_client_core", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClientPluginBuilder<PluginConfig> {
    private final HttpClient client;
    private final List<HookHandler<?>> hooks;
    private final AttributeKey<ClientPluginInstance<PluginConfig>> key;
    private Function0<Unit> onClose;
    private final PluginConfig pluginConfig;

    public ClientPluginBuilder(AttributeKey<ClientPluginInstance<PluginConfig>> attributeKey, HttpClient client, PluginConfig pluginconfig) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(pluginconfig, "pluginConfig");
        this.key = attributeKey;
        this.client = client;
        this.pluginConfig = pluginconfig;
        this.hooks = new ArrayList();
        this.onClose = new Function0() { // from class: io.ktor.client.plugins.api.ClientPluginBuilder$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
    }

    public final AttributeKey<ClientPluginInstance<PluginConfig>> getKey$ktor_client_core() {
        return this.key;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    public final PluginConfig getPluginConfig() {
        return this.pluginConfig;
    }

    public final List<HookHandler<?>> getHooks$ktor_client_core() {
        return this.hooks;
    }

    public final Function0<Unit> getOnClose$ktor_client_core() {
        return this.onClose;
    }

    public final void setOnClose$ktor_client_core(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClose = function0;
    }

    public final void onRequest(Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        on(RequestHook.INSTANCE, function4);
    }

    public final void onResponse(Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        on(ResponseHook.INSTANCE, function3);
    }

    public final void transformRequestBody(Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        on(TransformRequestBodyHook.INSTANCE, function5);
    }

    public final void transformResponseBody(Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<Object>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        on(TransformResponseBodyHook.INSTANCE, function5);
    }

    public final void onClose(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onClose = function0;
    }

    public final <HookHandler> void on(ClientHook<HookHandler> clientHook, HookHandler hookhandler) {
        Intrinsics.checkNotNullParameter(clientHook, "hook");
        this.hooks.add(new HookHandler<>(clientHook, hookhandler));
    }
}