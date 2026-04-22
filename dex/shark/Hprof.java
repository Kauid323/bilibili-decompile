package shark;

import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Hprof.kt */
@Deprecated(message = "Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lshark/Hprof;", "Ljava/io/Closeable;", "file", "Ljava/io/File;", "header", "Lshark/HprofHeader;", "(Ljava/io/File;Lshark/HprofHeader;)V", "closeables", "", "getFile", "()Ljava/io/File;", "fileLength", "", "getFileLength", "()J", "getHeader", "()Lshark/HprofHeader;", "heapDumpTimestamp", "getHeapDumpTimestamp", "hprofVersion", "Lshark/Hprof$HprofVersion;", "getHprofVersion", "()Lshark/Hprof$HprofVersion;", "reader", "Lshark/HprofReader;", "getReader", "()Lshark/HprofReader;", "attachClosable", "", "closeable", "close", "Companion", "HprofVersion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class Hprof implements Closeable {
    public static final Companion Companion = new Companion(null);
    private final List<Closeable> closeables;
    private final File file;
    private final HprofHeader header;
    private final HprofReader reader;

    private Hprof(File file, HprofHeader header) {
        this.file = file;
        this.header = header;
        this.reader = new HprofReader(this);
        this.closeables = new ArrayList();
    }

    public /* synthetic */ Hprof(File file, HprofHeader header, DefaultConstructorMarker $constructor_marker) {
        this(file, header);
    }

    public final File getFile() {
        return this.file;
    }

    public final HprofHeader getHeader() {
        return this.header;
    }

    public final HprofReader getReader() {
        return this.reader;
    }

    public final long getHeapDumpTimestamp() {
        return this.header.getHeapDumpTimestamp();
    }

    public final HprofVersion getHprofVersion() {
        return HprofVersion.valueOf(this.header.getVersion().name());
    }

    public final long getFileLength() {
        return this.file.length();
    }

    public final void attachClosable(Closeable closeable) {
        Intrinsics.checkParameterIsNotNull(closeable, "closeable");
        this.closeables.add(closeable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterable $this$forEach$iv = this.closeables;
        for (Object element$iv : $this$forEach$iv) {
            Closeable it = (Closeable) element$iv;
            it.close();
        }
    }

    /* compiled from: Hprof.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lshark/Hprof$HprofVersion;", "", "(Ljava/lang/String;I)V", "versionString", "", "getVersionString", "()Ljava/lang/String;", "JDK1_2_BETA3", "JDK1_2_BETA4", "JDK_6", "ANDROID", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    @Deprecated(message = "Moved to top level class", replaceWith = @ReplaceWith(expression = "shark.HprofVersion", imports = {}))
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum HprofVersion {
        JDK1_2_BETA3,
        JDK1_2_BETA4,
        JDK_6,
        ANDROID;

        public final String getVersionString() {
            return shark.HprofVersion.valueOf(name()).getVersionString();
        }
    }

    /* compiled from: Hprof.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lshark/Hprof$Companion;", "", "()V", "open", "Lshark/Hprof;", "hprofFile", "Ljava/io/File;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Deprecated(message = "Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
        public final Hprof open(File hprofFile) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            return new Hprof(hprofFile, HprofHeader.Companion.parseHeaderOf(hprofFile), null);
        }
    }
}