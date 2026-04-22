package kntr.app.deepsearch.ui.paragraph.constants;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.style.TextOverflow;
import com.bilibili.compose.theme.IBiliColors;
import kntr.app.deepsearch.ui.colors.DayNightColor;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphTextDrawParams.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;", RoomRecommendViewModel.EMPTY_CURSOR, "maxLines", RoomRecommendViewModel.EMPTY_CURSOR, "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "underlineColor", "Lkntr/app/deepsearch/ui/colors/DayNightColor;", "<init>", "(Ljava/lang/Integer;Landroidx/compose/ui/text/style/TextOverflow;Lkntr/app/deepsearch/ui/colors/DayNightColor;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOverflow-oLHJmLw", "()Landroidx/compose/ui/text/style/TextOverflow;", "getUnderlineColor", "()Lkntr/app/deepsearch/ui/colors/DayNightColor;", "component1", "component2", "component2-oLHJmLw", "component3", "copy", "copy-zxKtEsY", "(Ljava/lang/Integer;Landroidx/compose/ui/text/style/TextOverflow;Lkntr/app/deepsearch/ui/colors/DayNightColor;)Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ParagraphTextDrawParams {
    public static final int $stable = 0;
    private final Integer maxLines;
    private final TextOverflow overflow;
    private final DayNightColor underlineColor;

    public /* synthetic */ ParagraphTextDrawParams(Integer num, TextOverflow textOverflow, DayNightColor dayNightColor, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, textOverflow, dayNightColor);
    }

    /* renamed from: copy-zxKtEsY$default  reason: not valid java name */
    public static /* synthetic */ ParagraphTextDrawParams m775copyzxKtEsY$default(ParagraphTextDrawParams paragraphTextDrawParams, Integer num, TextOverflow textOverflow, DayNightColor dayNightColor, int i, Object obj) {
        if ((i & 1) != 0) {
            num = paragraphTextDrawParams.maxLines;
        }
        if ((i & 2) != 0) {
            textOverflow = paragraphTextDrawParams.overflow;
        }
        if ((i & 4) != 0) {
            dayNightColor = paragraphTextDrawParams.underlineColor;
        }
        return paragraphTextDrawParams.m777copyzxKtEsY(num, textOverflow, dayNightColor);
    }

    public final Integer component1() {
        return this.maxLines;
    }

    /* renamed from: component2-oLHJmLw  reason: not valid java name */
    public final TextOverflow m776component2oLHJmLw() {
        return this.overflow;
    }

    public final DayNightColor component3() {
        return this.underlineColor;
    }

    /* renamed from: copy-zxKtEsY  reason: not valid java name */
    public final ParagraphTextDrawParams m777copyzxKtEsY(Integer num, TextOverflow textOverflow, DayNightColor dayNightColor) {
        Intrinsics.checkNotNullParameter(dayNightColor, "underlineColor");
        return new ParagraphTextDrawParams(num, textOverflow, dayNightColor, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParagraphTextDrawParams) {
            ParagraphTextDrawParams paragraphTextDrawParams = (ParagraphTextDrawParams) obj;
            return Intrinsics.areEqual(this.maxLines, paragraphTextDrawParams.maxLines) && Intrinsics.areEqual(this.overflow, paragraphTextDrawParams.overflow) && Intrinsics.areEqual(this.underlineColor, paragraphTextDrawParams.underlineColor);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.maxLines == null ? 0 : this.maxLines.hashCode()) * 31) + (this.overflow != null ? TextOverflow.hashCode-impl(this.overflow.unbox-impl()) : 0)) * 31) + this.underlineColor.hashCode();
    }

    public String toString() {
        Integer num = this.maxLines;
        TextOverflow textOverflow = this.overflow;
        return "ParagraphTextDrawParams(maxLines=" + num + ", overflow=" + textOverflow + ", underlineColor=" + this.underlineColor + ")";
    }

    private ParagraphTextDrawParams(Integer maxLines, TextOverflow overflow, DayNightColor underlineColor) {
        Intrinsics.checkNotNullParameter(underlineColor, "underlineColor");
        this.maxLines = maxLines;
        this.overflow = overflow;
        this.underlineColor = underlineColor;
    }

    public /* synthetic */ ParagraphTextDrawParams(Integer num, TextOverflow textOverflow, DayNightColor dayNightColor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : textOverflow, (i & 4) != 0 ? new DayNightColor(new Function1<IBiliColors, Color>() { // from class: kntr.app.deepsearch.ui.paragraph.constants.ParagraphTextDrawParams.1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return Color.box-impl(m779invokevNxB06k((IBiliColors) p1));
            }

            /* renamed from: invoke-vNxB06k  reason: not valid java name */
            public final long m779invokevNxB06k(IBiliColors $this$DayNightColor) {
                Intrinsics.checkNotNullParameter($this$DayNightColor, "$this$DayNightColor");
                return $this$DayNightColor.getGa4-0d7_KjU();
            }
        }) : dayNightColor, null);
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: getOverflow-oLHJmLw  reason: not valid java name */
    public final TextOverflow m778getOverflowoLHJmLw() {
        return this.overflow;
    }

    public final DayNightColor getUnderlineColor() {
        return this.underlineColor;
    }
}