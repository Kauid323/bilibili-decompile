package kntr.common.behavior.prediction.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonBuilder;

/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
public final class UtilsKt$encodeToString$json$1 implements Function1<JsonBuilder, Unit> {
    public static final UtilsKt$encodeToString$json$1 INSTANCE = new UtilsKt$encodeToString$json$1();

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setPrettyPrint(false);
        $this$Json.setLenient(true);
    }
}