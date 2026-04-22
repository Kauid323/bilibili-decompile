package kntr.app.digital.backpack.tab;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.backpack.pager.CategoryModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TabsModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/app/digital/backpack/tab/TabModel;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "categories", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/pager/CategoryModel;", "<init>", "(JLjava/lang/String;Ljava/util/List;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getCategories", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TabModel {
    public static final int $stable = 8;
    private final List<CategoryModel> categories;
    private final long id;
    private final String title;

    public TabModel() {
        this(0L, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabModel copy$default(TabModel tabModel, long j2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = tabModel.id;
        }
        if ((i & 2) != 0) {
            str = tabModel.title;
        }
        if ((i & 4) != 0) {
            list = tabModel.categories;
        }
        return tabModel.copy(j2, str, list);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final List<CategoryModel> component3() {
        return this.categories;
    }

    public final TabModel copy(long j2, String str, List<CategoryModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "categories");
        return new TabModel(j2, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TabModel) {
            TabModel tabModel = (TabModel) obj;
            return this.id == tabModel.id && Intrinsics.areEqual(this.title, tabModel.title) && Intrinsics.areEqual(this.categories, tabModel.categories);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.title.hashCode()) * 31) + this.categories.hashCode();
    }

    public String toString() {
        long j2 = this.id;
        String str = this.title;
        return "TabModel(id=" + j2 + ", title=" + str + ", categories=" + this.categories + ")";
    }

    public TabModel(long id, String title, List<CategoryModel> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "categories");
        this.id = id;
        this.title = title;
        this.categories = list;
    }

    public /* synthetic */ TabModel(long j2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<CategoryModel> getCategories() {
        return this.categories;
    }
}