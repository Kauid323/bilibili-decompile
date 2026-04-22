package tv.danmaku.bili.eula;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginEulaDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/eula/EulaLinkType;", "", "link", "", "getLink", "()Ljava/lang/String;", "Help", "Agreement", "Privacy", "IspAgreement", "Ltv/danmaku/bili/eula/EulaLinkType$Agreement;", "Ltv/danmaku/bili/eula/EulaLinkType$Help;", "Ltv/danmaku/bili/eula/EulaLinkType$IspAgreement;", "Ltv/danmaku/bili/eula/EulaLinkType$Privacy;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface EulaLinkType {
    String getLink();

    /* compiled from: LoginEulaDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/eula/EulaLinkType$Help;", "Ltv/danmaku/bili/eula/EulaLinkType;", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Help implements EulaLinkType {
        public static final int $stable = 0;
        private final String link;

        public static /* synthetic */ Help copy$default(Help help, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = help.link;
            }
            return help.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final Help copy(String str) {
            Intrinsics.checkNotNullParameter(str, "link");
            return new Help(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Help) && Intrinsics.areEqual(this.link, ((Help) obj).link);
        }

        public int hashCode() {
            return this.link.hashCode();
        }

        public String toString() {
            return "Help(link=" + this.link + ")";
        }

        public Help(String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
        }

        @Override // tv.danmaku.bili.eula.EulaLinkType
        public String getLink() {
            return this.link;
        }
    }

    /* compiled from: LoginEulaDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/eula/EulaLinkType$Agreement;", "Ltv/danmaku/bili/eula/EulaLinkType;", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Agreement implements EulaLinkType {
        public static final int $stable = 0;
        private final String link;

        public static /* synthetic */ Agreement copy$default(Agreement agreement, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = agreement.link;
            }
            return agreement.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final Agreement copy(String str) {
            Intrinsics.checkNotNullParameter(str, "link");
            return new Agreement(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Agreement) && Intrinsics.areEqual(this.link, ((Agreement) obj).link);
        }

        public int hashCode() {
            return this.link.hashCode();
        }

        public String toString() {
            return "Agreement(link=" + this.link + ")";
        }

        public Agreement(String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
        }

        @Override // tv.danmaku.bili.eula.EulaLinkType
        public String getLink() {
            return this.link;
        }
    }

    /* compiled from: LoginEulaDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/eula/EulaLinkType$Privacy;", "Ltv/danmaku/bili/eula/EulaLinkType;", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Privacy implements EulaLinkType {
        public static final int $stable = 0;
        private final String link;

        public static /* synthetic */ Privacy copy$default(Privacy privacy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = privacy.link;
            }
            return privacy.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final Privacy copy(String str) {
            Intrinsics.checkNotNullParameter(str, "link");
            return new Privacy(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Privacy) && Intrinsics.areEqual(this.link, ((Privacy) obj).link);
        }

        public int hashCode() {
            return this.link.hashCode();
        }

        public String toString() {
            return "Privacy(link=" + this.link + ")";
        }

        public Privacy(String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
        }

        @Override // tv.danmaku.bili.eula.EulaLinkType
        public String getLink() {
            return this.link;
        }
    }

    /* compiled from: LoginEulaDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/eula/EulaLinkType$IspAgreement;", "Ltv/danmaku/bili/eula/EulaLinkType;", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class IspAgreement implements EulaLinkType {
        public static final int $stable = 0;
        private final String link;

        public static /* synthetic */ IspAgreement copy$default(IspAgreement ispAgreement, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ispAgreement.link;
            }
            return ispAgreement.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final IspAgreement copy(String str) {
            Intrinsics.checkNotNullParameter(str, "link");
            return new IspAgreement(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IspAgreement) && Intrinsics.areEqual(this.link, ((IspAgreement) obj).link);
        }

        public int hashCode() {
            return this.link.hashCode();
        }

        public String toString() {
            return "IspAgreement(link=" + this.link + ")";
        }

        public IspAgreement(String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
        }

        @Override // tv.danmaku.bili.eula.EulaLinkType
        public String getLink() {
            return this.link;
        }
    }
}