package im.session.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble$;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bilibili.blens.Lens;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J/\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0007\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006."}, d2 = {"Lim/session/model/IMQuickLink;", "", "items", "", "Lim/session/model/IMQuickLinkItem;", "bubble", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "isLegacyStyle", "", "<init>", "(Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItems$annotations", "()V", "getItems", "()Ljava/util/List;", "getBubble$annotations", "getBubble", "()Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "isLegacyStyle$annotations", "()Z", "hasHuaHuo", "getHasHuaHuo", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "Companion", "$serializer", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
@Lens
public final class IMQuickLink {
    private final KQuickLinkBubble bubble;
    private final boolean isLegacyStyle;
    private final List<IMQuickLinkItem> items;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMQuickLink$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMQuickLink._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMQuickLink copy$default(IMQuickLink iMQuickLink, List list, KQuickLinkBubble kQuickLinkBubble, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = iMQuickLink.items;
        }
        if ((i2 & 2) != 0) {
            kQuickLinkBubble = iMQuickLink.bubble;
        }
        if ((i2 & 4) != 0) {
            z = iMQuickLink.isLegacyStyle;
        }
        return iMQuickLink.copy(list, kQuickLinkBubble, z);
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getBubble$annotations() {
    }

    @ProtoNumber(number = 1)
    @ProtoPacked
    public static /* synthetic */ void getItems$annotations() {
    }

    @ProtoNumber(number = 3)
    public static /* synthetic */ void isLegacyStyle$annotations() {
    }

    public final List<IMQuickLinkItem> component1() {
        return this.items;
    }

    public final KQuickLinkBubble component2() {
        return this.bubble;
    }

    public final boolean component3() {
        return this.isLegacyStyle;
    }

    public final IMQuickLink copy(List<IMQuickLinkItem> list, KQuickLinkBubble kQuickLinkBubble, boolean z) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new IMQuickLink(list, kQuickLinkBubble, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMQuickLink) {
            IMQuickLink iMQuickLink = (IMQuickLink) obj;
            return Intrinsics.areEqual(this.items, iMQuickLink.items) && Intrinsics.areEqual(this.bubble, iMQuickLink.bubble) && this.isLegacyStyle == iMQuickLink.isLegacyStyle;
        }
        return false;
    }

    public int hashCode() {
        return (((this.items.hashCode() * 31) + (this.bubble == null ? 0 : this.bubble.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLegacyStyle);
    }

    public String toString() {
        List<IMQuickLinkItem> list = this.items;
        KQuickLinkBubble kQuickLinkBubble = this.bubble;
        return "IMQuickLink(items=" + list + ", bubble=" + kQuickLinkBubble + ", isLegacyStyle=" + this.isLegacyStyle + ")";
    }

    public /* synthetic */ IMQuickLink(int seen0, List items, KQuickLinkBubble bubble, boolean isLegacyStyle, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, IMQuickLink$$serializer.INSTANCE.getDescriptor());
        }
        this.items = items;
        this.bubble = bubble;
        if ((seen0 & 4) == 0) {
            this.isLegacyStyle = false;
        } else {
            this.isLegacyStyle = isLegacyStyle;
        }
    }

    public IMQuickLink(List<IMQuickLinkItem> list, KQuickLinkBubble bubble, boolean isLegacyStyle) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.bubble = bubble;
        this.isLegacyStyle = isLegacyStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IMQuickLinkItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMQuickLink self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.items);
        output.encodeNullableSerializableElement(serialDesc, 1, KQuickLinkBubble$.serializer.INSTANCE, self.bubble);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isLegacyStyle) {
            output.encodeBooleanElement(serialDesc, 2, self.isLegacyStyle);
        }
    }

    public /* synthetic */ IMQuickLink(List list, KQuickLinkBubble kQuickLinkBubble, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, kQuickLinkBubble, (i2 & 4) != 0 ? false : z);
    }

    public final List<IMQuickLinkItem> getItems() {
        return this.items;
    }

    public final KQuickLinkBubble getBubble() {
        return this.bubble;
    }

    public final boolean isLegacyStyle() {
        return this.isLegacyStyle;
    }

    /* compiled from: IMQuickLink.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMQuickLink$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMQuickLink;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMQuickLink> serializer() {
            return IMQuickLink$$serializer.INSTANCE;
        }
    }

    public final boolean getHasHuaHuo() {
        Iterable $this$any$iv = this.items;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            IMQuickLinkItem it = (IMQuickLinkItem) element$iv;
            if (Intrinsics.areEqual(it.getType(), KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_HUA_HUO.INSTANCE)) {
                return true;
            }
        }
        return false;
    }
}