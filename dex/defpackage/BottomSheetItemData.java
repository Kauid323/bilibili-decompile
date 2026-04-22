package defpackage;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import com.bilibili.crow.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomBottomSheet.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b&\b\u0081\b\u0018\u00002\u00020\u0001Bx\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0015\b\u0002\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b+\u0010\u001dJ\u0010\u0010,\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b-\u0010\u001dJ\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\u0085\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0015\b\u0002\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001¢\u0006\u0004\b3\u00104J\u0013\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u000fHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R \u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"LBottomSheetItemData;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "summary", "iconProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/Composable;", "iconTint", "Landroidx/compose/ui/graphics/Color;", "textColor", "showArrowRight", BuildConfig.FLAVOR, "maxLines", BuildConfig.FLAVOR, "enabled", "onClick", "Lkotlin/Function1;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;JJZIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getSummary", "getIconProvider", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getIconTint-0d7_KjU", "()J", "J", "getTextColor-0d7_KjU", "getShowArrowRight", "()Z", "getMaxLines", "()I", "getEnabled", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component7", "component8", "component9", "copy", "copy-jB83MbM", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;JJZIZLkotlin/jvm/functions/Function1;)LBottomSheetItemData;", "equals", "other", "hashCode", "toString", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: BottomSheetItemData  reason: default package */
public final class BottomSheetItemData {
    public static final int $stable = 0;
    private final boolean enabled;
    private final Function2<Composer, Integer, Painter> iconProvider;
    private final long iconTint;
    private final int maxLines;
    private final Function1<Integer, Unit> onClick;
    private final boolean showArrowRight;
    private final String summary;
    private final String text;
    private final long textColor;

    public /* synthetic */ BottomSheetItemData(String str, String str2, Function2 function2, long j, long j2, boolean z, int i, boolean z2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, function2, j, j2, z, i, z2, function1);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.summary;
    }

    public final Function2<Composer, Integer, Painter> component3() {
        return this.iconProvider;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m1component40d7_KjU() {
        return this.iconTint;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m2component50d7_KjU() {
        return this.textColor;
    }

    public final boolean component6() {
        return this.showArrowRight;
    }

    public final int component7() {
        return this.maxLines;
    }

    public final boolean component8() {
        return this.enabled;
    }

    public final Function1<Integer, Unit> component9() {
        return this.onClick;
    }

    /* renamed from: copy-jB83MbM  reason: not valid java name */
    public final BottomSheetItemData m3copyjB83MbM(String str, String str2, Function2<? super Composer, ? super Integer, ? extends Painter> function2, long j, long j2, boolean z, int i, boolean z2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        return new BottomSheetItemData(str, str2, function2, j, j2, z, i, z2, function1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BottomSheetItemData) {
            BottomSheetItemData bottomSheetItemData = (BottomSheetItemData) obj;
            return Intrinsics.areEqual(this.text, bottomSheetItemData.text) && Intrinsics.areEqual(this.summary, bottomSheetItemData.summary) && Intrinsics.areEqual(this.iconProvider, bottomSheetItemData.iconProvider) && Color.equals-impl0(this.iconTint, bottomSheetItemData.iconTint) && Color.equals-impl0(this.textColor, bottomSheetItemData.textColor) && this.showArrowRight == bottomSheetItemData.showArrowRight && this.maxLines == bottomSheetItemData.maxLines && this.enabled == bottomSheetItemData.enabled && Intrinsics.areEqual(this.onClick, bottomSheetItemData.onClick);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.text.hashCode() * 31) + (this.summary == null ? 0 : this.summary.hashCode())) * 31) + (this.iconProvider != null ? this.iconProvider.hashCode() : 0)) * 31) + Color.hashCode-impl(this.iconTint)) * 31) + Color.hashCode-impl(this.textColor)) * 31) + BottomSheetItemData$$ExternalSyntheticBackport0.m(this.showArrowRight)) * 31) + this.maxLines) * 31) + BottomSheetItemData$$ExternalSyntheticBackport0.m(this.enabled)) * 31) + this.onClick.hashCode();
    }

    public String toString() {
        String str = this.text;
        String str2 = this.summary;
        Function2<Composer, Integer, Painter> function2 = this.iconProvider;
        String str3 = Color.toString-impl(this.iconTint);
        String str4 = Color.toString-impl(this.textColor);
        boolean z = this.showArrowRight;
        int i = this.maxLines;
        boolean z2 = this.enabled;
        return "BottomSheetItemData(text=" + str + ", summary=" + str2 + ", iconProvider=" + function2 + ", iconTint=" + str3 + ", textColor=" + str4 + ", showArrowRight=" + z + ", maxLines=" + i + ", enabled=" + z2 + ", onClick=" + this.onClick + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BottomSheetItemData(String text, String summary, Function2<? super Composer, ? super Integer, ? extends Painter> function2, long iconTint, long textColor, boolean showArrowRight, int maxLines, boolean enabled, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        this.text = text;
        this.summary = summary;
        this.iconProvider = function2;
        this.iconTint = iconTint;
        this.textColor = textColor;
        this.showArrowRight = showArrowRight;
        this.maxLines = maxLines;
        this.enabled = enabled;
        this.onClick = function1;
    }

    public /* synthetic */ BottomSheetItemData(String str, String str2, Function2 function2, long j, long j2, boolean z, int i, boolean z2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : function2, (i2 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j, (i2 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j2, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? 1 : i, (i2 & 128) != 0 ? true : z2, function1, null);
    }

    public final String getText() {
        return this.text;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Function2<Composer, Integer, Painter> getIconProvider() {
        return this.iconProvider;
    }

    /* renamed from: getIconTint-0d7_KjU  reason: not valid java name */
    public final long m4getIconTint0d7_KjU() {
        return this.iconTint;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m5getTextColor0d7_KjU() {
        return this.textColor;
    }

    public final boolean getShowArrowRight() {
        return this.showArrowRight;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }
}