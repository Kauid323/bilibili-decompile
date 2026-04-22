package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkntr/base/config/PendingPreferencesValue;", "", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "get", "T", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PendingPreferencesValue {
    private final String value;

    public static /* synthetic */ PendingPreferencesValue copy$default(PendingPreferencesValue pendingPreferencesValue, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingPreferencesValue.value;
        }
        return pendingPreferencesValue.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final PendingPreferencesValue copy(String str) {
        return new PendingPreferencesValue(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PendingPreferencesValue) && Intrinsics.areEqual(this.value, ((PendingPreferencesValue) obj).value);
    }

    public int hashCode() {
        if (this.value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    public String toString() {
        return "PendingPreferencesValue(value=" + this.value + ")";
    }

    public PendingPreferencesValue(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }

    public final <T> T get(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            String str = this.value;
            Integer intOrNull = str != null ? StringsKt.toIntOrNull(str) : null;
            if (intOrNull == null) {
                return null;
            }
            return (T) intOrNull;
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            String str2 = this.value;
            Long longOrNull = str2 != null ? StringsKt.toLongOrNull(str2) : null;
            if (longOrNull == null) {
                return null;
            }
            return (T) longOrNull;
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            String str3 = this.value;
            Float floatOrNull = str3 != null ? StringsKt.toFloatOrNull(str3) : null;
            if (floatOrNull == null) {
                return null;
            }
            return (T) floatOrNull;
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            String str4 = this.value;
            Boolean booleanStrictOrNull = str4 != null ? StringsKt.toBooleanStrictOrNull(str4) : null;
            if (booleanStrictOrNull == null) {
                return null;
            }
            return (T) booleanStrictOrNull;
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            T t = (T) this.value;
            if (t == null) {
                return null;
            }
            return t;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + kClass);
        }
    }
}