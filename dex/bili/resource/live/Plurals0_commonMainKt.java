package bili.resource.live;

import bili.resource.live.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bX\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\u001a\b\u0010S\u001a\u00020\u0001H\u0002\u001a\b\u0010V\u001a\u00020\u0001H\u0002\u001a\b\u0010Y\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010\u0004\"\u0015\u0010T\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0004\"\u0015\u0010W\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u0004¨\u0006Z"}, d2 = {"live_global_string_2413", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lbili/resource/live/Res$plurals;", "getLive_global_string_2413", "(Lbili/resource/live/Res$plurals;)Lorg/jetbrains/compose/resources/PluralStringResource;", "init_live_global_string_2413", "live_global_string_2414", "getLive_global_string_2414", "init_live_global_string_2414", "live_global_string_2415", "getLive_global_string_2415", "init_live_global_string_2415", "live_global_string_2416", "getLive_global_string_2416", "init_live_global_string_2416", "live_global_string_2417", "getLive_global_string_2417", "init_live_global_string_2417", "live_global_string_2419", "getLive_global_string_2419", "init_live_global_string_2419", "live_global_string_2420", "getLive_global_string_2420", "init_live_global_string_2420", "live_global_string_2421", "getLive_global_string_2421", "init_live_global_string_2421", "live_global_string_2422", "getLive_global_string_2422", "init_live_global_string_2422", "live_global_string_2423", "getLive_global_string_2423", "init_live_global_string_2423", "live_global_string_2425", "getLive_global_string_2425", "init_live_global_string_2425", "live_global_string_2426", "getLive_global_string_2426", "init_live_global_string_2426", "live_global_string_2427", "getLive_global_string_2427", "init_live_global_string_2427", "live_global_string_2428", "getLive_global_string_2428", "init_live_global_string_2428", "live_global_string_2430", "getLive_global_string_2430", "init_live_global_string_2430", "live_global_string_2432", "getLive_global_string_2432", "init_live_global_string_2432", "live_global_string_2433", "getLive_global_string_2433", "init_live_global_string_2433", "live_global_string_2434", "getLive_global_string_2434", "init_live_global_string_2434", "live_global_string_2436", "getLive_global_string_2436", "init_live_global_string_2436", "live_global_string_2437", "getLive_global_string_2437", "init_live_global_string_2437", "live_global_string_2439", "getLive_global_string_2439", "init_live_global_string_2439", "live_global_string_2440", "getLive_global_string_2440", "init_live_global_string_2440", "live_global_string_2441", "getLive_global_string_2441", "init_live_global_string_2441", "live_global_string_2442", "getLive_global_string_2442", "init_live_global_string_2442", "live_global_string_2444", "getLive_global_string_2444", "init_live_global_string_2444", "live_global_string_2445", "getLive_global_string_2445", "init_live_global_string_2445", "live_global_string_2446", "getLive_global_string_2446", "init_live_global_string_2446", "live_global_string_2447", "getLive_global_string_2447", "init_live_global_string_2447", "live_global_string_2449", "getLive_global_string_2449", "init_live_global_string_2449", "live_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Plurals0_commonMainKt {
    public static final PluralStringResource getLive_global_string_2413(Res.plurals $this$live_global_string_2413) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2413, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2413();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2413() {
        return new PluralStringResource("plurals:live_global_string_2413", "live_global_string_2413", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 10L, 213L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 10L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 10L, 141L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 10L, 62L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 10L, 141L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 10L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 10L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2414(Res.plurals $this$live_global_string_2414) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2414, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2414();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2414() {
        return new PluralStringResource("plurals:live_global_string_2414", "live_global_string_2414", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 224L, 197L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 102L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 152L, 93L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 73L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 152L, 85L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 69L, 50L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 69L, 50L)}));
    }

    public static final PluralStringResource getLive_global_string_2415(Res.plurals $this$live_global_string_2415) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2415, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2415();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2415() {
        return new PluralStringResource("plurals:live_global_string_2415", "live_global_string_2415", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 422L, 341L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 170L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 246L, 165L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 124L, 82L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 238L, 165L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 120L, 70L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 120L, 70L)}));
    }

    public static final PluralStringResource getLive_global_string_2416(Res.plurals $this$live_global_string_2416) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2416, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2416();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2416() {
        return new PluralStringResource("plurals:live_global_string_2416", "live_global_string_2416", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 764L, 389L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 278L, 123L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 412L, 177L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 207L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 404L, 165L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 191L, 66L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 191L, 66L)}));
    }

    public static final PluralStringResource getLive_global_string_2417(Res.plurals $this$live_global_string_2417) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2417, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2417();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2417() {
        return new PluralStringResource("plurals:live_global_string_2417", "live_global_string_2417", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 1154L, 341L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 402L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 590L, 157L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 282L, 82L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 570L, 157L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 258L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 258L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2419(Res.plurals $this$live_global_string_2419) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2419, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2419();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2419() {
        return new PluralStringResource("plurals:live_global_string_2419", "live_global_string_2419", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 1496L, 497L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 510L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 748L, 177L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 365L, 82L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 728L, 169L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 317L, 66L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 317L, 66L)}));
    }

    public static final PluralStringResource getLive_global_string_2420(Res.plurals $this$live_global_string_2420) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2420, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2420();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2420() {
        return new PluralStringResource("plurals:live_global_string_2420", "live_global_string_2420", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 1994L, 473L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 626L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 926L, 169L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 448L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 898L, 165L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 384L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 384L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2421(Res.plurals $this$live_global_string_2421) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2421, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2421();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2421() {
        return new PluralStringResource("plurals:live_global_string_2421", "live_global_string_2421", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 2468L, 161L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 726L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1096L, 85L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 519L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1064L, 85L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 443L, 50L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 443L, 50L)}));
    }

    public static final PluralStringResource getLive_global_string_2422(Res.plurals $this$live_global_string_2422) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2422, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2422();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2422() {
        return new PluralStringResource("plurals:live_global_string_2422", "live_global_string_2422", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 2630L, 681L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 794L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1182L, 241L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 570L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1150L, 265L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 494L, 70L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 494L, 70L)}));
    }

    public static final PluralStringResource getLive_global_string_2423(Res.plurals $this$live_global_string_2423) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2423, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2423();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2423() {
        return new PluralStringResource("plurals:live_global_string_2423", "live_global_string_2423", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 3312L, 201L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 926L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1424L, 105L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 645L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1416L, 97L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 565L, 50L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 565L, 50L)}));
    }

    public static final PluralStringResource getLive_global_string_2425(Res.plurals $this$live_global_string_2425) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2425, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2425();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2425() {
        return new PluralStringResource("plurals:live_global_string_2425", "live_global_string_2425", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 3514L, 413L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1002L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1530L, 157L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 696L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1514L, 181L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 616L, 62L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 616L, 62L)}));
    }

    public static final PluralStringResource getLive_global_string_2426(Res.plurals $this$live_global_string_2426) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2426, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2426();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2426() {
        return new PluralStringResource("plurals:live_global_string_2426", "live_global_string_2426", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 3928L, 541L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1110L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1688L, 237L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 767L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1696L, 213L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 679L, 70L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 679L, 70L)}));
    }

    public static final PluralStringResource getLive_global_string_2427(Res.plurals $this$live_global_string_2427) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2427, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2427();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2427() {
        return new PluralStringResource("plurals:live_global_string_2427", "live_global_string_2427", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 4470L, 589L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1226L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 1926L, 177L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 838L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 1910L, 169L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 750L, 78L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 750L, 78L)}));
    }

    public static final PluralStringResource getLive_global_string_2428(Res.plurals $this$live_global_string_2428) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2428, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2428();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2428() {
        return new PluralStringResource("plurals:live_global_string_2428", "live_global_string_2428", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 5060L, 457L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1358L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2104L, 141L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 945L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2080L, 145L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 829L, 66L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 829L, 66L)}));
    }

    public static final PluralStringResource getLive_global_string_2430(Res.plurals $this$live_global_string_2430) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2430, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2430();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2430() {
        return new PluralStringResource("plurals:live_global_string_2430", "live_global_string_2430", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 5518L, 385L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1458L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2246L, 177L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1020L, 74L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2226L, 169L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 896L, 66L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 896L, 66L)}));
    }

    public static final PluralStringResource getLive_global_string_2432(Res.plurals $this$live_global_string_2432) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2432, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2432();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2432() {
        return new PluralStringResource("plurals:live_global_string_2432", "live_global_string_2432", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 5904L, 233L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1566L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2424L, 117L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1095L, 58L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2396L, 117L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 963L, 54L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 963L, 54L)}));
    }

    public static final PluralStringResource getLive_global_string_2433(Res.plurals $this$live_global_string_2433) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2433, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2433();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2433() {
        return new PluralStringResource("plurals:live_global_string_2433", "live_global_string_2433", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 6138L, 281L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1650L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2542L, 109L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1154L, 66L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2514L, 109L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1018L, 54L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1018L, 54L)}));
    }

    public static final PluralStringResource getLive_global_string_2434(Res.plurals $this$live_global_string_2434) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2434, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2434();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2434() {
        return new PluralStringResource("plurals:live_global_string_2434", "live_global_string_2434", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 6420L, 293L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1726L, 99L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2652L, 169L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1221L, 58L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2624L, 157L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1073L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1073L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2436(Res.plurals $this$live_global_string_2436) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2436, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2436();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2436() {
        return new PluralStringResource("plurals:live_global_string_2436", "live_global_string_2436", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 6714L, 401L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1826L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2822L, 157L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1280L, 66L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2782L, 157L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1132L, 62L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1132L, 62L)}));
    }

    public static final PluralStringResource getLive_global_string_2437(Res.plurals $this$live_global_string_2437) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2437, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2437();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2437() {
        return new PluralStringResource("plurals:live_global_string_2437", "live_global_string_2437", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 7116L, 277L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 1934L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 2980L, 117L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1347L, 58L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 2940L, 141L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1195L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1195L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2439(Res.plurals $this$live_global_string_2439) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2439, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2439();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2439() {
        return new PluralStringResource("plurals:live_global_string_2439", "live_global_string_2439", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 7394L, 269L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2026L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3098L, 193L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1406L, 70L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3082L, 157L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1254L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1254L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2440(Res.plurals $this$live_global_string_2440) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2440, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2440();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2440() {
        return new PluralStringResource("plurals:live_global_string_2440", "live_global_string_2440", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 7664L, 561L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2142L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3292L, 213L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1477L, 78L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3240L, 213L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1313L, 70L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1313L, 70L)}));
    }

    public static final PluralStringResource getLive_global_string_2441(Res.plurals $this$live_global_string_2441) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2441, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2441();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2441() {
        return new PluralStringResource("plurals:live_global_string_2441", "live_global_string_2441", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 8226L, 285L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2258L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3506L, 121L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1556L, 58L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3454L, 121L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1384L, 58L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1384L, 58L)}));
    }

    public static final PluralStringResource getLive_global_string_2442(Res.plurals $this$live_global_string_2442) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2442, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2442();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2442() {
        return new PluralStringResource("plurals:live_global_string_2442", "live_global_string_2442", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 8512L, 269L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2342L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3628L, 73L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1615L, 50L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3576L, 73L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1443L, 50L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1443L, 50L)}));
    }

    public static final PluralStringResource getLive_global_string_2444(Res.plurals $this$live_global_string_2444) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2444, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2444();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2444() {
        return new PluralStringResource("plurals:live_global_string_2444", "live_global_string_2444", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 8782L, 233L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2418L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3702L, 97L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1666L, 54L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3650L, 97L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1494L, 54L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1494L, 54L)}));
    }

    public static final PluralStringResource getLive_global_string_2445(Res.plurals $this$live_global_string_2445) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2445, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2445();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2445() {
        return new PluralStringResource("plurals:live_global_string_2445", "live_global_string_2445", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 9016L, 629L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2494L, 131L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 3800L, 217L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1721L, 98L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3748L, 217L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1549L, 74L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1549L, 74L)}));
    }

    public static final PluralStringResource getLive_global_string_2446(Res.plurals $this$live_global_string_2446) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2446, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2446();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2446() {
        return new PluralStringResource("plurals:live_global_string_2446", "live_global_string_2446", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 9646L, 373L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2626L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 4018L, 157L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1820L, 98L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 3966L, 165L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1624L, 70L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1624L, 70L)}));
    }

    public static final PluralStringResource getLive_global_string_2447(Res.plurals $this$live_global_string_2447) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2447, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2447();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2447() {
        return new PluralStringResource("plurals:live_global_string_2447", "live_global_string_2447", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 10020L, 269L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2742L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 4176L, 117L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1919L, 66L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 4132L, 109L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1695L, 54L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1695L, 54L)}));
    }

    public static final PluralStringResource getLive_global_string_2449(Res.plurals $this$live_global_string_2449) {
        Intrinsics.checkNotNullParameter($this$live_global_string_2449, "<this>");
        return CommonMainPlurals0.INSTANCE.getLive_global_string_2449();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_live_global_string_2449() {
        return new PluralStringResource("plurals:live_global_string_2449", "live_global_string_2449", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.live/values-ar/strings.commonMain.cvr", 10290L, 277L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.live/values-en/strings.commonMain.cvr", 2826L, 119L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.live/values-es/strings.commonMain.cvr", 4294L, 157L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.live/values-ja/strings.commonMain.cvr", 1986L, 66L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.live/values-pt/strings.commonMain.cvr", 4242L, 157L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.live/values-zh-rHK/strings.commonMain.cvr", 1750L, 66L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.live/values/strings.commonMain.cvr", 1750L, 66L)}));
    }
}