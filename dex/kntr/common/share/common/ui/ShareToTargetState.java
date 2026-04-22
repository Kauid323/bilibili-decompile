package kntr.common.share.common.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/share/common/ui/ShareToTargetState;", "", "Loading", "Loaded", "ShareFinish", "Lkntr/common/share/common/ui/ShareToTargetState$Loaded;", "Lkntr/common/share/common/ui/ShareToTargetState$Loading;", "Lkntr/common/share/common/ui/ShareToTargetState$ShareFinish;", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ShareToTargetState {

    /* compiled from: Share.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ui/ShareToTargetState$Loading;", "Lkntr/common/share/common/ui/ShareToTargetState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Loading implements ShareToTargetState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1545103248;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: Share.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/share/common/ui/ShareToTargetState$Loaded;", "Lkntr/common/share/common/ui/ShareToTargetState;", "content", "Lkntr/common/share/common/ShareContent;", "<init>", "(Lkntr/common/share/common/ShareContent;)V", "getContent", "()Lkntr/common/share/common/ShareContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Loaded implements ShareToTargetState {
        public static final int $stable = ShareContent.$stable;
        private final ShareContent content;

        public static /* synthetic */ Loaded copy$default(Loaded loaded, ShareContent shareContent, int i, Object obj) {
            if ((i & 1) != 0) {
                shareContent = loaded.content;
            }
            return loaded.copy(shareContent);
        }

        public final ShareContent component1() {
            return this.content;
        }

        public final Loaded copy(ShareContent shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return new Loaded(shareContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loaded) && Intrinsics.areEqual(this.content, ((Loaded) obj).content);
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return "Loaded(content=" + this.content + ")";
        }

        public Loaded(ShareContent content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
        }

        public final ShareContent getContent() {
            return this.content;
        }
    }

    /* compiled from: Share.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/share/common/ui/ShareToTargetState$ShareFinish;", "Lkntr/common/share/common/ui/ShareToTargetState;", "result", "Lkntr/common/share/common/ShareResult;", "message", "", "<init>", "(Lkntr/common/share/common/ShareResult;Ljava/lang/String;)V", "getResult", "()Lkntr/common/share/common/ShareResult;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShareFinish implements ShareToTargetState {
        public static final int $stable = 0;
        private final String message;
        private final ShareResult result;

        public static /* synthetic */ ShareFinish copy$default(ShareFinish shareFinish, ShareResult shareResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                shareResult = shareFinish.result;
            }
            if ((i & 2) != 0) {
                str = shareFinish.message;
            }
            return shareFinish.copy(shareResult, str);
        }

        public final ShareResult component1() {
            return this.result;
        }

        public final String component2() {
            return this.message;
        }

        public final ShareFinish copy(ShareResult shareResult, String str) {
            Intrinsics.checkNotNullParameter(shareResult, "result");
            Intrinsics.checkNotNullParameter(str, "message");
            return new ShareFinish(shareResult, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareFinish) {
                ShareFinish shareFinish = (ShareFinish) obj;
                return this.result == shareFinish.result && Intrinsics.areEqual(this.message, shareFinish.message);
            }
            return false;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            ShareResult shareResult = this.result;
            return "ShareFinish(result=" + shareResult + ", message=" + this.message + ")";
        }

        public ShareFinish(ShareResult result, String message) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(message, "message");
            this.result = result;
            this.message = message;
        }

        public final ShareResult getResult() {
            return this.result;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}