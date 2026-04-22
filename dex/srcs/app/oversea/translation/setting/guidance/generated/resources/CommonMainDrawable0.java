package srcs.app.oversea.translation.setting.guidance.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/app/oversea/translation/setting/guidance/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "checkbox_selected", "Lorg/jetbrains/compose/resources/DrawableResource;", "getCheckbox_selected", "()Lorg/jetbrains/compose/resources/DrawableResource;", "checkbox_selected$delegate", "Lkotlin/Lazy;", "checkbox_unselected", "getCheckbox_unselected", "checkbox_unselected$delegate", "translation-setting-guidance_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy checkbox_selected$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.oversea.translation.setting.guidance.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource checkbox_selected_delegate$lambda$0;
            checkbox_selected_delegate$lambda$0 = CommonMainDrawable0.checkbox_selected_delegate$lambda$0();
            return checkbox_selected_delegate$lambda$0;
        }
    });
    private static final Lazy checkbox_unselected$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.oversea.translation.setting.guidance.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource checkbox_unselected_delegate$lambda$0;
            checkbox_unselected_delegate$lambda$0 = CommonMainDrawable0.checkbox_unselected_delegate$lambda$0();
            return checkbox_unselected_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource checkbox_selected_delegate$lambda$0() {
        DrawableResource init_checkbox_selected;
        init_checkbox_selected = Drawable0_commonMainKt.init_checkbox_selected();
        return init_checkbox_selected;
    }

    public final DrawableResource getCheckbox_selected() {
        return (DrawableResource) checkbox_selected$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource checkbox_unselected_delegate$lambda$0() {
        DrawableResource init_checkbox_unselected;
        init_checkbox_unselected = Drawable0_commonMainKt.init_checkbox_unselected();
        return init_checkbox_unselected;
    }

    public final DrawableResource getCheckbox_unselected() {
        return (DrawableResource) checkbox_unselected$delegate.getValue();
    }
}