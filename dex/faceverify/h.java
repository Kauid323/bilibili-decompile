package faceverify;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.dtf.face.ToygerConfig;
import com.dtf.face.ToygerPresenter;
import com.dtf.face.camera.CameraData;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.utils.MiscUtil;
import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.face.ToygerFaceInfo;
import com.dtf.toyger.base.face.ToygerPairFaceInfo;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.AuthActivity;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class h {
    public ToygerFaceInfo a;
    public i k;
    public int b = 0;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1945d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f1946e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f1947f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f1948g = -1;

    /* renamed from: h  reason: collision with root package name */
    public List<g> f1949h = null;

    /* renamed from: i  reason: collision with root package name */
    public List<g> f1950i = null;
    public boolean j = false;
    public boolean l = false;
    public int m = 0;

    public final void a() {
        g next;
        List list;
        RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{"status", "buildVideoInner"});
        if (this.l) {
            return;
        }
        ToygerFaceInfo toygerFaceInfo = this.a;
        if (toygerFaceInfo != null && (list = toygerFaceInfo.videoFrames) != null && this.m < list.size()) {
            ToygerPairFaceInfo toygerPairFaceInfo = (ToygerPairFaceInfo) this.a.videoFrames.get(this.m);
            String valueOf = (toygerPairFaceInfo == null || TextUtils.isEmpty(toygerPairFaceInfo.key)) ? String.valueOf(System.currentTimeMillis()) : toygerPairFaceInfo.key;
            RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{"status", "make", AuthActivity.ACTION_KEY, valueOf});
            String str = "multipic_" + valueOf + "_video";
            try {
                if (this.f1949h == null) {
                    synchronized (this) {
                        if (this.f1949h == null) {
                            this.f1949h = new CopyOnWriteArrayList();
                        }
                    }
                }
                boolean z = false;
                if (!this.j) {
                    try {
                        z = ToygerConfig.getInstance().getAndroidClientConfig().getCaptureConfig(this.b).getJSONObject(toygerPairFaceInfo.key).getBooleanValue("videoEvidence");
                        this.j = z;
                    } catch (Throwable th) {
                    }
                }
                String str2 = z ? "toyger_verify_video" : str;
                new k(a(toygerPairFaceInfo.faceInfos), str2, new a(str2, z, str)).b();
                return;
            } catch (Throwable th2) {
                RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{"errType", "buildVideoInner", "errMsg", RecordService.getStackTraceString(th2), "fileName", str});
                this.m++;
                a();
                return;
            }
        }
        this.f1948g = System.currentTimeMillis();
        RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{"status", "end", "cost", String.valueOf(this.f1948g - this.f1947f)});
        ToygerPresenter.c cVar = this.k;
        if (cVar != null) {
            ToygerPresenter.c cVar2 = cVar;
            ToygerPresenter toygerPresenter = cVar2.b;
            toygerPresenter.e.f1937g = toygerPresenter.c.d();
            ToygerPresenter toygerPresenter2 = cVar2.b;
            toygerPresenter2.e.r = toygerPresenter2.c.c();
            List<g> list2 = cVar2.b.c.f1949h;
            String str3 = null;
            if (list2 != null) {
                try {
                    Iterator<g> it = list2.iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (next.f1944h) {
                            break;
                        }
                    }
                } catch (Throwable th3) {
                    RecordService.getInstance().recordException(th3);
                }
            }
            next = null;
            if (next != null) {
                cVar2.b.e.f1939i = next.f1940d;
            }
            APICallback aPICallback = cVar2.a;
            h hVar = cVar2.b.c;
            if (hVar.f1949h != null) {
                JSONObject jSONObject = new JSONObject();
                for (g gVar : hVar.f1949h) {
                    try {
                        jSONObject.put(gVar.b, gVar.a);
                        if (!TextUtils.isEmpty(gVar.c)) {
                            jSONObject.put(gVar.c, gVar.a);
                        }
                    } catch (Throwable th4) {
                        RecordService.getInstance().recordException(th4);
                    }
                }
                str3 = jSONObject.toString();
            }
            aPICallback.onSuccess(str3);
        }
    }

    public List<g> b() {
        ToygerFaceInfo toygerFaceInfo;
        List list;
        if (this.f1950i == null && (toygerFaceInfo = this.a) != null && (list = toygerFaceInfo.pictures) != null && list.size() > 0) {
            if (this.f1950i == null) {
                synchronized (this) {
                    if (this.f1950i == null) {
                        this.f1950i = new CopyOnWriteArrayList();
                    }
                }
            }
            AndroidClientConfig androidClientConfig = ToygerConfig.getInstance().getAndroidClientConfig();
            JSONObject captureConfig = androidClientConfig != null ? androidClientConfig.getCaptureConfig(this.b) : null;
            RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{SocialConstants.PARAM_SEND_MSG, faceverify.a.a("GetAllFaceInfo-").append(this.a.pictures.size()).toString()});
            for (ToygerPairFaceInfo toygerPairFaceInfo : this.a.pictures) {
                if (toygerPairFaceInfo.faceInfos != null) {
                    JSONObject jSONObject = captureConfig != null ? captureConfig.getJSONObject(toygerPairFaceInfo.key) : null;
                    List arrayList = jSONObject != null ? (List) MiscUtil.json2Object(jSONObject.getString("pictureToApp"), List.class) : new ArrayList();
                    for (int i2 = 0; i2 < toygerPairFaceInfo.faceInfos.size(); i2++) {
                        g gVar = new g();
                        String str = toygerPairFaceInfo.key;
                        gVar.f1942f = ((ToygerBiometricInfo) ((ToygerFaceInfo) toygerPairFaceInfo.faceInfos.get(i2))).encryptFrame.data;
                        if (!"equipmentLiveness_pic".equals(toygerPairFaceInfo.key) && !"nearfar_far_pic".equals(toygerPairFaceInfo.key) && !"nearfar_near_pic".equals(toygerPairFaceInfo.key)) {
                            gVar.b = faceverify.a.a("multipic_").append(toygerPairFaceInfo.key).append("_pic_").append(i2).toString();
                            if (i2 < arrayList.size() && ((Boolean) arrayList.get(i2)).booleanValue()) {
                                gVar.f1944h = true;
                                gVar.f1943g = ((ToygerBiometricInfo) ((ToygerFaceInfo) toygerPairFaceInfo.faceInfos.get(i2))).jpegFrame.data;
                            }
                        } else {
                            gVar.b = toygerPairFaceInfo.key;
                            gVar.f1943g = ((ToygerBiometricInfo) ((ToygerFaceInfo) toygerPairFaceInfo.faceInfos.get(i2))).jpegFrame.data;
                        }
                        this.f1950i.add(gVar);
                    }
                }
            }
        }
        return this.f1950i;
    }

    public Map<String, List<byte[]>> c() {
        HashMap hashMap = new HashMap();
        try {
            this.f1950i = b();
            if (this.f1950i != null) {
                for (g gVar : this.f1950i) {
                    if ("equipmentLiveness_pic".equals(gVar.b)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(gVar.f1943g);
                        hashMap.put("equipmentLiveness", arrayList);
                    }
                }
            }
        } catch (Throwable th) {
            RecordService.getInstance().recordException(th);
            hashMap.clear();
        }
        return hashMap;
    }

    public List<byte[]> d() {
        ArrayList arrayList = new ArrayList();
        try {
            this.f1950i = b();
            if (this.f1950i != null) {
                for (g gVar : this.f1950i) {
                    if (gVar.f1944h) {
                        arrayList.add(gVar.f1943g);
                    }
                }
            }
        } catch (Throwable th) {
            RecordService.getInstance().recordException(th);
            arrayList.clear();
        }
        RecordService.getInstance().recordEvent(4, "CaptureMaker", new String[]{SocialConstants.PARAM_SEND_MSG, faceverify.a.a("getOptionalFaceInfo-").append(arrayList.size()).toString()});
        return arrayList;
    }

    public void e() {
        synchronized (this) {
            if (this.f1947f > 0) {
                return;
            }
            this.f1947f = System.currentTimeMillis();
            this.l = false;
            a();
        }
    }

    public void f() {
        if (this.l) {
            return;
        }
        synchronized (this) {
            this.l = true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public a(String str, boolean z, String str2) {
            this.a = str;
            this.b = z;
            this.c = str2;
        }

        @Override // faceverify.j
        public void a(String str, String str2) {
            g gVar = new g();
            gVar.f1941e = true;
            h hVar = h.this;
            String str3 = ((ToygerPairFaceInfo) hVar.a.videoFrames.get(hVar.m)).key;
            gVar.b = this.a;
            gVar.f1940d = str;
            boolean z = this.b;
            gVar.f1944h = z;
            gVar.a = str2;
            if (z) {
                gVar.c = this.c;
            }
            h.this.f1949h.add(gVar);
            h hVar2 = h.this;
            hVar2.m++;
            hVar2.a();
        }

        @Override // faceverify.j
        public void a() {
            g gVar = new g();
            gVar.f1941e = false;
            h hVar = h.this;
            String str = ((ToygerPairFaceInfo) hVar.a.videoFrames.get(hVar.m)).key;
            gVar.b = this.a;
            String str2 = this.c;
            gVar.c = str2;
            boolean z = this.b;
            gVar.f1944h = z;
            gVar.f1940d = "";
            gVar.a = "";
            if (z) {
                gVar.c = str2;
            }
            h.this.f1949h.add(gVar);
            h hVar2 = h.this;
            hVar2.m++;
            hVar2.a();
        }
    }

    public final CopyOnWriteArrayList<CameraData> a(List<ToygerFaceInfo> list) {
        CopyOnWriteArrayList<CameraData> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (ToygerFaceInfo toygerFaceInfo : list) {
            CameraData cameraData = new CameraData();
            cameraData.setColorData(ByteBuffer.wrap(((ToygerBiometricInfo) toygerFaceInfo).frame.data));
            cameraData.setPreviewWidth(((ToygerBiometricInfo) toygerFaceInfo).frame.width);
            cameraData.setPreviewHeight(((ToygerBiometricInfo) toygerFaceInfo).frame.height);
            cameraData.setRotateAngle(((ToygerBiometricInfo) toygerFaceInfo).frame.rotation);
            copyOnWriteArrayList.add(cameraData);
        }
        return copyOnWriteArrayList;
    }
}