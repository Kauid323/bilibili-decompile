package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.graphics.Color;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PopupBubbleMenu.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;", RoomRecommendViewModel.EMPTY_CURSOR, "containerColor", "Landroidx/compose/ui/graphics/Color;", "arrowLeftButtonContainerColor", "arrowRightButtonContainerColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getArrowLeftButtonContainerColor-0d7_KjU", "getArrowRightButtonContainerColor-0d7_KjU", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "copy", "copy-ysEtTa8", "(JJJ)Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleMenuColors {
    public static final int $stable = 0;
    private final long arrowLeftButtonContainerColor;
    private final long arrowRightButtonContainerColor;
    private final long containerColor;

    public /* synthetic */ PopupBubbleMenuColors(long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4);
    }

    private PopupBubbleMenuColors(long containerColor, long arrowLeftButtonContainerColor, long arrowRightButtonContainerColor) {
        this.containerColor = containerColor;
        this.arrowLeftButtonContainerColor = arrowLeftButtonContainerColor;
        this.arrowRightButtonContainerColor = arrowRightButtonContainerColor;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1960getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getArrowLeftButtonContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1958getArrowLeftButtonContainerColor0d7_KjU() {
        return this.arrowLeftButtonContainerColor;
    }

    /* renamed from: getArrowRightButtonContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1959getArrowRightButtonContainerColor0d7_KjU() {
        return this.arrowRightButtonContainerColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PopupBubbleMenuColors) {
            return Color.equals-impl0(this.containerColor, ((PopupBubbleMenuColors) other).containerColor) && Color.equals-impl0(this.arrowLeftButtonContainerColor, ((PopupBubbleMenuColors) other).arrowLeftButtonContainerColor) && Color.equals-impl0(this.arrowRightButtonContainerColor, ((PopupBubbleMenuColors) other).arrowRightButtonContainerColor);
        }
        return false;
    }

    public int hashCode() {
        int result = Color.hashCode-impl(this.containerColor);
        return (((result * 31) + Color.hashCode-impl(this.arrowLeftButtonContainerColor)) * 31) + Color.hashCode-impl(this.arrowRightButtonContainerColor);
    }

    /* renamed from: copy-ysEtTa8  reason: not valid java name */
    public final PopupBubbleMenuColors m1957copyysEtTa8(long j2, long j3, long j4) {
        return new PopupBubbleMenuColors(j2, j3, j4, null);
    }
}