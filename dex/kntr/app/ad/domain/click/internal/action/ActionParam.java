package kntr.app.ad.domain.click.internal.action;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionParam.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "WxProgram", "Url", "SchemeDoubleJump", "Scheme", "ULink", "AppStore", "AppDownload", "Web", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Web;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ActionParam {
    public /* synthetic */ ActionParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "wxInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "<init>", "(Lkntr/app/ad/common/model/AdWxProgramInfo;)V", "getWxInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class WxProgram extends ActionParam {
        private final AdWxProgramInfo wxInfo;

        public static /* synthetic */ WxProgram copy$default(WxProgram wxProgram, AdWxProgramInfo adWxProgramInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                adWxProgramInfo = wxProgram.wxInfo;
            }
            return wxProgram.copy(adWxProgramInfo);
        }

        public final AdWxProgramInfo component1() {
            return this.wxInfo;
        }

        public final WxProgram copy(AdWxProgramInfo adWxProgramInfo) {
            return new WxProgram(adWxProgramInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WxProgram) && Intrinsics.areEqual(this.wxInfo, ((WxProgram) obj).wxInfo);
        }

        public int hashCode() {
            if (this.wxInfo == null) {
                return 0;
            }
            return this.wxInfo.hashCode();
        }

        public String toString() {
            return "WxProgram(wxInfo=" + this.wxInfo + ")";
        }

        public WxProgram(AdWxProgramInfo wxInfo) {
            super(null);
            this.wxInfo = wxInfo;
        }

        public final AdWxProgramInfo getWxInfo() {
            return this.wxInfo;
        }
    }

    private ActionParam() {
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Url extends ActionParam {
        private final String url;

        public static /* synthetic */ Url copy$default(Url url, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = url.url;
            }
            return url.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Url copy(String str) {
            return new Url(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Url) && Intrinsics.areEqual(this.url, ((Url) obj).url);
        }

        public int hashCode() {
            if (this.url == null) {
                return 0;
            }
            return this.url.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.url + ")";
        }

        public Url(String url) {
            super(null);
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "enableDoubleJump", RoomRecommendViewModel.EMPTY_CURSOR, "useAdWeb", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "getCallUpUrl", "()Ljava/lang/String;", "getJumpUrl", "getOpenWhiteList", "()Ljava/util/List;", "getEnableDoubleJump", "()Z", "getUseAdWeb", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SchemeDoubleJump extends ActionParam {
        private final String callUpUrl;
        private final boolean enableDoubleJump;
        private final String jumpUrl;
        private final List<String> openWhiteList;
        private final boolean useAdWeb;

        public static /* synthetic */ SchemeDoubleJump copy$default(SchemeDoubleJump schemeDoubleJump, String str, String str2, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = schemeDoubleJump.callUpUrl;
            }
            if ((i & 2) != 0) {
                str2 = schemeDoubleJump.jumpUrl;
            }
            String str3 = str2;
            List<String> list2 = list;
            if ((i & 4) != 0) {
                list2 = schemeDoubleJump.openWhiteList;
            }
            List list3 = list2;
            if ((i & 8) != 0) {
                z = schemeDoubleJump.enableDoubleJump;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = schemeDoubleJump.useAdWeb;
            }
            return schemeDoubleJump.copy(str, str3, list3, z3, z2);
        }

        public final String component1() {
            return this.callUpUrl;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final List<String> component3() {
            return this.openWhiteList;
        }

        public final boolean component4() {
            return this.enableDoubleJump;
        }

        public final boolean component5() {
            return this.useAdWeb;
        }

        public final SchemeDoubleJump copy(String str, String str2, List<String> list, boolean z, boolean z2) {
            return new SchemeDoubleJump(str, str2, list, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SchemeDoubleJump) {
                SchemeDoubleJump schemeDoubleJump = (SchemeDoubleJump) obj;
                return Intrinsics.areEqual(this.callUpUrl, schemeDoubleJump.callUpUrl) && Intrinsics.areEqual(this.jumpUrl, schemeDoubleJump.jumpUrl) && Intrinsics.areEqual(this.openWhiteList, schemeDoubleJump.openWhiteList) && this.enableDoubleJump == schemeDoubleJump.enableDoubleJump && this.useAdWeb == schemeDoubleJump.useAdWeb;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.callUpUrl == null ? 0 : this.callUpUrl.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.openWhiteList != null ? this.openWhiteList.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableDoubleJump)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useAdWeb);
        }

        public String toString() {
            String str = this.callUpUrl;
            String str2 = this.jumpUrl;
            List<String> list = this.openWhiteList;
            boolean z = this.enableDoubleJump;
            return "SchemeDoubleJump(callUpUrl=" + str + ", jumpUrl=" + str2 + ", openWhiteList=" + list + ", enableDoubleJump=" + z + ", useAdWeb=" + this.useAdWeb + ")";
        }

        public SchemeDoubleJump(String callUpUrl, String jumpUrl, List<String> list, boolean enableDoubleJump, boolean useAdWeb) {
            super(null);
            this.callUpUrl = callUpUrl;
            this.jumpUrl = jumpUrl;
            this.openWhiteList = list;
            this.enableDoubleJump = enableDoubleJump;
            this.useAdWeb = useAdWeb;
        }

        public final String getCallUpUrl() {
            return this.callUpUrl;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final List<String> getOpenWhiteList() {
            return this.openWhiteList;
        }

        public final boolean getEnableDoubleJump() {
            return this.enableDoubleJump;
        }

        public final boolean getUseAdWeb() {
            return this.useAdWeb;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "cancelUrl", "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "enableCallUpCancelToJumpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "useAdWeb", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "getCallUpUrl", "()Ljava/lang/String;", "getCancelUrl", "getOpenWhiteList", "()Ljava/util/List;", "getEnableCallUpCancelToJumpUrl", "()Z", "getUseAdWeb", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Scheme extends ActionParam {
        private final String callUpUrl;
        private final String cancelUrl;
        private final boolean enableCallUpCancelToJumpUrl;
        private final List<String> openWhiteList;
        private final boolean useAdWeb;

        public static /* synthetic */ Scheme copy$default(Scheme scheme, String str, String str2, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = scheme.callUpUrl;
            }
            if ((i & 2) != 0) {
                str2 = scheme.cancelUrl;
            }
            String str3 = str2;
            List<String> list2 = list;
            if ((i & 4) != 0) {
                list2 = scheme.openWhiteList;
            }
            List list3 = list2;
            if ((i & 8) != 0) {
                z = scheme.enableCallUpCancelToJumpUrl;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = scheme.useAdWeb;
            }
            return scheme.copy(str, str3, list3, z3, z2);
        }

        public final String component1() {
            return this.callUpUrl;
        }

        public final String component2() {
            return this.cancelUrl;
        }

        public final List<String> component3() {
            return this.openWhiteList;
        }

        public final boolean component4() {
            return this.enableCallUpCancelToJumpUrl;
        }

        public final boolean component5() {
            return this.useAdWeb;
        }

        public final Scheme copy(String str, String str2, List<String> list, boolean z, boolean z2) {
            return new Scheme(str, str2, list, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Scheme) {
                Scheme scheme = (Scheme) obj;
                return Intrinsics.areEqual(this.callUpUrl, scheme.callUpUrl) && Intrinsics.areEqual(this.cancelUrl, scheme.cancelUrl) && Intrinsics.areEqual(this.openWhiteList, scheme.openWhiteList) && this.enableCallUpCancelToJumpUrl == scheme.enableCallUpCancelToJumpUrl && this.useAdWeb == scheme.useAdWeb;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.callUpUrl == null ? 0 : this.callUpUrl.hashCode()) * 31) + (this.cancelUrl == null ? 0 : this.cancelUrl.hashCode())) * 31) + (this.openWhiteList != null ? this.openWhiteList.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableCallUpCancelToJumpUrl)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useAdWeb);
        }

        public String toString() {
            String str = this.callUpUrl;
            String str2 = this.cancelUrl;
            List<String> list = this.openWhiteList;
            boolean z = this.enableCallUpCancelToJumpUrl;
            return "Scheme(callUpUrl=" + str + ", cancelUrl=" + str2 + ", openWhiteList=" + list + ", enableCallUpCancelToJumpUrl=" + z + ", useAdWeb=" + this.useAdWeb + ")";
        }

        public Scheme(String callUpUrl, String cancelUrl, List<String> list, boolean enableCallUpCancelToJumpUrl, boolean useAdWeb) {
            super(null);
            this.callUpUrl = callUpUrl;
            this.cancelUrl = cancelUrl;
            this.openWhiteList = list;
            this.enableCallUpCancelToJumpUrl = enableCallUpCancelToJumpUrl;
            this.useAdWeb = useAdWeb;
        }

        public final String getCallUpUrl() {
            return this.callUpUrl;
        }

        public final String getCancelUrl() {
            return this.cancelUrl;
        }

        public final List<String> getOpenWhiteList() {
            return this.openWhiteList;
        }

        public final boolean getEnableCallUpCancelToJumpUrl() {
            return this.enableCallUpCancelToJumpUrl;
        }

        public final boolean getUseAdWeb() {
            return this.useAdWeb;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "universalApp", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCallUpUrl", "()Ljava/lang/String;", "getOpenWhiteList", "()Ljava/util/List;", "getUniversalApp", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ULink extends ActionParam {
        private final String callUpUrl;
        private final List<String> openWhiteList;
        private final String universalApp;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ULink copy$default(ULink uLink, String str, List list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uLink.callUpUrl;
            }
            if ((i & 2) != 0) {
                list = uLink.openWhiteList;
            }
            if ((i & 4) != 0) {
                str2 = uLink.universalApp;
            }
            return uLink.copy(str, list, str2);
        }

        public final String component1() {
            return this.callUpUrl;
        }

        public final List<String> component2() {
            return this.openWhiteList;
        }

        public final String component3() {
            return this.universalApp;
        }

        public final ULink copy(String str, List<String> list, String str2) {
            return new ULink(str, list, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ULink) {
                ULink uLink = (ULink) obj;
                return Intrinsics.areEqual(this.callUpUrl, uLink.callUpUrl) && Intrinsics.areEqual(this.openWhiteList, uLink.openWhiteList) && Intrinsics.areEqual(this.universalApp, uLink.universalApp);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.callUpUrl == null ? 0 : this.callUpUrl.hashCode()) * 31) + (this.openWhiteList == null ? 0 : this.openWhiteList.hashCode())) * 31) + (this.universalApp != null ? this.universalApp.hashCode() : 0);
        }

        public String toString() {
            String str = this.callUpUrl;
            List<String> list = this.openWhiteList;
            return "ULink(callUpUrl=" + str + ", openWhiteList=" + list + ", universalApp=" + this.universalApp + ")";
        }

        public ULink(String callUpUrl, List<String> list, String universalApp) {
            super(null);
            this.callUpUrl = callUpUrl;
            this.openWhiteList = list;
            this.universalApp = universalApp;
        }

        public final String getCallUpUrl() {
            return this.callUpUrl;
        }

        public final List<String> getOpenWhiteList() {
            return this.openWhiteList;
        }

        public final String getUniversalApp() {
            return this.universalApp;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014¨\u0006$"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "downloadWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdWhiteApk;", "enableAppStore", RoomRecommendViewModel.EMPTY_CURSOR, "appStorePriority", RoomRecommendViewModel.EMPTY_CURSOR, "storeLink", "isFirstJump", "<init>", "(Ljava/lang/String;Ljava/util/List;ZILjava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getDownloadWhiteList", "()Ljava/util/List;", "getEnableAppStore", "()Z", "getAppStorePriority", "()I", "getStoreLink", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AppStore extends ActionParam {
        private final int appStorePriority;
        private final List<AdWhiteApk> downloadWhiteList;
        private final boolean enableAppStore;
        private final boolean isFirstJump;
        private final String storeLink;
        private final String url;

        public static /* synthetic */ AppStore copy$default(AppStore appStore, String str, List list, boolean z, int i, String str2, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = appStore.url;
            }
            List<AdWhiteApk> list2 = list;
            if ((i2 & 2) != 0) {
                list2 = appStore.downloadWhiteList;
            }
            List list3 = list2;
            if ((i2 & 4) != 0) {
                z = appStore.enableAppStore;
            }
            boolean z3 = z;
            if ((i2 & 8) != 0) {
                i = appStore.appStorePriority;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                str2 = appStore.storeLink;
            }
            String str3 = str2;
            if ((i2 & 32) != 0) {
                z2 = appStore.isFirstJump;
            }
            return appStore.copy(str, list3, z3, i3, str3, z2);
        }

        public final String component1() {
            return this.url;
        }

        public final List<AdWhiteApk> component2() {
            return this.downloadWhiteList;
        }

        public final boolean component3() {
            return this.enableAppStore;
        }

        public final int component4() {
            return this.appStorePriority;
        }

        public final String component5() {
            return this.storeLink;
        }

        public final boolean component6() {
            return this.isFirstJump;
        }

        public final AppStore copy(String str, List<AdWhiteApk> list, boolean z, int i, String str2, boolean z2) {
            return new AppStore(str, list, z, i, str2, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AppStore) {
                AppStore appStore = (AppStore) obj;
                return Intrinsics.areEqual(this.url, appStore.url) && Intrinsics.areEqual(this.downloadWhiteList, appStore.downloadWhiteList) && this.enableAppStore == appStore.enableAppStore && this.appStorePriority == appStore.appStorePriority && Intrinsics.areEqual(this.storeLink, appStore.storeLink) && this.isFirstJump == appStore.isFirstJump;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.downloadWhiteList == null ? 0 : this.downloadWhiteList.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableAppStore)) * 31) + this.appStorePriority) * 31) + (this.storeLink != null ? this.storeLink.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFirstJump);
        }

        public String toString() {
            String str = this.url;
            List<AdWhiteApk> list = this.downloadWhiteList;
            boolean z = this.enableAppStore;
            int i = this.appStorePriority;
            String str2 = this.storeLink;
            return "AppStore(url=" + str + ", downloadWhiteList=" + list + ", enableAppStore=" + z + ", appStorePriority=" + i + ", storeLink=" + str2 + ", isFirstJump=" + this.isFirstJump + ")";
        }

        public AppStore(String url, List<AdWhiteApk> list, boolean enableAppStore, int appStorePriority, String storeLink, boolean isFirstJump) {
            super(null);
            this.url = url;
            this.downloadWhiteList = list;
            this.enableAppStore = enableAppStore;
            this.appStorePriority = appStorePriority;
            this.storeLink = storeLink;
            this.isFirstJump = isFirstJump;
        }

        public final String getUrl() {
            return this.url;
        }

        public final List<AdWhiteApk> getDownloadWhiteList() {
            return this.downloadWhiteList;
        }

        public final boolean getEnableAppStore() {
            return this.enableAppStore;
        }

        public final int getAppStorePriority() {
            return this.appStorePriority;
        }

        public final String getStoreLink() {
            return this.storeLink;
        }

        public final boolean isFirstJump() {
            return this.isFirstJump;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "downloadWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdWhiteApk;", "enableDownload", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getUrl", "()Ljava/lang/String;", "getDownloadWhiteList", "()Ljava/util/List;", "getEnableDownload", "()Z", "component1", "component2", "component3", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AppDownload extends ActionParam {
        private final List<AdWhiteApk> downloadWhiteList;
        private final boolean enableDownload;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppDownload copy$default(AppDownload appDownload, String str, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appDownload.url;
            }
            if ((i & 2) != 0) {
                list = appDownload.downloadWhiteList;
            }
            if ((i & 4) != 0) {
                z = appDownload.enableDownload;
            }
            return appDownload.copy(str, list, z);
        }

        public final String component1() {
            return this.url;
        }

        public final List<AdWhiteApk> component2() {
            return this.downloadWhiteList;
        }

        public final boolean component3() {
            return this.enableDownload;
        }

        public final AppDownload copy(String str, List<AdWhiteApk> list, boolean z) {
            return new AppDownload(str, list, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AppDownload) {
                AppDownload appDownload = (AppDownload) obj;
                return Intrinsics.areEqual(this.url, appDownload.url) && Intrinsics.areEqual(this.downloadWhiteList, appDownload.downloadWhiteList) && this.enableDownload == appDownload.enableDownload;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.downloadWhiteList != null ? this.downloadWhiteList.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableDownload);
        }

        public String toString() {
            String str = this.url;
            List<AdWhiteApk> list = this.downloadWhiteList;
            return "AppDownload(url=" + str + ", downloadWhiteList=" + list + ", enableDownload=" + this.enableDownload + ")";
        }

        public AppDownload(String url, List<AdWhiteApk> list, boolean enableDownload) {
            super(null);
            this.url = url;
            this.downloadWhiteList = list;
            this.enableDownload = enableDownload;
        }

        public final String getUrl() {
            return this.url;
        }

        public final List<AdWhiteApk> getDownloadWhiteList() {
            return this.downloadWhiteList;
        }

        public final boolean getEnableDownload() {
            return this.enableDownload;
        }
    }

    /* compiled from: ActionParam.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionParam$Web;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "useAdWeb", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getUseAdWeb", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Web extends ActionParam {
        private final String url;
        private final boolean useAdWeb;

        public static /* synthetic */ Web copy$default(Web web, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = web.url;
            }
            if ((i & 2) != 0) {
                z = web.useAdWeb;
            }
            return web.copy(str, z);
        }

        public final String component1() {
            return this.url;
        }

        public final boolean component2() {
            return this.useAdWeb;
        }

        public final Web copy(String str, boolean z) {
            return new Web(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Web) {
                Web web = (Web) obj;
                return Intrinsics.areEqual(this.url, web.url) && this.useAdWeb == web.useAdWeb;
            }
            return false;
        }

        public int hashCode() {
            return ((this.url == null ? 0 : this.url.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useAdWeb);
        }

        public String toString() {
            String str = this.url;
            return "Web(url=" + str + ", useAdWeb=" + this.useAdWeb + ")";
        }

        public Web(String url, boolean useAdWeb) {
            super(null);
            this.url = url;
            this.useAdWeb = useAdWeb;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean getUseAdWeb() {
            return this.useAdWeb;
        }
    }
}