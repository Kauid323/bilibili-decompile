package nl.adaptivity.xmlutil.core.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nl.adaptivity.xmlutil.EventType;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlException;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.XmlUtilInternal;
import nl.adaptivity.xmlutil.XmlWriter;

/* compiled from: PlatformXmlWriterBase.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/PlatformXmlWriterBase;", "Lnl/adaptivity/xmlutil/XmlWriter;", "indentSequence", "", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "<init>", "(Ljava/lang/Iterable;)V", "value", "", "getIndentSequence", "()Ljava/util/List;", "setIndentSequence", "(Ljava/util/List;)V", "_indentString", "", "get_indentString", "()Ljava/lang/String;", "set_indentString", "(Ljava/lang/String;)V", "indentString", "getIndentString", "setIndentString", "", "indent", "getIndent", "()I", "setIndent", "(I)V", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PlatformXmlWriterBase implements XmlWriter {
    private static final String COMMENT = "<!---->";
    public static final Companion Companion = new Companion(null);
    private String _indentString;
    private List<? extends XmlEvent.TextEvent> indentSequence;

    /* compiled from: PlatformXmlWriterBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PlatformXmlWriterBase() {
        this(null, 1, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void namespaceAttr(CharSequence charSequence, CharSequence charSequence2) {
        XmlWriter.CC.$default$namespaceAttr(this, charSequence, charSequence2);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void namespaceAttr(Namespace namespace) {
        XmlWriter.CC.$default$namespaceAttr(this, namespace);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void processingInstruction(String str, String str2) {
        XmlWriter.CC.$default$processingInstruction(this, str, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void setPrefix(CharSequence charSequence, CharSequence charSequence2) {
        XmlWriter.CC.$default$setPrefix(this, charSequence, charSequence2);
    }

    public PlatformXmlWriterBase(Iterable<? extends XmlEvent.TextEvent> indentSequence) {
        Intrinsics.checkNotNullParameter(indentSequence, "indentSequence");
        this.indentSequence = CollectionsKt.toList(indentSequence);
        this._indentString = CollectionsKt.joinToString$default(indentSequence, "", null, null, 0, null, new Function1() { // from class: nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence _indentString$lambda$1;
                _indentString$lambda$1 = PlatformXmlWriterBase._indentString$lambda$1((XmlEvent.TextEvent) obj);
                return _indentString$lambda$1;
            }
        }, 30, null);
    }

    public /* synthetic */ PlatformXmlWriterBase(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<XmlEvent.TextEvent> getIndentSequence() {
        return this.indentSequence;
    }

    public final void setIndentSequence(List<? extends XmlEvent.TextEvent> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.indentSequence = value;
        this._indentString = CollectionsKt.joinToString$default(value, "", null, null, 0, null, new Function1() { // from class: nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence _set_indentSequence_$lambda$0;
                _set_indentSequence_$lambda$0 = PlatformXmlWriterBase._set_indentSequence_$lambda$0((XmlEvent.TextEvent) obj);
                return _set_indentSequence_$lambda$0;
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _set_indentSequence_$lambda$0(XmlEvent.TextEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return WhenMappings.$EnumSwitchMapping$0[ev.getEventType().ordinal()] == 1 ? "<!--" + ev.getText() + "-->" : ev.getText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String get_indentString() {
        return this._indentString;
    }

    protected final void set_indentString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._indentString = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _indentString$lambda$1(XmlEvent.TextEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return WhenMappings.$EnumSwitchMapping$0[ev.getEventType().ordinal()] == 1 ? "<!--" + ev.getText() + "-->" : ev.getText();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use indentSequence")
    public final String getIndentString() {
        return this._indentString;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public final void setIndentString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setIndentSequence(Companion.toIndentSequence$core(value));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    @Deprecated(message = "Use indentString for better accuracy")
    public int getIndent() {
        int i = 0;
        for (XmlEvent.TextEvent it : this.indentSequence) {
            i += WhenMappings.$EnumSwitchMapping$0[it.getEventType().ordinal()] == 1 ? it.getText().length() + 7 : it.getText().length();
        }
        return i;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setIndent(int value) {
        setIndentSequence(CollectionsKt.listOf(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.IGNORABLE_WHITESPACE, StringsKt.repeat(" ", value))));
    }

    /* compiled from: PlatformXmlWriterBase.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0005H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/PlatformXmlWriterBase$Companion;", "", "<init>", "()V", "COMMENT", "", "toIndentSequence", "", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "toIndentSequence$core", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<XmlEvent.TextEvent> toIndentSequence$core(String $this$toIndentSequence) {
            Intrinsics.checkNotNullParameter($this$toIndentSequence, "<this>");
            List result = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int commentPos = 0;
            int length = $this$toIndentSequence.length();
            for (int i = 0; i < length; i++) {
                char ch = $this$toIndentSequence.charAt(i);
                switch (ch) {
                    case '!':
                        if (commentPos == 1) {
                            commentPos++;
                            Integer.valueOf(commentPos);
                            break;
                        } else {
                            sb.append(ch);
                            break;
                        }
                    case '-':
                        switch (commentPos) {
                            case 2:
                                commentPos++;
                                Integer.valueOf(commentPos);
                                continue;
                            case 3:
                                commentPos++;
                                toIndentSequence$sbToTextEvent(sb, result);
                                Unit unit = Unit.INSTANCE;
                                continue;
                            case 4:
                            case 5:
                                commentPos++;
                                Integer.valueOf(commentPos);
                                continue;
                            case 6:
                                throw new XmlException("-- is not allowed to occur inside xml comment text", null, 2, null);
                            default:
                                sb.append(ch);
                                continue;
                        }
                    case '<':
                        if (commentPos == 0) {
                            commentPos++;
                            Integer.valueOf(commentPos);
                            break;
                        } else {
                            sb.append(ch);
                            break;
                        }
                    case '>':
                        switch (commentPos) {
                            case 5:
                                commentPos = 4;
                                sb.append("->");
                                continue;
                            case 6:
                                commentPos = 0;
                                EventType eventType = EventType.COMMENT;
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                result.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, eventType, sb2));
                                StringsKt.clear(sb);
                                continue;
                            default:
                                sb.append(ch);
                                continue;
                        }
                    default:
                        switch (commentPos) {
                            case 0:
                            case 4:
                                sb.append(ch);
                                break;
                            case 1:
                            case 2:
                            case 3:
                                sb.append((CharSequence) PlatformXmlWriterBase.COMMENT, 0, commentPos);
                                commentPos = 0;
                                sb.append(ch);
                                break;
                            case 5:
                                commentPos = 4;
                                sb.append('-').append(ch);
                                break;
                            case 6:
                                throw new XmlException("-- is not allowed to occur inside xml comment text", null, 2, null);
                        }
                        Unit unit2 = Unit.INSTANCE;
                        break;
                }
            }
            if (commentPos > 0) {
                throw new XmlException("Indent can not contain unclosed comment", null, 2, null);
            }
            toIndentSequence$sbToTextEvent(sb, result);
            return result;
        }

        private static final void toIndentSequence$sbToTextEvent(StringBuilder sb, List<XmlEvent.TextEvent> list) {
            if (sb.length() > 0) {
                String text = sb.toString();
                Intrinsics.checkNotNullExpressionValue(text, "toString(...)");
                if (!XmlUtil.isXmlWhitespace(text)) {
                    throw new XmlException("Indents can only be whitespace or comments: " + text, null, 2, null);
                }
                list.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.IGNORABLE_WHITESPACE, text));
                StringsKt.clear(sb);
            }
        }
    }
}