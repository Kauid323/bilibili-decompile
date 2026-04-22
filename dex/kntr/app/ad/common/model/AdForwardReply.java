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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdForwardReply.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fBs\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jx\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u0006;"}, d2 = {"Lkntr/app/ad/common/model/AdForwardReply;", RoomRecommendViewModel.EMPTY_CURSOR, "commentId", RoomRecommendViewModel.EMPTY_CURSOR, "message", RoomRecommendViewModel.EMPTY_CURSOR, "highlightText", "highlightPrefixIcon", "callupUrl", "jumpUrl", "jumpType", RoomRecommendViewModel.EMPTY_CURSOR, "authorName", "authorIcon", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCommentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Ljava/lang/String;", "getHighlightText", "getHighlightPrefixIcon", "getCallupUrl", "getJumpUrl", "getJumpType", "()I", "getAuthorName", "getAuthorIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lkntr/app/ad/common/model/AdForwardReply;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdForwardReply {
    public static final Companion Companion = new Companion(null);
    private final String authorIcon;
    private final String authorName;
    private final String callupUrl;
    private final Long commentId;
    private final String highlightPrefixIcon;
    private final String highlightText;
    private final int jumpType;
    private final String jumpUrl;
    private final String message;

    public AdForwardReply() {
        this((Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public final Long component1() {
        return this.commentId;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.highlightText;
    }

    public final String component4() {
        return this.highlightPrefixIcon;
    }

    public final String component5() {
        return this.callupUrl;
    }

    public final String component6() {
        return this.jumpUrl;
    }

    public final int component7() {
        return this.jumpType;
    }

    public final String component8() {
        return this.authorName;
    }

    public final String component9() {
        return this.authorIcon;
    }

    public final AdForwardReply copy(Long l, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        return new AdForwardReply(l, str, str2, str3, str4, str5, i, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdForwardReply) {
            AdForwardReply adForwardReply = (AdForwardReply) obj;
            return Intrinsics.areEqual(this.commentId, adForwardReply.commentId) && Intrinsics.areEqual(this.message, adForwardReply.message) && Intrinsics.areEqual(this.highlightText, adForwardReply.highlightText) && Intrinsics.areEqual(this.highlightPrefixIcon, adForwardReply.highlightPrefixIcon) && Intrinsics.areEqual(this.callupUrl, adForwardReply.callupUrl) && Intrinsics.areEqual(this.jumpUrl, adForwardReply.jumpUrl) && this.jumpType == adForwardReply.jumpType && Intrinsics.areEqual(this.authorName, adForwardReply.authorName) && Intrinsics.areEqual(this.authorIcon, adForwardReply.authorIcon);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.commentId == null ? 0 : this.commentId.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.highlightText == null ? 0 : this.highlightText.hashCode())) * 31) + (this.highlightPrefixIcon == null ? 0 : this.highlightPrefixIcon.hashCode())) * 31) + (this.callupUrl == null ? 0 : this.callupUrl.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + this.jumpType) * 31) + (this.authorName == null ? 0 : this.authorName.hashCode())) * 31) + (this.authorIcon != null ? this.authorIcon.hashCode() : 0);
    }

    public String toString() {
        Long l = this.commentId;
        String str = this.message;
        String str2 = this.highlightText;
        String str3 = this.highlightPrefixIcon;
        String str4 = this.callupUrl;
        String str5 = this.jumpUrl;
        int i = this.jumpType;
        String str6 = this.authorName;
        return "AdForwardReply(commentId=" + l + ", message=" + str + ", highlightText=" + str2 + ", highlightPrefixIcon=" + str3 + ", callupUrl=" + str4 + ", jumpUrl=" + str5 + ", jumpType=" + i + ", authorName=" + str6 + ", authorIcon=" + this.authorIcon + ")";
    }

    /* compiled from: AdForwardReply.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdForwardReply$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdForwardReply;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdForwardReply> serializer() {
            return AdForwardReply$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdForwardReply(int seen0, Long commentId, String message, String highlightText, String highlightPrefixIcon, String callupUrl, String jumpUrl, int jumpType, String authorName, String authorIcon, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.commentId = null;
        } else {
            this.commentId = commentId;
        }
        if ((seen0 & 2) == 0) {
            this.message = null;
        } else {
            this.message = message;
        }
        if ((seen0 & 4) == 0) {
            this.highlightText = null;
        } else {
            this.highlightText = highlightText;
        }
        if ((seen0 & 8) == 0) {
            this.highlightPrefixIcon = null;
        } else {
            this.highlightPrefixIcon = highlightPrefixIcon;
        }
        if ((seen0 & 16) == 0) {
            this.callupUrl = null;
        } else {
            this.callupUrl = callupUrl;
        }
        if ((seen0 & 32) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 64) == 0) {
            this.jumpType = 0;
        } else {
            this.jumpType = jumpType;
        }
        if ((seen0 & 128) == 0) {
            this.authorName = null;
        } else {
            this.authorName = authorName;
        }
        if ((seen0 & 256) == 0) {
            this.authorIcon = null;
        } else {
            this.authorIcon = authorIcon;
        }
    }

    public AdForwardReply(Long commentId, String message, String highlightText, String highlightPrefixIcon, String callupUrl, String jumpUrl, int jumpType, String authorName, String authorIcon) {
        this.commentId = commentId;
        this.message = message;
        this.highlightText = highlightText;
        this.highlightPrefixIcon = highlightPrefixIcon;
        this.callupUrl = callupUrl;
        this.jumpUrl = jumpUrl;
        this.jumpType = jumpType;
        this.authorName = authorName;
        this.authorIcon = authorIcon;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdForwardReply self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.commentId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.commentId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.message != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.message);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.highlightText != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.highlightText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.highlightPrefixIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.highlightPrefixIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.callupUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.callupUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.jumpType != 0) {
            output.encodeIntElement(serialDesc, 6, self.jumpType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.authorName != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.authorName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.authorIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.authorIcon);
        }
    }

    public /* synthetic */ AdForwardReply(Long l, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? null : str6, (i2 & 256) == 0 ? str7 : null);
    }

    public final Long getCommentId() {
        return this.commentId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getHighlightText() {
        return this.highlightText;
    }

    public final String getHighlightPrefixIcon() {
        return this.highlightPrefixIcon;
    }

    public final String getCallupUrl() {
        return this.callupUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAuthorIcon() {
        return this.authorIcon;
    }
}