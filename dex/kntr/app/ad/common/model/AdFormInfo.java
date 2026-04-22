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

/* compiled from: AdFormInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eB\u007f\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0010HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u00069"}, d2 = {"Lkntr/app/ad/common/model/AdFormInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "desc", "placeholder", "autoFillPrefix", "autoFillText", "autoFillLink", "buttonName", "pageId", "formId", "formItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getPlaceholder", "getAutoFillPrefix", "getAutoFillText", "getAutoFillLink", "getButtonName", "getPageId", "getFormId", "getFormItemId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdFormInfo {
    public static final Companion Companion = new Companion(null);
    private final String autoFillLink;
    private final String autoFillPrefix;
    private final String autoFillText;
    private final String buttonName;
    private final String desc;
    private final String formId;
    private final String formItemId;
    private final String pageId;
    private final String placeholder;
    private final String title;

    public AdFormInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.formItemId;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.placeholder;
    }

    public final String component4() {
        return this.autoFillPrefix;
    }

    public final String component5() {
        return this.autoFillText;
    }

    public final String component6() {
        return this.autoFillLink;
    }

    public final String component7() {
        return this.buttonName;
    }

    public final String component8() {
        return this.pageId;
    }

    public final String component9() {
        return this.formId;
    }

    public final AdFormInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return new AdFormInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdFormInfo) {
            AdFormInfo adFormInfo = (AdFormInfo) obj;
            return Intrinsics.areEqual(this.title, adFormInfo.title) && Intrinsics.areEqual(this.desc, adFormInfo.desc) && Intrinsics.areEqual(this.placeholder, adFormInfo.placeholder) && Intrinsics.areEqual(this.autoFillPrefix, adFormInfo.autoFillPrefix) && Intrinsics.areEqual(this.autoFillText, adFormInfo.autoFillText) && Intrinsics.areEqual(this.autoFillLink, adFormInfo.autoFillLink) && Intrinsics.areEqual(this.buttonName, adFormInfo.buttonName) && Intrinsics.areEqual(this.pageId, adFormInfo.pageId) && Intrinsics.areEqual(this.formId, adFormInfo.formId) && Intrinsics.areEqual(this.formItemId, adFormInfo.formItemId);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.placeholder == null ? 0 : this.placeholder.hashCode())) * 31) + (this.autoFillPrefix == null ? 0 : this.autoFillPrefix.hashCode())) * 31) + (this.autoFillText == null ? 0 : this.autoFillText.hashCode())) * 31) + (this.autoFillLink == null ? 0 : this.autoFillLink.hashCode())) * 31) + (this.buttonName == null ? 0 : this.buttonName.hashCode())) * 31) + (this.pageId == null ? 0 : this.pageId.hashCode())) * 31) + (this.formId == null ? 0 : this.formId.hashCode())) * 31) + (this.formItemId != null ? this.formItemId.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.placeholder;
        String str4 = this.autoFillPrefix;
        String str5 = this.autoFillText;
        String str6 = this.autoFillLink;
        String str7 = this.buttonName;
        String str8 = this.pageId;
        String str9 = this.formId;
        return "AdFormInfo(title=" + str + ", desc=" + str2 + ", placeholder=" + str3 + ", autoFillPrefix=" + str4 + ", autoFillText=" + str5 + ", autoFillLink=" + str6 + ", buttonName=" + str7 + ", pageId=" + str8 + ", formId=" + str9 + ", formItemId=" + this.formItemId + ")";
    }

    /* compiled from: AdFormInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdFormInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdFormInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdFormInfo> serializer() {
            return AdFormInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdFormInfo(int seen0, String title, String desc, String placeholder, String autoFillPrefix, String autoFillText, String autoFillLink, String buttonName, String pageId, String formId, String formItemId, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 4) == 0) {
            this.placeholder = null;
        } else {
            this.placeholder = placeholder;
        }
        if ((seen0 & 8) == 0) {
            this.autoFillPrefix = null;
        } else {
            this.autoFillPrefix = autoFillPrefix;
        }
        if ((seen0 & 16) == 0) {
            this.autoFillText = null;
        } else {
            this.autoFillText = autoFillText;
        }
        if ((seen0 & 32) == 0) {
            this.autoFillLink = null;
        } else {
            this.autoFillLink = autoFillLink;
        }
        if ((seen0 & 64) == 0) {
            this.buttonName = null;
        } else {
            this.buttonName = buttonName;
        }
        if ((seen0 & 128) == 0) {
            this.pageId = null;
        } else {
            this.pageId = pageId;
        }
        if ((seen0 & 256) == 0) {
            this.formId = null;
        } else {
            this.formId = formId;
        }
        if ((seen0 & 512) == 0) {
            this.formItemId = null;
        } else {
            this.formItemId = formItemId;
        }
    }

    public AdFormInfo(String title, String desc, String placeholder, String autoFillPrefix, String autoFillText, String autoFillLink, String buttonName, String pageId, String formId, String formItemId) {
        this.title = title;
        this.desc = desc;
        this.placeholder = placeholder;
        this.autoFillPrefix = autoFillPrefix;
        this.autoFillText = autoFillText;
        this.autoFillLink = autoFillLink;
        this.buttonName = buttonName;
        this.pageId = pageId;
        this.formId = formId;
        this.formItemId = formItemId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdFormInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.placeholder != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.placeholder);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.autoFillPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.autoFillPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.autoFillText != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.autoFillText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.autoFillLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.autoFillLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.buttonName != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.buttonName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.pageId != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.pageId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.formId != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.formId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.formItemId != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.formItemId);
        }
    }

    public /* synthetic */ AdFormInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) == 0 ? str10 : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getAutoFillPrefix() {
        return this.autoFillPrefix;
    }

    public final String getAutoFillText() {
        return this.autoFillText;
    }

    public final String getAutoFillLink() {
        return this.autoFillLink;
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getFormId() {
        return this.formId;
    }

    public final String getFormItemId() {
        return this.formItemId;
    }
}