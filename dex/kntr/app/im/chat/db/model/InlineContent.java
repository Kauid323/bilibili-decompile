package kntr.app.im.chat.db.model;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* compiled from: InputBoxContent.kt */
@Lens
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002/0B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u00061"}, d2 = {"Lkntr/app/im/chat/db/model/InlineContent;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "size", "Lkntr/app/im/chat/db/model/Size;", "url", "offset", RoomRecommendViewModel.EMPTY_CURSOR, "animated", RoomRecommendViewModel.EMPTY_CURSOR, "rawText", "<init>", "(Ljava/lang/String;Lkntr/app/im/chat/db/model/Size;Ljava/lang/String;IZLjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/im/chat/db/model/Size;Ljava/lang/String;IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getSize", "()Lkntr/app/im/chat/db/model/Size;", "getUrl", "getOffset", "()I", "getAnimated", "()Z", "getRawText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$db_debug", "Companion", "$serializer", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class InlineContent {
    public static final Companion Companion = new Companion(null);
    private final boolean animated;
    private final String id;
    private final int offset;
    private final String rawText;
    private final Size size;
    private final String url;

    public static /* synthetic */ InlineContent copy$default(InlineContent inlineContent, String str, Size size, String str2, int i, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inlineContent.id;
        }
        if ((i2 & 2) != 0) {
            size = inlineContent.size;
        }
        Size size2 = size;
        if ((i2 & 4) != 0) {
            str2 = inlineContent.url;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = inlineContent.offset;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z = inlineContent.animated;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            str3 = inlineContent.rawText;
        }
        return inlineContent.copy(str, size2, str4, i3, z2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final Size component2() {
        return this.size;
    }

    public final String component3() {
        return this.url;
    }

    public final int component4() {
        return this.offset;
    }

    public final boolean component5() {
        return this.animated;
    }

    public final String component6() {
        return this.rawText;
    }

    public final InlineContent copy(String str, Size size, String str2, int i, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "rawText");
        return new InlineContent(str, size, str2, i, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineContent) {
            InlineContent inlineContent = (InlineContent) obj;
            return Intrinsics.areEqual(this.id, inlineContent.id) && Intrinsics.areEqual(this.size, inlineContent.size) && Intrinsics.areEqual(this.url, inlineContent.url) && this.offset == inlineContent.offset && this.animated == inlineContent.animated && Intrinsics.areEqual(this.rawText, inlineContent.rawText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.size.hashCode()) * 31) + this.url.hashCode()) * 31) + this.offset) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.animated)) * 31) + this.rawText.hashCode();
    }

    public String toString() {
        String str = this.id;
        Size size = this.size;
        String str2 = this.url;
        int i = this.offset;
        boolean z = this.animated;
        return "InlineContent(id=" + str + ", size=" + size + ", url=" + str2 + ", offset=" + i + ", animated=" + z + ", rawText=" + this.rawText + ")";
    }

    public /* synthetic */ InlineContent(int seen0, String id, Size size, String url, int offset, boolean animated, String rawText, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, InlineContent$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.size = size;
        this.url = url;
        this.offset = offset;
        if ((seen0 & 16) == 0) {
            this.animated = false;
        } else {
            this.animated = animated;
        }
        if ((seen0 & 32) == 0) {
            this.rawText = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.rawText = rawText;
        }
    }

    public InlineContent(String id, Size size, String url, int offset, boolean animated, String rawText) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(rawText, "rawText");
        this.id = id;
        this.size = size;
        this.url = url;
        this.offset = offset;
        this.animated = animated;
        this.rawText = rawText;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$db_debug(InlineContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, Size$$serializer.INSTANCE, self.size);
        output.encodeStringElement(serialDesc, 2, self.url);
        output.encodeIntElement(serialDesc, 3, self.offset);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.animated) {
            output.encodeBooleanElement(serialDesc, 4, self.animated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.rawText, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.rawText);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ InlineContent(String str, Size size, String str2, int i, boolean z, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, size, str2, i, r5, r6);
        boolean z2;
        String str4;
        if ((i2 & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        if ((i2 & 32) == 0) {
            str4 = str3;
        } else {
            str4 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final Size getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final String getRawText() {
        return this.rawText;
    }

    /* compiled from: InputBoxContent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/model/InlineContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/db/model/InlineContent;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<InlineContent> serializer() {
            return InlineContent$$serializer.INSTANCE;
        }
    }
}