package j$.util.function;

import j$.util.Objects;
import java.util.function.DoubleUnaryOperator;

/* renamed from: j$.util.function.DoubleUnaryOperator$-CC  reason: invalid class name */
public final /* synthetic */ class DoubleUnaryOperator$CC {
    public static DoubleUnaryOperator $default$compose(final DoubleUnaryOperator _this, final DoubleUnaryOperator before) {
        Objects.requireNonNull(before);
        return new DoubleUnaryOperator() { // from class: j$.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$andThen(this, doubleUnaryOperator);
            }

            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d) {
                double applyAsDouble;
                applyAsDouble = DoubleUnaryOperator.this.applyAsDouble(before.applyAsDouble(d));
                return applyAsDouble;
            }

            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$compose(this, doubleUnaryOperator);
            }
        };
    }

    public static DoubleUnaryOperator $default$andThen(final DoubleUnaryOperator _this, final DoubleUnaryOperator after) {
        Objects.requireNonNull(after);
        return new DoubleUnaryOperator() { // from class: j$.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$andThen(this, doubleUnaryOperator);
            }

            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d) {
                double applyAsDouble;
                applyAsDouble = after.applyAsDouble(DoubleUnaryOperator.this.applyAsDouble(d));
                return applyAsDouble;
            }

            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$compose(this, doubleUnaryOperator);
            }
        };
    }

    public static DoubleUnaryOperator identity() {
        return new DoubleUnaryOperator() { // from class: j$.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$andThen(this, doubleUnaryOperator);
            }

            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d) {
                return DoubleUnaryOperator$CC.lambda$identity$2(d);
            }

            @Override // java.util.function.DoubleUnaryOperator
            public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
                return DoubleUnaryOperator$CC.$default$compose(this, doubleUnaryOperator);
            }
        };
    }

    public static /* synthetic */ double lambda$identity$2(double t) {
        return t;
    }
}