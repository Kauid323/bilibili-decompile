package video.common.sharedata.model;

import io.ktor.http.CodecsKt;
import io.ktor.http.URLUtilsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShareData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0082\b¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u0002H\u0005H\u0082\b¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"PRELOAD_INFO_KEY", "", "json", "Lkotlinx/serialization/json/Json;", "mFromJson", "T", "jsonString", "(Ljava/lang/String;)Ljava/lang/Object;", "getQueryParam", "key", "toJsonObject", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonObject;", "mergeJsonObjects", "obj1", "obj2", "sharedata_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoShareDataKt {
    private static final String PRELOAD_INFO_KEY = "preload_info";
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: video.common.sharedata.model.VideoShareDataKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = VideoShareDataKt.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }

    private static final /* synthetic */ <T> T mFromJson(String jsonString) {
        if (jsonString != null) {
            try {
                String decodedString = CodecsKt.decodeURLPart$default(jsonString, 0, 0, (Charset) null, 7, (Object) null);
                if (decodedString != null && !StringsKt.isBlank(decodedString)) {
                    Json this_$iv = json;
                    SerializersModule serializersModule = this_$iv.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "T");
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    return (T) this_$iv.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), decodedString);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getQueryParam(String $this$getQueryParam, String key) {
        try {
            String str = URLUtilsKt.URLBuilder(CodecsKt.decodeURLPart$default($this$getQueryParam, 0, 0, (Charset) null, 7, (Object) null)).build().getParameters().get(key);
            return str == null ? "" : str;
        } catch (Exception e) {
            return "";
        }
    }

    private static final /* synthetic */ <T> JsonObject toJsonObject(T t) {
        try {
            Json this_$iv = json;
            StringFormat $this$encodeToString$iv = json;
            SerializersModule serializersModule = $this$encodeToString$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            String string$iv = $this$encodeToString$iv.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
            this_$iv.getSerializersModule();
            return (JsonObject) this_$iv.decodeFromString(JsonObject.Companion.serializer(), string$iv);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject mergeJsonObjects(JsonObject obj1, JsonObject obj2) {
        Iterable entrySet;
        Iterable entrySet2;
        Map mergedMap = new LinkedHashMap();
        if (obj1 != null && (entrySet2 = obj1.entrySet()) != null) {
            Iterable $this$map$iv = entrySet2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Map.Entry it = (Map.Entry) item$iv$iv;
                destination$iv$iv.add((JsonElement) mergedMap.put(it.getKey(), it.getValue()));
            }
            ArrayList arrayList = (List) destination$iv$iv;
        }
        if (obj2 != null && (entrySet = obj2.entrySet()) != null) {
            Iterable $this$map$iv2 = entrySet;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                Map.Entry it2 = (Map.Entry) item$iv$iv2;
                destination$iv$iv2.add((JsonElement) mergedMap.put(it2.getKey(), it2.getValue()));
            }
            ArrayList arrayList2 = (List) destination$iv$iv2;
        }
        return new JsonObject(mergedMap);
    }
}