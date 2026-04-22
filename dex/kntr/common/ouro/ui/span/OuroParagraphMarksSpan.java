package kntr.common.ouro.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.AlignmentSpan;
import android.text.style.LeadingMarginSpan;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroParagraphMarksSpan.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016Jp\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lkntr/common/ouro/ui/span/OuroParagraphMarksSpan;", "Landroid/text/style/AlignmentSpan;", "Landroid/text/style/LeadingMarginSpan;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "density", "", "extraIndent", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;FF)V", "firstLeadingMargin", "", "getFirstLeadingMargin", "()I", "firstLeadingMargin$delegate", "Lkotlin/Lazy;", "restLeadingMargin", "getRestLeadingMargin", "restLeadingMargin$delegate", "layoutAlignment", "Landroid/text/Layout$Alignment;", "getLayoutAlignment", "()Landroid/text/Layout$Alignment;", "layoutAlignment$delegate", "getAlignment", "getLeadingMargin", "first", "", "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", "p", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "layout", "Landroid/text/Layout;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroParagraphMarksSpan implements AlignmentSpan, LeadingMarginSpan {
    public static final int $stable = 8;
    private final Lazy firstLeadingMargin$delegate;
    private final Lazy layoutAlignment$delegate;
    private final OuroMarks<OuroParagraphMark> marks;
    private final Lazy restLeadingMargin$delegate;

    public OuroParagraphMarksSpan(OuroMarks<OuroParagraphMark> ouroMarks, final float density, final float extraIndent) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        this.marks = ouroMarks;
        this.firstLeadingMargin$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroParagraphMarksSpan$$ExternalSyntheticLambda0
            public final Object invoke() {
                int firstLeadingMargin_delegate$lambda$0;
                firstLeadingMargin_delegate$lambda$0 = OuroParagraphMarksSpan.firstLeadingMargin_delegate$lambda$0(extraIndent, this, density);
                return Integer.valueOf(firstLeadingMargin_delegate$lambda$0);
            }
        });
        this.restLeadingMargin$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroParagraphMarksSpan$$ExternalSyntheticLambda1
            public final Object invoke() {
                int restLeadingMargin_delegate$lambda$0;
                restLeadingMargin_delegate$lambda$0 = OuroParagraphMarksSpan.restLeadingMargin_delegate$lambda$0(extraIndent, this, density);
                return Integer.valueOf(restLeadingMargin_delegate$lambda$0);
            }
        });
        this.layoutAlignment$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroParagraphMarksSpan$$ExternalSyntheticLambda2
            public final Object invoke() {
                Layout.Alignment layoutAlignment_delegate$lambda$0;
                layoutAlignment_delegate$lambda$0 = OuroParagraphMarksSpan.layoutAlignment_delegate$lambda$0(OuroParagraphMarksSpan.this);
                return layoutAlignment_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ OuroParagraphMarksSpan(OuroMarks ouroMarks, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroMarks, f, (i & 4) != 0 ? 0.0f : f2);
    }

    private final int getFirstLeadingMargin() {
        return ((Number) this.firstLeadingMargin$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int firstLeadingMargin_delegate$lambda$0(float $extraIndent, OuroParagraphMarksSpan this$0, float $density) {
        OuroTextIndentMark ouroTextIndentMark = (OuroTextIndentMark) this$0.marks.get(OuroTextIndentMark.Key.INSTANCE);
        return (int) Math.ceil(((ouroTextIndentMark != null ? ouroTextIndentMark.getFirstLine() : 0.0f) + $extraIndent) * $density);
    }

    private final int getRestLeadingMargin() {
        return ((Number) this.restLeadingMargin$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int restLeadingMargin_delegate$lambda$0(float $extraIndent, OuroParagraphMarksSpan this$0, float $density) {
        OuroTextIndentMark ouroTextIndentMark = (OuroTextIndentMark) this$0.marks.get(OuroTextIndentMark.Key.INSTANCE);
        return (int) Math.ceil(((ouroTextIndentMark != null ? ouroTextIndentMark.getHanging() : 0.0f) + $extraIndent) * $density);
    }

    private final Layout.Alignment getLayoutAlignment() {
        return (Layout.Alignment) this.layoutAlignment$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Layout.Alignment layoutAlignment_delegate$lambda$0(OuroParagraphMarksSpan this$0) {
        OuroTextAlignMark ouroTextAlignMark = (OuroTextAlignMark) this$0.marks.get(OuroTextAlignMark.Key.INSTANCE);
        if (Intrinsics.areEqual(ouroTextAlignMark, OuroTextAlignStartMark.INSTANCE)) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (Intrinsics.areEqual(ouroTextAlignMark, OuroTextAlignCenterMark.INSTANCE)) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (Intrinsics.areEqual(ouroTextAlignMark, OuroTextAlignEndMark.INSTANCE)) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (!Intrinsics.areEqual(ouroTextAlignMark, OuroTextAlignJustifyMark.INSTANCE) && ouroTextAlignMark != null) {
            throw new NoWhenBranchMatchedException();
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    @Override // android.text.style.AlignmentSpan
    public Layout.Alignment getAlignment() {
        return getLayoutAlignment();
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return first ? getFirstLeadingMargin() : getRestLeadingMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
    }
}