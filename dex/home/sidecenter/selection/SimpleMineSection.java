package home.sidecenter.selection;

import com.bapis.bilibili.app.home.v1.KIconItem;
import com.bapis.bilibili.app.home.v1.KSimpleMineSection;
import home.sidecenter.recent.RecentIconItem;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSelection.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lhome/sidecenter/selection/SimpleMineSection;", "", "id", "", ContentDisposition.Parameters.Name, "items", "", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KSimpleMineSection;", "(Lcom/bapis/bilibili/app/home/v1/KSimpleMineSection;)V", "getId", "()Ljava/lang/String;", "getName", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleMineSection {
    public static final int $stable = 8;
    private final String id;
    private final List<RecentIconItem> items;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimpleMineSection copy$default(SimpleMineSection simpleMineSection, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = simpleMineSection.id;
        }
        if ((i2 & 2) != 0) {
            str2 = simpleMineSection.name;
        }
        if ((i2 & 4) != 0) {
            list = simpleMineSection.items;
        }
        return simpleMineSection.copy(str, str2, list);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final List<RecentIconItem> component3() {
        return this.items;
    }

    public final SimpleMineSection copy(String str, String str2, List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "items");
        return new SimpleMineSection(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleMineSection) {
            SimpleMineSection simpleMineSection = (SimpleMineSection) obj;
            return Intrinsics.areEqual(this.id, simpleMineSection.id) && Intrinsics.areEqual(this.name, simpleMineSection.name) && Intrinsics.areEqual(this.items, simpleMineSection.items);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        return "SimpleMineSection(id=" + str + ", name=" + str2 + ", items=" + this.items + ")";
    }

    public SimpleMineSection(String id, String name, List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "items");
        this.id = id;
        this.name = name;
        this.items = list;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<RecentIconItem> getItems() {
        return this.items;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleMineSection(KSimpleMineSection builder) {
        this(r0, r1, (List) destination$iv$iv);
        Intrinsics.checkNotNullParameter(builder, "builder");
        String id = builder.getId();
        String name = builder.getName();
        Iterable $this$map$iv = builder.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KIconItem it = (KIconItem) item$iv$iv;
            destination$iv$iv.add(new RecentIconItem(it));
        }
    }
}