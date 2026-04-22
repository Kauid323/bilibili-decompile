package kntr.common.ouro.core.model.mark;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: OuroMarks.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0010(\n\u0002\b\u0006\b\u0007\u0018\u0000 2*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000212B-\b\u0000\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\b\u0010\tB\u0017\b\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\b\u0010\u000bB!\b\u0016\u0012\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\f\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0001\u0010\u001d*\u00028\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0006H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J\"\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\u0002¢\u0006\u0002\b$J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J&\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003H\u0087\u0002¢\u0006\u0002\b%J\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0002J\u0015\u0010&\u001a\u00020\u000f2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0002J\u0016\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010(J\u0017\u0010)\u001a\u00020\u000f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0001J\t\u0010+\u001a\u00020\u000fH\u0096\u0001J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0003R(\u0010\u0004\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00178F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010.\u001a\u00020\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMarks;", "MARK", "Lkntr/common/ouro/core/model/mark/OuroMark;", "", "map", "", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMarkMap;", "<init>", "(Ljava/util/Map;)V", "marks", "(Ljava/util/Collection;)V", "", "([Lkntr/common/ouro/core/model/mark/OuroMark;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "keys", "", "getKeys$annotations", "()V", "getKeys", "()Ljava/util/Set;", "get", "T", "key", "(Lkntr/common/ouro/core/model/mark/OuroMark$Key;)Lkntr/common/ouro/core/model/mark/OuroMark;", "plus", "mark", "(Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMarks;", "minus", "minusMarks", "minusKeys", "contains", "element", "(Lkntr/common/ouro/core/model/mark/OuroMark;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "size", "getSize", "()I", "Empty", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = OuroMarksSerializer.class)
public final class OuroMarks<MARK extends OuroMark> implements Collection<MARK>, KMappedMarker, j$.util.Collection {
    public static final Companion Companion = new Companion(null);
    private final /* synthetic */ Collection<MARK> $$delegate_0;
    private final Map<OuroMark.Key<?>, MARK> map;

    public OuroMarks() {
        this(null, 1, null);
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(MARK mark) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends MARK> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(MARK mark) {
        Intrinsics.checkNotNullParameter(mark, "element");
        return this.$$delegate_0.contains(mark);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.$$delegate_0.containsAll(collection);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.-CC.$default$forEach(this, consumer);
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<MARK> iterator() {
        return this.$$delegate_0.iterator();
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super MARK> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Collection.-CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.-CC.$default$stream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    /* compiled from: OuroMarks.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMarks$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "MARK", "typeSerial0", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <MARK> KSerializer<OuroMarks<MARK>> serializer(KSerializer<MARK> kSerializer) {
            Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
            return OuroMarksSerializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroMarks(Map<OuroMark.Key<?>, ? extends MARK> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.$$delegate_0 = map.values();
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof OuroMark) {
            return contains((OuroMarks<MARK>) ((OuroMark) element));
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* synthetic */ OuroMarks(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    /* compiled from: OuroMarks.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMarks$Empty;", "", "<init>", "()V", "Marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "TextMarks", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getTextMarks", "ParagraphMarks", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "getParagraphMarks", "DrawableMarks", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "getDrawableMarks", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Empty {
        public static final Empty INSTANCE = new Empty();
        private static final OuroMarks<OuroMark> Marks = new OuroMarks<>(null, 1, null);
        private static final OuroMarks<OuroTextMark> TextMarks = new OuroMarks<>(null, 1, null);
        private static final OuroMarks<OuroParagraphMark> ParagraphMarks = new OuroMarks<>(null, 1, null);
        private static final OuroMarks<OuroDrawableMark> DrawableMarks = new OuroMarks<>(null, 1, null);

        private Empty() {
        }

        public final OuroMarks<OuroMark> getMarks() {
            return Marks;
        }

        public final OuroMarks<OuroTextMark> getTextMarks() {
            return TextMarks;
        }

        public final OuroMarks<OuroParagraphMark> getParagraphMarks() {
            return ParagraphMarks;
        }

        public final OuroMarks<OuroDrawableMark> getDrawableMarks() {
            return DrawableMarks;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OuroMarks(java.util.Collection<? extends MARK> collection) {
        this(destination$iv$iv);
        Intrinsics.checkNotNullParameter(collection, "marks");
        java.util.Collection<? extends MARK> $this$associateBy$iv = collection;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            OuroMark it = (OuroMark) element$iv$iv;
            destination$iv$iv.put(it.getKey(), element$iv$iv);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OuroMarks(MARK... markArr) {
        this(destination$iv$iv);
        Intrinsics.checkNotNullParameter(markArr, "marks");
        Iterable $this$associateBy$iv = ArraysKt.filterNotNull(markArr);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            OuroMark it = (OuroMark) element$iv$iv;
            destination$iv$iv.put(it.getKey(), element$iv$iv);
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OuroMarks) && Intrinsics.areEqual(this.map, ((OuroMarks) other).map);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        int size = size();
        return "OuroMarks(size=" + size + ", marks=[" + CollectionsKt.joinToString$default(this.map.values(), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "])";
    }

    public final Set<OuroMark.Key<MARK>> getKeys() {
        Set<OuroMark.Key<MARK>> set = (Set<OuroMark.Key<MARK>>) this.map.keySet();
        Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.Set<kntr.common.ouro.core.model.mark.OuroMark.Key<MARK of kntr.common.ouro.core.model.mark.OuroMarks>>");
        return set;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::TMARK;>(Lkntr/common/ouro/core/model/mark/OuroMark$Key<TT;>;)TT; */
    public final OuroMark get(OuroMark.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MARK mark = this.map.get(key);
        if (mark instanceof OuroMark) {
            return mark;
        }
        return null;
    }

    public final OuroMarks<MARK> plus(java.util.Collection<? extends MARK> collection) {
        Intrinsics.checkNotNullParameter(collection, "marks");
        Map<OuroMark.Key<?>, MARK> map = this.map;
        java.util.Collection<? extends MARK> $this$associateBy$iv = collection;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            OuroMark it = (OuroMark) element$iv$iv;
            destination$iv$iv.put(it.getKey(), element$iv$iv);
        }
        return new OuroMarks<>(MapsKt.plus(map, destination$iv$iv));
    }

    public final OuroMarks<MARK> plus(MARK mark) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        return new OuroMarks<>(MapsKt.plus(this.map, TuplesKt.to(mark.getKey(), mark)));
    }

    public final OuroMarks<MARK> minusMarks(java.util.Collection<? extends MARK> collection) {
        Map otherMap;
        Intrinsics.checkNotNullParameter(collection, "marks");
        if (collection.isEmpty()) {
            return this;
        }
        OuroMarks ouroMarks = collection instanceof OuroMarks ? (OuroMarks) collection : null;
        if (ouroMarks == null || (otherMap = ouroMarks.map) == null) {
            java.util.Collection<? extends MARK> $this$associateBy$iv = collection;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                OuroMark it = (OuroMark) element$iv$iv;
                destination$iv$iv.put(it.getKey(), element$iv$iv);
            }
            otherMap = destination$iv$iv;
        }
        Map $this$filter$iv = this.map;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Map.Entry element$iv$iv2 : $this$filter$iv.entrySet()) {
            if ((otherMap.containsKey(element$iv$iv2.getValue().getKey()) && Intrinsics.areEqual(element$iv$iv2.getValue(), otherMap.get(element$iv$iv2.getValue().getKey()))) ? false : true) {
                destination$iv$iv2.put(element$iv$iv2.getKey(), element$iv$iv2.getValue());
            }
        }
        return new OuroMarks<>(destination$iv$iv2);
    }

    public final OuroMarks<MARK> minus(MARK mark) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        Map $this$filter$iv = this.map;
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
            if ((Intrinsics.areEqual(element$iv$iv.getKey(), mark.getKey()) && Intrinsics.areEqual(element$iv$iv.getValue(), mark)) ? false : true) {
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
        }
        return new OuroMarks<>(destination$iv$iv);
    }

    public final OuroMarks<MARK> minusKeys(java.util.Collection<? extends OuroMark.Key<?>> collection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        return new OuroMarks<>(MapsKt.minus(this.map, collection));
    }

    public final OuroMarks<MARK> minus(OuroMark.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new OuroMarks<>(MapsKt.minus(this.map, key));
    }

    public final boolean contains(OuroMark.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.containsKey(key);
    }
}