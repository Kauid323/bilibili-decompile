package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.lib.avatar.AvatarShowParam;
import com.bilibili.lib.avatar.PendantAvatarView;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: MineAvatarFrameLayout.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0016J\b\u0010\"\u001a\u00020\nH\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/MineAvatarFrameLayout;", "Lcom/bilibili/lib/avatar/PendantAvatarView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "guideView", "Landroid/view/View;", "getGuideView", "()Landroid/view/View;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", ReportEvent.EVENT_TYPE_SHOW, "param", "Lcom/bilibili/lib/avatar/AvatarShowParam;", "showGuideView", "face", "", "setGuideView", "getAvatarBorderColor", "getAvatarGuideViewBg", "Landroid/graphics/drawable/Drawable;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineAvatarFrameLayout extends PendantAvatarView {
    public static final int $stable = 8;
    private final View guideView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineAvatarFrameLayout(Context context) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        int badgeIndex = indexOfChild((View) getView().badgeImage);
        this.guideView = new View(getContext());
        addView(this.guideView, badgeIndex);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineAvatarFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        int badgeIndex = indexOfChild((View) getView().badgeImage);
        this.guideView = new View(getContext());
        addView(this.guideView, badgeIndex);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineAvatarFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        int badgeIndex = indexOfChild((View) getView().badgeImage);
        this.guideView = new View(getContext());
        addView(this.guideView, badgeIndex);
    }

    public final View getGuideView() {
        return this.guideView;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int spec = View.MeasureSpec.makeMeasureSpec(getSizeType().avatarImageSize(getNormalAvatarSize(), getSizeStyle()), 1073741824);
        this.guideView.measure(spec, spec);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.guideView.getVisibility() != 8) {
            this.guideView.layout(getView().avatarImage.getLeft() + ((int) getAvatarBorderSize()), getView().avatarImage.getTop() + ((int) getAvatarBorderSize()), getView().avatarImage.getRight() - ((int) getAvatarBorderSize()), getView().avatarImage.getBottom() - ((int) getAvatarBorderSize()));
        } else {
            this.guideView.layout(0, 0, 0, 0);
        }
    }

    public final void show(AvatarShowParam param, boolean showGuideView) {
        Intrinsics.checkNotNullParameter(param, "param");
        super.show(param);
        setGuideView(showGuideView);
    }

    public final void show(String face, boolean showGuideView) {
        show(AvatarShowParam.copy$default(getAvatarShowParam(), face == null ? "" : face, 0, (String) null, 0, (String) null, 0, (String) null, 0, false, 0, false, 0, (String) null, false, 0, (String) null, false, 131070, (Object) null), showGuideView);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
        r0 = r5.guideView;
        r1 = getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        r0.setBackground(getAvatarGuideViewBg(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setGuideView(boolean showGuideView) {
        int i;
        View $this$setVisibleOrGone_u24default$iv = this.guideView;
        if ($this$setVisibleOrGone_u24default$iv != null) {
            if (showGuideView) {
                i = 0;
            } else {
                i = 8;
            }
            $this$setVisibleOrGone_u24default$iv.setVisibility(i);
        }
        if (!showGuideView || $this$setVisibleOrGone_u24default$iv != null) {
        }
    }

    protected int getAvatarBorderColor() {
        return ThemeUtils.getColorById(getContext(), R.color.bili_mine_avatar_border, getViewThemeId());
    }

    private final Drawable getAvatarGuideViewBg(Context context) {
        try {
            int drawableRes = R.drawable.shape_mine_avatar_guide_background;
            Drawable bgDrawable = ContextCompat.getDrawable(context, drawableRes);
            BitmapDrawable cameraDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), com.bilibili.app.comm.baseres.R.drawable.ic_empty_camera));
            cameraDrawable.setGravity(17);
            Drawable tempCamera = DrawableCompat.wrap(cameraDrawable).mutate();
            Intrinsics.checkNotNullExpressionValue(tempCamera, "mutate(...)");
            DrawableCompat.setTint(tempCamera, -1);
            Drawable[] layers = {bgDrawable, tempCamera};
            return new LayerDrawable(layers);
        } catch (Exception e) {
            return null;
        }
    }
}