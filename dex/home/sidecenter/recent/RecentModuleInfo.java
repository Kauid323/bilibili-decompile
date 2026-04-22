package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KModuleInfo;
import com.bapis.bilibili.app.home.v1.KMore;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lhome/sidecenter/recent/RecentModuleInfo;", "", "title", "", ContentDisposition.Parameters.Name, "icon", "url", "pos", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KModuleInfo;", "(Lcom/bapis/bilibili/app/home/v1/KModuleInfo;)V", "getTitle", "()Ljava/lang/String;", "getName", "getIcon", "getUrl", "getPos", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentModuleInfo {
    public static final int $stable = 0;
    private final String icon;
    private final String name;
    private final int pos;
    private final String title;
    private final String url;

    public static /* synthetic */ RecentModuleInfo copy$default(RecentModuleInfo recentModuleInfo, String str, String str2, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recentModuleInfo.title;
        }
        if ((i3 & 2) != 0) {
            str2 = recentModuleInfo.name;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = recentModuleInfo.icon;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = recentModuleInfo.url;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i2 = recentModuleInfo.pos;
        }
        return recentModuleInfo.copy(str, str5, str6, str7, i2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.url;
    }

    public final int component5() {
        return this.pos;
    }

    public final RecentModuleInfo copy(String str, String str2, String str3, String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str3, "icon");
        Intrinsics.checkNotNullParameter(str4, "url");
        return new RecentModuleInfo(str, str2, str3, str4, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentModuleInfo) {
            RecentModuleInfo recentModuleInfo = (RecentModuleInfo) obj;
            return Intrinsics.areEqual(this.title, recentModuleInfo.title) && Intrinsics.areEqual(this.name, recentModuleInfo.name) && Intrinsics.areEqual(this.icon, recentModuleInfo.icon) && Intrinsics.areEqual(this.url, recentModuleInfo.url) && this.pos == recentModuleInfo.pos;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.url.hashCode()) * 31) + this.pos;
    }

    public String toString() {
        String str = this.title;
        String str2 = this.name;
        String str3 = this.icon;
        String str4 = this.url;
        return "RecentModuleInfo(title=" + str + ", name=" + str2 + ", icon=" + str3 + ", url=" + str4 + ", pos=" + this.pos + ")";
    }

    public RecentModuleInfo(String title, String name, String icon, String url, int pos) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(url, "url");
        this.title = title;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.pos = pos;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getPos() {
        return this.pos;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentModuleInfo(KModuleInfo builder) {
        this(r2, r3, r4, (r0 == null || (r0 = r0.getUrl()) == null) ? "" : r0, (int) builder.getPos());
        String url;
        String icon;
        String name;
        Intrinsics.checkNotNullParameter(builder, "builder");
        String title = builder.getTitle();
        KMore more = builder.getMore();
        String str = (more == null || (name = more.getName()) == null) ? "" : name;
        KMore more2 = builder.getMore();
        String str2 = (more2 == null || (icon = more2.getIcon()) == null) ? "" : icon;
        KMore more3 = builder.getMore();
    }
}