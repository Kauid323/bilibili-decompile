package tv.danmaku.bili.utils;

import android.net.Uri;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class LinkMovementMethod extends ScrollingMovementMethod {
    private static final int CLICK = 1;
    private static final int DOWN = 3;
    private static Object FROM_BELOW = new NoCopySpan.Concrete();
    private static final int UP = 2;
    private static LinkMovementMethod sInstance;

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode, int movementMetaState, KeyEvent event) {
        switch (keyCode) {
            case module_topic_VALUE:
            case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState) && event.getAction() == 0 && event.getRepeatCount() == 0 && action(1, widget, buffer)) {
                    return true;
                }
                break;
        }
        return super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean up(TextView widget, Spannable buffer) {
        if (action(2, widget, buffer)) {
            return true;
        }
        return super.up(widget, buffer);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean down(TextView widget, Spannable buffer) {
        if (action(3, widget, buffer)) {
            return true;
        }
        return super.down(widget, buffer);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean left(TextView widget, Spannable buffer) {
        if (action(2, widget, buffer)) {
            return true;
        }
        return super.left(widget, buffer);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean right(TextView widget, Spannable buffer) {
        if (action(3, widget, buffer)) {
            return true;
        }
        return super.right(widget, buffer);
    }

    private boolean action(int what, TextView widget, Spannable buffer) {
        int selEnd;
        int selEnd2;
        int areatop;
        Layout layout = widget.getLayout();
        int padding = widget.getTotalPaddingBottom() + widget.getTotalPaddingTop();
        int areatop2 = widget.getScrollY();
        int areabot = (widget.getHeight() + areatop2) - padding;
        int linetop = layout.getLineForVertical(areatop2);
        int linebot = layout.getLineForVertical(areabot);
        int first = layout.getLineStart(linetop);
        int last = layout.getLineEnd(linebot);
        ClickableSpan[] candidates = (ClickableSpan[]) buffer.getSpans(first, last, ClickableSpan.class);
        int a = Selection.getSelectionStart(buffer);
        int b = Selection.getSelectionEnd(buffer);
        int selStart = Math.min(a, b);
        int selEnd3 = Math.max(a, b);
        if (selStart < 0 && buffer.getSpanStart(FROM_BELOW) >= 0) {
            int length = buffer.length();
            selEnd3 = length;
            selStart = length;
        }
        if (selStart > last) {
            selEnd3 = Integer.MAX_VALUE;
            selStart = Integer.MAX_VALUE;
        }
        if (selEnd3 >= first) {
            selEnd = selEnd3;
            selEnd2 = selStart;
        } else {
            selEnd = -1;
            selEnd2 = -1;
        }
        switch (what) {
            case 1:
                if (selEnd2 != selEnd) {
                    ClickableSpan[] link = (ClickableSpan[]) buffer.getSpans(selEnd2, selEnd, ClickableSpan.class);
                    if (link.length != 1) {
                        return false;
                    }
                    try {
                        try {
                            link[0].onClick(widget);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    } catch (Exception e2) {
                        break;
                    }
                } else {
                    return false;
                }
            case 2:
                int beststart = -1;
                int bestend = -1;
                int i = 0;
                while (i < candidates.length) {
                    int end = buffer.getSpanEnd(candidates[i]);
                    if (end >= selEnd && selEnd2 != selEnd) {
                        areatop = areatop2;
                    } else if (end <= bestend) {
                        areatop = areatop2;
                    } else {
                        areatop = areatop2;
                        beststart = buffer.getSpanStart(candidates[i]);
                        bestend = end;
                    }
                    i++;
                    areatop2 = areatop;
                }
                if (beststart < 0) {
                    break;
                } else {
                    Selection.setSelection(buffer, bestend, beststart);
                    return true;
                }
            case 3:
                int beststart2 = Integer.MAX_VALUE;
                int i2 = 0;
                int bestend2 = Integer.MAX_VALUE;
                while (true) {
                    int padding2 = padding;
                    if (i2 < candidates.length) {
                        int start = buffer.getSpanStart(candidates[i2]);
                        if ((start > selEnd2 || selEnd2 == selEnd) && start < beststart2) {
                            bestend2 = buffer.getSpanEnd(candidates[i2]);
                            beststart2 = start;
                        }
                        i2++;
                        padding = padding2;
                    } else if (bestend2 >= Integer.MAX_VALUE) {
                        break;
                    } else {
                        Selection.setSelection(buffer, beststart2, bestend2);
                        return true;
                    }
                }
        }
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();
        if (action == 1 || action == 0) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int x2 = x - widget.getTotalPaddingLeft();
            int y2 = y - widget.getTotalPaddingTop();
            int x3 = x2 + widget.getScrollX();
            int y3 = y2 + widget.getScrollY();
            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y3);
            int off = layout.getOffsetForHorizontal(line, x3);
            ClickableSpan[] link = (ClickableSpan[]) buffer.getSpans(off, off, ClickableSpan.class);
            if (link.length != 0) {
                if (action == 1) {
                    try {
                        if (link[0] instanceof URLSpan) {
                            String url = ((URLSpan) link[0]).getURL();
                            UriRouteKt.openRoute(Uri.parse(url), widget.getContext(), false);
                        } else {
                            link[0].onClick(widget);
                        }
                    } catch (Exception e) {
                    }
                } else if (action == 0) {
                    Selection.setSelection(buffer, buffer.getSpanStart(link[0]), buffer.getSpanEnd(link[0]));
                }
                return true;
            }
            Selection.removeSelection(buffer);
        }
        return super.onTouchEvent(widget, buffer, event);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView widget, Spannable text) {
        Selection.removeSelection(text);
        text.removeSpan(FROM_BELOW);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(TextView view2, Spannable text, int dir) {
        Selection.removeSelection(text);
        if ((dir & 1) != 0) {
            text.setSpan(FROM_BELOW, 0, 0, 34);
        } else {
            text.removeSpan(FROM_BELOW);
        }
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethod();
        }
        return sInstance;
    }
}