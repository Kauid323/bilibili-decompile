package io.ktor.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Path.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0006\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\u0006¨\u0006\u0013"}, d2 = {"Ljava/io/File;", "", "relativePath", "combineSafe", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "normalizeAndRelativize", "(Ljava/io/File;)Ljava/io/File;", "dir", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "notRooted", "path", "", "dropLeadingTopDirs", "(Ljava/lang/String;)I", "", "", "isPathSeparator", "(C)Z", "isPathSeparatorOrDot", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathKt {
    public static final File combineSafe(File $this$combineSafe, String relativePath) {
        Intrinsics.checkNotNullParameter($this$combineSafe, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return combineSafe($this$combineSafe, new File(relativePath));
    }

    public static final File normalizeAndRelativize(File $this$normalizeAndRelativize) {
        Intrinsics.checkNotNullParameter($this$normalizeAndRelativize, "<this>");
        return dropLeadingTopDirs(notRooted(FilesKt.normalize($this$normalizeAndRelativize)));
    }

    private static final File combineSafe(File dir, File relativePath) {
        File normalized = normalizeAndRelativize(relativePath);
        if (FilesKt.startsWith(normalized, "..")) {
            throw new IllegalArgumentException("Bad relative path " + relativePath);
        }
        if (normalized.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        return new File(dir, normalized.getPath());
    }

    private static final File notRooted(File $this$notRooted) {
        String str;
        if (FilesKt.isRooted($this$notRooted)) {
            File current = $this$notRooted;
            while (true) {
                File parent = current.getParentFile();
                if (parent == null) {
                    break;
                }
                current = parent;
            }
            String path = $this$notRooted.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            String $this$dropWhile$iv = StringsKt.drop(path, current.getName().length());
            int index$iv = 0;
            int length = $this$dropWhile$iv.length();
            while (true) {
                if (index$iv < length) {
                    char it = $this$dropWhile$iv.charAt(index$iv);
                    if (it == '\\' || it == '/') {
                        index$iv++;
                    } else {
                        str = $this$dropWhile$iv.substring(index$iv);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                        break;
                    }
                } else {
                    str = "";
                    break;
                }
            }
            return new File(str);
        }
        return $this$notRooted;
    }

    public static final int dropLeadingTopDirs(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int startIndex = 0;
        int lastIndex = path.length() - 1;
        while (startIndex <= lastIndex) {
            char first = path.charAt(startIndex);
            if (isPathSeparator(first)) {
                startIndex++;
            } else if (first == '.') {
                if (startIndex == lastIndex) {
                    return startIndex + 1;
                }
                char second = path.charAt(startIndex + 1);
                int i = 2;
                if (!isPathSeparator(second)) {
                    if (second == '.') {
                        if (startIndex + 2 != path.length()) {
                            if (isPathSeparator(path.charAt(startIndex + 2))) {
                                i = 3;
                            } else {
                                return startIndex;
                            }
                        }
                    } else {
                        return startIndex;
                    }
                }
                startIndex += i;
            } else {
                return startIndex;
            }
        }
        return startIndex;
    }

    private static final boolean isPathSeparator(char $this$isPathSeparator) {
        return $this$isPathSeparator == '\\' || $this$isPathSeparator == '/';
    }

    private static final boolean isPathSeparatorOrDot(char $this$isPathSeparatorOrDot) {
        return $this$isPathSeparatorOrDot == '.' || isPathSeparator($this$isPathSeparatorOrDot);
    }

    private static final File dropLeadingTopDirs(File $this$dropLeadingTopDirs) {
        String path = $this$dropLeadingTopDirs.getPath();
        if (path == null) {
            path = "";
        }
        int startIndex = dropLeadingTopDirs(path);
        if (startIndex == 0) {
            return $this$dropLeadingTopDirs;
        }
        if (startIndex >= $this$dropLeadingTopDirs.getPath().length()) {
            return new File(".");
        }
        String path2 = $this$dropLeadingTopDirs.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        String substring = path2.substring(startIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return new File(substring);
    }
}