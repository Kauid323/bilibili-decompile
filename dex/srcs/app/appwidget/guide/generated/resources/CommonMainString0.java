package srcs.app.appwidget.guide.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;
import tv.danmaku.bili.BR;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/app/appwidget/guide/generated/resources/CommonMainString0;", "", "<init>", "()V", "up_card_guide_subtitle", "Lorg/jetbrains/compose/resources/StringResource;", "getUp_card_guide_subtitle", "()Lorg/jetbrains/compose/resources/StringResource;", "up_card_guide_subtitle$delegate", "Lkotlin/Lazy;", "up_card_guide_title", "getUp_card_guide_title", "up_card_guide_title$delegate", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy up_card_guide_subtitle$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.appwidget.guide.generated.resources.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource up_card_guide_subtitle_delegate$lambda$0;
            up_card_guide_subtitle_delegate$lambda$0 = CommonMainString0.up_card_guide_subtitle_delegate$lambda$0();
            return up_card_guide_subtitle_delegate$lambda$0;
        }
    });
    private static final Lazy up_card_guide_title$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.appwidget.guide.generated.resources.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource up_card_guide_title_delegate$lambda$0;
            up_card_guide_title_delegate$lambda$0 = CommonMainString0.up_card_guide_title_delegate$lambda$0();
            return up_card_guide_title_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource up_card_guide_subtitle_delegate$lambda$0() {
        StringResource init_up_card_guide_subtitle;
        init_up_card_guide_subtitle = String0_commonMainKt.init_up_card_guide_subtitle();
        return init_up_card_guide_subtitle;
    }

    public final StringResource getUp_card_guide_subtitle() {
        return (StringResource) up_card_guide_subtitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource up_card_guide_title_delegate$lambda$0() {
        StringResource init_up_card_guide_title;
        init_up_card_guide_title = String0_commonMainKt.init_up_card_guide_title();
        return init_up_card_guide_title;
    }

    public final StringResource getUp_card_guide_title() {
        return (StringResource) up_card_guide_title$delegate.getValue();
    }
}