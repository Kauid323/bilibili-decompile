package kotlinx.datetime.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.DecimalFractionFieldFormatDirective;

/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/format/FractionalSecondDirective;", "Lkotlinx/datetime/internal/format/DecimalFractionFieldFormatDirective;", "Lkotlinx/datetime/format/TimeFieldContainer;", "minDigits", "", "maxDigits", "zerosToAdd", "", "(IILjava/util/List;)V", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FractionalSecondDirective extends DecimalFractionFieldFormatDirective<TimeFieldContainer> {
    private final int maxDigits;
    private final int minDigits;
    public static final Companion Companion = new Companion(null);
    private static final List<Integer> NO_EXTRA_ZEROS = CollectionsKt.listOf((Object[]) new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final List<Integer> GROUP_BY_THREE = CollectionsKt.listOf((Object[]) new Integer[]{2, 1, 0, 2, 1, 0, 2, 1, 0});

    public /* synthetic */ FractionalSecondDirective(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? NO_EXTRA_ZEROS : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FractionalSecondDirective(int minDigits, int maxDigits, List<Integer> zerosToAdd) {
        super(TimeFields.INSTANCE.getFractionOfSecond(), minDigits, maxDigits, zerosToAdd);
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.minDigits = minDigits;
        this.maxDigits = maxDigits;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        if (this.minDigits == 1 && this.maxDigits == 9) {
            return "secondFraction()";
        }
        if (this.minDigits == 1) {
            return "secondFraction(maxLength = " + this.maxDigits + ')';
        }
        if (this.maxDigits == 1) {
            return "secondFraction(minLength = " + this.minDigits + ')';
        }
        return this.maxDigits == this.minDigits ? "secondFraction(" + this.minDigits + ')' : "secondFraction(" + this.minDigits + ", " + this.maxDigits + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof FractionalSecondDirective) && this.minDigits == ((FractionalSecondDirective) other).minDigits && this.maxDigits == ((FractionalSecondDirective) other).maxDigits;
    }

    public int hashCode() {
        return (this.minDigits * 31) + this.maxDigits;
    }

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/FractionalSecondDirective$Companion;", "", "()V", "GROUP_BY_THREE", "", "", "getGROUP_BY_THREE", "()Ljava/util/List;", "NO_EXTRA_ZEROS", "getNO_EXTRA_ZEROS", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Integer> getNO_EXTRA_ZEROS() {
            return FractionalSecondDirective.NO_EXTRA_ZEROS;
        }

        public final List<Integer> getGROUP_BY_THREE() {
            return FractionalSecondDirective.GROUP_BY_THREE;
        }
    }
}