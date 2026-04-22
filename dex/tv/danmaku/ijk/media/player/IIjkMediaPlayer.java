package tv.danmaku.ijk.media.player;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.Surface;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.IIjkMediaPlayerItem;

public interface IIjkMediaPlayer extends IInterface {
    public static final String DESCRIPTOR = "tv.danmaku.ijk.media.player.IIjkMediaPlayer";

    void SamplePerformance() throws RemoteException;

    int addFrameOutputTask(String str, long j, int i, int i2, int i3, int i4) throws RemoteException;

    long getAndroidIOTrafficStatistic() throws RemoteException;

    String getAudioCodecInfo() throws RemoteException;

    int getAudioSessionId() throws RemoteException;

    int[] getAudioStreamsIndex() throws RemoteException;

    String getColorFormatName(int i) throws RemoteException;

    int getCurrentAudioIndex() throws RemoteException;

    long getCurrentPosition() throws RemoteException;

    Bundle getDashStreamInfo() throws RemoteException;

    int getDefaultAudioIndex() throws RemoteException;

    long getDuration() throws RemoteException;

    int getLoopCount() throws RemoteException;

    Bundle getMediaMeta() throws RemoteException;

    Bundle getPropertiesBundle(int[] iArr) throws RemoteException;

    float getPropertyFloat(int i, float f) throws RemoteException;

    long getPropertyLong(int i, long j) throws RemoteException;

    String getPropertyString(int i) throws RemoteException;

    double getSampleCpu() throws RemoteException;

    long getSampleMemory() throws RemoteException;

    long getSampleThread() throws RemoteException;

    Bundle getSampleThreadRecord() throws RemoteException;

    Bundle getSurfaceSize() throws RemoteException;

    String getVersion() throws RemoteException;

    String getVideoCodecInfo() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void nativeFinalize() throws RemoteException;

    void nativeProfileBegin(String str) throws RemoteException;

    void nativeProfileEnd() throws RemoteException;

    void nativeSetLogLevel(int i) throws RemoteException;

    void pause() throws RemoteException;

    void prepareAsync() throws RemoteException;

    void release() throws RemoteException;

    void reset() throws RemoteException;

    void seekTo(long j, int i) throws RemoteException;

    void setAndroidIOCallback() throws RemoteException;

    void setAuto(boolean z) throws RemoteException;

    void setDataSource(String str) throws RemoteException;

    void setDataSourceBase64(String str) throws RemoteException;

