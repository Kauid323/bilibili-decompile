package tv.danmaku.bili.ui.garb.nft.view;

import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.bili.BR;

/* compiled from: DLCMultiCardsView.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/MultiCardsLayoutHelper;", "", "computeCardSize", "Lkotlin/Pair;", "", "totalWidth", "(Ljava/lang/Integer;)Lkotlin/Pair;", "getCardX", "cardNum", "getCardY", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface MultiCardsLayoutHelper {
    Pair<Integer, Integer> computeCardSize(Integer num);

    int getCardX(int i);

    int getCardY(int i);

    /* compiled from: DLCMultiCardsView.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.nft.view.MultiCardsLayoutHelper$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Pair computeCardSize$default(MultiCardsLayoutHelper multiCardsLayoutHelper, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = null;
                }
                return multiCardsLayoutHelper.computeCardSize(num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeCardSize");
        }
    }
}