package kntr.app.mall.product.details.page.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Helper.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a@\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u0016\u0010\t\u001a\u00020\u0001*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001b\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0001¢\u0006\u0002\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u00020\u0011H\u0000\u001a\u001a\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004*\u00020\u0013H\u0000\u001a\u0014\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0015*\u00020\u0016H\u0000\u001a0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u0002H\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0080\b¢\u0006\u0002\u0010\u001a\u001a+\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0015\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0080\b¨\u0006\u001b"}, d2 = {"customizedImageUrl", "", "url", "buildShareParams", "", "", "imageUrl", "mSource", "extParams", "toCommaStringInternal", "", "splitter", "", "toCommaString", "placeholder", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "toFoundationValue", "Lkotlinx/serialization/json/JsonElement;", "toFoundationMap", "Lkotlinx/serialization/json/JsonObject;", "toFoundationList", "", "Lkotlinx/serialization/json/JsonArray;", "T", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/Object;Lkotlinx/serialization/json/Json;)Ljava/util/Map;", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HelperKt {
    public static final String customizedImageUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
            return "https:" + url;
        }
        return url;
    }

    public static /* synthetic */ Map buildShareParams$default(String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return buildShareParams(str, str2, map);
    }

    public static final Map<String, Object> buildShareParams(String imageUrl, String mSource, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(map, "extParams");
        Pair[] pairArr = new Pair[16];
        pairArr[0] = TuplesKt.to("shareImage", imageUrl);
        pairArr[1] = TuplesKt.to("imagePreview", true);
        pairArr[2] = TuplesKt.to("from", "NA");
        pairArr[3] = TuplesKt.to("msource", mSource == null ? "" : mSource);
        pairArr[4] = TuplesKt.to("previewY", 30);
        pairArr[5] = TuplesKt.to("showDownloadBtn", false);
        pairArr[6] = TuplesKt.to("maskClickCloseble", true);
        pairArr[7] = TuplesKt.to("buttons", CollectionsKt.listOf(new String[]{"WEIXIN", "WEIXIN_MOMENT", "QQ", "QZONE", "SINA", "biliDynamic", "COPY", "save_img"}));
        pairArr[8] = TuplesKt.to("logEventId", MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadClick", null), TuplesKt.to("channelClick", TrackConsts.MALL_MALL_DETAIL_SHARE_BOARD_0_CLICK), TuplesKt.to("show", null)}));
        pairArr[9] = TuplesKt.to("extraParams", map);
        pairArr[10] = TuplesKt.to("needJointExtraParam", 1);
        pairArr[11] = TuplesKt.to("shareWithLink", 1);
        pairArr[12] = TuplesKt.to("buttonMode", 2);
        pairArr[13] = TuplesKt.to("previewBorder", "#00000000");
        pairArr[14] = TuplesKt.to("previewBorderRadius", 0);
        pairArr[15] = TuplesKt.to("shortLink", 1);
        return MapsKt.mapOf(pairArr);
    }

    public static /* synthetic */ String toCommaStringInternal$default(long j, char c, int i, Object obj) {
        if ((i & 1) != 0) {
            c = ',';
        }
        return toCommaStringInternal(j, c);
    }

    public static final String toCommaStringInternal(long $this$toCommaStringInternal, char splitter) {
        if ($this$toCommaStringInternal == 0) {
            return "0";
        }
        boolean negative = $this$toCommaStringInternal < 0;
        String digits = String.valueOf(Math.abs($this$toCommaStringInternal));
        StringBuilder sb = new StringBuilder();
        int firstLen = digits.length() % 3;
        if (firstLen == 0) {
            firstLen = 3;
        }
        sb.append(StringsKt.take(digits, firstLen));
        for (int i = firstLen; i < digits.length(); i += 3) {
            sb.append(splitter);
            sb.append((CharSequence) digits, i, i + 3);
        }
        if (negative) {
            sb.insert(0, '-');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String toCommaString$default(Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "--";
        }
        return toCommaString(l, str);
    }

    public static final String toCommaString(Long $this$toCommaString, String placeholder) {
        String commaStringInternal$default;
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        return ($this$toCommaString == null || (commaStringInternal$default = toCommaStringInternal$default($this$toCommaString.longValue(), (char) 0, 1, null)) == null) ? placeholder : commaStringInternal$default;
    }

    public static final Object toFoundationValue(JsonElement $this$toFoundationValue) {
        Intrinsics.checkNotNullParameter($this$toFoundationValue, "<this>");
        if ($this$toFoundationValue instanceof JsonNull) {
            return null;
        }
        if ($this$toFoundationValue instanceof JsonPrimitive) {
            return ((JsonPrimitive) $this$toFoundationValue).isString() ? ((JsonPrimitive) $this$toFoundationValue).getContent() : JsonElementKt.getBooleanOrNull((JsonPrimitive) $this$toFoundationValue) != null ? JsonElementKt.getBooleanOrNull((JsonPrimitive) $this$toFoundationValue) : JsonElementKt.getLongOrNull((JsonPrimitive) $this$toFoundationValue) != null ? JsonElementKt.getLongOrNull((JsonPrimitive) $this$toFoundationValue) : JsonElementKt.getDoubleOrNull((JsonPrimitive) $this$toFoundationValue) != null ? JsonElementKt.getDoubleOrNull((JsonPrimitive) $this$toFoundationValue) : ((JsonPrimitive) $this$toFoundationValue).getContent();
        } else if ($this$toFoundationValue instanceof JsonObject) {
            return toFoundationMap((JsonObject) $this$toFoundationValue);
        } else {
            if (!($this$toFoundationValue instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            return toFoundationList((JsonArray) $this$toFoundationValue);
        }
    }

    public static final Map<String, Object> toFoundationMap(JsonObject $this$toFoundationMap) {
        Intrinsics.checkNotNullParameter($this$toFoundationMap, "<this>");
        Iterable $this$associate$iv = $this$toFoundationMap.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            String k = (String) entry.getKey();
            JsonElement v = (JsonElement) entry.getValue();
            Pair pair = TuplesKt.to(k, toFoundationValue(v));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    public static final List<Object> toFoundationList(JsonArray $this$toFoundationList) {
        Intrinsics.checkNotNullParameter($this$toFoundationList, "<this>");
        Iterable $this$map$iv = (Iterable) $this$toFoundationList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JsonElement it = (JsonElement) item$iv$iv;
            destination$iv$iv.add(toFoundationValue(it));
        }
        return (List) destination$iv$iv;
    }

    public static final /* synthetic */ <T> Map<String, Object> toFoundationMap(T t, Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        Object value$iv = json.encodeToJsonElement(SerializersKt.serializer(serializersModule, (KType) null), t);
        JsonObject jsonObject = value$iv instanceof JsonObject ? (JsonObject) value$iv : null;
        if (jsonObject != null) {
            JsonObject obj = jsonObject;
            return toFoundationMap(obj);
        }
        throw new IllegalStateException(("toFoundationMap() only supports objects, but got: " + value$iv).toString());
    }

    public static final /* synthetic */ <T> List<Object> toFoundationList(List<? extends T> list, Json json) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        int $i$f$toFoundationList = 0;
        List<? extends T> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            JsonElement element = json.encodeToJsonElement(SerializersKt.serializer(serializersModule, (KType) null), item$iv$iv);
            destination$iv$iv.add(toFoundationValue(element));
            $i$f$toFoundationList = $i$f$toFoundationList;
        }
        return (List) destination$iv$iv;
    }
}