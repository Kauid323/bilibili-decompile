package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.ui.unit.Constraints;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandableTextParagraph.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0013JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;", RoomRecommendViewModel.EMPTY_CURSOR, "collapseLineCount", RoomRecommendViewModel.EMPTY_CURSOR, "toExpand", RoomRecommendViewModel.EMPTY_CURSOR, "toCollapse", "ellipsis", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCollapseLineCount", "()I", "getToExpand", "()Ljava/lang/String;", "getToCollapse", "getEllipsis", "getConstraints-msEJaDk", "()J", "J", "component1", "component2", "component3", "component4", "component5", "component5-msEJaDk", "copy", "copy-X9ElhV4", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpandableTextConfig {
    public static final int $stable = 0;
    private final int collapseLineCount;
    private final long constraints;
    private final String ellipsis;
    private final String toCollapse;
    private final String toExpand;

    public /* synthetic */ ExpandableTextConfig(int i, String str, String str2, String str3, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, j2);
    }

    /* renamed from: copy-X9ElhV4$default  reason: not valid java name */
    public static /* synthetic */ ExpandableTextConfig m1831copyX9ElhV4$default(ExpandableTextConfig expandableTextConfig, int i, String str, String str2, String str3, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = expandableTextConfig.collapseLineCount;
        }
        if ((i2 & 2) != 0) {
            str = expandableTextConfig.toExpand;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = expandableTextConfig.toCollapse;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = expandableTextConfig.ellipsis;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            j2 = expandableTextConfig.constraints;
        }
        return expandableTextConfig.m1833copyX9ElhV4(i, str4, str5, str6, j2);
    }

    public final int component1() {
        return this.collapseLineCount;
    }

    public final String component2() {
        return this.toExpand;
    }

    public final String component3() {
        return this.toCollapse;
    }

    public final String component4() {
        return this.ellipsis;
    }

    /* renamed from: component5-msEJaDk  reason: not valid java name */
    public final long m1832component5msEJaDk() {
        return this.constraints;
    }

    /* renamed from: copy-X9ElhV4  reason: not valid java name */
    public final ExpandableTextConfig m1833copyX9ElhV4(int i, String str, String str2, String str3, long j2) {
        Intrinsics.checkNotNullParameter(str, "toExpand");
        Intrinsics.checkNotNullParameter(str2, "toCollapse");
        Intrinsics.checkNotNullParameter(str3, "ellipsis");
        return new ExpandableTextConfig(i, str, str2, str3, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExpandableTextConfig) {
            ExpandableTextConfig expandableTextConfig = (ExpandableTextConfig) obj;
            return this.collapseLineCount == expandableTextConfig.collapseLineCount && Intrinsics.areEqual(this.toExpand, expandableTextConfig.toExpand) && Intrinsics.areEqual(this.toCollapse, expandableTextConfig.toCollapse) && Intrinsics.areEqual(this.ellipsis, expandableTextConfig.ellipsis) && Constraints.equals-impl0(this.constraints, expandableTextConfig.constraints);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.collapseLineCount * 31) + this.toExpand.hashCode()) * 31) + this.toCollapse.hashCode()) * 31) + this.ellipsis.hashCode()) * 31) + Constraints.hashCode-impl(this.constraints);
    }

    public String toString() {
        int i = this.collapseLineCount;
        String str = this.toExpand;
        String str2 = this.toCollapse;
        String str3 = this.ellipsis;
        return "ExpandableTextConfig(collapseLineCount=" + i + ", toExpand=" + str + ", toCollapse=" + str2 + ", ellipsis=" + str3 + ", constraints=" + Constraints.toString-impl(this.constraints) + ")";
    }

    private ExpandableTextConfig(int collapseLineCount, String toExpand, String toCollapse, String ellipsis, long constraints) {
        Intrinsics.checkNotNullParameter(toExpand, "toExpand");
        Intrinsics.checkNotNullParameter(toCollapse, "toCollapse");
        Intrinsics.checkNotNullParameter(ellipsis, "ellipsis");
        this.collapseLineCount = collapseLineCount;
        this.toExpand = toExpand;
        this.toCollapse = toCollapse;
        this.ellipsis = ellipsis;
        this.constraints = constraints;
    }

    public final int getCollapseLineCount() {
        return this.collapseLineCount;
    }

    public final String getToExpand() {
        return this.toExpand;
    }

    public final String getToCollapse() {
        return this.toCollapse;
    }

    public final String getEllipsis() {
        return this.ellipsis;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m1834getConstraintsmsEJaDk() {
        return this.constraints;
    }
}