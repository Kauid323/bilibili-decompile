package video.biz.offline.base.facade.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOfflineClient extends IInterface {
    public static final String DESCRIPTOR = "video.biz.offline.base.facade.client.IOfflineClient";

    void onDownloadComplete(String str) throws RemoteException;

    void onDownloadError(String str) throws RemoteException;

    void onServiceTimeout(int i, int i2) throws RemoteException;

    void onUpdateVideo(String str, boolean z) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IOfflineClient {
        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onUpdateVideo(String entryList, boolean forceUpdate) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onDownloadComplete(String entryList) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onDownloadError(String entryList) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onServiceTimeout(int startId, int fgsType) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IOfflineClient {
        static final int TRANSACTION_onDownloadComplete = 2;
        static final int TRANSACTION_onDownloadError = 3;
        static final int TRANSACTION_onServiceTimeout = 4;
        static final int TRANSACTION_onUpdateVideo = 1;

        public Stub() {
            attachInterface(this, IOfflineClient.DESCRIPTOR);
        }

        public static IOfflineClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOfflineClient.DESCRIPTOR);
            if (iin != null && (iin instanceof IOfflineClient)) {
                return (IOfflineClient) iin;
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
                data.enforceInterface(IOfflineClient.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IOfflineClient.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    boolean _arg1 = data.readInt() != 0;
                    onUpdateVideo(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                case 2:
                    String _arg02 = data.readString();
                    onDownloadComplete(_arg02);
                    reply.writeNoException();
                    break;
                case 3:
                    String _arg03 = data.readString();
                    onDownloadError(_arg03);
                    reply.writeNoException();
                    break;
                case 4:
                    int _arg04 = data.readInt();
                    int _arg12 = data.readInt();
                    onServiceTimeout(_arg04, _arg12);
                    reply.writeNoException();
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IOfflineClient {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOfflineClient.DESCRIPTOR;
            }

            @Override // video.biz.offline.base.facade.client.IOfflineClient
            public void onUpdateVideo(String entryList, boolean forceUpdate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineClient.DESCRIPTOR);
                    _data.writeString(entryList);
                    _data.writeInt(forceUpdate ? 1 : 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.client.IOfflineClient
            public void onDownloadComplete(String entryList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineClient.DESCRIPTOR);
                    _data.writeString(entryList);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.client.IOfflineClient
            public void onDownloadError(String entryList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineClient.DESCRIPTOR);
                    _data.writeString(entryList);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.client.IOfflineClient
            public void onServiceTimeout(int startId, int fgsType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineClient.DESCRIPTOR);
                    _data.writeInt(startId);
                    _data.writeInt(fgsType);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}