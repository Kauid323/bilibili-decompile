package tv.danmaku.ijk.media.player.render.filter;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class BiliEnhanceFilter extends BiliFilter {
    public static final String BILI_OPRATION_FRAGMENT_SHADER = "precision highp float;varying highp vec2 textureCoordinate;uniform lowp sampler2D inputImageTexture;uniform float srcWidth;uniform float srcHeight;const float usmCoeff = 1.0;const float vibCoeff = 0.05;const float brightCoeff = 0.05;const float lobe = 0.25;const float eps = 1.0e-8;const float diffEps = 0.015;void calcMeanVar(   inout vec3 aMean,   inout vec3 aVar,  float w,    vec3 a, vec3 b, vec3 c, vec3 d, vec3 e  ) {    vec3 sum = a + b + c + d + e;    vec3 mean = sum / 5.0;    vec3 sum2 = a * a + b * b + c * c + d * d + e * e;    vec3 var = sum2 / 5.0 - mean * mean;    aMean += w * mean;    aVar += w * var;}void vibranceV2(    inout vec3 rgbUSM,    vec3 rgbRS ) {     float rgbMax = max(rgbRS.r, max(rgbRS.g, rgbRS.b));    float rgbMin = min(rgbRS.r, min(rgbRS.g, rgbRS.b));    float delta = rgbMax - rgbMin;    float flag = step(eps, delta);    float value = rgbMax + rgbMin;    float L = value / 2.0;    float S = delta / abs(2.0 * step(0.5, L) - value);    float alpha = 1.0 / clamp(1.0 - vibCoeff, S, 1.0) - 1.0;    rgbUSM = rgbUSM + flag * alpha * (rgbUSM - L);}void lanczos2(    inout vec3 aC,    inout float aW,    vec2 off,    vec3 c   ) {    vec2 wA = 0.4 * off * off - 1.0;   wA = 1.5625 * wA * wA - 0.5625;    vec2 wB = lobe * off * off - 1.0;    wB *= wB;    wB *= wA;    float w = wB.x * wB.y;    aC += w * c;    aW += w;}void main() {    vec2 invSrc = vec2(1.0 / srcWidth, 1.0 / srcHeight);    vec2 pp = textureCoordinate * vec2(srcWidth, srcHeight) - 0.5;    vec2 fp = floor(pp);    pp -= fp;     fp = fp + 0.5;     vec3 bC = texture2D(inputImageTexture, (fp + vec2(0.0, -1.0)) * invSrc).rgb;    vec3 cC = texture2D(inputImageTexture, (fp + vec2(1.0, -1.0)) * invSrc).rgb;    vec3 eC = texture2D(inputImageTexture, (fp + vec2(-1.0, 0.0)) * invSrc).rgb;    vec3 fC = texture2D(inputImageTexture, fp * invSrc).rgb;    vec3 gC = texture2D(inputImageTexture, (fp + vec2(1.0, 0.0)) * invSrc).rgb;    vec3 hC = texture2D(inputImageTexture, (fp + vec2(2.0, 0.0)) * invSrc).rgb;    vec3 iC = texture2D(inputImageTexture, (fp + vec2(-1.0, 1.0)) * invSrc).rgb;    vec3 jC = texture2D(inputImageTexture, (fp + vec2(0.0, 1.0)) * invSrc).rgb;    vec3 kC = texture2D(inputImageTexture, (fp + vec2(1.0, 1.0)) * invSrc).rgb;    vec3 lC = texture2D(inputImageTexture, (fp + vec2(2.0, 1.0)) * invSrc).rgb;    vec3 nC = texture2D(inputImageTexture, (fp + vec2(0.0, 2.0)) * invSrc).rgb;    vec3 oC = texture2D(inputImageTexture, (fp + vec2(1.0, 2.0)) * invSrc).rgb;    vec3 rgbRS = vec3(0.0);    float aW = 0.0;    lanczos2(rgbRS, aW, vec2(0.0, -1.0) - pp, bC);    lanczos2(rgbRS, aW, vec2(1.0, -1.0) - pp, cC);    lanczos2(rgbRS, aW, vec2(-1.0, 0.0) - pp, eC);    lanczos2(rgbRS, aW, vec2(0.0, 0.0) - pp, fC);    lanczos2(rgbRS, aW, vec2(1.0, 0.0) - pp, gC);    lanczos2(rgbRS, aW, vec2(2.0, 0.0) - pp, hC);    lanczos2(rgbRS, aW, vec2(-1.0, 1.0) - pp, iC);    lanczos2(rgbRS, aW, vec2(0.0, 1.0) - pp, jC);    lanczos2(rgbRS, aW, vec2(1.0, 1.0) - pp, kC);    lanczos2(rgbRS, aW, vec2(2.0, 1.0) - pp, lC);    lanczos2(rgbRS, aW, vec2(0.0, 2.0) - pp, nC);    lanczos2(rgbRS, aW, vec2(1.0, 2.0) - pp, oC);    rgbRS /= aW;    rgbRS = clamp(rgbRS, 0.0, 1.0);    vec3 mean = vec3(0.0);    vec3 var = vec3(0.0);    calcMeanVar(mean, var, (1.0 - pp.x) * (1.0 - pp.y), bC, eC, fC, gC, jC);    calcMeanVar(mean, var, pp.x * (1.0 - pp.y), cC, fC, gC, hC, kC);    calcMeanVar(mean, var, (1.0 - pp.x) * pp.y, fC, iC, jC, kC, nC);    calcMeanVar(mean, var, pp.x * pp.y, gC, jC, kC, lC, oC);    vec3 W = usmCoeff + 1.0 / (var + 1.0);    vec3 rgbUSM = mean + W * (rgbRS - mean);    vec3 diff = rgbUSM - rgbRS;    vec3 negitiveDiff = clamp(diff, -0.5-diffEps , -diffEps) + diffEps;    vec3 positiveDiff = clamp(diff, diffEps, 0.5+diffEps) - diffEps;    vec3 noise = clamp(diff, -diffEps, diffEps);    rgbUSM = clamp(rgbUSM + 1.2*(negitiveDiff*1.0 + positiveDiff*0.3) - 0.5*noise, 0.0, 1.0);    vibranceV2(rgbUSM, rgbRS);    rgbUSM = -brightCoeff * rgbUSM * rgbUSM + (1.0 + brightCoeff) * rgbUSM;    gl_FragColor = vec4(rgbUSM, 1.0);}";
    public static final String BILI_OPRATION_FRAGMENT_SHADER_PLUS = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform lowp sampler2D inputImageTexture;\nuniform float srcWidth; //input width\nuniform float srcHeight; //input height\nconst float usmCoeff = 1.5; // for usm v2, range [1.0, 1.5]\nconst float lobe = 0.25; // default 0.25\nconst float var_range = 7.5e-2;\nconst float deltaMax = 7.5e-2; \nvoid calcMeanVar(\n    inout vec3 aMean,\n    inout vec3 aVar,\n    float w,\n    vec3 a, vec3 b, vec3 c, vec3 d, vec3 e, vec3 f\n) {\n    vec3 sum = a + b + c + d + e + f;\n    vec3 mean = sum / 6.0;\n    vec3 sum2 = a * a + b * b + c * c + d * d + e * e + f * f;\n    vec3 var = sum2 / 6.0 - mean * mean;\n    aMean += w * mean;\n    aVar += w * var;\n}\nvoid lanczos2(\n    inout vec3 aC,\n    inout float aW,\n    vec2 off,\n    vec3 c\n) {\n    vec2 wA = 0.4 * off * off - 1.0;\n    wA = 1.5625 * wA * wA - 0.5625;\n    vec2 wB = lobe * off * off - 1.0;\n    wB *= wB;\n    wB *= wA;\n    float w = wB.x * wB.y;\n    aC += w * c;\n    aW += w;\n}\nvoid main() {\n    vec2 invSrc = vec2(1.0 / srcWidth, 1.0 / srcHeight);\n    vec2 pp = textureCoordinate * vec2(srcWidth, srcHeight) - 0.5; // output texture coordinate in the input pixel coordinate\n    vec2 fp = floor(pp); // fp is F in the pixel coordinate\n    pp -= fp; // offset to the top left f\n    fp = fp + 0.5; // make fp being the pixel coordinate corresponding to f in the texture coordinate\n    vec3 bC = texture2D(inputImageTexture, (fp + vec2(0.0, -1.0)) * invSrc).rgb;\n    vec3 cC = texture2D(inputImageTexture, (fp + vec2(1.0, -1.0)) * invSrc).rgb;\n    vec3 eC = texture2D(inputImageTexture, (fp + vec2(-1.0, 0.0)) * invSrc).rgb;\n    vec3 fC = texture2D(inputImageTexture, fp * invSrc).rgb;\n    vec3 gC = texture2D(inputImageTexture, (fp + vec2(1.0, 0.0)) * invSrc).rgb;\n    vec3 hC = texture2D(inputImageTexture, (fp + vec2(2.0, 0.0)) * invSrc).rgb;\n    vec3 iC = texture2D(inputImageTexture, (fp + vec2(-1.0, 1.0)) * invSrc).rgb;\n    vec3 jC = texture2D(inputImageTexture, (fp + vec2(0.0, 1.0)) * invSrc).rgb;\n    vec3 kC = texture2D(inputImageTexture, (fp + vec2(1.0, 1.0)) * invSrc).rgb;\n    vec3 lC = texture2D(inputImageTexture, (fp + vec2(2.0, 1.0)) * invSrc).rgb;\n    vec3 nC = texture2D(inputImageTexture, (fp + vec2(0.0, 2.0)) * invSrc).rgb;\n    vec3 oC = texture2D(inputImageTexture, (fp + vec2(1.0, 2.0)) * invSrc).rgb;\n    vec3 rgbRS = vec3(0.0);\n    float aW = 0.0;\n    lanczos2(rgbRS, aW, vec2(0.0, -1.0) - pp, bC);\n    lanczos2(rgbRS, aW, vec2(0.0, 0.0) - pp, fC);\n    lanczos2(rgbRS, aW, vec2(1.0, 0.0) - pp, gC);\n    lanczos2(rgbRS, aW, vec2(0.0, 1.0) - pp, jC);\n    lanczos2(rgbRS, aW, vec2(1.0, 1.0) - pp, kC);\n    lanczos2(rgbRS, aW, vec2(1.0, 2.0) - pp, oC);\n    rgbRS /= aW;\n    rgbRS = clamp(rgbRS, 0.0, 1.0);\n    vec3 mean = vec3(0.0);\n    vec3 var = vec3(0.0);\n    calcMeanVar(mean, var, 1.0, bC, kC, fC, gC, jC, oC);\n    vec3 W = usmCoeff + 5e-2 / (var + 5e-2);\n    vec3 rgbUSM = mean + W * (rgbRS - mean);\n    rgbUSM = clamp(rgbUSM, 0.0, 1.0);\n    vec3 delta_fo = rgbUSM - rgbRS;\n    if ((abs(var.r) + abs(var.g) + abs(var.b))/3.0 > var_range){\n        vec3 deltaRange = clamp(delta_fo, -deltaMax, deltaMax);\n        rgbUSM = rgbRS + deltaRange;\n    }\n    vec3 noise_fo = clamp(delta_fo, -0.0003, 0.0003);\n    vec3 noise_so = clamp(delta_fo, -0.0001, 0.0001);\n    rgbUSM = rgbUSM - (noise_fo - noise_so); \n    vec3 delta_so = rgbUSM - rgbRS;\n    if ((abs(delta_so.r) + abs(delta_so.g) + abs(delta_so.b))/3.0 > 0.075){\n        rgbUSM = rgbRS + 0.9*delta_so;\n    }\n    gl_FragColor = vec4(rgbUSM, 1.0);\n}";
    public static final String BILI_OPRATION_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}";
    private static final String TAG = "BiliEnhanceFilter";
    private Boolean mEnhancePlus;
    private int mSrcHeightIndex;
    private int mSrcWidthIndex;

    public BiliEnhanceFilter(boolean isPlus) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", isPlus ? BILI_OPRATION_FRAGMENT_SHADER_PLUS : BILI_OPRATION_FRAGMENT_SHADER);
        this.mEnhancePlus = Boolean.valueOf(isPlus);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
        this.mSrcWidthIndex = this.mFilterProgram.uniformIndex("srcWidth");
        this.mSrcHeightIndex = this.mFilterProgram.uniformIndex("srcHeight");
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        super.newFrameReady(frameTimeUs, textureIndex);
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputFrameBuffer(BiliFrameBuffer newInputFrameBuffer, int textureIndex) {
        super.setInputFrameBuffer(newInputFrameBuffer, textureIndex);
        if (newInputFrameBuffer == null) {
            return;
        }
        float w = newInputFrameBuffer.getWidth();
        float h = newInputFrameBuffer.getHeight();
        setFloat(w, "srcWidth");
        setFloat(h, "srcHeight");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        if (!this.mEnhancePlus.booleanValue()) {
            super.renderToTexture(vertices, textureCoordinates);
            return;
        }
        runPendingOnDrawTasks();
        BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
        BiliSize outputSize = sizeOfFBO();
        BiliFrameBufferCache framebufferCache = BiliRenderContext.sharedFramebufferCache();
        if (framebufferCache == null) {
            return;
        }
        this.mOutputFrameBuffer = framebufferCache.fetchFramebuffer(outputSize.getWidth() * 2, outputSize.getHeight() * 2, getOutputTextureOptions());
        this.mOutputFrameBuffer.use();
        if (this.mUsingNextFrameForImageCapture) {
            this.mOutputFrameBuffer.lock();
        }
        setUniformsForProgramAtIndex(0);
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID);
        inputFramebufferBindTexture();
        GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
        GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
        GLES20.glDrawArrays(5, 0, 4);
        inputFramebufferUnlock();
    }
}