package kntr.common.ouro.ui.utils;

import androidx.compose.ui.text.TextRange;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.OuroCustomStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/ui/utils/CustomAnnotation;", "T", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "", "range", "Landroidx/compose/ui/text/TextRange;", "value", "<init>", "(JLkntr/common/ouro/ui/utils/OuroCustomStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRange-d9O1mEE", "()J", "J", "getValue", "()Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "component1", "component1-d9O1mEE", "component2", "copy", "copy-72CqOWE", "(JLkntr/common/ouro/ui/utils/OuroCustomStyle;)Lkntr/common/ouro/ui/utils/CustomAnnotation;", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CustomAnnotation<T extends OuroCustomStyle> {
    public static final int $stable = 0;
    private final long range;
    private final T value;

    public /* synthetic */ CustomAnnotation(long j, OuroCustomStyle ouroCustomStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, ouroCustomStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-72CqOWE$default  reason: not valid java name */
    public static /* synthetic */ CustomAnnotation m2116copy72CqOWE$default(CustomAnnotation customAnnotation, long j, OuroCustomStyle ouroCustomStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            j = customAnnotation.range;
        }
        if ((i & 2) != 0) {
            ouroCustomStyle = customAnnotation.value;
        }
        return customAnnotation.m2118copy72CqOWE(j, ouroCustomStyle);
    }

    /* renamed from: component1-d9O1mEE  reason: not valid java name */
    public final long m2117component1d9O1mEE() {
        return this.range;
    }

    public final T component2() {
        return this.value;
    }

    /* renamed from: copy-72CqOWE  reason: not valid java name */
    public final CustomAnnotation<T> m2118copy72CqOWE(long j, T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        return new CustomAnnotation<>(j, t, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomAnnotation) {
            CustomAnnotation customAnnotation = (CustomAnnotation) obj;
            return TextRange.equals-impl0(this.range, customAnnotation.range) && Intrinsics.areEqual(this.value, customAnnotation.value);
        }
        return false;
    }

    public int hashCode() {
        return (TextRange.hashCode-impl(this.range) * 31) + this.value.hashCode();
    }

    public String toString() {
        String str = TextRange.toString-impl(this.range);
        return "CustomAnnotation(range=" + str + ", value=" + this.value + ")";
    }

    private CustomAnnotation(long range, T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        this.range = range;
        this.value = t;
    }

    /* renamed from: getRange-d9O1mEE  reason: not valid java name */
    public final long m2119getRanged9O1mEE() {
        return this.range;
    }

    public final T getValue() {
        return this.value;
    }
}