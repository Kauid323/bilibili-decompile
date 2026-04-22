package kntr.base.imageloader.cache.disk;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.FileIOKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.SinksKt;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: DiskLruCache.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0001\u0018\u0000 E2\u00060\u0001j\u0002`\u0002:\u0004BCDEB1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\u0017\u0010-\u001a\b\u0018\u00010.R\u00020\u00002\u0006\u0010/\u001a\u00020\u0013H\u0086\u0002J\u0014\u00100\u001a\b\u0018\u000101R\u00020\u00002\u0006\u0010/\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\bJ\u001c\u00102\u001a\u00020&2\n\u00103\u001a\u000601R\u00020\u00002\u0006\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002J\u000e\u00106\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0013J\u0014\u00107\u001a\u00020 2\n\u00108\u001a\u00060\u0014R\u00020\u0000H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0016J\u0006\u0010;\u001a\u00020&J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0006\u0010?\u001a\u00020&J\b\u0010@\u001a\u00020&H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014R\u00020\u00000\u0012j\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014R\u00020\u0000`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskLruCache;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "fileSystem", "Lkotlinx/io/files/FileSystem;", "directory", "Lkotlinx/io/files/Path;", "maxByteSize", "", "appVersion", "", "valueCount", "<init>", "(Lkotlinx/io/files/FileSystem;Lkotlinx/io/files/Path;JII)V", "journalFile", "journalFileTmp", "journalFileBackup", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "Lkotlin/collections/LinkedHashMap;", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "size", "operationsSinceRewrite", "journalWriter", "Lkotlinx/io/Sink;", "hasJournalErrors", "", "initialized", "closed", "mostRecentTrimFailed", "mostRecentRebuildFailed", "initialize", "", "readJournal", "newJournalWriter", "readJournalLine", "line", "processJournal", "writeJournal", "get", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;", "key", "edit", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "completeEdit", "editor", "success", "journalRewriteRequired", "remove", "removeEntry", "entry", "checkNotClosed", "close", "flush", "trimToSize", "removeOldestEntry", "delete", "evictAll", "launchCleanup", "validateKey", "Snapshot", "Editor", "Entry", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DiskLruCache implements AutoCloseable {
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TMP = "journal.tmp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    public static final String VERSION = "1";
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    private boolean closed;
    private final Path directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private Sink journalWriter;
    private final Object lock;
    private final LinkedHashMap<String, Entry> lruEntries;
    private final long maxByteSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");

    public DiskLruCache(FileSystem fileSystem, Path directory, long maxByteSize, int appVersion, int valueCount) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.maxByteSize = maxByteSize;
        this.appVersion = appVersion;
        this.valueCount = valueCount;
        if (!(this.maxByteSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(this.valueCount > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = PathsKt.Path(this.directory, new String[]{JOURNAL_FILE});
        this.journalFileTmp = PathsKt.Path(this.directory, new String[]{JOURNAL_FILE_TMP});
        this.journalFileBackup = PathsKt.Path(this.directory, new String[]{JOURNAL_FILE_BACKUP});
        this.lruEntries = new LinkedHashMap<>();
        this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(CoroutineExJvmKt.getIoContext().limitedParallelism(1)));
        this.lock = new Object();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DiskLruCache(FileSystem fileSystem, Path path, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, path, j, i, i2);
        FileSystem fileSystem2;
        if ((i3 & 1) == 0) {
            fileSystem2 = fileSystem;
        } else {
            fileSystem2 = FileSystemJvmKt.SystemFileSystem;
        }
    }

    public final void initialize() {
        synchronized (this.lock) {
            if (!this.initialized) {
                try {
                    if (this.fileSystem.exists(this.journalFileTmp)) {
                        this.fileSystem.delete(this.journalFileTmp, false);
                    }
                    if (this.fileSystem.exists(this.journalFileBackup)) {
                        if (this.fileSystem.exists(this.journalFile)) {
                            this.fileSystem.delete(this.journalFileBackup, false);
                        } else {
                            this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                        }
                    }
                } catch (IOException e) {
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    try {
                        readJournal();
                        processJournal();
                        this.initialized = true;
                    } catch (IOException e2) {
                        delete();
                        this.closed = false;
                    }
                }
                writeJournal();
                this.initialized = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void readJournal() {
        Source source = (AutoCloseable) CoreKt.buffered(this.fileSystem.source(this.journalFile));
        try {
            Source source2 = source;
            String magic = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
            String version = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
            String appVersionString = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
            String valueCountString = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
            String blank = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
            if (Intrinsics.areEqual(MAGIC, magic) && Intrinsics.areEqual("1", version) && Intrinsics.areEqual(String.valueOf(this.appVersion), appVersionString) && Intrinsics.areEqual(String.valueOf(this.valueCount), valueCountString)) {
                if (!(blank.length() > 0)) {
                    int lineCount = 0;
                    while (!source2.exhausted()) {
                        try {
                            String line = Utf8Kt.readLineStrict$default(source2, 0L, 1, (Object) null);
                            readJournalLine(line);
                            lineCount++;
                        } catch (EOFException e) {
                        }
                    }
                    this.operationsSinceRewrite = lineCount - this.lruEntries.size();
                    if (!source2.exhausted()) {
                        writeJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(source, (Throwable) null);
                    return;
                }
            }
            throw new IOException("unexpected journal header: [" + magic + ", " + version + ", " + appVersionString + ", " + valueCountString + ", " + blank + "]");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(source, th);
                throw th2;
            }
        }
    }

    private final Sink newJournalWriter() {
        return CoreKt.buffered(this.fileSystem.sink(this.journalFile, true));
    }

    private final void readJournalLine(String line) {
        String key;
        Entry entry;
        int firstSpace = StringsKt.indexOf$default(line, ' ', 0, false, 6, (Object) null);
        if (firstSpace == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        int keyBegin = firstSpace + 1;
        int secondSpace = StringsKt.indexOf$default(line, ' ', keyBegin, false, 4, (Object) null);
        if (secondSpace == -1) {
            String substring = line.substring(keyBegin);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            key = substring;
            if (firstSpace == 6 && StringsKt.startsWith$default(line, REMOVE, false, 2, (Object) null)) {
                this.lruEntries.remove(key);
                return;
            }
        } else {
            String substring2 = line.substring(keyBegin, secondSpace);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            key = substring2;
        }
        Map $this$getOrPut$iv = this.lruEntries;
        String str = key;
        Entry entry2 = $this$getOrPut$iv.get(str);
        if (entry2 == null) {
            entry = new Entry(this, key);
            $this$getOrPut$iv.put(str, entry);
        } else {
            entry = entry2;
        }
        Entry entry3 = entry;
        if (secondSpace != -1 && firstSpace == 5 && StringsKt.startsWith$default(line, CLEAN, false, 2, (Object) null)) {
            String substring3 = line.substring(secondSpace + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            List parts = StringsKt.split$default(substring3, new char[]{' '}, false, 0, 6, (Object) null);
            entry3.setReadable(true);
            entry3.setCurrentEditor(null);
            entry3.setLengths(parts);
        } else if (secondSpace == -1 && firstSpace == 5 && StringsKt.startsWith$default(line, DIRTY, false, 2, (Object) null)) {
            entry3.setCurrentEditor(new Editor(this, entry3));
        } else if (secondSpace != -1 || firstSpace != 4 || !StringsKt.startsWith$default(line, READ, false, 2, (Object) null)) {
            throw new IOException("unexpected journal line: " + line);
        }
    }

    private final void processJournal() {
        long size = 0;
        Iterator iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            Entry next = iterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Entry entry = next;
            if (entry.getCurrentEditor() == null) {
                int i = this.valueCount;
                for (int i2 = 0; i2 < i; i2++) {
                    size += entry.getLengths()[i2];
                }
            } else {
                entry.setCurrentEditor(null);
                int i3 = this.valueCount;
                for (int i4 = 0; i4 < i3; i4++) {
                    Path it = entry.getCleanFiles().get(i4);
                    FileSystem fileSystem = this.fileSystem;
                    Intrinsics.checkNotNull(it);
                    if (fileSystem.exists(it)) {
                        FileSystem.-CC.delete$default(this.fileSystem, it, false, 2, (Object) null);
                    }
                    Path it2 = entry.getDirtyFiles().get(i4);
                    FileSystem fileSystem2 = this.fileSystem;
                    Intrinsics.checkNotNull(it2);
                    if (fileSystem2.exists(it2)) {
                        FileSystem.-CC.delete$default(this.fileSystem, it2, false, 2, (Object) null);
                    }
                }
                iterator.remove();
            }
        }
        this.size = size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeJournal() {
        synchronized (this.lock) {
            Sink sink = this.journalWriter;
            if (sink != null) {
                sink.close();
            }
            Sink sink2 = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(this.fileSystem, this.journalFileTmp, false, 2, (Object) null));
            Sink sink3 = sink2;
            Utf8Kt.writeString$default(sink3, MAGIC, 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "1", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, String.valueOf(this.appVersion), 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, String.valueOf(this.valueCount), 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
            for (Entry entry : this.lruEntries.values()) {
                Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
                Entry entry2 = entry;
                if (entry2.getCurrentEditor() != null) {
                    Utf8Kt.writeString$default(sink3, DIRTY, 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default(sink3, " ", 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default(sink3, entry2.getKey(), 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
                } else {
                    Utf8Kt.writeString$default(sink3, CLEAN, 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default(sink3, " ", 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default(sink3, entry2.getKey(), 0, 0, 6, (Object) null);
                    entry2.writeLengths(sink3);
                    Utf8Kt.writeString$default(sink3, "\n", 0, 0, 6, (Object) null);
                }
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(sink2, (Throwable) null);
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup, false);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            this.journalWriter = newJournalWriter();
            this.operationsSinceRewrite = 0;
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final Snapshot get(String key) {
        Snapshot snapshot;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(key);
            initialize();
            Entry entry = this.lruEntries.get(key);
            if (entry != null && (snapshot = entry.snapshot()) != null) {
                this.operationsSinceRewrite++;
                Sink $this$get_u24lambda_u240_u240 = this.journalWriter;
                Intrinsics.checkNotNull($this$get_u24lambda_u240_u240);
                Utf8Kt.writeString$default($this$get_u24lambda_u240_u240, READ, 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$get_u24lambda_u240_u240, " ", 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$get_u24lambda_u240_u240, key, 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$get_u24lambda_u240_u240, "\n", 0, 0, 6, (Object) null);
                $this$get_u24lambda_u240_u240.flush();
                if (journalRewriteRequired()) {
                    launchCleanup();
                }
                return snapshot;
            }
            return null;
        }
    }

    public final Editor edit(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(key);
            initialize();
            Entry entry = this.lruEntries.get(key);
            if ((entry != null ? entry.getCurrentEditor() : null) == null && (entry == null || entry.getLockingSnapshotCount() == 0)) {
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    Sink $this$edit_u24lambda_u240_u240 = this.journalWriter;
                    Intrinsics.checkNotNull($this$edit_u24lambda_u240_u240);
                    Utf8Kt.writeString$default($this$edit_u24lambda_u240_u240, DIRTY, 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default($this$edit_u24lambda_u240_u240, " ", 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default($this$edit_u24lambda_u240_u240, key, 0, 0, 6, (Object) null);
                    Utf8Kt.writeString$default($this$edit_u24lambda_u240_u240, "\n", 0, 0, 6, (Object) null);
                    $this$edit_u24lambda_u240_u240.flush();
                    if (!this.hasJournalErrors) {
                        if (entry == null) {
                            entry = new Entry(this, key);
                            this.lruEntries.put(key, entry);
                        }
                        Editor editor = new Editor(this, entry);
                        entry.setCurrentEditor(editor);
                        return editor;
                    }
                }
                launchCleanup();
            }
            return null;
        }
    }

    public final long size() {
        long j;
        synchronized (this.lock) {
            initialize();
            j = this.size;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeEdit(Editor editor, boolean success) {
        synchronized (this.lock) {
            Entry entry = editor.getEntry();
            if (!Intrinsics.areEqual(entry.getCurrentEditor(), editor)) {
                throw new IllegalStateException("Check failed.");
            }
            boolean z = false;
            if (!success || entry.getZombie()) {
                int i = this.valueCount;
                for (int i2 = 0; i2 < i; i2++) {
                    FileSystem fileSystem = this.fileSystem;
                    Path path = entry.getDirtyFiles().get(i2);
                    Intrinsics.checkNotNullExpressionValue(path, "get(...)");
                    fileSystem.delete(path, false);
                }
            } else {
                int i3 = this.valueCount;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (editor.getWritten()[i4]) {
                        FileSystem fileSystem2 = this.fileSystem;
                        Path path2 = entry.getDirtyFiles().get(i4);
                        Intrinsics.checkNotNullExpressionValue(path2, "get(...)");
                        if (!fileSystem2.exists(path2)) {
                            editor.abort();
                            break;
                        }
                    }
                }
                int i5 = 0;
                int i6 = this.valueCount;
                while (i5 < i6) {
                    Path path3 = entry.getDirtyFiles().get(i5);
                    Intrinsics.checkNotNullExpressionValue(path3, "get(...)");
                    Path dirty = path3;
                    Path path4 = entry.getCleanFiles().get(i5);
                    Intrinsics.checkNotNullExpressionValue(path4, "get(...)");
                    Path clean = path4;
                    if (this.fileSystem.exists(dirty)) {
                        this.fileSystem.atomicMove(dirty, clean);
                    } else {
                        FileSystem fileSystem3 = this.fileSystem;
                        Path path5 = entry.getCleanFiles().get(i5);
                        Intrinsics.checkNotNullExpressionValue(path5, "get(...)");
                        FileSystem.-CC.sink$default(fileSystem3, path5, z, 2, (Object) null);
                    }
                    long oldLength = entry.getLengths()[i5];
                    FileMetadata metadataOrNull = this.fileSystem.metadataOrNull(clean);
                    long newLength = metadataOrNull != null ? metadataOrNull.getSize() : 0L;
                    entry.getLengths()[i5] = newLength;
                    this.size = (this.size - oldLength) + newLength;
                    i5++;
                    z = false;
                }
            }
            entry.setCurrentEditor(null);
            if (entry.getZombie()) {
                removeEntry(entry);
                return;
            }
            this.operationsSinceRewrite++;
            Sink $this$completeEdit_u24lambda_u240_u240 = this.journalWriter;
            Intrinsics.checkNotNull($this$completeEdit_u24lambda_u240_u240);
            if (!success && !entry.getReadable()) {
                this.lruEntries.remove(entry.getKey());
                Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, REMOVE, 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, " ", 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, entry.getKey(), 0, 0, 6, (Object) null);
                Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, "\n", 0, 0, 6, (Object) null);
                $this$completeEdit_u24lambda_u240_u240.flush();
                if (this.size <= this.maxByteSize || journalRewriteRequired()) {
                    launchCleanup();
                }
                Unit unit = Unit.INSTANCE;
            }
            entry.setReadable(true);
            Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, CLEAN, 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, " ", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, entry.getKey(), 0, 0, 6, (Object) null);
            entry.writeLengths($this$completeEdit_u24lambda_u240_u240);
            Utf8Kt.writeString$default($this$completeEdit_u24lambda_u240_u240, "\n", 0, 0, 6, (Object) null);
            $this$completeEdit_u24lambda_u240_u240.flush();
            if (this.size <= this.maxByteSize) {
            }
            launchCleanup();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    public final boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(key);
            initialize();
            Entry entry = this.lruEntries.get(key);
            if (entry == null) {
                return false;
            }
            boolean removed = removeEntry(entry);
            if (removed && this.size <= this.maxByteSize) {
                this.mostRecentTrimFailed = false;
            }
            return removed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) {
        Sink $this$removeEntry_u24lambda_u240;
        if (entry.getLockingSnapshotCount() > 0 && ($this$removeEntry_u24lambda_u240 = this.journalWriter) != null) {
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u240, DIRTY, 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u240, " ", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u240, entry.getKey(), 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u240, "\n", 0, 0, 6, (Object) null);
            $this$removeEntry_u24lambda_u240.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            FileSystem fileSystem = this.fileSystem;
            Path path = entry.getCleanFiles().get(i2);
            Intrinsics.checkNotNullExpressionValue(path, "get(...)");
            fileSystem.delete(path, false);
            this.size -= entry.getLengths()[i2];
            entry.getLengths()[i2] = 0;
        }
        int i3 = this.operationsSinceRewrite;
        this.operationsSinceRewrite = i3 + 1;
        Sink $this$removeEntry_u24lambda_u241 = this.journalWriter;
        if ($this$removeEntry_u24lambda_u241 != null) {
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u241, REMOVE, 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u241, " ", 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u241, entry.getKey(), 0, 0, 6, (Object) null);
            Utf8Kt.writeString$default($this$removeEntry_u24lambda_u241, "\n", 0, 0, 6, (Object) null);
            $this$removeEntry_u24lambda_u241.flush();
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Entry[] entryArr;
        synchronized (this.lock) {
            if (this.initialized && !this.closed) {
                Collection $this$toTypedArray$iv = this.lruEntries.values();
                Intrinsics.checkNotNullExpressionValue($this$toTypedArray$iv, "<get-values>(...)");
                for (Entry entry : (Entry[]) $this$toTypedArray$iv.toArray(new Entry[0])) {
                    Intrinsics.checkNotNull(entry);
                    Editor currentEditor = entry.getCurrentEditor();
                    if (currentEditor != null) {
                        currentEditor.detach();
                    }
                }
                trimToSize();
                CoroutineScopeKt.cancel$default(this.cleanupScope, (CancellationException) null, 1, (Object) null);
                Sink sink = this.journalWriter;
                Intrinsics.checkNotNull(sink);
                sink.close();
                this.journalWriter = null;
                this.closed = true;
                Unit unit = Unit.INSTANCE;
                return;
            }
            this.closed = true;
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            if (this.initialized) {
                checkNotClosed();
                trimToSize();
                Sink sink = this.journalWriter;
                Intrinsics.checkNotNull(sink);
                sink.flush();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxByteSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            Entry toEvict = entry;
            if (!toEvict.getZombie()) {
                removeEntry(toEvict);
                return true;
            }
        }
        return false;
    }

    private final void delete() {
        close();
        FileIOKt.deleteRecursively(this.fileSystem, this.directory);
    }

    public final void evictAll() {
        Entry[] entryArr;
        synchronized (this.lock) {
            initialize();
            Collection $this$toTypedArray$iv = this.lruEntries.values();
            Intrinsics.checkNotNullExpressionValue($this$toTypedArray$iv, "<get-values>(...)");
            for (Entry entry : (Entry[]) $this$toTypedArray$iv.toArray(new Entry[0])) {
                Intrinsics.checkNotNull(entry);
                removeEntry(entry);
            }
            this.mostRecentTrimFailed = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void launchCleanup() {
        BuildersKt.launch$default(this.cleanupScope, (CoroutineContext) null, (CoroutineStart) null, new DiskLruCache$launchCleanup$1(this, null), 3, (Object) null);
    }

    private final void validateKey(String key) {
        if (!LEGAL_KEY_PATTERN.matches(key)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + key + "\"").toString());
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0005R\u0015\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "entry", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskLruCache;Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;)V", "getEntry", "()Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "closed", "", "file", "Lkotlinx/io/files/Path;", "index", "", "close", "", "closeAndEdit", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class Snapshot implements AutoCloseable {
        private boolean closed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache this$0, Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0 = this$0;
            this.entry = entry;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Path file(int index) {
            if (this.closed) {
                throw new IllegalStateException("snapshot is closed".toString());
            }
            Path path = this.entry.getCleanFiles().get(index);
            Intrinsics.checkNotNullExpressionValue(path, "get(...)");
            return path;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (!this.closed) {
                this.closed = true;
                Object obj = this.this$0.lock;
                DiskLruCache diskLruCache = this.this$0;
                synchronized (obj) {
                    Entry entry = this.entry;
                    entry.setLockingSnapshotCount(entry.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final Editor closeAndEdit() {
            Editor edit;
            Object obj = this.this$0.lock;
            DiskLruCache diskLruCache = this.this$0;
            synchronized (obj) {
                close();
                edit = diskLruCache.edit(this.entry.getKey());
            }
            return edit;
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\f\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\nH\u0002R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "", "entry", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskLruCache;Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;)V", "getEntry", "()Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "closed", "", "written", "", "getWritten", "()[Z", "file", "Lkotlinx/io/files/Path;", "index", "", "detach", "", "commit", "commitAndGet", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;", "abort", "complete", "success", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class Editor {
        private boolean closed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache this$0, Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0 = this$0;
            this.entry = entry;
            this.written = new boolean[this.this$0.valueCount];
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }

        public final Path file(int index) {
            Path path;
            Object obj = this.this$0.lock;
            DiskLruCache diskLruCache = this.this$0;
            synchronized (obj) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed".toString());
                }
                this.written[index] = true;
                Path path2 = this.entry.getDirtyFiles().get(index);
                Intrinsics.checkNotNullExpressionValue(path2, "get(...)");
                Path path3 = path2;
                FileSystem.-CC.sink$default(diskLruCache.fileSystem, path3, false, 2, (Object) null);
                path = path2;
            }
            return path;
        }

        public final void detach() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                this.entry.setZombie(true);
            }
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            Object obj = this.this$0.lock;
            DiskLruCache diskLruCache = this.this$0;
            synchronized (obj) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void abort() {
            complete(false);
        }

        private final void complete(boolean success) {
            Object obj = this.this$0.lock;
            DiskLruCache diskLruCache = this.this$0;
            synchronized (obj) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed".toString());
                }
                if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                    diskLruCache.completeEdit(this, success);
                }
                this.closed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200J\f\u00101\u001a\b\u0018\u000102R\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R \u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskLruCache$Entry;", "", "key", "", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskLruCache;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lengths", "", "getLengths", "()[J", "cleanFiles", "Ljava/util/ArrayList;", "Lkotlinx/io/files/Path;", "Lkotlin/collections/ArrayList;", "getCleanFiles", "()Ljava/util/ArrayList;", "dirtyFiles", "getDirtyFiles", "readable", "", "getReadable", "()Z", "setReadable", "(Z)V", "zombie", "getZombie", "setZombie", "currentEditor", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "getCurrentEditor", "()Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "setCurrentEditor", "(Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;)V", "lockingSnapshotCount", "", "getLockingSnapshotCount", "()I", "setLockingSnapshotCount", "(I)V", "setLengths", "", "strings", "", "writeLengths", "writer", "Lkotlinx/io/Sink;", "snapshot", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class Entry {
        private final ArrayList<Path> cleanFiles;
        private Editor currentEditor;
        private final ArrayList<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache this$0, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = this$0;
            this.key = key;
            this.lengths = new long[this.this$0.valueCount];
            this.cleanFiles = new ArrayList<>(this.this$0.valueCount);
            this.dirtyFiles = new ArrayList<>(this.this$0.valueCount);
            StringBuilder fileBuilder = new StringBuilder(this.key).append('.');
            int truncateTo = fileBuilder.length();
            int i = this.this$0.valueCount;
            for (int i2 = 0; i2 < i; i2++) {
                fileBuilder.append(i2);
                Path path = this.this$0.directory;
                String sb = fileBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                this.cleanFiles.add(PathsKt.Path(path, new String[]{sb}));
                fileBuilder.append(".tmp");
                Path path2 = this.this$0.directory;
                String sb2 = fileBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                this.dirtyFiles.add(PathsKt.Path(path2, new String[]{sb2}));
                fileBuilder.setLength(truncateTo);
            }
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final void setReadable(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setZombie(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final void setCurrentEditor(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final void setLockingSnapshotCount(int i) {
            this.lockingSnapshotCount = i;
        }

        public final void setLengths(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "strings");
            if (list.size() != this.this$0.valueCount) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.lengths[i] = Long.parseLong(list.get(i));
                }
            } catch (NumberFormatException e) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void writeLengths(Sink writer) {
            long[] jArr;
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long length : this.lengths) {
                Utf8Kt.writeString$default(writer, " ", 0, 0, 6, (Object) null);
                SinksKt.writeDecimalLong(writer, length);
            }
        }

        public final Snapshot snapshot() {
            if (this.readable && this.currentEditor == null && !this.zombie) {
                Iterable $this$forEachIndexed$iv = this.cleanFiles;
                DiskLruCache diskLruCache = this.this$0;
                int index = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = index + 1;
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Path file = (Path) item$iv;
                    if (!diskLruCache.fileSystem.exists(file)) {
                        try {
                            diskLruCache.removeEntry(this);
                        } catch (IOException e) {
                        }
                        return null;
                    }
                    index = index$iv;
                }
                this.lockingSnapshotCount++;
                return new Snapshot(this.this$0, this);
            }
            return null;
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskLruCache$Companion;", "", "<init>", "()V", "JOURNAL_FILE", "", "JOURNAL_FILE_TMP", "JOURNAL_FILE_BACKUP", "MAGIC", "VERSION", DiskLruCache.CLEAN, DiskLruCache.DIRTY, DiskLruCache.REMOVE, DiskLruCache.READ, "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}