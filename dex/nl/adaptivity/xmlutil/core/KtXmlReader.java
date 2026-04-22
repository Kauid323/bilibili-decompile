package nl.adaptivity.xmlutil.core;

import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.EventType;
import nl.adaptivity.xmlutil.ExperimentalXmlUtilApi;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.XmlException;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.core.impl.EntityMap;
import nl.adaptivity.xmlutil.core.impl.NamespaceHolder;
import nl.adaptivity.xmlutil.core.internal.StringUtilKt;
import org.webrtc.H265Utils;

/* compiled from: KtXmlReader.kt */
@ExperimentalXmlUtilApi
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 Ë\u00012\u00020\u0001:\fË\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001B)\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u001f\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000bJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020TH\u0002J\u0012\u0010V\u001a\u00020T2\b\b\u0002\u0010W\u001a\u00020\u0010H\u0002J\u001a\u0010X\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\u0010\u0010\\\u001a\u00020T2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010]\u001a\u00020TH\u0002J\b\u0010^\u001a\u00020TH\u0002J\b\u0010_\u001a\u00020TH\u0002J\b\u0010`\u001a\u00020TH\u0002J\u0010\u0010a\u001a\u00020T2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020TH\u0002J\b\u0010e\u001a\u00020TH\u0002J\b\u0010f\u001a\u00020TH\u0002J\b\u0010g\u001a\u00020TH\u0002J\b\u0010h\u001a\u00020TH\u0002J\b\u0010i\u001a\u00020\u0017H\u0002J\b\u0010j\u001a\u00020\u0006H\u0002J\b\u0010k\u001a\u00020TH\u0002J\b\u0010l\u001a\u00020TH\u0002J \u0010m\u001a\u00020T2\u0006\u0010n\u001a\u0002072\u0006\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u0010H\u0002J\u0010\u0010q\u001a\u00020T2\u0006\u0010r\u001a\u00020\u0006H\u0002J\u0010\u0010s\u001a\u00020T2\u0006\u0010t\u001a\u00020cH\u0002J\u0010\u0010s\u001a\u00020T2\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0010\u0010v\u001a\u00020T2\u0006\u0010t\u001a\u00020\u0010H\u0002J\u0010\u0010w\u001a\u00020T2\u0006\u0010x\u001a\u00020\bH\u0002J\b\u0010y\u001a\u00020TH\u0002J\b\u0010z\u001a\u00020TH\u0002J\b\u0010{\u001a\u00020TH\u0002J\u0010\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020cH\u0002J\u0018\u0010~\u001a\u00020T2\u0006\u0010}\u001a\u00020c2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\t\u0010\u0080\u0001\u001a\u00020TH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020T2\u0006\u0010r\u001a\u00020\u0006H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020T2\u0006\u0010t\u001a\u00020cH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020T2\u0006\u0010t\u001a\u00020cH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0010H\u0002J\t\u0010\u0083\u0001\u001a\u00020cH\u0002J\u0014\u0010\u0084\u0001\u001a\u00020T2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0010H\u0002J\t\u0010\u0086\u0001\u001a\u00020TH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u0010H\u0002J\t\u0010\u0088\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020c2\u0007\u0010\u0089\u0001\u001a\u00020\u0010H\u0002J\u001a\u0010\u008c\u0001\u001a\u00020T2\u0007\u0010\u0089\u0001\u001a\u00020\u00102\u0006\u0010%\u001a\u00020cH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u008e\u0001\u001a\u00020TH\u0002J\t\u0010\u008f\u0001\u001a\u00020TH\u0002J\u0014\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0016J\t\u0010\u0092\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0093\u0001\u001a\u00020\u0006H\u0016J\u0007\u0010\u009c\u0001\u001a\u00020\u0010J\u0007\u0010\u009d\u0001\u001a\u00020\u0010J\b\u0010E\u001a\u00020\bH\u0016J\u0007\u0010¤\u0001\u001a\u00020\bJ\u0012\u0010¥\u0001\u001a\u00020\u00062\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010§\u0001\u001a\u00020\u00062\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010¨\u0001\u001a\u00020\u00062\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010©\u0001\u001a\u00020\u00062\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0016J\u001e\u0010©\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\n\u0010«\u0001\u001a\u00020\u0017H\u0096\u0002J\n\u0010¬\u0001\u001a\u00020\bH\u0096\u0002J\t\u0010\u00ad\u0001\u001a\u00020\u0017H\u0016J(\u0010®\u0001\u001a\u00020T2\u0007\u0010¯\u0001\u001a\u00020\u00172\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u001c\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\bÂ\u0001\u0010·\u0001R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0012\u0010+\u001a\u00060,R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\"\u0010.\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR$\u00100\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b@RX\u0096\u000e¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0013R\u0012\u0010?\u001a\u00060@R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001e\u0010\u0094\u0001\u001a\u00020\u00068VX\u0097\u0004¢\u0006\u000f\u0012\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0005\b\u0097\u0001\u0010\u001fR\u0018\u0010\u0098\u0001\u001a\u00030\u0099\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009e\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010\u001fR\u0016\u0010 \u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\u001fR\u0016\u0010¢\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\u001fR\u0019\u0010²\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R2\u0010°\u0001\u001a\u0004\u0018\u00010\u0006*\u00030´\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R1\u0010\"\u001a\u0004\u0018\u00010\u0006*\u00030´\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b¼\u0001\u0010¹\u0001\"\u0006\b½\u0001\u0010»\u0001R1\u0010\u001d\u001a\u0004\u0018\u00010\u0006*\u00030´\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b¾\u0001\u0010¹\u0001\"\u0006\b¿\u0001\u0010»\u0001R2\u0010°\u0001\u001a\u0004\u0018\u00010\u0006*\u00030Á\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÃ\u0001\u0010¹\u0001\"\u0006\bÄ\u0001\u0010»\u0001R1\u0010\"\u001a\u0004\u0018\u00010\u0006*\u00030Á\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÅ\u0001\u0010¹\u0001\"\u0006\bÆ\u0001\u0010»\u0001R1\u0010\u001d\u001a\u0004\u0018\u00010\u0006*\u00030Á\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÇ\u0001\u0010¹\u0001\"\u0006\bÈ\u0001\u0010»\u0001R1\u0010%\u001a\u0004\u0018\u00010\u0006*\u00030Á\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÉ\u0001\u0010¹\u0001\"\u0006\bÊ\u0001\u0010»\u0001¨\u0006Ñ\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader;", "Lnl/adaptivity/xmlutil/XmlReader;", "reader", "Ljava/io/Reader;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Reader;", "encoding", "", "relaxed", "", "<init>", "(Ljava/io/Reader;Ljava/lang/String;Z)V", "(Ljava/io/Reader;Z)V", "Ljava/io/Reader;", "getRelaxed", "()Z", "line", "", "column", "getColumn", "()I", "lastColumnStart", "offset", "_eventType", "Lnl/adaptivity/xmlutil/EventType;", "eventType", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "isStarted", "entityName", "localName", "getLocalName", "()Ljava/lang/String;", "namespaceURI", "getNamespaceURI", "prefix", "getPrefix", "isSelfClosing", "value", "attributeCount", "getAttributeCount", "attrData", "", "[Ljava/lang/String;", "attributes", "Lnl/adaptivity/xmlutil/core/KtXmlReader$AttributesCollection;", "getEncoding", "version", "getVersion", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "srcBufPos", "srcBufCount", "bufLeft", "", "bufRight", "entityMap", "Lnl/adaptivity/xmlutil/core/impl/EntityMap;", "namespaceHolder", "Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "depth", "getDepth", "elementStack", "Lnl/adaptivity/xmlutil/core/KtXmlReader$ElementStack;", "readPrefix", "readLocalname", "outputBuf", "outputBufRight", "isWhitespace", "error", "unresolved", "state", "Lnl/adaptivity/xmlutil/core/KtXmlReader$State;", "namespaceDecls", "", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "()Ljava/util/List;", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "close", "", "incCol", "incLine", "offsetAdd", "adjustNsp", "desc", "exception", "", "parseUnexpectedOrWS", "nextImplDocStart", "nextImplPreamble", "nextImplBody", "nextImplPost", "readTagContentUntil", "delim", "", "parsePI", "parseComment", "parseCData", "parseDoctype", "parseEndTag", "peekType", "get", "popOutput", "resetOutputBuffer", "pushRange", "buffer", "start", "endExcl", "push", "s", "pushChar", "c", "cp", "pushCodePoint", "parseStartTag", "xmldecl", "pushEntity", "pushRefEntity", "pushCharEntity", "pushText", "delimiter", "pushRegularText", "resolveEntities", "pushWSDelimAttrValue", "read", "readAssert", "readAndPush", "growOutputBuf", "minNeeded", "swapInputBuffer", "readAcross", "peek", "pos", "peekAcross", "getBuf", "setBuf", "readName", "readCName", "skip", "getNamespacePrefix", "namespaceUri", "getPositionDescription", "toString", "locationInfo", "getLocationInfo$annotations", "()V", "getLocationInfo", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getLineNumber", "getColumnNumber", "text", "getText", "piTarget", "getPiTarget", "piData", "getPiData", "isEmptyElementTag", "getAttributeNamespace", "index", "getAttributeLocalName", "getAttributePrefix", "getAttributeValue", "nsUri", "next", "hasNext", "nextTag", "require", "type", "namespace", "name", "elementData", "element", "Lnl/adaptivity/xmlutil/core/KtXmlReader$ElementDelegate;", "idx", "element-tPtF754", "(I)I", "getNamespace-Wdoxvj4", "(I)Ljava/lang/String;", "setNamespace-zO6yCoI", "(ILjava/lang/String;)V", "getPrefix-Wdoxvj4", "setPrefix-zO6yCoI", "getLocalName-Wdoxvj4", "setLocalName-zO6yCoI", "attribute", "Lnl/adaptivity/xmlutil/core/KtXmlReader$AttributeDelegate;", "attribute-hc9wHSM", "getNamespace-X2amM8A", "setNamespace-tlzzZ4Q", "getPrefix-X2amM8A", "setPrefix-tlzzZ4Q", "getLocalName-X2amM8A", "setLocalName-tlzzZ4Q", "getValue-X2amM8A", "setValue-tlzzZ4Q", "Companion", "ElementStack", "ElementDelegate", "AttributesCollection", "AttributeDelegate", "State", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtXmlReader implements XmlReader {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String ILLEGAL_TYPE = "Wrong event type";
    @Deprecated
    public static final boolean PROCESS_NAMESPACES = true;
    @Deprecated
    public static final String UNEXPECTED_EOF = "Unexpected EOF";
    private EventType _eventType;
    private String[] attrData;
    private int attributeCount;
    private AttributesCollection attributes;
    private char[] bufLeft;
    private char[] bufRight;
    private String[] elementData;
    private ElementStack elementStack;
    private String encoding;
    private EntityMap entityMap;
    private String entityName;
    private String error;
    private boolean isSelfClosing;
    private boolean isWhitespace;
    private int lastColumnStart;
    private int line;
    private final NamespaceHolder namespaceHolder;
    private int offset;
    private char[] outputBuf;
    private int outputBufRight;
    private String readLocalname;
    private String readPrefix;
    private final Reader reader;
    private final boolean relaxed;
    private int srcBufCount;
    private int srcBufPos;
    private Boolean standalone;
    private State state;
    private boolean unresolved;
    private String version;

    /* compiled from: KtXmlReader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.ENTITY_REF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.END_ELEMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.ATTRIBUTE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EventType.IGNORABLE_WHITESPACE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EventType.COMMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EventType.TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EventType.CDSECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EventType.DOCDECL.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EventType.END_DOCUMENT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[State.values().length];
            try {
                iArr2[State.BEFORE_START.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr2[State.START_DOC.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr2[State.DOCTYPE_DECL.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr2[State.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr2[State.POST.ordinal()] = 5;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr2[State.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError e18) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Deprecated(message = "Use extLocationInfo as that allows more detailed information", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
    public static /* synthetic */ void getLocationInfo$annotations() {
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getAttributeName(int i) {
        return XmlReader.CC.$default$getAttributeName(this, i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ String getAttributeValue(QName qName) {
        return XmlReader.CC.$default$getAttributeValue(this, qName);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getName() {
        return XmlReader.CC.$default$getName(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isCharacters() {
        return XmlReader.CC.$default$isCharacters(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isEndElement() {
        return XmlReader.CC.$default$isEndElement(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isStartElement() {
        return XmlReader.CC.$default$isStartElement(this);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ void require(EventType eventType, QName qName) {
        XmlReader.CC.$default$require(this, eventType, qName);
    }

    public KtXmlReader(Reader reader, String encoding, boolean relaxed) {
        boolean z;
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
        this.relaxed = relaxed;
        this.line = 1;
        this.attrData = new String[16];
        this.attributes = new AttributesCollection();
        this.encoding = encoding;
        this.bufLeft = new char[4096];
        int cnt = Companion.readUntilFullOrEOF(this.reader, this.bufLeft);
        if (cnt >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("Trying to parse an empty file (that is not valid XML)".toString());
        }
        if (cnt < 4096) {
            this.bufRight = new char[0];
            this.srcBufCount = cnt;
        } else {
            char[] newRight = new char[4096];
            this.bufRight = newRight;
            this.srcBufCount = RangesKt.coerceAtLeast(Companion.readUntilFullOrEOF(this.reader, newRight), 0) + 4096;
        }
        if (this.bufLeft[0] == 65279) {
            this.srcBufPos = 1;
            this.offset = 1;
            this.lastColumnStart = 1;
        }
        this.entityMap = new EntityMap();
        this.namespaceHolder = new NamespaceHolder();
        this.elementStack = new ElementStack();
        this.outputBuf = new char[ConstantsKt.MINIMUM_BLOCK_SIZE];
        this.state = State.BEFORE_START;
        this.elementData = new String[48];
    }

    public /* synthetic */ KtXmlReader(Reader reader, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reader, str, (i & 4) != 0 ? false : z);
    }

    public final boolean getRelaxed() {
        return this.relaxed;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KtXmlReader(Reader reader, boolean relaxed) {
        this(reader, null, relaxed);
        Intrinsics.checkNotNullParameter(reader, "reader");
    }

    public /* synthetic */ KtXmlReader(Reader reader, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reader, (i & 2) != 0 ? false : z);
    }

    private final int getColumn() {
        return (this.offset - this.lastColumnStart) + 1;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType getEventType() {
        EventType eventType = this._eventType;
        if (eventType != null) {
            return eventType;
        }
        throw new IllegalStateException("Not yet started");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStarted() {
        return this.state != State.BEFORE_START;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocalName() {
        String str;
        EventType eventType = this._eventType;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                str = this.entityName;
                if (str == null) {
                    throw new XmlException("Missing entity name", null, 2, null);
                }
                break;
            case 2:
            case 3:
                str = m1590getLocalNameWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1));
                if (str == null) {
                    throw new XmlException("Missing local name", null, 2, null);
                }
                break;
            default:
                throw new IllegalStateException("Local name not accessible outside of element tags");
        }
        return str;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI() {
        EventType eventType = this._eventType;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 2:
            case 3:
                String m1592getNamespaceWdoxvj4 = m1592getNamespaceWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1));
                if (m1592getNamespaceWdoxvj4 == null) {
                    throw new XmlException("Missing namespace", getExtLocationInfo());
                }
                return m1592getNamespaceWdoxvj4;
            default:
                throw new IllegalStateException("Local name not accessible outside of element tags");
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPrefix() {
        EventType eventType = this._eventType;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 2:
            case 3:
                String m1594getPrefixWdoxvj4 = m1594getPrefixWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1));
                return m1594getPrefixWdoxvj4 == null ? "" : m1594getPrefixWdoxvj4;
            default:
                throw new IllegalStateException("Local name not accessible outside of element tags");
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getEncoding() {
        return this.encoding;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getVersion() {
        return this.version;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public Boolean getStandalone() {
        return this.standalone;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getDepth() {
        return this.namespaceHolder.getDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public List<Namespace> getNamespaceDecls() {
        return this.namespaceHolder.getNamespacesAtCurrentDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        return this.namespaceHolder.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    private final void incCol() {
        this.offset++;
    }

    static /* synthetic */ void incLine$default(KtXmlReader ktXmlReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        ktXmlReader.incLine(i);
    }

    private final void incLine(int offsetAdd) {
        int newOffset = this.offset + offsetAdd;
        this.offset = newOffset;
        this.lastColumnStart = newOffset;
        this.line++;
    }

    private final boolean adjustNsp(String prefix, String localName) {
        String str;
        boolean hasActualAttribute = false;
        int attr = 0;
        while (true) {
            str = "";
            if (attr >= getAttributeCount()) {
                break;
            }
            int attrIdx = attr + 1;
            int attr2 = m1588attributehc9wHSM(attr);
            String aLocalName = m1591getLocalNameX2amM8A(attr2);
            Intrinsics.checkNotNull(aLocalName);
            String aPrefix = m1595getPrefixX2amM8A(attr2);
            if (Intrinsics.areEqual(aPrefix, XMLConstants.XMLNS_ATTRIBUTE)) {
                this.namespaceHolder.addPrefixToContext(aLocalName, m1596getValueX2amM8A(attr2));
                if (Intrinsics.areEqual(m1596getValueX2amM8A(attr2), "")) {
                    error("illegal empty namespace");
                }
                m1597setLocalNametlzzZ4Q(attr2, null);
            } else if (aPrefix == null && Intrinsics.areEqual(aLocalName, XMLConstants.XMLNS_ATTRIBUTE)) {
                this.namespaceHolder.addPrefixToContext("", m1596getValueX2amM8A(attr2));
                m1597setLocalNametlzzZ4Q(attr2, null);
            } else {
                hasActualAttribute = true;
                attr = attrIdx;
            }
            attr = attrIdx;
        }
        if (hasActualAttribute) {
            int attrIn = 0;
            int attrOutIdx = 0;
            while (attrIn < getAttributeCount()) {
                int attrInIdx = attrIn + 1;
                int attrIn2 = m1588attributehc9wHSM(attrIn);
                String attrLocalName = m1591getLocalNameX2amM8A(attrIn2);
                if (attrLocalName == null) {
                    attrIn = attrInIdx;
                } else {
                    int attrOutIdx2 = attrOutIdx + 1;
                    int attrOut = m1588attributehc9wHSM(attrOutIdx);
                    if (!AttributeDelegate.m1607equalsimpl0(attrIn2, attrOut)) {
                        this.attributes.copyNotNs(attrIn2, attrOut);
                    }
                    String attrPrefix = m1595getPrefixX2amM8A(attrIn2);
                    if (!Intrinsics.areEqual(attrPrefix, "")) {
                        if (attrPrefix != null) {
                            String attrNs = this.namespaceHolder.getNamespaceUri(attrPrefix);
                            if (attrNs == null) {
                                int it = this.elementStack.m1618gettPtF754(getDepth() - 1);
                                m1598setLocalNamezO6yCoI(it, localName);
                                m1602setPrefixzO6yCoI(it, prefix);
                                m1600setNamespacezO6yCoI(it, "<not yet set>");
                                error("Undefined Prefix: " + attrPrefix + " in " + this);
                            }
                            m1599setNamespacetlzzZ4Q(attrOut, attrNs);
                        } else {
                            m1599setNamespacetlzzZ4Q(attrOut, "");
                        }
                    } else {
                        error("illegal attribute name: " + Companion.fullname(attrPrefix, attrLocalName) + " at " + this);
                        m1599setNamespacetlzzZ4Q(attrOut, "");
                    }
                    attrIn = attrInIdx;
                    attrOutIdx = attrOutIdx2;
                }
            }
            if (attrIn != attrOutIdx) {
                this.attributes.shrink(attrOutIdx);
            }
        } else {
            this.attributes.shrink(0);
        }
        String it2 = this.namespaceHolder.getNamespaceUri(prefix == null ? "" : prefix);
        if (it2 != null) {
            str = it2;
        } else if (prefix != null) {
            error("undefined prefix: " + prefix);
        }
        String ns = str;
        int d = getDepth() - 1;
        m1602setPrefixzO6yCoI(this.elementStack.m1618gettPtF754(d), prefix);
        m1598setLocalNamezO6yCoI(this.elementStack.m1618gettPtF754(d), localName);
        m1600setNamespacezO6yCoI(this.elementStack.m1618gettPtF754(d), ns);
        return hasActualAttribute;
    }

    private final void error(String desc) {
        if (this.relaxed) {
            if (this.error == null) {
                this.error = "ERR: " + desc;
                return;
            }
            return;
        }
        exception(desc);
        throw new KotlinNothingValueException();
    }

    private final Void exception(String desc) {
        String sb;
        if (desc.length() < 100) {
            sb = desc;
        } else {
            StringBuilder sb2 = new StringBuilder();
            String substring = desc.substring(0, 100);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb = sb2.append(substring).append('\n').toString();
        }
        throw new XmlException(sb, this);
    }

    private final void parseUnexpectedOrWS(EventType eventType) {
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                error("Entity reference outside document body");
                pushEntity();
                return;
            case 2:
                error("Unexpected start tag after document body");
                parseStartTag(false);
                return;
            case 3:
                error("Unexpected end tag outside of body");
                parseEndTag();
                return;
            case 4:
                error("Unexpected START_DOCUMENT in state " + this.state);
                parseStartTag(true);
                return;
            case 5:
            case 6:
            case 7:
                throw new UnsupportedOperationException("Comments/WS are always allowed - they may start the document tough");
            case 8:
                pushText(Typography.less);
                if (!this.isWhitespace) {
                    error("Non-whitespace text where not expected: '" + getText() + '\'');
                    return;
                } else {
                    this._eventType = EventType.IGNORABLE_WHITESPACE;
                    return;
                }
            case 9:
                error("CData sections are not supported outside of the document body");
                parseCData();
                return;
            case 10:
                error("Document declarations are not supported outside the preamble");
                parseDoctype();
                return;
            case 11:
                error("End of document before end of document element");
                return;
            case additional_type_content_opus_VALUE:
                error("Processing instruction inside document body");
                parsePI();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void nextImplDocStart() {
        EventType eventType = peekType();
        if (eventType == EventType.START_DOCUMENT) {
            readAssert(Typography.less);
            readAssert('?');
            parseStartTag(true);
            if (getAttributeCount() < 1 || !Intrinsics.areEqual("version", m1591getLocalNameX2amM8A(m1588attributehc9wHSM(0)))) {
                error("version expected");
            }
            this.version = m1596getValueX2amM8A(m1588attributehc9wHSM(0));
            int pos = 1;
            if (1 < getAttributeCount() && Intrinsics.areEqual("encoding", m1591getLocalNameX2amM8A(m1588attributehc9wHSM(1)))) {
                this.encoding = m1596getValueX2amM8A(m1588attributehc9wHSM(1));
                pos = 1 + 1;
            }
            if (pos < getAttributeCount() && Intrinsics.areEqual("standalone", m1591getLocalNameX2amM8A(m1588attributehc9wHSM(pos)))) {
                String st = m1596getValueX2amM8A(m1588attributehc9wHSM(pos));
                if (Intrinsics.areEqual(st, "yes")) {
                    this.standalone = true;
                } else if (Intrinsics.areEqual(st, "no")) {
                    this.standalone = false;
                } else {
                    error("illegal standalone value: " + st);
                }
                pos++;
            }
            if (pos != getAttributeCount()) {
                error("illegal xmldecl");
            }
            this.isWhitespace = true;
        }
        this._eventType = EventType.START_DOCUMENT;
        this.state = State.START_DOC;
    }

    private final void nextImplPreamble() {
        String e = this.error;
        if (e != null) {
            push(e);
            this.error = null;
            this._eventType = EventType.COMMENT;
            return;
        }
        EventType eventType = peekType();
        this._eventType = eventType;
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 2:
                this.state = State.BODY;
                readAssert(Typography.less);
                parseStartTag(false);
                return;
            case 7:
                parseComment();
                return;
            case 10:
                read("<!DOCTYPE");
                parseDoctype();
                return;
            case additional_type_content_opus_VALUE:
                parsePI();
                return;
            default:
                parseUnexpectedOrWS(eventType);
                return;
        }
    }

    private final void nextImplBody() {
        if (this._eventType == EventType.END_ELEMENT) {
            this.namespaceHolder.decDepth();
        }
        if (this.isSelfClosing) {
            this.isSelfClosing = false;
            this._eventType = EventType.END_ELEMENT;
            if (getDepth() == 1) {
                this.state = State.POST;
                return;
            }
            return;
        }
        String e = this.error;
        if (e != null) {
            push(e);
            this.error = null;
            this._eventType = EventType.COMMENT;
            return;
        }
        EventType lastEvent = this._eventType;
        EventType eventType = peekType();
        this._eventType = eventType;
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                pushEntity();
                return;
            case 2:
                readAssert(Typography.less);
                parseStartTag(false);
                return;
            case 3:
                parseEndTag();
                if (getDepth() == 1) {
                    this.state = State.POST;
                    return;
                }
                return;
            case 4:
            case 5:
            case 6:
            default:
                parseUnexpectedOrWS(eventType);
                return;
            case 7:
                parseComment();
                return;
            case 8:
                if (lastEvent == EventType.ENTITY_REF) {
                    pushRegularText(Typography.less, false);
                    return;
                }
                pushText(Typography.less);
                if (this.isWhitespace) {
                    this._eventType = EventType.IGNORABLE_WHITESPACE;
                    return;
                }
                return;
            case 9:
                parseCData();
                return;
        }
    }

    private final void nextImplPost() {
        if (this._eventType == EventType.END_ELEMENT) {
            this.namespaceHolder.decDepth();
        }
        if (this.isSelfClosing) {
            this.isSelfClosing = false;
            this._eventType = EventType.END_ELEMENT;
            return;
        }
        String e = this.error;
        if (e != null) {
            push(e);
            this.error = null;
            this._eventType = EventType.COMMENT;
            return;
        }
        EventType eventType = peekType();
        this._eventType = eventType;
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 7:
                parseComment();
                return;
            case 11:
                this.state = State.EOF;
                return;
            case additional_type_content_opus_VALUE:
                parsePI();
                return;
            default:
                parseUnexpectedOrWS(eventType);
                return;
        }
    }

    private final void readTagContentUntil(char delim) {
        while (true) {
            char c = readAndPush();
            if (c == delim && peek() == 62) {
                popOutput();
                readAssert(Typography.greater);
                return;
            }
        }
    }

    private final void parsePI() {
        readAssert(Typography.less);
        readAssert('?');
        resetOutputBuffer();
        readTagContentUntil('?');
    }

    private final void parseComment() {
        readAssert(Typography.less);
        readAssert('!');
        readAssert('-');
        read('-');
        resetOutputBuffer();
        while (true) {
            char c = readAndPush();
            if (c == '-' && peek() == 45) {
                break;
            }
        }
        if (peek(1) != 62) {
            error("illegal comment delimiter: --->");
        }
        popOutput();
        readAssert('-');
        readAssert(Typography.greater);
    }

    private final void parseCData() {
        readAssert(Typography.less);
        readAssert('!');
        read("[CDATA[");
        resetOutputBuffer();
        while (true) {
            char c = readAndPush();
            if (c == ']' && peek() == 93 && peek(1) == 62) {
                popOutput();
                readAssert(AbstractJsonLexerKt.END_LIST);
                readAssert(Typography.greater);
                return;
            }
        }
    }

    private final void parseDoctype() {
        int nesting = 1;
        Character quote = null;
        while (true) {
            int i = read();
            switch (i) {
                case 34:
                case 39:
                    if (quote != null) {
                        if (quote.charValue() == ((char) i)) {
                            quote = null;
                            break;
                        }
                    } else {
                        quote = Character.valueOf((char) i);
                        break;
                    }
                    break;
                case 45:
                    if (quote != null && quote.charValue() == '!') {
                        pushChar('-');
                        int c = read();
                        pushChar(c);
                        if (c == 45) {
                            int c2 = read();
                            pushChar(c2);
                            if (c2 == 62) {
                                quote = null;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 60:
                    if (quote == null) {
                        if (nesting < 2) {
                            error("Doctype with internal subset must have an opening '['");
                        }
                        pushChar(Typography.less);
                        int c3 = read();
                        pushChar(c3);
                        if (c3 != 33) {
                            nesting++;
                            continue;
                        } else {
                            int c4 = read();
                            pushChar(c4);
                            if (c4 != 45) {
                                nesting++;
                            } else {
                                int c5 = read();
                                pushChar(c5);
                                if (c5 != 45) {
                                    nesting++;
                                } else {
                                    quote = '!';
                                    break;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                case 62:
                    if (quote == null) {
                        nesting--;
                        switch (nesting) {
                            case 0:
                                return;
                            case 1:
                                error("Missing closing ']' for doctype");
                                break;
                        }
                    }
                    break;
                case 91:
                    if (quote == null && nesting == 1) {
                        nesting++;
                        break;
                    }
                    break;
                case H265Utils.kLevel3_1 /* 93 */:
                    if (quote != null) {
                        break;
                    } else {
                        pushChar(AbstractJsonLexerKt.END_LIST);
                        int c6 = read();
                        pushChar(c6);
                        if (c6 == 62) {
                            if (nesting != 2) {
                                error("Invalid nesting of document type declaration: " + nesting);
                                return;
                            }
                            return;
                        }
                        continue;
                    }
            }
            pushChar(i);
        }
    }

    private final void parseEndTag() {
        int left2;
        if (getDepth() == 0) {
            error("element stack empty");
            this._eventType = EventType.COMMENT;
            return;
        }
        readAssert(Typography.less);
        readAssert('/');
        resetOutputBuffer();
        int spIdx = getDepth() - 1;
        String expectedPrefix = m1594getPrefixWdoxvj4(this.elementStack.m1618gettPtF754(spIdx));
        String expectedLocalName = m1590getLocalNameWdoxvj4(this.elementStack.m1618gettPtF754(spIdx));
        if (expectedLocalName == null) {
            exception("Missing localname");
            throw new KotlinNothingValueException();
        }
        int expectedLength = (expectedPrefix != null ? expectedPrefix.length() + 1 : 0) + expectedLocalName.length();
        int expectedEnd = this.srcBufPos + expectedLength;
        if (expectedEnd > this.srcBufCount) {
            exception(UNEXPECTED_EOF);
            throw new KotlinNothingValueException();
        } else if (expectedEnd < 4096) {
            if (expectedPrefix != null) {
                int left = this.srcBufPos;
                int length = expectedPrefix.length();
                for (int i = 0; i < length; i++) {
                    if (this.bufLeft[left + i] != expectedPrefix.charAt(i)) {
                        String expectedFullName = Companion.fullname(expectedPrefix, expectedLocalName);
                        error("expected: " + expectedFullName + " read: " + readName());
                    }
                }
                int i2 = expectedPrefix.length();
                left2 = i2 + left + 1;
            } else {
                left2 = this.srcBufPos;
            }
            int length2 = expectedLocalName.length();
            for (int i3 = 0; i3 < length2; i3++) {
                if (this.bufLeft[left2 + i3] != expectedLocalName.charAt(i3)) {
                    String expectedFullName2 = Companion.fullname(expectedPrefix, expectedLocalName);
                    error("expected: " + expectedFullName2 + " read: " + readName());
                }
            }
            int i4 = expectedLocalName.length();
            this.srcBufPos = i4 + left2;
            skip();
            read(Typography.greater);
        } else {
            readCName();
            skip();
            read(Typography.greater);
            if (!this.relaxed) {
                if (Intrinsics.areEqual(this.readPrefix, expectedPrefix) && Intrinsics.areEqual(this.readLocalname, expectedLocalName)) {
                    return;
                }
                String expectedFullName3 = Companion.fullname(expectedPrefix, expectedLocalName);
                Companion companion = Companion;
                String str = this.readPrefix;
                String str2 = this.readLocalname;
                Intrinsics.checkNotNull(str2);
                String fullName = companion.fullname(str, str2);
                error("expected: " + expectedFullName3 + " read: " + fullName);
            }
        }
    }

    private final EventType peekType() {
        switch (peek()) {
            case -1:
                return EventType.END_DOCUMENT;
            case 38:
                return EventType.ENTITY_REF;
            case 60:
                switch (peek(1)) {
                    case 33:
                        switch (peek(2)) {
                            case 45:
                                return EventType.COMMENT;
                            case 91:
                                return EventType.CDSECT;
                            default:
                                return EventType.DOCDECL;
                        }
                    case 47:
                        return EventType.END_ELEMENT;
                    case H265Utils.kLevel2_1 /* 63 */:
                        if (peek(2) == 120 && peek(3) == 109 && peek(4) == 108 && !StringUtilKt.isNameCodepoint$default(peek(5), false, 2, null)) {
                            return EventType.START_DOCUMENT;
                        }
                        return EventType.PROCESSING_INSTRUCTION;
                    default:
                        return EventType.START_ELEMENT;
                }
            default:
                return EventType.TEXT;
        }
    }

    private final String get() {
        return StringsKt.concatToString(this.outputBuf, 0, this.outputBufRight);
    }

    private final void popOutput() {
        this.outputBufRight--;
    }

    private final void resetOutputBuffer() {
        this.outputBufRight = 0;
    }

    private final void pushRange(char[] buffer, int start, int endExcl) {
        int count = endExcl - start;
        int outRight = this.outputBufRight;
        int minSizeNeeded = outRight + count;
        if (minSizeNeeded >= this.outputBuf.length) {
            growOutputBuf(minSizeNeeded);
        }
        ArraysKt.copyInto(buffer, this.outputBuf, outRight, start, endExcl);
        this.outputBufRight = outRight + count;
    }

    private final void push(String s) {
        int minSizeNeeded = this.outputBufRight + s.length();
        if (minSizeNeeded > this.outputBuf.length) {
            growOutputBuf(minSizeNeeded);
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            char[] cArr = this.outputBuf;
            int i2 = this.outputBufRight;
            this.outputBufRight = i2 + 1;
            cArr[i2] = c;
        }
    }

    private final void pushChar(char c) {
        int newPos = this.outputBufRight;
        if (newPos >= this.outputBuf.length) {
            growOutputBuf$default(this, 0, 1, null);
        }
        char[] cArr = this.outputBuf;
        int i = this.outputBufRight;
        this.outputBufRight = i + 1;
        cArr[i] = c;
    }

    private final void pushChar(int cp) {
        if (cp >= 0) {
            pushChar((char) cp);
        } else {
            error(UNEXPECTED_EOF);
        }
    }

    private final void pushCodePoint(int c) {
        if (c < 0) {
            error("UNEXPECTED EOF");
        }
        int newPos = this.outputBufRight;
        if (newPos + 1 >= this.outputBuf.length) {
            growOutputBuf$default(this, 0, 1, null);
        }
        if (c > 65535) {
            int offset = c - 65536;
            char[] cArr = this.outputBuf;
            int i = this.outputBufRight;
            this.outputBufRight = i + 1;
            cArr[i] = (char) ((offset >>> 10) + 55296);
            char[] cArr2 = this.outputBuf;
            int i2 = this.outputBufRight;
            this.outputBufRight = i2 + 1;
            cArr2[i2] = (char) ((offset & 1023) + 56320);
            return;
        }
        char[] cArr3 = this.outputBuf;
        int i3 = this.outputBufRight;
        this.outputBufRight = i3 + 1;
        cArr3[i3] = (char) c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00aa, code lost:
        getDepth();
        r8.namespaceHolder.incDepth();
        r8.elementStack.ensureCapacity(getDepth());
        adjustNsp(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c0, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void parseStartTag(boolean xmldecl) {
        String prefix;
        String localName;
        resetOutputBuffer();
        if (xmldecl) {
            prefix = null;
            localName = readName();
        } else {
            readCName();
            prefix = this.readPrefix;
            String str = this.readLocalname;
            Intrinsics.checkNotNull(str);
            localName = str;
        }
        this.attributes.clear();
        while (true) {
            skip();
            int c = peek(0);
            switch (c) {
                case -1:
                    error(UNEXPECTED_EOF);
                    return;
                case 9:
                case 10:
                case additional_type_content_video_VALUE:
                case 32:
                    next();
                    break;
                case 47:
                    if (xmldecl) {
                        error("/ found to close xml declaration");
                    }
                    this.isSelfClosing = true;
                    readAssert('/');
                    if (XmlUtil.isXmlWhitespace((char) peek())) {
                        error("ERR: Whitespace between empty content tag closing elements");
                        while (XmlUtil.isXmlWhitespace((char) peek())) {
                            read();
                        }
                    }
                    read(Typography.greater);
                    break;
                case 62:
                    if (xmldecl) {
                        error("xml declaration must be closed by '?>', not '>'");
                    }
                    readAssert(Typography.greater);
                    break;
                case H265Utils.kLevel2_1 /* 63 */:
                    if (!xmldecl) {
                        error("? found outside of xml declaration");
                    }
                    readAssert('?');
                    read(Typography.greater);
                    return;
                default:
                    if (StringUtilKt.isNameStartChar((char) c)) {
                        resetOutputBuffer();
                        readCName();
                        String aLocalName = this.readLocalname;
                        Intrinsics.checkNotNull(aLocalName);
                        if (aLocalName.length() == 0) {
                            error("attr name expected");
                            break;
                        } else {
                            skip();
                            if (peek() == 61) {
                                read('=');
                                skip();
                                int delimiter = peek();
                                switch (delimiter) {
                                    case 34:
                                    case 39:
                                        readAssert((char) delimiter);
                                        resetOutputBuffer();
                                        pushRegularText((char) delimiter, true);
                                        readAssert((char) delimiter);
                                        break;
                                    default:
                                        error("attr value delimiter missing!");
                                        resetOutputBuffer();
                                        pushWSDelimAttrValue();
                                        break;
                                }
                                this.attributes.addNsUnresolved(this.readPrefix, aLocalName, get());
                                break;
                            } else {
                                String fullname = Companion.fullname(this.readPrefix, aLocalName);
                                error("Attr.value missing in " + fullname + " '='. Found: " + ((char) peek(0)));
                                this.attributes.addNsUnresolved(this.readPrefix, aLocalName, fullname);
                                break;
                            }
                        }
                    } else {
                        String fullName = Companion.fullname(prefix, localName);
                        error("unexpected character in tag(" + fullName + "): '" + ((char) c) + '\'');
                        readAssert((char) c);
                        break;
                    }
            }
        }
    }

    private final void pushEntity() {
        readAssert(Typography.amp);
        int first = peek(0);
        if (first != 35) {
            if (first >= 0) {
                pushRefEntity();
                return;
            } else {
                error(UNEXPECTED_EOF);
                return;
            }
        }
        pushCharEntity();
    }

    private final void pushRefEntity() {
        int first = read();
        StringBuilder codeBuilder = new StringBuilder(8);
        if (!StringUtilKt.isNameStartChar((char) first)) {
            error("Entity reference does not start with name char &" + get() + ((char) first));
            return;
        }
        codeBuilder.append((char) first);
        while (true) {
            int c = peek(0);
            if (c == 59) {
                readAssert(';');
                String code = codeBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(code, "toString(...)");
                if (this._eventType == EventType.ENTITY_REF) {
                    this.entityName = code;
                }
                String result = this.entityMap.get(code);
                this.unresolved = result == null;
                if (result != null) {
                    push(result);
                    return;
                }
                return;
            } else if (!StringUtilKt.isNameChar11((char) c)) {
                error("unterminated entity ref (" + ((Object) codeBuilder) + ')');
                return;
            } else {
                codeBuilder.append((char) read());
            }
        }
    }

    private final void pushCharEntity() {
        readAssert('#');
        StringBuilder codeBuilder = new StringBuilder(8);
        boolean isHex = false;
        int first = read();
        if (first == 120) {
            isHex = true;
        } else {
            if (48 <= first && first < 58) {
                codeBuilder.append((char) first);
            } else {
                error("Unexpected start of numeric entity reference '&" + ((char) first) + '\'');
            }
        }
        while (true) {
            int c = peek(0);
            if (c == -1) {
                error(UNEXPECTED_EOF);
            } else if (c == 59) {
                readAssert(';');
                break;
            } else {
                if (!(97 <= c && c < 103)) {
                    if (!(65 <= c && c < 71)) {
                        if (!(48 <= c && c < 58)) {
                            error("Unexpected content in numeric entity reference: " + ((char) c) + " (in " + ((Object) codeBuilder));
                            break;
                        }
                    }
                }
                int cp = read();
                codeBuilder.append((char) cp);
            }
        }
        String code = codeBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(code, "toString(...)");
        if (this._eventType == EventType.ENTITY_REF) {
            this.entityName = code;
        }
        int cp2 = isHex ? Integer.parseInt(code, CharsKt.checkRadix(16)) : Integer.parseInt(code);
        pushCodePoint(cp2);
    }

    private final void pushText(char delimiter) {
        char peekChar;
        int bufCount = this.srcBufCount;
        int innerLoopEnd = Math.min(bufCount, 4096);
        int curPos = this.srcBufPos;
        if (curPos < innerLoopEnd) {
            switch (this.bufLeft[curPos]) {
                case '\t':
                case '\n':
                case additional_type_content_video_VALUE:
                case ' ':
                    break;
                default:
                    pushRegularText(delimiter, false);
                    return;
            }
        }
        int left = curPos;
        int right = -1;
        boolean notFinished = true;
        while (curPos < bufCount && notFinished) {
            boolean continueInNonWSMode = false;
            while (true) {
                if (curPos < innerLoopEnd) {
                    char c = this.bufLeft[curPos];
                    if (c == '\r') {
                        if (right > left + 1) {
                            pushRange(this.bufLeft, left, right);
                        }
                        right = -1;
                        int i = curPos + 1;
                        if (i == bufCount) {
                            peekChar = 0;
                        } else {
                            peekChar = i == 4096 ? this.bufRight[0] : this.bufLeft[curPos + 1];
                        }
                        if (peekChar == '\n') {
                            this.offset++;
                        } else {
                            pushChar('\n');
                            incLine$default(this, 0, 1, null);
                        }
                        left = curPos + 1;
                        curPos++;
                    } else if (c == '\n') {
                        incLine$default(this, 0, 1, null);
                        curPos++;
                    } else if (c == ' ' || c == '\t') {
                        incCol();
                        curPos++;
                    } else if (c == delimiter) {
                        notFinished = false;
                        right = curPos;
                    } else {
                        continueInNonWSMode = true;
                        right = curPos;
                    }
                }
            }
            if (curPos == innerLoopEnd) {
                right = curPos;
            }
            if (right > left) {
                pushRange(this.bufLeft, left, right);
                right = -1;
            }
            if (curPos == 4096) {
                this.srcBufPos = curPos;
                swapInputBuffer();
                curPos = this.srcBufPos;
                bufCount = this.srcBufCount;
                innerLoopEnd = Math.min(bufCount, 4096);
            }
            if (continueInNonWSMode) {
                this.srcBufPos = curPos;
                pushRegularText(delimiter, false);
                return;
            }
            left = curPos;
        }
        this.isWhitespace = true;
        this.srcBufPos = curPos;
    }

    private final void pushRegularText(char delimiter, boolean resolveEntities) {
        int next;
        int bufCount = this.srcBufCount;
        int innerLoopEnd = Math.min(bufCount, 4096);
        int curPos = this.srcBufPos;
        int left = curPos;
        int right = -1;
        boolean notFinished = true;
        while (curPos < bufCount && notFinished) {
            while (true) {
                if (curPos >= innerLoopEnd) {
                    break;
                }
                char c = this.bufLeft[curPos];
                if (c == delimiter) {
                    notFinished = false;
                    right = curPos;
                    break;
                } else if (c == '\r') {
                    pushRange(this.bufLeft, left, curPos);
                    int next2 = curPos + 1;
                    if (next2 == bufCount) {
                        next = 0;
                    } else {
                        next = next2 == 4096 ? this.bufRight[0] == '\n' ? 1 : 0 : this.bufLeft[next2] == '\n' ? 1 : 0;
                    }
                    if (next != 0) {
                        incLine(2);
                        curPos += 2;
                    } else {
                        incLine$default(this, 0, 1, null);
                        curPos++;
                    }
                    pushChar('\n');
                    right = -1;
                    left = curPos;
                } else if (c == '\n') {
                    incLine$default(this, 0, 1, null);
                    curPos++;
                } else if (c == '&') {
                    if (!resolveEntities) {
                        right = curPos;
                        notFinished = false;
                        break;
                    } else if (left == curPos) {
                        this.srcBufPos = curPos;
                        pushEntity();
                        curPos = this.srcBufPos;
                        left = curPos;
                    } else {
                        right = curPos;
                        break;
                    }
                } else {
                    incCol();
                    curPos++;
                }
            }
            if (curPos == innerLoopEnd) {
                right = curPos;
            }
            if (right > 0) {
                pushRange(this.bufLeft, left, right);
                right = -1;
            }
            if (curPos >= 4096) {
                this.srcBufPos = curPos;
                swapInputBuffer();
                curPos = this.srcBufPos;
                bufCount = this.srcBufCount;
                innerLoopEnd = Math.min(bufCount, 4096);
            }
            left = curPos;
        }
        this.isWhitespace = false;
        this.srcBufPos = curPos;
    }

    private final void pushWSDelimAttrValue() {
        int bufCount = this.srcBufCount;
        int leftEnd = Math.min(bufCount, 4096);
        int curPos = this.srcBufPos;
        boolean notFinished = true;
        while (curPos < bufCount && notFinished) {
            int left = curPos;
            int right = -1;
            while (true) {
                if (curPos < leftEnd) {
                    switch (this.bufLeft[curPos]) {
                        case '\t':
                        case '\n':
                        case ' ':
                        case '>':
                            right = curPos;
                            curPos++;
                            notFinished = false;
                            break;
                        case additional_type_content_video_VALUE:
                            this.srcBufPos = curPos;
                            if (peek() == 10) {
                                this.srcBufPos++;
                                this.offset++;
                            }
                            right = curPos;
                            curPos = this.srcBufPos;
                            notFinished = false;
                            break;
                        case '&':
                            if (left == curPos) {
                                pushEntity();
                                curPos = this.srcBufPos;
                            } else {
                                right = curPos;
                                break;
                            }
                        default:
                            curPos++;
                    }
                }
            }
            if (right > 0) {
                pushRange(this.bufLeft, left, right);
            }
            if (curPos == 4096) {
                this.srcBufPos = curPos;
                swapInputBuffer();
                curPos = this.srcBufPos;
                bufCount = this.srcBufCount;
                leftEnd = Math.min(bufCount, 4096);
            }
        }
        this.srcBufPos = curPos;
    }

    private final void read(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int d = read();
            if (c != d) {
                error("Found unexpected character '" + d + "' while parsing '" + s + '\'');
            }
        }
    }

    private final void read(char c) {
        int a = read();
        if (a != c) {
            error("expected: '" + c + "' actual: '" + ((char) a) + '\'');
        }
    }

    private final void readAssert(char c) {
        read();
    }

    private final int read() {
        int pos = this.srcBufPos;
        if (pos >= this.srcBufCount) {
            return -1;
        }
        if (pos + 2 >= 4096) {
            return readAcross();
        }
        int next = pos + 1;
        char ch = this.bufLeft[pos];
        switch (ch) {
            case '\n':
                this.srcBufPos = next;
                incLine$default(this, 0, 1, null);
                return 10;
            case additional_type_content_video_VALUE:
                if (next < this.srcBufCount && this.bufLeft[next] == '\n') {
                    this.srcBufPos = next + 1;
                    incLine(2);
                } else {
                    this.srcBufPos = next;
                    incLine$default(this, 0, 1, null);
                }
                return 10;
            default:
                incCol();
                this.srcBufPos = next;
                return ch;
        }
    }

    private final char readAndPush() {
        int outRight;
        char result;
        int i;
        int pos = this.srcBufPos;
        if (pos >= this.srcBufCount) {
            exception(UNEXPECTED_EOF);
            throw new KotlinNothingValueException();
        }
        int nextSrcPos = pos + 1;
        if (nextSrcPos >= 4096) {
            int p0 = readAcross();
            pushChar(p0);
            return (char) p0;
        }
        int outRight2 = this.outputBufRight;
        if (outRight2 >= this.outputBuf.length) {
            growOutputBuf(outRight2 + 0);
        }
        char[] bufLeft = this.bufLeft;
        char ch = bufLeft[pos];
        switch (ch) {
            case '\n':
                this.srcBufPos = nextSrcPos;
                incLine$default(this, 0, 1, null);
                outRight = outRight2 + 1;
                this.outputBuf[outRight2] = '\n';
                result = '\n';
                break;
            case additional_type_content_video_VALUE:
                if (nextSrcPos < this.srcBufCount && bufLeft[nextSrcPos] == '\n') {
                    incLine(2);
                    i = nextSrcPos + 1;
                } else {
                    incLine$default(this, 0, 1, null);
                    i = nextSrcPos;
                }
                this.srcBufPos = i;
                outRight = outRight2 + 1;
                this.outputBuf[outRight2] = '\n';
                result = '\n';
                break;
            default:
                incCol();
                this.srcBufPos = nextSrcPos;
                outRight = outRight2 + 1;
                this.outputBuf[outRight2] = ch;
                result = ch;
                break;
        }
        this.outputBufRight = outRight;
        return result;
    }

    static /* synthetic */ void growOutputBuf$default(KtXmlReader ktXmlReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ktXmlReader.outputBufRight;
        }
        ktXmlReader.growOutputBuf(i);
    }

    private final void growOutputBuf(int minNeeded) {
        int newSize = Math.max(this.outputBuf.length * 2, (minNeeded * 5) / 4);
        char[] copyOf = Arrays.copyOf(this.outputBuf, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.outputBuf = copyOf;
    }

    private final void swapInputBuffer() {
        char[] oldLeft = this.bufLeft;
        this.bufLeft = this.bufRight;
        this.bufRight = oldLeft;
        this.srcBufPos -= 4096;
        int rightBufCount = this.srcBufCount - 4096;
        if (rightBufCount < 4096) {
            this.srcBufCount = rightBufCount;
            return;
        }
        int newRead = Companion.readUntilFullOrEOF(this.reader, this.bufRight);
        this.srcBufCount = newRead < 0 ? rightBufCount : rightBufCount + newRead;
    }

    private final int readAcross() {
        int pos = this.srcBufPos;
        if (pos >= 4096) {
            swapInputBuffer();
            pos -= 4096;
        }
        int next = pos + 1;
        char ch = this.bufLeft[pos];
        switch (ch) {
            case 0:
                this.srcBufPos = next;
                return readAcross();
            case '\n':
                this.srcBufPos = next;
                incLine$default(this, 0, 1, null);
                return 10;
            case additional_type_content_video_VALUE:
                this.bufLeft[this.srcBufPos] = '\n';
                if (next < this.srcBufCount && getBuf(next) == '\n') {
                    setBuf(next, (char) 0);
                    this.srcBufPos = next + 1;
                    incLine(2);
                } else {
                    this.srcBufPos = next;
                    incLine$default(this, 0, 1, null);
                }
                return 10;
            default:
                incCol();
                this.srcBufPos = next;
                return ch;
        }
    }

    private final int peek(int pos) {
        if (this.srcBufPos + (pos << 3) >= 4096) {
            return peekAcross(pos);
        }
        int current = this.srcBufPos;
        int peekCount = pos;
        while (current < this.srcBufCount) {
            char chr = this.bufLeft[current];
            if (chr == '\r') {
                chr = '\n';
                this.bufLeft[current] = '\n';
                if (this.bufLeft[current + 1] == '\r') {
                    this.bufLeft[current] = 0;
                    current++;
                }
            } else {
                current++;
            }
            int peekCount2 = peekCount - 1;
            if (peekCount == 0) {
                return chr;
            }
            peekCount = peekCount2;
        }
        return -1;
    }

    private final int peek() {
        int current = this.srcBufPos;
        if (current >= this.srcBufCount) {
            return -1;
        }
        if (current >= 4096) {
            return peekAcross(0);
        }
        char chr = this.bufLeft[current];
        if (chr == '\r') {
            return 10;
        }
        return chr;
    }

    private final int peekAcross(int pos) {
        int current = this.srcBufPos;
        int peekCount = pos;
        while (current < this.srcBufCount) {
            char chr = getBuf(current);
            if (chr == '\r') {
                chr = '\n';
                if (current + 1 < this.srcBufCount && getBuf(current + 1) == '\n') {
                    current += 2;
                } else {
                    current++;
                }
            } else {
                current++;
            }
            int peekCount2 = peekCount - 1;
            if (peekCount == 0) {
                return chr;
            }
            peekCount = peekCount2;
        }
        return -1;
    }

    private final char getBuf(int pos) {
        int split = pos - 4096;
        return split < 0 ? this.bufLeft[pos] : this.bufRight[split];
    }

    private final void setBuf(int pos, char value) {
        int split = pos - 4096;
        if (split >= 0) {
            this.bufRight[split] = value;
        } else {
            this.bufLeft[pos] = value;
        }
    }

    private final String readName() {
        int bufEnd;
        int left = this.srcBufPos;
        KtXmlReader $this$readName_u24lambda_u247 = this;
        int cnt = $this$readName_u24lambda_u247.srcBufCount;
        if (4096 < cnt) {
            if (left == 4096) {
                $this$readName_u24lambda_u247.swapInputBuffer();
                left = 0;
                bufEnd = Math.min(4096, $this$readName_u24lambda_u247.srcBufCount);
            } else {
                bufEnd = 4096;
            }
        } else if (left >= cnt) {
            $this$readName_u24lambda_u247.exception(UNEXPECTED_EOF);
            throw new KotlinNothingValueException();
        } else {
            bufEnd = cnt;
        }
        char[] srcBuf = this.bufLeft;
        if (!StringUtilKt.isNameStartChar(srcBuf[left])) {
            error("name expected, found: " + ((Object) srcBuf) + "[left]");
        }
        int right = left + 1;
        while (true) {
            if (right == bufEnd) {
                pushRange(srcBuf, left, right);
                if (bufEnd >= this.srcBufCount) {
                    error(UNEXPECTED_EOF);
                }
                this.srcBufPos = right;
                swapInputBuffer();
                bufEnd = Math.min(4096, this.srcBufCount);
                if (bufEnd == 0) {
                    break;
                }
                left = 0;
                right = 0;
                srcBuf = this.bufLeft;
            }
            if (!StringUtilKt.isNameChar11(srcBuf[right])) {
                pushRange(srcBuf, left, right);
                break;
            }
            right++;
        }
        this.srcBufPos = right;
        return get();
    }

    private final void readCName() {
        int bufEnd;
        int left = this.srcBufPos;
        KtXmlReader $this$readCName_u24lambda_u248 = this;
        int cnt = $this$readCName_u24lambda_u248.srcBufCount;
        if (4096 < cnt) {
            if (left == 4096) {
                $this$readCName_u24lambda_u248.swapInputBuffer();
                left = 0;
                bufEnd = Math.min(4096, $this$readCName_u24lambda_u248.srcBufCount);
            } else {
                bufEnd = 4096;
            }
        } else if (left >= cnt) {
            $this$readCName_u24lambda_u248.exception(UNEXPECTED_EOF);
            throw new KotlinNothingValueException();
        } else {
            bufEnd = cnt;
        }
        char[] srcBuf = this.bufLeft;
        char c = srcBuf[left];
        if (c == ':' || !StringUtilKt.isNameStartChar(c)) {
            error("name expected, found: " + c);
        }
        int right = left + 1;
        String prefix = null;
        while (true) {
            if (right == bufEnd) {
                pushRange(srcBuf, left, right);
                if (bufEnd >= this.srcBufCount) {
                    error(UNEXPECTED_EOF);
                }
                this.srcBufPos = right;
                swapInputBuffer();
                bufEnd = Math.min(4096, this.srcBufCount);
                if (bufEnd == 0) {
                    break;
                }
                left = 0;
                right = 0;
                srcBuf = this.bufLeft;
            }
            char c2 = srcBuf[right];
            if (c2 == ':') {
                pushRange(srcBuf, left, right);
                right++;
                left = right;
                prefix = get();
                resetOutputBuffer();
            } else if (!StringUtilKt.isNameChar11(c2)) {
                pushRange(srcBuf, left, right);
                break;
            } else {
                right++;
            }
        }
        this.srcBufPos = right;
        this.readPrefix = prefix;
        this.readLocalname = get();
    }

    private final void skip() {
        while (true) {
            int c = peek();
            if (c != -1 && XmlUtil.isXmlWhitespace((char) c)) {
                readAssert((char) c);
            } else {
                return;
            }
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        return this.namespaceHolder.getPrefix(namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.namespaceHolder.getNamespaceUri(prefix);
    }

    private final String getPositionDescription() {
        EventType et = this._eventType;
        if (et == null) {
            return "<!--Parsing not started yet-->";
        }
        StringBuilder buf = new StringBuilder(et.name());
        buf.append(' ');
        if (et == EventType.START_ELEMENT || et == EventType.END_ELEMENT) {
            if (this.isSelfClosing) {
                buf.append("(empty) ");
            }
            buf.append(Typography.less);
            if (et == EventType.END_ELEMENT) {
                buf.append('/');
            }
            if (m1594getPrefixWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1)) != null) {
                buf.append(AbstractJsonLexerKt.BEGIN_OBJ + getNamespaceURI() + AbstractJsonLexerKt.END_OBJ + getPrefix() + AbstractJsonLexerKt.COLON);
            }
            buf.append(getName());
            int attributeCount = getAttributeCount();
            for (int x = 0; x < attributeCount; x++) {
                buf.append(' ');
                int a = m1588attributehc9wHSM(x);
                if (m1593getNamespaceX2amM8A(a) != null) {
                    buf.append(AbstractJsonLexerKt.BEGIN_OBJ).append(m1593getNamespaceX2amM8A(a)).append(AbstractJsonLexerKt.END_OBJ).append(m1595getPrefixX2amM8A(a)).append(AbstractJsonLexerKt.COLON);
                }
                buf.append(m1591getLocalNameX2amM8A(a) + "='" + m1596getValueX2amM8A(a) + '\'');
            }
            buf.append(Typography.greater);
        } else if (et == EventType.IGNORABLE_WHITESPACE) {
            Unit unit = Unit.INSTANCE;
        } else if (et != EventType.TEXT) {
            buf.append(getText());
        } else if (this.isWhitespace) {
            buf.append("(whitespace)");
        } else {
            String textCpy = getText();
            if (textCpy.length() > 16) {
                StringBuilder sb = new StringBuilder();
                String substring = textCpy.substring(0, 16);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                textCpy = sb.append(substring).append("...").toString();
            }
            buf.append(textCpy);
        }
        if (this.offset >= 0) {
            buf.append('@' + this.line + AbstractJsonLexerKt.COLON + getColumn() + " [" + this.offset + "] in ");
        }
        buf.append(this.reader.toString());
        String sb2 = buf.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public String toString() {
        return "KtXmlReader [" + getPositionDescription() + AbstractJsonLexerKt.END_LIST;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocationInfo() {
        return this.offset >= 0 ? new StringBuilder().append(this.line).append(AbstractJsonLexerKt.COLON).append(getColumn()).toString() : "<unknown>";
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public XmlReader.LocationInfo getExtLocationInfo() {
        return new XmlReader.ExtLocationInfo(getColumn(), this.line, this.offset);
    }

    public final int getLineNumber() {
        return this.line;
    }

    public final int getColumnNumber() {
        return getColumn();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isWhitespace() {
        switch (WhenMappings.$EnumSwitchMapping$0[getEventType().ordinal()]) {
            case 6:
            case 8:
                return this.isWhitespace;
            case 7:
            default:
                exception(ILLEGAL_TYPE);
                throw new KotlinNothingValueException();
            case 9:
                return false;
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getText() {
        if (getEventType().isTextElement()) {
            return get();
        }
        throw new XmlException("The element is not text, it is: " + getEventType(), null, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiTarget() {
        if (!(getEventType() == EventType.PROCESSING_INSTRUCTION)) {
            throw new IllegalStateException("Check failed.");
        }
        return StringsKt.substringBefore$default(get(), ' ', (String) null, 2, (Object) null);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiData() {
        if (!(getEventType() == EventType.PROCESSING_INSTRUCTION)) {
            throw new IllegalStateException("Check failed.");
        }
        return StringsKt.substringAfter(get(), ' ', "");
    }

    public final boolean isEmptyElementTag() {
        if (this._eventType != EventType.START_ELEMENT) {
            exception(ILLEGAL_TYPE);
            throw new KotlinNothingValueException();
        }
        return this.isSelfClosing;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeNamespace(int index) {
        String m1593getNamespaceX2amM8A = m1593getNamespaceX2amM8A(m1588attributehc9wHSM(index));
        Intrinsics.checkNotNull(m1593getNamespaceX2amM8A);
        return m1593getNamespaceX2amM8A;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeLocalName(int index) {
        String m1591getLocalNameX2amM8A = m1591getLocalNameX2amM8A(m1588attributehc9wHSM(index));
        Intrinsics.checkNotNull(m1591getLocalNameX2amM8A);
        return m1591getLocalNameX2amM8A;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributePrefix(int index) {
        String m1595getPrefixX2amM8A = m1595getPrefixX2amM8A(m1588attributehc9wHSM(index));
        return m1595getPrefixX2amM8A == null ? "" : m1595getPrefixX2amM8A;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(int index) {
        String m1596getValueX2amM8A = m1596getValueX2amM8A(m1588attributehc9wHSM(index));
        Intrinsics.checkNotNull(m1596getValueX2amM8A);
        return m1596getValueX2amM8A;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(String nsUri, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        int attributeCount = getAttributeCount();
        for (int attrIdx = 0; attrIdx < attributeCount; attrIdx++) {
            int attr = m1588attributehc9wHSM(attrIdx);
            if (Intrinsics.areEqual(m1591getLocalNameX2amM8A(attr), localName) && (nsUri == null || Intrinsics.areEqual(m1593getNamespaceX2amM8A(attr), nsUri))) {
                return m1596getValueX2amM8A(attr);
            }
        }
        return null;
    }

    @Override // java.util.Iterator
    public EventType next() {
        this.isWhitespace = true;
        resetOutputBuffer();
        switch (WhenMappings.$EnumSwitchMapping$1[this.state.ordinal()]) {
            case 1:
                nextImplDocStart();
                break;
            case 2:
            case 3:
                nextImplPreamble();
                break;
            case 4:
                nextImplBody();
                break;
            case 5:
                nextImplPost();
                break;
            case 6:
                error("Reading past end of file");
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return getEventType();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.util.Iterator
    public boolean hasNext() {
        return this._eventType != EventType.END_DOCUMENT;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType nextTag() {
        while (true) {
            next();
            EventType eventType = this._eventType;
            boolean z = false;
            if (eventType != null && eventType.isIgnorable()) {
                z = true;
            }
            if (z || (this._eventType == EventType.TEXT && this.isWhitespace)) {
            }
        }
        if (this._eventType == EventType.END_ELEMENT || this._eventType == EventType.START_ELEMENT) {
            return getEventType();
        }
        exception("unexpected type");
        throw new KotlinNothingValueException();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public void require(EventType type, String namespace, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type != this._eventType || ((namespace != null && !Intrinsics.areEqual(namespace, m1592getNamespaceWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1)))) || (name != null && !Intrinsics.areEqual(name, m1590getLocalNameWdoxvj4(this.elementStack.m1618gettPtF754(getDepth() - 1)))))) {
            exception("expected: " + type + " {" + namespace + AbstractJsonLexerKt.END_OBJ + name + ", found: " + this._eventType + " {" + getNamespaceURI() + AbstractJsonLexerKt.END_OBJ + getLocalName());
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0003J\u001d\u0010\f\u001a\u00020\r*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$Companion;", "", "<init>", "()V", "UNEXPECTED_EOF", "", "ILLEGAL_TYPE", "PROCESS_NAMESPACES", "", "fullname", "prefix", "localName", "readUntilFullOrEOF", "", "Ljava/io/Reader;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Reader;", "buffer", "", "(Ljava/io/Reader;[C)I", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String fullname(String prefix, String localName) {
            return prefix == null ? localName : prefix + AbstractJsonLexerKt.COLON + localName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int readUntilFullOrEOF(Reader $this$readUntilFullOrEOF, char[] buffer) {
            int bufSize = buffer.length;
            int totalRead = $this$readUntilFullOrEOF.read(buffer, 0, bufSize);
            if (totalRead < 0) {
                return -1;
            }
            while (totalRead < bufSize) {
                int lastRead = $this$readUntilFullOrEOF.read(buffer, totalRead, bufSize - totalRead);
                if (lastRead < 0) {
                    return totalRead;
                }
                totalRead += lastRead;
            }
            return totalRead;
        }
    }

    @JvmStatic
    private static final String fullname(String prefix, String localName) {
        return Companion.fullname(prefix, localName);
    }

    @JvmStatic
    private static final int readUntilFullOrEOF(Reader $this$readUntilFullOrEOF, char[] buffer) {
        return Companion.readUntilFullOrEOF($this$readUntilFullOrEOF, buffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$ElementStack;", "", "<init>", "(Lnl/adaptivity/xmlutil/core/KtXmlReader;)V", "get", "Lnl/adaptivity/xmlutil/core/KtXmlReader$ElementDelegate;", "idx", "", "get-tPtF754", "(I)I", "ensureCapacity", "", "required", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class ElementStack {
        public ElementStack() {
        }

        /* renamed from: get-tPtF754  reason: not valid java name */
        public final int m1618gettPtF754(int idx) {
            return KtXmlReader.this.m1589elementtPtF754(idx);
        }

        public final void ensureCapacity(int required) {
            int requiredCapacity = required * 3;
            if (KtXmlReader.this.elementData.length >= requiredCapacity) {
                return;
            }
            KtXmlReader ktXmlReader = KtXmlReader.this;
            Object[] copyOf = Arrays.copyOf(KtXmlReader.this.elementData, requiredCapacity + 12);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            ktXmlReader.elementData = (String[]) copyOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: element-tPtF754  reason: not valid java name */
    public final int m1589elementtPtF754(int idx) {
        return ElementDelegate.m1612constructorimpl(idx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000e"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$ElementDelegate;", "", "index", "", "constructor-impl", "(I)I", "getIndex", "()I", "equals", "", "other", "hashCode", "toString", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ElementDelegate {
        private final int index;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ ElementDelegate m1611boximpl(int i) {
            return new ElementDelegate(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1612constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1613equalsimpl(int i, Object obj) {
            return (obj instanceof ElementDelegate) && i == ((ElementDelegate) obj).m1617unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1614equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1615hashCodeimpl(int i) {
            return i;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1616toStringimpl(int i) {
            return "ElementDelegate(index=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m1613equalsimpl(this.index, obj);
        }

        public int hashCode() {
            return m1615hashCodeimpl(this.index);
        }

        public String toString() {
            return m1616toStringimpl(this.index);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1617unboximpl() {
            return this.index;
        }

        private /* synthetic */ ElementDelegate(int index) {
            this.index = index;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* renamed from: getNamespace-Wdoxvj4  reason: not valid java name */
    private final String m1592getNamespaceWdoxvj4(int $this$namespace) {
        if ($this$namespace >= getDepth()) {
            throw new IndexOutOfBoundsException();
        }
        return this.elementData[$this$namespace * 3];
    }

    /* renamed from: setNamespace-zO6yCoI  reason: not valid java name */
    private final void m1600setNamespacezO6yCoI(int $this$namespace, String value) {
        this.elementData[$this$namespace * 3] = value;
    }

    /* renamed from: getPrefix-Wdoxvj4  reason: not valid java name */
    private final String m1594getPrefixWdoxvj4(int $this$prefix) {
        if ($this$prefix >= getDepth()) {
            throw new IndexOutOfBoundsException();
        }
        return this.elementData[($this$prefix * 3) + 1];
    }

    /* renamed from: setPrefix-zO6yCoI  reason: not valid java name */
    private final void m1602setPrefixzO6yCoI(int $this$prefix, String value) {
        this.elementData[($this$prefix * 3) + 1] = value;
    }

    /* renamed from: getLocalName-Wdoxvj4  reason: not valid java name */
    private final String m1590getLocalNameWdoxvj4(int $this$localName) {
        if ($this$localName >= getDepth()) {
            throw new IndexOutOfBoundsException();
        }
        return this.elementData[($this$localName * 3) + 2];
    }

    /* renamed from: setLocalName-zO6yCoI  reason: not valid java name */
    private final void m1598setLocalNamezO6yCoI(int $this$localName, String value) {
        this.elementData[($this$localName * 3) + 2] = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bJ \u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$AttributesCollection;", "", "<init>", "(Lnl/adaptivity/xmlutil/core/KtXmlReader;)V", "clear", "", "shrink", "newSize", "", "ensureCapacity", "required", "addNsUnresolved", "attrPrefix", "", "attrLocalName", "attrValue", "copyNotNs", "fromIdx", "toIdx", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class AttributesCollection {
        public AttributesCollection() {
        }

        public final void clear() {
            int oldSize = KtXmlReader.this.getAttributeCount();
            if (oldSize > 0) {
                ArraysKt.fill(KtXmlReader.this.attrData, (Object) null, 0, oldSize * 4);
            }
            KtXmlReader.this.attributeCount = 0;
        }

        public final void shrink(int newSize) {
            ArraysKt.fill(KtXmlReader.this.attrData, (Object) null, newSize * 4, KtXmlReader.this.getAttributeCount() * 4);
            KtXmlReader.this.attributeCount = newSize;
        }

        public final void ensureCapacity(int required) {
            int requiredSize = required * 4;
            String[] oldData = KtXmlReader.this.attrData;
            if (oldData.length >= requiredSize) {
                return;
            }
            KtXmlReader ktXmlReader = KtXmlReader.this;
            Object[] copyOf = Arrays.copyOf(oldData, requiredSize + 16);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            ktXmlReader.attrData = (String[]) copyOf;
        }

        public final void addNsUnresolved(String attrPrefix, String attrLocalName, String attrValue) {
            Intrinsics.checkNotNullParameter(attrLocalName, "attrLocalName");
            Intrinsics.checkNotNullParameter(attrValue, "attrValue");
            int oldSize = KtXmlReader.this.getAttributeCount();
            int newSize = oldSize < 0 ? 1 : oldSize + 1;
            KtXmlReader.this.attributeCount = newSize;
            ensureCapacity(newSize);
            int i = (newSize * 4) - 4;
            String[] d = KtXmlReader.this.attrData;
            int i2 = i + 1;
            d[i] = null;
            int i3 = i2 + 1;
            d[i2] = attrPrefix;
            d[i3] = attrLocalName;
            d[i3 + 1] = attrValue;
        }

        public final void copyNotNs(int fromIdx, int toIdx) {
            ArraysKt.copyInto(KtXmlReader.this.attrData, KtXmlReader.this.attrData, (toIdx * 4) + 1, (fromIdx * 4) + 1, (fromIdx * 4) + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000e"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$AttributeDelegate;", "", "index", "", "constructor-impl", "(I)I", "getIndex", "()I", "equals", "", "other", "hashCode", "toString", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AttributeDelegate {
        private final int index;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ AttributeDelegate m1604boximpl(int i) {
            return new AttributeDelegate(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1605constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1606equalsimpl(int i, Object obj) {
            return (obj instanceof AttributeDelegate) && i == ((AttributeDelegate) obj).m1610unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1607equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1608hashCodeimpl(int i) {
            return i;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1609toStringimpl(int i) {
            return "AttributeDelegate(index=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m1606equalsimpl(this.index, obj);
        }

        public int hashCode() {
            return m1608hashCodeimpl(this.index);
        }

        public String toString() {
            return m1609toStringimpl(this.index);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1610unboximpl() {
            return this.index;
        }

        private /* synthetic */ AttributeDelegate(int index) {
            this.index = index;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* renamed from: attribute-hc9wHSM  reason: not valid java name */
    private final int m1588attributehc9wHSM(int index) {
        return AttributeDelegate.m1605constructorimpl(index);
    }

    /* renamed from: getNamespace-X2amM8A  reason: not valid java name */
    private final String m1593getNamespaceX2amM8A(int $this$namespace) {
        if ($this$namespace >= getAttributeCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.attrData[$this$namespace * 4];
    }

    /* renamed from: setNamespace-tlzzZ4Q  reason: not valid java name */
    private final void m1599setNamespacetlzzZ4Q(int $this$namespace, String value) {
        this.attrData[$this$namespace * 4] = value;
    }

    /* renamed from: getPrefix-X2amM8A  reason: not valid java name */
    private final String m1595getPrefixX2amM8A(int $this$prefix) {
        if ($this$prefix >= getAttributeCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.attrData[($this$prefix * 4) + 1];
    }

    /* renamed from: setPrefix-tlzzZ4Q  reason: not valid java name */
    private final void m1601setPrefixtlzzZ4Q(int $this$prefix, String value) {
        this.attrData[($this$prefix * 4) + 1] = value;
    }

    /* renamed from: getLocalName-X2amM8A  reason: not valid java name */
    private final String m1591getLocalNameX2amM8A(int $this$localName) {
        if ($this$localName >= getAttributeCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.attrData[($this$localName * 4) + 2];
    }

    /* renamed from: setLocalName-tlzzZ4Q  reason: not valid java name */
    private final void m1597setLocalNametlzzZ4Q(int $this$localName, String value) {
        this.attrData[($this$localName * 4) + 2] = value;
    }

    /* renamed from: getValue-X2amM8A  reason: not valid java name */
    private final String m1596getValueX2amM8A(int $this$value) {
        if ($this$value >= getAttributeCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.attrData[($this$value * 4) + 3];
    }

    /* renamed from: setValue-tlzzZ4Q  reason: not valid java name */
    private final void m1603setValuetlzzZ4Q(int $this$value, String value) {
        this.attrData[($this$value * 4) + 3] = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KtXmlReader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lnl/adaptivity/xmlutil/core/KtXmlReader$State;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_START", "START_DOC", "DOCTYPE_DECL", "BODY", "POST", "EOF", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum State {
        BEFORE_START,
        START_DOC,
        DOCTYPE_DECL,
        BODY,
        POST,
        EOF;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }
}