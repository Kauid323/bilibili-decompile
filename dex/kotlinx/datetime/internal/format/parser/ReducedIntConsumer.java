package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.MathKt;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ/\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ReducedIntConsumer;", "Receiver", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "length", "", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "name", "", "base", "(ILkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;I)V", "getBase", "()I", "baseFloor", "baseMod", "getLength", "()Ljava/lang/Integer;", "modulo", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", "start", "end", "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReducedIntConsumer<Receiver> extends NumberConsumer<Receiver> {
    private final int base;
    private final int baseFloor;
    private final int baseMod;
    private final int length;
    private final int modulo;
    private final AssignableField<Receiver, Integer> setter;

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public Integer getLength() {
        return Integer.valueOf(this.length);
    }

    public final int getBase() {
        return this.base;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntConsumer(int length, AssignableField<? super Receiver, Integer> setter, String name, int base) {
        super(Integer.valueOf(length), name, null);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.length = length;
        this.setter = setter;
        this.base = base;
        this.modulo = MathKt.getPOWERS_OF_TEN()[getLength().intValue()];
        this.baseMod = this.base % this.modulo;
        this.baseFloor = this.base - this.baseMod;
        int intValue = getLength().intValue();
        boolean z = false;
        if (1 <= intValue && intValue < 10) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Invalid length for field " + getWhatThisExpects() + ": " + getLength().intValue()).toString());
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public NumberConsumptionError consume(Receiver receiver, CharSequence input, int start, int end) {
        int result;
        int i;
        NumberConsumptionError withoutReassigning;
        Intrinsics.checkNotNullParameter(input, "input");
        result = NumberConsumerKt.parseAsciiInt(input, start, end);
        AssignableField<Receiver, Integer> assignableField = this.setter;
        if (result >= this.baseMod) {
            i = this.baseFloor + result;
        } else {
            i = this.baseFloor + this.modulo + result;
        }
        withoutReassigning = NumberConsumerKt.setWithoutReassigning(assignableField, receiver, Integer.valueOf(i));
        return withoutReassigning;
    }
}