package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ChatMediaSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0013\u0010\u0010\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0011\u0010\u0007R\u0013\u0010\u0012\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetDefaults;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "PeekHeight", "Landroidx/compose/ui/unit/Dp;", "getPeekHeight-D9Ej5fM", "()F", "F", "ScrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor-0d7_KjU", "()J", "ScrimColorAlpha", RoomRecommendViewModel.EMPTY_CURSOR, "getScrimColorAlpha", "sheetContentCornerShape", "getSheetContentCornerShape-D9Ej5fM", "paddingForTopAppBar", "getPaddingForTopAppBar-D9Ej5fM", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMediaSelectBottomSheetDefaults {
    public static final int $stable = 0;
    public static final ChatMediaSelectBottomSheetDefaults INSTANCE = new ChatMediaSelectBottomSheetDefaults();
    private static final float PeekHeight = Dp.constructor-impl(338);
    private static final float sheetContentCornerShape = Dp.constructor-impl(12);
    private static final float paddingForTopAppBar = Dp.constructor-impl(50);

    private ChatMediaSelectBottomSheetDefaults() {
    }

    /* renamed from: getPeekHeight-D9Ej5fM  reason: not valid java name */
    public final float m1919getPeekHeightD9Ej5fM() {
        return PeekHeight;
    }

    /* renamed from: getScrimColor-0d7_KjU  reason: not valid java name */
    public final long m1920getScrimColor0d7_KjU() {
        return Color.Companion.getBlack-0d7_KjU();
    }

    public final float getScrimColorAlpha() {
        return 0.8f;
    }

    /* renamed from: getSheetContentCornerShape-D9Ej5fM  reason: not valid java name */
    public final float m1921getSheetContentCornerShapeD9Ej5fM() {
        return sheetContentCornerShape;
    }

    /* renamed from: getPaddingForTopAppBar-D9Ej5fM  reason: not valid java name */
    public final float m1918getPaddingForTopAppBarD9Ej5fM() {
        return paddingForTopAppBar;
    }
}