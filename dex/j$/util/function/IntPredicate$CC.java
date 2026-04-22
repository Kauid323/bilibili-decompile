package j$.util.function;

import j$.util.Objects;
import java.util.function.IntPredicate;

/* renamed from: j$.util.function.IntPredicate$-CC  reason: invalid class name */
public final /* synthetic */ class IntPredicate$CC {
    public static IntPredicate $default$and(final IntPredicate _this, final IntPredicate other) {
        Objects.requireNonNull(other);
        return new IntPredicate() { // from class: j$.util.function.IntPredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$and(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate negate() {
                return IntPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$or(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return IntPredicate$CC.$private$lambda$and$0(IntPredicate.this, other, i);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$and$0(IntPredicate _this, IntPredicate other, int value) {
        return _this.test(value) && other.test(value);
    }

    public static IntPredicate $default$negate(final IntPredicate _this) {
        return new IntPredicate() { // from class: j$.util.function.IntPredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$and(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate negate() {
                return IntPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$or(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return IntPredicate$CC.$private$lambda$negate$1(IntPredicate.this, i);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$negate$1(IntPredicate _this, int value) {
        return !_this.test(value);
    }

    public static IntPredicate $default$or(final IntPredicate _this, final IntPredicate other) {
        Objects.requireNonNull(other);
        return new IntPredicate() { // from class: j$.util.function.IntPredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$and(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate negate() {
                return IntPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.IntPredicate
            public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
                return IntPredicate$CC.$default$or(this, intPredicate);
            }

            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return IntPredicate$CC.$private$lambda$or$2(IntPredicate.this, other, i);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$or$2(IntPredicate _this, IntPredicate other, int value) {
        return _this.test(value) || other.test(value);
    }
}