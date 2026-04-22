package home.sidecenter.recent;

import home.sidecenter.recent.RecentContent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0007J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lhome/sidecenter/recent/RecentContentPool;", "T", "Lhome/sidecenter/recent/RecentContent;", "", "show", "", "cache", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getShow$annotations", "()V", "getShow", "()Ljava/util/List;", "getCache", "hasContent", "", "hasValidContent", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentContentPool<T extends RecentContent> {
    public static final int $stable = 8;
    private final List<T> cache;
    private final List<T> show;

    public RecentContentPool() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentContentPool copy$default(RecentContentPool recentContentPool, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = recentContentPool.show;
        }
        if ((i2 & 2) != 0) {
            list2 = recentContentPool.cache;
        }
        return recentContentPool.copy(list, list2);
    }

    public static /* synthetic */ void getShow$annotations() {
    }

    public final List<T> component1() {
        return this.show;
    }

    public final List<T> component2() {
        return this.cache;
    }

    public final RecentContentPool<T> copy(List<? extends T> list, List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list, "show");
        Intrinsics.checkNotNullParameter(list2, "cache");
        return new RecentContentPool<>(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentContentPool) {
            RecentContentPool recentContentPool = (RecentContentPool) obj;
            return Intrinsics.areEqual(this.show, recentContentPool.show) && Intrinsics.areEqual(this.cache, recentContentPool.cache);
        }
        return false;
    }

    public int hashCode() {
        return (this.show.hashCode() * 31) + this.cache.hashCode();
    }

    public String toString() {
        List<T> list = this.show;
        return "RecentContentPool(show=" + list + ", cache=" + this.cache + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecentContentPool(List<? extends T> list, List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list, "show");
        Intrinsics.checkNotNullParameter(list2, "cache");
        this.show = list;
        this.cache = list2;
    }

    public /* synthetic */ RecentContentPool(List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<T> getShow() {
        return this.show;
    }

    public final List<T> getCache() {
        return this.cache;
    }

    public final boolean hasContent() {
        return !this.show.isEmpty();
    }

    public final boolean hasValidContent() {
        Iterable $this$any$iv = this.show;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            RecentContent it = (RecentContent) element$iv;
            if (!it.getDeleted()) {
                return true;
            }
        }
        return false;
    }
}