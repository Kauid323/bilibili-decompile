package video.biz.offline.base.facade.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import video.biz.offline.base.facade.client.IOfflineClient;

public interface IOfflineService extends IInterface {
    public static final String DESCRIPTOR = "video.biz.offline.base.facade.service.IOfflineService";

    void addDownload(String str) throws RemoteException;

    int getCurrentTaskCount() throws RemoteException;

    List<String> getDownloadingKeys() throws RemoteException;

    void registerClient(IOfflineClient iOfflineClient) throws RemoteException;

    void setMaxConcurrent(int i, List<String> list) throws RemoteException;

    void stopAll() throws RemoteException;

    void stopDownload(List<String> list, boolean z) throws RemoteException;

    void unregisterClient(IOfflineClient iOfflineClient) throws RemoteException;

    void updateDanmaku(String str) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IOfflineService {
        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void registerClient(IOfflineClient callback) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void unregisterClient(IOfflineClient callback) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void addDownload(String videos) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void stopDownload(List<String> keys, boolean isRemove) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void stopAll() throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void setMaxConcurrent(int max, List<String> keys) throws RemoteException {
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public List<String> getDownloadingKeys() throws RemoteException {
            return null;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public int getCurrentTaskCount() throws RemoteException {
            return 0;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void updateDanmaku(String videos) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IOfflineService {
        static final int TRANSACTION_addDownload = 3;
        static final int TRANSACTION_getCurrentTaskCount = 8;
        static final int TRANSACTION_getDownloadingKeys = 7;
        static final int TRANSACTION_registerClient = 1;
        static final int TRANSACTION_setMaxConcurrent = 6;
        static final int TRANSACTION_stopAll = 5;
        static final int TRANSACTION_stopDownload = 4;
        static final int TRANSACTION_unregisterClient = 2;
        static final int TRANSACTION_updateDanmaku = 9;

        public Stub() {
            attachInterface(this, IOfflineService.DESCRIPTOR);
        }

        public static IOfflineService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOfflineService.DESCRIPTOR);
            if (iin != null && (iin instanceof IOfflineService)) {
                return (IOfflineService) iin;
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
                data.enforceInterface(IOfflineService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IOfflineService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    IOfflineClient _arg0 = IOfflineClient.Stub.asInterface(data.readStrongBinder());
                    registerClient(_arg0);
                    reply.writeNoException();
                    break;
                case 2:
                    IOfflineClient _arg02 = IOfflineClient.Stub.asInterface(data.readStrongBinder());
                    unregisterClient(_arg02);
                    reply.writeNoException();
                    break;
                case 3:
                    String _arg03 = data.readString();
                    addDownload(_arg03);
                    reply.writeNoException();
                    break;
                case 4:
                    List<String> _arg04 = data.createStringArrayList();
                    boolean _arg1 = data.readInt() != 0;
                    stopDownload(_arg04, _arg1);
                    reply.writeNoException();
                    break;
                case 5:
                    stopAll();
                    reply.writeNoException();
                    break;
                case 6:
                    int _arg05 = data.readInt();
                    List<String> _arg12 = data.createStringArrayList();
                    setMaxConcurrent(_arg05, _arg12);
                    reply.writeNoException();
                    break;
                case 7:
                    List<String> _result = getDownloadingKeys();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    break;
                case 8:
                    int _result2 = getCurrentTaskCount();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    break;
                case 9:
                    String _arg06 = data.readString();
                    updateDanmaku(_arg06);
                    reply.writeNoException();
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IOfflineService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOfflineService.DESCRIPTOR;
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void registerClient(IOfflineClient callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void unregisterClient(IOfflineClient callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void addDownload(String videos) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeString(videos);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void stopDownload(List<String> keys, boolean isRemove) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeStringList(keys);
                    _data.writeInt(isRemove ? 1 : 0);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void stopAll() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void setMaxConcurrent(int max, List<String> keys) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeInt(max);
                    _data.writeStringList(keys);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public List<String> getDownloadingKeys() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public int getCurrentTaskCount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // video.biz.offline.base.facade.service.IOfflineService
            public void updateDanmaku(String videos) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOfflineService.DESCRIPTOR);
                    _data.writeString(videos);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}