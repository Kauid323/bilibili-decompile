package srcs.app.tribee.publish.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsrcs/app/tribee/publish/ui/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "tribee_icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "getTribee_icon", "()Lorg/jetbrains/compose/resources/DrawableResource;", "tribee_icon$delegate", "Lkotlin/Lazy;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy tribee_icon$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.tribee.publish.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource tribee_icon_delegate$lambda$0;
            tribee_icon_delegate$lambda$0 = CommonMainDrawable0.tribee_icon_delegate$lambda$0();
            return tribee_icon_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource tribee_icon_delegate$lambda$0() {
        DrawableResource init_tribee_icon;
        init_tribee_icon = Drawable0_commonMainKt.init_tribee_icon();
        return init_tribee_icon;
    }

    public final DrawableResource getTribee_icon() {
        return (DrawableResource) tribee_icon$delegate.getValue();
    }
}