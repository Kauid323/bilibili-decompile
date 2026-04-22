package f;

import java.util.concurrent.ThreadPoolExecutor;

public final class b {
    public f.a a;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class a {
        public static b a = new b();
    }

    public b() {
        this.a = null;
        this.a = new f.a();
    }

    public final void a(c cVar) {
        ThreadPoolExecutor threadPoolExecutor = this.a.a;
        if (cVar.a != 1) {
            int a2 = d.a(cVar.a);
            if (a2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (a2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        cVar.a = 2;
        cVar.b.getClass();
        cVar.b.getClass();
        threadPoolExecutor.execute(cVar.c);
    }
}