package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IAbrParamsInterface extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IAbrParamsInterface";

    int getAbrParamInt(int i) throws RemoteException;

    void updateDynamicAbrParams(Bundle bundle) throws RemoteException;

    void updateExperimentalGroup(Bundle bundle) throws RemoteException;

    void updateOnlineConfigBundle(Bundle bundle) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IAbrParamsInterface {
        @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
        public void updateOnlineConfigBundle(Bundle configBundle) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
        public void updateExperimentalGroup(Bundle expBundle) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
        public void updateDynamicAbrParams(Bundle params) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
        public int getAbrParamInt(int type) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IAbrParamsInterface {
        static final int TRANSACTION_getAbrParamInt = 4;
        static final int TRANSACTION_updateDynamicAbrParams = 3;
        static final int TRANSACTION_updateExperimentalGroup = 2;
        static final int TRANSACTION_updateOnlineConfigBundle = 1;

        public Stub() {
            attachInterface(this, IAbrParamsInterface.DESCRIPTOR);
        }

        public static IAbrParamsInterface asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAbrParamsInterface.DESCRIPTOR);
            if (iin != null && (iin instanceof IAbrParamsInterface)) {
                return (IAbrParamsInterface) iin;
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
                data.enforceInterface(IAbrParamsInterface.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IAbrParamsInterface.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    Bundle _arg0 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    updateOnlineConfigBundle(_arg0);
                    reply.writeNoException();
                    break;
                case 2:
                    Bundle _arg02 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    updateExperimentalGroup(_arg02);
                    reply.writeNoException();
                    break;
                case 3:
                    Bundle _arg03 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    updateDynamicAbrParams(_arg03);
                    reply.writeNoException();
                    break;
                case 4:
                    int _arg04 = data.readInt();
                    int _result = getAbrParamInt(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IAbrParamsInterface {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAbrParamsInterface.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
            public void updateOnlineConfigBundle(Bundle configBundle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAbrParamsInterface.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, configBundle, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
            public void updateExperimentalGroup(Bundle expBundle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAbrParamsInterface.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, expBundle, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
            public void updateDynamicAbrParams(Bundle params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAbrParamsInterface.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, params, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
            public int getAbrParamInt(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAbrParamsInterface.DESCRIPTOR);
                    _data.writeInt(type);
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