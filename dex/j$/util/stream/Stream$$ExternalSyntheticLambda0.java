package j$.util.stream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Stream$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Stream f$0;

    public /* synthetic */ Stream$$ExternalSyntheticLambda0(Stream stream) {
        this.f$0 = stream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}