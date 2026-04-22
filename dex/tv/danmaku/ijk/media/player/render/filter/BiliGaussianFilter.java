package tv.danmaku.ijk.media.player.render.filter;

import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.cache.BiliFrameBufferCache;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.IjkGLUtils;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class BiliGaussianFilter extends BiliFilter {
    private static final String BILI_FRAGMENT_GAU_SHADER = "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform vec2 uTexelOffset;\nuniform vec2 uTexelSize;\nuniform vec4 displayRect;\n\nfloat normpdf(in float x, in float sigma){\nreturn 0.39894*exp(-0.5*x*x/(sigma*sigma))/sigma;\n}\n\nbool inReact(vec2 uv, vec4 rect) {\n    return uv.x >= rect.x && uv.x <= rect.z && uv.y >= rect.y && uv.y <= rect.w;\n}\n\n\n#define KERNEL_SIZE 7\n#define SIGMA 7.0\nvoid main() {\nvec3 c = texture2D(inputImageTexture, textureCoordinate.xy).rgb;\nif (!inReact(textureCoordinate,displayRect))\n{\ngl_FragColor = vec4(c,1.0);\n} else {\n\n//declare stuff\nconst int kSize = (KERNEL_SIZE-1)/2;\nfloat kernel[KERNEL_SIZE];\nvec3 final_colour = vec3(0.0);\n\n//create the 1-D kernel\nfloat Z = 0.0;\nfor (int j = 0; j <= kSize; ++j)\n{\nkernel[kSize+j] = kernel[kSize-j] = normpdf(float(j), SIGMA);\n}\n\n//get the normalization factor (as the gaussian has been clamped)\nfor (int j = 0; j < KERNEL_SIZE; ++j)\n{\nZ += kernel[j];\n}\n\n//read out the texels\nfor (int i=-kSize; i <= kSize; ++i)\n{\nfor (int j=-kSize; j <= kSize; ++j)\n{\nfinal_colour += kernel[kSize+j]*kernel[kSize+i]*texture2D(inputImageTexture, (textureCoordinate.xy+uTexelOffset *(vec2(float(i),float(j))/ uTexelSize.xy))).rgb;\n\n}\n}\n\n\ngl_FragColor = vec4(final_colour/(Z*Z), 1.0);\n}\n}";
    public static final String BILI_VERTEX_SHADER = "attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}";
    private List<RectF> blurRectList;
    private float mTexelHeightOffset;
    private float mTexelWidthOffset;

    public BiliGaussianFilter() {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", BILI_FRAGMENT_GAU_SHADER);
        this.mTexelWidthOffset = 6.0f;
        this.mTexelHeightOffset = 6.0f;
        this.blurRectList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void onInitOnGLThread() {
        super.onInitOnGLThread();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter
    public void renderToTexture(FloatBuffer vertices, FloatBuffer textureCoordinates) {
        String str;
        String str2;
        runPendingOnDrawTasks();
        BiliSize outputSize = sizeOfFBO();
        BiliFrameBufferCache framebufferCache = BiliRenderContext.sharedFramebufferCache();
        if (framebufferCache == null) {
            return;
        }
        BiliFrameBuffer lastFbo = this.mFirstInputFramebuffer;
        String str3 = "displayRect";
        String str4 = "uTexelOffset";
        int i = 0;
        if (this.blurRectList.isEmpty()) {
            str = "displayRect";
            str2 = "uTexelOffset";
        } else {
            Iterator<RectF> it = this.blurRectList.iterator();
            while (it.hasNext()) {
                RectF rectF = it.next();
                BiliFrameBuffer blurFbo = framebufferCache.fetchFramebuffer(outputSize.getWidth(), outputSize.getHeight(), getOutputTextureOptions());
                blurFbo.use();
                IjkGLUtils.checkGlError("glBindFramebuffer");
                BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
                setUniformsForProgramAtIndex(i);
                GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
                GLES20.glClear(IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, lastFbo.getTexture());
                GLES20.glUniform1i(this.mFilterInputTextureUniform, 2);
                Iterator<RectF> it2 = it;
                GLES20.glUniform2fv(this.mFilterProgram.uniformIndex("uTexelSize"), 1, new float[]{this.mInputTextureSize.getWidth(), this.mInputTextureSize.getHeight()}, 0);
                IjkGLUtils.checkGlError("glUniform1fv");
                String str5 = str4;
                GLES20.glUniform2fv(this.mFilterProgram.uniformIndex(str4), 1, new float[]{this.mTexelWidthOffset, this.mTexelHeightOffset}, 0);
                IjkGLUtils.checkGlError("glUniform1fv");
                String str6 = str3;
                GLES20.glUniform4fv(this.mFilterProgram.uniformIndex(str3), 1, new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom}, 0);
                IjkGLUtils.checkGlError("glUniform1fv");
                GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
                GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
                GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
                GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glFlush();
                if (lastFbo != this.mFirstInputFramebuffer) {
                    lastFbo.unlock();
                }
                lastFbo = blurFbo;
                GLES20.glBindFramebuffer(36160, 0);
                it = it2;
                str4 = str5;
                str3 = str6;
                i = 0;
            }
            str = str3;
            str2 = str4;
        }
        this.mOutputFrameBuffer = framebufferCache.fetchFramebuffer(outputSize.getWidth(), outputSize.getHeight(), getOutputTextureOptions());
        this.mOutputFrameBuffer.use();
        IjkGLUtils.checkGlError("glBindFramebuffer");
        if (this.mUsingNextFrameForImageCapture) {
            this.mOutputFrameBuffer.lock();
        }
        BiliRenderContext.setActiveShaderProgram(this.mFilterProgram);
        setUniformsForProgramAtIndex(0);
        GLES20.glClearColor(this.mBackgroundColorRed, this.mBackgroundColorGreen, this.mBackgroundColorBlue, this.mBackgroundColorAlpha);
        GLES20.glClear(IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID);
        inputFramebufferBindTexture();
        IjkGLUtils.checkGlError("inputFramebufferBindTexture");
        GLES20.glUniform2fv(this.mFilterProgram.uniformIndex("uTexelSize"), 1, new float[]{lastFbo.getWidth(), lastFbo.getHeight()}, 0);
        IjkGLUtils.checkGlError("glUniform1fv");
        GLES20.glUniform2fv(this.mFilterProgram.uniformIndex(str2), 1, new float[]{this.mTexelWidthOffset, this.mTexelHeightOffset}, 0);
        GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
        GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, (Buffer) vertices);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) textureCoordinates);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, lastFbo.getTexture());
        GLES20.glUniform1i(this.mFilterInputTextureUniform, 2);
        GLES20.glUniform4fv(this.mFilterProgram.uniformIndex(str), 1, new float[]{DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN}, 0);
        IjkGLUtils.checkGlError("glUniform1fv");
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        if (lastFbo != this.mFirstInputFramebuffer) {
            lastFbo.unlock();
        }
        inputFramebufferUnlock();
    }

    @Override // tv.danmaku.ijk.media.player.render.filter.BiliFilter, tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    public void addBlurRect(RectF rect) {
        if (rect == null) {
            return;
        }
        this.blurRectList.add(rect);
    }

    public void setBlurRectList(List<RectF> list) {
        if (list == null) {
            return;
        }
        this.blurRectList.clear();
        this.blurRectList.addAll(list);
    }

    public void clearBlurRect() {
        this.blurRectList.clear();
    }
}