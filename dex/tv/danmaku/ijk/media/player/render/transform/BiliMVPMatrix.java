package tv.danmaku.ijk.media.player.render.transform;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.output.IOprationRenderer;
import tv.danmaku.ijk.media.player.render.tools.BiliMatrix;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliMVPMatrix implements IOprationRenderer {
    public static final String BILI_MATRIX = "matrix";
    public static final int BILI_MIRROR_X = 0;
    public static final int BILI_MIRROR_Y = 1;
    public static final int BILI_MIRROR_Z = 2;
    public static final int BILI_RATIO_16_9 = 4;
    public static final int BILI_RATIO_4_3 = 5;
    public static final int BILI_RATIO_AUTO = 1;
    public static final int BILI_RATIO_FULLSCREEN = 2;
    public static final int BILI_RATIO_STRETCH = 3;
    private static final String TAG = "BiliMVPMatrix";
    private BiliSize mScreenSize = new BiliSize();
    private BiliSize mImageSize = new BiliSize();
    private int mRatio = 1;
    private int mMirror = 1;
    private float mTranslateX = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mTranslateY = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mTranslateZ = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mRotateX = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mRotateY = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mRotateZ = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mScaleZ = 1.0f;
    private BiliSize mTransformImgSize = new BiliSize();
    private BiliSize mOriginDisplayImgSize = new BiliSize();
    private RectF mImageRectF = new RectF();
    private PointF offset = new PointF();
    private float[] mProjectMatrix = new float[16];
    private float[] mModelMatrix = new float[16];
    private float[] mMVPMatrix = new float[16];
    private HashMap<Integer, Boolean> mMirrorMap = new HashMap<>();

    public BiliMVPMatrix() {
        this.mMirrorMap.put(0, false);
        this.mMirrorMap.put(1, false);
        this.mMirrorMap.put(2, false);
        BiliMatrix.setIdentityM(this.mProjectMatrix, 0);
        BiliMatrix.setIdentityM(this.mModelMatrix, 0);
    }

    public synchronized void mapTextureToVertex(BiliSize imageSize, BiliSize screenSize, FloatBuffer vertexBuffer) {
        if (imageSize.isSize() && screenSize.isSize()) {
            vertexBuffer.clear();
            BiliSize iSize = imageSize.copy();
            float iRatio = iSize.getRatioFloat() > 1.0f ? 1.0f / iSize.getRatioFloat() : iSize.getRatioFloat();
            float sRatio = screenSize.getRatioFloat() > 1.0f ? 1.0f / screenSize.getRatioFloat() : screenSize.getRatioFloat();
            switch (this.mRatio) {
                case 2:
                    iRatio = sRatio;
                    iSize.width = screenSize.width;
                    iSize.height = screenSize.height;
                    break;
                case 4:
                    iRatio = 0.5625f;
                    if (iSize.width > iSize.height) {
                        iSize.width = 16;
                        iSize.height = 9;
                        break;
                    } else {
                        iSize.width = 9;
                        iSize.height = 16;
                        break;
                    }
                case 5:
                    iRatio = 0.75f;
                    if (iSize.width > iSize.height) {
                        iSize.width = 4;
                        iSize.height = 3;
                        break;
                    } else {
                        iSize.width = 3;
                        iSize.height = 4;
                        break;
                    }
            }
            float[] imageVertices = new float[8];
            if (iSize.width > iSize.height) {
                imageVertices[0] = -1.0f;
                imageVertices[1] = -iRatio;
                imageVertices[2] = 1.0f;
                imageVertices[3] = imageVertices[1];
                imageVertices[4] = imageVertices[0];
                imageVertices[5] = iRatio;
                imageVertices[6] = imageVertices[2];
                imageVertices[7] = imageVertices[5];
            } else {
                imageVertices[0] = -iRatio;
                imageVertices[1] = -1.0f;
                imageVertices[2] = iRatio;
                imageVertices[3] = -1.0f;
                imageVertices[4] = imageVertices[0];
                imageVertices[5] = 1.0f;
                imageVertices[6] = imageVertices[2];
                imageVertices[7] = imageVertices[5];
            }
            this.mImageRectF.set(imageVertices[0], imageVertices[5], imageVertices[2], imageVertices[3]);
            vertexBuffer.put(imageVertices).position(0);
            return;
        }
        BLog.e(TAG, "mapTextureToVertex is not size  image:" + imageSize + " screen:" + screenSize);
    }

    public synchronized void mapVerticesFromRect(Rect rect, BiliSize screenSize, FloatBuffer vertexBuffer) {
        float leftDis;
        float topDis;
        if (screenSize != null) {
            if (screenSize.isSize()) {
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                float sRatio = screenSize.getRatioFloat();
                float minSide = screenSize.minSide();
                if (screenSize.width < screenSize.height) {
                    sRatio = screenSize.height / screenSize.width;
                }
                float[] imageVertices = {-(rect.width() / minSide), -(rect.height() / minSide), rect.width() / minSide, -(rect.height() / minSide), -(rect.width() / minSide), rect.height() / minSide, rect.width() / minSide, rect.height() / minSide};
                PointF leftTop = new PointF(imageVertices[4], imageVertices[5]);
                if (screenSize.width > screenSize.height) {
                    leftDis = sRatio - Math.abs(leftTop.x);
                    topDis = 1.0f - Math.abs(leftTop.y);
                } else {
                    leftDis = 1.0f - Math.abs(leftTop.x);
                    topDis = sRatio - Math.abs(leftTop.y);
                }
                this.offset.x = -leftDis;
                this.offset.y = topDis;
                this.offset.x += (rect.left / screenSize.minSide()) * 2.0f;
                this.offset.y -= (rect.top / screenSize.minSide()) * 2.0f;
                vertexBuffer.put(imageVertices).position(0);
                return;
            }
        }
        BLog.e(TAG, "mapVerticesFromRect is not size screen:" + screenSize);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setScreenSize(int width, int height) {
        if (this.mScreenSize.width == width && this.mScreenSize.height == height) {
            return;
        }
        this.mScreenSize.width = width;
        this.mScreenSize.height = height;
        this.mOriginDisplayImgSize.width = width;
        this.mOriginDisplayImgSize.height = height;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setTextureSize(int width, int height) {
        if (this.mImageSize.width == width && this.mImageSize.height == height) {
            return;
        }
        this.mImageSize.width = width;
        this.mImageSize.height = height;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setAspectRatio(int ratio) {
        this.mRatio = ratio;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public void setRotation(float degress) {
        setRotation(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, degress);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setRotation(float degressX, float degressY, float degressZ) {
        this.mRotateX = degressX;
        this.mRotateY = degressY;
        this.mRotateZ = degressZ;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setTranslate(float translateX, float translateY) {
        this.mTranslateX = translateX;
        this.mTranslateY = translateY;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setTranslate(int translateX, int translateY) {
        this.mTranslateX = translateX;
        this.mTranslateY = translateY;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setScale(float scale) {
        this.mScaleX = scale;
        this.mScaleY = scale;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setScale(float scaleX, float scaleY, float scaleZ) {
        this.mScaleX = scaleX;
        this.mScaleY = scaleY;
        this.mScaleZ = scaleZ;
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public synchronized void setMirror(int mirrorType, boolean enable) {
        this.mMirror = mirrorType;
        this.mMirrorMap.put(Integer.valueOf(mirrorType), Boolean.valueOf(enable));
    }

    @Override // tv.danmaku.ijk.media.player.render.output.IOprationRenderer
    public BiliSize getTransformSize() {
        BiliSize biliSize;
        synchronized (this.mTransformImgSize) {
            biliSize = this.mTransformImgSize;
        }
        return biliSize;
    }

    public synchronized float[] getMatrix() {
        calcMatrix();
        return this.mMVPMatrix;
    }

    public synchronized float[] getMatrixForInput() {
        calcInputRectMatrix();
        return this.mMVPMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void calcMatrix() {
        float fixScale;
        int i;
        int i2;
        int i3;
        int i4;
        float fixScale2;
        BiliMatrix.setIdentityM(this.mModelMatrix, 0);
        BiliMatrix.setIdentityM(this.mProjectMatrix, 0);
        if (!this.mScreenSize.isSize() || !this.mImageSize.isSize()) {
            BLog.e(TAG, "calcMatrix is not size  image:" + this.mImageSize + " screen:" + this.mScreenSize);
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mMVPMatrix, 0, this.mProjectMatrix, 0);
            return;
        }
        RectF imageRect = this.mImageRectF;
        float sRatio = this.mScreenSize.getRatioFloat() > 1.0f ? 1.0f / this.mScreenSize.getRatioFloat() : this.mScreenSize.getRatioFloat();
        float iRatio = this.mImageSize.getRatioFloat() > 1.0f ? 1.0f / this.mImageSize.getRatioFloat() : this.mImageSize.getRatioFloat();
        BiliSize iSize = this.mImageSize.copy();
        BiliSize sSize = this.mScreenSize.copy();
        BiliSize outImgSize = this.mTransformImgSize.copy();
        float rotateX = -this.mRotateX;
        float rotateY = -this.mRotateY;
        float rotateZ = -this.mRotateZ;
        switch (this.mRatio) {
            case 2:
            case 4:
            case 5:
                float rFull = sRatio;
                int i5 = iSize.width;
                int i6 = iSize.height;
                fixScale = 1.0f;
                if (this.mRatio == 4) {
                    iRatio = 0.5625f;
                    if (this.mImageSize.getRatioFloat() > 1.0f) {
                        i3 = 16;
                    } else {
                        i3 = 9;
                    }
                    iSize.setWidth(i3);
                    if (this.mImageSize.getRatioFloat() <= 1.0f) {
                        i4 = 16;
                    } else {
                        i4 = 9;
                    }
                    iSize.setHeight(i4);
                } else {
                    int width = this.mRatio;
                    if (width == 5) {
                        iRatio = 0.75f;
                        if (this.mImageSize.getRatioFloat() > 1.0f) {
                            i = 4;
                        } else {
                            i = 3;
                        }
                        iSize.setWidth(i);
                        if (this.mImageSize.getRatioFloat() <= 1.0f) {
                            i2 = 4;
                        } else {
                            i2 = 3;
                        }
                        iSize.setHeight(i2);
                    } else {
                        int width2 = this.mRatio;
                        if (width2 == 2) {
                            iRatio = rFull;
                            int width3 = sSize.width;
                            int height = sSize.height;
                            iSize.setWidth(width3);
                            iSize.setHeight(height);
                        }
                    }
                }
                if (iRatio != 1.0f) {
                    if (sSize.getRatioFloat() >= 1.0f || iSize.getRatioFloat() >= 1.0f) {
                        if (sSize.getRatioFloat() > 1.0f && iSize.getRatioFloat() > 1.0f) {
                            if (iSize.getRatioFloat() < sSize.getRatioFloat()) {
                                fixScale2 = 1.0f / iRatio;
                                break;
                            } else {
                                fixScale2 = 1.0f / sRatio;
                                break;
                            }
                        }
                    } else if (iSize.getRatioFloat() < sSize.getRatioFloat()) {
                        fixScale2 = 1.0f / sRatio;
                        break;
                    } else {
                        fixScale2 = 1.0f / iRatio;
                        break;
                    }
                }
                fixScale2 = fixScale;
                break;
            case 3:
                if (sSize.getRatioFloat() < 1.0f) {
                    if (iSize.getRatioFloat() > sSize.getRatioFloat()) {
                        if (iSize.getRatioFloat() > 1.0f) {
                            fixScale2 = (1.0f / sRatio) * (1.0f / iRatio);
                            break;
                        } else {
                            fixScale2 = 1.0f / sRatio;
                            break;
                        }
                    } else {
                        if (iSize.getRatioFloat() < 1.0f) {
                            fixScale2 = 1.0f / iRatio;
                            break;
                        }
                        fixScale2 = 1.0f;
                        break;
                    }
                } else {
                    if (sSize.getRatioFloat() > 1.0f) {
                        if (iSize.getRatioFloat() > sSize.getRatioFloat()) {
                            fixScale2 = 1.0f / iRatio;
                            break;
                        } else if (iSize.getRatioFloat() < 1.0f) {
                            fixScale2 = (1.0f / iRatio) * (1.0f / sRatio);
                            break;
                        } else {
                            fixScale2 = (1.0f / iRatio) * (iRatio / sRatio);
                            break;
                        }
                    }
                    fixScale2 = 1.0f;
                }
            default:
                fixScale = 1.0f;
                if (iRatio != 1.0f) {
                }
                fixScale2 = fixScale;
                break;
        }
        BiliMatrix.scaleM(this.mModelMatrix, 0, fixScale2, fixScale2, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        float wRatio = (Math.abs(imageRect.left) + Math.abs(imageRect.right)) / 2.0f;
        float hRatio = (Math.abs(imageRect.top) + Math.abs(imageRect.bottom)) / 2.0f;
        outImgSize.width = (int) (sSize.minSide() * wRatio * fixScale2);
        outImgSize.height = (int) (sSize.minSide() * hRatio * fixScale2);
        this.mOriginDisplayImgSize.width = outImgSize.width;
        this.mOriginDisplayImgSize.height = outImgSize.height;
        if (this.mScreenSize.width <= this.mScreenSize.height) {
            float aspectRatio = this.mScreenSize.height / this.mScreenSize.width;
            BiliMatrix.orthoM(this.mProjectMatrix, 0, -1.0f, 1.0f, (-aspectRatio) * 1.0f, aspectRatio * 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10.0f);
        } else {
            float aspectRatio2 = this.mScreenSize.getRatioFloat();
            BiliMatrix.orthoM(this.mProjectMatrix, 0, (-aspectRatio2) * 1.0f, aspectRatio2 * 1.0f, -1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10.0f);
        }
        float tx = this.mTranslateX / this.mOriginDisplayImgSize.width;
        float ty = this.mTranslateY / this.mOriginDisplayImgSize.height;
        float transX = tx == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? tx : (this.mImageRectF.right - this.mImageRectF.left) * tx;
        float transY = ty == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? ty : (this.mImageRectF.bottom - this.mImageRectF.top) * ty;
        BiliMatrix.translateM(this.mModelMatrix, 0, transX, transY, this.mTranslateZ);
        float scaleX = this.mScaleX;
        float scaleY = this.mScaleY;
        float scaleZ = this.mScaleZ;
        Iterator<Integer> it = this.mMirrorMap.keySet().iterator();
        float scaleY2 = rotateZ;
        float rotateZ2 = scaleY;
        float scaleZ2 = scaleZ;
        float scaleZ3 = scaleX;
        while (it.hasNext()) {
            Iterator<Integer> it2 = it;
            Integer item = it.next();
            float fixScale3 = fixScale2;
            switch (this.mMirror) {
                case 0.0f:
                    if (!this.mMirrorMap.get(item).booleanValue()) {
                        break;
                    } else {
                        float scaleX2 = -scaleZ3;
                        scaleY2 = -scaleY2;
                        scaleZ3 = scaleX2;
                        break;
                    }
                case Float.MIN_VALUE:
                    if (!this.mMirrorMap.get(item).booleanValue()) {
                        break;
                    } else {
                        rotateZ2 = -rotateZ2;
                        break;
                    }
                case 2.8E-45f:
                    if (!this.mMirrorMap.get(item).booleanValue()) {
                        break;
                    } else {
                        scaleZ2 = -scaleZ2;
                        break;
                    }
            }
            it = it2;
            fixScale2 = fixScale3;
        }
        BiliMatrix.scaleM(this.mModelMatrix, 0, scaleZ3, rotateZ2, scaleZ2);
        outImgSize.width = (int) (outImgSize.width * scaleZ3);
        outImgSize.height = (int) (outImgSize.height * rotateZ2);
        float rotateZ3 = scaleY2;
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateX, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateY, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateZ3, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectMatrix, 0, this.mModelMatrix, 0);
        synchronized (this.mTransformImgSize) {
            this.mTransformImgSize.width = outImgSize.width;
            this.mTransformImgSize.height = outImgSize.height;
        }
    }

    private void calcInputRectMatrix() {
        BiliMatrix.setIdentityM(this.mModelMatrix, 0);
        BiliMatrix.setIdentityM(this.mProjectMatrix, 0);
        float rotateX = -this.mRotateX;
        float rotateY = -this.mRotateY;
        float rotateZ = -this.mRotateZ;
        if (!this.mScreenSize.isSize() || !this.mImageSize.isSize()) {
            BLog.e(TAG, "calcMatrix is not size  image:" + this.mImageSize + " screen:" + this.mScreenSize);
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mMVPMatrix, 0, this.mProjectMatrix, 0);
            return;
        }
        if (this.mScreenSize.width <= this.mScreenSize.height) {
            float aspectRatio = this.mScreenSize.height / this.mScreenSize.width;
            BiliMatrix.orthoM(this.mProjectMatrix, 0, -1.0f, 1.0f, (-aspectRatio) * 1.0f, aspectRatio * 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10.0f);
        } else {
            float aspectRatio2 = this.mScreenSize.getRatioFloat();
            BiliMatrix.orthoM(this.mProjectMatrix, 0, (-aspectRatio2) * 1.0f, aspectRatio2 * 1.0f, -1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10.0f);
        }
        float transX = (this.mTranslateX / this.mScreenSize.minSide()) * 2.0f;
        float transY = (this.mTranslateY / this.mScreenSize.minSide()) * 2.0f;
        BiliMatrix.translateM(this.mModelMatrix, 0, this.offset.x + transX, this.offset.y - transY, this.mTranslateZ);
        float scaleX = this.mScaleX;
        float scaleY = this.mScaleY;
        float scaleZ = this.mScaleZ;
        float rotateZ2 = rotateZ;
        float scaleX2 = scaleX;
        float scaleY2 = scaleY;
        float scaleZ2 = scaleZ;
        for (Integer item : this.mMirrorMap.keySet()) {
            switch (this.mMirror) {
                case 0:
                    if (this.mMirrorMap.get(item).booleanValue()) {
                        scaleX2 = -scaleX2;
                        rotateZ2 = -rotateZ2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (this.mMirrorMap.get(item).booleanValue()) {
                        scaleY2 = -scaleY2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (this.mMirrorMap.get(item).booleanValue()) {
                        scaleZ2 = -scaleZ2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        BiliMatrix.scaleM(this.mModelMatrix, 0, scaleX2, scaleY2, scaleZ2);
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateX, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateY, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        BiliMatrix.rotateM(this.mModelMatrix, 0, rotateZ2, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectMatrix, 0, this.mModelMatrix, 0);
    }
}