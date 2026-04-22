package kntr.common.photonic.gallery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kntr.common.photonic.gallery.entity.AndroidAlbumInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Gallery.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lkntr/common/photonic/AlbumInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.Gallery$loadAlbums$2", f = "Gallery.android.kt", i = {}, l = {25, 26, 27, 27}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class Gallery$loadAlbums$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AlbumInfo>>, Object> {
    final /* synthetic */ GalleryLoadConfig $config;
    Object L$0;
    int label;

    /* compiled from: Gallery.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GalleryLoadConfig.MediaType.values().length];
            try {
                iArr[GalleryLoadConfig.MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GalleryLoadConfig.MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GalleryLoadConfig.MediaType.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gallery$loadAlbums$2(GalleryLoadConfig galleryLoadConfig, Continuation<? super Gallery$loadAlbums$2> continuation) {
        super(2, continuation);
        this.$config = galleryLoadConfig;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Gallery$loadAlbums$2(this.$config, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends AlbumInfo>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110 A[LOOP:1: B:39:0x010a->B:41:0x0110, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object loadImageAssets;
        Object loadVideoAssets;
        Object loadImageAssets2;
        List assets;
        Object loadVideoAssets2;
        Collection collection;
        AlbumInfo defaultAlbumInfo;
        ArrayList arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                switch (WhenMappings.$EnumSwitchMapping$0[this.$config.getMediaType().ordinal()]) {
                    case 1:
                        this.label = 1;
                        loadImageAssets = Gallery.INSTANCE.loadImageAssets(this.$config, (Continuation) this);
                        if (loadImageAssets == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        assets = (List) loadImageAssets;
                        defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
                        List listOf = CollectionsKt.listOf(defaultAlbumInfo);
                        Iterable $this$groupBy$iv = assets;
                        Map destination$iv$iv = new LinkedHashMap();
                        for (Object element$iv$iv : $this$groupBy$iv) {
                            AndroidAsset it = (AndroidAsset) element$iv$iv;
                            AlbumInfo albumInfo = it.getAlbumInfo();
                            Object value$iv$iv$iv = destination$iv$iv.get(albumInfo);
                            if (value$iv$iv$iv == null) {
                                arrayList = new ArrayList();
                                destination$iv$iv.put(albumInfo, arrayList);
                            } else {
                                arrayList = value$iv$iv$iv;
                            }
                            Object key$iv$iv$iv = arrayList;
                            List list$iv$iv = (List) key$iv$iv$iv;
                            list$iv$iv.add(element$iv$iv);
                        }
                        Map $this$mapNotNull$iv = destination$iv$iv;
                        int $i$f$mapNotNull = 0;
                        Collection destination$iv$iv2 = new ArrayList();
                        for (Map.Entry element$iv$iv$iv : $this$mapNotNull$iv.entrySet()) {
                            destination$iv$iv2.add(new AndroidAlbumInfo(((AlbumInfo) element$iv$iv$iv.getKey()).getTitle(), ((AlbumInfo) element$iv$iv$iv.getKey()).getId(), (List) element$iv$iv$iv.getValue()));
                            assets = assets;
                            $this$mapNotNull$iv = $this$mapNotNull$iv;
                            $i$f$mapNotNull = $i$f$mapNotNull;
                        }
                        return CollectionsKt.plus(listOf, (List) destination$iv$iv2);
                    case 2:
                        this.label = 2;
                        loadVideoAssets = Gallery.INSTANCE.loadVideoAssets(this.$config, (Continuation) this);
                        if (loadVideoAssets == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        assets = (List) loadVideoAssets;
                        defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
                        List listOf2 = CollectionsKt.listOf(defaultAlbumInfo);
                        Iterable $this$groupBy$iv2 = assets;
                        Map destination$iv$iv3 = new LinkedHashMap();
                        while (r8.hasNext()) {
                        }
                        Map $this$mapNotNull$iv2 = destination$iv$iv3;
                        int $i$f$mapNotNull2 = 0;
                        Collection destination$iv$iv22 = new ArrayList();
                        while (r10.hasNext()) {
                        }
                        return CollectionsKt.plus(listOf2, (List) destination$iv$iv22);
                    case 3:
                        this.label = 3;
                        loadImageAssets2 = Gallery.INSTANCE.loadImageAssets(this.$config, (Continuation) this);
                        if (loadImageAssets2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                loadImageAssets = $result;
                assets = (List) loadImageAssets;
                defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
                List listOf22 = CollectionsKt.listOf(defaultAlbumInfo);
                Iterable $this$groupBy$iv22 = assets;
                Map destination$iv$iv32 = new LinkedHashMap();
                while (r8.hasNext()) {
                }
                Map $this$mapNotNull$iv22 = destination$iv$iv32;
                int $i$f$mapNotNull22 = 0;
                Collection destination$iv$iv222 = new ArrayList();
                while (r10.hasNext()) {
                }
                return CollectionsKt.plus(listOf22, (List) destination$iv$iv222);
            case 2:
                ResultKt.throwOnFailure($result);
                loadVideoAssets = $result;
                assets = (List) loadVideoAssets;
                defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
                List listOf222 = CollectionsKt.listOf(defaultAlbumInfo);
                Iterable $this$groupBy$iv222 = assets;
                Map destination$iv$iv322 = new LinkedHashMap();
                while (r8.hasNext()) {
                }
                Map $this$mapNotNull$iv222 = destination$iv$iv322;
                int $i$f$mapNotNull222 = 0;
                Collection destination$iv$iv2222 = new ArrayList();
                while (r10.hasNext()) {
                }
                return CollectionsKt.plus(listOf222, (List) destination$iv$iv2222);
            case 3:
                ResultKt.throwOnFailure($result);
                loadImageAssets2 = $result;
                break;
            case 4:
                collection = (Collection) this.L$0;
                ResultKt.throwOnFailure($result);
                loadVideoAssets2 = $result;
                assets = CollectionsKt.plus(collection, (Iterable) loadVideoAssets2);
                defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
                List listOf2222 = CollectionsKt.listOf(defaultAlbumInfo);
                Iterable $this$groupBy$iv2222 = assets;
                Map destination$iv$iv3222 = new LinkedHashMap();
                while (r8.hasNext()) {
                }
                Map $this$mapNotNull$iv2222 = destination$iv$iv3222;
                int $i$f$mapNotNull2222 = 0;
                Collection destination$iv$iv22222 = new ArrayList();
                while (r10.hasNext()) {
                }
                return CollectionsKt.plus(listOf2222, (List) destination$iv$iv22222);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Collection collection2 = (Collection) loadImageAssets2;
        this.L$0 = collection2;
        this.label = 4;
        loadVideoAssets2 = Gallery.INSTANCE.loadVideoAssets(this.$config, (Continuation) this);
        if (loadVideoAssets2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        collection = collection2;
        assets = CollectionsKt.plus(collection, (Iterable) loadVideoAssets2);
        defaultAlbumInfo = Gallery.INSTANCE.defaultAlbumInfo(assets);
        List listOf22222 = CollectionsKt.listOf(defaultAlbumInfo);
        Iterable $this$groupBy$iv22222 = assets;
        Map destination$iv$iv32222 = new LinkedHashMap();
        while (r8.hasNext()) {
        }
        Map $this$mapNotNull$iv22222 = destination$iv$iv32222;
        int $i$f$mapNotNull22222 = 0;
        Collection destination$iv$iv222222 = new ArrayList();
        while (r10.hasNext()) {
        }
        return CollectionsKt.plus(listOf22222, (List) destination$iv$iv222222);
    }
}