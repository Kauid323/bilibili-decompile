package bili.resource.history;

import bili.resource.history.Res;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bv\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\u001a\b\u0010S\u001a\u00020\u0001H\u0002\u001a\b\u0010V\u001a\u00020\u0001H\u0002\u001a\b\u0010Y\u001a\u00020\u0001H\u0002\u001a\b\u0010\\\u001a\u00020\u0001H\u0002\u001a\b\u0010_\u001a\u00020\u0001H\u0002\u001a\b\u0010b\u001a\u00020\u0001H\u0002\u001a\b\u0010e\u001a\u00020\u0001H\u0002\u001a\b\u0010h\u001a\u00020\u0001H\u0002\u001a\b\u0010k\u001a\u00020\u0001H\u0002\u001a\b\u0010n\u001a\u00020\u0001H\u0002\u001a\b\u0010q\u001a\u00020\u0001H\u0002\u001a\b\u0010t\u001a\u00020\u0001H\u0002\u001a\b\u0010w\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010\u0004\"\u0015\u0010T\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0004\"\u0015\u0010W\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u0004\"\u0015\u0010Z\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\u0004\"\u0015\u0010]\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010\u0004\"\u0015\u0010`\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\ba\u0010\u0004\"\u0015\u0010c\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bd\u0010\u0004\"\u0015\u0010f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bg\u0010\u0004\"\u0015\u0010i\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bj\u0010\u0004\"\u0015\u0010l\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bm\u0010\u0004\"\u0015\u0010o\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bp\u0010\u0004\"\u0015\u0010r\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bs\u0010\u0004\"\u0015\u0010u\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bv\u0010\u0004¨\u0006x"}, d2 = {"history_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "Lbili/resource/history/Res$string;", "getHistory_global_string_1", "(Lbili/resource/history/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_history_global_string_1", "history_global_string_10", "getHistory_global_string_10", "init_history_global_string_10", "history_global_string_11", "getHistory_global_string_11", "init_history_global_string_11", "history_global_string_13", "getHistory_global_string_13", "init_history_global_string_13", "history_global_string_14", "getHistory_global_string_14", "init_history_global_string_14", "history_global_string_17", "getHistory_global_string_17", "init_history_global_string_17", "history_global_string_18", "getHistory_global_string_18", "init_history_global_string_18", "history_global_string_19", "getHistory_global_string_19", "init_history_global_string_19", "history_global_string_2", "getHistory_global_string_2", "init_history_global_string_2", "history_global_string_20", "getHistory_global_string_20", "init_history_global_string_20", "history_global_string_21", "getHistory_global_string_21", "init_history_global_string_21", "history_global_string_22", "getHistory_global_string_22", "init_history_global_string_22", "history_global_string_23", "getHistory_global_string_23", "init_history_global_string_23", "history_global_string_24", "getHistory_global_string_24", "init_history_global_string_24", "history_global_string_25", "getHistory_global_string_25", "init_history_global_string_25", "history_global_string_26", "getHistory_global_string_26", "init_history_global_string_26", "history_global_string_27", "getHistory_global_string_27", "init_history_global_string_27", "history_global_string_28", "getHistory_global_string_28", "init_history_global_string_28", "history_global_string_3", "getHistory_global_string_3", "init_history_global_string_3", "history_global_string_32", "getHistory_global_string_32", "init_history_global_string_32", "history_global_string_34", "getHistory_global_string_34", "init_history_global_string_34", "history_global_string_35", "getHistory_global_string_35", "init_history_global_string_35", "history_global_string_37", "getHistory_global_string_37", "init_history_global_string_37", "history_global_string_39", "getHistory_global_string_39", "init_history_global_string_39", "history_global_string_4", "getHistory_global_string_4", "init_history_global_string_4", "history_global_string_40", "getHistory_global_string_40", "init_history_global_string_40", "history_global_string_41", "getHistory_global_string_41", "init_history_global_string_41", "history_global_string_42", "getHistory_global_string_42", "init_history_global_string_42", "history_global_string_43", "getHistory_global_string_43", "init_history_global_string_43", "history_global_string_44", "getHistory_global_string_44", "init_history_global_string_44", "history_global_string_45", "getHistory_global_string_45", "init_history_global_string_45", "history_global_string_46", "getHistory_global_string_46", "init_history_global_string_46", "history_global_string_47", "getHistory_global_string_47", "init_history_global_string_47", "history_global_string_48", "getHistory_global_string_48", "init_history_global_string_48", "history_global_string_5", "getHistory_global_string_5", "init_history_global_string_5", "history_global_string_6", "getHistory_global_string_6", "init_history_global_string_6", "history_global_string_7", "getHistory_global_string_7", "init_history_global_string_7", "history_global_string_8", "getHistory_global_string_8", "init_history_global_string_8", "history_global_string_9", "getHistory_global_string_9", "init_history_global_string_9", "history_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class String0_commonMainKt {
    public static final StringResource getHistory_global_string_1(Res.string $this$history_global_string_1) {
        Intrinsics.checkNotNullParameter($this$history_global_string_1, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_1() {
        return new StringResource("string:history_global_string_1", "history_global_string_1", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 749L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 465L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 541L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 525L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 541L, 71L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 457L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 457L, 79L)}));
    }

    public static final StringResource getHistory_global_string_10(Res.string $this$history_global_string_10) {
        Intrinsics.checkNotNullParameter($this$history_global_string_10, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_10();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_10() {
        return new StringResource("string:history_global_string_10", "history_global_string_10", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 10L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 10L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 10L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 10L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 10L, 56L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 10L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 10L, 48L)}));
    }

    public static final StringResource getHistory_global_string_11(Res.string $this$history_global_string_11) {
        Intrinsics.checkNotNullParameter($this$history_global_string_11, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_11();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_11() {
        return new StringResource("string:history_global_string_11", "history_global_string_11", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 83L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 63L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 71L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 71L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 67L, 64L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 59L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 59L, 56L)}));
    }

    public static final StringResource getHistory_global_string_13(Res.string $this$history_global_string_13) {
        Intrinsics.checkNotNullParameter($this$history_global_string_13, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_13();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_13() {
        return new StringResource("string:history_global_string_13", "history_global_string_13", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 172L, 184L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 128L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 136L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 140L, 120L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 132L, 132L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 116L, 100L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 116L, 100L)}));
    }

    public static final StringResource getHistory_global_string_14(Res.string $this$history_global_string_14) {
        Intrinsics.checkNotNullParameter($this$history_global_string_14, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_14();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_14() {
        return new StringResource("string:history_global_string_14", "history_global_string_14", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 357L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 213L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 269L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 261L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 265L, 60L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 217L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 217L, 56L)}));
    }

    public static final StringResource getHistory_global_string_17(Res.string $this$history_global_string_17) {
        Intrinsics.checkNotNullParameter($this$history_global_string_17, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_17();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_17() {
        return new StringResource("string:history_global_string_17", "history_global_string_17", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 454L, 148L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 266L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 330L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 334L, 100L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 326L, 104L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 274L, 84L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 274L, 84L)}));
    }

    public static final StringResource getHistory_global_string_18(Res.string $this$history_global_string_18) {
        Intrinsics.checkNotNullParameter($this$history_global_string_18, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_18();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_18() {
        return new StringResource("string:history_global_string_18", "history_global_string_18", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 603L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 363L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 439L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 435L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 431L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 359L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 359L, 48L)}));
    }

    public static final StringResource getHistory_global_string_19(Res.string $this$history_global_string_19) {
        Intrinsics.checkNotNullParameter($this$history_global_string_19, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_19();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_19() {
        return new StringResource("string:history_global_string_19", "history_global_string_19", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 672L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 408L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 484L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 476L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 480L, 60L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 408L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 408L, 48L)}));
    }

    public static final StringResource getHistory_global_string_2(Res.string $this$history_global_string_2) {
        Intrinsics.checkNotNullParameter($this$history_global_string_2, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_2() {
        return new StringResource("string:history_global_string_2", "history_global_string_2", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1522L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1034L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1206L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1222L, 123L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1150L, 79L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1018L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1018L, 83L)}));
    }

    public static final StringResource getHistory_global_string_20(Res.string $this$history_global_string_20) {
        Intrinsics.checkNotNullParameter($this$history_global_string_20, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_20();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_20() {
        return new StringResource("string:history_global_string_20", "history_global_string_20", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 865L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 529L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 621L, 36L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 613L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 613L, 40L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 537L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 537L, 40L)}));
    }

    public static final StringResource getHistory_global_string_21(Res.string $this$history_global_string_21) {
        Intrinsics.checkNotNullParameter($this$history_global_string_21, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_21();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_21() {
        return new StringResource("string:history_global_string_21", "history_global_string_21", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 918L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 570L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 658L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 654L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 654L, 40L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 578L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 578L, 40L)}));
    }

    public static final StringResource getHistory_global_string_22(Res.string $this$history_global_string_22) {
        Intrinsics.checkNotNullParameter($this$history_global_string_22, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_22();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_22() {
        return new StringResource("string:history_global_string_22", "history_global_string_22", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 963L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 615L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 699L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 695L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 695L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 619L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 619L, 40L)}));
    }

    public static final StringResource getHistory_global_string_23(Res.string $this$history_global_string_23) {
        Intrinsics.checkNotNullParameter($this$history_global_string_23, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_23();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_23() {
        return new StringResource("string:history_global_string_23", "history_global_string_23", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1012L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 660L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 752L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 744L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 744L, 72L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 660L, 56L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 660L, 56L)}));
    }

    public static final StringResource getHistory_global_string_24(Res.string $this$history_global_string_24) {
        Intrinsics.checkNotNullParameter($this$history_global_string_24, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_24();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_24() {
        return new StringResource("string:history_global_string_24", "history_global_string_24", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1081L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 721L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 825L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 805L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 817L, 44L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 717L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 717L, 40L)}));
    }

    public static final StringResource getHistory_global_string_25(Res.string $this$history_global_string_25) {
        Intrinsics.checkNotNullParameter($this$history_global_string_25, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_25();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_25() {
        return new StringResource("string:history_global_string_25", "history_global_string_25", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1126L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 762L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 866L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 846L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 862L, 40L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 758L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 758L, 40L)}));
    }

    public static final StringResource getHistory_global_string_26(Res.string $this$history_global_string_26) {
        Intrinsics.checkNotNullParameter($this$history_global_string_26, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_26();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_26() {
        return new StringResource("string:history_global_string_26", "history_global_string_26", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1195L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 803L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 907L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 899L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 903L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 799L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 799L, 48L)}));
    }

    public static final StringResource getHistory_global_string_27(Res.string $this$history_global_string_27) {
        Intrinsics.checkNotNullParameter($this$history_global_string_27, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_27();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_27() {
        return new StringResource("string:history_global_string_27", "history_global_string_27", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1276L, 100L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 852L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 968L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 948L, 128L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 952L, 80L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 848L, 76L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 848L, 76L)}));
    }

    public static final StringResource getHistory_global_string_28(Res.string $this$history_global_string_28) {
        Intrinsics.checkNotNullParameter($this$history_global_string_28, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_28();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_28() {
        return new StringResource("string:history_global_string_28", "history_global_string_28", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1377L, 144L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 945L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1053L, 152L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1077L, 144L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1033L, 116L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 925L, 92L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 925L, 92L)}));
    }

    public static final StringResource getHistory_global_string_3(Res.string $this$history_global_string_3) {
        Intrinsics.checkNotNullParameter($this$history_global_string_3, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_3() {
        return new StringResource("string:history_global_string_3", "history_global_string_3", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2067L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1375L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1611L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1675L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1559L, 79L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1363L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1363L, 63L)}));
    }

    public static final StringResource getHistory_global_string_32(Res.string $this$history_global_string_32) {
        Intrinsics.checkNotNullParameter($this$history_global_string_32, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_32();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_32() {
        return new StringResource("string:history_global_string_32", "history_global_string_32", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1638L, 68L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1102L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1290L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1346L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1230L, 44L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1102L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1102L, 40L)}));
    }

    public static final StringResource getHistory_global_string_34(Res.string $this$history_global_string_34) {
        Intrinsics.checkNotNullParameter($this$history_global_string_34, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_34();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_34() {
        return new StringResource("string:history_global_string_34", "history_global_string_34", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1707L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1143L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1335L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1391L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1275L, 52L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1143L, 44L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1143L, 44L)}));
    }

    public static final StringResource getHistory_global_string_35(Res.string $this$history_global_string_35) {
        Intrinsics.checkNotNullParameter($this$history_global_string_35, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_35();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_35() {
        return new StringResource("string:history_global_string_35", "history_global_string_35", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1772L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1188L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1380L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1440L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1328L, 40L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1188L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1188L, 40L)}));
    }

    public static final StringResource getHistory_global_string_37(Res.string $this$history_global_string_37) {
        Intrinsics.checkNotNullParameter($this$history_global_string_37, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_37();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_37() {
        return new StringResource("string:history_global_string_37", "history_global_string_37", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 1821L, 188L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1233L, 100L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1421L, 148L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1489L, 140L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1369L, 140L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1229L, 92L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1229L, 92L)}));
    }

    public static final StringResource getHistory_global_string_39(Res.string $this$history_global_string_39) {
        Intrinsics.checkNotNullParameter($this$history_global_string_39, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_39();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_39() {
        return new StringResource("string:history_global_string_39", "history_global_string_39", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2010L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1334L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1570L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1630L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1510L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1322L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1322L, 40L)}));
    }

    public static final StringResource getHistory_global_string_4(Res.string $this$history_global_string_4) {
        Intrinsics.checkNotNullParameter($this$history_global_string_4, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_4() {
        return new StringResource("string:history_global_string_4", "history_global_string_4", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2956L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2032L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2320L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2420L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2248L, 79L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2004L, 55L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2004L, 55L)}));
    }

    public static final StringResource getHistory_global_string_40(Res.string $this$history_global_string_40) {
        Intrinsics.checkNotNullParameter($this$history_global_string_40, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_40();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_40() {
        return new StringResource("string:history_global_string_40", "history_global_string_40", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2163L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1439L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1695L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1743L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1639L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1427L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1427L, 48L)}));
    }

    public static final StringResource getHistory_global_string_41(Res.string $this$history_global_string_41) {
        Intrinsics.checkNotNullParameter($this$history_global_string_41, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_41();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_41() {
        return new StringResource("string:history_global_string_41", "history_global_string_41", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2224L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1488L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1740L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1792L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1688L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1476L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1476L, 48L)}));
    }

    public static final StringResource getHistory_global_string_42(Res.string $this$history_global_string_42) {
        Intrinsics.checkNotNullParameter($this$history_global_string_42, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_42();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_42() {
        return new StringResource("string:history_global_string_42", "history_global_string_42", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2277L, 104L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1541L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1789L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1841L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1737L, 88L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1525L, 72L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1525L, 72L)}));
    }

    public static final StringResource getHistory_global_string_43(Res.string $this$history_global_string_43) {
        Intrinsics.checkNotNullParameter($this$history_global_string_43, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_43();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_43() {
        return new StringResource("string:history_global_string_43", "history_global_string_43", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2382L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1622L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1866L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1926L, 56L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1826L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1598L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1598L, 48L)}));
    }

    public static final StringResource getHistory_global_string_44(Res.string $this$history_global_string_44) {
        Intrinsics.checkNotNullParameter($this$history_global_string_44, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_44();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_44() {
        return new StringResource("string:history_global_string_44", "history_global_string_44", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2455L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1683L, 60L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1927L, 64L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 1983L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1875L, 60L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1647L, 48L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1647L, 48L)}));
    }

    public static final StringResource getHistory_global_string_45(Res.string $this$history_global_string_45) {
        Intrinsics.checkNotNullParameter($this$history_global_string_45, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_45();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_45() {
        return new StringResource("string:history_global_string_45", "history_global_string_45", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2552L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1744L, 72L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 1992L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2060L, 116L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 1936L, 88L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1696L, 88L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1696L, 88L)}));
    }

    public static final StringResource getHistory_global_string_46(Res.string $this$history_global_string_46) {
        Intrinsics.checkNotNullParameter($this$history_global_string_46, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_46();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_46() {
        return new StringResource("string:history_global_string_46", "history_global_string_46", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2661L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1817L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2085L, 44L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2177L, 40L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2025L, 44L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1785L, 40L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1785L, 40L)}));
    }

    public static final StringResource getHistory_global_string_47(Res.string $this$history_global_string_47) {
        Intrinsics.checkNotNullParameter($this$history_global_string_47, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_47();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_47() {
        return new StringResource("string:history_global_string_47", "history_global_string_47", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2714L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1862L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2130L, 48L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2218L, 52L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2070L, 48L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1826L, 44L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1826L, 44L)}));
    }

    public static final StringResource getHistory_global_string_48(Res.string $this$history_global_string_48) {
        Intrinsics.checkNotNullParameter($this$history_global_string_48, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_48();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_48() {
        return new StringResource("string:history_global_string_48", "history_global_string_48", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 2791L, 164L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 1911L, 120L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2179L, 140L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2271L, 148L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2119L, 128L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 1871L, 132L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 1871L, 132L)}));
    }

    public static final StringResource getHistory_global_string_5(Res.string $this$history_global_string_5) {
        Intrinsics.checkNotNullParameter($this$history_global_string_5, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_5() {
        return new StringResource("string:history_global_string_5", "history_global_string_5", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 3032L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2096L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2400L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2468L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2328L, 91L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2060L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2060L, 79L)}));
    }

    public static final StringResource getHistory_global_string_6(Res.string $this$history_global_string_6) {
        Intrinsics.checkNotNullParameter($this$history_global_string_6, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_6() {
        return new StringResource("string:history_global_string_6", "history_global_string_6", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 3164L, 111L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2184L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2488L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2560L, 51L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2420L, 63L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2140L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2140L, 63L)}));
    }

    public static final StringResource getHistory_global_string_7(Res.string $this$history_global_string_7) {
        Intrinsics.checkNotNullParameter($this$history_global_string_7, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_7() {
        return new StringResource("string:history_global_string_7", "history_global_string_7", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 3276L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2240L, 55L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2552L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2612L, 47L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2484L, 71L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2204L, 55L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2204L, 55L)}));
    }

    public static final StringResource getHistory_global_string_8(Res.string $this$history_global_string_8) {
        Intrinsics.checkNotNullParameter($this$history_global_string_8, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_8() {
        return new StringResource("string:history_global_string_8", "history_global_string_8", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 3364L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2296L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2612L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2660L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2556L, 95L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2260L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2260L, 75L)}));
    }

    public static final StringResource getHistory_global_string_9(Res.string $this$history_global_string_9) {
        Intrinsics.checkNotNullParameter($this$history_global_string_9, "<this>");
        return CommonMainString0.INSTANCE.getHistory_global_string_9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_history_global_string_9() {
        return new StringResource("string:history_global_string_9", "history_global_string_9", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.history/values-ar/strings.commonMain.cvr", 3480L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.history/values-en/strings.commonMain.cvr", 2384L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.history/values-es/strings.commonMain.cvr", 2712L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.history/values-ja/strings.commonMain.cvr", 2744L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.history/values-pt/strings.commonMain.cvr", 2652L, 75L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.history/values-zh-rHK/strings.commonMain.cvr", 2336L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.history/values/strings.commonMain.cvr", 2336L, 67L)}));
    }
}