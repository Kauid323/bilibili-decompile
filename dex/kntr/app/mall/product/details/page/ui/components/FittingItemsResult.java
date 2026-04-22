package kntr.app.mall.product.details.page.ui.components;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.PriceDescVO;
import kntr.app.mall.product.details.page.api.model.TextColorModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MergeAtmospherePriceFloorComponent.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lkntr/app/mall/product/details/page/ui/components/FittingItemsResult;", "", "priceDescVOs", "", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "benefitInfos", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getPriceDescVOs", "()Ljava/util/List;", "getBenefitInfos", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FittingItemsResult {
    private final List<TextColorModel> benefitInfos;
    private final List<PriceDescVO> priceDescVOs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FittingItemsResult copy$default(FittingItemsResult fittingItemsResult, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fittingItemsResult.priceDescVOs;
        }
        if ((i & 2) != 0) {
            list2 = fittingItemsResult.benefitInfos;
        }
        return fittingItemsResult.copy(list, list2);
    }

    public final List<PriceDescVO> component1() {
        return this.priceDescVOs;
    }

    public final List<TextColorModel> component2() {
        return this.benefitInfos;
    }

    public final FittingItemsResult copy(List<PriceDescVO> list, List<TextColorModel> list2) {
        Intrinsics.checkNotNullParameter(list, "priceDescVOs");
        Intrinsics.checkNotNullParameter(list2, "benefitInfos");
        return new FittingItemsResult(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FittingItemsResult) {
            FittingItemsResult fittingItemsResult = (FittingItemsResult) obj;
            return Intrinsics.areEqual(this.priceDescVOs, fittingItemsResult.priceDescVOs) && Intrinsics.areEqual(this.benefitInfos, fittingItemsResult.benefitInfos);
        }
        return false;
    }

    public int hashCode() {
        return (this.priceDescVOs.hashCode() * 31) + this.benefitInfos.hashCode();
    }

    public String toString() {
        List<PriceDescVO> list = this.priceDescVOs;
        return "FittingItemsResult(priceDescVOs=" + list + ", benefitInfos=" + this.benefitInfos + ")";
    }

    public FittingItemsResult(List<PriceDescVO> list, List<TextColorModel> list2) {
        Intrinsics.checkNotNullParameter(list, "priceDescVOs");
        Intrinsics.checkNotNullParameter(list2, "benefitInfos");
        this.priceDescVOs = list;
        this.benefitInfos = list2;
    }

    public final List<PriceDescVO> getPriceDescVOs() {
        return this.priceDescVOs;
    }

    public final List<TextColorModel> getBenefitInfos() {
        return this.benefitInfos;
    }
}