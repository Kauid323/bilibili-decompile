package tv.danmaku.ijk.media.player.render.filter;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Pair;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Queue;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.IDolbyHDRApi;
import tv.danmaku.ijk.media.player.render.IHdrVividProcess;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliOESRetrieval extends BiliFilter {
    private static final String BILI_OPRATION_FRAGMENT_SHADER_HDR = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nuniform vec3 dst_luma;\nuniform mat3 cms_matrix;\nuniform int  render_hdr;uniform int  enableDaltonism;\nuniform mat4 daltonizerMatrix;\n\nfloat _hable_3_0(float x) {\n    return ((x * (0.150000*x + 0.050000)+0.004000)/(x * (0.150000*x + 0.500000) + 0.060000)) - 0.066667;\n}\nvec4 _main_4_0(vec4 color) {\n{\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/78.843750));\n        color.rgb = max(color.rgb - vec3(0.835938), 0.0)\n        / (vec3(18.851562) - vec3(18.687500) * color.rgb);\n        color.rgb = pow(color.rgb, vec3(1.0/0.159302));\n        color.rgb *= vec3(110);\n        color.rgb = cms_matrix * color.rgb;\n\n        float sig = max(max(color.r, color.g), color.b);\n        float sig_peak = 110.000000;\n        float sig_avg = 0.250000;\n        float luma = dot(dst_luma, color.rgb);\n        float coeff = max(sig - 0.18, 1e-6) / max(sig, 1e-6);\n        coeff = pow(coeff, 20.0);\n        color.rgb = mix(color.rgb, vec3(luma), coeff);\n        sig = mix(sig, luma, coeff);\n        float sig_orig = sig;\n        float slope = min(1.0, 0.250000 / sig_avg);\n        sig *= slope;\n        sig_peak *= slope;\n        sig = _hable_3_0(sig) / _hable_3_0(sig_peak);\n        sig = min(sig, 1.0);\n        color.rgb *= sig / sig_orig;\n\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/2.2));\n    }\n    return color;\n}\n\n highp vec3 OutputTransform(const highp vec3 color) {\n       return clamp(vec3(daltonizerMatrix * vec4(color, 1.0)), 0.0, 1.0);\n}\nuniform vec4 FillColor;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);    if (enableDaltonism > 0) {\n       gl_FragColor = vec4(OutputTransform(gl_FragColor.rgb),1.0);\n    }\n     if(render_hdr > 0){         gl_FragColor = _main_4_0(gl_FragColor);\n       gl_FragColor = gl_FragColor * FillColor ;\n}}";
    private static final String BILI_OPRATION_FRAGMENT_SHADER_HDR_V2 = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision highp float;\nout vec4 fragColor;\nuniform vec3 dst_luma;\nuniform mat3 cms_matrix;\nuniform int  render_hdr;uniform int  enableDaltonism;\nuniform mat4 daltonizerMatrix;\nuniform int  is_vivid;\nuniform sampler2D vivid_GTMcurve;\n\nfloat dMin(float a, float b) {\n   return ((a) < (b)) ? (a) : (b);\n}\n\nfloat dMax(float a, float b) {\n   return ((a) > (b)) ? (a) : (b);\n}\n\nfloat dClip(float x, float low, float high) {\n   x = dMax(x, low);\n   x = dMin(x, high);\n   return x;\n}\nvec4 vivid_tonemapping(vec4 color, sampler2D curve) {\n    float r = dClip(color.r, 0.0, 1.0);\n    float g = dClip(color.g, 0.0, 1.0);\n    float b = dClip(color.b, 0.0, 1.0);\n\n    float maxRGB = dMax(dMax(r, g), b);\n    maxRGB = dClip(maxRGB, 0.0, 1.0);\n\n    float index = maxRGB * 1023.0;\n    int index0 = int(index);\n    int index1 = min(index0 + 1, 1023);\n    float maxRGBAfterbefore = texelFetch(curve, ivec2(index0, 0), 0).a;\n    float maxRGBAfterafter  = texelFetch(curve, ivec2(index1, 0), 0).a;\n    float before = float(index0);\n    float after = float(index1);\n    float mid = index;\n    float maxRGBAfter = maxRGBAfterbefore * (after - mid) + maxRGBAfterafter * (mid - before);\n    maxRGBAfter = dClip(maxRGBAfter, 0.0, 1.0);\n\n    float ratio = 1.0;\n    float _266 = maxRGB;\n    if (_266 != 0.0) {\n        float param_20 = maxRGBAfter;\n        float _272 = param_20;\n        float param_21 = maxRGB;\n        float _275 = param_21;\n        ratio = _272 / _275;\n    }\n    ratio = dClip(ratio, 0.0, 1.0);\n    float r_linear = 0.0;\n    float g_linear = 0.0;\n    float b_linear = 0.0;\n    if(maxRGB != 0.0) {\n        r_linear = r * ratio;\n        g_linear = g * ratio;\n        b_linear = b * ratio;\n        r_linear = dClip(r_linear,0.0,1.0);\n        g_linear = dClip(g_linear,0.0,1.0);\n        b_linear = dClip(b_linear,0.0,1.0);\n    }\n    return vec4(r_linear, g_linear, b_linear, 1.0);\n}\nfloat _hable_3_0(float x) {\n    return ((x * (0.150000*x + 0.050000)+0.004000)/(x * (0.150000*x + 0.500000) + 0.060000)) - 0.066667;\n}\nvec4 _main_4_0(vec4 color) {\n{\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/78.843750));\n        color.rgb = max(color.rgb - vec3(0.835938), 0.0)\n        / (vec3(18.851562) - vec3(18.687500) * color.rgb);\n        color.rgb = pow(color.rgb, vec3(1.0/0.159302));\n        color.rgb *= vec3(110);\n        color.rgb = cms_matrix * color.rgb;\n\n        float sig = max(max(color.r, color.g), color.b);\n        float sig_peak = 110.000000;\n        float sig_avg = 0.250000;\n        float luma = dot(dst_luma, color.rgb);\n        float coeff = max(sig - 0.18, 1e-6) / max(sig, 1e-6);\n        coeff = pow(coeff, 20.0);\n        color.rgb = mix(color.rgb, vec3(luma), coeff);\n        sig = mix(sig, luma, coeff);\n        float sig_orig = sig;\n        float slope = min(1.0, 0.250000 / sig_avg);\n        sig *= slope;\n        sig_peak *= slope;\n        sig = _hable_3_0(sig) / _hable_3_0(sig_peak);\n        sig = min(sig, 1.0);\n        color.rgb *= sig / sig_orig;\n\n        color.rgb = max(color.rgb, 0.0);\n        color.rgb = pow(color.rgb, vec3(1.0/2.2));\n    }\n    return color;\n}\n\n highp vec3 OutputTransform(const highp vec3 color) {\n       return clamp(vec3(daltonizerMatrix * vec4(color, 1.0)), 0.0, 1.0);\n}\nuniform vec4 FillColor;\nin vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main(void) {\n    fragColor = texture(inputImageTexture, textureCoordinate);    if (enableDaltonism > 0) {\n       fragColor = vec4(OutputTransform(fragColor.rgb),1.0);\n    }\n    if(is_vivid > 0) {\n       fragColor = vivid_tonemapping(fragColor,vivid_GTMcurve);\n    } else if(render_hdr > 0) {\n      fragColor = _main_4_0(fragColor);\n      fragColor = fragColor * FillColor ;\n    }\n}";
    public static final String BILI_OPRATION_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;uniform mat4 um4TexTransformMatrix;void main(){    gl_Position = position;    textureCoordinate = (inputTextureCoordinate * um4TexTransformMatrix).xy;}";
    public static final String BILI_OPRATION_SHADER_V2 = "#version 300 es\nin vec4 position;in vec4 inputTextureCoordinate;out vec2 textureCoordinate;uniform mat4 um4TexTransformMatrix;void main(){    gl_Position = position;    textureCoordinate = (inputTextureCoordinate * um4TexTransformMatrix).xy;}";
    private static final String TAG = BiliOESRetrieval.class.getName();
    public static final float[] mtxFlipV = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
    private int _cmsMatrix;
    private int _daltonizerMatrix;
    private int _dstLuma;
    private int _enableDaltonism;
    private int _fillColor;
    private int _is_vivid;
    private int _renderHdr;
    private int _vivid_GTMcurve;
    private int gtmCurveTextureID;
    private boolean isDolbyHDR;
    private boolean isHDRRender;
    private boolean isHdrVivid;
    private BiliDaltonizer mDaltonizer;
    private boolean mDaltonizerChangend;
    private IDolbyHDRApi mDolbyHDR;
    private boolean mEnableDaltonism;
    private IHdrVividProcess mHdrVivid;
    private boolean mSupportVivid;
    private float[] mUm4Matrix;
    private int mUm4TexTransformMatrix;
    private float[] martix_2020;

    public BiliOESRetrieval(boolean supportVivid) {
        super(supportVivid ? BILI_OPRATION_SHADER_V2 : BILI_OPRATION_SHADER, supportVivid ? BILI_OPRATION_FRAGMENT_SHADER_HDR_V2 : BILI_OPRATION_FRAGMENT_SHADER_HDR);
        this.mUm4Matrix = new float[16];
        this.martix_2020 = new float[]{1.660497f, -0.124547064f, -0.018153682f, -0.58765674f, 1.1328952f, -0.10059729f, -0.072839946f, -0.008347984f, 1.118751f};
        this.mSupportVivid = supportVivid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        this.mUm4TexTransformMatrix = this.mFilterProgram.uniformIndex("um4TexTransformMatrix");
        this._dstLuma = this.mFilterProgram.uniformIndex("dst_luma");
        this._cmsMatrix = this.mFilterProgram.uniformIndex("cms_matrix");
        this._fillColor = this.mFilterProgram.uniformIndex("FillColor");
        this._renderHdr = this.mFilterProgram.uniformIndex("render_hdr");
        this._daltonizerMatrix = this.mFilterProgram.uniformIndex("daltonizerMatrix");
        this._enableDaltonism = this.mFilterProgram.uniformIndex("enableDaltonism");
        this.mDaltonizer = new BiliDaltonizer();
        this.mDaltonizer.setType(BiliDaltonizer.ColorBlindnessType.None);
        this.mDaltonizer.setMode(BiliDaltonizer.ColorBlindnessMode.Correction);
        GLES20.glUniform1i(this._renderHdr, this.isHDRRender ? 1 : 0);
        GLES20.glUniform3f(this._dstLuma, 0.21263677f, 0.715183f, 0.07218021f);
        GLES20.glUniformMatrix3fv(this._cmsMatrix, 1, false, this.martix_2020, 0);
        GLES20.glUniform4f(this._fillColor, 1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this._daltonizerMatrix, 1, false, this.mDaltonizer.getMatrix(), 0);
        Matrix.setIdentityM(this.mUm4Matrix, 0);
        this._is_vivid = this.mFilterProgram.uniformIndex("is_vivid");
        GLES20.glUniform1i(this._is_vivid, this.isHdrVivid ? 1 : 0);
        GLES20.glActiveTexture(33989);
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        this.gtmCurveTextureID = textures[0];
        GLES20.glBindTexture(3553, this.gtmCurveTextureID);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        this._vivid_GTMcurve = this.mFilterProgram.uniformIndex("vivid_GTMcurve");
        GLES20.glUniform1i(this._vivid_GTMcurve, 5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        ByteBuffer GTMcurve;
        runPendingOnDrawTasks();
        BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
        BiliSize outputSize = sizeOfFBO();
        if (this.mOutputFrameBuffer == null || !outputFrameSize().equals(this.mOutputFrameBuffer.getSize())) {
            if (this.mOutputFrameBuffer != null) {
                this.mOutputFrameBuffer.destroy();
            }
            this.mOutputFrameBuffer = new BiliFrameBuffer(outputSize.getWidth(), outputSize.getHeight(), BiliFrameBuffer.FboModel.Fbo_FBO_AND_TEXTURE, 0, getOutputTextureOptions());
            this.mOutputFrameBuffer.setReferenceDisabled(true);
        }
        this.mOutputFrameBuffer.use();
        if (this.mDaltonizerChangend) {
            GLES20.glUniformMatrix4fv(this._daltonizerMatrix, 1, false, this.mDaltonizer.getMatrix(), 0);
            GLES20.glUniform1i(this._enableDaltonism, this.mEnableDaltonism ? 1 : 0);
            this.mDaltonizerChangend = false;
        }
        if (this.isDolbyHDR) {
            if (this.mDolbyHDR != null) {
                GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
                GLES20.glClear(16640);
                this.mDolbyHDR.processFrame(this.mFirstInputFramebuffer.getTexture(), this.mUm4Matrix, this.mFirstInputFramebuffer.getTimeUS());
                GLES20.glBindBuffer(34962, 0);
            } else {
                return;
            }
        } else {
            GLES20.glUniform1i(this._is_vivid, this.isHdrVivid ? 1 : 0);
            if (this.isHdrVivid && this.mHdrVivid != null && this.mSupportVivid && (GTMcurve = this.mHdrVivid.processFrame(this.mFirstInputFramebuffer.getTimeUS())) != null) {
                int width = 1024 * 2;
                GLES20.glActiveTexture(33989);
                GLES20.glBindTexture(3553, this.gtmCurveTextureID);
                GLES30.glTexImage2D(3553, 0, 33325, width, 1, 0, 6403, 5131, GTMcurve);
            }
            setUniformsForProgramAtIndex(0);
            GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
            GLES20.glClear(16640);
            GLES20.glUniform1i(this._renderHdr, this.isHDRRender ? 1 : 0);
            inputFramebufferBindTexture();
            GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
            GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
            GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
            GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
            GLES20.glUniformMatrix4fv(this.mUm4TexTransformMatrix, 1, false, this.mUm4Matrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void inputFramebufferBindTexture() {
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(36197, this.mFirstInputFramebuffer == null ? 0 : this.mFirstInputFramebuffer.getTexture());
        GLES20.glUniform1i(this.mFilterInputTextureUniform, 2);
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize newSize, int textureIndex) {
        this.mInputTextureSize = newSize;
        if (this.mDolbyHDR != null) {
            this.mDolbyHDR.setResolution(newSize.width, newSize.height);
        }
    }

    public void setSurfaceTextureMatrix(float[] matrix) {
        if (matrix.length != 16) {
            BLog.w(TAG, "surface texture matrix length error ! length:" + matrix.length);
            return;
        }
        System.arraycopy(matrix, 0, this.mUm4Matrix, 0, matrix.length);
        Matrix.multiplyMM(this.mUm4Matrix, 0, mtxFlipV, 0, matrix, 0);
    }

    public void destroy() {
        destroyDolbyHDR();
    }

    public void enableHDR(boolean enable) {
        BLog.i(TAG, "enableHDR:  " + enable);
        this.isHDRRender = enable;
    }

    public boolean initDolbyHDR(final String configPath) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval.1
            @Override // java.lang.Runnable
            public void run() {
                BLog.i(BiliOESRetrieval.TAG, "init dolby hdr ...");
                if (BiliOESRetrieval.this.mDolbyHDR != null) {
                    BiliOESRetrieval.this.mDolbyHDR.relsase();
                    BiliOESRetrieval.this.mDolbyHDR = null;
                }
                BiliOESRetrieval.this.mDolbyHDR = new IDolbyHDRApi();
                if (!BiliOESRetrieval.this.mDolbyHDR.initDolby(configPath, 0)) {
                    BiliOESRetrieval.this.mDolbyHDR = null;
                    BLog.i(BiliOESRetrieval.TAG, "init dolby hdr fall");
                }
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindBuffer(34962, 0);
                BiliOESRetrieval.this.mDolbyHDR.setResolution(BiliOESRetrieval.this.mInputTextureSize.width, BiliOESRetrieval.this.mInputTextureSize.height);
                BLog.i(BiliOESRetrieval.TAG, "init dolby hdr success");
            }
        });
        return true;
    }

    public void destroyDolbyHDR() {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval.2
            @Override // java.lang.Runnable
            public void run() {
                BLog.i(BiliOESRetrieval.TAG, "destroy dolby hdr ...");
                BiliOESRetrieval.this.mDolbyHDR.relsase();
                BiliOESRetrieval.this.mDolbyHDR = null;
            }
        });
    }

    public void enableDolbyHDR(boolean enable) {
        this.isDolbyHDR = enable;
    }

    public void isHdrVivid(boolean enable) {
        BLog.i(TAG, "isHdrVivid:  " + enable);
        this.isHdrVivid = enable;
    }

    public void video_packet_callback(final ByteBuffer buffer, final long timeUS, final int flag) {
        if (buffer != null) {
            runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BiliOESRetrieval.this.mDolbyHDR != null) {
                        BiliOESRetrieval.this.mDolbyHDR.sendRPU(buffer, buffer.capacity(), timeUS);
                    }
                }
            });
        } else {
            runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BiliOESRetrieval.this.mDolbyHDR != null) {
                        BiliOESRetrieval.this.mDolbyHDR.flush(flag);
                    }
                }
            });
        }
    }

    public void setDaltonismType(final BiliDaltonizer.ColorBlindnessType type) {
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.filter.BiliOESRetrieval.5
            @Override // java.lang.Runnable
            public void run() {
                BLog.i(BiliOESRetrieval.TAG, "setDaltonismType : " + type);
                BiliOESRetrieval.this.mDaltonizer.setType(type);
                BiliOESRetrieval.this.mDaltonizer.setMode(BiliDaltonizer.ColorBlindnessMode.Correction);
                BiliOESRetrieval.this.mEnableDaltonism = type != BiliDaltonizer.ColorBlindnessType.None;
                BiliOESRetrieval.this.mDaltonizerChangend = true;
            }
        });
    }

    public void setVividDataList(Queue<Pair<ByteBuffer, Long>> list) {
        if (this.mHdrVivid == null) {
            this.mHdrVivid = new IHdrVividProcess();
        }
        this.mHdrVivid.setVividDataList(list);
    }

    public void flushVividDataList() {
        if (this.mHdrVivid != null) {
            this.mHdrVivid.flush();
        }
    }
}