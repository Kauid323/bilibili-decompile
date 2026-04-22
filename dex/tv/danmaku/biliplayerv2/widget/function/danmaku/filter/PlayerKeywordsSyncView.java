package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UploadState;

public class PlayerKeywordsSyncView extends LinearLayout implements UploadState.Observer {
    private Animation mAnimation;
    private AppCompatImageView mSyncView;

    public PlayerKeywordsSyncView(Context context) {
        super(context);
    }

    public PlayerKeywordsSyncView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlayerKeywordsSyncView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mSyncView = getChildAt(0);
        this.mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bplayer_rotate);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        UploadState state = UploadState.obtain();
        state.register(this);
        onChanged(state.isUploading());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UploadState state = UploadState.obtain();
        state.unregister(this);
        onChanged(state.isUploading());
    }

    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UploadState.Observer
    public void onChanged(boolean isUploading) {
        if (isUploading) {
            onStartSync();
            setEnabled(false);
            return;
        }
        onSyncFinish();
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        View text = findViewById(tv.danmaku.biliplayerv2.R.id.text);
        if (text != null) {
            text.setEnabled(enabled);
        }
        if (this.mSyncView != null) {
            this.mSyncView.setEnabled(enabled);
        }
    }

    private void onStartSync() {
        if (this.mSyncView != null) {
            this.mSyncView.startAnimation(this.mAnimation);
        }
        setEnabled(false);
    }

    private void onSyncFinish() {
        if (this.mSyncView != null) {
            this.mSyncView.clearAnimation();
        }
        setEnabled(true);
    }
}