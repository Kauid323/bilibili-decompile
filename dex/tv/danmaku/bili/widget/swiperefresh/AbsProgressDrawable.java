package tv.danmaku.bili.widget.swiperefresh;

import android.graphics.drawable.Animatable;

interface AbsProgressDrawable extends Animatable {
    int getProgressAlpha();

    void onAnimateToCorrectPosition(float f);

    void onDragPercentChange(float f, float f2);

    void onFinishSpinner();

    void onRefreshCancel();

    void onSpinnerMove();

    void setBackgroundColor(int i);

    void setColorSchemeColors(int... iArr);

    void setProgressAlpha(int i);
}