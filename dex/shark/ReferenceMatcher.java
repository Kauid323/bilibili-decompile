package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReferenceMatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lshark/ReferenceMatcher;", "", "()V", "pattern", "Lshark/ReferencePattern;", "getPattern", "()Lshark/ReferencePattern;", "Lshark/LibraryLeakReferenceMatcher;", "Lshark/IgnoredReferenceMatcher;", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class ReferenceMatcher {
    public abstract ReferencePattern getPattern();

    private ReferenceMatcher() {
    }

    public /* synthetic */ ReferenceMatcher(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}