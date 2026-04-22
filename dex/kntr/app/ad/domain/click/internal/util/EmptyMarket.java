package kntr.app.ad.domain.click.internal.util;

import kotlin.Metadata;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/EmptyMarket;", "Lkntr/app/ad/domain/click/internal/util/AbsMarket;", "<init>", "()V", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyMarket extends AbsMarket {
    public static final EmptyMarket INSTANCE = new EmptyMarket();

    private EmptyMarket() {
        super(new String[0]);
    }
}