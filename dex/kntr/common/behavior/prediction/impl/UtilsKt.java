package kntr.common.behavior.prediction.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a \u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u0010\r\u001a \u0010\u000e\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\u000f\u001a\u0002H\u000bH\u0080\b¢\u0006\u0002\u0010\u0010\u001a4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0018H\u0000\u001a\b\u0010\u0019\u001a\u00020\u001aH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"LOG_TAG", "", "logV", "", "tag", "msg", "logI", "logE", "deleteEscaped", "fixJson", "decodeFromString", "T", "jsonStr", "(Ljava/lang/String;)Ljava/lang/Object;", "encodeToString", "data", "(Ljava/lang/Object;)Ljava/lang/String;", "getSetValue", "", "Lkntr/base/config/KConfig;", "key", "defaultValue", "delimiters", "getIntValue", "", "currentTimestamp", "", "behavior-prediction_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    private static final String LOG_TAG = "BehaviorPrediction";

    public static final void logV(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().v(LOG_TAG, "<" + tag + "> " + msg);
    }

    public static final void logI(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().i(LOG_TAG, "<" + tag + "> " + msg);
    }

    public static final void logE(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().e(LOG_TAG, "<" + tag + "> " + msg);
    }

    private static final String deleteEscaped(String $this$deleteEscaped) {
        return StringsKt.replace$default(StringsKt.replace$default($this$deleteEscaped, "\\\"", "\"", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
    }

    public static final String fixJson(String $this$fixJson) {
        String fixed;
        if (StringsKt.startsWith$default($this$fixJson, "\"", false, 2, (Object) null) && StringsKt.endsWith$default($this$fixJson, "\"", false, 2, (Object) null)) {
            fixed = $this$fixJson.substring(1, $this$fixJson.length() - 1);
            Intrinsics.checkNotNullExpressionValue(fixed, "substring(...)");
        } else {
            fixed = $this$fixJson;
        }
        return deleteEscaped(fixed);
    }

    public static final /* synthetic */ <T> T decodeFromString(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            Json json = JsonKt.Json$default((Json) null, UtilsKt$decodeFromString$json$1.INSTANCE, 1, (Object) null);
            String string$iv = fixJson(jsonStr);
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            return (T) json.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), string$iv);
        } catch (Exception e) {
            logE("JsonUtils", "decodeFromString error.");
            return null;
        }
    }

    public static final /* synthetic */ <T> String encodeToString(T t) {
        try {
            StringFormat $this$encodeToString$iv = JsonKt.Json$default((Json) null, UtilsKt$encodeToString$json$1.INSTANCE, 1, (Object) null);
            SerializersModule serializersModule = $this$encodeToString$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            return $this$encodeToString$iv.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
        } catch (Exception e) {
            logE("JsonUtils", "encodeToString error.");
            return null;
        }
    }

    public static /* synthetic */ Set getSetValue$default(KConfig kConfig, String str, Set set, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            str2 = ",";
        }
        return getSetValue(kConfig, str, set, str2);
    }

    public static final Set<String> getSetValue(KConfig $this$getSetValue, String key, Set<String> set, String delimiters) {
        Iterable split$default;
        Intrinsics.checkNotNullParameter($this$getSetValue, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(set, "defaultValue");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        String config$default = IPlatformConfig.CC.config$default($this$getSetValue, key, null, 2, null);
        if (config$default != null && (split$default = StringsKt.split$default(config$default, new String[]{delimiters}, false, 0, 6, (Object) null)) != null) {
            Iterable $this$map$iv = split$default;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(StringsKt.trim(it).toString());
            }
            Set<String> set2 = CollectionsKt.toSet((List) destination$iv$iv);
            if (set2 != null) {
                return set2;
            }
        }
        return set;
    }

    public static final int getIntValue(KConfig $this$getIntValue, String key, int defaultValue) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter($this$getIntValue, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String config$default = IPlatformConfig.CC.config$default($this$getIntValue, key, null, 2, null);
        return (config$default == null || (intOrNull = StringsKt.toIntOrNull(config$default)) == null) ? defaultValue : intOrNull.intValue();
    }

    public static final long currentTimestamp() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }
}