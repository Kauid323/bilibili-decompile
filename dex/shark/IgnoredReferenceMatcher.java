package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferenceMatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lshark/IgnoredReferenceMatcher;", "Lshark/ReferenceMatcher;", "pattern", "Lshark/ReferencePattern;", "(Lshark/ReferencePattern;)V", "getPattern", "()Lshark/ReferencePattern;", "toString", "", "shark"}, k = 1, mv = {1, 4, 1})
public final class IgnoredReferenceMatcher extends ReferenceMatcher {
    private final ReferencePattern pattern;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoredReferenceMatcher(ReferencePattern pattern) {
        super(null);
        Intrinsics.checkParameterIsNotNull(pattern, "pattern");
        this.pattern = pattern;
    }

    @Override // shark.ReferenceMatcher
    public ReferencePattern getPattern() {
        return this.pattern;
    }

    public String toString() {
        return "ignored ref: " + getPattern();
    }
}