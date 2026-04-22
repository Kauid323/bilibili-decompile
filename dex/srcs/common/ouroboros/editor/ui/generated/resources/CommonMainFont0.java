package srcs.common.ouroboros.editor.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.FontResource;
import tv.danmaku.bili.BR;

/* compiled from: Font0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsrcs/common/ouroboros/editor/ui/generated/resources/CommonMainFont0;", "", "<init>", "()V", "placeholder", "Lorg/jetbrains/compose/resources/FontResource;", "getPlaceholder", "()Lorg/jetbrains/compose/resources/FontResource;", "placeholder$delegate", "Lkotlin/Lazy;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainFont0 {
    public static final CommonMainFont0 INSTANCE = new CommonMainFont0();
    private static final Lazy placeholder$delegate = LazyKt.lazy(new Function0() { // from class: srcs.common.ouroboros.editor.ui.generated.resources.CommonMainFont0$$ExternalSyntheticLambda0
        public final Object invoke() {
            FontResource placeholder_delegate$lambda$0;
            placeholder_delegate$lambda$0 = CommonMainFont0.placeholder_delegate$lambda$0();
            return placeholder_delegate$lambda$0;
        }
    });

    private CommonMainFont0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource placeholder_delegate$lambda$0() {
        FontResource init_placeholder;
        init_placeholder = Font0_commonMainKt.init_placeholder();
        return init_placeholder;
    }

    public final FontResource getPlaceholder() {
        return (FontResource) placeholder$delegate.getValue();
    }
}