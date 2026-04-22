package j$.util.stream;

import j$.util.function.LongConsumer$CC;
import java.util.function.LongConsumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda12 implements LongConsumer {
    public final /* synthetic */ Sink f$0;

    public /* synthetic */ LongPipeline$$ExternalSyntheticLambda12(Sink sink) {
        this.f$0 = sink;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f$0.accept(j);
    }

    @Override // java.util.function.LongConsumer
    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return LongConsumer$CC.$default$andThen(this, longConsumer);
    }
}