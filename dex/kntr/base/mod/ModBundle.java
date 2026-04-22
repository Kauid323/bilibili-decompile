package kntr.base.mod;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMod.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkntr/base/mod/ModBundle;", "", "pool", "", "mod", AppKey.VERSION, "", "filePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getPool", "()Ljava/lang/String;", "getMod", "getVersion", "()J", "getFilePath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ModBundle {
    private final String filePath;
    private final String mod;
    private final String pool;
    private final long version;

    public static /* synthetic */ ModBundle copy$default(ModBundle modBundle, String str, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modBundle.pool;
        }
        if ((i & 2) != 0) {
            str2 = modBundle.mod;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = modBundle.version;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = modBundle.filePath;
        }
        return modBundle.copy(str, str4, j2, str3);
    }

    public final String component1() {
        return this.pool;
    }

    public final String component2() {
        return this.mod;
    }

    public final long component3() {
        return this.version;
    }

    public final String component4() {
        return this.filePath;
    }

    public final ModBundle copy(String str, String str2, long j, String str3) {
        Intrinsics.checkNotNullParameter(str, "pool");
        Intrinsics.checkNotNullParameter(str2, "mod");
        Intrinsics.checkNotNullParameter(str3, "filePath");
        return new ModBundle(str, str2, j, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModBundle) {
            ModBundle modBundle = (ModBundle) obj;
            return Intrinsics.areEqual(this.pool, modBundle.pool) && Intrinsics.areEqual(this.mod, modBundle.mod) && this.version == modBundle.version && Intrinsics.areEqual(this.filePath, modBundle.filePath);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.pool.hashCode() * 31) + this.mod.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        String str = this.pool;
        String str2 = this.mod;
        long j = this.version;
        return "ModBundle(pool=" + str + ", mod=" + str2 + ", version=" + j + ", filePath=" + this.filePath + ")";
    }

    public ModBundle(String pool, String mod, long version, String filePath) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(mod, "mod");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.pool = pool;
        this.mod = mod;
        this.version = version;
        this.filePath = filePath;
    }

    public final String getPool() {
        return this.pool;
    }

    public final String getMod() {
        return this.mod;
    }

    public final long getVersion() {
        return this.version;
    }

    public final String getFilePath() {
        return this.filePath;
    }
}