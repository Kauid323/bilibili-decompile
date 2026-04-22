package kntr.common.ouro.core.plugin.atMention;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAtMentionAction.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction;", "Lkntr/common/ouro/core/action/OuroAction;", "Search", "Retry", "SelectUser", "Clear", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Clear;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Retry;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Search;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$SelectUser;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroAtMentionAction extends OuroAction {

    /* compiled from: OuroAtMentionAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Search;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction;", "keyword", "Lkntr/common/ouro/core/plugin/atMention/Keyword;", "multipleModeIdentifier", "", "<init>", "(Lkntr/common/ouro/core/plugin/atMention/Keyword;Ljava/lang/String;)V", "getKeyword", "()Lkntr/common/ouro/core/plugin/atMention/Keyword;", "getMultipleModeIdentifier", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Search implements OuroAtMentionAction {
        private final Keyword keyword;
        private final String multipleModeIdentifier;

        public static /* synthetic */ Search copy$default(Search search, Keyword keyword, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                keyword = search.keyword;
            }
            if ((i & 2) != 0) {
                str = search.multipleModeIdentifier;
            }
            return search.copy(keyword, str);
        }

        public final Keyword component1() {
            return this.keyword;
        }

        public final String component2() {
            return this.multipleModeIdentifier;
        }

        public final Search copy(Keyword keyword, String str) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            return new Search(keyword, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Search) {
                Search search = (Search) obj;
                return Intrinsics.areEqual(this.keyword, search.keyword) && Intrinsics.areEqual(this.multipleModeIdentifier, search.multipleModeIdentifier);
            }
            return false;
        }

        public int hashCode() {
            return (this.keyword.hashCode() * 31) + (this.multipleModeIdentifier == null ? 0 : this.multipleModeIdentifier.hashCode());
        }

        public String toString() {
            Keyword keyword = this.keyword;
            return "Search(keyword=" + keyword + ", multipleModeIdentifier=" + this.multipleModeIdentifier + ")";
        }

        public Search(Keyword keyword, String multipleModeIdentifier) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
            this.multipleModeIdentifier = multipleModeIdentifier;
        }

        public /* synthetic */ Search(Keyword keyword, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(keyword, (i & 2) != 0 ? null : str);
        }

        public final Keyword getKeyword() {
            return this.keyword;
        }

        public final String getMultipleModeIdentifier() {
            return this.multipleModeIdentifier;
        }
    }

    /* compiled from: OuroAtMentionAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Retry;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Retry implements OuroAtMentionAction {
        public static final Retry INSTANCE = new Retry();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Retry) {
                Retry retry = (Retry) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1119197868;
        }

        public String toString() {
            return "Retry";
        }

        private Retry() {
        }
    }

    /* compiled from: OuroAtMentionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$SelectUser;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction;", "user", "Lkntr/common/ouro/core/model/node/AtMentionUser;", "<init>", "(Lkntr/common/ouro/core/model/node/AtMentionUser;)V", "getUser", "()Lkntr/common/ouro/core/model/node/AtMentionUser;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectUser implements OuroAtMentionAction {
        private final AtMentionUser user;

        public static /* synthetic */ SelectUser copy$default(SelectUser selectUser, AtMentionUser atMentionUser, int i, Object obj) {
            if ((i & 1) != 0) {
                atMentionUser = selectUser.user;
            }
            return selectUser.copy(atMentionUser);
        }

        public final AtMentionUser component1() {
            return this.user;
        }

        public final SelectUser copy(AtMentionUser atMentionUser) {
            Intrinsics.checkNotNullParameter(atMentionUser, "user");
            return new SelectUser(atMentionUser);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectUser) && Intrinsics.areEqual(this.user, ((SelectUser) obj).user);
        }

        public int hashCode() {
            return this.user.hashCode();
        }

        public String toString() {
            return "SelectUser(user=" + this.user + ")";
        }

        public SelectUser(AtMentionUser user) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.user = user;
        }

        public final AtMentionUser getUser() {
            return this.user;
        }
    }

    /* compiled from: OuroAtMentionAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$Clear;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Clear implements OuroAtMentionAction {
        public static final Clear INSTANCE = new Clear();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Clear) {
                Clear clear = (Clear) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1105538641;
        }

        public String toString() {
            return "Clear";
        }

        private Clear() {
        }
    }
}