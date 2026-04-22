package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.LibraryLeakReferenceMatcher;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: Reference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lshark/internal/Reference;", "", "valueObjectId", "", "isLowPriority", "", "lazyDetailsResolver", "Lshark/internal/Reference$LazyDetails$Resolver;", "(JZLshark/internal/Reference$LazyDetails$Resolver;)V", "()Z", "getLazyDetailsResolver", "()Lshark/internal/Reference$LazyDetails$Resolver;", "getValueObjectId", "()J", "LazyDetails", "shark"}, k = 1, mv = {1, 4, 1})
public final class Reference {
    private final boolean isLowPriority;
    private final LazyDetails.Resolver lazyDetailsResolver;
    private final long valueObjectId;

    public Reference(long valueObjectId, boolean isLowPriority, LazyDetails.Resolver lazyDetailsResolver) {
        Intrinsics.checkParameterIsNotNull(lazyDetailsResolver, "lazyDetailsResolver");
        this.valueObjectId = valueObjectId;
        this.isLowPriority = isLowPriority;
        this.lazyDetailsResolver = lazyDetailsResolver;
    }

    public final long getValueObjectId() {
        return this.valueObjectId;
    }

    public final boolean isLowPriority() {
        return this.isLowPriority;
    }

    public final LazyDetails.Resolver getLazyDetailsResolver() {
        return this.lazyDetailsResolver;
    }

    /* compiled from: Reference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0016B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lshark/internal/Reference$LazyDetails;", "", ChannelRoutes.CHANNEL_NAME, "", "locationClassObjectId", "", "locationType", "Lshark/internal/ReferenceLocationType;", "matchedLibraryLeak", "Lshark/LibraryLeakReferenceMatcher;", "isVirtual", "", "(Ljava/lang/String;JLshark/internal/ReferenceLocationType;Lshark/LibraryLeakReferenceMatcher;Z)V", "()Z", "getLocationClassObjectId", "()J", "getLocationType", "()Lshark/internal/ReferenceLocationType;", "getMatchedLibraryLeak", "()Lshark/LibraryLeakReferenceMatcher;", "getName", "()Ljava/lang/String;", "Resolver", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LazyDetails {
        private final boolean isVirtual;
        private final long locationClassObjectId;
        private final ReferenceLocationType locationType;
        private final LibraryLeakReferenceMatcher matchedLibraryLeak;
        private final String name;

        /* compiled from: Reference.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lshark/internal/Reference$LazyDetails$Resolver;", "", "resolve", "Lshark/internal/Reference$LazyDetails;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public interface Resolver {
            LazyDetails resolve();
        }

        public LazyDetails(String name, long locationClassObjectId, ReferenceLocationType locationType, LibraryLeakReferenceMatcher matchedLibraryLeak, boolean isVirtual) {
            Intrinsics.checkParameterIsNotNull(name, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkParameterIsNotNull(locationType, "locationType");
            this.name = name;
            this.locationClassObjectId = locationClassObjectId;
            this.locationType = locationType;
            this.matchedLibraryLeak = matchedLibraryLeak;
            this.isVirtual = isVirtual;
        }

        public final String getName() {
            return this.name;
        }

        public final long getLocationClassObjectId() {
            return this.locationClassObjectId;
        }

        public final ReferenceLocationType getLocationType() {
            return this.locationType;
        }

        public final LibraryLeakReferenceMatcher getMatchedLibraryLeak() {
            return this.matchedLibraryLeak;
        }

        public final boolean isVirtual() {
            return this.isVirtual;
        }
    }
}