package kntr.app.tribee.publish.core.v2.serviceImpl;

import bili.resource.following.FollowingRes;
import bili.resource.following.String0_commonMainKt;
import com.bapis.bilibili.dynamic.common.KArticle;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KOpusContent;
import com.bapis.bilibili.dynamic.common.KOpusSource;
import com.bapis.bilibili.dynamic.common.KPubInfo;
import com.bapis.bilibili.dynamic.common.KTranslateResult;
import com.bapis.bilibili.dynamic.common.KTribee;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermission;
import com.bapis.bilibili.dynamic.common.KUpPermissionItem;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bapis.bilibili.dynamic.common.KVersion;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.service.LinkParseServiceImpl;
import kntr.common.ouro.core.converter.OpusConverterKt;
import kntr.common.ouro.core.di.OuroComponent;
import kntr.common.ouro.core.dsl.OuroNodeDSLKt;
import kntr.common.ouro.core.model.NodeStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeePublishDataConverterImpl.kt */
@TribeePublishScope
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJj\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u001dJ.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroComponent", "Lkntr/common/ouro/core/di/OuroComponent;", "<init>", "(Lkntr/common/ouro/core/di/OuroComponent;)V", "convert", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "toDraft", "", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "opus", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "sendToFollowing", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "selectedCategory", "settingItems", "", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSettingItem;", "fromDraft", "fromEdit", "(Lcom/bapis/bilibili/dynamic/common/KOpus;Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;ZLjava/util/List;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;Ljava/util/Map;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettingItems", "permission", "Lcom/bapis/bilibili/dynamic/common/KUpPermission;", "attachments", "Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;", "(Lcom/bapis/bilibili/dynamic/common/KUpPermission;Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishDataConverterImpl implements TribeePublishDataConverter {
    public static final Companion Companion = new Companion(null);
    public static final String DRAFT_ORIGIN_PREFIX = "draft-origin-";
    public static final String DRAFT_PREFIX = "draft-";
    private final OuroComponent ouroComponent;

    @Inject
    public TribeePublishDataConverterImpl(OuroComponent ouroComponent) {
        Intrinsics.checkNotNullParameter(ouroComponent, "ouroComponent");
        this.ouroComponent = ouroComponent;
    }

    /* compiled from: TribeePublishDataConverterImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl$Companion;", "", "<init>", "()V", "DRAFT_PREFIX", "", "DRAFT_ORIGIN_PREFIX", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter
    public Object convert(TribeePublishContent content, boolean toDraft, Continuation<? super KOpus> continuation) {
        int i;
        KTribee kTribee = new KTribee(content.getTribeeInfo().getTribeeId(), false, 2, (DefaultConstructorMarker) null);
        if (toDraft) {
            i = content.getAigc();
        } else {
            i = 0;
        }
        KOpusAttachments kOpusAttachments = new KOpusAttachments(kTribee, i);
        String title = content.getTitle();
        return new KOpus(0L, KOpusSource.MIXED_CONTENT.INSTANCE, title, 0L, (String) null, toDraft ? null : OpusConverterKt.toOpusContent(content.getContent(), content.getLocalImageState()), (List) null, new KPubInfo(0L, 0L, 0L, 0L, this.ouroComponent.getVersion(), 15, (DefaultConstructorMarker) null), (KArticle) null, (KVersion) null, 0L, kOpusAttachments, (KTranslateResult) null, (String) null, 14169, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object convert(KOpus opus, TribeeInfo tribeeInfo, KTribeePublishConfig limitInfo, boolean sendToFollowing, List<KTribeeCategory> list, KTribeeCategory selectedCategory, Map<KUpPermissionType, ? extends TribeePublishSettingItem> map, boolean fromDraft, boolean fromEdit, Continuation<? super TribeePublishContent> continuation) {
        TribeePublishDataConverterImpl$convert$2 tribeePublishDataConverterImpl$convert$2;
        String title;
        TribeeInfo tribeeInfo2;
        KTribeePublishConfig limitInfo2;
        boolean sendToFollowing2;
        List categories;
        KTribeeCategory selectedCategory2;
        Map settingItems;
        boolean fromEdit2;
        boolean fromDraft2;
        Object convertOpusContentToOuroStorage;
        NodeStorage Document$default;
        String str;
        NodeStorage nodeStorage;
        if (continuation instanceof TribeePublishDataConverterImpl$convert$2) {
            tribeePublishDataConverterImpl$convert$2 = (TribeePublishDataConverterImpl$convert$2) continuation;
            if ((tribeePublishDataConverterImpl$convert$2.label & Integer.MIN_VALUE) != 0) {
                tribeePublishDataConverterImpl$convert$2.label -= Integer.MIN_VALUE;
                Object $result = tribeePublishDataConverterImpl$convert$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeePublishDataConverterImpl$convert$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        title = opus.getTitle();
                        KOpusContent it = opus.getContent();
                        if (it != null) {
                            tribeePublishDataConverterImpl$convert$2.L$0 = SpillingKt.nullOutSpilledVariable(opus);
                            tribeeInfo2 = tribeeInfo;
                            tribeePublishDataConverterImpl$convert$2.L$1 = tribeeInfo2;
                            limitInfo2 = limitInfo;
                            tribeePublishDataConverterImpl$convert$2.L$2 = limitInfo2;
                            categories = list;
                            tribeePublishDataConverterImpl$convert$2.L$3 = categories;
                            selectedCategory2 = selectedCategory;
                            tribeePublishDataConverterImpl$convert$2.L$4 = selectedCategory2;
                            settingItems = map;
                            tribeePublishDataConverterImpl$convert$2.L$5 = settingItems;
                            tribeePublishDataConverterImpl$convert$2.L$6 = title;
                            tribeePublishDataConverterImpl$convert$2.L$7 = SpillingKt.nullOutSpilledVariable(it);
                            sendToFollowing2 = sendToFollowing;
                            tribeePublishDataConverterImpl$convert$2.Z$0 = sendToFollowing2;
                            tribeePublishDataConverterImpl$convert$2.Z$1 = fromDraft;
                            tribeePublishDataConverterImpl$convert$2.Z$2 = fromEdit;
                            tribeePublishDataConverterImpl$convert$2.I$0 = 0;
                            tribeePublishDataConverterImpl$convert$2.label = 1;
                            convertOpusContentToOuroStorage = OpusConverterKt.convertOpusContentToOuroStorage(it, new LinkParseServiceImpl(), tribeePublishDataConverterImpl$convert$2);
                            if (convertOpusContentToOuroStorage == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fromDraft2 = fromDraft;
                            fromEdit2 = fromEdit;
                            nodeStorage = (NodeStorage) convertOpusContentToOuroStorage;
                            if (nodeStorage != null) {
                                Document$default = nodeStorage;
                                str = title;
                                return new TribeePublishContent(str, Document$default, null, tribeeInfo2, limitInfo2, categories, selectedCategory2, false, settingItems, sendToFollowing2, fromDraft2, fromEdit2, false, null, 12420, null);
                            }
                            Document$default = OuroNodeDSLKt.Document$default(null, null, 3, null);
                            str = title;
                            return new TribeePublishContent(str, Document$default, null, tribeeInfo2, limitInfo2, categories, selectedCategory2, false, settingItems, sendToFollowing2, fromDraft2, fromEdit2, false, null, 12420, null);
                        }
                        tribeeInfo2 = tribeeInfo;
                        limitInfo2 = limitInfo;
                        sendToFollowing2 = sendToFollowing;
                        categories = list;
                        selectedCategory2 = selectedCategory;
                        settingItems = map;
                        fromEdit2 = fromEdit;
                        fromDraft2 = fromDraft;
                        Document$default = OuroNodeDSLKt.Document$default(null, null, 3, null);
                        str = title;
                        return new TribeePublishContent(str, Document$default, null, tribeeInfo2, limitInfo2, categories, selectedCategory2, false, settingItems, sendToFollowing2, fromDraft2, fromEdit2, false, null, 12420, null);
                    case 1:
                        int i = tribeePublishDataConverterImpl$convert$2.I$0;
                        fromEdit2 = tribeePublishDataConverterImpl$convert$2.Z$2;
                        fromDraft2 = tribeePublishDataConverterImpl$convert$2.Z$1;
                        boolean sendToFollowing3 = tribeePublishDataConverterImpl$convert$2.Z$0;
                        KOpusContent kOpusContent = (KOpusContent) tribeePublishDataConverterImpl$convert$2.L$7;
                        title = (String) tribeePublishDataConverterImpl$convert$2.L$6;
                        Map settingItems2 = (Map) tribeePublishDataConverterImpl$convert$2.L$5;
                        List categories2 = (List) tribeePublishDataConverterImpl$convert$2.L$3;
                        KTribeePublishConfig limitInfo3 = (KTribeePublishConfig) tribeePublishDataConverterImpl$convert$2.L$2;
                        TribeeInfo tribeeInfo3 = (TribeeInfo) tribeePublishDataConverterImpl$convert$2.L$1;
                        KOpus kOpus = (KOpus) tribeePublishDataConverterImpl$convert$2.L$0;
                        ResultKt.throwOnFailure($result);
                        convertOpusContentToOuroStorage = $result;
                        sendToFollowing2 = sendToFollowing3;
                        tribeeInfo2 = tribeeInfo3;
                        settingItems = settingItems2;
                        limitInfo2 = limitInfo3;
                        selectedCategory2 = (KTribeeCategory) tribeePublishDataConverterImpl$convert$2.L$4;
                        categories = categories2;
                        nodeStorage = (NodeStorage) convertOpusContentToOuroStorage;
                        if (nodeStorage != null) {
                        }
                        Document$default = OuroNodeDSLKt.Document$default(null, null, 3, null);
                        str = title;
                        return new TribeePublishContent(str, Document$default, null, tribeeInfo2, limitInfo2, categories, selectedCategory2, false, settingItems, sendToFollowing2, fromDraft2, fromEdit2, false, null, 12420, null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeePublishDataConverterImpl$convert$2 = new TribeePublishDataConverterImpl$convert$2(this, continuation);
        Object $result2 = tribeePublishDataConverterImpl$convert$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeePublishDataConverterImpl$convert$2.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0231  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00cb -> B:59:0x022d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0195 -> B:40:0x01a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01bb -> B:42:0x01d1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x020a -> B:55:0x0214). Please submit an issue!!! */
    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getSettingItems(KUpPermission permission, KOpusAttachments attachments, Continuation<? super Map<KUpPermissionType, ? extends TribeePublishSettingItem>> continuation) {
        TribeePublishDataConverterImpl$getSettingItems$1 tribeePublishDataConverterImpl$getSettingItems$1;
        TribeePublishDataConverterImpl tribeePublishDataConverterImpl;
        Iterable items;
        int $i$f$forEach;
        Map map;
        Iterable element$iv;
        Iterator it;
        TribeePublishDataConverterImpl tribeePublishDataConverterImpl2;
        Object $result;
        Object obj;
        Continuation $completion;
        TribeePublishDataConverterImpl$getSettingItems$1 tribeePublishDataConverterImpl$getSettingItems$12;
        KUpPermission permission2;
        KOpusAttachments attachments2;
        int i;
        Object element$iv2;
        KUpPermission permission3;
        KOpusAttachments attachments3;
        KUpPermissionItem item;
        KOpusAttachments attachments4;
        Map map2;
        Iterable $this$forEach$iv;
        Iterator it2;
        Object element$iv3;
        KUpPermissionItem item2;
        int $i$f$forEach2;
        int $i$f$forEach3;
        KUpPermission permission4;
        TribeePublishDataConverterImpl $result2;
        Object $result3;
        String str;
        String subtitle;
        KUpPermission permission5;
        String str2;
        Map map3;
        KOpusAttachments attachments5;
        Map map4;
        Iterable $this$forEach$iv2;
        Iterator it3;
        Object element$iv4;
        KUpPermissionItem item3;
        String str3;
        int $i$f$forEach4;
        int $i$f$forEach5;
        KUpPermission permission6;
        TribeePublishDataConverterImpl tribeePublishDataConverterImpl3;
        Object $result4;
        Map map5;
        KUpPermission permission7;
        TribeePublishSettingItem.Switch value;
        Map map6;
        Map map7;
        KOpusAttachments attachments6;
        KUpPermission permission8;
        boolean z;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof TribeePublishDataConverterImpl$getSettingItems$1) {
            tribeePublishDataConverterImpl$getSettingItems$1 = (TribeePublishDataConverterImpl$getSettingItems$1) $completion2;
            if ((tribeePublishDataConverterImpl$getSettingItems$1.label & Integer.MIN_VALUE) != 0) {
                tribeePublishDataConverterImpl$getSettingItems$1.label -= Integer.MIN_VALUE;
                tribeePublishDataConverterImpl = this;
                Object $result5 = tribeePublishDataConverterImpl$getSettingItems$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeePublishDataConverterImpl$getSettingItems$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result5);
                        Map map8 = new LinkedHashMap();
                        if (permission == null || (items = permission.getItems()) == null) {
                            return MapsKt.toMap(map8);
                        }
                        Iterable $this$forEach$iv3 = items;
                        $i$f$forEach = 0;
                        map = map8;
                        element$iv = $this$forEach$iv3;
                        it = $this$forEach$iv3.iterator();
                        tribeePublishDataConverterImpl2 = tribeePublishDataConverterImpl;
                        $result = $result5;
                        obj = coroutine_suspended;
                        $completion = $completion2;
                        tribeePublishDataConverterImpl$getSettingItems$12 = tribeePublishDataConverterImpl$getSettingItems$1;
                        permission2 = permission;
                        attachments2 = attachments;
                        if (it.hasNext()) {
                            element$iv2 = it.next();
                            item = (KUpPermissionItem) element$iv2;
                            map6 = map;
                            if (item.getPermission() == 1) {
                                if (Intrinsics.areEqual(item.getType(), KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE)) {
                                    str = item.getTitle();
                                    if (StringsKt.isBlank(str)) {
                                        StringResource following_global_string_1112 = String0_commonMainKt.getFollowing_global_string_1112(FollowingRes.INSTANCE.getString());
                                        Continuation $completion3 = $completion;
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$0 = SpillingKt.nullOutSpilledVariable(permission2);
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$1 = attachments2;
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$2 = map;
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$4 = it;
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$5 = SpillingKt.nullOutSpilledVariable(element$iv2);
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$6 = item;
                                        tribeePublishDataConverterImpl$getSettingItems$12.L$7 = null;
                                        tribeePublishDataConverterImpl$getSettingItems$12.I$0 = $i$f$forEach;
                                        tribeePublishDataConverterImpl$getSettingItems$12.I$1 = 0;
                                        tribeePublishDataConverterImpl$getSettingItems$12.I$2 = 0;
                                        tribeePublishDataConverterImpl$getSettingItems$12.label = 1;
                                        $result5 = StringResourcesKt.getString(following_global_string_1112, tribeePublishDataConverterImpl$getSettingItems$12);
                                        if ($result5 == obj) {
                                            return obj;
                                        }
                                        permission3 = permission2;
                                        $completion2 = $completion3;
                                        attachments3 = attachments2;
                                        tribeePublishDataConverterImpl$getSettingItems$1 = tribeePublishDataConverterImpl$getSettingItems$12;
                                        coroutine_suspended = obj;
                                        i = 0;
                                        map5 = map;
                                        str = (String) $result5;
                                        $result3 = $result;
                                        $result2 = tribeePublishDataConverterImpl2;
                                        $i$f$forEach2 = $i$f$forEach;
                                        $i$f$forEach3 = i;
                                        permission4 = permission3;
                                        attachments4 = attachments3;
                                        map2 = map5;
                                        it2 = it;
                                        item2 = item;
                                        $this$forEach$iv = element$iv;
                                        element$iv3 = element$iv2;
                                        Object element$iv5 = str;
                                        String str4 = (String) element$iv5;
                                        subtitle = item2.getSubtitle();
                                        if (StringsKt.isBlank(subtitle)) {
                                            Continuation $completion4 = $completion2;
                                            StringResource following_global_string_1113 = String0_commonMainKt.getFollowing_global_string_1113(FollowingRes.INSTANCE.getString());
                                            Object $result6 = $result3;
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$0 = SpillingKt.nullOutSpilledVariable(permission4);
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$1 = attachments4;
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$2 = map2;
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$3 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$4 = it2;
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$5 = SpillingKt.nullOutSpilledVariable(element$iv3);
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$6 = item2;
                                            tribeePublishDataConverterImpl$getSettingItems$1.L$7 = str4;
                                            tribeePublishDataConverterImpl$getSettingItems$1.I$0 = $i$f$forEach2;
                                            tribeePublishDataConverterImpl$getSettingItems$1.I$1 = $i$f$forEach3;
                                            tribeePublishDataConverterImpl$getSettingItems$1.I$2 = 0;
                                            tribeePublishDataConverterImpl$getSettingItems$1.label = 2;
                                            $result5 = StringResourcesKt.getString(following_global_string_1113, tribeePublishDataConverterImpl$getSettingItems$1);
                                            if ($result5 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $completion2 = $completion4;
                                            attachments5 = attachments4;
                                            map4 = map2;
                                            $this$forEach$iv2 = $this$forEach$iv;
                                            it3 = it2;
                                            element$iv4 = element$iv3;
                                            item3 = item2;
                                            str3 = str4;
                                            $i$f$forEach4 = $i$f$forEach2;
                                            $i$f$forEach5 = $i$f$forEach3;
                                            permission6 = permission4;
                                            tribeePublishDataConverterImpl3 = $result2;
                                            $result4 = $result6;
                                            $result = $result4;
                                            subtitle = (String) $result5;
                                            str2 = str3;
                                            it = it3;
                                            $completion = $completion2;
                                            permission5 = permission6;
                                            $i$f$forEach = $i$f$forEach4;
                                            item = item3;
                                            element$iv = $this$forEach$iv2;
                                            map3 = map4;
                                            tribeePublishDataConverterImpl2 = tribeePublishDataConverterImpl3;
                                            obj = coroutine_suspended;
                                            tribeePublishDataConverterImpl$getSettingItems$12 = tribeePublishDataConverterImpl$getSettingItems$1;
                                            attachments2 = attachments5;
                                            String str5 = subtitle;
                                            KUpPermissionType type = item.getType();
                                            if (attachments2 != null) {
                                                KOpusAttachments it4 = attachments2;
                                                permission8 = permission5;
                                                if (it4.isAigc() == 1) {
                                                    z = true;
                                                    value = new TribeePublishSettingItem.Switch(type, str2, str5, z, false, false, 48, null);
                                                    permission7 = permission8;
                                                    map7 = map3;
                                                    if (value == null) {
                                                        attachments6 = attachments2;
                                                    } else {
                                                        TribeePublishSettingItem.Switch it5 = value;
                                                        attachments6 = attachments2;
                                                        map7.put(item.getType(), it5);
                                                    }
                                                    attachments2 = attachments6;
                                                    permission2 = permission7;
                                                    map6 = map7;
                                                }
                                            } else {
                                                permission8 = permission5;
                                            }
                                            z = false;
                                            value = new TribeePublishSettingItem.Switch(type, str2, str5, z, false, false, 48, null);
                                            permission7 = permission8;
                                            map7 = map3;
                                            if (value == null) {
                                            }
                                            attachments2 = attachments6;
                                            permission2 = permission7;
                                            map6 = map7;
                                        } else {
                                            Object $result7 = $result3;
                                            $completion = $completion2;
                                            permission5 = permission4;
                                            str2 = str4;
                                            element$iv = $this$forEach$iv;
                                            obj = coroutine_suspended;
                                            item = item2;
                                            it = it2;
                                            map3 = map2;
                                            tribeePublishDataConverterImpl$getSettingItems$12 = tribeePublishDataConverterImpl$getSettingItems$1;
                                            $i$f$forEach = $i$f$forEach2;
                                            attachments2 = attachments4;
                                            tribeePublishDataConverterImpl2 = $result2;
                                            $result = $result7;
                                            String str52 = subtitle;
                                            KUpPermissionType type2 = item.getType();
                                            if (attachments2 != null) {
                                            }
                                            z = false;
                                            value = new TribeePublishSettingItem.Switch(type2, str2, str52, z, false, false, 48, null);
                                            permission7 = permission8;
                                            map7 = map3;
                                            if (value == null) {
                                            }
                                            attachments2 = attachments6;
                                            permission2 = permission7;
                                            map6 = map7;
                                        }
                                    } else {
                                        Continuation $completion5 = $completion;
                                        attachments4 = attachments2;
                                        tribeePublishDataConverterImpl$getSettingItems$1 = tribeePublishDataConverterImpl$getSettingItems$12;
                                        $result3 = $result;
                                        coroutine_suspended = obj;
                                        $result2 = tribeePublishDataConverterImpl2;
                                        permission4 = permission2;
                                        $i$f$forEach2 = $i$f$forEach;
                                        $i$f$forEach3 = 0;
                                        $completion2 = $completion5;
                                        map2 = map;
                                        it2 = it;
                                        item2 = item;
                                        $this$forEach$iv = element$iv;
                                        element$iv3 = element$iv2;
                                        Object element$iv52 = str;
                                        String str42 = (String) element$iv52;
                                        subtitle = item2.getSubtitle();
                                        if (StringsKt.isBlank(subtitle)) {
                                        }
                                    }
                                } else {
                                    permission7 = permission2;
                                    value = null;
                                    $completion = $completion;
                                    map7 = map;
                                    if (value == null) {
                                    }
                                    attachments2 = attachments6;
                                    permission2 = permission7;
                                    map6 = map7;
                                }
                            }
                            map = map6;
                            if (it.hasNext()) {
                                map8 = map;
                                return MapsKt.toMap(map8);
                            }
                        }
                        break;
                    case 1:
                        int i2 = tribeePublishDataConverterImpl$getSettingItems$1.I$2;
                        i = tribeePublishDataConverterImpl$getSettingItems$1.I$1;
                        $i$f$forEach = tribeePublishDataConverterImpl$getSettingItems$1.I$0;
                        KUpPermissionItem item4 = (KUpPermissionItem) tribeePublishDataConverterImpl$getSettingItems$1.L$6;
                        element$iv2 = tribeePublishDataConverterImpl$getSettingItems$1.L$5;
                        it = (Iterator) tribeePublishDataConverterImpl$getSettingItems$1.L$4;
                        element$iv = (Iterable) tribeePublishDataConverterImpl$getSettingItems$1.L$3;
                        KOpusAttachments attachments7 = (KOpusAttachments) tribeePublishDataConverterImpl$getSettingItems$1.L$1;
                        ResultKt.throwOnFailure($result5);
                        permission3 = (KUpPermission) tribeePublishDataConverterImpl$getSettingItems$1.L$0;
                        attachments3 = attachments7;
                        item = item4;
                        tribeePublishDataConverterImpl2 = tribeePublishDataConverterImpl;
                        $result = $result5;
                        map5 = (Map) tribeePublishDataConverterImpl$getSettingItems$1.L$2;
                        str = (String) $result5;
                        $result3 = $result;
                        $result2 = tribeePublishDataConverterImpl2;
                        $i$f$forEach2 = $i$f$forEach;
                        $i$f$forEach3 = i;
                        permission4 = permission3;
                        attachments4 = attachments3;
                        map2 = map5;
                        it2 = it;
                        item2 = item;
                        $this$forEach$iv = element$iv;
                        element$iv3 = element$iv2;
                        Object element$iv522 = str;
                        String str422 = (String) element$iv522;
                        subtitle = item2.getSubtitle();
                        if (StringsKt.isBlank(subtitle)) {
                        }
                        break;
                    case 2:
                        int i3 = tribeePublishDataConverterImpl$getSettingItems$1.I$2;
                        int i4 = tribeePublishDataConverterImpl$getSettingItems$1.I$1;
                        int $i$f$forEach6 = tribeePublishDataConverterImpl$getSettingItems$1.I$0;
                        KUpPermissionItem item5 = (KUpPermissionItem) tribeePublishDataConverterImpl$getSettingItems$1.L$6;
                        Object element$iv6 = tribeePublishDataConverterImpl$getSettingItems$1.L$5;
                        KOpusAttachments attachments8 = (KOpusAttachments) tribeePublishDataConverterImpl$getSettingItems$1.L$1;
                        ResultKt.throwOnFailure($result5);
                        attachments5 = attachments8;
                        map4 = (Map) tribeePublishDataConverterImpl$getSettingItems$1.L$2;
                        $this$forEach$iv2 = (Iterable) tribeePublishDataConverterImpl$getSettingItems$1.L$3;
                        it3 = (Iterator) tribeePublishDataConverterImpl$getSettingItems$1.L$4;
                        element$iv4 = element$iv6;
                        item3 = item5;
                        str3 = (String) tribeePublishDataConverterImpl$getSettingItems$1.L$7;
                        $i$f$forEach4 = $i$f$forEach6;
                        $i$f$forEach5 = i4;
                        permission6 = (KUpPermission) tribeePublishDataConverterImpl$getSettingItems$1.L$0;
                        tribeePublishDataConverterImpl3 = tribeePublishDataConverterImpl;
                        $result4 = $result5;
                        $result = $result4;
                        subtitle = (String) $result5;
                        str2 = str3;
                        it = it3;
                        $completion = $completion2;
                        permission5 = permission6;
                        $i$f$forEach = $i$f$forEach4;
                        item = item3;
                        element$iv = $this$forEach$iv2;
                        map3 = map4;
                        tribeePublishDataConverterImpl2 = tribeePublishDataConverterImpl3;
                        obj = coroutine_suspended;
                        tribeePublishDataConverterImpl$getSettingItems$12 = tribeePublishDataConverterImpl$getSettingItems$1;
                        attachments2 = attachments5;
                        String str522 = subtitle;
                        KUpPermissionType type22 = item.getType();
                        if (attachments2 != null) {
                        }
                        z = false;
                        value = new TribeePublishSettingItem.Switch(type22, str2, str522, z, false, false, 48, null);
                        permission7 = permission8;
                        map7 = map3;
                        if (value == null) {
                        }
                        attachments2 = attachments6;
                        permission2 = permission7;
                        map6 = map7;
                        map = map6;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeePublishDataConverterImpl = this;
        tribeePublishDataConverterImpl$getSettingItems$1 = new TribeePublishDataConverterImpl$getSettingItems$1(tribeePublishDataConverterImpl, $completion2);
        Object $result52 = tribeePublishDataConverterImpl$getSettingItems$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeePublishDataConverterImpl$getSettingItems$1.label) {
        }
    }
}