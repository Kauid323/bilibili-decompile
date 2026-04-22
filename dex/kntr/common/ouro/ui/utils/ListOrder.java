package kntr.common.ouro.ui.utils;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroFontWeightMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroRegularMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.utils.BulletStyle;
import kntr.common.ouro.core.utils.ListOrderUtilsKt;
import kntr.common.ouro.ui.utils.ListOrderStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotatedStringUtils.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0015\u0016JB\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrder;", "", "level", "", "getLevel", "()I", "style", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "listOrderLayoutCache", "Lkntr/common/ouro/ui/utils/OuroCacheMap;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textMeasure", "Landroidx/compose/ui/text/TextMeasurer;", "density", "Landroidx/compose/ui/unit/Density;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "Ordered", "Unordered", "Lkntr/common/ouro/ui/utils/ListOrder$Ordered;", "Lkntr/common/ouro/ui/utils/ListOrder$Unordered;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ListOrder {
    int getLevel();

    ListOrderStyle style(OuroMarks<OuroTextMark> ouroMarks, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasurer, Density density, ThemeDayNight themeDayNight);

    /* compiled from: AnnotatedStringUtils.kt */
    /* renamed from: kntr.common.ouro.ui.utils.ListOrder$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static ListOrderStyle $default$style(ListOrder _this, OuroMarks marks, OuroCacheMap listOrderLayoutCache, final TextMeasurer textMeasure, Density density, ThemeDayNight theme) {
            FontWeight composeFontWeight;
            Intrinsics.checkNotNullParameter(marks, "marks");
            Intrinsics.checkNotNullParameter(listOrderLayoutCache, "listOrderLayoutCache");
            Intrinsics.checkNotNullParameter(textMeasure, "textMeasure");
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(theme, "theme");
            long color = ColorKt.Color(AnnotatedStringUtilsKt.getColorOrDefault(marks, OuroColor.Companion.getGa9()).colorForTheme(theme));
            float fontSize = AnnotatedStringUtilsKt.getFontSizeOrDefault(marks, 14.0f);
            OuroFontWeightMark fontWeight = AnnotatedStringUtilsKt.getFontWeightOrDefault(marks, OuroRegularMark.INSTANCE);
            if (_this instanceof Ordered) {
                final AnnotatedString text = new AnnotatedString(ListOrderUtilsKt.listOrder(((Ordered) _this).getIndex(), ((Ordered) _this).getLevel()), (List) null, 2, (DefaultConstructorMarker) null);
                long sp = TextUnitKt.getSp(fontSize);
                composeFontWeight = AnnotatedStringUtilsKt.toComposeFontWeight(fontWeight);
                final TextStyle textStyle = new TextStyle(color, sp, composeFontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null);
                TextLayoutResult textLayoutResult = (TextLayoutResult) listOrderLayoutCache.getOrPut(text.getText(), new Function0() { // from class: kntr.common.ouro.ui.utils.ListOrder$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        TextLayoutResult textLayoutResult2;
                        textLayoutResult2 = TextMeasurer.measure-xDpz5zY$default(textMeasure, text, textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null);
                        return textLayoutResult2;
                    }
                });
                long textSize = DpKt.DpSize-YgX7TsA(density.toDp-u2uoSUM((int) (textLayoutResult.getSize-YbymL2g() >> 32)), density.toDp-u2uoSUM((int) (textLayoutResult.getSize-YbymL2g() & 4294967295L)));
                return new ListOrderStyle.Ordered(((Ordered) _this).getLevel(), ((Ordered) _this).getIndex(), text, textSize, Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(Math.max(DpSize.getWidth-D9Ej5fM(textSize), Dp.constructor-impl(18))) + Dp.constructor-impl(4))), color, null);
            } else if (_this instanceof Unordered) {
                return new ListOrderStyle.Unordered(((Unordered) _this).getLevel(), BulletStyle.FilledCircle, DpKt.DpSize-YgX7TsA(Dp.constructor-impl(18), Dp.constructor-impl(18)), Dp.constructor-impl(-24), color, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* compiled from: AnnotatedStringUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrder$Ordered;", "Lkntr/common/ouro/ui/utils/ListOrder;", "level", "", "index", "<init>", "(II)V", "getLevel", "()I", "getIndex", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Ordered implements ListOrder {
        public static final int $stable = 0;
        private final int index;
        private final int level;

        public static /* synthetic */ Ordered copy$default(Ordered ordered, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = ordered.level;
            }
            if ((i3 & 2) != 0) {
                i2 = ordered.index;
            }
            return ordered.copy(i, i2);
        }

        public final int component1() {
            return this.level;
        }

        public final int component2() {
            return this.index;
        }

        public final Ordered copy(int i, int i2) {
            return new Ordered(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ordered) {
                Ordered ordered = (Ordered) obj;
                return this.level == ordered.level && this.index == ordered.index;
            }
            return false;
        }

        public int hashCode() {
            return (this.level * 31) + this.index;
        }

        public String toString() {
            int i = this.level;
            return "Ordered(level=" + i + ", index=" + this.index + ")";
        }

        public Ordered(int level, int index) {
            this.level = level;
            this.index = index;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrder
        public /* bridge */ ListOrderStyle style(OuroMarks<OuroTextMark> ouroMarks, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasure, Density density, ThemeDayNight theme) {
            return CC.$default$style(this, ouroMarks, ouroCacheMap, textMeasure, density, theme);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrder
        public int getLevel() {
            return this.level;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* compiled from: AnnotatedStringUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrder$Unordered;", "Lkntr/common/ouro/ui/utils/ListOrder;", "level", "", "<init>", "(I)V", "getLevel", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Unordered implements ListOrder {
        public static final int $stable = 0;
        private final int level;

        public static /* synthetic */ Unordered copy$default(Unordered unordered, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unordered.level;
            }
            return unordered.copy(i);
        }

        public final int component1() {
            return this.level;
        }

        public final Unordered copy(int i) {
            return new Unordered(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unordered) && this.level == ((Unordered) obj).level;
        }

        public int hashCode() {
            return this.level;
        }

        public String toString() {
            return "Unordered(level=" + this.level + ")";
        }

        public Unordered(int level) {
            this.level = level;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrder
        public /* bridge */ ListOrderStyle style(OuroMarks<OuroTextMark> ouroMarks, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasure, Density density, ThemeDayNight theme) {
            return CC.$default$style(this, ouroMarks, ouroCacheMap, textMeasure, density, theme);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrder
        public int getLevel() {
            return this.level;
        }
    }

    /* compiled from: AnnotatedStringUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static ListOrderStyle style(ListOrder $this, OuroMarks<OuroTextMark> ouroMarks, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasure, Density density, ThemeDayNight theme) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            Intrinsics.checkNotNullParameter(ouroCacheMap, "listOrderLayoutCache");
            Intrinsics.checkNotNullParameter(textMeasure, "textMeasure");
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(theme, "theme");
            return CC.$default$style($this, ouroMarks, ouroCacheMap, textMeasure, density, theme);
        }
    }
}