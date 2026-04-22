package f;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
    public static final int b;
    public static final int c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0018a f1894d;
    public ThreadPoolExecutor a;

    /* renamed from: f.a$a  reason: collision with other inner class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class C0018a implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
            return 0;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors + 1;
        c = (availableProcessors * 2) + 1;
        f1894d = new C0018a();
    }

    public a() {
        if (this.a == null) {
            this.a = new ThreadPoolExecutor(b, c, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, f1894d));
        }
    }
}