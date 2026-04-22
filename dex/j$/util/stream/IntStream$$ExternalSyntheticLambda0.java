package j$.util.stream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IntStream$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IntStream f$0;

    public /* synthetic */ IntStream$$ExternalSyntheticLambda0(IntStream intStream) {
        this.f$0 = intStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}