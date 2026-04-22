package bili.resource.account;

import com.bilibili.upper.BR;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.PluralStringResource;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lbili/resource/account/CommonMainPlurals0;", "", "<init>", "()V", "account_global_string_418", "Lorg/jetbrains/compose/resources/PluralStringResource;", "getAccount_global_string_418", "()Lorg/jetbrains/compose/resources/PluralStringResource;", "account_global_string_418$delegate", "Lkotlin/Lazy;", "account_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainPlurals0 {
    public static final CommonMainPlurals0 INSTANCE = new CommonMainPlurals0();
    private static final Lazy account_global_string_418$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.account.CommonMainPlurals0$$ExternalSyntheticLambda0
        public final Object invoke() {
            PluralStringResource account_global_string_418_delegate$lambda$0;
            account_global_string_418_delegate$lambda$0 = CommonMainPlurals0.account_global_string_418_delegate$lambda$0();
            return account_global_string_418_delegate$lambda$0;
        }
    });

    private CommonMainPlurals0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource account_global_string_418_delegate$lambda$0() {
        PluralStringResource init_account_global_string_418;
        init_account_global_string_418 = Plurals0_commonMainKt.init_account_global_string_418();
        return init_account_global_string_418;
    }

    public final PluralStringResource getAccount_global_string_418() {
        return (PluralStringResource) account_global_string_418$delegate.getValue();
    }
}