package tv.danmaku.ijk.media.player.render;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.IjkGLUtils;
import tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer;

public class IjkExternalOESRenderer {
    private static final String TAG = "GLTextureRender";
    private static final String _fragmentShaderEOS = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String _vertexShader = "attribute vec4 v_Position;\nattribute vec4 f_Position;\nvarying vec2 vTextureCoord;\nuniform mat4 um4TexTransformMatrix;void main() {\n    vTextureCoord = (f_Position * um4TexTransformMatrix).xy;\n    gl_Position = v_Position;\n}";
    private int _fPosition;
    private int _program;
    private int _texture;
    private int _um4Position;
    private int _vPosition;
    private float mBackgroundColorBlue;
    private float mBackgroundColorGreen;
    private float mBackgroundColorRed;
    final float[] _vertexCoordinate = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    final float[] _vertexCoordinate_1 = {-1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -1.0f, -1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -1.0f};
    final float[] _vertexCoordinate_2 = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
    final float[] _textureCoordinate = {DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f};
    private float[] um4Matrix = new float[16];
    private float mBackgroundColorAlpha = 1.0f;
    private FloatBuffer _vertexBuffer = IjkGLUtils.createFloatBuffer(this._vertexCoordinate);
    private FloatBuffer _vertexBuffer_1 = IjkGLUtils.createFloatBuffer(this._vertexCoordinate_1);
    private FloatBuffer _vertexBuffer_2 = IjkGLUtils.createFloatBuffer(this._vertexCoordinate_2);
    private FloatBuffer _textureBuffer = IjkGLUtils.createFloatBuffer(this._textureCoordinate);

    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
    }

    public void onSurfaceCreate() {
        this._program = IjkGLUtils.createProgram(_vertexShader, _fragmentShaderEOS);
        this._vPosition = GLES20.glGetAttribLocation(this._program, "v_Position");
        this._fPosition = GLES20.glGetAttribLocation(this._program, "f_Position");
        this._texture = GLES20.glGetUniformLocation(this._program, "sTexture");
        this._um4Position = GLES20.glGetUniformLocation(this._program, "um4TexTransformMatrix");
    }

    public void draw(int texture, int texture1) {
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this._program);
        IjkGLUtils.checkGlError("GLTextureRender use programe");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, texture);
        GLES20.glUniform1i(this._texture, 0);
        IjkGLUtils.checkGlError("GLTextureRender bind texture");
        GLES20.glEnableVertexAttribArray(this._vPosition);
        GLES20.glVertexAttribPointer(this._vPosition, 2, 5126, false, 0, (Buffer) this._vertexBuffer_1);
        IjkGLUtils.checkGlError("GLTextureRender enable vertex");
        GLES20.glEnableVertexAttribArray(this._fPosition);
        GLES20.glVertexAttribPointer(this._fPosition, 2, 5126, false, 0, (Buffer) this._textureBuffer);
        IjkGLUtils.checkGlError("GLTextureRender enable position");
        float[] matrix = new float[16];
        Matrix.multiplyMM(matrix, 0, BiliTerminalOprationRenderer.mtxFlipV, 0, this.um4Matrix, 0);
        GLES20.glUniformMatrix4fv(this._um4Position, 1, false, matrix, 0);
        IjkGLUtils.checkGlError("GLTextureRender matrix");
        GLES20.glDrawArrays(5, 0, 4);
        IjkGLUtils.checkGlError("GLTextureRender draw");
        GLES20.glBindTexture(36197, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, texture1);
        GLES20.glUniform1i(this._texture, 0);
        IjkGLUtils.checkGlError("GLTextureRender bind texture");
        GLES20.glEnableVertexAttribArray(this._vPosition);
        GLES20.glVertexAttribPointer(this._vPosition, 2, 5126, false, 0, (Buffer) this._vertexBuffer_2);
        IjkGLUtils.checkGlError("GLTextureRender enable vertex");
        GLES20.glDrawArrays(5, 0, 4);
        IjkGLUtils.checkGlError("GLTextureRender draw");
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        IjkGLUtils.checkGlError("GLTextureRender unbind texture");
    }

    public void draw(int texture) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this._program);
        IjkGLUtils.checkGlError("GLTextureRender use programe");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, texture);
        GLES20.glUniform1i(this._texture, 0);
        IjkGLUtils.checkGlError("GLTextureRender bind texture");
        GLES20.glEnableVertexAttribArray(this._vPosition);
        GLES20.glVertexAttribPointer(this._vPosition, 2, 5126, false, 0, (Buffer) this._vertexBuffer);
        IjkGLUtils.checkGlError("GLTextureRender enable vertex");
        GLES20.glEnableVertexAttribArray(this._fPosition);
        GLES20.glVertexAttribPointer(this._fPosition, 2, 5126, false, 0, (Buffer) this._textureBuffer);
        IjkGLUtils.checkGlError("GLTextureRender enable position");
        float[] matrix = new float[16];
        Matrix.multiplyMM(matrix, 0, BiliTerminalOprationRenderer.mtxFlipV, 0, this.um4Matrix, 0);
        GLES20.glUniformMatrix4fv(this._um4Position, 1, false, matrix, 0);
        IjkGLUtils.checkGlError("GLTextureRender matrix");
        GLES20.glDrawArrays(5, 0, 4);
        IjkGLUtils.checkGlError("GLTextureRender draw");
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        IjkGLUtils.checkGlError("GLTextureRender unbind texture");
    }

    public void setSurfaceTextureMatrix(float[] matrix) {
        if (matrix.length != 16) {
            return;
        }
        System.arraycopy(matrix, 0, this.um4Matrix, 0, matrix.length);
    }

    public void release() {
        if (this._program != 0) {
            GLES20.glDeleteProgram(this._program);
        }
        if (this._texture != 0) {
            GLES20.glDeleteTextures(0, new int[]{this._texture}, 0);
        }
    }
}