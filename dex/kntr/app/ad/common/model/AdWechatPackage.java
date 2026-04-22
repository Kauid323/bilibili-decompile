package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdWechatPackage.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/ad/common/model/AdWechatPackage;", RoomRecommendViewModel.EMPTY_CURSOR, "packageId", RoomRecommendViewModel.EMPTY_CURSOR, "accountId", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPackageId", "()Ljava/lang/String;", "getAccountId", "getContent", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdWechatPackage {
    public static final Companion Companion = new Companion(null);
    private final String accountId;
    private final String content;
    private final String packageId;

    public AdWechatPackage() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdWechatPackage copy$default(AdWechatPackage adWechatPackage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adWechatPackage.packageId;
        }
        if ((i & 2) != 0) {
            str2 = adWechatPackage.accountId;
        }
        if ((i & 4) != 0) {
            str3 = adWechatPackage.content;
        }
        return adWechatPackage.copy(str, str2, str3);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.accountId;
    }

    public final String component3() {
        return this.content;
    }

    public final AdWechatPackage copy(String str, String str2, String str3) {
        return new AdWechatPackage(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdWechatPackage) {
            AdWechatPackage adWechatPackage = (AdWechatPackage) obj;
            return Intrinsics.areEqual(this.packageId, adWechatPackage.packageId) && Intrinsics.areEqual(this.accountId, adWechatPackage.accountId) && Intrinsics.areEqual(this.content, adWechatPackage.content);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.packageId == null ? 0 : this.packageId.hashCode()) * 31) + (this.accountId == null ? 0 : this.accountId.hashCode())) * 31) + (this.content != null ? this.content.hashCode() : 0);
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.accountId;
        return "AdWechatPackage(packageId=" + str + ", accountId=" + str2 + ", content=" + this.content + ")";
    }

    /* compiled from: AdWechatPackage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdWechatPackage$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdWechatPackage;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdWechatPackage> serializer() {
            return AdWechatPackage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdWechatPackage(int seen0, String packageId, String accountId, String content, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.packageId = null;
        } else {
            this.packageId = packageId;
        }
        if ((seen0 & 2) == 0) {
            this.accountId = null;
        } else {
            this.accountId = accountId;
        }
        if ((seen0 & 4) == 0) {
            this.content = null;
        } else {
            this.content = content;
        }
    }

    public AdWechatPackage(String packageId, String accountId, String content) {
        this.packageId = packageId;
        this.accountId = accountId;
        this.content = content;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdWechatPackage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.packageId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.packageId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.accountId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.accountId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.content);
        }
    }

    public /* synthetic */ AdWechatPackage(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getContent() {
        return this.content;
    }
}