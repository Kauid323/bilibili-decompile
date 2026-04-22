package j$.util;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OptionalDouble$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}