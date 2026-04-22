package nl.adaptivity.xmlutil.dom2;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DOMImplementation.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J,\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "", "supportsWhitespaceAtToplevel", "", "getSupportsWhitespaceAtToplevel", "()Z", "createDocumentType", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "qualifiedName", "", "publicId", "systemId", "createDocument", "Lnl/adaptivity/xmlutil/dom2/Document;", "namespace", "documentType", "hasFeature", "feature", "version", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$SupportedFeatures;", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$DOMVersion;", "SupportedFeatures", "DOMVersion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DOMImplementation {
    Document createDocument(String str, String str2, DocumentType documentType);

    DocumentType createDocumentType(String str, String str2, String str3);

    boolean getSupportsWhitespaceAtToplevel();

    boolean hasFeature(String str, String str2);

    boolean hasFeature(SupportedFeatures supportedFeatures, DOMVersion dOMVersion);

    /* compiled from: DOMImplementation.kt */
    /* renamed from: nl.adaptivity.xmlutil.dom2.DOMImplementation$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Document createDocument$default(DOMImplementation dOMImplementation, String str, String str2, DocumentType documentType, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    documentType = null;
                }
                return dOMImplementation.createDocument(str, str2, documentType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDocument");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean $default$hasFeature(DOMImplementation _this, String feature, String version) {
            DOMVersion dOMVersion;
            Object element$iv;
            Intrinsics.checkNotNullParameter(feature, "feature");
            Iterable $this$firstOrNull$iv = SupportedFeatures.getEntries();
            Iterator<E> it = $this$firstOrNull$iv.iterator();
            while (true) {
                dOMVersion = null;
                if (it.hasNext()) {
                    element$iv = it.next();
                    SupportedFeatures it2 = (SupportedFeatures) element$iv;
                    if (Intrinsics.areEqual(it2.getStrName(), feature)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            SupportedFeatures f = (SupportedFeatures) element$iv;
            if (f == null) {
                return false;
            }
            String str = version;
            if (!(str == null || str.length() == 0)) {
                Iterable $this$firstOrNull$iv2 = DOMVersion.getEntries();
                Iterator<E> it3 = $this$firstOrNull$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object element$iv2 = it3.next();
                    DOMVersion it4 = (DOMVersion) element$iv2;
                    if (Intrinsics.areEqual(it4.getStrName(), version)) {
                        dOMVersion = element$iv2;
                        break;
                    }
                }
                dOMVersion = dOMVersion;
                if (dOMVersion == null) {
                    return false;
                }
            }
            DOMVersion v = dOMVersion;
            return _this.hasFeature(f, v);
        }

        public static boolean $default$hasFeature(DOMImplementation _this, SupportedFeatures feature, DOMVersion version) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            return version == null || feature.isSupportedVersion(version);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DOMImplementation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/DOMImplementation$SupportedFeatures;", "", "strName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrName", "()Ljava/lang/String;", "CORE", "XML", "isSupportedVersion", "", "version", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$DOMVersion;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SupportedFeatures {
        private final String strName;
        public static final SupportedFeatures CORE = new CORE("CORE", 0);
        public static final SupportedFeatures XML = new XML("XML", 1);
        private static final /* synthetic */ SupportedFeatures[] $VALUES = $values();
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        private static final /* synthetic */ SupportedFeatures[] $values() {
            return new SupportedFeatures[]{CORE, XML};
        }

        public /* synthetic */ SupportedFeatures(String str, int i, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2);
        }

        public abstract boolean isSupportedVersion(DOMVersion dOMVersion);

        /* compiled from: DOMImplementation.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"nl/adaptivity/xmlutil/dom2/DOMImplementation.SupportedFeatures.CORE", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$SupportedFeatures;", "isSupportedVersion", "", "version", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$DOMVersion;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class CORE extends SupportedFeatures {
            CORE(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, "Core", null);
            }

            @Override // nl.adaptivity.xmlutil.dom2.DOMImplementation.SupportedFeatures
            public boolean isSupportedVersion(DOMVersion version) {
                Intrinsics.checkNotNullParameter(version, "version");
                return true;
            }
        }

        private SupportedFeatures(String $enum$name, int $enum$ordinal, String strName) {
            this.strName = strName;
        }

        public final String getStrName() {
            return this.strName;
        }

        /* compiled from: DOMImplementation.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"nl/adaptivity/xmlutil/dom2/DOMImplementation.SupportedFeatures.XML", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$SupportedFeatures;", "isSupportedVersion", "", "version", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation$DOMVersion;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class XML extends SupportedFeatures {
            XML(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, "XML", null);
            }

            @Override // nl.adaptivity.xmlutil.dom2.DOMImplementation.SupportedFeatures
            public boolean isSupportedVersion(DOMVersion version) {
                Intrinsics.checkNotNullParameter(version, "version");
                return true;
            }
        }

        public static EnumEntries<SupportedFeatures> getEntries() {
            return $ENTRIES;
        }

        public static SupportedFeatures valueOf(String value) {
            return (SupportedFeatures) Enum.valueOf(SupportedFeatures.class, value);
        }

        public static SupportedFeatures[] values() {
            return (SupportedFeatures[]) $VALUES.clone();
        }
    }

    /* compiled from: DOMImplementation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/DOMImplementation$DOMVersion;", "", "strName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrName", "()Ljava/lang/String;", "V1", "V2", "V3", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum DOMVersion {
        V1("1.0"),
        V2("2.0"),
        V3("3.0");
        
        private final String strName;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        DOMVersion(String strName) {
            this.strName = strName;
        }

        public final String getStrName() {
            return this.strName;
        }

        public static EnumEntries<DOMVersion> getEntries() {
            return $ENTRIES;
        }
    }
}