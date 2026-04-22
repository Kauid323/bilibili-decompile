package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemTypeSerializer;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnread$;
import com.bilibili.blens.Lens;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMQuickLink.kt */
@Lens
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000267BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003JG\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000eHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!¨\u00068"}, d2 = {"Lim/session/model/IMQuickLinkItem;", "", "title", "", "url", "icon", "iconForNight", "unread", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "type", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KUnread;Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KUnread;Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getUrl$annotations", "getUrl", "getIcon$annotations", "getIcon", "getIconForNight$annotations", "getIconForNight", "getUnread$annotations", "getUnread", "()Lcom/bapis/bilibili/app/im/v1/KUnread;", "getType$annotations", "getType", "()Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "Companion", "$serializer", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMQuickLinkItem {
    public static final Companion Companion = new Companion(null);
    private final String icon;
    private final String iconForNight;
    private final String title;
    private final KQuickLinkItemType type;
    private final KUnread unread;
    private final String url;

    public static /* synthetic */ IMQuickLinkItem copy$default(IMQuickLinkItem iMQuickLinkItem, String str, String str2, String str3, String str4, KUnread kUnread, KQuickLinkItemType kQuickLinkItemType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iMQuickLinkItem.title;
        }
        if ((i2 & 2) != 0) {
            str2 = iMQuickLinkItem.url;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = iMQuickLinkItem.icon;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = iMQuickLinkItem.iconForNight;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            kUnread = iMQuickLinkItem.unread;
        }
        KUnread kUnread2 = kUnread;
        if ((i2 & 32) != 0) {
            kQuickLinkItemType = iMQuickLinkItem.type;
        }
        return iMQuickLinkItem.copy(str, str5, str6, str7, kUnread2, kQuickLinkItemType);
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getIcon$annotations() {
    }

    @ProtoNumber(number = 3)
    public static /* synthetic */ void getIconForNight$annotations() {
    }

    @ProtoNumber(number = 1)
    public static /* synthetic */ void getTitle$annotations() {
    }

    @ProtoNumber(number = 6)
    public static /* synthetic */ void getType$annotations() {
    }

    @ProtoNumber(number = 5)
    public static /* synthetic */ void getUnread$annotations() {
    }

    @ProtoNumber(number = 4)
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.iconForNight;
    }

    public final KUnread component5() {
        return this.unread;
    }

    public final KQuickLinkItemType component6() {
        return this.type;
    }

    public final IMQuickLinkItem copy(String str, String str2, String str3, String str4, KUnread kUnread, KQuickLinkItemType kQuickLinkItemType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "icon");
        Intrinsics.checkNotNullParameter(str4, "iconForNight");
        Intrinsics.checkNotNullParameter(kQuickLinkItemType, "type");
        return new IMQuickLinkItem(str, str2, str3, str4, kUnread, kQuickLinkItemType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMQuickLinkItem) {
            IMQuickLinkItem iMQuickLinkItem = (IMQuickLinkItem) obj;
            return Intrinsics.areEqual(this.title, iMQuickLinkItem.title) && Intrinsics.areEqual(this.url, iMQuickLinkItem.url) && Intrinsics.areEqual(this.icon, iMQuickLinkItem.icon) && Intrinsics.areEqual(this.iconForNight, iMQuickLinkItem.iconForNight) && Intrinsics.areEqual(this.unread, iMQuickLinkItem.unread) && Intrinsics.areEqual(this.type, iMQuickLinkItem.type);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.url.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.iconForNight.hashCode()) * 31) + (this.unread == null ? 0 : this.unread.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.url;
        String str3 = this.icon;
        String str4 = this.iconForNight;
        KUnread kUnread = this.unread;
        return "IMQuickLinkItem(title=" + str + ", url=" + str2 + ", icon=" + str3 + ", iconForNight=" + str4 + ", unread=" + kUnread + ", type=" + this.type + ")";
    }

    public /* synthetic */ IMQuickLinkItem(int seen0, String title, String url, String icon, String iconForNight, KUnread unread, KQuickLinkItemType type, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, IMQuickLinkItem$$serializer.INSTANCE.getDescriptor());
        }
        this.title = title;
        if ((seen0 & 2) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen0 & 4) == 0) {
            this.icon = "";
        } else {
            this.icon = icon;
        }
        if ((seen0 & 8) == 0) {
            this.iconForNight = "";
        } else {
            this.iconForNight = iconForNight;
        }
        if ((seen0 & 16) == 0) {
            this.unread = null;
        } else {
            this.unread = unread;
        }
        if ((seen0 & 32) == 0) {
            this.type = KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_UNKNOWN.INSTANCE;
        } else {
            this.type = type;
        }
    }

    public IMQuickLinkItem(String title, String url, String icon, String iconForNight, KUnread unread, KQuickLinkItemType type) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(iconForNight, "iconForNight");
        Intrinsics.checkNotNullParameter(type, "type");
        this.title = title;
        this.url = url;
        this.icon = icon;
        this.iconForNight = iconForNight;
        this.unread = unread;
        this.type = type;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMQuickLinkItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.title);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.url, "")) {
            output.encodeStringElement(serialDesc, 1, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.icon, "")) {
            output.encodeStringElement(serialDesc, 2, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.iconForNight, "")) {
            output.encodeStringElement(serialDesc, 3, self.iconForNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.unread != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, KUnread$.serializer.INSTANCE, self.unread);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.type, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_UNKNOWN.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 5, KQuickLinkItemTypeSerializer.INSTANCE, self.type);
        }
    }

    public /* synthetic */ IMQuickLinkItem(String str, String str2, String str3, String str4, KUnread kUnread, KQuickLinkItemType kQuickLinkItemType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? null : kUnread, (i2 & 32) != 0 ? (KQuickLinkItemType) KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_UNKNOWN.INSTANCE : kQuickLinkItemType);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconForNight() {
        return this.iconForNight;
    }

    public final KUnread getUnread() {
        return this.unread;
    }

    public final KQuickLinkItemType getType() {
        return this.type;
    }

    /* compiled from: IMQuickLink.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMQuickLinkItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMQuickLinkItem;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMQuickLinkItem> serializer() {
            return IMQuickLinkItem$$serializer.INSTANCE;
        }
    }
}