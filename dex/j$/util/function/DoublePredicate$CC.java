package j$.util.function;

import j$.util.Objects;
import java.util.function.DoublePredicate;

/* renamed from: j$.util.function.DoublePredicate$-CC */
public final /* synthetic */ class DoublePredicate$CC {
    public static DoublePredicate $default$and(final DoublePredicate _this, final DoublePredicate other) {
        Objects.requireNonNull(other);
        return new DoublePredicate() { // from class: j$.util.function.DoublePredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$and(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate negate() {
                return DoublePredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$or(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public final boolean test(double d) {
                return DoublePredicate$CC.$private$lambda$and$0(DoublePredicate.this, other, d);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$and$0(DoublePredicate _this, DoublePredicate other, double value) {
        return _this.test(value) && other.test(value);
    }

    public static DoublePredicate $default$negate(final DoublePredicate _this) {
        return new DoublePredicate() { // from class: j$.util.function.DoublePredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$and(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate negate() {
                return DoublePredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$or(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public final boolean test(double d) {
                return DoublePredicate$CC.$private$lambda$negate$1(DoublePredicate.this, d);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$negate$1(DoublePredicate _this, double value) {
        return !_this.test(value);
    }

    public static DoublePredicate $default$or(final DoublePredicate _this, final DoublePredicate other) {
        Objects.requireNonNull(other);
        return new DoublePredicate() { // from class: j$.util.function.DoublePredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$and(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate negate() {
                return DoublePredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.DoublePredicate
            public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
                return DoublePredicate$CC.$default$or(this, doublePredicate);
            }

            @Override // java.util.function.DoublePredicate
            public final boolean test(double d) {
                return DoublePredicate$CC.$private$lambda$or$2(DoublePredicate.this, other, d);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$or$2(DoublePredicate _this, DoublePredicate other, double value) {
        return _this.test(value) || other.test(value);
    }
}