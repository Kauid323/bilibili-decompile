package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import c.t.m.g.m5;
import c.t.m.g.n5;
import c.t.m.g.p6;
import c.t.m.g.u2;
import com.alipay.alipaysecuritysdk.common.exception.ErrorCode;
import com.antlr4.runtime.TokenStreamRewriter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class i5 {
    public static SparseArray<String> h0;
    public static final TencentLocationListener i0;
    public n4 A;
    public List<TencentLocationListener> B;
    public List<TencentLocationListener> C;
    public List<e> D;
    public long J;
    public p6 O;
    public double P;
    public double Q;
    public p6 R;
    public long T;
    public String V;

    /* renamed from: c  reason: collision with root package name */
    public c f42c;
    public f d;
    public Handler e;
    public boolean g;
    public volatile CopyOnWriteArrayList<w5> g0;
    public d5 h;
    public k5 i;
    public boolean j;
    public h5 k;
    public m5 l;
    public s5 m;
    public f5 n;
    public b5 o;
    public j5 p;
    public o5 q;
    public n5 r;
    public volatile int s;
    public boolean t;
    public q5 u;
    public w5 v;
    public e6 w;
    public e6 x;
    public x5 y;
    public final m4 z;
    public int a = -1;
    public int b = 1;
    public long f = 0;
    public long E = 0;
    public volatile long F = 0;
    public int G = 0;
    public final String[] H = {"guilinbank", "JDTest", "QuanChengTao", "bankofbbg"};
    public volatile int I = 0;
    public final Object K = new Object();
    public final TencentLocationRequest L = TencentLocationRequest.create();
    public final TencentLocationRequest M = TencentLocationRequest.create();
    public long N = 0;
    public int S = ErrorCode.E_INVALID_ARGUMENT;
    public volatile d U = d.Stop;
    public c.t.m.g.b W = null;
    public int X = 0;
    public long Y = 0;
    public x3 Z = null;
    public boolean a0 = false;
    public boolean b0 = false;
    public int c0 = 0;
    public final byte[] d0 = new byte[0];
    public final q1 e0 = new b();
    public String f0 = "";

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements TencentLocationListener {
        public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends q1 {
        public b() {
        }

        @Override // c.t.m.g.q1
        public void a(p1 p1Var) {
            a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: " + p1Var.a());
            switch (p1Var.a()) {
                case 10002:
                    a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: 10002");
                    i5.this.b((x5) p1Var);
                    return;
                case 10003:
                    a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: 10003");
                    i5.this.b((w5) p1Var);
                    return;
                case 10004:
                    a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: 10004");
                    i5.this.b((e6) p1Var);
                    return;
                case 10005:
                    a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: 10005");
                    r1 r1Var = (r1) p1Var;
                    i5.this.b(r1Var.b(), r1Var.c());
                    return;
                case 10006:
                    a7.c("TxLocManagerImpl#updateInner", "databus,BaseBusData type: 10006");
                    i5.this.a(((t1) p1Var).b());
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class c extends Handler {
        public String a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43c;
        public boolean d;
        public int e;
        public m5.c f;

        /* compiled from: TML */
        /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
        public class a implements m5.c {
            public a() {
            }

            @Override // c.t.m.g.m5.c
            public void a(p6 p6Var, int i) {
                if (c7.b(i5.this.l)) {
                    i5.this.l.a();
                }
                a7.c("TxLocationManagerImpl", "onTxNlpLocationChanged: error= " + i + "," + p6Var);
                if (p6Var != null && p6Var != p6.q) {
                    a7.c("TxLocationManagerImpl", "nlp location is ok, start to update lastlocation");
                    i5.this.a(0, p6Var);
                    c.this.b(0);
                    return;
                }
                a7.c("TxLocationManagerImpl", "nlp location is failed");
                i5.this.a(i, p6.q);
                c.this.b(i);
            }
        }

        public c(Looper looper) {
            super(looper);
            this.a = "TxLocManagerImpl#MyHandler";
            this.e = 0;
            this.f = new a();
            this.b = 0L;
            this.f43c = false;
            this.d = false;
        }

        public void b() {
            this.e = 0;
            removeCallbacksAndMessages(null);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x06c4, code lost:
            r2 = "info3 is null";
         */
        /* JADX WARN: Removed duplicated region for block: B:137:0x05d2 A[Catch: all -> 0x072a, TRY_LEAVE, TryCatch #1 {all -> 0x072a, blocks: (B:14:0x0055, B:15:0x005f, B:17:0x0064, B:19:0x0071, B:21:0x0079, B:24:0x00be, B:25:0x00ca, B:27:0x00ea, B:28:0x010d, B:30:0x011a, B:32:0x0120, B:34:0x013c, B:37:0x014c, B:52:0x0278, B:53:0x0284, B:54:0x02c6, B:56:0x02e5, B:57:0x02e7, B:59:0x02f2, B:60:0x030e, B:62:0x0323, B:64:0x032b, B:65:0x0333, B:68:0x033d, B:70:0x0347, B:72:0x034c, B:69:0x0343, B:73:0x0374, B:75:0x037a, B:77:0x0380, B:79:0x039b, B:82:0x03db, B:87:0x0408, B:89:0x0410, B:90:0x0419, B:84:0x03e3, B:86:0x03ee, B:92:0x0431, B:94:0x043f, B:96:0x0457, B:98:0x0473, B:100:0x0488, B:101:0x0491, B:103:0x04a1, B:104:0x04a9, B:105:0x04b0, B:107:0x04c7, B:115:0x0533, B:117:0x0546, B:119:0x0556, B:121:0x055c, B:123:0x056a, B:125:0x057b, B:129:0x059f, B:131:0x05c6, B:137:0x05d2, B:139:0x05d9, B:141:0x05f3, B:143:0x0602, B:145:0x0608, B:147:0x0633, B:149:0x0639, B:151:0x063f, B:124:0x0577, B:109:0x04cf, B:112:0x04e7, B:114:0x052a, B:152:0x0662, B:154:0x0668, B:156:0x0676, B:158:0x068d, B:163:0x06b2, B:168:0x06da, B:167:0x06c7, B:170:0x06e6, B:172:0x06f3, B:173:0x0708, B:174:0x070e, B:40:0x0156, B:42:0x01b8, B:44:0x01be, B:46:0x0211, B:47:0x0261), top: B:183:0x0055, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:141:0x05f3 A[Catch: all -> 0x072a, TryCatch #1 {all -> 0x072a, blocks: (B:14:0x0055, B:15:0x005f, B:17:0x0064, B:19:0x0071, B:21:0x0079, B:24:0x00be, B:25:0x00ca, B:27:0x00ea, B:28:0x010d, B:30:0x011a, B:32:0x0120, B:34:0x013c, B:37:0x014c, B:52:0x0278, B:53:0x0284, B:54:0x02c6, B:56:0x02e5, B:57:0x02e7, B:59:0x02f2, B:60:0x030e, B:62:0x0323, B:64:0x032b, B:65:0x0333, B:68:0x033d, B:70:0x0347, B:72:0x034c, B:69:0x0343, B:73:0x0374, B:75:0x037a, B:77:0x0380, B:79:0x039b, B:82:0x03db, B:87:0x0408, B:89:0x0410, B:90:0x0419, B:84:0x03e3, B:86:0x03ee, B:92:0x0431, B:94:0x043f, B:96:0x0457, B:98:0x0473, B:100:0x0488, B:101:0x0491, B:103:0x04a1, B:104:0x04a9, B:105:0x04b0, B:107:0x04c7, B:115:0x0533, B:117:0x0546, B:119:0x0556, B:121:0x055c, B:123:0x056a, B:125:0x057b, B:129:0x059f, B:131:0x05c6, B:137:0x05d2, B:139:0x05d9, B:141:0x05f3, B:143:0x0602, B:145:0x0608, B:147:0x0633, B:149:0x0639, B:151:0x063f, B:124:0x0577, B:109:0x04cf, B:112:0x04e7, B:114:0x052a, B:152:0x0662, B:154:0x0668, B:156:0x0676, B:158:0x068d, B:163:0x06b2, B:168:0x06da, B:167:0x06c7, B:170:0x06e6, B:172:0x06f3, B:173:0x0708, B:174:0x070e, B:40:0x0156, B:42:0x01b8, B:44:0x01be, B:46:0x0211, B:47:0x0261), top: B:183:0x0055, inners: #2 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            String str;
            boolean z2;
            String str2 = this.a + "#handleMessage";
            synchronized (i5.this.K) {
                if (!c7.b(i5.this.B) && !i5.this.B.isEmpty() && i5.this.U == d.Normal) {
                    return;
                }
                TencentLocationRequest tencentLocationRequest = i5.this.L;
                int requestLevel = tencentLocationRequest.getRequestLevel();
                long j = i5.this.F;
                try {
                    switch (message.what) {
                        case 555:
                            a7.c(str2, "MSG_ID_CLEAR_WIFI(555)");
                            i5.this.w = null;
                            x3.a("WIFI", "rany- wifi clear req");
                            w6.a("wifi disenable,prepare");
                            sendEmptyMessage(3999);
                            return;
                        case 3991:
                            a7.c(str2, "MSG_ID_CHECK_PREPARE_JSON(3991)");
                            if (!i5.this.b0) {
                                a7.c(str2, "rany- send prepare json beacase no cell wifi gps");
                                w6.a("check,prepare");
                                sendEmptyMessage(3999);
                                x3.a("P", "time out");
                                return;
                            }
                            a7.c(str2, "donot send prepare json beacase already send");
                            return;
                        case 3997:
                            a7.c(str2, "MSG_ID_SINGLE_PREPARE_JSON(3997)");
                            y5 j2 = i5.this.j();
                            if (j2 != null) {
                                str = j2.a(requestLevel, i5.this.V, i5.this.z, false, false, false);
                                a7.c("TxLocationManagerImpl", "json3 = " + str);
                                z = !g7.a(str);
                            } else {
                                z = false;
                                str = null;
                            }
                            if (j2 != null && !z) {
                                i5.this.r.a(str, j2, i5.this.b);
                                return;
                            }
                            String str3 = "handleMessage: bad json " + str;
                            a7.b(str2, str3);
                            a7.b(str2, "handleLocationfailed due to MSG_ID_SINGLE_PREPARE_JSON bad json");
                            a(2);
                            return;
                        case 3999:
                            break;
                        case 4998:
                            a7.c(str2, "MSG_ID_HTTP_LOCATION_TIMEOUT(4998)");
                            if (i5.this.A.h() == 0) {
                                i5.this.A.b(-1L);
                            }
                            w6.a("location timeout");
                            if (!i5.this.a(30000, 0)) {
                                a7.b(str2, "handleLocationfailed due to http location timeout ");
                                a(1);
                            }
                            i5.this.J = -1L;
                            return;
                        case 4999:
                            a7.c(str2, "MSG_ID_HTTP_LOCATION_RESPONSE(4999)");
                            a();
                            removeMessages(4998);
                            Pair pair = (Pair) message.obj;
                            String obj = pair.first.toString();
                            n5.b bVar = (n5.b) pair.second;
                            i5.this.x = ((y5) bVar.e).a();
                            String str4 = bVar.g;
                            a7.c(str2, "MSG_ID_HTTP_LOCATION_RESPONSE -> response: " + obj);
                            try {
                                p6 a2 = new p6.b().a(obj).a(requestLevel).b("network").a();
                                if (a2.isMockGps() == 1) {
                                    this.d = true;
                                }
                                p6.d(a2);
                                c.t.m.g.b bVar2 = i5.this.W;
                                if (bVar2 != null) {
                                    bVar2.a(a2.b(), i5.this.b, a2.getLatitude(), a2.getLongitude(), a2.getAccuracy());
                                }
                                i5.this.J = System.currentTimeMillis();
                                boolean isEmpty = TextUtils.isEmpty(a2.getIndoorBuildingId());
                                boolean z3 = !isEmpty;
                                if (!isEmpty && i5.this.I == 1) {
                                    i5.this.I = 2;
                                    this.e = 0;
                                }
                                if (i5.this.I == 2) {
                                    if (isEmpty) {
                                        this.e++;
                                    } else {
                                        this.e = 0;
                                    }
                                    if (this.e >= 5) {
                                        a7.b(str2, "indoor stop," + i5.this.L.getInterval());
                                        i5.this.I = 1;
                                        this.e = 0;
                                    }
                                }
                                int b = v4.a(a2) ? v4.b() : 0;
                                a7.c(str2, "HTTP_LOCATION_RESPONSE, fakeReason is " + b);
                                a2.c(b);
                                a7.c("UPDATE_LOCATION", "isGpsValid(): " + i5.this.l() + ", isIndoorLocation: " + z3 + ", mIndoorLocationStatus: " + i5.this.I);
                                if (!i5.this.l() || (!isEmpty && i5.this.I > 0)) {
                                    p6.a(a2, z3);
                                    i5.this.a(0, a2);
                                    a7.c("UPDATE_LOCATION", "MSG_ID_HTTP_LOCATION_RESPONSE updateLastLocation: " + a2.toString());
                                }
                                if (i5.this.O != null) {
                                    p6.a(i5.this.O, a2);
                                }
                                b(0);
                                i5.this.R = a2;
                                q6.a(i5.this.z.a);
                                return;
                            } catch (JSONException e) {
                                a7.b(str2, "handleLocationfailed due to use json to build txlocation with exception");
                                x3.a("LOC", "server location error.");
                                x3.a("LOC", "request:" + str4);
                                x3.a("LOC", "response:" + obj);
                                a(ErrorCode.E_INVALID_ARGUMENT);
                                return;
                            }
                        case 5997:
                            a(message.arg1);
                            a7.c(str2, "MSG_ID_NLP_RETRY");
                            return;
                        case 5999:
                            int i = message.arg1;
                            int i2 = message.arg2;
                            p6 p6Var = (p6) message.obj;
                            a7.c(str2, "nationcode, requestLevel=" + i5.this.L.getRequestLevel() + ", current NationCode: " + p6Var.getNationCode());
                            a7.c(str2, "nationcode, request bundle: " + i5.this.L.getExtras());
                            if (i5.this.L.getRequestLevel() <= 0 || p6Var.getNationCode() != 0) {
                                return;
                            }
                            String b2 = i5.this.z.b("https://apis.map.qq.com/ws/geocoder/v1/?location=" + p6Var.getLatitude() + "," + p6Var.getLongitude() + "&key=" + e5.f27c);
                            a7.c(str2, "nationcode, response: " + b2);
                            if (b2 == null) {
                                i5.this.a(1, p6.q);
                                a7.b(str2, "get nation code failed, ERROR_NETWORK");
                                return;
                            }
                            JSONObject jSONObject = new JSONObject(b2);
                            i5.this.a = jSONObject.optInt(com.alipay.sdk.m.h.c.a);
                            i5.this.c0 = jSONObject.getJSONObject(com.alipay.sdk.m.q.k.f247c).getJSONObject("ad_info").getInt("nation_code");
                            a7.c(str2, "nation code is " + i5.this.c0 + ", processLocationChanged");
                            i5.this.a(p6Var, i, i2);
                            return;
                        case 7999:
                            a7.c(str2, "MSG_ID_NETWORK_CONNECTED(7999)");
                            if (!i5.this.b()) {
                                long max = Math.max(i5.this.L.getInterval(), 4000L);
                                if (i5.this.J != 0 && System.currentTimeMillis() - i5.this.J >= max) {
                                    a7.c(str2, "network connected --> prepare json");
                                    requestLevel = requestLevel;
                                    break;
                                }
                                return;
                            }
                            a7.c(str2, "MSG_ID_NETWORK_CONNECTED(7999), is first loc return");
                            return;
                        case 11997:
                        case 11998:
                            a7.c(str2, "MSG_ID_DIRECT_CALLBACK(11998) or MSG_ID_TIME_OUT_CALLBACK(11997), current msg.what = " + message.what);
                            if (i5.this.O != null) {
                                i5.this.a(i5.this.O);
                                a7.c(str2, "to processLocationChanged, send msg MSG_ID_USER_LOCATION_CHANGED(3101)");
                                i5.this.a(i5.this.O, i5.this.S, 3101);
                                return;
                            }
                            return;
                        case 11999:
                            a7.c(str2, "MSG_ID_TIMED_CALLBACK");
                            if (i5.this.O != null && tencentLocationRequest.getInterval() > 0) {
                                i5.this.a(i5.this.O);
                                a7.c(str2, "send msg MSG_ID_USER_LOCATION_CHANGED(3101)");
                                i5.this.a(i5.this.O, i5.this.S, 3101);
                                a7.c(str2, "MSG_ID_TIMED_CALLBACK mLastLocation: " + i5.this.O.toString());
                            }
                            if (j > 0) {
                                a7.c(str2, "send msg MSG_ID_TIMED_CALLBACK, ");
                                sendEmptyMessageDelayed(11999, j);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    a7.c(str2, "MSG_ID_PREPARE_JSON(3999)");
                    i5.this.b0 = true;
                    removeMessages(3999);
                    if (i5.this.U == d.Daemon || i5.this.a0) {
                        long parseLong = Long.parseLong(f7.a().get("up_daemon_delay"));
                        if (parseLong < 120000) {
                            parseLong = 120000;
                        }
                        a7.b(str2, "the daemonLocation, so we delay long time upload:" + parseLong + "," + System.currentTimeMillis() + "," + i5.this.T);
                        if (System.currentTimeMillis() - i5.this.T >= parseLong) {
                            i5.this.T = System.currentTimeMillis();
                        } else {
                            a7.b(str2, "the daemonLocation, < daeInterval");
                            return;
                        }
                    }
                    int i3 = i5.this.b;
                    a7.b(str2, "getFromLastKnownInfo");
                    y5 j3 = i5.this.j();
                    if (j3 == null) {
                        a7.b(str2, "handleLocationfailed due to getFromLastKnownInfo is null");
                        x3.a("LOC", "info is null.");
                        a(2);
                        return;
                    }
                    if (!j3.b() || System.currentTimeMillis() - this.b <= 60000) {
                        this.f43c = false;
                    } else {
                        this.f43c = true;
                        this.d = false;
                        this.b = System.currentTimeMillis();
                    }
                    a7.b(str2, "toJsonString");
                    String a3 = j3.a(requestLevel, i5.this.V, i5.this.z, this.f43c, this.d, i5.this.U == d.Daemon);
                    a7.c(str2, "json = " + a3);
                    if (a3 != null && g7.a(a3)) {
                        z2 = false;
                        if (!z2) {
                            a7.b(str2, "handleLocationfailed due to bad json");
                            x3.a("LOC", "bad json " + a3);
                            a(2);
                            return;
                        }
                        a7.b(str2, "RUNNING_STATUS");
                        if (i5.this.U == d.Normal && g6.a(tencentLocationRequest)) {
                            p6 a4 = new p6.b().a((p6) null).a(requestLevel).a();
                            g6.a(a4, a3.getBytes(com.alipay.sdk.m.o.a.z));
                            i5.this.a(a4);
                            a7.c(str2, "to processLocationChanged when isRequestRawData, send msg MSG_ID_USER_LOCATION_CHANGED(3101)");
                            i5.this.a(a4, 0, 3101);
                            return;
                        } else if (v4.a()) {
                            a7.b(str2, "!MOCK_LOCATION_FILTER, don't upload");
                            return;
                        } else {
                            a7.b(str2, "rany- postLocationRequest: " + a3);
                            i5.this.r.a(a3, j3, i3);
                            return;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                } catch (Throwable th) {
                    a7.b(str2, th.toString());
                }
            }
        }

        public final void a(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - i5.this.N;
            long time = i5.this.O != null ? currentTimeMillis - i5.this.O.getTime() : 0L;
            a7.c("handleLocFailed", "error:" + i + ", locTimeDiff:" + time);
            if (i5.this.S == 0 && i5.this.O != null && time < 30000) {
                a7.c("handleLocFailed", "use cache location");
                return;
            }
            if (g6.a) {
                a7.c("handleLocFailed", "nlpTimeDiff: " + j);
                if (c7.b(i5.this.l) && j > 30000) {
                    a7.c("handleLocFailed", "mNlpProvider.startup()");
                    i5.this.N = currentTimeMillis;
                    i5.this.l.a(i5.this.b == 1);
                    i5.this.l.a(this.f);
                    i5.this.l.a(i5.this.V);
                    i5.this.l.a(i5.this.b);
                    i5.this.l.b(i);
                    i5.this.l.c(i5.this.L.getRequestLevel());
                    i5.this.l.b();
                    return;
                }
                a7.c("handleLocFailed", "don't start nlp location");
                return;
            }
            a7.c("handleLocFailed", "not allow nlp location");
            if (i5.this.S != 0 || i5.this.O == null || time >= 60000) {
                i5.this.a(i, p6.q);
                b(i);
                a7.c("handleLocFailed", "cache timeout, error location");
                return;
            }
            b(0);
        }

        public final void b(int i) {
            if (i5.this.C == null || i5.this.C.isEmpty()) {
                return;
            }
            if (i5.this.S == 0) {
                a7.b("TxLocManagerImpl#handleSingleLocationUpdate", "single message MSG_ID_USER_SINGLE_LOCATION_CHANGED(3103) 2");
                i5 i5Var = i5.this;
                i5Var.a(i5Var.O, 0, 3103);
                return;
            }
            a7.b("TxLocManagerImpl#handleSingleLocationUpdate", "single message MSG_ID_USER_SINGLE_LOCATION_CHANGED(3103) 3");
            i5.this.a(p6.q, i, 3103);
        }

        public final void a() {
            if (i5.this.A.h() == 0) {
                i5.this.A.b(System.currentTimeMillis() - i5.this.A.q());
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum d {
        Normal,
        Daemon,
        Single,
        Stop
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class e {
        public TencentLocationListener a;
        public long b;

        public e(i5 i5Var, TencentLocationListener tencentLocationListener, long j) {
            this.a = tencentLocationListener;
            this.b = j;
        }

        public long a() {
            return this.b;
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class f extends Handler {
        public double a;
        public double b;

        public f(Looper looper) {
            super(looper);
            this.a = 0.0d;
            this.b = 0.0d;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3101:
                case 3103:
                    int i = message.arg1;
                    p6 p6Var = p6.q;
                    if (i == 0) {
                        p6Var = (p6) message.obj;
                    } else {
                        x3.a("LOC", "callback:" + i);
                    }
                    if (p6Var == null) {
                        x3.a("LOC", "cbCode:" + i);
                        return;
                    }
                    boolean z = false;
                    if (a5.a(p6Var)) {
                        p6Var.a("beidou");
                        p6Var.c(0);
                        a7.c("TxLocationManagerImpl", "provider: " + p6Var.getProvider() + ", sourceProvider: " + p6Var.getSourceProvider());
                    }
                    a7.c("TxLocationManagerImpl", "user location:" + p6Var);
                    int i2 = message.what;
                    if (i2 == 3101) {
                        a7.b("TxLocationManagerImpl", "msg.what == MSG_ID_USER_LOCATION_CHANGED");
                        i5 i5Var = i5.this;
                        if (i5Var.a(p6Var, i5Var.L) || System.currentTimeMillis() - i5.this.A.q() >= i5.this.L.getGpsFirstTimeOut()) {
                            a7.b("TxLocationManagerImpl", "startLocTime: cal time since last loc " + i5.this.A.q());
                            long currentTimeMillis = i5.this.A.q() >= i5.this.A.k() ? System.currentTimeMillis() - i5.this.A.q() : System.currentTimeMillis() - i5.this.A.k();
                            a7.b("TxLocationManagerImpl", "TimeFromLastLoc: " + currentTimeMillis);
                            if (i5.this.L.getLocMode() == 12 && !p6Var.getProvider().equals("gps") && currentTimeMillis < 8000 && !i5.this.A.j().equals("network")) {
                                a7.c("TxLocationManagerImpl", "location mode is ONLY_GPS_MODE but location provider is " + p6Var.getProvider());
                                return;
                            }
                            if (this.a != p6Var.getLatitude() || this.b != p6Var.getLongitude()) {
                                try {
                                    x3.a("LOC", String.format(Locale.ENGLISH, "callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s", Integer.valueOf(i), p6Var.getProvider().substring(0, 1), Double.valueOf(p6Var.getLatitude()), Double.valueOf(p6Var.getLongitude()), Double.valueOf(p6Var.getAltitude()), Float.valueOf(p6Var.getAccuracy()), Float.valueOf(p6Var.getBearing()), Float.valueOf(p6Var.getSpeed()), p6Var.getIndoorBuildingFloor()));
                                } catch (Exception e) {
                                    a7.a("TxLocationManagerImpl", "maploc log", e);
                                }
                                this.a = p6Var.getLatitude();
                                this.b = p6Var.getLongitude();
                            }
                            b5 b5Var = i5.this.o;
                            if (b5Var != null) {
                                b5Var.a(p6Var.getLatitude(), p6Var.getLongitude());
                            }
                            if (i5.this.B != null) {
                                try {
                                    a7.c("TxLocationManagerImpl", String.format(Locale.ENGLISH, "continue callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s,%s,%d", Integer.valueOf(i), p6Var.getProvider().substring(0, 1), Double.valueOf(p6Var.getLatitude()), Double.valueOf(p6Var.getLongitude()), Double.valueOf(p6Var.getAltitude()), Float.valueOf(p6Var.getAccuracy()), Float.valueOf(p6Var.getBearing()), Float.valueOf(p6Var.getSpeed()), p6Var.getIndoorBuildingFloor(), p6Var.getSourceProvider().substring(0, 1), Integer.valueOf(p6Var.getFakeReason())));
                                } catch (Exception e2) {
                                }
                                for (TencentLocationListener tencentLocationListener : i5.this.B) {
                                    if (tencentLocationListener != null) {
                                        i5.this.A.e(p6Var.getProvider());
                                        i5.this.A.c(System.currentTimeMillis());
                                        tencentLocationListener.onLocationChanged(p6Var, i, (String) i5.h0.get(i));
                                        c cVar = i5.this.f42c;
                                        if (cVar != null) {
                                            cVar.removeMessages(11997);
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        a7.c("TxLocationManagerImpl", "continue is gps first but provider is " + p6Var.getProvider() + ", timeout: " + i5.this.L.getGpsFirstTimeOut());
                        return;
                    } else if (i2 == 3103) {
                        a7.b("TxLocationManagerImpl", "msg.what == MSG_ID_USER_SINGLE_LOCATION_CHANGED(3103)");
                        try {
                            a7.c("TxLocationManagerImpl", String.format(Locale.ENGLISH, "single callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s,%s,%d", Integer.valueOf(i), p6Var.getProvider().substring(0, 1), Double.valueOf(p6Var.getLatitude()), Double.valueOf(p6Var.getLongitude()), Double.valueOf(p6Var.getAltitude()), Float.valueOf(p6Var.getAccuracy()), Float.valueOf(p6Var.getBearing()), Float.valueOf(p6Var.getSpeed()), p6Var.getIndoorBuildingFloor(), p6Var.getSourceProvider().substring(0, 1), Integer.valueOf(p6Var.getFakeReason())));
                        } catch (Exception e3) {
                        }
                        i5 i5Var2 = i5.this;
                        if (!i5Var2.a(p6Var, i5Var2.M)) {
                            a7.c("TxLocationManagerImpl", "single is gps first but provider is " + p6Var.getProvider() + ", timeout: " + i5.this.M.getGpsFirstTimeOut());
                            if (i5.this.D == null || i5.this.D.isEmpty()) {
                                return;
                            }
                            for (e eVar : i5.this.D) {
                                TencentLocationListener tencentLocationListener2 = eVar.a;
                                if (tencentLocationListener2 != null && System.currentTimeMillis() - eVar.b > i5.this.M.getGpsFirstTimeOut()) {
                                    a7.c("TxLocationManagerImpl", "start callback single location, and remove listener");
                                    tencentLocationListener2.onLocationChanged(p6Var, i, (String) i5.h0.get(i));
                                    i5.this.c(tencentLocationListener2);
                                } else {
                                    a7.c("TxLocationManagerImpl", "singleListener.isEmpty()");
                                }
                            }
                            if (i5.this.D.isEmpty()) {
                                a7.c("TxLocationManagerImpl", "mSingleListenerStartTimeList.isEmpty()");
                                i5.this.o();
                                return;
                            }
                            return;
                        }
                        StringBuilder append = new StringBuilder().append("MSG_ID_USER_SINGLE_LOCATION_CHANGED, mSingleListenerList, ");
                        if (i5.this.C != null && !i5.this.C.isEmpty()) {
                            z = true;
                        }
                        a7.c("TxLocationManagerImpl", append.append(z).toString());
                        if (i5.this.C == null || i5.this.C.isEmpty()) {
                            return;
                        }
                        a7.c("TxLocationManagerImpl", "single Loc call back, provider is " + p6Var.getProvider());
                        for (TencentLocationListener tencentLocationListener3 : i5.this.C) {
                            if (tencentLocationListener3 != null) {
                                tencentLocationListener3.onLocationChanged(p6Var, i, (String) i5.h0.get(i));
                                i5.this.c(tencentLocationListener3);
                                a7.c("TxLocationManagerImpl", "SingleListener callback, " + tencentLocationListener3 + ", mSingleListenerList size: " + i5.this.C.size());
                            }
                        }
                        i5.this.o();
                        a7.c("TxLocationManagerImpl", "clear mSingleListenerList after size: " + i5.this.C.size());
                        a7.c("TxLocationManagerImpl", "clear mSingleListenerStartTimeList after size: " + i5.this.D.size());
                        return;
                    } else {
                        return;
                    }
                case 3102:
                    a7.c("TxLocationManagerImpl", "MSG_ID_USER_STATUS_UPDATE");
                    Bundle data = message.getData();
                    a7.c("TxLocationManagerImpl", "MSG_ID_USER_STATUS_UPDATE, " + data);
                    if (data == null) {
                        return;
                    }
                    String string = data.getString(com.alipay.sdk.m.h.c.e);
                    int i3 = data.getInt(com.alipay.sdk.m.h.c.a);
                    String string2 = data.getString("desc");
                    if (i5.this.B != null) {
                        for (TencentLocationListener tencentLocationListener4 : i5.this.B) {
                            a7.c("TxLocationManagerImpl", "MSG_ID_USER_STATUS_UPDATE, TencentLocationListener, " + tencentLocationListener4);
                            if (tencentLocationListener4 != null) {
                                tencentLocationListener4.onStatusUpdate(string, i3, string2);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        h0 = sparseArray;
        sparseArray.put(0, "OK");
        h0.put(1, "ERROR_NETWORK");
        h0.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
        h0.put(4, "DEFLECT_FAILED");
        h0.put(ErrorCode.E_INVALID_ARGUMENT, "ERROR_SERVER_NOT_LOCATION");
        i0 = new a();
    }

    public i5(m4 m4Var) {
        this.s = 0;
        this.z = m4Var;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
                this.t = true;
                try {
                    System.loadLibrary("jnirtk");
                    a7.c("TencentLocationSDK", "load jnirtk library success");
                } catch (Throwable th) {
                    a7.a("TencentLocationSDK", "load jnirtk library failed", th);
                    this.t = false;
                }
            } catch (Throwable th2) {
                a7.a("TencentLocationSDK", "load library", th2);
                this.s = 3;
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.t = false;
        }
        this.A = this.z.a();
        try {
            if (!TextUtils.isEmpty(TencentLocationManagerOptions.getExtraKey())) {
                this.A.d(TencentLocationManagerOptions.getExtraKey());
            } else if (!TextUtils.isEmpty(TencentLocationManagerOptions.getKey())) {
                this.A.d(TencentLocationManagerOptions.getKey());
            }
        } catch (Throwable th3) {
            a7.a("setKey", "setKey error", th3);
        }
        x3.a("7.5.4.3.official_1-240119");
        String i = this.A.i();
        this.V = a(i);
        a7.c("TxLocationManagerImpl", "mAppId: " + this.V);
        if (TextUtils.isEmpty(this.V)) {
            a7.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + i + "]");
            this.s = 2;
            return;
        }
        o1.a().a(this.e0);
        this.u = new q5(10, 4);
        this.C = new CopyOnWriteArrayList();
        this.B = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.p = new j5(this.z);
        this.q = new o5();
        this.r = new n5(this.z);
        this.n = f5.a(m4Var.a);
        try {
            this.o = new b5(this.z.a);
        } catch (Exception e2) {
            this.o = null;
        }
        this.j = true;
        this.h = null;
        s5 g = g();
        this.m = g;
        k5 e3 = e();
        this.i = e3;
        h5 d2 = d();
        this.k = d2;
        m5 f2 = f();
        this.l = f2;
        this.g = c7.a(g, e3, d2, f2);
        if (this.g) {
            this.s = 1;
            return;
        }
        this.g0 = new CopyOnWriteArrayList<>();
        x3.b(this.V);
    }

    public final k5 e() {
        if (!this.z.l()) {
            a7.b("TxLocationManagerImpl", "createNewCellProvider: failed");
            return null;
        }
        return new k5(this.z);
    }

    public final m5 f() {
        if (this.z.k() && g6.a) {
            return new m5(this.z);
        }
        a7.b("TxLocationManagerImpl", "createNlpProvider: failed");
        return null;
    }

    public final s5 g() {
        if (!this.z.m()) {
            a7.b("TxLocationManagerImpl", "createWifiProvider: failed");
            return null;
        }
        return new s5(this.z);
    }

    public final c.t.m.g.c h() {
        try {
            n4 a2 = this.z.a();
            return new c.t.m.g.c(a2.c(), "7.5.4.3.official_1", a2.a());
        } catch (Throwable th) {
            a7.a("TxLocationManagerImpl", "getAppInfo error.", th);
            return new c.t.m.g.c("unknown", "unknown", "unknown");
        }
    }

    public int i() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final y5 j() {
        x5 x5Var;
        e6 e6Var;
        w5 w5Var;
        e6 e6Var2 = this.w;
        w5 w5Var2 = this.v;
        x5 x5Var2 = this.y;
        a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, mLastWifiInfo: " + this.w);
        a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, mLastCellInfo: " + this.v);
        a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, mLastGpsInfo: " + this.y);
        boolean z = (x5Var2 == null || l()) ? false : true;
        boolean z2 = (e6Var2 == null || e6Var2.a(System.currentTimeMillis(), 60000L)) ? false : true;
        boolean z3 = w5Var2 == null;
        w6.a("combine," + z + "," + z3 + "," + z2);
        if (!z) {
            x5Var = x5Var2;
        } else {
            a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, gps is invalid!");
            x5Var = null;
        }
        if (z3) {
            a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, cellInfo is invalid! start to renew again");
            k5 k5Var = this.i;
            if (k5Var != null) {
                w5Var2 = k5Var.a(this.z);
            }
        }
        if (!z2) {
            e6Var = e6Var2;
        } else {
            a7.c("TxLocationManagerImpl", "getFromLastKnownInfo, wifiInfo is invalid! wifi is null or not fresh ");
            e6Var = null;
        }
        if (w5Var2 != null && x5Var != null) {
            int i = w5Var2.d;
            long j = w5Var2.f;
            Location location = x5Var.a;
            Bundle bundle = new Bundle();
            bundle.putString("cellkey", i + "" + j);
            bundle.putParcelable("location", location);
            o4 a2 = this.z.a("cell");
            if (a2 != null && !a2.a(bundle)) {
                a7.c("TxLocationManagerImpl", "getFromLastKnownInfo: discard bad cell(" + i + "," + j + ")");
                w5Var = null;
                b5 b5Var = this.o;
                return new y5(e6Var, w5Var, x5Var, b5Var != null ? b5Var.a() : null, this.g0);
            }
        }
        w5Var = w5Var2;
        b5 b5Var2 = this.o;
        return new y5(e6Var, w5Var, x5Var, b5Var2 != null ? b5Var2.a() : null, this.g0);
    }

    public TencentLocation k() {
        if (this.S == 0) {
            a(this.O);
            return this.O;
        }
        return null;
    }

    public final boolean l() {
        h5 h5Var = this.k;
        boolean z = false;
        if (h5Var != null) {
            if (h5Var.g() && this.k.f()) {
                z = true;
            }
            a7.c("TxLocationManagerImpl", "gps enable and isavailable: " + z);
        }
        if (!z) {
            a7.b("TxLocationManagerImpl", "isGpsValid: provider=" + z);
        }
        return z;
    }

    public final void m() {
        this.I = 0;
        this.w = null;
        this.v = null;
        this.y = null;
        this.R = null;
        this.J = 0L;
        y5.f = 0L;
        this.a0 = false;
        this.b0 = false;
        this.a = -1;
        a7.c("TxLocManagerImpl#reset", "mRunningStatus(Normal, Daemon, Single, Stop): " + this.U);
        this.U = d.Stop;
        this.N = 0L;
        this.c0 = 0;
        this.f = 0L;
        o4 a2 = this.z.a("cell");
        if (a2 != null) {
            a2.a();
        }
        n4 n4Var = this.A;
        if (n4Var != null) {
            n4Var.c("");
            this.A.a(0L);
            this.A.b(0L);
            this.A.d(0L);
            this.A.c(0L);
            this.A.e("");
        }
        v4.c();
    }

    public final void n() {
        a7.c("TxLocManagerImpl#shutdownProviders", "shutdownProviders");
        u6.a = false;
        if (c7.b(this.p)) {
            this.p.a();
        }
        if (c7.b(this.q)) {
            this.q.f();
        }
        if (c7.b(this.r)) {
            this.r.c();
        }
        if (c7.b(this.u)) {
            this.u.b();
        }
        if (c7.b(this.m)) {
            this.m.b();
        }
        if (this.j) {
            if (c7.b(this.i)) {
                this.i.b();
            }
        } else if (c7.b(this.h)) {
            this.h.f();
        }
        if (c7.b(this.k)) {
            this.k.l();
        }
        if (c7.b(this.l)) {
            this.l.a();
        }
        if (c7.b(this.n) && this.L.isAllowDirection()) {
            this.n.b();
        }
        if (c7.b(this.o)) {
            this.o.b();
        }
        c.t.m.g.b bVar = this.W;
        if (bVar != null) {
            bVar.f();
            this.W = null;
        }
        x3 x3Var = this.Z;
        if (x3Var != null) {
            x3Var.c();
            this.Z = null;
        }
        a7.c("TxLocManagerImpl#shutdownProviders", "----------finish, shutdownProviders");
    }

    public final void o() {
        if (this.U == d.Single) {
            c((TencentLocationListener) null);
            a7.b("TxLocationManagerImpl", "singleLocReset remove update!");
            return;
        }
        TencentLocationRequest.copy(this.M, TencentLocationRequest.create());
    }

    public boolean p() {
        this.I = 1;
        x3.a("LOC", "start indoor");
        return true;
    }

    public final void q() {
        if (this.L.getInterval() > 0) {
            a7.b("TxLocationManagerImpl", "send msg MSG_ID_TIMED_CALLBACK, startTimedCallback, interval is " + this.L.getInterval());
            a(11999, this.L.getInterval());
        }
    }

    public final void r() {
        c cVar = this.f42c;
        if (cVar == null) {
            this.f42c = new c(this.z.j().getLooper());
            a7.b("TxLocManagerImpl#startupProviders", "new mHandler");
        } else {
            cVar.b();
            a7.b("TxLocManagerImpl#startupProviders", "mHandler != null");
        }
        if (Boolean.parseBoolean(f7.a().get("deny_secret_info"))) {
            i4.a(true);
        }
        boolean t = t();
        boolean z = d.Daemon == this.U;
        c cVar2 = this.f42c;
        a7.b("TxLocManagerImpl#startupProviders", "startupProviders start mHandler is null? " + (this.f42c == null));
        x3 f2 = x3.f();
        this.Z = f2;
        if (f2 != null && !z) {
            boolean booleanValue = ((Boolean) d3.a("CONF_USER_DEBUGGABLE", Boolean.FALSE)).booleanValue();
            this.Z.a(booleanValue);
            if (booleanValue) {
                this.Z.e();
                x3.a("LOC", "request {interval: " + this.L.getInterval() + ", level: " + this.L.getRequestLevel() + ", gps: " + this.L.isAllowGPS() + ", direct: " + this.L.isAllowDirection() + com.alipay.sdk.m.q.h.d);
            }
        }
        this.r.a(cVar2, z);
        if (this.j) {
            if (t && c7.b(this.i) && c7.b(cVar2)) {
                this.i.a(cVar2, z);
            }
        } else if (t && c7.b(this.h) && c7.b(cVar2)) {
            this.h.a(cVar2);
        }
        if (t && c7.b(this.m) && c7.b(cVar2)) {
            this.m.b(this.A.s());
            this.m.a(cVar2, this.d, this.e, z);
        }
        if (c7.b(this.k) && this.L.isAllowGPS() && c7.b(cVar2)) {
            this.k.c(this.b == 1);
            if (!this.t) {
                this.G = 20;
            }
            this.k.b(this.G);
            this.k.b(this.t);
            this.k.a(cVar2, this.d, this.e, z);
        }
        if (!z) {
            if (!Boolean.parseBoolean(f7.a().get("collect_bles"))) {
                this.o = null;
            }
            if (c7.b(this.o) && c7.b(cVar2)) {
                a7.c("TxLocManagerImpl#startupProviders", "blue.startup()");
                this.o.a(cVar2);
            }
            if (c7.b(cVar2)) {
                this.p.b(cVar2);
                a7.c("TxLocManagerImpl#startupProviders", "NetworkMonitor.startup()");
                this.q.g();
                a7.c("TxLocManagerImpl#startupProviders", "ThreadPoolManger.startup()");
            }
            if (c7.b(this.n) && this.L.isAllowDirection() && c7.b(cVar2)) {
                a7.c("TxLocManagerImpl#startupProviders", "direct.startup()");
                this.n.a(cVar2);
            }
        }
        if (cVar2 != null) {
            cVar2.sendEmptyMessageDelayed(3991, 10000L);
        }
        if (c7.b(cVar2)) {
            int parseInt = Integer.parseInt(f7.a().get("f_coll_item"));
            if ((parseInt == 1 || parseInt == 2) && this.W == null) {
                this.W = new c.t.m.g.b(this.z.a);
            } else {
                this.W = null;
            }
            if (this.W != null && cVar2 != null) {
                a7.c("TxLocManagerImpl#startupProviders", "fc,set:" + parseInt + ",daemon:" + z + ",version:" + c.t.m.g.b.b());
                if (parseInt == 2 || (parseInt == 1 && !z)) {
                    this.W.a(h());
                    this.W.a("D_UP_NET", f7.a().get("f_coll_up_net"));
                    this.W.a("D_UP_U_TRACK_INFO", Boolean.toString(true));
                    this.W.a("D_SDK_VER", "7.5.4.3.official_1");
                    this.W.a("D_UP_GPS_FOR_NAVI", Boolean.toString(TencentLocationManagerOptions.isUploadGpsForNavi()));
                    this.W.a(cVar2.getLooper());
                }
            }
        }
        x3.a("m", i4.f());
        a7.b("TxLocManagerImpl#startupProviders", "------ startupProviders end mHandler is null? " + (this.f42c == null));
    }

    public boolean s() {
        if (this.I > 0) {
            if (c7.b(this.m)) {
                this.m.b(this.A.s());
            }
            if (c7.b(Long.valueOf(this.F))) {
                this.F = this.L.getInterval();
            }
            this.I = 0;
        }
        x3.a("LOC", "stop indoor");
        return true;
    }

    public final boolean t() {
        Bundle extras = this.L.getExtras();
        if (extras != null) {
            return extras.getBoolean("use_network", true);
        }
        return true;
    }

    public final boolean u() {
        a7.c("TxLocationManagerImpl", "nationcode, lastRegeostatus=" + this.a);
        int i = this.a;
        return (i < 110 || i > 199) && this.a != 311;
    }

    public final h5 d() {
        if (!this.z.k()) {
            a7.b("TxLocationManagerImpl", "createGpsProvider: failed");
            return null;
        }
        return new h5(this.z, this.t);
    }

    public void c(TencentLocationListener tencentLocationListener) {
        List<TencentLocationListener> list;
        w6.a("removeUpdates," + (tencentLocationListener == null));
        synchronized (this.K) {
            if (this.B != null) {
                if (tencentLocationListener != null) {
                    this.B.remove(tencentLocationListener);
                } else {
                    this.B.clear();
                }
            }
            if (this.C != null && !this.C.isEmpty()) {
                if (tencentLocationListener != null) {
                    this.C.remove(tencentLocationListener);
                } else {
                    this.C.clear();
                }
            }
            if (this.D != null) {
                if (tencentLocationListener != null) {
                    Iterator<e> it = this.D.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        e next = it.next();
                        if (next.a.equals(tencentLocationListener)) {
                            this.D.remove(next);
                            break;
                        }
                    }
                } else {
                    this.D.clear();
                }
            }
        }
        List<TencentLocationListener> list2 = this.C;
        if (list2 == null || !list2.isEmpty() || (list = this.B) == null || !list.isEmpty()) {
            return;
        }
        synchronized (this.d0) {
            n();
            a7.b("TxLocationManagerImpl", "shutdown all providers");
            if (this.f42c != null) {
                this.f42c.b();
                a7.b("TxLocationManagerImpl", "mHandler set null");
                this.f42c = null;
            }
        }
        m();
    }

    public int b(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        List<e> list;
        List<TencentLocationListener> list2;
        if (this.s != 0) {
            return this.s;
        }
        if (tencentLocationListener != null && (list2 = this.C) != null) {
            list2.add(tencentLocationListener);
        }
        if (tencentLocationListener != null && (list = this.D) != null) {
            list.add(new e(this, tencentLocationListener, System.currentTimeMillis()));
        }
        a7.c("TxLocManagerImpl#requestSingleLocationFresh", "mSingleListenerList size: " + this.C.size());
        w6.a("requestSingle," + tencentLocationRequest + ",7.5.4.3.official_1_240119," + i4.f() + "," + this.C.size() + "," + i4.k() + "," + u3.a().c(this.z.a));
        if (tencentLocationRequest != null) {
            a7.c("TxLocManagerImpl#requestSingleLocationFresh", "request: " + tencentLocationRequest.toString());
            TencentLocationRequest.copy(this.M, tencentLocationRequest);
        } else {
            a7.c("TxLocManagerImpl#requestSingleLocationFresh", "request is null");
        }
        if (System.currentTimeMillis() - this.E < 2000 && this.C.size() > 1) {
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", "since last single less than 2s , return directly");
            return 0;
        }
        this.E = System.currentTimeMillis();
        boolean a2 = a(90000, 30000);
        boolean a3 = a(tencentLocationRequest);
        if (a2 && a3) {
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", " single message MSG_ID_USER_SINGLE_LOCATION_CHANGED(3103)");
            a(this.O, this.S, 3103);
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", " cache hit");
            return 0;
        } else if (this.U == d.Normal) {
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", " continues callback is running,send single prepare");
            if (tencentLocationRequest.isGpsFirst()) {
                a7.b("TxLocManagerImpl#requestSingleLocationFresh", " request isGpsFirst, send MSG_ID_SINGLE_PREPARE_JSON(3997)delay: " + tencentLocationRequest.getGpsFirstTimeOut());
                a(3997, tencentLocationRequest.getGpsFirstTimeOut());
            } else {
                a7.b("TxLocManagerImpl#requestSingleLocationFresh", " request is not GpsFirst, send MSG_ID_SINGLE_PREPARE_JSON(3997)");
                b(3997);
            }
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", " mHandler is null? " + (this.f42c == null));
            return 0;
        } else {
            a7.b("TxLocManagerImpl#requestSingleLocationFresh", " no continues callback, start all provider");
            if (tencentLocationRequest != null) {
                tencentLocationRequest.setSmallAppKey(tencentLocationRequest.getSmallAppKey()).setInterval(0L);
            } else {
                tencentLocationRequest = TencentLocationRequest.create().setInterval(0L);
                tencentLocationRequest.setAllowGPS(false);
            }
            return a(tencentLocationRequest, i0, looper);
        }
    }

    public int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.s != 0) {
            a7.c("TxLocManagerImpl#requestLocationUpdates", "requestLocationUpdates mSoAndKeyStatus: " + this.s);
            w6.a("init error," + this.s);
            return this.s;
        }
        a7.c("TxLocManagerImpl#requestLocationUpdates", "requestLocationUpdates reset(): ");
        m();
        this.S = ErrorCode.E_INVALID_ARGUMENT;
        this.O = null;
        synchronized (this.K) {
            if (tencentLocationListener != null) {
                if (this.B != null) {
                    this.B.add(tencentLocationListener);
                }
            }
        }
        e5.b = tencentLocationRequest.getExtras().getBoolean("NetLocationImprove", false);
        a7.c("TxLocManagerImpl#requestLocationUpdates", "requestLocationUpdates isImproveNetLoc: " + e5.b);
        if (tencentLocationListener == i0) {
            a7.c("TxLocManagerImpl#requestLocationUpdates", "requestLocationUpdates current is single request");
            List<e> list = this.D;
            if (list != null && !list.isEmpty()) {
                this.A.d(this.D.get(0).a());
            }
            if (this.U == d.Stop || this.U == d.Single) {
                this.U = d.Single;
                if (!e5.b) {
                    j7.d = true;
                } else {
                    j7.d = false;
                }
            }
        } else {
            this.U = d.Normal;
            j7.d = false;
            w6.a("requestContinue," + tencentLocationRequest + ",7.5.4.3.official_1_240119," + i4.f() + "," + i4.k() + "," + u3.a().c(this.z.a));
        }
        a7.c("TxLocManagerImpl#requestLocationUpdates", "IS_SINGLE_REQUEST_LIMIT: " + j7.d);
        Bundle extras = tencentLocationRequest.getExtras();
        if (extras != null && extras.getString("LOCATION_URL_IOT") != null && extras.getString("LOCATION_URL_IOT").equals("true")) {
            e5.d = true;
            a7.c("TxLocManagerImpl#requestLocationUpdates", "use LOCATION_URL_IOT");
        } else {
            e5.d = false;
            a7.c("TxLocManagerImpl#requestLocationUpdates", "use LOCATION_URL");
        }
        TencentLocationRequest.copy(this.L, tencentLocationRequest);
        if (this.L.isIndoorLocationMode()) {
            this.I = 1;
        }
        if (this.L.getGnssSource() == 20 || this.L.getGnssSource() == 21) {
            this.G = this.L.getGnssSource();
        }
        n4 n4Var = this.A;
        if (n4Var != null) {
            n4Var.d(System.currentTimeMillis());
            a7.b("TxLocManagerImpl#requestLocationUpdates", "startLocTime begin set: " + this.A.q());
            if (this.A.d().equals(this.A.e())) {
                this.z.o();
            }
            this.A.g(tencentLocationRequest.getQQ());
            this.A.h(tencentLocationRequest.getSmallAppKey());
            this.A.a(tencentLocationRequest.getInterval(), this.L.isIndoorLocationMode());
        }
        this.F = this.L.getInterval();
        b(looper);
        a7.c("TxLocManagerImpl#requestLocationUpdates", "requestLocationUpdates request:" + this.L.toString());
        Boolean valueOf = Boolean.valueOf(System.currentTimeMillis() - this.Y > 600000);
        a7.c("GpsNaviPro", "mOrderStatus(last one): " + this.X + ", exceed 10 mins: " + valueOf);
        if (this.Y != 0 && valueOf.booleanValue()) {
            this.X = 0;
        }
        c.t.m.g.b bVar = this.W;
        if (bVar != null) {
            bVar.a(4, 0L, new Integer(this.X));
        }
        if (this.L.getLocMode() == 10 && this.L.isGpsFirst()) {
            a7.b("TxLocManagerImpl#requestLocationUpdates", "send msg MSG_ID_TIME_OUT_CALLBACK(11997), GpsFirstTimeOut, send delayed " + this.L.getGpsFirstTimeOut());
            a(11997, this.L.getGpsFirstTimeOut());
            a7.b("TxLocManagerImpl#requestLocationUpdates", "send msg MSG_ID_TIME_OUT_CALLBACK(3997), GpsFirstTimeOut, send delayed " + this.L.getGpsFirstTimeOut());
            a(3997, this.L.getGpsFirstTimeOut());
        } else if (this.L.getLocMode() == 12) {
            a7.b("TxLocManagerImpl#requestLocationUpdates", "ONLY_GPS_TIME_OUT MSG_ID_TIME_OUT_CALLBACK(11997) send delayed");
            a(11997, 8000L);
        }
        return 0;
    }

    public void c(int i) {
        if (this.b == i) {
            return;
        }
        synchronized (this.K) {
            if (c7.b(this.B) && !this.B.isEmpty()) {
                throw new IllegalStateException("removeUpdates MUST called before set coordinate type!");
            }
        }
        this.b = i;
    }

    public final void b(Looper looper) {
        a7.b("TxLocManagerImpl#restartProviders", "restartProviders in");
        synchronized (this.d0) {
            a7.b("TxLocManagerImpl#restartProviders", "restartProviders in got lock");
            a(looper);
            n();
            this.f = System.currentTimeMillis();
            r();
        }
    }

    public final d5 c() {
        if (!this.z.l()) {
            a7.b("TxLocationManagerImpl", "createCellProvider: failed");
            return null;
        }
        return new d5(this.z);
    }

    public void b(int i, TencentLocationListener tencentLocationListener) {
        z4.a(this.z).b(i, tencentLocationListener);
    }

    public void b(TencentLocationListener tencentLocationListener) {
        synchronized (this.K) {
            if (tencentLocationListener != null) {
                if (this.B != null && !this.B.isEmpty()) {
                    this.B.remove(tencentLocationListener);
                    a7.c("TxLocationManagerImpl", "removeLocationListener direct");
                    if (this.C != null && this.C.isEmpty() && this.B != null && this.B.isEmpty()) {
                        c((TencentLocationListener) null);
                    }
                }
            }
        }
    }

    public final boolean b() {
        return this.S == 404;
    }

    public final void b(int i) {
        if (this.f42c == null) {
            a7.b("TxLocationManagerImpl", "mHandler is null");
            this.f42c = new c(this.z.j().getLooper());
        }
        this.f42c.sendEmptyMessage(i);
    }

    public final void b(w5 w5Var) {
        a7.c("TxLocManagerImpl#onCellInfoEvent", "onCellInfoEvent");
        a(w5Var);
        c.t.m.g.b bVar = this.W;
        if (bVar != null) {
            c.t.m.g.d dVar = new c.t.m.g.d(w5Var.b, w5Var.f114c, w5Var.d, w5Var.f, w5Var.e, w5Var.a.ordinal());
            ArrayList arrayList = new ArrayList();
            arrayList.add(dVar);
            bVar.a(dVar, arrayList);
        }
    }

    public final void b(e6 e6Var) {
        a7.c("TxLocationManagerImpl", "onWifiInfoEvent");
        a7.b("TxLocationManagerImpl", "onWifiInfoEvent mHandler is null? " + (this.f42c == null));
        a(e6Var);
        c.t.m.g.b bVar = this.W;
        if (bVar != null) {
            bVar.a(e6Var.b());
        }
    }

    public final void b(x5 x5Var) {
        a7.c("TxLocationManagerImpl", "onGpsInfoEvent");
        a(x5Var);
        c.t.m.g.b bVar = this.W;
        if (bVar != null) {
            bVar.a(x5Var.a);
            this.Y = System.currentTimeMillis();
        }
    }

    public final void a(Looper looper) {
        if (c7.a(this.d) || this.d.getLooper() != looper) {
            this.d = new f(looper);
        }
        this.d.removeCallbacksAndMessages(null);
        Handler handler = this.e;
        if (handler == null || handler.getLooper() != Looper.getMainLooper()) {
            this.e = new Handler(Looper.getMainLooper());
        }
    }

    public final void b(int i, int i2) {
        String str;
        String str2 = "location permission denied";
        String str3 = "unknown";
        switch (i) {
            case 12001:
                if (i2 == 13001) {
                    str3 = "wifi enabled";
                } else if (i2 == 13002) {
                    str3 = "wifi disabled";
                } else if (i2 == 13005) {
                    str3 = "location service switch is off";
                }
                str = "wifi";
                if (i2 != 5 && j7.a) {
                    i2 = 2;
                    break;
                } else {
                    str2 = str3;
                    break;
                }
            case 12002:
                str = "gps";
                switch (i2) {
                    case 13001:
                        str2 = "gps enabled";
                        break;
                    case 13002:
                        str2 = "gps disabled";
                        break;
                    case 13003:
                        str2 = "gps available";
                        break;
                    case 13004:
                        str2 = "gps unavailable";
                        break;
                    default:
                        str2 = str3;
                        break;
                }
            case 12003:
                if (i2 == 13001) {
                    str3 = "cell enabled";
                } else if (i2 == 13002) {
                    str3 = "cell disabled";
                }
                str = "cell";
                if (u6.a) {
                    i2 = 13006;
                    break;
                }
                str2 = str3;
                break;
            default:
                a7.b("TxLocationManagerImpl", "onStatusChanged error:unknown type! type:" + i + ",status" + i2);
                str2 = null;
                str = null;
                break;
        }
        x3.a(str, "s:" + i2);
        a7.c("TxLocationManagerImpl", "onStatusChanged: " + str2);
        w6.a("status," + str + "," + str2);
        f fVar = this.d;
        if (fVar != null) {
            Message obtainMessage = fVar.obtainMessage(3102);
            Bundle data = obtainMessage.getData();
            if (data == null) {
                data = new Bundle();
            }
            data.clear();
            data.putString(com.alipay.sdk.m.h.c.e, str);
            data.putInt(com.alipay.sdk.m.h.c.a, i2);
            data.putString("desc", str2);
            obtainMessage.setData(data);
            obtainMessage.sendToTarget();
        }
    }

    public final void a(p6 p6Var) {
        a7.c("TxLocationManagerImpl", "fillExtra");
        if (p6Var != null) {
            if (this.n != null && this.L.isAllowDirection()) {
                y2.a(p6Var.getExtra(), "direction", Double.valueOf(this.n.a()), Double.class);
            }
            try {
                p6Var.getExtra().putAll(this.L.getExtras());
            } catch (Exception e2) {
            }
        }
    }

    public int a(int i, TencentLocationListener tencentLocationListener) {
        return z4.a(this.z).a(i, tencentLocationListener);
    }

    public void a(TencentLocationListener tencentLocationListener) {
        synchronized (this.K) {
            if (tencentLocationListener != null) {
                if (this.B != null) {
                    this.B.add(tencentLocationListener);
                    a7.c("TxLocationManagerImpl", "addLocationListener direct");
                }
            }
        }
    }

    public final void a(int i, p6 p6Var) {
        int i2;
        if (p6Var == null) {
            return;
        }
        if (i == 0 && p6Var.getLatitude() != 0.0d && p6Var.getLongitude() != 0.0d) {
            x4 x4Var = x4.h;
            if (this.b == 1 && v6.a(p6Var.getLatitude(), p6Var.getLongitude())) {
                x4Var = x4.i;
                i2 = 1;
            } else {
                i2 = 0;
            }
            p6.b(p6Var, i2);
            a7.c("TxLocationManagerImpl", "updateLastLoc, txloc: " + p6Var.getProvider() + "," + p6Var.getLatitude() + "," + p6Var.getLatitude());
            if (x4Var != null && p6Var.getProvider().equals("network")) {
                double accuracy = p6Var.getAccuracy();
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - this.f;
                long j2 = currentTimeMillis - x4Var.g;
                if (accuracy <= 150.0d || j >= 20000) {
                    if (accuracy <= 150.0d && j < 5000 && j2 < 10000) {
                        p6Var.a("gps", x4Var.a());
                        a7.c("TxLocationManagerImpl", "wifi loc is update to: " + p6Var + " GpsCach" + x4Var);
                    }
                } else if (j2 < 25000) {
                    p6Var.a("gps", x4Var.a());
                    a7.c("TxLocationManagerImpl", "cell loc is update to: " + p6Var + " GpsCach" + x4Var);
                }
            }
        }
        if (b()) {
            if (p6Var.getAccuracy() < 5000.0f && p6Var.getAccuracy() > 0.0f) {
                this.u.a((TencentLocation) p6Var);
            }
            this.P = p6Var.getLatitude();
            this.Q = p6Var.getLongitude();
            if (c7.b(this.B) && this.B.size() > 0) {
                q();
            }
        } else if (i == 0 && p6Var.getLatitude() != 0.0d && p6Var.getLongitude() != 0.0d && Math.abs(p6Var.getLatitude() - this.P) >= 1.0E-8d && Math.abs(p6Var.getLongitude() - this.Q) >= 1.0E-8d) {
            if (!this.u.a(p6Var, this.z, this.k.g())) {
                a7.c("TxLocationManagerImpl", "discard " + p6Var);
                return;
            }
            this.P = p6Var.getLatitude();
            this.Q = p6Var.getLongitude();
            if (p6Var.getAccuracy() < 5000.0f && p6Var.getAccuracy() > 0.0f) {
                this.u.a(p6Var);
                this.u.a((TencentLocation) p6Var);
            }
        }
        boolean z = this.S != 0 && i == 0;
        this.S = i;
        this.O = p6Var;
        a7.c("TxLocationManagerImpl", "mLastLocation location:" + this.O.toString());
        if (this.L.getInterval() == 0 && c7.b(this.B) && !this.B.isEmpty()) {
            a7.b("TxLocationManagerImpl", "interval 0, direct callback, mHandler is null? " + (this.f42c == null));
            b(11998);
        } else if (z && c7.b(this.B) && !this.B.isEmpty()) {
            a7.b("TxLocationManagerImpl", "error_ok, direct callback, mHandler is null? " + (this.f42c == null));
            b(11998);
        }
    }

    public final boolean b(String str) {
        if (str != null && !str.isEmpty()) {
            if (Arrays.asList(this.H).contains(str)) {
                return true;
            }
            if (!"crisTest".equals(str) || System.currentTimeMillis() >= 1678712340000L) {
                String packageName = this.z.a.getPackageName();
                if (packageName.length() > 32) {
                    String[] split = packageName.split("\\.");
                    if (split.length > 0) {
                        packageName = split[split.length - 1];
                    }
                }
                String replaceAll = packageName.replaceAll("\\.", "_");
                if (replaceAll.equals(str)) {
                    return true;
                }
                a7.b("TxLocationManagerImpl", "key not valid, key:" + str + " validKey:" + replaceAll);
                return false;
            }
            return true;
        }
        a7.b("TxLocationManagerImpl", "key is empty");
        return false;
    }

    public final void a(int i, long j) {
        if (this.f42c == null) {
            a7.b("TxLocationManagerImpl", "mHandler is null delayed");
            this.f42c = new c(this.z.j().getLooper());
        }
        this.f42c.sendEmptyMessageDelayed(i, j);
    }

    public final void a(int i) {
        String b2 = b7.b(this.z.a);
        w6.a("netstatus," + i + "," + b2);
        if (i == -1) {
            a7.c("TxLocationManagerImpl", "onNetworkEvent: networks not found");
        } else if (i == 0) {
            a7.c("TxLocationManagerImpl", "onNetworkEvent: " + b2 + " disconnected");
        } else if (i != 1) {
        } else {
            a7.c("TxLocationManagerImpl", "onNetworkEvent: " + b2 + " connected");
            a(7999, 1000L);
        }
    }

    public final void a(e6 e6Var) {
        boolean z;
        a7.c("TxLocManagerImpl#onWifiChanged", "onWifiChanged," + e6Var);
        a7.b("TxLocManagerImpl#onWifiChanged", "onWifiChanged mHandler is null? " + (this.f42c == null));
        e6 e6Var2 = this.x;
        if (e6Var2 == null) {
            z = false;
        } else {
            z = e6Var2.a(e6Var);
        }
        if (z) {
            this.J = System.currentTimeMillis();
        }
        List<ScanResult> emptyList = e6Var == null ? Collections.emptyList() : e6Var.b();
        StringBuilder sb = new StringBuilder("len:" + emptyList.size() + ",sim:" + (z ? "1" : "0"));
        for (int i = 0; i < Math.min(3, emptyList.size()); i++) {
            ScanResult scanResult = emptyList.get(i);
            sb.append(',').append(scanResult.BSSID.replaceAll(":", "")).append('_').append(scanResult.level);
        }
        x3.a("WIFI", sb.toString());
        w6.a("wifi prepare," + this.I + "," + z + "," + (this.w == null) + "," + (e6Var == e6.d) + "," + (this.J == -1) + "," + (e6Var != null ? e6Var.b().size() + "" : "null"));
        if (this.w == null || this.I == 2 || e6Var == e6.d || this.J == -1 || e6Var.b().size() < 3 || !z) {
            a7.c("TxLocManagerImpl#onWifiChanged", "onWifiChanged: --> prepare json");
            x3.a("WIFI", "rany- wifi req");
            a7.b("TxLocManagerImpl#onWifiChanged", "mHandler is null? " + (this.f42c == null));
            b(3999);
        }
        this.w = e6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(w5 w5Var) {
        a7.c("TxLocManagerImpl#onCellChanged", "onCellChanged," + w5Var);
        w5 w5Var2 = this.v;
        if (this.g0 != null && w5Var2 != null) {
            if (!this.g0.isEmpty()) {
                w5 w5Var3 = this.g0.get(this.g0.size() - 1);
                if (w5Var3 != null && !w5Var3.u.containsAll(w5Var2.u)) {
                    this.g0.add(w5Var2);
                }
            } else {
                this.g0.add(w5Var2);
            }
            if (this.g0.size() > 8) {
                this.g0.remove(0);
            }
        }
        this.v = w5Var;
        long max = Math.max(this.L.getInterval(), 20000L);
        List<ScanResult> emptyList = Collections.emptyList();
        boolean c2 = j7.c(this.z);
        if (!this.a0) {
            if (!c2) {
                a7.c("TxLocManagerImpl#onCellChanged", "onCellChanged,clear last wifi info");
                this.w = null;
            } else {
                emptyList = j7.a(this.z.i(), false);
                a7.c("TxLocManagerImpl#onCellChanged", "onCellChanged,Wi-Fi List size = " + emptyList.size());
            }
        }
        w6.a("cell prepare," + c2 + "," + this.a0 + "," + emptyList.size() + "," + (this.J == -1) + "," + (this.J > 0 && System.currentTimeMillis() - this.J > max) + "," + max);
        if (!this.a0 && c2 && emptyList.size() != 0) {
            long j = this.J;
            if (j != -1 && (j <= 0 || System.currentTimeMillis() - this.J <= max)) {
                a7.b("TxLocManagerImpl#onCellChanged", "cell change but not prepare json, because isScannable:" + c2 + ", wifi size:" + emptyList.size() + ", mLastWF:" + this.J + ", current:" + System.currentTimeMillis());
                if (w5Var == null) {
                    String str = w5Var.d + "," + w5Var.f;
                    if (this.f0.equals(str)) {
                        return;
                    }
                    String str2 = "cell:" + w5Var.b + "," + w5Var.f114c + "," + w5Var.d + "," + w5Var.f + "," + w5Var.e + ",";
                    x3.a("CELL", (w5Var.m == Integer.MAX_VALUE || w5Var.n == Integer.MAX_VALUE) ? str2 + "-1,-1" : str2 + String.format(Locale.ENGLISH, "%.6f,%.6f", Float.valueOf(w5Var.m / 14400.0f), Float.valueOf(w5Var.n / 14400.0f)));
                    this.f0 = str;
                    return;
                }
                return;
            }
        }
        x3.a("CELL", "cell req");
        a7.c("TxLocManagerImpl#onCellChanged", "mHandler is null? " + (this.f42c == null));
        a7.c("TxLocManagerImpl#onCellChanged", "rany- onCellChanged: --> prepare json");
        b(3999);
        if (w5Var == null) {
        }
    }

    public final void a(x5 x5Var) {
        double d2;
        double d3;
        a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, " + x5Var);
        if (x5Var.a == e5.a) {
            return;
        }
        this.y = x5Var;
        int requestLevel = this.L.getRequestLevel();
        p6 p6Var = this.R;
        Location location = new Location(x5Var.a);
        Bundle extras = location.getExtras();
        if (extras == null) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            d2 = extras.getDouble("lat");
            d3 = extras.getDouble("lng");
        }
        a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged,  location extras:" + d2 + "," + d3);
        if (d2 == 0.0d && d3 == 0.0d) {
            x3.a("g", "defl error");
            return;
        }
        if (b()) {
            a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, onGpsChanged: --> prepare json");
            a7.b("TxLocManagerImpl#onGpsChanged", "rany- onGpsChanged, mHandler is null? " + (this.f42c == null));
            w6.a("gps prepare,in first");
            b(3999);
        }
        int b2 = v4.a(x5Var) ? v4.b() : 0;
        a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, fakeReason is " + b2);
        p6 a2 = new p6.b().a(p6Var).b("gps").a(requestLevel).a(location.getExtras()).a(new Location(x5Var.a)).a();
        location.setLatitude(d2);
        location.setLongitude(d3);
        a2.b(location);
        a2.c(b2);
        a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, location:" + a2);
        a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, updateLastLocation: mIndoorLocationStatus: " + this.I + ", beforeFirstFix: " + b());
        if (this.I != 2) {
            a(0, a2);
            a7.c("TxLocManagerImpl#onGpsChanged", "send msg MSG_ID_USER_SINGLE_LOCATION_CHANGED(3103)");
            a(a2, 0, 3103);
            a7.c("TxLocManagerImpl#onGpsChanged", "onGpsChanged, updateLastLocation:" + a2.getLatitude() + "," + a2.getLongitude());
        }
        b(12002, 13003);
    }

    public final synchronized void a(p6 p6Var, int i, int i2) {
        if (p6Var != null) {
            if (this.d != null) {
                a7.c("TxLocManagerImpl#processLocationChanged", "location:" + p6Var);
                a7.c("TxLocManagerImpl#processLocationChanged", "error:" + i);
                a7.c("TxLocManagerImpl#processLocationChanged", "msg_id:" + i2);
                Bundle extras = this.L.getExtras();
                if (this.c0 != 0 && i == 0) {
                    p6Var.a(this.c0);
                    a7.c("TxLocManagerImpl#processLocationChanged", "set nation code: " + p6Var.getNationCode());
                } else if (i == 0 && extras != null && extras.containsKey("ReGeoCodingnKey") && u()) {
                    String string = extras.getString("ReGeoCodingnKey", TokenStreamRewriter.DEFAULT_PROGRAM_NAME);
                    if (!TokenStreamRewriter.DEFAULT_PROGRAM_NAME.equals(string)) {
                        a7.c("TxLocManagerImpl#processLocationChanged", "sendmessage to request nationcode");
                        e5.f27c = string;
                        p3.b(this.f42c, 5999, i, i2, p6Var);
                        return;
                    }
                }
                a7.c("TxLocManagerImpl#processLocationChanged", "sendmessage to callback user");
                Message obtainMessage = this.d.obtainMessage(i2);
                obtainMessage.arg1 = i;
                obtainMessage.obj = p6Var;
                obtainMessage.sendToTarget();
                if (this.d.getLooper() == null || this.d.getLooper().getThread() == null || !this.d.getLooper().getThread().isAlive()) {
                    x3.a("U", i + ",user thread is invalid");
                }
                return;
            }
        }
        x3.a("G", "user handler is null or loc is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0077 A[Catch: UnsatisfiedLinkError -> 0x008c, TryCatch #0 {UnsatisfiedLinkError -> 0x008c, blocks: (B:4:0x0025, B:6:0x0037, B:8:0x003a, B:10:0x003e, B:12:0x0042, B:19:0x0054, B:21:0x005c, B:23:0x0077, B:20:0x0057, B:25:0x007a, B:27:0x0087), top: B:32:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        a7.c("TxLocationManagerImpl", "calcAppIdFromKey, key: " + str);
        try {
            if (str.contains(",")) {
                String[] split = str.split(",");
                a7.c("hh", "fun_w");
                boolean b2 = b(split[0]);
                boolean z = (split == null || split.length <= 1 || split[0] == null || split[1] == null || SoUtils.fun_w(split[0], split[1]) <= 0) ? false : true;
                if (z && b2) {
                    e5.e = true;
                    a7.c("TxLocationManagerImpl", "extraKey is " + e5.e);
                    return !z ? split[0] : "";
                }
                this.t = false;
                e5.e = false;
                a7.c("TxLocationManagerImpl", "extraKey is " + e5.e);
                if (!z) {
                }
            } else {
                a7.c("hh", "fun_v");
                int fun_v = SoUtils.fun_v(str);
                this.t = false;
                return fun_v >= 0 ? Integer.toString(fun_v) : "";
            }
        } catch (UnsatisfiedLinkError e2) {
            return null;
        }
    }

    public final boolean a(p6 p6Var, TencentLocationRequest tencentLocationRequest) {
        return tencentLocationRequest == null || tencentLocationRequest.getLocMode() != 10 || !tencentLocationRequest.isGpsFirst() || p6Var.getProvider().equals("gps");
    }

    public final boolean a(int i, int i2) {
        List<TencentLocationListener> list = this.C;
        if (list == null || list.isEmpty() || this.S != 0 || this.O == null || this.A.q() == 0) {
            return false;
        }
        if (!"gps".equals(this.O.getProvider()) || System.currentTimeMillis() - this.O.getTime() > i) {
            return "network".equals(this.O.getProvider()) && System.currentTimeMillis() - this.O.getTime() <= ((long) i2);
        }
        return true;
    }

    public final boolean a(TencentLocationRequest tencentLocationRequest) {
        if (tencentLocationRequest == null) {
            return true;
        }
        if (this.O == null) {
            return false;
        }
        if ((tencentLocationRequest.isGpsFirst() && tencentLocationRequest.getLocMode() == 10) || tencentLocationRequest.getLocMode() == 12) {
            return "gps".equals(this.O.getProvider()) && System.currentTimeMillis() - this.O.getTime() <= 5000;
        } else if (tencentLocationRequest.getLocMode() == 11) {
            return "network".equals(this.O.getProvider()) && System.currentTimeMillis() - this.O.getTime() <= 5000;
        } else {
            return true;
        }
    }

    public void a(long j) {
        if (this.U == d.Normal) {
            if (j <= 0) {
                a7.c("TxLocManagerImpl#changeCallbackInterval", "callback interval <= 0, return");
            } else if (j == this.F) {
                a7.c("TxLocManagerImpl#changeCallbackInterval", "callback interval is not change, return");
            } else {
                this.L.setInterval(j);
                this.F = j;
                boolean t = t();
                boolean z = d.Daemon == this.U;
                c cVar = this.f42c;
                if (c7.b(this.k)) {
                    this.k.l();
                }
                if (c7.b(this.k) && this.L.isAllowGPS() && c7.b(cVar)) {
                    this.k.a(j);
                    this.k.c(this.b == 1);
                    if (!this.t) {
                        this.G = 20;
                    }
                    this.k.b(this.G);
                    this.k.b(this.t);
                    this.k.a(cVar, this.d, this.e, z);
                }
                long s = this.A.s();
                this.A.a(this.L.getInterval(), this.L.isIndoorLocationMode());
                if (s == this.A.s()) {
                    a7.c("TxLocManagerImpl#changeCallbackInterval", "wifi scan interval is not change, return");
                    return;
                }
                if (c7.b(this.m)) {
                    this.m.b();
                }
                if (t && c7.b(this.m) && c7.b(cVar)) {
                    this.m.b(this.A.s());
                    this.m.a(cVar, this.d, this.e, z);
                }
            }
        }
    }

    public void a(String str, String str2) {
        if ("orderStatus".equals(str)) {
            if (TencentLocationManagerOptions.isUploadGpsForNavi()) {
                try {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt != 0) {
                        this.X = parseInt;
                        if (this.W != null) {
                            this.W.a(4, 0L, new Integer(parseInt));
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("order status value should not be 0");
                } catch (NumberFormatException e2) {
                    a7.c("TxLocationManagerImpl", "parse order status value error: " + e2.getMessage());
                }
            }
        } else if ("RunningState".equals(str)) {
            if ("foreground".equals(str2)) {
                u2.a(u2.a.FOREGROUND);
            } else if ("background".equals(str2)) {
                u2.a(u2.a.BACKGROUND);
            }
        } else {
            throw new IllegalArgumentException("the key: " + str + " is not supported");
        }
    }
}