    void setDataSourceFd(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void setDataSourceKey(String str, String[] strArr, String[] strArr2) throws RemoteException;

    void setExternalRenderInternalSurface(Surface surface) throws RemoteException;

    void setExternalRenderSurface(Surface surface, Surface surface2) throws RemoteException;

    void setIjkMediaPlayerItem(IIjkMediaPlayerItem iIjkMediaPlayerItem) throws RemoteException;

    void setLoopCount(int i) throws RemoteException;

    void setOptionLong(int i, String str, long j) throws RemoteException;

    void setOptionString(int i, String str, String str2) throws RemoteException;

    void setPropertyFloat(int i, float f) throws RemoteException;

    void setPropertyLong(int i, long j) throws RemoteException;

    void setProtectDelay(int i) throws RemoteException;

    void setStreamSelected(int i, boolean z) throws RemoteException;

    void setSurface(Surface surface) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    void start() throws RemoteException;

    void stop() throws RemoteException;

    int switchAudioStream(int i) throws RemoteException;

    void switchDashAudioStream(int i) throws RemoteException;

    void switchDashVideoStream(int i) throws RemoteException;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Default implements IIjkMediaPlayer {
        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void start() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void pause() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void stop() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void release() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void reset() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setSurface(Surface surface) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setExternalRenderInternalSurface(Surface internal) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setExternalRenderSurface(Surface avcSurface, Surface amcSurface) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setDataSource(String path) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setDataSourceBase64(String path) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setDataSourceKey(String path, String[] keys, String[] values) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setDataSourceFd(ParcelFileDescriptor fd) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setIjkMediaPlayerItem(IIjkMediaPlayerItem item) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void prepareAsync() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setStreamSelected(int stream, boolean select) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public boolean isPlaying() throws RemoteException {
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void seekTo(long msec, int flag) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getCurrentPosition() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getDuration() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setLoopCount(int loopCount) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int getLoopCount() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public float getPropertyFloat(int property, float defaultValue) throws RemoteException {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setPropertyFloat(int property, float value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getPropertyLong(int property, long defaultValue) throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setPropertyLong(int property, long value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setVolume(float leftVolume, float rightVolume) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int getAudioSessionId() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public String getVideoCodecInfo() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public String getAudioCodecInfo() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setOptionString(int category, String name, String value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setOptionLong(int category, String name, long value) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public Bundle getMediaMeta() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public Bundle getDashStreamInfo() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void nativeFinalize() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public String getColorFormatName(int mediaCodecColorFormat) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void nativeProfileBegin(String libName) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void nativeProfileEnd() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void nativeSetLogLevel(int level) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setAndroidIOCallback() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getAndroidIOTrafficStatistic() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int addFrameOutputTask(String imgCachePath, long startTime, int frame_interval, int count, int imgDefinition, int frameType) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void switchDashVideoStream(int id) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void switchDashAudioStream(int id) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setAuto(boolean flag) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void SamplePerformance() throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public double getSampleCpu() throws RemoteException {
            return 0.0d;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getSampleThread() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public long getSampleMemory() throws RemoteException {
            return 0L;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public Bundle getSampleThreadRecord() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public void setProtectDelay(int protectDelay) throws RemoteException {
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public Bundle getSurfaceSize() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public Bundle getPropertiesBundle(int[] keys) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public String getVersion() throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public String getPropertyString(int key) throws RemoteException {
            return null;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int getDefaultAudioIndex() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int getCurrentAudioIndex() throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int switchAudioStream(int index) throws RemoteException {
            return 0;
        }

        @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
        public int[] getAudioStreamsIndex() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Stub extends Binder implements IIjkMediaPlayer {
        static final int TRANSACTION_SamplePerformance = 45;
        static final int TRANSACTION_addFrameOutputTask = 41;
        static final int TRANSACTION_getAndroidIOTrafficStatistic = 40;
        static final int TRANSACTION_getAudioCodecInfo = 29;
        static final int TRANSACTION_getAudioSessionId = 27;
        static final int TRANSACTION_getAudioStreamsIndex = 58;
        static final int TRANSACTION_getColorFormatName = 35;
        static final int TRANSACTION_getCurrentAudioIndex = 56;
        static final int TRANSACTION_getCurrentPosition = 18;
        static final int TRANSACTION_getDashStreamInfo = 33;
        static final int TRANSACTION_getDefaultAudioIndex = 55;
        static final int TRANSACTION_getDuration = 19;
        static final int TRANSACTION_getLoopCount = 21;
        static final int TRANSACTION_getMediaMeta = 32;
        static final int TRANSACTION_getPropertiesBundle = 52;
        static final int TRANSACTION_getPropertyFloat = 22;
        static final int TRANSACTION_getPropertyLong = 24;
        static final int TRANSACTION_getPropertyString = 54;
        static final int TRANSACTION_getSampleCpu = 46;
        static final int TRANSACTION_getSampleMemory = 48;
        static final int TRANSACTION_getSampleThread = 47;
        static final int TRANSACTION_getSampleThreadRecord = 49;
        static final int TRANSACTION_getSurfaceSize = 51;
        static final int TRANSACTION_getVersion = 53;
        static final int TRANSACTION_getVideoCodecInfo = 28;
        static final int TRANSACTION_isPlaying = 16;
        static final int TRANSACTION_nativeFinalize = 34;
        static final int TRANSACTION_nativeProfileBegin = 36;
        static final int TRANSACTION_nativeProfileEnd = 37;
        static final int TRANSACTION_nativeSetLogLevel = 38;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_prepareAsync = 14;
        static final int TRANSACTION_release = 4;
        static final int TRANSACTION_reset = 5;
        static final int TRANSACTION_seekTo = 17;
        static final int TRANSACTION_setAndroidIOCallback = 39;
        static final int TRANSACTION_setAuto = 44;
        static final int TRANSACTION_setDataSource = 9;
        static final int TRANSACTION_setDataSourceBase64 = 10;
        static final int TRANSACTION_setDataSourceFd = 12;
        static final int TRANSACTION_setDataSourceKey = 11;
        static final int TRANSACTION_setExternalRenderInternalSurface = 7;
        static final int TRANSACTION_setExternalRenderSurface = 8;
        static final int TRANSACTION_setIjkMediaPlayerItem = 13;
        static final int TRANSACTION_setLoopCount = 20;
        static final int TRANSACTION_setOptionLong = 31;
        static final int TRANSACTION_setOptionString = 30;
        static final int TRANSACTION_setPropertyFloat = 23;
        static final int TRANSACTION_setPropertyLong = 25;
        static final int TRANSACTION_setProtectDelay = 50;
        static final int TRANSACTION_setStreamSelected = 15;
        static final int TRANSACTION_setSurface = 6;
        static final int TRANSACTION_setVolume = 26;
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_stop = 3;
        static final int TRANSACTION_switchAudioStream = 57;
        static final int TRANSACTION_switchDashAudioStream = 43;
        static final int TRANSACTION_switchDashVideoStream = 42;

        public Stub() {
            attachInterface(this, IIjkMediaPlayer.DESCRIPTOR);
        }

        public static IIjkMediaPlayer asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIjkMediaPlayer.DESCRIPTOR);
            if (iin != null && (iin instanceof IIjkMediaPlayer)) {
                return (IIjkMediaPlayer) iin;
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
                data.enforceInterface(IIjkMediaPlayer.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IIjkMediaPlayer.DESCRIPTOR);
                return true;
            }
            boolean _arg0 = false;
            switch (code) {
                case 1:
                    start();
                    reply.writeNoException();
                    break;
                case 2:
                    pause();
                    reply.writeNoException();
                    break;
                case 3:
                    stop();
                    reply.writeNoException();
                    break;
                case 4:
                    release();
                    reply.writeNoException();
                    break;
                case 5:
                    reset();
                    reply.writeNoException();
                    break;
                case 6:
                    setSurface((Surface) _Parcel.readTypedObject(data, Surface.CREATOR));
                    reply.writeNoException();
                    break;
                case 7:
                    setExternalRenderInternalSurface((Surface) _Parcel.readTypedObject(data, Surface.CREATOR));
                    reply.writeNoException();
                    break;
                case 8:
                    Surface _arg1 = (Surface) _Parcel.readTypedObject(data, Surface.CREATOR);
                    setExternalRenderSurface((Surface) _Parcel.readTypedObject(data, Surface.CREATOR), _arg1);
                    reply.writeNoException();
                    break;
                case 9:
                    setDataSource(data.readString());
                    reply.writeNoException();
                    break;
                case 10:
                    setDataSourceBase64(data.readString());
                    reply.writeNoException();
                    break;
                case 11:
                    String _arg02 = data.readString();
                    String[] _arg12 = data.createStringArray();
                    String[] _arg2 = data.createStringArray();
                    setDataSourceKey(_arg02, _arg12, _arg2);
                    reply.writeNoException();
                    break;
                case 12:
                    setDataSourceFd((ParcelFileDescriptor) _Parcel.readTypedObject(data, ParcelFileDescriptor.CREATOR));
                    reply.writeNoException();
                    break;
                case 13:
                    setIjkMediaPlayerItem(IIjkMediaPlayerItem.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    break;
                case 14:
                    prepareAsync();
                    reply.writeNoException();
                    break;
                case 15:
                    int _arg03 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setStreamSelected(_arg03, _arg0);
                    reply.writeNoException();
                    break;
                case 16:
                    boolean isPlaying = isPlaying();
                    reply.writeNoException();
                    reply.writeInt(isPlaying ? 1 : 0);
                    break;
                case 17:
                    long _arg04 = data.readLong();
                    int _arg13 = data.readInt();
                    seekTo(_arg04, _arg13);
                    reply.writeNoException();
                    break;
                case 18:
                    long _result = getCurrentPosition();
                    reply.writeNoException();
                    reply.writeLong(_result);
                    break;
                case 19:
                    long _result2 = getDuration();
                    reply.writeNoException();
                    reply.writeLong(_result2);
                    break;
                case 20:
                    setLoopCount(data.readInt());
                    reply.writeNoException();
                    break;
                case 21:
                    int _result3 = getLoopCount();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    break;
                case 22:
                    int _arg05 = data.readInt();
                    float _arg14 = data.readFloat();
                    float _result4 = getPropertyFloat(_arg05, _arg14);
                    reply.writeNoException();
                    reply.writeFloat(_result4);
                    break;
                case 23:
                    int _arg06 = data.readInt();
                    float _arg15 = data.readFloat();
                    setPropertyFloat(_arg06, _arg15);
                    reply.writeNoException();
                    break;
                case 24:
                    int _arg07 = data.readInt();
                    long _arg16 = data.readLong();
                    long _result5 = getPropertyLong(_arg07, _arg16);
                    reply.writeNoException();
                    reply.writeLong(_result5);
                    break;
                case 25:
                    int _arg08 = data.readInt();
                    long _arg17 = data.readLong();
                    setPropertyLong(_arg08, _arg17);
                    reply.writeNoException();
                    break;
                case 26:
                    float _arg09 = data.readFloat();
                    float _arg18 = data.readFloat();
                    setVolume(_arg09, _arg18);
                    reply.writeNoException();
                    break;
                case 27:
                    int _result6 = getAudioSessionId();
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    break;
                case 28:
                    String _result7 = getVideoCodecInfo();
                    reply.writeNoException();
                    reply.writeString(_result7);
                    break;
                case 29:
                    String _result8 = getAudioCodecInfo();
                    reply.writeNoException();
                    reply.writeString(_result8);
                    break;
                case 30:
                    int _arg010 = data.readInt();
                    String _arg19 = data.readString();
                    String _arg22 = data.readString();
                    setOptionString(_arg010, _arg19, _arg22);
                    reply.writeNoException();
                    break;
                case 31:
                    int _arg011 = data.readInt();
                    String _arg110 = data.readString();
                    long _arg23 = data.readLong();
                    setOptionLong(_arg011, _arg110, _arg23);
                    reply.writeNoException();
                    break;
                case 32:
                    Bundle _result9 = getMediaMeta();
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result9, 1);
                    break;
                case 33:
                    Bundle _result10 = getDashStreamInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result10, 1);
                    break;
                case 34:
                    nativeFinalize();
                    reply.writeNoException();
                    break;
                case 35:
                    String _result11 = getColorFormatName(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result11);
                    break;
                case 36:
                    nativeProfileBegin(data.readString());
                    reply.writeNoException();
                    break;
                case 37:
                    nativeProfileEnd();
                    reply.writeNoException();
                    break;
                case 38:
                    nativeSetLogLevel(data.readInt());
                    reply.writeNoException();
                    break;
                case 39:
                    setAndroidIOCallback();
                    reply.writeNoException();
                    break;
                case 40:
                    long _result12 = getAndroidIOTrafficStatistic();
                    reply.writeNoException();
                    reply.writeLong(_result12);
                    break;
                case 41:
                    String _arg012 = data.readString();
                    long _arg111 = data.readLong();
                    int _arg24 = data.readInt();
                    int _arg3 = data.readInt();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    int _result13 = addFrameOutputTask(_arg012, _arg111, _arg24, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    break;
                case 42:
                    switchDashVideoStream(data.readInt());
                    reply.writeNoException();
                    break;
                case 43:
                    switchDashAudioStream(data.readInt());
                    reply.writeNoException();
                    break;
                case 44:
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setAuto(_arg0);
                    reply.writeNoException();
                    break;
                case 45:
                    SamplePerformance();
                    reply.writeNoException();
                    break;
                case TRANSACTION_getSampleCpu /* 46 */:
                    double _result14 = getSampleCpu();
                    reply.writeNoException();
                    reply.writeDouble(_result14);
                    break;
                case TRANSACTION_getSampleThread /* 47 */:
                    long _result15 = getSampleThread();
                    reply.writeNoException();
                    reply.writeLong(_result15);
                    break;
                case 48:
                    long _result16 = getSampleMemory();
                    reply.writeNoException();
                    reply.writeLong(_result16);
                    break;
                case 49:
                    Bundle _result17 = getSampleThreadRecord();
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result17, 1);
                    break;
                case TRANSACTION_setProtectDelay /* 50 */:
                    setProtectDelay(data.readInt());
                    reply.writeNoException();
                    break;
                case TRANSACTION_getSurfaceSize /* 51 */:
                    Bundle _result18 = getSurfaceSize();
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result18, 1);
                    break;
                case 52:
                    Bundle _result19 = getPropertiesBundle(data.createIntArray());
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result19, 1);
                    break;
                case TRANSACTION_getVersion /* 53 */:
                    String _result20 = getVersion();
                    reply.writeNoException();
                    reply.writeString(_result20);
                    break;
                case TRANSACTION_getPropertyString /* 54 */:
                    String _result21 = getPropertyString(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result21);
                    break;
                case TRANSACTION_getDefaultAudioIndex /* 55 */:
                    int _result22 = getDefaultAudioIndex();
                    reply.writeNoException();
                    reply.writeInt(_result22);
                    break;
                case TRANSACTION_getCurrentAudioIndex /* 56 */:
                    int _result23 = getCurrentAudioIndex();
                    reply.writeNoException();
                    reply.writeInt(_result23);
                    break;
                case TRANSACTION_switchAudioStream /* 57 */:
                    int _result24 = switchAudioStream(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result24);
                    break;
                case TRANSACTION_getAudioStreamsIndex /* 58 */:
                    int[] _result25 = getAudioStreamsIndex();
                    reply.writeNoException();
                    reply.writeIntArray(_result25);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        private static class Proxy implements IIjkMediaPlayer {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIjkMediaPlayer.DESCRIPTOR;
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void start() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void pause() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void stop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void release() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void reset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setSurface(Surface surface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, surface, 0);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setExternalRenderInternalSurface(Surface internal) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, internal, 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setExternalRenderSurface(Surface avcSurface, Surface amcSurface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, avcSurface, 0);
                    _Parcel.writeTypedObject(_data, amcSurface, 0);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setDataSource(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setDataSourceBase64(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setDataSourceKey(String path, String[] keys, String[] values) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeString(path);
                    _data.writeStringArray(keys);
                    _data.writeStringArray(values);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setDataSourceFd(ParcelFileDescriptor fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, fd, 0);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setIjkMediaPlayerItem(IIjkMediaPlayerItem item) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeStrongInterface(item);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void prepareAsync() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setStreamSelected(int stream, boolean select) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(stream);
                    _data.writeInt(select ? 1 : 0);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public boolean isPlaying() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    boolean _status = _reply.readInt() != 0;
                    return _status;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void seekTo(long msec, int flag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeLong(msec);
                    _data.writeInt(flag);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getCurrentPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getDuration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setLoopCount(int loopCount) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(loopCount);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int getLoopCount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public float getPropertyFloat(int property, float defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeFloat(defaultValue);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    float _result = _reply.readFloat();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setPropertyFloat(int property, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeFloat(value);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getPropertyLong(int property, long defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeLong(defaultValue);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setPropertyLong(int property, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(property);
                    _data.writeLong(value);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setVolume(float leftVolume, float rightVolume) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeFloat(leftVolume);
                    _data.writeFloat(rightVolume);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int getAudioSessionId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public String getVideoCodecInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public String getAudioCodecInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setOptionString(int category, String name, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(category);
                    _data.writeString(name);
                    _data.writeString(value);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setOptionLong(int category, String name, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(category);
                    _data.writeString(name);
                    _data.writeLong(value);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public Bundle getMediaMeta() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public Bundle getDashStreamInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void nativeFinalize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public String getColorFormatName(int mediaCodecColorFormat) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(mediaCodecColorFormat);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void nativeProfileBegin(String libName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeString(libName);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void nativeProfileEnd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void nativeSetLogLevel(int level) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(level);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setAndroidIOCallback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getAndroidIOTrafficStatistic() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int addFrameOutputTask(String imgCachePath, long startTime, int frame_interval, int count, int imgDefinition, int frameType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeString(imgCachePath);
                    _data.writeLong(startTime);
                    _data.writeInt(frame_interval);
                    _data.writeInt(count);
                    _data.writeInt(imgDefinition);
                    _data.writeInt(frameType);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void switchDashVideoStream(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(id);
                    this.mRemote.transact(42, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void switchDashAudioStream(int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(id);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setAuto(boolean flag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(flag ? 1 : 0);
                    this.mRemote.transact(44, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void SamplePerformance() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(45, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public double getSampleCpu() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSampleCpu, _data, _reply, 0);
                    _reply.readException();
                    double _result = _reply.readDouble();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getSampleThread() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSampleThread, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public long getSampleMemory() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(48, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public Bundle getSampleThreadRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(49, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public void setProtectDelay(int protectDelay) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(protectDelay);
                    this.mRemote.transact(Stub.TRANSACTION_setProtectDelay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public Bundle getSurfaceSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSurfaceSize, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public Bundle getPropertiesBundle(int[] keys) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeIntArray(keys);
                    this.mRemote.transact(52, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _Parcel.readTypedObject(_reply, Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public String getVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVersion, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public String getPropertyString(int key) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(key);
                    this.mRemote.transact(Stub.TRANSACTION_getPropertyString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int getDefaultAudioIndex() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDefaultAudioIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int getCurrentAudioIndex() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentAudioIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int switchAudioStream(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_switchAudioStream, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // tv.danmaku.ijk.media.player.IIjkMediaPlayer
            public int[] getAudioStreamsIndex() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIjkMediaPlayer.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioStreamsIndex, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
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