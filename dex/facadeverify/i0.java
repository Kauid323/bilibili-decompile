package facadeverify;

import com.dtf.face.network.mpass.biz.rpc.exception.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class i0 extends g0 {
    public i0(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // facadeverify.g0
    public Object a() {
        try {
            JSONObject jSONObject = new JSONObject(new String(this.b));
            int i2 = jSONObject.getInt("resultStatus");
            if (i2 == 1000) {
                if (this.a == String.class) {
                    return jSONObject.optString("result");
                }
                return s0.a(jSONObject.optString("result"), this.a);
            }
            throw new RpcException(Integer.valueOf(i2), jSONObject.optString("tips"));
        } catch (Exception e2) {
            throw new RpcException(10, a.a("response  =").append(new String(this.b)).append(":").append(e2).toString() == null ? "" : e2.getMessage(), e2);
        }
    }
}