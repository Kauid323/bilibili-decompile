package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public interface PrimitiveIterator<T, T_CONS> extends java.util.Iterator<T> {
    void forEachRemaining(T_CONS t_cons);

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfInt extends PrimitiveIterator<Integer, IntConsumer> {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfInt, Iterator {
            public final /* synthetic */ PrimitiveIterator.OfInt wrappedValue;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfInt ofInt) {
                this.wrappedValue = ofInt;
            }

            public static /* synthetic */ OfInt convert(PrimitiveIterator.OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof Wrapper ? OfInt.this : new VivifiedWrapper(ofInt);
            }

            public /* synthetic */ boolean equals(Object obj) {
                PrimitiveIterator.OfInt ofInt = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return ofInt.equals(obj);
            }

            @Override // j$.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                this.wrappedValue.forEachRemaining((PrimitiveIterator.OfInt) intConsumer);
            }

            @Override // j$.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.wrappedValue.forEachRemaining((Consumer<? super Integer>) consumer);
            }

            @Override // j$.util.PrimitiveIterator.OfInt
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
                this.wrappedValue.forEachRemaining(intConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return this.wrappedValue.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ Integer next() {
                return this.wrappedValue.next();
            }

            @Override // java.util.Iterator
            public /* synthetic */ Object next() {
                return this.wrappedValue.next();
            }

            @Override // j$.util.PrimitiveIterator.OfInt
            public /* synthetic */ int nextInt() {
                return this.wrappedValue.nextInt();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                this.wrappedValue.remove();
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfInt {
            private /* synthetic */ Wrapper() {
                OfInt.this = r1;
            }

            public static /* synthetic */ PrimitiveIterator.OfInt convert(OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof VivifiedWrapper ? ((VivifiedWrapper) ofInt).wrappedValue : new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfInt ofInt = OfInt.this;
                if (obj instanceof Wrapper) {
                    obj = OfInt.this;
                }
                return ofInt.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                OfInt.this.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                OfInt.this.forEachRemaining((Consumer<? super Integer>) consumer);
            }

            @Override // java.util.PrimitiveIterator.OfInt
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
                OfInt.this.forEachRemaining(intConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfInt.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfInt.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ Integer next() {
                return OfInt.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfInt.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public /* synthetic */ int nextInt() {
                return OfInt.this.nextInt();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfInt.this.remove();
            }
        }

        @Override // java.util.Iterator
        void forEachRemaining(Consumer<? super Integer> consumer);

        void forEachRemaining(IntConsumer intConsumer);

        @Override // java.util.Iterator
        Integer next();

        int nextInt();

        /* renamed from: j$.util.PrimitiveIterator$OfInt$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static /* bridge */ /* synthetic */ void $default$forEachRemaining(OfInt _this, Object obj) {
                _this.forEachRemaining((IntConsumer) obj);
            }

            /* renamed from: $default$next */
            public static /* bridge */ /* synthetic */ Object m44$default$next(OfInt _this) {
                return _this.next();
            }

            public static void $default$forEachRemaining(OfInt _this, IntConsumer action) {
                Objects.requireNonNull(action);
                while (_this.hasNext()) {
                    action.accept(_this.nextInt());
                }
            }

            public static Integer $default$next(OfInt _this) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfInt.nextInt()");
                }
                return Integer.valueOf(_this.nextInt());
            }

            public static void $default$forEachRemaining(OfInt _this, Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    _this.forEachRemaining((IntConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                }
                Objects.requireNonNull(consumer);
                _this.forEachRemaining((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfLong extends PrimitiveIterator<Long, LongConsumer> {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfLong, Iterator {
            public final /* synthetic */ PrimitiveIterator.OfLong wrappedValue;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfLong ofLong) {
                this.wrappedValue = ofLong;
            }

            public static /* synthetic */ OfLong convert(PrimitiveIterator.OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof Wrapper ? OfLong.this : new VivifiedWrapper(ofLong);
            }

            public /* synthetic */ boolean equals(Object obj) {
                PrimitiveIterator.OfLong ofLong = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return ofLong.equals(obj);
            }

            @Override // j$.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                this.wrappedValue.forEachRemaining((PrimitiveIterator.OfLong) longConsumer);
            }

            @Override // j$.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.wrappedValue.forEachRemaining((Consumer<? super Long>) consumer);
            }

            @Override // j$.util.PrimitiveIterator.OfLong
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
                this.wrappedValue.forEachRemaining(longConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return this.wrappedValue.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ Long next() {
                return this.wrappedValue.next();
            }

            @Override // java.util.Iterator
            public /* synthetic */ Object next() {
                return this.wrappedValue.next();
            }

            @Override // j$.util.PrimitiveIterator.OfLong
            public /* synthetic */ long nextLong() {
                return this.wrappedValue.nextLong();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                this.wrappedValue.remove();
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfLong {
            private /* synthetic */ Wrapper() {
                OfLong.this = r1;
            }

            public static /* synthetic */ PrimitiveIterator.OfLong convert(OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof VivifiedWrapper ? ((VivifiedWrapper) ofLong).wrappedValue : new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfLong ofLong = OfLong.this;
                if (obj instanceof Wrapper) {
                    obj = OfLong.this;
                }
                return ofLong.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                OfLong.this.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                OfLong.this.forEachRemaining((Consumer<? super Long>) consumer);
            }

            @Override // java.util.PrimitiveIterator.OfLong
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
                OfLong.this.forEachRemaining(longConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfLong.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfLong.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ Long next() {
                return OfLong.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfLong.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public /* synthetic */ long nextLong() {
                return OfLong.this.nextLong();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfLong.this.remove();
            }
        }

        @Override // java.util.Iterator
        void forEachRemaining(Consumer<? super Long> consumer);

        void forEachRemaining(LongConsumer longConsumer);

        @Override // java.util.Iterator
        Long next();

        long nextLong();

        /* renamed from: j$.util.PrimitiveIterator$OfLong$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static /* bridge */ /* synthetic */ void $default$forEachRemaining(OfLong _this, Object obj) {
                _this.forEachRemaining((LongConsumer) obj);
            }

            /* renamed from: $default$next */
            public static /* bridge */ /* synthetic */ Object m45$default$next(OfLong _this) {
                return _this.next();
            }

            public static void $default$forEachRemaining(OfLong _this, LongConsumer action) {
                Objects.requireNonNull(action);
                while (_this.hasNext()) {
                    action.accept(_this.nextLong());
                }
            }

            public static Long $default$next(OfLong _this) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfLong.nextLong()");
                }
                return Long.valueOf(_this.nextLong());
            }

            public static void $default$forEachRemaining(OfLong _this, Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    _this.forEachRemaining((LongConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                }
                Objects.requireNonNull(consumer);
                _this.forEachRemaining((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface OfDouble extends PrimitiveIterator<Double, DoubleConsumer> {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfDouble, Iterator {
            public final /* synthetic */ PrimitiveIterator.OfDouble wrappedValue;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfDouble ofDouble) {
                this.wrappedValue = ofDouble;
            }

            public static /* synthetic */ OfDouble convert(PrimitiveIterator.OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof Wrapper ? OfDouble.this : new VivifiedWrapper(ofDouble);
            }

            public /* synthetic */ boolean equals(Object obj) {
                PrimitiveIterator.OfDouble ofDouble = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return ofDouble.equals(obj);
            }

            @Override // j$.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                this.wrappedValue.forEachRemaining((PrimitiveIterator.OfDouble) doubleConsumer);
            }

            @Override // j$.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.wrappedValue.forEachRemaining((Consumer<? super Double>) consumer);
            }

            @Override // j$.util.PrimitiveIterator.OfDouble
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
                this.wrappedValue.forEachRemaining(doubleConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return this.wrappedValue.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ Double next() {
                return this.wrappedValue.next();
            }

            @Override // java.util.Iterator
            public /* synthetic */ Object next() {
                return this.wrappedValue.next();
            }

            @Override // j$.util.PrimitiveIterator.OfDouble
            public /* synthetic */ double nextDouble() {
                return this.wrappedValue.nextDouble();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                this.wrappedValue.remove();
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfDouble {
            private /* synthetic */ Wrapper() {
                OfDouble.this = r1;
            }

            public static /* synthetic */ PrimitiveIterator.OfDouble convert(OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof VivifiedWrapper ? ((VivifiedWrapper) ofDouble).wrappedValue : new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfDouble ofDouble = OfDouble.this;
                if (obj instanceof Wrapper) {
                    obj = OfDouble.this;
                }
                return ofDouble.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                OfDouble.this.forEachRemaining((Consumer<? super Double>) consumer);
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            /* renamed from: forEachRemaining */
            public /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining(doubleConsumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfDouble.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfDouble.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ Double next() {
                return OfDouble.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfDouble.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public /* synthetic */ double nextDouble() {
                return OfDouble.this.nextDouble();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfDouble.this.remove();
            }
        }

        @Override // java.util.Iterator
        void forEachRemaining(Consumer<? super Double> consumer);

        void forEachRemaining(DoubleConsumer doubleConsumer);

        @Override // java.util.Iterator
        Double next();

        double nextDouble();

        /* renamed from: j$.util.PrimitiveIterator$OfDouble$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static /* bridge */ /* synthetic */ void $default$forEachRemaining(OfDouble _this, Object obj) {
                _this.forEachRemaining((DoubleConsumer) obj);
            }

            /* renamed from: $default$next */
            public static /* bridge */ /* synthetic */ Object m43$default$next(OfDouble _this) {
                return _this.next();
            }

            public static void $default$forEachRemaining(OfDouble _this, DoubleConsumer action) {
                Objects.requireNonNull(action);
                while (_this.hasNext()) {
                    action.accept(_this.nextDouble());
                }
            }

            public static Double $default$next(OfDouble _this) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfDouble.nextLong()");
                }
                return Double.valueOf(_this.nextDouble());
            }

            public static void $default$forEachRemaining(OfDouble _this, Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    _this.forEachRemaining((DoubleConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(_this.getClass(), "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                }
                Objects.requireNonNull(consumer);
                _this.forEachRemaining((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
            }
        }
    }
}