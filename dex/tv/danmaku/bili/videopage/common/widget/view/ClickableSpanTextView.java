package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.videopage.common.helper.UriRouteHelper;
import tv.danmaku.bili.videopage.common.widget.span.DescSpecialTagSpan;
import tv.danmaku.bili.videopage.common.widget.span.DescTagSpan;

public class ClickableSpanTextView extends TintTextView {
    private long mDownTime;
    private boolean mHasPerformedLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private boolean mPendingCheckForLongPressRemoved;
    private int mTouchSlop;

    public ClickableSpanTextView(Context context) {
        super(context);
        this.mPendingCheckForLongPressRemoved = true;
    }

    public ClickableSpanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPendingCheckForLongPressRemoved = true;
    }

    public ClickableSpanTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPendingCheckForLongPressRemoved = true;
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.mTouchSlop = configuration.getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() && handleTouchEventInternal(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (isEnabled()) {
            removeLongPressCallback();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (isEnabled()) {
            removeLongPressCallback();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeLongPressCallback();
    }

    public void cancelLongPress() {
        super.cancelLongPress();
        removeLongPressCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean handleTouchEventInternal(MotionEvent event) {
        CharSequence text = getText();
        if (!(text instanceof Spanned)) {
            removeLongPressCallback();
            return false;
        }
        Spanned buffer = (Spanned) text;
        int action = event.getAction();
        if (action == 1 || action == 0) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int x2 = x - getTotalPaddingLeft();
            int y2 = y - getTotalPaddingTop();
            int x3 = getScrollX() + x2;
            int x4 = getScrollY();
            Layout layout = getLayout();
            int line = layout.getLineForVertical(y2 + x4);
            int off = layout.getOffsetForHorizontal(line, x3);
            DescSpecialTagSpan[] specialTags = (DescSpecialTagSpan[]) buffer.getSpans(off, off, DescSpecialTagSpan.class);
            if (specialTags.length != 0) {
                removeLongPressCallback();
                if (action == 1) {
                    int index = 0;
                    try {
                        if (specialTags.length > 1) {
                            index = 0 + 1;
                            if (buffer instanceof Spannable) {
                                Selection.setSelection((Spannable) buffer, buffer.getSpanStart(specialTags[index]), buffer.getSpanEnd(specialTags[index]));
                            }
                        }
                        if (this.mHasPerformedLongPress) {
                            return true;
                        }
                        specialTags[index].onClick();
                        playSoundEffect(0);
                    } catch (Exception e) {
                    }
                } else {
                    this.mHasPerformedLongPress = false;
                }
                return true;
            }
            DescTagSpan[] tags = (DescTagSpan[]) buffer.getSpans(off, off, DescTagSpan.class);
            if (tags.length == 0) {
                this.mHasPerformedLongPress = false;
                removeLongPressCallback();
                ClickableSpan[] link = (ClickableSpan[]) buffer.getSpans(off, off, ClickableSpan.class);
                if (link.length != 0) {
                    if (action != 1) {
                        this.mDownTime = SystemClock.elapsedRealtime();
                        if (buffer instanceof Spannable) {
                            Selection.setSelection((Spannable) buffer, buffer.getSpanStart(link[0]), buffer.getSpanEnd(link[0]));
                            return true;
                        }
                        return true;
                    }
                    int index2 = 0;
                    try {
                        if (link[0] instanceof LongClickableSpan) {
                            try {
                                if (SystemClock.elapsedRealtime() - this.mDownTime > ViewConfiguration.getLongPressTimeout()) {
                                    performHapticFeedback(0);
                                    ((LongClickableSpan) link[0]).onLongClick(this, link[0]);
                                    return true;
                                } else if (link.length > 1) {
                                    index2 = 0 + 1;
                                    if (buffer instanceof Spannable) {
                                        Selection.setSelection((Spannable) buffer, buffer.getSpanStart(link[index2]), buffer.getSpanEnd(link[index2]));
                                    }
                                }
                            } catch (Exception e2) {
                                return true;
                            }
                        }
                        if (!(link[index2] instanceof URLSpan)) {
                            link[index2].onClick(this);
                        } else {
                            String url = ((URLSpan) link[index2]).getURL();
                            UriRouteHelper.goToUri(getContext(), url);
                        }
                        playSoundEffect(0);
                        return true;
                    } catch (Exception e3) {
                        return true;
                    }
                } else if (buffer instanceof Spannable) {
                    Selection.removeSelection((Spannable) buffer);
                }
            } else {
                removeLongPressCallback();
                if (action != 1) {
                    this.mHasPerformedLongPress = false;
                    checkForLongClick(tags[0]);
                    if (buffer instanceof Spannable) {
                        Selection.setSelection((Spannable) buffer, buffer.getSpanStart(tags[0]), buffer.getSpanEnd(tags[0]));
                    }
                } else {
                    int index3 = 0;
                    try {
                        if (tags.length > 1) {
                            index3 = 0 + 1;
                            if (buffer instanceof Spannable) {
                                Selection.setSelection((Spannable) buffer, buffer.getSpanStart(tags[index3]), buffer.getSpanEnd(tags[index3]));
                            }
                        }
                        if (this.mHasPerformedLongPress) {
                            return true;
                        }
                        tags[index3].onClick();
                        playSoundEffect(0);
                    } catch (Exception e4) {
                    }
                }
                return true;
            }
        }
        if (action == 3) {
            this.mHasPerformedLongPress = false;
            removeLongPressCallback();
        }
        if (action == 2) {
            int touchSlop = this.mTouchSlop;
            float x5 = event.getX();
            float y3 = event.getY();
            if (!pointInView(x5, y3, touchSlop)) {
                removeLongPressCallback();
                return false;
            }
            return false;
        }
        return false;
    }

    private void checkForLongClick(DescTagSpan span) {
        if (this.mPendingCheckForLongPress == null) {
            this.mPendingCheckForLongPress = new CheckForLongPress();
        }
        this.mPendingCheckForLongPress.rememberWindowAttachCount();
        this.mPendingCheckForLongPress.rememberPressedState();
        this.mPendingCheckForLongPress.setSpan(span);
        this.mPendingCheckForLongPressRemoved = false;
        postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
    }

    private void removeLongPressCallback() {
        if (!this.mPendingCheckForLongPressRemoved && this.mPendingCheckForLongPress != null) {
            this.mPendingCheckForLongPressRemoved = true;
            removeCallbacks(this.mPendingCheckForLongPress);
        }
    }

    private boolean pointInView(float localX, float localY, float slop) {
        return localX >= (-slop) && localY >= (-slop) && localX < ((float) getWidth()) + slop && localY < ((float) getHeight()) + slop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class CheckForLongPress implements Runnable {
        private boolean mOriginalPressedState;
        private int mOriginalWindowAttachCount;
        private DescTagSpan mSpan;

        private CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mOriginalPressedState == ClickableSpanTextView.this.isPressed() && ClickableSpanTextView.this.getParent() != null && this.mOriginalWindowAttachCount == ClickableSpanTextView.this.getWindowAttachCount() && this.mSpan != null) {
                ClickableSpanTextView.this.mHasPerformedLongPress = true;
                ClickableSpanTextView.this.performHapticFeedback(0);
                this.mSpan.onLongClick();
            }
        }

        public void setSpan(DescTagSpan span) {
            this.mSpan = span;
        }

        public void rememberWindowAttachCount() {
            this.mOriginalWindowAttachCount = ClickableSpanTextView.this.getWindowAttachCount();
        }

        public void rememberPressedState() {
            this.mOriginalPressedState = ClickableSpanTextView.this.isPressed();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class LongClickableSpan extends ClickableSpan {
        public abstract void onLongClick(View view2, ClickableSpan clickableSpan);

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
        }
    }
}