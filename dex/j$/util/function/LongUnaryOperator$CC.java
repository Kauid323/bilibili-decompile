package j$.util.function;

import j$.util.Objects;
import java.util.function.LongUnaryOperator;

/* renamed from: j$.util.function.LongUnaryOperator$-CC  reason: invalid class name */
public final /* synthetic */ class LongUnaryOperator$CC {
    public static LongUnaryOperator $default$compose(final LongUnaryOperator _this, final LongUnaryOperator before) {
        Objects.requireNonNull(before);
        return new LongUnaryOperator() { // from class: j$.util.function.LongUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$andThen(this, longUnaryOperator);
            }

            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j) {
                long applyAsLong;
                applyAsLong = LongUnaryOperator.this.applyAsLong(before.applyAsLong(j));
                return applyAsLong;
            }

            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$compose(this, longUnaryOperator);
            }
        };
    }

    public static LongUnaryOperator $default$andThen(final LongUnaryOperator _this, final LongUnaryOperator after) {
        Objects.requireNonNull(after);
        return new LongUnaryOperator() { // from class: j$.util.function.LongUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$andThen(this, longUnaryOperator);
            }

            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j) {
                long applyAsLong;
                applyAsLong = after.applyAsLong(LongUnaryOperator.this.applyAsLong(j));
                return applyAsLong;
            }

            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$compose(this, longUnaryOperator);
            }
        };
    }

    public static LongUnaryOperator identity() {
        return new LongUnaryOperator() { // from class: j$.util.function.LongUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$andThen(this, longUnaryOperator);
            }

            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j) {
                return LongUnaryOperator$CC.lambda$identity$2(j);
            }

            @Override // java.util.function.LongUnaryOperator
            public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
                return LongUnaryOperator$CC.$default$compose(this, longUnaryOperator);
            }
        };
    }

    public static /* synthetic */ long lambda$identity$2(long t) {
        return t;
    }
}