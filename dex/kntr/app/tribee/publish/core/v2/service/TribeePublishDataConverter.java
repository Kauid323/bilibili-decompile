package kntr.app.tribee.publish.core.v2.service;

import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermission;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* compiled from: TribeePublishDataConverter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJt\u0010\u0002\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH¦@¢\u0006\u0002\u0010\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "", "convert", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "toDraft", "", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "opus", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "sendToFollowing", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "selectedCategory", "settingItems", "", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSettingItem;", "fromDraft", "fromEdit", "(Lcom/bapis/bilibili/dynamic/common/KOpus;Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;ZLjava/util/List;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;Ljava/util/Map;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettingItems", "permission", "Lcom/bapis/bilibili/dynamic/common/KUpPermission;", "attachments", "Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;", "(Lcom/bapis/bilibili/dynamic/common/KUpPermission;Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishDataConverter {
    Object convert(KOpus kOpus, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, boolean z, List<KTribeeCategory> list, KTribeeCategory kTribeeCategory, Map<KUpPermissionType, ? extends TribeePublishSettingItem> map, boolean z2, boolean z3, Continuation<? super TribeePublishContent> continuation);

    Object convert(TribeePublishContent tribeePublishContent, boolean z, Continuation<? super KOpus> continuation);

    Object getSettingItems(KUpPermission kUpPermission, KOpusAttachments kOpusAttachments, Continuation<? super Map<KUpPermissionType, ? extends TribeePublishSettingItem>> continuation);

    /* compiled from: TribeePublishDataConverter.kt */
    /* renamed from: kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object convert$default(TribeePublishDataConverter tribeePublishDataConverter, KOpus kOpus, TribeeInfo tribeeInfo, KTribeePublishConfig kTribeePublishConfig, boolean z, List list, KTribeeCategory kTribeeCategory, Map map, boolean z2, boolean z3, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return tribeePublishDataConverter.convert(kOpus, tribeeInfo, kTribeePublishConfig, z, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : kTribeeCategory, (i & 64) != 0 ? MapsKt.emptyMap() : map, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    /* compiled from: TribeePublishDataConverter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}