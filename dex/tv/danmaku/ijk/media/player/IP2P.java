package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IP2P extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IP2P";

    int getHttpServerPort() throws RemoteException;

    ParcelFileDescriptor[] getTrackerChannelFd() throws RemoteException;

    void nofityNetWorkChange(int i, int i2) throws RemoteException;

    void notifyConfigChange(Bundle bundle) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IP2P {
        @Override // tv.danmaku.ijk.media.player.IP2P
        public void nofityNetWorkChange(int newType, int oldType) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IP2P
        public void notifyConfigChange(Bundle config) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IP2P
        public ParcelFileDescriptor[] getTrackerChannelFd() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IP2P
        public int getHttpServerPort() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IP2P {
        static final int TRANSACTION_getHttpServerPort = 4;
        static final int TRANSACTION_getTrackerChannelFd = 3;
        static final int TRANSACTION_nofityNetWorkChange = 1;
        static final int TRANSACTION_notifyConfigChange = 2;

        public Stub() {
            attachInterface(this, IP2P.DESCRIPTOR);
        }

        public static IP2P asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IP2P.DESCRIPTOR);
            if (iin != null && (iin instanceof IP2P)) {
                return (IP2P) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IP2P.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IP2P.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    nofityNetWorkChange(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                case 2:
                    Bundle _arg02 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    notifyConfigChange(_arg02);
                    reply.writeNoException();
                    break;
                case 3:
                    ParcelFileDescriptor[] _result = getTrackerChannelFd();
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    break;
                case 4:
                    int _result2 = getHttpServerPort();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IP2P {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IP2P.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IP2P
            public void nofityNetWorkChange(int newType, int oldType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IP2P.DESCRIPTOR);
                    _data.writeInt(newType);
                    _data.writeInt(oldType);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IP2P
            public void notifyConfigChange(Bundle config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IP2P.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, config, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IP2P
            public ParcelFileDescriptor[] getTrackerChannelFd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IP2P.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    ParcelFileDescriptor[] _result = (ParcelFileDescriptor[]) _reply.createTypedArray(ParcelFileDescriptor.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IP2P
            public int getHttpServerPort() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IP2P.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> c) {
            if (parcel.readInt() != 0) {
                return c.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T value, int parcelableFlags) {
            if (value != null) {
                parcel.writeInt(1);
                value.writeToParcel(parcel, parcelableFlags);
                return;
            }
            parcel.writeInt(0);
        }
    }
}