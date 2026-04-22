package tv.danmaku.bili.ui.favorites.util;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.widget.TextView;
import androidx.core.math.MathUtils;
import com.bilibili.app.comm.list.widget.tag.tagtinttext.TagSpanTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesUtils.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0006H\u0000\u001a\u0082\u0001\u0010\t\u001a\u00020\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0007\u001a\u0012\u0010\u0019\u001a\u00020\r*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006¨\u0006\u001b"}, d2 = {"calculateEllipsize", "", "textView", "Landroid/widget/TextView;", "workingText", "maxLines", "", "suffix", "suffixWidth", "displaySpanTag", "", "Lcom/bilibili/app/comm/list/widget/tag/tagtinttext/TagSpanTextView;", "tagText", "", "tagTextColor", "tagTextBgColor", "tagStyle", "textContent", "nullBlock", "Lkotlin/Function0;", "", "goneInNullBlock", "emptyGoneOrVisible", "hideIfOutOfWidth", "onTagSet", "toIsAcquiesce", "defaultTabId", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesUtilsKt {
    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, 0, null, null, false, false, false, null, 1016, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, null, null, false, false, false, null, 1008, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, charSequence, null, false, false, false, null, 992, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, charSequence, function0, false, false, false, null, 960, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence, Function0<Unit> function0, boolean z) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, charSequence, function0, z, false, false, null, 896, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence, Function0<Unit> function0, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, charSequence, function0, z, z2, false, null, 768, null);
    }

    public static final boolean displaySpanTag(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence, Function0<Unit> function0, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(tagSpanTextView, "<this>");
        return displaySpanTag$default(tagSpanTextView, str, i, i2, i3, charSequence, function0, z, z2, z3, null, BR.roleType, null);
    }

    public static final CharSequence calculateEllipsize(TextView textView, CharSequence workingText, int maxLines, CharSequence suffix, int suffixWidth) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(workingText, "workingText");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Layout layout = textView.getLayout();
        if (layout == null) {
            return workingText;
        }
        if (maxLines != -1 && layout.getLineCount() > maxLines) {
            int start = layout.getLineStart(maxLines - 1);
            int end = layout.getLineEnd(maxLines - 1);
            TextPaint paint = textView.getPaint();
            float ellSize = Layout.getDesiredWidth("…", 0, "…".length(), paint);
            int end2 = MathUtils.clamp(end, 0, workingText.length());
            do {
                end2--;
                if (end2 < start) {
                    break;
                }
            } while (layout.getWidth() - Layout.getDesiredWidth(workingText, start, end2, paint) < suffixWidth + ellSize);
            SpannableStringBuilder append = new SpannableStringBuilder(workingText.subSequence(0, MathUtils.clamp(end2, 0, workingText.length()))).append(suffix);
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            return append;
        }
        return workingText;
    }

    public static /* synthetic */ boolean displaySpanTag$default(TagSpanTextView tagSpanTextView, String str, int i, int i2, int i3, CharSequence charSequence, Function0 function0, boolean z, boolean z2, boolean z3, Function0 function02, int i4, Object obj) {
        return displaySpanTag(tagSpanTextView, str, i, i2, (i4 & 8) != 0 ? 1 : i3, (i4 & 16) != 0 ? null : charSequence, (i4 & 32) != 0 ? null : function0, (i4 & 64) != 0 ? false : z, (i4 & BR.cover) != 0 ? true : z2, (i4 & BR.hallEnterHotText) != 0 ? false : z3, (i4 & BR.roleType) != 0 ? null : function02);
    }

    public static final boolean displaySpanTag(TagSpanTextView $this$displaySpanTag, String tagText, int tagTextColor, int tagTextBgColor, int tagStyle, CharSequence textContent, Function0<Unit> function0, boolean goneInNullBlock, boolean emptyGoneOrVisible, boolean hideIfOutOfWidth, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter($this$displaySpanTag, "<this>");
        if (tagText == null) {
            if (goneInNullBlock) {
                $this$displaySpanTag.setVisibility(8);
            }
            if (function0 != null) {
                function0.invoke();
            }
            return false;
        }
        TagSpanTextView.TagBuilder builder = $this$displaySpanTag.tagBuilder();
        if (textContent != null) {
            builder.appendText(textContent);
        }
        TagSpanTextView.TagBuilder.appendTag$default(builder.setTagText(tagText).setTagTextColorRes(tagTextColor).setTagBackgroundColorRes(tagTextBgColor).setTagNightTextColor(tagTextColor).setTagNightBackgroundColor(tagTextBgColor).setTagBackgroundStyle(tagStyle), false, hideIfOutOfWidth, 1, (Object) null);
        builder.applyToView(emptyGoneOrVisible);
        if (function02 != null) {
            function02.invoke();
        }
        return true;
    }

    public static final String toIsAcquiesce(int $this$toIsAcquiesce, int defaultTabId) {
        return String.valueOf($this$toIsAcquiesce == defaultTabId ? 1 : 0);
    }
}