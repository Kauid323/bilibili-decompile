package kntr.app.tribee.publish.ui.v2.utils;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelEvent;
import kntr.common.ouro.common.ui.toolPanel.TextStylePanelEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrackEventTransform.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toButtonType", "", "Lkntr/common/ouro/common/ui/toolPanel/TextStylePanelEvent;", "Lkntr/common/ouro/common/ui/toolPanel/ParagraphStylePanelEvent;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TrackEventTransformKt {

    /* compiled from: TrackEventTransform.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextStylePanelEvent.values().length];
            try {
                iArr[TextStylePanelEvent.H1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TextStylePanelEvent.H2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TextStylePanelEvent.H3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TextStylePanelEvent.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TextStylePanelEvent.BOLD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TextStylePanelEvent.ITALIC.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[TextStylePanelEvent.UNDERLINE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[TextStylePanelEvent.STRIKETHROUGH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[TextStylePanelEvent.FOREGROUND_COLOR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[TextStylePanelEvent.BACKGROUND_COLOR.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParagraphStylePanelEvent.values().length];
            try {
                iArr2[ParagraphStylePanelEvent.ALIGNMENT_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.ALIGNMENT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.ALIGNMENT_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.INCREASE_INDENT.ordinal()] = 4;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.DECREASE_INDENT.ordinal()] = 5;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.UNORDERED_LIST.ordinal()] = 6;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.ORDERED_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.QUOTE.ordinal()] = 8;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr2[ParagraphStylePanelEvent.DIVIDER.ordinal()] = 9;
            } catch (NoSuchFieldError e19) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String toButtonType(TextStylePanelEvent $this$toButtonType) {
        Intrinsics.checkNotNullParameter($this$toButtonType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toButtonType.ordinal()]) {
            case 1:
                return "h1";
            case 2:
                return "h2";
            case 3:
                return "h3";
            case 4:
                return "paragraph";
            case 5:
                return "bold";
            case 6:
                return "italic";
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return "underline";
            case 8:
                return "strikethrough";
            case ConstantsKt.SPACER_9 /* 9 */:
                return "text_color";
            case 10:
                return "background_color";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String toButtonType(ParagraphStylePanelEvent $this$toButtonType) {
        Intrinsics.checkNotNullParameter($this$toButtonType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$toButtonType.ordinal()]) {
            case 1:
                return "align_left";
            case 2:
                return "align_center";
            case 3:
                return "align_right";
            case 4:
                return "increase_indent";
            case 5:
                return "decrease_indent";
            case 6:
                return "bullet_list";
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return "ordered_list";
            case 8:
                return "quote";
            case ConstantsKt.SPACER_9 /* 9 */:
                return "divider";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}