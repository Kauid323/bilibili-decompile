package okio.internal;

import java.io.IOException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

/* compiled from: ZipFiles.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ZipFilesKt$openZip$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ZipEntry it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x0055, code lost:
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0056, code lost:
        r15 = readEocdRecord(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x005f, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0064, code lost:
        r0 = r6.readUtf8(r15.getCommentByteCount());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x006a, code lost:
        r6.close();
        r10 = r13 - 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0078, code lost:
        if (r10 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x007a, code lost:
        r12 = okio.Okio.buffer(r0.source(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0085, code lost:
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0093, code lost:
        if (r0.readIntLe() != okio.internal.ZipFilesKt.ZIP64_LOCATOR_SIGNATURE) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0095, code lost:
        r0 = r0.readIntLe();
        r23 = r0.readLongLe();
        r0 = r0.readIntLe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00ab, code lost:
        if (r0 != 1) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00ad, code lost:
        if (r0 != 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x00b3, code lost:
        r6 = okio.Okio.buffer(r0.source(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x00c0, code lost:
        r0 = r6;
        r27 = r0.readIntLe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x00d2, code lost:
        if (r27 != okio.internal.ZipFilesKt.ZIP64_EOCD_RECORD_SIGNATURE) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x00d4, code lost:
        r15 = readZip64EocdRecord(r0, r15);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x00dd, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x00e5, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00eb, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0120, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(okio.internal.ZipFilesKt.ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0121, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0122, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0124, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0125, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0129, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x012a, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x012f, code lost:
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0136, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0137, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x014b, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0150, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0154, code lost:
        kotlin.io.CloseableKt.closeFinally(r12, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x015b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x015c, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0161, code lost:
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x016c, code lost:
        r0 = new java.util.ArrayList();
        r10 = okio.Okio.buffer(r0.source(r15.getCentralDirectoryOffset()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0183, code lost:
        r0 = r10;
        r12 = 0;
        r16 = r15.getEntryCount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x018f, code lost:
        if (r12 >= r16) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0191, code lost:
        r14 = readEntry(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x019f, code lost:
        if (r14.getOffset() >= r15.getCentralDirectoryOffset()) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x01ab, code lost:
        if (r3.invoke(r14).booleanValue() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x01ad, code lost:
        r19 = r0;
        r0.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x01b6, code lost:
        r19 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x01b8, code lost:
        r12 = r12 + 1;
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x01c8, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x01c9, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x01cf, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, null);
        r0 = buildIndex(r0);
        r3 = new okio.ZipFileSystem(r33, r34, r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x01db, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x01df, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x01e9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x01ef, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x01f0, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0226, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0229, code lost:
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> function1) throws IOException {
        Function1<? super ZipEntry, Boolean> predicate = function1;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            FileHandle fileHandle = openReadOnly;
            boolean z = false;
            long scanOffset = fileHandle.size() - 22;
            if (scanOffset < 0) {
                throw new IOException("not a zip: size=" + fileHandle.size());
            }
            long stopOffset = Math.max(scanOffset - 65536, 0L);
            while (true) {
                BufferedSource source = Okio.buffer(fileHandle.source(scanOffset));
                try {
                    if (source.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        break;
                    }
                    boolean z2 = z;
                    long stopOffset2 = stopOffset;
                    source.close();
                    scanOffset--;
                    if (scanOffset < stopOffset2) {
                        throw new IOException("not a zip: end of central directory signature not found");
                    }
                    predicate = function1;
                    z = z2;
                    stopOffset = stopOffset2;
                } catch (Throwable th) {
                    th = th;
                    BufferedSource source2 = source;
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(openReadOnly, th2);
                throw th3;
            }
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path root = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map result = MapsKt.mutableMapOf(TuplesKt.to(root, new ZipEntry(root, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        List<ZipEntry> $this$sortedBy$iv = list;
        for (ZipEntry entry : CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ZipEntry it = (ZipEntry) t;
                ZipEntry it2 = (ZipEntry) t2;
                return ComparisonsKt.compareValues(it.getCanonicalPath(), it2.getCanonicalPath());
            }
        })) {
            ZipEntry replaced = result.put(entry.getCanonicalPath(), entry);
            if (replaced == null) {
                ZipEntry child = entry;
                while (true) {
                    Path parentPath = child.getCanonicalPath().parent();
                    if (parentPath != null) {
                        ZipEntry parentEntry = result.get(parentPath);
                        if (parentEntry != null) {
                            parentEntry.getChildren().add(child.getCanonicalPath());
                            break;
                        }
                        ZipEntry parentEntry2 = new ZipEntry(parentPath, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        result.put(parentPath, parentEntry2);
                        parentEntry2.getChildren().add(child.getCanonicalPath());
                        child = parentEntry2;
                    }
                }
            }
        }
        return result;
    }

    public static final ZipEntry readEntry(final BufferedSource $this$readEntry) throws IOException {
        Ref.LongRef offset;
        Intrinsics.checkNotNullParameter($this$readEntry, "<this>");
        int signature = $this$readEntry.readIntLe();
        if (signature != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(signature));
        }
        $this$readEntry.skip(4L);
        int bitFlag = $this$readEntry.readShortLe() & 65535;
        if ((bitFlag & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(bitFlag));
        }
        int compressionMethod = $this$readEntry.readShortLe() & 65535;
        int time = $this$readEntry.readShortLe() & 65535;
        int date = $this$readEntry.readShortLe() & 65535;
        Long lastModifiedAtMillis = dosDateTimeToEpochMillis(date, time);
        long crc = $this$readEntry.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef compressedSize = new Ref.LongRef();
        compressedSize.element = $this$readEntry.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef size = new Ref.LongRef();
        size.element = $this$readEntry.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int nameSize = $this$readEntry.readShortLe() & 65535;
        int extraSize = $this$readEntry.readShortLe() & 65535;
        int commentByteCount = $this$readEntry.readShortLe() & 65535;
        $this$readEntry.skip(8L);
        Ref.LongRef offset2 = new Ref.LongRef();
        offset2.element = $this$readEntry.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String name = $this$readEntry.readUtf8(nameSize);
        if (StringsKt.contains$default((CharSequence) name, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long result = 0;
        if (size.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            offset = offset2;
            result = 0 + 8;
        } else {
            offset = offset2;
        }
        if (compressedSize.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            result += 8;
        }
        if (offset.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            result += 8;
        }
        final long requiredZip64ExtraSize = result;
        final Ref.BooleanRef hasZip64Extra = new Ref.BooleanRef();
        final Ref.LongRef offset3 = offset;
        readExtra($this$readEntry, extraSize, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readEntry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) {
                invoke(num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int headerId, long dataSize) {
                if (headerId == 1) {
                    if (!Ref.BooleanRef.this.element) {
                        Ref.BooleanRef.this.element = true;
                        if (dataSize < requiredZip64ExtraSize) {
                            throw new IOException("bad zip: zip64 extra too short");
                        }
                        size.element = size.element == 4294967295L ? $this$readEntry.readLongLe() : size.element;
                        compressedSize.element = compressedSize.element == 4294967295L ? $this$readEntry.readLongLe() : 0L;
                        offset3.element = offset3.element == 4294967295L ? $this$readEntry.readLongLe() : 0L;
                        return;
                    }
                    throw new IOException("bad zip: zip64 extra repeated");
                }
            }
        });
        if (requiredZip64ExtraSize > 0 && !hasZip64Extra.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String comment = $this$readEntry.readUtf8(commentByteCount);
        Path canonicalPath = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(name);
        boolean isDirectory = StringsKt.endsWith$default(name, "/", false, 2, (Object) null);
        return new ZipEntry(canonicalPath, isDirectory, comment, crc, compressedSize.element, size.element, compressionMethod, lastModifiedAtMillis, offset3.element);
    }

    private static final EocdRecord readEocdRecord(BufferedSource $this$readEocdRecord) throws IOException {
        int diskNumber = $this$readEocdRecord.readShortLe() & 65535;
        int diskWithCentralDir = $this$readEocdRecord.readShortLe() & 65535;
        long entryCount = $this$readEocdRecord.readShortLe() & 65535;
        long totalEntryCount = $this$readEocdRecord.readShortLe() & 65535;
        if (entryCount != totalEntryCount || diskNumber != 0 || diskWithCentralDir != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        $this$readEocdRecord.skip(4L);
        long centralDirectoryOffset = $this$readEocdRecord.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int commentByteCount = 65535 & $this$readEocdRecord.readShortLe();
        return new EocdRecord(entryCount, centralDirectoryOffset, commentByteCount);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource $this$readZip64EocdRecord, EocdRecord regularRecord) throws IOException {
        $this$readZip64EocdRecord.skip(12L);
        int diskNumber = $this$readZip64EocdRecord.readIntLe();
        int diskWithCentralDirStart = $this$readZip64EocdRecord.readIntLe();
        long entryCount = $this$readZip64EocdRecord.readLongLe();
        long totalEntryCount = $this$readZip64EocdRecord.readLongLe();
        if (entryCount == totalEntryCount && diskNumber == 0 && diskWithCentralDirStart == 0) {
            $this$readZip64EocdRecord.skip(8L);
            long centralDirectoryOffset = $this$readZip64EocdRecord.readLongLe();
            return new EocdRecord(entryCount, centralDirectoryOffset, regularRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource $this$readExtra, int extraSize, Function2<? super Integer, ? super Long, Unit> function2) {
        long remaining = extraSize;
        while (remaining != 0) {
            if (remaining < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int headerId = $this$readExtra.readShortLe() & 65535;
            long dataSize = $this$readExtra.readShortLe() & 65535;
            long remaining2 = remaining - 4;
            if (remaining2 < dataSize) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            $this$readExtra.require(dataSize);
            long sizeBefore = $this$readExtra.getBuffer().size();
            function2.invoke(Integer.valueOf(headerId), Long.valueOf(dataSize));
            long fieldRemaining = ($this$readExtra.getBuffer().size() + dataSize) - sizeBefore;
            if (fieldRemaining < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + headerId);
            }
            if (fieldRemaining > 0) {
                $this$readExtra.getBuffer().skip(fieldRemaining);
            }
            remaining = remaining2 - dataSize;
        }
    }

    public static final void skipLocalHeader(BufferedSource $this$skipLocalHeader) {
        Intrinsics.checkNotNullParameter($this$skipLocalHeader, "<this>");
        readOrSkipLocalHeader($this$skipLocalHeader, null);
    }

    public static final FileMetadata readLocalHeader(BufferedSource $this$readLocalHeader, FileMetadata basicMetadata) {
        Intrinsics.checkNotNullParameter($this$readLocalHeader, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader($this$readLocalHeader, basicMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource $this$readOrSkipLocalHeader, FileMetadata basicMetadata) {
        final Ref.ObjectRef lastModifiedAtMillis = new Ref.ObjectRef();
        lastModifiedAtMillis.element = basicMetadata != null ? basicMetadata.getLastModifiedAtMillis() : 0;
        final Ref.ObjectRef lastAccessedAtMillis = new Ref.ObjectRef();
        final Ref.ObjectRef createdAtMillis = new Ref.ObjectRef();
        int signature = $this$readOrSkipLocalHeader.readIntLe();
        if (signature == LOCAL_FILE_HEADER_SIGNATURE) {
            $this$readOrSkipLocalHeader.skip(2L);
            int bitFlag = $this$readOrSkipLocalHeader.readShortLe() & 65535;
            if ((bitFlag & 1) == 0) {
                $this$readOrSkipLocalHeader.skip(18L);
                long fileNameLength = $this$readOrSkipLocalHeader.readShortLe() & 65535;
                int extraSize = 65535 & $this$readOrSkipLocalHeader.readShortLe();
                $this$readOrSkipLocalHeader.skip(fileNameLength);
                if (basicMetadata == null) {
                    $this$readOrSkipLocalHeader.skip(extraSize);
                    return null;
                }
                readExtra($this$readOrSkipLocalHeader, extraSize, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) {
                        invoke(num.intValue(), l.longValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r4v12, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.lang.Long] */
                    public final void invoke(int headerId, long dataSize) {
                        if (headerId == 21589) {
                            if (dataSize < 1) {
                                throw new IOException("bad zip: extended timestamp extra too short");
                            }
                            int flags = BufferedSource.this.readByte() & 255;
                            boolean hasLastModifiedAtMillis = (flags & 1) == 1;
                            boolean hasLastAccessedAtMillis = (flags & 2) == 2;
                            boolean hasCreatedAtMillis = (flags & 4) == 4;
                            BufferedSource bufferedSource = BufferedSource.this;
                            long result = hasLastModifiedAtMillis ? 1 + 4 : 1L;
                            if (hasLastAccessedAtMillis) {
                                result += 4;
                            }
                            if (hasCreatedAtMillis) {
                                result += 4;
                            }
                            long requiredSize = result;
                            if (dataSize < requiredSize) {
                                throw new IOException("bad zip: extended timestamp extra too short");
                            }
                            if (hasLastModifiedAtMillis) {
                                lastModifiedAtMillis.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                            }
                            if (hasLastAccessedAtMillis) {
                                lastAccessedAtMillis.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                            }
                            if (hasCreatedAtMillis) {
                                createdAtMillis.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                            }
                        }
                    }
                });
                return new FileMetadata(basicMetadata.isRegularFile(), basicMetadata.isDirectory(), null, basicMetadata.getSize(), (Long) createdAtMillis.element, (Long) lastModifiedAtMillis.element, (Long) lastAccessedAtMillis.element, null, 128, null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(bitFlag));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(signature));
    }

    private static final Long dosDateTimeToEpochMillis(int date, int time) {
        if (time == -1) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(14, 0);
        int year = ((date >> 9) & WorkQueueKt.MASK) + 1980;
        int month = (date >> 5) & 15;
        int day = date & 31;
        int hour = (time >> 11) & 31;
        int minute = (time >> 5) & 63;
        int second = (time & 31) << 1;
        cal.set(year, month - 1, day, hour, minute, second);
        return Long.valueOf(cal.getTime().getTime());
    }

    private static final String getHex(int $this$hex) {
        StringBuilder append = new StringBuilder().append("0x");
        String num = Integer.toString($this$hex, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return append.append(num).toString();
    }
}