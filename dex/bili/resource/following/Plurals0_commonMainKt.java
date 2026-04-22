package bili.resource.following;

import bili.resource.following.Res;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bR\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\b\u0010 \u001a\u00020\u0001H\u0002\u001a\b\u0010#\u001a\u00020\u0001H\u0002\u001a\b\u0010&\u001a\u00020\u0001H\u0002\u001a\b\u0010)\u001a\u00020\u0001H\u0002\u001a\b\u0010,\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00102\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\u001a\b\u00108\u001a\u00020\u0001H\u0002\u001a\b\u0010;\u001a\u00020\u0001H\u0002\u001a\b\u0010>\u001a\u00020\u0001H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010D\u001a\u00020\u0001H\u0002\u001a\b\u0010G\u001a\u00020\u0001H\u0002\u001a\b\u0010J\u001a\u00020\u0001H\u0002\u001a\b\u0010M\u001a\u00020\u0001H\u0002\u001a\b\u0010P\u001a\u00020\u0001H\u0002\u001a\b\u0010S\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010$\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010*\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u00100\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00106\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u0010\u0004\"\u0015\u00109\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010\u0004\"\u0015\u0010<\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010\u0004\"\u0015\u0010?\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u0010\u0004\"\u0015\u0010B\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010\u0004\"\u0015\u0010E\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0004\"\u0015\u0010H\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0004\"\u0015\u0010K\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0004\"\u0015\u0010N\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010\u0004\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010\u0004¨\u0006T"}, d2 = {"following_global_string_1114", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lbili/resource/following/Res$plurals;", "getFollowing_global_string_1114", "(Lbili/resource/following/Res$plurals;)Lorg/jetbrains/compose/resources/PluralStringResource;", "init_following_global_string_1114", "following_global_string_1116", "getFollowing_global_string_1116", "init_following_global_string_1116", "following_global_string_1117", "getFollowing_global_string_1117", "init_following_global_string_1117", "following_global_string_1118", "getFollowing_global_string_1118", "init_following_global_string_1118", "following_global_string_1119", "getFollowing_global_string_1119", "init_following_global_string_1119", "following_global_string_1120", "getFollowing_global_string_1120", "init_following_global_string_1120", "following_global_string_1123", "getFollowing_global_string_1123", "init_following_global_string_1123", "following_global_string_1124", "getFollowing_global_string_1124", "init_following_global_string_1124", "following_global_string_1125", "getFollowing_global_string_1125", "init_following_global_string_1125", "following_global_string_1126", "getFollowing_global_string_1126", "init_following_global_string_1126", "following_global_string_1129", "getFollowing_global_string_1129", "init_following_global_string_1129", "following_global_string_1132", "getFollowing_global_string_1132", "init_following_global_string_1132", "following_global_string_1133", "getFollowing_global_string_1133", "init_following_global_string_1133", "following_global_string_1134", "getFollowing_global_string_1134", "init_following_global_string_1134", "following_global_string_1135", "getFollowing_global_string_1135", "init_following_global_string_1135", "following_global_string_1136", "getFollowing_global_string_1136", "init_following_global_string_1136", "following_global_string_1138", "getFollowing_global_string_1138", "init_following_global_string_1138", "following_global_string_1139", "getFollowing_global_string_1139", "init_following_global_string_1139", "following_global_string_1142", "getFollowing_global_string_1142", "init_following_global_string_1142", "following_global_string_1144", "getFollowing_global_string_1144", "init_following_global_string_1144", "following_global_string_1145", "getFollowing_global_string_1145", "init_following_global_string_1145", "following_global_string_1146", "getFollowing_global_string_1146", "init_following_global_string_1146", "following_global_string_1147", "getFollowing_global_string_1147", "init_following_global_string_1147", "following_global_string_1148", "getFollowing_global_string_1148", "init_following_global_string_1148", "following_global_string_1150", "getFollowing_global_string_1150", "init_following_global_string_1150", "following_global_string_1151", "getFollowing_global_string_1151", "init_following_global_string_1151", "following_global_string_1153", "getFollowing_global_string_1153", "init_following_global_string_1153", "following_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class Plurals0_commonMainKt {
    public static final PluralStringResource getFollowing_global_string_1114(Res.plurals $this$following_global_string_1114) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1114, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1114();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1114() {
        return new PluralStringResource("plurals:following_global_string_1114", "following_global_string_1114", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 10L, 238L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 10L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 10L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 10L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 10L, 102L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 10L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 10L, 59L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1116(Res.plurals $this$following_global_string_1116) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1116, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1116();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1116() {
        return new PluralStringResource("plurals:following_global_string_1116", "following_global_string_1116", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 249L, 418L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 91L, 104L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 117L, 166L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 70L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 113L, 170L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 70L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 70L, 79L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1117(Res.plurals $this$following_global_string_1117) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1117, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1117();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1117() {
        return new PluralStringResource("plurals:following_global_string_1117", "following_global_string_1117", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 668L, 746L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 196L, 140L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 284L, 270L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 162L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 284L, 294L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 150L, 99L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 150L, 99L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1118(Res.plurals $this$following_global_string_1118) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1118, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1118();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1118() {
        return new PluralStringResource("plurals:following_global_string_1118", "following_global_string_1118", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 1415L, 454L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 337L, 92L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 555L, 162L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 278L, 103L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 579L, 194L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 250L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 250L, 79L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1119(Res.plurals $this$following_global_string_1119) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1119, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1119();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1119() {
        return new PluralStringResource("plurals:following_global_string_1119", "following_global_string_1119", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 1870L, 506L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 430L, 156L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 718L, 246L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 382L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 774L, 254L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 330L, 91L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 330L, 91L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1120(Res.plurals $this$following_global_string_1120) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1120, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1120();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1120() {
        return new PluralStringResource("plurals:following_global_string_1120", "following_global_string_1120", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 2377L, 258L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 587L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 965L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 470L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1029L, 138L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 422L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 422L, 59L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1123(Res.plurals $this$following_global_string_1123) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1123, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1123();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1123() {
        return new PluralStringResource("plurals:following_global_string_1123", "following_global_string_1123", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 2636L, 290L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 664L, 104L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1072L, 178L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 534L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1168L, 158L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 482L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 482L, 63L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1124(Res.plurals $this$following_global_string_1124) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1124, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1124();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1124() {
        return new PluralStringResource("plurals:following_global_string_1124", "following_global_string_1124", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 2927L, 518L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 769L, 136L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1251L, 250L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 626L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1327L, 218L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 546L, 87L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 546L, 87L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1125(Res.plurals $this$following_global_string_1125) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1125, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1125();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1125() {
        return new PluralStringResource("plurals:following_global_string_1125", "following_global_string_1125", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 3446L, 230L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 906L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1502L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 718L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1546L, 102L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 634L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 634L, 63L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1126(Res.plurals $this$following_global_string_1126) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1126, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1126();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1126() {
        return new PluralStringResource("plurals:following_global_string_1126", "following_global_string_1126", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 3677L, 602L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 987L, 120L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1609L, 222L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 786L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1649L, 218L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 698L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 698L, 79L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1129(Res.plurals $this$following_global_string_1129) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1129, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1129();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1129() {
        return new PluralStringResource("plurals:following_global_string_1129", "following_global_string_1129", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 4280L, 238L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1108L, 88L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1832L, 118L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 874L, 71L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1868L, 114L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 778L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 778L, 59L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1132(Res.plurals $this$following_global_string_1132) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1132, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1132();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1132() {
        return new PluralStringResource("plurals:following_global_string_1132", "following_global_string_1132", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 4519L, 282L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1197L, 80L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 1951L, 106L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 946L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 1983L, 146L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 838L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 838L, 63L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1133(Res.plurals $this$following_global_string_1133) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1133, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1133();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1133() {
        return new PluralStringResource("plurals:following_global_string_1133", "following_global_string_1133", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 4802L, 322L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1278L, 104L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 2058L, 154L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1010L, 59L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2130L, 150L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 902L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 902L, 63L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1134(Res.plurals $this$following_global_string_1134) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1134, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1134();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1134() {
        return new PluralStringResource("plurals:following_global_string_1134", "following_global_string_1134", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 5125L, 234L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1383L, 76L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 2213L, 114L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1070L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2281L, 138L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 966L, 59L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 966L, 59L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1135(Res.plurals $this$following_global_string_1135) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1135, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1135();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1135() {
        return new PluralStringResource("plurals:following_global_string_1135", "following_global_string_1135", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 5360L, 498L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1460L, 152L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 2328L, 234L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1134L, 91L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2420L, 218L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1026L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1026L, 83L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1136(Res.plurals $this$following_global_string_1136) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1136, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1136();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1136() {
        return new PluralStringResource("plurals:following_global_string_1136", "following_global_string_1136", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 5859L, 426L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1613L, 128L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 2563L, 202L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1226L, 79L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1110L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1110L, 75L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1138(Res.plurals $this$following_global_string_1138) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1138, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1138();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1138() {
        return new PluralStringResource("plurals:following_global_string_1138", "following_global_string_1138", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 6286L, 1454L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1742L, 216L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 2766L, 330L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1306L, 179L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1186L, 147L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1186L, 147L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1139(Res.plurals $this$following_global_string_1139) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1139, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1139();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1139() {
        return new PluralStringResource("plurals:following_global_string_1139", "following_global_string_1139", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 7741L, 282L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 1959L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 3097L, 130L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1486L, 63L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2639L, 158L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1334L, 63L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1334L, 63L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1142(Res.plurals $this$following_global_string_1142) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1142, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1142();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1142() {
        return new PluralStringResource("plurals:following_global_string_1142", "following_global_string_1142", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 8024L, 442L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2056L, 96L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 3228L, 162L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1550L, 75L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2798L, 162L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1398L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1398L, 75L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1144(Res.plurals $this$following_global_string_1144) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1144, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1144();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1144() {
        return new PluralStringResource("plurals:following_global_string_1144", "following_global_string_1144", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 8467L, 474L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2153L, 124L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 3391L, 190L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1626L, 111L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 2961L, 194L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1474L, 83L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1474L, 83L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1145(Res.plurals $this$following_global_string_1145) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1145, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1145();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1145() {
        return new PluralStringResource("plurals:following_global_string_1145", "following_global_string_1145", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 8942L, 746L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2278L, 132L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 3582L, 258L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1738L, 115L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 3156L, 230L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1558L, 95L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1558L, 95L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1146(Res.plurals $this$following_global_string_1146) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1146, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1146();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1146() {
        return new PluralStringResource("plurals:following_global_string_1146", "following_global_string_1146", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 9689L, 506L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2411L, 112L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 3841L, 246L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1854L, 87L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 3387L, 194L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1654L, 87L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1654L, 87L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1147(Res.plurals $this$following_global_string_1147) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1147, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1147();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1147() {
        return new PluralStringResource("plurals:following_global_string_1147", "following_global_string_1147", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 10196L, 238L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2524L, 108L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 4088L, 186L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 1942L, 67L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 3582L, 150L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1742L, 67L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1742L, 67L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1148(Res.plurals $this$following_global_string_1148) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1148, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1148();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1148() {
        return new PluralStringResource("plurals:following_global_string_1148", "following_global_string_1148", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 10435L, 566L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2633L, 152L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 4275L, 218L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 2010L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 3733L, 230L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1810L, 91L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1810L, 91L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1150(Res.plurals $this$following_global_string_1150) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1150, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1150();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1150() {
        return new PluralStringResource("plurals:following_global_string_1150", "following_global_string_1150", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 11002L, 502L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2786L, 104L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 4494L, 234L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 2118L, 107L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 3964L, 186L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1902L, 79L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1902L, 79L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1151(Res.plurals $this$following_global_string_1151) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1151, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1151();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1151() {
        return new PluralStringResource("plurals:following_global_string_1151", "following_global_string_1151", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 11505L, 530L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 2891L, 112L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 4729L, 162L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 2226L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 4151L, 214L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 1982L, 75L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 1982L, 75L)}));
    }

    public static final PluralStringResource getFollowing_global_string_1153(Res.plurals $this$following_global_string_1153) {
        Intrinsics.checkNotNullParameter($this$following_global_string_1153, "<this>");
        return CommonMainPlurals0.INSTANCE.getFollowing_global_string_1153();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource init_following_global_string_1153() {
        return new PluralStringResource("plurals:following_global_string_1153", "following_global_string_1153", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("ar")), "composeResources/bili.resource.following/values-ar/strings.commonMain.cvr", 12036L, 558L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/bili.resource.following/values-en/strings.commonMain.cvr", 3004L, 152L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("es")), "composeResources/bili.resource.following/values-es/strings.commonMain.cvr", 4892L, 238L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("ja")), "composeResources/bili.resource.following/values-ja/strings.commonMain.cvr", 2310L, 83L), new ResourceItem(SetsKt.setOf(new LanguageQualifier("pt")), "composeResources/bili.resource.following/values-pt/strings.commonMain.cvr", 4366L, 186L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/bili.resource.following/values-zh-rHK/strings.commonMain.cvr", 2058L, 87L), new ResourceItem(SetsKt.emptySet(), "composeResources/bili.resource.following/values/strings.commonMain.cvr", 2058L, 87L)}));
    }
}