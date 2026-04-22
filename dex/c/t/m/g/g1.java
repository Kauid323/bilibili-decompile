package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;

/* compiled from: TML */
public final class g1 implements IInterface {
    public IBinder a;
    public Context b;

    public g1(IBinder iBinder, Context context) {
        this.a = iBinder;
        this.b = context;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    public boolean e() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        boolean z = true;
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
        }
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    public String f() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            w3.a("HWIDInterface", "getID", th);
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    public String g() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            String string = Settings.Global.getString(this.b.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(this.b.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                if (!TextUtils.isEmpty(string2)) {
                    return "get oaid failed";
                }
            }
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return "get oaid failed";
        }
    }
}