package j$.util.function;

import j$.util.Objects;
import java.util.function.LongConsumer;

/* renamed from: j$.util.function.LongConsumer$-CC */
public final /* synthetic */ class LongConsumer$CC {
    public static LongConsumer $default$andThen(final LongConsumer _this, final LongConsumer after) {
        Objects.requireNonNull(after);
        return new LongConsumer() { // from class: j$.util.function.LongConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                LongConsumer$CC.$private$lambda$andThen$0(LongConsumer.this, after, j);
            }

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }
        };
    }

    public static /* synthetic */ void $private$lambda$andThen$0(LongConsumer _this, LongConsumer after, long t) {
        _this.accept(t);
        after.accept(t);
    }
}