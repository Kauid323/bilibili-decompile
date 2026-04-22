package srcs.app.biliapplet.minigame.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;
import tv.danmaku.bili.BR;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsrcs/app/biliapplet/minigame/generated/resources/CommonMainString0;", "", "<init>", "()V", "bwa_recent_visit_title", "Lorg/jetbrains/compose/resources/StringResource;", "getBwa_recent_visit_title", "()Lorg/jetbrains/compose/resources/StringResource;", "bwa_recent_visit_title$delegate", "Lkotlin/Lazy;", "minigame_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy bwa_recent_visit_title$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.biliapplet.minigame.generated.resources.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource bwa_recent_visit_title_delegate$lambda$0;
            bwa_recent_visit_title_delegate$lambda$0 = CommonMainString0.bwa_recent_visit_title_delegate$lambda$0();
            return bwa_recent_visit_title_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource bwa_recent_visit_title_delegate$lambda$0() {
        StringResource init_bwa_recent_visit_title;
        init_bwa_recent_visit_title = String0_commonMainKt.init_bwa_recent_visit_title();
        return init_bwa_recent_visit_title;
    }

    public final StringResource getBwa_recent_visit_title() {
        return (StringResource) bwa_recent_visit_title$delegate.getValue();
    }
}