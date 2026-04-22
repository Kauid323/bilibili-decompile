package tv.danmaku.bili.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.utils.DpUtils;

public class SoftKeyBoardListener {
    private static final String TAG = "SoftKeyBoardListener";
    private OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    private View rootView;
    private int rootViewVisibleHeight;
    private int softThreshold;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public SoftKeyBoardListener(Window window) {
        this.rootView = window.getDecorView();
        this.softThreshold = (int) DpUtils.dp2px(this.rootView.getContext(), 100.0f);
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.utils.SoftKeyBoardListener.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect r = new Rect();
                SoftKeyBoardListener.this.rootView.getWindowVisibleDisplayFrame(r);
                int visibleHeight = r.height();
                if (SoftKeyBoardListener.this.rootViewVisibleHeight == 0) {
                    SoftKeyBoardListener.this.rootViewVisibleHeight = visibleHeight;
                } else if (SoftKeyBoardListener.this.rootViewVisibleHeight == visibleHeight) {
                } else {
                    if (SoftKeyBoardListener.this.rootViewVisibleHeight - visibleHeight > SoftKeyBoardListener.this.softThreshold) {
                        if (SoftKeyBoardListener.this.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardShow(SoftKeyBoardListener.this.rootViewVisibleHeight - visibleHeight);
                        }
                        BLog.d(SoftKeyBoardListener.TAG, "key board show: " + (SoftKeyBoardListener.this.rootViewVisibleHeight - visibleHeight));
                        SoftKeyBoardListener.this.rootViewVisibleHeight = visibleHeight;
                    } else if (visibleHeight - SoftKeyBoardListener.this.rootViewVisibleHeight > SoftKeyBoardListener.this.softThreshold) {
                        if (SoftKeyBoardListener.this.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardHide(visibleHeight - SoftKeyBoardListener.this.rootViewVisibleHeight);
                        }
                        BLog.d(SoftKeyBoardListener.TAG, "key board hide: " + (visibleHeight - SoftKeyBoardListener.this.rootViewVisibleHeight));
                        SoftKeyBoardListener.this.rootViewVisibleHeight = visibleHeight;
                    }
                }
            }
        });
    }

    public void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
    }
}