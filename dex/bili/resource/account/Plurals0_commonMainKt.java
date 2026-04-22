package bili.resource.account;

import bili.resource.account.Res;
import com.bilibili.upper.BR;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"account_global_string_418", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lbili/resource/account/Res$plurals;", "getAccount_global_string_418", "(Lbili/resource/account/Res$plurals;)Lorg/jetbrains/compose/resources/PluralStringResource;", "init_account_global_string_418", "account_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Plurals0_commonMainKt {
    public static final PluralStringResource getAccount_global_string_418(Res.plurals $this$account_global_string_418) {
        Intrinsics.checkNotNullParameter($this$account_global_string_418, "<this>");
        return CommonMainPlurals0.INSTANCE.getAccount_global_string_418();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_account_global_string_418() {
        return new PluralStringResource("plurals:account_global_string_418", "account_global_string_418", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.account/values-ar/strings.commonMain.cvr", 10L, 503L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.account/values-en/strings.commonMain.cvr", 10L, 77L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.account/values-es/strings.commonMain.cvr", 10L, 111L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.account/values-ja/strings.commonMain.cvr", 10L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.account/values-pt/strings.commonMain.cvr", 10L, 123L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.account/values-zh-rHK/strings.commonMain.cvr", 10L, 60L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.account/values/strings.commonMain.cvr", 10L, 60L)}));
    }
}