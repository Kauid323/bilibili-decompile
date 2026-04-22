package faceverify;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.dtf.face.network.APICallback;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.face.ToygerFaceInfo;
import faceverify.s;
import java.util.List;
import java.util.Map;

public interface r<State extends s, Attr extends ToygerAttr> {
    PointF a(PointF pointF);

    void a();

    void a(List<ToygerFaceInfo> list, APICallback<String> aPICallback);

    void a(Map<String, Object> map);

    boolean a(int i2, Map<String, Object> map);

    boolean a(int i2, byte[] bArr, byte[] bArr2, boolean z);

    boolean a(Bitmap bitmap, Attr attr);

    boolean a(State state, Attr attr, Map<String, Object> map);
}