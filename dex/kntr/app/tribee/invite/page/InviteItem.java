package kntr.app.tribee.invite.page;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeDesc;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInviteList.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/invite/page/InviteItem;", "", "tribeeId", "", "<init>", "(J)V", "getTribeeId", "()J", "TribeeItem", "CodeItem", "Expandable", "Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "Lkntr/app/tribee/invite/page/InviteItem$Expandable;", "Lkntr/app/tribee/invite/page/InviteItem$TribeeItem;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class InviteItem {
    public static final int $stable = 0;
    private final long tribeeId;

    public /* synthetic */ InviteItem(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private InviteItem(long tribeeId) {
        this.tribeeId = tribeeId;
    }

    public long getTribeeId() {
        return this.tribeeId;
    }

    /* compiled from: TribeeInviteList.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\tJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006*"}, d2 = {"Lkntr/app/tribee/invite/page/InviteItem$TribeeItem;", "Lkntr/app/tribee/invite/page/InviteItem;", "tribeeId", "", "tribeeTitle", "", "tribeeFaceUrl", "jumpUrl", "isCollapsed", "", "childrenIsHidden", "codesSize", "", "showLength", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZII)V", "getTribeeId", "()J", "getTribeeTitle", "()Ljava/lang/String;", "getTribeeFaceUrl", "getJumpUrl", "()Z", "getChildrenIsHidden", "getCodesSize", "()I", "getShowLength", "needFold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeItem extends InviteItem {
        public static final int $stable = 0;
        private final boolean childrenIsHidden;
        private final int codesSize;
        private final boolean isCollapsed;
        private final String jumpUrl;
        private final int showLength;
        private final String tribeeFaceUrl;
        private final long tribeeId;
        private final String tribeeTitle;

        public final long component1() {
            return this.tribeeId;
        }

        public final String component2() {
            return this.tribeeTitle;
        }

        public final String component3() {
            return this.tribeeFaceUrl;
        }

        public final String component4() {
            return this.jumpUrl;
        }

        public final boolean component5() {
            return this.isCollapsed;
        }

        public final boolean component6() {
            return this.childrenIsHidden;
        }

        public final int component7() {
            return this.codesSize;
        }

        public final int component8() {
            return this.showLength;
        }

        public final TribeeItem copy(long j, String str, String str2, String str3, boolean z, boolean z2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "tribeeTitle");
            Intrinsics.checkNotNullParameter(str2, "tribeeFaceUrl");
            Intrinsics.checkNotNullParameter(str3, "jumpUrl");
            return new TribeeItem(j, str, str2, str3, z, z2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeItem) {
                TribeeItem tribeeItem = (TribeeItem) obj;
                return this.tribeeId == tribeeItem.tribeeId && Intrinsics.areEqual(this.tribeeTitle, tribeeItem.tribeeTitle) && Intrinsics.areEqual(this.tribeeFaceUrl, tribeeItem.tribeeFaceUrl) && Intrinsics.areEqual(this.jumpUrl, tribeeItem.jumpUrl) && this.isCollapsed == tribeeItem.isCollapsed && this.childrenIsHidden == tribeeItem.childrenIsHidden && this.codesSize == tribeeItem.codesSize && this.showLength == tribeeItem.showLength;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId) * 31) + this.tribeeTitle.hashCode()) * 31) + this.tribeeFaceUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCollapsed)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.childrenIsHidden)) * 31) + this.codesSize) * 31) + this.showLength;
        }

        public String toString() {
            long j = this.tribeeId;
            String str = this.tribeeTitle;
            String str2 = this.tribeeFaceUrl;
            String str3 = this.jumpUrl;
            boolean z = this.isCollapsed;
            boolean z2 = this.childrenIsHidden;
            int i = this.codesSize;
            return "TribeeItem(tribeeId=" + j + ", tribeeTitle=" + str + ", tribeeFaceUrl=" + str2 + ", jumpUrl=" + str3 + ", isCollapsed=" + z + ", childrenIsHidden=" + z2 + ", codesSize=" + i + ", showLength=" + this.showLength + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TribeeItem(long tribeeId, String tribeeTitle, String tribeeFaceUrl, String jumpUrl, boolean isCollapsed, boolean childrenIsHidden, int codesSize, int showLength) {
            super(tribeeId, null);
            Intrinsics.checkNotNullParameter(tribeeTitle, "tribeeTitle");
            Intrinsics.checkNotNullParameter(tribeeFaceUrl, "tribeeFaceUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.tribeeId = tribeeId;
            this.tribeeTitle = tribeeTitle;
            this.tribeeFaceUrl = tribeeFaceUrl;
            this.jumpUrl = jumpUrl;
            this.isCollapsed = isCollapsed;
            this.childrenIsHidden = childrenIsHidden;
            this.codesSize = codesSize;
            this.showLength = showLength;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ TribeeItem(long j, String str, String str2, String str3, boolean z, boolean z2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, str2, str3, r8, r9, i, i2);
            boolean z3;
            boolean z4;
            if ((i3 & 16) == 0) {
                z3 = z;
            } else {
                z3 = false;
            }
            if ((i3 & 32) == 0) {
                z4 = z2;
            } else {
                z4 = false;
            }
        }

        @Override // kntr.app.tribee.invite.page.InviteItem
        public long getTribeeId() {
            return this.tribeeId;
        }

        public final String getTribeeTitle() {
            return this.tribeeTitle;
        }

        public final String getTribeeFaceUrl() {
            return this.tribeeFaceUrl;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final boolean isCollapsed() {
            return this.isCollapsed;
        }

        public final boolean getChildrenIsHidden() {
            return this.childrenIsHidden;
        }

        public final int getCodesSize() {
            return this.codesSize;
        }

        public final int getShowLength() {
            return this.showLength;
        }

        public final boolean needFold() {
            return this.codesSize > this.showLength;
        }
    }

    /* compiled from: TribeeInviteList.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "Lkntr/app/tribee/invite/page/InviteItem;", "code", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeDesc;", "tribeeId", "", "tribeeTitle", "", "tribeeFaceUrl", "inSectionEnd", "", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeDesc;JLjava/lang/String;Ljava/lang/String;Z)V", "getCode", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeDesc;", "getTribeeId", "()J", "getTribeeTitle", "()Ljava/lang/String;", "getTribeeFaceUrl", "getInSectionEnd", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CodeItem extends InviteItem {
        public static final int $stable = 8;
        private final KTribeeInviteCodeDesc code;
        private final boolean inSectionEnd;
        private final String tribeeFaceUrl;
        private final long tribeeId;
        private final String tribeeTitle;

        public static /* synthetic */ CodeItem copy$default(CodeItem codeItem, KTribeeInviteCodeDesc kTribeeInviteCodeDesc, long j, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeInviteCodeDesc = codeItem.code;
            }
            if ((i & 2) != 0) {
                j = codeItem.tribeeId;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str = codeItem.tribeeTitle;
            }
            String str3 = str;
            if ((i & 8) != 0) {
                str2 = codeItem.tribeeFaceUrl;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                z = codeItem.inSectionEnd;
            }
            return codeItem.copy(kTribeeInviteCodeDesc, j2, str3, str4, z);
        }

        public final KTribeeInviteCodeDesc component1() {
            return this.code;
        }

        public final long component2() {
            return this.tribeeId;
        }

        public final String component3() {
            return this.tribeeTitle;
        }

        public final String component4() {
            return this.tribeeFaceUrl;
        }

        public final boolean component5() {
            return this.inSectionEnd;
        }

        public final CodeItem copy(KTribeeInviteCodeDesc kTribeeInviteCodeDesc, long j, String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(kTribeeInviteCodeDesc, "code");
            Intrinsics.checkNotNullParameter(str, "tribeeTitle");
            Intrinsics.checkNotNullParameter(str2, "tribeeFaceUrl");
            return new CodeItem(kTribeeInviteCodeDesc, j, str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CodeItem) {
                CodeItem codeItem = (CodeItem) obj;
                return Intrinsics.areEqual(this.code, codeItem.code) && this.tribeeId == codeItem.tribeeId && Intrinsics.areEqual(this.tribeeTitle, codeItem.tribeeTitle) && Intrinsics.areEqual(this.tribeeFaceUrl, codeItem.tribeeFaceUrl) && this.inSectionEnd == codeItem.inSectionEnd;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.code.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId)) * 31) + this.tribeeTitle.hashCode()) * 31) + this.tribeeFaceUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.inSectionEnd);
        }

        public String toString() {
            KTribeeInviteCodeDesc kTribeeInviteCodeDesc = this.code;
            long j = this.tribeeId;
            String str = this.tribeeTitle;
            String str2 = this.tribeeFaceUrl;
            return "CodeItem(code=" + kTribeeInviteCodeDesc + ", tribeeId=" + j + ", tribeeTitle=" + str + ", tribeeFaceUrl=" + str2 + ", inSectionEnd=" + this.inSectionEnd + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeItem(KTribeeInviteCodeDesc code, long tribeeId, String tribeeTitle, String tribeeFaceUrl, boolean inSectionEnd) {
            super(tribeeId, null);
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(tribeeTitle, "tribeeTitle");
            Intrinsics.checkNotNullParameter(tribeeFaceUrl, "tribeeFaceUrl");
            this.code = code;
            this.tribeeId = tribeeId;
            this.tribeeTitle = tribeeTitle;
            this.tribeeFaceUrl = tribeeFaceUrl;
            this.inSectionEnd = inSectionEnd;
        }

        public final KTribeeInviteCodeDesc getCode() {
            return this.code;
        }

        @Override // kntr.app.tribee.invite.page.InviteItem
        public long getTribeeId() {
            return this.tribeeId;
        }

        public final String getTribeeTitle() {
            return this.tribeeTitle;
        }

        public final String getTribeeFaceUrl() {
            return this.tribeeFaceUrl;
        }

        public final boolean getInSectionEnd() {
            return this.inSectionEnd;
        }
    }

    /* compiled from: TribeeInviteList.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lkntr/app/tribee/invite/page/InviteItem$Expandable;", "Lkntr/app/tribee/invite/page/InviteItem;", "isExpandedAll", "", "showLength", "", "expandableChildren", "", "Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "tribeeId", "", "<init>", "(ZILjava/util/List;J)V", "()Z", "getShowLength", "()I", "getExpandableChildren", "()Ljava/util/List;", "getTribeeId", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Expandable extends InviteItem {
        public static final int $stable = 8;
        private final List<CodeItem> expandableChildren;
        private final boolean isExpandedAll;
        private final int showLength;
        private final long tribeeId;

        public static /* synthetic */ Expandable copy$default(Expandable expandable, boolean z, int i, List list, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = expandable.isExpandedAll;
            }
            if ((i2 & 2) != 0) {
                i = expandable.showLength;
            }
            int i3 = i;
            List<CodeItem> list2 = list;
            if ((i2 & 4) != 0) {
                list2 = expandable.expandableChildren;
            }
            List list3 = list2;
            if ((i2 & 8) != 0) {
                j = expandable.tribeeId;
            }
            return expandable.copy(z, i3, list3, j);
        }

        public final boolean component1() {
            return this.isExpandedAll;
        }

        public final int component2() {
            return this.showLength;
        }

        public final List<CodeItem> component3() {
            return this.expandableChildren;
        }

        public final long component4() {
            return this.tribeeId;
        }

        public final Expandable copy(boolean z, int i, List<CodeItem> list, long j) {
            Intrinsics.checkNotNullParameter(list, "expandableChildren");
            return new Expandable(z, i, list, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Expandable) {
                Expandable expandable = (Expandable) obj;
                return this.isExpandedAll == expandable.isExpandedAll && this.showLength == expandable.showLength && Intrinsics.areEqual(this.expandableChildren, expandable.expandableChildren) && this.tribeeId == expandable.tribeeId;
            }
            return false;
        }

        public int hashCode() {
            return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isExpandedAll) * 31) + this.showLength) * 31) + this.expandableChildren.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId);
        }

        public String toString() {
            boolean z = this.isExpandedAll;
            int i = this.showLength;
            List<CodeItem> list = this.expandableChildren;
            return "Expandable(isExpandedAll=" + z + ", showLength=" + i + ", expandableChildren=" + list + ", tribeeId=" + this.tribeeId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Expandable(boolean isExpandedAll, int showLength, List<CodeItem> list, long tribeeId) {
            super(tribeeId, null);
            Intrinsics.checkNotNullParameter(list, "expandableChildren");
            this.isExpandedAll = isExpandedAll;
            this.showLength = showLength;
            this.expandableChildren = list;
            this.tribeeId = tribeeId;
        }

        public final boolean isExpandedAll() {
            return this.isExpandedAll;
        }

        public final int getShowLength() {
            return this.showLength;
        }

        public final List<CodeItem> getExpandableChildren() {
            return this.expandableChildren;
        }

        @Override // kntr.app.tribee.invite.page.InviteItem
        public long getTribeeId() {
            return this.tribeeId;
        }
    }
}