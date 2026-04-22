package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: PolymorphicModuleBuilder.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B'\b\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001J5\u0010\u0015\u001a\u00020\u00122+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\tH\u0007J3\u0010\u0019\u001a\u00020\u00122+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\tJ,\u0010\u001a\u001a\u00020\u0012\"\b\b\u0001\u0010\u001b*\u00028\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0006R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0088\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\u0018\u00010\tX\u0088\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\u0018\u00010\tX\u0088\u000e¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u00100\u000fX\u0088\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", "", "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "defaultDeserializerProvider", "Lkotlin/Function1;", "", "Lkotlinx/serialization/DeserializationStrategy;", "defaultSerializerProvider", "Lkotlinx/serialization/SerializationStrategy;", "subclasses", "", "Lkotlin/Pair;", "buildTo", "", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "default", "Lkotlin/ParameterName;", "name", "className", "defaultDeserializer", "subclass", "T", "serializer", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PolymorphicModuleBuilder<Base> {
    private final KClass<Base> baseClass;
    private final KSerializer<Base> baseSerializer;
    private Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider;
    private Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider;
    private final List<Pair<KClass<? extends Base>, KSerializer<? extends Base>>> subclasses;

    public PolymorphicModuleBuilder(KClass<Base> baseClass, KSerializer<Base> kSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.baseClass = baseClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    public /* synthetic */ PolymorphicModuleBuilder(KClass kClass, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? null : kSerializer);
    }

    public final <T extends Base> void subclass(KClass<T> subclass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(subclass, "subclass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.subclasses.add(TuplesKt.to(subclass, serializer));
    }

    public final void defaultDeserializer(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        if (!(this.defaultDeserializerProvider == null)) {
            throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider).toString());
        }
        this.defaultDeserializerProvider = defaultDeserializerProvider;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: defaultDeserializer", replaceWith = @ReplaceWith(expression = "defaultDeserializer(defaultSerializerProvider)", imports = {}))
    /* renamed from: default  reason: not valid java name */
    public final void m1569default(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        defaultDeserializer(defaultSerializerProvider);
    }

    public final void buildTo(SerializersModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (this.baseSerializer != null) {
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, this.baseClass, this.baseClass, this.baseSerializer, false, 8, null);
        }
        Iterable $this$forEach$iv = this.subclasses;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair) element$iv;
            KClass kclass = (KClass) pair.component1();
            KSerializer serializer = (KSerializer) pair.component2();
            KClass<Base> kClass = this.baseClass;
            Intrinsics.checkNotNull(kclass, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, kClass, kclass, serializer, false, 8, null);
        }
        Function1 defaultSerializer = this.defaultSerializerProvider;
        if (defaultSerializer != null) {
            builder.registerDefaultPolymorphicSerializer(this.baseClass, defaultSerializer, false);
        }
        Function1 defaultDeserializer = this.defaultDeserializerProvider;
        if (defaultDeserializer != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, defaultDeserializer, false);
        }
    }
}