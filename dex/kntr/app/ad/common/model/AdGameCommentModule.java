package kntr.app.ad.common.model;

import BottomSheetItemData$;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0003)*+B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\rHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lkntr/app/ad/common/model/AdGameCommentModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "commentNum", RoomRecommendViewModel.EMPTY_CURSOR, "showAllComment", "commentList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdGameCommentModule$Comment;", "<init>", "(ZLjava/lang/String;ZLjava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;ZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getCommentNum", "()Ljava/lang/String;", "getShowAllComment", "getCommentList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "Comment", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameCommentModule {
    private final List<Comment> commentList;
    private final String commentNum;
    private final boolean display;
    private final boolean showAllComment;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameCommentModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdGameCommentModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdGameCommentModule() {
        this(false, (String) null, false, (List) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdGameCommentModule copy$default(AdGameCommentModule adGameCommentModule, boolean z, String str, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adGameCommentModule.display;
        }
        if ((i & 2) != 0) {
            str = adGameCommentModule.commentNum;
        }
        if ((i & 4) != 0) {
            z2 = adGameCommentModule.showAllComment;
        }
        if ((i & 8) != 0) {
            list = adGameCommentModule.commentList;
        }
        return adGameCommentModule.copy(z, str, z2, list);
    }

    public final boolean component1() {
        return this.display;
    }

    public final String component2() {
        return this.commentNum;
    }

    public final boolean component3() {
        return this.showAllComment;
    }

    public final List<Comment> component4() {
        return this.commentList;
    }

    public final AdGameCommentModule copy(boolean z, String str, boolean z2, List<Comment> list) {
        return new AdGameCommentModule(z, str, z2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameCommentModule) {
            AdGameCommentModule adGameCommentModule = (AdGameCommentModule) obj;
            return this.display == adGameCommentModule.display && Intrinsics.areEqual(this.commentNum, adGameCommentModule.commentNum) && this.showAllComment == adGameCommentModule.showAllComment && Intrinsics.areEqual(this.commentList, adGameCommentModule.commentList);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + (this.commentNum == null ? 0 : this.commentNum.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showAllComment)) * 31) + (this.commentList != null ? this.commentList.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.display;
        String str = this.commentNum;
        boolean z2 = this.showAllComment;
        return "AdGameCommentModule(display=" + z + ", commentNum=" + str + ", showAllComment=" + z2 + ", commentList=" + this.commentList + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameCommentModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameCommentModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameCommentModule> serializer() {
            return AdGameCommentModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameCommentModule(int seen0, boolean display, String commentNum, boolean showAllComment, List commentList, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = false;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.commentNum = null;
        } else {
            this.commentNum = commentNum;
        }
        if ((seen0 & 4) == 0) {
            this.showAllComment = false;
        } else {
            this.showAllComment = showAllComment;
        }
        if ((seen0 & 8) == 0) {
            this.commentList = null;
        } else {
            this.commentList = commentList;
        }
    }

    public AdGameCommentModule(boolean display, String commentNum, boolean showAllComment, List<Comment> list) {
        this.display = display;
        this.commentNum = commentNum;
        this.showAllComment = showAllComment;
        this.commentList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdGameCommentModule$Comment$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameCommentModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.commentNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.commentNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.showAllComment) {
            output.encodeBooleanElement(serialDesc, 2, self.showAllComment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.commentList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.commentList);
        }
    }

    public /* synthetic */ AdGameCommentModule(boolean z, String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : list);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final String getCommentNum() {
        return this.commentNum;
    }

    public final boolean getShowAllComment() {
        return this.showAllComment;
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDBa\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eBe\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003Jh\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\bHÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006E"}, d2 = {"Lkntr/app/ad/common/model/AdGameCommentModule$Comment;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "userName", RoomRecommendViewModel.EMPTY_CURSOR, "userFace", "userLevel", RoomRecommendViewModel.EMPTY_CURSOR, "commentNo", "grade", "content", "upCount", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;J)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameBaseId", "()Ljava/lang/Long;", "setGameBaseId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "getUserFace", "setUserFace", "getUserLevel", "()I", "setUserLevel", "(I)V", "getCommentNo", "setCommentNo", "getGrade", "setGrade", "getContent", "setContent", "getUpCount", "()J", "setUpCount", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;J)Lkntr/app/ad/common/model/AdGameCommentModule$Comment;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Comment {
        public static final Companion Companion = new Companion(null);
        private String commentNo;
        private String content;
        private Long gameBaseId;
        private int grade;
        private long upCount;
        private String userFace;
        private int userLevel;
        private String userName;

        public Comment() {
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

        public final Comment copy(Long l, String str, String str2, int i, String str3, int i2, String str4, long j2) {
            return new Comment(l, str, str2, i, str3, i2, str4, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Comment) {
                Comment comment = (Comment) obj;
                return Intrinsics.areEqual(this.gameBaseId, comment.gameBaseId) && Intrinsics.areEqual(this.userName, comment.userName) && Intrinsics.areEqual(this.userFace, comment.userFace) && this.userLevel == comment.userLevel && Intrinsics.areEqual(this.commentNo, comment.commentNo) && this.grade == comment.grade && Intrinsics.areEqual(this.content, comment.content) && this.upCount == comment.upCount;
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
            return "Comment(gameBaseId=" + l + ", userName=" + str + ", userFace=" + str2 + ", userLevel=" + i + ", commentNo=" + str3 + ", grade=" + i2 + ", content=" + str4 + ", upCount=" + this.upCount + ")";
        }

        /* compiled from: AdAndroidGameInfo.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameCommentModule$Comment$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameCommentModule$Comment;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Comment> serializer() {
                return AdGameCommentModule$Comment$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Comment(int seen0, Long gameBaseId, String userName, String userFace, int userLevel, String commentNo, int grade, String content, long upCount, SerializationConstructorMarker serializationConstructorMarker) {
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

        public Comment(Long gameBaseId, String userName, String userFace, int userLevel, String commentNo, int grade, String content, long upCount) {
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
        public static final /* synthetic */ void write$Self$dto_debug(Comment self, CompositeEncoder output, SerialDescriptor serialDesc) {
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

        public /* synthetic */ Comment(Long l, String str, String str2, int i, String str3, int i2, String str4, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : l, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? null : str3, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) == 0 ? str4 : null, (i3 & 128) != 0 ? 0L : j2);
        }

        public final Long getGameBaseId() {
            return this.gameBaseId;
        }

        public final void setGameBaseId(Long l) {
            this.gameBaseId = l;
        }

        public final String getUserName() {
            return this.userName;
        }

        public final void setUserName(String str) {
            this.userName = str;
        }

        public final String getUserFace() {
            return this.userFace;
        }

        public final void setUserFace(String str) {
            this.userFace = str;
        }

        public final int getUserLevel() {
            return this.userLevel;
        }

        public final void setUserLevel(int i) {
            this.userLevel = i;
        }

        public final String getCommentNo() {
            return this.commentNo;
        }

        public final void setCommentNo(String str) {
            this.commentNo = str;
        }

        public final int getGrade() {
            return this.grade;
        }

        public final void setGrade(int i) {
            this.grade = i;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final long getUpCount() {
            return this.upCount;
        }

        public final void setUpCount(long j2) {
            this.upCount = j2;
        }
    }

    public final List<Comment> getCommentList() {
        return this.commentList;
    }
}