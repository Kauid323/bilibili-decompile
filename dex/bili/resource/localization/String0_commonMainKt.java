package bili.resource.localization;

import bili.resource.localization.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bO\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004¨\u0006Q"}, d2 = {"localization_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "Lbili/resource/localization/Res$string;", "getLocalization_global_string_1", "(Lbili/resource/localization/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_localization_global_string_1", "localization_global_string_10", "getLocalization_global_string_10", "init_localization_global_string_10", "localization_global_string_12", "getLocalization_global_string_12", "init_localization_global_string_12", "localization_global_string_14", "getLocalization_global_string_14", "init_localization_global_string_14", "localization_global_string_15", "getLocalization_global_string_15", "init_localization_global_string_15", "localization_global_string_16", "getLocalization_global_string_16", "init_localization_global_string_16", "localization_global_string_17", "getLocalization_global_string_17", "init_localization_global_string_17", "localization_global_string_18", "getLocalization_global_string_18", "init_localization_global_string_18", "localization_global_string_19", "getLocalization_global_string_19", "init_localization_global_string_19", "localization_global_string_2", "getLocalization_global_string_2", "init_localization_global_string_2", "localization_global_string_3", "getLocalization_global_string_3", "init_localization_global_string_3", "localization_global_string_33", "getLocalization_global_string_33", "init_localization_global_string_33", "localization_global_string_34", "getLocalization_global_string_34", "init_localization_global_string_34", "localization_global_string_35", "getLocalization_global_string_35", "init_localization_global_string_35", "localization_global_string_36", "getLocalization_global_string_36", "init_localization_global_string_36", "localization_global_string_37", "getLocalization_global_string_37", "init_localization_global_string_37", "localization_global_string_38", "getLocalization_global_string_38", "init_localization_global_string_38", "localization_global_string_39", "getLocalization_global_string_39", "init_localization_global_string_39", "localization_global_string_4", "getLocalization_global_string_4", "init_localization_global_string_4", "localization_global_string_40", "getLocalization_global_string_40", "init_localization_global_string_40", "localization_global_string_41", "getLocalization_global_string_41", "init_localization_global_string_41", "localization_global_string_5", "getLocalization_global_string_5", "init_localization_global_string_5", "localization_global_string_6", "getLocalization_global_string_6", "init_localization_global_string_6", "localization_global_string_7", "getLocalization_global_string_7", "init_localization_global_string_7", "localization_global_string_8", "getLocalization_global_string_8", "init_localization_global_string_8", "localization_global_string_9", "getLocalization_global_string_9", "init_localization_global_string_9", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class String0_commonMainKt {
    public static final StringResource getLocalization_global_string_1(Res.string $this$localization_global_string_1) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_1, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_1() {
        return new StringResource("string:localization_global_string_1", "localization_global_string_1", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1382L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1076L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1354L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 957L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1370L, 60L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 941L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 941L, 56L)}));
    }

    public static final StringResource getLocalization_global_string_10(Res.string $this$localization_global_string_10) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_10, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_10();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_10() {
        return new StringResource("string:localization_global_string_10", "localization_global_string_10", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 842L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 604L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 862L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 461L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 862L, 61L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 445L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 445L, 57L)}));
    }

    public static final StringResource getLocalization_global_string_12(Res.string $this$localization_global_string_12) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_12, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_12();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_12() {
        return new StringResource("string:localization_global_string_12", "localization_global_string_12", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 912L, 61L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 658L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 916L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 519L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 924L, 53L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 503L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 503L, 57L)}));
    }

    public static final StringResource getLocalization_global_string_14(Res.string $this$localization_global_string_14) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_14, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_14();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_14() {
        return new StringResource("string:localization_global_string_14", "localization_global_string_14", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 974L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 712L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 970L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 577L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 978L, 61L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 561L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 561L, 57L)}));
    }

    public static final StringResource getLocalization_global_string_15(Res.string $this$localization_global_string_15) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_15, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_15();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_15() {
        return new StringResource("string:localization_global_string_15", "localization_global_string_15", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1044L, 65L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 766L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1024L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 635L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1040L, 61L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 619L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 619L, 57L)}));
    }

    public static final StringResource getLocalization_global_string_16(Res.string $this$localization_global_string_16) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_16, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_16();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_16() {
        return new StringResource("string:localization_global_string_16", "localization_global_string_16", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1110L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 824L, 65L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1078L, 77L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 693L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1102L, 69L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 677L, 69L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 677L, 69L)}));
    }

    public static final StringResource getLocalization_global_string_17(Res.string $this$localization_global_string_17) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_17, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_17();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_17() {
        return new StringResource("string:localization_global_string_17", "localization_global_string_17", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1180L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 890L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1156L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 763L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1172L, 61L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 747L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 747L, 57L)}));
    }

    public static final StringResource getLocalization_global_string_18(Res.string $this$localization_global_string_18) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_18, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_18();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_18() {
        return new StringResource("string:localization_global_string_18", "localization_global_string_18", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1250L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 948L, 57L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1214L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 821L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1234L, 53L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 805L, 53L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 805L, 53L)}));
    }

    public static final StringResource getLocalization_global_string_19(Res.string $this$localization_global_string_19) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_19, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_19();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_19() {
        return new StringResource("string:localization_global_string_19", "localization_global_string_19", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1308L, 73L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1006L, 69L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1264L, 89L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 875L, 81L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1288L, 81L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 859L, 81L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 859L, 81L)}));
    }

    public static final StringResource getLocalization_global_string_2(Res.string $this$localization_global_string_2) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_2, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_2() {
        return new StringResource("string:localization_global_string_2", "localization_global_string_2", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1447L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1129L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1407L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1014L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1431L, 64L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 998L, 64L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 998L, 64L)}));
    }

    public static final StringResource getLocalization_global_string_3(Res.string $this$localization_global_string_3) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_3, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_3() {
        return new StringResource("string:localization_global_string_3", "localization_global_string_3", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1508L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1186L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1818L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1079L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1866L, 52L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1063L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1385L, 56L)}));
    }

    public static final StringResource getLocalization_global_string_33(Res.string $this$localization_global_string_33) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_33, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_33();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_33() {
        return new StringResource("string:localization_global_string_33", "localization_global_string_33", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1484L, 41L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1496L, 45L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1063L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_34(Res.string $this$localization_global_string_34) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_34, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_34();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_34() {
        return new StringResource("string:localization_global_string_34", "localization_global_string_34", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1526L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1542L, 57L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1109L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_35(Res.string $this$localization_global_string_35) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_35, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_35();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_35() {
        return new StringResource("string:localization_global_string_35", "localization_global_string_35", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1572L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1600L, 53L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1155L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_36(Res.string $this$localization_global_string_36) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_36, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_36();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_36() {
        return new StringResource("string:localization_global_string_36", "localization_global_string_36", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1618L, 53L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1654L, 53L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1201L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_37(Res.string $this$localization_global_string_37) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_37, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_37();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_37() {
        return new StringResource("string:localization_global_string_37", "localization_global_string_37", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1672L, 45L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1708L, 53L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1247L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_38(Res.string $this$localization_global_string_38) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_38, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_38();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_38() {
        return new StringResource("string:localization_global_string_38", "localization_global_string_38", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1718L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1762L, 53L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1293L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_39(Res.string $this$localization_global_string_39) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_39, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_39();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_39() {
        return new StringResource("string:localization_global_string_39", "localization_global_string_39", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1768L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1816L, 49L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1339L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_4(Res.string $this$localization_global_string_4) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_4, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_4() {
        return new StringResource("string:localization_global_string_4", "localization_global_string_4", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1561L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1235L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1987L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1136L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2031L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1120L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1554L, 48L)}));
    }

    public static final StringResource getLocalization_global_string_40(Res.string $this$localization_global_string_40) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_40, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_40();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_40() {
        return new StringResource("string:localization_global_string_40", "localization_global_string_40", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1871L, 49L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1919L, 49L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1442L, 45L)}));
    }

    public static final StringResource getLocalization_global_string_41(Res.string $this$localization_global_string_41) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_41, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_41();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_41() {
        return new StringResource("string:localization_global_string_41", "localization_global_string_41", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 1921L, 65L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 1969L, 61L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1488L, 65L)}));
    }

    public static final StringResource getLocalization_global_string_5(Res.string $this$localization_global_string_5) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_5, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_5() {
        return new StringResource("string:localization_global_string_5", "localization_global_string_5", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1614L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1284L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 2036L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1185L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2080L, 52L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1169L, 52L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1603L, 52L)}));
    }

    public static final StringResource getLocalization_global_string_6(Res.string $this$localization_global_string_6) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_6, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_6() {
        return new StringResource("string:localization_global_string_6", "localization_global_string_6", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1675L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1341L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 2089L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1238L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2133L, 68L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1222L, 68L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1656L, 68L)}));
    }

    public static final StringResource getLocalization_global_string_7(Res.string $this$localization_global_string_7) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_7, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_7() {
        return new StringResource("string:localization_global_string_7", "localization_global_string_7", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1748L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1410L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 2158L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1307L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2202L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1291L, 52L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1725L, 52L)}));
    }

    public static final StringResource getLocalization_global_string_8(Res.string $this$localization_global_string_8) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_8, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_8() {
        return new StringResource("string:localization_global_string_8", "localization_global_string_8", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1809L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1463L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 2207L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1360L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2251L, 52L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1344L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1778L, 56L)}));
    }

    public static final StringResource getLocalization_global_string_9(Res.string $this$localization_global_string_9) {
        Intrinsics.checkNotNullParameter($this$localization_global_string_9, "<this>");
        return CommonMainString0.INSTANCE.getLocalization_global_string_9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_localization_global_string_9() {
        return new StringResource("string:localization_global_string_9", "localization_global_string_9", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.localization/values-ar/strings.commonMain.cvr", 1870L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.localization/values-en/strings.commonMain.cvr", 1520L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.localization/values-es/strings.commonMain.cvr", 2260L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.localization/values-ja/strings.commonMain.cvr", 1417L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.localization/values-pt/strings.commonMain.cvr", 2304L, 52L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.localization/values-zh-rHK/strings.commonMain.cvr", 1401L, 44L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.localization/values/strings.commonMain.cvr", 1835L, 44L)}));
    }
}