package srcs.app.ad.ui.uikit.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/app/ad/ui/uikit/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "ad_live_ad_big_card_close", "Lorg/jetbrains/compose/resources/DrawableResource;", "getAd_live_ad_big_card_close", "()Lorg/jetbrains/compose/resources/DrawableResource;", "ad_live_ad_big_card_close$delegate", "Lkotlin/Lazy;", "ic_tv_placeholder", "getIc_tv_placeholder", "ic_tv_placeholder$delegate", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy ad_live_ad_big_card_close$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.ad.ui.uikit.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource ad_live_ad_big_card_close_delegate$lambda$0;
            ad_live_ad_big_card_close_delegate$lambda$0 = CommonMainDrawable0.ad_live_ad_big_card_close_delegate$lambda$0();
            return ad_live_ad_big_card_close_delegate$lambda$0;
        }
    });
    private static final Lazy ic_tv_placeholder$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.ad.ui.uikit.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource ic_tv_placeholder_delegate$lambda$0;
            ic_tv_placeholder_delegate$lambda$0 = CommonMainDrawable0.ic_tv_placeholder_delegate$lambda$0();
            return ic_tv_placeholder_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource ad_live_ad_big_card_close_delegate$lambda$0() {
        DrawableResource init_ad_live_ad_big_card_close;
        init_ad_live_ad_big_card_close = Drawable0_commonMainKt.init_ad_live_ad_big_card_close();
        return init_ad_live_ad_big_card_close;
    }

    public final DrawableResource getAd_live_ad_big_card_close() {
        return (DrawableResource) ad_live_ad_big_card_close$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource ic_tv_placeholder_delegate$lambda$0() {
        DrawableResource init_ic_tv_placeholder;
        init_ic_tv_placeholder = Drawable0_commonMainKt.init_ic_tv_placeholder();
        return init_ic_tv_placeholder;
    }

    public final DrawableResource getIc_tv_placeholder() {
        return (DrawableResource) ic_tv_placeholder$delegate.getValue();
    }
}