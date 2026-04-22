package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import nl.adaptivity.xmlutil.core.impl.idom.IElement;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.TypeInfo;

/* compiled from: AttrImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/AttrImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "delegate", "<init>", "(Lorg/w3c/dom/Attr;)V", "getOwnerElement", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "getName", "", "getSpecified", "", "getValue", "setValue", "", "value", "getSchemaTypeInfo", "Lorg/w3c/dom/TypeInfo;", "isId", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttrImpl extends NodeImpl<Attr> implements IAttr {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttrImpl(Attr delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // org.w3c.dom.Attr
    public IElement getOwnerElement() {
        Element ownerElement = getDelegate().getOwnerElement();
        if (ownerElement != null) {
            return NodeImplKt.wrap(ownerElement);
        }
        return null;
    }

    @Override // org.w3c.dom.Attr, nl.adaptivity.xmlutil.dom2.Attr
    public String getName() {
        String name = getDelegate().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return getDelegate().getSpecified();
    }

    @Override // org.w3c.dom.Attr, nl.adaptivity.xmlutil.dom2.Attr
    public String getValue() {
        String value = getDelegate().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return value;
    }

    @Override // org.w3c.dom.Attr, nl.adaptivity.xmlutil.dom2.Attr
    public void setValue(String value) {
        getDelegate().setValue(value);
    }

    @Override // org.w3c.dom.Attr
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo schemaTypeInfo = getDelegate().getSchemaTypeInfo();
        Intrinsics.checkNotNullExpressionValue(schemaTypeInfo, "getSchemaTypeInfo(...)");
        return schemaTypeInfo;
    }

    @Override // org.w3c.dom.Attr
    public boolean isId() {
        return getDelegate().isId();
    }
}