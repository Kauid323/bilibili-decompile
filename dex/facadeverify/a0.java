package facadeverify;

import android.os.Looper;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.mpass.biz.rpc.exception.RpcException;
import facadeverify.h;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.Header;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<Object> f1905d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f1906e = new ThreadLocal<>();
    public byte a = 0;
    public AtomicInteger b = new AtomicInteger();
    public y c;

    public a0(y yVar) {
        this.c = yVar;
    }

    public Object a(Object obj, Class<?> cls, Method method, Object[] objArr) {
        if (!(Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())) {
            e0 e0Var = (e0) method.getAnnotation(e0.class);
            boolean z = method.getAnnotation(f0.class) != null;
            Type genericReturnType = method.getGenericReturnType();
            method.getAnnotations();
            f1905d.set(null);
            f1906e.set(null);
            if (e0Var != null) {
                String value = e0Var.value();
                int incrementAndGet = this.b.incrementAndGet();
                try {
                    if (this.a == 0) {
                        Object a = new i0(genericReturnType, a(method, objArr, value, incrementAndGet, z)).a();
                        if (genericReturnType != Void.TYPE) {
                            f1905d.set(a);
                        }
                    }
                    return f1905d.get();
                } catch (RpcException e2) {
                    e2.setOperationType(value);
                    throw e2;
                }
            }
            throw new IllegalStateException("OperationType must be set.");
        }
        throw new IllegalThreadStateException("can't in main thread call rpc .");
    }

    public final byte[] a(Method method, Object[] objArr, String str, int i2, boolean z) {
        j0 j0Var = new j0(i2, str, objArr);
        if (f1906e.get() != null) {
            j0Var.f1912d = f1906e.get();
        }
        try {
            ArrayList arrayList = new ArrayList();
            Object obj = j0Var.f1912d;
            if (obj != null) {
                arrayList.add(new BasicNameValuePair("extParam", d.a(obj)));
            }
            arrayList.add(new BasicNameValuePair("operationType", j0Var.a));
            arrayList.add(new BasicNameValuePair("id", j0Var.c + ""));
            Object obj2 = j0Var.b;
            arrayList.add(new BasicNameValuePair("requestData", obj2 == null ? "[]" : d.a(obj2)));
            o oVar = new o(this.c.a, method, i2, str, URLEncodedUtils.format(arrayList, "utf-8").getBytes(), z);
            u uVar = new u(((h.a) oVar.f1917f).c());
            ((h.a) oVar.f1917f).c();
            uVar.c = oVar.a;
            uVar.f1924d = oVar.f1913d;
            uVar.f1927g = oVar.f1914e;
            uVar.a("id", String.valueOf(oVar.c));
            uVar.a("operationType", oVar.b);
            ((h.a) oVar.f1917f).d();
            uVar.a("gzip", String.valueOf(true));
            String uuid = UUID.randomUUID().toString();
            uVar.a((Header) new BasicHeader("uuid", uuid));
            String a = uVar.a("operationType");
            if ("com.zoloz.zhub.zim.init.json".equals(a)) {
                RecordService.getInstance().setInitUUID(uuid);
            } else if ("com.zoloz.zhub.zim.verify.json".equals(a)) {
                RecordService.getInstance().setVerifyUUID(uuid);
            } else if ("com.zoloz.zhub.zim.ocr.json".equals(a)) {
                RecordService.getInstance().setOcrUUID(uuid);
            }
            List<Header> a2 = ((h.a) oVar.f1917f).a().a();
            if (a2 != null && !a2.isEmpty()) {
                for (Header header : a2) {
                    uVar.a(header);
                }
            }
            a.a("threadid = ").append(Thread.currentThread().getId()).append("; ").append(uVar.toString()).toString();
            try {
                x xVar = ((s) ((h.a) oVar.f1917f).b()).a(uVar).get();
                if (xVar != null) {
                    byte[] bArr = xVar.a;
                    f1906e.set(null);
                    return bArr;
                }
                throw new RpcException(9, "response is null");
            } catch (InterruptedException e2) {
                throw new RpcException(13, "", e2);
            } catch (CancellationException e3) {
                throw new RpcException(13, "", e3);
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                if (cause != null && (cause instanceof q)) {
                    q qVar = (q) cause;
                    int i3 = qVar.a;
                    switch (i3) {
                        case 1:
                            i3 = 2;
                            break;
                        case 2:
                            i3 = 3;
                            break;
                        case 3:
                            i3 = 4;
                            break;
                        case 4:
                            i3 = 5;
                            break;
                        case 5:
                            i3 = 6;
                            break;
                        case 6:
                            i3 = 7;
                            break;
                        case 7:
                            i3 = 8;
                            break;
                        case 8:
                            i3 = 15;
                            break;
                        case 9:
                            i3 = 16;
                            break;
                    }
                    throw new RpcException(Integer.valueOf(i3), qVar.b);
                }
                throw new RpcException(9, "", e4);
            }
        } catch (Exception e5) {
            throw new RpcException(9, a.a("request  =").append(j0Var.b).append(":").append(e5).toString() != null ? e5.getMessage() : "", e5);
        }
    }
}