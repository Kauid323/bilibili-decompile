package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Serializers.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0014\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0001\u001a7\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0086\b\u001a6\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001aG\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0002\b\u001a\u001a7\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u000fH\u0002¢\u0006\u0002\b\u001c\u001a1\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\f0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0006\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0002\b\u001f\u001aB\u0010 \u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0000\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u0007H\u0007\u001a\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0006\b\u0000\u0010\f\u0018\u0001*\u00020\u0005H\u0086\b\u001a:\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u001a\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013\u001aG\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0001*\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\b#\u001a+\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0002\b&\u001a$\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u0007H\u0007\u001a\u001c\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013\u001a2\u0010'\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\u0018\u00010\u000f*\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010%\u001a\u00020\u0011H\u0000¨\u0006)"}, d2 = {"noCompiledSerializer", "Lkotlinx/serialization/KSerializer;", "forClass", "", "module", "Lkotlinx/serialization/modules/SerializersModule;", "kClass", "Lkotlin/reflect/KClass;", "argSerializers", "", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "serializer", "T", "", "typeArgumentsSerializers", "", "isNullable", "", "type", "Lkotlin/reflect/KType;", "serializerOrNull", "builtinParametrizedSerializer", "serializers", "elementClassifierIfArray", "Lkotlin/Function0;", "Lkotlin/reflect/KClassifier;", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "parametrizedSerializerOrNull", "serializerByKClassImpl", "rootClass", "serializerByKClassImpl$SerializersKt__SerializersKt", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializersForParameters", "typeArguments", "kotlinx-serialization-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
public final /* synthetic */ class SerializersKt__SerializersKt {
    public static final /* synthetic */ <T> KSerializer<T> serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer $this$cast$iv = SerializersKt.serializer((KType) null);
        Intrinsics.checkNotNull($this$cast$iv, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$cast$iv;
    }

    public static final /* synthetic */ <T> KSerializer<T> serializer(SerializersModule $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer $this$cast$iv = SerializersKt.serializer($this$serializer, (KType) null);
        Intrinsics.checkNotNull($this$cast$iv, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$cast$iv;
    }

    public static final KSerializer<Object> serializer(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(KClass<?> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), kClass, typeArgumentsSerializers, isNullable);
    }

    public static final KSerializer<Object> serializerOrNull(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializer, type, true);
        if (serializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return serializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(type));
        throw new KotlinNothingValueException();
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KClass<?> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        KSerializer<Object> serializerByKClassImpl$SerializersKt__SerializersKt = serializerByKClassImpl$SerializersKt__SerializersKt($this$serializer, kClass, typeArgumentsSerializers, isNullable);
        if (serializerByKClassImpl$SerializersKt__SerializersKt != null) {
            return serializerByKClassImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializerOrNull, type, false);
    }

    private static final KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKTypeImpl, KType type, boolean failOnMissingTypeArgSerializer) {
        KSerializer cachedSerializer;
        KSerializer contextualSerializer;
        KClass rootClass = Platform_commonKt.kclass(type);
        boolean isNullable = type.isMarkedNullable();
        Iterable $this$map$iv = type.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KTypeProjection it = (KTypeProjection) item$iv$iv;
            KType type2 = it.getType();
            if (type2 == null) {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + type).toString());
            }
            destination$iv$iv.add(type2);
        }
        final List typeArguments = (List) destination$iv$iv;
        if (typeArguments.isEmpty()) {
            cachedSerializer = SerializersCacheKt.findCachedSerializer(rootClass, isNullable);
        } else {
            Object cachedResult = SerializersCacheKt.findParametrizedCachedSerializer(rootClass, typeArguments, isNullable);
            if (failOnMissingTypeArgSerializer) {
                cachedSerializer = (KSerializer) (Result.isFailure-impl(cachedResult) ? null : cachedResult);
            } else if (Result.exceptionOrNull-impl(cachedResult) != null) {
                return null;
            } else {
                cachedSerializer = (KSerializer) cachedResult;
            }
        }
        if (cachedSerializer != null) {
            KSerializer it2 = cachedSerializer;
            return it2;
        }
        if (typeArguments.isEmpty()) {
            contextualSerializer = SerializersModule.getContextual$default($this$serializerByKTypeImpl, rootClass, null, 2, null);
        } else {
            List serializers = SerializersKt.serializersForParameters($this$serializerByKTypeImpl, typeArguments, failOnMissingTypeArgSerializer);
            if (serializers == null) {
                return null;
            }
            KSerializer parametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(rootClass, serializers, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final KClassifier invoke() {
                    return typeArguments.get(0).getClassifier();
                }
            });
            if (parametrizedSerializerOrNull != null) {
                contextualSerializer = parametrizedSerializerOrNull;
            } else {
                contextualSerializer = $this$serializerByKTypeImpl.getContextual(rootClass, serializers);
            }
        }
        if (contextualSerializer != null) {
            KSerializer $this$cast$iv = contextualSerializer;
            return nullable$SerializersKt__SerializersKt($this$cast$iv, isNullable);
        }
        return null;
    }

    private static final KSerializer<Object> serializerByKClassImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKClassImpl, KClass<Object> kClass, List<? extends KSerializer<Object>> list, boolean isNullable) {
        KSerializer serializer;
        if (list.isEmpty()) {
            serializer = SerializersKt.serializerOrNull(kClass);
            if (serializer == null) {
                serializer = SerializersModule.getContextual$default($this$serializerByKClassImpl, kClass, null, 2, null);
            }
        } else {
            try {
                serializer = SerializersKt.parametrizedSerializerOrNull(kClass, list, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersKt__SerializersKt$serializerByKClassImpl$serializer$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KClassifier invoke() {
                        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
                    }
                });
                if (serializer == null) {
                    serializer = $this$serializerByKClassImpl.getContextual(kClass, list);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new SerializationException("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", e);
            }
        }
        if (serializer != null) {
            KSerializer $this$cast$iv = serializer;
            return nullable$SerializersKt__SerializersKt($this$cast$iv, isNullable);
        }
        return null;
    }

    public static final List<KSerializer<Object>> serializersForParameters(SerializersModule $this$serializersForParameters, List<? extends KType> typeArguments, boolean failOnMissingTypeArgSerializer) {
        Intrinsics.checkNotNullParameter($this$serializersForParameters, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (failOnMissingTypeArgSerializer) {
            List<? extends KType> $this$map$iv = typeArguments;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KType it = (KType) item$iv$iv;
                destination$iv$iv.add(SerializersKt.serializer($this$serializersForParameters, it));
            }
            List serializers = (List) destination$iv$iv;
            return serializers;
        }
        List<? extends KType> $this$map$iv2 = typeArguments;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KType it2 = (KType) item$iv$iv2;
            KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull($this$serializersForParameters, it2);
            if (serializerOrNull == null) {
                return null;
            }
            destination$iv$iv2.add(serializerOrNull);
        }
        List serializers2 = (List) destination$iv$iv2;
        return serializers2;
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> serializerOrNull = SerializersKt.serializerOrNull(kClass);
        if (serializerOrNull != null) {
            return serializerOrNull;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> compiledSerializerImpl = PlatformKt.compiledSerializerImpl(kClass);
        return compiledSerializerImpl == null ? PrimitivesKt.builtinSerializerOrNull(kClass) : compiledSerializerImpl;
    }

    public static final KSerializer<? extends Object> parametrizedSerializerOrNull(KClass<Object> kClass, List<? extends KSerializer<Object>> serializers, Function0<? extends KClassifier> elementClassifierIfArray) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(elementClassifierIfArray, "elementClassifierIfArray");
        KSerializer<? extends Object> builtinParametrizedSerializer$SerializersKt__SerializersKt = builtinParametrizedSerializer$SerializersKt__SerializersKt(kClass, serializers, elementClassifierIfArray);
        return builtinParametrizedSerializer$SerializersKt__SerializersKt == null ? compiledParametrizedSerializer$SerializersKt__SerializersKt(kClass, serializers) : builtinParametrizedSerializer$SerializersKt__SerializersKt;
    }

    private static final KSerializer<? extends Object> compiledParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        List<? extends KSerializer<Object>> $this$toTypedArray$iv = list;
        KSerializer[] kSerializerArr = (KSerializer[]) $this$toTypedArray$iv.toArray(new KSerializer[0]);
        return PlatformKt.constructSerializerForGivenTypeArgs(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final KSerializer<? extends Object> builtinParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Collection.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            return new ArrayListSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashSet.class))) {
            return new HashSetSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashMap.class))) {
            return new HashMapSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
            return BuiltinSerializersKt.MapEntrySerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
            return BuiltinSerializersKt.PairSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Triple.class))) {
            return BuiltinSerializersKt.TripleSerializer(list.get(0), list.get(1), list.get(2));
        }
        if (PlatformKt.isReferenceArray(kClass)) {
            KClassifier invoke = function0.invoke();
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            return BuiltinSerializersKt.ArraySerializer((KClass) invoke, list.get(0));
        }
        return null;
    }

    private static final <T> KSerializer<T> nullable$SerializersKt__SerializersKt(KSerializer<T> kSerializer, boolean shouldBeNullable) {
        if (shouldBeNullable) {
            return BuiltinSerializersKt.getNullable(kSerializer);
        }
        Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<?> noCompiledSerializer(String forClass) {
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(forClass));
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        KSerializer<?> contextual$default = SerializersModule.getContextual$default(module, kClass, null, 2, null);
        if (contextual$default != null) {
            return contextual$default;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass, KSerializer<?>[] argSerializers) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(argSerializers, "argSerializers");
        KSerializer<?> contextual = module.getContextual(kClass, ArraysKt.asList(argSerializers));
        if (contextual != null) {
            return contextual;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }
}