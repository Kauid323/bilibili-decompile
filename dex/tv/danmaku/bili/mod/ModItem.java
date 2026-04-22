package tv.danmaku.bili.mod;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: ModModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/mod/ModItem;", "", ChannelRoutes.CHANNEL_NAME, "", "version", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getVersion", "getSize", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModItem {
    public static final int $stable = 0;
    private final String name;
    private final long size;
    private final String version;

    public static /* synthetic */ ModItem copy$default(ModItem modItem, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modItem.name;
        }
        if ((i & 2) != 0) {
            str2 = modItem.version;
        }
        if ((i & 4) != 0) {
            j = modItem.size;
        }
        return modItem.copy(str, str2, j);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.version;
    }

    public final long component3() {
        return this.size;
    }

    public final ModItem copy(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(str2, "version");
        return new ModItem(str, str2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModItem) {
            ModItem modItem = (ModItem) obj;
            return Intrinsics.areEqual(this.name, modItem.name) && Intrinsics.areEqual(this.version, modItem.version) && this.size == modItem.size;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.size);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.version;
        return "ModItem(name=" + str + ", version=" + str2 + ", size=" + this.size + ")";
    }

    public ModItem(String name, String version, long size) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
        this.size = size;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getVersion() {
        return this.version;
    }
}