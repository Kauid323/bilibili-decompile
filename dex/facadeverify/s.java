package facadeverify;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.performance.EntryPointKt;
import com.dtf.face.ToygerConfig;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.params.HttpConnectionParams;

public class s implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public static s f1918h;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f1919i = new a();
    public Context a;

    /* renamed from: d  reason: collision with root package name */
    public long f1920d;

    /* renamed from: e  reason: collision with root package name */
    public long f1921e;

    /* renamed from: f  reason: collision with root package name */
    public long f1922f;

    /* renamed from: g  reason: collision with root package name */
    public int f1923g;
    public m c = m.a("android");
    public ThreadPoolExecutor b = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f1919i, new ThreadPoolExecutor.CallerRunsPolicy());

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, facadeverify.a.a("com.alipay.zoloz.mobile.common.transport.http.HttpManager.HttpWorker #").append(this.a.getAndIncrement()).toString());
            thread.setPriority(4);
            return thread;
        }
    }

    public s(Context context) {
        this.a = context;
        try {
            this.b.allowCoreThreadTimeOut(true);
        } catch (Exception e2) {
        }
        CookieSyncManager.createInstance(this.a);
        __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance().setAcceptCookie(true);
    }

    public static final synchronized s a(Context context) {
        synchronized (s.class) {
            s sVar = f1918h;
            if (sVar != null) {
                return sVar;
            }
            f1918h = new s(context);
            return f1918h;
        }
    }

    public Future<x> a(u uVar) {
        if (uVar instanceof u) {
            w wVar = new w(this, uVar);
            r rVar = new r(this, wVar, wVar);
            this.b.execute(rVar);
            String a2 = uVar.a("operationType");
            if ("com.zoloz.zhub.zim.init.json".equalsIgnoreCase(a2)) {
                HttpConnectionParams.setSoTimeout(this.c.getParams(), ToygerConfig.getInstance().getTimeoutFoInit() * 1000);
            } else if ("com.zoloz.zhub.zim.verify.json".equalsIgnoreCase(a2)) {
                HttpConnectionParams.setSoTimeout(this.c.getParams(), ToygerConfig.getInstance().getTimeoutForVerify() * 1000);
            }
            return rVar;
        }
        throw new RuntimeException("request send error.");
    }

    public void a(long j) {
        this.f1921e += j;
        this.f1923g++;
    }

    @JvmStatic
    private static CookieManager __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance() {
        Application it;
        if (EntryPointKt.getBootOptEnable() && (it = BiliContext.application()) != null) {
            CookieSyncManager.createInstance(it);
            Log.e("WebViewGhost", "hook CookieManager getInstance");
        }
        CookieManager cookieManager = CookieManager.getInstance();
        Intrinsics.checkNotNull(cookieManager, "null cannot be cast to non-null type android.webkit.CookieManager");
        return cookieManager;
    }
}