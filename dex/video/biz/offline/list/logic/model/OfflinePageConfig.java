package video.biz.offline.list.logic.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.Config;

/* compiled from: OfflinePageState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "", "headerOperations", "", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "footerOperations", "maxConcurrent", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "getHeaderOperations", "()Ljava/util/List;", "getFooterOperations", "getMaxConcurrent", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePageConfig {
    public static final int $stable = 8;
    private final List<OfflinePageOperation> footerOperations;
    private final List<OfflinePageOperation> headerOperations;
    private final int maxConcurrent;

    public OfflinePageConfig() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflinePageConfig copy$default(OfflinePageConfig offlinePageConfig, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = offlinePageConfig.headerOperations;
        }
        if ((i2 & 2) != 0) {
            list2 = offlinePageConfig.footerOperations;
        }
        if ((i2 & 4) != 0) {
            i = offlinePageConfig.maxConcurrent;
        }
        return offlinePageConfig.copy(list, list2, i);
    }

    public final List<OfflinePageOperation> component1() {
        return this.headerOperations;
    }

    public final List<OfflinePageOperation> component2() {
        return this.footerOperations;
    }

    public final int component3() {
        return this.maxConcurrent;
    }

    public final OfflinePageConfig copy(List<? extends OfflinePageOperation> list, List<? extends OfflinePageOperation> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "headerOperations");
        Intrinsics.checkNotNullParameter(list2, "footerOperations");
        return new OfflinePageConfig(list, list2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflinePageConfig) {
            OfflinePageConfig offlinePageConfig = (OfflinePageConfig) obj;
            return Intrinsics.areEqual(this.headerOperations, offlinePageConfig.headerOperations) && Intrinsics.areEqual(this.footerOperations, offlinePageConfig.footerOperations) && this.maxConcurrent == offlinePageConfig.maxConcurrent;
        }
        return false;
    }

    public int hashCode() {
        return (((this.headerOperations.hashCode() * 31) + this.footerOperations.hashCode()) * 31) + this.maxConcurrent;
    }

    public String toString() {
        List<OfflinePageOperation> list = this.headerOperations;
        List<OfflinePageOperation> list2 = this.footerOperations;
        return "OfflinePageConfig(headerOperations=" + list + ", footerOperations=" + list2 + ", maxConcurrent=" + this.maxConcurrent + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfflinePageConfig(List<? extends OfflinePageOperation> list, List<? extends OfflinePageOperation> list2, int maxConcurrent) {
        Intrinsics.checkNotNullParameter(list, "headerOperations");
        Intrinsics.checkNotNullParameter(list2, "footerOperations");
        this.headerOperations = list;
        this.footerOperations = list2;
        this.maxConcurrent = maxConcurrent;
    }

    public /* synthetic */ OfflinePageConfig(List list, List list2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? Config.Companion.getMaxConcurrent() : i);
    }

    public final List<OfflinePageOperation> getHeaderOperations() {
        return this.headerOperations;
    }

    public final List<OfflinePageOperation> getFooterOperations() {
        return this.footerOperations;
    }

    public final int getMaxConcurrent() {
        return this.maxConcurrent;
    }
}