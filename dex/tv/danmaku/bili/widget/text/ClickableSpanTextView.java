package tv.danmaku.bili.widget.text;

import android.content.Context;
import android.net.Uri;
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
import tv.danmaku.bili.utils.UriRouteKt;

public class ClickableSpanTextView extends TintTextView {
    private long mDownTime;

    public ClickableSpanTextView(Context context) {
        super(context);
    }

    public ClickableSpanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickableSpanTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() && handleTouchEventInternal(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean handleTouchEventInternal(MotionEvent event) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
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
                    int index = 0;
                    try {
                        if (link[0] instanceof LongClickableSpan) {
                            try {
                                if (SystemClock.elapsedRealtime() - this.mDownTime > ViewConfiguration.getLongPressTimeout()) {
                                    performHapticFeedback(0);
                                    ((LongClickableSpan) link[0]).onLongClick(this, link[0]);
                                    return true;
                                } else if (link.length > 1) {
                                    index = 0 + 1;
                                    if (buffer instanceof Spannable) {
                                        Selection.setSelection((Spannable) buffer, buffer.getSpanStart(link[index]), buffer.getSpanEnd(link[index]));
                                    }
                                }
                            } catch (Exception e) {
                                return true;
                            }
                        }
                        if (!(link[index] instanceof URLSpan)) {
                            link[index].onClick(this);
                        } else {
                            String url = ((URLSpan) link[index]).getURL();
                            UriRouteKt.openRoute(Uri.parse(url), getContext(), false);
                        }
                        playSoundEffect(0);
                        return true;
                    } catch (Exception e2) {
                        return true;
                    }
                } else if (buffer instanceof Spannable) {
                    Selection.removeSelection((Spannable) buffer);
                }
            }
            return false;
        }
        return false;
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