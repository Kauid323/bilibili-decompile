package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: JsonSupport.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u0006\"\u0017\u0010\b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lkotlinx/serialization/json/Json;", "json", "Lio/ktor/http/ContentType;", "contentType", "", "(Lio/ktor/serialization/Configuration;Lkotlinx/serialization/json/Json;Lio/ktor/http/ContentType;)V", "jsonIo", "DefaultJson", "Lkotlinx/serialization/json/Json;", "getDefaultJson", "()Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class JsonSupportKt {
    private static final Json DefaultJson = JsonKt.Json$default((Json) null, new Function1() { // from class: io.ktor.serialization.kotlinx.json.JsonSupportKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit DefaultJson$lambda$0;
            DefaultJson$lambda$0 = JsonSupportKt.DefaultJson$lambda$0((JsonBuilder) obj);
            return DefaultJson$lambda$0;
        }
    }, 1, (Object) null);

    public static final Json getDefaultJson() {
        return DefaultJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setEncodeDefaults(true);
        $this$Json.setLenient(true);
        $this$Json.setAllowSpecialFloatingPointValues(true);
        $this$Json.setAllowStructuredMapKeys(true);
        $this$Json.setPrettyPrint(false);
        $this$Json.setUseArrayPolymorphism(false);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void json$default(Configuration configuration, Json json, ContentType contentType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            json = DefaultJson;
        }
        if ((i2 & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        json(configuration, json, contentType);
    }

    public static final void json(Configuration $this$json, Json json, ContentType contentType) {
        Intrinsics.checkNotNullParameter($this$json, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        KotlinxSerializationConverterKt.serialization($this$json, contentType, (StringFormat) json);
    }

    public static /* synthetic */ void jsonIo$default(Configuration configuration, Json json, ContentType contentType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            json = DefaultJson;
        }
        if ((i2 & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        jsonIo(configuration, json, contentType);
    }

    @ExperimentalSerializationApi
    public static final void jsonIo(Configuration $this$jsonIo, Json json, ContentType contentType) {
        Intrinsics.checkNotNullParameter($this$jsonIo, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Configuration.DefaultImpls.register$default($this$jsonIo, contentType, new ExperimentalJsonConverter(json), null, 4, null);
    }
}