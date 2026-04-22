package kntr.base.mod;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMod.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\b\t\n\u000b\f\rR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/base/mod/ModEvent;", "", "poolName", "", "getPoolName", "()Ljava/lang/String;", "modName", "getModName", "FetchEvent", "Initial", "Deleted", "Failure", "Succeed", "Progress", "Lkntr/base/mod/ModEvent$Deleted;", "Lkntr/base/mod/ModEvent$FetchEvent;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ModEvent {

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/base/mod/ModEvent$FetchEvent;", "Lkntr/base/mod/ModEvent;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface FetchEvent extends ModEvent {
    }

    String getModName();

    String getPoolName();

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/base/mod/ModEvent$Initial;", "Lkntr/base/mod/ModEvent$FetchEvent;", "poolName", "", "modName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Initial implements FetchEvent {
        private final String modName;
        private final String poolName;

        public static /* synthetic */ Initial copy$default(Initial initial, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initial.poolName;
            }
            if ((i & 2) != 0) {
                str2 = initial.modName;
            }
            return initial.copy(str, str2);
        }

        public final String component1() {
            return this.poolName;
        }

        public final String component2() {
            return this.modName;
        }

        public final Initial copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            return new Initial(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initial) {
                Initial initial = (Initial) obj;
                return Intrinsics.areEqual(this.poolName, initial.poolName) && Intrinsics.areEqual(this.modName, initial.modName);
            }
            return false;
        }

        public int hashCode() {
            return (this.poolName.hashCode() * 31) + this.modName.hashCode();
        }

        public String toString() {
            String str = this.poolName;
            return "Initial(poolName=" + str + ", modName=" + this.modName + ")";
        }

        public Initial(String poolName, String modName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            this.poolName = poolName;
            this.modName = modName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getPoolName() {
            return this.poolName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getModName() {
            return this.modName;
        }
    }

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/base/mod/ModEvent$Deleted;", "Lkntr/base/mod/ModEvent;", "poolName", "", "modName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Deleted implements ModEvent {
        private final String modName;
        private final String poolName;

        public static /* synthetic */ Deleted copy$default(Deleted deleted, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deleted.poolName;
            }
            if ((i & 2) != 0) {
                str2 = deleted.modName;
            }
            return deleted.copy(str, str2);
        }

        public final String component1() {
            return this.poolName;
        }

        public final String component2() {
            return this.modName;
        }

        public final Deleted copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            return new Deleted(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Deleted) {
                Deleted deleted = (Deleted) obj;
                return Intrinsics.areEqual(this.poolName, deleted.poolName) && Intrinsics.areEqual(this.modName, deleted.modName);
            }
            return false;
        }

        public int hashCode() {
            return (this.poolName.hashCode() * 31) + this.modName.hashCode();
        }

        public String toString() {
            String str = this.poolName;
            return "Deleted(poolName=" + str + ", modName=" + this.modName + ")";
        }

        public Deleted(String poolName, String modName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            this.poolName = poolName;
            this.modName = modName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getPoolName() {
            return this.poolName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getModName() {
            return this.modName;
        }
    }

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/base/mod/ModEvent$Failure;", "Lkntr/base/mod/ModEvent$FetchEvent;", "poolName", "", "modName", "throwable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Failure implements FetchEvent {
        private final String modName;
        private final String poolName;
        private final Throwable throwable;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.poolName;
            }
            if ((i & 2) != 0) {
                str2 = failure.modName;
            }
            if ((i & 4) != 0) {
                th = failure.throwable;
            }
            return failure.copy(str, str2, th);
        }

        public final String component1() {
            return this.poolName;
        }

        public final String component2() {
            return this.modName;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final Failure copy(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new Failure(str, str2, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.areEqual(this.poolName, failure.poolName) && Intrinsics.areEqual(this.modName, failure.modName) && Intrinsics.areEqual(this.throwable, failure.throwable);
            }
            return false;
        }

        public int hashCode() {
            return (((this.poolName.hashCode() * 31) + this.modName.hashCode()) * 31) + this.throwable.hashCode();
        }

        public String toString() {
            String str = this.poolName;
            String str2 = this.modName;
            return "Failure(poolName=" + str + ", modName=" + str2 + ", throwable=" + this.throwable + ")";
        }

        public Failure(String poolName, String modName, Throwable throwable) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.poolName = poolName;
            this.modName = modName;
            this.throwable = throwable;
        }

        @Override // kntr.base.mod.ModEvent
        public String getPoolName() {
            return this.poolName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getModName() {
            return this.modName;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/base/mod/ModEvent$Succeed;", "Lkntr/base/mod/ModEvent$FetchEvent;", "poolName", "", "modName", "resource", "Lkntr/base/mod/ModResource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/mod/ModResource;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getResource", "()Lkntr/base/mod/ModResource;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Succeed implements FetchEvent {
        private final String modName;
        private final String poolName;
        private final ModResource resource;

        public static /* synthetic */ Succeed copy$default(Succeed succeed, String str, String str2, ModResource modResource, int i, Object obj) {
            if ((i & 1) != 0) {
                str = succeed.poolName;
            }
            if ((i & 2) != 0) {
                str2 = succeed.modName;
            }
            if ((i & 4) != 0) {
                modResource = succeed.resource;
            }
            return succeed.copy(str, str2, modResource);
        }

        public final String component1() {
            return this.poolName;
        }

        public final String component2() {
            return this.modName;
        }

        public final ModResource component3() {
            return this.resource;
        }

        public final Succeed copy(String str, String str2, ModResource modResource) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            Intrinsics.checkNotNullParameter(modResource, "resource");
            return new Succeed(str, str2, modResource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Succeed) {
                Succeed succeed = (Succeed) obj;
                return Intrinsics.areEqual(this.poolName, succeed.poolName) && Intrinsics.areEqual(this.modName, succeed.modName) && Intrinsics.areEqual(this.resource, succeed.resource);
            }
            return false;
        }

        public int hashCode() {
            return (((this.poolName.hashCode() * 31) + this.modName.hashCode()) * 31) + this.resource.hashCode();
        }

        public String toString() {
            String str = this.poolName;
            String str2 = this.modName;
            return "Succeed(poolName=" + str + ", modName=" + str2 + ", resource=" + this.resource + ")";
        }

        public Succeed(String poolName, String modName, ModResource resource) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.poolName = poolName;
            this.modName = modName;
            this.resource = resource;
        }

        @Override // kntr.base.mod.ModEvent
        public String getPoolName() {
            return this.poolName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getModName() {
            return this.modName;
        }

        public final ModResource getResource() {
            return this.resource;
        }
    }

    /* compiled from: KMod.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lkntr/base/mod/ModEvent$Progress;", "Lkntr/base/mod/ModEvent$FetchEvent;", "poolName", "", "modName", "currentLength", "", "totalLength", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getCurrentLength", "()J", "getTotalLength", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Progress implements FetchEvent {
        private final long currentLength;
        private final String modName;
        private final String poolName;
        private final long totalLength;

        public static /* synthetic */ Progress copy$default(Progress progress, String str, String str2, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = progress.poolName;
            }
            if ((i & 2) != 0) {
                str2 = progress.modName;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                j = progress.currentLength;
            }
            long j3 = j;
            if ((i & 8) != 0) {
                j2 = progress.totalLength;
            }
            return progress.copy(str, str3, j3, j2);
        }

        public final String component1() {
            return this.poolName;
        }

        public final String component2() {
            return this.modName;
        }

        public final long component3() {
            return this.currentLength;
        }

        public final long component4() {
            return this.totalLength;
        }

        public final Progress copy(String str, String str2, long j, long j2) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            return new Progress(str, str2, j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Progress) {
                Progress progress = (Progress) obj;
                return Intrinsics.areEqual(this.poolName, progress.poolName) && Intrinsics.areEqual(this.modName, progress.modName) && this.currentLength == progress.currentLength && this.totalLength == progress.totalLength;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.poolName.hashCode() * 31) + this.modName.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.currentLength)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalLength);
        }

        public String toString() {
            String str = this.poolName;
            String str2 = this.modName;
            long j = this.currentLength;
            return "Progress(poolName=" + str + ", modName=" + str2 + ", currentLength=" + j + ", totalLength=" + this.totalLength + ")";
        }

        public Progress(String poolName, String modName, long currentLength, long totalLength) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            this.poolName = poolName;
            this.modName = modName;
            this.currentLength = currentLength;
            this.totalLength = totalLength;
        }

        @Override // kntr.base.mod.ModEvent
        public String getPoolName() {
            return this.poolName;
        }

        @Override // kntr.base.mod.ModEvent
        public String getModName() {
            return this.modName;
        }

        public final long getCurrentLength() {
            return this.currentLength;
        }

        public final long getTotalLength() {
            return this.totalLength;
        }
    }
}