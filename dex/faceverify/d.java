package faceverify;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.dtf.face.network.model.FaceInfo;
import com.dtf.face.network.model.OCRInfo;
import com.dtf.toyger.base.algorithm.TGFaceAttr;
import com.dtf.toyger.base.algorithm.TGFaceState;
import com.dtf.toyger.base.face.ToygerFaceAttr;
import com.dtf.toyger.base.face.ToygerFaceState;
import java.util.List;
import java.util.Map;

public class d {
    public Bundle a;
    public Bitmap b;
    public byte[] c;

    /* renamed from: d  reason: collision with root package name */
    public String f1934d;

    /* renamed from: e  reason: collision with root package name */
    public ToygerFaceAttr f1935e;

    /* renamed from: f  reason: collision with root package name */
    public FaceInfo f1936f;

    /* renamed from: g  reason: collision with root package name */
    public List<byte[]> f1937g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f1938h;

    /* renamed from: i  reason: collision with root package name */
    public String f1939i;
    public byte[] j;
    public byte[] k;
    public String l;
    public String m;
    public String n;
    public byte[] o;
    public byte[] p;
    public OCRInfo q = null;
    public Map<String, List<byte[]>> r;

    public void a(ToygerFaceState toygerFaceState, ToygerFaceAttr toygerFaceAttr) {
        if (toygerFaceAttr == null || toygerFaceState == null) {
            return;
        }
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putBoolean("lipMovement", ((TGFaceAttr) toygerFaceAttr).lipMovement);
        this.a.putBoolean("hasFace", ((TGFaceAttr) toygerFaceAttr).hasFace);
        this.a.putInt("faceID", ((TGFaceAttr) toygerFaceAttr).faceId);
        this.a.putInt("actionCode", ((TGFaceState) toygerFaceState).staticMessage);
        this.a.putInt("messageCode", ((TGFaceState) toygerFaceState).messageCode);
        this.a.putFloat("targetFaceRatio", ((TGFaceState) toygerFaceState).targetFaceRegion);
    }

    public void a() {
        this.b = null;
        this.f1939i = "";
        this.m = null;
        this.n = null;
    }
}