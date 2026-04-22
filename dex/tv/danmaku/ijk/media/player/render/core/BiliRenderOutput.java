package tv.danmaku.ijk.media.player.render.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public abstract class BiliRenderOutput {
    private static final String TAG = "RenderOutput";
    protected BiliFrameBuffer mOutputFrameBuffer;
    protected boolean mOverrideInputSize;
    private boolean mShouldIgnoreUpdatesToThisTarget;
    private BiliRenderInput mTargetToIgnoreForUpdates;
    protected BiliSize mInputTextureSize = new BiliSize();
    protected BiliSize mCachedMaximumOutputSize = new BiliSize();
    protected BiliSize mForcedMaximumSize = new BiliSize();
    private final BlockingQueue<Runnable> mRunOnDraw = new LinkedBlockingQueue();
    protected final List<BiliRenderInput> mTargets = new ArrayList();
    protected final List<Integer> mTargetTextureIndices = new ArrayList();
    protected boolean mAllTargetsWantMonochromeData = true;
    protected boolean mUsingNextFrameForImageCapture = false;
    private BiliFrameBuffer.BiliTextureOptions mOutputTextureOptions = new BiliFrameBuffer.BiliTextureOptions();

    public void setInputFramebufferForTarget(BiliRenderInput target, int inputTextureIndex) {
        if (target != null) {
            target.setInputFrameBuffer(getOutputFrameBuffer(), inputTextureIndex);
        } else {
            BLog.e(TAG, String.format("%s setInputFramebufferForTarget target is null", getClass()));
        }
    }

    public BiliFrameBuffer getOutputFrameBuffer() {
        return this.mOutputFrameBuffer;
    }

    public void removeOutputFramebuffer() {
        this.mOutputFrameBuffer.unlock();
    }

    public boolean isShouldIgnoreUpdatesToThisTarget() {
        return this.mShouldIgnoreUpdatesToThisTarget;
    }

    public void setShouldIgnoreUpdatesToThisTarget(boolean mShouldIgnoreUpdatesToThisTarget) {
        this.mShouldIgnoreUpdatesToThisTarget = mShouldIgnoreUpdatesToThisTarget;
    }

    public BiliRenderInput getTargetToIgnoreForUpdates() {
        return this.mTargetToIgnoreForUpdates;
    }

    public void setTargetToIgnoreForUpdates(BiliRenderInput mTargetToIgnoreForUpdates) {
        this.mTargetToIgnoreForUpdates = mTargetToIgnoreForUpdates;
    }

    public void notifyTargetsAboutNewOutputTexture() {
        List<BiliRenderInput> targets = targets();
        for (int i = 0; i < targets.size(); i++) {
            BiliRenderInput currentTarget = targets.get(i);
            if (!currentTarget.isEnable()) {
                int textureIndex = this.mTargetTextureIndices.get(i).intValue();
                setInputFramebufferForTarget(currentTarget, textureIndex);
            }
        }
    }

    public void addTarget(BiliRenderInput newTarget) {
        if (newTarget == null) {
            BLog.e(TAG, String.format("%s addTarget newTarget is null", getClass()));
            return;
        }
        int nextAvailableTextureIndex = newTarget.nextAvailableTextureIndex();
        addTarget(newTarget, nextAvailableTextureIndex);
        if (newTarget.isShouldIgnoreUpdatesToThisTarget()) {
            this.mTargetToIgnoreForUpdates = newTarget;
        }
    }

    public void addTarget(final BiliRenderInput newTarget, final int textureLocation) {
        if (newTarget == null) {
            BLog.e(TAG, String.format("%s addTarget:newTarget:textureLocation is null", getClass()));
        } else {
            runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.core.BiliRenderOutput.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BiliRenderOutput.this.mTargets.contains(newTarget)) {
                        return;
                    }
                    BiliRenderOutput.this.mCachedMaximumOutputSize = new BiliSize();
                    BiliRenderOutput.this.setInputFramebufferForTarget(newTarget, textureLocation);
                    BiliRenderOutput.this.mTargets.add(newTarget);
                    BiliRenderOutput.this.mTargetTextureIndices.add(Integer.valueOf(textureLocation));
                }
            });
        }
    }

    public void removeTarget(final BiliRenderInput targetToRemove) {
        if (targetToRemove == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.core.BiliRenderOutput.2
            @Override // java.lang.Runnable
            public void run() {
                if (BiliRenderOutput.this.mTargets.contains(targetToRemove)) {
                    if (targetToRemove.equals(BiliRenderOutput.this.mTargetToIgnoreForUpdates)) {
                        BiliRenderOutput.this.mTargetToIgnoreForUpdates = null;
                    }
                    BiliRenderOutput.this.mCachedMaximumOutputSize = new BiliSize();
                    int indexOfObject = BiliRenderOutput.this.mTargets.indexOf(targetToRemove);
                    int textureIndexOfTarget = BiliRenderOutput.this.mTargetTextureIndices.get(indexOfObject).intValue();
                    targetToRemove.setInputSize(new BiliSize(), textureIndexOfTarget);
                    targetToRemove.setInputRotation(BiliImageOrientation.Up, textureIndexOfTarget);
                    BiliRenderOutput.this.mTargetTextureIndices.remove(indexOfObject);
                    BiliRenderOutput.this.mTargets.remove(targetToRemove);
                }
            }
        });
    }

    public void removeAllTargets() {
        this.mCachedMaximumOutputSize = new BiliSize();
        runOnDraw(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.core.BiliRenderOutput.3
            @Override // java.lang.Runnable
            public void run() {
                int j = BiliRenderOutput.this.mTargets.size();
                for (int i = 0; i < j; i++) {
                    BiliRenderInput targetToRemove = BiliRenderOutput.this.mTargets.get(i);
                    int textureIndexOfTarget = BiliRenderOutput.this.mTargetTextureIndices.get(i).intValue();
                    targetToRemove.setInputSize(new BiliSize(), textureIndexOfTarget);
                    targetToRemove.setInputRotation(BiliImageOrientation.Up, textureIndexOfTarget);
                }
                BiliRenderOutput.this.mTargets.clear();
                BiliRenderOutput.this.mTargetTextureIndices.clear();
                BiliRenderOutput.this.mAllTargetsWantMonochromeData = true;
            }
        });
    }

    public BiliFrameBuffer.BiliTextureOptions getOutputTextureOptions() {
        return this.mOutputTextureOptions;
    }

    public List<BiliRenderInput> targets() {
        return new ArrayList(this.mTargets);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            try {
                this.mRunOnDraw.take().run();
            } catch (InterruptedException e) {
                BLog.e(TAG, e.getMessage());
            }
        }
    }

    protected boolean isOnDrawTasksEmpty() {
        return this.mRunOnDraw.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.add(runnable);
        }
    }
}