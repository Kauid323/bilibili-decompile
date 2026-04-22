package baseverify;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.thread.ThreadControl;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.face.utils.DownloadUtil;
import com.dtf.face.utils.LocalPreferencesUtil;
import com.dtf.face.utils.ModelDownloadUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    public Map<String, CopyOnWriteArrayList<APICallback<String>>> a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f7b;
    public List<String> c;
    public AtomicInteger d;
    public String e = "";
    public String f;

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class a implements Runnable {
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f8b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ APICallback d;

        public a(Context context, List list, boolean z, APICallback aPICallback) {
            this.a = context;
            this.f8b = list;
            this.c = z;
            this.d = aPICallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a, this.f8b, this.c, this.d);
        }
    }

    public e(String str) {
        this.f = "";
        this.f = str;
    }

    public final void a(Context context, List<String> list, boolean z, APICallback<String> aPICallback) {
        if (ModelDownloadUtil.chooseValidLocalModel(context, this.f) != null) {
            if (aPICallback != null) {
                aPICallback.onSuccess("SUCCESS");
                return;
            }
            return;
        }
        synchronized (ModelDownloadUtil.class) {
            a();
            if (ModelDownloadUtil.chooseValidLocalModel(context, this.f) != null) {
                if (aPICallback != null) {
                    aPICallback.onSuccess("SUCCESS");
                }
                return;
            }
            RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", z ? "preload" : "backup"});
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    String lowerCase = str.toLowerCase();
                    if (!TextUtils.isEmpty(str) && ((lowerCase.startsWith("http") || lowerCase.startsWith("www")) && !this.f7b.contains(str) && !this.c.contains(str) && !this.e.equals(str))) {
                        this.f7b.add(str);
                    }
                }
            }
            if (this.a.get(this.f) != null) {
                if (aPICallback != null) {
                    this.a.get(this.f).add(aPICallback);
                }
                return;
            }
            CopyOnWriteArrayList<APICallback<String>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            if (aPICallback != null) {
                copyOnWriteArrayList.add(aPICallback);
            }
            this.a.put(this.f, copyOnWriteArrayList);
            a(context, this.f, ModelDownloadUtil.getLocalStoreDir(context), null, new b(System.currentTimeMillis()));
        }
    }

    public void b(Context context, List<String> list, boolean z, APICallback<String> aPICallback) {
        ThreadControl.runOnSingleThread(new a(context, list, z, aPICallback));
    }

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class c implements APICallback<Pair<File, String>> {
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ APICallback f10b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public c(long j, APICallback aPICallback, Context context, String str, String str2, String str3) {
            this.a = j;
            this.f10b = aPICallback;
            this.c = context;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        public void a() {
            ModelDownloadUtil.cleanModel(this.c, this.d);
            onError("INVALID_FILE", "Null file", null);
        }

        public void onError(String str, String str2, String str3) {
            a(str.equals("INVALID_FILE") ? -1 : 0, str + "-" + str2 + "-" + str3, System.currentTimeMillis());
            e eVar = e.this;
            if (!eVar.c.contains(eVar.e)) {
                e eVar2 = e.this;
                eVar2.c.add(eVar2.e);
            }
            e eVar3 = e.this;
            eVar3.e = "";
            eVar3.a(this.c, this.d, this.e, this.f, this.f10b);
        }

        public void onSuccess(Object obj) {
            Pair pair = (Pair) obj;
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.a;
            if (pair == null) {
                onError("NULL-PARAMS", "Null file", null);
            } else if (j > 5) {
                Object obj2 = pair.second;
                String lowerCase = obj2 != null ? ((String) obj2).toLowerCase() : "";
                if (!lowerCase.startsWith("http") && !lowerCase.startsWith("www")) {
                    APICallback aPICallback = this.f10b;
                    if (aPICallback != null) {
                        aPICallback.onSuccess(pair.first);
                    }
                } else {
                    LocalPreferencesUtil.putString("faceModelURL", (String) pair.second);
                    APICallback aPICallback2 = this.f10b;
                    if (aPICallback2 != null) {
                        aPICallback2.onSuccess(pair.first);
                    } else {
                        onError("MD5-ERROR", "Rename MD5 error", null);
                        return;
                    }
                }
                a(1, null, currentTimeMillis);
            } else if (ClientConfigUtil.needUploadInvalidModel()) {
                ThreadControl.runOnMultiThread(new f(this, pair));
            } else {
                a();
            }
        }

        public void a(int i, String str, long j) {
            RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", TtmlNode.END, "url", e.this.e, "result", String.valueOf(i), "msg", str != null ? str : "NULL", "totalCost", String.valueOf(j - this.a)});
        }
    }

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class b implements APICallback<File> {
        public final /* synthetic */ long a;

        public b(long j) {
            this.a = j;
        }

        public void a() {
            CopyOnWriteArrayList<APICallback<String>> remove;
            a(true);
            synchronized (ModelDownloadUtil.class) {
                remove = e.this.a.remove(e.this.f);
            }
            if (remove != null) {
                for (APICallback<String> aPICallback : remove) {
                    aPICallback.onSuccess("SUCCESS");
                }
            }
        }

        public void onError(String str, String str2, String str3) {
            CopyOnWriteArrayList<APICallback<String>> remove;
            a(false);
            synchronized (ModelDownloadUtil.class) {
                remove = e.this.a.remove(e.this.f);
            }
            if (remove != null) {
                for (APICallback<String> aPICallback : remove) {
                    aPICallback.onError(str, str2, str3);
                }
            }
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            File file = (File) obj;
            a();
        }

        public void a(boolean z) {
            RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", "total", "result", z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0", "cost", String.valueOf(System.currentTimeMillis() - this.a), "count", String.valueOf(e.this.d.get())});
            e.this.d.set(0);
            e.this.f7b.clear();
        }
    }

    public final synchronized void a() {
        if (this.f7b == null) {
            this.f7b = new CopyOnWriteArrayList();
        }
        if (this.d == null) {
            this.d = new AtomicInteger(0);
        }
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        if (this.c == null) {
            this.c = new CopyOnWriteArrayList();
        }
    }

    public final void a(Context context, String str, String str2, String str3, APICallback<File> aPICallback) {
        if (this.f7b.size() == 0) {
            if (aPICallback != null) {
                aPICallback.onError("RETRY-OVER", (String) null, (String) null);
                return;
            }
            return;
        }
        this.d.incrementAndGet();
        long currentTimeMillis = System.currentTimeMillis();
        this.e = this.f7b.remove(0);
        RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", TtmlNode.START, "url", this.e, TtmlNode.LEFT, String.valueOf(this.f7b.size())});
        DownloadUtil.downloadFileAsync(this.e, str2, str3, str, 0, new c(currentTimeMillis, aPICallback, context, str, str2, str3));
    }
}