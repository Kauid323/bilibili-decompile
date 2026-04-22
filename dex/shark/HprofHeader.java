package shark;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: HprofHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lshark/HprofHeader;", "", "heapDumpTimestamp", "", "version", "Lshark/HprofVersion;", "identifierByteSize", "", "(JLshark/HprofVersion;I)V", "getHeapDumpTimestamp", "()J", "getIdentifierByteSize", "()I", "recordsPosition", "getRecordsPosition", "getVersion", "()Lshark/HprofVersion;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofHeader {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, HprofVersion> supportedVersions;
    private final long heapDumpTimestamp;
    private final int identifierByteSize;
    private final int recordsPosition;
    private final HprofVersion version;

    public HprofHeader() {
        this(0L, null, 0, 7, null);
    }

    public static /* synthetic */ HprofHeader copy$default(HprofHeader hprofHeader, long j, HprofVersion hprofVersion, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = hprofHeader.heapDumpTimestamp;
        }
        if ((i2 & 2) != 0) {
            hprofVersion = hprofHeader.version;
        }
        if ((i2 & 4) != 0) {
            i = hprofHeader.identifierByteSize;
        }
        return hprofHeader.copy(j, hprofVersion, i);
    }

    public final long component1() {
        return this.heapDumpTimestamp;
    }

    public final HprofVersion component2() {
        return this.version;
    }

    public final int component3() {
        return this.identifierByteSize;
    }

    public final HprofHeader copy(long j, HprofVersion hprofVersion, int i) {
        Intrinsics.checkParameterIsNotNull(hprofVersion, "version");
        return new HprofHeader(j, hprofVersion, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HprofHeader) {
                HprofHeader hprofHeader = (HprofHeader) obj;
                return this.heapDumpTimestamp == hprofHeader.heapDumpTimestamp && Intrinsics.areEqual(this.version, hprofHeader.version) && this.identifierByteSize == hprofHeader.identifierByteSize;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.heapDumpTimestamp;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        HprofVersion hprofVersion = this.version;
        return ((i + (hprofVersion != null ? hprofVersion.hashCode() : 0)) * 31) + this.identifierByteSize;
    }

    public String toString() {
        return "HprofHeader(heapDumpTimestamp=" + this.heapDumpTimestamp + ", version=" + this.version + ", identifierByteSize=" + this.identifierByteSize + ")";
    }

    public HprofHeader(long heapDumpTimestamp, HprofVersion version, int identifierByteSize) {
        Intrinsics.checkParameterIsNotNull(version, "version");
        this.heapDumpTimestamp = heapDumpTimestamp;
        this.version = version;
        this.identifierByteSize = identifierByteSize;
        String versionString = this.version.getVersionString();
        Charset charset = Charsets.UTF_8;
        if (versionString == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = versionString.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        this.recordsPosition = bytes.length + 1 + 4 + 8;
    }

    public /* synthetic */ HprofHeader(long j, HprofVersion hprofVersion, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? System.currentTimeMillis() : j, (i2 & 2) != 0 ? HprofVersion.ANDROID : hprofVersion, (i2 & 4) != 0 ? 4 : i);
    }

    public final long getHeapDumpTimestamp() {
        return this.heapDumpTimestamp;
    }

    public final HprofVersion getVersion() {
        return this.version;
    }

    public final int getIdentifierByteSize() {
        return this.identifierByteSize;
    }

    public final int getRecordsPosition() {
        return this.recordsPosition;
    }

    /* compiled from: HprofHeader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lshark/HprofHeader$Companion;", "", "()V", "supportedVersions", "", "", "Lshark/HprofVersion;", "parseHeaderOf", "Lshark/HprofHeader;", "hprofFile", "Ljava/io/File;", "source", "Lokio/BufferedSource;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final HprofHeader parseHeaderOf(File hprofFile) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            long fileLength = hprofFile.length();
            if (fileLength == 0) {
                throw new IllegalArgumentException("Hprof file is 0 byte length");
            }
            BufferedSource bufferedSource = (Closeable) Okio.buffer(Okio.source(new FileInputStream(hprofFile)));
            try {
                BufferedSource it = bufferedSource;
                Companion companion = HprofHeader.Companion;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                HprofHeader parseHeaderOf = companion.parseHeaderOf(it);
                CloseableKt.closeFinally(bufferedSource, (Throwable) null);
                return parseHeaderOf;
            } finally {
            }
        }

        public final HprofHeader parseHeaderOf(BufferedSource source) {
            Intrinsics.checkParameterIsNotNull(source, "source");
            if (source.exhausted()) {
                throw new IllegalArgumentException("Source has no available bytes");
            }
            long endOfVersionString = source.indexOf((byte) 0);
            String versionName = source.readUtf8(endOfVersionString);
            HprofVersion version = (HprofVersion) HprofHeader.supportedVersions.get(versionName);
            if (version == null) {
                throw new IllegalStateException(("Unsupported Hprof version [" + versionName + "] not in supported list " + HprofHeader.supportedVersions.keySet()).toString());
            }
            source.skip(1L);
            int identifierByteSize = source.readInt();
            long heapDumpTimestamp = source.readLong();
            return new HprofHeader(heapDumpTimestamp, version, identifierByteSize);
        }
    }

    static {
        HprofVersion[] values = HprofVersion.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (HprofVersion hprofVersion : values) {
            destination$iv$iv.put(hprofVersion.getVersionString(), hprofVersion);
        }
        supportedVersions = destination$iv$iv;
    }
}