package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/MonthNameDirective;", "Lkotlinx/datetime/internal/format/NamedUnsignedIntFieldFormatDirective;", "Lkotlinx/datetime/format/DateFieldContainer;", "names", "Lkotlinx/datetime/format/MonthNames;", "(Lkotlinx/datetime/format/MonthNames;)V", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MonthNameDirective extends NamedUnsignedIntFieldFormatDirective<DateFieldContainer> {
    private final MonthNames names;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonthNameDirective(MonthNames names) {
        super(DateFields.INSTANCE.getMonth(), names.getNames(), "monthName");
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        String kotlinCode;
        StringBuilder append = new StringBuilder().append("monthName(");
        kotlinCode = LocalDateFormatKt.toKotlinCode(this.names);
        return append.append(kotlinCode).append(')').toString();
    }

    public boolean equals(Object other) {
        return (other instanceof MonthNameDirective) && Intrinsics.areEqual(this.names.getNames(), ((MonthNameDirective) other).names.getNames());
    }

    public int hashCode() {
        return this.names.getNames().hashCode();
    }
}