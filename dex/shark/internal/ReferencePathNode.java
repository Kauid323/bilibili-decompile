package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.GcRoot;
import shark.LibraryLeakReferenceMatcher;
import shark.internal.Reference;

/* compiled from: ReferencePathNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lshark/internal/ReferencePathNode;", "", "()V", "objectId", "", "getObjectId", "()J", "ChildNode", "RootNode", "Lshark/internal/ReferencePathNode$RootNode;", "Lshark/internal/ReferencePathNode$ChildNode;", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class ReferencePathNode {
    public abstract long getObjectId();

    private ReferencePathNode() {
    }

    public /* synthetic */ ReferencePathNode(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: ReferencePathNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lshark/internal/ReferencePathNode$RootNode;", "Lshark/internal/ReferencePathNode;", "()V", "gcRoot", "Lshark/GcRoot;", "getGcRoot", "()Lshark/GcRoot;", "objectId", "", "getObjectId", "()J", "LibraryLeakRootNode", "NormalRootNode", "Lshark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lshark/internal/ReferencePathNode$RootNode$NormalRootNode;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class RootNode extends ReferencePathNode {
        public abstract GcRoot getGcRoot();

        private RootNode() {
            super(null);
        }

        public /* synthetic */ RootNode(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Override // shark.internal.ReferencePathNode
        public long getObjectId() {
            return getGcRoot().getId();
        }

        /* compiled from: ReferencePathNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lshark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lshark/internal/ReferencePathNode$RootNode;", "gcRoot", "Lshark/GcRoot;", "matcher", "Lshark/LibraryLeakReferenceMatcher;", "(Lshark/GcRoot;Lshark/LibraryLeakReferenceMatcher;)V", "getGcRoot", "()Lshark/GcRoot;", "getMatcher", "()Lshark/LibraryLeakReferenceMatcher;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class LibraryLeakRootNode extends RootNode {
            private final GcRoot gcRoot;
            private final LibraryLeakReferenceMatcher matcher;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LibraryLeakRootNode(GcRoot gcRoot, LibraryLeakReferenceMatcher matcher) {
                super(null);
                Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
                Intrinsics.checkParameterIsNotNull(matcher, "matcher");
                this.gcRoot = gcRoot;
                this.matcher = matcher;
            }

            @Override // shark.internal.ReferencePathNode.RootNode
            public GcRoot getGcRoot() {
                return this.gcRoot;
            }

            public final LibraryLeakReferenceMatcher getMatcher() {
                return this.matcher;
            }
        }

        /* compiled from: ReferencePathNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lshark/internal/ReferencePathNode$RootNode$NormalRootNode;", "Lshark/internal/ReferencePathNode$RootNode;", "gcRoot", "Lshark/GcRoot;", "(Lshark/GcRoot;)V", "getGcRoot", "()Lshark/GcRoot;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class NormalRootNode extends RootNode {
            private final GcRoot gcRoot;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NormalRootNode(GcRoot gcRoot) {
                super(null);
                Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
                this.gcRoot = gcRoot;
            }

            @Override // shark.internal.ReferencePathNode.RootNode
            public GcRoot getGcRoot() {
                return this.gcRoot;
            }
        }
    }

    /* compiled from: ReferencePathNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lshark/internal/ReferencePathNode$ChildNode;", "Lshark/internal/ReferencePathNode;", "objectId", "", "parent", "lazyDetailsResolver", "Lshark/internal/Reference$LazyDetails$Resolver;", "(JLshark/internal/ReferencePathNode;Lshark/internal/Reference$LazyDetails$Resolver;)V", "getLazyDetailsResolver", "()Lshark/internal/Reference$LazyDetails$Resolver;", "getObjectId", "()J", "getParent", "()Lshark/internal/ReferencePathNode;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ChildNode extends ReferencePathNode {
        private final Reference.LazyDetails.Resolver lazyDetailsResolver;
        private final long objectId;
        private final ReferencePathNode parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildNode(long objectId, ReferencePathNode parent, Reference.LazyDetails.Resolver lazyDetailsResolver) {
            super(null);
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Intrinsics.checkParameterIsNotNull(lazyDetailsResolver, "lazyDetailsResolver");
            this.objectId = objectId;
            this.parent = parent;
            this.lazyDetailsResolver = lazyDetailsResolver;
        }

        @Override // shark.internal.ReferencePathNode
        public long getObjectId() {
            return this.objectId;
        }

        public final ReferencePathNode getParent() {
            return this.parent;
        }

        public final Reference.LazyDetails.Resolver getLazyDetailsResolver() {
            return this.lazyDetailsResolver;
        }
    }
}