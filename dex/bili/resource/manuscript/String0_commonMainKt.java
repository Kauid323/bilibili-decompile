package bili.resource.manuscript;

import bili.resource.manuscript.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"manuscript_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "Lbili/resource/manuscript/Res$string;", "getManuscript_global_string_1", "(Lbili/resource/manuscript/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_manuscript_global_string_1", "manuscript_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class String0_commonMainKt {
    public static final StringResource getManuscript_global_string_1(Res.string $this$manuscript_global_string_1) {
        Intrinsics.checkNotNullParameter($this$manuscript_global_string_1, "<this>");
        return CommonMainString0.INSTANCE.getManuscript_global_string_1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_manuscript_global_string_1() {
        return new StringResource("string:manuscript_global_string_1", "manuscript_global_string_1", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.manuscript/values-ar/strings.commonMain.cvr", 10L, 54L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.manuscript/values-en/strings.commonMain.cvr", 10L, 42L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.manuscript/values-es/strings.commonMain.cvr", 10L, 46L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.manuscript/values-ja/strings.commonMain.cvr", 10L, 42L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.manuscript/values-pt/strings.commonMain.cvr", 10L, 46L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.manuscript/values-zh-rHK/strings.commonMain.cvr", 10L, 42L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.manuscript/values/strings.commonMain.cvr", 10L, 42L)}));
    }
}