package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: HttpClientPlugin.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a9\u0010\u0005\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0007\" \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "B", "F", "Lio/ktor/client/HttpClient;", "Lio/ktor/client/plugins/HttpClientPlugin;", "plugin", "pluginOrNull", "(Lio/ktor/client/HttpClient;Lio/ktor/client/plugins/HttpClientPlugin;)Ljava/lang/Object;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/util/Attributes;", "PLUGIN_INSTALLED_LIST", "Lio/ktor/util/AttributeKey;", "getPLUGIN_INSTALLED_LIST", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientPluginKt {
    private static final AttributeKey<Attributes> PLUGIN_INSTALLED_LIST;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Attributes.class);
        try {
            kType = Reflection.typeOf(Attributes.class);
        } catch (Throwable th) {
            kType = null;
        }
        PLUGIN_INSTALLED_LIST = new AttributeKey<>("ApplicationPluginRegistry", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final AttributeKey<Attributes> getPLUGIN_INSTALLED_LIST() {
        return PLUGIN_INSTALLED_LIST;
    }

    public static final <B, F> F pluginOrNull(HttpClient $this$pluginOrNull, HttpClientPlugin<? extends B, F> httpClientPlugin) {
        Intrinsics.checkNotNullParameter($this$pluginOrNull, "<this>");
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        Attributes attributes = (Attributes) $this$pluginOrNull.getAttributes().getOrNull(PLUGIN_INSTALLED_LIST);
        if (attributes != null) {
            return (F) attributes.getOrNull(httpClientPlugin.getKey());
        }
        return null;
    }

    public static final <B, F> F plugin(HttpClient $this$plugin, HttpClientPlugin<? extends B, F> httpClientPlugin) {
        Intrinsics.checkNotNullParameter($this$plugin, "<this>");
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        F f2 = (F) pluginOrNull($this$plugin, httpClientPlugin);
        if (f2 != null) {
            return f2;
        }
        throw new IllegalStateException("Plugin " + httpClientPlugin + " is not installed. Consider using `install(" + httpClientPlugin.getKey() + ")` in client config first.");
    }
}