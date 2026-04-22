package nl.adaptivity.xmlutil;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: XmlSerializer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\u0011\u0010#\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010$\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001d\u0010\u001cR\u0012\u0010%\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lnl/adaptivity/xmlutil/ExtXmlSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "delegate", "xmlDescriptor", "serialQName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljavax/xml/namespace/QName;)V", "getDelegate", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getSerialQName", "()Ljavax/xml/namespace/QName;", "getXmlDescriptor", "()Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "getElementDescriptor", "index", "", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "isInline", "", "()Z", "isNullable", "isNullable$annotations", "getElementAnnotations", "getElementIndex", "name", "", "getElementName", "isElementOptional", "elementsCount", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "getSerialName", "()Ljava/lang/String;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ExtXmlSerialDescriptor implements SerialDescriptor, XmlSerialDescriptor {
    private final SerialDescriptor delegate;
    private final XmlSerialDescriptor xmlDescriptor;

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

    public ExtXmlSerialDescriptor(SerialDescriptor delegate, SerialDescriptor xmlDescriptor, QName serialQName) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(xmlDescriptor, "xmlDescriptor");
        this.delegate = delegate;
        this.xmlDescriptor = new BaseXmlSerialDescriptor(xmlDescriptor, serialQName);
    }

    public /* synthetic */ ExtXmlSerialDescriptor(SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, QName qName, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialDescriptor, (i & 2) != 0 ? serialDescriptor : serialDescriptor2, (i & 4) != 0 ? null : qName);
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public SerialDescriptor getDelegate() {
        return this.delegate;
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public QName getSerialQName() {
        return getXmlDescriptor().getSerialQName();
    }

    @Override // nl.adaptivity.xmlutil.XmlSerialDescriptor
    public XmlSerialDescriptor getXmlDescriptor() {
        return this.xmlDescriptor;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public SerialDescriptor getElementDescriptor(int index) {
        return index < 0 ? getXmlDescriptor() : getDelegate().getElementDescriptor(index);
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