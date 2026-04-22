package faceverify;

import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtf.face.ToygerConfig;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.Chameleon;
import com.dtf.face.config.Coll;
import com.dtf.face.config.Upload;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.request.ValidateParams;
import com.dtf.face.utils.StringUtil;
import com.vivo.identifier.IdentifierConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class l {
    public Camera a;
    public Handler b;
    public List<String> c;

    /* renamed from: g  reason: collision with root package name */
    public long f1961g;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1963i;
    public float j;
    public JSONObject s;

    /* renamed from: d  reason: collision with root package name */
    public String f1958d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f1959e = -1;

    /* renamed from: f  reason: collision with root package name */
    public String f1960f = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f1962h = false;
    public Runnable k = new a();
    public String l = "";
    public String m = "";
    public String n = "";
    public int o = -1;
    public List<byte[]> p = new ArrayList();
    public List<String> q = new ArrayList();
    public List<String> r = new ArrayList();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f1962h = true;
        }
    }

    public l() {
        Chameleon chameleon;
        this.f1961g = 600L;
        this.j = 0.6f;
        AndroidClientConfig androidClientConfig = ToygerConfig.getInstance().getAndroidClientConfig();
        if (androidClientConfig != null) {
            Upload upload = androidClientConfig.getUpload();
            if (upload != null) {
                float f2 = upload.chameleonUploadCompressRate;
                if (f2 > CropImageView.DEFAULT_ASPECT_RATIO && f2 <= 1.0f) {
                    this.j = f2;
                } else {
                    this.j = 1.0f;
                    RecordService.getInstance().recordEvent(4, "Chameleon", new String[]{"errMsg", faceverify.a.a("chameleonUploadCompressRate=").append(upload.chameleonUploadCompressRate).toString()});
                }
            }
            Coll coll = androidClientConfig.getColl();
            if (coll != null && (chameleon = coll.chameleon) != null) {
                Long l = chameleon.maxWaitTime;
                if (l != null && l.longValue() > 0 && chameleon.maxWaitTime.longValue() <= 2000) {
                    this.f1961g = chameleon.maxWaitTime.longValue();
                } else {
                    this.f1961g *= 2;
                    RecordService.getInstance().recordEvent(4, "Chameleon", new String[]{"errMsg", faceverify.a.a("maxWaitTime=").append(chameleon.maxWaitTime).toString()});
                }
                this.f1963i = chameleon.triggering;
            }
        }
        d();
        this.b = new Handler();
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f1958d) && this.a != null) {
            JSONObject jSONObject = new JSONObject();
            Camera.Parameters a2 = a(this.a);
            if (a2 != null) {
                jSONObject.put("supportWhiteBalance", StringUtil.join(c(), Constants.ACCEPT_TIME_SEPARATOR_SP));
                jSONObject.put("horizontalViewAngle", Float.valueOf(a2.getHorizontalViewAngle()));
                jSONObject.put("verticalViewAngle", Float.valueOf(a2.getVerticalViewAngle()));
                jSONObject.put("supportedfocusModes", StringUtil.join(a2.getSupportedFocusModes(), Constants.ACCEPT_TIME_SEPARATOR_SP));
                jSONObject.put("focusMode", a2.getFocusMode());
                Camera.Size previewSize = a2.getPreviewSize();
                if (previewSize != null) {
                    jSONObject.put("previewWidth", Integer.valueOf(previewSize.width));
                    jSONObject.put("previewHeight", Integer.valueOf(previewSize.height));
                }
                jSONObject.put("jpegQuality", Integer.valueOf(a2.getJpegQuality()));
                jSONObject.put("maxZoom", Integer.valueOf(a2.getMaxZoom()));
            }
            this.f1958d = jSONObject.toJSONString();
        }
        return this.f1958d;
    }

    public final List<String> c() {
        List<String> list = this.c;
        if (list != null) {
            return list;
        }
        Camera.Parameters a2 = a(this.a);
        if (a2 != null) {
            this.c = a2.getSupportedWhiteBalance();
            return this.c;
        }
        return new ArrayList();
    }

    public void d() {
        this.s = null;
        this.f1962h = false;
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacks(this.k);
        }
        this.p.clear();
        this.q.clear();
        this.r.clear();
        this.b = null;
    }

    public final String a(Map<String, String> map) {
        Random random = new Random();
        if (map.size() <= 0) {
            return null;
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        return strArr[strArr.length > 1 ? random.nextInt(strArr.length) : 0];
    }

    public boolean a(int i2) {
        boolean z;
        String str;
        Camera.Parameters parameters;
        String str2;
        int[] iArr = this.f1963i;
        boolean z2 = true;
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            String str3 = "";
            this.l = "";
            this.m = "";
            this.n = "";
            this.o = -1;
            Camera camera = this.a;
            if (camera == null) {
                str = "";
                parameters = null;
            } else {
                parameters = a(camera);
                if (parameters == null) {
                    return false;
                }
                this.c = c();
                Chameleon chameleon = ToygerConfig.getInstance().getAndroidClientConfig().getColl().chameleon;
                if (chameleon == null) {
                    str = "";
                } else {
                    HashMap hashMap = new HashMap();
                    Map map = chameleon.whiteBalanceAndroid;
                    if (map != null && map.size() > 0) {
                        Set<String> keySet = map.keySet();
                        List<String> c = c();
                        for (String str4 : keySet) {
                            String str5 = (String) map.get(str4);
                            if (c.contains(str5)) {
                                hashMap.put(str4, str5);
                            }
                        }
                        if (hashMap.size() == 0) {
                            str = "no valid whiteBalance";
                        } else {
                            this.l = a(hashMap);
                            this.m = hashMap.get(this.l);
                            Map<String, String> map2 = chameleon.videoZoom;
                            Camera.Parameters a2 = a(this.a);
                            if (map2 == null || map2.size() <= 0 || a2 == null || !a2.isZoomSupported()) {
                                str = "camera is null";
                            } else {
                                this.n = a(map2);
                                try {
                                    this.o = (int) (Float.parseFloat(map2.get(this.n)) * a2.getMaxZoom());
                                } catch (Throwable th) {
                                    str = RecordService.getStackTraceString(th);
                                }
                            }
                        }
                    }
                    str = "";
                }
            }
            if (!TextUtils.isEmpty(this.m) && this.o > -1) {
                try {
                    this.f1959e = parameters.getZoom();
                    this.f1960f = parameters.getWhiteBalance();
                    parameters.setWhiteBalance(this.m);
                    parameters.setZoom(this.o);
                    if (this.a == null) {
                        z2 = false;
                        str2 = str;
                    } else {
                        this.a.setParameters(parameters);
                        Handler handler = this.b;
                        if (handler != null) {
                            handler.postDelayed(this.k, this.f1961g);
                        }
                        str2 = str;
                    }
                } catch (Throwable th2) {
                    String sb = faceverify.a.a(str).append(RecordService.getStackTraceString(th2)).toString();
                    a((HashMap<String, String>) null, "1");
                    z2 = false;
                    str2 = sb;
                }
            } else {
                String str6 = str + "whiteBalanceModeSelected=" + this.m + " zoomSelected=" + this.o;
                if (TextUtils.isEmpty(this.m)) {
                    str3 = "2";
                } else if (this.o < 0) {
                    str3 = IdentifierConstant.OAID_STATE_PERMISSION_SHOW;
                }
                if (this.s == null) {
                    a((HashMap<String, String>) null, str3);
                }
                z2 = false;
                str2 = str6 + "whiteBalanceModeSelected=" + this.m + " zoomSelected=" + this.o;
            }
            RecordService.getInstance().recordEvent(2, "Chameleon", new String[]{"status", z2 ? "success" : "fail", "whiteBalance", this.l, "zoom", this.n, "deviceInfo", b(), "errMsg", str2, "maxWaitTime", String.valueOf(this.f1961g)});
            return z2;
        }
        return false;
    }

    public final void a(HashMap<String, String> hashMap, String str) {
        JSONObject jSONObject = this.s;
        if (jSONObject == null) {
            this.s = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            a(jSONArray, hashMap, str);
            this.s.put("chameleon", jSONArray);
            this.s.put("deviceInfo", b());
            return;
        }
        a(jSONObject.getJSONArray("chameleon"), hashMap, str);
    }

    public void a(JSONArray jSONArray, HashMap<String, String> hashMap, String str) {
        JSONObject jSONObject;
        if (hashMap != null) {
            jSONObject = (JSONObject) JSON.toJSON(hashMap);
        } else {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("errCode", str);
        }
        jSONArray.add(jSONObject);
        if (this.s == null) {
            this.s = new JSONObject();
        }
        this.s.put("chameleon", jSONArray);
    }

    public String a() {
        if (this.s == null) {
            this.s = new JSONObject();
        }
        return this.s.toJSONString();
    }

    public void a(Map<String, Object> map, List<Pair<Integer, String>> list) {
        Object obj;
        ValidateParams validateParams = (ValidateParams) map.get("validateParams");
        if (validateParams == null || list == null) {
            return;
        }
        for (Pair<Integer, String> pair : list) {
            if (pair != null && (obj = pair.second) != null && ((String) obj).contains("chameleon")) {
                validateParams.setChameleonFileName((List) null);
                JSONObject jSONObject = this.s;
                if (jSONObject != null) {
                    jSONObject.put("chameleon", "");
                }
                validateParams.setChameleonMetaInfo(a());
                return;
            }
        }
    }

    public Camera.Parameters a(Camera camera) {
        try {
        } catch (Throwable th) {
            RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        }
        if (camera == null) {
            RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", "camera is null"});
            return null;
        }
        return camera.getParameters();
    }
}