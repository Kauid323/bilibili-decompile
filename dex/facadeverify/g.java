package facadeverify;

import com.dtf.face.network.mpass.biz.rpc.exception.RpcException;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.face.utils.StringUtil;
import facadeverify.h;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class g extends y {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class a extends z {
        public a(n nVar, Class cls, a0 a0Var) {
            super(nVar, cls, a0Var);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        @Override // java.lang.reflect.InvocationHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object invoke(Object obj, Method method, Object[] objArr) {
            n nVar;
            String str;
            try {
                return this.c.a(obj, this.b, method, objArr);
            } catch (RpcException e2) {
                if (ClientConfigUtil.getNeedBackupUrl() && !g.this.a(e2) && (nVar = this.a) != null) {
                    h.a aVar = (h.a) nVar;
                    List<String> list = h.this.c;
                    if (list != null && list.size() != 0) {
                        h hVar = h.this;
                        int indexOf = hVar.c.indexOf(hVar.b);
                        if (indexOf < h.this.c.size() - 1) {
                            str = h.this.c.get(indexOf + 1);
                            h.this.b = str;
                            if (!StringUtil.isNullorEmpty(str)) {
                                return invoke(obj, method, objArr);
                            }
                        }
                    }
                    str = "";
                    if (!StringUtil.isNullorEmpty(str)) {
                    }
                }
                throw new j(e2);
            }
        }
    }

    public g(n nVar) {
        super(nVar);
    }

    @Override // facadeverify.y
    public <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this.a, cls, this.b));
    }

    public boolean a(RpcException rpcException) {
        return rpcException.getCode() == 5 || rpcException.getCode() == 4;
    }
}