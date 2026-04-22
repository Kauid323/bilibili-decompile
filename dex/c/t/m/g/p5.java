package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import java.util.LinkedList;

/* compiled from: TML */
public class p5 {
    public a a;
    public HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80c;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(Message message) {
            int i = message.what;
            if (i == 1001) {
                if (p5.this.a != null) {
                    p5.this.a.sendEmptyMessage(IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE);
                }
            } else if (i != 1003) {
            } else {
                p5.this.a(101);
                p5.this.a(102);
                if (p5.this.a == null || !p5.this.f80c) {
                    return;
                }
                p5.this.a.sendEmptyMessageDelayed(IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE, 30000L);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable th) {
                a7.a("TxThreadPoolManger", "", th);
            }
        }
    }

    public p5() {
        new LinkedList();
    }

    public void a(Looper looper) {
        if (this.f80c) {
            return;
        }
        this.f80c = true;
        a7.c("TxThreadPoolManger", "TxThreadPoolManger startup");
        if (this.a == null) {
            if (looper != null) {
                this.a = new a(looper);
            } else {
                HandlerThread handlerThread = new HandlerThread("thread-thPoolMange");
                this.b = handlerThread;
                handlerThread.start();
                Looper looper2 = this.b.getLooper();
                a7.c("TxThreadPoolManger", "thpHandler create on thread-thPoolMange thread");
                this.a = new a(looper2);
            }
        }
        this.a.sendEmptyMessage(IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO);
    }

    public void a() {
        if (this.f80c) {
            this.f80c = false;
            a aVar = this.a;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
                this.a = null;
            }
            if (this.b != null) {
                this.b = null;
            }
        }
    }

    public void a(int i) {
        a7.c("ThreadPool", i + " ThreadPool Status: AliveThreadCount:" + j4.a() + ", ActiveThreadCount:" + j4.a(i) + ", QueSize:" + j4.g(i) + ", MaxCostTime:" + j4.e(i) + ", AvgCostTime:" + j4.b(i) + ", CompletedTaskCount:" + j4.d(i) + ", TaskCount:" + j4.h(i) + ", MaxQueWaitTime:" + j4.f(i) + ", AvgQueWaitTime:" + j4.c(i));
    }
}