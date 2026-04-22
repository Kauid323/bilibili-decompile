package kntr.common.ouro.ui.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksKt;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.ui.span.OuroDrawableSpan;
import kntr.common.ouro.ui.span.OuroTextMarksSpan;
import kntr.common.ouro.ui.span.ParaSpacingHelpSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableStringBuilderUtils.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0081\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010:\u001a\u00020\u000fH\u0000¢\u0006\u0002\b;J\b\u0010<\u001a\u00020\u000fH\u0002J7\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020BH\u0000¢\u0006\u0002\bDJ\u001d\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020-H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020\u000fH\u0002J/\u0010J\u001a\b\u0012\u0004\u0012\u00020*0$2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020*0$2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020*0$H\u0000¢\u0006\u0002\bLJ\b\u0010M\u001a\u00020\u000fH\u0002J#\u0010N\u001a\u0002082\u0006\u0010O\u001a\u0002072\f\u0010P\u001a\b\u0012\u0004\u0012\u0002080QH\u0000¢\u0006\u0002\bRJ\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\tHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0017\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rHÆ\u0003JU\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rHÆ\u0001J\u0013\u0010Z\u001a\u00020-2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\tHÖ\u0001J\t\u0010]\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR,\u0010 \u001a \u0012\u0004\u0012\u00020\"\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020&0#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0(X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010)\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$0!0!X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010+\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$0(0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u0002070(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lkntr/common/ouro/ui/utils/SpannableStringBuilderContext;", "", "density", "Landroidx/compose/ui/unit/Density;", "textMeasure", "Landroidx/compose/ui/text/TextMeasurer;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "mainAxisLength", "", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "dispatcher", "Lkotlin/Function1;", "Lkntr/common/ouro/core/action/OuroAction;", "", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/TextMeasurer;Lcom/bilibili/compose/theme/ThemeDayNight;ILkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;Lkotlin/jvm/functions/Function1;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTextMeasure", "()Landroidx/compose/ui/text/TextMeasurer;", "getTheme", "()Lcom/bilibili/compose/theme/ThemeDayNight;", "getMainAxisLength", "()I", "getLocalImageState", "()Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "setLocalImageState", "(Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;)V", "getDispatcher", "()Lkotlin/jvm/functions/Function1;", "textElementCache", "", "Lkntr/common/ouro/ui/utils/TextElementCacheKey;", "Lkotlin/Pair;", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Landroid/text/Spannable;", "textElementCacheUsed", "", "mergedMarksCache", "Lkntr/common/ouro/core/model/mark/OuroMark;", "mergedMarksCacheUsed", "isEmptyContainer", "", "isEmptyContainer$ui_debug", "()Z", "textLayoutResultCache", "Lkntr/common/ouro/ui/utils/OuroCacheMap;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "getTextLayoutResultCache$ui_debug", "()Lkntr/common/ouro/ui/utils/OuroCacheMap;", "drawableCache", "Lkntr/common/ouro/ui/utils/DrawableSpanCacheKey;", "Lkntr/common/ouro/ui/span/OuroDrawableSpan;", "drawableCacheUsed", "clearCache", "clearCache$ui_debug", "clearTextElementCache", "getPlainTextSpannable", "element", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "marks", "textForegroundColorAlpha", "", "textBackgroundColorAlpha", "getPlainTextSpannable$ui_debug", "getHardBreakSpannable", "paragraphSpacingDp", "isLast", "getHardBreakSpannable$ui_debug", "clearMergedMarksCacheUsed", "getMergedMarks", "parentMarks", "getMergedMarks$ui_debug", "clearDrawableCache", "getOrCreateDrawableSpan", "cacheKey", "creator", "Lkotlin/Function0;", "getOrCreateDrawableSpan$ui_debug", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SpannableStringBuilderContext {
    public static final int $stable = 8;
    private final Density density;
    private final Function1<OuroAction, Unit> dispatcher;
    private final Map<DrawableSpanCacheKey, OuroDrawableSpan> drawableCache;
    private final Set<DrawableSpanCacheKey> drawableCacheUsed;
    private OuroLocalImageState localImageState;
    private final int mainAxisLength;
    private final Map<OuroMarks<OuroMark>, Map<OuroMarks<OuroMark>, OuroMarks<OuroMark>>> mergedMarksCache;
    private final Map<OuroMarks<OuroMark>, Set<OuroMarks<OuroMark>>> mergedMarksCacheUsed;
    private final Map<TextElementCacheKey, Pair<OuroMarks<OuroTextMark>, Spannable>> textElementCache;
    private final Set<TextElementCacheKey> textElementCacheUsed;
    private final OuroCacheMap<String, TextLayoutResult> textLayoutResultCache;
    private final TextMeasurer textMeasure;
    private final ThemeDayNight theme;

    public static /* synthetic */ SpannableStringBuilderContext copy$default(SpannableStringBuilderContext spannableStringBuilderContext, Density density, TextMeasurer textMeasurer, ThemeDayNight themeDayNight, int i, OuroLocalImageState ouroLocalImageState, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            density = spannableStringBuilderContext.density;
        }
        if ((i2 & 2) != 0) {
            textMeasurer = spannableStringBuilderContext.textMeasure;
        }
        TextMeasurer textMeasurer2 = textMeasurer;
        if ((i2 & 4) != 0) {
            themeDayNight = spannableStringBuilderContext.theme;
        }
        ThemeDayNight themeDayNight2 = themeDayNight;
        if ((i2 & 8) != 0) {
            i = spannableStringBuilderContext.mainAxisLength;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            ouroLocalImageState = spannableStringBuilderContext.localImageState;
        }
        OuroLocalImageState ouroLocalImageState2 = ouroLocalImageState;
        Function1<OuroAction, Unit> function12 = function1;
        if ((i2 & 32) != 0) {
            function12 = spannableStringBuilderContext.dispatcher;
        }
        return spannableStringBuilderContext.copy(density, textMeasurer2, themeDayNight2, i3, ouroLocalImageState2, function12);
    }

    public final Density component1() {
        return this.density;
    }

    public final TextMeasurer component2() {
        return this.textMeasure;
    }

    public final ThemeDayNight component3() {
        return this.theme;
    }

    public final int component4() {
        return this.mainAxisLength;
    }

    public final OuroLocalImageState component5() {
        return this.localImageState;
    }

    public final Function1<OuroAction, Unit> component6() {
        return this.dispatcher;
    }

    public final SpannableStringBuilderContext copy(Density density, TextMeasurer textMeasurer, ThemeDayNight themeDayNight, int i, OuroLocalImageState ouroLocalImageState, Function1<? super OuroAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasure");
        Intrinsics.checkNotNullParameter(themeDayNight, "theme");
        return new SpannableStringBuilderContext(density, textMeasurer, themeDayNight, i, ouroLocalImageState, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SpannableStringBuilderContext) {
            SpannableStringBuilderContext spannableStringBuilderContext = (SpannableStringBuilderContext) obj;
            return Intrinsics.areEqual(this.density, spannableStringBuilderContext.density) && Intrinsics.areEqual(this.textMeasure, spannableStringBuilderContext.textMeasure) && this.theme == spannableStringBuilderContext.theme && this.mainAxisLength == spannableStringBuilderContext.mainAxisLength && Intrinsics.areEqual(this.localImageState, spannableStringBuilderContext.localImageState) && Intrinsics.areEqual(this.dispatcher, spannableStringBuilderContext.dispatcher);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.density.hashCode() * 31) + this.textMeasure.hashCode()) * 31) + this.theme.hashCode()) * 31) + this.mainAxisLength) * 31) + (this.localImageState == null ? 0 : this.localImageState.hashCode())) * 31) + (this.dispatcher != null ? this.dispatcher.hashCode() : 0);
    }

    public String toString() {
        Density density = this.density;
        TextMeasurer textMeasurer = this.textMeasure;
        ThemeDayNight themeDayNight = this.theme;
        int i = this.mainAxisLength;
        OuroLocalImageState ouroLocalImageState = this.localImageState;
        return "SpannableStringBuilderContext(density=" + density + ", textMeasure=" + textMeasurer + ", theme=" + themeDayNight + ", mainAxisLength=" + i + ", localImageState=" + ouroLocalImageState + ", dispatcher=" + this.dispatcher + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpannableStringBuilderContext(Density density, TextMeasurer textMeasure, ThemeDayNight theme, int mainAxisLength, OuroLocalImageState localImageState, Function1<? super OuroAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(textMeasure, "textMeasure");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.density = density;
        this.textMeasure = textMeasure;
        this.theme = theme;
        this.mainAxisLength = mainAxisLength;
        this.localImageState = localImageState;
        this.dispatcher = function1;
        this.textElementCache = new LinkedHashMap();
        this.textElementCacheUsed = new LinkedHashSet();
        this.mergedMarksCache = new LinkedHashMap();
        this.mergedMarksCacheUsed = new LinkedHashMap();
        this.textLayoutResultCache = new OuroCacheMap<>(null, null, 3, null);
        this.drawableCache = new LinkedHashMap();
        this.drawableCacheUsed = new LinkedHashSet();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SpannableStringBuilderContext(Density density, TextMeasurer textMeasurer, ThemeDayNight themeDayNight, int i, OuroLocalImageState ouroLocalImageState, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, textMeasurer, themeDayNight, i, ouroLocalImageState, r6);
        Function1 function12;
        if ((i2 & 32) == 0) {
            function12 = function1;
        } else {
            function12 = null;
        }
    }

    public final Density getDensity() {
        return this.density;
    }

    public final TextMeasurer getTextMeasure() {
        return this.textMeasure;
    }

    public final ThemeDayNight getTheme() {
        return this.theme;
    }

    public final int getMainAxisLength() {
        return this.mainAxisLength;
    }

    public final OuroLocalImageState getLocalImageState() {
        return this.localImageState;
    }

    public final void setLocalImageState(OuroLocalImageState ouroLocalImageState) {
        this.localImageState = ouroLocalImageState;
    }

    public final Function1<OuroAction, Unit> getDispatcher() {
        return this.dispatcher;
    }

    public final boolean isEmptyContainer$ui_debug() {
        return this.mainAxisLength <= 0;
    }

    public final OuroCacheMap<String, TextLayoutResult> getTextLayoutResultCache$ui_debug() {
        return this.textLayoutResultCache;
    }

    public final void clearCache$ui_debug() {
        clearTextElementCache();
        clearMergedMarksCacheUsed();
        clearDrawableCache();
    }

    private final void clearTextElementCache() {
        Iterator it = this.textElementCache.entrySet().iterator();
        while (it.hasNext()) {
            if (!this.textElementCacheUsed.contains(it.next().getKey())) {
                it.remove();
            }
        }
        this.textElementCacheUsed.clear();
    }

    public static /* synthetic */ Spannable getPlainTextSpannable$ui_debug$default(SpannableStringBuilderContext spannableStringBuilderContext, OuroTextElement.Plain plain, OuroMarks ouroMarks, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        if ((i & 8) != 0) {
            f2 = 1.0f;
        }
        return spannableStringBuilderContext.getPlainTextSpannable$ui_debug(plain, ouroMarks, f, f2);
    }

    public final Spannable getPlainTextSpannable$ui_debug(OuroTextElement.Plain element, OuroMarks<OuroTextMark> ouroMarks, float textForegroundColorAlpha, float textBackgroundColorAlpha) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        TextElementCacheKey textElementCacheKey = new TextElementCacheKey(element, textForegroundColorAlpha, textBackgroundColorAlpha);
        this.textElementCacheUsed.add(textElementCacheKey);
        Pair cached = this.textElementCache.get(textElementCacheKey);
        if (cached != null) {
            if (Intrinsics.areEqual(cached.getFirst(), ouroMarks)) {
                return cached.getSecond();
            }
            this.textElementCache.remove(textElementCacheKey);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) element.getMeta());
        if (!ouroMarks.isEmpty()) {
            spannableStringBuilder.setSpan(new OuroTextMarksSpan(ouroMarks, this.theme, this.density.getDensity(), textForegroundColorAlpha, textBackgroundColorAlpha), 0, element.getMeta().length(), 33);
        }
        SpannableStringBuilder $this$toSpannable$iv = spannableStringBuilder;
        Spannable spannable = SpannableString.valueOf($this$toSpannable$iv);
        this.textElementCache.put(textElementCacheKey, TuplesKt.to(ouroMarks, spannable));
        return spannable;
    }

    public final Spannable getHardBreakSpannable$ui_debug(int paragraphSpacingDp, boolean isLast) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (isLast) {
            spannableStringBuilder.append(SpannableStringBuilderUtilsKt.END_PLACEHOLDER_CHAR);
        } else {
            spannableStringBuilder.append((CharSequence) "\n");
            spannableStringBuilder.append((char) 8203);
            ParaSpacingHelpSpan paraSpacing = new ParaSpacingHelpSpan(paragraphSpacingDp);
            spannableStringBuilder.setSpan(paraSpacing, 1, 2, 33);
            spannableStringBuilder.append((CharSequence) "\n");
        }
        SpannableStringBuilder $this$toSpannable$iv = spannableStringBuilder;
        return SpannableString.valueOf($this$toSpannable$iv);
    }

    private final void clearMergedMarksCacheUsed() {
        Iterator it = this.mergedMarksCache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<OuroMarks<OuroMark>, Map<OuroMarks<OuroMark>, OuroMarks<OuroMark>>> next = it.next();
            OuroMarks key = next.getKey();
            Map value = next.getValue();
            if (!this.mergedMarksCacheUsed.containsKey(key)) {
                it.remove();
            } else {
                Iterator valueIt = value.entrySet().iterator();
                Set usedSet = this.mergedMarksCacheUsed.get(key);
                if (usedSet == null) {
                    usedSet = new LinkedHashSet();
                }
                while (valueIt.hasNext()) {
                    if (!usedSet.contains(valueIt.next().getKey())) {
                        valueIt.remove();
                    }
                }
                if (value.isEmpty()) {
                    it.remove();
                }
            }
        }
        this.mergedMarksCacheUsed.clear();
    }

    public final OuroMarks<OuroMark> getMergedMarks$ui_debug(OuroMarks<OuroMark> ouroMarks, OuroMarks<OuroMark> ouroMarks2) {
        LinkedHashMap linkedHashMap;
        OuroMarks ouroMarks3;
        LinkedHashSet linkedHashSet;
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "parentMarks");
        Map $this$getOrPut$iv = this.mergedMarksCache;
        Map<OuroMarks<OuroMark>, OuroMarks<OuroMark>> map = $this$getOrPut$iv.get(ouroMarks);
        if (map == null) {
            linkedHashMap = new LinkedHashMap();
            $this$getOrPut$iv.put(ouroMarks, linkedHashMap);
        } else {
            linkedHashMap = map;
        }
        Map<OuroMarks<OuroMark>, OuroMarks<OuroMark>> $this$getOrPut$iv2 = linkedHashMap;
        OuroMarks<OuroMark> ouroMarks4 = $this$getOrPut$iv2.get(ouroMarks2);
        if (ouroMarks4 == null) {
            ouroMarks3 = OuroMarksKt.mergeParent(ouroMarks, ouroMarks2);
            $this$getOrPut$iv2.put(ouroMarks2, ouroMarks3);
        } else {
            ouroMarks3 = ouroMarks4;
        }
        OuroMarks cache = ouroMarks3;
        Map $this$getOrPut$iv3 = this.mergedMarksCacheUsed;
        Set<OuroMarks<OuroMark>> set = $this$getOrPut$iv3.get(ouroMarks);
        if (set == null) {
            linkedHashSet = new LinkedHashSet();
            $this$getOrPut$iv3.put(ouroMarks, linkedHashSet);
        } else {
            linkedHashSet = set;
        }
        linkedHashSet.add(ouroMarks2);
        return cache;
    }

    private final void clearDrawableCache() {
        Iterator it = this.drawableCache.entrySet().iterator();
        while (it.hasNext()) {
            if (!this.drawableCacheUsed.contains(it.next().getKey())) {
                it.remove();
            }
        }
        this.drawableCacheUsed.clear();
    }

    public final OuroDrawableSpan getOrCreateDrawableSpan$ui_debug(DrawableSpanCacheKey cacheKey, Function0<OuroDrawableSpan> function0) {
        OuroDrawableSpan ouroDrawableSpan;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(function0, "creator");
        this.drawableCacheUsed.add(cacheKey);
        Map $this$getOrPut$iv = this.drawableCache;
        OuroDrawableSpan ouroDrawableSpan2 = $this$getOrPut$iv.get(cacheKey);
        if (ouroDrawableSpan2 == null) {
            ouroDrawableSpan = (OuroDrawableSpan) function0.invoke();
            $this$getOrPut$iv.put(cacheKey, ouroDrawableSpan);
        } else {
            ouroDrawableSpan = ouroDrawableSpan2;
        }
        return ouroDrawableSpan;
    }
}