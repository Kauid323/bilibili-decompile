package tv.danmaku.ijk.media.player.render.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.BiliVertexBuffer;
import tv.danmaku.ijk.media.player.render.tools.BiliMatrix;
import tv.danmaku.ijk.media.player.render.tools.BiliSensorEntity;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class BiliPanoramaFilter extends BiliFilter {
    public static final String BILI_OPRATION_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main(){     gl_FragColor = texture2D(inputImageTexture,textureCoordinate);}";
    public static final String BILI_OPRATION_SHADER = "attribute vec3 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;uniform mat4 matrix;\nvoid main(){    gl_Position = matrix * vec4(position.x, -position.y, position.z, 1.0);    textureCoordinate = inputTextureCoordinate;}";
    public static final int PANORAMA_GYROSCOPE = 1;
    public static final int PANORAMA_GYROSCOPE_TOUCH = 3;
    public static final int PANORAMA_NONE = 0;
    public static final int PANORAMA_TOUCH = 2;
    private int mMatrixIndex;
    private int mOperationModel;
    private volatile BiliSensorEntity mSensorEntity;
    private PanoramaShape mShape;

    public BiliPanoramaFilter() {
        super(BILI_OPRATION_SHADER, "varying highp vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main(){     gl_FragColor = texture2D(inputImageTexture,textureCoordinate);}");
        this.mOperationModel = 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        this.mMatrixIndex = this.mFilterProgram.uniformIndex(BiliMVPMatrix.BILI_MATRIX);
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        if (this.mFirstInputFramebuffer == null) {
            return;
        }
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(textureCoordinates(BiliImageOrientation.Down)).position(0);
        renderToTexture(this.mVerticesBuffer, this.mTextureBuffer);
        informTargetsAboutNewFrame(frameTimeUs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        runPendingOnDrawTasks();
        if (this.mFirstInputFramebuffer == null) {
            return;
        }
        BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
        if (this.mOutputFrameBuffer == null || !outputFrameSize().equals(this.mOutputFrameBuffer.getSize())) {
            if (this.mOutputFrameBuffer != null) {
                this.mOutputFrameBuffer.recycle();
            }
            BiliFrameBufferCache framebufferCache = BiliRenderContext.sharedFramebufferCache();
            if (framebufferCache == null) {
                return;
            }
            this.mOutputFrameBuffer = framebufferCache.fetchFramebuffer(outputFrameSize().getWidth(), outputFrameSize().getHeight(), getOutputTextureOptions());
            this.mOutputFrameBuffer.setReferenceDisabled(true);
        }
        this.mOutputFrameBuffer.use();
        setUniformsForProgramAtIndex(0);
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        inputFramebufferBindTexture();
        float[] matrix = new float[16];
        if (this.mShape == null) {
            this.mShape = new PanoramaShape();
            this.mShape.init();
        }
        float aspect = outputFrameSize().getRatioFloat();
        float perspective = this.mShape.getPerspective();
        BiliMatrix.perspectiveM(matrix, 0, perspective, aspect, 0.001f, 100.0f);
        BiliMatrix.rotateM(matrix, 0, 180.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        BiliMatrix.rotateM(matrix, 0, 2.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        if (this.mOperationModel >= 2) {
            float angleX = -this.mShape.angleX;
            float angleY = -this.mShape.angleY;
            BiliMatrix.rotateM(matrix, 0, angleY, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            BiliMatrix.rotateM(matrix, 0, angleX, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        if (this.mSensorEntity != null && (this.mOperationModel == 1 || this.mOperationModel == 3)) {
            BiliMatrix.rotateM(matrix, 0, -this.mSensorEntity.angleX, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            BiliMatrix.rotateM(matrix, 0, this.mSensorEntity.angleY, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        this.mShape.mVertexBuffer.activateVertexbuffer();
        GLES20.glBindBuffer(34963, this.mShape.mEbo);
        GLES20.glEnable(2929);
        GLES20.glUniformMatrix4fv(this.mMatrixIndex, 1, false, BiliFilter.buildBuffer(matrix));
        GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 3, 5126, false, 20, 0);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 20, 12);
        GLES20.glDrawElements(4, this.mShape.indicesCount, 5123, 0);
        GLES20.glFlush();
        GLES20.glBindTexture(3553, 0);
        this.mShape.mVertexBuffer.disableVertexbuffer();
        GLES20.glBindBuffer(34963, 0);
        inputFramebufferUnlock();
    }

    public void setSensorMatrix(BiliSensorEntity sensorEntity) {
        this.mSensorEntity = sensorEntity;
    }

    public void setRotation(float x, float y) {
        if (this.mShape == null) {
            return;
        }
        this.mShape.setRotation(x, y);
    }

    public void setOperationModel(int model) {
        this.mOperationModel = model;
    }

    public void setPerspective(float perspective) {
        if (this.mShape == null) {
            return;
        }
        this.mShape.setPerspective(perspective);
    }

    public void destroy() {
        if (this.mOutputFrameBuffer != null) {
            this.mOutputFrameBuffer.recycle();
        }
        this.mOutputFrameBuffer = null;
        if (this.mShape != null) {
            this.mShape.destroy();
        }
        this.mShape = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PanoramaShape {
        public static final float DEFAULT_PERSPECTIVE = 85.0f;
        public static final float MAX_PERSPECTIVE = 100.0f;
        public static final float MIN_PERSPECTIVE = 30.0f;
        private float angleX;
        private float angleY;
        private int indicesCount;
        private int mEbo;
        private short[] mIndices;
        private BiliVertexBuffer mVertexBuffer;
        private float[] mVertices;
        private float perspective;
        private float[] srcQuaternion;

        private PanoramaShape() {
            this.perspective = 85.0f;
            this.srcQuaternion = new float[16];
        }

        public void init() {
            Matrix.setIdentityM(this.srcQuaternion, 0);
            genSphereWithSlices(100, 1.0f);
            this.mVertexBuffer = new BiliVertexBuffer(BiliFilter.buildBuffer(this.mVertices));
            ByteBuffer buffer = ByteBuffer.allocateDirect(this.mIndices.length * 2);
            buffer.order(ByteOrder.nativeOrder());
            ShortBuffer indicesBuff = buffer.asShortBuffer();
            indicesBuff.put(this.mIndices);
            indicesBuff.position(0);
            int[] ebos = new int[2];
            GLES20.glGenBuffers(1, ebos, 0);
            this.mEbo = ebos[0];
            GLES20.glBindBuffer(34963, this.mEbo);
            GLES20.glBufferData(34963, indicesBuff.limit() * 2, indicesBuff, 35044);
        }

        public void genSphereWithSlices(int slices, float radius) {
            int numParallels = slices / 2;
            int numVertices = (numParallels + 1) * (slices + 1);
            int numIndices = numParallels * slices * 6;
            float angleStep = (float) (6.283185307179586d / slices);
            this.mVertices = new float[numVertices * 5];
            this.mIndices = new short[numIndices];
            for (int i = 0; i < numParallels + 1; i++) {
                for (int j = 0; j < slices + 1; j++) {
                    int vertex = (((slices + 1) * i) + j) * 5;
                    this.mVertices[vertex + 0] = (float) (radius * Math.sin(i * angleStep) * Math.sin(j * angleStep));
                    this.mVertices[vertex + 1] = (float) (radius * Math.cos(i * angleStep));
                    this.mVertices[vertex + 2] = (float) (radius * Math.sin(i * angleStep) * Math.cos(j * angleStep));
                    this.mVertices[vertex + 3] = j / slices;
                    this.mVertices[vertex + 4] = 1.0f - (i / numParallels);
                }
            }
            int index = 0;
            for (int i2 = 0; i2 < numParallels; i2++) {
                int j2 = 0;
                while (j2 < slices) {
                    int index2 = index + 1;
                    this.mIndices[index] = (short) (((slices + 1) * i2) + j2);
                    int index3 = index2 + 1;
                    this.mIndices[index2] = (short) (((i2 + 1) * (slices + 1)) + j2);
                    int index4 = index3 + 1;
                    this.mIndices[index3] = (short) (((i2 + 1) * (slices + 1)) + j2 + 1);
                    int index5 = index4 + 1;
                    this.mIndices[index4] = (short) (((slices + 1) * i2) + j2);
                    int index6 = index5 + 1;
                    this.mIndices[index5] = (short) (((i2 + 1) * (slices + 1)) + j2 + 1);
                    this.mIndices[index6] = (short) (((slices + 1) * i2) + j2 + 1);
                    j2++;
                    index = index6 + 1;
                }
            }
            this.indicesCount = numIndices;
        }

        public float getPerspective() {
            return Math.min(Math.max(this.perspective, 30.0f), 100.0f);
        }

        public void destroy() {
            if (this.mVertexBuffer != null) {
                this.mVertexBuffer.deleteBuffer();
            }
            GLES20.glDeleteBuffers(1, new int[]{this.mEbo}, 0);
        }

        public void setRotation(float x, float y) {
            this.angleX = x;
            this.angleY = y;
        }

        public void setPerspective(float perspective) {
            if (perspective <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || perspective > 100.0f) {
                BLog.w(BiliFilter.TAG, "set invalid perspective : " + perspective);
            } else {
                this.perspective = perspective;
            }
        }
    }
}