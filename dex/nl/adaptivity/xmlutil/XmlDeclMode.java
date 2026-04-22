package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: XmlStreaming.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lnl/adaptivity/xmlutil/XmlDeclMode;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Minimal", "Auto", "Charset", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum XmlDeclMode {
    None,
    Minimal,
    Auto,
    Charset;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    /* compiled from: XmlStreaming.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lnl/adaptivity/xmlutil/XmlDeclMode$Companion;", "", "<init>", "()V", "from", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "value", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @XmlUtilInternal
        public final XmlDeclMode from(boolean value) {
            return value ? XmlDeclMode.None : XmlDeclMode.Auto;
        }
    }

    public static EnumEntries<XmlDeclMode> getEntries() {
        return $ENTRIES;
    }
}