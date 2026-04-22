package j$.util.stream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LongStream$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ LongStream f$0;

    public /* synthetic */ LongStream$$ExternalSyntheticLambda1(LongStream longStream) {
        this.f$0 = longStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}