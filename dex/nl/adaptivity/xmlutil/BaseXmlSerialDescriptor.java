package nl.adaptivity.xmlutil;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: XmlSerializer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\"R\u0012\u0010*\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lnl/adaptivity/xmlutil/BaseXmlSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "delegate", "serialQName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljavax/xml/namespace/QName;)V", "getDelegate", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getSerialQName", "()Ljavax/xml/namespace/QName;", "Ljavax/xml/namespace/QName;", "xmlDescriptor", "getXmlDescriptor", "getElementDescriptor", "index", "", "equals", "", "other", "", "hashCode", "toString", "", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "isInline", "()Z", "isNullable", "isNullable$annotations", "getElementAnnotations", "getElementIndex", "name", "getElementName", "isElementOptional", "elementsCount", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "getSerialName", "()Ljava/lang/String;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class BaseXmlSerialDescriptor implements SerialDescriptor, XmlSerialDescriptor {
    private final SerialDescriptor delegate;
    private final QName serialQName;

    @ExperimentalSerializationApi
    public static /* synthetic */ void getAnnotations$annotations() {
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void isNullable$annotations() {
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int i) {
        return this.delegate.getElementAnnotations(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.delegate.getElementIndex(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int i) {
        return this.delegate.getElementName(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.delegate.getElementsCount();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.delegate.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.delegate.getSerialName();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int i) {
        return this.delegate.isElementOptional(i);
    }

    public BaseXmlSerialDescriptor(SerialDescriptor delegate, QName serialQName) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.serialQName = serialQName;
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public SerialDescriptor getDelegate() {
        return this.delegate;
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public QName getSerialQName() {
        return this.serialQName;
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public SerialDescriptor getXmlDescriptor() {
        return this;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public SerialDescriptor getElementDescriptor(int index) {
        return index < 0 ? getXmlDescriptor() : getDelegate().getElementDescriptor(index);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        BaseXmlSerialDescriptor baseXmlSerialDescriptor = (BaseXmlSerialDescriptor) other;
        if (!Intrinsics.areEqual(getDelegate(), ((BaseXmlSerialDescriptor) other).getDelegate()) || !Intrinsics.areEqual(getSerialQName(), ((BaseXmlSerialDescriptor) other).getSerialQName())) {
            return false;
        }
        int elementsCount = getDelegate().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            if (!Intrinsics.areEqual(getDelegate().getElementName(i), ((BaseXmlSerialDescriptor) other).getDelegate().getElementName(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = getDelegate().hashCode();
        int i = result * 31;
        QName serialQName = getSerialQName();
        int result2 = i + (serialQName != null ? serialQName.hashCode() : 0);
        return result2;
    }

    public String toString() {
        return "BaseXmlSerialDescriptor<" + getSerialQName() + ">(" + getDelegate() + ')';
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(new XmlSerialDescriptor$annotationImpl$nl_adaptivity_xmlutil_XmlSerialDescriptorMarker$0()), (Iterable) getDelegate().getAnnotations());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return getDelegate().isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return getDelegate().isNullable();
    }
}