package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

/* compiled from: TML */
public class j5 extends BroadcastReceiver {
    public final m4 a;
    public boolean b;

    public j5(m4 m4Var) {
        this.a = m4Var;
    }

    public void a() {
        if (this.b) {
            this.b = false;
            try {
                this.a.a.unregisterReceiver(this);
            } catch (Exception e) {
            }
        }
    }

    public void b(Handler handler) {
        if (this.b) {
            return;
        }
        this.b = true;
        a(handler);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                l4.b();
                o1.a().a(new t1(-1));
            } else if (b7.c(context)) {
                o1.a().a(new t1(1));
                l4.a(context);
            } else {
                l4.b();
                o1.a().a(new t1(0));
            }
        } catch (Exception e) {
            a7.a("TxNetworkStateMonitor", "listenNetworkState: Exception", e);
        }
    }

    public final void a(Handler handler) {
        if (handler != null) {
            try {
                __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(this.a.a, this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
            } catch (Exception e) {
                a7.a("TxNetworkStateMonitor", "listenNetworkState: failed", e);
            }
        }
    }

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter, String permission, Handler scheduler) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler);
    }
}