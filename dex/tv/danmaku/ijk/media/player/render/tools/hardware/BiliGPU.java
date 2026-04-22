package tv.danmaku.ijk.media.player.render.tools.hardware;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.widget.PinnedBottomPanelViewKt;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.render.tools.ReflectUtils;
import tv.danmaku.ijk.media.player.render.tools.StringHelper;

public class BiliGPU {
    private static final String TAG = "BiliGPU";
    private static int mGlMaxTextureSize;
    private static String mGpuInfo;
    private static boolean mHasGpuInfo;
    private static boolean mIsSupporTurbo;
    private static int mGlMaxTextureOptimizedSize = 2000;
    private static GpuType mGpuType = new GpuType(0, 2000, 0, 2);
    private static Hashtable<String, ArrayList<GpuType>> mGpuTypes = new Hashtable<>();
    private static int[] mAdrenoUnsupportPBO = {505, 506, 530, 540};

    public static int getMaxTextureSize() {
        return mGlMaxTextureSize;
    }

    public static int getMaxTextureOptimizedSize() {
        return mGlMaxTextureOptimizedSize;
    }

    public static String getGpuInfo() {
        return mGpuInfo;
    }

    public static GpuType getGpuType() {
        if (mGpuType == null) {
            mGpuType = new GpuType(0, 2000, 0, 2);
        }
        return mGpuType;
    }

    public static boolean isSupporTurbo() {
        return mIsSupporTurbo;
    }

    public static boolean isLiveStickerSupported() {
        return getGpuType().getPerformance() >= 3;
    }

    public static boolean isFaceBeautySupported() {
        return getGpuType().getPerformance() >= 3;
    }

    public static void init(int glMaxTextureSize, String gpuInfo) {
        if (mHasGpuInfo || gpuInfo == null) {
            return;
        }
        mHasGpuInfo = true;
        initGPUTypes();
        mGlMaxTextureSize = glMaxTextureSize;
        mGpuInfo = gpuInfo;
        matchGPUInfo(mGpuInfo);
    }

