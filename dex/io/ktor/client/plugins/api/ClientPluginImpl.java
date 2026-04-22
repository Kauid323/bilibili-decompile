package io.ktor.client.plugins.api;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentDisposition;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CreatePluginUtils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B<\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R+\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginImpl;", "", "PluginConfigT", "Lio/ktor/client/plugins/api/ClientPlugin;", "", ContentDisposition.Parameters.Name, "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "Lkotlin/ExtensionFunctionType;", "body", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "block", "Lio/ktor/client/plugins/api/ClientPluginInstance;", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPluginInstance;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/api/ClientPluginInstance;Lio/ktor/client/HttpClient;)V", "Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function1;", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClientPluginImpl<PluginConfigT> implements ClientPlugin<PluginConfigT> {
    private final Function1<ClientPluginBuilder<PluginConfigT>, Unit> body;
    private final Function0<PluginConfigT> createConfiguration;
    private final AttributeKey<ClientPluginInstance<PluginConfigT>> key;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPluginImpl(String name, Function0<? extends PluginConfigT> function0, Function1<? super ClientPluginBuilder<PluginConfigT>, Unit> function1) {
        KType kType;
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(function0, "createConfiguration");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.createConfiguration = function0;
        this.body = function1;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientPluginInstance.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.Companion;
            KTypeParameter typeParameter = Reflection.typeParameter(Reflection.getOrCreateKotlinClass(ClientPluginImpl.class), "PluginConfigT", KVariance.INVARIANT, false);
            Reflection.setUpperBounds(typeParameter, Reflection.typeOf(Object.class));
            kType = Reflection.typeOf(ClientPluginInstance.class, companion.invariant(Reflection.typeOf(typeParameter)));
        } catch (Throwable th) {
            kType = null;
        }
        this.key = new AttributeKey<>(name, new TypeInfo(orCreateKotlinClass, kType));
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public /* bridge */ /* synthetic */ void install(Object plugin, HttpClient scope) {
        install((ClientPluginInstance) ((ClientPluginInstance) plugin), scope);
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public AttributeKey<ClientPluginInstance<PluginConfigT>> getKey() {
        return this.key;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public ClientPluginInstance<PluginConfigT> prepare(Function1<? super PluginConfigT, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Object config = this.createConfiguration.invoke();
        function1.invoke(config);
        return new ClientPluginInstance<>(getKey(), config, this.body);
    }

    public void install(ClientPluginInstance<PluginConfigT> clientPluginInstance, HttpClient scope) {
        Intrinsics.checkNotNullParameter(clientPluginInstance, "plugin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        clientPluginInstance.install(scope);
    }
}