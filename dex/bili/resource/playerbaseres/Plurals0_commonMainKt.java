package bili.resource.playerbaseres;

import bili.resource.playerbaseres.Res;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b@\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004¨\u0006B"}, d2 = {"playerbaseres_global_string_2317", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lbili/resource/playerbaseres/Res$plurals;", "getPlayerbaseres_global_string_2317", "(Lbili/resource/playerbaseres/Res$plurals;)Lorg/jetbrains/compose/resources/PluralStringResource;", "init_playerbaseres_global_string_2317", "playerbaseres_global_string_2319", "getPlayerbaseres_global_string_2319", "init_playerbaseres_global_string_2319", "playerbaseres_global_string_2320", "getPlayerbaseres_global_string_2320", "init_playerbaseres_global_string_2320", "playerbaseres_global_string_2321", "getPlayerbaseres_global_string_2321", "init_playerbaseres_global_string_2321", "playerbaseres_global_string_2329", "getPlayerbaseres_global_string_2329", "init_playerbaseres_global_string_2329", "playerbaseres_global_string_2331", "getPlayerbaseres_global_string_2331", "init_playerbaseres_global_string_2331", "playerbaseres_global_string_2339", "getPlayerbaseres_global_string_2339", "init_playerbaseres_global_string_2339", "playerbaseres_global_string_2343", "getPlayerbaseres_global_string_2343", "init_playerbaseres_global_string_2343", "playerbaseres_global_string_2345", "getPlayerbaseres_global_string_2345", "init_playerbaseres_global_string_2345", "playerbaseres_global_string_2348", "getPlayerbaseres_global_string_2348", "init_playerbaseres_global_string_2348", "playerbaseres_global_string_2350", "getPlayerbaseres_global_string_2350", "init_playerbaseres_global_string_2350", "playerbaseres_global_string_2351", "getPlayerbaseres_global_string_2351", "init_playerbaseres_global_string_2351", "playerbaseres_global_string_2352", "getPlayerbaseres_global_string_2352", "init_playerbaseres_global_string_2352", "playerbaseres_global_string_2355", "getPlayerbaseres_global_string_2355", "init_playerbaseres_global_string_2355", "playerbaseres_global_string_2358", "getPlayerbaseres_global_string_2358", "init_playerbaseres_global_string_2358", "playerbaseres_global_string_2362", "getPlayerbaseres_global_string_2362", "init_playerbaseres_global_string_2362", "playerbaseres_global_string_2368", "getPlayerbaseres_global_string_2368", "init_playerbaseres_global_string_2368", "playerbaseres_global_string_2370", "getPlayerbaseres_global_string_2370", "init_playerbaseres_global_string_2370", "playerbaseres_global_string_2372", "getPlayerbaseres_global_string_2372", "init_playerbaseres_global_string_2372", "playerbaseres_global_string_2374", "getPlayerbaseres_global_string_2374", "init_playerbaseres_global_string_2374", "playerbaseres_global_string_2392", "getPlayerbaseres_global_string_2392", "init_playerbaseres_global_string_2392", "playerbaseres_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Plurals0_commonMainKt {
    public static final PluralStringResource getPlayerbaseres_global_string_2317(Res.plurals $this$playerbaseres_global_string_2317) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2317, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2317();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2317() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2317", "playerbaseres_global_string_2317", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 10L, 750L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 10L, 156L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 10L, 254L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 10L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 10L, 238L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 10L, 91L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 10L, 91L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2319(Res.plurals $this$playerbaseres_global_string_2319) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2319, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2319();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2319() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2319", "playerbaseres_global_string_2319", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 761L, 242L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 167L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 265L, 130L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 118L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 249L, 106L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 102L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 102L, 63L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2320(Res.plurals $this$playerbaseres_global_string_2320) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2320, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2320();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2320() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2320", "playerbaseres_global_string_2320", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 1004L, 242L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 252L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 396L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 186L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 356L, 114L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 166L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 166L, 63L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2321(Res.plurals $this$playerbaseres_global_string_2321) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2321, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2321();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2321() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2321", "playerbaseres_global_string_2321", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 1247L, 690L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 333L, 140L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 515L, 286L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 262L, 95L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 471L, 282L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 230L, 95L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 230L, 95L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2329(Res.plurals $this$playerbaseres_global_string_2329) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2329, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2329();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2329() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2329", "playerbaseres_global_string_2329", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 1938L, 258L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 474L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 802L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 358L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 754L, 118L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 326L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 326L, 63L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2331(Res.plurals $this$playerbaseres_global_string_2331) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2331, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2331();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2331() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2331", "playerbaseres_global_string_2331", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 2197L, 346L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 559L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 921L, 142L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 422L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 873L, 142L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 390L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 390L, 71L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2339(Res.plurals $this$playerbaseres_global_string_2339) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2339, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2339();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2339() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2339", "playerbaseres_global_string_2339", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 2544L, 578L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 668L, 156L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1064L, 210L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 486L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1016L, 190L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 462L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 462L, 83L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2343(Res.plurals $this$playerbaseres_global_string_2343) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2343, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2343();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2343() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2343", "playerbaseres_global_string_2343", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 3123L, 550L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 825L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1275L, 222L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 574L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1207L, 210L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 546L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 546L, 83L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2345(Res.plurals $this$playerbaseres_global_string_2345) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2345, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2345();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2345() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2345", "playerbaseres_global_string_2345", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 3674L, 278L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 958L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1498L, 126L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 658L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1418L, 154L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 630L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 630L, 71L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2348(Res.plurals $this$playerbaseres_global_string_2348) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2348, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2348();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2348() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2348", "playerbaseres_global_string_2348", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 3953L, 254L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1051L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1625L, 94L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 730L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1573L, 94L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 702L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 702L, 67L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2350(Res.plurals $this$playerbaseres_global_string_2350) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2350, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2350();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2350() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2350", "playerbaseres_global_string_2350", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 4208L, 294L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1128L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1720L, 130L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 798L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1668L, 138L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 770L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 770L, 67L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2351(Res.plurals $this$playerbaseres_global_string_2351) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2351, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2351();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2351() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2351", "playerbaseres_global_string_2351", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 4503L, 546L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1225L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 1851L, 234L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 862L, 143L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 1807L, 258L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 838L, 103L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 838L, 99L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2352(Res.plurals $this$playerbaseres_global_string_2352) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2352, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2352();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2352() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2352", "playerbaseres_global_string_2352", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 5050L, 226L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1358L, 84L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2086L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1006L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2066L, 106L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 942L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 938L, 59L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2355(Res.plurals $this$playerbaseres_global_string_2355) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2355, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2355();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2355() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2355", "playerbaseres_global_string_2355", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 5277L, 510L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1443L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2193L, 210L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1066L, 79L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2173L, 190L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1002L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 998L, 83L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2358(Res.plurals $this$playerbaseres_global_string_2358) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2358, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2358();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2358() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2358", "playerbaseres_global_string_2358", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 5788L, 374L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1576L, 100L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2404L, 126L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1146L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2364L, 150L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1086L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1082L, 71L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2362(Res.plurals $this$playerbaseres_global_string_2362) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2362, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2362();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2362() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2362", "playerbaseres_global_string_2362", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 6163L, 342L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1677L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2531L, 126L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1222L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2515L, 166L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1158L, 71L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1154L, 71L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2368(Res.plurals $this$playerbaseres_global_string_2368) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2368, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2368();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2368() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2368", "playerbaseres_global_string_2368", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 6506L, 278L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1770L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2658L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1294L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2682L, 130L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1230L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1226L, 67L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2370(Res.plurals $this$playerbaseres_global_string_2370) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2370, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2370();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2370() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2370", "playerbaseres_global_string_2370", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 6785L, 254L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1863L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2777L, 114L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1362L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2813L, 114L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1298L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1294L, 63L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2372(Res.plurals $this$playerbaseres_global_string_2372) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2372, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2372();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2372() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2372", "playerbaseres_global_string_2372", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 7040L, 494L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 1952L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 2892L, 166L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1430L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 2928L, 166L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1362L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1358L, 79L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2374(Res.plurals $this$playerbaseres_global_string_2374) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2374, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2374();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2374() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2374", "playerbaseres_global_string_2374", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 7535L, 222L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 2061L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 3059L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1514L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 3095L, 154L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1442L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1438L, 63L)}));
    }

    public static final PluralStringResource getPlayerbaseres_global_string_2392(Res.plurals $this$playerbaseres_global_string_2392) {
        Intrinsics.checkNotNullParameter($this$playerbaseres_global_string_2392, "<this>");
        return CommonMainPlurals0.INSTANCE.getPlayerbaseres_global_string_2392();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_playerbaseres_global_string_2392() {
        return new PluralStringResource("plurals:playerbaseres_global_string_2392", "playerbaseres_global_string_2392", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.playerbaseres/values-ar/strings.commonMain.cvr", 7758L, 546L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.playerbaseres/values-en/strings.commonMain.cvr", 2150L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.playerbaseres/values-es/strings.commonMain.cvr", 3178L, 250L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.playerbaseres/values-ja/strings.commonMain.cvr", 1578L, 143L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.playerbaseres/values-pt/strings.commonMain.cvr", 3250L, 258L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.playerbaseres/values-zh-rHK/strings.commonMain.cvr", 1506L, 103L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.playerbaseres/values/strings.commonMain.cvr", 1502L, 103L)}));
    }
}