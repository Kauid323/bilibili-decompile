package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.adcommon.data.model.WxProgramInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashShopCard.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashShopCard;", "", "image", "", "imageHash", "jumpUrl", PerformanceConstants.EXTRA_KEY_SCHEMA, "wxProgramInfo", "Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bilibili/adcommon/data/model/WxProgramInfo;)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "getImageHash", "setImageHash", "getJumpUrl", "setJumpUrl", "getSchema", "setSchema", "getWxProgramInfo", "()Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "setWxProgramInfo", "(Lcom/bilibili/adcommon/data/model/WxProgramInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashShopCard {
    public static final int $stable = 0;
    @JSONField(name = "image")
    private String image;
    @JSONField(name = "image_hash")
    private String imageHash;
    @JSONField(name = "jump_url")
    private String jumpUrl;
    @JSONField(name = PerformanceConstants.EXTRA_KEY_SCHEMA)
    private String schema;
    @JSONField(name = "wx_program_info")
    private WxProgramInfo wxProgramInfo;

    public SplashShopCard() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SplashShopCard copy$default(SplashShopCard splashShopCard, String str, String str2, String str3, String str4, WxProgramInfo wxProgramInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashShopCard.image;
        }
        if ((i & 2) != 0) {
            str2 = splashShopCard.imageHash;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = splashShopCard.jumpUrl;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = splashShopCard.schema;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            wxProgramInfo = splashShopCard.wxProgramInfo;
        }
        return splashShopCard.copy(str, str5, str6, str7, wxProgramInfo);
    }

    public final String component1() {
        return this.image;
    }

    public final String component2() {
        return this.imageHash;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.schema;
    }

    public final WxProgramInfo component5() {
        return this.wxProgramInfo;
    }

    public final SplashShopCard copy(String str, String str2, String str3, String str4, WxProgramInfo wxProgramInfo) {
        return new SplashShopCard(str, str2, str3, str4, wxProgramInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashShopCard) {
            SplashShopCard splashShopCard = (SplashShopCard) obj;
            return Intrinsics.areEqual(this.image, splashShopCard.image) && Intrinsics.areEqual(this.imageHash, splashShopCard.imageHash) && Intrinsics.areEqual(this.jumpUrl, splashShopCard.jumpUrl) && Intrinsics.areEqual(this.schema, splashShopCard.schema) && Intrinsics.areEqual(this.wxProgramInfo, splashShopCard.wxProgramInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.image == null ? 0 : this.image.hashCode()) * 31) + (this.imageHash == null ? 0 : this.imageHash.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.schema == null ? 0 : this.schema.hashCode())) * 31) + (this.wxProgramInfo != null ? this.wxProgramInfo.hashCode() : 0);
    }

    public String toString() {
        String str = this.image;
        String str2 = this.imageHash;
        String str3 = this.jumpUrl;
        String str4 = this.schema;
        return "SplashShopCard(image=" + str + ", imageHash=" + str2 + ", jumpUrl=" + str3 + ", schema=" + str4 + ", wxProgramInfo=" + this.wxProgramInfo + ")";
    }

    public SplashShopCard(String image, String imageHash, String jumpUrl, String schema, WxProgramInfo wxProgramInfo) {
        this.image = image;
        this.imageHash = imageHash;
        this.jumpUrl = jumpUrl;
        this.schema = schema;
        this.wxProgramInfo = wxProgramInfo;
    }

    public /* synthetic */ SplashShopCard(String str, String str2, String str3, String str4, WxProgramInfo wxProgramInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : wxProgramInfo);
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final String getImageHash() {
        return this.imageHash;
    }

    public final void setImageHash(String str) {
        this.imageHash = str;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final WxProgramInfo getWxProgramInfo() {
        return this.wxProgramInfo;
    }

    public final void setWxProgramInfo(WxProgramInfo wxProgramInfo) {
        this.wxProgramInfo = wxProgramInfo;
    }
}