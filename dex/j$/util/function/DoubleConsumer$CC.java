package j$.util.function;

import j$.util.Objects;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.function.DoubleConsumer$-CC */
public final /* synthetic */ class DoubleConsumer$CC {
    public static DoubleConsumer $default$andThen(final DoubleConsumer _this, final DoubleConsumer after) {
        Objects.requireNonNull(after);
        return new DoubleConsumer() { // from class: j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                DoubleConsumer$CC.$private$lambda$andThen$0(DoubleConsumer.this, after, d);
            }

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }
        };
    }

    public static /* synthetic */ void $private$lambda$andThen$0(DoubleConsumer _this, DoubleConsumer after, double t) {
        _this.accept(t);
        after.accept(t);
    }
}