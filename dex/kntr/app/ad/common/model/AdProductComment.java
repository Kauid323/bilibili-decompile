package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdProductComment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0003:;<Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010Bm\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003Jk\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u001b\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006="}, d2 = {"Lkntr/app/ad/common/model/AdProductComment;", RoomRecommendViewModel.EMPTY_CURSOR, "titleLabel", RoomRecommendViewModel.EMPTY_CURSOR, "moreLabel", "commentId", RoomRecommendViewModel.EMPTY_CURSOR, "prefixIcon", "prefixIconWidth", RoomRecommendViewModel.EMPTY_CURSOR, "prefixIconHeight", "message", "urls", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdProductComment$MessageUrl;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;IILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitleLabel", "()Ljava/lang/String;", "getMoreLabel", "getCommentId", "()J", "getPrefixIcon", "getPrefixIconWidth$annotations", "()V", "getPrefixIconWidth", "()I", "getPrefixIconHeight$annotations", "getPrefixIconHeight", "getMessage", "getUrls", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "MessageUrl", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdProductComment {
    private final long commentId;
    private final String message;
    private final String moreLabel;
    private final String prefixIcon;
    private final int prefixIconHeight;
    private final int prefixIconWidth;
    private final String titleLabel;
    private final List<MessageUrl> urls;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdProductComment$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdProductComment._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdProductComment() {
        this((String) null, (String) null, 0L, (String) null, 0, 0, (String) null, (List) null, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("prefix_icon_h")
    public static /* synthetic */ void getPrefixIconHeight$annotations() {
    }

    @SerialName("prefix_icon_w")
    public static /* synthetic */ void getPrefixIconWidth$annotations() {
    }

    public final String component1() {
        return this.titleLabel;
    }

    public final String component2() {
        return this.moreLabel;
    }

    public final long component3() {
        return this.commentId;
    }

    public final String component4() {
        return this.prefixIcon;
    }

    public final int component5() {
        return this.prefixIconWidth;
    }

    public final int component6() {
        return this.prefixIconHeight;
    }

    public final String component7() {
        return this.message;
    }

    public final List<MessageUrl> component8() {
        return this.urls;
    }

    public final AdProductComment copy(String str, String str2, long j2, String str3, int i, int i2, String str4, List<MessageUrl> list) {
        return new AdProductComment(str, str2, j2, str3, i, i2, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdProductComment) {
            AdProductComment adProductComment = (AdProductComment) obj;
            return Intrinsics.areEqual(this.titleLabel, adProductComment.titleLabel) && Intrinsics.areEqual(this.moreLabel, adProductComment.moreLabel) && this.commentId == adProductComment.commentId && Intrinsics.areEqual(this.prefixIcon, adProductComment.prefixIcon) && this.prefixIconWidth == adProductComment.prefixIconWidth && this.prefixIconHeight == adProductComment.prefixIconHeight && Intrinsics.areEqual(this.message, adProductComment.message) && Intrinsics.areEqual(this.urls, adProductComment.urls);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.titleLabel == null ? 0 : this.titleLabel.hashCode()) * 31) + (this.moreLabel == null ? 0 : this.moreLabel.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.commentId)) * 31) + (this.prefixIcon == null ? 0 : this.prefixIcon.hashCode())) * 31) + this.prefixIconWidth) * 31) + this.prefixIconHeight) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.urls != null ? this.urls.hashCode() : 0);
    }

    public String toString() {
        String str = this.titleLabel;
        String str2 = this.moreLabel;
        long j2 = this.commentId;
        String str3 = this.prefixIcon;
        int i = this.prefixIconWidth;
        int i2 = this.prefixIconHeight;
        String str4 = this.message;
        return "AdProductComment(titleLabel=" + str + ", moreLabel=" + str2 + ", commentId=" + j2 + ", prefixIcon=" + str3 + ", prefixIconWidth=" + i + ", prefixIconHeight=" + i2 + ", message=" + str4 + ", urls=" + this.urls + ")";
    }

    /* compiled from: AdProductComment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdProductComment$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdProductComment;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdProductComment> serializer() {
            return AdProductComment$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdProductComment(int seen0, String titleLabel, String moreLabel, long commentId, String prefixIcon, int prefixIconWidth, int prefixIconHeight, String message, List urls, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.titleLabel = null;
        } else {
            this.titleLabel = titleLabel;
        }
        if ((seen0 & 2) == 0) {
            this.moreLabel = null;
        } else {
            this.moreLabel = moreLabel;
        }
        if ((seen0 & 4) == 0) {
            this.commentId = 0L;
        } else {
            this.commentId = commentId;
        }
        if ((seen0 & 8) == 0) {
            this.prefixIcon = null;
        } else {
            this.prefixIcon = prefixIcon;
        }
        if ((seen0 & 16) == 0) {
            this.prefixIconWidth = 0;
        } else {
            this.prefixIconWidth = prefixIconWidth;
        }
        if ((seen0 & 32) == 0) {
            this.prefixIconHeight = 0;
        } else {
            this.prefixIconHeight = prefixIconHeight;
        }
        if ((seen0 & 64) == 0) {
            this.message = null;
        } else {
            this.message = message;
        }
        if ((seen0 & 128) == 0) {
            this.urls = null;
        } else {
            this.urls = urls;
        }
    }

    public AdProductComment(String titleLabel, String moreLabel, long commentId, String prefixIcon, int prefixIconWidth, int prefixIconHeight, String message, List<MessageUrl> list) {
        this.titleLabel = titleLabel;
        this.moreLabel = moreLabel;
        this.commentId = commentId;
        this.prefixIcon = prefixIcon;
        this.prefixIconWidth = prefixIconWidth;
        this.prefixIconHeight = prefixIconHeight;
        this.message = message;
        this.urls = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdProductComment$MessageUrl$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdProductComment self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.titleLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.titleLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.moreLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.moreLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.commentId != 0) {
            output.encodeLongElement(serialDesc, 2, self.commentId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.prefixIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.prefixIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.prefixIconWidth != 0) {
            output.encodeIntElement(serialDesc, 4, self.prefixIconWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.prefixIconHeight != 0) {
            output.encodeIntElement(serialDesc, 5, self.prefixIconHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.message != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.message);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.urls != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.urls);
        }
    }

    public /* synthetic */ AdProductComment(String str, String str2, long j2, String str3, int i, int i2, String str4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0L : j2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : str4, (i3 & 128) == 0 ? list : null);
    }

    public final String getTitleLabel() {
        return this.titleLabel;
    }

    public final String getMoreLabel() {
        return this.moreLabel;
    }

    public final long getCommentId() {
        return this.commentId;
    }

    public final String getPrefixIcon() {
        return this.prefixIcon;
    }

    public final int getPrefixIconWidth() {
        return this.prefixIconWidth;
    }

    public final int getPrefixIconHeight() {
        return this.prefixIconHeight;
    }

    public final String getMessage() {
        return this.message;
    }

    /* compiled from: AdProductComment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006*"}, d2 = {"Lkntr/app/ad/common/model/AdProductComment$MessageUrl;", RoomRecommendViewModel.EMPTY_CURSOR, "key", RoomRecommendViewModel.EMPTY_CURSOR, "text", "callupUrl", "jumpUrl", "highlightPrefixIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getText", "getCallupUrl", "getJumpUrl", "getHighlightPrefixIcon", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MessageUrl {
        public static final Companion Companion = new Companion(null);
        private final String callupUrl;
        private final String highlightPrefixIcon;
        private final String jumpUrl;
        private final String key;
        private final String text;

        public MessageUrl() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MessageUrl copy$default(MessageUrl messageUrl, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = messageUrl.key;
            }
            if ((i & 2) != 0) {
                str2 = messageUrl.text;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = messageUrl.callupUrl;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = messageUrl.jumpUrl;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = messageUrl.highlightPrefixIcon;
            }
            return messageUrl.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.text;
        }

        public final String component3() {
            return this.callupUrl;
        }

        public final String component4() {
            return this.jumpUrl;
        }

        public final String component5() {
            return this.highlightPrefixIcon;
        }

        public final MessageUrl copy(String str, String str2, String str3, String str4, String str5) {
            return new MessageUrl(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MessageUrl) {
                MessageUrl messageUrl = (MessageUrl) obj;
                return Intrinsics.areEqual(this.key, messageUrl.key) && Intrinsics.areEqual(this.text, messageUrl.text) && Intrinsics.areEqual(this.callupUrl, messageUrl.callupUrl) && Intrinsics.areEqual(this.jumpUrl, messageUrl.jumpUrl) && Intrinsics.areEqual(this.highlightPrefixIcon, messageUrl.highlightPrefixIcon);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.callupUrl == null ? 0 : this.callupUrl.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.highlightPrefixIcon != null ? this.highlightPrefixIcon.hashCode() : 0);
        }

        public String toString() {
            String str = this.key;
            String str2 = this.text;
            String str3 = this.callupUrl;
            String str4 = this.jumpUrl;
            return "MessageUrl(key=" + str + ", text=" + str2 + ", callupUrl=" + str3 + ", jumpUrl=" + str4 + ", highlightPrefixIcon=" + this.highlightPrefixIcon + ")";
        }

        /* compiled from: AdProductComment.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdProductComment$MessageUrl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdProductComment$MessageUrl;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MessageUrl> serializer() {
                return AdProductComment$MessageUrl$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MessageUrl(int seen0, String key, String text, String callupUrl, String jumpUrl, String highlightPrefixIcon, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.key = null;
            } else {
                this.key = key;
            }
            if ((seen0 & 2) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
            if ((seen0 & 4) == 0) {
                this.callupUrl = null;
            } else {
                this.callupUrl = callupUrl;
            }
            if ((seen0 & 8) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 16) == 0) {
                this.highlightPrefixIcon = null;
            } else {
                this.highlightPrefixIcon = highlightPrefixIcon;
            }
        }

        public MessageUrl(String key, String text, String callupUrl, String jumpUrl, String highlightPrefixIcon) {
            this.key = key;
            this.text = text;
            this.callupUrl = callupUrl;
            this.jumpUrl = jumpUrl;
            this.highlightPrefixIcon = highlightPrefixIcon;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(MessageUrl self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.key != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.key);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.callupUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.callupUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.highlightPrefixIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.highlightPrefixIcon);
            }
        }

        public /* synthetic */ MessageUrl(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
        }

        public final String getKey() {
            return this.key;
        }

        public final String getText() {
            return this.text;
        }

        public final String getCallupUrl() {
            return this.callupUrl;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getHighlightPrefixIcon() {
            return this.highlightPrefixIcon;
        }
    }

    public final List<MessageUrl> getUrls() {
        return this.urls;
    }
}