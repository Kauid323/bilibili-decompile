package nl.adaptivity.xmlutil;

import java.io.Closeable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.core.KtXmlWriter;
import nl.adaptivity.xmlutil.core.XmlVersion;
import nl.adaptivity.xmlutil.util.CompactFragment;
import nl.adaptivity.xmlutil.util.ICompactFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XmlReaderNS.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0007\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002¨\u0006\b"}, d2 = {"elementContentToFragment", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "Lnl/adaptivity/xmlutil/XmlReader;", "siblingsToFragment", "Lnl/adaptivity/xmlutil/util/CompactFragment;", "siblingsToCharArray", "", "elementToFragment", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlReaderUtil")
public final /* synthetic */ class XmlReaderUtil__XmlReaderNSKt {

    /* compiled from: XmlReaderNS.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.IGNORABLE_WHITESPACE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.CDSECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ICompactFragment elementContentToFragment(XmlReader $this$elementContentToFragment) {
        Intrinsics.checkNotNullParameter($this$elementContentToFragment, "<this>");
        XmlReaderUtil.skipPreamble($this$elementContentToFragment);
        if ($this$elementContentToFragment.hasNext()) {
            $this$elementContentToFragment.require(EventType.START_ELEMENT, null, null);
            $this$elementContentToFragment.next();
            return XmlReaderUtil.siblingsToFragment($this$elementContentToFragment);
        }
        return new CompactFragment("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        r0 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CompactFragment siblingsToFragment(XmlReader $this$siblingsToFragment) {
        int initialDepth;
        Intrinsics.checkNotNullParameter($this$siblingsToFragment, "<this>");
        Appendable appendable = new StringBuilder();
        if (!$this$siblingsToFragment.isStarted()) {
            if (!$this$siblingsToFragment.hasNext()) {
                return new CompactFragment("");
            }
            $this$siblingsToFragment.next();
        }
        XmlReader.LocationInfo startLocation = $this$siblingsToFragment.getExtLocationInfo();
        try {
            Map missingNamespaces = new LinkedHashMap();
            EventType type = $this$siblingsToFragment.getEventType();
            for (int initialDepth2 = $this$siblingsToFragment.getDepth() - ($this$siblingsToFragment.getEventType() == EventType.START_ELEMENT ? 1 : 0); type != EventType.END_DOCUMENT && (type != EventType.END_ELEMENT || $this$siblingsToFragment.getDepth() > initialDepth2); initialDepth2 = initialDepth) {
                int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                switch (i) {
                    case 1:
                        initialDepth = initialDepth2;
                        Closeable $this$use$iv = new KtXmlWriter(appendable, false, XmlDeclMode.None, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
                        try {
                            KtXmlWriter out = (KtXmlWriter) $this$use$iv;
                            out.setIndentString("");
                            String namespaceForPrefix = out.getNamespaceUri($this$siblingsToFragment.getPrefix());
                            XmlReaderUtil.writeCurrent($this$siblingsToFragment, out);
                            if (!Intrinsics.areEqual(namespaceForPrefix, $this$siblingsToFragment.getNamespaceURI())) {
                                XmlWriterUtil.addUndeclaredNamespaces(out, $this$siblingsToFragment, missingNamespaces);
                            }
                            XmlWriterUtil.writeElementContent(out, missingNamespaces, $this$siblingsToFragment);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally($this$use$iv, null);
                            break;
                        } finally {
                        }
                    case 2:
                        if ($this$siblingsToFragment.getText().length() > 0) {
                            appendable.append(XmlUtil.xmlEncode($this$siblingsToFragment.getText()));
                        }
                        initialDepth = initialDepth2;
                        break;
                    case 3:
                    case 4:
                        appendable.append(XmlUtil.xmlEncode($this$siblingsToFragment.getText()));
                        initialDepth = initialDepth2;
                        break;
                    default:
                        initialDepth = initialDepth2;
                        break;
                }
                if ($this$siblingsToFragment.hasNext()) {
                    type = $this$siblingsToFragment.next();
                }
            }
            if (Intrinsics.areEqual(missingNamespaces.get(""), "")) {
                missingNamespaces.remove("");
            }
            return new CompactFragment(new SimpleNamespaceContext(missingNamespaces), appendable.toString());
        } catch (RuntimeException e) {
            throw new XmlException("Failure to parse children into string at " + startLocation, e);
        } catch (XmlException e2) {
            throw new XmlException("Failure to parse children into string at " + startLocation, e2);
        }
    }

    @Deprecated(message = "This is inefficient in Javascript")
    public static final char[] siblingsToCharArray(XmlReader $this$siblingsToCharArray) {
        Intrinsics.checkNotNullParameter($this$siblingsToCharArray, "<this>");
        return XmlReaderUtil.siblingsToFragment($this$siblingsToCharArray).getContent();
    }

    public static final CompactFragment elementToFragment(XmlReader $this$elementToFragment) {
        Intrinsics.checkNotNullParameter($this$elementToFragment, "<this>");
        StringBuilder output = new StringBuilder();
        if (!$this$elementToFragment.isStarted()) {
            if (!$this$elementToFragment.hasNext()) {
                return new CompactFragment("");
            }
            $this$elementToFragment.next();
        }
        XmlReader.LocationInfo startLocation = $this$elementToFragment.getExtLocationInfo();
        try {
            Map missingNamespaces = new LinkedHashMap();
            if (!$this$elementToFragment.getEventType().isTextElement() && $this$elementToFragment.getEventType() != EventType.IGNORABLE_WHITESPACE) {
                $this$elementToFragment.require(EventType.START_ELEMENT, null, null);
                Closeable $this$use$iv = new KtXmlWriter((Appendable) output, false, XmlDeclMode.None, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
                KtXmlWriter out = (KtXmlWriter) $this$use$iv;
                out.setIndentString("");
                while ($this$elementToFragment.getEventType() == EventType.IGNORABLE_WHITESPACE) {
                    out.ignorableWhitespace($this$elementToFragment.getText());
                    $this$elementToFragment.next();
                }
                if ($this$elementToFragment.getEventType() != EventType.END_ELEMENT && $this$elementToFragment.getEventType() != EventType.END_DOCUMENT) {
                    $this$elementToFragment.require(EventType.START_ELEMENT, null, null);
                    out.getNamespaceUri($this$elementToFragment.getPrefix());
                    XmlReaderUtil.writeCurrent($this$elementToFragment, out);
                    XmlWriterUtil.addUndeclaredNamespaces(out, $this$elementToFragment, missingNamespaces);
                    XmlWriterUtil.writeElementContent(out, missingNamespaces, $this$elementToFragment);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally($this$use$iv, null);
                    if (Intrinsics.areEqual(missingNamespaces.get(""), "")) {
                        missingNamespaces.remove("");
                    }
                    String sb = output.toString();
                    Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                    return new CompactFragment(new SimpleNamespaceContext(missingNamespaces), sb);
                }
                String sb2 = output.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                CompactFragment compactFragment = new CompactFragment(sb2);
                CloseableKt.closeFinally($this$use$iv, null);
                return compactFragment;
            }
            return new CompactFragment($this$elementToFragment.getText());
        } catch (RuntimeException e) {
            throw new XmlException("Failure to parse children into string", startLocation, e);
        } catch (XmlException e2) {
            throw new XmlException("Failure to parse children into string", startLocation, e2);
        }
    }
}