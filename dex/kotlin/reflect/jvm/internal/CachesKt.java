package kotlin.reflect.jvm.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers;

/* compiled from: caches.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a \u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a6\u0010\u001a\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0000\u001a6\u0010\u001d\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0002\"$\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"6\u0010\u0017\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0019\u0012\u0004\u0012\u00020\u00100\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\u0012\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u00132\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013¨\u0006\u001e"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/CacheByClass;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "K_PACKAGE_CACHE", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "getOrCreateKotlinClass", "T", "jClass", "Ljava/lang/Class;", "getOrCreateKotlinPackage", "Lkotlin/reflect/KDeclarationContainer;", "clearCaches", "", "CACHE_FOR_BASE_CLASSIFIERS", "Lkotlin/reflect/KType;", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Key", "Lkotlin/Pair;", "", "Lkotlin/reflect/KTypeProjection;", "", "CACHE_FOR_GENERIC_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/reflect/jvm/internal/Key;", "getOrCreateKType", "arguments", "isMarkedNullable", "getOrCreateKTypeWithTypeArguments", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CachesKt {
    private static final CacheByClass<KClassImpl<? extends Object>> K_CLASS_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KClassImpl K_CLASS_CACHE$lambda$0;
            K_CLASS_CACHE$lambda$0 = CachesKt.K_CLASS_CACHE$lambda$0((Class) obj);
            return K_CLASS_CACHE$lambda$0;
        }
    });
    private static final CacheByClass<KPackageImpl> K_PACKAGE_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KPackageImpl K_PACKAGE_CACHE$lambda$0;
            K_PACKAGE_CACHE$lambda$0 = CachesKt.K_PACKAGE_CACHE$lambda$0((Class) obj);
            return K_PACKAGE_CACHE$lambda$0;
        }
    });
    private static final CacheByClass<KType> CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$2
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KType CACHE_FOR_BASE_CLASSIFIERS$lambda$0;
            CACHE_FOR_BASE_CLASSIFIERS$lambda$0 = CachesKt.CACHE_FOR_BASE_CLASSIFIERS$lambda$0((Class) obj);
            return CACHE_FOR_BASE_CLASSIFIERS$lambda$0;
        }
    });
    private static final CacheByClass<KType> CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$3
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$0;
            CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$0 = CachesKt.CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$0((Class) obj);
            return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$0;
        }
    });
    private static final CacheByClass<ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType>> CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$4
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$0;
            CACHE_FOR_GENERIC_CLASSIFIERS$lambda$0 = CachesKt.CACHE_FOR_GENERIC_CLASSIFIERS$lambda$0((Class) obj);
            return CACHE_FOR_GENERIC_CLASSIFIERS$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassImpl K_CLASS_CACHE$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KClassImpl(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KPackageImpl K_PACKAGE_CACHE$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KPackageImpl(it);
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        KClassImpl<? extends Object> kClassImpl = K_CLASS_CACHE.get(jClass);
        Intrinsics.checkNotNull(kClassImpl, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (KClassImpl<T>) kClassImpl;
    }

    public static final <T> KDeclarationContainer getOrCreateKotlinPackage(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return K_PACKAGE_CACHE.get(jClass);
    }

    public static final void clearCaches() {
        K_CLASS_CACHE.clear();
        K_PACKAGE_CACHE.clear();
        CACHE_FOR_BASE_CLASSIFIERS.clear();
        CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.clear();
        CACHE_FOR_GENERIC_CLASSIFIERS.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType CACHE_FOR_BASE_CLASSIFIERS$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(it), CollectionsKt.emptyList(), false, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(it), CollectionsKt.emptyList(), true, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConcurrentHashMap();
    }

    public static final <T> KType getOrCreateKType(Class<T> jClass, List<KTypeProjection> arguments, boolean isMarkedNullable) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.isEmpty()) {
            if (isMarkedNullable) {
                return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(jClass);
            }
            return CACHE_FOR_BASE_CLASSIFIERS.get(jClass);
        }
        return getOrCreateKTypeWithTypeArguments(jClass, arguments, isMarkedNullable);
    }

    private static final <T> KType getOrCreateKTypeWithTypeArguments(Class<T> cls, List<KTypeProjection> list, boolean isMarkedNullable) {
        Object putIfAbsent;
        ConcurrentMap $this$getOrPut$iv = (ConcurrentHashMap) CACHE_FOR_GENERIC_CLASSIFIERS.get(cls);
        Pair pair = TuplesKt.to(list, Boolean.valueOf(isMarkedNullable));
        Object default$iv = $this$getOrPut$iv.get(pair);
        if (default$iv == null && (putIfAbsent = $this$getOrPut$iv.putIfAbsent(pair, (default$iv = KClassifiers.createType(getOrCreateKotlinClass(cls), list, isMarkedNullable, CollectionsKt.emptyList())))) != null) {
            default$iv = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(default$iv, "getOrPut(...)");
        return (KType) default$iv;
    }
}