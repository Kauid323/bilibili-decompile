package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* compiled from: BinaryVersion.kt */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;
    private final int[] numbers;

    /* renamed from: patch  reason: collision with root package name */
    private final int f9patch;
    private final List<Integer> rest;

    public BinaryVersion(int... numbers) {
        List<Integer> emptyList;
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        Integer orNull = ArraysKt.getOrNull(this.numbers, 0);
        this.major = orNull != null ? orNull.intValue() : -1;
        Integer orNull2 = ArraysKt.getOrNull(this.numbers, 1);
        this.minor = orNull2 != null ? orNull2.intValue() : -1;
        Integer orNull3 = ArraysKt.getOrNull(this.numbers, 2);
        this.f9patch = orNull3 != null ? orNull3.intValue() : -1;
        if (this.numbers.length > 3) {
            if (this.numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + this.numbers.length + FilenameUtils.EXTENSION_SEPARATOR);
            }
            emptyList = CollectionsKt.toList(ArraysKt.asList(this.numbers).subList(3, this.numbers.length));
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.rest = emptyList;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCompatibleTo(BinaryVersion ourVersion) {
        Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        return this.major == 0 ? ourVersion.major == 0 && this.minor == ourVersion.minor : this.major == ourVersion.major && this.minor <= ourVersion.minor;
    }

    public final boolean isAtLeast(BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isAtLeast(version.major, version.minor, version.f9patch);
    }

    public final boolean isAtLeast(int major, int minor, int patch2) {
        if (this.major > major) {
            return true;
        }
        if (this.major < major) {
            return false;
        }
        if (this.minor > minor) {
            return true;
        }
        return this.minor >= minor && this.f9patch >= patch2;
    }

    public final boolean isAtMost(int major, int minor, int patch2) {
        if (this.major < major) {
            return true;
        }
        if (this.major > major) {
            return false;
        }
        if (this.minor < minor) {
            return true;
        }
        return this.minor <= minor && this.f9patch <= patch2;
    }

    public String toString() {
        int[] $this$takeWhile$iv = toArray();
        ArrayList list$iv = new ArrayList();
        int length = $this$takeWhile$iv.length;
        for (int i = 0; i < length; i++) {
            int item$iv = $this$takeWhile$iv[i];
            if (!(item$iv != -1)) {
                break;
            }
            list$iv.add(Integer.valueOf(item$iv));
        }
        ArrayList versions = list$iv;
        return versions.isEmpty() ? "unknown" : CollectionsKt.joinToString$default(versions, ".", null, null, 0, null, null, 62, null);
    }

    public boolean equals(Object other) {
        return other != null && Intrinsics.areEqual(getClass(), other.getClass()) && this.major == ((BinaryVersion) other).major && this.minor == ((BinaryVersion) other).minor && this.f9patch == ((BinaryVersion) other).f9patch && Intrinsics.areEqual(this.rest, ((BinaryVersion) other).rest);
    }

    public int hashCode() {
        int result = this.major;
        int result2 = result + (result * 31) + this.minor;
        int result3 = result2 + (result2 * 31) + this.f9patch;
        return result3 + (result3 * 31) + this.rest.hashCode();
    }

    /* compiled from: BinaryVersion.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}