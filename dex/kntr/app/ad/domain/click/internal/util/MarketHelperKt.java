package kntr.app.ad.domain.click.internal.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {MarketHelperKt.HUAWEI, RoomRecommendViewModel.EMPTY_CURSOR, MarketHelperKt.HONOR, "XIAOMI", MarketHelperKt.OPPO, "ONEPLUS", "REALME", "VIVO", "MEIZU", "SAMSUNG", "LENOVO", "SMARTISAN", "ZTE", "getSystemMarket", "Lkntr/app/ad/domain/click/internal/util/AbsMarket;", "brand", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MarketHelperKt {
    private static final String HONOR = "HONOR";
    private static final String HUAWEI = "HUAWEI";
    private static final String LENOVO = "lenovo";
    private static final String MEIZU = "Meizu";
    private static final String ONEPLUS = "OnePlus";
    private static final String OPPO = "OPPO";
    private static final String REALME = "realme";
    private static final String SAMSUNG = "samsung";
    private static final String SMARTISAN = "smartisan";
    private static final String VIVO = "vivo";
    private static final String XIAOMI = "Xiaomi";
    private static final String ZTE = "zte";

    public static final /* synthetic */ AbsMarket access$getSystemMarket(String brand) {
        return getSystemMarket(brand);
    }

    public static final AbsMarket getSystemMarket(String brand) {
        if (brand != null) {
            switch (brand.hashCode()) {
                case -1675632421:
                    if (brand.equals(XIAOMI)) {
                        return new XIAOMIMarket();
                    }
                    break;
                case -1443430368:
                    if (brand.equals(SMARTISAN)) {
                        return new SMARTISANMarket();
                    }
                    break;
                case -1106355917:
                    if (brand.equals(LENOVO)) {
                        return new LENOVOMarket();
                    }
                    break;
                case -934971466:
                    if (brand.equals(REALME)) {
                        return new REALMEMarket();
                    }
                    break;
                case 120939:
                    if (brand.equals(ZTE)) {
                        return new ZTEMarket();
                    }
                    break;
                case 2432928:
                    if (brand.equals(OPPO)) {
                        return new OPPOMarket();
                    }
                    break;
                case 3620012:
                    if (brand.equals(VIVO)) {
                        return new VIVOMarket();
                    }
                    break;
                case 68924490:
                    if (brand.equals(HONOR)) {
                        return new HONORMarket();
                    }
                    break;
                case 74224812:
                    if (brand.equals(MEIZU)) {
                        return new MEIZUMarket();
                    }
                    break;
                case 343319808:
                    if (brand.equals(ONEPLUS)) {
                        return new ONEPLUSMarket();
                    }
                    break;
                case 1864941562:
                    if (brand.equals(SAMSUNG)) {
                        return new SAMSUNGMarket();
                    }
                    break;
                case 2141820391:
                    if (brand.equals(HUAWEI)) {
                        return new HUWEIMarket();
                    }
                    break;
            }
        }
        return EmptyMarket.INSTANCE;
    }
}