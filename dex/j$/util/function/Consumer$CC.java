package j$.util.function;

import j$.util.Objects;
import java.util.function.Consumer;

/* renamed from: j$.util.function.Consumer$-CC */
public final /* synthetic */ class Consumer$CC {
    public static Consumer $default$andThen(final Consumer _this, final Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new Consumer() { // from class: j$.util.function.Consumer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Consumer$CC.$private$lambda$andThen$0(Consumer.this, consumer, obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer$CC.$default$andThen(this, consumer2);
            }
        };
    }

    public static /* synthetic */ void $private$lambda$andThen$0(Consumer _this, Consumer after, Object t) {
        _this.accept(t);
        after.accept(t);
    }
}