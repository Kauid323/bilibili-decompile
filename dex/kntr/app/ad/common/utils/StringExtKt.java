package kntr.app.ad.common.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.crypto.MD5_androidKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* compiled from: StringExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0001\u001a\u0014\u0010\t\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0006\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0002\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0002*\u00020\u0002¨\u0006\u0010"}, d2 = {"toIntOrZero", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "toLongOrZero", RoomRecommendViewModel.EMPTY_CURSOR, "toFloatOrZero", RoomRecommendViewModel.EMPTY_CURSOR, "toIntOr", "defaultVal", "toLongOr", "toFloatOr", "toJsonObject", "Lkotlinx/serialization/json/JsonObject;", "base64Encode", "base64Decode", "md5", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringExtKt {
    public static final int toIntOrZero(String $this$toIntOrZero) {
        return toIntOr($this$toIntOrZero, 0);
    }

    public static final long toLongOrZero(String $this$toLongOrZero) {
        return toLongOr($this$toLongOrZero, 0L);
    }

    public static final float toFloatOrZero(String $this$toFloatOrZero) {
        return toFloatOr($this$toFloatOrZero, 0.0f);
    }

    public static final int toIntOr(String $this$toIntOr, int defaultVal) {
        Integer intOrNull;
        return ($this$toIntOr == null || (intOrNull = StringsKt.toIntOrNull($this$toIntOr)) == null) ? defaultVal : intOrNull.intValue();
    }

    public static final long toLongOr(String $this$toLongOr, long defaultVal) {
        Long longOrNull;
        return ($this$toLongOr == null || (longOrNull = StringsKt.toLongOrNull($this$toLongOr)) == null) ? defaultVal : longOrNull.longValue();
    }

    public static final float toFloatOr(String $this$toFloatOr, float defaultVal) {
        Float floatOrNull;
        return ($this$toFloatOr == null || (floatOrNull = StringsKt.toFloatOrNull($this$toFloatOr)) == null) ? defaultVal : floatOrNull.floatValue();
    }

    public static final JsonObject toJsonObject(String $this$toJsonObject) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$toJsonObject, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(JsonElementKt.getJsonObject(Json.Default.parseToJsonElement($this$toJsonObject)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (JsonObject) obj;
    }

    public static final String base64Encode(String $this$base64Encode) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$base64Encode, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Base64.encode$default(Base64.Default, StringsKt.encodeToByteArray($this$base64Encode), 0, 0, 6, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final String base64Decode(String $this$base64Decode) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$base64Decode, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(StringsKt.decodeToString(Base64.decode$default(Base64.Default, StringsKt.encodeToByteArray($this$base64Decode), 0, 0, 6, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final String md5(String $this$md5) {
        Intrinsics.checkNotNullParameter($this$md5, "<this>");
        return MD5_androidKt.encryptMd5($this$md5);
    }
}