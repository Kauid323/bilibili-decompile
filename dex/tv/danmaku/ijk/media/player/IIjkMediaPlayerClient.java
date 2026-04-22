package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IIjkMediaPlayerClient extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IIjkMediaPlayerClient";

    int onDownloadSeiDataWrite(byte[] bArr, int i, long j, long j2) throws RemoteException;

    int onDrmEvent(int i, Bundle bundle) throws RemoteException;

    void onEventHandler(int i, int i2, int i3, long j, Bundle bundle) throws RemoteException;

    int onFirstVideoRender() throws RemoteException;

    String onMediaCodecSelect(String str, int i, int i2) throws RemoteException;

    int onMetaDataWrite(byte[] bArr, int i, int i2, int i3, int i4) throws RemoteException;

    boolean onNativeInvoke(int i, Bundle bundle) throws RemoteException;

    int onRawDataWrite(byte[] bArr, int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void onReportAnr(int i) throws RemoteException;

    int onSeiDataWrite(byte[] bArr, int i, long j, long j2) throws RemoteException;

    void onSetDolbyModel(int i) throws RemoteException;

    int onVideoDisplay(double d, double d2) throws RemoteException;

    int onVideoPacketCallback(byte[] bArr, int i, long j, int i2) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IIjkMediaPlayerClient {
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public String onMediaCodecSelect(String mimeType, int profile, int level) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onRawDataWrite(byte[] data, int offset, int size, int freq, int channles, int samples) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDownloadSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onMetaDataWrite(byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public boolean onNativeInvoke(int what, Bundle args) throws RemoteException {
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onEventHandler(int what, int arg1, int arg2, long timestamp, Bundle args) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onReportAnr(int what) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoPacketCallback(byte[] au_buf, int size, long timeUs, int flag) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public void onSetDolbyModel(int model) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onVideoDisplay(double pts, double duration) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onFirstVideoRender() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
        public int onDrmEvent(int event, Bundle args) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IIjkMediaPlayerClient {
        static final int TRANSACTION_onDownloadSeiDataWrite = 4;
        static final int TRANSACTION_onDrmEvent = 13;
        static final int TRANSACTION_onEventHandler = 7;
        static final int TRANSACTION_onFirstVideoRender = 12;
        static final int TRANSACTION_onMediaCodecSelect = 1;
        static final int TRANSACTION_onMetaDataWrite = 5;
        static final int TRANSACTION_onNativeInvoke = 6;
        static final int TRANSACTION_onRawDataWrite = 2;
        static final int TRANSACTION_onReportAnr = 8;
        static final int TRANSACTION_onSeiDataWrite = 3;
        static final int TRANSACTION_onSetDolbyModel = 10;
        static final int TRANSACTION_onVideoDisplay = 11;
        static final int TRANSACTION_onVideoPacketCallback = 9;

        public Stub() {
            attachInterface(this, IIjkMediaPlayerClient.DESCRIPTOR);
        }

        public static IIjkMediaPlayerClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIjkMediaPlayerClient.DESCRIPTOR);
            if (iin != null && (iin instanceof IIjkMediaPlayerClient)) {
                return (IIjkMediaPlayerClient) iin;
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
                data.enforceInterface(IIjkMediaPlayerClient.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IIjkMediaPlayerClient.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    String _result = onMediaCodecSelect(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeString(_result);
                    break;
                case 2:
                    byte[] _arg02 = data.createByteArray();
                    int _arg12 = data.readInt();
                    int _arg22 = data.readInt();
                    int _arg3 = data.readInt();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    int _result2 = onRawDataWrite(_arg02, _arg12, _arg22, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    break;
                case 3:
                    byte[] _arg03 = data.createByteArray();
                    int _arg13 = data.readInt();
                    long _arg23 = data.readLong();
                    long _arg32 = data.readLong();
                    int _result3 = onSeiDataWrite(_arg03, _arg13, _arg23, _arg32);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    break;
                case 4:
                    byte[] _arg04 = data.createByteArray();
                    int _arg14 = data.readInt();
                    long _arg24 = data.readLong();
                    long _arg33 = data.readLong();
                    int _result4 = onDownloadSeiDataWrite(_arg04, _arg14, _arg24, _arg33);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    break;
                case 5:
                    byte[] _arg05 = data.createByteArray();
                    int _arg15 = data.readInt();
                    int _arg25 = data.readInt();
                    int _arg34 = data.readInt();
                    int _arg42 = data.readInt();
                    int _result5 = onMetaDataWrite(_arg05, _arg15, _arg25, _arg34, _arg42);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    break;
                case 6:
                    int _arg06 = data.readInt();
                    Bundle _arg16 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    boolean onNativeInvoke = onNativeInvoke(_arg06, _arg16);
                    reply.writeNoException();
                    reply.writeInt(onNativeInvoke ? 1 : 0);
                    _Parcel.writeTypedObject(reply, _arg16, 1);
                    break;
                case 7:
                    int _arg07 = data.readInt();
                    int _arg17 = data.readInt();
                    int _arg26 = data.readInt();
                    long _arg35 = data.readLong();
                    Bundle _arg43 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    onEventHandler(_arg07, _arg17, _arg26, _arg35, _arg43);
                    reply.writeNoException();
                    break;
                case 8:
                    int _arg08 = data.readInt();
                    onReportAnr(_arg08);
                    reply.writeNoException();
                    break;
                case 9:
                    byte[] _arg09 = data.createByteArray();
                    int _arg18 = data.readInt();
                    long _arg27 = data.readLong();
                    int _arg36 = data.readInt();
                    int _result6 = onVideoPacketCallback(_arg09, _arg18, _arg27, _arg36);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    break;
                case 10:
                    int _arg010 = data.readInt();
                    onSetDolbyModel(_arg010);
                    reply.writeNoException();
                    break;
                case 11:
                    double _arg011 = data.readDouble();
                    double _arg19 = data.readDouble();
                    int _result7 = onVideoDisplay(_arg011, _arg19);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    break;
                case 12:
                    int _result8 = onFirstVideoRender();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    break;
                case 13:
                    int _arg012 = data.readInt();
                    Bundle _arg110 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
                    int _result9 = onDrmEvent(_arg012, _arg110);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IIjkMediaPlayerClient {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIjkMediaPlayerClient.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public String onMediaCodecSelect(String mimeType, int profile, int level) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeString(mimeType);
                    _data.writeInt(profile);
                    _data.writeInt(level);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onRawDataWrite(byte[] data, int offset, int size, int freq, int channles, int samples) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeByteArray(data);
                    _data.writeInt(offset);
                    _data.writeInt(size);
                    _data.writeInt(freq);
                    _data.writeInt(channles);
                    _data.writeInt(samples);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    _data.writeLong(decodeTimestamp);
                    _data.writeLong(presentationTimestamp);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onDownloadSeiDataWrite(byte[] data, int size, long decodeTimestamp, long presentationTimestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    _data.writeLong(decodeTimestamp);
                    _data.writeLong(presentationTimestamp);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onMetaDataWrite(byte[] data, int size, int colorSpace, int colorRange, int colorTransfer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeByteArray(data);
                    _data.writeInt(size);
                    _data.writeInt(colorSpace);
                    _data.writeInt(colorRange);
                    _data.writeInt(colorTransfer);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public boolean onNativeInvoke(int what, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeInt(what);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(6, _data, _reply, 0);
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

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public void onEventHandler(int what, int arg1, int arg2, long timestamp, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    _data.writeLong(timestamp);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public void onReportAnr(int what) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onVideoPacketCallback(byte[] au_buf, int size, long timeUs, int flag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeByteArray(au_buf);
                    _data.writeInt(size);
                    _data.writeLong(timeUs);
                    _data.writeInt(flag);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public void onSetDolbyModel(int model) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeInt(model);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onVideoDisplay(double pts, double duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeDouble(pts);
                    _data.writeDouble(duration);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onFirstVideoRender() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayerClient
            public int onDrmEvent(int event, Bundle args) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayerClient.DESCRIPTOR);
                    _data.writeInt(event);
                    _Parcel.writeTypedObject(_data, args, 0);
                    this.mRemote.transact(13, _data, _reply, 0);
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