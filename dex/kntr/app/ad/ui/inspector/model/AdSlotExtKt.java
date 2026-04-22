package kntr.app.ad.ui.inspector.model;

import androidx.compose.ui.graphics.vector.ImageVector;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSlotExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lkntr/app/ad/common/model/AdSlot;", "getIcon", "(Lkntr/app/ad/common/model/AdSlot;)Landroidx/compose/ui/graphics/vector/ImageVector;", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdSlotExtKt {

    /* compiled from: AdSlotExt.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdSlot.values().length];
            try {
                iArr[AdSlot.PEGASUS_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AdSlot.PEGASUS_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AdSlot.STORY_FEED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AdSlot.DETAIL_UNDERFRAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AdSlot.DETAIL_RELATE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AdSlot.SEARCH_FEED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[AdSlot.LIVE_BIGCARD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[AdSlot.IAA.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ImageVector getIcon(AdSlot $this$icon) {
        Intrinsics.checkNotNullParameter($this$icon, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$icon.ordinal()]) {
            case 1:
                return AppIcons.AdSlotIcons.INSTANCE.getPegasus();
            case 2:
                return AppIcons.AdSlotIcons.INSTANCE.getPegasus();
            case 3:
                return AppIcons.AdSlotIcons.INSTANCE.getStory();
            case 4:
                return AppIcons.AdSlotIcons.INSTANCE.getUnderPlayer();
            case 5:
                return AppIcons.AdSlotIcons.INSTANCE.getRelate();
            case 6:
                return AppIcons.AdSlotIcons.INSTANCE.getSearch();
            case 7:
                return AppIcons.AdSlotIcons.INSTANCE.getLIVE_BRAND_CARD();
            case 8:
                return AppIcons.AdSlotIcons.INSTANCE.getIAA();
            default:
                return AppIcons.AdSlotIcons.INSTANCE.getUnknown();
        }
    }
}