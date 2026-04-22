package j$.lang;

import j$.util.Collection;
import j$.util.DesugarLinkedHashSet;
import j$.util.List;
import j$.util.Objects;
import j$.util.SortedSet;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;

public interface Iterable<T> {

    /* compiled from: D8$$SyntheticClass */
    /* renamed from: j$.lang.Iterable$-EL  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void forEach(java.lang.Iterable iterable, Consumer consumer) {
            if (iterable instanceof Iterable) {
                ((Iterable) iterable).forEach(consumer);
            } else if (iterable instanceof Collection) {
                Collection.CC.$default$forEach((java.util.Collection) iterable, consumer);
            } else {
                CC.$default$forEach(iterable, consumer);
            }
        }

        public static /* synthetic */ Spliterator spliterator(java.lang.Iterable iterable) {
            return iterable instanceof Iterable ? ((Iterable) iterable).spliterator() : iterable instanceof LinkedHashSet ? DesugarLinkedHashSet.spliterator((LinkedHashSet) iterable) : iterable instanceof SortedSet ? SortedSet.CC.$default$spliterator((java.util.SortedSet) iterable) : iterable instanceof Set ? Spliterators.spliterator((Set) iterable, 1) : iterable instanceof List ? List.CC.$default$spliterator((java.util.List) iterable) : iterable instanceof java.util.Collection ? Spliterators.spliterator((java.util.Collection) iterable, 0) : CC.$default$spliterator(iterable);
        }
    }

    void forEach(Consumer<? super T> consumer);

    Spliterator<T> spliterator();

    /* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static void $default$forEach(java.lang.Iterable _this, Consumer consumer) {
            Objects.requireNonNull(consumer);
            for (T t : _this) {
                consumer.accept(t);
            }
        }

        public static Spliterator $default$spliterator(java.lang.Iterable _this) {
            return Spliterators.spliteratorUnknownSize(_this.iterator(), 0);
        }
    }
}