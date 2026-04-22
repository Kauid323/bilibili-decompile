package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
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

/* compiled from: AdComment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eBe\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jh\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lkntr/app/ad/common/model/AdComment;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "userName", RoomRecommendViewModel.EMPTY_CURSOR, "userFace", "userLevel", RoomRecommendViewModel.EMPTY_CURSOR, "commentNo", "grade", "content", "upCount", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;J)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameBaseId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserName", "()Ljava/lang/String;", "getUserFace", "getUserLevel", "()I", "getCommentNo", "getGrade", "getContent", "getUpCount", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;J)Lkntr/app/ad/common/model/AdComment;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdComment {
    public static final Companion Companion = new Companion(null);
    private final String commentNo;
    private final String content;
    private final Long gameBaseId;
    private final int grade;
    private final long upCount;
    private final String userFace;
    private final int userLevel;
    private final String userName;

    public AdComment() {
        this((Long) null, (String) null, (String) null, 0, (String) null, 0, (String) null, 0L, 255, (DefaultConstructorMarker) null);
    }

    public final Long component1() {
        return this.gameBaseId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.userFace;
    }

    public final int component4() {
        return this.userLevel;
    }

    public final String component5() {
        return this.commentNo;
    }

    public final int component6() {
        return this.grade;
    }

    public final String component7() {
        return this.content;
    }

    public final long component8() {
        return this.upCount;
    }

    public final AdComment copy(Long l, String str, String str2, int i, String str3, int i2, String str4, long j2) {
        return new AdComment(l, str, str2, i, str3, i2, str4, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdComment) {
            AdComment adComment = (AdComment) obj;
            return Intrinsics.areEqual(this.gameBaseId, adComment.gameBaseId) && Intrinsics.areEqual(this.userName, adComment.userName) && Intrinsics.areEqual(this.userFace, adComment.userFace) && this.userLevel == adComment.userLevel && Intrinsics.areEqual(this.commentNo, adComment.commentNo) && this.grade == adComment.grade && Intrinsics.areEqual(this.content, adComment.content) && this.upCount == adComment.upCount;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.gameBaseId == null ? 0 : this.gameBaseId.hashCode()) * 31) + (this.userName == null ? 0 : this.userName.hashCode())) * 31) + (this.userFace == null ? 0 : this.userFace.hashCode())) * 31) + this.userLevel) * 31) + (this.commentNo == null ? 0 : this.commentNo.hashCode())) * 31) + this.grade) * 31) + (this.content != null ? this.content.hashCode() : 0)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.upCount);
    }

    public String toString() {
        Long l = this.gameBaseId;
        String str = this.userName;
        String str2 = this.userFace;
        int i = this.userLevel;
        String str3 = this.commentNo;
        int i2 = this.grade;
        String str4 = this.content;
        return "AdComment(gameBaseId=" + l + ", userName=" + str + ", userFace=" + str2 + ", userLevel=" + i + ", commentNo=" + str3 + ", grade=" + i2 + ", content=" + str4 + ", upCount=" + this.upCount + ")";
    }

    /* compiled from: AdComment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdComment$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdComment;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdComment> serializer() {
            return AdComment$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdComment(int seen0, Long gameBaseId, String userName, String userFace, int userLevel, String commentNo, int grade, String content, long upCount, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.gameBaseId = null;
        } else {
            this.gameBaseId = gameBaseId;
        }
        if ((seen0 & 2) == 0) {
            this.userName = null;
        } else {
            this.userName = userName;
        }
        if ((seen0 & 4) == 0) {
            this.userFace = null;
        } else {
            this.userFace = userFace;
        }
        if ((seen0 & 8) == 0) {
            this.userLevel = 0;
        } else {
            this.userLevel = userLevel;
        }
        if ((seen0 & 16) == 0) {
            this.commentNo = null;
        } else {
            this.commentNo = commentNo;
        }
        if ((seen0 & 32) == 0) {
            this.grade = 0;
        } else {
            this.grade = grade;
        }
        if ((seen0 & 64) == 0) {
            this.content = null;
        } else {
            this.content = content;
        }
        if ((seen0 & 128) == 0) {
            this.upCount = 0L;
        } else {
            this.upCount = upCount;
        }
    }

    public AdComment(Long gameBaseId, String userName, String userFace, int userLevel, String commentNo, int grade, String content, long upCount) {
        this.gameBaseId = gameBaseId;
        this.userName = userName;
        this.userFace = userFace;
        this.userLevel = userLevel;
        this.commentNo = commentNo;
        this.grade = grade;
        this.content = content;
        this.upCount = upCount;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdComment self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gameBaseId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.gameBaseId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.userName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.userName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.userFace != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.userFace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.userLevel != 0) {
            output.encodeIntElement(serialDesc, 3, self.userLevel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.commentNo != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.commentNo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.grade != 0) {
            output.encodeIntElement(serialDesc, 5, self.grade);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.upCount != 0) {
            output.encodeLongElement(serialDesc, 7, self.upCount);
        }
    }

    public /* synthetic */ AdComment(Long l, String str, String str2, int i, String str3, int i2, String str4, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? null : str3, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) == 0 ? str4 : null, (i3 & 128) != 0 ? 0L : j2);
    }

    public final Long getGameBaseId() {
        return this.gameBaseId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserFace() {
        return this.userFace;
    }

    public final int getUserLevel() {
        return this.userLevel;
    }

    public final String getCommentNo() {
        return this.commentNo;
    }

    public final int getGrade() {
        return this.grade;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getUpCount() {
        return this.upCount;
    }
}