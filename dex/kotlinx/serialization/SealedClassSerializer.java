package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: SealedSerializer.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BW\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\u0010\u000eBG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0002\u0010\u000fJ\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J%\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "classAnnotations", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "_annotations", "", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@InternalSerializationApi
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    private List<? extends Annotation> _annotations;
    private final KClass<T> baseClass;
    private final Map<KClass<? extends T>, KSerializer<? extends T>> class2Serializer;
    private final Lazy descriptor$delegate;
    private final Map<String, KSerializer<? extends T>> serialName2Serializer;

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    public SealedClassSerializer(final String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                final SealedClassSerializer<T> sealedClassSerializer = this;
                return SerialDescriptorsKt.buildSerialDescriptor(serialName, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                        invoke2(classSerialDescriptorBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
                        final SealedClassSerializer<T> sealedClassSerializer2 = sealedClassSerializer;
                        SerialDescriptor elementDescriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + sealedClassSerializer.getBaseClass().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                                invoke2(classSerialDescriptorBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(ClassSerialDescriptorBuilder buildSerialDescriptor2) {
                                Map $this$forEach$iv;
                                Intrinsics.checkNotNullParameter(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                $this$forEach$iv = ((SealedClassSerializer) sealedClassSerializer2).serialName2Serializer;
                                for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                                    String name = (String) element$iv.getKey();
                                    KSerializer serializer = (KSerializer) element$iv.getValue();
                                    ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor2, name, serializer.getDescriptor(), null, false, 12, null);
                                }
                            }
                        });
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "value", elementDescriptor, null, false, 12, null);
                        list = ((SealedClassSerializer) sealedClassSerializer)._annotations;
                        buildSerialDescriptor.setAnnotations(list);
                    }
                });
            }
        });
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
        }
        this.class2Serializer = MapsKt.toMap(ArraysKt.zip(subclasses, subclassSerializers));
        final Iterable $this$groupingBy$iv = this.class2Serializer.entrySet();
        Grouping $this$aggregate$iv = new Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String>() { // from class: kotlinx.serialization.SealedClassSerializer$special$$inlined$groupingBy$1
            @Override // kotlin.collections.Grouping
            public Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> sourceIterator() {
                return $this$groupingBy$iv.iterator();
            }

            @Override // kotlin.collections.Grouping
            public String keyOf(Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry) {
                Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> it = entry;
                return it.getValue().getDescriptor().getSerialName();
            }
        };
        Map destination$iv$iv = new LinkedHashMap();
        Iterator<T> sourceIterator = $this$aggregate$iv.sourceIterator();
        while (sourceIterator.hasNext()) {
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> next = sourceIterator.next();
            String keyOf = $this$aggregate$iv.keyOf(next);
            Object accumulator$iv$iv = destination$iv$iv.get(keyOf);
            if (accumulator$iv$iv == null) {
                destination$iv$iv.containsKey(keyOf);
            }
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> element = next;
            Map.Entry accumulator = (Map.Entry) accumulator$iv$iv;
            String key = keyOf;
            if (accumulator != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + key + "': '" + accumulator.getKey() + "', '" + element.getKey() + '\'').toString());
            }
            destination$iv$iv.put(keyOf, element);
        }
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = destination$iv$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv2.put(it$iv$iv.getKey(), (KSerializer) ((Map.Entry) it.getValue()).getValue());
        }
        this.serialName2Serializer = destination$iv$iv2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.serialName2Serializer.get(klassName);
        return kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(decoder, klassName);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer<? extends T> kSerializer = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(value.getClass()));
        KSerializer<? extends T> findPolymorphicSerializerOrNull = kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
        if (findPolymorphicSerializerOrNull != null) {
            return findPolymorphicSerializerOrNull;
        }
        return null;
    }
}