package bili.resource.manuscript;

import com.bilibili.crow.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lbili/resource/manuscript/CommonMainString0;", BuildConfig.FLAVOR, "<init>", "()V", "manuscript_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "getManuscript_global_string_1", "()Lorg/jetbrains/compose/resources/StringResource;", "manuscript_global_string_1$delegate", "Lkotlin/Lazy;", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy manuscript_global_string_1$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.manuscript.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource manuscript_global_string_1_delegate$lambda$0;
            manuscript_global_string_1_delegate$lambda$0 = CommonMainString0.manuscript_global_string_1_delegate$lambda$0();
            return manuscript_global_string_1_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource manuscript_global_string_1_delegate$lambda$0() {
        StringResource init_manuscript_global_string_1;
        init_manuscript_global_string_1 = String0_commonMainKt.init_manuscript_global_string_1();
        return init_manuscript_global_string_1;
    }

    public final StringResource getManuscript_global_string_1() {
        return (StringResource) manuscript_global_string_1$delegate.getValue();
    }
}