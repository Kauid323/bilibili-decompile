package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.ICharacterData;
import org.apache.commons.cli.HelpFormatter;
import org.w3c.dom.CharacterData;

/* compiled from: CharacterDataImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH\u0016¨\u0006\u0017"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/CharacterDataImpl;", "N", "Lorg/w3c/dom/CharacterData;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lnl/adaptivity/xmlutil/core/impl/idom/ICharacterData;", "delegate", "<init>", "(Lorg/w3c/dom/CharacterData;)V", "getData", "", "setData", "", "data", "getLength", "", "substringData", "offset", "count", "appendData", HelpFormatter.DEFAULT_ARG_NAME, "insertData", "deleteData", "replaceData", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CharacterDataImpl<N extends CharacterData> extends NodeImpl<N> implements ICharacterData {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CharacterDataImpl(N delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public String getData() {
        String data = ((CharacterData) getDelegate()).getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        return data;
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public void setData(String data) {
        ((CharacterData) getDelegate()).setData(data);
    }

    @Override // org.w3c.dom.CharacterData
    public int getLength() {
        return ((CharacterData) getDelegate()).getLength();
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public String substringData(int offset, int count) {
        String substringData = ((CharacterData) getDelegate()).substringData(offset, count);
        Intrinsics.checkNotNullExpressionValue(substringData, "substringData(...)");
        return substringData;
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public void appendData(String arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        ((CharacterData) getDelegate()).appendData(arg);
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public void insertData(int offset, String arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        ((CharacterData) getDelegate()).insertData(offset, arg);
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public void deleteData(int offset, int count) {
        ((CharacterData) getDelegate()).deleteData(offset, count);
    }

    @Override // org.w3c.dom.CharacterData, nl.adaptivity.xmlutil.dom2.CharacterData
    public void replaceData(int offset, int count, String arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        ((CharacterData) getDelegate()).replaceData(offset, count, arg);
    }
}