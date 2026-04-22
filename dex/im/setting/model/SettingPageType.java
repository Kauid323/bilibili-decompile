package im.setting.model;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingPageData.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/setting/model/SettingPageType;", "", "IMSetting", "ChatSetting", "Lim/setting/model/SettingPageType$ChatSetting;", "Lim/setting/model/SettingPageType$IMSetting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingPageType {

    /* compiled from: IMSettingPageData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/model/SettingPageType$IMSetting;", "Lim/setting/model/SettingPageType;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class IMSetting implements SettingPageType {
        public static final int $stable = 8;
        private final KIMSettingType type;

        public static /* synthetic */ IMSetting copy$default(IMSetting iMSetting, KIMSettingType kIMSettingType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kIMSettingType = iMSetting.type;
            }
            return iMSetting.copy(kIMSettingType);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final IMSetting copy(KIMSettingType kIMSettingType) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            return new IMSetting(kIMSettingType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IMSetting) && Intrinsics.areEqual(this.type, ((IMSetting) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "IMSetting(type=" + this.type + ")";
        }

        public IMSetting(KIMSettingType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final KIMSettingType getType() {
            return this.type;
        }
    }

    /* compiled from: IMSettingPageData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/model/SettingPageType$ChatSetting;", "Lim/setting/model/SettingPageType;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "getSessionId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ChatSetting implements SettingPageType {
        public static final int $stable = 8;
        private final KSessionId sessionId;

        public static /* synthetic */ ChatSetting copy$default(ChatSetting chatSetting, KSessionId kSessionId, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kSessionId = chatSetting.sessionId;
            }
            return chatSetting.copy(kSessionId);
        }

        public final KSessionId component1() {
            return this.sessionId;
        }

        public final ChatSetting copy(KSessionId kSessionId) {
            Intrinsics.checkNotNullParameter(kSessionId, "sessionId");
            return new ChatSetting(kSessionId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChatSetting) && Intrinsics.areEqual(this.sessionId, ((ChatSetting) obj).sessionId);
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "ChatSetting(sessionId=" + this.sessionId + ")";
        }

        public ChatSetting(KSessionId sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.sessionId = sessionId;
        }

        public final KSessionId getSessionId() {
            return this.sessionId;
        }
    }
}