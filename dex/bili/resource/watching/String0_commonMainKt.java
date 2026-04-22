package bili.resource.watching;

import bili.resource.watching.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\ba\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\u001a\b\u0010S\u001a\u00020\u0001H\u0002\u001a\b\u0010V\u001a\u00020\u0001H\u0002\u001a\b\u0010Y\u001a\u00020\u0001H\u0002\u001a\b\u0010\\\u001a\u00020\u0001H\u0002\u001a\b\u0010_\u001a\u00020\u0001H\u0002\u001a\b\u0010b\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010\u0004\"\u0015\u0010T\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0004\"\u0015\u0010W\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u0004\"\u0015\u0010Z\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\u0004\"\u0015\u0010]\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010\u0004\"\u0015\u0010`\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\ba\u0010\u0004¨\u0006c"}, d2 = {"watching_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "Lbili/resource/watching/Res$string;", "getWatching_global_string_1", "(Lbili/resource/watching/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_watching_global_string_1", "watching_global_string_10", "getWatching_global_string_10", "init_watching_global_string_10", "watching_global_string_11", "getWatching_global_string_11", "init_watching_global_string_11", "watching_global_string_12", "getWatching_global_string_12", "init_watching_global_string_12", "watching_global_string_13", "getWatching_global_string_13", "init_watching_global_string_13", "watching_global_string_14", "getWatching_global_string_14", "init_watching_global_string_14", "watching_global_string_15", "getWatching_global_string_15", "init_watching_global_string_15", "watching_global_string_16", "getWatching_global_string_16", "init_watching_global_string_16", "watching_global_string_17", "getWatching_global_string_17", "init_watching_global_string_17", "watching_global_string_18", "getWatching_global_string_18", "init_watching_global_string_18", "watching_global_string_19", "getWatching_global_string_19", "init_watching_global_string_19", "watching_global_string_2", "getWatching_global_string_2", "init_watching_global_string_2", "watching_global_string_20", "getWatching_global_string_20", "init_watching_global_string_20", "watching_global_string_21", "getWatching_global_string_21", "init_watching_global_string_21", "watching_global_string_22", "getWatching_global_string_22", "init_watching_global_string_22", "watching_global_string_23", "getWatching_global_string_23", "init_watching_global_string_23", "watching_global_string_24", "getWatching_global_string_24", "init_watching_global_string_24", "watching_global_string_25", "getWatching_global_string_25", "init_watching_global_string_25", "watching_global_string_26", "getWatching_global_string_26", "init_watching_global_string_26", "watching_global_string_27", "getWatching_global_string_27", "init_watching_global_string_27", "watching_global_string_28", "getWatching_global_string_28", "init_watching_global_string_28", "watching_global_string_29", "getWatching_global_string_29", "init_watching_global_string_29", "watching_global_string_3", "getWatching_global_string_3", "init_watching_global_string_3", "watching_global_string_30", "getWatching_global_string_30", "init_watching_global_string_30", "watching_global_string_31", "getWatching_global_string_31", "init_watching_global_string_31", "watching_global_string_32", "getWatching_global_string_32", "init_watching_global_string_32", "watching_global_string_33", "getWatching_global_string_33", "init_watching_global_string_33", "watching_global_string_34", "getWatching_global_string_34", "init_watching_global_string_34", "watching_global_string_5", "getWatching_global_string_5", "init_watching_global_string_5", "watching_global_string_6", "getWatching_global_string_6", "init_watching_global_string_6", "watching_global_string_7", "getWatching_global_string_7", "init_watching_global_string_7", "watching_global_string_9", "getWatching_global_string_9", "init_watching_global_string_9", "watching_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class String0_commonMainKt {
    public static final StringResource getWatching_global_string_1(Res.string $this$watching_global_string_1) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_1, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_1() {
        return new StringResource("string:watching_global_string_1", "watching_global_string_1", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 546L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 430L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 446L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 438L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 446L, 72L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 434L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 434L, 48L)}));
    }

    public static final StringResource getWatching_global_string_10(Res.string $this$watching_global_string_10) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_10, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_10();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_10() {
        return new StringResource("string:watching_global_string_10", "watching_global_string_10", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 10L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 10L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 10L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 10L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 10L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 10L, 45L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 10L, 45L)}));
    }

    public static final StringResource getWatching_global_string_11(Res.string $this$watching_global_string_11) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_11, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_11();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_11() {
        return new StringResource("string:watching_global_string_11", "watching_global_string_11", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 68L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 56L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 56L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 60L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 56L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 56L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 56L, 41L)}));
    }

    public static final StringResource getWatching_global_string_12(Res.string $this$watching_global_string_12) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_12, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_12();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_12() {
        return new StringResource("string:watching_global_string_12", "watching_global_string_12", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 122L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 98L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 98L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 102L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 102L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 98L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 98L, 41L)}));
    }

    public static final StringResource getWatching_global_string_13(Res.string $this$watching_global_string_13) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_13, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_13();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_13() {
        return new StringResource("string:watching_global_string_13", "watching_global_string_13", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 176L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 140L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 144L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 144L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 148L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 140L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 140L, 41L)}));
    }

    public static final StringResource getWatching_global_string_14(Res.string $this$watching_global_string_14) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_14, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_14();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_14() {
        return new StringResource("string:watching_global_string_14", "watching_global_string_14", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 226L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 182L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 186L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 186L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 190L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 182L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 182L, 41L)}));
    }

    public static final StringResource getWatching_global_string_15(Res.string $this$watching_global_string_15) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_15, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_15();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_15() {
        return new StringResource("string:watching_global_string_15", "watching_global_string_15", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 280L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 224L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 228L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 228L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 232L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 224L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 224L, 41L)}));
    }

    public static final StringResource getWatching_global_string_16(Res.string $this$watching_global_string_16) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_16, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_16();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_16() {
        return new StringResource("string:watching_global_string_16", "watching_global_string_16", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 330L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 262L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 270L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 270L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 274L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 266L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 266L, 41L)}));
    }

    public static final StringResource getWatching_global_string_17(Res.string $this$watching_global_string_17) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_17, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_17();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_17() {
        return new StringResource("string:watching_global_string_17", "watching_global_string_17", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 384L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 304L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 312L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 312L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 316L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 308L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 308L, 41L)}));
    }

    public static final StringResource getWatching_global_string_18(Res.string $this$watching_global_string_18) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_18, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_18();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_18() {
        return new StringResource("string:watching_global_string_18", "watching_global_string_18", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 438L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 346L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 354L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 354L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 358L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 350L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 350L, 41L)}));
    }

    public static final StringResource getWatching_global_string_19(Res.string $this$watching_global_string_19) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_19, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_19();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_19() {
        return new StringResource("string:watching_global_string_19", "watching_global_string_19", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 492L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 388L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 396L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 396L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 400L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 392L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 392L, 41L)}));
    }

    public static final StringResource getWatching_global_string_2(Res.string $this$watching_global_string_2) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_2, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_2() {
        return new StringResource("string:watching_global_string_2", "watching_global_string_2", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1135L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 903L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 939L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 891L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 943L, 64L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 883L, 52L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 883L, 52L)}));
    }

    public static final StringResource getWatching_global_string_20(Res.string $this$watching_global_string_20) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_20, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_20();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_20() {
        return new StringResource("string:watching_global_string_20", "watching_global_string_20", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 619L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 483L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 515L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 499L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 519L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 483L, 41L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 483L, 41L)}));
    }

    public static final StringResource getWatching_global_string_21(Res.string $this$watching_global_string_21) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_21, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_21();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_21() {
        return new StringResource("string:watching_global_string_21", "watching_global_string_21", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 673L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 525L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 561L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 541L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 565L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 525L, 45L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 525L, 45L)}));
    }

    public static final StringResource getWatching_global_string_22(Res.string $this$watching_global_string_22) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_22, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_22();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_22() {
        return new StringResource("string:watching_global_string_22", "watching_global_string_22", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 727L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 567L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 607L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 583L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 611L, 45L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 571L, 45L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 571L, 45L)}));
    }

    public static final StringResource getWatching_global_string_23(Res.string $this$watching_global_string_23) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_23, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_23();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_23() {
        return new StringResource("string:watching_global_string_23", "watching_global_string_23", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 781L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 609L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 653L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 625L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 657L, 37L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 617L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 617L, 37L)}));
    }

    public static final StringResource getWatching_global_string_24(Res.string $this$watching_global_string_24) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_24, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_24();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_24() {
        return new StringResource("string:watching_global_string_24", "watching_global_string_24", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 831L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 651L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 691L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 663L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 695L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 655L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 655L, 37L)}));
    }

    public static final StringResource getWatching_global_string_25(Res.string $this$watching_global_string_25) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_25, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_25();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_25() {
        return new StringResource("string:watching_global_string_25", "watching_global_string_25", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 885L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 693L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 729L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 701L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 737L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 693L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 693L, 37L)}));
    }

    public static final StringResource getWatching_global_string_26(Res.string $this$watching_global_string_26) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_26, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_26();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_26() {
        return new StringResource("string:watching_global_string_26", "watching_global_string_26", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 939L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 735L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 771L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 739L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 779L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 731L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 731L, 37L)}));
    }

    public static final StringResource getWatching_global_string_27(Res.string $this$watching_global_string_27) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_27, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_27();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_27() {
        return new StringResource("string:watching_global_string_27", "watching_global_string_27", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 993L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 777L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 813L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 777L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 821L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 769L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 769L, 37L)}));
    }

    public static final StringResource getWatching_global_string_28(Res.string $this$watching_global_string_28) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_28, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_28();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_28() {
        return new StringResource("string:watching_global_string_28", "watching_global_string_28", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1043L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 819L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 855L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 815L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 863L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 807L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 807L, 37L)}));
    }

    public static final StringResource getWatching_global_string_29(Res.string $this$watching_global_string_29) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_29, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_29();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_29() {
        return new StringResource("string:watching_global_string_29", "watching_global_string_29", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1089L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 861L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 897L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 853L, 37L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 905L, 37L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 845L, 37L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 845L, 37L)}));
    }

    public static final StringResource getWatching_global_string_3(Res.string $this$watching_global_string_3) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_3, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_3() {
        return new StringResource("string:watching_global_string_3", "watching_global_string_3", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1862L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1318L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1382L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1406L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1418L, 68L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1290L, 64L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1290L, 64L)}));
    }

    public static final StringResource getWatching_global_string_30(Res.string $this$watching_global_string_30) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_30, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_30();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_30() {
        return new StringResource("string:watching_global_string_30", "watching_global_string_30", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1220L, 85L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 952L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 992L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 940L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1008L, 53L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 936L, 61L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 936L, 61L)}));
    }

    public static final StringResource getWatching_global_string_31(Res.string $this$watching_global_string_31) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_31, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_31();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_31() {
        return new StringResource("string:watching_global_string_31", "watching_global_string_31", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1306L, 141L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1002L, 85L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1042L, 97L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 998L, 121L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1062L, 93L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 998L, 73L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 998L, 73L)}));
    }

    public static final StringResource getWatching_global_string_32(Res.string $this$watching_global_string_32) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_32, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_32();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_32() {
        return new StringResource("string:watching_global_string_32", "watching_global_string_32", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1448L, 89L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1088L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1140L, 65L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1120L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1156L, 73L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1072L, 49L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1072L, 49L)}));
    }

    public static final StringResource getWatching_global_string_33(Res.string $this$watching_global_string_33) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_33, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_33();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_33() {
        return new StringResource("string:watching_global_string_33", "watching_global_string_33", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1538L, 245L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1142L, 109L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1206L, 117L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1174L, 173L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1230L, 121L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1122L, 117L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1122L, 117L)}));
    }

    public static final StringResource getWatching_global_string_34(Res.string $this$watching_global_string_34) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_34, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_34();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_34() {
        return new StringResource("string:watching_global_string_34", "watching_global_string_34", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1784L, 77L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1252L, 65L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1324L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1348L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1352L, 65L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1240L, 49L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1240L, 49L)}));
    }

    public static final StringResource getWatching_global_string_5(Res.string $this$watching_global_string_5) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_5, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_5() {
        return new StringResource("string:watching_global_string_5", "watching_global_string_5", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 1951L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1375L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1451L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1483L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1487L, 56L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1355L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1355L, 48L)}));
    }

    public static final StringResource getWatching_global_string_6(Res.string $this$watching_global_string_6) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_6, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_6() {
        return new StringResource("string:watching_global_string_6", "watching_global_string_6", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 2008L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1420L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1516L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1540L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1544L, 44L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1404L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1404L, 40L)}));
    }

    public static final StringResource getWatching_global_string_7(Res.string $this$watching_global_string_7) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_7, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_7() {
        return new StringResource("string:watching_global_string_7", "watching_global_string_7", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 2053L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1465L, 36L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1561L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1581L, 36L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1589L, 36L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1445L, 36L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1445L, 36L)}));
    }

    public static final StringResource getWatching_global_string_9(Res.string $this$watching_global_string_9) {
        Intrinsics.checkNotNullParameter($this$watching_global_string_9, "<this>");
        return CommonMainString0.INSTANCE.getWatching_global_string_9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_watching_global_string_9() {
        return new StringResource("string:watching_global_string_9", "watching_global_string_9", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.watching/values-ar/strings.commonMain.cvr", 2098L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.watching/values-en/strings.commonMain.cvr", 1502L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.watching/values-es/strings.commonMain.cvr", 1602L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.watching/values-ja/strings.commonMain.cvr", 1618L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.watching/values-pt/strings.commonMain.cvr", 1626L, 44L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.watching/values-zh-rHK/strings.commonMain.cvr", 1482L, 44L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.watching/values/strings.commonMain.cvr", 1482L, 44L)}));
    }
}