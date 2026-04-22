package tv.danmaku.ijk.media.player.render.core;

import android.opengl.GLES20;
import tv.danmaku.android.log.BLog;

public class BiliProgram {
    private static final String TAG = "BiliProgram";
    private int mProgram;
    private String mProgramLog;
    private boolean mInitialized = false;
    private BiliEGLContext mEglContext = new BiliEGLContext();

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public String getProgramLog() {
        return this.mProgramLog;
    }

    public BiliEGLContext getEglContext() {
        return this.mEglContext;
    }

    public static BiliProgram create(String vertexString, String fragmentString) {
        return new BiliProgram(vertexString, fragmentString);
    }

    private BiliProgram(String vertexString, String fragmentString) {
        this.mProgram = GLES20.glCreateProgram();
        BLog.d(TAG, String.format("BiliProgram  create() program : %s  %s %s", Integer.valueOf(this.mProgram), this, BiliRenderContext.currentEGLContext()));
        this.mProgram = GlUtil.createProgram(vertexString, fragmentString);
    }

    public int attributeIndex(String attributeName) {
        return GLES20.glGetAttribLocation(this.mProgram, attributeName);
    }

    public int uniformIndex(String uniformName) {
        return GLES20.glGetUniformLocation(this.mProgram, uniformName);
    }

    public void use() {
        GLES20.glUseProgram(this.mProgram);
    }

    public void validate() {
        GLES20.glValidateProgram(this.mProgram);
        this.mProgramLog = GLES20.glGetProgramInfoLog(this.mProgram);
    }

    public boolean isValidate() {
        return this.mProgram >= 0;
    }

    public void destroy() {
        BLog.i(TAG, String.format("%s  program : %s  destory()  %s  context : %s", TAG, Integer.valueOf(this.mProgram), Integer.valueOf(this.mProgram), BiliRenderContext.currentEGLContext()));
        if (this.mProgram > 0) {
            GLES20.glDeleteProgram(this.mProgram);
        }
        this.mProgram = 0;
    }
}