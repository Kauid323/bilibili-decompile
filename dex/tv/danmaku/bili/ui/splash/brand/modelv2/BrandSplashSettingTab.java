package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingTab.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "source", "sections", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "page", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getSource", "setSource", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "getPage", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "setPage", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingTab {
    public static final int $stable = 8;
    @SerializedName("page")
    private BrandSplashSettingPageMore page;
    @SerializedName("sections")
    private List<BrandSplashSection> sections;
    @SerializedName("source")
    private String source;
    @SerializedName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private String title;

    public BrandSplashSettingTab() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandSplashSettingTab copy$default(BrandSplashSettingTab brandSplashSettingTab, String str, String str2, List list, BrandSplashSettingPageMore brandSplashSettingPageMore, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandSplashSettingTab.title;
        }
        if ((i & 2) != 0) {
            str2 = brandSplashSettingTab.source;
        }
        if ((i & 4) != 0) {
            list = brandSplashSettingTab.sections;
        }
        if ((i & 8) != 0) {
            brandSplashSettingPageMore = brandSplashSettingTab.page;
        }
        return brandSplashSettingTab.copy(str, str2, list, brandSplashSettingPageMore);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.source;
    }

    public final List<BrandSplashSection> component3() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.sections);
    }

    public final BrandSplashSettingPageMore component4() {
        return this.page;
    }

    public final BrandSplashSettingTab copy(String str, String str2, List<BrandSplashSection> list, BrandSplashSettingPageMore brandSplashSettingPageMore) {
        return new BrandSplashSettingTab(str, str2, EnhancedUnmodifiabilityKt.unmodifiable(list), brandSplashSettingPageMore);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingTab) {
            BrandSplashSettingTab brandSplashSettingTab = (BrandSplashSettingTab) obj;
            return Intrinsics.areEqual(this.title, brandSplashSettingTab.title) && Intrinsics.areEqual(this.source, brandSplashSettingTab.source) && Intrinsics.areEqual(this.sections, brandSplashSettingTab.sections) && Intrinsics.areEqual(this.page, brandSplashSettingTab.page);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.sections == null ? 0 : this.sections.hashCode())) * 31) + (this.page != null ? this.page.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.source;
        List<BrandSplashSection> list = this.sections;
        return "BrandSplashSettingTab(title=" + str + ", source=" + str2 + ", sections=" + list + ", page=" + this.page + ")";
    }

    public BrandSplashSettingTab(String title, String source, List<BrandSplashSection> list, BrandSplashSettingPageMore page) {
        List sections = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.title = title;
        this.source = source;
        this.sections = sections;
        this.page = page;
    }

    public /* synthetic */ BrandSplashSettingTab(String str, String str2, List list, BrandSplashSettingPageMore brandSplashSettingPageMore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : brandSplashSettingPageMore);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final List<BrandSplashSection> getSections() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.sections);
    }

    public final void setSections(List<BrandSplashSection> list) {
        this.sections = list;
    }

    public final BrandSplashSettingPageMore getPage() {
        return this.page;
    }

    public final void setPage(BrandSplashSettingPageMore brandSplashSettingPageMore) {
        this.page = brandSplashSettingPageMore;
    }
}