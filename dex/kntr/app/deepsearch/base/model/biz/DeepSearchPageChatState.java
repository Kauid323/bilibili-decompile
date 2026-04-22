package kntr.app.deepsearch.base.model.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPageChatState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", RoomRecommendViewModel.EMPTY_CURSOR, "desc", RoomRecommendViewModel.EMPTY_CURSOR, "getDesc$annotations", "()V", "getDesc", "()Ljava/lang/String;", "queryId", "getQueryId", "avatarAnimated", RoomRecommendViewModel.EMPTY_CURSOR, "currentQueryId", "None", "Thinking", "Answering", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$Answering;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$None;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$Thinking;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchPageChatState {
    boolean avatarAnimated(String str);

    String getDesc();

    String getQueryId();

    /* compiled from: DeepSearchPageChatState.kt */
    /* renamed from: kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$avatarAnimated(DeepSearchPageChatState _this, String currentQueryId) {
            Intrinsics.checkNotNullParameter(currentQueryId, "currentQueryId");
            return false;
        }
    }

    /* compiled from: DeepSearchPageChatState.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDesc$annotations() {
        }

        @Deprecated
        public static boolean avatarAnimated(DeepSearchPageChatState $this, String currentQueryId) {
            Intrinsics.checkNotNullParameter(currentQueryId, "currentQueryId");
            return CC.$default$avatarAnimated($this, currentQueryId);
        }
    }

    /* compiled from: DeepSearchPageChatState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$None;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class None implements DeepSearchPageChatState {
        private final String desc;
        private final String queryId;

        public None() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ None copy$default(None none, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = none.desc;
            }
            if ((i & 2) != 0) {
                str2 = none.queryId;
            }
            return none.copy(str, str2);
        }

        public final String component1() {
            return this.desc;
        }

        public final String component2() {
            return this.queryId;
        }

        public final None copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(str2, "queryId");
            return new None(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof None) {
                None none = (None) obj;
                return Intrinsics.areEqual(this.desc, none.desc) && Intrinsics.areEqual(this.queryId, none.queryId);
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.queryId.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "None(desc=" + str + ", queryId=" + this.queryId + ")";
        }

        public None(String desc, String queryId) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.desc = desc;
            this.queryId = queryId;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public /* bridge */ boolean avatarAnimated(String currentQueryId) {
            return CC.$default$avatarAnimated(this, currentQueryId);
        }

        public /* synthetic */ None(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getQueryId() {
            return this.queryId;
        }
    }

    /* compiled from: DeepSearchPageChatState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$Thinking;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getQueryId", "avatarAnimated", RoomRecommendViewModel.EMPTY_CURSOR, "currentQueryId", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Thinking implements DeepSearchPageChatState {
        private final String desc;
        private final String queryId;

        public Thinking() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Thinking copy$default(Thinking thinking, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = thinking.desc;
            }
            if ((i & 2) != 0) {
                str2 = thinking.queryId;
            }
            return thinking.copy(str, str2);
        }

        public final String component1() {
            return this.desc;
        }

        public final String component2() {
            return this.queryId;
        }

        public final Thinking copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(str2, "queryId");
            return new Thinking(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Thinking) {
                Thinking thinking = (Thinking) obj;
                return Intrinsics.areEqual(this.desc, thinking.desc) && Intrinsics.areEqual(this.queryId, thinking.queryId);
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.queryId.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Thinking(desc=" + str + ", queryId=" + this.queryId + ")";
        }

        public Thinking(String desc, String queryId) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.desc = desc;
            this.queryId = queryId;
        }

        public /* synthetic */ Thinking(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getQueryId() {
            return this.queryId;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public boolean avatarAnimated(String currentQueryId) {
            Intrinsics.checkNotNullParameter(currentQueryId, "currentQueryId");
            return Intrinsics.areEqual(getQueryId(), currentQueryId);
        }
    }

    /* compiled from: DeepSearchPageChatState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState$Answering;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getQueryId", "avatarAnimated", RoomRecommendViewModel.EMPTY_CURSOR, "currentQueryId", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Answering implements DeepSearchPageChatState {
        private final String desc;
        private final String queryId;

        public Answering() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Answering copy$default(Answering answering, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answering.desc;
            }
            if ((i & 2) != 0) {
                str2 = answering.queryId;
            }
            return answering.copy(str, str2);
        }

        public final String component1() {
            return this.desc;
        }

        public final String component2() {
            return this.queryId;
        }

        public final Answering copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(str2, "queryId");
            return new Answering(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Answering) {
                Answering answering = (Answering) obj;
                return Intrinsics.areEqual(this.desc, answering.desc) && Intrinsics.areEqual(this.queryId, answering.queryId);
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.queryId.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Answering(desc=" + str + ", queryId=" + this.queryId + ")";
        }

        public Answering(String desc, String queryId) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.desc = desc;
            this.queryId = queryId;
        }

        public /* synthetic */ Answering(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public String getQueryId() {
            return this.queryId;
        }

        @Override // kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState
        public boolean avatarAnimated(String currentQueryId) {
            Intrinsics.checkNotNullParameter(currentQueryId, "currentQueryId");
            return Intrinsics.areEqual(getQueryId(), currentQueryId);
        }
    }
}