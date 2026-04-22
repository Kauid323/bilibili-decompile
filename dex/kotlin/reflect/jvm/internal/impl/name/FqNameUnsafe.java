package kotlin.reflect.jvm.internal.impl.name;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* compiled from: FqNameUnsafe.kt */
public final class FqNameUnsafe {
    public static final Companion Companion = new Companion(null);
    private static final Name ROOT_NAME;
    private static final Pattern SPLIT_BY_DOTS;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    public /* synthetic */ FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fqNameUnsafe, name);
    }

    public FqNameUnsafe(String fqName, FqName safe) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(safe, "safe");
        this.fqName = fqName;
        this.safe = safe;
    }

    public FqNameUnsafe(String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqNameUnsafe(String fqName, FqNameUnsafe parent, Name shortName) {
        this.fqName = fqName;
        this.parent = parent;
        this.shortName = shortName;
    }

    private final void compute() {
        int lastDot = indexOfLastDotWithBackticksSupport(this.fqName);
        if (lastDot >= 0) {
            String substring = this.fqName.substring(lastDot + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            this.shortName = Name.guessByFirstCharacter(substring);
            String substring2 = this.fqName.substring(0, lastDot);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            this.parent = new FqNameUnsafe(substring2);
            return;
        }
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    private final int indexOfLastDotWithBackticksSupport(String fqName) {
        int index = fqName.length() - 1;
        boolean isBacktick = false;
        while (index >= 0) {
            char charAt = fqName.charAt(index);
            if (charAt == '.' && !isBacktick) {
                return index;
            }
            if (charAt == '`') {
                isBacktick = !isBacktick;
            } else if (charAt == '\\') {
                index--;
            }
            index--;
        }
        return -1;
    }

    public final String asString() {
        return this.fqName;
    }

    public final boolean isSafe() {
        return this.safe != null || StringsKt.indexOf$default((CharSequence) asString(), (char) Typography.less, 0, false, 6, (Object) null) < 0;
    }

    public final FqName toSafe() {
        FqName fqName = this.safe;
        if (fqName == null) {
            FqName it = new FqName(this);
            this.safe = it;
            return it;
        }
        return fqName;
    }

    public final boolean isRoot() {
        return this.fqName.length() == 0;
    }

    public final FqNameUnsafe parent() {
        FqNameUnsafe it = this.parent;
        if (it != null) {
            return it;
        }
        if (isRoot()) {
            throw new IllegalStateException("root".toString());
        }
        compute();
        FqNameUnsafe fqNameUnsafe = this.parent;
        Intrinsics.checkNotNull(fqNameUnsafe);
        return fqNameUnsafe;
    }

    public final FqNameUnsafe child(Name name) {
        String childFqName;
        Intrinsics.checkNotNullParameter(name, "name");
        if (isRoot()) {
            childFqName = name.asString();
        } else {
            childFqName = this.fqName + FilenameUtils.EXTENSION_SEPARATOR + name.asString();
        }
        Intrinsics.checkNotNull(childFqName);
        return new FqNameUnsafe(childFqName, this, name);
    }

    public final Name shortName() {
        Name it = this.shortName;
        if (it != null) {
            return it;
        }
        if (isRoot()) {
            throw new IllegalStateException("root".toString());
        }
        compute();
        Name name = this.shortName;
        Intrinsics.checkNotNull(name);
        return name;
    }

    public final Name shortNameOrSpecial() {
        if (isRoot()) {
            return ROOT_NAME;
        }
        return shortName();
    }

    private static final List<Name> pathSegments$collectSegmentsOf(FqNameUnsafe fqName) {
        if (fqName.isRoot()) {
            return new ArrayList();
        }
        List parentSegments = pathSegments$collectSegmentsOf(fqName.parent());
        parentSegments.add(fqName.shortName());
        return parentSegments;
    }

    public final List<Name> pathSegments() {
        return pathSegments$collectSegmentsOf(this);
    }

    public final boolean startsWith(Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (isRoot()) {
            return false;
        }
        int firstDot = StringsKt.indexOf$default((CharSequence) this.fqName, (char) FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
        int fqNameFirstSegmentLength = firstDot == -1 ? this.fqName.length() : firstDot;
        String segmentAsString = segment.asString();
        Intrinsics.checkNotNullExpressionValue(segmentAsString, "asString(...)");
        return fqNameFirstSegmentLength == segmentAsString.length() && StringsKt.regionMatches$default(this.fqName, 0, segmentAsString, 0, fqNameFirstSegmentLength, false, 16, (Object) null);
    }

    public String toString() {
        if (isRoot()) {
            String asString = ROOT_NAME.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }
        return this.fqName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FqNameUnsafe) && Intrinsics.areEqual(this.fqName, ((FqNameUnsafe) other).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    /* compiled from: FqNameUnsafe.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FqNameUnsafe topLevel(Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            String asString = shortName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return new FqNameUnsafe(asString, FqName.ROOT.toUnsafe(), shortName, null);
        }
    }

    static {
        Name special = Name.special("<root>");
        Intrinsics.checkNotNullExpressionValue(special, "special(...)");
        ROOT_NAME = special;
        Pattern compile = Pattern.compile("\\.");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        SPLIT_BY_DOTS = compile;
    }
}