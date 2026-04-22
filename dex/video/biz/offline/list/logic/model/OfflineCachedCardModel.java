package video.biz.offline.list.logic.model;

import BottomSheetItemData$;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import io.ktor.http.CodecsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineCacheCardModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bK\u0010$J\u0010\u0010L\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bM\u0010$J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0010HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0013HÆ\u0003J\t\u0010S\u001a\u00020\u0015HÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003J®\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0001¢\u0006\u0004\bV\u0010WJ\u0013\u0010X\u001a\u00020\u00132\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0010HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u0002038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u001b\u00108\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b9\u0010\u001cR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u00178F¢\u0006\u0006\u001a\u0004\b<\u00101R\u0011\u0010=\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b>\u0010*R\u0013\u0010?\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bC\u0010\u001c¨\u0006\\"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "", "id", "", "coverUrl", "coverPath", "cardTag", "Lvideo/biz/offline/list/logic/model/CardTag;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "subTitle", "duration", "Lkotlin/time/Duration;", "progress", "size", "author", "danmakuCount", "", "link", "vipOnly", "", "bizType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "children", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/list/logic/model/CardTag;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getCoverUrl", "getCoverPath", "getCardTag", "()Lvideo/biz/offline/list/logic/model/CardTag;", "getTitle", "getSubTitle", "getDuration-UwyO8pc", "()J", "J", "getProgress-UwyO8pc", "getSize", "getAuthor", "getDanmakuCount", "()I", "getLink", "getVipOnly", "()Z", "getBizType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "getChildren", "()Ljava/util/List;", "progressPercent", "", "getProgressPercent", "()F", "progressPercent$delegate", "Lkotlin/Lazy;", "progressDesc", "getProgressDesc", "progressDesc$delegate", "keys", "getKeys", "childCount", "getChildCount", "entity", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "encodedTitle", "getEncodedTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component7-UwyO8pc", "component8", "component8-UwyO8pc", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "copy-qFwndlU", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/list/logic/model/CardTag;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Ljava/util/List;)Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "equals", "other", "hashCode", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCachedCardModel {
    public static final int $stable = 8;
    private final String author;
    private final OfflineVideoEntity.BizType bizType;
    private final CardTag cardTag;
    private final List<OfflineVideoEntity> children;
    private final String coverPath;
    private final String coverUrl;
    private final int danmakuCount;
    private final long duration;
    private final String id;
    private final String link;
    private final long progress;
    private final Lazy progressDesc$delegate;
    private final Lazy progressPercent$delegate;
    private final String size;
    private final String subTitle;
    private final String title;
    private final boolean vipOnly;

    public /* synthetic */ OfflineCachedCardModel(String str, String str2, String str3, CardTag cardTag, String str4, String str5, long j, long j2, String str6, String str7, int i, String str8, boolean z, OfflineVideoEntity.BizType bizType, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, cardTag, str4, str5, j, j2, str6, str7, i, str8, z, bizType, list);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.author;
    }

    public final int component11() {
        return this.danmakuCount;
    }

    public final String component12() {
        return this.link;
    }

    public final boolean component13() {
        return this.vipOnly;
    }

    public final OfflineVideoEntity.BizType component14() {
        return this.bizType;
    }

    public final List<OfflineVideoEntity> component15() {
        return this.children;
    }

    public final String component2() {
        return this.coverUrl;
    }

    public final String component3() {
        return this.coverPath;
    }

    public final CardTag component4() {
        return this.cardTag;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.subTitle;
    }

    /* renamed from: component7-UwyO8pc  reason: not valid java name */
    public final long m2792component7UwyO8pc() {
        return this.duration;
    }

    /* renamed from: component8-UwyO8pc  reason: not valid java name */
    public final long m2793component8UwyO8pc() {
        return this.progress;
    }

    public final String component9() {
        return this.size;
    }

    /* renamed from: copy-qFwndlU  reason: not valid java name */
    public final OfflineCachedCardModel m2794copyqFwndlU(String str, String str2, String str3, CardTag cardTag, String str4, String str5, long j, long j2, String str6, String str7, int i, String str8, boolean z, OfflineVideoEntity.BizType bizType, List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "coverUrl");
        Intrinsics.checkNotNullParameter(str3, "coverPath");
        Intrinsics.checkNotNullParameter(cardTag, "cardTag");
        Intrinsics.checkNotNullParameter(str4, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str6, "size");
        Intrinsics.checkNotNullParameter(str7, "author");
        Intrinsics.checkNotNullParameter(str8, "link");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(list, "children");
        return new OfflineCachedCardModel(str, str2, str3, cardTag, str4, str5, j, j2, str6, str7, i, str8, z, bizType, list, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineCachedCardModel) {
            OfflineCachedCardModel offlineCachedCardModel = (OfflineCachedCardModel) obj;
            return Intrinsics.areEqual(this.id, offlineCachedCardModel.id) && Intrinsics.areEqual(this.coverUrl, offlineCachedCardModel.coverUrl) && Intrinsics.areEqual(this.coverPath, offlineCachedCardModel.coverPath) && this.cardTag == offlineCachedCardModel.cardTag && Intrinsics.areEqual(this.title, offlineCachedCardModel.title) && Intrinsics.areEqual(this.subTitle, offlineCachedCardModel.subTitle) && Duration.equals-impl0(this.duration, offlineCachedCardModel.duration) && Duration.equals-impl0(this.progress, offlineCachedCardModel.progress) && Intrinsics.areEqual(this.size, offlineCachedCardModel.size) && Intrinsics.areEqual(this.author, offlineCachedCardModel.author) && this.danmakuCount == offlineCachedCardModel.danmakuCount && Intrinsics.areEqual(this.link, offlineCachedCardModel.link) && this.vipOnly == offlineCachedCardModel.vipOnly && this.bizType == offlineCachedCardModel.bizType && Intrinsics.areEqual(this.children, offlineCachedCardModel.children);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.id.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + this.cardTag.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.subTitle == null ? 0 : this.subTitle.hashCode())) * 31) + Duration.hashCode-impl(this.duration)) * 31) + Duration.hashCode-impl(this.progress)) * 31) + this.size.hashCode()) * 31) + this.author.hashCode()) * 31) + this.danmakuCount) * 31) + this.link.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.vipOnly)) * 31) + this.bizType.hashCode()) * 31) + this.children.hashCode();
    }

    public String toString() {
        String str = this.id;
        String str2 = this.coverUrl;
        String str3 = this.coverPath;
        CardTag cardTag = this.cardTag;
        String str4 = this.title;
        String str5 = this.subTitle;
        String str6 = Duration.toString-impl(this.duration);
        String str7 = Duration.toString-impl(this.progress);
        String str8 = this.size;
        String str9 = this.author;
        int i = this.danmakuCount;
        String str10 = this.link;
        boolean z = this.vipOnly;
        OfflineVideoEntity.BizType bizType = this.bizType;
        return "OfflineCachedCardModel(id=" + str + ", coverUrl=" + str2 + ", coverPath=" + str3 + ", cardTag=" + cardTag + ", title=" + str4 + ", subTitle=" + str5 + ", duration=" + str6 + ", progress=" + str7 + ", size=" + str8 + ", author=" + str9 + ", danmakuCount=" + i + ", link=" + str10 + ", vipOnly=" + z + ", bizType=" + bizType + ", children=" + this.children + ")";
    }

    private OfflineCachedCardModel(String id, String coverUrl, String coverPath, CardTag cardTag, String title, String subTitle, long duration, long progress, String size, String author, int danmakuCount, String link, boolean vipOnly, OfflineVideoEntity.BizType bizType, List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(cardTag, "cardTag");
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(list, "children");
        this.id = id;
        this.coverUrl = coverUrl;
        this.coverPath = coverPath;
        this.cardTag = cardTag;
        this.title = title;
        this.subTitle = subTitle;
        this.duration = duration;
        this.progress = progress;
        this.size = size;
        this.author = author;
        this.danmakuCount = danmakuCount;
        this.link = link;
        this.vipOnly = vipOnly;
        this.bizType = bizType;
        this.children = list;
        this.progressPercent$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.list.logic.model.OfflineCachedCardModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                float progressPercent_delegate$lambda$0;
                progressPercent_delegate$lambda$0 = OfflineCachedCardModel.progressPercent_delegate$lambda$0(OfflineCachedCardModel.this);
                return Float.valueOf(progressPercent_delegate$lambda$0);
            }
        });
        this.progressDesc$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.list.logic.model.OfflineCachedCardModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                String progressDesc_delegate$lambda$0;
                progressDesc_delegate$lambda$0 = OfflineCachedCardModel.progressDesc_delegate$lambda$0(OfflineCachedCardModel.this);
                return progressDesc_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ OfflineCachedCardModel(String str, String str2, String str3, CardTag cardTag, String str4, String str5, long j, long j2, String str6, String str7, int i, String str8, boolean z, OfflineVideoEntity.BizType bizType, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? CardTag.NONE : cardTag, str4, (i2 & 32) != 0 ? null : str5, j, j2, str6, str7, (i2 & 1024) != 0 ? 0 : i, (i2 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? "" : str8, (i2 & 4096) != 0 ? false : z, bizType, list, null);
    }

    public final String getId() {
        return this.id;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final CardTag getCardTag() {
        return this.cardTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m2795getDurationUwyO8pc() {
        return this.duration;
    }

    /* renamed from: getProgress-UwyO8pc  reason: not valid java name */
    public final long m2796getProgressUwyO8pc() {
        return this.progress;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final int getDanmakuCount() {
        return this.danmakuCount;
    }

    public final String getLink() {
        return this.link;
    }

    public final boolean getVipOnly() {
        return this.vipOnly;
    }

    public final OfflineVideoEntity.BizType getBizType() {
        return this.bizType;
    }

    public final List<OfflineVideoEntity> getChildren() {
        return this.children;
    }

    public final float getProgressPercent() {
        return ((Number) this.progressPercent$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float progressPercent_delegate$lambda$0(OfflineCachedCardModel this$0) {
        if (Duration.compareTo-LRDsOJo(this$0.progress, this$0.duration) > 0 || Duration.equals-impl0(this$0.progress, Duration.Companion.getZERO-UwyO8pc()) || Duration.equals-impl0(this$0.duration, Duration.Companion.getZERO-UwyO8pc())) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        return (((float) Duration.getInWholeMilliseconds-impl(this$0.progress)) * 1.0f) / ((float) Duration.getInWholeMilliseconds-impl(this$0.duration));
    }

    public final String getProgressDesc() {
        return (String) this.progressDesc$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String progressDesc_delegate$lambda$0(OfflineCachedCardModel this$0) {
        if (Duration.compareTo-LRDsOJo(this$0.progress, this$0.duration) > 0 || Duration.equals-impl0(this$0.progress, Duration.Companion.getZERO-UwyO8pc())) {
            return OfflineCacheCardModelKt.m2788formatPlayTimeLRDsOJo(this$0.duration);
        }
        if (Duration.compareTo-LRDsOJo(this$0.progress, Duration.Companion.getZERO-UwyO8pc()) < 0) {
            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_626(PlayerbaseresRes.INSTANCE.getString()));
        }
        String m2788formatPlayTimeLRDsOJo = OfflineCacheCardModelKt.m2788formatPlayTimeLRDsOJo(this$0.progress);
        return m2788formatPlayTimeLRDsOJo + " / " + OfflineCacheCardModelKt.m2788formatPlayTimeLRDsOJo(this$0.duration);
    }

    public final List<String> getKeys() {
        Iterable $this$map$iv = this.children;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) item$iv$iv;
            destination$iv$iv.add(it.getKey());
        }
        return (List) destination$iv$iv;
    }

    public final int getChildCount() {
        return this.children.size();
    }

    public final OfflineVideoEntity getEntity() {
        return (OfflineVideoEntity) CollectionsKt.firstOrNull(this.children);
    }

    public final String getEncodedTitle() {
        return CodecsKt.encodeURLPath$default(this.title, false, false, 3, (Object) null);
    }
}