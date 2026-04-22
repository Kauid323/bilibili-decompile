package android.adservices.measurement;

import android.adservices.common.AdServicesOutcomeReceiver;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public class MeasurementManager {
    MeasurementManager() {
        throw new RuntimeException("Stub!");
    }

    public static MeasurementManager get(Context context) {
        throw new RuntimeException("Stub!");
    }

    public void registerTrigger(Uri trigger, Executor executor, OutcomeReceiver<Object, Exception> callback) {
        throw new RuntimeException("Stub!");
    }

    public void registerTrigger(Uri trigger, Executor executor, AdServicesOutcomeReceiver<Object, Exception> callback) {
        throw new RuntimeException("Stub!");
    }
}