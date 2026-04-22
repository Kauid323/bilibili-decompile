package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IText;
import org.w3c.dom.Text;

/* compiled from: TextImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/TextImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/CharacterDataImpl;", "Lorg/w3c/dom/Text;", "Lnl/adaptivity/xmlutil/core/impl/idom/IText;", "delegate", "<init>", "(Lorg/w3c/dom/Text;)V", "splitText", "offset", "", "isElementContentWhitespace", "", "getWholeText", "", "replaceWholeText", "content", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextImpl extends CharacterDataImpl<Text> implements IText {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextImpl(Text delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // org.w3c.dom.Text
    public IText splitText(int offset) {
        Text splitText = ((Text) getDelegate()).splitText(offset);
        Intrinsics.checkNotNullExpressionValue(splitText, "splitText(...)");
        return NodeImplKt.wrap(splitText);
    }

    @Override // org.w3c.dom.Text
    public boolean isElementContentWhitespace() {
        return ((Text) getDelegate()).isElementContentWhitespace();
    }

    @Override // org.w3c.dom.Text
    public String getWholeText() {
        String wholeText = ((Text) getDelegate()).getWholeText();
        Intrinsics.checkNotNullExpressionValue(wholeText, "getWholeText(...)");
        return wholeText;
    }

    @Override // org.w3c.dom.Text
    public IText replaceWholeText(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Text replaceWholeText = ((Text) getDelegate()).replaceWholeText(content);
        Intrinsics.checkNotNullExpressionValue(replaceWholeText, "replaceWholeText(...)");
        return NodeImplKt.wrap(replaceWholeText);
    }
}