package kntr.app.ad.ui.uikit.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.ad.ui.uikit.modifiers.Background;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTag.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/ad/ui/uikit/components/TagContent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Text", "Icon", "Lkntr/app/ad/ui/uikit/components/TagContent$Icon;", "Lkntr/app/ad/ui/uikit/components/TagContent$Text;", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TagContent {
    public static final int $stable = 0;

    public /* synthetic */ TagContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TagContent() {
    }

    /* compiled from: AdTag.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0010\u0010&\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b'\u0010\u0017J\u0010\u0010(\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b)\u0010\u0017J\u0010\u0010*\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b+\u0010\u0017J\t\u0010,\u001a\u00020\nHÆ\u0003J\u0010\u0010-\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b.\u0010\u001eJ\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003Jj\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b3\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lkntr/app/ad/ui/uikit/components/TagContent$Text;", "Lkntr/app/ad/ui/uikit/components/TagContent;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "textColor", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "lineHeight", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "spacing", "background", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "<init>", "(Ljava/lang/String;JJJLandroidx/compose/ui/text/font/FontWeight;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lkntr/app/ad/ui/uikit/modifiers/Background;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getTextColor-0d7_KjU", "()J", "J", "getFontSize-XSAIIZE", "getLineHeight-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getMaxWidth-D9Ej5fM", "()F", "F", "getPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getSpacing", "getBackground", "()Lkntr/app/ad/ui/uikit/modifiers/Background;", "component1", "component2", "component2-0d7_KjU", "component3", "component3-XSAIIZE", "component4", "component4-XSAIIZE", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-9o5josE", "(Ljava/lang/String;JJJLandroidx/compose/ui/text/font/FontWeight;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lkntr/app/ad/ui/uikit/modifiers/Background;)Lkntr/app/ad/ui/uikit/components/TagContent$Text;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Text extends TagContent {
        public static final int $stable = 0;
        private final Background background;
        private final long fontSize;
        private final FontWeight fontWeight;
        private final long lineHeight;
        private final float maxWidth;
        private final PaddingValues padding;
        private final PaddingValues spacing;
        private final String text;
        private final long textColor;

        public /* synthetic */ Text(String str, long j2, long j3, long j4, FontWeight fontWeight, float f, PaddingValues paddingValues, PaddingValues paddingValues2, Background background, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j2, j3, j4, fontWeight, f, paddingValues, paddingValues2, background);
        }

        public final String component1() {
            return this.text;
        }

        /* renamed from: component2-0d7_KjU  reason: not valid java name */
        public final long m505component20d7_KjU() {
            return this.textColor;
        }

        /* renamed from: component3-XSAIIZE  reason: not valid java name */
        public final long m506component3XSAIIZE() {
            return this.fontSize;
        }

        /* renamed from: component4-XSAIIZE  reason: not valid java name */
        public final long m507component4XSAIIZE() {
            return this.lineHeight;
        }

        public final FontWeight component5() {
            return this.fontWeight;
        }

        /* renamed from: component6-D9Ej5fM  reason: not valid java name */
        public final float m508component6D9Ej5fM() {
            return this.maxWidth;
        }

        public final PaddingValues component7() {
            return this.padding;
        }

        public final PaddingValues component8() {
            return this.spacing;
        }

        public final Background component9() {
            return this.background;
        }

        /* renamed from: copy-9o5josE  reason: not valid java name */
        public final Text m509copy9o5josE(String str, long j2, long j3, long j4, FontWeight fontWeight, float f, PaddingValues paddingValues, PaddingValues paddingValues2, Background background) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(paddingValues, "padding");
            Intrinsics.checkNotNullParameter(paddingValues2, "spacing");
            Intrinsics.checkNotNullParameter(background, "background");
            return new Text(str, j2, j3, j4, fontWeight, f, paddingValues, paddingValues2, background, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Text) {
                Text text = (Text) obj;
                return Intrinsics.areEqual(this.text, text.text) && Color.equals-impl0(this.textColor, text.textColor) && TextUnit.equals-impl0(this.fontSize, text.fontSize) && TextUnit.equals-impl0(this.lineHeight, text.lineHeight) && Intrinsics.areEqual(this.fontWeight, text.fontWeight) && Dp.equals-impl0(this.maxWidth, text.maxWidth) && Intrinsics.areEqual(this.padding, text.padding) && Intrinsics.areEqual(this.spacing, text.spacing) && Intrinsics.areEqual(this.background, text.background);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((this.text.hashCode() * 31) + Color.hashCode-impl(this.textColor)) * 31) + TextUnit.hashCode-impl(this.fontSize)) * 31) + TextUnit.hashCode-impl(this.lineHeight)) * 31) + this.fontWeight.hashCode()) * 31) + Dp.hashCode-impl(this.maxWidth)) * 31) + this.padding.hashCode()) * 31) + this.spacing.hashCode()) * 31) + this.background.hashCode();
        }

        public String toString() {
            String str = this.text;
            String str2 = Color.toString-impl(this.textColor);
            String str3 = TextUnit.toString-impl(this.fontSize);
            String str4 = TextUnit.toString-impl(this.lineHeight);
            FontWeight fontWeight = this.fontWeight;
            String str5 = Dp.toString-impl(this.maxWidth);
            PaddingValues paddingValues = this.padding;
            PaddingValues paddingValues2 = this.spacing;
            return "Text(text=" + str + ", textColor=" + str2 + ", fontSize=" + str3 + ", lineHeight=" + str4 + ", fontWeight=" + fontWeight + ", maxWidth=" + str5 + ", padding=" + paddingValues + ", spacing=" + paddingValues2 + ", background=" + this.background + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Text(String text, long textColor, long fontSize, long lineHeight, FontWeight fontWeight, float maxWidth, PaddingValues padding, PaddingValues spacing, Background background) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(spacing, "spacing");
            Intrinsics.checkNotNullParameter(background, "background");
            this.text = text;
            this.textColor = textColor;
            this.fontSize = fontSize;
            this.lineHeight = lineHeight;
            this.fontWeight = fontWeight;
            this.maxWidth = maxWidth;
            this.padding = padding;
            this.spacing = spacing;
            this.background = background;
        }

        public /* synthetic */ Text(String str, long j2, long j3, long j4, FontWeight fontWeight, float f, PaddingValues paddingValues, PaddingValues paddingValues2, Background background, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? ColorKt.Color(4294466132L) : j2, (i & 4) != 0 ? TextUnitKt.getSp(10) : j3, (i & 8) != 0 ? TextUnitKt.getSp(14) : j4, (i & 16) != 0 ? FontWeight.Companion.getW400() : fontWeight, (i & 32) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f, (i & 64) != 0 ? PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(6), Dp.constructor-impl(2)) : paddingValues, (i & 128) != 0 ? PaddingKt.PaddingValues-a9UjIt4$default(0.0f, Dp.constructor-impl(1), Dp.constructor-impl(4), Dp.constructor-impl(1), 1, (Object) null) : paddingValues2, (i & 256) != 0 ? new Background.Fill(ColorKt.Color(4294896874L), null, 2, null) : background, null);
        }

        public final String getText() {
            return this.text;
        }

        /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
        public final long m513getTextColor0d7_KjU() {
            return this.textColor;
        }

        /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
        public final long m510getFontSizeXSAIIZE() {
            return this.fontSize;
        }

        /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
        public final long m511getLineHeightXSAIIZE() {
            return this.lineHeight;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
        public final float m512getMaxWidthD9Ej5fM() {
            return this.maxWidth;
        }

        public final PaddingValues getPadding() {
            return this.padding;
        }

        public final PaddingValues getSpacing() {
            return this.spacing;
        }

        public final Background getBackground() {
            return this.background;
        }
    }

    /* compiled from: AdTag.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0010J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JB\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lkntr/app/ad/ui/uikit/components/TagContent$Icon;", "Lkntr/app/ad/ui/uikit/components/TagContent;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "width", "Landroidx/compose/ui/unit/Dp;", "height", "spacing", "Landroidx/compose/foundation/layout/PaddingValues;", "background", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "<init>", "(Ljava/lang/String;FFLandroidx/compose/foundation/layout/PaddingValues;Lkntr/app/ad/ui/uikit/modifiers/Background;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getWidth-D9Ej5fM", "()F", "F", "getHeight-D9Ej5fM", "getSpacing", "()Landroidx/compose/foundation/layout/PaddingValues;", "getBackground", "()Lkntr/app/ad/ui/uikit/modifiers/Background;", "component1", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component5", "copy", "copy-73KfpEQ", "(Ljava/lang/String;FFLandroidx/compose/foundation/layout/PaddingValues;Lkntr/app/ad/ui/uikit/modifiers/Background;)Lkntr/app/ad/ui/uikit/components/TagContent$Icon;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Icon extends TagContent {
        public static final int $stable = 0;
        private final Background background;
        private final float height;
        private final PaddingValues spacing;
        private final String url;
        private final float width;

        public /* synthetic */ Icon(String str, float f, float f2, PaddingValues paddingValues, Background background, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, paddingValues, background);
        }

        /* renamed from: copy-73KfpEQ$default  reason: not valid java name */
        public static /* synthetic */ Icon m498copy73KfpEQ$default(Icon icon, String str, float f, float f2, PaddingValues paddingValues, Background background, int i, Object obj) {
            if ((i & 1) != 0) {
                str = icon.url;
            }
            if ((i & 2) != 0) {
                f = icon.width;
            }
            float f3 = f;
            if ((i & 4) != 0) {
                f2 = icon.height;
            }
            float f4 = f2;
            if ((i & 8) != 0) {
                paddingValues = icon.spacing;
            }
            PaddingValues paddingValues2 = paddingValues;
            if ((i & 16) != 0) {
                background = icon.background;
            }
            return icon.m501copy73KfpEQ(str, f3, f4, paddingValues2, background);
        }

        public final String component1() {
            return this.url;
        }

        /* renamed from: component2-D9Ej5fM  reason: not valid java name */
        public final float m499component2D9Ej5fM() {
            return this.width;
        }

        /* renamed from: component3-D9Ej5fM  reason: not valid java name */
        public final float m500component3D9Ej5fM() {
            return this.height;
        }

        public final PaddingValues component4() {
            return this.spacing;
        }

        public final Background component5() {
            return this.background;
        }

        /* renamed from: copy-73KfpEQ  reason: not valid java name */
        public final Icon m501copy73KfpEQ(String str, float f, float f2, PaddingValues paddingValues, Background background) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(paddingValues, "spacing");
            Intrinsics.checkNotNullParameter(background, "background");
            return new Icon(str, f, f2, paddingValues, background, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Icon) {
                Icon icon = (Icon) obj;
                return Intrinsics.areEqual(this.url, icon.url) && Dp.equals-impl0(this.width, icon.width) && Dp.equals-impl0(this.height, icon.height) && Intrinsics.areEqual(this.spacing, icon.spacing) && Intrinsics.areEqual(this.background, icon.background);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.url.hashCode() * 31) + Dp.hashCode-impl(this.width)) * 31) + Dp.hashCode-impl(this.height)) * 31) + this.spacing.hashCode()) * 31) + this.background.hashCode();
        }

        public String toString() {
            String str = this.url;
            String str2 = Dp.toString-impl(this.width);
            String str3 = Dp.toString-impl(this.height);
            PaddingValues paddingValues = this.spacing;
            return "Icon(url=" + str + ", width=" + str2 + ", height=" + str3 + ", spacing=" + paddingValues + ", background=" + this.background + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Icon(String url, float width, float height, PaddingValues spacing, Background background) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(spacing, "spacing");
            Intrinsics.checkNotNullParameter(background, "background");
            this.url = url;
            this.width = width;
            this.height = height;
            this.spacing = spacing;
            this.background = background;
        }

        public /* synthetic */ Icon(String str, float f, float f2, PaddingValues paddingValues, Background background, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, (i & 8) != 0 ? PaddingKt.PaddingValues-a9UjIt4$default(0.0f, Dp.constructor-impl(0), Dp.constructor-impl(4), Dp.constructor-impl(0), 1, (Object) null) : paddingValues, (i & 16) != 0 ? Background.NoBackground.INSTANCE : background, null);
        }

        public final String getUrl() {
            return this.url;
        }

        /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
        public final float m503getWidthD9Ej5fM() {
            return this.width;
        }

        /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
        public final float m502getHeightD9Ej5fM() {
            return this.height;
        }

        public final PaddingValues getSpacing() {
            return this.spacing;
        }

        public final Background getBackground() {
            return this.background;
        }
    }
}