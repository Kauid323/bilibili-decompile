package kntr.app.im.base;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSetting;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* compiled from: IMEventHub.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0007\bJ'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0016¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/base/SettingNotifyItem;", RoomRecommendViewModel.EMPTY_CURSOR, "to", "T", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lkntr/app/im/base/SettingNotifyItem;", "IMSetting", "ChatSetting", "Lkntr/app/im/base/SettingNotifyItem$ChatSetting;", "Lkntr/app/im/base/SettingNotifyItem$IMSetting;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingNotifyItem {
    <T extends SettingNotifyItem> T to(KClass<T> kClass);

    /* compiled from: IMEventHub.kt */
    /* renamed from: kntr.app.im.base.SettingNotifyItem$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static SettingNotifyItem $default$to(SettingNotifyItem _this, KClass type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.isInstance(_this)) {
                return (SettingNotifyItem) KClasses.cast(type, _this);
            }
            return null;
        }
    }

    /* compiled from: IMEventHub.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/im/base/SettingNotifyItem$IMSetting;", "Lkntr/app/im/base/SettingNotifyItem;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "setting", "Lcom/bapis/bilibili/app/im/v1/KSetting;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lcom/bapis/bilibili/app/im/v1/KSetting;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getSetting", "()Lcom/bapis/bilibili/app/im/v1/KSetting;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IMSetting implements SettingNotifyItem {
        private final KSetting setting;
        private final KIMSettingType type;

        public static /* synthetic */ IMSetting copy$default(IMSetting iMSetting, KIMSettingType kIMSettingType, KSetting kSetting, int i, Object obj) {
            if ((i & 1) != 0) {
                kIMSettingType = iMSetting.type;
            }
            if ((i & 2) != 0) {
                kSetting = iMSetting.setting;
            }
            return iMSetting.copy(kIMSettingType, kSetting);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final KSetting component2() {
            return this.setting;
        }

        public final IMSetting copy(KIMSettingType kIMSettingType, KSetting kSetting) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            Intrinsics.checkNotNullParameter(kSetting, "setting");
            return new IMSetting(kIMSettingType, kSetting);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IMSetting) {
                IMSetting iMSetting = (IMSetting) obj;
                return Intrinsics.areEqual(this.type, iMSetting.type) && Intrinsics.areEqual(this.setting, iMSetting.setting);
            }
            return false;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.setting.hashCode();
        }

        public String toString() {
            KIMSettingType kIMSettingType = this.type;
            return "IMSetting(type=" + kIMSettingType + ", setting=" + this.setting + ")";
        }

        public IMSetting(KIMSettingType type, KSetting setting) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(setting, "setting");
            this.type = type;
            this.setting = setting;
        }

        @Override // kntr.app.im.base.SettingNotifyItem
        public /* bridge */ <T extends SettingNotifyItem> T to(KClass<T> kClass) {
            return (T) CC.$default$to(this, kClass);
        }

        public final KIMSettingType getType() {
            return this.type;
        }

        public final KSetting getSetting() {
            return this.setting;
        }
    }

    /* compiled from: IMEventHub.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/app/im/base/SettingNotifyItem$ChatSetting;", "Lkntr/app/im/base/SettingNotifyItem;", "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "setting", "Lcom/bapis/bilibili/app/im/v1/KSetting;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lcom/bapis/bilibili/app/im/v1/KSetting;)V", "getSessionID", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getSetting", "()Lcom/bapis/bilibili/app/im/v1/KSetting;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ChatSetting implements SettingNotifyItem {
        private final KSessionId sessionID;
        private final KSetting setting;
        private final KIMSettingType type;

        public static /* synthetic */ ChatSetting copy$default(ChatSetting chatSetting, KSessionId kSessionId, KIMSettingType kIMSettingType, KSetting kSetting, int i, Object obj) {
            if ((i & 1) != 0) {
                kSessionId = chatSetting.sessionID;
            }
            if ((i & 2) != 0) {
                kIMSettingType = chatSetting.type;
            }
            if ((i & 4) != 0) {
                kSetting = chatSetting.setting;
            }
            return chatSetting.copy(kSessionId, kIMSettingType, kSetting);
        }

        public final KSessionId component1() {
            return this.sessionID;
        }

        public final KIMSettingType component2() {
            return this.type;
        }

        public final KSetting component3() {
            return this.setting;
        }

        public final ChatSetting copy(KSessionId kSessionId, KIMSettingType kIMSettingType, KSetting kSetting) {
            Intrinsics.checkNotNullParameter(kSessionId, "sessionID");
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            Intrinsics.checkNotNullParameter(kSetting, "setting");
            return new ChatSetting(kSessionId, kIMSettingType, kSetting);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChatSetting) {
                ChatSetting chatSetting = (ChatSetting) obj;
                return Intrinsics.areEqual(this.sessionID, chatSetting.sessionID) && Intrinsics.areEqual(this.type, chatSetting.type) && Intrinsics.areEqual(this.setting, chatSetting.setting);
            }
            return false;
        }

        public int hashCode() {
            return (((this.sessionID.hashCode() * 31) + this.type.hashCode()) * 31) + this.setting.hashCode();
        }

        public String toString() {
            KSessionId kSessionId = this.sessionID;
            KIMSettingType kIMSettingType = this.type;
            return "ChatSetting(sessionID=" + kSessionId + ", type=" + kIMSettingType + ", setting=" + this.setting + ")";
        }

        public ChatSetting(KSessionId sessionID, KIMSettingType type, KSetting setting) {
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(setting, "setting");
            this.sessionID = sessionID;
            this.type = type;
            this.setting = setting;
        }

        @Override // kntr.app.im.base.SettingNotifyItem
        public /* bridge */ <T extends SettingNotifyItem> T to(KClass<T> kClass) {
            return (T) CC.$default$to(this, kClass);
        }

        public final KSessionId getSessionID() {
            return this.sessionID;
        }

        public final KIMSettingType getType() {
            return this.type;
        }

        public final KSetting getSetting() {
            return this.setting;
        }
    }

    /* compiled from: IMEventHub.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends SettingNotifyItem> T to(SettingNotifyItem $this, KClass<T> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "type");
            return (T) CC.$default$to($this, kClass);
        }
    }
}