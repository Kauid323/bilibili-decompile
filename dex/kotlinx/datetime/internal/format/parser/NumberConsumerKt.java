package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"parseAsciiInt", "", "", "start", "end", "parseAsciiIntOrNull", "(Ljava/lang/CharSequence;II)Ljava/lang/Integer;", "setWithoutReassigning", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "Object", "Type", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "receiver", "value", "(Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class NumberConsumerKt {
    public static final /* synthetic */ int access$parseAsciiInt(CharSequence $receiver, int start, int end) {
        return parseAsciiInt($receiver, start, end);
    }

    public static final /* synthetic */ NumberConsumptionError access$setWithoutReassigning(AssignableField $receiver, Object receiver, Object value) {
        return setWithoutReassigning($receiver, receiver, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> NumberConsumptionError setWithoutReassigning(AssignableField<? super Object, Type> assignableField, Object object, Type type) {
        Object conflictingValue = assignableField.trySetWithoutReassigning(object, type);
        if (conflictingValue == null) {
            return null;
        }
        return new NumberConsumptionError.Conflicting(conflictingValue);
    }

    public static final int parseAsciiInt(CharSequence $this$parseAsciiInt, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            char digit = $this$parseAsciiInt.charAt(i);
            result = (result * 10) + UtilKt.asciiDigitToInt(digit);
        }
        return result;
    }

    public static final Integer parseAsciiIntOrNull(CharSequence $this$parseAsciiIntOrNull, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            char digit = $this$parseAsciiIntOrNull.charAt(i);
            result = (result * 10) + UtilKt.asciiDigitToInt(digit);
            if (result < 0) {
                return null;
            }
        }
        return Integer.valueOf(result);
    }
}