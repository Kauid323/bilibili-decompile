package srcs.app.im.setting.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.DrawableResource;
import tv.danmaku.bili.BR;

/* compiled from: Drawable0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lsrcs/app/im/setting/ui/generated/resources/CommonMainDrawable0;", "", "<init>", "()V", "gender_female", "Lorg/jetbrains/compose/resources/DrawableResource;", "getGender_female", "()Lorg/jetbrains/compose/resources/DrawableResource;", "gender_female$delegate", "Lkotlin/Lazy;", "gender_male", "getGender_male", "gender_male$delegate", "gender_unknown", "getGender_unknown", "gender_unknown$delegate", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainDrawable0 {
    public static final CommonMainDrawable0 INSTANCE = new CommonMainDrawable0();
    private static final Lazy gender_female$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.im.setting.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda0
        public final Object invoke() {
            DrawableResource gender_female_delegate$lambda$0;
            gender_female_delegate$lambda$0 = CommonMainDrawable0.gender_female_delegate$lambda$0();
            return gender_female_delegate$lambda$0;
        }
    });
    private static final Lazy gender_male$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.im.setting.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda1
        public final Object invoke() {
            DrawableResource gender_male_delegate$lambda$0;
            gender_male_delegate$lambda$0 = CommonMainDrawable0.gender_male_delegate$lambda$0();
            return gender_male_delegate$lambda$0;
        }
    });
    private static final Lazy gender_unknown$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.im.setting.ui.generated.resources.CommonMainDrawable0$$ExternalSyntheticLambda2
        public final Object invoke() {
            DrawableResource gender_unknown_delegate$lambda$0;
            gender_unknown_delegate$lambda$0 = CommonMainDrawable0.gender_unknown_delegate$lambda$0();
            return gender_unknown_delegate$lambda$0;
        }
    });

    private CommonMainDrawable0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource gender_female_delegate$lambda$0() {
        DrawableResource init_gender_female;
        init_gender_female = Drawable0_commonMainKt.init_gender_female();
        return init_gender_female;
    }

    public final DrawableResource getGender_female() {
        return (DrawableResource) gender_female$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource gender_male_delegate$lambda$0() {
        DrawableResource init_gender_male;
        init_gender_male = Drawable0_commonMainKt.init_gender_male();
        return init_gender_male;
    }

    public final DrawableResource getGender_male() {
        return (DrawableResource) gender_male$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawableResource gender_unknown_delegate$lambda$0() {
        DrawableResource init_gender_unknown;
        init_gender_unknown = Drawable0_commonMainKt.init_gender_unknown();
        return init_gender_unknown;
    }

    public final DrawableResource getGender_unknown() {
        return (DrawableResource) gender_unknown$delegate.getValue();
    }
}