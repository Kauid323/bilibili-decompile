package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.adapter.EnumWithJsonValue;
import com.bilibili.bson.common.Bson;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCCardRewardModel.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/ActionVo;", "", "type", "Ltv/danmaku/bili/ui/garb/nft/model/ActionVo$Type;", "value", "", "<init>", "(Ltv/danmaku/bili/ui/garb/nft/model/ActionVo$Type;Ljava/lang/String;)V", "getType", "()Ltv/danmaku/bili/ui/garb/nft/model/ActionVo$Type;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Type", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActionVo {
    public static final int $stable = 0;
    private final Type type;
    private final String value;

    public static /* synthetic */ ActionVo copy$default(ActionVo actionVo, Type type, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            type = actionVo.type;
        }
        if ((i & 2) != 0) {
            str = actionVo.value;
        }
        return actionVo.copy(type, str);
    }

    public final Type component1() {
        return this.type;
    }

    public final String component2() {
        return this.value;
    }

    public final ActionVo copy(Type type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        return new ActionVo(type, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionVo) {
            ActionVo actionVo = (ActionVo) obj;
            return this.type == actionVo.type && Intrinsics.areEqual(this.value, actionVo.value);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        Type type = this.type;
        return "ActionVo(type=" + type + ", value=" + this.value + ")";
    }

    public ActionVo(Type type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
    }

    public /* synthetic */ ActionVo(Type type, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Type.LINK : type, str);
    }

    public final Type getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: DLCCardRewardModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/ActionVo$Type;", "Lcom/bilibili/bson/adapter/EnumWithJsonValue;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "getValue", "()Ljava/lang/Integer;", "LINK", "TOAST", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum Type implements EnumWithJsonValue<Integer> {
        LINK(1),
        TOAST(2);
        
        private final int value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(int value) {
            this.value = value;
        }

        /* renamed from: getValue */
        public Integer m1774getValue() {
            return Integer.valueOf(this.value);
        }
    }
}