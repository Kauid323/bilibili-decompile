package kntr.common.ouro.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import com.bilibili.droid.DimenUtilsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuoteBlockSpan.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016Jp\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkntr/common/ouro/ui/span/QuoteBlockSpan;", "Landroid/text/style/LeadingMarginSpan;", "startIndex", "", "endIndex", "isDarkTheme", "", "verticalLineStyle", "Lkntr/common/ouro/ui/span/QuoteBlockSpan$VerticalLineStyle;", "<init>", "(IIZLkntr/common/ouro/ui/span/QuoteBlockSpan$VerticalLineStyle;)V", "getLeadingMargin", "first", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "layout", "Landroid/text/Layout;", "VerticalLineStyle", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class QuoteBlockSpan implements LeadingMarginSpan {
    public static final int $stable = 0;
    private final int endIndex;
    private final boolean isDarkTheme;
    private final int startIndex;
    private final VerticalLineStyle verticalLineStyle;

    /* compiled from: QuoteBlockSpan.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/ui/span/QuoteBlockSpan$VerticalLineStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Rect", "RoundedRect", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum VerticalLineStyle {
        Rect,
        RoundedRect;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<VerticalLineStyle> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: QuoteBlockSpan.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerticalLineStyle.values().length];
            try {
                iArr[VerticalLineStyle.Rect.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VerticalLineStyle.RoundedRect.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public QuoteBlockSpan(int startIndex, int endIndex, boolean isDarkTheme, VerticalLineStyle verticalLineStyle) {
        Intrinsics.checkNotNullParameter(verticalLineStyle, "verticalLineStyle");
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.isDarkTheme = isDarkTheme;
        this.verticalLineStyle = verticalLineStyle;
    }

    public /* synthetic */ QuoteBlockSpan(int i, int i2, boolean z, VerticalLineStyle verticalLineStyle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? VerticalLineStyle.Rect : verticalLineStyle);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        boolean isEndLine = this.endIndex == end + 1;
        if (canvas == null || paint == null) {
            return;
        }
        if (start + 1 == end) {
            if ((text != null && text.charAt(start) == 8203) && isEndLine) {
                return;
            }
        }
        int originalColor = paint.getColor();
        float lineWidth = DimenUtilsKt.dpToPx(2.0f);
        paint.setColor(this.isDarkTheme ? OuroColor.Companion.getText4().getDarkColor() : OuroColor.Companion.getText4().getLightColor());
        switch (WhenMappings.$EnumSwitchMapping$0[this.verticalLineStyle.ordinal()]) {
            case 1:
                canvas.drawRect(1.0f, top, 1.0f + lineWidth, bottom, paint);
                break;
            case 2:
                boolean isStartLine = this.startIndex == start;
                float cornerSize = (isEndLine || isStartLine) ? DimenUtilsKt.dpToPx(1.0f) : 0.0f;
                canvas.drawRoundRect(1.0f, top, 1.0f + lineWidth, bottom, cornerSize, cornerSize, paint);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        paint.setColor(originalColor);
    }
}