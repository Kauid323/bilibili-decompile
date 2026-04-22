package kntr.common.ouro.ui.span;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroTextSpacingMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextMarksSpan.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0003J\u0010\u00107\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00108\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00109\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010:\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010<\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010=\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0014\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001a\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001b\u0010\u000fR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b+\u0010$R\u001d\u0010-\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b.\u0010$R\u001d\u00100\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b1\u0010 ¨\u0006>"}, d2 = {"Lkntr/common/ouro/ui/span/OuroTextMarksSpan;", "Landroid/text/style/MetricAffectingSpan;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "density", "", "foregroundColorAlpha", "backgroundColorAlpha", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;Lcom/bilibili/compose/theme/ThemeDayNight;FFF)V", "isMedium", "", "()Z", "isMedium$delegate", "Lkotlin/Lazy;", "isSemiBold", "isSemiBold$delegate", "isItalic", "isItalic$delegate", "isUnderline", "isUnderline$delegate", "isStrikethrough", "isStrikethrough$delegate", "hasBackgroundColor", "getHasBackgroundColor", "hasBackgroundColor$delegate", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/Integer;", "backgroundColor$delegate", "backgroundColorHeightPx", "getBackgroundColorHeightPx", "()Ljava/lang/Float;", "backgroundColorHeightPx$delegate", "typefaceStyle", "getTypefaceStyle", "()I", "typefaceStyle$delegate", "fontSizePx", "getFontSizePx", "fontSizePx$delegate", "textSpacingEm", "getTextSpacingEm", "textSpacingEm$delegate", "foregroundColor", "getForegroundColor", "foregroundColor$delegate", "applyTypefaceStyle", "", "tp", "Landroid/text/TextPaint;", "applyUnderline", "applyStrikethrough", "applyFontSize", "applyTextSpacing", "applyForegroundColor", "updateMeasureState", "updateDrawState", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextMarksSpan extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final Lazy backgroundColor$delegate;
    private final Lazy backgroundColorHeightPx$delegate;
    private final Lazy fontSizePx$delegate;
    private final Lazy foregroundColor$delegate;
    private final Lazy hasBackgroundColor$delegate;
    private final Lazy isItalic$delegate;
    private final Lazy isMedium$delegate;
    private final Lazy isSemiBold$delegate;
    private final Lazy isStrikethrough$delegate;
    private final Lazy isUnderline$delegate;
    private final OuroMarks<OuroTextMark> marks;
    private final Lazy textSpacingEm$delegate;
    private final Lazy typefaceStyle$delegate;

    public OuroTextMarksSpan(OuroMarks<OuroTextMark> ouroMarks, final ThemeDayNight theme, final float density, final float foregroundColorAlpha, final float backgroundColorAlpha) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.marks = ouroMarks;
        this.isMedium$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean isMedium_delegate$lambda$0;
                isMedium_delegate$lambda$0 = OuroTextMarksSpan.isMedium_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(isMedium_delegate$lambda$0);
            }
        });
        this.isSemiBold$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda5
            public final Object invoke() {
                boolean isSemiBold_delegate$lambda$0;
                isSemiBold_delegate$lambda$0 = OuroTextMarksSpan.isSemiBold_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(isSemiBold_delegate$lambda$0);
            }
        });
        this.isItalic$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda6
            public final Object invoke() {
                boolean isItalic_delegate$lambda$0;
                isItalic_delegate$lambda$0 = OuroTextMarksSpan.isItalic_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(isItalic_delegate$lambda$0);
            }
        });
        this.isUnderline$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda7
            public final Object invoke() {
                boolean isUnderline_delegate$lambda$0;
                isUnderline_delegate$lambda$0 = OuroTextMarksSpan.isUnderline_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(isUnderline_delegate$lambda$0);
            }
        });
        this.isStrikethrough$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda8
            public final Object invoke() {
                boolean isStrikethrough_delegate$lambda$0;
                isStrikethrough_delegate$lambda$0 = OuroTextMarksSpan.isStrikethrough_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(isStrikethrough_delegate$lambda$0);
            }
        });
        this.hasBackgroundColor$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda9
            public final Object invoke() {
                boolean hasBackgroundColor_delegate$lambda$0;
                hasBackgroundColor_delegate$lambda$0 = OuroTextMarksSpan.hasBackgroundColor_delegate$lambda$0(OuroTextMarksSpan.this);
                return Boolean.valueOf(hasBackgroundColor_delegate$lambda$0);
            }
        });
        this.backgroundColor$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda10
            public final Object invoke() {
                Integer backgroundColor_delegate$lambda$0;
                backgroundColor_delegate$lambda$0 = OuroTextMarksSpan.backgroundColor_delegate$lambda$0(OuroTextMarksSpan.this, theme, backgroundColorAlpha);
                return backgroundColor_delegate$lambda$0;
            }
        });
        this.backgroundColorHeightPx$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda11
            public final Object invoke() {
                Float backgroundColorHeightPx_delegate$lambda$0;
                backgroundColorHeightPx_delegate$lambda$0 = OuroTextMarksSpan.backgroundColorHeightPx_delegate$lambda$0(OuroTextMarksSpan.this, density);
                return backgroundColorHeightPx_delegate$lambda$0;
            }
        });
        this.typefaceStyle$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda1
            public final Object invoke() {
                int typefaceStyle_delegate$lambda$0;
                typefaceStyle_delegate$lambda$0 = OuroTextMarksSpan.typefaceStyle_delegate$lambda$0(OuroTextMarksSpan.this);
                return Integer.valueOf(typefaceStyle_delegate$lambda$0);
            }
        });
        this.fontSizePx$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda2
            public final Object invoke() {
                Float fontSizePx_delegate$lambda$0;
                fontSizePx_delegate$lambda$0 = OuroTextMarksSpan.fontSizePx_delegate$lambda$0(OuroTextMarksSpan.this, density);
                return fontSizePx_delegate$lambda$0;
            }
        });
        this.textSpacingEm$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda3
            public final Object invoke() {
                Float textSpacingEm_delegate$lambda$0;
                textSpacingEm_delegate$lambda$0 = OuroTextMarksSpan.textSpacingEm_delegate$lambda$0(OuroTextMarksSpan.this);
                return textSpacingEm_delegate$lambda$0;
            }
        });
        this.foregroundColor$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroTextMarksSpan$$ExternalSyntheticLambda4
            public final Object invoke() {
                Integer foregroundColor_delegate$lambda$0;
                foregroundColor_delegate$lambda$0 = OuroTextMarksSpan.foregroundColor_delegate$lambda$0(OuroTextMarksSpan.this, theme, foregroundColorAlpha);
                return foregroundColor_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OuroTextMarksSpan(OuroMarks ouroMarks, ThemeDayNight themeDayNight, float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroMarks, themeDayNight, f, r5, r6);
        float f4;
        float f5;
        if ((i & 8) == 0) {
            f4 = f2;
        } else {
            f4 = 1.0f;
        }
        if ((i & 16) == 0) {
            f5 = f3;
        } else {
            f5 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMedium_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.contains((Object) OuroMediumMark.INSTANCE);
    }

    public final boolean isMedium() {
        return ((Boolean) this.isMedium$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSemiBold_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.contains((Object) OuroSemiBoldMark.INSTANCE);
    }

    public final boolean isSemiBold() {
        return ((Boolean) this.isSemiBold$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isItalic_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.contains((Object) OuroItalicMark.INSTANCE);
    }

    public final boolean isItalic() {
        return ((Boolean) this.isItalic$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isUnderline_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.contains((Object) OuroUnderlineMark.INSTANCE);
    }

    public final boolean isUnderline() {
        return ((Boolean) this.isUnderline$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isStrikethrough_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.contains((Object) OuroStrikethroughMark.INSTANCE);
    }

    public final boolean isStrikethrough() {
        return ((Boolean) this.isStrikethrough$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasBackgroundColor_delegate$lambda$0(OuroTextMarksSpan this$0) {
        return this$0.marks.get(OuroBackgroundColorMark.Key.INSTANCE) != null;
    }

    public final boolean getHasBackgroundColor() {
        return ((Boolean) this.hasBackgroundColor$delegate.getValue()).booleanValue();
    }

    public final Integer getBackgroundColor() {
        return (Integer) this.backgroundColor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer backgroundColor_delegate$lambda$0(OuroTextMarksSpan this$0, ThemeDayNight $theme, float $backgroundColorAlpha) {
        OuroColor color;
        OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) this$0.marks.get(OuroBackgroundColorMark.Key.INSTANCE);
        if (ouroBackgroundColorMark == null || (color = ouroBackgroundColorMark.getColor()) == null) {
            return null;
        }
        return Integer.valueOf(OuroTextMarksSpanKt.fade(color.colorForTheme($theme), $backgroundColorAlpha));
    }

    public final Float getBackgroundColorHeightPx() {
        return (Float) this.backgroundColorHeightPx$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float backgroundColorHeightPx_delegate$lambda$0(OuroTextMarksSpan this$0, float $density) {
        if (((OuroBackgroundColorMark) this$0.marks.get(OuroBackgroundColorMark.Key.INSTANCE)) != null) {
            return Float.valueOf(12.0f * $density);
        }
        return null;
    }

    private final int getTypefaceStyle() {
        return ((Number) this.typefaceStyle$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int typefaceStyle_delegate$lambda$0(OuroTextMarksSpan this$0) {
        if (this$0.isItalic() && this$0.isSemiBold()) {
            return 3;
        }
        if (this$0.isItalic()) {
            return 2;
        }
        return this$0.isSemiBold() ? 1 : 0;
    }

    private final Float getFontSizePx() {
        return (Float) this.fontSizePx$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float fontSizePx_delegate$lambda$0(OuroTextMarksSpan this$0, float $density) {
        OuroFontSizeMark ouroFontSizeMark = (OuroFontSizeMark) this$0.marks.get(OuroFontSizeMark.Key.INSTANCE);
        if (ouroFontSizeMark != null) {
            float it = ouroFontSizeMark.getSize();
            return Float.valueOf(it * $density);
        }
        return null;
    }

    private final Float getTextSpacingEm() {
        return (Float) this.textSpacingEm$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float textSpacingEm_delegate$lambda$0(OuroTextMarksSpan this$0) {
        OuroTextSpacingMark ouroTextSpacingMark = (OuroTextSpacingMark) this$0.marks.get(OuroTextSpacingMark.Key.INSTANCE);
        if (ouroTextSpacingMark != null) {
            return Float.valueOf(ouroTextSpacingMark.getSpacing());
        }
        return null;
    }

    private final Integer getForegroundColor() {
        return (Integer) this.foregroundColor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer foregroundColor_delegate$lambda$0(OuroTextMarksSpan this$0, ThemeDayNight $theme, float $foregroundColorAlpha) {
        OuroColor color;
        OuroForegroundColorMark ouroForegroundColorMark = (OuroForegroundColorMark) this$0.marks.get(OuroForegroundColorMark.Key.INSTANCE);
        if (ouroForegroundColorMark == null || (color = ouroForegroundColorMark.getColor()) == null) {
            return null;
        }
        return Integer.valueOf(OuroTextMarksSpanKt.fade(color.colorForTheme($theme), $foregroundColorAlpha));
    }

    private final void applyTypefaceStyle(TextPaint tp) {
        Typeface it;
        Typeface old = tp.getTypeface();
        int oldStyle = old != null ? old.getStyle() : 0;
        int want = getTypefaceStyle() | oldStyle;
        if (old == null || (it = Typeface.create(old, want)) == null) {
            it = Typeface.defaultFromStyle(want);
            Intrinsics.checkNotNullExpressionValue(it, "defaultFromStyle(...)");
        }
        int fake = (~it.getStyle()) & want;
        if ((fake & 1) != 0 || isMedium()) {
            tp.setFakeBoldText(true);
        }
        if ((fake & 2) != 0) {
            tp.setTextSkewX(-0.25f);
        }
        tp.setTypeface(it);
    }

    private final void applyUnderline(TextPaint tp) {
        if (isUnderline()) {
            tp.setUnderlineText(true);
        }
    }

    private final void applyStrikethrough(TextPaint tp) {
        if (isStrikethrough()) {
            tp.setStrikeThruText(true);
        }
    }

    private final void applyFontSize(TextPaint tp) {
        Float fontSizePx = getFontSizePx();
        if (fontSizePx != null) {
            float it = fontSizePx.floatValue();
            tp.setTextSize(it);
        }
    }

    private final void applyTextSpacing(TextPaint tp) {
        Float textSpacingEm = getTextSpacingEm();
        if (textSpacingEm != null) {
            float it = textSpacingEm.floatValue();
            tp.setLetterSpacing(it);
        }
    }

    private final void applyForegroundColor(TextPaint tp) {
        Integer foregroundColor = getForegroundColor();
        if (foregroundColor != null) {
            int it = foregroundColor.intValue();
            tp.setColor(it);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyTypefaceStyle(tp);
        applyFontSize(tp);
        applyTextSpacing(tp);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyTypefaceStyle(tp);
        applyUnderline(tp);
        applyStrikethrough(tp);
        applyFontSize(tp);
        applyTextSpacing(tp);
        applyForegroundColor(tp);
    }
}