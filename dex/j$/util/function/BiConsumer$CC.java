package j$.util.function;

import j$.util.Objects;
import java.util.function.BiConsumer;

/* renamed from: j$.util.function.BiConsumer$-CC */
public final /* synthetic */ class BiConsumer$CC {
    public static BiConsumer $default$andThen(final BiConsumer _this, final BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new BiConsumer() { // from class: j$.util.function.BiConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer$CC.$private$lambda$andThen$0(BiConsumer.this, biConsumer, obj, obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer2) {
                return BiConsumer$CC.$default$andThen(this, biConsumer2);
            }
        };
    }

    public static /* synthetic */ void $private$lambda$andThen$0(BiConsumer _this, BiConsumer after, Object l, Object r) {
        _this.accept(l, r);
        after.accept(l, r);
    }
}