package c.t.m.g;

import android.content.Context;
import android.location.GnssClock;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import com.tencent.tencentmap.lbssdk.service.GTime;
import com.tencent.tencentmap.lbssdk.service.GnssRaw;
import com.tencent.tencentmap.lbssdk.service.TxRtkSvr;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TML */
public class x7 implements w7 {
    public final Context a;
    public BufferedWriter d;
    public BufferedWriter e;
    public BufferedWriter f;
    public BufferedWriter g;
    public File h;
    public File i;
    public File j;
    public File k;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public GnssRaw f122c = new GnssRaw();
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public boolean p = true;
    public boolean q = true;
    public ReentrantLock r = new ReentrantLock();

    public x7(Context context) {
        this.a = context;
    }

    public void a(int i) {
    }

    public void a(long j) {
    }

    public void a(GnssNavigationMessage gnssNavigationMessage) {
    }

    public void a(GnssStatus gnssStatus) {
    }

    public void a(Location location) {
        String str;
        if (location.getProvider().equals("gps")) {
            if (!this.p) {
                str = "";
            } else {
                str = String.format(Locale.US, "Fix,%s,%f,%f,%f,%f,%f,%f,%d,%d%n", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(location.getTime()));
            }
            this.f122c.mLatitude = location.getLatitude();
            this.f122c.mLongitude = location.getLongitude();
            this.f122c.mAltitude = location.getAltitude();
            this.f122c.mSpeed = location.getSpeed();
            this.f122c.mHorizontalAccuracyMeters = location.getAccuracy();
            this.f122c.mBearing = location.getBearing();
            this.f122c.mTime = location.getTime();
            this.f122c.mProvider = 1;
            BufferedWriter bufferedWriter = this.e;
            if (bufferedWriter != null && this.m != 0) {
                try {
                    bufferedWriter.write(str);
                    this.e.newLine();
                    this.e.flush();
                } catch (IOException e) {
                    a("Problem writing to file.", e);
                }
            }
            this.r.lock();
            try {
                TxRtkSvr.jni_upd_android_data(str.getBytes().length, str.getBytes(), this.f122c, 1);
            } finally {
            }
        }
        if (location.getProvider().equals("network")) {
            String format = this.p ? String.format(Locale.US, "NLP,%s,%f,%f,%f,%f,%f,%f,%d,%d%n", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(location.getTime())) : "";
            this.f122c.mLatitude = location.getLatitude();
            this.f122c.mLongitude = location.getLongitude();
            this.f122c.mAltitude = location.getAltitude();
            this.f122c.mSpeed = location.getSpeed();
            this.f122c.mHorizontalAccuracyMeters = location.getAccuracy();
            this.f122c.mBearing = location.getBearing();
            this.f122c.mTime = location.getTime();
            this.f122c.mProvider = 0;
            BufferedWriter bufferedWriter2 = this.f;
            if (bufferedWriter2 != null && this.n != 0) {
                try {
                    bufferedWriter2.write(format);
                    this.f.newLine();
                    this.f.flush();
                } catch (IOException e2) {
                    a("Problem writing to file.", e2);
                }
            }
            this.r.lock();
            try {
                TxRtkSvr.jni_upd_android_data(format.getBytes().length, format.getBytes(), this.f122c, 0);
            } finally {
            }
        }
    }

    public void b(int i) {
        b("Gnss Navigation Message Status Changed");
    }

