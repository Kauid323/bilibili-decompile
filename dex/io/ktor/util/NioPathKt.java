package io.ktor.util;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NioPath.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0002\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "relativePath", "combineSafe", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "normalizeAndRelativize", "(Ljava/nio/file/Path;)Ljava/nio/file/Path;", "dropLeadingTopDirs", "Ljava/io/File;", "(Ljava/io/File;Ljava/nio/file/Path;)Ljava/io/File;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NioPathKt {
    public static final Path combineSafe(Path $this$combineSafe, Path relativePath) {
        Intrinsics.checkNotNullParameter($this$combineSafe, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Path normalized = normalizeAndRelativize(relativePath);
        if (normalized.startsWith("..")) {
            throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
        }
        if (normalized.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        Path resolve = $this$combineSafe.resolve(normalized);
        Intrinsics.checkNotNullExpressionValue(resolve, "resolve(...)");
        return resolve;
    }

    public static final Path normalizeAndRelativize(Path $this$normalizeAndRelativize) {
        Path relativize;
        Path normalize;
        Path dropLeadingTopDirs;
        Intrinsics.checkNotNullParameter($this$normalizeAndRelativize, "<this>");
        Path root = $this$normalizeAndRelativize.getRoot();
        if (root == null || (relativize = root.relativize($this$normalizeAndRelativize)) == null || (normalize = relativize.normalize()) == null || (dropLeadingTopDirs = dropLeadingTopDirs(normalize)) == null) {
            Path normalize2 = $this$normalizeAndRelativize.normalize();
            Intrinsics.checkNotNullExpressionValue(normalize2, "normalize(...)");
            return dropLeadingTopDirs(normalize2);
        }
        return dropLeadingTopDirs;
    }

    private static final Path dropLeadingTopDirs(Path $this$dropLeadingTopDirs) {
        Path $this$indexOfFirst$iv = $this$dropLeadingTopDirs;
        int index$iv = 0;
        Iterator it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (index$iv < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                Path it2 = (Path) item$iv;
                if (!Intrinsics.areEqual(it2.toString(), "..")) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int startIndex = index$iv;
        if (startIndex <= 0) {
            return $this$dropLeadingTopDirs;
        }
        Path subpath = $this$dropLeadingTopDirs.subpath(startIndex, $this$dropLeadingTopDirs.getNameCount());
        Intrinsics.checkNotNullExpressionValue(subpath, "subpath(...)");
        return subpath;
    }

    public static final File combineSafe(File $this$combineSafe, Path relativePath) {
        Intrinsics.checkNotNullParameter($this$combineSafe, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Path normalized = normalizeAndRelativize(relativePath);
        if (normalized.startsWith("..")) {
            throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
        }
        if (normalized.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        return new File($this$combineSafe, normalized.toString());
    }
}