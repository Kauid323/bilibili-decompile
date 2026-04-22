package tv.danmaku.ijk.media.player.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.os.Build;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class IjkDrmUtils {
    public static final int SECURITY_LEVEL_L1 = 1;
    public static final int SECURITY_LEVEL_L2 = 2;
    public static final int SECURITY_LEVEL_L3 = 3;
    public static final int SECURITY_LEVEL_UNKNOWN = 0;
    public static final int WIDEVINE_MIN_API = 24;
    public static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static ExecutorService sExecutorService = Executors.newSingleThreadExecutor();
    private static boolean sFirstSearchSupportVideoWidevine = true;
    private static boolean sIsSupportVideoWidevine = false;
    private static boolean sFirstSearchSupportAudioWidevine = true;
    private static boolean sIsSupportAudioWidevine = false;
    private static boolean sFirstGetSecurityLevel = true;
    private static int sSecurityLevel = 0;

    /* renamed from: -$$Nest$smgetSecurityLevelByDrm  reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2671$$Nest$smgetSecurityLevelByDrm() {
        return getSecurityLevelByDrm();
    }

    public static native void _invokeMethod(String str, String str2, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum SupportWidevineType {
        UNKNOWN(0),
        VIDEO_ONLY(1),
        AUDIO_AND_VIDEO(2);
        
        private final int value;

        SupportWidevineType(int value) {
            this.value = value;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum DrmType {
        DRM_DEFAULT(0),
        DRM_FAIRPLAY(1),
        DRM_WIDEVINE(2),
        DRM_BILIDRM(3);
        
        private final int value;

        public int getValue() {
            return this.value;
        }

        DrmType(int value) {
            this.value = value;
        }
    }

    public static synchronized int getSupportWidevineType() {
        synchronized (IjkDrmUtils.class) {
            if (isSupportWidevine()) {
                return SupportWidevineType.AUDIO_AND_VIDEO.value;
            } else if (isSupportVideoWidevine()) {
                return SupportWidevineType.VIDEO_ONLY.value;
            } else {
                return SupportWidevineType.UNKNOWN.value;
            }
        }
    }

    public static synchronized boolean isSupportWidevine() {
        boolean isSupportAudioWidevine;
        synchronized (IjkDrmUtils.class) {
            isSupportAudioWidevine = isSupportAudioWidevine();
        }
        return isSupportAudioWidevine;
    }

    public static synchronized boolean isSupportVideoWidevine() {
        boolean z;
        synchronized (IjkDrmUtils.class) {
            if (sFirstSearchSupportVideoWidevine) {
                boolean z2 = false;
                sFirstSearchSupportVideoWidevine = false;
                if (24 <= Build.VERSION.SDK_INT && getSecurityLevelSync() == 1) {
                    z2 = true;
                }
                sIsSupportVideoWidevine = z2;
                BLog.i("IjkDrmUtils sIsSupportVideoWidevine: " + sIsSupportVideoWidevine);
            }
            z = sIsSupportVideoWidevine;
        }
        return z;
    }

    public static synchronized boolean isSupportAudioWidevine() {
        boolean z;
        synchronized (IjkDrmUtils.class) {
            if (sFirstSearchSupportAudioWidevine) {
                boolean z2 = false;
                sFirstSearchSupportAudioWidevine = false;
                try {
                    if (24 <= Build.VERSION.SDK_INT && getSecurityLevelSync() == 1 && isSupportHardwareDecoding("audio/mp4a-latm")) {
                        z2 = true;
                    }
                    sIsSupportAudioWidevine = z2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BLog.i("IjkDrmUtils sIsSupportAudioWidevine: " + sIsSupportAudioWidevine);
            }
            z = sIsSupportAudioWidevine;
        }
        return z;
    }

    private static boolean isSupportHardwareDecoding(String mimeType) {
        MediaCodecList mediaCodecList = new MediaCodecList(0);
        MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
        for (MediaCodecInfo codecInfo : codecInfos) {
            if (isSupportHardwareDecoding(codecInfo, mimeType)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSupportHardwareDecoding(MediaCodecInfo codecInfo, String mimeType) {
        if (codecInfo.isEncoder()) {
            return false;
        }
        String codecName = codecInfo.getName();
        if (codecName.indexOf("OMX.google") == -1 && codecName.indexOf("OMX.ffmpeg") == -1 && ((codecName.indexOf("OMX.SEC") == -1 || codecName.indexOf(".sw.") == -1) && codecName.indexOf("OMX.qcom.video.decoder.hevcswvdec") == -1)) {
            String[] types = codecInfo.getSupportedTypes();
            for (String type : types) {
                if (type.equalsIgnoreCase(mimeType)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static synchronized int getSecurityLevel() {
        boolean isSupportWidevine;
        synchronized (IjkDrmUtils.class) {
            isSupportWidevine = isSupportWidevine();
        }
        return isSupportWidevine ? 1 : 0;
    }

    private static synchronized int getSecurityLevelSync() {
        synchronized (IjkDrmUtils.class) {
            if (!sFirstGetSecurityLevel) {
                return sSecurityLevel;
            }
            sFirstGetSecurityLevel = false;
            Integer level = 0;
            try {
                level = (Integer) sExecutorService.submit(new Callable<Integer>() { // from class: tv.danmaku.ijk.media.player.utils.IjkDrmUtils.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Integer call() throws Exception {
                        return Integer.valueOf(IjkDrmUtils.m2671$$Nest$smgetSecurityLevelByDrm());
                    }
                }).get(PlayerToastConfig.DURATION_2, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                e.printStackTrace();
                BLog.e("IjkDrmUtils TimeoutException");
            } catch (Exception e2) {
                e2.printStackTrace();
                BLog.e("IjkDrmUtils Exception");
            }
            sSecurityLevel = level.intValue();
            BLog.i("IjkDrmUtils sSecurityLevel: " + sSecurityLevel);
            return sSecurityLevel;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int getSecurityLevelByDrm() {
        char c;
        int level = 0;
        if (Build.VERSION.SDK_INT < 24) {
            BLog.i("IjkDrmUtils cur api level: " + Build.VERSION.SDK_INT + " < 24");
            return 0;
        }
        MediaDrm drm = createDrm(WIDEVINE_UUID);
        if (drm == null) {
            BLog.i("IjkDrmUtils drm create failed");
            return 0;
        }
        String levelString = "";
        try {
            levelString = drm.getPropertyString("securityLevel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BLog.i("IjkDrmUtils levelString: " + levelString);
        switch (levelString.hashCode()) {
            case 2405:
                if (levelString.equals("L1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2406:
                if (levelString.equals("L2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2407:
                if (levelString.equals("L3")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                level = 1;
                break;
            case 1:
                level = 2;
                break;
            case 2:
                level = 3;
                break;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                drm.release();
            } else {
                drm.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return level;
    }

    private static MediaDrm createDrm(UUID uuid) {
        BLog.i("IjkDrmUtils createDrm");
        try {
            MediaDrm drm = new MediaDrm(uuid);
            return drm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MediaDrm.OnEventListener createOnEventListener(final String listener, final String opaque) {
        return new MediaDrm.OnEventListener() { // from class: tv.danmaku.ijk.media.player.utils.IjkDrmUtils.2
            @Override // android.media.MediaDrm.OnEventListener
            public void onEvent(MediaDrm md, byte[] sessionId, int event, int extra, byte[] data) {
                IjkDrmUtils._invokeMethod(listener, opaque, md, sessionId, event, extra, data);
            }
        };
    }
}