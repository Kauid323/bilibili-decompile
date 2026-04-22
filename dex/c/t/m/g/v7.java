package c.t.m.g;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: TML */
public class v7 {
    public final List<w7> a;
    public boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public long f111c = 0;
    public long d = 0;
    public long e = 0;
    public boolean f = true;
    public HandlerThread g;
    public Looper h;

    static {
        TimeUnit.SECONDS.toMillis(1L);
    }

    public v7(Context context, w7... w7VarArr) {
        HandlerThread handlerThread = new HandlerThread("GPS_DEMO");
        this.g = handlerThread;
        handlerThread.start();
        this.h = this.g.getLooper();
        new Handler(this.h);
        this.a = Arrays.asList(w7VarArr);
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
    }
}