package nl.adaptivity.xmlutil.core;

import javax.xml.namespace.NamespaceContext;
import kntr.common.ouro.core.utils.ConverterUtilsKt$;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.XmlDeclMode;
import nl.adaptivity.xmlutil.XmlException;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.core.impl.NamespaceHolder;
import nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Multiplatform_jvmKt;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Writer;
import org.apache.commons.io.IOUtils;

/* compiled from: KtXmlWriter.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b%\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0003fghB/\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u000fB#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0010B'\b\u0017\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0011B\u001b\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0012B\u001f\b\u0017\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0013J\u0010\u00101\u001a\u00020!2\u0006\u0010.\u001a\u00020(H\u0002J(\u00102\u001a\u0002032\u0006\u0010.\u001a\u00020(2\u0006\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!H\u0002J\u0010\u00107\u001a\u00020!2\u0006\u0010.\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010.\u001a\u00020(H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u0007H\u0002J'\u0010;\u001a\u000203*\u00060\u0004j\u0002`\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002¢\u0006\u0004\b@\u0010AJ \u0010B\u001a\u000203*\u00060\u0004j\u0002`\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010E\u001a\u0002032\u0006\u0010F\u001a\u00020!2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010G\u001a\u000203H\u0002J\u0012\u0010H\u001a\u0002032\b\b\u0002\u0010I\u001a\u00020(H\u0002J\u001c\u0010J\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010!2\b\u00105\u001a\u0004\u0018\u00010!H\u0002J\b\u0010K\u001a\u000203H\u0016J+\u0010L\u001a\u0002032\b\u0010M\u001a\u0004\u0018\u00010!2\b\u0010N\u001a\u0004\u0018\u00010!2\b\u0010O\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0010\u0010S\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0018\u0010S\u001a\u0002032\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!H\u0016J$\u0010V\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010!H\u0016J$\u0010W\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010X\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0010\u0010Y\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0010\u0010Z\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J\u0010\u0010[\u001a\u0002032\u0006\u0010R\u001a\u00020!H\u0016J,\u0010\\\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010!2\u0006\u0010]\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010!2\u0006\u0010\u0017\u001a\u00020!H\u0016J\u0018\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020!H\u0016J \u0010a\u001a\u0002032\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!H\u0002J\b\u0010b\u001a\u000203H\u0016J\u0018\u0010c\u001a\u0002032\u0006\u00105\u001a\u00020!2\u0006\u0010`\u001a\u00020!H\u0016J\u0012\u0010d\u001a\u0004\u0018\u00010!2\u0006\u00105\u001a\u00020!H\u0016J\u0014\u0010e\u001a\u0004\u0018\u00010!2\b\u0010`\u001a\u0004\u0018\u00010!H\u0016J\b\u0010:\u001a\u000203H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010)\u001a\u00060*j\u0002`+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006i"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlWriter;", "Lnl/adaptivity/xmlutil/core/impl/PlatformXmlWriterBase;", "Lnl/adaptivity/xmlutil/XmlWriter;", "writer", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "isRepairNamespaces", "", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "xmlVersion", "Lnl/adaptivity/xmlutil/core/XmlVersion;", "<init>", "(Ljava/lang/Appendable;ZLnl/adaptivity/xmlutil/XmlDeclMode;Lnl/adaptivity/xmlutil/core/XmlVersion;)V", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "(Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;ZLnl/adaptivity/xmlutil/XmlDeclMode;Lnl/adaptivity/xmlutil/core/XmlVersion;)V", "(Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;ZLnl/adaptivity/xmlutil/core/XmlVersion;)V", "(Ljava/lang/Appendable;ZLnl/adaptivity/xmlutil/core/XmlVersion;)V", "(Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;Z)V", "(Ljava/lang/Appendable;Z)V", "()Z", "getXmlDeclMode", "()Lnl/adaptivity/xmlutil/XmlDeclMode;", "value", "getXmlVersion", "()Lnl/adaptivity/xmlutil/core/XmlVersion;", "addTrailingSpaceBeforeEnd", "getAddTrailingSpaceBeforeEnd", "setAddTrailingSpaceBeforeEnd", "(Z)V", "isPartiallyOpenTag", "elementStack", "", "", "[Ljava/lang/String;", "state", "Lnl/adaptivity/xmlutil/core/KtXmlWriter$WriteState;", "namespaceHolder", "Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "lastTagDepth", "", "namespaceContext", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "getNamespaceContext", "()Ljavax/xml/namespace/NamespaceContext;", "depth", "getDepth", "()I", "namespaceAt", "setElementStack", "", "namespace", "prefix", "localName", "prefixAt", "localNameAt", "finishPartialStartTag", "close", "appendXmlCodepoint", "codepoint", "Lkotlin/UInt;", "mode", "Lnl/adaptivity/xmlutil/core/KtXmlWriter$EscapeMode;", "appendXmlCodepoint-OsBMiQA", "(Ljava/lang/Appendable;ILnl/adaptivity/xmlutil/core/KtXmlWriter$EscapeMode;)V", "appendXmlChar", "char", "", "writeEscapedText", "s", "triggerStartDocument", "writeIndent", "newDepth", "ensureNamespaceIfRepairing", "flush", "startDocument", "version", "encoding", "standalone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "docdecl", "text", "processingInstruction", "target", "data", "startTag", "endTag", "comment", "cdsect", "entityRef", "ignorableWhitespace", "attribute", "name", "namespaceAttr", "namespacePrefix", "namespaceUri", "rawWriteAttribute", "endDocument", "setPrefix", "getNamespaceUri", "getPrefix", "EscapeMode", "Companion", "WriteState", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtXmlWriter extends PlatformXmlWriterBase implements XmlWriter {
    private static final Companion Companion = new Companion(null);
    private static final boolean[] ESCAPED_CHARS;
    private static final int TAG_DEPTH_FORCE_INDENT_NEXT = Integer.MAX_VALUE;
    private static final int TAG_DEPTH_NOT_TAG = -1;
    private boolean addTrailingSpaceBeforeEnd;
    private String[] elementStack;
    private boolean isPartiallyOpenTag;
    private final boolean isRepairNamespaces;
    private int lastTagDepth;
    private final NamespaceHolder namespaceHolder;
    private WriteState state;
    private final Appendable writer;
    private final XmlDeclMode xmlDeclMode;
    private XmlVersion xmlVersion;

    /* compiled from: KtXmlWriter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[XmlVersion.values().length];
            try {
                iArr[XmlVersion.XML10.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[XmlVersion.XML11.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WriteState.values().length];
            try {
                iArr2[WriteState.BeforeDocument.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ KtXmlWriter(Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, XmlVersion xmlVersion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appendable, (i & 2) != 0 ? true : z, xmlDeclMode, (i & 8) != 0 ? XmlVersion.XML11 : xmlVersion);
    }

    public final boolean isRepairNamespaces() {
        return this.isRepairNamespaces;
    }

    public final XmlDeclMode getXmlDeclMode() {
        return this.xmlDeclMode;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtXmlWriter(Appendable writer, boolean isRepairNamespaces, XmlDeclMode xmlDeclMode, XmlVersion xmlVersion) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        Intrinsics.checkNotNullParameter(xmlVersion, "xmlVersion");
        this.writer = writer;
        this.isRepairNamespaces = isRepairNamespaces;
        this.xmlDeclMode = xmlDeclMode;
        this.xmlVersion = xmlVersion;
        this.addTrailingSpaceBeforeEnd = true;
        this.elementStack = new String[12];
        this.state = WriteState.BeforeDocument;
        this.namespaceHolder = new NamespaceHolder();
        this.lastTagDepth = -1;
    }

    public /* synthetic */ KtXmlWriter(Writer writer, boolean z, XmlDeclMode xmlDeclMode, XmlVersion xmlVersion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(writer, (i & 2) != 0 ? true : z, xmlDeclMode, (i & 8) != 0 ? XmlVersion.XML11 : xmlVersion);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KtXmlWriter(Writer writer, boolean isRepairNamespaces, XmlDeclMode xmlDeclMode, XmlVersion xmlVersion) {
        this((Appendable) writer, isRepairNamespaces, xmlDeclMode, xmlVersion);
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        Intrinsics.checkNotNullParameter(xmlVersion, "xmlVersion");
    }

    public /* synthetic */ KtXmlWriter(Writer writer, boolean z, XmlVersion xmlVersion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(writer, (i & 2) != 0 ? true : z, xmlVersion);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "When using XML 1.1 a document type declaration is required. If you wantto omit it, do so expressly")
    public KtXmlWriter(Writer writer, boolean isRepairNamespaces, XmlVersion xmlVersion) {
        this((Appendable) writer, isRepairNamespaces, XmlDeclMode.None, xmlVersion);
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlVersion, "xmlVersion");
    }

    public /* synthetic */ KtXmlWriter(Appendable appendable, boolean z, XmlVersion xmlVersion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appendable, (i & 2) != 0 ? true : z, xmlVersion);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "When using XML 1.1 a document type declaration is required. If you wantto omit it, do so expressly")
    public KtXmlWriter(Appendable writer, boolean isRepairNamespaces, XmlVersion xmlVersion) {
        this(writer, isRepairNamespaces, XmlDeclMode.None, xmlVersion);
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlVersion, "xmlVersion");
    }

    public /* synthetic */ KtXmlWriter(Writer writer, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(writer, (i & 2) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "When using XML 1.1 a document type declaration is required. If you want to omit it, do so expressly")
    public KtXmlWriter(Writer writer, boolean isRepairNamespaces) {
        this((Appendable) writer, isRepairNamespaces, XmlDeclMode.None, XmlVersion.XML11);
        Intrinsics.checkNotNullParameter(writer, "writer");
    }

    public /* synthetic */ KtXmlWriter(Appendable appendable, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appendable, (i & 2) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "When using XML 1.1 a document type declaration is required. If you want to omit it, do so expressly")
    public KtXmlWriter(Appendable writer, boolean isRepairNamespaces) {
        this(writer, isRepairNamespaces, XmlDeclMode.None, XmlVersion.XML11);
        Intrinsics.checkNotNullParameter(writer, "writer");
    }

    public final XmlVersion getXmlVersion() {
        return this.xmlVersion;
    }

    public final boolean getAddTrailingSpaceBeforeEnd() {
        return this.addTrailingSpaceBeforeEnd;
    }

    public final void setAddTrailingSpaceBeforeEnd(boolean z) {
        this.addTrailingSpaceBeforeEnd = z;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public NamespaceContext getNamespaceContext() {
        return this.namespaceHolder.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public int getDepth() {
        return this.namespaceHolder.getDepth();
    }

    private final String namespaceAt(int depth) {
        String str = this.elementStack[depth * 3];
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final void setElementStack(int depth, String namespace, String prefix, String localName) {
        int esp = depth * 3;
        if (this.elementStack.length < esp + 3) {
            String[] hlp = new String[this.elementStack.length + 12];
            ArraysKt.copyInto$default(this.elementStack, hlp, 0, 0, esp, 6, (Object) null);
            this.elementStack = hlp;
        }
        int esp2 = esp + 1;
        this.elementStack[esp] = namespace;
        this.elementStack[esp2] = prefix;
        this.elementStack[esp2 + 1] = localName;
    }

    private final String prefixAt(int depth) {
        String str = this.elementStack[(depth * 3) + 1];
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final String localNameAt(int depth) {
        String str = this.elementStack[(depth * 3) + 2];
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final void finishPartialStartTag(boolean close) {
        String endOfTag;
        if (!this.isPartiallyOpenTag) {
            return;
        }
        this.isPartiallyOpenTag = false;
        if (close) {
            endOfTag = this.addTrailingSpaceBeforeEnd ? " />" : "/>";
        } else {
            endOfTag = ">";
        }
        this.writer.append(endOfTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlWriter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlWriter$EscapeMode;", "", "<init>", "(Ljava/lang/String;I)V", "MINIMAL", "ATTRCONTENTQUOT", "ATTRCONTENTAPOS", "TEXTCONTENT", "DTD", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum EscapeMode {
        MINIMAL,
        ATTRCONTENTQUOT,
        ATTRCONTENTAPOS,
        TEXTCONTENT,
        DTD;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<EscapeMode> getEntries() {
            return $ENTRIES;
        }
    }

    private static final void appendXmlCodepoint_OsBMiQA$appendNumCharRef(Appendable $this_appendXmlCodepoint, int code) {
        $this_appendXmlCodepoint.append("&#x").append(UStringsKt.m1233toStringV7xB4Y4(code, 16)).append(';');
    }

    private static final Void appendXmlCodepoint_OsBMiQA$throwInvalid(KtXmlWriter this$0, int code) {
        throw new IllegalArgumentException("In xml " + this$0.xmlVersion.getVersionString() + " the character 0x" + UStringsKt.m1233toStringV7xB4Y4(code, 16) + " is not valid");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* renamed from: appendXmlCodepoint-OsBMiQA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m1619appendXmlCodepointOsBMiQA(Appendable $this$appendXmlCodepoint_u2dOsBMiQA, int codepoint, EscapeMode mode) {
        char ch;
        boolean z = true;
        if (codepoint != 9 && codepoint != 10 && codepoint != 13) {
            if (!(UnsignedKt.uintCompare(codepoint, 32) >= 0 && UnsignedKt.uintCompare(codepoint, 55295) <= 0)) {
                if (!(UnsignedKt.uintCompare(codepoint, 57344) >= 0 && UnsignedKt.uintCompare(codepoint, 65533) <= 0)) {
                    ch = (char) 0;
                    if (codepoint != 0) {
                        throw new IllegalArgumentException("XML documents may not contain null strings directly or indirectly");
                    }
                    if (ch != '&') {
                        if (ch != '<' || mode == EscapeMode.MINIMAL) {
                            if (ch != '>' || mode != EscapeMode.TEXTCONTENT) {
                                if (ch != '\"' || mode != EscapeMode.ATTRCONTENTQUOT) {
                                    if (ch != '\'' || mode != EscapeMode.ATTRCONTENTAPOS) {
                                        if (!(UnsignedKt.uintCompare(codepoint, 1) >= 0 && UnsignedKt.uintCompare(codepoint, 8) <= 0) && codepoint != 11 && codepoint != 12) {
                                            if (!(UnsignedKt.uintCompare(codepoint, 14) >= 0 && UnsignedKt.uintCompare(codepoint, 31) <= 0)) {
                                                if (!(UnsignedKt.uintCompare(codepoint, (int) WorkQueueKt.MASK) >= 0 && UnsignedKt.uintCompare(codepoint, 132) <= 0)) {
                                                    if (!(UnsignedKt.uintCompare(codepoint, 134) >= 0 && UnsignedKt.uintCompare(codepoint, 159) <= 0)) {
                                                        if (UnsignedKt.uintCompare(codepoint, 55296) < 0 || UnsignedKt.uintCompare(codepoint, 57343) > 0) {
                                                            z = false;
                                                        }
                                                        if (z || codepoint == 65534 || codepoint == 65535) {
                                                            appendXmlCodepoint_OsBMiQA$throwInvalid(this, codepoint);
                                                            throw new KotlinNothingValueException();
                                                        } else if (ConverterUtilsKt$.ExternalSyntheticBackport0.m(codepoint, 65535) > 0) {
                                                            int down = UInt.constructor-impl(codepoint - 65536);
                                                            int highSurogate = UInt.constructor-impl(UInt.constructor-impl(down >>> 10) + 55296);
                                                            int lowSurogate = UInt.constructor-impl(UInt.constructor-impl(down & 1023) + 56320);
                                                            $this$appendXmlCodepoint_u2dOsBMiQA.append((char) (UShort.constructor-impl((short) highSurogate) & 65535));
                                                            $this$appendXmlCodepoint_u2dOsBMiQA.append((char) (65535 & UShort.constructor-impl((short) lowSurogate)));
                                                            return;
                                                        } else {
                                                            $this$appendXmlCodepoint_u2dOsBMiQA.append(ch);
                                                            return;
                                                        }
                                                    }
                                                }
                                                switch (WhenMappings.$EnumSwitchMapping$0[this.xmlVersion.ordinal()]) {
                                                    case 1:
                                                        $this$appendXmlCodepoint_u2dOsBMiQA.append(ch);
                                                        return;
                                                    case 2:
                                                        appendXmlCodepoint_OsBMiQA$appendNumCharRef($this$appendXmlCodepoint_u2dOsBMiQA, codepoint);
                                                        Unit unit = Unit.INSTANCE;
                                                        return;
                                                    default:
                                                        throw new NoWhenBranchMatchedException();
                                                }
                                            }
                                        }
                                        switch (WhenMappings.$EnumSwitchMapping$0[this.xmlVersion.ordinal()]) {
                                            case 1:
                                                appendXmlCodepoint_OsBMiQA$throwInvalid(this, codepoint);
                                                throw new KotlinNothingValueException();
                                            case 2:
                                                appendXmlCodepoint_OsBMiQA$appendNumCharRef($this$appendXmlCodepoint_u2dOsBMiQA, codepoint);
                                                Unit unit2 = Unit.INSTANCE;
                                                return;
                                            default:
                                                throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    $this$appendXmlCodepoint_u2dOsBMiQA.append("&apos;");
                                    return;
                                }
                                $this$appendXmlCodepoint_u2dOsBMiQA.append("&quot;");
                                return;
                            }
                            $this$appendXmlCodepoint_u2dOsBMiQA.append("&gt;");
                            return;
                        }
                        $this$appendXmlCodepoint_u2dOsBMiQA.append("&lt;");
                        return;
                    }
                    $this$appendXmlCodepoint_u2dOsBMiQA.append("&amp;");
                    return;
                }
            }
        }
        ch = (char) (UShort.constructor-impl((short) codepoint) & 65535);
        if (codepoint != 0) {
        }
    }

    private static final void appendXmlChar$appendNumCharRef$0(Appendable $this_appendXmlChar, int code) {
        Appendable append = $this_appendXmlChar.append("&#x");
        String num = Integer.toString(code, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        append.append(num).append(';');
    }

    private static final Void appendXmlChar$throwInvalid$1(KtXmlWriter this$0, int code) {
        StringBuilder append = new StringBuilder().append("In xml ").append(this$0.xmlVersion.getVersionString()).append(" the character 0x");
        String num = Integer.toString(code, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        throw new IllegalArgumentException(append.append(num).append(" is not valid").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fb, code lost:
        if (r2 != false) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void appendXmlChar(Appendable $this$appendXmlChar, char c, EscapeMode mode) {
        if (c < ' ' && !XmlUtil.isXmlWhitespace(c)) {
            StringBuilder append = new StringBuilder().append("Invalid character with code 0x");
            String num = Integer.toString(c, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
            throw new IllegalArgumentException(append.append(num).toString());
        }
        boolean z = true;
        if (c >= ESCAPED_CHARS.length) {
            if (55296 > c || c >= 57344) {
                z = false;
            }
            if (z || c == 65534 || c == 65535) {
                appendXmlChar$throwInvalid$1(this, c);
                throw new KotlinNothingValueException();
            } else {
                $this$appendXmlChar.append(c);
            }
        } else if (!ESCAPED_CHARS[c]) {
            $this$appendXmlChar.append(c);
        } else if (c != '&') {
            if (c != '<' || mode == EscapeMode.MINIMAL) {
                if (c != '>' || mode != EscapeMode.TEXTCONTENT) {
                    if (c != '\"' || mode != EscapeMode.ATTRCONTENTQUOT) {
                        if (c != '\'' || mode != EscapeMode.ATTRCONTENTAPOS) {
                            if (!(1 <= c && c < '\t') && c != 11 && c != '\f') {
                                if (!(14 <= c && c < ' ')) {
                                    if (this.xmlVersion == XmlVersion.XML11) {
                                        if (!(127 <= c && c < 133)) {
                                            if (134 > c || c >= 160) {
                                                z = false;
                                            }
                                        }
                                        appendXmlChar$appendNumCharRef$0($this$appendXmlChar, c);
                                        Unit unit = Unit.INSTANCE;
                                        return;
                                    }
                                    $this$appendXmlChar.append(c);
                                    return;
                                }
                            }
                            switch (WhenMappings.$EnumSwitchMapping$0[this.xmlVersion.ordinal()]) {
                                case 1:
                                    appendXmlChar$throwInvalid$1(this, c);
                                    throw new KotlinNothingValueException();
                                case 2:
                                    appendXmlChar$appendNumCharRef$0($this$appendXmlChar, c);
                                    Unit unit2 = Unit.INSTANCE;
                                    return;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                        }
                        $this$appendXmlChar.append("&apos;");
                        return;
                    }
                    $this$appendXmlChar.append("&quot;");
                    return;
                }
                $this$appendXmlChar.append("&gt;");
                return;
            }
            $this$appendXmlChar.append("&lt;");
        } else {
            $this$appendXmlChar.append("&amp;");
        }
    }

    private final void writeEscapedText(String s, EscapeMode mode) {
        int start = 0;
        int i = 0;
        int l = s.length();
        while (i < l) {
            char c = s.charAt(i);
            if (c >= ESCAPED_CHARS.length || ESCAPED_CHARS[c]) {
                if (start < i) {
                    this.writer.append(s, start, i);
                }
                if (Character.isHighSurrogate(c)) {
                    int codePoint = UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(c) - 55296) << 10) + 65536) + UInt.constructor-impl(UInt.constructor-impl(s.charAt(i + 1)) - 56320));
                    m1619appendXmlCodepointOsBMiQA(this.writer, codePoint, mode);
                    start = i + 2;
                    i++;
                } else {
                    appendXmlChar(this.writer, c, mode);
                    start = i + 1;
                }
            }
            i++;
        }
        if (start < l) {
            Appendable appendable = this.writer;
            String substring = s.substring(start, l);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            appendable.append(substring);
        }
    }

    private final void triggerStartDocument() {
        if (WhenMappings.$EnumSwitchMapping$1[this.state.ordinal()] == 1) {
            if (this.xmlDeclMode != XmlDeclMode.None) {
                if (this.xmlVersion == XmlVersion.XML11 || this.xmlDeclMode != XmlDeclMode.Minimal) {
                    startDocument(this.xmlVersion.getVersionString(), null, null);
                } else {
                    XmlWriter.CC.startDocument$default(this, null, null, null, 7, null);
                }
            }
            this.state = WriteState.AfterXmlDecl;
        }
    }

    static /* synthetic */ void writeIndent$default(KtXmlWriter ktXmlWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ktXmlWriter.getDepth();
        }
        ktXmlWriter.writeIndent(i);
    }

    private final void writeIndent(int newDepth) {
        if (this.lastTagDepth >= 0) {
            if ((get_indentString().length() > 0) && this.lastTagDepth != getDepth()) {
                ignorableWhitespace(IOUtils.LINE_SEPARATOR_UNIX);
                int depth = getDepth();
                for (int i = 0; i < depth; i++) {
                    this.writer.append(get_indentString());
                }
            }
        }
        this.lastTagDepth = newDepth;
    }

    private final void ensureNamespaceIfRepairing(String namespace, String prefix) {
        if (this.isRepairNamespaces) {
            String str = namespace;
            if (!(str == null || str.length() == 0) && prefix != null && !Intrinsics.areEqual(this.namespaceHolder.getNamespaceUri(prefix), namespace)) {
                namespaceAttr(prefix, namespace);
            }
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void flush() {
        finishPartialStartTag(false);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startDocument(String version, String encoding, Boolean standalone) {
        String verString;
        writeIndent(Integer.MAX_VALUE);
        if (this.state != WriteState.BeforeDocument) {
            throw new XmlException("Attempting to write start document after document already started", null, 2, null);
        }
        this.state = WriteState.AfterXmlDecl;
        if (version == null) {
            verString = this.xmlVersion.getVersionString();
        } else {
            if (Intrinsics.areEqual(version, "1") || Intrinsics.areEqual(version, "1.0")) {
                this.xmlVersion = XmlVersion.XML10;
            } else {
                this.xmlVersion = XmlVersion.XML11;
            }
            verString = version;
        }
        this.writer.append("<?xml version='" + verString + '\'');
        String effectiveEncoding = encoding == null ? "UTF-8" : encoding;
        if (this.xmlDeclMode != XmlDeclMode.Minimal || encoding != null) {
            this.writer.append(" encoding='");
            writeEscapedText(effectiveEncoding, EscapeMode.ATTRCONTENTAPOS);
            this.writer.append('\'');
            if (standalone != null) {
                this.writer.append(" standalone='");
                this.writer.append(standalone.booleanValue() ? "yes" : "no");
                this.writer.append('\'');
            }
        }
        if (this.addTrailingSpaceBeforeEnd) {
            this.writer.append(' ');
        }
        this.writer.append("?>");
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void docdecl(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        writeIndent(Integer.MAX_VALUE);
        triggerStartDocument();
        if (this.state != WriteState.AfterXmlDecl) {
            throw new XmlException("Writing a DTD is only allowed once, in the prolog", null, 2, null);
        }
        this.state = WriteState.AfterDocTypeDecl;
        this.writer.append("<!DOCTYPE ").append(StringsKt.trimStart((CharSequence) text).toString()).append(">");
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        writeIndent(Integer.MAX_VALUE);
        triggerStartDocument();
        this.writer.append("<?");
        this.writer.append(text);
        this.writer.append("?>");
    }

    @Override // nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase, nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String target, String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        finishPartialStartTag(false);
        writeIndent(Integer.MAX_VALUE);
        triggerStartDocument();
        this.writer.append("<?");
        this.writer.append(target);
        if (data.length() > 0) {
            this.writer.append(' ').append(data);
        }
        this.writer.append("?>");
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startTag(String namespace, String localName, String prefix) {
        String reg;
        Intrinsics.checkNotNullParameter(localName, "localName");
        boolean z = false;
        finishPartialStartTag(false);
        writeIndent$default(this, 0, 1, null);
        triggerStartDocument();
        if (this.state == WriteState.Finished) {
            throw new XmlException("Attempting to write tag after the document finished", null, 2, null);
        }
        this.state = WriteState.InTagContent;
        if (Intrinsics.areEqual(namespace, "")) {
            reg = "";
        } else {
            reg = getPrefix(namespace);
            if (reg == null) {
                reg = prefix == null ? this.namespaceHolder.nextAutoPrefix() : prefix;
            }
        }
        setElementStack(getDepth(), namespace != null ? namespace : "", reg, localName);
        this.writer.append(Typography.less);
        if (reg.length() > 0) {
            z = true;
        }
        if (z) {
            this.writer.append(reg);
            this.writer.append(AbstractJsonLexerKt.COLON);
        }
        this.writer.append(localName);
        this.isPartiallyOpenTag = true;
        this.namespaceHolder.incDepth();
        ensureNamespaceIfRepairing(namespace, reg);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endTag(String namespace, String localName, String prefix) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        this.namespaceHolder.decDepth();
        writeIndent(Integer.MAX_VALUE);
        if (!Intrinsics.areEqual(namespace == null ? "" : namespace, namespaceAt(getDepth())) || !Intrinsics.areEqual(localNameAt(getDepth()), localName)) {
            throw new IllegalArgumentException("</{" + namespace + AbstractJsonLexerKt.END_OBJ + localName + "> does not match start");
        }
        if (this.isPartiallyOpenTag) {
            finishPartialStartTag(true);
            return;
        }
        this.writer.append("</");
        String actualPrefix = prefixAt(getDepth());
        if (actualPrefix.length() > 0) {
            this.writer.append(actualPrefix);
            this.writer.append(AbstractJsonLexerKt.COLON);
        }
        this.writer.append(localName);
        this.writer.append(Typography.greater);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void comment(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        writeIndent(Integer.MAX_VALUE);
        triggerStartDocument();
        boolean lastWasHyphen = false;
        this.writer.append("<!--");
        for (UInt uInt : KtXmlWriterKt.asCodePoints(text)) {
            int cp = uInt.unbox-impl();
            if (cp == UInt.constructor-impl(45)) {
                if (lastWasHyphen) {
                    lastWasHyphen = false;
                    this.writer.append("&#x2d;");
                } else {
                    lastWasHyphen = true;
                    this.writer.append('-');
                }
            } else {
                m1619appendXmlCodepointOsBMiQA(this.writer, cp, EscapeMode.MINIMAL);
                Unit unit = Unit.INSTANCE;
            }
        }
        this.writer.append("-->");
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        writeEscapedText(text, EscapeMode.TEXTCONTENT);
        this.lastTagDepth = -1;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void cdsect(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        int endPos = 0;
        this.writer.append("<![CDATA[");
        for (UInt uInt : KtXmlWriterKt.asCodePoints(text)) {
            int cp = uInt.unbox-impl();
            char ch = ConverterUtilsKt$.ExternalSyntheticBackport0.m(cp, 32223) < 0 ? (char) (UShort.constructor-impl((short) cp) & 65535) : (char) 0;
            if (ch == ']' && (endPos == 0 || endPos == 1)) {
                endPos++;
                this.writer.append(ch);
            } else if (ch == '>' && endPos == 2) {
                this.writer.append("&gt;");
            } else if (ch == ']' && endPos == 2) {
                this.writer.append(ch);
            } else {
                endPos = 0;
                m1619appendXmlCodepointOsBMiQA(this.writer, cp, EscapeMode.MINIMAL);
                Unit unit = Unit.INSTANCE;
            }
        }
        this.writer.append("]]>");
        this.lastTagDepth = -1;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void entityRef(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        this.writer.append(Typography.amp).append(text).append(';');
        this.lastTagDepth = -1;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void ignorableWhitespace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        finishPartialStartTag(false);
        triggerStartDocument();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            switch (c) {
                case '\t':
                case '\n':
                case additional_type_content_video_VALUE:
                case ' ':
                default:
                    throw new IllegalArgumentException('\"' + text + "\" is not ignorable whitespace");
            }
        }
        this.writer.append(text);
        this.lastTagDepth = -1;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void attribute(String namespace, String name, String prefix, String value) {
        String str;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(namespace, XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
            namespaceAttr(name, value);
            return;
        }
        String str2 = namespace;
        boolean z = false;
        if ((str2 == null || str2.length() == 0) && Intrinsics.areEqual(XMLConstants.XMLNS_ATTRIBUTE, name)) {
            namespaceAttr("", value);
            return;
        }
        String str3 = prefix;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = namespace;
            if (!(str4 == null || str4.length() == 0)) {
                setPrefix(prefix, namespace);
                ensureNamespaceIfRepairing(namespace, prefix);
            }
        }
        if (!this.isPartiallyOpenTag) {
            throw new IllegalStateException("illegal position for attribute");
        }
        String str5 = prefix;
        if (str5 == null || str5.length() == 0) {
            z = true;
        }
        if (z || Intrinsics.areEqual(getNamespaceUri(prefix), namespace)) {
            str = prefix;
        } else {
            str = getPrefix(namespace);
        }
        String actualPrefix = str != null ? str : "";
        rawWriteAttribute(actualPrefix, name, value);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void namespaceAttr(String namespacePrefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        String existingNamespaceForPrefix = this.namespaceHolder.namespaceAtCurrentDepth(namespacePrefix);
        if (existingNamespaceForPrefix != null) {
            if (this.isRepairNamespaces) {
                return;
            }
            if (!Intrinsics.areEqual(existingNamespaceForPrefix, namespaceUri)) {
                throw new IllegalStateException("Attempting to set prefix to different values in the same tag");
            }
            throw new IllegalStateException("Namespace attribute duplicated");
        }
        this.namespaceHolder.addPrefixToContext(namespacePrefix, namespaceUri);
        if (!this.isPartiallyOpenTag) {
            throw new IllegalStateException("illegal position for attribute");
        }
        if (namespacePrefix.length() > 0) {
            rawWriteAttribute(XMLConstants.XMLNS_ATTRIBUTE, namespacePrefix, namespaceUri);
        } else {
            rawWriteAttribute("", XMLConstants.XMLNS_ATTRIBUTE, namespaceUri);
        }
    }

    private final void rawWriteAttribute(String prefix, String localName, String value) {
        this.writer.append(' ');
        if (prefix.length() > 0) {
            this.writer.append(prefix).append(AbstractJsonLexerKt.COLON);
        }
        this.writer.append(localName).append('=');
        Pair pair = StringsKt.indexOf$default((CharSequence) value, '\"', 0, false, 6, (Object) null) == -1 ? new Pair('\"', EscapeMode.ATTRCONTENTQUOT) : new Pair('\'', EscapeMode.ATTRCONTENTAPOS);
        char q = ((Character) pair.component1()).charValue();
        EscapeMode mode = (EscapeMode) pair.component2();
        this.writer.append(q);
        writeEscapedText(value, mode);
        this.writer.append(q);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endDocument() {
        Multiplatform_jvmKt.m1630assert(getDepth() == 0);
        if (this.state != WriteState.InTagContent) {
            throw new XmlException("Attempting to end document when in invalid state: " + this.state, null, 2, null);
        }
        while (getDepth() > 0) {
            endTag(namespaceAt(getDepth() - 1), prefixAt(getDepth() - 1), localNameAt(getDepth() - 1));
        }
        flush();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setPrefix(String prefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        if (!Intrinsics.areEqual(namespaceUri, getNamespaceUri(prefix))) {
            this.namespaceHolder.addPrefixToContext(prefix, namespaceUri);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getNamespaceUri(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.namespaceHolder.getNamespaceUri(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getPrefix(String namespaceUri) {
        if (namespaceUri != null) {
            String it = this.namespaceHolder.getPrefix(namespaceUri);
            return it;
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.namespaceHolder.clear();
    }

    /* compiled from: KtXmlWriter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlWriter$Companion;", "", "<init>", "()V", "TAG_DEPTH_NOT_TAG", "", "TAG_DEPTH_FORCE_INDENT_NEXT", "ESCAPED_CHARS", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        boolean[] it = new boolean[255];
        for (int i = 1; i < 9; i++) {
            it[i] = true;
        }
        it[11] = true;
        it[12] = true;
        for (int i2 = 14; i2 < 31; i2++) {
            it[i2] = true;
        }
        it[60] = true;
        it[62] = true;
        it[38] = true;
        it[39] = true;
        it[34] = true;
        for (int i3 = WorkQueueKt.MASK; i3 < 133; i3++) {
            it[i3] = true;
        }
        for (int i4 = 134; i4 < 160; i4++) {
            it[i4] = true;
        }
        ESCAPED_CHARS = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlWriter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlWriter$WriteState;", "", "<init>", "(Ljava/lang/String;I)V", "BeforeDocument", "AfterXmlDecl", "AfterDocTypeDecl", "InTagContent", "Finished", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum WriteState {
        BeforeDocument,
        AfterXmlDecl,
        AfterDocTypeDecl,
        InTagContent,
        Finished;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<WriteState> getEntries() {
            return $ENTRIES;
        }
    }
}