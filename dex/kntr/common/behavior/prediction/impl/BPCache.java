package kntr.common.behavior.prediction.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BPCache.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J'\u0010\u0019\u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Lkntr/common/behavior/prediction/impl/BPCache;", "", "maxSize", "", "<init>", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "sp", "Lkntr/base/config/SharedPreferences;", "cacheMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "get", "key", "tag", "fromDisk", "", "set", "", "value", "toDisk", "namespacedKey", "synchronized", "T", "action", "Lkotlin/Function0;", "synchronized$behavior_prediction_debug", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BPCache {
    private final LinkedHashMap<String, String> cacheMap;
    private final ReentrantLock lock;
    private final int maxSize;
    private final SharedPreferences sp;

    public BPCache() {
        this(0, 1, null);
    }

    public BPCache(int maxSize) {
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();
        this.sp = new SharedPreferences("kntr-behavior-prediction-cache", true);
        this.cacheMap = new LinkedHashMap<>(this.maxSize, 0.75f);
    }

    public /* synthetic */ BPCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 256 : i);
    }

    public static /* synthetic */ String get$default(BPCache bPCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return bPCache.get(str, str2, z);
    }

    public final String get(String key, String tag, boolean fromDisk) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String it = namespacedKey(key, tag);
        this.lock.lock();
        try {
            String str = this.cacheMap.get(it);
            if (str == null) {
                if (fromDisk) {
                    return SharedPreferences.getString$default(this.sp, it, null, 2, null);
                }
                return null;
            }
            return str;
        } finally {
            this.lock.unlock();
        }
    }

    public static /* synthetic */ void set$default(BPCache bPCache, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            z = true;
        }
        bPCache.set(str, str2, str3, z);
    }

    public final void set(String key, String value, String tag, boolean toDisk) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String k = namespacedKey(key, tag);
        this.lock.lock();
        try {
            this.cacheMap.put(k, value);
            if (this.cacheMap.size() > this.maxSize) {
                Set<Map.Entry<String, String>> entrySet = this.cacheMap.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
                Object key2 = ((Map.Entry) CollectionsKt.first(entrySet)).getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                String eldestKey = (String) key2;
                this.cacheMap.remove(eldestKey);
            }
            Unit unit = Unit.INSTANCE;
            if (toDisk) {
                this.sp.setString(k, value);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private final String namespacedKey(String key, String tag) {
        return StringsKt.isBlank(tag) ? key : tag + ":" + key;
    }

    public final <T> T synchronized$behavior_prediction_debug(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.lock.lock();
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.lock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}