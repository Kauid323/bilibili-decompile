package bili.resource.charge;

import bili.resource.charge.Res;
import com.bilibili.upper.BR;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b|\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\u001a\b\u0010S\u001a\u00020\u0001H\u0002\u001a\b\u0010V\u001a\u00020\u0001H\u0002\u001a\b\u0010Y\u001a\u00020\u0001H\u0002\u001a\b\u0010\\\u001a\u00020\u0001H\u0002\u001a\b\u0010_\u001a\u00020\u0001H\u0002\u001a\b\u0010b\u001a\u00020\u0001H\u0002\u001a\b\u0010e\u001a\u00020\u0001H\u0002\u001a\b\u0010h\u001a\u00020\u0001H\u0002\u001a\b\u0010k\u001a\u00020\u0001H\u0002\u001a\b\u0010n\u001a\u00020\u0001H\u0002\u001a\b\u0010q\u001a\u00020\u0001H\u0002\u001a\b\u0010t\u001a\u00020\u0001H\u0002\u001a\b\u0010w\u001a\u00020\u0001H\u0002\u001a\b\u0010z\u001a\u00020\u0001H\u0002\u001a\b\u0010}\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010\u0004\"\u0015\u0010T\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0004\"\u0015\u0010W\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u0004\"\u0015\u0010Z\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\u0004\"\u0015\u0010]\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010\u0004\"\u0015\u0010`\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\ba\u0010\u0004\"\u0015\u0010c\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bd\u0010\u0004\"\u0015\u0010f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bg\u0010\u0004\"\u0015\u0010i\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bj\u0010\u0004\"\u0015\u0010l\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bm\u0010\u0004\"\u0015\u0010o\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bp\u0010\u0004\"\u0015\u0010r\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bs\u0010\u0004\"\u0015\u0010u\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bv\u0010\u0004\"\u0015\u0010x\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\by\u0010\u0004\"\u0015\u0010{\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b|\u0010\u0004¨\u0006~"}, d2 = {"charge_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "Lbili/resource/charge/Res$string;", "getCharge_global_string_1", "(Lbili/resource/charge/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_charge_global_string_1", "charge_global_string_10", "getCharge_global_string_10", "init_charge_global_string_10", "charge_global_string_11", "getCharge_global_string_11", "init_charge_global_string_11", "charge_global_string_14", "getCharge_global_string_14", "init_charge_global_string_14", "charge_global_string_15", "getCharge_global_string_15", "init_charge_global_string_15", "charge_global_string_16", "getCharge_global_string_16", "init_charge_global_string_16", "charge_global_string_17", "getCharge_global_string_17", "init_charge_global_string_17", "charge_global_string_18", "getCharge_global_string_18", "init_charge_global_string_18", "charge_global_string_19", "getCharge_global_string_19", "init_charge_global_string_19", "charge_global_string_2", "getCharge_global_string_2", "init_charge_global_string_2", "charge_global_string_20", "getCharge_global_string_20", "init_charge_global_string_20", "charge_global_string_21", "getCharge_global_string_21", "init_charge_global_string_21", "charge_global_string_22", "getCharge_global_string_22", "init_charge_global_string_22", "charge_global_string_23", "getCharge_global_string_23", "init_charge_global_string_23", "charge_global_string_24", "getCharge_global_string_24", "init_charge_global_string_24", "charge_global_string_26", "getCharge_global_string_26", "init_charge_global_string_26", "charge_global_string_28", "getCharge_global_string_28", "init_charge_global_string_28", "charge_global_string_3", "getCharge_global_string_3", "init_charge_global_string_3", "charge_global_string_30", "getCharge_global_string_30", "init_charge_global_string_30", "charge_global_string_31", "getCharge_global_string_31", "init_charge_global_string_31", "charge_global_string_32", "getCharge_global_string_32", "init_charge_global_string_32", "charge_global_string_33", "getCharge_global_string_33", "init_charge_global_string_33", "charge_global_string_34", "getCharge_global_string_34", "init_charge_global_string_34", "charge_global_string_35", "getCharge_global_string_35", "init_charge_global_string_35", "charge_global_string_36", "getCharge_global_string_36", "init_charge_global_string_36", "charge_global_string_37", "getCharge_global_string_37", "init_charge_global_string_37", "charge_global_string_38", "getCharge_global_string_38", "init_charge_global_string_38", "charge_global_string_39", "getCharge_global_string_39", "init_charge_global_string_39", "charge_global_string_4", "getCharge_global_string_4", "init_charge_global_string_4", "charge_global_string_41", "getCharge_global_string_41", "init_charge_global_string_41", "charge_global_string_43", "getCharge_global_string_43", "init_charge_global_string_43", "charge_global_string_44", "getCharge_global_string_44", "init_charge_global_string_44", "charge_global_string_45", "getCharge_global_string_45", "init_charge_global_string_45", "charge_global_string_46", "getCharge_global_string_46", "init_charge_global_string_46", "charge_global_string_48", "getCharge_global_string_48", "init_charge_global_string_48", "charge_global_string_5", "getCharge_global_string_5", "init_charge_global_string_5", "charge_global_string_57", "getCharge_global_string_57", "init_charge_global_string_57", "charge_global_string_6", "getCharge_global_string_6", "init_charge_global_string_6", "charge_global_string_7", "getCharge_global_string_7", "init_charge_global_string_7", "charge_global_string_8", "getCharge_global_string_8", "init_charge_global_string_8", "charge_global_string_9", "getCharge_global_string_9", "init_charge_global_string_9", "charge_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class String0_commonMainKt {
    public static final StringResource getCharge_global_string_1(Res.string $this$charge_global_string_1) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_1, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_1() {
        return new StringResource("string:charge_global_string_1", "charge_global_string_1", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2198L, 178L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1042L, 146L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1298L, 134L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 886L, 110L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1334L, 134L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 738L, 114L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 738L, 114L)}));
    }

    public static final StringResource getCharge_global_string_10(Res.string $this$charge_global_string_10) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_10, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_10();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_10() {
        return new StringResource("string:charge_global_string_10", "charge_global_string_10", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1526L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 510L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 742L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 318L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 718L, 67L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 290L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 290L, 47L)}));
    }

    public static final StringResource getCharge_global_string_11(Res.string $this$charge_global_string_11) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_11, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_11();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_11() {
        return new StringResource("string:charge_global_string_11", "charge_global_string_11", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1598L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 570L, 39L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 794L, 39L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 366L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 786L, 39L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 338L, 43L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 338L, 43L)}));
    }

    public static final StringResource getCharge_global_string_14(Res.string $this$charge_global_string_14) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_14, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_14();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_14() {
        return new StringResource("string:charge_global_string_14", "charge_global_string_14", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1646L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 610L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 834L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 414L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 826L, 71L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 382L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 382L, 47L)}));
    }

    public static final StringResource getCharge_global_string_15(Res.string $this$charge_global_string_15) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_15, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_15();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_15() {
        return new StringResource("string:charge_global_string_15", "charge_global_string_15", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1738L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 658L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 902L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 490L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 898L, 71L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 430L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 430L, 47L)}));
    }

    public static final StringResource getCharge_global_string_16(Res.string $this$charge_global_string_16) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_16, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_16();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_16() {
        return new StringResource("string:charge_global_string_16", "charge_global_string_16", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1822L, 103L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 730L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 966L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 558L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 970L, 87L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 478L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 478L, 59L)}));
    }

    public static final StringResource getCharge_global_string_17(Res.string $this$charge_global_string_17) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_17, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_17();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_17() {
        return new StringResource("string:charge_global_string_17", "charge_global_string_17", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1926L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 806L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1054L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 650L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1058L, 71L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 538L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 538L, 47L)}));
    }

    public static final StringResource getCharge_global_string_18(Res.string $this$charge_global_string_18) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_18, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_18();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_18() {
        return new StringResource("string:charge_global_string_18", "charge_global_string_18", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 1986L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 866L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1118L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 698L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1130L, 63L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 586L, 51L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 586L, 51L)}));
    }

    public static final StringResource getCharge_global_string_19(Res.string $this$charge_global_string_19) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_19, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_19();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_19() {
        return new StringResource("string:charge_global_string_19", "charge_global_string_19", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2050L, 147L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 926L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1174L, 123L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 758L, 127L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1194L, 139L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 638L, 99L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 638L, 99L)}));
    }

    public static final StringResource getCharge_global_string_2(Res.string $this$charge_global_string_2) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_2, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_2() {
        return new StringResource("string:charge_global_string_2", "charge_global_string_2", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3213L, 266L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1825L, 182L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2145L, 214L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1665L, 126L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2245L, 206L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1441L, 134L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1441L, 134L)}));
    }

    public static final StringResource getCharge_global_string_20(Res.string $this$charge_global_string_20) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_20, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_20();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_20() {
        return new StringResource("string:charge_global_string_20", "charge_global_string_20", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2377L, 155L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1189L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1433L, 127L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 997L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1469L, 139L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 853L, 99L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 853L, 99L)}));
    }

    public static final StringResource getCharge_global_string_21(Res.string $this$charge_global_string_21) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_21, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_21();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_21() {
        return new StringResource("string:charge_global_string_21", "charge_global_string_21", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2533L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1309L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1561L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1113L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1609L, 67L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 953L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 953L, 47L)}));
    }

    public static final StringResource getCharge_global_string_22(Res.string $this$charge_global_string_22) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_22, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_22();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_22() {
        return new StringResource("string:charge_global_string_22", "charge_global_string_22", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2605L, 143L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1361L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1625L, 151L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1173L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1677L, 151L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1001L, 95L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1001L, 95L)}));
    }

    public static final StringResource getCharge_global_string_23(Res.string $this$charge_global_string_23) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_23, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_23();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_23() {
        return new StringResource("string:charge_global_string_23", "charge_global_string_23", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2749L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1481L, 43L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1777L, 43L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1293L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1829L, 43L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1097L, 51L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1097L, 51L)}));
    }

    public static final StringResource getCharge_global_string_24(Res.string $this$charge_global_string_24) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_24, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_24();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_24() {
        return new StringResource("string:charge_global_string_24", "charge_global_string_24", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 2805L, 235L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1525L, 151L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1821L, 159L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1349L, 163L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 1873L, 203L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1149L, 151L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1149L, 151L)}));
    }

    public static final StringResource getCharge_global_string_26(Res.string $this$charge_global_string_26) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_26, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_26();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_26() {
        return new StringResource("string:charge_global_string_26", "charge_global_string_26", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3041L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1677L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 1981L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1513L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2077L, 91L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1301L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1301L, 75L)}));
    }

    public static final StringResource getCharge_global_string_28(Res.string $this$charge_global_string_28) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_28, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_28();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_28() {
        return new StringResource("string:charge_global_string_28", "charge_global_string_28", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3133L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 1761L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2069L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1597L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2169L, 75L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1377L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1377L, 63L)}));
    }

    public static final StringResource getCharge_global_string_3(Res.string $this$charge_global_string_3) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_3, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_3() {
        return new StringResource("string:charge_global_string_3", "charge_global_string_3", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4300L, 86L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2640L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3044L, 78L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2516L, 90L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3164L, 82L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2184L, 78L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2188L, 78L)}));
    }

    public static final StringResource getCharge_global_string_30(Res.string $this$charge_global_string_30) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_30, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_30();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_30() {
        return new StringResource("string:charge_global_string_30", "charge_global_string_30", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3480L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2008L, 43L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2360L, 39L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1792L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2452L, 43L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1576L, 39L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1576L, 39L)}));
    }

    public static final StringResource getCharge_global_string_31(Res.string $this$charge_global_string_31) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_31, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_31();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_31() {
        return new StringResource("string:charge_global_string_31", "charge_global_string_31", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3532L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2052L, 43L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2400L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1840L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2496L, 43L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1616L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1616L, 47L)}));
    }

    public static final StringResource getCharge_global_string_32(Res.string $this$charge_global_string_32) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_32, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_32();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_32() {
        return new StringResource("string:charge_global_string_32", "charge_global_string_32", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3580L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2096L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2448L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1900L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2540L, 55L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1664L, 55L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1664L, 55L)}));
    }

    public static final StringResource getCharge_global_string_33(Res.string $this$charge_global_string_33) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_33, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_33();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_33() {
        return new StringResource("string:charge_global_string_33", "charge_global_string_33", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3660L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2152L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2504L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 1956L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2596L, 63L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1720L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1720L, 47L)}));
    }

    public static final StringResource getCharge_global_string_34(Res.string $this$charge_global_string_34) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_34, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_34();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_34() {
        return new StringResource("string:charge_global_string_34", "charge_global_string_34", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3740L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2204L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2572L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2020L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2660L, 75L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1768L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1768L, 71L)}));
    }

    public static final StringResource getCharge_global_string_35(Res.string $this$charge_global_string_35) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_35, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_35();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_35() {
        return new StringResource("string:charge_global_string_35", "charge_global_string_35", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3828L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2272L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2644L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2092L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2736L, 55L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1840L, 47L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1840L, 47L)}));
    }

    public static final StringResource getCharge_global_string_36(Res.string $this$charge_global_string_36) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_36, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_36();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_36() {
        return new StringResource("string:charge_global_string_36", "charge_global_string_36", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3888L, 103L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2324L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2704L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2140L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2792L, 79L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1888L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1888L, 71L)}));
    }

    public static final StringResource getCharge_global_string_37(Res.string $this$charge_global_string_37) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_37, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_37();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_37() {
        return new StringResource("string:charge_global_string_37", "charge_global_string_37", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 3992L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2404L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2784L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2212L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2872L, 95L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 1960L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 1960L, 71L)}));
    }

    public static final StringResource getCharge_global_string_38(Res.string $this$charge_global_string_38) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_38, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_38();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_38() {
        return new StringResource("string:charge_global_string_38", "charge_global_string_38", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4084L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2476L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2872L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2292L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 2968L, 75L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2028L, 55L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2032L, 55L)}));
    }

    public static final StringResource getCharge_global_string_39(Res.string $this$charge_global_string_39) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_39, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_39();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_39() {
        return new StringResource("string:charge_global_string_39", "charge_global_string_39", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4160L, 139L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2532L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 2936L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2360L, 155L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3044L, 119L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2084L, 99L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2088L, 99L)}));
    }

    public static final StringResource getCharge_global_string_4(Res.string $this$charge_global_string_4) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_4, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_4() {
        return new StringResource("string:charge_global_string_4", "charge_global_string_4", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5071L, 62L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3147L, 54L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3643L, 46L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3039L, 62L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3759L, 46L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2667L, 46L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2671L, 46L)}));
    }

    public static final StringResource getCharge_global_string_41(Res.string $this$charge_global_string_41) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_41, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_41();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_41() {
        return new StringResource("string:charge_global_string_41", "charge_global_string_41", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4387L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2715L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3123L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2607L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3247L, 51L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2263L, 51L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2267L, 51L)}));
    }

    public static final StringResource getCharge_global_string_43(Res.string $this$charge_global_string_43) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_43, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_43();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_43() {
        return new StringResource("string:charge_global_string_43", "charge_global_string_43", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4451L, 187L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2771L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3175L, 135L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2655L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3299L, 131L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2315L, 99L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2319L, 99L)}));
    }

    public static final StringResource getCharge_global_string_44(Res.string $this$charge_global_string_44) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_44, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_44();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_44() {
        return new StringResource("string:charge_global_string_44", "charge_global_string_44", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4639L, 111L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2843L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3311L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2747L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3431L, 91L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2415L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2419L, 67L)}));
    }

    public static final StringResource getCharge_global_string_45(Res.string $this$charge_global_string_45) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_45, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_45();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_45() {
        return new StringResource("string:charge_global_string_45", "charge_global_string_45", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4751L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 2923L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3391L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2823L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3523L, 75L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2483L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2487L, 63L)}));
    }

    public static final StringResource getCharge_global_string_46(Res.string $this$charge_global_string_46) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_46, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_46();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_46() {
        return new StringResource("string:charge_global_string_46", "charge_global_string_46", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 4883L, 135L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3011L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3491L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2915L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3599L, 111L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2547L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2551L, 75L)}));
    }

    public static final StringResource getCharge_global_string_48(Res.string $this$charge_global_string_48) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_48, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_48();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_48() {
        return new StringResource("string:charge_global_string_48", "charge_global_string_48", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5019L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3107L, 39L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3591L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 2991L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3711L, 47L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2623L, 43L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2627L, 43L)}));
    }

    public static final StringResource getCharge_global_string_5(Res.string $this$charge_global_string_5) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_5, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_5() {
        return new StringResource("string:charge_global_string_5", "charge_global_string_5", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5230L, 130L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3254L, 90L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3778L, 86L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3178L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3898L, 86L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2790L, 90L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2790L, 82L)}));
    }

    public static final StringResource getCharge_global_string_57(Res.string $this$charge_global_string_57) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_57, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_57();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_57() {
        return new StringResource("string:charge_global_string_57", "charge_global_string_57", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5134L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3202L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3690L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3102L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3806L, 91L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2714L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2718L, 71L)}));
    }

    public static final StringResource getCharge_global_string_6(Res.string $this$charge_global_string_6) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_6, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_6() {
        return new StringResource("string:charge_global_string_6", "charge_global_string_6", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5361L, 66L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3345L, 46L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3865L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3253L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 3985L, 50L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2881L, 46L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2873L, 46L)}));
    }

    public static final StringResource getCharge_global_string_7(Res.string $this$charge_global_string_7) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_7, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_7() {
        return new StringResource("string:charge_global_string_7", "charge_global_string_7", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5428L, 134L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3392L, 98L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 3916L, 102L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3304L, 86L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 4036L, 110L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 2928L, 86L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 2920L, 86L)}));
    }

    public static final StringResource getCharge_global_string_8(Res.string $this$charge_global_string_8) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_8, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_8() {
        return new StringResource("string:charge_global_string_8", "charge_global_string_8", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5563L, 94L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3491L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 4019L, 90L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3391L, 54L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 4147L, 86L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 3015L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 3007L, 58L)}));
    }

    public static final StringResource getCharge_global_string_9(Res.string $this$charge_global_string_9) {
        Intrinsics.checkNotNullParameter($this$charge_global_string_9, "<this>");
        return CommonMainString0.INSTANCE.getCharge_global_string_9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_charge_global_string_9() {
        return new StringResource("string:charge_global_string_9", "charge_global_string_9", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.charge/values-ar/strings.commonMain.cvr", 5658L, 94L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.charge/values-en/strings.commonMain.cvr", 3566L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.charge/values-es/strings.commonMain.cvr", 4110L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.charge/values-ja/strings.commonMain.cvr", 3446L, 54L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.charge/values-pt/strings.commonMain.cvr", 4234L, 94L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.charge/values-zh-rHK/strings.commonMain.cvr", 3074L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.charge/values/strings.commonMain.cvr", 3066L, 58L)}));
    }
}