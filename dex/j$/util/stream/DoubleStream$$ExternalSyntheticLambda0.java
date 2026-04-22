package j$.util.stream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DoubleStream$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DoubleStream f$0;

    public /* synthetic */ DoubleStream$$ExternalSyntheticLambda0(DoubleStream doubleStream) {
        this.f$0 = doubleStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}