package tv.danmaku.ijk.media.player.render.transform;

import android.opengl.Matrix;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class BiliTranslation implements ITransform {
    private static final String TAG = "BiliTranslation";
    private float mTransX = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mTransY = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    private float mTransZ = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;

    public BiliTranslation(float transX, float transY, float transZ) {
        translation(transX, transY, transZ);
    }

    public void translation(float transX, float transY, float transZ) {
        this.mTransX = transX;
        this.mTransY = transY;
        this.mTransZ = transZ;
    }

    @Override // tv.danmaku.ijk.media.player.render.transform.ITransform
    public float[] calcTransForModel(float[] modelMatrix) {
        if (modelMatrix == null || modelMatrix.length < 16) {
            BLog.w(TAG, "model matrix is invalid!");
            float[] matrix = new float[16];
            Matrix.setIdentityM(matrix, 0);
            return matrix;
        }
        float[] localModelMatrix = (float[]) modelMatrix.clone();
        Matrix.translateM(localModelMatrix, 0, this.mTransX, this.mTransY, this.mTransZ);
        return localModelMatrix;
    }
}