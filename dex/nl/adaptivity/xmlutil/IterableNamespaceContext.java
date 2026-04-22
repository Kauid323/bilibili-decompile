package nl.adaptivity.xmlutil;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* compiled from: NamespaceContext.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\u0011\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContextImpl;", "", "Lnl/adaptivity/xmlutil/Namespace;", "freeze", "plus", "secondary", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IterableNamespaceContext extends NamespaceContextImpl, Iterable<Namespace>, KMappedMarker {
    IterableNamespaceContext freeze();

    IterableNamespaceContext plus(IterableNamespaceContext iterableNamespaceContext);

    /* compiled from: NamespaceContext.kt */
    /* renamed from: nl.adaptivity.xmlutil.IterableNamespaceContext$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static IterableNamespaceContext $default$freeze(IterableNamespaceContext _this) {
            return new SimpleNamespaceContext(_this);
        }

        public static IterableNamespaceContext $default$plus(IterableNamespaceContext _this, IterableNamespaceContext secondary) {
            Intrinsics.checkNotNullParameter(secondary, "secondary");
            return new SimpleNamespaceContext((List<? extends Namespace>) SequencesKt.toList(SequencesKt.plus(CollectionsKt.asSequence(_this), CollectionsKt.asSequence(secondary))));
        }
    }

    /* compiled from: NamespaceContext.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static IterableNamespaceContext freeze(IterableNamespaceContext $this) {
            return CC.$default$freeze($this);
        }

        @Deprecated
        public static IterableNamespaceContext plus(IterableNamespaceContext $this, IterableNamespaceContext secondary) {
            Intrinsics.checkNotNullParameter(secondary, "secondary");
            return CC.$default$plus($this, secondary);
        }
    }
}