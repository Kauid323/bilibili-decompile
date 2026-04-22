package io.ktor.client;

import faceverify.q;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.KtorDsl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientConfig.kt */
@KtorDsl
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\n\u0010\u000bJP\u0010\u0011\u001a\u00020\u0007\"\b\b\u0001\u0010\f*\u00020\u0003\"\b\b\u0002\u0010\r*\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\u0011\u0010\u0016J\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0011\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001c\u001a\u00020\u00072\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0086\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R5\u0010\"\u001a#\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R,\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R3\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u000bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00103\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R(\u00106\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b6\u0010+\u0012\u0004\b9\u0010\u0005\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/¨\u0006:"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "engine", "(Lkotlin/jvm/functions/Function1;)V", "TBuilder", "TPlugin", "Lio/ktor/client/plugins/HttpClientPlugin;", "plugin", "configure", "install", "(Lio/ktor/client/plugins/HttpClientPlugin;Lkotlin/jvm/functions/Function1;)V", "", q.KEY_RES_9_KEY, "Lio/ktor/client/HttpClient;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "client", "(Lio/ktor/client/HttpClient;)V", "clone", "()Lio/ktor/client/HttpClientConfig;", "other", "plusAssign", "(Lio/ktor/client/HttpClientConfig;)V", "", "Lio/ktor/util/AttributeKey;", "plugins", "Ljava/util/Map;", "pluginConfigurations", "customInterceptors", "engineConfig", "Lkotlin/jvm/functions/Function1;", "getEngineConfig$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "setEngineConfig$ktor_client_core", "", "followRedirects", "Z", "getFollowRedirects", "()Z", "setFollowRedirects", "(Z)V", "useDefaultTransformers", "getUseDefaultTransformers", "setUseDefaultTransformers", "expectSuccess", "getExpectSuccess", "setExpectSuccess", "developmentMode", "getDevelopmentMode", "setDevelopmentMode", "getDevelopmentMode$annotations", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    private boolean expectSuccess;
    private final Map<AttributeKey<?>, Function1<HttpClient, Unit>> plugins = new LinkedHashMap();
    private final Map<AttributeKey<?>, Function1<Object, Unit>> pluginConfigurations = new LinkedHashMap();
    private final Map<String, Function1<HttpClient, Unit>> customInterceptors = new LinkedHashMap();
    private Function1<? super T, Unit> engineConfig = new Function1() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            Unit engineConfig$lambda$0;
            engineConfig$lambda$0 = HttpClientConfig.engineConfig$lambda$0((HttpClientEngineConfig) obj);
            return engineConfig$lambda$0;
        }
    };
    private boolean followRedirects = true;
    private boolean useDefaultTransformers = true;
    private boolean developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Development mode is no longer required. The property will be removed in the future.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static /* synthetic */ void getDevelopmentMode$annotations() {
    }

    public static final Unit engineConfig$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
        Intrinsics.checkNotNullParameter(httpClientEngineConfig, "<this>");
        return Unit.INSTANCE;
    }

    public final Function1<T, Unit> getEngineConfig$ktor_client_core() {
        return (Function1<? super T, Unit>) this.engineConfig;
    }

    public final void setEngineConfig$ktor_client_core(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.engineConfig = function1;
    }

    public final void engine(final Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        final Function1 oldConfig = this.engineConfig;
        this.engineConfig = new Function1() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit engine$lambda$1;
                engine$lambda$1 = HttpClientConfig.engine$lambda$1(oldConfig, function1, (HttpClientEngineConfig) obj);
                return engine$lambda$1;
            }
        };
    }

    public static final Unit engine$lambda$1(Function1 $oldConfig, Function1 $block, HttpClientEngineConfig httpClientEngineConfig) {
        Intrinsics.checkNotNullParameter(httpClientEngineConfig, "<this>");
        $oldConfig.invoke(httpClientEngineConfig);
        $block.invoke(httpClientEngineConfig);
        return Unit.INSTANCE;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final boolean getUseDefaultTransformers() {
        return this.useDefaultTransformers;
    }

    public final void setUseDefaultTransformers(boolean z) {
        this.useDefaultTransformers = z;
    }

    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final void setExpectSuccess(boolean z) {
        this.expectSuccess = z;
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final void setDevelopmentMode(boolean z) {
        this.developmentMode = z;
    }

    public static /* synthetic */ void install$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit install$lambda$2;
                    install$lambda$2 = HttpClientConfig.install$lambda$2(obj2);
                    return install$lambda$2;
                }
            };
        }
        httpClientConfig.install(httpClientPlugin, function1);
    }

    public static final Unit install$lambda$2(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return Unit.INSTANCE;
    }

    public final <TBuilder, TPlugin> void install(final HttpClientPlugin<? extends TBuilder, TPlugin> httpClientPlugin, final Function1<? super TBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        Intrinsics.checkNotNullParameter(function1, "configure");
        final Function1 previousConfigBlock = this.pluginConfigurations.get(httpClientPlugin.getKey());
        this.pluginConfigurations.put(httpClientPlugin.getKey(), new Function1() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit install$lambda$3;
                install$lambda$3 = HttpClientConfig.install$lambda$3(previousConfigBlock, function1, obj);
                return install$lambda$3;
            }
        });
        if (this.plugins.containsKey(httpClientPlugin.getKey())) {
            return;
        }
        this.plugins.put(httpClientPlugin.getKey(), new Function1() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit install$lambda$5;
                install$lambda$5 = HttpClientConfig.install$lambda$5(HttpClientPlugin.this, (HttpClient) obj);
                return install$lambda$5;
            }
        });
    }

    public static final Unit install$lambda$3(Function1 $previousConfigBlock, Function1 $configure, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if ($previousConfigBlock != null) {
            $previousConfigBlock.invoke(obj);
        }
        $configure.invoke(obj);
        return Unit.INSTANCE;
    }

    public static final Unit install$lambda$5(HttpClientPlugin $plugin, HttpClient scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Attributes attributes = (Attributes) scope.getAttributes().computeIfAbsent(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST(), new Function0() { // from class: io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda5
            public final Object invoke() {
                Attributes install$lambda$5$lambda$4;
                install$lambda$5$lambda$4 = HttpClientConfig.install$lambda$5$lambda$4();
                return install$lambda$5$lambda$4;
            }
        });
        Function1 function1 = ((HttpClientConfig) scope.getConfig$ktor_client_core()).pluginConfigurations.get($plugin.getKey());
        Intrinsics.checkNotNull(function1);
        Function1 config = function1;
        Object pluginData = $plugin.prepare(config);
        $plugin.install(pluginData, scope);
        attributes.put($plugin.getKey(), pluginData);
        return Unit.INSTANCE;
    }

    public static final Attributes install$lambda$5$lambda$4() {
        return AttributesJvmKt.Attributes(true);
    }

    public final void install(String key, Function1<? super HttpClient, Unit> function1) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(function1, "block");
        this.customInterceptors.put(key, function1);
    }

    public final void install(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        Iterable $this$forEach$iv = this.plugins.values();
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1) element$iv;
            it.invoke(client);
        }
        Iterable $this$forEach$iv2 = this.customInterceptors.values();
        for (Object element$iv2 : $this$forEach$iv2) {
            Function1 it2 = (Function1) element$iv2;
            it2.invoke(client);
        }
    }

    public final HttpClientConfig<T> clone() {
        HttpClientConfig result = new HttpClientConfig();
        result.plusAssign(this);
        return result;
    }

    public final void plusAssign(HttpClientConfig<? extends T> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "other");
        this.followRedirects = httpClientConfig.followRedirects;
        this.useDefaultTransformers = httpClientConfig.useDefaultTransformers;
        this.expectSuccess = httpClientConfig.expectSuccess;
        this.plugins.putAll(httpClientConfig.plugins);
        this.pluginConfigurations.putAll(httpClientConfig.pluginConfigurations);
        this.customInterceptors.putAll(httpClientConfig.customInterceptors);
    }
}