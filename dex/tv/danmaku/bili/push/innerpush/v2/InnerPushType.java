package tv.danmaku.bili.push.innerpush.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;

/* compiled from: InnerPushTaskManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0004\u000e\u000f\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "", "type", "", "getType", "()Ljava/lang/String;", "cacheTime", "", "getCacheTime", "()J", "HighLevel", "Normal", "BizType", "Empty", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$BizType;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$Empty;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$HighLevel;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$Normal;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface InnerPushType {
    long getCacheTime();

    String getType();

    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$HighLevel;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "cacheTime", "", "getCacheTime", "()J", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HighLevel implements InnerPushType {
        public static final int $stable = 0;
        public static final HighLevel INSTANCE = new HighLevel();
        private static final String type = "HighLevel";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HighLevel) {
                HighLevel highLevel = (HighLevel) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -226908897;
        }

        public String toString() {
            return "HighLevel";
        }

        private HighLevel() {
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public String getType() {
            return type;
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public long getCacheTime() {
            return 0L;
        }
    }

    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$Normal;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "cacheTime", "", "getCacheTime", "()J", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Normal implements InnerPushType {
        public static final int $stable = 0;
        public static final Normal INSTANCE = new Normal();
        private static final String type = "Normal";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Normal) {
                Normal normal = (Normal) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1661102102;
        }

        public String toString() {
            return "Normal";
        }

        private Normal() {
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public String getType() {
            return type;
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public long getCacheTime() {
            return InnerPushLocalStorage.INSTANCE.loadInnerPushConfig().getDisplayInterval();
        }
    }

    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$BizType;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "bizType", "", "<init>", "(Ljava/lang/String;)V", "getBizType", "()Ljava/lang/String;", "type", "getType", "cacheTime", "", "getCacheTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class BizType implements InnerPushType {
        public static final int $stable = 0;
        private final String bizType;
        private final String type;

        public static /* synthetic */ BizType copy$default(BizType bizType, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bizType.bizType;
            }
            return bizType.copy(str);
        }

        public final String component1() {
            return this.bizType;
        }

        public final BizType copy(String str) {
            Intrinsics.checkNotNullParameter(str, "bizType");
            return new BizType(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BizType) && Intrinsics.areEqual(this.bizType, ((BizType) obj).bizType);
        }

        public int hashCode() {
            return this.bizType.hashCode();
        }

        public String toString() {
            return "BizType(bizType=" + this.bizType + ")";
        }

        public BizType(String bizType) {
            Intrinsics.checkNotNullParameter(bizType, "bizType");
            this.bizType = bizType;
            this.type = "BizTask";
        }

        public final String getBizType() {
            return this.bizType;
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public String getType() {
            return this.type;
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public long getCacheTime() {
            return 0L;
        }
    }

    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushType$Empty;", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "cacheTime", "", "getCacheTime", "()J", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Empty implements InnerPushType {
        public static final int $stable = 0;
        public static final Empty INSTANCE = new Empty();
        private static final String type = "Empty";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 215137770;
        }

        public String toString() {
            return "Empty";
        }

        private Empty() {
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public String getType() {
            return type;
        }

        @Override // tv.danmaku.bili.push.innerpush.v2.InnerPushType
        public long getCacheTime() {
            return 0L;
        }
    }
}