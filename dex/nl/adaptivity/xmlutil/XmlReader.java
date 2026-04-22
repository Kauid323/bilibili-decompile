package nl.adaptivity.xmlutil;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: XmlReader.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003UVWJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0006\u001a\u00020\u0007H¦\u0002J\t\u0010\b\u001a\u00020\u0004H¦\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0002\u0010\u001cJ\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001eH&J\u0010\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001eH&J\u0010\u0010,\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001eH&J\u0019\u0010-\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010*\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001eH&J\u001c\u0010/\u001a\u0004\u0018\u00010\n2\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH&J\u001b\u0010/\u001a\u0004\u0018\u00010\n2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0002\u00104J\u0012\u00105\u001a\u0004\u0018\u00010\n2\u0006\u00106\u001a\u00020\nH&J\b\u00107\u001a\u00020\u0019H&J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nH&R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001a\u00060\u0012j\u0002`\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0012\u0010#\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u0012\u0010%\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0012\u0010'\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0012\u00100\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010C\u001a\u0004\bD\u0010\fR\u001c\u0010E\u001a\u0004\u0018\u00010F8VX\u0096\u0004¢\u0006\f\u0012\u0004\bG\u0010C\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010N\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\fR\u0014\u0010P\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006XÀ\u0006\u0003"}, d2 = {"Lnl/adaptivity/xmlutil/XmlReader;", "Ljava/io/Closeable;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Closeable;", "", "Lnl/adaptivity/xmlutil/EventType;", "nextTag", "hasNext", "", "next", "namespaceURI", "", "getNamespaceURI", "()Ljava/lang/String;", "localName", "getLocalName", "prefix", "getPrefix", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "getName", "()Ljavax/xml/namespace/QName;", "isStarted", "()Z", "require", "", "type", "namespace", "(Lnl/adaptivity/xmlutil/EventType;Ljavax/xml/namespace/QName;)V", "depth", "", "getDepth", "()I", "text", "getText", "piTarget", "getPiTarget", "piData", "getPiData", "attributeCount", "getAttributeCount", "getAttributeNamespace", "index", "getAttributePrefix", "getAttributeLocalName", "getAttributeName", "(I)Ljavax/xml/namespace/QName;", "getAttributeValue", "eventType", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "nsUri", "(Ljavax/xml/namespace/QName;)Ljava/lang/String;", "getNamespacePrefix", "namespaceUri", "close", "isWhitespace", "isEndElement", "isCharacters", "isStartElement", "namespaceDecls", "", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "()Ljava/util/List;", "locationInfo", "getLocationInfo$annotations", "()V", "getLocationInfo", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo$annotations", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "encoding", "getEncoding", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "version", "getVersion", "LocationInfo", "StringLocationInfo", "ExtLocationInfo", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlReader extends Closeable, Iterator<EventType>, KMappedMarker {

    /* compiled from: XmlReader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface LocationInfo {
    }

    /* compiled from: XmlReader.kt */
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
                iArr[EventType.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getAttributeCount();

    String getAttributeLocalName(int i);

    QName getAttributeName(int i);

    String getAttributeNamespace(int i);

    String getAttributePrefix(int i);

    String getAttributeValue(int i);

    String getAttributeValue(String str, String str2);

    String getAttributeValue(QName qName);

    int getDepth();

    String getEncoding();

    EventType getEventType();

    LocationInfo getExtLocationInfo();

    String getLocalName();

    String getLocationInfo();

    QName getName();

    IterableNamespaceContext getNamespaceContext();

    List<Namespace> getNamespaceDecls();

    String getNamespacePrefix(String str);

    String getNamespaceURI();

    String getNamespaceURI(String str);

    String getPiData();

    String getPiTarget();

    String getPrefix();

    Boolean getStandalone();

    String getText();

    String getVersion();

    boolean hasNext();

    boolean isCharacters();

    boolean isEndElement();

    boolean isStartElement();

    boolean isStarted();

    boolean isWhitespace();

    EventType next();

    EventType nextTag();

    void require(EventType eventType, String str, String str2) throws XmlException;

    void require(EventType eventType, QName qName) throws XmlException;

    /* compiled from: XmlReader.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlReader$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static EventType $default$nextTag(XmlReader _this) {
            EventType event = _this.next();
            while (event != EventType.START_ELEMENT && event != EventType.END_ELEMENT) {
                if (event == EventType.TEXT && !XmlUtil.isXmlWhitespace(_this.getText())) {
                    throw new XmlException("Unexpected text content", null, 2, null);
                }
                event = _this.next();
            }
            return event;
        }

        public static QName $default$getName(XmlReader _this) {
            return XmlUtil.qname(_this.getNamespaceURI(), _this.getLocalName(), _this.getPrefix());
        }

        public static void $default$require(XmlReader _this, EventType type, String namespace, String name) throws XmlException {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!_this.isStarted()) {
                throw new XmlException("Parsing not started yet", null, 2, null);
            }
            if (_this.getEventType() != type) {
                switch (WhenMappings.$EnumSwitchMapping$0[_this.getEventType().ordinal()]) {
                    case 1:
                    case 2:
                        throw new XmlException("Type " + _this.getEventType() + '(' + _this.getLocalName() + ") does not match expected type \"" + type + '(' + name + ")\" (" + _this.getExtLocationInfo() + ')', null, 2, null);
                    default:
                        throw new XmlException("Type " + _this.getEventType() + " does not match expected type \"" + type + '(' + name + ")\" (" + _this.getExtLocationInfo() + ')', null, 2, null);
                }
            } else if (name != null && !Intrinsics.areEqual(_this.getLocalName(), name)) {
                throw new XmlException("local name \"" + _this.getLocalName() + "\" does not match expected \"" + name + "\" (" + _this.getExtLocationInfo() + ')', null, 2, null);
            } else {
                if (namespace != null && !Intrinsics.areEqual(_this.getNamespaceURI(), namespace)) {
                    throw new XmlException("Namespace \"" + _this.getNamespaceURI() + "\" does not match expected \"" + namespace + "\" (" + _this.getExtLocationInfo() + ')', null, 2, null);
                }
            }
        }

        public static void $default$require(XmlReader _this, EventType type, QName name) throws XmlException {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            String str2 = null;
            if (name == null) {
                str = null;
            } else {
                str = name.getNamespaceURI();
            }
            if (name != null) {
                str2 = name.getLocalPart();
            }
            _this.require(type, str, str2);
        }

        public static QName $default$getAttributeName(XmlReader _this, int index) {
            return XmlUtil.qname(_this.getAttributeNamespace(index), _this.getAttributeLocalName(index), _this.getAttributePrefix(index));
        }

        public static String $default$getAttributeValue(XmlReader _this, QName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return _this.getAttributeValue(name.getNamespaceURI(), name.getLocalPart());
        }

        public static boolean $default$isWhitespace(XmlReader _this) {
            return _this.getEventType() == EventType.IGNORABLE_WHITESPACE || (_this.getEventType() == EventType.TEXT && XmlUtil.isXmlWhitespace(_this.getText()));
        }

        public static boolean $default$isEndElement(XmlReader _this) {
            return _this.getEventType() == EventType.END_ELEMENT;
        }

        public static boolean $default$isCharacters(XmlReader _this) {
            return _this.getEventType() == EventType.TEXT;
        }

        public static boolean $default$isStartElement(XmlReader _this) {
            return _this.getEventType() == EventType.START_ELEMENT;
        }

        public static LocationInfo $default$getExtLocationInfo(XmlReader _this) {
            String p0 = _this.getLocationInfo();
            return p0 != null ? new StringLocationInfo(p0) : null;
        }
    }

    /* compiled from: XmlReader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getExtLocationInfo$annotations() {
        }

        @Deprecated(message = "Use extLocationInfo as that allows more detailed information", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
        public static /* synthetic */ void getLocationInfo$annotations() {
        }

        @Deprecated
        public static EventType nextTag(XmlReader $this) {
            return CC.$default$nextTag($this);
        }

        @Deprecated
        public static QName getName(XmlReader $this) {
            return CC.$default$getName($this);
        }

        @Deprecated
        public static void require(XmlReader $this, EventType type, String namespace, String name) throws XmlException {
            Intrinsics.checkNotNullParameter(type, "type");
            CC.$default$require($this, type, namespace, name);
        }

        @Deprecated
        public static void require(XmlReader $this, EventType type, QName name) throws XmlException {
            Intrinsics.checkNotNullParameter(type, "type");
            CC.$default$require($this, type, name);
        }

        @Deprecated
        public static QName getAttributeName(XmlReader $this, int index) {
            return CC.$default$getAttributeName($this, index);
        }

        @Deprecated
        public static String getAttributeValue(XmlReader $this, QName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return CC.$default$getAttributeValue($this, name);
        }

        @Deprecated
        public static boolean isWhitespace(XmlReader $this) {
            return CC.$default$isWhitespace($this);
        }

        @Deprecated
        public static boolean isEndElement(XmlReader $this) {
            return CC.$default$isEndElement($this);
        }

        @Deprecated
        public static boolean isCharacters(XmlReader $this) {
            return CC.$default$isCharacters($this);
        }

        @Deprecated
        public static boolean isStartElement(XmlReader $this) {
            return CC.$default$isStartElement($this);
        }

        @Deprecated
        public static LocationInfo getExtLocationInfo(XmlReader $this) {
            return CC.$default$getExtLocationInfo($this);
        }
    }

    /* compiled from: XmlReader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lnl/adaptivity/xmlutil/XmlReader$StringLocationInfo;", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "str", "", "<init>", "(Ljava/lang/String;)V", "toString", "equals", "", "other", "", "hashCode", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class StringLocationInfo implements LocationInfo {
        private final String str;

        public StringLocationInfo(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.str = str;
        }

        public String toString() {
            return this.str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            StringLocationInfo stringLocationInfo = (StringLocationInfo) other;
            return Intrinsics.areEqual(this.str, ((StringLocationInfo) other).str);
        }

        public int hashCode() {
            return this.str.hashCode();
        }
    }

    /* compiled from: XmlReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lnl/adaptivity/xmlutil/XmlReader$ExtLocationInfo;", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "col", "", "line", "offset", "<init>", "(III)V", "toString", "", "equals", "", "other", "", "hashCode", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ExtLocationInfo implements LocationInfo {
        private final int col;
        private final int line;
        private final int offset;

        public ExtLocationInfo(int col, int line, int offset) {
            this.col = col;
            this.line = line;
            this.offset = offset;
        }

        public String toString() {
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            if (this.line >= 0) {
                $this$toString_u24lambda_u240.append(this.line);
                if (this.col >= 0) {
                    $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                    $this$toString_u24lambda_u240.append(this.col);
                }
                Unit unit = Unit.INSTANCE;
            } else if (this.offset >= 0) {
                $this$toString_u24lambda_u240.append('@').append(this.offset);
            } else {
                $this$toString_u24lambda_u240.append("<unknown>");
            }
            return $this$toString_u24lambda_u240.toString();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            ExtLocationInfo extLocationInfo = (ExtLocationInfo) other;
            if (this.col == ((ExtLocationInfo) other).col && this.line == ((ExtLocationInfo) other).line && this.offset == ((ExtLocationInfo) other).offset) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.col;
            return (((result * 31) + this.line) * 31) + this.offset;
        }
    }
}