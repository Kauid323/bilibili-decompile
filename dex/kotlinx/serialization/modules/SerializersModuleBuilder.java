package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerializersModuleCollector;

/* compiled from: SerializersModuleBuilders.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0001JQ\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052/\u0010\u001c\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u001d¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\bH\u0016J.\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0013H\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0016JF\u0010\"\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a\"\b\b\u0001\u0010$*\u0002H#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H$0\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H$0\u0013H\u0016JM\u0010(\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052+\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\r0\bH\u0016JK\u0010*\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052)\u0010+\u001a%\u0012\u0013\u0012\u0011H#¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\u00100\bH\u0016JU\u0010-\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052+\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\r0\b2\u0006\u0010.\u001a\u00020/H\u0001JS\u00100\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052)\u0010+\u001a%\u0012\u0013\u0012\u0011H#¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010\u00100\b2\u0006\u0010.\u001a\u00020/H\u0001JP\u00101\u001a\u00020\u0018\"\b\b\u0000\u0010#*\u00020\u001a\"\b\b\u0001\u0010$*\u0002H#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u0002H$0\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u0002H$0\u00132\b\b\u0002\u0010.\u001a\u00020/H\u0001J2\u00104\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00052\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020/H\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u0007\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\bj\u0006\u0012\u0002\b\u0003`\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u000f\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\bj\u0006\u0012\u0002\b\u0003`\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "()V", "class2ContextualProvider", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2DefaultDeserializerProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultSerializerProvider", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "build", "Lkotlinx/serialization/modules/SerializersModule;", "contextual", "", "T", "", "kClass", "provider", "", "typeArgumentsSerializers", "serializer", "include", "module", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "registerDefaultPolymorphicDeserializer", "allowOverwrite", "", "registerDefaultPolymorphicSerializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "registerSerializer", "forClass", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    private final Map<KClass<?>, ContextualProvider> class2ContextualProvider = new HashMap();
    private final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers = new HashMap();
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider = new HashMap();
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers = new HashMap();
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider = new HashMap();

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
    public <Base> void polymorphicDefault(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        SerializersModuleCollector.DefaultImpls.polymorphicDefault(this, kClass, function1);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        registerSerializer$default(this, kClass, new ContextualProvider.Argless(serializer), false, 4, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        registerSerializer$default(this, kClass, new ContextualProvider.WithTypeArguments(provider), false, 4, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        registerPolymorphicSerializer$default(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, false);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, false);
    }

    public final void include(SerializersModule module) {
        Intrinsics.checkNotNullParameter(module, "module");
        module.dumpTo(this);
    }

    public static /* synthetic */ void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, ContextualProvider contextualProvider, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerSerializer(kClass, contextualProvider, z);
    }

    public final <T> void registerSerializer(KClass<T> forClass, ContextualProvider provider, boolean allowOverwrite) {
        ContextualProvider previous;
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!allowOverwrite && (previous = this.class2ContextualProvider.get(forClass)) != null && !Intrinsics.areEqual(previous, provider)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        this.class2ContextualProvider.put(forClass, provider);
    }

    public final <Base> void registerDefaultPolymorphicSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider, boolean allowOverwrite) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        Function1 previous = this.polyBase2DefaultSerializerProvider.get(baseClass);
        if (previous != null && !Intrinsics.areEqual(previous, defaultSerializerProvider) && !allowOverwrite) {
            throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + previous);
        }
        this.polyBase2DefaultSerializerProvider.put(baseClass, defaultSerializerProvider);
    }

    public final <Base> void registerDefaultPolymorphicDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider, boolean allowOverwrite) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        Function1 previous = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        if (previous != null && !Intrinsics.areEqual(previous, defaultDeserializerProvider) && !allowOverwrite) {
            throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + previous);
        }
        this.polyBase2DefaultDeserializerProvider.put(baseClass, defaultDeserializerProvider);
    }

    public static /* synthetic */ void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KClass kClass2, KSerializer kSerializer, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(kClass, kClass2, kSerializer, z);
    }

    public final <Base, Sub extends Base> void registerPolymorphicSerializer(KClass<Base> baseClass, KClass<Sub> concreteClass, KSerializer<Sub> concreteSerializer, boolean allowOverwrite) {
        HashMap $this$getOrPut$iv;
        HashMap $this$getOrPut$iv2;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        Intrinsics.checkNotNullParameter(concreteSerializer, "concreteSerializer");
        String name = concreteSerializer.getDescriptor().getSerialName();
        Map $this$getOrPut$iv3 = this.polyBase2Serializers;
        Map<KClass<?>, KSerializer<?>> map = $this$getOrPut$iv3.get(baseClass);
        if (map == null) {
            $this$getOrPut$iv = new HashMap();
            $this$getOrPut$iv3.put(baseClass, $this$getOrPut$iv);
        } else {
            $this$getOrPut$iv = map;
        }
        Map baseClassSerializers = $this$getOrPut$iv;
        KSerializer<?> previousSerializer = baseClassSerializers.get(concreteClass);
        Map $this$getOrPut$iv4 = this.polyBase2NamedSerializers;
        Map<String, KSerializer<?>> map2 = $this$getOrPut$iv4.get(baseClass);
        if (map2 == null) {
            $this$getOrPut$iv2 = new HashMap();
            $this$getOrPut$iv4.put(baseClass, $this$getOrPut$iv2);
        } else {
            $this$getOrPut$iv2 = map2;
        }
        Map names = $this$getOrPut$iv2;
        if (allowOverwrite) {
            if (previousSerializer != null) {
                names.remove(previousSerializer.getDescriptor().getSerialName());
            }
            baseClassSerializers.put(concreteClass, concreteSerializer);
            names.put(name, concreteSerializer);
            return;
        }
        if (previousSerializer != null) {
            if (!Intrinsics.areEqual(previousSerializer, concreteSerializer)) {
                throw new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            }
            names.remove(previousSerializer.getDescriptor().getSerialName());
        }
        KSerializer<?> previousByName = names.get(name);
        if (previousByName == null) {
            baseClassSerializers.put(concreteClass, concreteSerializer);
            names.put(name, concreteSerializer);
            return;
        }
        Map<KClass<?>, KSerializer<?>> map3 = this.polyBase2Serializers.get(baseClass);
        Intrinsics.checkNotNull(map3);
        Iterator it = MapsKt.asSequence(map3).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map.Entry it2 = (Map.Entry) obj;
            if (it2.getValue() == previousByName) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Map.Entry conflictingClass = (Map.Entry) obj;
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + name + "': '" + concreteClass + "' and '" + conflictingClass + '\'');
    }

    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider);
    }
}