    public final void c() {
        BufferedWriter bufferedWriter;
        if (this.k == null || this.o == 0 || (bufferedWriter = this.g) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.g.close();
            this.g = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final void d() {
        BufferedWriter bufferedWriter;
        if (this.i == null || this.m == 0 || (bufferedWriter = this.e) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.e.close();
            this.e = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final void e() {
        BufferedWriter bufferedWriter;
        if (this.h == null || this.l == 0 || (bufferedWriter = this.d) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.d.close();
            this.d = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final int f() {
        File file = new File(this.a.getExternalFilesDir("dgnss"), String.format("%s_%s.raw", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.d;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.h = file;
            this.d = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int g() {
        File file = new File(this.a.getExternalFilesDir("dgnss"), String.format("%s_%s.nlp", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.f;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.j = file;
            this.f = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("Could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int h() {
        File file = new File(this.a.getExternalFilesDir("dgnss"), String.format("%s_%s.nma", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.g;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.k = file;
            this.g = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("Could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int i() {
        File file = new File(this.a.getExternalFilesDir("dgnss"), String.format("%s_%s.pos", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.e;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.i = file;
            this.e = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public void j() {
        if (this.q) {
            this.l = f();
        }
        if (this.q) {
            this.m = i();
        }
        if (this.q) {
            this.n = g();
        }
        if (this.q) {
            this.o = h();
        }
    }

    public final void b() {
        BufferedWriter bufferedWriter;
        if (this.j == null || this.n == 0 || (bufferedWriter = this.f) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.f.close();
            this.f = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final synchronized String c(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        return String.format("%s,%s,%s,%s,%s,%s,", Integer.valueOf(gnssMeasurement.getSvid()), Double.valueOf(gnssMeasurement.getTimeOffsetNanos()), Integer.valueOf(gnssMeasurement.getState()), Long.valueOf(gnssMeasurement.getReceivedSvTimeNanos()), Long.valueOf(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()), Double.valueOf(gnssMeasurement.getCn0DbHz()));
    }

    public final synchronized String d(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        String valueOf;
        valueOf = gnssMeasurement.hasCarrierFrequencyHz() ? String.valueOf(gnssMeasurement.getCarrierFrequencyHz()) : "";
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Double.valueOf(gnssMeasurement.getPseudorangeRateMetersPerSecond()), Double.valueOf(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()), Integer.valueOf(gnssMeasurement.getAccumulatedDeltaRangeState()), Double.valueOf(gnssMeasurement.getAccumulatedDeltaRangeMeters()), Double.valueOf(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()), valueOf, gnssMeasurement.hasCarrierCycles() ? String.valueOf(gnssMeasurement.getCarrierCycles()) : "", gnssMeasurement.hasCarrierPhase() ? String.valueOf(gnssMeasurement.getCarrierPhase()) : "", gnssMeasurement.hasCarrierPhaseUncertainty() ? String.valueOf(gnssMeasurement.getCarrierPhaseUncertainty()) : "", Integer.valueOf(gnssMeasurement.getMultipathIndicator()), gnssMeasurement.hasSnrInDb() ? String.valueOf(gnssMeasurement.getSnrInDb()) : "", Integer.valueOf(gnssMeasurement.getConstellationType()), (Build.VERSION.SDK_INT < 26 || !gnssMeasurement.hasAutomaticGainControlLevelDb()) ? "" : String.valueOf(gnssMeasurement.getAutomaticGainControlLevelDb()), valueOf, gnssClock.hasLeapSecond() ? String.valueOf(gnssClock.getLeapSecond()) : "");
    }

    public final synchronized int e(GnssClock gnssClock, GnssMeasurement gnssMeasurement) throws IOException {
        if (this.l == 0) {
            return 0;
        }
        this.d.write(this.b);
        this.d.newLine();
        this.d.flush();
        return 1;
    }

    public final synchronized String b(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        return c(gnssClock, gnssMeasurement) + d(gnssClock, gnssMeasurement);
    }

    public final void b(GnssClock gnssClock, GnssMeasurement gnssMeasurement, GnssRaw gnssRaw) {
        gnssRaw.mSvid = gnssMeasurement.getSvid();
        gnssRaw.mTimeOffsetNanos = gnssMeasurement.getTimeOffsetNanos();
        gnssRaw.mState = gnssMeasurement.getState();
        gnssRaw.mReceivedSvTimeNanos = gnssMeasurement.getReceivedSvTimeNanos();
        gnssRaw.mReceivedSvTimeUncertaintyNanos = gnssMeasurement.getReceivedSvTimeUncertaintyNanos();
        gnssRaw.mCn0DbHz = gnssMeasurement.getCn0DbHz();
        gnssRaw.mPseudorangeRateMetersPerSecond = gnssMeasurement.getPseudorangeRateMetersPerSecond();
        gnssRaw.mPseudorangeRateUncertaintyMetersPerSecond = gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond();
        gnssRaw.mAccumulatedDeltaRangeState = gnssMeasurement.getAccumulatedDeltaRangeState();
        gnssRaw.mAccumulatedDeltaRangeMeters = gnssMeasurement.getAccumulatedDeltaRangeMeters();
        gnssRaw.mAccumulatedDeltaRangeUncertaintyMeters = gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters();
        gnssRaw.mCarrierFrequencyHz = gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f;
        gnssRaw.mCarrierCycles = gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L;
        double d = 0.0d;
        gnssRaw.mCarrierPhase = gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : 0.0d;
        gnssRaw.mCarrierPhaseUncertainty = gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : 0.0d;
        gnssRaw.mMultipathIndicator = gnssMeasurement.getMultipathIndicator();
        gnssRaw.mSnrInDb = gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : 0.0d;
        gnssRaw.mConstellationType = gnssMeasurement.getConstellationType();
        if (Build.VERSION.SDK_INT >= 26 && gnssMeasurement.hasAutomaticGainControlLevelDb()) {
            d = gnssMeasurement.getAutomaticGainControlLevelDb();
        }
        gnssRaw.mAutomaticGainControlLevelInDb = d;
    }

    public final void b(String str) {
        Log.w("GnssLogger", str);
    }

    public void a(String str, int i, Bundle bundle) {
        b(str + "Not Implemented");
    }

    public void a(GnssMeasurementsEvent gnssMeasurementsEvent) {
        gnssMeasurementsEvent.getMeasurements().size();
        GnssClock clock = gnssMeasurementsEvent.getClock();
        if (this.d != null) {
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                a(clock, gnssMeasurement);
                try {
                    if (e(clock, gnssMeasurement) == 0) {
                        a("Problem writing to file.");
                    }
                } catch (IOException e) {
                    a("Problem writing to file.", e);
                }
            }
        }
        int size = gnssMeasurementsEvent.getMeasurements().size();
        t7.a("txgpos", "get gnss satellites: " + size);
        this.r.lock();
        try {
            this.b = "";
            int i = 0;
            for (GnssMeasurement gnssMeasurement2 : gnssMeasurementsEvent.getMeasurements()) {
                if (this.p) {
                    a(clock, gnssMeasurement2);
                }
                a(clock, gnssMeasurement2, this.f122c);
                i++;
                if (i == size) {
                    if (this.p) {
                        this.b += ",TXEPOCHEND\n";
                    }
                    this.f122c.mEndFlag = 1;
                } else if (this.p) {
                    this.b += XMPRDFWriter.XMP_DEFAULT_NEWLINE;
                }
                a(this.b, this.f122c);
            }
        } finally {
            this.r.unlock();
        }
    }

    public void a(long j, String str) {
        BufferedWriter bufferedWriter = this.g;
        if (bufferedWriter == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.g.newLine();
            this.g.flush();
        } catch (IOException e) {
            a("Problem writing to file.", e);
        }
    }

    public void a() {
        e();
        d();
        c();
        b();
    }

    public final synchronized String a(GnssClock gnssClock) {
        return String.format("Raw,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(gnssClock.getTimeNanos()), gnssClock.hasLeapSecond() ? Integer.valueOf(gnssClock.getLeapSecond()) : "", gnssClock.hasTimeUncertaintyNanos() ? Double.valueOf(gnssClock.getTimeUncertaintyNanos()) : "", Long.valueOf(gnssClock.getFullBiasNanos()), gnssClock.hasBiasNanos() ? Double.valueOf(gnssClock.getBiasNanos()) : "", gnssClock.hasBiasUncertaintyNanos() ? Double.valueOf(gnssClock.getBiasUncertaintyNanos()) : "", gnssClock.hasDriftNanosPerSecond() ? Double.valueOf(gnssClock.getDriftNanosPerSecond()) : "", gnssClock.hasDriftUncertaintyNanosPerSecond() ? Double.valueOf(gnssClock.getDriftUncertaintyNanosPerSecond()) : "", gnssClock.getHardwareClockDiscontinuityCount() + ",");
    }

    public final synchronized void a(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        String a = a(gnssClock);
        String b = b(gnssClock, gnssMeasurement);
        this.b = a + b + "," + GTime.jni_getCurrSow() + "," + Long.toString(System.currentTimeMillis());
    }

    public final void a(GnssClock gnssClock, GnssRaw gnssRaw) {
        gnssRaw.mEndFlag = 0;
        gnssRaw.elapsedRealtime = SystemClock.elapsedRealtime();
        gnssRaw.mTimeNanos = gnssClock.getTimeNanos();
        gnssRaw.mLeapSecond = gnssClock.hasLeapSecond() ? gnssClock.getLeapSecond() : 0;
        gnssRaw.mTimeUncertaintyNanos = gnssClock.hasTimeUncertaintyNanos() ? gnssClock.getTimeUncertaintyNanos() : 0.0d;
        gnssRaw.mFullBiasNanos = gnssClock.getFullBiasNanos();
        gnssRaw.mBiasNanos = gnssClock.hasBiasNanos() ? gnssClock.getBiasNanos() : 0.0d;
        gnssRaw.mBiasUncertaintyNanos = gnssClock.hasBiasUncertaintyNanos() ? gnssClock.getBiasUncertaintyNanos() : 0.0d;
        gnssRaw.mDriftNanosPerSecond = gnssClock.hasDriftNanosPerSecond() ? gnssClock.getDriftNanosPerSecond() : 0.0d;
        gnssRaw.mDriftUncertaintyNanosPerSecond = gnssClock.hasDriftUncertaintyNanosPerSecond() ? gnssClock.getDriftUncertaintyNanosPerSecond() : 0.0d;
        gnssRaw.mHardwareClockDiscontinuityCount = gnssClock.getHardwareClockDiscontinuityCount();
    }

    public final synchronized void a(GnssClock gnssClock, GnssMeasurement gnssMeasurement, GnssRaw gnssRaw) {
        a(gnssClock, gnssRaw);
        b(gnssClock, gnssMeasurement, gnssRaw);
    }

    public final synchronized int a(String str, GnssRaw gnssRaw) {
        return TxRtkSvr.jni_upd_android_data(str.getBytes().length, str.getBytes(), gnssRaw, 2);
    }

    public final void a(String str, Exception exc) {
        Log.e("GnssLogger", str, exc);
        if (t7.a) {
            t7.a("GnssLogger", str);
        }
    }

    public final void a(String str) {
        Log.e("GnssLogger", str);
        if (t7.a) {
            t7.a("GnssLogger", str);
        }
    }
}