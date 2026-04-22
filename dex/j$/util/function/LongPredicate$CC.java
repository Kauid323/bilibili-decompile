package j$.util.function;

import j$.util.Objects;
import java.util.function.LongPredicate;

/* renamed from: j$.util.function.LongPredicate$-CC  reason: invalid class name */
public final /* synthetic */ class LongPredicate$CC {
    public static LongPredicate $default$and(final LongPredicate _this, final LongPredicate other) {
        Objects.requireNonNull(other);
        return new LongPredicate() { // from class: j$.util.function.LongPredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$and(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate negate() {
                return LongPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$or(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public final boolean test(long j) {
                return LongPredicate$CC.$private$lambda$and$0(LongPredicate.this, other, j);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$and$0(LongPredicate _this, LongPredicate other, long value) {
        return _this.test(value) && other.test(value);
    }

    public static LongPredicate $default$negate(final LongPredicate _this) {
        return new LongPredicate() { // from class: j$.util.function.LongPredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$and(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate negate() {
                return LongPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$or(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public final boolean test(long j) {
                return LongPredicate$CC.$private$lambda$negate$1(LongPredicate.this, j);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$negate$1(LongPredicate _this, long value) {
        return !_this.test(value);
    }

    public static LongPredicate $default$or(final LongPredicate _this, final LongPredicate other) {
        Objects.requireNonNull(other);
        return new LongPredicate() { // from class: j$.util.function.LongPredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$and(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate negate() {
                return LongPredicate$CC.$default$negate(this);
            }

            @Override // java.util.function.LongPredicate
            public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
                return LongPredicate$CC.$default$or(this, longPredicate);
            }

            @Override // java.util.function.LongPredicate
            public final boolean test(long j) {
                return LongPredicate$CC.$private$lambda$or$2(LongPredicate.this, other, j);
            }
        };
    }

    public static /* synthetic */ boolean $private$lambda$or$2(LongPredicate _this, LongPredicate other, long value) {
        return _this.test(value) || other.test(value);
    }
}