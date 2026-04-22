package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"json", "Lkotlinx/serialization/json/Json;", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TypeConverterKt {
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: video.biz.offline.base.model.entity.TypeConverterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = TypeConverterKt.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    public static final /* synthetic */ Json access$getJson$p() {
        return json;
    }

    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setCoerceInputValues(true);
        return Unit.INSTANCE;
    }
}