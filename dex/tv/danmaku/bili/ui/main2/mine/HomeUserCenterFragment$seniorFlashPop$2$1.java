package tv.danmaku.bili.ui.main2.mine;

import android.graphics.drawable.Drawable;
import com.bilibili.lib.image2.bean.AnimationListener;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.bean.BiliAnimatedDrawable;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0014J\u0018\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"tv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$seniorFlashPop$2$1", "Lcom/bilibili/lib/image2/bean/BaseImageDataSubscriber;", "Lcom/bilibili/lib/image2/bean/DrawableHolder;", "onNewResultImpl", "", "dataSource", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "onFailureImpl", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterFragment$seniorFlashPop$2$1 extends BaseImageDataSubscriber<DrawableHolder> {
    final /* synthetic */ BiliImageView $flashImage;
    final /* synthetic */ Function1<Integer, Unit> $seniorFlashOnFinish;
    final /* synthetic */ String $whichFlash;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeUserCenterFragment$seniorFlashPop$2$1(BiliImageView $flashImage, String $whichFlash, Function1<? super Integer, Unit> function1) {
        this.$flashImage = $flashImage;
        this.$whichFlash = $whichFlash;
        this.$seniorFlashOnFinish = function1;
    }

    protected void onNewResultImpl(ImageDataSource<DrawableHolder> imageDataSource) {
        if (imageDataSource != null) {
            BiliImageView biliImageView = this.$flashImage;
            final String str = this.$whichFlash;
            final Function1<Integer, Unit> function1 = this.$seniorFlashOnFinish;
            DrawableHolder drawableHolder = (DrawableHolder) imageDataSource.getResult();
            BiliAnimatedDrawable biliAnimatedDrawable = drawableHolder != null ? drawableHolder.get() : null;
            BiliAnimatedDrawable animatableDrawable = biliAnimatedDrawable instanceof BiliAnimatedDrawable ? biliAnimatedDrawable : null;
            if (animatableDrawable != null) {
                biliImageView.getGenericProperties().setImage((Drawable) animatableDrawable);
                animatableDrawable.getPreviewDrawable();
                animatableDrawable.start();
                animatableDrawable.setAnimationListener(new AnimationListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$seniorFlashPop$2$1$onNewResultImpl$1$1$1
                    public /* synthetic */ void onAnimationLastFrame(BiliAnimatable biliAnimatable) {
                        AnimationListener.-CC.$default$onAnimationLastFrame(this, biliAnimatable);
                    }

                    public void onAnimationStart(BiliAnimatable animatable) {
                    }

                    public void onAnimationStop(BiliAnimatable animatable) {
                        int margin = Intrinsics.areEqual(str, HomeUserCenterFragment.KEY_SENIOR_GATE_SHOWN) ? 70 : 40;
                        Function1<Integer, Unit> function12 = function1;
                        if (function12 != null) {
                            Unit unit = (Unit) function12.invoke(Integer.valueOf(margin));
                        }
                    }
                });
                return;
            }
            new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$seniorFlashPop$2$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onNewResultImpl$lambda$0$1;
                    onNewResultImpl$lambda$0$1 = HomeUserCenterFragment$seniorFlashPop$2$1.onNewResultImpl$lambda$0$1(function1);
                    return onNewResultImpl$lambda$0$1;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onNewResultImpl$lambda$0$1(Function1 $seniorFlashOnFinish) {
        if ($seniorFlashOnFinish != null) {
            return (Unit) $seniorFlashOnFinish.invoke(5);
        }
        return null;
    }

    protected void onFailureImpl(ImageDataSource<DrawableHolder> imageDataSource) {
        Function1<Integer, Unit> function1 = this.$seniorFlashOnFinish;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(5);
        }
    }
}