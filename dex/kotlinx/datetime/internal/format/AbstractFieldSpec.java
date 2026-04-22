package kotlinx.datetime.internal.format;

import kotlin.Metadata;

/* compiled from: FieldSpec.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/internal/format/AbstractFieldSpec;", "Target", "Type", "Lkotlinx/datetime/internal/format/FieldSpec;", "()V", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractFieldSpec<Target, Type> implements FieldSpec<Target, Type> {
    public String toString() {
        return "The field " + getName() + " (default value is " + getDefaultValue() + ')';
    }
}