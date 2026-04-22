package kntr.base.config;

import android.content.SharedPreferences;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* compiled from: KPreferences.android.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001H\u0015¢\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u001c\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u0002H\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u001a\u0010 \u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00032\n\u0010!\u001a\u00060\u0010j\u0002`\u0011J\u001a\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00032\n\u0010!\u001a\u00060\u0010j\u0002`\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkntr/base/config/KPreferences;", "", "spName", "", "multiProcess", "", "<init>", "(Ljava/lang/String;Z)V", "sp", "Lcom/bilibili/lib/blkv/SharedPrefX;", "getSp", "()Lcom/bilibili/lib/blkv/SharedPrefX;", "listeners", "Lkotlinx/atomicfu/AtomicRef;", "", "", "Lkntr/base/config/PreferencesListener;", "Lkntr/base/config/KPreferencesListener;", "spListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "get", "T", "key", "type", "Lkotlin/reflect/KClass;", "default", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)V", "clear", "addListener", "listener", "removeListener", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KPreferences {
    private final AtomicRef<Map<String, Set<PreferencesListener>>> listeners;
    private final SharedPrefX sp;
    private final SharedPreferences.OnSharedPreferenceChangeListener spListener;

    public KPreferences(String spName, boolean multiProcess) {
        Intrinsics.checkNotNullParameter(spName, "spName");
        this.sp = BLKV.getBLSharedPreferences$default(FoundationAlias.getFapp(), spName, multiProcess, 0, 4, (Object) null);
        this.listeners = AtomicFU.atomic(MapsKt.emptyMap());
        this.spListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: kntr.base.config.KPreferences$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, String str) {
                KPreferences.spListener$lambda$0(KPreferences.this, sharedPreferences, str);
            }
        };
    }

    public /* synthetic */ KPreferences(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final SharedPrefX getSp() {
        return this.sp;
    }

    public static final void spListener$lambda$0(KPreferences this$0, android.content.SharedPreferences sharedPreferences, String key) {
        Iterable iterable;
        if (key == null || (iterable = (Set) ((Map) this$0.listeners.getValue()).get(key)) == null) {
            return;
        }
        Iterable $this$forEach$iv = iterable;
        for (Object element$iv : $this$forEach$iv) {
            PreferencesListener it = (PreferencesListener) element$iv;
            it.onChanged(new PreferencesReadProxy(this$0, null, 2, null), key);
        }
    }

    public static /* synthetic */ Object get$default(KPreferences kPreferences, String str, KClass kClass, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return kPreferences.get(str, kClass, obj);
    }

    public final <T> T get(String key, KClass<T> kClass, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kClass, "type");
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            SharedPrefX sharedPrefX = this.sp;
            Integer num = t instanceof Integer ? (Integer) t : null;
            return (T) Integer.valueOf(sharedPrefX.getInt(key, num != null ? num.intValue() : 0));
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            SharedPrefX sharedPrefX2 = this.sp;
            Long l = t instanceof Long ? (Long) t : null;
            return (T) Long.valueOf(sharedPrefX2.getLong(key, l != null ? l.longValue() : 0L));
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            SharedPrefX sharedPrefX3 = this.sp;
            Float f = t instanceof Float ? (Float) t : null;
            return (T) Float.valueOf(sharedPrefX3.getFloat(key, f != null ? f.floatValue() : 0.0f));
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            SharedPrefX sharedPrefX4 = this.sp;
            Boolean bool = t instanceof Boolean ? (Boolean) t : null;
            return (T) Boolean.valueOf(sharedPrefX4.getBoolean(key, bool != null ? bool.booleanValue() : false));
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            T t2 = (T) this.sp.getString(key, t instanceof String ? (String) t : null);
            if (t2 == null) {
                return null;
            }
            return t2;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + kClass);
        }
    }

    public final <T> void set(String key, T t, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(kClass, "type");
        SharedPreferences.Editor $this$set_u24lambda_u240 = this.sp.edit();
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            $this$set_u24lambda_u240.putString(key, t instanceof String ? (String) t : null);
        } else {
            if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                Integer num = t instanceof Integer ? (Integer) t : null;
                $this$set_u24lambda_u240.putInt(key, num != null ? num.intValue() : 0);
            } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                Long l = t instanceof Long ? (Long) t : null;
                $this$set_u24lambda_u240.putLong(key, l != null ? l.longValue() : 0L);
            } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                Float f = t instanceof Float ? (Float) t : null;
                $this$set_u24lambda_u240.putFloat(key, f != null ? f.floatValue() : 0.0f);
            } else if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                throw new IllegalArgumentException("Unsupported type: " + kClass);
            } else {
                Boolean bool = t instanceof Boolean ? (Boolean) t : null;
                $this$set_u24lambda_u240.putBoolean(key, bool != null ? bool.booleanValue() : false);
            }
        }
        $this$set_u24lambda_u240.apply();
    }

    public final void clear() {
        this.sp.edit().clear().apply();
    }

    public final void addListener(String key, PreferencesListener listener) {
        Object cur$iv;
        Map $this$addListener_u24lambda_u240_u240;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AtomicRef $this$getAndUpdate$iv = this.listeners;
        do {
            cur$iv = $this$getAndUpdate$iv.getValue();
            Map it = (Map) cur$iv;
            $this$addListener_u24lambda_u240_u240 = MapsKt.toMutableMap(it);
            if (!it.containsKey(key)) {
                $this$addListener_u24lambda_u240_u240.put(key, SetsKt.setOf(listener));
            } else {
                Object obj = it.get(key);
                Intrinsics.checkNotNull(obj);
                Set $this$addListener_u24lambda_u240_u240_u240 = CollectionsKt.toMutableSet((Iterable) obj);
                $this$addListener_u24lambda_u240_u240_u240.add(listener);
                $this$addListener_u24lambda_u240_u240.put(key, CollectionsKt.toSet($this$addListener_u24lambda_u240_u240_u240));
            }
        } while (!$this$getAndUpdate$iv.compareAndSet(cur$iv, MapsKt.toMap($this$addListener_u24lambda_u240_u240)));
        boolean prevIsEmpty = ((Map) cur$iv).isEmpty();
        if (prevIsEmpty) {
            this.sp.registerOnSharedPreferenceChangeListener(this.spListener);
        }
    }

    public final void removeListener(String key, PreferencesListener listener) {
        Object cur$iv;
        Map it;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AtomicRef $this$updateAndGet$iv = this.listeners;
        do {
            cur$iv = $this$updateAndGet$iv.getValue();
            Map it2 = (Map) cur$iv;
            Map $this$removeListener_u24lambda_u240_u240 = MapsKt.toMutableMap(it2);
            if (it2.containsKey(key)) {
                Object obj = it2.get(key);
                Intrinsics.checkNotNull(obj);
                Set mutableSet = CollectionsKt.toMutableSet((Iterable) obj);
                mutableSet.remove(listener);
                if (!mutableSet.isEmpty()) {
                    $this$removeListener_u24lambda_u240_u240.put(key, CollectionsKt.toSet(mutableSet));
                } else {
                    $this$removeListener_u24lambda_u240_u240.remove(key);
                }
            }
            it = MapsKt.toMap($this$removeListener_u24lambda_u240_u240);
        } while (!$this$updateAndGet$iv.compareAndSet(cur$iv, it));
        boolean afterIsEmpty = it.isEmpty();
        if (afterIsEmpty) {
            this.sp.unregisterOnSharedPreferenceChangeListener(this.spListener);
        }
    }
}