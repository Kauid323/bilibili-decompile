package im.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;

/* compiled from: Json.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\"\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"buildBaseChatJson", "Lkotlinx/serialization/json/Json;", "builder", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", "", "Lkotlin/ExtensionFunctionType;", "baseChatJson", "getBaseChatJson", "()Lkotlinx/serialization/json/Json;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JsonKt {
    private static final Json baseChatJson = buildBaseChatJson(new Function1() { // from class: im.base.JsonKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit baseChatJson$lambda$0;
            baseChatJson$lambda$0 = JsonKt.baseChatJson$lambda$0((JsonBuilder) obj);
            return baseChatJson$lambda$0;
        }
    });

    public static final Json buildBaseChatJson(final Function1<? super JsonBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        return kotlinx.serialization.json.JsonKt.Json$default((Json) null, new Function1() { // from class: im.base.JsonKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildBaseChatJson$lambda$0;
                buildBaseChatJson$lambda$0 = JsonKt.buildBaseChatJson$lambda$0(function1, (JsonBuilder) obj);
                return buildBaseChatJson$lambda$0;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildBaseChatJson$lambda$0(Function1 $builder, JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setEncodeDefaults(true);
        $this$Json.setExplicitNulls(false);
        $builder.invoke($this$Json);
        return Unit.INSTANCE;
    }

    public static final Json getBaseChatJson() {
        return baseChatJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit baseChatJson$lambda$0(JsonBuilder $this$buildBaseChatJson) {
        Intrinsics.checkNotNullParameter($this$buildBaseChatJson, "$this$buildBaseChatJson");
        $this$buildBaseChatJson.setIgnoreUnknownKeys(true);
        $this$buildBaseChatJson.setEncodeDefaults(true);
        $this$buildBaseChatJson.setExplicitNulls(false);
        return Unit.INSTANCE;
    }
}