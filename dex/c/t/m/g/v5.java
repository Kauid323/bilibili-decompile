package c.t.m.g;

import android.bluetooth.BluetoothDevice;
import com.ashampoo.xmp.XMPConst;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class v5 implements Cloneable {
    public int a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f109c;
    public int d;
    public long e;

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public void b(String str) {
    }

    public int c() {
        return this.b;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public String toString() {
        return "Beacon [major=" + this.a + ", minor=" + this.b + ", bluetoothAddress=" + this.f109c + ", rssi=" + this.d + ", time=" + this.e + "]";
    }

    public String a() {
        return this.f109c;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.f109c = str;
    }

    public void a(long j) {
        this.e = j;
    }

    public static String a(List<v5> list) {
        if (list == null || list.size() == 0) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        JSONArray jSONArray = new JSONArray();
        for (v5 v5Var : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mac", v5Var.a());
                jSONObject.put("major", v5Var.b());
                jSONObject.put("minor", v5Var.c());
                jSONObject.put("rssi", v5Var.d());
                jSONObject.put("time", v5Var.e() / 1000);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static v5 a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        boolean z;
        if (bluetoothDevice == null) {
            return null;
        }
        int i2 = 2;
        while (true) {
            if (i2 > 5) {
                z = false;
                break;
            } else if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            v5 v5Var = new v5();
            v5Var.a(((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255));
            v5Var.b(((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255));
            v5Var.c(i);
            v5Var.a(bluetoothDevice.getAddress().toUpperCase());
            v5Var.b(bluetoothDevice.getName());
            v5Var.a(System.currentTimeMillis());
            return v5Var;
        }
        return null;
    }
}