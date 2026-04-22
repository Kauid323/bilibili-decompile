package c.t.m.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* compiled from: TML */
public final class f1 implements IInterface {
    public IBinder a;

    public f1(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    public String e() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            w3.a("ASUSIDInterface", "getID", th);
            str = "get oaid failed";
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    public boolean f() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } catch (Exception e) {
            obtain2.recycle();
            obtain.recycle();
            return false;
        }
    }
}