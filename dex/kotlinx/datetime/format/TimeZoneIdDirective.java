package kotlinx.datetime.format;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.StringFieldFormatDirective;

/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/TimeZoneIdDirective;", "Lkotlinx/datetime/internal/format/StringFieldFormatDirective;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "knownZones", "", "", "(Ljava/util/Set;)V", "builderRepresentation", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimeZoneIdDirective extends StringFieldFormatDirective<DateTimeComponentsContents> {
    private final Set<String> knownZones;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeZoneIdDirective(Set<String> knownZones) {
        super(DateTimeComponentsKt.getTimeZoneField(), knownZones);
        Intrinsics.checkNotNullParameter(knownZones, "knownZones");
        this.knownZones = knownZones;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return "timeZoneId()";
    }

    public boolean equals(Object other) {
        return (other instanceof TimeZoneIdDirective) && Intrinsics.areEqual(((TimeZoneIdDirective) other).knownZones, this.knownZones);
    }

    public int hashCode() {
        return this.knownZones.hashCode();
    }
}