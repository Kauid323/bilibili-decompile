package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\u001a\u0015\u0010\u0004\u001a\u00020\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007H\u0082\b\u001a\u0086\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b\"\u0006\b\u0000\u0010\u0006\u0018\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052>\b\n\u0010\u0010\u001a8\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0017\u0012\u00150\u0015j\u0002`\u0017¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u00112\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0019H\u0086\bø\u0001\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"KPreferencesListener", "Lkntr/base/config/PreferencesListener;", "json", "Lkotlinx/serialization/json/Json;", "isSupportedPrimitiveType", "", "T", "", "type", "Lkotlin/reflect/KClass;", "kGetPreferences", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "spName", "", "key", "multiProcess", "repair", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "jsonString", "Ljava/lang/IllegalArgumentException;", "jsonDecodeException", "Lkotlin/IllegalArgumentException;", "initializer", "Lkotlin/Function0;", "preferences_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KPreferencesKt {
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.config.KPreferencesKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = KPreferencesKt.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setLenient(true);
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setEncodeDefaults(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }

    public static final <T> boolean isSupportedPrimitiveType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return true;
        }
        return false;
    }

    private static final /* synthetic */ <T> boolean isSupportedPrimitiveType() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return isSupportedPrimitiveType(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ SerializableSharedPreferencesProperty kGetPreferences$default(String spName, String key, boolean multiProcess, Function2 repair, Function0 initializer, int i, Object obj) {
        if ((i & 1) != 0) {
            spName = "kntr-base-preferences";
        }
        if ((i & 4) != 0) {
            multiProcess = false;
        }
        if ((i & 8) != 0) {
            repair = null;
        }
        Intrinsics.checkNotNullParameter(spName, "spName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new SerializableSharedPreferencesProperty(spName, multiProcess, SerializersKt.serializer((KType) null), key, initializer, repair);
    }

    public static final /* synthetic */ <T> SerializableSharedPreferencesProperty<T> kGetPreferences(String spName, String key, boolean multiProcess, Function2<? super String, ? super IllegalArgumentException, ? extends T> function2, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(spName, "spName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new SerializableSharedPreferencesProperty<>(spName, multiProcess, SerializersKt.serializer((KType) null), key, function0, function2);
    }
}