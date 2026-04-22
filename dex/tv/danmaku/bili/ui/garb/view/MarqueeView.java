package tv.danmaku.bili.ui.garb.view;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: MarqueeView.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/MarqueeView;", "Landroid/widget/TextSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mViewFactory", "Lkotlin/Function0;", "Landroid/widget/TextView;", "startAnimation", "", "message", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MarqueeView extends TextSwitcher {
    public static final int $stable = 8;
    private final Function0<TextView> mViewFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewFactory = new Function0() { // from class: tv.danmaku.bili.ui.garb.view.MarqueeView$$ExternalSyntheticLambda0
            public final Object invoke() {
                TextView mViewFactory$lambda$0;
                mViewFactory$lambda$0 = MarqueeView.mViewFactory$lambda$0(context, this);
                return mViewFactory$lambda$0;
            }
        };
        Animation $this$_init__u24lambda_u240 = AnimationUtils.loadAnimation(context, R.anim.anim_bottom_in);
        $this$_init__u24lambda_u240.setDuration(250L);
        setInAnimation($this$_init__u24lambda_u240);
        Animation $this$_init__u24lambda_u241 = AnimationUtils.loadAnimation(context, R.anim.anim_top_out);
        $this$_init__u24lambda_u241.setDuration(250L);
        setOutAnimation($this$_init__u24lambda_u241);
        final Function0<TextView> function0 = this.mViewFactory;
        setFactory(new ViewSwitcher.ViewFactory() { // from class: tv.danmaku.bili.ui.garb.view.MarqueeView$$ExternalSyntheticLambda1
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                View _init_$lambda$2;
                _init_$lambda$2 = MarqueeView._init_$lambda$2(function0);
                return _init_$lambda$2;
            }
        });
    }

    public /* synthetic */ MarqueeView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mViewFactory$lambda$0(Context $context, MarqueeView this$0) {
        TextView contentView = new TextView($context);
        contentView.setHighlightColor(0);
        contentView.setTextSize(2, 12.0f);
        contentView.setTextColor(this$0.getResources().getColor(com.bilibili.app.comm.baseres.R.color.white));
        contentView.setGravity(17);
        contentView.setShadowLayer(1.0f, 0.0f, 1.5f, this$0.getResources().getColor(com.bilibili.app.comm.baseres.R.color.black_alpha50));
        contentView.setMovementMethod(LinkMovementMethod.getInstance());
        return contentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View _init_$lambda$2(Function0 $tmp0) {
        return (View) $tmp0.invoke();
    }

    public final void startAnimation(CharSequence message) {
        if (message != null) {
            setText(message);
        }
    }
}