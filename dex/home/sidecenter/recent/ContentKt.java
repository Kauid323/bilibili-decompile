package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KArcContentPool;
import com.bapis.bilibili.app.home.v1.KArcInfo;
import com.bapis.bilibili.app.home.v1.KFavContentPool;
import com.bapis.bilibili.app.home.v1.KFavInfo;
import com.bapis.bilibili.app.home.v1.KHalfWatchedVideo;
import com.bapis.bilibili.app.home.v1.KModuleInfo;
import com.bapis.bilibili.app.home.v1.KRecType;
import com.bapis.bilibili.app.home.v1.KRecentFav;
import com.bapis.bilibili.app.home.v1.KToView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\f\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\n2\u0006\u0010\u0004\u001a\u00020\u000b\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u0010H\u0007\u001a\u0011\u0010\u0016\u001a\u00020\u0012*\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015*\u0016\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0016\u0010\b\"\b\u0012\u0004\u0012\u00020\t0\u00012\b\u0012\u0004\u0012\u00020\t0\u0001¨\u0006\u001a"}, d2 = {"RecentVideo", "Lhome/sidecenter/recent/RecentModule;", "Lhome/sidecenter/recent/RecentVideoContent;", "Lhome/sidecenter/recent/RecentVideo;", "builder", "Lcom/bapis/bilibili/app/home/v1/KHalfWatchedVideo;", "RecentToView", "Lcom/bapis/bilibili/app/home/v1/KToView;", "RecentFav", "Lhome/sidecenter/recent/RecentFavContent;", "Lhome/sidecenter/recent/RecentFav;", "Lcom/bapis/bilibili/app/home/v1/KRecentFav;", "RecentContentPool", "Lhome/sidecenter/recent/RecentContentPool;", "b", "Lcom/bapis/bilibili/app/home/v1/KArcContentPool;", "Lcom/bapis/bilibili/app/home/v1/KFavContentPool;", "reportType", "", "Lcom/bapis/bilibili/app/home/v1/KRecType;", "getReportType", "(Lcom/bapis/bilibili/app/home/v1/KRecType;)Ljava/lang/String;", "toDisplayString", "Lkotlin/time/Duration;", "toDisplayString-LRDsOJo", "(J)Ljava/lang/String;", "sidecenter_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentKt {
    public static final RecentModule<RecentVideoContent> RecentVideo(KHalfWatchedVideo builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        KModuleInfo it = builder.getModuleInfo();
        RecentModuleInfo recentModuleInfo = it != null ? new RecentModuleInfo(it) : null;
        KArcContentPool it2 = builder.getArcContentPool();
        return new RecentModule<>(recentModuleInfo, it2 != null ? RecentContentPool(it2) : null, ModuleType.Video);
    }

    public static final RecentModule<RecentVideoContent> RecentToView(KToView builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        KModuleInfo it = builder.getModuleInfo();
        RecentModuleInfo recentModuleInfo = it != null ? new RecentModuleInfo(it) : null;
        KArcContentPool it2 = builder.getArcContentPool();
        return new RecentModule<>(recentModuleInfo, it2 != null ? RecentContentPool(it2) : null, ModuleType.ToView);
    }

    public static final RecentModule<RecentFavContent> RecentFav(KRecentFav builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        KModuleInfo it = builder.getModuleInfo();
        RecentModuleInfo recentModuleInfo = it != null ? new RecentModuleInfo(it) : null;
        KFavContentPool it2 = builder.getFavContentPool();
        return new RecentModule<>(recentModuleInfo, it2 != null ? RecentContentPool(it2) : null, ModuleType.Fav);
    }

    public static final RecentContentPool<RecentVideoContent> RecentContentPool(KArcContentPool b) {
        Intrinsics.checkNotNullParameter(b, "b");
        Iterable $this$map$iv = b.getShowArcs();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KArcInfo it = (KArcInfo) item$iv$iv;
            destination$iv$iv.add(new RecentVideoContent(it, false, false, 4, null));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        Iterable $this$map$iv2 = b.getBackupArcs();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KArcInfo it2 = (KArcInfo) item$iv$iv2;
            destination$iv$iv2.add(new RecentVideoContent(it2, true, false, 4, null));
            $this$map$iv2 = $this$map$iv2;
        }
        return new RecentContentPool<>(arrayList, (List) destination$iv$iv2);
    }

    public static final RecentContentPool<RecentFavContent> RecentContentPool(KFavContentPool b) {
        Intrinsics.checkNotNullParameter(b, "b");
        Iterable $this$map$iv = b.getShowFavs();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KFavInfo it = (KFavInfo) item$iv$iv;
            destination$iv$iv.add(new RecentFavContent(it, false, false, 4, null));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        Iterable $this$map$iv2 = b.getBackupFavs();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KFavInfo it2 = (KFavInfo) item$iv$iv2;
            destination$iv$iv2.add(new RecentFavContent(it2, true, false, 4, null));
            $this$map$iv2 = $this$map$iv2;
        }
        return new RecentContentPool<>(arrayList, (List) destination$iv$iv2);
    }

    public static final String getReportType(KRecType $this$reportType) {
        Intrinsics.checkNotNullParameter($this$reportType, "<this>");
        if (Intrinsics.areEqual($this$reportType, KRecType.REC_TYPE_UGC.INSTANCE)) {
            return "ugc";
        }
        if (!Intrinsics.areEqual($this$reportType, KRecType.REC_TYPE_OGV.INSTANCE) && !Intrinsics.areEqual($this$reportType, KRecType.REC_TYPE_SEASON.INSTANCE)) {
            return Intrinsics.areEqual($this$reportType, KRecType.REC_TYPE_FAV_FOLDER.INSTANCE) ? "playlist" : "";
        }
        return "pgc";
    }

    /* renamed from: toDisplayString-LRDsOJo  reason: not valid java name */
    public static final String m3058toDisplayStringLRDsOJo(long j) {
        StringBuilder $this$toDisplayString_LRDsOJo_u24lambda_u240 = new StringBuilder();
        long hours = Duration.getInWholeHours-impl(j);
        if (hours > 0) {
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(hours);
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(":");
        }
        long j2 = 60;
        long minutes = Duration.getInWholeMinutes-impl(j) % j2;
        if (!StringsKt.isBlank($this$toDisplayString_LRDsOJo_u24lambda_u240)) {
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(StringsKt.padStart(String.valueOf(minutes), 2, '0'));
        } else {
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(minutes);
        }
        $this$toDisplayString_LRDsOJo_u24lambda_u240.append(":");
        long seconds = Duration.getInWholeSeconds-impl(j) % j2;
        if (!StringsKt.isBlank($this$toDisplayString_LRDsOJo_u24lambda_u240)) {
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(StringsKt.padStart(String.valueOf(seconds), 2, '0'));
        } else {
            $this$toDisplayString_LRDsOJo_u24lambda_u240.append(seconds);
        }
        String sb = $this$toDisplayString_LRDsOJo_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}