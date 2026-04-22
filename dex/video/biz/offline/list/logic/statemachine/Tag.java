package video.biz.offline.list.logic.statemachine;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/Tag;", "", "id", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "Complete", "Damage", "Incomplete", "Unknown", "Lvideo/biz/offline/list/logic/statemachine/Tag$Complete;", "Lvideo/biz/offline/list/logic/statemachine/Tag$Damage;", "Lvideo/biz/offline/list/logic/statemachine/Tag$Incomplete;", "Lvideo/biz/offline/list/logic/statemachine/Tag$Unknown;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class Tag {
    public static final int $stable = 0;
    private final String content;
    private final String id;

    public /* synthetic */ Tag(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private Tag(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/Tag$Complete;", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "id", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Complete extends Tag {
        public static final int $stable = 0;
        private final String content;
        private final String id;

        public Complete() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Complete copy$default(Complete complete, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = complete.id;
            }
            if ((i & 2) != 0) {
                str2 = complete.content;
            }
            return complete.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.content;
        }

        public final Complete copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "content");
            return new Complete(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Complete) {
                Complete complete = (Complete) obj;
                return Intrinsics.areEqual(this.id, complete.id) && Intrinsics.areEqual(this.content, complete.content);
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.content.hashCode();
        }

        public String toString() {
            String str = this.id;
            return "Complete(id=" + str + ", content=" + this.content + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complete(String id, String content) {
            super(id, content, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(content, "content");
            this.id = id;
            this.content = content;
        }

        public /* synthetic */ Complete(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "COMPLETE" : str, (i & 2) != 0 ? StringsKt.trim(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2219(PlayerbaseresRes.INSTANCE.getString()))).toString() : str2);
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getId() {
            return this.id;
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getContent() {
            return this.content;
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/Tag$Damage;", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "id", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Damage extends Tag {
        public static final int $stable = 0;
        private final String content;
        private final String id;

        public Damage() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Damage copy$default(Damage damage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = damage.id;
            }
            if ((i & 2) != 0) {
                str2 = damage.content;
            }
            return damage.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.content;
        }

        public final Damage copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "content");
            return new Damage(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Damage) {
                Damage damage = (Damage) obj;
                return Intrinsics.areEqual(this.id, damage.id) && Intrinsics.areEqual(this.content, damage.content);
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.content.hashCode();
        }

        public String toString() {
            String str = this.id;
            return "Damage(id=" + str + ", content=" + this.content + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Damage(String id, String content) {
            super(id, content, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(content, "content");
            this.id = id;
            this.content = content;
        }

        public /* synthetic */ Damage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "DAMAGE" : str, (i & 2) != 0 ? StringsKt.trim(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2245(PlayerbaseresRes.INSTANCE.getString()))).toString() : str2);
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getId() {
            return this.id;
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getContent() {
            return this.content;
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/Tag$Incomplete;", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "id", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Incomplete extends Tag {
        public static final int $stable = 0;
        private final String content;
        private final String id;

        public Incomplete() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Incomplete copy$default(Incomplete incomplete, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = incomplete.id;
            }
            if ((i & 2) != 0) {
                str2 = incomplete.content;
            }
            return incomplete.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.content;
        }

        public final Incomplete copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "content");
            return new Incomplete(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Incomplete) {
                Incomplete incomplete = (Incomplete) obj;
                return Intrinsics.areEqual(this.id, incomplete.id) && Intrinsics.areEqual(this.content, incomplete.content);
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.content.hashCode();
        }

        public String toString() {
            String str = this.id;
            return "Incomplete(id=" + str + ", content=" + this.content + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Incomplete(String id, String content) {
            super(id, content, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(content, "content");
            this.id = id;
            this.content = content;
        }

        public /* synthetic */ Incomplete(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "INCOMPLETE" : str, (i & 2) != 0 ? StringsKt.trim(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2188(PlayerbaseresRes.INSTANCE.getString()))).toString() : str2);
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getId() {
            return this.id;
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getContent() {
            return this.content;
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/Tag$Unknown;", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "id", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Unknown extends Tag {
        public static final int $stable = 0;
        private final String content;
        private final String id;

        public Unknown() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.id;
            }
            if ((i & 2) != 0) {
                str2 = unknown.content;
            }
            return unknown.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.content;
        }

        public final Unknown copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "content");
            return new Unknown(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unknown) {
                Unknown unknown = (Unknown) obj;
                return Intrinsics.areEqual(this.id, unknown.id) && Intrinsics.areEqual(this.content, unknown.content);
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.content.hashCode();
        }

        public String toString() {
            String str = this.id;
            return "Unknown(id=" + str + ", content=" + this.content + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unknown(String id, String content) {
            super(id, content, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(content, "content");
            this.id = id;
            this.content = content;
        }

        public /* synthetic */ Unknown(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "UNKNOWN" : str, (i & 2) != 0 ? StringsKt.trim(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_533(PlayerbaseresRes.INSTANCE.getString()))).toString() : str2);
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getId() {
            return this.id;
        }

        @Override // video.biz.offline.list.logic.statemachine.Tag
        public String getContent() {
            return this.content;
        }
    }
}