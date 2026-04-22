package kntr.common.ouro.ui.textField;

import androidx.compose.ui.graphics.Color;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNativeTextField.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/ui/textField/HintText;", "", "text", "", "fontSize", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;IJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getFontSize", "()I", "getTextColor-0d7_KjU", "()J", "J", "component1", "component2", "component3", "component3-0d7_KjU", "copy", "copy-mxwnekA", "(Ljava/lang/String;IJ)Lkntr/common/ouro/ui/textField/HintText;", "equals", "", "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HintText {
    public static final int $stable = 0;
    private final int fontSize;
    private final String text;
    private final long textColor;

    public /* synthetic */ HintText(String str, int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, j);
    }

    /* renamed from: copy-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ HintText m2093copymxwnekA$default(HintText hintText, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hintText.text;
        }
        if ((i2 & 2) != 0) {
            i = hintText.fontSize;
        }
        if ((i2 & 4) != 0) {
            j = hintText.textColor;
        }
        return hintText.m2095copymxwnekA(str, i, j);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.fontSize;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m2094component30d7_KjU() {
        return this.textColor;
    }

    /* renamed from: copy-mxwnekA  reason: not valid java name */
    public final HintText m2095copymxwnekA(String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new HintText(str, i, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HintText) {
            HintText hintText = (HintText) obj;
            return Intrinsics.areEqual(this.text, hintText.text) && this.fontSize == hintText.fontSize && Color.equals-impl0(this.textColor, hintText.textColor);
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.fontSize) * 31) + Color.hashCode-impl(this.textColor);
    }

    public String toString() {
        String str = this.text;
        int i = this.fontSize;
        return "HintText(text=" + str + ", fontSize=" + i + ", textColor=" + Color.toString-impl(this.textColor) + ")";
    }

    private HintText(String text, int fontSize, long textColor) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
    }

    public final String getText() {
        return this.text;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m2096getTextColor0d7_KjU() {
        return this.textColor;
    }
}