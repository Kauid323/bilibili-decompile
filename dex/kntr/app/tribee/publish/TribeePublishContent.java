package kntr.app.tribee.publish;

import BottomSheetItemData$;
import com.bapis.bilibili.dynamic.common.KTribeeArg;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.tribee.publish.TribeePublishSettingItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextContent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TribeePublishContent.kt */
@Lens
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010-\u001a\u00020\u0000H\u0016J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u000fHÆ\u0003J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\u000fHÆ\u0003J\t\u0010U\u001a\u00020\u000fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009b\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010X\u001a\u00020\u000f2\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020CHÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030/8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b5\u0010&R\u0011\u00106\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b7\u0010&R\u0011\u00108\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b9\u0010&R\u0011\u0010:\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b;\u0010&R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bA\u0010&R\u0011\u0010B\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006^"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishContent;", "Lkntr/app/tribee/publish/TribeePublishState;", "title", "", "content", "Lkntr/common/paragraph/input/RichTextContent;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "selectedCategory", "validLimitInfo", "", "settingItems", "Lkntr/app/tribee/publish/TribeePublishSettingItem;", "sendToFollowing", "fromDraft", "fromEdit", "showPublishConfirmDialog", "toast", "<init>", "(Ljava/lang/String;Lkntr/common/paragraph/input/RichTextContent;Lkntr/app/tribee/publish/TribeeInfo;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;Ljava/util/List;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;ZLjava/util/List;ZZZZLjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getContent", "()Lkntr/common/paragraph/input/RichTextContent;", "getTribeeInfo", "()Lkntr/app/tribee/publish/TribeeInfo;", "getLimitInfo", "()Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "getCategories", "()Ljava/util/List;", "getSelectedCategory", "()Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "getValidLimitInfo", "()Z", "getSettingItems", "getSendToFollowing", "getFromDraft", "getFromEdit", "getShowPublishConfirmDialog", "getToast", "getPublishContent", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "getEditToast$annotations", "()V", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "readyForPublish", "getReadyForPublish", "buttonValid", "getButtonValid", "contentNotEmpty", "getContentNotEmpty", "readyForSaveDraft", "getReadyForSaveDraft", "selectedCategoryId", "", "getSelectedCategoryId", "()J", "showSettingsButton", "getShowSettingsButton", "aigc", "", "getAigc", "()I", "tribeeArg", "Lcom/bapis/bilibili/dynamic/common/KTribeeArg;", "getTribeeArg", "()Lcom/bapis/bilibili/dynamic/common/KTribeeArg;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishContent implements TribeePublishState {
    public static final Companion Companion = new Companion(null);
    private final List<KTribeeCategory> categories;
    private final RichTextContent content;
    private final boolean fromDraft;
    private final boolean fromEdit;
    private final KTribeePublishConfig limitInfo;
    private final KTribeeCategory selectedCategory;
    private final boolean sendToFollowing;
    private final List<TribeePublishSettingItem> settingItems;
    private final boolean showPublishConfirmDialog;
    private final String title;
    private final String toast;
    private final TribeeInfo tribeeInfo;
    private final boolean validLimitInfo;

    public static /* synthetic */ void getEditToast$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.fromDraft;
    }

    public final boolean component11() {
        return this.fromEdit;
    }

    public final boolean component12() {
        return this.showPublishConfirmDialog;
    }

    public final String component13() {
        return this.toast;
    }

    public final RichTextContent component2() {
        return this.content;
    }

    public final TribeeInfo component3() {
        return this.tribeeInfo;
    }

    public final KTribeePublishConfig component4() {
        return this.limitInfo;
    }

    public final List<KTribeeCategory> component5() {
        return this.categories;
    }

    public final KTribeeCategory component6() {
        return this.selectedCategory;
    }

    public final boolean component7() {
        return this.validLimitInfo;
    }

    public final List<TribeePublishSettingItem> component8() {
        return this.settingItems;
    }

    public final boolean component9() {
        return this.sendToFollowing;
    }

    public final TribeePublishContent copy(String str, RichTextContent richTextContent, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, List<KTribeeCategory> list, KTribeeCategory kTribeeCategory, boolean z, List<? extends TribeePublishSettingItem> list2, boolean z2, boolean z3, boolean z4, boolean z5, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(richTextContent, "content");
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(kTribeePublishConfig, "limitInfo");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(list2, "settingItems");
        return new TribeePublishContent(str, richTextContent, tribeeInfo, kTribeePublishConfig, list, kTribeeCategory, z, list2, z2, z3, z4, z5, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeePublishContent) {
            TribeePublishContent tribeePublishContent = (TribeePublishContent) obj;
            return Intrinsics.areEqual(this.title, tribeePublishContent.title) && Intrinsics.areEqual(this.content, tribeePublishContent.content) && Intrinsics.areEqual(this.tribeeInfo, tribeePublishContent.tribeeInfo) && Intrinsics.areEqual(this.limitInfo, tribeePublishContent.limitInfo) && Intrinsics.areEqual(this.categories, tribeePublishContent.categories) && Intrinsics.areEqual(this.selectedCategory, tribeePublishContent.selectedCategory) && this.validLimitInfo == tribeePublishContent.validLimitInfo && Intrinsics.areEqual(this.settingItems, tribeePublishContent.settingItems) && this.sendToFollowing == tribeePublishContent.sendToFollowing && this.fromDraft == tribeePublishContent.fromDraft && this.fromEdit == tribeePublishContent.fromEdit && this.showPublishConfirmDialog == tribeePublishContent.showPublishConfirmDialog && Intrinsics.areEqual(this.toast, tribeePublishContent.toast);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.tribeeInfo.hashCode()) * 31) + this.limitInfo.hashCode()) * 31) + this.categories.hashCode()) * 31) + (this.selectedCategory == null ? 0 : this.selectedCategory.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.validLimitInfo)) * 31) + this.settingItems.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sendToFollowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromDraft)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromEdit)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showPublishConfirmDialog)) * 31) + (this.toast != null ? this.toast.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        RichTextContent richTextContent = this.content;
        TribeeInfo tribeeInfo = this.tribeeInfo;
        KTribeePublishConfig kTribeePublishConfig = this.limitInfo;
        List<KTribeeCategory> list = this.categories;
        KTribeeCategory kTribeeCategory = this.selectedCategory;
        boolean z = this.validLimitInfo;
        List<TribeePublishSettingItem> list2 = this.settingItems;
        boolean z2 = this.sendToFollowing;
        boolean z3 = this.fromDraft;
        boolean z4 = this.fromEdit;
        boolean z5 = this.showPublishConfirmDialog;
        return "TribeePublishContent(title=" + str + ", content=" + richTextContent + ", tribeeInfo=" + tribeeInfo + ", limitInfo=" + kTribeePublishConfig + ", categories=" + list + ", selectedCategory=" + kTribeeCategory + ", validLimitInfo=" + z + ", settingItems=" + list2 + ", sendToFollowing=" + z2 + ", fromDraft=" + z3 + ", fromEdit=" + z4 + ", showPublishConfirmDialog=" + z5 + ", toast=" + this.toast + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TribeePublishContent(String title, RichTextContent content, TribeeInfo tribeeInfo, KTribeePublishConfig limitInfo, List<KTribeeCategory> list, KTribeeCategory selectedCategory, boolean validLimitInfo, List<? extends TribeePublishSettingItem> list2, boolean sendToFollowing, boolean fromDraft, boolean fromEdit, boolean showPublishConfirmDialog, String toast) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(limitInfo, "limitInfo");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(list2, "settingItems");
        this.title = title;
        this.content = content;
        this.tribeeInfo = tribeeInfo;
        this.limitInfo = limitInfo;
        this.categories = list;
        this.selectedCategory = selectedCategory;
        this.validLimitInfo = validLimitInfo;
        this.settingItems = list2;
        this.sendToFollowing = sendToFollowing;
        this.fromDraft = fromDraft;
        this.fromEdit = fromEdit;
        this.showPublishConfirmDialog = showPublishConfirmDialog;
        this.toast = toast;
    }

    public /* synthetic */ TribeePublishContent(String str, RichTextContent richTextContent, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, List list, KTribeeCategory kTribeeCategory, boolean z, List list2, boolean z2, boolean z3, boolean z4, boolean z5, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, richTextContent, tribeeInfo, kTribeePublishConfig, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : kTribeeCategory, (i & 64) != 0 ? true : z, (i & 128) != 0 ? CollectionsKt.emptyList() : list2, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? false : z4, (i & 2048) != 0 ? false : z5, (i & 4096) != 0 ? null : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final RichTextContent getContent() {
        return this.content;
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

    public final List<TribeePublishSettingItem> getSettingItems() {
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

    /* compiled from: TribeePublishContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.TribeePublishState
    public TribeePublishContent getPublishContent() {
        return this;
    }

    @Override // kntr.app.tribee.publish.TribeePublishState
    public BSimpleLens<TribeePublishState, String> getEditToast() {
        BSimpleLens<TribeePublishState, String> toast = TribeePublishContentLensKt.getToast(TribeePublishContentLensKt.getLens(Companion));
        Intrinsics.checkNotNull(toast, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.tribee.publish.TribeePublishState, kotlin.String?>");
        return toast;
    }

    public final boolean getReadyForPublish() {
        return !StringsKt.isBlank(this.title) && ((long) this.title.length()) <= this.limitInfo.getTitleMaxLength() && ((long) this.content.getTextCount()) <= this.limitInfo.getContentMaxLength() && ((long) this.content.getAssetCount()) <= this.limitInfo.getPicMaxNum() && getContentNotEmpty() && this.validLimitInfo;
    }

    public final boolean getButtonValid() {
        return getContentNotEmpty() && this.validLimitInfo;
    }

    public final boolean getContentNotEmpty() {
        if (this.content.getTextCount() > 0 || this.content.getAssetCount() > 0) {
            return this.title.length() > 0;
        }
        return false;
    }

    public final boolean getReadyForSaveDraft() {
        return !StringsKt.isBlank(this.title) || this.content.getTextCount() > 0 || this.content.getAssetCount() > 0 || this.fromDraft;
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
        Iterable $this$first$iv = this.settingItems;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(((TribeePublishSettingItem) element$iv).getType(), KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE)) {
                TribeePublishSettingItem it = (TribeePublishSettingItem) element$iv;
                if (it instanceof TribeePublishSettingItem.Switch) {
                    if (((TribeePublishSettingItem.Switch) it).isChecked()) {
                        return 1;
                    }
                    return 2;
                }
                return 0;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final KTribeeArg getTribeeArg() {
        return new KTribeeArg(CollectionsKt.listOf(Long.valueOf(getSelectedCategoryId())));
    }
}