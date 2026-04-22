package tv.danmaku.ijk.media.player.render.tools;

import android.opengl.Matrix;
import android.renderscript.Float3;
import android.renderscript.Matrix4f;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class BiliDaltonizer {
    private static final float[] DEFAULT_COLOR_TRANSFORM = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    private static final float[] RGB_2_XYZ = {0.4124f, 0.2126f, 0.0193f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.3576f, 0.7152f, 0.1192f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.1805f, 0.0722f, 0.9505f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    private static final float[] XYZ_2_LMS = {0.7328f, -0.7036f, 0.003f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.4296f, 1.6975f, 0.0136f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -0.1624f, 0.0061f, 0.9834f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    private Matrix4f mRGB2LMSMatrix = new Matrix4f();
    private Matrix4f mLMS2RGBMatrix = new Matrix4f();
    private ColorBlindnessType mType = ColorBlindnessType.None;
    private ColorBlindnessMode mModel = ColorBlindnessMode.Simulation;
    private boolean mDirty = false;
    private float[] mColorTransform = DEFAULT_COLOR_TRANSFORM;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ColorBlindnessMode {
        Simulation,
        Correction
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ColorBlindnessType {
        None,
        Protanomaly,
        Deuteranomaly,
        Tritanomaly
    }

    public BiliDaltonizer() {
        Matrix.multiplyMM(this.mRGB2LMSMatrix.getArray(), 0, XYZ_2_LMS, 0, RGB_2_XYZ, 0);
        Matrix.invertM(this.mLMS2RGBMatrix.getArray(), 0, this.mRGB2LMSMatrix.getArray(), 0);
    }

    public void setType(ColorBlindnessType type) {
        if (type != this.mType) {
            this.mDirty = true;
            this.mType = type;
        }
    }

    public void setMode(ColorBlindnessMode mode) {
        if (mode != this.mModel) {
            this.mDirty = true;
            this.mModel = mode;
        }
    }

    public float[] getMatrix() {
        if (this.mDirty) {
            this.mDirty = false;
            update();
        }
        return this.mColorTransform;
    }

    private void update() {
        Matrix4f correction;
        Matrix4f correction2;
        if (this.mType == ColorBlindnessType.None) {
            this.mColorTransform = DEFAULT_COLOR_TRANSFORM;
        }
        Float3 lms_r = new Float3(this.mRGB2LMSMatrix.get(0, 0), this.mRGB2LMSMatrix.get(0, 1), this.mRGB2LMSMatrix.get(0, 2));
        Float3 lms_b = new Float3(this.mRGB2LMSMatrix.get(2, 0), this.mRGB2LMSMatrix.get(2, 1), this.mRGB2LMSMatrix.get(2, 2));
        float[] temp = new float[4];
        Matrix.multiplyMV(temp, 0, this.mRGB2LMSMatrix.getArray(), 0, new float[]{1.0f, 1.0f, 1.0f, 1.0f}, 0);
        Float3 lms_w = new Float3(temp[0], temp[1], temp[2]);
        Float3 p0 = cross(lms_w, lms_b);
        Float3 p1 = cross(lms_w, lms_r);
        float[] lms2lmspArray = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (-p0.y) / p0.x, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (-p0.z) / p0.x, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f lms2lmsp = new Matrix4f(lms2lmspArray);
        float[] lms2lmsdArray = {1.0f, (-p0.x) / p0.y, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (-p0.z) / p0.y, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f lms2lmsd = new Matrix4f(lms2lmsdArray);
        float[] lms2lmstArray = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (-p1.x) / p1.z, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, (-p1.y) / p1.z, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f lms2lmst = new Matrix4f(lms2lmstArray);
        float[] errpArray = {1.0f, 0.7f, 0.7f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f errp = new Matrix4f(errpArray);
        float[] errdArray = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.7f, 1.0f, 0.7f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f errd = new Matrix4f(errdArray);
        float[] errtArray = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.7f, 0.7f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
        Matrix4f errt = new Matrix4f(errtArray);
        Matrix4f simulation = new Matrix4f();
        Matrix4f correction3 = new Matrix4f();
        correction3.set(0, 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        correction3.set(1, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        correction3.set(2, 2, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        correction3.set(3, 3, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        switch (this.mType) {
            case Protanomaly:
                if (this.mModel != ColorBlindnessMode.Correction) {
                    correction = correction3;
                    correction2 = lms2lmsp;
                    break;
                } else {
                    correction = errp;
                    correction2 = lms2lmsp;
                    break;
                }
            case Deuteranomaly:
                if (this.mModel != ColorBlindnessMode.Correction) {
                    correction = correction3;
                    correction2 = lms2lmsd;
                    break;
                } else {
                    correction = errd;
                    correction2 = lms2lmsd;
                    break;
                }
            case Tritanomaly:
                if (this.mModel != ColorBlindnessMode.Correction) {
                    correction = correction3;
                    correction2 = lms2lmst;
                    break;
                } else {
                    correction = errt;
                    correction2 = lms2lmst;
                    break;
                }
            default:
                correction = correction3;
                correction2 = simulation;
                break;
        }
        Matrix4f simMulRgb = new Matrix4f();
        Matrix4f errt2 = this.mRGB2LMSMatrix;
        simMulRgb.loadMultiply(correction2, errt2);
        Matrix4f rgb2lmsMinSim = min(this.mRGB2LMSMatrix, simMulRgb);
        Matrix4f correctionMulSimMulRgb = new Matrix4f();
        correctionMulSimMulRgb.loadMultiply(correction, rgb2lmsMinSim);
        Matrix4f simMulRgb2Lms = new Matrix4f();
        Matrix4f rgb2lmsMinSim2 = this.mRGB2LMSMatrix;
        simMulRgb2Lms.loadMultiply(correction2, rgb2lmsMinSim2);
        Matrix4f addTemp = add(simMulRgb2Lms, correctionMulSimMulRgb);
        Matrix4f result = new Matrix4f();
        Matrix4f simulation2 = this.mLMS2RGBMatrix;
        result.loadMultiply(simulation2, addTemp);
        this.mColorTransform = result.getArray();
    }

    private Float3 cross(Float3 u, Float3 v) {
        return new Float3((u.y * v.z) - (u.z * v.y), (u.z * v.x) - (u.x * v.z), (u.x * v.y) - (u.y * v.x));
    }

    private Matrix4f add(Matrix4f lm, Matrix4f rm) {
        Matrix4f result = new Matrix4f();
        result.set(0, 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(1, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(2, 2, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(3, 3, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.set(i, j, lm.get(i, j) + rm.get(i, j));
            }
        }
        return result;
    }

    private Matrix4f min(Matrix4f lm, Matrix4f rm) {
        Matrix4f result = new Matrix4f();
        result.set(0, 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(1, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(2, 2, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        result.set(3, 3, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.set(i, j, lm.get(i, j) - rm.get(i, j));
            }
        }
        return result;
    }
}