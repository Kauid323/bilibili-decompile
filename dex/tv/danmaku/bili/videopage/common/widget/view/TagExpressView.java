package tv.danmaku.bili.videopage.common.widget.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class TagExpressView extends ForegroundRelativeLayout {
    private AnimatorSet mAnimatorSet;
    private int mDisAbleClickIcon;
    private boolean mEnableClick;
    private TintImageView mIcon;
    private TintTextView mNum;
    private TintTextView mPrompt;

    public TagExpressView(Context context) {
        this(context, null);
    }

    public TagExpressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagExpressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TagExpressView);
        this.mDisAbleClickIcon = array.getResourceId(R.styleable.TagExpressView_expressIconDisable, 0);
        int strId = array.getResourceId(R.styleable.TagExpressView_expressPrompt, 0);
        int drawableId = array.getResourceId(R.styleable.TagExpressView_expressIcon, com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv);
        int textColorId = array.getResourceId(R.styleable.TagExpressView_expressTextColor, R.color.selector_tag_edit_dialog_text);
        array.recycle();
        initView(strId, textColorId, drawableId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView(int strId, int colorId, int drawableId) {
        View view2 = LayoutInflater.from(getContext()).inflate(tv.danmaku.bili.videopage.common.R.layout.bili_app_layout_express_view, (ViewGroup) this, true);
        this.mNum = view2.findViewById(tv.danmaku.bili.videopage.common.R.id.num);
        this.mIcon = view2.findViewById(tv.danmaku.bili.videopage.common.R.id.icon);
        this.mIcon.setImageResource(drawableId);
        this.mPrompt = view2.findViewById(tv.danmaku.bili.videopage.common.R.id.prompt);
        if (strId != 0) {
            this.mPrompt.setText(strId);
        }
        this.mPrompt.setTextColorById(colorId);
        setForeground(getResources().getDrawable(ThemeUtils.getThemeAttrId(getContext(), com.bilibili.app.comm.relation.R.attr.selectableItemBackground)));
    }

    public void setPrompt(int id, Object... params) {
        if (id != 0) {
            if (params != null) {
                this.mPrompt.setText(getResources().getString(id, params));
            } else {
                this.mPrompt.setText(id);
            }
        }
    }

    public void setEnableClick(boolean isEnable, boolean hasSelected) {
        this.mEnableClick = isEnable;
        if (!this.mEnableClick) {
            this.mIcon.setImageResource(this.mDisAbleClickIcon);
            this.mIcon.setImageTintList(com.bilibili.app.comm.baseres.R.color.daynight_color_dividing_line);
            this.mPrompt.setTextColor(getResources().getColor(com.bilibili.app.comm.baseres.R.color.daynight_color_dividing_line));
        } else if (hasSelected) {
            setSelected(true);
        } else {
            setSelected(false);
        }
    }

    public boolean isEnableClick() {
        return this.mEnableClick;
    }

    public boolean hasSelected() {
        return this.mIcon.isSelected();
    }

    public void onDestroy() {
        if (this.mAnimatorSet != null && this.mAnimatorSet.isStarted()) {
            this.mAnimatorSet.cancel();
        }
    }

    public void setOnViewClickListener(View.OnClickListener listener) {
        if (listener != null) {
            this.mIcon.setOnClickListener(listener);
        }
    }

    public void setSelected(boolean selected) {
        super.setSelected(selected);
        this.mIcon.setSelected(selected);
        this.mPrompt.setSelected(selected);
    }

    public void showAnimate() {
        this.mNum.setVisibility(0);
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
            ObjectAnimator animator = ObjectAnimator.ofFloat(this.mNum, "translationY", DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -getPaddingTop());
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(this.mNum, "alpha", 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            this.mAnimatorSet.play(animator).with(animator1);
            this.mAnimatorSet.setDuration(600L);
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.TagExpressView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    TagExpressView.this.mNum.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    TagExpressView.this.mNum.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }
            });
            this.mAnimatorSet.setInterpolator(new LinearOutSlowInInterpolator());
        }
        if (!this.mAnimatorSet.isStarted()) {
            this.mAnimatorSet.start();
        }
    }
}