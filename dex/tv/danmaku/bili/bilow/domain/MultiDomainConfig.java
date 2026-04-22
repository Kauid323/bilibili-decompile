package tv.danmaku.bili.bilow.domain;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MultiDomainConfig.kt */
@Deprecated(message = "Using MultiDomainInterceptor")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/bilow/domain/MultiDomainConfig;", "", "<init>", "()V", "APP_MULTI_DOMAIN_ENABLED", "", "appMultiDomainEnabled", "getAppMultiDomainEnabled", "()Ljava/lang/Boolean;", "API_MULTI_DOMAIN_ENABLED", "apiMultiDomainEnabled", "getApiMultiDomainEnabled", "IMAGE_MULTI_DOMAIN_ENABLED", "imageMultiDomainEnabled", "getImageMultiDomainEnabled", "APP_MULTI_DOMAIN", "", "appMultiDomain", "getAppMultiDomain", "()Ljava/lang/String;", "API_MULTI_DOMAIN", "apiMultiDomain", "getApiMultiDomain", "IMAGE_MULTI_DOMAIN", "imageMultiDomain", "getImageMultiDomain", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MultiDomainConfig {
    public static final String API_MULTI_DOMAIN = "[\"api.bilibili.com\",\"api.biliapi.net\",\"api.biliapi.com\"]";
    public static final boolean API_MULTI_DOMAIN_ENABLED = true;
    public static final String APP_MULTI_DOMAIN = "[\"app.bilibili.com\",\"app.biliapi.net\",\"app.biliapi.com\"]";
    public static final boolean APP_MULTI_DOMAIN_ENABLED = true;
    public static final String IMAGE_MULTI_DOMAIN = "[\"i0.hdslb.com\",\"i1.hdslb.com\",\"i2.hdslb.com\"]";
    public static final boolean IMAGE_MULTI_DOMAIN_ENABLED = true;
    public static final MultiDomainConfig INSTANCE = new MultiDomainConfig();

    private MultiDomainConfig() {
    }

    public final Boolean getAppMultiDomainEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "okhttp_app_multi_domain_enabled", (Object) null, 2, (Object) null);
    }

    public final Boolean getApiMultiDomainEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "okhttp_api_multi_domain_enabled", (Object) null, 2, (Object) null);
    }

    public final Boolean getImageMultiDomainEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "okhttp_image_multi_domain_enabled", (Object) null, 2, (Object) null);
    }

    public final String getAppMultiDomain() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "okhttp.app_multi_domain", (Object) null, 2, (Object) null);
    }

    public final String getApiMultiDomain() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "okhttp.api_multi_domain", (Object) null, 2, (Object) null);
    }

    public final String getImageMultiDomain() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "okhttp.image_multi_domain", (Object) null, 2, (Object) null);
    }
}