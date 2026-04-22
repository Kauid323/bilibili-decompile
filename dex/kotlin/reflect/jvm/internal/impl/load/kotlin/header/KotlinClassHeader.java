package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {
    private final String[] data;
    private final int extraInt;
    private final String extraString;
    private final String[] incompatibleData;
    private final Kind kind;
    private final MetadataVersion metadataVersion;
    private final String packageName;
    private final byte[] serializedIr;
    private final String[] strings;

    public KotlinClassHeader(Kind kind, MetadataVersion metadataVersion, String[] data, String[] incompatibleData, String[] strings, String extraString, int extraInt, String packageName, byte[] serializedIr) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.kind = kind;
        this.metadataVersion = metadataVersion;
        this.data = data;
        this.incompatibleData = incompatibleData;
        this.strings = strings;
        this.extraString = extraString;
        this.extraInt = extraInt;
        this.packageName = packageName;
        this.serializedIr = serializedIr;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final MetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final String[] getStrings() {
        return this.strings;
    }

    /* compiled from: KotlinClassHeader.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        private static final Map<Integer, Kind> entryById;
        private final int id;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        public static final Companion Companion = new Companion(null);

        Kind(int id) {
            this.id = id;
        }

        static {
            Kind[] values = values();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Kind kind : values) {
                destination$iv$iv.put(Integer.valueOf(kind.id), kind);
            }
            entryById = destination$iv$iv;
        }

        /* compiled from: KotlinClassHeader.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Kind getById(int id) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(id));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        @JvmStatic
        public static final Kind getById(int id) {
            return Companion.getById(id);
        }
    }

    public final String getMultifileClassName() {
        String str = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.data;
        if (!(this.kind == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> asList = strArr != null ? ArraysKt.asList(strArr) : null;
        return asList == null ? CollectionsKt.emptyList() : asList;
    }

    public final boolean isUnstableJvmIrBinary() {
        return has(this.extraInt, 16) && !has(this.extraInt, 32);
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }

    private final boolean has(int $this$has, int flag) {
        return ($this$has & flag) != 0;
    }
}