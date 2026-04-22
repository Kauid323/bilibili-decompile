package kntr.common.ouro.ui.utils;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.utils.BulletStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u001a\u001bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\r\u0082\u0001\u0002\u001c\u001d¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrderStyle;", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "level", "", "getLevel", "()I", "size", "Landroidx/compose/ui/unit/DpSize;", "getSize-MYxV2XQ", "()J", "offsetX", "Landroidx/compose/ui/unit/Dp;", "getOffsetX-D9Ej5fM", "()F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "key", "", "getKey", "()Ljava/lang/String;", "indent", "", "getIndent", "prefixIndent", "getPrefixIndent", "Ordered", "Unordered", "Lkntr/common/ouro/ui/utils/ListOrderStyle$Ordered;", "Lkntr/common/ouro/ui/utils/ListOrderStyle$Unordered;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ListOrderStyle extends OuroCustomStyle {
    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    long mo2128getColor0d7_KjU();

    float getIndent();

    @Override // kntr.common.ouro.ui.utils.OuroCustomStyle
    String getKey();

    int getLevel();

    /* renamed from: getOffsetX-D9Ej5fM  reason: not valid java name */
    float mo2129getOffsetXD9Ej5fM();

    float getPrefixIndent();

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    long mo2130getSizeMYxV2XQ();

    /* compiled from: OuroAnnotatedString.kt */
    /* renamed from: kntr.common.ouro.ui.utils.ListOrderStyle$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static String $default$getKey(ListOrderStyle _this) {
            return "OuroListOrderStyle";
        }

        public static float $default$getIndent(ListOrderStyle _this) {
            return _this.getLevel() > 1 ? 22.0f : 0.0f;
        }

        public static float $default$getPrefixIndent(ListOrderStyle _this) {
            return -_this.mo2129getOffsetXD9Ej5fM();
        }
    }

    /* compiled from: OuroAnnotatedString.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String getKey(ListOrderStyle $this) {
            return CC.$default$getKey($this);
        }

        @Deprecated
        public static float getIndent(ListOrderStyle $this) {
            return CC.$default$getIndent($this);
        }

        @Deprecated
        public static float getPrefixIndent(ListOrderStyle $this) {
            return CC.$default$getPrefixIndent($this);
        }
    }

    /* compiled from: OuroAnnotatedString.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015J\u0010\u0010 \u001a\u00020\nHÆ\u0003¢\u0006\u0004\b!\u0010\u0018J\u0010\u0010\"\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b#\u0010\u0015JL\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015¨\u0006."}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrderStyle$Ordered;", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "level", "", "index", "text", "Landroidx/compose/ui/text/AnnotatedString;", "size", "Landroidx/compose/ui/unit/DpSize;", "offsetX", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(IILandroidx/compose/ui/text/AnnotatedString;JFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLevel", "()I", "getIndex", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getSize-MYxV2XQ", "()J", "J", "getOffsetX-D9Ej5fM", "()F", "F", "getColor-0d7_KjU", "component1", "component2", "component3", "component4", "component4-MYxV2XQ", "component5", "component5-D9Ej5fM", "component6", "component6-0d7_KjU", "copy", "copy-Ic2MFlc", "(IILandroidx/compose/ui/text/AnnotatedString;JFJ)Lkntr/common/ouro/ui/utils/ListOrderStyle$Ordered;", "equals", "", "other", "", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Ordered implements ListOrderStyle {
        public static final int $stable = 0;
        private final long color;
        private final int index;
        private final int level;
        private final float offsetX;
        private final long size;
        private final AnnotatedString text;

        public /* synthetic */ Ordered(int i, int i2, AnnotatedString annotatedString, long j, float f, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, annotatedString, j, f, j2);
        }

        public final int component1() {
            return this.level;
        }

        public final int component2() {
            return this.index;
        }

        public final AnnotatedString component3() {
            return this.text;
        }

        /* renamed from: component4-MYxV2XQ  reason: not valid java name */
        public final long m2132component4MYxV2XQ() {
            return this.size;
        }

        /* renamed from: component5-D9Ej5fM  reason: not valid java name */
        public final float m2133component5D9Ej5fM() {
            return this.offsetX;
        }

        /* renamed from: component6-0d7_KjU  reason: not valid java name */
        public final long m2134component60d7_KjU() {
            return this.color;
        }

        /* renamed from: copy-Ic2MFlc  reason: not valid java name */
        public final Ordered m2135copyIc2MFlc(int i, int i2, AnnotatedString annotatedString, long j, float f, long j2) {
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            return new Ordered(i, i2, annotatedString, j, f, j2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ordered) {
                Ordered ordered = (Ordered) obj;
                return this.level == ordered.level && this.index == ordered.index && Intrinsics.areEqual(this.text, ordered.text) && DpSize.equals-impl0(this.size, ordered.size) && Dp.equals-impl0(this.offsetX, ordered.offsetX) && Color.equals-impl0(this.color, ordered.color);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.level * 31) + this.index) * 31) + this.text.hashCode()) * 31) + DpSize.hashCode-impl(this.size)) * 31) + Dp.hashCode-impl(this.offsetX)) * 31) + Color.hashCode-impl(this.color);
        }

        public String toString() {
            int i = this.level;
            int i2 = this.index;
            AnnotatedString annotatedString = this.text;
            String str = DpSize.toString-impl(this.size);
            String str2 = Dp.toString-impl(this.offsetX);
            return "Ordered(level=" + i + ", index=" + i2 + ", text=" + annotatedString + ", size=" + str + ", offsetX=" + str2 + ", color=" + Color.toString-impl(this.color) + ")";
        }

        private Ordered(int level, int index, AnnotatedString text, long size, float offsetX, long color) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.level = level;
            this.index = index;
            this.text = text;
            this.size = size;
            this.offsetX = offsetX;
            this.color = color;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public /* bridge */ float getIndent() {
            return CC.$default$getIndent(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle, kntr.common.ouro.ui.utils.OuroCustomStyle
        public /* bridge */ String getKey() {
            return CC.$default$getKey(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public /* bridge */ float getPrefixIndent() {
            return CC.$default$getPrefixIndent(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public int getLevel() {
            return this.level;
        }

        public final int getIndex() {
            return this.index;
        }

        public final AnnotatedString getText() {
            return this.text;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getSize-MYxV2XQ */
        public long mo2130getSizeMYxV2XQ() {
            return this.size;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getOffsetX-D9Ej5fM */
        public float mo2129getOffsetXD9Ej5fM() {
            return this.offsetX;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getColor-0d7_KjU */
        public long mo2128getColor0d7_KjU() {
            return this.color;
        }
    }

    /* compiled from: OuroAnnotatedString.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b \u0010\u0013JB\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013¨\u0006+"}, d2 = {"Lkntr/common/ouro/ui/utils/ListOrderStyle$Unordered;", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "level", "", "style", "Lkntr/common/ouro/core/utils/BulletStyle;", "size", "Landroidx/compose/ui/unit/DpSize;", "offsetX", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ILkntr/common/ouro/core/utils/BulletStyle;JFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLevel", "()I", "getStyle", "()Lkntr/common/ouro/core/utils/BulletStyle;", "getSize-MYxV2XQ", "()J", "J", "getOffsetX-D9Ej5fM", "()F", "F", "getColor-0d7_KjU", "component1", "component2", "component3", "component3-MYxV2XQ", "component4", "component4-D9Ej5fM", "component5", "component5-0d7_KjU", "copy", "copy-ARDBIIY", "(ILkntr/common/ouro/core/utils/BulletStyle;JFJ)Lkntr/common/ouro/ui/utils/ListOrderStyle$Unordered;", "equals", "", "other", "", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Unordered implements ListOrderStyle {
        public static final int $stable = 0;
        private final long color;
        private final int level;
        private final float offsetX;
        private final long size;
        private final BulletStyle style;

        public /* synthetic */ Unordered(int i, BulletStyle bulletStyle, long j, float f, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, bulletStyle, j, f, j2);
        }

        /* renamed from: copy-ARDBIIY$default  reason: not valid java name */
        public static /* synthetic */ Unordered m2136copyARDBIIY$default(Unordered unordered, int i, BulletStyle bulletStyle, long j, float f, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unordered.level;
            }
            if ((i2 & 2) != 0) {
                bulletStyle = unordered.style;
            }
            BulletStyle bulletStyle2 = bulletStyle;
            if ((i2 & 4) != 0) {
                j = unordered.size;
            }
            long j3 = j;
            if ((i2 & 8) != 0) {
                f = unordered.offsetX;
            }
            float f2 = f;
            if ((i2 & 16) != 0) {
                j2 = unordered.color;
            }
            return unordered.m2140copyARDBIIY(i, bulletStyle2, j3, f2, j2);
        }

        public final int component1() {
            return this.level;
        }

        public final BulletStyle component2() {
            return this.style;
        }

        /* renamed from: component3-MYxV2XQ  reason: not valid java name */
        public final long m2137component3MYxV2XQ() {
            return this.size;
        }

        /* renamed from: component4-D9Ej5fM  reason: not valid java name */
        public final float m2138component4D9Ej5fM() {
            return this.offsetX;
        }

        /* renamed from: component5-0d7_KjU  reason: not valid java name */
        public final long m2139component50d7_KjU() {
            return this.color;
        }

        /* renamed from: copy-ARDBIIY  reason: not valid java name */
        public final Unordered m2140copyARDBIIY(int i, BulletStyle bulletStyle, long j, float f, long j2) {
            Intrinsics.checkNotNullParameter(bulletStyle, "style");
            return new Unordered(i, bulletStyle, j, f, j2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unordered) {
                Unordered unordered = (Unordered) obj;
                return this.level == unordered.level && this.style == unordered.style && DpSize.equals-impl0(this.size, unordered.size) && Dp.equals-impl0(this.offsetX, unordered.offsetX) && Color.equals-impl0(this.color, unordered.color);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.level * 31) + this.style.hashCode()) * 31) + DpSize.hashCode-impl(this.size)) * 31) + Dp.hashCode-impl(this.offsetX)) * 31) + Color.hashCode-impl(this.color);
        }

        public String toString() {
            int i = this.level;
            BulletStyle bulletStyle = this.style;
            String str = DpSize.toString-impl(this.size);
            String str2 = Dp.toString-impl(this.offsetX);
            return "Unordered(level=" + i + ", style=" + bulletStyle + ", size=" + str + ", offsetX=" + str2 + ", color=" + Color.toString-impl(this.color) + ")";
        }

        private Unordered(int level, BulletStyle style, long size, float offsetX, long color) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.level = level;
            this.style = style;
            this.size = size;
            this.offsetX = offsetX;
            this.color = color;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public /* bridge */ float getIndent() {
            return CC.$default$getIndent(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle, kntr.common.ouro.ui.utils.OuroCustomStyle
        public /* bridge */ String getKey() {
            return CC.$default$getKey(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public /* bridge */ float getPrefixIndent() {
            return CC.$default$getPrefixIndent(this);
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        public int getLevel() {
            return this.level;
        }

        public final BulletStyle getStyle() {
            return this.style;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getSize-MYxV2XQ */
        public long mo2130getSizeMYxV2XQ() {
            return this.size;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getOffsetX-D9Ej5fM */
        public float mo2129getOffsetXD9Ej5fM() {
            return this.offsetX;
        }

        @Override // kntr.common.ouro.ui.utils.ListOrderStyle
        /* renamed from: getColor-0d7_KjU */
        public long mo2128getColor0d7_KjU() {
            return this.color;
        }
    }
}