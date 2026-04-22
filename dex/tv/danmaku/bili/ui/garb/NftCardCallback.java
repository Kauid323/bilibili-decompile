package tv.danmaku.bili.ui.garb;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: NftCardRecyclerView.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardCallback;", "", "onScrollStart", "", "onScrollEnd", "cardInfo", "Ltv/danmaku/bili/ui/garb/NftCardData;", "onCardLoadSuccess", "showCardInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface NftCardCallback {
    void onCardLoadSuccess(NftCardData nftCardData);

    void onScrollEnd(NftCardData nftCardData);

    void onScrollStart();

    void showCardInfo(NftCardData nftCardData);

    /* compiled from: NftCardRecyclerView.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.NftCardCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$onScrollStart(NftCardCallback _this) {
        }
    }
}