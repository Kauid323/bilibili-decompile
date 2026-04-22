package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* compiled from: TML */
public class j6 implements Parcelable {
    public static final Parcelable.Creator<j6> CREATOR = new a();
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f50c;
    public double d;
    public double e;
    public double f;
    public String g;
    public String h;

    public j6() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddressData{");
        sb.append("name=").append(this.a).append(",");
        sb.append("dtype=").append(this.b).append(",");
        sb.append("pointx=").append(this.d).append(",");
        sb.append("pointy=").append(this.e).append(",");
        sb.append("dist=").append(this.f).append(",");
        sb.append("direction=").append(this.g).append(",");
        sb.append("tag=").append(this.h).append(",");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f50c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public j6(JSONObject jSONObject) {
        this.a = jSONObject.optString(com.alipay.sdk.m.h.c.e);
        this.b = jSONObject.optString("dtype");
        this.f50c = jSONObject.optString("addr");
        this.d = jSONObject.optDouble("pointx");
        this.e = jSONObject.optDouble("pointy");
        this.f = jSONObject.optDouble("dist");
        this.g = jSONObject.optString("direction");
        this.h = jSONObject.optString("tag");
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Parcelable.Creator<j6> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public j6 createFromParcel(Parcel parcel) {
            j6 j6Var = new j6();
            j6Var.a = parcel.readString();
            j6Var.b = parcel.readString();
            j6Var.f50c = parcel.readString();
            j6Var.d = parcel.readDouble();
            j6Var.e = parcel.readDouble();
            j6Var.f = parcel.readDouble();
            j6Var.g = parcel.readString();
            j6Var.h = parcel.readString();
            return j6Var;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public j6[] newArray(int i) {
            return new j6[i];
        }
    }
}