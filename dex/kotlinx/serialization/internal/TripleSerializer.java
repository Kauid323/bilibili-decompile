package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\tJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", "composite", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {
    private final KSerializer<A> aSerializer;
    private final KSerializer<B> bSerializer;
    private final KSerializer<C> cSerializer;
    private final SerialDescriptor descriptor;

    public TripleSerializer(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        this.aSerializer = aSerializer;
        this.bSerializer = bSerializer;
        this.cSerializer = cSerializer;
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>(this) { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1
            final /* synthetic */ TripleSerializer<A, B, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                invoke2(classSerialDescriptorBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                KSerializer kSerializer;
                KSerializer kSerializer2;
                KSerializer kSerializer3;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                kSerializer = ((TripleSerializer) this.this$0).aSerializer;
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "first", kSerializer.getDescriptor(), null, false, 12, null);
                kSerializer2 = ((TripleSerializer) this.this$0).bSerializer;
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "second", kSerializer2.getDescriptor(), null, false, 12, null);
                kSerializer3 = ((TripleSerializer) this.this$0).cSerializer;
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "third", kSerializer3.getDescriptor(), null, false, 12, null);
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        serialize(encoder, (Triple) ((Triple) value));
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CompositeEncoder structuredEncoder = encoder.beginStructure(getDescriptor());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 0, this.aSerializer, value.getFirst());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 1, this.bSerializer, value.getSecond());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 2, this.cSerializer, value.getThird());
        structuredEncoder.endStructure(getDescriptor());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Triple<A, B, C> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder composite = decoder.beginStructure(getDescriptor());
        if (composite.decodeSequentially()) {
            return decodeSequentially(composite);
        }
        return decodeStructure(composite);
    }

    private final Triple<A, B, C> decodeSequentially(CompositeDecoder composite) {
        Object a = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 0, this.aSerializer, null, 8, null);
        Object b = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 1, this.bSerializer, null, 8, null);
        Object c = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
        composite.endStructure(getDescriptor());
        return new Triple<>(a, b, c);
    }

    private final Triple<A, B, C> decodeStructure(CompositeDecoder composite) {
        Object a = TuplesKt.access$getNULL$p();
        Object b = TuplesKt.access$getNULL$p();
        Object c = TuplesKt.access$getNULL$p();
        while (true) {
            int index = composite.decodeElementIndex(getDescriptor());
            switch (index) {
                case -1:
                    composite.endStructure(getDescriptor());
                    if (a == TuplesKt.access$getNULL$p()) {
                        throw new SerializationException("Element 'first' is missing");
                    }
                    if (b == TuplesKt.access$getNULL$p()) {
                        throw new SerializationException("Element 'second' is missing");
                    }
                    if (c == TuplesKt.access$getNULL$p()) {
                        throw new SerializationException("Element 'third' is missing");
                    }
                    return new Triple<>(a, b, c);
                case 0:
                    a = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 0, this.aSerializer, null, 8, null);
                    break;
                case 1:
                    b = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 1, this.bSerializer, null, 8, null);
                    break;
                case 2:
                    c = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
                    break;
                default:
                    throw new SerializationException("Unexpected index " + index);
            }
        }
    }
}