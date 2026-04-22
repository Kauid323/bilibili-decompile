package tv.danmaku.bili.ui.garb.nft.helper;

import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplay;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayMark;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawItem;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

/* compiled from: DLCCardModelHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/helper/DLCCardModelHelper;", "", "<init>", "()V", "getDefaultImageUrl", "", "cardItem", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "getDefaultImageItem", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawItem;", "display", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardModelHelper {
    public static final int $stable = 0;
    public static final DLCCardModelHelper INSTANCE = new DLCCardModelHelper();

    private DLCCardModelHelper() {
    }

    public final String getDefaultImageUrl(BiliDLCCardItem cardItem) {
        CardTypeInfo cardTypeInfo;
        Integer valueOf = (cardItem == null || (cardTypeInfo = cardItem.getCardTypeInfo()) == null) ? null : Integer.valueOf(cardTypeInfo.getMaterialType());
        int type = NftType.IMAGE.getType();
        if (valueOf == null || valueOf.intValue() != type) {
            return (valueOf != null && valueOf.intValue() == NftType.VIDEO.getType()) ? cardItem.getCardTypeInfo().getContent().getAnimation().getAnimationBackupImage() : "";
        }
        String defaultImage = cardItem.getCardTypeInfo().getContent().getImage().getDefaultImage();
        return defaultImage == null ? "" : defaultImage;
    }

    public final DLCCardDrawItem getDefaultImageItem(BiliDLCCardItem cardItem, BiliDLCCardDisplay display) {
        CardTypeInfo cardTypeInfo;
        Intrinsics.checkNotNullParameter(display, "display");
        Integer valueOf = (cardItem == null || (cardTypeInfo = cardItem.getCardTypeInfo()) == null) ? null : Integer.valueOf(cardTypeInfo.getMaterialType());
        int type = NftType.IMAGE.getType();
        if (valueOf != null && valueOf.intValue() == type) {
            String defaultImage = cardItem.getCardTypeInfo().getContent().getImage().getDefaultImage();
            if (defaultImage == null) {
                defaultImage = "";
            }
            DLCTagModel tag = cardItem.getTag();
            String smeltTag = cardItem.getCardInfo().getWebCard().getSmeltTag();
            if (StringsKt.isBlank(smeltTag)) {
                smeltTag = display.getCornerMark().getImg();
            }
            return new DLCCardDrawItem(defaultImage, tag, BiliDLCCardDisplay.copy$default(display, new BiliDLCCardDisplayMark(smeltTag), null, 2, null));
        }
        int type2 = NftType.VIDEO.getType();
        if (valueOf == null || valueOf.intValue() != type2) {
            return null;
        }
        String animationBackupImage = cardItem.getCardTypeInfo().getContent().getAnimation().getAnimationBackupImage();
        DLCTagModel tag2 = cardItem.getTag();
        String smeltTag2 = cardItem.getCardInfo().getWebCard().getSmeltTag();
        if (StringsKt.isBlank(smeltTag2)) {
            smeltTag2 = display.getCornerMark().getImg();
        }
        return new DLCCardDrawItem(animationBackupImage, tag2, BiliDLCCardDisplay.copy$default(display, new BiliDLCCardDisplayMark(smeltTag2), null, 2, null));
    }
}