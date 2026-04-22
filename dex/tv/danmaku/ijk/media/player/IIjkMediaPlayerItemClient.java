package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IIjkMediaPlayerItemClient extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient";

    int addHdrVividMetadata(byte[] bArr, int i, long j) throws RemoteException;

    void onEventHandler(int i, int i2, int i3, long j, String str) throws RemoteException;

    boolean onNativeInvoke(int i, Bundle bundle) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IIjkMediaPlayerItemClient {
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        public boolean onNativeInvoke(int what, Bundle args) throws RemoteException {
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        public void onEventHandler(int what, int arg1, int arg2, long timestamp, String str) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
        public int addHdrVividMetadata(byte[] data, int size, long pts) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IIjkMediaPlayerItemClient {
        static final int TRANSACTION_addHdrVividMetadata = 3;
        static final int TRANSACTION_onEventHandler = 2;
        static final int TRANSACTION_onNativeInvoke = 1;

        public Stub() {
            attachInterface(this, IIjkMediaPlayerItemClient.DESCRIPTOR);
        }

        public static IIjkMediaPlayerItemClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIjkMediaPlayerItemClient.DESCRIPTOR);
            if (iin != null && (iin instanceof IIjkMediaPlayerItemClient)) {
                return (IIjkMediaPlayerItemClient) iin;
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
                data.enforceInterface(IIjkMediaPlayerItemClient.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IIjkMediaPlayerItemClient.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    Bundle _arg1 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    boolean onNativeInvoke = onNativeInvoke(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(onNativeInvoke ? 1 : 0);
                    _Parcel.writeTypedObject(reply, _arg1, 1);
                    break;
                case 2:
                    int _arg02 = data.readInt();
                    int _arg12 = data.readInt();
                    int _arg2 = data.readInt();
                    long _arg3 = data.readLong();
                    String _arg4 = data.readString();
                    onEventHandler(_arg02, _arg12, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    break;
                case 3:
                    byte[] _arg03 = data.createByteArray();
                    int _arg13 = data.readInt();
                    long _arg22 = data.readLong();
                    int _result = addHdrVividMetadata(_arg03, _arg13, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IIjkMediaPlayerItemClient {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIjkMediaPlayerItemClient.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
            public boolean onNativeInvoke(int what, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItemClient.DESCRIPTOR);
                    _data.writeInt(what);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    if (_reply.readInt() != 0) {
                        args.readFromParcel(_reply);
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
            public void onEventHandler(int what, int arg1, int arg2, long timestamp, String str) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItemClient.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    _data.writeLong(timestamp);
                    _data.writeString(str);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient
            public int addHdrVividMetadata(byte[] data, int size, long pts) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItemClient.DESCRIPTOR);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    _data.writeLong(pts);
                    this.mRemote.transact(3, _data, _reply, 0);
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