package bili.resource.search;

import com.bilibili.crow.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.PluralStringResource;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lbili/resource/search/CommonMainPlurals0;", BuildConfig.FLAVOR, "<init>", "()V", "search_global_string_261", "Lorg/jetbrains/compose/resources/PluralStringResource;", "getSearch_global_string_261", "()Lorg/jetbrains/compose/resources/PluralStringResource;", "search_global_string_261$delegate", "Lkotlin/Lazy;", "search_global_string_262", "getSearch_global_string_262", "search_global_string_262$delegate", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class CommonMainPlurals0 {
    public static final CommonMainPlurals0 INSTANCE = new CommonMainPlurals0();
    private static final Lazy search_global_string_261$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.search.CommonMainPlurals0$$ExternalSyntheticLambda0
        public final Object invoke() {
            PluralStringResource search_global_string_261_delegate$lambda$0;
            search_global_string_261_delegate$lambda$0 = CommonMainPlurals0.search_global_string_261_delegate$lambda$0();
            return search_global_string_261_delegate$lambda$0;
        }
    });
    private static final Lazy search_global_string_262$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.search.CommonMainPlurals0$$ExternalSyntheticLambda1
        public final Object invoke() {
            PluralStringResource search_global_string_262_delegate$lambda$0;
            search_global_string_262_delegate$lambda$0 = CommonMainPlurals0.search_global_string_262_delegate$lambda$0();
            return search_global_string_262_delegate$lambda$0;
        }
    });

    private CommonMainPlurals0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource search_global_string_261_delegate$lambda$0() {
        PluralStringResource init_search_global_string_261;
        init_search_global_string_261 = Plurals0_commonMainKt.init_search_global_string_261();
        return init_search_global_string_261;
    }

    public final PluralStringResource getSearch_global_string_261() {
        return (PluralStringResource) search_global_string_261$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource search_global_string_262_delegate$lambda$0() {
        PluralStringResource init_search_global_string_262;
        init_search_global_string_262 = Plurals0_commonMainKt.init_search_global_string_262();
        return init_search_global_string_262;
    }

    public final PluralStringResource getSearch_global_string_262() {
        return (PluralStringResource) search_global_string_262$delegate.getValue();
    }
}