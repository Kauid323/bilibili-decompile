package nl.adaptivity.xmlutil.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: XmlVersion.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lnl/adaptivity/xmlutil/core/XmlVersion;", "", "versionString", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersionString", "()Ljava/lang/String;", "XML10", "XML11", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum XmlVersion {
    XML10("1.0"),
    XML11("1.1");
    
    private final String versionString;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    XmlVersion(String versionString) {
        this.versionString = versionString;
    }

    public final String getVersionString() {
        return this.versionString;
    }

    public static EnumEntries<XmlVersion> getEntries() {
        return $ENTRIES;
    }
}