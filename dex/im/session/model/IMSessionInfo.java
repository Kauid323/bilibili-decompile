package im.session.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KUserLabel;
import com.bapis.bilibili.app.im.v1.KUserLabel$;
import com.bilibili.blens.Lens;
import com.tencent.smtt.sdk.TbsListener;
import im.base.model.AvatarHolder;
import im.base.model.AvatarSerializer;
import im.base.model.NameRenderHolder;
import im.base.model.NameRenderSerializer;
import im.base.model.VipNameColorHolder;
import im.base.model.VipNameColorHolder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMSessionInfo.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002ABBS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fB_\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003JU\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0011HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b\u000b\u0010%R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001e\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010,¨\u0006C"}, d2 = {"Lim/session/model/IMSessionInfo;", "", "sessionName", "", "nameRender", "Lim/base/model/NameRenderHolder;", "avatar", "Lim/base/model/AvatarHolder;", "vipInfo", "userLabel", "Lcom/bapis/bilibili/app/im/v1/KUserLabel;", "isLive", "", "sessionHandle", "<init>", "(Ljava/lang/String;Lim/base/model/NameRenderHolder;Lim/base/model/AvatarHolder;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KUserLabel;ZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lim/base/model/NameRenderHolder;Lim/base/model/AvatarHolder;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KUserLabel;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSessionName$annotations", "()V", "getSessionName", "()Ljava/lang/String;", "getNameRender$annotations", "getNameRender", "()Lim/base/model/NameRenderHolder;", "getAvatar$annotations", "getAvatar", "()Lim/base/model/AvatarHolder;", "getVipInfo$annotations", "getVipInfo", "getUserLabel$annotations", "getUserLabel", "()Lcom/bapis/bilibili/app/im/v1/KUserLabel;", "isLive$annotations", "()Z", "getSessionHandle$annotations", "getSessionHandle", "vipNameColor", "Lim/base/model/VipNameColorHolder;", "getVipNameColor$annotations", "getVipNameColor", "()Lim/base/model/VipNameColorHolder;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "Companion", "$serializer", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMSessionInfo {
    private final AvatarHolder avatar;
    private final boolean isLive;
    private final NameRenderHolder nameRender;
    private final String sessionHandle;
    private final String sessionName;
    private final KUserLabel userLabel;
    private final String vipInfo;
    private final VipNameColorHolder vipNameColor;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMSessionInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null};

    public IMSessionInfo() {
        this((String) null, (NameRenderHolder) null, (AvatarHolder) null, (String) null, (KUserLabel) null, false, (String) null, (int) TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IMSessionInfo copy$default(IMSessionInfo iMSessionInfo, String str, NameRenderHolder nameRenderHolder, AvatarHolder avatarHolder, String str2, KUserLabel kUserLabel, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iMSessionInfo.sessionName;
        }
        if ((i2 & 2) != 0) {
            nameRenderHolder = iMSessionInfo.nameRender;
        }
        NameRenderHolder nameRenderHolder2 = nameRenderHolder;
        if ((i2 & 4) != 0) {
            avatarHolder = iMSessionInfo.avatar;
        }
        AvatarHolder avatarHolder2 = avatarHolder;
        if ((i2 & 8) != 0) {
            str2 = iMSessionInfo.vipInfo;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            kUserLabel = iMSessionInfo.userLabel;
        }
        KUserLabel kUserLabel2 = kUserLabel;
        if ((i2 & 32) != 0) {
            z = iMSessionInfo.isLive;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            str3 = iMSessionInfo.sessionHandle;
        }
        return iMSessionInfo.copy(str, nameRenderHolder2, avatarHolder2, str4, kUserLabel2, z2, str3);
    }

    @ProtoNumber(number = 3)
    @Serializable(with = AvatarSerializer.class)
    @SerialName("avatar")
    @Lens.Ignore
    public static /* synthetic */ void getAvatar$annotations() {
    }

    @ProtoNumber(number = 2)
    @Serializable(with = NameRenderSerializer.class)
    @SerialName("nameRender")
    @Lens.Ignore
    public static /* synthetic */ void getNameRender$annotations() {
    }

    @SerialName("sessionHandle")
    @ProtoNumber(number = 7)
    public static /* synthetic */ void getSessionHandle$annotations() {
    }

    @SerialName("sessionName")
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getSessionName$annotations() {
    }

    @SerialName("userLabel")
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getUserLabel$annotations() {
    }

    @SerialName("vipInfo")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getVipInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getVipNameColor$annotations() {
    }

    @SerialName("isLive")
    @ProtoNumber(number = 6)
    public static /* synthetic */ void isLive$annotations() {
    }

    public final String component1() {
        return this.sessionName;
    }

    public final NameRenderHolder component2() {
        return this.nameRender;
    }

    public final AvatarHolder component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.vipInfo;
    }

    public final KUserLabel component5() {
        return this.userLabel;
    }

    public final boolean component6() {
        return this.isLive;
    }

    public final String component7() {
        return this.sessionHandle;
    }

    public final IMSessionInfo copy(String str, NameRenderHolder nameRenderHolder, AvatarHolder avatarHolder, String str2, KUserLabel kUserLabel, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "sessionName");
        Intrinsics.checkNotNullParameter(str2, "vipInfo");
        Intrinsics.checkNotNullParameter(str3, "sessionHandle");
        return new IMSessionInfo(str, nameRenderHolder, avatarHolder, str2, kUserLabel, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionInfo) {
            IMSessionInfo iMSessionInfo = (IMSessionInfo) obj;
            return Intrinsics.areEqual(this.sessionName, iMSessionInfo.sessionName) && Intrinsics.areEqual(this.nameRender, iMSessionInfo.nameRender) && Intrinsics.areEqual(this.avatar, iMSessionInfo.avatar) && Intrinsics.areEqual(this.vipInfo, iMSessionInfo.vipInfo) && Intrinsics.areEqual(this.userLabel, iMSessionInfo.userLabel) && this.isLive == iMSessionInfo.isLive && Intrinsics.areEqual(this.sessionHandle, iMSessionInfo.sessionHandle);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.sessionName.hashCode() * 31) + (this.nameRender == null ? 0 : this.nameRender.hashCode())) * 31) + (this.avatar == null ? 0 : this.avatar.hashCode())) * 31) + this.vipInfo.hashCode()) * 31) + (this.userLabel != null ? this.userLabel.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLive)) * 31) + this.sessionHandle.hashCode();
    }

    public String toString() {
        String str = this.sessionName;
        NameRenderHolder nameRenderHolder = this.nameRender;
        AvatarHolder avatarHolder = this.avatar;
        String str2 = this.vipInfo;
        KUserLabel kUserLabel = this.userLabel;
        boolean z = this.isLive;
        return "IMSessionInfo(sessionName=" + str + ", nameRender=" + nameRenderHolder + ", avatar=" + avatarHolder + ", vipInfo=" + str2 + ", userLabel=" + kUserLabel + ", isLive=" + z + ", sessionHandle=" + this.sessionHandle + ")";
    }

    public /* synthetic */ IMSessionInfo(int seen0, String sessionName, NameRenderHolder nameRender, AvatarHolder avatar, String vipInfo, KUserLabel userLabel, boolean isLive, String sessionHandle, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.sessionName = "";
        } else {
            this.sessionName = sessionName;
        }
        if ((seen0 & 2) == 0) {
            this.nameRender = null;
        } else {
            this.nameRender = nameRender;
        }
        if ((seen0 & 4) == 0) {
            this.avatar = null;
        } else {
            this.avatar = avatar;
        }
        if ((seen0 & 8) == 0) {
            this.vipInfo = "";
        } else {
            this.vipInfo = vipInfo;
        }
        if ((seen0 & 16) == 0) {
            this.userLabel = null;
        } else {
            this.userLabel = userLabel;
        }
        if ((seen0 & 32) == 0) {
            this.isLive = false;
        } else {
            this.isLive = isLive;
        }
        if ((seen0 & 64) == 0) {
            this.sessionHandle = "";
        } else {
            this.sessionHandle = sessionHandle;
        }
        this.vipNameColor = VipNameColorHolder_androidKt.parseVipNameColor(this.vipInfo);
    }

    public IMSessionInfo(String sessionName, NameRenderHolder nameRender, AvatarHolder avatar, String vipInfo, KUserLabel userLabel, boolean isLive, String sessionHandle) {
        Intrinsics.checkNotNullParameter(sessionName, "sessionName");
        Intrinsics.checkNotNullParameter(vipInfo, "vipInfo");
        Intrinsics.checkNotNullParameter(sessionHandle, "sessionHandle");
        this.sessionName = sessionName;
        this.nameRender = nameRender;
        this.avatar = avatar;
        this.vipInfo = vipInfo;
        this.userLabel = userLabel;
        this.isLive = isLive;
        this.sessionHandle = sessionHandle;
        this.vipNameColor = VipNameColorHolder_androidKt.parseVipNameColor(this.vipInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return AvatarHolder.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMSessionInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.sessionName, "")) {
            output.encodeStringElement(serialDesc, 0, self.sessionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.nameRender != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, NameRenderSerializer.INSTANCE, self.nameRender);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.avatar != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.vipInfo, "")) {
            output.encodeStringElement(serialDesc, 3, self.vipInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.userLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, KUserLabel$.serializer.INSTANCE, self.userLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isLive) {
            output.encodeBooleanElement(serialDesc, 5, self.isLive);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.sessionHandle, "")) {
            output.encodeStringElement(serialDesc, 6, self.sessionHandle);
        }
    }

    public /* synthetic */ IMSessionInfo(String str, NameRenderHolder nameRenderHolder, AvatarHolder avatarHolder, String str2, KUserLabel kUserLabel, boolean z, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : nameRenderHolder, (i2 & 4) != 0 ? null : avatarHolder, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? kUserLabel : null, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? "" : str3);
    }

    public final String getSessionName() {
        return this.sessionName;
    }

    public final NameRenderHolder getNameRender() {
        return this.nameRender;
    }

    public final AvatarHolder getAvatar() {
        return this.avatar;
    }

    public final String getVipInfo() {
        return this.vipInfo;
    }

    public final KUserLabel getUserLabel() {
        return this.userLabel;
    }

    public final boolean isLive() {
        return this.isLive;
    }

    public final String getSessionHandle() {
        return this.sessionHandle;
    }

    /* compiled from: IMSessionInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMSessionInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMSessionInfo;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMSessionInfo> serializer() {
            return IMSessionInfo$$serializer.INSTANCE;
        }
    }

    public final VipNameColorHolder getVipNameColor() {
        return this.vipNameColor;
    }
}