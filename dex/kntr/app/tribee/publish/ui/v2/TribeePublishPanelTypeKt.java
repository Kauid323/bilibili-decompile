package kntr.app.tribee.publish.ui.v2;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.preview.component.ToolbarItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishPanelType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toolbarItem", "Lkntr/common/ouro/preview/component/ToolbarItem;", "Lkntr/app/tribee/publish/ui/v2/TribeePublishPanelType;", "tribeePublishPanelType", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishPanelTypeKt {

    /* compiled from: TribeePublishPanelType.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TribeePublishPanelType.values().length];
            try {
                iArr[TribeePublishPanelType.ALBUM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TribeePublishPanelType.STICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TribeePublishPanelType.TEXT_STYLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TribeePublishPanelType.PARAGRAPH_STYLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ToolbarItem.values().length];
            try {
                iArr2[ToolbarItem.Album.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[ToolbarItem.Sticker.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[ToolbarItem.TextStyle.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[ToolbarItem.ParagraphStyle.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final ToolbarItem toolbarItem(TribeePublishPanelType $this$toolbarItem) {
        Intrinsics.checkNotNullParameter($this$toolbarItem, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toolbarItem.ordinal()]) {
            case 1:
                return ToolbarItem.Album;
            case 2:
                return ToolbarItem.Sticker;
            case 3:
                return ToolbarItem.TextStyle;
            case 4:
                return ToolbarItem.ParagraphStyle;
            default:
                return null;
        }
    }

    public static final TribeePublishPanelType tribeePublishPanelType(ToolbarItem $this$tribeePublishPanelType) {
        Intrinsics.checkNotNullParameter($this$tribeePublishPanelType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$tribeePublishPanelType.ordinal()]) {
            case 1:
                return TribeePublishPanelType.ALBUM;
            case 2:
                return TribeePublishPanelType.STICKER;
            case 3:
                return TribeePublishPanelType.TEXT_STYLE;
            case 4:
                return TribeePublishPanelType.PARAGRAPH_STYLE;
            default:
                return TribeePublishPanelType.NONE;
        }
    }
}