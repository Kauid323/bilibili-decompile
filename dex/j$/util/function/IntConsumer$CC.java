package j$.util.function;

import j$.util.Objects;
import java.util.function.IntConsumer;

/* renamed from: j$.util.function.IntConsumer$-CC */
public final /* synthetic */ class IntConsumer$CC {
    public static IntConsumer $default$andThen(final IntConsumer _this, final IntConsumer after) {
        Objects.requireNonNull(after);
        return new IntConsumer() { // from class: j$.util.function.IntConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                IntConsumer$CC.$private$lambda$andThen$0(IntConsumer.this, after, i);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }
        };
    }

    public static /* synthetic */ void $private$lambda$andThen$0(IntConsumer _this, IntConsumer after, int t) {
        _this.accept(t);
        after.accept(t);
    }
}