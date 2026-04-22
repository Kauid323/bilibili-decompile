package io.ktor.client.plugins.api;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.InternalAPI;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientPluginInstance.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00060\u0003j\u0002`\u0004BD\b\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u0007\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R+\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginInstance;", "", "PluginConfig", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "config", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "Lkotlin/ExtensionFunctionType;", "body", "<init>", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/HttpClient;)V", "close", "()V", "Lio/ktor/util/AttributeKey;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "onClose", "Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClientPluginInstance<PluginConfig> implements Closeable {
    private final Function1<ClientPluginBuilder<PluginConfig>, Unit> body;
    private final PluginConfig config;
    private final AttributeKey<ClientPluginInstance<PluginConfig>> key;
    private Function0<Unit> onClose;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPluginInstance(AttributeKey<ClientPluginInstance<PluginConfig>> attributeKey, PluginConfig pluginconfig, Function1<? super ClientPluginBuilder<PluginConfig>, Unit> function1) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(pluginconfig, "config");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.key = attributeKey;
        this.config = pluginconfig;
        this.body = function1;
        this.onClose = new Function0() { // from class: io.ktor.client.plugins.api.ClientPluginInstance$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
    }

    @InternalAPI
    public final void install(HttpClient scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        ClientPluginBuilder pluginBuilder = new ClientPluginBuilder(this.key, scope, this.config);
        this.body.invoke(pluginBuilder);
        this.onClose = pluginBuilder.getOnClose$ktor_client_core();
        Iterable $this$forEach$iv = pluginBuilder.getHooks$ktor_client_core();
        for (Object element$iv : $this$forEach$iv) {
            HookHandler it = (HookHandler) element$iv;
            it.install(scope);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.onClose.invoke();
    }
}