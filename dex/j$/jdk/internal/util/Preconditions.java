package j$.jdk.internal.util;

import j$.time.Duration$DurationUnits$$ExternalSyntheticBackport0;
import j$.util.DesugarCalendar;
import j$.util.function.BiFunction$CC;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Preconditions {
    private static RuntimeException outOfBounds(BiFunction<String, List<Integer>, ? extends RuntimeException> oobef, String checkKind, Integer... args) {
        List<Integer> largs = Duration$DurationUnits$$ExternalSyntheticBackport0.m(args);
        RuntimeException e = oobef == null ? null : oobef.apply(checkKind, largs);
        return e == null ? new IndexOutOfBoundsException(outOfBoundsMessage(checkKind, largs)) : e;
    }

    private static RuntimeException outOfBoundsCheckIndex(BiFunction<String, List<Integer>, ? extends RuntimeException> oobe, int index, int length) {
        return outOfBounds(oobe, "checkIndex", Integer.valueOf(index), Integer.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromToIndex(BiFunction<String, List<Integer>, ? extends RuntimeException> oobe, int fromIndex, int toIndex, int length) {
        return outOfBounds(oobe, "checkFromToIndex", Integer.valueOf(fromIndex), Integer.valueOf(toIndex), Integer.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromIndexSize(BiFunction<String, List<Integer>, ? extends RuntimeException> oobe, int fromIndex, int size, int length) {
        return outOfBounds(oobe, "checkFromIndexSize", Integer.valueOf(fromIndex), Integer.valueOf(size), Integer.valueOf(length));
    }

    public static <X extends RuntimeException> BiFunction<String, List<Integer>, X> outOfBoundsExceptionFormatter(final Function<String, X> f) {
        return (BiFunction<String, List<Integer>, X>) new BiFunction<String, List<Integer>, X>() { // from class: j$.jdk.internal.util.Preconditions.1
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public /* bridge */ /* synthetic */ Object apply(String str, List<Integer> list) {
                return apply2(str, (List) list);
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;Ljava/util/List<Ljava/lang/Integer;>;)TX; */
            /* renamed from: apply  reason: avoid collision after fix types in other method */
            public RuntimeException apply2(String checkKind, List list) {
                return (RuntimeException) Function.this.apply(Preconditions.outOfBoundsMessage(checkKind, list));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String outOfBoundsMessage(String checkKind, List<Integer> args) {
        boolean z;
        if (checkKind == null && args == null) {
            return String.format("Range check failed", new Object[0]);
        }
        if (checkKind == null) {
            return String.format("Range check failed: %s", args);
        }
        if (args == null) {
            return String.format("Range check failed: %s", checkKind);
        }
        int argSize = 0;
        char c = 65535;
        switch (checkKind.hashCode()) {
            case -538822486:
                if (checkKind.equals("checkIndex")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1844394469:
                if (checkKind.equals("checkFromToIndex")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1848935233:
                if (checkKind.equals("checkFromIndexSize")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                argSize = 2;
                break;
            case true:
            case DesugarCalendar.LONG_FORMAT /* 2 */:
                argSize = 3;
                break;
        }
        String str = args.size() != argSize ? "" : checkKind;
        switch (str.hashCode()) {
            case -538822486:
                if (str.equals("checkIndex")) {
                    c = 0;
                    break;
                }
                break;
            case 1844394469:
                if (str.equals("checkFromToIndex")) {
                    c = 1;
                    break;
                }
                break;
            case 1848935233:
                if (str.equals("checkFromIndexSize")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return String.format("Index %d out of bounds for length %d", args.get(0), args.get(1));
            case 1:
                return String.format("Range [%d, %d) out of bounds for length %d", args.get(0), args.get(1), args.get(2));
            case DesugarCalendar.LONG_FORMAT /* 2 */:
                return String.format("Range [%d, %<d + %d) out of bounds for length %d", args.get(0), args.get(1), args.get(2));
            default:
                return String.format("Range check failed: %s %s", checkKind, args);
        }
    }

    public static <X extends RuntimeException> int checkIndex(int index, int length, BiFunction<String, List<Integer>, X> oobef) {
        if (index < 0 || index >= length) {
            throw outOfBoundsCheckIndex(oobef, index, length);
        }
        return index;
    }

    public static <X extends RuntimeException> int checkFromToIndex(int fromIndex, int toIndex, int length, BiFunction<String, List<Integer>, X> oobef) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > length) {
            throw outOfBoundsCheckFromToIndex(oobef, fromIndex, toIndex, length);
        }
        return fromIndex;
    }

    public static <X extends RuntimeException> int checkFromIndexSize(int fromIndex, int size, int length, BiFunction<String, List<Integer>, X> oobef) {
        if ((length | fromIndex | size) < 0 || size > length - fromIndex) {
            throw outOfBoundsCheckFromIndexSize(oobef, fromIndex, size, length);
        }
        return fromIndex;
    }
}