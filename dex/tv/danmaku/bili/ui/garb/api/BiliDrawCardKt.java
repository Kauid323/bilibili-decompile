package tv.danmaku.bili.ui.garb.api;

import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDrawCard.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getImgUrlWithType", "", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDrawCardKt {
    public static final String getImgUrlWithType(BiliDrawCard $this$getImgUrlWithType) {
        Content content;
        BiliNftImage image;
        Content content2;
        Animation animation;
        Intrinsics.checkNotNullParameter($this$getImgUrlWithType, "<this>");
        NftType.Companion companion = NftType.Companion;
        CardTypeInfo cardTypeInfo = $this$getImgUrlWithType.getCardTypeInfo();
        NftType type = companion.getType(cardTypeInfo != null ? cardTypeInfo.getMaterialType() : NftType.IMAGE.getType());
        if (type == NftType.VIDEO) {
            CardTypeInfo cardTypeInfo2 = $this$getImgUrlWithType.getCardTypeInfo();
            if (cardTypeInfo2 == null || (content2 = cardTypeInfo2.getContent()) == null || (animation = content2.getAnimation()) == null) {
                return null;
            }
            return animation.getAnimationBackupImage();
        }
        CardTypeInfo cardTypeInfo3 = $this$getImgUrlWithType.getCardTypeInfo();
        if (cardTypeInfo3 == null || (content = cardTypeInfo3.getContent()) == null || (image = content.getImage()) == null) {
            return null;
        }
        return image.getDefaultImage();
    }
}