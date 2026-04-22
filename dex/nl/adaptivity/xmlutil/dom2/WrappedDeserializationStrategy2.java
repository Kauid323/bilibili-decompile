package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ElementSerializer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/WrappedDeserializationStrategy2;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "delegate", "document", "Lnl/adaptivity/xmlutil/dom2/Document;", "<init>", "(Lkotlinx/serialization/DeserializationStrategy;Lnl/adaptivity/xmlutil/dom2/Document;)V", "getDelegate", "()Lkotlinx/serialization/DeserializationStrategy;", "getDocument", "()Lnl/adaptivity/xmlutil/dom2/Document;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrappedDeserializationStrategy2<T> implements DeserializationStrategy<T> {
    private final DeserializationStrategy<T> delegate;
    private final Document document;

    /* JADX WARN: Multi-variable type inference failed */
    public WrappedDeserializationStrategy2(DeserializationStrategy<? extends T> delegate, Document document) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(document, "document");
        this.delegate = delegate;
        this.document = document;
    }

    public final DeserializationStrategy<T> getDelegate() {
        return this.delegate;
    }

    public final Document getDocument() {
        return this.document;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.delegate.getDescriptor();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.delegate.deserialize(new Document2Decoder(decoder, this.document));
    }
}