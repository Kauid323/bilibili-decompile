package im.setting.model;

import com.bapis.bilibili.app.im.v1.KGetChatSettingsReply;
import com.bapis.bilibili.app.im.v1.KGetImSettingsReply;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KRedirect2SettingPage;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSettingUserInfo;
import im.setting.model.SettingItem;
import im.setting.model.SettingPageType;
import im.setting.model.extension.IMSettingPageDataExtKt;
import im.setting.model.extension.SettingItemExtKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: IMSettingPageData.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\f\u0010\u0011B\u0019\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u0014¢\u0006\u0004\b\f\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007HÀ\u0003¢\u0006\u0002\b&J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÀ\u0003¢\u0006\u0002\b(JA\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lim/setting/model/IMSettingPageData;", "", "type", "Lim/setting/model/SettingPageType;", "title", "", "settings", "", "", "Lim/setting/model/SettingItem$Setting;", "userInfo", "Lim/setting/model/SettingItem$UserInfo;", "<init>", "(Lim/setting/model/SettingPageType;Ljava/lang/String;Ljava/util/Map;Lim/setting/model/SettingItem$UserInfo;)V", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "response", "Lcom/bapis/bilibili/app/im/v1/KGetImSettingsReply;", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lcom/bapis/bilibili/app/im/v1/KGetImSettingsReply;)V", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "Lcom/bapis/bilibili/app/im/v1/KGetChatSettingsReply;", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KGetChatSettingsReply;)V", "getType", "()Lim/setting/model/SettingPageType;", "getTitle", "()Ljava/lang/String;", "getSettings$logic_debug", "()Ljava/util/Map;", "getUserInfo$logic_debug", "()Lim/setting/model/SettingItem$UserInfo;", "groups", "", "Lim/setting/model/SettingGroup;", "getGroups", "()Ljava/util/List;", "component1", "component2", "component3", "component3$logic_debug", "component4", "component4$logic_debug", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingPageData {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final List<SettingGroup> groups;
    private final Map<Integer, SettingItem.Setting> settings;
    private final String title;
    private final SettingPageType type;
    private final SettingItem.UserInfo userInfo;

    public IMSettingPageData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMSettingPageData copy$default(IMSettingPageData iMSettingPageData, SettingPageType settingPageType, String str, Map map, SettingItem.UserInfo userInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            settingPageType = iMSettingPageData.type;
        }
        if ((i2 & 2) != 0) {
            str = iMSettingPageData.title;
        }
        if ((i2 & 4) != 0) {
            map = iMSettingPageData.settings;
        }
        if ((i2 & 8) != 0) {
            userInfo = iMSettingPageData.userInfo;
        }
        return iMSettingPageData.copy(settingPageType, str, map, userInfo);
    }

    public final SettingPageType component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final Map<Integer, SettingItem.Setting> component3$logic_debug() {
        return this.settings;
    }

    public final SettingItem.UserInfo component4$logic_debug() {
        return this.userInfo;
    }

    public final IMSettingPageData copy(SettingPageType settingPageType, String str, Map<Integer, SettingItem.Setting> map, SettingItem.UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(settingPageType, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(map, "settings");
        return new IMSettingPageData(settingPageType, str, map, userInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSettingPageData) {
            IMSettingPageData iMSettingPageData = (IMSettingPageData) obj;
            return Intrinsics.areEqual(this.type, iMSettingPageData.type) && Intrinsics.areEqual(this.title, iMSettingPageData.title) && Intrinsics.areEqual(this.settings, iMSettingPageData.settings) && Intrinsics.areEqual(this.userInfo, iMSettingPageData.userInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + this.settings.hashCode()) * 31) + (this.userInfo == null ? 0 : this.userInfo.hashCode());
    }

    public String toString() {
        SettingPageType settingPageType = this.type;
        String str = this.title;
        Map<Integer, SettingItem.Setting> map = this.settings;
        return "IMSettingPageData(type=" + settingPageType + ", title=" + str + ", settings=" + map + ", userInfo=" + this.userInfo + ")";
    }

    public IMSettingPageData(SettingPageType type, String title, Map<Integer, SettingItem.Setting> map, SettingItem.UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(map, "settings");
        this.type = type;
        this.title = title;
        this.settings = map;
        this.userInfo = userInfo;
        this.groups = IMSettingPageDataExtKt.createSettingGroups(Companion, this.type, this.settings, this.userInfo);
    }

    public /* synthetic */ IMSettingPageData(SettingPageType.IMSetting iMSetting, String str, Map map, SettingItem.UserInfo userInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new SettingPageType.IMSetting(KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE) : iMSetting, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? null : userInfo);
    }

    public final SettingPageType getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Map<Integer, SettingItem.Setting> getSettings$logic_debug() {
        return this.settings;
    }

    public final SettingItem.UserInfo getUserInfo$logic_debug() {
        return this.userInfo;
    }

    public final List<SettingGroup> getGroups() {
        return this.groups;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IMSettingPageData(KIMSettingType type, KGetImSettingsReply response) {
        this(new SettingPageType.IMSetting(type), response.getPageTitle(), SettingItemExtKt.toSettingItemsMap(response.getSettings()), null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IMSettingPageData(KSessionId sessionId, KGetChatSettingsReply response) {
        this(r0, r1, r2, it != null ? new SettingItem.UserInfo(it) : null);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(response, "response");
        SettingPageType.ChatSetting chatSetting = new SettingPageType.ChatSetting(sessionId);
        String pageTitle = response.getPageTitle();
        Map<Integer, SettingItem.Setting> settingItemsMap = SettingItemExtKt.toSettingItemsMap(response.getSettings());
        KSettingUserInfo it = response.getUserInfo();
    }

    /* compiled from: IMSettingPageData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lim/setting/model/IMSettingPageData$Companion;", "", "<init>", "()V", "decodeFromHex", "Lim/setting/model/IMSettingPageData;", "hexString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IMSettingPageData decodeFromHex(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            byte[] bytes = HexExtensionsKt.hexToByteArray$default(hexString, (HexFormat) null, 1, (Object) null);
            BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
            $this$decodeFromByteArray$iv.getSerializersModule();
            KRedirect2SettingPage settingPage = (KRedirect2SettingPage) $this$decodeFromByteArray$iv.decodeFromByteArray(KRedirect2SettingPage.Companion.serializer(), bytes);
            KIMSettingType type = settingPage.getParentSettingType();
            return new IMSettingPageData(new SettingPageType.IMSetting(type), settingPage.getPageTitle(), SettingItemExtKt.toSettingItemsMap(settingPage.getSubSettings()), null);
        }
    }
}