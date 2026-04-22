package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\t¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/base/config/PreferencesReadProxy;", "", "sp", "Lkntr/base/config/KPreferences;", "memory", "Lkntr/base/config/PendingPreferencesValue;", "<init>", "(Lkntr/base/config/KPreferences;Lkntr/base/config/PendingPreferencesValue;)V", "get", "T", "key", "", "type", "Lkotlin/reflect/KClass;", "default", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreferencesReadProxy {
    private final PendingPreferencesValue memory;
    private final KPreferences sp;

    public PreferencesReadProxy(KPreferences sp, PendingPreferencesValue memory) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        this.sp = sp;
        this.memory = memory;
    }

    public /* synthetic */ PreferencesReadProxy(KPreferences kPreferences, PendingPreferencesValue pendingPreferencesValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kPreferences, (i & 2) != 0 ? null : pendingPreferencesValue);
    }

    public static /* synthetic */ Object get$default(PreferencesReadProxy preferencesReadProxy, String str, KClass kClass, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return preferencesReadProxy.get(str, kClass, obj);
    }

    public final <T> T get(String key, KClass<T> kClass, T t) {
        T t2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kClass, "type");
        PendingPreferencesValue pendingPreferencesValue = this.memory;
        return (pendingPreferencesValue == null || (t2 = (T) pendingPreferencesValue.get(kClass)) == null) ? (T) this.sp.get(key, kClass, t) : t2;
    }
}