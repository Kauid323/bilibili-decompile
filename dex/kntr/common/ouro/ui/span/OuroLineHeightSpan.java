package kntr.common.ouro.ui.span;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import com.bilibili.droid.DimenUtilsKt;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: OuroLineHeightSpan.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J<\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/common/ouro/ui/span/OuroLineHeightSpan;", "Landroid/text/style/LineHeightSpan$WithDensity;", "height", "", "<init>", "(I)V", "paint", "Landroid/text/TextPaint;", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "applyParagraphSpacing", "span", "Lkntr/common/ouro/ui/span/ParaSpacingHelpSpan;", "applyLineHeight", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLineHeightSpan implements LineHeightSpan.WithDensity {
    public static final int $stable = 8;
    private final int height;
    private final TextPaint paint = new TextPaint();

    public OuroLineHeightSpan(int height) {
        this.height = height;
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm, TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fm == null || text == null) {
            return;
        }
        this.paint.set(paint);
        ParaSpacingHelpSpan paraSpacingHelpSpan = ParaSpacingHelpSpanKt.getParaSpacingHelpSpanInLineHeightSpan(text, start, end);
        if (paraSpacingHelpSpan != null) {
            applyParagraphSpacing(paraSpacingHelpSpan, fm);
        } else {
            applyLineHeight(text, start, end, fm);
        }
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        chooseHeight(text, start, end, spanstartv, lineHeight, fm, this.paint);
    }

    private final void applyParagraphSpacing(ParaSpacingHelpSpan span, Paint.FontMetricsInt fm) {
        int realLineHeightPx = DimenUtilsKt.dpToPx(span.getSpacingDp());
        fm.ascent = fm.descent - realLineHeightPx;
        fm.bottom = fm.descent;
        fm.top = fm.ascent;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void applyLineHeight(CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        float heightFromReplacement;
        int lineHeight;
        Spanned $this$getSpans$iv = text instanceof Spanned ? (Spanned) text : null;
        ReplacementSpan[] replacementSpans = $this$getSpans$iv != null ? (ReplacementSpan[]) $this$getSpans$iv.getSpans(start, end, ReplacementSpan.class) : null;
        float heightFromFontSize = DimenUtilsKt.dpToPx(this.height);
        if (replacementSpans != null) {
            ReplacementSpan[] replacementSpanArr = !(replacementSpans.length == 0) ? replacementSpans : null;
            if (replacementSpanArr != null) {
                if (replacementSpanArr.length == 0) {
                    throw new NoSuchElementException();
                }
                ReplacementSpan it = replacementSpanArr[0];
                heightFromReplacement = it.getSize(this.paint, text, start, end, fm);
                int lastIndex = ArraysKt.getLastIndex(replacementSpanArr);
                if (1 <= lastIndex) {
                    int i = 1;
                    float f = heightFromReplacement;
                    while (true) {
                        ReplacementSpan it2 = replacementSpanArr[i];
                        f = Math.max(f, it2.getSize(this.paint, text, start, end, fm));
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                    heightFromReplacement = f;
                }
                float height = Math.max(heightFromFontSize, heightFromReplacement);
                lineHeight = fm.descent - fm.ascent;
                if (lineHeight > 0) {
                    return;
                }
                float ratio = (1.0f * height) / lineHeight;
                fm.descent = MathKt.roundToInt(fm.descent * ratio);
                fm.ascent = fm.descent - ((int) height);
                return;
            }
        }
        heightFromReplacement = 0.0f;
        float height2 = Math.max(heightFromFontSize, heightFromReplacement);
        lineHeight = fm.descent - fm.ascent;
        if (lineHeight > 0) {
        }
    }
}