package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import tv.danmaku.ijk.media.player.IAbrParamsInterface;
import tv.danmaku.ijk.media.player.IIjkMediaPlayer;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerClient;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItemClient;
import tv.danmaku.ijk.media.player.IP2P;

public interface IIjkMediaPlayerService extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IIjkMediaPlayerService";

    IIjkMediaPlayer create(int i, IIjkMediaPlayerClient iIjkMediaPlayerClient) throws RemoteException;

    IAbrParamsInterface createAbrParamsInterface() throws RemoteException;

    IIjkMediaPlayerItem createItem(int i, IIjkMediaPlayerItemClient iIjkMediaPlayerItemClient) throws RemoteException;

    IP2P createP2P(Bundle bundle) throws RemoteException;

    void removeClient(int i) throws RemoteException;

    void removeItemClient(int i) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IIjkMediaPlayerService {
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IIjkMediaPlayer create(int connId, IIjkMediaPlayerClient client) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IIjkMediaPlayerItem createItem(int connId, IIjkMediaPlayerItemClient itemClient) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IP2P createP2P(Bundle config) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public IAbrParamsInterface createAbrParamsInterface() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public void removeClient(int connId) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
        public void removeItemClient(int connId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IIjkMediaPlayerService {
        static final int TRANSACTION_create = 1;
        static final int TRANSACTION_createAbrParamsInterface = 4;
        static final int TRANSACTION_createItem = 2;
        static final int TRANSACTION_createP2P = 3;
        static final int TRANSACTION_removeClient = 5;
        static final int TRANSACTION_removeItemClient = 6;

        public Stub() {
            attachInterface(this, IIjkMediaPlayerService.DESCRIPTOR);
        }

        public static IIjkMediaPlayerService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIjkMediaPlayerService.DESCRIPTOR);
            if (iin != null && (iin instanceof IIjkMediaPlayerService)) {
                return (IIjkMediaPlayerService) iin;
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
                data.enforceInterface(IIjkMediaPlayerService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IIjkMediaPlayerService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    IIjkMediaPlayerClient _arg1 = IIjkMediaPlayerClient.Stub.asInterface(data.readStrongBinder());
                    IIjkMediaPlayer _result = create(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result);
                    break;
                case 2:
                    int _arg02 = data.readInt();
                    IIjkMediaPlayerItemClient _arg12 = IIjkMediaPlayerItemClient.Stub.asInterface(data.readStrongBinder());
                    IIjkMediaPlayerItem _result2 = createItem(_arg02, _arg12);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result2);
                    break;
                case 3:
                    Bundle _arg03 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    IP2P _result3 = createP2P(_arg03);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result3);
                    break;
                case 4:
                    IAbrParamsInterface _result4 = createAbrParamsInterface();
                    reply.writeNoException();
                    reply.writeStrongInterface(_result4);
                    break;
                case 5:
                    int _arg04 = data.readInt();
                    removeClient(_arg04);
                    reply.writeNoException();
                    break;
                case 6:
                    int _arg05 = data.readInt();
                    removeItemClient(_arg05);
                    reply.writeNoException();
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static class Proxy implements IIjkMediaPlayerService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIjkMediaPlayerService.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public IIjkMediaPlayer create(int connId, IIjkMediaPlayerClient client) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    _data.writeInt(connId);
                    _data.writeStrongInterface(client);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    IIjkMediaPlayer _result = IIjkMediaPlayer.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public IIjkMediaPlayerItem createItem(int connId, IIjkMediaPlayerItemClient itemClient) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    _data.writeInt(connId);
                    _data.writeStrongInterface(itemClient);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    IIjkMediaPlayerItem _result = IIjkMediaPlayerItem.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public IP2P createP2P(Bundle config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, config, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    IP2P _result = IP2P.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public IAbrParamsInterface createAbrParamsInterface() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    IAbrParamsInterface _result = IAbrParamsInterface.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public void removeClient(int connId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    _data.writeInt(connId);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerService
            public void removeItemClient(int connId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerService.DESCRIPTOR);
                    _data.writeInt(connId);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
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