package srcs.app.game.game.bind.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lsrcs/app/game/game/bind/ui/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "biligame_vector_ic_eye_close", "Lorg/jetbrains/compose/resources/DrawableResource;", "getBiligame_vector_ic_eye_close", "()Lorg/jetbrains/compose/resources/DrawableResource;", "biligame_vector_ic_eye_close$delegate", "Lkotlin/Lazy;", "biligame_vector_ic_eye_open", "getBiligame_vector_ic_eye_open", "biligame_vector_ic_eye_open$delegate", "biligame_vector_ic_more", "getBiligame_vector_ic_more", "biligame_vector_ic_more$delegate", "game-bind-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy biligame_vector_ic_eye_close$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.game.bind.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource biligame_vector_ic_eye_close_delegate$lambda$0;
            biligame_vector_ic_eye_close_delegate$lambda$0 = CommonMainDrawable0.biligame_vector_ic_eye_close_delegate$lambda$0();
            return biligame_vector_ic_eye_close_delegate$lambda$0;
        }
    });
    private static final Lazy biligame_vector_ic_eye_open$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.game.bind.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource biligame_vector_ic_eye_open_delegate$lambda$0;
            biligame_vector_ic_eye_open_delegate$lambda$0 = CommonMainDrawable0.biligame_vector_ic_eye_open_delegate$lambda$0();
            return biligame_vector_ic_eye_open_delegate$lambda$0;
        }
    });
    private static final Lazy biligame_vector_ic_more$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.game.bind.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda2
        public final Object invoke() {
            DrawableResource biligame_vector_ic_more_delegate$lambda$0;
            biligame_vector_ic_more_delegate$lambda$0 = CommonMainDrawable0.biligame_vector_ic_more_delegate$lambda$0();
            return biligame_vector_ic_more_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource biligame_vector_ic_eye_close_delegate$lambda$0() {
        DrawableResource init_biligame_vector_ic_eye_close;
        init_biligame_vector_ic_eye_close = Drawable0_commonMainKt.init_biligame_vector_ic_eye_close();
        return init_biligame_vector_ic_eye_close;
    }

    public final DrawableResource getBiligame_vector_ic_eye_close() {
        return (DrawableResource) biligame_vector_ic_eye_close$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource biligame_vector_ic_eye_open_delegate$lambda$0() {
        DrawableResource init_biligame_vector_ic_eye_open;
        init_biligame_vector_ic_eye_open = Drawable0_commonMainKt.init_biligame_vector_ic_eye_open();
        return init_biligame_vector_ic_eye_open;
    }

    public final DrawableResource getBiligame_vector_ic_eye_open() {
        return (DrawableResource) biligame_vector_ic_eye_open$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource biligame_vector_ic_more_delegate$lambda$0() {
        DrawableResource init_biligame_vector_ic_more;
        init_biligame_vector_ic_more = Drawable0_commonMainKt.init_biligame_vector_ic_more();
        return init_biligame_vector_ic_more;
    }

    public final DrawableResource getBiligame_vector_ic_more() {
        return (DrawableResource) biligame_vector_ic_more$delegate.getValue();
    }
}