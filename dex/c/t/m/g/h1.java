package c.t.m.g;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: TML */
public class h1 implements i1 {
    public IBinder a;

    public h1(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // c.t.m.g.i1
    public String b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Exception e) {
                w3.a("LenovoIDInterface", "a", e);
                obtain2.recycle();
                obtain.recycle();
                return null;
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // c.t.m.g.i1
    public boolean d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r2 = obtain2.readInt() != 0;
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
        return r2;
    }
}