package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

/* compiled from: CollectionSerializers.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0007\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0015\b\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010\u001a\u001a\u00020\u001bH$¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!J%\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u0019H$¢\u0006\u0002\u0010&J\u0011\u0010'\u001a\u00020\u0019*\u00028\u0002H\u0004¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020\u0016*\u00028\u00022\u0006\u0010%\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,*\u00028\u0001H\u0004¢\u0006\u0002\u0010-J!\u0010.\u001a\u00020\u0016*\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00063"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "empty", "()Ljava/lang/Object;", "readElement", "", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "writeContent", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "builderSize", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "checkCapacity", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {
    private final SerialDescriptor descriptor;

    protected abstract Array empty();

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i, Builder builder, boolean z);

    protected abstract void writeContent(CompositeEncoder compositeEncoder, Array array, int i);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int builderSize(Object $this$builderSize) {
        return builderSize((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) $this$builderSize));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ void checkCapacity(Object $this$checkCapacity, int size) {
        checkCapacity((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) $this$checkCapacity), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object $this$insert, int index, Object element) {
        insert((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) $this$insert), index, (int) element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toResult(Object $this$toResult) {
        return toResult((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) $this$toResult));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        this.descriptor = new PrimitiveArrayDescriptor(primitiveSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    protected final int builderSize(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.getPosition$kotlinx_serialization_core();
    }

    protected final Array toResult(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return (Array) builder.build$kotlinx_serialization_core();
    }

    protected final void checkCapacity(Builder builder, int size) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.ensureCapacity$kotlinx_serialization_core(size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator<Element> collectionIterator(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    protected final void insert(Builder builder, int index, Element element) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Builder builder() {
        return (Builder) toBuilder(empty());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Array array) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int size = collectionSize(array);
        SerialDescriptor descriptor$iv = this.descriptor;
        CompositeEncoder composite$iv = encoder.beginCollection(descriptor$iv, size);
        writeContent(composite$iv, array, size);
        composite$iv.endStructure(descriptor$iv);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Array deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }
}