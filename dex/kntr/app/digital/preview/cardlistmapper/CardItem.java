package kntr.app.digital.preview.cardlistmapper;

import kntr.app.digital.preview.card.CardBasic;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/cardlistmapper/CardItem;", "T", RoomRecommendViewModel.EMPTY_CURSOR, "basic", "Lkntr/app/digital/preview/card/CardBasic;", "data", "<init>", "(Lkntr/app/digital/preview/card/CardBasic;Ljava/lang/Object;)V", "getBasic", "()Lkntr/app/digital/preview/card/CardBasic;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lkntr/app/digital/preview/card/CardBasic;Ljava/lang/Object;)Lkntr/app/digital/preview/cardlistmapper/CardItem;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardItem<T> {
    public static final int $stable = 8;
    private final CardBasic basic;
    private final T data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardItem copy$default(CardItem cardItem, CardBasic cardBasic, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            cardBasic = cardItem.basic;
        }
        if ((i & 2) != 0) {
            obj = cardItem.data;
        }
        return cardItem.copy(cardBasic, obj);
    }

    public final CardBasic component1() {
        return this.basic;
    }

    public final T component2() {
        return this.data;
    }

    public final CardItem<T> copy(CardBasic cardBasic, T t) {
        Intrinsics.checkNotNullParameter(cardBasic, "basic");
        Intrinsics.checkNotNullParameter(t, "data");
        return new CardItem<>(cardBasic, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardItem) {
            CardItem cardItem = (CardItem) obj;
            return Intrinsics.areEqual(this.basic, cardItem.basic) && Intrinsics.areEqual(this.data, cardItem.data);
        }
        return false;
    }

    public int hashCode() {
        return (this.basic.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        CardBasic cardBasic = this.basic;
        return "CardItem(basic=" + cardBasic + ", data=" + this.data + ")";
    }

    public CardItem(CardBasic basic, T t) {
        Intrinsics.checkNotNullParameter(basic, "basic");
        Intrinsics.checkNotNullParameter(t, "data");
        this.basic = basic;
        this.data = t;
    }

    public final CardBasic getBasic() {
        return this.basic;
    }

    public final T getData() {
        return this.data;
    }
}