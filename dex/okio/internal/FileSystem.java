package okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;

/* compiled from: FileSystem.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
public final class FileSystem {
    public static final FileMetadata commonMetadata(okio.FileSystem $this$commonMetadata, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonMetadata, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = $this$commonMetadata.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem $this$commonExists, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return $this$commonExists.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem $this$commonCreateDirectories, Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonCreateDirectories, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque directories = new ArrayDeque();
        for (Path path = dir; path != null && !$this$commonCreateDirectories.exists(path); path = path.parent()) {
            directories.addFirst(path);
        }
        if (mustCreate && directories.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator it = directories.iterator();
        while (it.hasNext()) {
            Path toCreate = (Path) it.next();
            $this$commonCreateDirectories.createDirectory(toCreate);
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem $this$commonDeleteRecursively, Path fileOrDirectory, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonDeleteRecursively, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Sequence sequence = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1($this$commonDeleteRecursively, fileOrDirectory, null));
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            Path toDelete = (Path) iterator.next();
            $this$commonDeleteRecursively.delete(toDelete, mustExist && !iterator.hasNext());
        }
    }

    public static final Sequence<Path> commonListRecursively(okio.FileSystem $this$commonListRecursively, Path dir, boolean followSymlinks) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonListRecursively, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new FileSystem$commonListRecursively$1(dir, $this$commonListRecursively, followSymlinks, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(SequenceScope<? super Path> sequenceScope, okio.FileSystem fileSystem, ArrayDeque<Path> arrayDeque, Path path, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        FileSystem$collectRecursively$1 fileSystem$collectRecursively$1;
        ArrayDeque stack;
        boolean followSymlinks;
        okio.FileSystem fileSystem2;
        Path path2;
        boolean postorder;
        SequenceScope $this$collectRecursively;
        List children;
        ArrayDeque stack2;
        SequenceScope $this$collectRecursively2;
        okio.FileSystem fileSystem3;
        Path path3;
        Iterator<Path> it;
        if (continuation instanceof FileSystem$collectRecursively$1) {
            fileSystem$collectRecursively$1 = (FileSystem$collectRecursively$1) continuation;
            if ((fileSystem$collectRecursively$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                fileSystem$collectRecursively$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result = fileSystem$collectRecursively$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileSystem$collectRecursively$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SequenceScope $this$collectRecursively3 = sequenceScope;
                        stack = arrayDeque;
                        followSymlinks = z;
                        fileSystem2 = fileSystem;
                        path2 = path;
                        postorder = z2;
                        $this$collectRecursively = $this$collectRecursively3;
                        if (!postorder) {
                            fileSystem$collectRecursively$1.L$0 = $this$collectRecursively3;
                            fileSystem$collectRecursively$1.L$1 = fileSystem2;
                            fileSystem$collectRecursively$1.L$2 = stack;
                            fileSystem$collectRecursively$1.L$3 = path2;
                            fileSystem$collectRecursively$1.Z$0 = followSymlinks;
                            fileSystem$collectRecursively$1.Z$1 = postorder;
                            fileSystem$collectRecursively$1.label = 1;
                            Object yield = $this$collectRecursively3.yield(path2, fileSystem$collectRecursively$1);
                            $this$collectRecursively = $this$collectRecursively3;
                            if (yield == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        children = fileSystem2.listOrNull(path2);
                        if (children == null) {
                            children = CollectionsKt.emptyList();
                        }
                        if (!children.isEmpty()) {
                            Path symlinkPath = path2;
                            int symlinkCount = 0;
                            while (true) {
                                if (followSymlinks && stack.contains(symlinkPath)) {
                                    throw new IOException("symlink cycle at " + path2);
                                }
                                Path symlinkTarget = symlinkTarget(fileSystem2, symlinkPath);
                                if (symlinkTarget != null) {
                                    symlinkPath = symlinkTarget;
                                    symlinkCount++;
                                } else if (followSymlinks || symlinkCount == 0) {
                                    stack.addLast(symlinkPath);
                                    try {
                                        Iterator<Path> it2 = children.iterator();
                                        $this$collectRecursively2 = $this$collectRecursively;
                                        fileSystem3 = fileSystem2;
                                        stack2 = stack;
                                        path3 = path2;
                                        it = it2;
                                        break;
                                    } catch (Throwable th) {
                                        th = th;
                                        stack2 = stack;
                                        stack2.removeLast();
                                        throw th;
                                    }
                                }
                            }
                        }
                        if (postorder) {
                            fileSystem$collectRecursively$1.L$0 = null;
                            fileSystem$collectRecursively$1.L$1 = null;
                            fileSystem$collectRecursively$1.L$2 = null;
                            fileSystem$collectRecursively$1.L$3 = null;
                            fileSystem$collectRecursively$1.L$4 = null;
                            fileSystem$collectRecursively$1.label = 3;
                            if ($this$collectRecursively.yield(path2, fileSystem$collectRecursively$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        postorder = fileSystem$collectRecursively$1.Z$1;
                        followSymlinks = fileSystem$collectRecursively$1.Z$0;
                        path2 = (Path) fileSystem$collectRecursively$1.L$3;
                        stack = (ArrayDeque) fileSystem$collectRecursively$1.L$2;
                        fileSystem2 = (okio.FileSystem) fileSystem$collectRecursively$1.L$1;
                        ResultKt.throwOnFailure($result);
                        $this$collectRecursively = (SequenceScope) fileSystem$collectRecursively$1.L$0;
                        children = fileSystem2.listOrNull(path2);
                        if (children == null) {
                        }
                        if (!children.isEmpty()) {
                        }
                        if (postorder) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        postorder = fileSystem$collectRecursively$1.Z$1;
                        followSymlinks = fileSystem$collectRecursively$1.Z$0;
                        it = (Iterator) fileSystem$collectRecursively$1.L$4;
                        path3 = (Path) fileSystem$collectRecursively$1.L$3;
                        stack2 = (ArrayDeque) fileSystem$collectRecursively$1.L$2;
                        fileSystem3 = (okio.FileSystem) fileSystem$collectRecursively$1.L$1;
                        $this$collectRecursively2 = (SequenceScope) fileSystem$collectRecursively$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            while (it.hasNext()) {
                                Path next = it.next();
                                boolean z3 = followSymlinks;
                                boolean z4 = postorder;
                                fileSystem$collectRecursively$1.L$0 = $this$collectRecursively2;
                                fileSystem$collectRecursively$1.L$1 = fileSystem3;
                                fileSystem$collectRecursively$1.L$2 = stack2;
                                fileSystem$collectRecursively$1.L$3 = path3;
                                fileSystem$collectRecursively$1.L$4 = it;
                                fileSystem$collectRecursively$1.Z$0 = followSymlinks;
                                fileSystem$collectRecursively$1.Z$1 = postorder;
                                fileSystem$collectRecursively$1.label = 2;
                                if (collectRecursively($this$collectRecursively2, fileSystem3, stack2, next, z3, z4, fileSystem$collectRecursively$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            stack2.removeLast();
                            path2 = path3;
                            $this$collectRecursively = $this$collectRecursively2;
                            if (postorder) {
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            stack2.removeLast();
                            throw th;
                        }
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileSystem$collectRecursively$1 = new FileSystem$collectRecursively$1(continuation);
        Object $result2 = fileSystem$collectRecursively$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileSystem$collectRecursively$1.label) {
        }
    }

    public static final Path symlinkTarget(okio.FileSystem $this$symlinkTarget, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$symlinkTarget, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path target = $this$symlinkTarget.metadata(path).getSymlinkTarget();
        if (target == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(target);
    }

    public static final void commonCopy(okio.FileSystem $this$commonCopy, Path source, Path target) throws IOException {
        Throwable thrown$iv;
        Object result$iv;
        Intrinsics.checkNotNullParameter($this$commonCopy, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Closeable $this$use$iv = $this$commonCopy.source(source);
        Object result$iv2 = null;
        Throwable thrown$iv2 = null;
        try {
            Source bytesIn = (Source) $this$use$iv;
            Closeable $this$use$iv2 = Okio.buffer($this$commonCopy.sink(target));
            thrown$iv = null;
            BufferedSink bytesOut = (BufferedSink) $this$use$iv2;
            result$iv = Long.valueOf(bytesOut.writeAll(bytesIn));
            if ($this$use$iv2 != null) {
                try {
                    $this$use$iv2.close();
                } catch (Throwable t$iv) {
                    thrown$iv = t$iv;
                }
            }
        } catch (Throwable t$iv2) {
            thrown$iv2 = t$iv2;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv2, t$iv3);
                }
            }
        }
        if (thrown$iv != null) {
            throw thrown$iv;
        }
        Intrinsics.checkNotNull(result$iv);
        result$iv2 = Long.valueOf(((Number) result$iv).longValue());
        if ($this$use$iv != null) {
            try {
                $this$use$iv.close();
            } catch (Throwable t$iv4) {
                thrown$iv2 = t$iv4;
            }
        }
        if (thrown$iv2 != null) {
            throw thrown$iv2;
        }
        Intrinsics.checkNotNull(result$iv2);
    }
}