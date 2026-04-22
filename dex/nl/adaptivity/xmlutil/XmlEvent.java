package nl.adaptivity.xmlutil;

import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;

/* compiled from: XmlEvent.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001a2\u00020\u0001:\u000b\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0014\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015\u0082\u0001\u0005%&'()¨\u0006*"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent;", "", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "locationInfo", "", "(Ljava/lang/String;)V", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getLocationInfo$annotations", "()V", "getLocationInfo", "()Ljava/lang/String;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "isIgnorable", "", "()Z", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "Companion", "TextEvent", "ProcessingInstructionEvent", "EntityRefEvent", "EndDocumentEvent", "EndElementEvent", "StartDocumentEvent", "NamedEvent", "StartElementEvent", "Attribute", "NamespaceImpl", "Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "Lnl/adaptivity/xmlutil/XmlEvent$EndDocumentEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$NamedEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$StartDocumentEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class XmlEvent {
    public static final Companion Companion = new Companion(null);
    private final XmlReader.LocationInfo extLocationInfo;
    private final String locationInfo;

    public /* synthetic */ XmlEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ XmlEvent(XmlReader.LocationInfo locationInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(locationInfo);
    }

    @Deprecated(message = "More detail is available from extLocationInfo", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
    public static /* synthetic */ void getLocationInfo$annotations() {
    }

    public abstract EventType getEventType();

    public abstract void writeTo(XmlWriter xmlWriter);

    private XmlEvent(XmlReader.LocationInfo extLocationInfo) {
        this.extLocationInfo = extLocationInfo;
        XmlReader.LocationInfo locationInfo = this.extLocationInfo;
        this.locationInfo = locationInfo != null ? locationInfo.toString() : null;
    }

    public final XmlReader.LocationInfo getExtLocationInfo() {
        return this.extLocationInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private XmlEvent(String locationInfo) {
        this(r3, (DefaultConstructorMarker) null);
        XmlReader.StringLocationInfo stringLocationInfo;
        if (locationInfo == null) {
            stringLocationInfo = null;
        } else {
            stringLocationInfo = new XmlReader.StringLocationInfo(locationInfo);
        }
    }

    public final String getLocationInfo() {
        return this.locationInfo;
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$Companion;", "", "<init>", "()V", "from", "Lnl/adaptivity/xmlutil/XmlEvent;", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XmlEvent from(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return reader.getEventType().createEvent(reader);
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0018"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "Lnl/adaptivity/xmlutil/XmlEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "text", "", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Lnl/adaptivity/xmlutil/EventType;Ljava/lang/String;)V", "locationInfo", "(Ljava/lang/String;Lnl/adaptivity/xmlutil/EventType;Ljava/lang/String;)V", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "getText", "()Ljava/lang/String;", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "isIgnorable", "", "()Z", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class TextEvent extends XmlEvent {
        private final EventType eventType;
        private final String text;

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return this.eventType;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextEvent(XmlReader.LocationInfo extLocationInfo, EventType eventType, String text) {
            super(extLocationInfo, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(text, "text");
            this.eventType = eventType;
            this.text = text;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TextEvent(String locationInfo, EventType eventType, String text) {
            this(new XmlReader.StringLocationInfo(locationInfo), eventType, text);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(text, "text");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            getEventType().writeEvent(writer, this);
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public boolean isIgnorable() {
            return super.isIgnorable() || (getEventType() == EventType.TEXT && XmlUtil.isXmlWhitespace(this.text));
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" - \"").append(this.text).append("\" (");
            Object extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').toString();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$ProcessingInstructionEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "target", "", "data", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Ljava/lang/String;", "getData", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ProcessingInstructionEvent extends TextEvent {
        private final String data;
        private final String target;

        public final String getTarget() {
            return this.target;
        }

        public final String getData() {
            return this.data;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProcessingInstructionEvent(XmlReader.LocationInfo extLocationInfo, String target, String data) {
            super(extLocationInfo, EventType.PROCESSING_INSTRUCTION, target + ' ' + data);
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(data, "data");
            this.target = target;
            this.data = data;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ProcessingInstructionEvent(String locationInfo, String target, String data) {
            this(new XmlReader.StringLocationInfo(locationInfo), target, data);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0015"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$EntityRefEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "localName", "", "text", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalName", "()Ljava/lang/String;", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "isIgnorable", "", "()Z", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class EntityRefEvent extends TextEvent {
        private final String localName;

        public final String getLocalName() {
            return this.localName;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntityRefEvent(XmlReader.LocationInfo extLocationInfo, String localName, String text) {
            super(extLocationInfo, EventType.ENTITY_REF, text);
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(text, "text");
            this.localName = localName;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EntityRefEvent(String locationInfo, String localName, String text) {
            this(new XmlReader.StringLocationInfo(locationInfo), localName, text);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(text, "text");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent.TextEvent, nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            getEventType().writeEvent(writer, this);
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent.TextEvent, nl.adaptivity.xmlutil.XmlEvent
        public boolean isIgnorable() {
            return false;
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent.TextEvent
        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" - \"").append(getText()).append("\" (");
            Object extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').toString();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$EndDocumentEvent;", "Lnl/adaptivity/xmlutil/XmlEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "locationInfo", "", "(Ljava/lang/String;)V", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class EndDocumentEvent extends XmlEvent {
        public EndDocumentEvent(XmlReader.LocationInfo extLocationInfo) {
            super(extLocationInfo, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EndDocumentEvent(String locationInfo) {
            this(new XmlReader.StringLocationInfo(locationInfo));
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            writer.endDocument();
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return EventType.END_DOCUMENT;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" (");
            Object extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').toString();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\n\u0010\f\u001a\u00060\rj\u0002`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u0010B1\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$EndElementEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$NamedEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceUri", "", "localName", "prefix", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "parentNamespaceContext", "(Ljavax/xml/namespace/QName;Lnl/adaptivity/xmlutil/IterableNamespaceContext;Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class EndElementEvent extends NamedEvent {
        private final IterableNamespaceContext namespaceContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EndElementEvent(XmlReader.LocationInfo extLocationInfo, String namespaceUri, String localName, String prefix, IterableNamespaceContext namespaceContext) {
            super(extLocationInfo, namespaceUri, localName, prefix);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(namespaceContext, "namespaceContext");
            this.namespaceContext = namespaceContext.freeze();
        }

        public /* synthetic */ EndElementEvent(QName qName, IterableNamespaceContext iterableNamespaceContext, XmlReader.LocationInfo locationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(qName, iterableNamespaceContext, (i & 4) != 0 ? null : locationInfo);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EndElementEvent(QName name, IterableNamespaceContext parentNamespaceContext, XmlReader.LocationInfo extLocationInfo) {
            this(extLocationInfo, name.getNamespaceURI(), name.getLocalPart(), name.getPrefix(), parentNamespaceContext);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(parentNamespaceContext, "parentNamespaceContext");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EndElementEvent(String locationInfo, String namespaceUri, String localName, String prefix, IterableNamespaceContext namespaceContext) {
            this(new XmlReader.StringLocationInfo(locationInfo), namespaceUri, localName, prefix, namespaceContext);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(namespaceContext, "namespaceContext");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            writer.endTag(getNamespaceUri(), getLocalName(), getPrefix());
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return EventType.END_ELEMENT;
        }

        public final IterableNamespaceContext getNamespaceContext() {
            return this.namespaceContext;
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB/\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$StartDocumentEvent;", "Lnl/adaptivity/xmlutil/XmlEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "encoding", "", "version", "standalone", "", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEncoding", "()Ljava/lang/String;", "getVersion", "getStandalone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class StartDocumentEvent extends XmlEvent {
        private final String encoding;
        private final Boolean standalone;
        private final String version;

        public final String getEncoding() {
            return this.encoding;
        }

        public final String getVersion() {
            return this.version;
        }

        public final Boolean getStandalone() {
            return this.standalone;
        }

        public StartDocumentEvent(XmlReader.LocationInfo extLocationInfo, String encoding, String version, Boolean standalone) {
            super(extLocationInfo, (DefaultConstructorMarker) null);
            this.encoding = encoding;
            this.version = version;
            this.standalone = standalone;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StartDocumentEvent(String locationInfo, String encoding, String version, Boolean standalone) {
            this(new XmlReader.StringLocationInfo(locationInfo), encoding, version, standalone);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            writer.startDocument(this.version, this.encoding, this.standalone);
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return EventType.START_DOCUMENT;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" - encoding:").append(this.encoding).append(", version: ").append(this.version).append(", standalone: ").append(this.standalone).append(" (");
            Object extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').toString();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0013\u001a\u00060\u0014j\u0002`\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$NamedEvent;", "Lnl/adaptivity/xmlutil/XmlEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceUri", "", "localName", "prefix", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespaceUri", "()Ljava/lang/String;", "getLocalName", "getPrefix", "isEqualNames", "", "ev", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "getName", "()Ljavax/xml/namespace/QName;", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class NamedEvent extends XmlEvent {
        private final String localName;
        private final String namespaceUri;
        private final String prefix;

        public final String getNamespaceUri() {
            return this.namespaceUri;
        }

        public final String getLocalName() {
            return this.localName;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NamedEvent(XmlReader.LocationInfo extLocationInfo, String namespaceUri, String localName, String prefix) {
            super(extLocationInfo, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            this.namespaceUri = namespaceUri;
            this.localName = localName;
            this.prefix = prefix;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NamedEvent(String locationInfo, String namespaceUri, String localName, String prefix) {
            this(new XmlReader.StringLocationInfo(locationInfo), namespaceUri, localName, prefix);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
        }

        public final boolean isEqualNames(NamedEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            return Intrinsics.areEqual(this.namespaceUri, ev.namespaceUri) && Intrinsics.areEqual(this.localName, ev.localName) && Intrinsics.areEqual(this.prefix, ev.prefix);
        }

        public final QName getName() {
            return new QName(this.namespaceUri, this.localName, this.prefix);
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" - {").append(this.namespaceUri).append(AbstractJsonLexerKt.END_OBJ).append(this.prefix).append(AbstractJsonLexerKt.COLON).append(this.localName).append(" (");
            Object extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').toString();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011BO\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0013B)\b\u0016\u0012\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0017B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0018B!\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0019BI\b\u0017\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u001aJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0017\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u0005H\u0000¢\u0006\u0002\b-J\u0017\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/J\u0012\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u000201H\u0007J\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020\u0005062\u0006\u0010,\u001a\u00020\u0005H\u0000¢\u0006\u0002\b7J\b\u00108\u001a\u00020\u0005H\u0016R\u001b\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u00102\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00069"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$StartElementEvent;", "Lnl/adaptivity/xmlutil/XmlEvent$NamedEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceUri", "", "localName", "prefix", "attributes", "", "Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "parentNamespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "namespaceDecls", "", "Lnl/adaptivity/xmlutil/Namespace;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;Lnl/adaptivity/xmlutil/IterableNamespaceContext;Ljava/util/List;)V", "locationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;Lnl/adaptivity/xmlutil/IterableNamespaceContext;Ljava/util/List;)V", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Ljavax/xml/namespace/QName;Lnl/adaptivity/xmlutil/IterableNamespaceContext;Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;Ljava/util/List;)V", "getAttributes", "()[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "namespaceHolder", "Lnl/adaptivity/xmlutil/SimpleNamespaceContext;", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "", "getNamespaceDecls", "()Ljava/lang/Iterable;", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "getPrefix", "namespaceURI", "getPrefix$core", "getNamespaceURI", "getNamespaceURI$core", "getNamespaceUri", "", "namespaceContext", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getPrefixes", "", "getPrefixes$core", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class StartElementEvent extends NamedEvent {
        private final Attribute[] attributes;
        private final SimpleNamespaceContext namespaceHolder;
        private final IterableNamespaceContext parentNamespaceContext;

        public final Attribute[] getAttributes() {
            return this.attributes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartElementEvent(XmlReader.LocationInfo extLocationInfo, String namespaceUri, String localName, String prefix, Attribute[] attributes, IterableNamespaceContext parentNamespaceContext, List<? extends Namespace> namespaceDecls) {
            super(extLocationInfo, namespaceUri, localName, prefix);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(parentNamespaceContext, "parentNamespaceContext");
            Intrinsics.checkNotNullParameter(namespaceDecls, "namespaceDecls");
            this.attributes = attributes;
            this.parentNamespaceContext = parentNamespaceContext;
            this.namespaceHolder = new SimpleNamespaceContext(namespaceDecls);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StartElementEvent(String locationInfo, String namespaceUri, String localName, String prefix, Attribute[] attributes, IterableNamespaceContext parentNamespaceContext, List<? extends Namespace> namespaceDecls) {
            this(new XmlReader.StringLocationInfo(locationInfo), namespaceUri, localName, prefix, attributes, parentNamespaceContext, namespaceDecls);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(parentNamespaceContext, "parentNamespaceContext");
            Intrinsics.checkNotNullParameter(namespaceDecls, "namespaceDecls");
        }

        public /* synthetic */ StartElementEvent(QName qName, IterableNamespaceContext iterableNamespaceContext, XmlReader.LocationInfo locationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(qName, iterableNamespaceContext, (i & 4) != 0 ? null : locationInfo);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StartElementEvent(QName name, IterableNamespaceContext parentNamespaceContext, XmlReader.LocationInfo extLocationInfo) {
            this(extLocationInfo, name.getNamespaceURI(), name.getLocalPart(), name.getPrefix(), new Attribute[0], parentNamespaceContext, CollectionsKt.emptyList());
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(parentNamespaceContext, "parentNamespaceContext");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StartElementEvent(String namespaceUri, String localName, String prefix, IterableNamespaceContext parentNamespaceContext) {
            this((XmlReader.LocationInfo) null, namespaceUri, localName, prefix, new Attribute[0], parentNamespaceContext, CollectionsKt.emptyList());
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(parentNamespaceContext, "parentNamespaceContext");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use version that takes the parent tag's namespace context.")
        public StartElementEvent(String namespaceUri, String localName, String prefix) {
            this(namespaceUri, localName, prefix, new SimpleNamespaceContext());
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use version that takes the parent tag's namespace context.")
        public StartElementEvent(String locationInfo, String namespaceUri, String localName, String prefix, Attribute[] attributes, List<? extends Namespace> namespaceDecls) {
            this(locationInfo != null ? new XmlReader.StringLocationInfo(locationInfo) : null, namespaceUri, localName, prefix, attributes, new SimpleNamespaceContext(), namespaceDecls);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(namespaceDecls, "namespaceDecls");
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Attribute[] attributeArr;
            Intrinsics.checkNotNullParameter(writer, "writer");
            writer.startTag(getNamespaceUri(), getLocalName(), getPrefix());
            for (Attribute attribute : this.attributes) {
                writer.attribute(attribute.getNamespaceUri(), attribute.getLocalName(), attribute.getPrefix(), attribute.getValue());
            }
            Iterable $this$forEach$iv = this.namespaceHolder;
            for (Object element$iv : $this$forEach$iv) {
                Namespace ns = (Namespace) element$iv;
                writer.namespaceAttr(ns.getPrefix(), ns.getNamespaceURI());
            }
        }

        public final Iterable<Namespace> getNamespaceDecls() {
            return this.namespaceHolder;
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return EventType.START_ELEMENT;
        }

        public final String getPrefix$core(String namespaceURI) {
            Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
            String prefix = this.namespaceHolder.getPrefix(namespaceURI);
            if (prefix != null) {
                return prefix;
            }
            return this.parentNamespaceContext.getPrefix(getNamespaceUri());
        }

        public final String getNamespaceURI$core(String prefix) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            String decl = this.namespaceHolder.getNamespaceURI(prefix);
            if (decl != null) {
                return decl;
            }
            return this.parentNamespaceContext.getNamespaceURI(prefix);
        }

        @Deprecated(message = "Just use the version that takes a string", replaceWith = @ReplaceWith(expression = "getNamespaceURI(prefix.toString())", imports = {}))
        public final String getNamespaceUri(CharSequence prefix) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            return getNamespaceURI$core(prefix.toString());
        }

        public final IterableNamespaceContext getNamespaceContext() {
            return this.namespaceHolder.plus(this.parentNamespaceContext);
        }

        public final Iterator<String> getPrefixes$core(String namespaceURI) {
            Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
            return SequencesKt.plus(SequencesKt.asSequence(this.namespaceHolder.getPrefixes(namespaceURI)), SequencesKt.asSequence(this.parentNamespaceContext.getPrefixes(namespaceURI))).iterator();
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent.NamedEvent
        public String toString() {
            StringBuilder append = new StringBuilder().append(getEventType()).append(" - {").append(getNamespaceUri()).append(AbstractJsonLexerKt.END_OBJ).append(getPrefix()).append(AbstractJsonLexerKt.COLON).append(getLocalName()).append(" (");
            XmlReader.LocationInfo extLocationInfo = getExtLocationInfo();
            if (extLocationInfo == null) {
                extLocationInfo = "";
            }
            return append.append(extLocationInfo).append(')').append(ArraysKt.joinToString$default(this.attributes, "\n    ", this.attributes.length == 0 ? "" : "\n    ", (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: nl.adaptivity.xmlutil.XmlEvent$StartElementEvent$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence string$lambda$3;
                    string$lambda$3 = XmlEvent.StartElementEvent.toString$lambda$3((XmlEvent.Attribute) obj);
                    return string$lambda$3;
                }
            }, 28, (Object) null)).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toString$lambda$3(Attribute it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getLocalName() + " = " + it.getValue() + ' ';
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB1\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\rB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\fH\u0016J\u0013\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "Lnl/adaptivity/xmlutil/XmlEvent;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceUri", "", "localName", "prefix", "value", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "locationInfo", "", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getValue", "()Ljava/lang/String;", "getPrefix", "getLocalName", "getNamespaceUri", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "getName", "()Ljavax/xml/namespace/QName;", "writeTo", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "hasNamespaceUri", "", "toString", "equals", "other", "", "hashCode", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Attribute extends XmlEvent {
        private final String localName;
        private final String namespaceUri;
        private final String prefix;
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Attribute(XmlReader.LocationInfo extLocationInfo, CharSequence namespaceUri, CharSequence localName, CharSequence prefix, CharSequence value) {
            super(extLocationInfo, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value.toString();
            this.prefix = prefix.toString();
            this.localName = localName.toString();
            this.namespaceUri = namespaceUri.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Attribute(String locationInfo, CharSequence namespaceUri, CharSequence localName, CharSequence prefix, CharSequence value) {
            this(new XmlReader.StringLocationInfo(locationInfo), namespaceUri, localName, prefix, value);
            Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(value, "value");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Attribute(CharSequence namespaceUri, CharSequence localName, CharSequence prefix, CharSequence value) {
            this((XmlReader.LocationInfo) null, namespaceUri, localName, prefix, value);
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            Intrinsics.checkNotNullParameter(localName, "localName");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(value, "value");
        }

        public final String getValue() {
            return this.value;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getLocalName() {
            return this.localName;
        }

        public final String getNamespaceUri() {
            return this.namespaceUri;
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public EventType getEventType() {
            return EventType.ATTRIBUTE;
        }

        public final QName getName() {
            return new QName(this.namespaceUri, this.localName, this.prefix);
        }

        @Override // nl.adaptivity.xmlutil.XmlEvent
        public void writeTo(XmlWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            if (hasNamespaceUri()) {
                String nsPrefix = this.prefix.length() == 0 ? "" : this.localName;
                writer.namespaceAttr(nsPrefix, this.namespaceUri);
                return;
            }
            writer.attribute(this.namespaceUri, this.localName, this.prefix, this.value);
        }

        public final boolean hasNamespaceUri() {
            if (Intrinsics.areEqual(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, this.namespaceUri)) {
                return true;
            }
            return (this.prefix.length() == 0) && Intrinsics.areEqual(XMLConstants.XMLNS_ATTRIBUTE, this.localName);
        }

        public String toString() {
            return StringsKt.isBlank(this.namespaceUri) ? this.localName + "=\"" + this.value + '\"' : StringsKt.isBlank(this.prefix) ? AbstractJsonLexerKt.BEGIN_OBJ + this.namespaceUri + AbstractJsonLexerKt.END_OBJ + this.localName + "=\"" + this.value + '\"' : AbstractJsonLexerKt.BEGIN_OBJ + this.namespaceUri + AbstractJsonLexerKt.END_OBJ + this.prefix + AbstractJsonLexerKt.COLON + this.localName + "=\"" + this.value + '\"';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Attribute attribute = (Attribute) other;
            if (Intrinsics.areEqual(this.value, ((Attribute) other).value) && Intrinsics.areEqual(this.prefix, ((Attribute) other).prefix) && Intrinsics.areEqual(this.localName, ((Attribute) other).localName) && Intrinsics.areEqual(this.namespaceUri, ((Attribute) other).namespaceUri)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.value.hashCode();
            return (((((result * 31) + this.prefix.hashCode()) * 31) + this.localName.hashCode()) * 31) + this.namespaceUri.hashCode();
        }
    }

    /* compiled from: XmlEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lnl/adaptivity/xmlutil/XmlEvent$NamespaceImpl;", "Lnl/adaptivity/xmlutil/Namespace;", "namespacePrefix", "", "namespaceUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "prefix", "getPrefix", "()Ljava/lang/String;", "namespaceURI", "getNamespaceURI", "equals", "", "other", "", "hashCode", "", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class NamespaceImpl implements Namespace {
        private final String namespaceURI;
        private final String prefix;

        @Override // nl.adaptivity.xmlutil.Namespace
        public /* synthetic */ String component1() {
            return getPrefix();
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public /* synthetic */ String component2() {
            return getNamespaceURI();
        }

        public NamespaceImpl(String namespacePrefix, String namespaceUri) {
            Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            this.prefix = namespacePrefix;
            this.namespaceURI = namespaceUri;
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public String getPrefix() {
            return this.prefix;
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public String getNamespaceURI() {
            return this.namespaceURI;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NamespaceImpl(CharSequence namespacePrefix, CharSequence namespaceUri) {
            this(namespacePrefix.toString(), namespaceUri.toString());
            Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Namespace) && Intrinsics.areEqual(getPrefix(), ((Namespace) other).getPrefix()) && Intrinsics.areEqual(getNamespaceURI(), ((Namespace) other).getNamespaceURI());
        }

        public int hashCode() {
            return (getPrefix().hashCode() * 31) + getNamespaceURI().hashCode();
        }

        public String toString() {
            return AbstractJsonLexerKt.BEGIN_OBJ + getPrefix() + AbstractJsonLexerKt.COLON + getNamespaceURI() + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public boolean isIgnorable() {
        return getEventType().isIgnorable();
    }
}