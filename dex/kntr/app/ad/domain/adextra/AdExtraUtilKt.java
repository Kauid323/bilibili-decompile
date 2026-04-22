package kntr.app.ad.domain.adextra;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.common.utils.StringExtKt;
import kntr.app.ad.common.utils.StringExt_androidKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* compiled from: AdExtraUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"adPlayPage", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/json/JsonObject;", "getAdPlayPage", "(Lkotlinx/serialization/json/JsonObject;)I", "adDynamicDetail", "getAdDynamicDetail", "extraParams", "Lkotlinx/serialization/json/JsonElement;", "getExtraParams", "(Lkotlinx/serialization/json/JsonObject;)Lkotlinx/serialization/json/JsonElement;", "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "getSourceId", "(Lkotlinx/serialization/json/JsonObject;)J", "bizExtraObject", RoomRecommendViewModel.EMPTY_CURSOR, "getBizExtraObject", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;", "adextra_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUtilKt {
    public static final int getAdPlayPage(JsonObject $this$adPlayPage) {
        Object obj;
        JsonElement element$iv;
        Intrinsics.checkNotNullParameter($this$adPlayPage, "<this>");
        Object default$iv = 0;
        try {
            Result.Companion companion = Result.Companion;
            element$iv = (JsonElement) $this$adPlayPage.get("ad_play_page");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (element$iv == null) {
            return ((Number) default$iv).intValue();
        }
        Json $this$decodeFromJsonElement$iv$iv = JsonExtKt.getAdJson();
        $this$decodeFromJsonElement$iv$iv.getSerializersModule();
        obj = Result.constructor-impl($this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(IntSerializer.INSTANCE, element$iv));
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
        }
        boolean z = Result.isFailure-impl(obj);
        Object obj2 = obj;
        if (z) {
            obj2 = default$iv;
        }
        default$iv = obj2;
        return ((Number) default$iv).intValue();
    }

    public static final int getAdDynamicDetail(JsonObject $this$adDynamicDetail) {
        Object obj;
        JsonElement element$iv;
        Intrinsics.checkNotNullParameter($this$adDynamicDetail, "<this>");
        Object default$iv = 0;
        try {
            Result.Companion companion = Result.Companion;
            element$iv = (JsonElement) $this$adDynamicDetail.get("ad_dynamic_detail");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (element$iv == null) {
            return ((Number) default$iv).intValue();
        }
        Json $this$decodeFromJsonElement$iv$iv = JsonExtKt.getAdJson();
        $this$decodeFromJsonElement$iv$iv.getSerializersModule();
        obj = Result.constructor-impl($this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(IntSerializer.INSTANCE, element$iv));
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
        }
        boolean z = Result.isFailure-impl(obj);
        Object obj2 = obj;
        if (z) {
            obj2 = default$iv;
        }
        default$iv = obj2;
        return ((Number) default$iv).intValue();
    }

    public static final JsonElement getExtraParams(JsonObject $this$extraParams) {
        Intrinsics.checkNotNullParameter($this$extraParams, "<this>");
        return (JsonElement) $this$extraParams.get(ReportBuildInParam.EXTRA_PARAMS);
    }

    public static final long getSourceId(JsonObject $this$sourceId) {
        Long l;
        Number number;
        Object obj;
        JsonElement element$iv;
        if ($this$sourceId != null) {
            Object default$iv = 0L;
            try {
                Result.Companion companion = Result.Companion;
                element$iv = (JsonElement) $this$sourceId.get("source_id");
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (element$iv == null) {
                l = (Long) default$iv;
            } else {
                Json $this$decodeFromJsonElement$iv$iv = JsonExtKt.getAdJson();
                $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                obj = Result.constructor-impl($this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(LongSerializer.INSTANCE, element$iv));
                Throwable it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
                }
                boolean z = Result.isFailure-impl(obj);
                Object obj2 = obj;
                if (z) {
                    obj2 = default$iv;
                }
                default$iv = obj2;
                l = (Long) default$iv;
            }
        } else {
            l = null;
        }
        Number $this$orZero$iv = l;
        if ($this$orZero$iv != null) {
            number = $this$orZero$iv;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number = (Long) (byte) 0;
            }
        }
        return number.longValue();
    }

    public static final JsonObject getBizExtraObject(String $this$bizExtraObject) {
        Intrinsics.checkNotNullParameter($this$bizExtraObject, "<this>");
        String urlDecode = StringExt_androidKt.urlDecode($this$bizExtraObject);
        if (urlDecode != null) {
            return StringExtKt.toJsonObject(urlDecode);
        }
        return null;
    }
}