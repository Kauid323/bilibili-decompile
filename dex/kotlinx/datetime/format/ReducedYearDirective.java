package kotlinx.datetime.format;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.internal.format.ReducedIntFieldDirective;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/ReducedYearDirective;", "Lkotlinx/datetime/internal/format/ReducedIntFieldDirective;", "Lkotlinx/datetime/format/DateFieldContainer;", "base", "", "isYearOfEra", "", "(IZ)V", "getBase", "()I", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "other", "", "hashCode", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReducedYearDirective extends ReducedIntFieldDirective<DateFieldContainer> {
    private final int base;
    private final boolean isYearOfEra;

    public /* synthetic */ ReducedYearDirective(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    public final int getBase() {
        return this.base;
    }

    public ReducedYearDirective(int base, boolean isYearOfEra) {
        super(DateFields.INSTANCE.getYear(), 2, base);
        this.base = base;
        this.isYearOfEra = isYearOfEra;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        String it = "yearTwoDigits(" + this.base + ')';
        if (this.isYearOfEra) {
            return it + " /** TODO: the original format had an `y` directive, so the behavior is different on years earlier than 1 AD. See the [kotlinx.datetime.format.byUnicodePattern] documentation for details. */";
        }
        return it;
    }

    public boolean equals(Object other) {
        return (other instanceof ReducedYearDirective) && this.base == ((ReducedYearDirective) other).base && this.isYearOfEra == ((ReducedYearDirective) other).isYearOfEra;
    }

    public int hashCode() {
        return (this.base * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isYearOfEra);
    }
}