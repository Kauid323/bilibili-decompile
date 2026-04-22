package j$.util.stream;

import j$.time.Duration$DurationUnits$$ExternalSyntheticBackport0;
import j$.time.ZoneId$$ExternalSyntheticBackport1;
import j$.util.CollSer$$ExternalSyntheticBackport0;
import j$.util.DoubleSummaryStatistics;
import j$.util.IntSummaryStatistics;
import j$.util.LongSummaryStatistics;
import j$.util.Map;
import j$.util.Objects;
import j$.util.Optional;
import j$.util.StringJoiner;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.function.BinaryOperator$CC;
import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.stream.Collector;
import j$.util.stream.Collectors;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Collectors {
    static final Set<Collector.Characteristics> CH_CONCURRENT_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_CONCURRENT_NOID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED));
    static final Set<Collector.Characteristics> CH_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_UNORDERED_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();
    static final Set<Collector.Characteristics> CH_UNORDERED_NOID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED));

    /* renamed from: -$$Nest$smcastingIdentity  reason: not valid java name */
    static /* bridge */ /* synthetic */ Function m50$$Nest$smcastingIdentity() {
        return castingIdentity();
    }

    private Collectors() {
    }

    private static IllegalStateException duplicateKeyException(Object k, Object u, Object v) {
        return new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", k, u, v));
    }

    private static <K, V, M extends Map<K, V>> BinaryOperator<M> uniqKeysMapMerger() {
        return new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$uniqKeysMapMerger$0((Map) obj, (Map) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$uniqKeysMapMerger$0(Map m1, Map m2) {
        for (Map.Entry entry : m2.entrySet()) {
            Object key = entry.getKey();
            Object requireNonNull = Objects.requireNonNull(entry.getValue());
            Object putIfAbsent = Map.EL.putIfAbsent(m1, key, requireNonNull);
            if (putIfAbsent != null) {
                throw duplicateKeyException(key, putIfAbsent, requireNonNull);
            }
        }
        return m1;
    }

    private static <T, K, V> BiConsumer<java.util.Map<K, V>, T> uniqKeysMapAccumulator(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends V> valueMapper) {
        return new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$uniqKeysMapAccumulator$1(Function.this, valueMapper, (java.util.Map) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uniqKeysMapAccumulator$1(Function keyMapper, Function valueMapper, java.util.Map map, Object element) {
        Object apply = keyMapper.apply(element);
        Object requireNonNull = Objects.requireNonNull(valueMapper.apply(element));
        Object putIfAbsent = Map.EL.putIfAbsent(map, apply, requireNonNull);
        if (putIfAbsent != null) {
            throw duplicateKeyException(apply, putIfAbsent, requireNonNull);
        }
    }

    private static <I, R> Function<I, R> castingIdentity() {
        return new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda65
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$castingIdentity$2(obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$castingIdentity$2(Object i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final BiConsumer<A, T> accumulator;
        private final Set<Collector.Characteristics> characteristics;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Supplier<A> supplier;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        public CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Function<A, R> finisher, Set<Collector.Characteristics> set) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = set;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        public CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Set<Collector.Characteristics> set) {
            this(supplier, accumulator, combiner, Collectors.m50$$Nest$smcastingIdentity(), set);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        @Override // j$.util.stream.Collector
        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        @Override // j$.util.stream.Collector
        public Supplier<A> supplier() {
            return this.supplier;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        @Override // j$.util.stream.Collector
        public BinaryOperator<A> combiner() {
            return this.combiner;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        @Override // j$.util.stream.Collector
        public Function<A, R> finisher() {
            return this.finisher;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$CollectorImpl != java.util.stream.Collectors$CollectorImpl<T, A, R> */
        @Override // j$.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return this.characteristics;
        }
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> collectionFactory) {
        return new CollectorImpl(collectionFactory, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda19
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collection) obj).add(obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda20
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$toCollection$3(java.util.Collection, java.util.Collection):java.util.Collection
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    java.util.Collection r1 = (java.util.Collection) r1
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.util.Collection r1 = j$.util.stream.Collectors.lambda$toCollection$3(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda20.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, CH_ID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.Collection lambda$toCollection$3(java.util.Collection r0, java.util.Collection r1) {
        /*
            r0.addAll(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$toCollection$3(java.util.Collection, java.util.Collection):java.util.Collection");
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda21(), new Collectors$$ExternalSyntheticLambda22(), new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda64
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$toList$4(java.util.List, java.util.List):java.util.List
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    java.util.List r1 = (java.util.List) r1
                    java.util.List r2 = (java.util.List) r2
                    java.util.List r1 = j$.util.stream.Collectors.lambda$toList$4(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda64.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, CH_ID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.List lambda$toList$4(java.util.List r0, java.util.List r1) {
        /*
            r0.addAll(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$toList$4(java.util.List, java.util.List):java.util.List");
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda21(), new Collectors$$ExternalSyntheticLambda22(), new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda23
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$toUnmodifiableList$5(java.util.List, java.util.List):java.util.List
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    java.util.List r1 = (java.util.List) r1
                    java.util.List r2 = (java.util.List) r2
                    java.util.List r1 = j$.util.stream.Collectors.lambda$toUnmodifiableList$5(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda23.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda24
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List m;
                m = Duration$DurationUnits$$ExternalSyntheticBackport0.m(((List) obj).toArray());
                return m;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.List lambda$toUnmodifiableList$5(java.util.List r0, java.util.List r1) {
        /*
            r0.addAll(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$toUnmodifiableList$5(java.util.List, java.util.List):java.util.List");
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda43(), new Collectors$$ExternalSyntheticLambda44(), new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda72
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toSet$7((Set) obj, (Set) obj2);
            }
        }, CH_UNORDERED_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set lambda$toSet$7(Set left, Set right) {
        if (left.size() < right.size()) {
            right.addAll(left);
            return right;
        }
        left.addAll(right);
        return left;
    }

    public static <T> Collector<T, ?, Set<T>> toUnmodifiableSet() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda43(), new Collectors$$ExternalSyntheticLambda44(), new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda45
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toUnmodifiableSet$8((Set) obj, (Set) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda46
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Set m;
                m = CollSer$$ExternalSyntheticBackport0.m(((Set) obj).toArray());
                return m;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_UNORDERED_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set lambda$toUnmodifiableSet$8(Set left, Set right) {
        if (left.size() < right.size()) {
            right.addAll(left);
            return right;
        }
        left.addAll(right);
        return left;
    }

    public static Collector<CharSequence, ?, String> joining() {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda91
            @Override // java.util.function.Supplier
            public final Object get() {
                return new StringBuilder();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda92
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringBuilder) obj).append((CharSequence) obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda93
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$joining$10(java.lang.StringBuilder, java.lang.StringBuilder):java.lang.StringBuilder
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
                    java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
                    java.lang.StringBuilder r1 = j$.util.stream.Collectors.lambda$joining$10(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda93.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda94
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringBuilder) obj).toString();
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.lang.StringBuilder lambda$joining$10(java.lang.StringBuilder r0, java.lang.StringBuilder r1) {
        /*
            r0.append(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$joining$10(java.lang.StringBuilder, java.lang.StringBuilder):java.lang.StringBuilder");
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter) {
        return joining(delimiter, "", "");
    }

    public static Collector<CharSequence, ?, String> joining(final CharSequence delimiter, final CharSequence prefix, final CharSequence suffix) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda68
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$joining$11(delimiter, prefix, suffix);
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda69
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringJoiner) obj).add((CharSequence) obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda70
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((StringJoiner) obj).merge((StringJoiner) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda71
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringJoiner) obj).toString();
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StringJoiner lambda$joining$11(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        return new StringJoiner(delimiter, prefix, suffix);
    }

    private static <K, V, M extends java.util.Map<K, V>> BinaryOperator<M> mapMerger(final BinaryOperator<V> mergeFunction) {
        return new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda90
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$mapMerger$12(BinaryOperator.this, (java.util.Map) obj, (java.util.Map) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.Map lambda$mapMerger$12(BinaryOperator mergeFunction, java.util.Map m1, java.util.Map m2) {
        for (Map.Entry entry : m2.entrySet()) {
            Map.EL.merge(m1, entry.getKey(), entry.getValue(), mergeFunction);
        }
        return m1;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super U, A, R> */
    public static <T, U, A, R> Collector<T, ?, R> mapping(final Function<? super T, ? extends U> mapper, Collector<? super U, A, R> collector) {
        final BiConsumer<A, ? super U> downstreamAccumulator = collector.accumulator();
        return new CollectorImpl(collector.supplier(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda41
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer.this.accept(obj, mapper.apply(obj2));
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, collector.combiner(), collector.finisher(), collector.characteristics());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super U, A, R> */
    public static <T, U, A, R> Collector<T, ?, R> flatMapping(final Function<? super T, ? extends Stream<? extends U>> function, Collector<? super U, A, R> collector) {
        final BiConsumer<A, ? super U> downstreamAccumulator = collector.accumulator();
        return new CollectorImpl(collector.supplier(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda77
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$flatMapping$15(Function.this, downstreamAccumulator, obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, collector.combiner(), collector.finisher(), collector.characteristics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends U> */
    public static /* synthetic */ void lambda$flatMapping$15(Function mapper, final BiConsumer downstreamAccumulator, final Object r, Object t) {
        Stream stream = (Stream) mapper.apply(t);
        if (stream != null) {
            try {
                stream.sequential().forEach(new Consumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda14
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        BiConsumer.this.accept(r, obj);
                    }

                    @Override // java.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer$CC.$default$andThen(this, consumer);
                    }
                });
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (stream != null) {
            stream.close();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, R> */
    public static <T, A, R> Collector<T, ?, R> filtering(final Predicate<? super T> predicate, Collector<? super T, A, R> collector) {
        final BiConsumer<A, ? super T> downstreamAccumulator = collector.accumulator();
        return new CollectorImpl(collector.supplier(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda67
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$filtering$16(Predicate.this, downstreamAccumulator, obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, collector.combiner(), collector.finisher(), collector.characteristics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$filtering$16(Predicate predicate, BiConsumer downstreamAccumulator, Object r, Object t) {
        if (predicate.test(t)) {
            downstreamAccumulator.accept(r, t);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<T, A, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> collector, Function<R, RR> finisher) {
        Set<Collector.Characteristics> characteristics = collector.characteristics();
        if (characteristics.contains(Collector.Characteristics.IDENTITY_FINISH)) {
            if (characteristics.size() == 1) {
                characteristics = CH_NOID;
            } else {
                Set<Collector.Characteristics> characteristics2 = EnumSet.copyOf((Collection) characteristics);
                characteristics2.remove(Collector.Characteristics.IDENTITY_FINISH);
                characteristics = Collections.unmodifiableSet(characteristics2);
            }
        }
        return new CollectorImpl(collector.supplier(), collector.accumulator(), collector.combiner(), collector.finisher().andThen(finisher), characteristics);
    }

    public static <T> Collector<T, ?, Long> counting() {
        return summingLong(new ToLongFunction() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda75
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return Collectors.lambda$counting$17(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$counting$17(Object e) {
        return 1L;
    }

    public static <T> Collector<T, ?, Optional<T>> minBy(Comparator<? super T> comparator) {
        return reducing(BinaryOperator$CC.minBy(comparator));
    }

    public static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator) {
        return reducing(BinaryOperator$CC.maxBy(comparator));
    }

    public static <T> Collector<T, ?, Integer> summingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingInt$18();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda11
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingInt$19(ToIntFunction.this, (int[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda12
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingInt$20((int[]) obj, (int[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((int[]) obj)[0]);
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int[] lambda$summingInt$18() {
        return new int[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingInt$19(ToIntFunction mapper, int[] a, Object t) {
        a[0] = a[0] + mapper.applyAsInt(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int[] lambda$summingInt$20(int[] a, int[] b) {
        a[0] = a[0] + b[0];
        return a;
    }

    public static <T> Collector<T, ?, Long> summingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda78
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingLong$22();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda79
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingLong$23(ToLongFunction.this, (long[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda80
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingLong$24((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda81
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Long valueOf;
                valueOf = Long.valueOf(((long[]) obj)[0]);
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$summingLong$22() {
        return new long[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingLong$23(ToLongFunction mapper, long[] a, Object t) {
        a[0] = a[0] + mapper.applyAsLong(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$summingLong$24(long[] a, long[] b) {
        a[0] = a[0] + b[0];
        return a;
    }

    public static <T> Collector<T, ?, Double> summingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda55
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingDouble$26();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda56
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingDouble$27(ToDoubleFunction.this, (double[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda57
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingDouble$28((double[]) obj, (double[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda58
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(Collectors.computeFinalSum((double[]) obj));
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$summingDouble$26() {
        return new double[3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingDouble$27(ToDoubleFunction mapper, double[] a, Object t) {
        double val = mapper.applyAsDouble(t);
        sumWithCompensation(a, val);
        a[2] = a[2] + val;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$summingDouble$28(double[] a, double[] b) {
        sumWithCompensation(a, b[0]);
        a[2] = a[2] + b[2];
        return sumWithCompensation(a, b[1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double[] sumWithCompensation(double[] intermediateSum, double value) {
        double tmp = value - intermediateSum[1];
        double sum = intermediateSum[0];
        double velvel = sum + tmp;
        intermediateSum[1] = (velvel - sum) - tmp;
        intermediateSum[0] = velvel;
        return intermediateSum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double computeFinalSum(double[] summands) {
        double tmp = summands[0] + summands[1];
        double simpleSum = summands[summands.length - 1];
        if (Double.isNaN(tmp) && Double.isInfinite(simpleSum)) {
            return simpleSum;
        }
        return tmp;
    }

    public static <T> Collector<T, ?, Double> averagingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda36
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingInt$30();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda37
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingInt$31(ToIntFunction.this, (long[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda38
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingInt$32((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda39
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                long[] jArr = (long[]) obj;
                valueOf = Double.valueOf(a[1] == 0 ? 0.0d : jArr[0] / jArr[1]);
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingInt$30() {
        return new long[2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingInt$31(ToIntFunction mapper, long[] a, Object t) {
        a[0] = a[0] + mapper.applyAsInt(t);
        a[1] = a[1] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingInt$32(long[] a, long[] b) {
        a[0] = a[0] + b[0];
        a[1] = a[1] + b[1];
        return a;
    }

    public static <T> Collector<T, ?, Double> averagingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda86
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingLong$34();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda87
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingLong$35(ToLongFunction.this, (long[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda88
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingLong$36((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda89
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                long[] jArr = (long[]) obj;
                valueOf = Double.valueOf(a[1] == 0 ? 0.0d : jArr[0] / jArr[1]);
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingLong$34() {
        return new long[2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingLong$35(ToLongFunction mapper, long[] a, Object t) {
        a[0] = a[0] + mapper.applyAsLong(t);
        a[1] = a[1] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingLong$36(long[] a, long[] b) {
        a[0] = a[0] + b[0];
        a[1] = a[1] + b[1];
        return a;
    }

    public static <T> Collector<T, ?, Double> averagingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda32
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingDouble$38();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda33
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingDouble$39(ToDoubleFunction.this, (double[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda34
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingDouble$40((double[]) obj, (double[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda35
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(a[2] != 0.0d ? Collectors.computeFinalSum(r1) / ((double[]) obj)[2] : 0.0d);
                return valueOf;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$averagingDouble$38() {
        return new double[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingDouble$39(ToDoubleFunction mapper, double[] a, Object t) {
        double val = mapper.applyAsDouble(t);
        sumWithCompensation(a, val);
        a[2] = a[2] + 1.0d;
        a[3] = a[3] + val;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$averagingDouble$40(double[] a, double[] b) {
        sumWithCompensation(a, b[0]);
        sumWithCompensation(a, b[1]);
        a[2] = a[2] + b[2];
        a[3] = a[3] + b[3];
        return a;
    }

    public static <T> Collector<T, ?, T> reducing(T identity, final BinaryOperator<T> op) {
        return new CollectorImpl(boxSupplier(identity), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda52
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$reducing$42(BinaryOperator.this, (Object[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda53
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$43(BinaryOperator.this, (Object[]) obj, (Object[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda54
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$reducing$44((Object[]) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$reducing$42(BinaryOperator op, Object[] a, Object t) {
        a[0] = op.apply(a[0], t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$reducing$43(BinaryOperator op, Object[] a, Object[] b) {
        a[0] = op.apply(a[0], b[0]);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reducing$44(Object[] a) {
        return a[0];
    }

    private static <T> Supplier<T[]> boxSupplier(final T identity) {
        return new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda18
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$boxSupplier$45(identity);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$boxSupplier$45(Object identity) {
        return new Object[]{identity};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: j$.util.stream.Collectors$1OptionalBox  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C1OptionalBox<T> implements Consumer<T> {
        final /* synthetic */ BinaryOperator val$op;
        T value = null;
        boolean present = false;

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        C1OptionalBox(BinaryOperator binaryOperator) {
            this.val$op = binaryOperator;
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            if (this.present) {
                this.value = this.val$op.apply(this.value, t);
                return;
            }
            this.value = t;
            this.present = true;
        }
    }

    public static <T> Collector<T, ?, Optional<T>> reducing(final BinaryOperator<T> op) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda82
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$reducing$46(BinaryOperator.this);
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda83
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collectors.C1OptionalBox) obj).accept(obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda84
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$47((Collectors.C1OptionalBox) obj, (Collectors.C1OptionalBox) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda85
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Optional ofNullable;
                ofNullable = Optional.ofNullable(((Collectors.C1OptionalBox) obj).value);
                return ofNullable;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1OptionalBox lambda$reducing$46(BinaryOperator op) {
        return new C1OptionalBox(op);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1OptionalBox lambda$reducing$47(C1OptionalBox a, C1OptionalBox b) {
        if (b.present) {
            a.accept(b.value);
        }
        return a;
    }

    public static <T, U> Collector<T, ?, U> reducing(U identity, final Function<? super T, ? extends U> mapper, final BinaryOperator<U> op) {
        return new CollectorImpl(boxSupplier(identity), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$reducing$49(BinaryOperator.this, mapper, (Object[]) obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda5
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$50(BinaryOperator.this, (Object[]) obj, (Object[]) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$reducing$51((Object[]) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$reducing$49(BinaryOperator op, Function mapper, Object[] a, Object t) {
        a[0] = op.apply(a[0], mapper.apply(t));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$reducing$50(BinaryOperator op, Object[] a, Object[] b) {
        a[0] = op.apply(a[0], b[0]);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reducing$51(Object[] a) {
        return a[0];
    }

    public static <T, K> Collector<T, ?, java.util.Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier) {
        return groupingBy(classifier, toList());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, D> */
    public static <T, K, A, D> Collector<T, ?, java.util.Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> collector) {
        return groupingBy(classifier, new Collectors$$ExternalSyntheticLambda76(), collector);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, D> */
    public static <T, K, D, A, M extends java.util.Map<K, D>> Collector<T, ?, M> groupingBy(final Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> collector) {
        final Supplier<A> downstreamSupplier = collector.supplier();
        final BiConsumer<A, ? super T> downstreamAccumulator = collector.accumulator();
        BiConsumer<java.util.Map<K, A>, T> accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda59
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                downstreamAccumulator.accept(Map.EL.computeIfAbsent((java.util.Map) obj, Objects.requireNonNull(Function.this.apply(obj2), "element cannot be mapped to a null key"), new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda66
                    @Override // java.util.function.Function
                    public /* synthetic */ Function andThen(Function function) {
                        return Function$CC.$default$andThen(this, function);
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        Object obj4;
                        obj4 = Supplier.this.get();
                        return obj4;
                    }

                    @Override // java.util.function.Function
                    public /* synthetic */ Function compose(Function function) {
                        return Function$CC.$default$compose(this, function);
                    }
                }), obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        };
        BinaryOperator<java.util.Map<K, A>> merger = mapMerger(collector.combiner());
        if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(mapFactory, accumulator, merger, CH_ID);
        }
        final Function<A, D> finisher = collector.finisher();
        Function<java.util.Map<K, A>, M> finisher2 = new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda60
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$groupingBy$55(Function.this, (java.util.Map) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, merger, finisher2, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.Map lambda$groupingBy$55(final Function downstreamFinisher, java.util.Map intermediate) {
        Map.EL.replaceAll(intermediate, new BiFunction() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda42
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply(obj2);
                return apply;
            }
        });
        return intermediate;
    }

    public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent(Function<? super T, ? extends K> classifier) {
        return groupingByConcurrent(classifier, new Collectors$$ExternalSyntheticLambda2(), toList());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, D> */
    public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> groupingByConcurrent(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> collector) {
        return groupingByConcurrent(classifier, new Collectors$$ExternalSyntheticLambda2(), collector);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, D> */
    public static <T, K, A, D, M extends ConcurrentMap<K, D>> Collector<T, ?, M> groupingByConcurrent(final Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> collector) {
        BiConsumer<ConcurrentMap<K, A>, T> accumulator;
        final Supplier<A> downstreamSupplier = collector.supplier();
        final BiConsumer<A, ? super T> downstreamAccumulator = collector.accumulator();
        BinaryOperator<ConcurrentMap<K, A>> merger = mapMerger(collector.combiner());
        if (collector.characteristics().contains(Collector.Characteristics.CONCURRENT)) {
            accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    downstreamAccumulator.accept(ConcurrentMap.EL.computeIfAbsent((java.util.concurrent.ConcurrentMap) obj, Objects.requireNonNull(Function.this.apply(obj2), "element cannot be mapped to a null key"), new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda3
                        @Override // java.util.function.Function
                        public /* synthetic */ Function andThen(Function function) {
                            return Function$CC.$default$andThen(this, function);
                        }

                        @Override // java.util.function.Function
                        public final Object apply(Object obj3) {
                            Object obj4;
                            obj4 = Supplier.this.get();
                            return obj4;
                        }

                        @Override // java.util.function.Function
                        public /* synthetic */ Function compose(Function function) {
                            return Function$CC.$default$compose(this, function);
                        }
                    }), obj2);
                }

                @Override // java.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer$CC.$default$andThen(this, biConsumer);
                }
            };
        } else {
            accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Collectors.lambda$groupingByConcurrent$59(Function.this, downstreamSupplier, downstreamAccumulator, (java.util.concurrent.ConcurrentMap) obj, obj2);
                }

                @Override // java.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer$CC.$default$andThen(this, biConsumer);
                }
            };
        }
        if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(mapFactory, accumulator, merger, CH_CONCURRENT_ID);
        }
        final Function<A, D> finisher = collector.finisher();
        Function<java.util.concurrent.ConcurrentMap<K, A>, M> finisher2 = new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$groupingByConcurrent$61(Function.this, (java.util.concurrent.ConcurrentMap) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, merger, finisher2, CH_CONCURRENT_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$groupingByConcurrent$59(Function classifier, final Supplier downstreamSupplier, BiConsumer downstreamAccumulator, java.util.concurrent.ConcurrentMap m, Object t) {
        Object computeIfAbsent = ConcurrentMap.EL.computeIfAbsent(m, Objects.requireNonNull(classifier.apply(t), "element cannot be mapped to a null key"), new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda30
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object obj2;
                obj2 = Supplier.this.get();
                return obj2;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        });
        synchronized (computeIfAbsent) {
            downstreamAccumulator.accept(computeIfAbsent, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.concurrent.ConcurrentMap lambda$groupingByConcurrent$61(final Function downstreamFinisher, java.util.concurrent.ConcurrentMap intermediate) {
        ConcurrentMap.EL.replaceAll(intermediate, new BiFunction() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda47
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply(obj2);
                return apply;
            }
        });
        return intermediate;
    }

    public static <T> Collector<T, ?, java.util.Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
        return partitioningBy(predicate, toList());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super T, A, D> */
    public static <T, D, A> Collector<T, ?, java.util.Map<Boolean, D>> partitioningBy(final Predicate<? super T> predicate, final Collector<? super T, A, D> collector) {
        final BiConsumer<A, ? super T> downstreamAccumulator = collector.accumulator();
        BiConsumer<Collectors.Partition<A>, T> accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda48
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer biConsumer = BiConsumer.this;
                Predicate predicate2 = predicate;
                biConsumer.accept(predicate.test(t) ? r3.forTrue : ((Collectors.Partition) obj).forFalse, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        };
        final BinaryOperator<A> op = collector.combiner();
        BinaryOperator<Collectors.Partition<A>> merger = new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda49
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$partitioningBy$63(BinaryOperator.this, (Collectors.Partition) obj, (Collectors.Partition) obj2);
            }
        };
        Supplier<Collectors.Partition<A>> supplier = new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda50
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$partitioningBy$64(Collector.this);
            }
        };
        if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(supplier, accumulator, merger, CH_ID);
        }
        Function<Collectors.Partition<A>, java.util.Map<Boolean, D>> finisher = new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda51
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$partitioningBy$65(Collector.this, (Collectors.Partition) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
        return new CollectorImpl(supplier, accumulator, merger, finisher, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Partition lambda$partitioningBy$63(BinaryOperator op, Partition left, Partition right) {
        return new Partition(op.apply(left.forTrue, right.forTrue), op.apply(left.forFalse, right.forFalse));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Partition lambda$partitioningBy$64(Collector downstream) {
        return new Partition(downstream.supplier().get(), downstream.supplier().get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.util.Map lambda$partitioningBy$65(Collector downstream, Partition par) {
        return new Partition(downstream.finisher().apply(par.forTrue), downstream.finisher().apply(par.forFalse));
    }

    public static <T, K, U> Collector<T, ?, java.util.Map<K, U>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda76(), uniqKeysMapAccumulator(keyMapper, valueMapper), uniqKeysMapMerger(), CH_ID);
    }

    public static <T, K, U> Collector<T, ?, java.util.Map<K, U>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        Objects.requireNonNull(keyMapper, "keyMapper");
        Objects.requireNonNull(valueMapper, "valueMapper");
        return collectingAndThen(toMap(keyMapper, valueMapper), new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda31
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                java.util.Map m;
                m = ZoneId$$ExternalSyntheticBackport1.m((Map.Entry[]) ((java.util.Map) obj).entrySet().toArray(new Map.Entry[0]));
                return m;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        });
    }

    public static <T, K, U> Collector<T, ?, java.util.Map<K, U>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        return toMap(keyMapper, valueMapper, mergeFunction, new Collectors$$ExternalSyntheticLambda76());
    }

    public static <T, K, U> Collector<T, ?, java.util.Map<K, U>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        Objects.requireNonNull(keyMapper, "keyMapper");
        Objects.requireNonNull(valueMapper, "valueMapper");
        Objects.requireNonNull(mergeFunction, "mergeFunction");
        return collectingAndThen(toMap(keyMapper, valueMapper, mergeFunction, new Collectors$$ExternalSyntheticLambda73()), new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda74
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                java.util.Map m;
                m = ZoneId$$ExternalSyntheticBackport1.m((Map.Entry[]) ((HashMap) obj).entrySet().toArray(new Map.Entry[0]));
                return m;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        });
    }

    public static <T, K, U, M extends java.util.Map<K, U>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends U> valueMapper, final BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) {
        BiConsumer<M, T> accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda26
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                java.util.Map map = (java.util.Map) obj;
                Map.EL.merge(map, Function.this.apply(obj2), valueMapper.apply(obj2), mergeFunction);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, mapMerger(mergeFunction), CH_ID);
    }

    public static <T, K, U> Collector<T, ?, java.util.concurrent.ConcurrentMap<K, U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda40
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ConcurrentHashMap();
            }
        }, uniqKeysMapAccumulator(keyMapper, valueMapper), uniqKeysMapMerger(), CH_CONCURRENT_ID);
    }

    public static <T, K, U> Collector<T, ?, java.util.concurrent.ConcurrentMap<K, U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        return toConcurrentMap(keyMapper, valueMapper, mergeFunction, new Collectors$$ExternalSyntheticLambda2());
    }

    public static <T, K, U, M extends java.util.concurrent.ConcurrentMap<K, U>> Collector<T, ?, M> toConcurrentMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends U> valueMapper, final BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) {
        BiConsumer<M, T> accumulator = new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda25
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                java.util.concurrent.ConcurrentMap concurrentMap = (java.util.concurrent.ConcurrentMap) obj;
                ConcurrentMap.EL.merge(concurrentMap, Function.this.apply(obj2), valueMapper.apply(obj2), mergeFunction);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, mapMerger(mergeFunction), CH_CONCURRENT_ID);
    }

    public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda27(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda28
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((IntSummaryStatistics) obj).accept(ToIntFunction.this.applyAsInt(obj2));
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda29
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$summarizingInt$71(j$.util.IntSummaryStatistics, j$.util.IntSummaryStatistics):j$.util.IntSummaryStatistics
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    j$.util.IntSummaryStatistics r1 = (j$.util.IntSummaryStatistics) r1
                    j$.util.IntSummaryStatistics r2 = (j$.util.IntSummaryStatistics) r2
                    j$.util.IntSummaryStatistics r1 = j$.util.stream.Collectors.lambda$summarizingInt$71(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda29.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, CH_ID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j$.util.IntSummaryStatistics lambda$summarizingInt$71(j$.util.IntSummaryStatistics r0, j$.util.IntSummaryStatistics r1) {
        /*
            r0.combine(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$summarizingInt$71(j$.util.IntSummaryStatistics, j$.util.IntSummaryStatistics):j$.util.IntSummaryStatistics");
    }

    public static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda61(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda62
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LongSummaryStatistics) obj).accept(ToLongFunction.this.applyAsLong(obj2));
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda63
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$summarizingLong$73(j$.util.LongSummaryStatistics, j$.util.LongSummaryStatistics):j$.util.LongSummaryStatistics
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    j$.util.LongSummaryStatistics r1 = (j$.util.LongSummaryStatistics) r1
                    j$.util.LongSummaryStatistics r2 = (j$.util.LongSummaryStatistics) r2
                    j$.util.LongSummaryStatistics r1 = j$.util.stream.Collectors.lambda$summarizingLong$73(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda63.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, CH_ID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j$.util.LongSummaryStatistics lambda$summarizingLong$73(j$.util.LongSummaryStatistics r0, j$.util.LongSummaryStatistics r1) {
        /*
            r0.combine(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$summarizingLong$73(j$.util.LongSummaryStatistics, j$.util.LongSummaryStatistics):j$.util.LongSummaryStatistics");
    }

    public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda15(), new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda16
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((DoubleSummaryStatistics) obj).accept(ToDoubleFunction.this.applyAsDouble(obj2));
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda17
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.Collectors.lambda$summarizingDouble$75(j$.util.DoubleSummaryStatistics, j$.util.DoubleSummaryStatistics):j$.util.DoubleSummaryStatistics
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r0 = this;
                    j$.util.DoubleSummaryStatistics r1 = (j$.util.DoubleSummaryStatistics) r1
                    j$.util.DoubleSummaryStatistics r2 = (j$.util.DoubleSummaryStatistics) r2
                    j$.util.DoubleSummaryStatistics r1 = j$.util.stream.Collectors.lambda$summarizingDouble$75(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors$$ExternalSyntheticLambda17.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, CH_ID);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j$.util.DoubleSummaryStatistics lambda$summarizingDouble$75(j$.util.DoubleSummaryStatistics r0, j$.util.DoubleSummaryStatistics r1) {
        /*
            r0.combine(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.lambda$summarizingDouble$75(j$.util.DoubleSummaryStatistics, j$.util.DoubleSummaryStatistics):j$.util.DoubleSummaryStatistics");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class Partition<T> extends AbstractMap<Boolean, T> implements java.util.Map<Boolean, T> {
        final T forFalse;
        final T forTrue;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$Partition != java.util.stream.Collectors$Partition<T> */
        Partition(T forTrue, T forFalse) {
            this.forTrue = forTrue;
            this.forFalse = forFalse;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collectors$Partition != java.util.stream.Collectors$Partition<T> */
        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Boolean, T>> entrySet() {
            return new AbstractSet<Map.Entry<Boolean, T>>() { // from class: j$.util.stream.Collectors.Partition.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<Boolean, T>> iterator() {
                    Map.Entry<Boolean, T> falseEntry = new AbstractMap.SimpleImmutableEntry<>(false, Partition.this.forFalse);
                    Map.Entry<Boolean, T> trueEntry = new AbstractMap.SimpleImmutableEntry<>(true, Partition.this.forTrue);
                    return Collectors$Partition$1$$ExternalSyntheticBackport0.m(falseEntry, trueEntry).iterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return 2;
                }
            };
        }
    }
}