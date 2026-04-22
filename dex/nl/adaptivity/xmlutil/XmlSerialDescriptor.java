package nl.adaptivity.xmlutil;

import java.lang.annotation.Annotation;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: XmlSerializer.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0017R\u0012\u0010\u0002\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001c\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "delegate", "getDelegate", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "xmlDescriptor", "getXmlDescriptor", "serialQName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "getSerialQName", "()Ljavax/xml/namespace/QName;", "getElementDescriptor", "index", "", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlSerialDescriptor extends SerialDescriptor {
    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    List<Annotation> getAnnotations();

    SerialDescriptor getDelegate();

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    SerialDescriptor getElementDescriptor(int i);

    QName getSerialQName();

    SerialDescriptor getXmlDescriptor();

    /* compiled from: XmlSerializer.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlSerialDescriptor$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        @ExperimentalSerializationApi
        public static /* synthetic */ void getAnnotations$annotations() {
        }

        public static QName $default$getSerialQName(XmlSerialDescriptor _this) {
            return null;
        }

        @ExperimentalSerializationApi
        public static SerialDescriptor $default$getElementDescriptor(XmlSerialDescriptor _this, int index) {
            return index < 0 ? _this.getXmlDescriptor() : _this.getDelegate().getElementDescriptor(index);
        }
    }
}