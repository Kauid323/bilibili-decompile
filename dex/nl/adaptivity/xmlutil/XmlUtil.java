package nl.adaptivity.xmlutil;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: XmlUtil.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a/\u0010\u000b\u001a\u00060\fj\u0002`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\u000b\u001a\u00060\fj\u0002`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00060\fj\u0002`\r*\u00020\u0006¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0013\u001a\u00060\fj\u0002`\r*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\b*\u00060\fj\u0002`\r¢\u0006\u0002\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00060\fj\u0002`\r*\u00060\u001bj\u0002`\u001c2\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0002\u0010\u001e\u001a\n\u0010\u001f\u001a\u00020\u0001*\u00020 \u001a\n\u0010!\u001a\u00020\b*\u00020\u0006¨\u0006\""}, d2 = {"isXmlWhitespace", "", "char", "", "data", "", "", "xmlCollapseWhitespace", "", "original", "xmlTrimWhitespace", "qname", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "namespaceUri", "localname", "prefix", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljavax/xml/namespace/QName;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljavax/xml/namespace/QName;", "toQname", "(Ljava/lang/CharSequence;)Ljavax/xml/namespace/QName;", "namespace", "Lnl/adaptivity/xmlutil/Namespace;", "(Ljava/lang/CharSequence;Lnl/adaptivity/xmlutil/Namespace;)Ljavax/xml/namespace/QName;", "toCName", "(Ljavax/xml/namespace/QName;)Ljava/lang/String;", "asQName", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "name", "(Ljavax/xml/namespace/NamespaceContext;Ljava/lang/String;)Ljavax/xml/namespace/QName;", "isXml", "Lnl/adaptivity/xmlutil/XmlReader;", "xmlEncode", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlUtil {
    public static final boolean isXmlWhitespace(char c) {
        switch (c) {
            case '\t':
            case '\n':
            case additional_type_content_video_VALUE:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    public static final boolean isXmlWhitespace(char[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        for (char element$iv : data) {
            if (!isXmlWhitespace(element$iv)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isXmlWhitespace(CharSequence data) {
        Intrinsics.checkNotNullParameter(data, "data");
        for (int i = 0; i < data.length(); i++) {
            char element$iv = data.charAt(i);
            if (!isXmlWhitespace(element$iv)) {
                return false;
            }
        }
        return true;
    }

    public static final String xmlCollapseWhitespace(String original) {
        Intrinsics.checkNotNullParameter(original, "original");
        StringBuilder $this$xmlCollapseWhitespace_u24lambda_u242 = new StringBuilder(original.length());
        char last = ' ';
        int length = original.length();
        for (int i = 0; i < length; i++) {
            char c = original.charAt(i);
            switch (c) {
                case '\t':
                case '\n':
                case additional_type_content_video_VALUE:
                case ' ':
                    if (last != ' ') {
                        $this$xmlCollapseWhitespace_u24lambda_u242.append(' ');
                    }
                    last = ' ';
                    break;
                default:
                    last = c;
                    $this$xmlCollapseWhitespace_u24lambda_u242.append(c);
                    break;
            }
        }
        if (last == ' ') {
            if ($this$xmlCollapseWhitespace_u24lambda_u242.length() > 0) {
                Intrinsics.checkNotNullExpressionValue($this$xmlCollapseWhitespace_u24lambda_u242.deleteCharAt($this$xmlCollapseWhitespace_u24lambda_u242.length() - 1), "deleteCharAt(...)");
            }
        }
        return $this$xmlCollapseWhitespace_u24lambda_u242.toString();
    }

    public static final String xmlTrimWhitespace(String original) {
        Intrinsics.checkNotNullParameter(original, "original");
        StringBuilder $this$xmlTrimWhitespace_u24lambda_u243 = new StringBuilder(original.length());
        int start = -1;
        int i = 0;
        int length = original.length();
        while (true) {
            if (i < length) {
                switch (original.charAt(i)) {
                    case '\t':
                    case '\n':
                    case additional_type_content_video_VALUE:
                    case ' ':
                        i++;
                    default:
                        start = i;
                        break;
                }
            }
        }
        if (start < 0) {
            return "";
        }
        int end = -1;
        int length2 = original.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2;
                length2--;
                switch (original.charAt(i2)) {
                    case '\t':
                    case '\n':
                    case additional_type_content_video_VALUE:
                    case ' ':
                        if (length2 < 0) {
                            break;
                        }
                    default:
                        end = i2;
                        break;
                }
            }
        }
        int i3 = start;
        if (i3 <= end) {
            while (true) {
                char c = original.charAt(i3);
                switch (c) {
                    case '\t':
                    case '\n':
                    case additional_type_content_video_VALUE:
                    case ' ':
                        $this$xmlTrimWhitespace_u24lambda_u243.append(' ');
                        break;
                    default:
                        $this$xmlTrimWhitespace_u24lambda_u243.append(c);
                        break;
                }
                if (i3 != end) {
                    i3++;
                }
            }
        }
        return $this$xmlTrimWhitespace_u24lambda_u243.toString();
    }

    public static /* synthetic */ QName qname$default(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Object obj) {
        if ((i & 4) != 0) {
        }
        return qname(charSequence, charSequence2, charSequence3);
    }

    @Deprecated(message = "Use the version that takes string parameters", replaceWith = @ReplaceWith(expression = "qname(namespaceUri.toString(), localname.toString(), prefix.toString())", imports = {}))
    public static final QName qname(CharSequence namespaceUri, CharSequence localname, CharSequence prefix) {
        String obj;
        Intrinsics.checkNotNullParameter(localname, "localname");
        String str = "";
        String str2 = (namespaceUri == null || (str2 = namespaceUri.toString()) == null) ? "" : "";
        String obj2 = localname.toString();
        if (prefix != null && (obj = prefix.toString()) != null) {
            str = obj;
        }
        return new QName(str2, obj2, str);
    }

    public static /* synthetic */ QName qname$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return qname(str, str2, str3);
    }

    public static final QName qname(String namespaceUri, String localname, String prefix) {
        Intrinsics.checkNotNullParameter(localname, "localname");
        return new QName(namespaceUri == null ? "" : namespaceUri, localname, prefix != null ? prefix : "");
    }

    public static final QName toQname(CharSequence $this$toQname) {
        String nsUri;
        String localname;
        Intrinsics.checkNotNullParameter($this$toQname, "<this>");
        int split = StringsKt.indexOf$default($this$toQname, (char) AbstractJsonLexerKt.END_OBJ, 0, false, 6, (Object) null);
        if (split >= 0) {
            if ($this$toQname.charAt(0) != '{') {
                throw new IllegalArgumentException("Not a valid qname literal");
            }
            nsUri = $this$toQname.subSequence(1, split).toString();
            localname = $this$toQname.subSequence(split + 1, $this$toQname.length()).toString();
        } else {
            nsUri = "";
            localname = $this$toQname.toString();
        }
        return new QName(nsUri, localname);
    }

    public static final QName toQname(CharSequence $this$toQname, Namespace namespace) {
        String nsUri;
        String localname;
        Intrinsics.checkNotNullParameter($this$toQname, "<this>");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        int split = StringsKt.indexOf$default($this$toQname, (char) AbstractJsonLexerKt.END_OBJ, 0, false, 6, (Object) null);
        if (split >= 0) {
            if ($this$toQname.charAt(0) != '{') {
                throw new IllegalArgumentException("Not a valid qname literal");
            }
            nsUri = $this$toQname.subSequence(1, split).toString();
            localname = $this$toQname.subSequence(split + 1, $this$toQname.length()).toString();
        } else {
            nsUri = namespace.getNamespaceURI();
            localname = $this$toQname.toString();
        }
        return new QName(nsUri, localname);
    }

    public static final String toCName(QName $this$toCName) {
        Intrinsics.checkNotNullParameter($this$toCName, "<this>");
        return Intrinsics.areEqual("", $this$toCName.getPrefix()) ? $this$toCName.getLocalPart() : $this$toCName.getPrefix() + AbstractJsonLexerKt.COLON + $this$toCName.getLocalPart();
    }

    public static final QName asQName(NamespaceContext $this$asQName, String name) {
        QName qName;
        Intrinsics.checkNotNullParameter($this$asQName, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int colPos = StringsKt.indexOf$default((CharSequence) name, (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (colPos >= 0) {
            String prefix = name.substring(0, colPos);
            Intrinsics.checkNotNullExpressionValue(prefix, "substring(...)");
            String namespaceURI = $this$asQName.getNamespaceURI(prefix);
            String str = namespaceURI != null ? namespaceURI : "";
            String substring = name.substring(colPos + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            qName = new QName(str, substring, prefix);
        } else {
            String namespaceURI2 = $this$asQName.getNamespaceURI("");
            if (namespaceURI2 == null) {
                namespaceURI2 = "";
            }
            qName = new QName(namespaceURI2, name, "");
        }
        return qName;
    }

    public static final boolean isXml(XmlReader $this$isXml) {
        Intrinsics.checkNotNullParameter($this$isXml, "<this>");
        while ($this$isXml.hasNext()) {
            try {
                $this$isXml.next();
            } catch (XmlException e) {
                return false;
            }
        }
        return true;
    }

    public static final String xmlEncode(CharSequence $this$xmlEncode) {
        Intrinsics.checkNotNullParameter($this$xmlEncode, "<this>");
        int it = $this$xmlEncode.length();
        StringBuilder $this$xmlEncode_u24lambda_u245 = new StringBuilder(it + (it >> 4));
        for (int i = 0; i < $this$xmlEncode.length(); i++) {
            char c = $this$xmlEncode.charAt(i);
            switch (c) {
                case '&':
                    $this$xmlEncode_u24lambda_u245.append("&amp;");
                    break;
                case '<':
                    $this$xmlEncode_u24lambda_u245.append("&lt;");
                    break;
                case '>':
                    $this$xmlEncode_u24lambda_u245.append("&gt;");
                    break;
                default:
                    $this$xmlEncode_u24lambda_u245.append(c);
                    break;
            }
        }
        return $this$xmlEncode_u24lambda_u245.toString();
    }
}