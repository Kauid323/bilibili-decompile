package bili.resource.upper;

import bili.resource.upper.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b:\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004¨\u0006<"}, d2 = {"upper_global_string_3466", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lbili/resource/upper/Res$plurals;", "getUpper_global_string_3466", "(Lbili/resource/upper/Res$plurals;)Lorg/jetbrains/compose/resources/PluralStringResource;", "init_upper_global_string_3466", "upper_global_string_3473", "getUpper_global_string_3473", "init_upper_global_string_3473", "upper_global_string_3474", "getUpper_global_string_3474", "init_upper_global_string_3474", "upper_global_string_3475", "getUpper_global_string_3475", "init_upper_global_string_3475", "upper_global_string_3476", "getUpper_global_string_3476", "init_upper_global_string_3476", "upper_global_string_3477", "getUpper_global_string_3477", "init_upper_global_string_3477", "upper_global_string_3478", "getUpper_global_string_3478", "init_upper_global_string_3478", "upper_global_string_3479", "getUpper_global_string_3479", "init_upper_global_string_3479", "upper_global_string_3480", "getUpper_global_string_3480", "init_upper_global_string_3480", "upper_global_string_3487", "getUpper_global_string_3487", "init_upper_global_string_3487", "upper_global_string_3488", "getUpper_global_string_3488", "init_upper_global_string_3488", "upper_global_string_3489", "getUpper_global_string_3489", "init_upper_global_string_3489", "upper_global_string_3490", "getUpper_global_string_3490", "init_upper_global_string_3490", "upper_global_string_3494", "getUpper_global_string_3494", "init_upper_global_string_3494", "upper_global_string_3496", "getUpper_global_string_3496", "init_upper_global_string_3496", "upper_global_string_3501", "getUpper_global_string_3501", "init_upper_global_string_3501", "upper_global_string_3502", "getUpper_global_string_3502", "init_upper_global_string_3502", "upper_global_string_3504", "getUpper_global_string_3504", "init_upper_global_string_3504", "upper_global_string_3506", "getUpper_global_string_3506", "init_upper_global_string_3506", "upper_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Plurals0_commonMainKt {
    public static final PluralStringResource getUpper_global_string_3466(Res.plurals $this$upper_global_string_3466) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3466, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3466();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3466() {
        return new PluralStringResource("plurals:upper_global_string_3466", "upper_global_string_3466", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 10L, 382L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 10L, 112L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 10L, 134L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 10L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 10L, 178L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 10L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 10L, 71L)}));
    }

    public static final PluralStringResource getUpper_global_string_3473(Res.plurals $this$upper_global_string_3473) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3473, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3473();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3473() {
        return new PluralStringResource("plurals:upper_global_string_3473", "upper_global_string_3473", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 393L, 234L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 123L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 145L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 118L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 189L, 122L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 82L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 82L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3474(Res.plurals $this$upper_global_string_3474) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3474, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3474();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3474() {
        return new PluralStringResource("plurals:upper_global_string_3474", "upper_global_string_3474", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 628L, 214L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 204L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 264L, 110L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 190L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 312L, 110L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 142L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 142L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3475(Res.plurals $this$upper_global_string_3475) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3475, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3475();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3475() {
        return new PluralStringResource("plurals:upper_global_string_3475", "upper_global_string_3475", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 843L, 710L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 289L, 188L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 375L, 298L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 254L, 143L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 423L, 298L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 202L, 91L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 202L, 91L)}));
    }

    public static final PluralStringResource getUpper_global_string_3476(Res.plurals $this$upper_global_string_3476) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3476, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3476();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3476() {
        return new PluralStringResource("plurals:upper_global_string_3476", "upper_global_string_3476", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 1554L, 638L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 478L, 136L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 674L, 238L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 398L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 722L, 226L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 294L, 87L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 294L, 87L)}));
    }

    public static final PluralStringResource getUpper_global_string_3477(Res.plurals $this$upper_global_string_3477) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3477, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3477();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3477() {
        return new PluralStringResource("plurals:upper_global_string_3477", "upper_global_string_3477", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 2193L, 342L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 615L, 120L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 913L, 218L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 518L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 949L, 206L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 382L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 382L, 83L)}));
    }

    public static final PluralStringResource getUpper_global_string_3478(Res.plurals $this$upper_global_string_3478) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3478, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3478();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3478() {
        return new PluralStringResource("plurals:upper_global_string_3478", "upper_global_string_3478", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 2536L, 226L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 736L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1132L, 98L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 614L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1156L, 98L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 466L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 466L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3479(Res.plurals $this$upper_global_string_3479) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3479, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3479();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3479() {
        return new PluralStringResource("plurals:upper_global_string_3479", "upper_global_string_3479", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 2763L, 526L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 813L, 124L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1231L, 142L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 678L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1255L, 182L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 526L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 526L, 71L)}));
    }

    public static final PluralStringResource getUpper_global_string_3480(Res.plurals $this$upper_global_string_3480) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3480, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3480();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3480() {
        return new PluralStringResource("plurals:upper_global_string_3480", "upper_global_string_3480", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 3290L, 218L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 938L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1374L, 110L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 786L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1438L, 106L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 598L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 598L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3487(Res.plurals $this$upper_global_string_3487) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3487, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3487();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3487() {
        return new PluralStringResource("plurals:upper_global_string_3487", "upper_global_string_3487", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 3509L, 210L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1023L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1485L, 142L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 846L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1545L, 134L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 658L, 55L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 658L, 55L)}));
    }

    public static final PluralStringResource getUpper_global_string_3488(Res.plurals $this$upper_global_string_3488) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3488, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3488();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3488() {
        return new PluralStringResource("plurals:upper_global_string_3488", "upper_global_string_3488", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 3720L, 222L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1100L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1628L, 110L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 906L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1680L, 110L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 714L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 714L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3489(Res.plurals $this$upper_global_string_3489) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3489, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3489();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3489() {
        return new PluralStringResource("plurals:upper_global_string_3489", "upper_global_string_3489", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 3943L, 506L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1173L, 144L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1739L, 194L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 974L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 1791L, 242L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 774L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 774L, 83L)}));
    }

    public static final PluralStringResource getUpper_global_string_3490(Res.plurals $this$upper_global_string_3490) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3490, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3490();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3490() {
        return new PluralStringResource("plurals:upper_global_string_3490", "upper_global_string_3490", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 4450L, 426L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1318L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 1934L, 146L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1094L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 2034L, 158L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 858L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 858L, 67L)}));
    }

    public static final PluralStringResource getUpper_global_string_3494(Res.plurals $this$upper_global_string_3494) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3494, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3494();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3494() {
        return new PluralStringResource("plurals:upper_global_string_3494", "upper_global_string_3494", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 4877L, 438L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1415L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 2081L, 158L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1190L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 2193L, 158L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 926L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 926L, 67L)}));
    }

    public static final PluralStringResource getUpper_global_string_3496(Res.plurals $this$upper_global_string_3496) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3496, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3496();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3496() {
        return new PluralStringResource("plurals:upper_global_string_3496", "upper_global_string_3496", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 5316L, 198L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1524L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 2240L, 110L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1270L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 2352L, 110L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 994L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 994L, 59L)}));
    }

    public static final PluralStringResource getUpper_global_string_3501(Res.plurals $this$upper_global_string_3501) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3501, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3501();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3501() {
        return new PluralStringResource("plurals:upper_global_string_3501", "upper_global_string_3501", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 5515L, 798L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1597L, 180L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 2351L, 326L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1334L, 143L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 2463L, 326L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 1054L, 103L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 1054L, 103L)}));
    }

    public static final PluralStringResource getUpper_global_string_3502(Res.plurals $this$upper_global_string_3502) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3502, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3502();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3502() {
        return new PluralStringResource("plurals:upper_global_string_3502", "upper_global_string_3502", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 6314L, 502L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1778L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 2678L, 218L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1478L, 111L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 2790L, 218L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 1158L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 1158L, 75L)}));
    }

    public static final PluralStringResource getUpper_global_string_3504(Res.plurals $this$upper_global_string_3504) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3504, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3504();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3504() {
        return new PluralStringResource("plurals:upper_global_string_3504", "upper_global_string_3504", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 6817L, 806L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 1911L, 180L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 2897L, 322L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1590L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 3009L, 310L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 1234L, 103L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 1234L, 103L)}));
    }

    public static final PluralStringResource getUpper_global_string_3506(Res.plurals $this$upper_global_string_3506) {
        Intrinsics.checkNotNullParameter($this$upper_global_string_3506, "<this>");
        return CommonMainPlurals0.INSTANCE.getUpper_global_string_3506();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_upper_global_string_3506() {
        return new PluralStringResource("plurals:upper_global_string_3506", "upper_global_string_3506", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.upper/values-ar/strings.commonMain.cvr", 7624L, 402L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.upper/values-en/strings.commonMain.cvr", 2092L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.upper/values-es/strings.commonMain.cvr", 3220L, 158L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.upper/values-ja/strings.commonMain.cvr", 1722L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.upper/values-pt/strings.commonMain.cvr", 3320L, 154L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.upper/values-zh-rHK/strings.commonMain.cvr", 1338L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.upper/values/strings.commonMain.cvr", 1338L, 67L)}));
    }
}