package j$.util;

import j$.util.Comparators;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface Comparator<T> {

    /* compiled from: D8$$SyntheticClass */
    /* renamed from: j$.util.Comparator$-EL  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ java.util.Comparator reversed(java.util.Comparator comparator) {
            return comparator instanceof Comparator ? ((Comparator) comparator).reversed() : Collections.reverseOrder(comparator);
        }

        public static /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(comparator2) : CC.$default$thenComparing(comparator, comparator2);
        }

        public static /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator, Function function) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(function) : CC.$default$thenComparing(comparator, function);
        }

        public static /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(function, comparator2) : CC.$default$thenComparing(comparator, function, comparator2);
        }

        public static /* synthetic */ java.util.Comparator thenComparingDouble(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparingDouble(toDoubleFunction) : CC.$default$thenComparingDouble(comparator, toDoubleFunction);
        }

        public static /* synthetic */ java.util.Comparator thenComparingInt(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparingInt(toIntFunction) : CC.$default$thenComparingInt(comparator, toIntFunction);
        }

        public static /* synthetic */ java.util.Comparator thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparingLong(toLongFunction) : CC.$default$thenComparingLong(comparator, toLongFunction);
        }
    }

    java.util.Comparator<T> reversed();

    java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator);

    <U extends Comparable<? super U>> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function);

    <U> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator);

    java.util.Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> toDoubleFunction);

    java.util.Comparator<T> thenComparingInt(ToIntFunction<? super T> toIntFunction);

    java.util.Comparator<T> thenComparingLong(ToLongFunction<? super T> toLongFunction);

    /* renamed from: j$.util.Comparator$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static java.util.Comparator $default$thenComparing(java.util.Comparator _this, java.util.Comparator comparator) {
            Objects.requireNonNull(comparator);
            return new Comparator$$ExternalSyntheticLambda1(_this, comparator);
        }

        public static /* synthetic */ int $private$lambda$thenComparing$36697e65$1(java.util.Comparator _this, java.util.Comparator other, Object c1, Object c2) {
            int res = _this.compare(c1, c2);
            return res != 0 ? res : other.compare(c1, c2);
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator _this, Function function, java.util.Comparator comparator) {
            return EL.thenComparing(_this, comparing(function, comparator));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator _this, Function function) {
            return EL.thenComparing(_this, comparing(function));
        }

        public static java.util.Comparator $default$thenComparingInt(java.util.Comparator _this, ToIntFunction toIntFunction) {
            return EL.thenComparing(_this, comparingInt(toIntFunction));
        }

        public static java.util.Comparator $default$thenComparingLong(java.util.Comparator _this, ToLongFunction toLongFunction) {
            return EL.thenComparing(_this, comparingLong(toLongFunction));
        }

        public static java.util.Comparator $default$thenComparingDouble(java.util.Comparator _this, ToDoubleFunction toDoubleFunction) {
            return EL.thenComparing(_this, comparingDouble(toDoubleFunction));
        }

        public static <T extends Comparable<? super T>> java.util.Comparator<T> reverseOrder() {
            return Collections.reverseOrder();
        }

        public static <T extends Comparable<? super T>> java.util.Comparator<T> naturalOrder() {
            return Comparators.NaturalOrderComparator.INSTANCE;
        }

        public static <T> java.util.Comparator<T> nullsFirst(java.util.Comparator<? super T> comparator) {
            return new Comparators.NullComparator(true, comparator);
        }

        public static <T> java.util.Comparator<T> nullsLast(java.util.Comparator<? super T> comparator) {
            return new Comparators.NullComparator(false, comparator);
        }

        public static <T, U> java.util.Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, java.util.Comparator<? super U> keyComparator) {
            Objects.requireNonNull(keyExtractor);
            Objects.requireNonNull(keyComparator);
            return new Comparator$$ExternalSyntheticLambda5(keyComparator, keyExtractor);
        }

        public static <T, U extends Comparable<? super U>> java.util.Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
            Objects.requireNonNull(keyExtractor);
            return new Comparator$$ExternalSyntheticLambda3(keyExtractor);
        }

        public static <T> java.util.Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
            Objects.requireNonNull(keyExtractor);
            return new Comparator$$ExternalSyntheticLambda0(keyExtractor);
        }

        public static <T> java.util.Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
            Objects.requireNonNull(keyExtractor);
            return new Comparator$$ExternalSyntheticLambda4(keyExtractor);
        }

        public static <T> java.util.Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
            Objects.requireNonNull(keyExtractor);
            return new Comparator$$ExternalSyntheticLambda2(keyExtractor);
        }
    }
}