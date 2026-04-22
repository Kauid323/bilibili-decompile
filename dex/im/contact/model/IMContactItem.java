package im.contact.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.blens.Lens;
import faceverify.w;
import im.base.model.AvatarHolder;
import im.base.model.AvatarSerializer;
import im.base.model.NameRenderHolder;
import im.base.model.NameRenderSerializer;
import im.base.model.VipNameColorHolder;
import im.base.model.VipNameColorHolder_androidKt;
import io.ktor.http.ContentDisposition;
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

/* compiled from: IMContactItem.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002LMBe\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012By\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0010HÆ\u0003Jg\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0010HÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b\f\u0010*R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001eR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0019\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001e¨\u0006N"}, d2 = {"Lim/contact/model/IMContactItem;", "", "uid", "", ContentDisposition.Parameters.Name, "", "avatar", "Lim/base/model/AvatarHolder;", "vipInfo", "url", "nameRender", "Lim/base/model/NameRenderHolder;", "isSpecialFollow", "", w.BLOB_ELEM_TYPE_FACE, "officialType", "", "<init>", "(JLjava/lang/String;Lim/base/model/AvatarHolder;Ljava/lang/String;Ljava/lang/String;Lim/base/model/NameRenderHolder;ZLjava/lang/String;I)V", "seen0", "identifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lim/base/model/AvatarHolder;Ljava/lang/String;Ljava/lang/String;Lim/base/model/NameRenderHolder;ZLjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUid$annotations", "()V", "getUid", "()J", "getName$annotations", "getName", "()Ljava/lang/String;", "getAvatar$annotations", "getAvatar", "()Lim/base/model/AvatarHolder;", "getVipInfo$annotations", "getVipInfo", "getUrl$annotations", "getUrl", "getNameRender$annotations", "getNameRender", "()Lim/base/model/NameRenderHolder;", "isSpecialFollow$annotations", "()Z", "getFace$annotations", "getFace", "getOfficialType$annotations", "getOfficialType", "()I", "vipNameColor", "Lim/base/model/VipNameColorHolder;", "getVipNameColor$annotations", "getVipNameColor", "()Lim/base/model/VipNameColorHolder;", "getIdentifier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$contact_debug", "Companion", "$serializer", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMContactItem {
    private final AvatarHolder avatar;
    private final String face;
    private final String identifier;
    private final boolean isSpecialFollow;
    private final String name;
    private final NameRenderHolder nameRender;
    private final int officialType;
    private final long uid;
    private final String url;
    private final String vipInfo;
    private final VipNameColorHolder vipNameColor;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.contact.model.IMContactItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMContactItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null};

    public IMContactItem() {
        this(0L, null, null, null, null, null, false, null, 0, 511, null);
    }

    @ProtoNumber(number = 3)
    @Serializable(with = AvatarSerializer.class)
    @SerialName("avatar")
    @Lens.Ignore
    public static /* synthetic */ void getAvatar$annotations() {
    }

    @SerialName(w.BLOB_ELEM_TYPE_FACE)
    @ProtoNumber(number = 8)
    public static /* synthetic */ void getFace$annotations() {
    }

    @SerialName(ContentDisposition.Parameters.Name)
    @ProtoNumber(number = 2)
    public static /* synthetic */ void getName$annotations() {
    }

    @ProtoNumber(number = 6)
    @Serializable(with = NameRenderSerializer.class)
    @SerialName("nameRender")
    @Lens.Ignore
    public static /* synthetic */ void getNameRender$annotations() {
    }

    @SerialName("officialType")
    @ProtoNumber(number = 9)
    public static /* synthetic */ void getOfficialType$annotations() {
    }

    @SerialName("id")
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getUid$annotations() {
    }

    @SerialName("url")
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("vipInfo")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getVipInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getVipNameColor$annotations() {
    }

    @SerialName("isSpecialFollow")
    @ProtoNumber(number = 7)
    public static /* synthetic */ void isSpecialFollow$annotations() {
    }

    public final long component1() {
        return this.uid;
    }

    public final String component2() {
        return this.name;
    }

    public final AvatarHolder component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.vipInfo;
    }

    public final String component5() {
        return this.url;
    }

    public final NameRenderHolder component6() {
        return this.nameRender;
    }

    public final boolean component7() {
        return this.isSpecialFollow;
    }

    public final String component8() {
        return this.face;
    }

    public final int component9() {
        return this.officialType;
    }

    public final IMContactItem copy(long j, String str, AvatarHolder avatarHolder, String str2, String str3, NameRenderHolder nameRenderHolder, boolean z, String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "vipInfo");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, w.BLOB_ELEM_TYPE_FACE);
        return new IMContactItem(j, str, avatarHolder, str2, str3, nameRenderHolder, z, str4, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactItem) {
            IMContactItem iMContactItem = (IMContactItem) obj;
            return this.uid == iMContactItem.uid && Intrinsics.areEqual(this.name, iMContactItem.name) && Intrinsics.areEqual(this.avatar, iMContactItem.avatar) && Intrinsics.areEqual(this.vipInfo, iMContactItem.vipInfo) && Intrinsics.areEqual(this.url, iMContactItem.url) && Intrinsics.areEqual(this.nameRender, iMContactItem.nameRender) && this.isSpecialFollow == iMContactItem.isSpecialFollow && Intrinsics.areEqual(this.face, iMContactItem.face) && this.officialType == iMContactItem.officialType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.name.hashCode()) * 31) + (this.avatar == null ? 0 : this.avatar.hashCode())) * 31) + this.vipInfo.hashCode()) * 31) + this.url.hashCode()) * 31) + (this.nameRender != null ? this.nameRender.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSpecialFollow)) * 31) + this.face.hashCode()) * 31) + this.officialType;
    }

    public String toString() {
        long j = this.uid;
        String str = this.name;
        AvatarHolder avatarHolder = this.avatar;
        String str2 = this.vipInfo;
        String str3 = this.url;
        NameRenderHolder nameRenderHolder = this.nameRender;
        boolean z = this.isSpecialFollow;
        String str4 = this.face;
        return "IMContactItem(uid=" + j + ", name=" + str + ", avatar=" + avatarHolder + ", vipInfo=" + str2 + ", url=" + str3 + ", nameRender=" + nameRenderHolder + ", isSpecialFollow=" + z + ", face=" + str4 + ", officialType=" + this.officialType + ")";
    }

    public /* synthetic */ IMContactItem(int seen0, long uid, String name, AvatarHolder avatar, String vipInfo, String url, NameRenderHolder nameRender, boolean isSpecialFollow, String face, int officialType, String identifier, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.uid = -1L;
        } else {
            this.uid = uid;
        }
        if ((seen0 & 2) == 0) {
            this.name = "";
        } else {
            this.name = name;
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
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen0 & 32) == 0) {
            this.nameRender = null;
        } else {
            this.nameRender = nameRender;
        }
        if ((seen0 & 64) == 0) {
            this.isSpecialFollow = false;
        } else {
            this.isSpecialFollow = isSpecialFollow;
        }
        if ((seen0 & 128) == 0) {
            this.face = "";
        } else {
            this.face = face;
        }
        if ((seen0 & 256) == 0) {
            this.officialType = 0;
        } else {
            this.officialType = officialType;
        }
        this.vipNameColor = VipNameColorHolder_androidKt.parseVipNameColor(this.vipInfo);
        if ((seen0 & 512) == 0) {
            this.identifier = String.valueOf(this.uid);
        } else {
            this.identifier = identifier;
        }
    }

    public IMContactItem(long uid, String name, AvatarHolder avatar, String vipInfo, String url, NameRenderHolder nameRender, boolean isSpecialFollow, String face, int officialType) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(vipInfo, "vipInfo");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(face, w.BLOB_ELEM_TYPE_FACE);
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.vipInfo = vipInfo;
        this.url = url;
        this.nameRender = nameRender;
        this.isSpecialFollow = isSpecialFollow;
        this.face = face;
        this.officialType = officialType;
        this.vipNameColor = VipNameColorHolder_androidKt.parseVipNameColor(this.vipInfo);
        this.identifier = String.valueOf(this.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return AvatarHolder.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$contact_debug(IMContactItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.uid != -1) {
            output.encodeLongElement(serialDesc, 0, self.uid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.avatar != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.vipInfo, "")) {
            output.encodeStringElement(serialDesc, 3, self.vipInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.url, "")) {
            output.encodeStringElement(serialDesc, 4, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.nameRender != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, NameRenderSerializer.INSTANCE, self.nameRender);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isSpecialFollow) {
            output.encodeBooleanElement(serialDesc, 6, self.isSpecialFollow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.face, "")) {
            output.encodeStringElement(serialDesc, 7, self.face);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.officialType != 0) {
            output.encodeIntElement(serialDesc, 8, self.officialType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.identifier, String.valueOf(self.uid))) {
            output.encodeStringElement(serialDesc, 9, self.identifier);
        }
    }

    public /* synthetic */ IMContactItem(long j, String str, AvatarHolder avatarHolder, String str2, String str3, NameRenderHolder nameRenderHolder, boolean z, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : avatarHolder, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) == 0 ? nameRenderHolder : null, (i3 & 64) != 0 ? false : z, (i3 & 128) == 0 ? str4 : "", (i3 & 256) == 0 ? i2 : 0);
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getName() {
        return this.name;
    }

    public final AvatarHolder getAvatar() {
        return this.avatar;
    }

    public final String getVipInfo() {
        return this.vipInfo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final NameRenderHolder getNameRender() {
        return this.nameRender;
    }

    public final boolean isSpecialFollow() {
        return this.isSpecialFollow;
    }

    public final String getFace() {
        return this.face;
    }

    public final int getOfficialType() {
        return this.officialType;
    }

    /* compiled from: IMContactItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/contact/model/IMContactItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/contact/model/IMContactItem;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMContactItem> serializer() {
            return IMContactItem$$serializer.INSTANCE;
        }
    }

    public final VipNameColorHolder getVipNameColor() {
        return this.vipNameColor;
    }

    public final String getIdentifier() {
        return this.identifier;
    }
}