    private static void initGPUTypes() {
        Hashtable<String, ArrayList<GpuType>> hashtable = mGpuTypes;
        ArrayList<GpuType> types = new ArrayList<>();
        hashtable.put("Mali", types);
        types.add(new GpuTypeMali(300, 2000, 0, 2));
        types.add(new GpuTypeMali(400, 2000, 0, 2));
        types.add(new GpuTypeMali(400, 3000, 4, 3));
        types.add(new GpuTypeMali(450, 4000, 4, 5));
        types.add(new GpuTypeMali(604, 3000, 4, 3));
        types.add(new GpuTypeMali(622, 2800, 4, 2));
        types.add(new GpuTypeMali(624, 4000, 4, 4));
        types.add(new GpuTypeMali(628, 4000, 6, 4));
        types.add(new GpuTypeMali(760, 4000, 6, 4));
        types.add(new GpuTypeMali(880, 4000, 6, 5));
        types.add(new GpuTypeMali(7100, 4000, 6, 5));
        types.add(new GpuTypeMali(7200, 4000, 6, 5));
        Hashtable<String, ArrayList<GpuType>> hashtable2 = mGpuTypes;
        ArrayList<GpuType> types2 = new ArrayList<>();
        hashtable2.put("Adreno", types2);
        types2.add(new GpuTypeAdreno(130, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(200, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(203, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(205, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(220, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(225, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(302, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(PinnedBottomPanelViewKt.DEFAULT_PEEK_HEIGHT, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(305, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(306, 2000, 0, 2));
        types2.add(new GpuTypeAdreno(320, 4000, 0, 2));
        types2.add(new GpuTypeAdreno(330, 4000, 0, 4));
        types2.add(new GpuTypeAdreno(405, 4000, 0, 3));
        types2.add(new GpuTypeAdreno(418, 4000, 0, 4));
        types2.add(new GpuTypeAdreno(420, 4000, 0, 4));
        types2.add(new GpuTypeAdreno(430, 4000, 0, 5));
        types2.add(new GpuTypeAdreno(505, 4000, 0, 3));
        types2.add(new GpuTypeAdreno(506, 4000, 0, 3));
        types2.add(new GpuTypeAdreno(510, 4000, 0, 4));
        types2.add(new GpuTypeAdreno(512, 4000, 0, 5));
        types2.add(new GpuTypeAdreno(530, 4000, 0, 5));
        types2.add(new GpuTypeAdreno(540, 4000, 0, 5));
        types2.add(new GpuTypeAdreno(630, 4000, 0, 5));
        Hashtable<String, ArrayList<GpuType>> hashtable3 = mGpuTypes;
        ArrayList<GpuType> types3 = new ArrayList<>();
        hashtable3.put("PowerVR", types3);
        types3.add(new GpuTypePowerVR(530, 2000, 0, 2));
        types3.add(new GpuTypePowerVR(531, 2000, 0, 2));
        types3.add(new GpuTypePowerVR(535, 2000, 0, 2));
        types3.add(new GpuTypePowerVR(540, 2000, 0, 2));
        types3.add(new GpuTypePowerVR(543, 2000, 4, 3));
        types3.add(new GpuTypePowerVR(544, 3000, 0, 3));
        types3.add(new GpuTypePowerVR(544, 3000, 3, 4));
        types3.add(new GpuTypePowerVR(6200, 4000, 0, 5));
        types3.add(new GpuTypePowerVR(7400, 4000, 4, 5));
        types3.add(new GpuTypePowerVR(8100, 3500, 1, 5));
        types3.add(new GpuTypePowerVR(8200, 4000, 1, 5));
        Hashtable<String, ArrayList<GpuType>> hashtable4 = mGpuTypes;
        ArrayList<GpuType> types4 = new ArrayList<>();
        hashtable4.put("Nvidia", types4);
        types4.add(new GpuTypeNvidia(3, 2500, 0, 4));
        Hashtable<String, ArrayList<GpuType>> hashtable5 = mGpuTypes;
        ArrayList<GpuType> types5 = new ArrayList<>();
        hashtable5.put("Immersion", types5);
        types5.add(new GpuTypeImmersion(16, 3000, 0, 2));
        Hashtable<String, ArrayList<GpuType>> hashtable6 = mGpuTypes;
        ArrayList<GpuType> types6 = new ArrayList<>();
        hashtable6.put("Vivante", types6);
        types6.add(new GpuTypeVivante(IjkMediaCodecInfo.RANK_MAX, 2000, 0, 2));
        types6.add(new GpuTypeVivante(2000, 2000, 0, 2));
        types6.add(new GpuTypeVivante(4000, 4000, 0, 2));
    }

    private static void matchGPUInfo(String gpuInfo) {
        if (gpuInfo == null) {
            return;
        }
        String gpuInfo2 = gpuInfo.toLowerCase();
        boolean isMathed = false;
        Iterator<Map.Entry<String, ArrayList<GpuType>>> it = mGpuTypes.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ArrayList<GpuType>> item = it.next();
            if (gpuInfo2.contains(item.getKey().toLowerCase())) {
                matchType(item.getKey(), item.getValue(), gpuInfo2);
                isMathed = true;
                break;
            }
        }
        if (!isMathed) {
            matchUnknowType(gpuInfo2);
        }
        configGpuType();
    }

    private static void matchType(String key, ArrayList<GpuType> types, String gpuInfo) {
        GpuType type = (GpuType) ReflectUtils.classInstance(types.get(0).getClass());
        type.matchInfo(gpuInfo);
        GpuType cType = null;
        int i = types.size();
        while (true) {
            i--;
            if (i <= -1) {
                break;
            }
            GpuType gpuType = types.get(i);
            if (type.getCode() >= gpuType.getCode()) {
                cType = gpuType;
                break;
            }
        }
        if (cType == null) {
            GpuType cType2 = types.get(0);
            cType = cType2;
        }
        mGpuType = cType;
    }

    private static void matchUnknowType(String gpuInfo) {
        if (gpuInfo != null && gpuInfo.contains("gc1000")) {
            mGpuType = new GpuTypeVivante(IjkMediaCodecInfo.RANK_MAX, 2000, 0, 2);
        }
    }

    private static void configGpuType() {
        if (mGpuType == null) {
            return;
        }
        if (mGlMaxTextureSize > 0) {
            mGpuType.setSize(Math.min(mGpuType.getSize(), mGlMaxTextureSize));
        }
        mGlMaxTextureOptimizedSize = mGpuType.mSize;
        if (!(mGpuType instanceof GpuTypeNvidia) || mGpuType.getCode() > 2) {
            mIsSupporTurbo = true;
        }
        BLog.i(TAG, String.format("GPU info: %s %s", mGpuInfo, mGpuType));
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuType {
        private int mCode;
        private int mMp;
        private int mPerformance;
        private int mSize;

        public GpuType() {
        }

        public GpuType(int code, int size, int mp, int performance) {
            this.mCode = code;
            this.mSize = size;
            this.mMp = mp;
            this.mPerformance = performance;
        }

        public int getCode() {
            return this.mCode;
        }

        public void setCode(int code) {
            this.mCode = code;
        }

        public int getSize() {
            return this.mSize;
        }

        public void setSize(int size) {
            this.mSize = size;
        }

        public int getMp() {
            return this.mMp;
        }

        public void setMp(int mp) {
            this.mMp = mp;
        }

        public int getPerformance() {
            return this.mPerformance;
        }

        public void setPerformance(int mPerformance) {
            this.mPerformance = mPerformance;
        }

        public void matchInfo(String gpuInfo) {
            String mp = StringHelper.matchString(gpuInfo, "mp([0-9]+)");
            this.mMp = StringHelper.parserInt(mp);
        }

        public String toString() {
            String info = String.format("%s - {code: %s, mp: %s, size: %s, pf: %s}", getClass().getSimpleName(), Integer.valueOf(this.mCode), Integer.valueOf(this.mMp), Integer.valueOf(this.mSize), Integer.valueOf(this.mPerformance));
            return info;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypeMali extends GpuType {
        public GpuTypeMali() {
        }

        public GpuTypeMali(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            super.matchInfo(gpuInfo);
            String code = StringHelper.matchString(gpuInfo, "-[a-z]*([0-9]+)");
            int c = StringHelper.parserInt(code);
            if (StringHelper.matchString(gpuInfo, "-g([0-9]+)") != null) {
                c *= 100;
            }
            setCode(c);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypePowerVR extends GpuType {
        public GpuTypePowerVR() {
        }

        public GpuTypePowerVR(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            String code;
            super.matchInfo(gpuInfo);
            if (gpuInfo.indexOf("sgx") != -1) {
                StringHelper.matchString(gpuInfo, "sgx[ ]*([0-9]+)");
            }
            if (gpuInfo.indexOf("marlowe") != -1) {
                code = "7400";
                setMp(4);
            } else if (gpuInfo.indexOf("rogue") != -1) {
                code = StringHelper.matchString(gpuInfo, "rogue[ ]*g[a-z]*([0-9]+)");
            } else {
                code = StringHelper.matchString(gpuInfo, "[ ]*g[a-z]*([0-9]+)");
            }
            setCode(StringHelper.parserInt(code));
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypeAdreno extends GpuType {
        public GpuTypeAdreno() {
        }

        public GpuTypeAdreno(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            super.matchInfo(gpuInfo);
            String code = StringHelper.matchString(gpuInfo, "[ ]([0-9]+)");
            setCode(StringHelper.parserInt(code));
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypeNvidia extends GpuType {
        public GpuTypeNvidia() {
        }

        public GpuTypeNvidia(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            if (gpuInfo != null && gpuInfo.contains("Tegra")) {
                setCode(1);
                setSize(2000);
                setPerformance(2);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypeImmersion extends GpuType {
        public GpuTypeImmersion() {
        }

        public GpuTypeImmersion(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            super.matchInfo(gpuInfo);
            String code = StringHelper.matchString(gpuInfo, "\\.?([0-9]+)");
            setCode(StringHelper.parserInt(code));
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class GpuTypeVivante extends GpuType {
        public GpuTypeVivante() {
        }

        public GpuTypeVivante(int code, int size, int mp, int performance) {
            super(code, size, mp, performance);
        }

        @Override // tv.danmaku.ijk.media.player.render.tools.hardware.BiliGPU.GpuType
        public void matchInfo(String gpuInfo) {
            super.matchInfo(gpuInfo);
            String code = StringHelper.matchString(gpuInfo, "([0-9]+)");
            setCode(StringHelper.parserInt(code));
        }
    }

    public static boolean lowPerformance() {
        return (getGpuType() instanceof GpuTypeNvidia) || (getGpuType() instanceof GpuTypeImmersion) || (getGpuType() instanceof GpuTypeVivante);
    }
}