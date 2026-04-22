package kotlinx.io.files;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystem;

/* compiled from: Paths.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\t*\u00020\u0001H\u0007¢\u0006\u0002\b\n\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0007¢\u0006\u0002\b\r\u001a\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¨\u0006\u0017"}, d2 = {"Path", "Lkotlinx/io/files/Path;", "base", "", "parts", "", "(Ljava/lang/String;[Ljava/lang/String;)Lkotlinx/io/files/Path;", "(Lkotlinx/io/files/Path;[Ljava/lang/String;)Lkotlinx/io/files/Path;", "source", "Lkotlinx/io/Source;", "sourceDeprecated", "sink", "Lkotlinx/io/Sink;", "sinkDeprecated", "removeTrailingSeparators", "path", "isWindows_", "", "isUnc", "removeTrailingSeparatorsUnix", "removeTrailingSeparatorsWindows", "suffixLength", "", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PathsKt {
    public static final Path Path(String base, String... parts) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(parts, "parts");
        StringBuilder $this$Path_u24lambda_u241 = new StringBuilder();
        $this$Path_u24lambda_u241.append(base);
        for (String str : parts) {
            if (($this$Path_u24lambda_u241.length() > 0) && !StringsKt.endsWith$default((CharSequence) $this$Path_u24lambda_u241, PathsJvmKt.SystemPathSeparator, false, 2, (Object) null)) {
                $this$Path_u24lambda_u241.append(PathsJvmKt.SystemPathSeparator);
            }
            $this$Path_u24lambda_u241.append(str);
        }
        return PathsJvmKt.Path($this$Path_u24lambda_u241.toString());
    }

    public static final Path Path(Path base, String... parts) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(parts, "parts");
        return Path(base.toString(), (String[]) Arrays.copyOf(parts, parts.length));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use FileSystem.source instead", replaceWith = @ReplaceWith(expression = "SystemFileSystem.source(this).buffered()", imports = {"kotlinx.io.files.FileSystem"}))
    public static final Source sourceDeprecated(Path $this$source) {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        return CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source($this$source));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use FileSystem.sink instead", replaceWith = @ReplaceWith(expression = "SystemFileSystem.sink(this).buffered()", imports = {"kotlinx.io.files.FileSystem"}))
    public static final Sink sinkDeprecated(Path $this$sink) {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return CoreKt.buffered(FileSystem.CC.sink$default(FileSystemJvmKt.SystemFileSystem, $this$sink, false, 2, null));
    }

    public static /* synthetic */ String removeTrailingSeparators$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = FileSystemJvmKt.isWindows();
        }
        return removeTrailingSeparators(str, z);
    }

    public static final String removeTrailingSeparators(String path, boolean isWindows_) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (isWindows_) {
            int i = 1;
            if (path.length() > 1) {
                if (path.charAt(1) == ':') {
                    i = 3;
                } else if (isUnc(path)) {
                    i = 2;
                }
            }
            int limit = i;
            return removeTrailingSeparatorsWindows(limit, path);
        }
        return removeTrailingSeparatorsUnix(path);
    }

    private static final boolean isUnc(String path) {
        if (path.length() < 2) {
            return false;
        }
        return StringsKt.startsWith$default(path, "\\\\", false, 2, (Object) null) || StringsKt.startsWith$default(path, "//", false, 2, (Object) null);
    }

    private static final String removeTrailingSeparatorsUnix(String path) {
        int idx = path.length();
        while (idx > 1 && path.charAt(idx - 1) == '/') {
            idx--;
        }
        String substring = path.substring(0, idx);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final String removeTrailingSeparatorsWindows(int suffixLength, String path) {
        if (!(suffixLength >= 1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int idx = path.length();
        while (idx > suffixLength) {
            char c = path.charAt(idx - 1);
            if (c != '\\' && c != '/') {
                break;
            }
            idx--;
        }
        String substring = path.substring(0, idx);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}