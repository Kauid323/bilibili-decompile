package kntr.app.digital.backpack.pager;

import java.util.List;
import kntr.app.digital.backpack.card.CardModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoryModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/backpack/pager/CategoryModel;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "cards", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/card/CardModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getCards", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CategoryModel {
    public static final int $stable = 8;
    private final List<CardModel> cards;
    private final String title;

    public CategoryModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryModel copy$default(CategoryModel categoryModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryModel.title;
        }
        if ((i & 2) != 0) {
            list = categoryModel.cards;
        }
        return categoryModel.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<CardModel> component2() {
        return this.cards;
    }

    public final CategoryModel copy(String str, List<CardModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "cards");
        return new CategoryModel(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryModel) {
            CategoryModel categoryModel = (CategoryModel) obj;
            return Intrinsics.areEqual(this.title, categoryModel.title) && Intrinsics.areEqual(this.cards, categoryModel.cards);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.cards.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "CategoryModel(title=" + str + ", cards=" + this.cards + ")";
    }

    public CategoryModel(String title, List<CardModel> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "cards");
        this.title = title;
        this.cards = list;
    }

    public /* synthetic */ CategoryModel(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<CardModel> getCards() {
        return this.cards;
    }
}