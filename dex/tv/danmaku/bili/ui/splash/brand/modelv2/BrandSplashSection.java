package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSection.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJP\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "groupNo", "list", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "page", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getGroupNo", "setGroupNo", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getPage", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;Ljava/lang/Integer;)Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "equals", "", "other", "hashCode", "toString", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSection {
    public static final int TYPE_DLC = 3;
    public static final int TYPE_DRESS = 1;
    public static final int TYPE_VIP = 2;
    @SerializedName("group_no")
    private String groupNo;
    @SerializedName("list")
    private List<BrandSplash> list;
    @SerializedName("page")
    private final BrandSplashSettingPageMore page;
    @SerializedName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private String title;
    @SerializedName("type")
    private final Integer type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BrandSplashSection() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BrandSplashSection copy$default(BrandSplashSection brandSplashSection, String str, String str2, List list, BrandSplashSettingPageMore brandSplashSettingPageMore, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandSplashSection.title;
        }
        if ((i & 2) != 0) {
            str2 = brandSplashSection.groupNo;
        }
        String str3 = str2;
        List<BrandSplash> list2 = list;
        if ((i & 4) != 0) {
            list2 = brandSplashSection.list;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            brandSplashSettingPageMore = brandSplashSection.page;
        }
        BrandSplashSettingPageMore brandSplashSettingPageMore2 = brandSplashSettingPageMore;
        if ((i & 16) != 0) {
            num = brandSplashSection.type;
        }
        return brandSplashSection.copy(str, str3, list3, brandSplashSettingPageMore2, num);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.groupNo;
    }

    public final List<BrandSplash> component3() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.list);
    }

    public final BrandSplashSettingPageMore component4() {
        return this.page;
    }

    public final Integer component5() {
        return this.type;
    }

    public final BrandSplashSection copy(String str, String str2, List<BrandSplash> list, BrandSplashSettingPageMore brandSplashSettingPageMore, Integer num) {
        return new BrandSplashSection(str, str2, EnhancedUnmodifiabilityKt.unmodifiable(list), brandSplashSettingPageMore, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSection) {
            BrandSplashSection brandSplashSection = (BrandSplashSection) obj;
            return Intrinsics.areEqual(this.title, brandSplashSection.title) && Intrinsics.areEqual(this.groupNo, brandSplashSection.groupNo) && Intrinsics.areEqual(this.list, brandSplashSection.list) && Intrinsics.areEqual(this.page, brandSplashSection.page) && Intrinsics.areEqual(this.type, brandSplashSection.type);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.groupNo == null ? 0 : this.groupNo.hashCode())) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + (this.page == null ? 0 : this.page.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.groupNo;
        List<BrandSplash> list = this.list;
        BrandSplashSettingPageMore brandSplashSettingPageMore = this.page;
        return "BrandSplashSection(title=" + str + ", groupNo=" + str2 + ", list=" + list + ", page=" + brandSplashSettingPageMore + ", type=" + this.type + ")";
    }

    public BrandSplashSection(String title, String groupNo, List<BrandSplash> list, BrandSplashSettingPageMore page, Integer type) {
        List list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.title = title;
        this.groupNo = groupNo;
        this.list = list2;
        this.page = page;
        this.type = type;
    }

    public /* synthetic */ BrandSplashSection(String str, String str2, List list, BrandSplashSettingPageMore brandSplashSettingPageMore, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : brandSplashSettingPageMore, (i & 16) != 0 ? null : num);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getGroupNo() {
        return this.groupNo;
    }

    public final void setGroupNo(String str) {
        this.groupNo = str;
    }

    public final List<BrandSplash> getList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.list);
    }

    public final void setList(List<BrandSplash> list) {
        this.list = list;
    }

    public final BrandSplashSettingPageMore getPage() {
        return this.page;
    }

    public final Integer getType() {
        return this.type;
    }

    /* compiled from: BrandSplashSection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection$Companion;", "", "<init>", "()V", "TYPE_DRESS", "", "TYPE_VIP", "TYPE_DLC", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}