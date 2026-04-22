package home.sidecenter.recent;

import BottomSheetItemData$;
import com.bapis.bilibili.app.home.v1.KIconItem;
import com.bapis.bilibili.app.home.v1.KRedDot;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003JQ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0019¨\u0006'"}, d2 = {"Lhome/sidecenter/recent/RecentIconItem;", "", "id", "", "icon", "url", ContentDisposition.Parameters.Name, "redDot", "Lhome/sidecenter/recent/RecentRedDot;", "fixed", "", "isChecked", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lhome/sidecenter/recent/RecentRedDot;ZZ)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KIconItem;", "(Lcom/bapis/bilibili/app/home/v1/KIconItem;)V", "getId", "()Ljava/lang/String;", "getIcon", "getUrl", "getName", "getRedDot", "()Lhome/sidecenter/recent/RecentRedDot;", "getFixed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentIconItem {
    public static final int $stable = 0;
    private final boolean fixed;
    private final String icon;
    private final String id;
    private final boolean isChecked;
    private final String name;
    private final RecentRedDot redDot;
    private final String url;

    public static /* synthetic */ RecentIconItem copy$default(RecentIconItem recentIconItem, String str, String str2, String str3, String str4, RecentRedDot recentRedDot, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recentIconItem.id;
        }
        if ((i2 & 2) != 0) {
            str2 = recentIconItem.icon;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = recentIconItem.url;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = recentIconItem.name;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            recentRedDot = recentIconItem.redDot;
        }
        RecentRedDot recentRedDot2 = recentRedDot;
        if ((i2 & 32) != 0) {
            z = recentIconItem.fixed;
        }
        boolean z3 = z;
        if ((i2 & 64) != 0) {
            z2 = recentIconItem.isChecked;
        }
        return recentIconItem.copy(str, str5, str6, str7, recentRedDot2, z3, z2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.name;
    }

    public final RecentRedDot component5() {
        return this.redDot;
    }

    public final boolean component6() {
        return this.fixed;
    }

    public final boolean component7() {
        return this.isChecked;
    }

    public final RecentIconItem copy(String str, String str2, String str3, String str4, RecentRedDot recentRedDot, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, ContentDisposition.Parameters.Name);
        return new RecentIconItem(str, str2, str3, str4, recentRedDot, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentIconItem) {
            RecentIconItem recentIconItem = (RecentIconItem) obj;
            return Intrinsics.areEqual(this.id, recentIconItem.id) && Intrinsics.areEqual(this.icon, recentIconItem.icon) && Intrinsics.areEqual(this.url, recentIconItem.url) && Intrinsics.areEqual(this.name, recentIconItem.name) && Intrinsics.areEqual(this.redDot, recentIconItem.redDot) && this.fixed == recentIconItem.fixed && this.isChecked == recentIconItem.isChecked;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.icon.hashCode()) * 31) + this.url.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.redDot == null ? 0 : this.redDot.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fixed)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.icon;
        String str3 = this.url;
        String str4 = this.name;
        RecentRedDot recentRedDot = this.redDot;
        boolean z = this.fixed;
        return "RecentIconItem(id=" + str + ", icon=" + str2 + ", url=" + str3 + ", name=" + str4 + ", redDot=" + recentRedDot + ", fixed=" + z + ", isChecked=" + this.isChecked + ")";
    }

    public RecentIconItem(String id, String icon, String url, String name, RecentRedDot redDot, boolean fixed, boolean isChecked) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        this.id = id;
        this.icon = icon;
        this.url = url;
        this.name = name;
        this.redDot = redDot;
        this.fixed = fixed;
        this.isChecked = isChecked;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RecentIconItem(String str, String str2, String str3, String str4, RecentRedDot recentRedDot, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, recentRedDot, z, r8);
        boolean z3;
        if ((i2 & 64) == 0) {
            z3 = z2;
        } else {
            z3 = true;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getName() {
        return this.name;
    }

    public final RecentRedDot getRedDot() {
        return this.redDot;
    }

    public final boolean getFixed() {
        return this.fixed;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentIconItem(KIconItem builder) {
        this(r2, r3, r4, r5, it != null ? new RecentRedDot(it) : null, builder.getFixure(), false, 64, null);
        Intrinsics.checkNotNullParameter(builder, "builder");
        String id = builder.getId();
        String icon = builder.getIcon();
        String url = builder.getUrl();
        String name = builder.getName();
        KRedDot it = builder.getRedDot();
    }
}