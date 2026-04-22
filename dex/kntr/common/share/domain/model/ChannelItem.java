package kntr.common.share.domain.model;

import java.util.ArrayList;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShareChannels.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGB\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010B{\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0087\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0012HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R&\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019¨\u0006H"}, d2 = {"Lkntr/common/share/domain/model/ChannelItem;", "", "name", "", "picture", "shareChannel", "tag", "title", "category", "level", "statusList", "Ljava/util/ArrayList;", "Lkntr/common/share/domain/model/MenuStatusItem;", "Lkotlin/collections/ArrayList;", "jumpLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicture", "setPicture", "getShareChannel$annotations", "()V", "getShareChannel", "setShareChannel", "getTag", "setTag", "getTitle", "setTitle", "getCategory", "setCategory", "getLevel", "setLevel", "getStatusList", "()Ljava/util/ArrayList;", "setStatusList", "(Ljava/util/ArrayList;)V", "getJumpLink$annotations", "getJumpLink", "setJumpLink", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_debug", "$serializer", "Companion", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ChannelItem {
    private String category;
    private String jumpLink;
    private String level;
    private String name;
    private String picture;
    private String shareChannel;
    private ArrayList<MenuStatusItem> statusList;
    private String tag;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.share.domain.model.ChannelItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ChannelItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public ChannelItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("jump_link")
    public static /* synthetic */ void getJumpLink$annotations() {
    }

    @SerialName("share_channel")
    public static /* synthetic */ void getShareChannel$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.picture;
    }

    public final String component3() {
        return this.shareChannel;
    }

    public final String component4() {
        return this.tag;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.category;
    }

    public final String component7() {
        return this.level;
    }

    public final ArrayList<MenuStatusItem> component8() {
        return this.statusList;
    }

    public final String component9() {
        return this.jumpLink;
    }

    public final ChannelItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList<MenuStatusItem> arrayList, String str8) {
        return new ChannelItem(str, str2, str3, str4, str5, str6, str7, arrayList, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChannelItem) {
            ChannelItem channelItem = (ChannelItem) obj;
            return Intrinsics.areEqual(this.name, channelItem.name) && Intrinsics.areEqual(this.picture, channelItem.picture) && Intrinsics.areEqual(this.shareChannel, channelItem.shareChannel) && Intrinsics.areEqual(this.tag, channelItem.tag) && Intrinsics.areEqual(this.title, channelItem.title) && Intrinsics.areEqual(this.category, channelItem.category) && Intrinsics.areEqual(this.level, channelItem.level) && Intrinsics.areEqual(this.statusList, channelItem.statusList) && Intrinsics.areEqual(this.jumpLink, channelItem.jumpLink);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.picture == null ? 0 : this.picture.hashCode())) * 31) + (this.shareChannel == null ? 0 : this.shareChannel.hashCode())) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.level == null ? 0 : this.level.hashCode())) * 31) + (this.statusList == null ? 0 : this.statusList.hashCode())) * 31) + (this.jumpLink != null ? this.jumpLink.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.picture;
        String str3 = this.shareChannel;
        String str4 = this.tag;
        String str5 = this.title;
        String str6 = this.category;
        String str7 = this.level;
        ArrayList<MenuStatusItem> arrayList = this.statusList;
        return "ChannelItem(name=" + str + ", picture=" + str2 + ", shareChannel=" + str3 + ", tag=" + str4 + ", title=" + str5 + ", category=" + str6 + ", level=" + str7 + ", statusList=" + arrayList + ", jumpLink=" + this.jumpLink + ")";
    }

    /* compiled from: ShareChannels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/share/domain/model/ChannelItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/share/domain/model/ChannelItem;", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ChannelItem> serializer() {
            return ChannelItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ChannelItem(int seen0, String name, String picture, String shareChannel, String tag, String title, String category, String level, ArrayList statusList, String jumpLink, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 2) == 0) {
            this.picture = null;
        } else {
            this.picture = picture;
        }
        if ((seen0 & 4) == 0) {
            this.shareChannel = null;
        } else {
            this.shareChannel = shareChannel;
        }
        if ((seen0 & 8) == 0) {
            this.tag = null;
        } else {
            this.tag = tag;
        }
        if ((seen0 & 16) == 0) {
            this.title = "";
        } else {
            this.title = title;
        }
        if ((seen0 & 32) == 0) {
            this.category = null;
        } else {
            this.category = category;
        }
        if ((seen0 & 64) == 0) {
            this.level = null;
        } else {
            this.level = level;
        }
        if ((seen0 & 128) == 0) {
            this.statusList = null;
        } else {
            this.statusList = statusList;
        }
        if ((seen0 & 256) == 0) {
            this.jumpLink = null;
        } else {
            this.jumpLink = jumpLink;
        }
    }

    public ChannelItem(String name, String picture, String shareChannel, String tag, String title, String category, String level, ArrayList<MenuStatusItem> arrayList, String jumpLink) {
        this.name = name;
        this.picture = picture;
        this.shareChannel = shareChannel;
        this.tag = tag;
        this.title = title;
        this.category = category;
        this.level = level;
        this.statusList = arrayList;
        this.jumpLink = jumpLink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MenuStatusItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$domain_debug(ChannelItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.picture != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.picture);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shareChannel != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shareChannel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tag != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.tag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.category != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.category);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.level != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.level);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.statusList != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.statusList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.jumpLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.jumpLink);
        }
    }

    public /* synthetic */ ChannelItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList arrayList, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : arrayList, (i & 256) == 0 ? str8 : null);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final String getShareChannel() {
        return this.shareChannel;
    }

    public final void setShareChannel(String str) {
        this.shareChannel = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getLevel() {
        return this.level;
    }

    public final void setLevel(String str) {
        this.level = str;
    }

    public final ArrayList<MenuStatusItem> getStatusList() {
        return this.statusList;
    }

    public final void setStatusList(ArrayList<MenuStatusItem> arrayList) {
        this.statusList = arrayList;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    public final void setJumpLink(String str) {
        this.jumpLink = str;
    }
}