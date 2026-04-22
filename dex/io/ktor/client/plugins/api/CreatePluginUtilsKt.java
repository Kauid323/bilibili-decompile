package io.ktor.client.plugins.api;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreatePluginUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aR\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\f\u0010\r\u001a:\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"", "PluginConfigT", "", ContentDisposition.Parameters.Name, "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "Lkotlin/ExtensionFunctionType;", "body", "Lio/ktor/client/plugins/api/ClientPlugin;", "createClientPlugin", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPlugin;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CreatePluginUtilsKt {
    public static final <PluginConfigT> ClientPlugin<PluginConfigT> createClientPlugin(String name, Function0<? extends PluginConfigT> function0, Function1<? super ClientPluginBuilder<PluginConfigT>, Unit> function1) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(function0, "createConfiguration");
        Intrinsics.checkNotNullParameter(function1, "body");
        return new ClientPluginImpl(name, function0, function1);
    }

    public static final ClientPlugin<Unit> createClientPlugin(String name, Function1<? super ClientPluginBuilder<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(function1, "body");
        return createClientPlugin(name, new Function0() { // from class: io.ktor.client.plugins.api.CreatePluginUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, function1);
    }
}