package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import android.graphics.Rect;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliRenderInput;
import tv.danmaku.ijk.media.player.render.filter.BiliPanoramaFilter;
import tv.danmaku.ijk.media.player.render.tools.BiliPipeTask;
import tv.danmaku.ijk.media.player.render.tools.BiliSensorEntity;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public class IJKTerminalRenderWrap implements BiliRenderInput {
    public static final int NORMAL = 1;
    public static final int PANORAMA = 2;
    private static final String TAG = IJKTerminalRenderWrap.class.getName();
    private boolean isRecycle;
    private float mBackgroundColorAlpha;
    private float mBackgroundColorBlue;
    private float mBackgroundColorGreen;
    private float mBackgroundColorRed;
    private Bitmap mBgBitmap;
    private Rect mBgDisplayRect;
    private int mCurrentRenderType;
    private Rect mDisplayRect;
    private BiliMVPMatrix mMVPMatrix;
    private BiliSize mOutputSize;
    private BiliPanoramaFilter mPanoramaFilter;
    private final BiliPipeTask mRunOnDraw;
    private BiliTerminalOprationRenderer mTerminalRender;
    private int mVerticesCalcModel;

    public IJKTerminalRenderWrap() {
        this(1);
    }

    public IJKTerminalRenderWrap(int model) {
        this.mBackgroundColorAlpha = 1.0f;
        this.mRunOnDraw = new BiliPipeTask();
        switchRenderer(model);
    }

    public synchronized void switchRenderer(final int render) {
        if (this.mCurrentRenderType == render) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.IJKTerminalRenderWrap.1
            @Override // java.lang.Runnable
            public void run() {
                IJKTerminalRenderWrap.this.mCurrentRenderType = render;
                if (IJKTerminalRenderWrap.this.mTerminalRender == null) {
                    IJKTerminalRenderWrap.this.mTerminalRender = new BiliTerminalOprationRenderer();
                    IJKTerminalRenderWrap.this.mTerminalRender.setVerticesModel(IJKTerminalRenderWrap.this.mVerticesCalcModel);
                    IJKTerminalRenderWrap.this.mTerminalRender.setDisplayRect(IJKTerminalRenderWrap.this.mDisplayRect);
                    IJKTerminalRenderWrap.this.mTerminalRender.setMatrix(IJKTerminalRenderWrap.this.mMVPMatrix);
                    IJKTerminalRenderWrap.this.mTerminalRender.setGLScreenSizeSize(IJKTerminalRenderWrap.this.mOutputSize);
                    IJKTerminalRenderWrap.this.mTerminalRender.setBackgroundColor(IJKTerminalRenderWrap.this.mBackgroundColorRed, IJKTerminalRenderWrap.this.mBackgroundColorGreen, IJKTerminalRenderWrap.this.mBackgroundColorBlue, IJKTerminalRenderWrap.this.mBackgroundColorAlpha);
                }
                switch (render) {
                    case 1:
                        if (IJKTerminalRenderWrap.this.mPanoramaFilter != null) {
                            IJKTerminalRenderWrap.this.mPanoramaFilter.removeAllTargets();
                            IJKTerminalRenderWrap.this.mPanoramaFilter.destroy();
                            IJKTerminalRenderWrap.this.mPanoramaFilter = null;
                            break;
                        }
                        break;
                    case 2:
                        if (IJKTerminalRenderWrap.this.mPanoramaFilter != null && IJKTerminalRenderWrap.this.mPanoramaFilter.targets().contains(IJKTerminalRenderWrap.this.mTerminalRender)) {
                            BLog.w(IJKTerminalRenderWrap.TAG, "contain this target !!!");
                            return;
                        }
                        IJKTerminalRenderWrap.this.mPanoramaFilter = new BiliPanoramaFilter();
                        IJKTerminalRenderWrap.this.mPanoramaFilter.addTarget(IJKTerminalRenderWrap.this.mTerminalRender);
                        break;
                        break;
                }
                IJKTerminalRenderWrap.this.mTerminalRender.setBackgroundImage(IJKTerminalRenderWrap.this.mBgBitmap, IJKTerminalRenderWrap.this.isRecycle, IJKTerminalRenderWrap.this.mBgDisplayRect);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void newFrameReady(long frameTimeUs, int textureIndex) {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.newFrameReady(frameTimeUs, textureIndex);
        } else if (this.mTerminalRender != null) {
            this.mTerminalRender.newFrameReady(frameTimeUs, textureIndex);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputFrameBuffer(BiliFrameBuffer frameBuffer, int textureIndex) {
        runPendingOnDrawTasks();
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setInputFrameBuffer(frameBuffer, textureIndex);
        } else if (this.mTerminalRender != null) {
            this.mTerminalRender.setInputFrameBuffer(frameBuffer, textureIndex);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public int nextAvailableTextureIndex() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputSize(BiliSize inputSize, int textureIndex) {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setInputSize(inputSize, textureIndex);
        }
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setInputSize(inputSize, textureIndex);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setInputRotation(BiliImageOrientation inputRotation, int textureIndex) {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setInputRotation(inputRotation, textureIndex);
        }
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setInputRotation(inputRotation, textureIndex);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public BiliSize maximumOutputSize() {
        return this.mTerminalRender == null ? BiliSize.create(0, 0) : this.mTerminalRender.maximumOutputSize();
    }

    public void setMatrix(BiliMVPMatrix matrix) {
        this.mMVPMatrix = matrix;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setMatrix(this.mMVPMatrix);
        }
    }

    public void setRotation(float x, float y) {
        if (this.mCurrentRenderType == 2 && this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setRotation(x, y);
        }
    }

    public void setPerspective(float value) {
        if (this.mCurrentRenderType == 2 && this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setPerspective(value);
        }
    }

    public void setOutputSize(BiliSize size) {
        this.mOutputSize = size;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setGLScreenSizeSize(this.mOutputSize);
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isShouldIgnoreUpdatesToThisTarget() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public boolean isEnable() {
        return true;
    }

    protected void runPendingOnDrawTasks() {
        this.mRunOnDraw.runPendingOnDrawTasks();
    }

    public void setSensorMatrix(BiliSensorEntity sensorEntity) {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setSensorMatrix(sensorEntity);
        }
    }

    public void setOperationModel(int model) {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.setOperationModel(model);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mRunOnDraw.addTask(runnable);
    }

    public void destroy() {
        if (this.mPanoramaFilter != null) {
            this.mPanoramaFilter.removeAllTargets();
            this.mPanoramaFilter.destroy();
        }
        if (this.mTerminalRender != null) {
            this.mTerminalRender.destroy();
        }
        this.mPanoramaFilter = null;
        this.mTerminalRender = null;
    }

    public void setVerticesModel(int model) {
        this.mVerticesCalcModel = model;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setVerticesModel(model);
        }
    }

    public void setDisplayRect(Rect displayRect) {
        this.mDisplayRect = displayRect;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setDisplayRect(displayRect);
        }
    }

    public BiliFrameBuffer getOutputFrameBuffer() {
        if (this.mPanoramaFilter != null) {
            return this.mPanoramaFilter.getOutputFrameBuffer();
        }
        if (this.mTerminalRender != null) {
            return this.mTerminalRender.getInputFrameBuffer();
        }
        return null;
    }

    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect displayRect) {
        this.mBgBitmap = bitmap;
        this.isRecycle = recycle;
        this.mBgDisplayRect = displayRect;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setBackgroundImage(bitmap, recycle, displayRect);
        } else {
            BLog.i(TAG, "setBackgroundImage TerminalRender is null !");
        }
    }

    @Override // tv.danmaku.ijk.media.player.render.core.BiliRenderInput
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        this.mBackgroundColorRed = red;
        this.mBackgroundColorGreen = green;
        this.mBackgroundColorBlue = blue;
        this.mBackgroundColorAlpha = alpha;
        if (this.mTerminalRender != null) {
            this.mTerminalRender.setBackgroundColor(red, green, blue, alpha);
        }
    }
}