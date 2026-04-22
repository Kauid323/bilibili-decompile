package kntr.app.tribee.publish.core.v2.model;

import BottomSheetItemData$;
import com.bapis.bilibili.dynamic.common.KTribeeArg;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TribeePublishState.kt */
@Lens
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0001jB©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u00105\u001a\u00020\u0000H\u0016J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\fHÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010]\u001a\u00020\u0012HÆ\u0003J\u0015\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014HÆ\u0003J\t\u0010_\u001a\u00020\u0012HÆ\u0003J\t\u0010`\u001a\u00020\u0012HÆ\u0003J\t\u0010a\u001a\u00020\u0012HÆ\u0003J\t\u0010b\u001a\u00020\u0012HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J³\u0001\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010e\u001a\u00020\u00122\b\u0010f\u001a\u0004\u0018\u00010gHÖ\u0003J\t\u0010h\u001a\u00020CHÖ\u0001J\t\u0010i\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u0018\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0011\u0010\u001a\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR(\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003078VX\u0096\u0004¢\u0006\f\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b=\u0010-R\u0011\u0010>\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b?\u0010-R\u0011\u0010@\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bA\u0010-R\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bI\u0010-R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bO\u0010-R\u0011\u0010P\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bQ\u0010ER\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006k"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "title", "", "content", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "selectedCategory", "validLimitInfo", "", "settingItems", "", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSettingItem;", "sendToFollowing", "fromDraft", "fromEdit", "showPublishConfirmDialog", "toast", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/NodeStorage;Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;Ljava/util/List;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;ZLjava/util/Map;ZZZZLjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getContent", "()Lkntr/common/ouro/core/model/NodeStorage;", "getLocalImageState", "()Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "getTribeeInfo", "()Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "getLimitInfo", "()Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "getCategories", "()Ljava/util/List;", "getSelectedCategory", "()Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "getValidLimitInfo", "()Z", "getSettingItems", "()Ljava/util/Map;", "getSendToFollowing", "getFromDraft", "getFromEdit", "getShowPublishConfirmDialog", "getToast", "getPublishContent", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "getEditToast$annotations", "()V", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "readyForPublish", "getReadyForPublish", "buttonValid", "getButtonValid", "contentNotEmpty", "getContentNotEmpty", "unuploadedPictureCount", "", "getUnuploadedPictureCount", "()I", "unuploadedPictureCount$delegate", "Lkotlin/Lazy;", "readyForSaveDraft", "getReadyForSaveDraft", "selectedCategoryId", "", "getSelectedCategoryId", "()J", "showSettingsButton", "getShowSettingsButton", "aigc", "getAigc", "tribeeArg", "Lcom/bapis/bilibili/dynamic/common/KTribeeArg;", "getTribeeArg", "()Lcom/bapis/bilibili/dynamic/common/KTribeeArg;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishContent implements TribeePublishState {
    public static final Companion Companion = new Companion(null);
    private final List<KTribeeCategory> categories;
    private final NodeStorage<OuroDocument> content;
    private final boolean fromDraft;
    private final boolean fromEdit;
    private final KTribeePublishConfig limitInfo;
    private final OuroLocalImageState localImageState;
    private final KTribeeCategory selectedCategory;
    private final boolean sendToFollowing;
    private final Map<KUpPermissionType, TribeePublishSettingItem> settingItems;
    private final boolean showPublishConfirmDialog;
    private final String title;
    private final String toast;
    private final TribeeInfo tribeeInfo;
    private final Lazy unuploadedPictureCount$delegate;
    private final boolean validLimitInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TribeePublishContent copy$default(TribeePublishContent tribeePublishContent, String str, NodeStorage nodeStorage, OuroLocalImageState ouroLocalImageState, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, List list, KTribeeCategory kTribeeCategory, boolean z, Map map, boolean z2, boolean z3, boolean z4, boolean z5, String str2, int i, Object obj) {
        return tribeePublishContent.copy((i & 1) != 0 ? tribeePublishContent.title : str, (i & 2) != 0 ? tribeePublishContent.content : nodeStorage, (i & 4) != 0 ? tribeePublishContent.localImageState : ouroLocalImageState, (i & 8) != 0 ? tribeePublishContent.tribeeInfo : tribeeInfo, (i & 16) != 0 ? tribeePublishContent.limitInfo : kTribeePublishConfig, (i & 32) != 0 ? tribeePublishContent.categories : list, (i & 64) != 0 ? tribeePublishContent.selectedCategory : kTribeeCategory, (i & 128) != 0 ? tribeePublishContent.validLimitInfo : z, (i & 256) != 0 ? tribeePublishContent.settingItems : map, (i & 512) != 0 ? tribeePublishContent.sendToFollowing : z2, (i & 1024) != 0 ? tribeePublishContent.fromDraft : z3, (i & 2048) != 0 ? tribeePublishContent.fromEdit : z4, (i & 4096) != 0 ? tribeePublishContent.showPublishConfirmDialog : z5, (i & 8192) != 0 ? tribeePublishContent.toast : str2);
    }

    public static /* synthetic */ void getEditToast$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.sendToFollowing;
    }

    public final boolean component11() {
        return this.fromDraft;
    }

    public final boolean component12() {
        return this.fromEdit;
    }

    public final boolean component13() {
        return this.showPublishConfirmDialog;
    }

    public final String component14() {
        return this.toast;
    }

    public final NodeStorage<OuroDocument> component2() {
        return this.content;
    }

    public final OuroLocalImageState component3() {
        return this.localImageState;
    }

    public final TribeeInfo component4() {
        return this.tribeeInfo;
    }

    public final KTribeePublishConfig component5() {
        return this.limitInfo;
    }

    public final List<KTribeeCategory> component6() {
        return this.categories;
    }

    public final KTribeeCategory component7() {
        return this.selectedCategory;
    }

    public final boolean component8() {
        return this.validLimitInfo;
    }

    public final Map<KUpPermissionType, TribeePublishSettingItem> component9() {
        return this.settingItems;
    }

    public final TribeePublishContent copy(String str, NodeStorage<OuroDocument> nodeStorage, OuroLocalImageState ouroLocalImageState, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, List<KTribeeCategory> list, KTribeeCategory kTribeeCategory, boolean z, Map<KUpPermissionType, ? extends TribeePublishSettingItem> map, boolean z2, boolean z3, boolean z4, boolean z5, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(nodeStorage, "content");
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(kTribeePublishConfig, "limitInfo");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(map, "settingItems");
        return new TribeePublishContent(str, nodeStorage, ouroLocalImageState, tribeeInfo, kTribeePublishConfig, list, kTribeeCategory, z, map, z2, z3, z4, z5, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeePublishContent) {
            TribeePublishContent tribeePublishContent = (TribeePublishContent) obj;
            return Intrinsics.areEqual(this.title, tribeePublishContent.title) && Intrinsics.areEqual(this.content, tribeePublishContent.content) && Intrinsics.areEqual(this.localImageState, tribeePublishContent.localImageState) && Intrinsics.areEqual(this.tribeeInfo, tribeePublishContent.tribeeInfo) && Intrinsics.areEqual(this.limitInfo, tribeePublishContent.limitInfo) && Intrinsics.areEqual(this.categories, tribeePublishContent.categories) && Intrinsics.areEqual(this.selectedCategory, tribeePublishContent.selectedCategory) && this.validLimitInfo == tribeePublishContent.validLimitInfo && Intrinsics.areEqual(this.settingItems, tribeePublishContent.settingItems) && this.sendToFollowing == tribeePublishContent.sendToFollowing && this.fromDraft == tribeePublishContent.fromDraft && this.fromEdit == tribeePublishContent.fromEdit && this.showPublishConfirmDialog == tribeePublishContent.showPublishConfirmDialog && Intrinsics.areEqual(this.toast, tribeePublishContent.toast);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + (this.localImageState == null ? 0 : this.localImageState.hashCode())) * 31) + this.tribeeInfo.hashCode()) * 31) + this.limitInfo.hashCode()) * 31) + this.categories.hashCode()) * 31) + (this.selectedCategory == null ? 0 : this.selectedCategory.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.validLimitInfo)) * 31) + this.settingItems.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sendToFollowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromDraft)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromEdit)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showPublishConfirmDialog)) * 31) + (this.toast != null ? this.toast.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        NodeStorage<OuroDocument> nodeStorage = this.content;
        OuroLocalImageState ouroLocalImageState = this.localImageState;
        TribeeInfo tribeeInfo = this.tribeeInfo;
        KTribeePublishConfig kTribeePublishConfig = this.limitInfo;
        List<KTribeeCategory> list = this.categories;
        KTribeeCategory kTribeeCategory = this.selectedCategory;
        boolean z = this.validLimitInfo;
        Map<KUpPermissionType, TribeePublishSettingItem> map = this.settingItems;
        boolean z2 = this.sendToFollowing;
        boolean z3 = this.fromDraft;
        boolean z4 = this.fromEdit;
        boolean z5 = this.showPublishConfirmDialog;
        return "TribeePublishContent(title=" + str + ", content=" + nodeStorage + ", localImageState=" + ouroLocalImageState + ", tribeeInfo=" + tribeeInfo + ", limitInfo=" + kTribeePublishConfig + ", categories=" + list + ", selectedCategory=" + kTribeeCategory + ", validLimitInfo=" + z + ", settingItems=" + map + ", sendToFollowing=" + z2 + ", fromDraft=" + z3 + ", fromEdit=" + z4 + ", showPublishConfirmDialog=" + z5 + ", toast=" + this.toast + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TribeePublishContent(String title, NodeStorage<OuroDocument> nodeStorage, OuroLocalImageState localImageState, TribeeInfo tribeeInfo, KTribeePublishConfig limitInfo, List<KTribeeCategory> list, KTribeeCategory selectedCategory, boolean validLimitInfo, Map<KUpPermissionType, ? extends TribeePublishSettingItem> map, boolean sendToFollowing, boolean fromDraft, boolean fromEdit, boolean showPublishConfirmDialog, String toast) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(nodeStorage, "content");
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(limitInfo, "limitInfo");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(map, "settingItems");
        this.title = title;
        this.content = nodeStorage;
        this.localImageState = localImageState;
        this.tribeeInfo = tribeeInfo;
        this.limitInfo = limitInfo;
        this.categories = list;
        this.selectedCategory = selectedCategory;
        this.validLimitInfo = validLimitInfo;
        this.settingItems = map;
        this.sendToFollowing = sendToFollowing;
        this.fromDraft = fromDraft;
        this.fromEdit = fromEdit;
        this.showPublishConfirmDialog = showPublishConfirmDialog;
        this.toast = toast;
        this.unuploadedPictureCount$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.tribee.publish.core.v2.model.TribeePublishContent$$ExternalSyntheticLambda0
            public final Object invoke() {
                int unuploadedPictureCount_delegate$lambda$0;
                unuploadedPictureCount_delegate$lambda$0 = TribeePublishContent.unuploadedPictureCount_delegate$lambda$0(TribeePublishContent.this);
                return Integer.valueOf(unuploadedPictureCount_delegate$lambda$0);
            }
        });
    }

    public /* synthetic */ TribeePublishContent(String str, NodeStorage nodeStorage, OuroLocalImageState ouroLocalImageState, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, List list, KTribeeCategory kTribeeCategory, boolean z, Map map, boolean z2, boolean z3, boolean z4, boolean z5, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, nodeStorage, (i & 4) != 0 ? null : ouroLocalImageState, tribeeInfo, kTribeePublishConfig, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : kTribeeCategory, (i & 128) != 0 ? true : z, (i & 256) != 0 ? MapsKt.emptyMap() : map, (i & 512) != 0 ? true : z2, (i & 1024) != 0 ? false : z3, (i & 2048) != 0 ? false : z4, (i & 4096) != 0 ? false : z5, (i & 8192) != 0 ? null : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final NodeStorage<OuroDocument> getContent() {
        return this.content;
    }

    public final OuroLocalImageState getLocalImageState() {
        return this.localImageState;
    }

    public final TribeeInfo getTribeeInfo() {
        return this.tribeeInfo;
    }

    public final KTribeePublishConfig getLimitInfo() {
        return this.limitInfo;
    }

    public final List<KTribeeCategory> getCategories() {
        return this.categories;
    }

    public final KTribeeCategory getSelectedCategory() {
        return this.selectedCategory;
    }

    public final boolean getValidLimitInfo() {
        return this.validLimitInfo;
    }

    public final Map<KUpPermissionType, TribeePublishSettingItem> getSettingItems() {
        return this.settingItems;
    }

    public final boolean getSendToFollowing() {
        return this.sendToFollowing;
    }

    public final boolean getFromDraft() {
        return this.fromDraft;
    }

    public final boolean getFromEdit() {
        return this.fromEdit;
    }

    public final boolean getShowPublishConfirmDialog() {
        return this.showPublishConfirmDialog;
    }

    public final String getToast() {
        return this.toast;
    }

    /* compiled from: TribeePublishState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.core.v2.model.TribeePublishState
    public TribeePublishContent getPublishContent() {
        return this;
    }

    @Override // kntr.app.tribee.publish.core.v2.model.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        BSimpleLens<TribeePublishState, String> toast = TribeePublishContentLensKt.getToast(TribeePublishContentLensKt.getLens(Companion));
        Intrinsics.checkNotNull(toast, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.tribee.publish.core.v2.model.TribeePublishState, kotlin.String?>");
        return toast;
    }

    public final boolean getReadyForPublish() {
        return !StringsKt.isBlank(this.title) && ((long) this.title.length()) <= this.limitInfo.getTitleMaxLength() && ((long) this.content.getTextCount()) <= this.limitInfo.getContentMaxLength() && ((long) this.content.getPictureCount()) <= this.limitInfo.getPicMaxNum() && getContentNotEmpty() && this.validLimitInfo;
    }

    public final boolean getButtonValid() {
        return getContentNotEmpty() && this.validLimitInfo;
    }

    public final boolean getContentNotEmpty() {
        int textCount = this.content.getTextCount();
        int pictureCount = this.content.getPictureCount() - getUnuploadedPictureCount();
        boolean titleNotEmpty = this.title.length() > 0;
        return (textCount > 0 || pictureCount > 0) && titleNotEmpty;
    }

    public final int getUnuploadedPictureCount() {
        return ((Number) this.unuploadedPictureCount$delegate.getValue()).intValue();
    }

    public static final int unuploadedPictureCount_delegate$lambda$0(TribeePublishContent this$0) {
        if (this$0.localImageState != null) {
            return this$0.content.unuploadedPictureCount(this$0.localImageState);
        }
        return 0;
    }

    public final boolean getReadyForSaveDraft() {
        return !StringsKt.isBlank(this.title) || this.content.getTextCount() > 0 || this.content.getPictureCount() > 0 || this.fromDraft;
    }

    public final long getSelectedCategoryId() {
        KTribeeCategory kTribeeCategory = this.selectedCategory;
        if (kTribeeCategory != null) {
            return kTribeeCategory.getCategoryId();
        }
        return 0L;
    }

    public final boolean getShowSettingsButton() {
        return !this.settingItems.isEmpty();
    }

    public final int getAigc() {
        TribeePublishSettingItem it = this.settingItems.get(KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE);
        if (it instanceof TribeePublishSettingItem.Switch) {
            if (((TribeePublishSettingItem.Switch) it).isChecked()) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public final KTribeeArg getTribeeArg() {
        return new KTribeeArg(CollectionsKt.listOf(Long.valueOf(getSelectedCategoryId())));
    }
}