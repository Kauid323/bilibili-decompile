package tv.danmaku.ijk.media.player.render.output;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.IjkGLUtils;

public class BiliTerminalOprationOESRenderer extends BiliTerminalOprationRenderer {
    public static final String BILI_OPRATION_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
    private static final String BILI_OPRATION_FRAGMENT_SHADER_HDR = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nuniform vec3 dst_luma;\nuniform mat3 cms_matrix;\nuniform int  render_hdr;\nfloat _hable_3_0(float x) {\n    return ((x * (0.150000*x + 0.050000)+0.004000)/(x * (0.150000*x + 0.500000) + 0.060000)) - 0.066667;\n}\nvec4 _main_4_0(vec4 color) {\n{\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/78.843750));\n        color.rgb = max(color.rgb - vec3(0.835938), 0.0)\n        / (vec3(18.851562) - vec3(18.687500) * color.rgb);\n        color.rgb = pow(color.rgb, vec3(1.0/0.159302));\n        color.rgb *= vec3(110);\n        color.rgb = cms_matrix * color.rgb;\n\n        float sig = max(max(color.r, color.g), color.b);\n        float sig_peak = 100.000000;\n        float sig_avg = 0.250000;\n        float luma = dot(dst_luma, color.rgb);\n        float coeff = max(sig - 0.18, 1e-6) / max(sig, 1e-6);\n        coeff = pow(coeff, 20.0);\n        color.rgb = mix(color.rgb, vec3(luma), coeff);\n        sig = mix(sig, luma, coeff);\n        float sig_orig = sig;\n        float slope = min(1.0, 0.250000 / sig_avg);\n        sig *= slope;\n        sig_peak *= slope;\n        sig = _hable_3_0(sig) / _hable_3_0(sig_peak);\n        sig = min(sig, 1.0);\n        color.rgb *= sig / sig_orig;\n\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/2.2));\n    }\n    return color;\n}\n\nuniform vec4 FillColor;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    if(render_hdr > 0){         gl_FragColor = _main_4_0(gl_FragColor);\n       gl_FragColor = gl_FragColor * FillColor ;\n}}";
    public static final String BILI_OPRATION_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;uniform mat4 matrix;uniform mat4 um4TexTransformMatrix;void main(){    gl_Position =matrix * position;    textureCoordinate = (inputTextureCoordinate * um4TexTransformMatrix).xy;}";
    public static final int RENDER_HDR = 1;
    public static final int RENDER_NORMAL = 0;
    private int _cmsMatrix;
    private int _dstLuma;
    private int _fillColor;
    private int _renderHdr;
    private boolean isHDRRender;
    private float[] mUm4Matrix;
    private int mUm4TexTransformMatrix;
    private float[] martix_2020;

    public BiliTerminalOprationOESRenderer() {
        super(BILI_OPRATION_SHADER, BILI_OPRATION_FRAGMENT_SHADER_HDR);
        this.mUm4Matrix = new float[16];
        this.martix_2020 = new float[]{1.660497f, -0.124547064f, -0.018153682f, -0.58765674f, 1.1328952f, -0.10059729f, -0.072839946f, -0.008347984f, 1.118751f};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        this.mUm4TexTransformMatrix = this.mDisplayProgram.uniformIndex("um4TexTransformMatrix");
        this._dstLuma = this.mDisplayProgram.uniformIndex("dst_luma");
        this._cmsMatrix = this.mDisplayProgram.uniformIndex("cms_matrix");
        this._fillColor = this.mDisplayProgram.uniformIndex("FillColor");
        this._renderHdr = this.mDisplayProgram.uniformIndex("render_hdr");
        GLES20.glUniform1i(this._renderHdr, this.isHDRRender ? 1 : 0);
        GLES20.glUniform3f(this._dstLuma, 0.21263677f, 0.715183f, 0.07218021f);
        GLES20.glUniformMatrix3fv(this._cmsMatrix, 1, false, this.martix_2020, 0);
        GLES20.glUniform4f(this._fillColor, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationRenderer
    protected void renderToTexture(long frameTime, FloatBuffer vertices, FloatBuffer textureCoordinates) {
        float[] matrix;
        if (this.mInputFramebufferForDisplay == null) {
            return;
        }
        if (BiliRenderContext.currentEGLContext() == EGL10.EGL_NO_CONTEXT) {
            BLog.e("BiliTerminalRenderer", "render to texture egl context is EGL_NO_CONTEXT !");
            return;
        }
        BiliRenderContext.setActiveShaderProgram(this.mDisplayProgram);
        IjkGLUtils.checkGlError("use program");
        GLES20.glBindFramebuffer(36160, 0);
        if (!maximumOutputSize().isSize()) {
            BLog.e("BiliTerminalRenderer", "render to texture viewport is invalid ! " + maximumOutputSize());
        }
        GLES20.glViewport(0, 0, maximumOutputSize().getWidth(), maximumOutputSize().getHeight());
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(36197, getInputFramebufferTexture());
        IjkGLUtils.checkGlError("active texture");
        GLES20.glUniform1i(this.mDisplayInputTextureUniform, 4);
        if (this.mMatrixIndex == -1) {
            BLog.w("BiliTerminalRenderer", "Matrix index is -1 !");
        }
        switch (this.mVerticesMode) {
            case 0:
                matrix = this.mMVPMatrix.getMatrix();
                break;
            case 1:
                matrix = this.mMVPMatrix.getMatrixForInput();
                break;
            default:
                matrix = this.mMVPMatrix.getMatrix();
                break;
        }
        GLES20.glUniformMatrix4fv(this.mMatrixIndex, 1, false, matrix, 0);
        IjkGLUtils.checkGlError("uniform matrix");
        GLES20.glVertexAttribPointer(this.mDisplayPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
        GLES20.glVertexAttribPointer(this.mDisplayTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
        IjkGLUtils.checkGlError("vertex attrib");
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    public void setSurfaceTextureMatrix(final float[] matrix) {
        if (matrix.length != 16) {
            BLog.w("BiliTerminalRenderer", "surface texture matrix length error ! length:" + matrix.length);
            return;
        }
        System.arraycopy(matrix, 0, this.mUm4Matrix, 0, matrix.length);
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationOESRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                Matrix.multiplyMM(BiliTerminalOprationOESRenderer.this.mUm4Matrix, 0, BiliTerminalOprationRenderer.mtxFlipV, 0, matrix, 0);
                GLES20.glUniformMatrix4fv(BiliTerminalOprationOESRenderer.this.mUm4TexTransformMatrix, 1, false, BiliTerminalOprationOESRenderer.this.mUm4Matrix, 0);
            }
        });
    }

    public void enableHDR(final boolean enable) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliTerminalOprationOESRenderer.2
            @Override // java.lang.Runnable
            public void run() {
                BiliTerminalOprationOESRenderer.this.isHDRRender = enable;
                GLES20.glUniform1i(BiliTerminalOprationOESRenderer.this._renderHdr, enable ? 1 : 0);
            }
        });
    }
}