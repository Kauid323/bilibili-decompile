package kntr.common.ouro.core.plugin.atMention;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAtMentionState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "Idle", "ShowContent", "Loading", "Error", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Error;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Idle;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Loading;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$ShowContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroAtMentionState extends OuroPluginState {

    /* compiled from: OuroAtMentionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Idle;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Idle implements OuroAtMentionState {
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1751195661;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: OuroAtMentionState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$ShowContent;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "keyword", "Lkntr/common/ouro/core/plugin/atMention/Keyword;", "users", "", "Lkntr/common/ouro/core/model/node/AtMentionUser;", "multipleModeIdentifier", "", "<init>", "(Lkntr/common/ouro/core/plugin/atMention/Keyword;Ljava/util/List;Ljava/lang/String;)V", "getKeyword", "()Lkntr/common/ouro/core/plugin/atMention/Keyword;", "getUsers", "()Ljava/util/List;", "getMultipleModeIdentifier", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowContent implements OuroAtMentionState {
        private final Keyword keyword;
        private final String multipleModeIdentifier;
        private final List<AtMentionUser> users;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowContent copy$default(ShowContent showContent, Keyword keyword, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                keyword = showContent.keyword;
            }
            if ((i & 2) != 0) {
                list = showContent.users;
            }
            if ((i & 4) != 0) {
                str = showContent.multipleModeIdentifier;
            }
            return showContent.copy(keyword, list, str);
        }

        public final Keyword component1() {
            return this.keyword;
        }

        public final List<AtMentionUser> component2() {
            return this.users;
        }

        public final String component3() {
            return this.multipleModeIdentifier;
        }

        public final ShowContent copy(Keyword keyword, List<AtMentionUser> list, String str) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(list, "users");
            return new ShowContent(keyword, list, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowContent) {
                ShowContent showContent = (ShowContent) obj;
                return Intrinsics.areEqual(this.keyword, showContent.keyword) && Intrinsics.areEqual(this.users, showContent.users) && Intrinsics.areEqual(this.multipleModeIdentifier, showContent.multipleModeIdentifier);
            }
            return false;
        }

        public int hashCode() {
            return (((this.keyword.hashCode() * 31) + this.users.hashCode()) * 31) + (this.multipleModeIdentifier == null ? 0 : this.multipleModeIdentifier.hashCode());
        }

        public String toString() {
            Keyword keyword = this.keyword;
            List<AtMentionUser> list = this.users;
            return "ShowContent(keyword=" + keyword + ", users=" + list + ", multipleModeIdentifier=" + this.multipleModeIdentifier + ")";
        }

        public ShowContent(Keyword keyword, List<AtMentionUser> list, String multipleModeIdentifier) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(list, "users");
            this.keyword = keyword;
            this.users = list;
            this.multipleModeIdentifier = multipleModeIdentifier;
        }

        public /* synthetic */ ShowContent(Keyword keyword, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(keyword, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str);
        }

        public final Keyword getKeyword() {
            return this.keyword;
        }

        public final List<AtMentionUser> getUsers() {
            return this.users;
        }

        public final String getMultipleModeIdentifier() {
            return this.multipleModeIdentifier;
        }
    }

    /* compiled from: OuroAtMentionState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Loading;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "keyword", "Lkntr/common/ouro/core/plugin/atMention/Keyword;", "<init>", "(Lkntr/common/ouro/core/plugin/atMention/Keyword;)V", "getKeyword", "()Lkntr/common/ouro/core/plugin/atMention/Keyword;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Loading implements OuroAtMentionState {
        private final Keyword keyword;

        public static /* synthetic */ Loading copy$default(Loading loading, Keyword keyword, int i, Object obj) {
            if ((i & 1) != 0) {
                keyword = loading.keyword;
            }
            return loading.copy(keyword);
        }

        public final Keyword component1() {
            return this.keyword;
        }

        public final Loading copy(Keyword keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            return new Loading(keyword);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.areEqual(this.keyword, ((Loading) obj).keyword);
        }

        public int hashCode() {
            return this.keyword.hashCode();
        }

        public String toString() {
            return "Loading(keyword=" + this.keyword + ")";
        }

        public Loading(Keyword keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
        }

        public final Keyword getKeyword() {
            return this.keyword;
        }
    }

    /* compiled from: OuroAtMentionState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState$Error;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "keyword", "Lkntr/common/ouro/core/plugin/atMention/Keyword;", "error", "", "<init>", "(Lkntr/common/ouro/core/plugin/atMention/Keyword;Ljava/lang/Throwable;)V", "getKeyword", "()Lkntr/common/ouro/core/plugin/atMention/Keyword;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Error implements OuroAtMentionState {
        private final Throwable error;
        private final Keyword keyword;

        public static /* synthetic */ Error copy$default(Error error, Keyword keyword, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                keyword = error.keyword;
            }
            if ((i & 2) != 0) {
                th = error.error;
            }
            return error.copy(keyword, th);
        }

        public final Keyword component1() {
            return this.keyword;
        }

        public final Throwable component2() {
            return this.error;
        }

        public final Error copy(Keyword keyword, Throwable th) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(th, "error");
            return new Error(keyword, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.keyword, error.keyword) && Intrinsics.areEqual(this.error, error.error);
            }
            return false;
        }

        public int hashCode() {
            return (this.keyword.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            Keyword keyword = this.keyword;
            return "Error(keyword=" + keyword + ", error=" + this.error + ")";
        }

        public Error(Keyword keyword, Throwable error) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(error, "error");
            this.keyword = keyword;
            this.error = error;
        }

        public final Keyword getKeyword() {
            return this.keyword;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}