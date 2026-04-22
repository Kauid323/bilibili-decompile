package io.ktor.client.plugins.json;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.json.JsonPlugin;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: JsonPlugin.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"$\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/json/JsonPlugin$Config;", "", "Lkotlin/ExtensionFunctionType;", "block", "Json", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "", "Lkotlin/reflect/KClass;", "DefaultCommonIgnoredTypes", "Ljava/util/Set;", "getDefaultCommonIgnoredTypes", "()Ljava/util/Set;", "ktor-client-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class JsonPluginKt {
    private static final Set<KClass<?>> DefaultCommonIgnoredTypes = SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class)});

    public static final Set<KClass<?>> getDefaultCommonIgnoredTypes() {
        return DefaultCommonIgnoredTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use ContentNegotiation plugin: https://ktor.io/docs/migration-to-20x.html#serialization-client")
    public static final void Json(HttpClientConfig<?> httpClientConfig, Function1<? super JsonPlugin.Config, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        httpClientConfig.install(JsonPlugin.Plugin, function1);
    }
}