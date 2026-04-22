package tv.danmaku.bili.ui.garb.nft.view;

import android.content.Context;
import com.bilibili.droid.ScreenUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCMultiCardsView.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/FiveCardsLayoutHelper;", "Ltv/danmaku/bili/ui/garb/nft/view/MultiCardsLayoutHelper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "itemSpace", "", "cardHorizonVerticalRatio", "", "cardWidth", "cardHeight", "computeCardSize", "Lkotlin/Pair;", "totalWidth", "(Ljava/lang/Integer;)Lkotlin/Pair;", "getCardX", "cardNum", "getCardY", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FiveCardsLayoutHelper implements MultiCardsLayoutHelper {
    public static final int $stable = 8;
    private int cardHeight;
    private float cardHorizonVerticalRatio;
    private int cardWidth;
    private final Context context;
    private final int itemSpace;

    public FiveCardsLayoutHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.itemSpace = ScreenUtil.dip2px(this.context, 18.0f);
        this.cardHorizonVerticalRatio = 1.5f;
    }

    @Override // tv.danmaku.bili.ui.garb.nft.view.MultiCardsLayoutHelper
    public Pair<Integer, Integer> computeCardSize(Integer totalWidth) {
        int width = totalWidth != null ? totalWidth.intValue() : 0;
        if (totalWidth != null && totalWidth.intValue() == 0) {
            width = ScreenUtil.getScreenWidth(this.context);
        }
        this.cardWidth = (width - (this.itemSpace * 4)) / 3;
        this.cardHeight = (int) (this.cardWidth * this.cardHorizonVerticalRatio);
        return new Pair<>(Integer.valueOf(this.cardWidth), Integer.valueOf(this.cardHeight));
    }

    @Override // tv.danmaku.bili.ui.garb.nft.view.MultiCardsLayoutHelper
    public int getCardX(int cardNum) {
        int left;
        int remainCount = (cardNum - 1) / 3;
        int i = 0;
        if (remainCount == 0) {
            left = 0;
        } else {
            left = (this.cardWidth + this.itemSpace) / 2;
        }
        switch (cardNum % 3) {
            case 0:
                i = (this.cardWidth * 2) + (this.itemSpace * 3);
                break;
            case 1:
                i = this.cardWidth + (this.itemSpace * 2);
                break;
            case 2:
                i = this.itemSpace;
                break;
        }
        return i + left;
    }

    @Override // tv.danmaku.bili.ui.garb.nft.view.MultiCardsLayoutHelper
    public int getCardY(int cardNum) {
        int remainCount = (cardNum - 1) / 3;
        if (remainCount == 0) {
            return 0;
        }
        return this.cardHeight + this.itemSpace;
    }
}