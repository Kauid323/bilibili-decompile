package c.t.m.g;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentGeofence;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TML */
public class s4 extends BroadcastReceiver implements TencentLocationListener, PendingIntent.OnFinished {
    public final Context a;
    public TencentLocationManager b;

    /* renamed from: c  reason: collision with root package name */
    public final a f93c;
    public final b d;
    public boolean e;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            s4.this.a(true);
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b {
        public final List<q4> a = new LinkedList();
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public Location f94c = null;
        public boolean d = false;

        public void a() {
            this.a.clear();
            this.b = false;
            this.f94c = null;
            this.d = false;
        }
    }

    public s4(Context context, Looper looper) {
        this.d = new b();
        this.e = false;
        TencentLocationRequest.create().setInterval(5000L);
        this.a = context;
        a7.a(context);
        b3.a(context);
        a7.c("NewTxLocationManagerImpl", "TxtGeofenceManagerImpl new TxLocationManagerImpl");
        this.b = TencentLocationManager.getInstance(this.a);
        this.f93c = new a(looper);
        e();
    }

    public void b() {
        if (this.e) {
            return;
        }
        f();
        this.a.unregisterReceiver(this);
        this.e = true;
    }

    public final void c(String str) {
        if (this.d.d) {
            return;
        }
        a(str);
        this.d.d = true;
        this.f93c.sendEmptyMessage(1);
    }

