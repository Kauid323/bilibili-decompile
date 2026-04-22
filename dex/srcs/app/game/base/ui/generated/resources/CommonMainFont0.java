package srcs.app.game.base.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.FontResource;
import tv.danmaku.bili.BR;

/* compiled from: Font0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/app/game/base/ui/generated/resources/CommonMainFont0;", "", "<init>", "()V", "xx_bin_Regular", "Lorg/jetbrains/compose/resources/FontResource;", "getXx_bin_Regular", "()Lorg/jetbrains/compose/resources/FontResource;", "xx_bin_Regular$delegate", "Lkotlin/Lazy;", "xx_bin_bold", "getXx_bin_bold", "xx_bin_bold$delegate", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainFont0 {
    public static final CommonMainFont0 INSTANCE = new CommonMainFont0();
    private static final Lazy xx_bin_Regular$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.base.ui.generated.resources.CommonMainFont0$$ExternalSyntheticLambda0
        public final Object invoke() {
            FontResource xx_bin_Regular_delegate$lambda$0;
            xx_bin_Regular_delegate$lambda$0 = CommonMainFont0.xx_bin_Regular_delegate$lambda$0();
            return xx_bin_Regular_delegate$lambda$0;
        }
    });
    private static final Lazy xx_bin_bold$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.game.base.ui.generated.resources.CommonMainFont0$$ExternalSyntheticLambda1
        public final Object invoke() {
            FontResource xx_bin_bold_delegate$lambda$0;
            xx_bin_bold_delegate$lambda$0 = CommonMainFont0.xx_bin_bold_delegate$lambda$0();
            return xx_bin_bold_delegate$lambda$0;
        }
    });

    private CommonMainFont0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource xx_bin_Regular_delegate$lambda$0() {
        FontResource init_xx_bin_Regular;
        init_xx_bin_Regular = Font0_commonMainKt.init_xx_bin_Regular();
        return init_xx_bin_Regular;
    }

    public final FontResource getXx_bin_Regular() {
        return (FontResource) xx_bin_Regular$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource xx_bin_bold_delegate$lambda$0() {
        FontResource init_xx_bin_bold;
        init_xx_bin_bold = Font0_commonMainKt.init_xx_bin_bold();
        return init_xx_bin_bold;
    }

    public final FontResource getXx_bin_bold() {
        return (FontResource) xx_bin_bold$delegate.getValue();
    }
}