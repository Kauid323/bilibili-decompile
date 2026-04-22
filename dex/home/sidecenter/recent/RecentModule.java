package home.sidecenter.recent;

import faceverify.q;
import home.sidecenter.recent.RecentContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lhome/sidecenter/recent/RecentModule;", "T", "Lhome/sidecenter/recent/RecentContent;", "", "info", "Lhome/sidecenter/recent/RecentModuleInfo;", q.KEY_RES_9_CONTENT, "Lhome/sidecenter/recent/RecentContentPool;", "moduleType", "Lhome/sidecenter/recent/ModuleType;", "<init>", "(Lhome/sidecenter/recent/RecentModuleInfo;Lhome/sidecenter/recent/RecentContentPool;Lhome/sidecenter/recent/ModuleType;)V", "getInfo", "()Lhome/sidecenter/recent/RecentModuleInfo;", "getContent", "()Lhome/sidecenter/recent/RecentContentPool;", "getModuleType", "()Lhome/sidecenter/recent/ModuleType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentModule<T extends RecentContent> {
    public static final int $stable = 8;
    private final RecentContentPool<T> content;
    private final RecentModuleInfo info;
    private final ModuleType moduleType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentModule copy$default(RecentModule recentModule, RecentModuleInfo recentModuleInfo, RecentContentPool recentContentPool, ModuleType moduleType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            recentModuleInfo = recentModule.info;
        }
        if ((i2 & 2) != 0) {
            recentContentPool = recentModule.content;
        }
        if ((i2 & 4) != 0) {
            moduleType = recentModule.moduleType;
        }
        return recentModule.copy(recentModuleInfo, recentContentPool, moduleType);
    }

    public final RecentModuleInfo component1() {
        return this.info;
    }

    public final RecentContentPool<T> component2() {
        return this.content;
    }

    public final ModuleType component3() {
        return this.moduleType;
    }

    public final RecentModule<T> copy(RecentModuleInfo recentModuleInfo, RecentContentPool<T> recentContentPool, ModuleType moduleType) {
        Intrinsics.checkNotNullParameter(moduleType, "moduleType");
        return new RecentModule<>(recentModuleInfo, recentContentPool, moduleType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentModule) {
            RecentModule recentModule = (RecentModule) obj;
            return Intrinsics.areEqual(this.info, recentModule.info) && Intrinsics.areEqual(this.content, recentModule.content) && this.moduleType == recentModule.moduleType;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.info == null ? 0 : this.info.hashCode()) * 31) + (this.content != null ? this.content.hashCode() : 0)) * 31) + this.moduleType.hashCode();
    }

    public String toString() {
        RecentModuleInfo recentModuleInfo = this.info;
        RecentContentPool<T> recentContentPool = this.content;
        return "RecentModule(info=" + recentModuleInfo + ", content=" + recentContentPool + ", moduleType=" + this.moduleType + ")";
    }

    public RecentModule(RecentModuleInfo info, RecentContentPool<T> recentContentPool, ModuleType moduleType) {
        Intrinsics.checkNotNullParameter(moduleType, "moduleType");
        this.info = info;
        this.content = recentContentPool;
        this.moduleType = moduleType;
    }

    public final RecentModuleInfo getInfo() {
        return this.info;
    }

    public final RecentContentPool<T> getContent() {
        return this.content;
    }

    public final ModuleType getModuleType() {
        return this.moduleType;
    }
}