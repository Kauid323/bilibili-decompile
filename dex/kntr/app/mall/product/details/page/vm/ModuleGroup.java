package kntr.app.mall.product.details.page.vm;

import java.util.List;
import kntr.app.mall.product.details.page.utils.UUID_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ModuleGroup;", "", "modules", "", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "id", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getModules", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ModuleGroup {
    public static final int $stable = 8;
    private final String id;
    private final List<ContentModule> modules;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModuleGroup copy$default(ModuleGroup moduleGroup, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = moduleGroup.modules;
        }
        if ((i & 2) != 0) {
            str = moduleGroup.id;
        }
        return moduleGroup.copy(list, str);
    }

    public final List<ContentModule> component1() {
        return this.modules;
    }

    public final String component2() {
        return this.id;
    }

    public final ModuleGroup copy(List<? extends ContentModule> list, String str) {
        Intrinsics.checkNotNullParameter(list, "modules");
        Intrinsics.checkNotNullParameter(str, "id");
        return new ModuleGroup(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModuleGroup) {
            ModuleGroup moduleGroup = (ModuleGroup) obj;
            return Intrinsics.areEqual(this.modules, moduleGroup.modules) && Intrinsics.areEqual(this.id, moduleGroup.id);
        }
        return false;
    }

    public int hashCode() {
        return (this.modules.hashCode() * 31) + this.id.hashCode();
    }

    public String toString() {
        List<ContentModule> list = this.modules;
        return "ModuleGroup(modules=" + list + ", id=" + this.id + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModuleGroup(List<? extends ContentModule> list, String id) {
        Intrinsics.checkNotNullParameter(list, "modules");
        Intrinsics.checkNotNullParameter(id, "id");
        this.modules = list;
        this.id = id;
    }

    public /* synthetic */ ModuleGroup(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? UUID_androidKt.generateUUID() : str);
    }

    public final List<ContentModule> getModules() {
        return this.modules;
    }

    public final String getId() {
        return this.id;
    }
}