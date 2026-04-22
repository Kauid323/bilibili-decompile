package kntr.app.mall.product.details.page.ui.container;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkntr/app/mall/product/details/page/ui/container/ActionIconType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BACK", "SEARCH", "CART", "SHARE", "SHOP", "CUSTOMER", "LIKE", "ORDER", "UNKNOWN", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum ActionIconType {
    BACK(0),
    SEARCH(1),
    CART(2),
    SHARE(3),
    SHOP(4),
    CUSTOMER(5),
    LIKE(6),
    ORDER(7),
    UNKNOWN(-1);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ActionIconType> getEntries() {
        return $ENTRIES;
    }

    ActionIconType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}