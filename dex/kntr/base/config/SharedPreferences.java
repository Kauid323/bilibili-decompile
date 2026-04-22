package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u0002H\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003J-\u0010\u0017\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012¢\u0006\u0002\u0010\u0018J3\u0010\u0017\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u0006\u0010\u0016\u001a\u0002H\u000e¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c2\u0006\u0010\u000f\u001a\u00020\u0003H\u0007J0\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\u001c\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012H\u0017R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lkntr/base/config/SharedPreferences;", "", "spName", "", "multiProcess", "", "<init>", "(Ljava/lang/String;Z)V", "sp", "Lkntr/base/config/KPreferences;", "getSp$preferences_debug", "()Lkntr/base/config/KPreferences;", "set", "", "T", "key", "value", "type", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)V", "setString", "getString", "default", "get", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "clear", "asStringFlow", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class SharedPreferences {
    private final KPreferences sp;

    public SharedPreferences(String spName, boolean multiProcess) {
        Intrinsics.checkNotNullParameter(spName, "spName");
        this.sp = new KPreferences(spName, multiProcess);
    }

    public /* synthetic */ SharedPreferences(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final KPreferences getSp$preferences_debug() {
        return this.sp;
    }

    public final <T> void set(String key, T t, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(kClass, "type");
        this.sp.set(key, t, kClass);
    }

    public final void setString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        set(key, value, Reflection.getOrCreateKotlinClass(String.class));
    }

    public static /* synthetic */ String getString$default(SharedPreferences sharedPreferences, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return sharedPreferences.getString(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
    }

    public final String getString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (String) this.sp.get(key, Reflection.getOrCreateKotlinClass(String.class), str);
    }

    public final <T> T get(String key, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kClass, "type");
        return (T) KPreferences.get$default(this.sp, key, kClass, null, 4, null);
    }

    public final <T> T get(String key, KClass<T> kClass, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(t, "default");
        T t2 = (T) this.sp.get(key, kClass, t);
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    public final void clear() {
        this.sp.clear();
    }

    public final Flow<String> asStringFlow(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return asFlow(key, Reflection.getOrCreateKotlinClass(String.class));
    }

    public <T> Flow<T> asFlow(String key, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kClass, "type");
        return FlowKt.onStart(FlowKt.callbackFlow(new SharedPreferences$asFlow$1(this, key, kClass, null)), new SharedPreferences$asFlow$2(this, key, kClass, null));
    }
}