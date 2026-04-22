package srcs.common.ouroboros.editor.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/common/ouroboros/editor/ui/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "image_failed_icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "getImage_failed_icon", "()Lorg/jetbrains/compose/resources/DrawableResource;", "image_failed_icon$delegate", "Lkotlin/Lazy;", "image_loading", "getImage_loading", "image_loading$delegate", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy image_failed_icon$delegate = LazyKt.lazy(new Function0() { // from class: srcs.common.ouroboros.editor.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource image_failed_icon_delegate$lambda$0;
            image_failed_icon_delegate$lambda$0 = CommonMainDrawable0.image_failed_icon_delegate$lambda$0();
            return image_failed_icon_delegate$lambda$0;
        }
    });
    private static final Lazy image_loading$delegate = LazyKt.lazy(new Function0() { // from class: srcs.common.ouroboros.editor.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource image_loading_delegate$lambda$0;
            image_loading_delegate$lambda$0 = CommonMainDrawable0.image_loading_delegate$lambda$0();
            return image_loading_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource image_failed_icon_delegate$lambda$0() {
        DrawableResource init_image_failed_icon;
        init_image_failed_icon = Drawable0_commonMainKt.init_image_failed_icon();
        return init_image_failed_icon;
    }

    public final DrawableResource getImage_failed_icon() {
        return (DrawableResource) image_failed_icon$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource image_loading_delegate$lambda$0() {
        DrawableResource init_image_loading;
        init_image_loading = Drawable0_commonMainKt.init_image_loading();
        return init_image_loading;
    }

    public final DrawableResource getImage_loading() {
        return (DrawableResource) image_loading$delegate.getValue();
    }
}