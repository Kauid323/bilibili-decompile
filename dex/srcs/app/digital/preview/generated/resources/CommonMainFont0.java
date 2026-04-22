package srcs.app.digital.preview.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.FontResource;
import tv.danmaku.bili.BR;

/* compiled from: Font0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsrcs/app/digital/preview/generated/resources/CommonMainFont0;", "", "<init>", "()V", "digital_id_num", "Lorg/jetbrains/compose/resources/FontResource;", "getDigital_id_num", "()Lorg/jetbrains/compose/resources/FontResource;", "digital_id_num$delegate", "Lkotlin/Lazy;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainFont0 {
    public static final CommonMainFont0 INSTANCE = new CommonMainFont0();
    private static final Lazy digital_id_num$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.digital.preview.generated.resources.CommonMainFont0$$ExternalSyntheticLambda0
        public final Object invoke() {
            FontResource digital_id_num_delegate$lambda$0;
            digital_id_num_delegate$lambda$0 = CommonMainFont0.digital_id_num_delegate$lambda$0();
            return digital_id_num_delegate$lambda$0;
        }
    });

    private CommonMainFont0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontResource digital_id_num_delegate$lambda$0() {
        FontResource init_digital_id_num;
        init_digital_id_num = Font0_commonMainKt.init_digital_id_num();
        return init_digital_id_num;
    }

    public final FontResource getDigital_id_num() {
        return (FontResource) digital_id_num$delegate.getValue();
    }
}