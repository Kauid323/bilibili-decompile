package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;

public class VisibilityLottieAnimationView extends LottieAnimationView {
    public VisibilityLottieAnimationView(Context context) {
        super(context);
    }

    public VisibilityLottieAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VisibilityLottieAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            playAnimation();
        } else {
            cancelAnimation();
        }
    }
}