package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public interface IIjkMediaPlayerItem extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IIjkMediaPlayerItem";

    long getPlayableDuration() throws RemoteException;

    void getPropBundle(int i, Bundle bundle) throws RemoteException;

    Bundle getPropertiesBundle(int[] iArr) throws RemoteException;

    float getPropertyFloat(int i, float f) throws RemoteException;

    long getPropertyLong(int i, long j) throws RemoteException;

    String getPropertyString(int i) throws RemoteException;

    void ioInterrupt(int i) throws RemoteException;

    boolean isEqualsToInternal(String str) throws RemoteException;

    void release() throws RemoteException;

    void reset() throws RemoteException;

    void setDataSource(String str) throws RemoteException;

    void setDataSourceFd(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void setDataSourceJson(String[] strArr, int i, int i2) throws RemoteException;

    void setMultiAudioStream(String[] strArr) throws RemoteException;

    void setOptionBundle(int i, Bundle bundle) throws RemoteException;

    void setOptionLong(int i, String str, long j) throws RemoteException;

    void setOptionString(int i, String str, String str2) throws RemoteException;

    void setPropertyFloat(int i, float f) throws RemoteException;

    void setPropertyLong(int i, long j) throws RemoteException;

    void setPropertyString(int i, String str) throws RemoteException;

    void start() throws RemoteException;

    void stop() throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IIjkMediaPlayerItem {
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void start() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void ioInterrupt(int interrupt) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void stop() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void reset() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void release() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setDataSource(String path) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setDataSourceFd(ParcelFileDescriptor fd) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setDataSourceJson(String[] args, int defaultAudioId, int defaultVideoId) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setMultiAudioStream(String[] urls) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public long getPlayableDuration() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public float getPropertyFloat(int property, float defaultValue) throws RemoteException {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setPropertyFloat(int property, float value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public long getPropertyLong(int property, long defaultValue) throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setPropertyLong(int property, long value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setOptionString(int category, String name, String value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setOptionLong(int category, String name, long value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setOptionBundle(int category, Bundle args) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public boolean isEqualsToInternal(String name) throws RemoteException {
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public Bundle getPropertiesBundle(int[] keys) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public String getPropertyString(int propId) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void getPropBundle(int propId, Bundle args) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
        public void setPropertyString(int property, String value) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IIjkMediaPlayerItem {
        static final int TRANSACTION_getPlayableDuration = 10;
        static final int TRANSACTION_getPropBundle = 21;
        static final int TRANSACTION_getPropertiesBundle = 19;
        static final int TRANSACTION_getPropertyFloat = 11;
        static final int TRANSACTION_getPropertyLong = 13;
        static final int TRANSACTION_getPropertyString = 20;
        static final int TRANSACTION_ioInterrupt = 2;
        static final int TRANSACTION_isEqualsToInternal = 18;
        static final int TRANSACTION_release = 5;
        static final int TRANSACTION_reset = 4;
        static final int TRANSACTION_setDataSource = 6;
        static final int TRANSACTION_setDataSourceFd = 7;
        static final int TRANSACTION_setDataSourceJson = 8;
        static final int TRANSACTION_setMultiAudioStream = 9;
        static final int TRANSACTION_setOptionBundle = 17;
        static final int TRANSACTION_setOptionLong = 16;
        static final int TRANSACTION_setOptionString = 15;
        static final int TRANSACTION_setPropertyFloat = 12;
        static final int TRANSACTION_setPropertyLong = 14;
        static final int TRANSACTION_setPropertyString = 22;
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_stop = 3;

        public Stub() {
            attachInterface(this, IIjkMediaPlayerItem.DESCRIPTOR);
        }

        public static IIjkMediaPlayerItem asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIjkMediaPlayerItem.DESCRIPTOR);
            if (iin != null && (iin instanceof IIjkMediaPlayerItem)) {
                return (IIjkMediaPlayerItem) iin;
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
                data.enforceInterface(IIjkMediaPlayerItem.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IIjkMediaPlayerItem.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    start();
                    reply.writeNoException();
                    break;
                case 2:
                    int _arg0 = data.readInt();
                    ioInterrupt(_arg0);
                    reply.writeNoException();
                    break;
                case 3:
                    stop();
                    reply.writeNoException();
                    break;
                case 4:
                    reset();
                    reply.writeNoException();
                    break;
                case 5:
                    release();
                    reply.writeNoException();
                    break;
                case 6:
                    String _arg02 = data.readString();
                    setDataSource(_arg02);
                    reply.writeNoException();
                    break;
                case 7:
                    ParcelFileDescriptor _arg03 = (ParcelFileDescriptor) _Parcel.readTypedObject(data, ParcelFileDescriptor.CREATOR);
                    setDataSourceFd(_arg03);
                    reply.writeNoException();
                    break;
                case 8:
                    String[] _arg04 = data.createStringArray();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    setDataSourceJson(_arg04, _arg1, _arg2);
                    reply.writeNoException();
                    break;
                case 9:
                    String[] _arg05 = data.createStringArray();
                    setMultiAudioStream(_arg05);
                    reply.writeNoException();
                    break;
                case 10:
                    long _result = getPlayableDuration();
                    reply.writeNoException();
                    reply.writeLong(_result);
                    break;
                case 11:
                    int _arg06 = data.readInt();
                    float _arg12 = data.readFloat();
                    float _result2 = getPropertyFloat(_arg06, _arg12);
                    reply.writeNoException();
                    reply.writeFloat(_result2);
                    break;
                case 12:
                    int _arg07 = data.readInt();
                    float _arg13 = data.readFloat();
                    setPropertyFloat(_arg07, _arg13);
                    reply.writeNoException();
                    break;
                case 13:
                    int _arg08 = data.readInt();
                    long _arg14 = data.readLong();
                    long _result3 = getPropertyLong(_arg08, _arg14);
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    break;
                case 14:
                    int _arg09 = data.readInt();
                    long _arg15 = data.readLong();
                    setPropertyLong(_arg09, _arg15);
                    reply.writeNoException();
                    break;
                case 15:
                    int _arg010 = data.readInt();
                    String _arg16 = data.readString();
                    String _arg22 = data.readString();
                    setOptionString(_arg010, _arg16, _arg22);
                    reply.writeNoException();
                    break;
                case 16:
                    int _arg011 = data.readInt();
                    String _arg17 = data.readString();
                    long _arg23 = data.readLong();
                    setOptionLong(_arg011, _arg17, _arg23);
                    reply.writeNoException();
                    break;
                case 17:
                    int _arg012 = data.readInt();
                    Bundle _arg18 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    setOptionBundle(_arg012, _arg18);
                    reply.writeNoException();
                    break;
                case 18:
                    String _arg013 = data.readString();
                    boolean isEqualsToInternal = isEqualsToInternal(_arg013);
                    reply.writeNoException();
                    reply.writeInt(isEqualsToInternal ? 1 : 0);
                    break;
                case 19:
                    int[] _arg014 = data.createIntArray();
                    Bundle _result4 = getPropertiesBundle(_arg014);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result4, 1);
                    break;
                case 20:
                    int _arg015 = data.readInt();
                    String _result5 = getPropertyString(_arg015);
                    reply.writeNoException();
                    reply.writeString(_result5);
                    break;
                case 21:
                    int _arg016 = data.readInt();
                    Bundle _arg19 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    getPropBundle(_arg016, _arg19);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _arg19, 1);
                    break;
                case 22:
                    int _arg017 = data.readInt();
                    String _arg110 = data.readString();
                    setPropertyString(_arg017, _arg110);
                    reply.writeNoException();
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IIjkMediaPlayerItem {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIjkMediaPlayerItem.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void start() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void ioInterrupt(int interrupt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(interrupt);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void stop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void reset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void release() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setDataSource(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setDataSourceFd(ParcelFileDescriptor fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, fd, 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setDataSourceJson(String[] args, int defaultAudioId, int defaultVideoId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeStringArray(args);
                    _data.writeInt(defaultAudioId);
                    _data.writeInt(defaultVideoId);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setMultiAudioStream(String[] urls) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeStringArray(urls);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public long getPlayableDuration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public float getPropertyFloat(int property, float defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeFloat(defaultValue);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    float _result = _reply.readFloat();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setPropertyFloat(int property, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeFloat(value);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public long getPropertyLong(int property, long defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeLong(defaultValue);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setPropertyLong(int property, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeLong(value);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setOptionString(int category, String name, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(category);
                    _data.writeString(name);
                    _data.writeString(value);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setOptionLong(int category, String name, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(category);
                    _data.writeString(name);
                    _data.writeLong(value);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setOptionBundle(int category, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(category);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public boolean isEqualsToInternal(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeString(name);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    boolean _status = _reply.readInt() != 0;
                    return _status;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public Bundle getPropertiesBundle(int[] keys) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeIntArray(keys);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public String getPropertyString(int propId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(propId);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void getPropBundle(int propId, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(propId);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        args.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerItem
            public void setPropertyString(int property, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerItem.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeString(value);
                    this.mRemote.transact(22, _data, _reply, 0);
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