    public List<TencentGeofence> d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.d) {
            for (q4 q4Var : this.d.a) {
                arrayList.add(q4Var.a);
            }
        }
        return arrayList;
    }

    public final void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("com.tencent.map.geolocation.wakeup");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.a, this, intentFilter, null, this.f93c);
    }

    public void f() {
        a();
        synchronized (this.d) {
            this.d.a.clear();
            d("removeAllFence: --> schedule update fence");
        }
    }

    public final void g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<q4> it = this.d.a.iterator();
        while (it.hasNext()) {
            q4 next = it.next();
            if (next.f86c < elapsedRealtime) {
                it.remove();
                a7.c("GeofenceManager", "remove expired fence, " + next.a.getTag());
            }
        }
    }

    public final void h() {
        this.d.a();
    }

    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        Location a2 = r4.a(tencentLocation, false);
        a7.b("GeofenceManager", "onLocationChanged geofence");
        if (tencentLocation != null && i == 0) {
            synchronized (this.d) {
                if (this.d.b) {
                    this.d.f94c = a2;
                }
                a("onLocationChanged: fresh location got --> update fences");
                this.f93c.removeMessages(1);
                a(false);
            }
            return;
        }
        a7.b("GeofenceManager", "location error, " + i + ", " + str);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        synchronized (this.d) {
            boolean z = c() == null;
            if ("android.intent.action.SCREEN_ON".equals(action) && z) {
                c("onReceive: screen_on and no_fresh_location --> schedule update fence");
            }
        }
    }

    @Override // android.app.PendingIntent.OnFinished
    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
    }

    public void onStatusUpdate(String str, int i, String str2) {
    }

    public static boolean a(TencentGeofence.FencePoint fencePoint, List<TencentGeofence.FencePoint> list) {
        int size = list.size();
        TencentGeofence.FencePoint fencePoint2 = list.get(0);
        int i = 0;
        int i2 = 1;
        while (i2 <= size) {
            if (fencePoint.equals(fencePoint2)) {
                return true;
            }
            TencentGeofence.FencePoint fencePoint3 = list.get(i2 % size);
            if (fencePoint.getLatitude() >= Math.min(fencePoint2.getLatitude(), fencePoint3.getLatitude()) && fencePoint.getLatitude() <= Math.max(fencePoint2.getLatitude(), fencePoint3.getLatitude())) {
                if (fencePoint.getLatitude() > Math.min(fencePoint2.getLatitude(), fencePoint3.getLatitude()) && fencePoint.getLatitude() < Math.max(fencePoint2.getLatitude(), fencePoint3.getLatitude())) {
                    if (fencePoint.getLongitude() > Math.max(fencePoint2.getLongitude(), fencePoint3.getLongitude())) {
                        continue;
                    } else if (fencePoint2.getLatitude() == fencePoint3.getLatitude() && fencePoint.getLongitude() >= Math.min(fencePoint2.getLongitude(), fencePoint3.getLongitude())) {
                        return true;
                    } else {
                        if (fencePoint2.getLongitude() == fencePoint3.getLongitude()) {
                            if (fencePoint2.getLongitude() == fencePoint.getLongitude()) {
                                return true;
                            }
                        } else {
                            double latitude = (((fencePoint.getLatitude() - fencePoint2.getLatitude()) * (fencePoint3.getLongitude() - fencePoint2.getLongitude())) / (fencePoint3.getLatitude() - fencePoint2.getLatitude())) + fencePoint2.getLongitude();
                            if (Math.abs(fencePoint.getLongitude() - latitude) < 2.0E-10d) {
                                return true;
                            }
                            if (fencePoint.getLongitude() >= latitude) {
                            }
                        }
                        i++;
                    }
                } else if (fencePoint.getLatitude() == fencePoint3.getLatitude() && fencePoint.getLongitude() <= fencePoint3.getLongitude()) {
                    TencentGeofence.FencePoint fencePoint4 = list.get((i2 + 1) % size);
                    if (fencePoint.getLatitude() < Math.min(fencePoint2.getLatitude(), fencePoint4.getLatitude()) || fencePoint.getLatitude() > Math.max(fencePoint2.getLatitude(), fencePoint4.getLatitude())) {
                        i += 2;
                    }
                    i++;
                }
            }
            i2++;
            fencePoint2 = fencePoint3;
        }
        return i % 2 != 0;
    }

    public final void b(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        a7.c("GeofenceManager", "removeFence: fence=" + tencentGeofence + ", intent=" + pendingIntent);
        synchronized (this.d) {
            Iterator<q4> it = this.d.a.iterator();
            while (it.hasNext()) {
                q4 next = it.next();
                if (next.d.equals(pendingIntent)) {
                    if (tencentGeofence == null) {
                        it.remove();
                    } else if (tencentGeofence.equals(next.a)) {
                        it.remove();
                        a7.c("GeofenceManager", "remove fence: " + next.a.getTag());
                    }
                }
            }
            d("removeFence: --> schedule update fence");
        }
    }

    public final Location c() {
        b bVar = this.d;
        Location location = bVar.f94c;
        List<q4> list = bVar.a;
        if (location == null && !list.isEmpty()) {
            location = r4.a(this.b.getLastKnownLocation(), false);
        }
        if (location == null) {
            a7.c("GeofenceManager", "location is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - location.getTime() >= 60000) {
            a7.c("GeofenceManager", "location timeout, " + (currentTimeMillis - location.getTime()));
            return null;
        }
        return location;
    }

    public final void d(String str) {
        if (this.d.d) {
            return;
        }
        a(str);
        this.d.d = true;
        this.f93c.sendEmptyMessage(1);
    }

    public void b(String str) {
        a();
        a7.c("GeofenceManager", "removeFence: tag=" + str);
        synchronized (this.d) {
            Iterator<q4> it = this.d.a.iterator();
            while (it.hasNext()) {
                TencentGeofence tencentGeofence = it.next().a;
                if (tencentGeofence == null || TextUtils.equals(tencentGeofence.getTag(), str)) {
                    it.remove();
                }
            }
            d("removeFence: " + str + " removed --> schedule update fence");
        }
    }

    public final void b(PendingIntent pendingIntent) {
        a7.c("GeofenceManager", "sendIntentExit: pendingIntent=" + pendingIntent);
        Intent intent = new Intent();
        intent.putExtra("entering", false);
        a(pendingIntent, intent);
    }

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter, String permission, Handler scheduler) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler);
    }

    public final void a() {
        if (this.e) {
            throw new IllegalStateException("this object has been destroyed!");
        }
    }

    public void a(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        a();
        if (tencentGeofence != null && pendingIntent != null) {
            if (tencentGeofence.getType() == 1 && (tencentGeofence.getPolygonFence() == null || tencentGeofence.getPolygonFence().getPointList().size() < 3)) {
                throw new IllegalArgumentException("polygon edge points < 3");
            }
            a7.c("GeofenceManager", "addFence: geofence=" + tencentGeofence + ", intent=" + pendingIntent);
            q4 q4Var = new q4(tencentGeofence, tencentGeofence.getExpireAt(), "packageName", pendingIntent);
            b bVar = this.d;
            List<q4> list = bVar.a;
            synchronized (bVar) {
                int size = list.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    q4 q4Var2 = list.get(size);
                    if (tencentGeofence.equals(q4Var2.a) && pendingIntent.equals(q4Var2.d)) {
                        a7.b("GeofenceManager", "fence " + q4Var2.a.getTag() + " is exits, remove old one.");
                        list.remove(size);
                        break;
                    }
                    size--;
                }
                list.add(q4Var);
                d("addFence: --> schedule update fence");
            }
            return;
        }
        throw null;
    }

    public s4(Context context) {
        this(context, Looper.myLooper());
    }

    public void a(TencentGeofence tencentGeofence) {
        a();
        if (tencentGeofence == null) {
            return;
        }
        a7.c("GeofenceManager", "removeFence: fence=" + tencentGeofence);
        synchronized (this.d) {
            Iterator<q4> it = this.d.a.iterator();
            while (it.hasNext()) {
                if (tencentGeofence.equals(it.next().a)) {
                    it.remove();
                }
            }
            d("removeFence: --> schedule update fence");
        }
    }

    public final void a(boolean z) {
        LinkedList<PendingIntent> linkedList = new LinkedList();
        LinkedList<PendingIntent> linkedList2 = new LinkedList();
        synchronized (this.d) {
            this.d.d = false;
            g();
            Location c2 = c();
            a("updateFences: fresh_location=" + c2);
            List<q4> list = this.d.a;
            if (c2 != null) {
                r4.a(c2);
                for (q4 q4Var : list) {
                    int a2 = q4Var.a(c2);
                    if ((a2 & 1) != 0) {
                        a7.c("GeofenceManager", "fence enter, " + q4Var.a.getTag());
                        linkedList.add(q4Var.d);
                    }
                    if ((a2 & 2) != 0) {
                        a7.c("GeofenceManager", "fence exit, " + q4Var.a.getTag());
                        linkedList2.add(q4Var.d);
                    }
                }
            }
            if (!list.isEmpty() && !this.d.b) {
                this.d.b = true;
                this.b.addLocationListener(this);
                a7.c("GeofenceManager", "updateFences, addLocationListener");
            } else if (list.isEmpty() && this.d.b) {
                this.d.b = false;
                this.b.removeLocationListener(this);
                h();
                a7.c("GeofenceManager", "updateFences, removeLocationListener");
            }
        }
        for (PendingIntent pendingIntent : linkedList2) {
            b(pendingIntent);
        }
        for (PendingIntent pendingIntent2 : linkedList) {
            a(pendingIntent2);
        }
    }

    public final void a(PendingIntent pendingIntent) {
        a7.c("GeofenceManager", "sendIntentEnter: pendingIntent=" + pendingIntent);
        Intent intent = new Intent();
        intent.putExtra("entering", true);
        a(pendingIntent, intent);
    }

    public final void a(PendingIntent pendingIntent, Intent intent) {
        try {
            pendingIntent.send(this.a, 0, intent, this, null);
        } catch (PendingIntent.CanceledException e) {
            b(null, pendingIntent);
        }
    }

    public static void a(String str) {
        a7.c("GeofenceManager", str);
    }
}