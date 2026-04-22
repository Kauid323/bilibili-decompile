package im.setting.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingUserInfo;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import com.bilibili.blens.Lens;
import faceverify.q;
import im.setting.model.SettingItem;
import kntr.compose.avatar.model.AvatarItem;
import kntr.compose.avatar.parser.protobuf.AvatarKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItem.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lim/setting/model/SettingItem;", "", q.KEY_RES_9_KEY, "", "getKey", "()Ljava/lang/String;", "Setting", "UserInfo", "Lim/setting/model/SettingItem$Setting;", "Lim/setting/model/SettingItem$UserInfo;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingItem {
    String getKey();

    /* compiled from: SettingItem.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lim/setting/model/SettingItem$Setting;", "Lim/setting/model/SettingItem;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "setting", "Lcom/bapis/bilibili/app/im/v1/KSetting;", "isDisabled", "", "isLoading", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lcom/bapis/bilibili/app/im/v1/KSetting;ZZ)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getSetting", "()Lcom/bapis/bilibili/app/im/v1/KSetting;", "()Z", q.KEY_RES_9_KEY, "", "getKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Lens
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Setting implements SettingItem {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final boolean isDisabled;
        private final boolean isLoading;
        private final KSetting setting;
        private final KIMSettingType type;

        public static /* synthetic */ Setting copy$default(Setting setting, KIMSettingType kIMSettingType, KSetting kSetting, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kIMSettingType = setting.type;
            }
            if ((i2 & 2) != 0) {
                kSetting = setting.setting;
            }
            if ((i2 & 4) != 0) {
                z = setting.isDisabled;
            }
            if ((i2 & 8) != 0) {
                z2 = setting.isLoading;
            }
            return setting.copy(kIMSettingType, kSetting, z, z2);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final KSetting component2() {
            return this.setting;
        }

        public final boolean component3() {
            return this.isDisabled;
        }

        public final boolean component4() {
            return this.isLoading;
        }

        public final Setting copy(KIMSettingType kIMSettingType, KSetting kSetting, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            Intrinsics.checkNotNullParameter(kSetting, "setting");
            return new Setting(kIMSettingType, kSetting, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Setting) {
                Setting setting = (Setting) obj;
                return Intrinsics.areEqual(this.type, setting.type) && Intrinsics.areEqual(this.setting, setting.setting) && this.isDisabled == setting.isDisabled && this.isLoading == setting.isLoading;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + this.setting.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDisabled)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading);
        }

        public String toString() {
            KIMSettingType kIMSettingType = this.type;
            KSetting kSetting = this.setting;
            boolean z = this.isDisabled;
            return "Setting(type=" + kIMSettingType + ", setting=" + kSetting + ", isDisabled=" + z + ", isLoading=" + this.isLoading + ")";
        }

        public Setting(KIMSettingType type, KSetting setting, boolean isDisabled, boolean isLoading) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(setting, "setting");
            this.type = type;
            this.setting = setting;
            this.isDisabled = isDisabled;
            this.isLoading = isLoading;
        }

        public /* synthetic */ Setting(KIMSettingType kIMSettingType, KSetting kSetting, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(kIMSettingType, kSetting, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
        }

        public final KIMSettingType getType() {
            return this.type;
        }

        public final KSetting getSetting() {
            return this.setting;
        }

        public final boolean isDisabled() {
            return this.isDisabled;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        /* compiled from: SettingItem.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/setting/model/SettingItem$Setting$Companion;", "", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // im.setting.model.SettingItem
        public String getKey() {
            return this.type.getName();
        }
    }

    /* compiled from: SettingItem.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lim/setting/model/SettingItem$UserInfo;", "Lim/setting/model/SettingItem;", "value", "Lcom/bapis/bilibili/app/im/v1/KSettingUserInfo;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSettingUserInfo;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KSettingUserInfo;", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "getAvatar$annotations", "()V", "getAvatar", "()Lkntr/compose/avatar/model/AvatarItem;", "avatar$delegate", "Lkotlin/Lazy;", q.KEY_RES_9_KEY, "", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class UserInfo implements SettingItem {
        public static final int $stable = 0;
        private final Lazy avatar$delegate;
        private final KSettingUserInfo value;

        public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, KSettingUserInfo kSettingUserInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kSettingUserInfo = userInfo.value;
            }
            return userInfo.copy(kSettingUserInfo);
        }

        public static /* synthetic */ void getAvatar$annotations() {
        }

        public final KSettingUserInfo component1() {
            return this.value;
        }

        public final UserInfo copy(KSettingUserInfo kSettingUserInfo) {
            Intrinsics.checkNotNullParameter(kSettingUserInfo, "value");
            return new UserInfo(kSettingUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserInfo) && Intrinsics.areEqual(this.value, ((UserInfo) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "UserInfo(value=" + this.value + ")";
        }

        public UserInfo(KSettingUserInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.avatar$delegate = LazyKt.lazy(new Function0() { // from class: im.setting.model.SettingItem$UserInfo$$ExternalSyntheticLambda0
                public final Object invoke() {
                    AvatarItem avatar_delegate$lambda$0;
                    avatar_delegate$lambda$0 = SettingItem.UserInfo.avatar_delegate$lambda$0(SettingItem.UserInfo.this);
                    return avatar_delegate$lambda$0;
                }
            });
        }

        public final KSettingUserInfo getValue() {
            return this.value;
        }

        public final AvatarItem getAvatar() {
            return (AvatarItem) this.avatar$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AvatarItem avatar_delegate$lambda$0(UserInfo this$0) {
            KAvatarItem avatar = this$0.value.getAvatar();
            if (avatar != null) {
                return AvatarKt.toAvatarItem(avatar);
            }
            return null;
        }

        @Override // im.setting.model.SettingItem
        public String getKey() {
            return "SETTING_TYPE_USER_INFO";
        }
    }
}