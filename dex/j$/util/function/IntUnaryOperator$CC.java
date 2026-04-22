package j$.util.function;

import j$.util.Objects;
import java.util.function.IntUnaryOperator;

/* renamed from: j$.util.function.IntUnaryOperator$-CC  reason: invalid class name */
public final /* synthetic */ class IntUnaryOperator$CC {
    public static IntUnaryOperator $default$compose(final IntUnaryOperator _this, final IntUnaryOperator before) {
        Objects.requireNonNull(before);
        return new IntUnaryOperator() { // from class: j$.util.function.IntUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$andThen(this, intUnaryOperator);
            }

            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                int applyAsInt;
                applyAsInt = IntUnaryOperator.this.applyAsInt(before.applyAsInt(i));
                return applyAsInt;
            }

            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$compose(this, intUnaryOperator);
            }
        };
    }

    public static IntUnaryOperator $default$andThen(final IntUnaryOperator _this, final IntUnaryOperator after) {
        Objects.requireNonNull(after);
        return new IntUnaryOperator() { // from class: j$.util.function.IntUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$andThen(this, intUnaryOperator);
            }

            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                int applyAsInt;
                applyAsInt = after.applyAsInt(IntUnaryOperator.this.applyAsInt(i));
                return applyAsInt;
            }

            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$compose(this, intUnaryOperator);
            }
        };
    }

    public static IntUnaryOperator identity() {
        return new IntUnaryOperator() { // from class: j$.util.function.IntUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$andThen(this, intUnaryOperator);
            }

            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                return IntUnaryOperator$CC.lambda$identity$2(i);
            }

            @Override // java.util.function.IntUnaryOperator
            public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
                return IntUnaryOperator$CC.$default$compose(this, intUnaryOperator);
            }
        };
    }

    public static /* synthetic */ int lambda$identity$2(int t) {
        return t;
    }
}