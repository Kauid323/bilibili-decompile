package tv.danmaku.bili.ui.offline;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bili.resource.playerbaseres.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import com.bilibili.offline.StorageInfo;
import com.bilibili.playerbizcommonv2.history.CommonPlayerDBHelper;
import com.bilibili.playerdb.basic.PlayerDBEntity;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.bilibili.videodownloader.exceptions.ErrCode;
import com.bilibili.videodownloader.model.OfflinePermissionCode;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.season.Episode;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.widget.PinnedBottomPanelViewKt;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;

/* compiled from: OfflineUtil.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0012J\u001c\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010,J\u001a\u0010-\u001a\u00020.2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020\u0005H\u0007J\u0018\u00100\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J\u001c\u00101\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103J\u001c\u00104\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\n\u00102\u001a\u0006\u0012\u0002\b\u000303H\u0007J \u00105\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001aH\u0002J\u0018\u00108\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u00106\u001a\u00020\u001aH\u0002J\u0018\u00109\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010:\u001a\u00020\u001aH\u0007J\u001e\u0010;\u001a\u00020\u00152\u0006\u0010*\u001a\u00020<2\u0006\u0010:\u001a\u00020=2\u0006\u0010\u0017\u001a\u00020\u0012J\u0016\u0010>\u001a\u00020\u00052\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010@J\u000e\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006C"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineUtil;", "", "<init>", "()V", "TAG", "", "dbHelper", "Lcom/bilibili/playerbizcommonv2/history/CommonPlayerDBHelper;", "getDbHelper", "()Lcom/bilibili/playerbizcommonv2/history/CommonPlayerDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "getPlayedTimeV2", "", "typeInfo", "isEquals", "", "update", "Lcom/bilibili/offline/OfflineInfo;", "old", "updateData", "", "getPageTitle", "info", "getPlayId", "caclProgress", "", "DECEND_BY_MODIFY_TIME", "Ljava/util/Comparator;", "ASCEND_BY_SORT_INDEX", "getASCEND_BY_SORT_INDEX", "()Ljava/util/Comparator;", "setASCEND_BY_SORT_INDEX", "(Ljava/util/Comparator;)V", "compareByCreateTime", "o1", "o2", "createSortKey", "createKey", "getOfflineStorage", "", "Lcom/bilibili/offline/StorageInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)[Lcom/bilibili/offline/StorageInfo;", "buildColorString", "Landroid/text/SpannableString;", "str", "playedTime", "getErrInfo", "entry", "Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "code2Msg", "parseResolveError", "realErrorCode", "fdErrorCode", "parseMediaResolverError", "getFdErrorTips", "code", "showDownloadedVipDialog", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bilibili/videodownloader/model/OfflinePermissionCode;", "getOfflineInfoString", "offlineInfos", "", "getBangumiTypeName", "seasonType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineUtil {
    private static final String TAG = "OfflineUtil";
    public static final OfflineUtil INSTANCE = new OfflineUtil();
    private static final Lazy dbHelper$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda0
        public final Object invoke() {
            CommonPlayerDBHelper dbHelper_delegate$lambda$0;
            dbHelper_delegate$lambda$0 = OfflineUtil.dbHelper_delegate$lambda$0();
            return dbHelper_delegate$lambda$0;
        }
    });
    public static Comparator<OfflineInfo> DECEND_BY_MODIFY_TIME = new Comparator() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int DECEND_BY_MODIFY_TIME$lambda$0;
            DECEND_BY_MODIFY_TIME$lambda$0 = OfflineUtil.DECEND_BY_MODIFY_TIME$lambda$0((OfflineInfo) obj, (OfflineInfo) obj2);
            return DECEND_BY_MODIFY_TIME$lambda$0;
        }
    };
    private static Comparator<OfflineInfo> ASCEND_BY_SORT_INDEX = new Comparator() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int ASCEND_BY_SORT_INDEX$lambda$0;
            ASCEND_BY_SORT_INDEX$lambda$0 = OfflineUtil.ASCEND_BY_SORT_INDEX$lambda$0((OfflineInfo) obj, (OfflineInfo) obj2);
            return ASCEND_BY_SORT_INDEX$lambda$0;
        }
    };
    public static final int $stable = 8;

    /* compiled from: OfflineUtil.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflinePermissionCode.values().length];
            try {
                iArr[OfflinePermissionCode.Dolby.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflinePermissionCode.EpOffline.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflinePermissionCode.Vip.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OfflinePermissionCode.EpVip.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[OfflinePermissionCode.EpFreeQnVip.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[OfflinePermissionCode.EpPayOrVip.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[OfflinePermissionCode.EpPayOrVipFirst.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[OfflinePermissionCode.EpPay.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[OfflinePermissionCode.EpPayFirst.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[OfflinePermissionCode.EpPayPack.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[OfflinePermissionCode.EpTicketWhite.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private OfflineUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommonPlayerDBHelper dbHelper_delegate$lambda$0() {
        return new CommonPlayerDBHelper();
    }

    private final CommonPlayerDBHelper getDbHelper() {
        return (CommonPlayerDBHelper) dbHelper$delegate.getValue();
    }

    @JvmStatic
    public static final long getPlayedTimeV2(Object typeInfo) {
        long cid;
        PlayerDBEntity read;
        if (typeInfo == null) {
            return 0L;
        }
        if (typeInfo instanceof Page) {
            cid = ((Page) typeInfo).cid;
        } else if (typeInfo instanceof Episode) {
            Long l = ((Episode) typeInfo).danmakuId;
            cid = l != null ? l.longValue() : 0L;
        } else {
            cid = typeInfo instanceof DramaVideo ? ((DramaVideo) typeInfo).cid : 0L;
        }
        if (cid > 0 && (read = INSTANCE.getDbHelper().read(cid)) != null) {
            return read.currentPos;
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0151 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0106  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isEquals(OfflineInfo update, OfflineInfo old) {
        boolean isSameDrama;
        OfflineType offlineType;
        boolean isSameVideo;
        OfflineType offlineType2;
        boolean isSameBangumi;
        Long valueOf;
        Episode episode;
        Long valueOf2;
        Page page;
        if (update != null && old != null && update.id == old.id) {
            OfflineType offlineType3 = update.offlineType;
            Integer valueOf3 = offlineType3 != null ? Integer.valueOf(offlineType3.type) : null;
            OfflineType offlineType4 = old.offlineType;
            if (Intrinsics.areEqual(valueOf3, offlineType4 != null ? Integer.valueOf(offlineType4.type) : null)) {
                OfflineType offlineType5 = update.offlineType;
                if ((offlineType5 != null && offlineType5.type == OfflineType.TYPE_DRAMA) && (update.typeInfo instanceof DramaVideo) && (old.typeInfo instanceof DramaVideo)) {
                    Object obj = update.typeInfo;
                    DramaVideo dramaVideo = obj instanceof DramaVideo ? (DramaVideo) obj : null;
                    Long valueOf4 = dramaVideo != null ? Long.valueOf(dramaVideo.avid) : null;
                    Object obj2 = old.typeInfo;
                    DramaVideo dramaVideo2 = obj2 instanceof DramaVideo ? (DramaVideo) obj2 : null;
                    if (Intrinsics.areEqual(valueOf4, dramaVideo2 != null ? Long.valueOf(dramaVideo2.avid) : null)) {
                        Object obj3 = update.typeInfo;
                        DramaVideo dramaVideo3 = obj3 instanceof DramaVideo ? (DramaVideo) obj3 : null;
                        Long valueOf5 = dramaVideo3 != null ? Long.valueOf(dramaVideo3.cid) : null;
                        Object obj4 = old.typeInfo;
                        DramaVideo dramaVideo4 = obj4 instanceof DramaVideo ? (DramaVideo) obj4 : null;
                        if (Intrinsics.areEqual(valueOf5, dramaVideo4 != null ? Long.valueOf(dramaVideo4.cid) : null)) {
                            isSameDrama = true;
                            offlineType = update.offlineType;
                            if ((offlineType == null && offlineType.type == OfflineType.TYPE_VIDEO) && (update.typeInfo instanceof Page) && (old.typeInfo instanceof Page)) {
                                Object obj5 = update.typeInfo;
                                Page page2 = !(obj5 instanceof Page) ? (Page) obj5 : null;
                                valueOf2 = page2 == null ? Long.valueOf(page2.cid) : null;
                                Object obj6 = old.typeInfo;
                                page = !(obj6 instanceof Page) ? (Page) obj6 : null;
                                if (Intrinsics.areEqual(valueOf2, page == null ? Long.valueOf(page.cid) : null)) {
                                    isSameVideo = true;
                                    offlineType2 = update.offlineType;
                                    if ((offlineType2 == null && offlineType2.type == OfflineType.TYPE_BANGUMI) && (update.typeInfo instanceof Episode) && (old.typeInfo instanceof Episode)) {
                                        Object obj7 = update.typeInfo;
                                        Episode episode2 = !(obj7 instanceof Episode) ? (Episode) obj7 : null;
                                        valueOf = episode2 == null ? Long.valueOf(episode2.id) : null;
                                        Object obj8 = old.typeInfo;
                                        episode = !(obj8 instanceof Episode) ? (Episode) obj8 : null;
                                        if (Intrinsics.areEqual(valueOf, episode != null ? Long.valueOf(episode.id) : null)) {
                                            isSameBangumi = true;
                                            OfflineType offlineType6 = update.offlineType;
                                            boolean isSameAudio = offlineType6 == null && offlineType6.type == OfflineType.TYPE_AUDIO;
                                            return !isSameVideo || isSameBangumi || isSameAudio || isSameDrama;
                                        }
                                    }
                                    isSameBangumi = false;
                                    OfflineType offlineType62 = update.offlineType;
                                    if (offlineType62 == null) {
                                    }
                                    if (isSameVideo) {
                                    }
                                }
                            }
                            isSameVideo = false;
                            offlineType2 = update.offlineType;
                            if (offlineType2 == null && offlineType2.type == OfflineType.TYPE_BANGUMI) {
                                Object obj72 = update.typeInfo;
                                if (!(obj72 instanceof Episode)) {
                                }
                                if (episode2 == null) {
                                }
                                Object obj82 = old.typeInfo;
                                if (!(obj82 instanceof Episode)) {
                                }
                                if (Intrinsics.areEqual(valueOf, episode != null ? Long.valueOf(episode.id) : null)) {
                                }
                            }
                            isSameBangumi = false;
                            OfflineType offlineType622 = update.offlineType;
                            if (offlineType622 == null) {
                            }
                            if (isSameVideo) {
                            }
                        }
                    }
                }
                isSameDrama = false;
                offlineType = update.offlineType;
                if (offlineType == null && offlineType.type == OfflineType.TYPE_VIDEO) {
                    Object obj52 = update.typeInfo;
                    if (!(obj52 instanceof Page)) {
                    }
                    if (page2 == null) {
                    }
                    Object obj62 = old.typeInfo;
                    if (!(obj62 instanceof Page)) {
                    }
                    if (Intrinsics.areEqual(valueOf2, page == null ? Long.valueOf(page.cid) : null)) {
                    }
                }
                isSameVideo = false;
                offlineType2 = update.offlineType;
                if (offlineType2 == null && offlineType2.type == OfflineType.TYPE_BANGUMI) {
                }
                isSameBangumi = false;
                OfflineType offlineType6222 = update.offlineType;
                if (offlineType6222 == null) {
                }
                if (isSameVideo) {
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final void updateData(OfflineInfo update, OfflineInfo old) {
        if (update == null || old == null) {
            return;
        }
        old.totalBytes = update.totalBytes;
        old.downloadedBytes = update.downloadedBytes;
        old.offlineStatus = update.offlineStatus;
        old.canPlayInAdvance = update.canPlayInAdvance;
    }

    @JvmStatic
    public static final String getPageTitle(OfflineInfo info) {
        Object typeInfo;
        String str;
        Integer intOrNull;
        Integer intOrNull2;
        if (info == null || (typeInfo = info.typeInfo) == null) {
            return "";
        }
        if (typeInfo instanceof Page) {
            String str2 = ((Page) typeInfo).title;
            return str2 == null ? "" : str2;
        } else if (!(typeInfo instanceof Episode)) {
            return (!(typeInfo instanceof DramaVideo) || (str = ((DramaVideo) typeInfo).title) == null) ? "" : str;
        } else {
            StringBuilder title = new StringBuilder();
            if (StringUtil.isNumeric(((Episode) typeInfo).index)) {
                Object context = BiliContext.topActivity();
                if (context == null) {
                    context = FoundationAlias.getFapp();
                }
                int i = ((Episode) typeInfo).seasonType;
                int i2 = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
                if (i == 1 || ((Episode) typeInfo).seasonType == 4) {
                    Resources resources = ((ContextWrapper) context).getResources();
                    int i3 = R.plurals.playerbaseres_global_string_2329;
                    String str3 = ((Episode) typeInfo).index;
                    if (str3 != null && (intOrNull = StringsKt.toIntOrNull(str3)) != null) {
                        i2 = intOrNull.intValue();
                    }
                    title.append(resources.getQuantityString(i3, i2, ((Episode) typeInfo).index));
                } else {
                    Resources resources2 = ((ContextWrapper) context).getResources();
                    int i4 = bili.resource.favorites.R.plurals.favorites_global_string_261;
                    String str4 = ((Episode) typeInfo).index;
                    if (str4 != null && (intOrNull2 = StringsKt.toIntOrNull(str4)) != null) {
                        i2 = intOrNull2.intValue();
                    }
                    title.append(resources2.getQuantityString(i4, i2, ((Episode) typeInfo).index));
                }
            } else {
                title.append(((Episode) typeInfo).index);
            }
            title.append(" ").append(((Episode) typeInfo).title);
            String sb = title.toString();
            Intrinsics.checkNotNull(sb);
            return sb;
        }
    }

    @JvmStatic
    public static final long getPlayId(OfflineInfo info) {
        Page page;
        Intrinsics.checkNotNullParameter(info, "info");
        OfflineType offlineType = info.offlineType;
        Integer valueOf = offlineType != null ? Integer.valueOf(offlineType.type) : null;
        int i = OfflineType.TYPE_AUDIO;
        if (valueOf != null && valueOf.intValue() == i) {
            return info.id;
        }
        int i2 = OfflineType.TYPE_VIDEO;
        if (valueOf != null && valueOf.intValue() == i2) {
            Object obj = info.typeInfo;
            page = obj instanceof Page ? (Page) obj : null;
            if (page != null) {
                return page.cid;
            }
            return 0L;
        }
        int i3 = OfflineType.TYPE_DRAMA;
        if (valueOf != null && valueOf.intValue() == i3) {
            Object obj2 = info.typeInfo;
            page = obj2 instanceof DramaVideo ? (DramaVideo) obj2 : null;
            if (page != null) {
                return ((DramaVideo) page).cid;
            }
            return 0L;
        }
        int i4 = OfflineType.TYPE_BANGUMI;
        if (valueOf != null && valueOf.intValue() == i4) {
            Object obj3 = info.typeInfo;
            page = obj3 instanceof Episode ? (Episode) obj3 : null;
            if (page != null) {
                return ((Episode) page).id;
            }
            return 0L;
        }
        return 0L;
    }

    public final int caclProgress(OfflineInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.totalBytes == 0) {
            return 0;
        }
        return (int) (((((float) info.downloadedBytes) * 1.0f) / ((float) info.totalBytes)) * 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DECEND_BY_MODIFY_TIME$lambda$0(OfflineInfo o1, OfflineInfo o2) {
        if (o1 == null || o2 != null) {
            if (o1 != null || o2 == null) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                Intrinsics.checkNotNull(o1);
                long j = o1.modifyTime;
                Intrinsics.checkNotNull(o2);
                if (j > o2.modifyTime) {
                    return -1;
                }
                if (o1.modifyTime < o2.modifyTime) {
                    return 1;
                }
                return 0;
            }
            return -1;
        }
        return 1;
    }

    public final Comparator<OfflineInfo> getASCEND_BY_SORT_INDEX() {
        return ASCEND_BY_SORT_INDEX;
    }

    public final void setASCEND_BY_SORT_INDEX(Comparator<OfflineInfo> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<set-?>");
        ASCEND_BY_SORT_INDEX = comparator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ASCEND_BY_SORT_INDEX$lambda$0(OfflineInfo o1, OfflineInfo o2) {
        if (o1 == null || o2 != null) {
            if (o1 == null && o2 != null) {
                return -1;
            }
            if (o1 == null && o2 == null) {
                return 0;
            }
            Intrinsics.checkNotNull(o1);
            long j = o1.sortIndex;
            Intrinsics.checkNotNull(o2);
            if (j > o2.sortIndex) {
                return 1;
            }
            if (o1.sortIndex < o2.sortIndex) {
                return -1;
            }
            return INSTANCE.compareByCreateTime(o1, o2);
        }
        return 1;
    }

    private final int compareByCreateTime(OfflineInfo o1, OfflineInfo o2) {
        if (o1 == null || o2 != null) {
            if (o1 != null || o2 == null) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                Intrinsics.checkNotNull(o1);
                long j = o1.createTime;
                Intrinsics.checkNotNull(o2);
                if (j > o2.createTime) {
                    return 1;
                }
                if (o1.createTime < o2.createTime) {
                    return -1;
                }
                return 0;
            }
            return -1;
        }
        return 1;
    }

    @JvmStatic
    public static final long createSortKey(OfflineInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Object typeInfo = info.typeInfo;
        if (typeInfo instanceof Page) {
            return ((Page) typeInfo).page;
        }
        if (typeInfo instanceof Episode) {
            return ((Episode) typeInfo).sortIndex;
        }
        if (typeInfo instanceof DramaVideo) {
            return ((DramaVideo) typeInfo).createSortedKey();
        }
        return 0L;
    }

    @JvmStatic
    public static final String createKey(OfflineInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        OfflineType offlineType = info.offlineType;
        Integer valueOf = offlineType != null ? Integer.valueOf(offlineType.type) : null;
        int i = OfflineType.TYPE_AUDIO;
        if (valueOf != null && valueOf.intValue() == i) {
            return "audio_" + info.id;
        }
        int i2 = OfflineType.TYPE_VIDEO;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (info.getPageCount() != 0) {
                return "video_" + info.id;
            }
            long j = info.id;
            Object obj = info.typeInfo;
            Page page = obj instanceof Page ? (Page) obj : null;
            return "video_" + j + "_page_" + (page != null ? Long.valueOf(page.cid) : null);
        }
        int i3 = OfflineType.TYPE_BANGUMI;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (info.getPageCount() != 0) {
                return "bangumi_" + info.id;
            }
            long j2 = info.id;
            Object obj2 = info.typeInfo;
            Episode episode = obj2 instanceof Episode ? (Episode) obj2 : null;
            return "bangumi_" + j2 + "_page_" + (episode != null ? Long.valueOf(episode.id) : null);
        }
        int i4 = OfflineType.TYPE_PAGE;
        if (valueOf != null && valueOf.intValue() == i4) {
            Object typeInfo = info.typeInfo;
            if (typeInfo instanceof Page) {
                return "video_" + info.id + "_page_" + ((Page) typeInfo).cid;
            } else if (typeInfo instanceof Episode) {
                return "bangumi_" + info.id + "_page_" + ((Episode) typeInfo).id;
            } else if (typeInfo instanceof DramaVideo) {
                return "drama_" + info.id + "_video_" + ((DramaVideo) typeInfo).avid;
            } else {
                throw new IllegalArgumentException("unknown offline type");
            }
        }
        int i5 = OfflineType.TYPE_DRAMA;
        if (valueOf != null && valueOf.intValue() == i5) {
            if (info.getPageCount() != 0) {
                return "drama_" + info.id;
            }
            long j3 = info.id;
            Object obj3 = info.typeInfo;
            DramaVideo dramaVideo = obj3 instanceof DramaVideo ? (DramaVideo) obj3 : null;
            Long valueOf2 = dramaVideo != null ? Long.valueOf(dramaVideo.avid) : null;
            Object obj4 = info.typeInfo;
            DramaVideo dramaVideo2 = obj4 instanceof DramaVideo ? (DramaVideo) obj4 : null;
            return "drama_" + j3 + "_video_" + valueOf2 + (dramaVideo2 != null ? Long.valueOf(dramaVideo2.cid) : null);
        }
        throw new IllegalArgumentException("unknown offline type");
    }

    @JvmStatic
    public static final StorageInfo[] getOfflineStorage(Context context) {
        StorageInfo[] downloadVideoStorage = StorageHelper.getDownloadVideoStorage(context);
        Intrinsics.checkNotNullExpressionValue(downloadVideoStorage, "getDownloadVideoStorage(...)");
        return downloadVideoStorage;
    }

    @JvmStatic
    public static final SpannableString buildColorString(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        int color = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        SpannableString colorStr = SpannableString.valueOf(str);
        colorStr.setSpan(colorSpan, 0, str.length(), 17);
        Intrinsics.checkNotNull(colorStr);
        return colorStr;
    }

    @JvmStatic
    public static final String playedTime(Context context, OfflineInfo info) {
        int prg;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.duration != 0) {
            prg = MathKt.roundToInt(((((float) info.playedTime) * 1.0f) / ((float) info.duration)) * 100);
        } else {
            prg = 0;
        }
        if (prg < 1) {
            String string = context.getString(bili.resource.others.R.string.others_global_string_338);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(bili.resource.homepage.R.string.homepage_global_string_186, String.valueOf(prg));
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public final String getErrInfo(Context context, VideoDownloadEntry<?> videoDownloadEntry) {
        Intrinsics.checkNotNullParameter(context, "context");
        String prefix = context.getString(R.string.playerbaseres_global_string_1345);
        Intrinsics.checkNotNullExpressionValue(prefix, "getString(...)");
        if (videoDownloadEntry == null) {
            return prefix;
        }
        if (videoDownloadEntry.taskStopReason == VideoDownloadEntry.STOP_REASON_NETWORK || videoDownloadEntry.mLastErrorCode == 1002) {
            String string = context.getString(bili.resource.downloads.R.string.downloads_global_string_43);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (videoDownloadEntry.mLastErrorCode == 0) {
            return prefix;
        } else {
            String str = prefix + ":" + code2Msg(context, videoDownloadEntry);
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return str;
        }
    }

    @JvmStatic
    public static final String code2Msg(Context context, VideoDownloadEntry<?> videoDownloadEntry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoDownloadEntry, "entry");
        switch (ErrCode.getCoreError(videoDownloadEntry.mLastErrorCode)) {
            case -1:
                String string = context.getString(bili.resource.downloads.R.string.downloads_global_string_18);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 1:
            case 606:
                String string2 = context.getString(bili.resource.downloads.R.string.downloads_global_string_22);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 2:
            case 9:
            case 11:
            case 14:
                String string3 = context.getString(bili.resource.downloads.R.string.downloads_global_string_62);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 3:
                String string4 = context.getString(bili.resource.downloads.R.string.downloads_global_string_47);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 4:
            case 6:
                String string5 = context.getString(bili.resource.downloads.R.string.downloads_global_string_92);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 5:
                String string6 = context.getString(bili.resource.downloads.R.string.downloads_global_string_81);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
            case IjkMediaItem.BLIJKPlayMode_VOD_STORY_TELCOM_FREE /* 503 */:
            case 607:
                String string7 = context.getString(bili.resource.downloads.R.string.downloads_global_string_15);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
            case 307:
                String string8 = context.getString(bili.resource.downloads.R.string.downloads_global_string_100);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 10:
            case 13:
            case 302:
            case 303:
            case PinnedBottomPanelViewKt.DEFAULT_PEEK_HEIGHT /* 304 */:
            case 306:
            case 605:
                String string9 = context.getString(bili.resource.downloads.R.string.downloads_global_string_54);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 12:
            case 15:
            case 16:
            case 17:
                String string10 = context.getString(bili.resource.downloads.R.string.downloads_global_string_92);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 18:
            case 305:
                String string11 = context.getString(bili.resource.downloads.R.string.downloads_global_string_110);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 19:
                String string12 = context.getString(bili.resource.downloads.R.string.downloads_global_string_41);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 100:
                String string13 = context.getString(bili.resource.downloads.R.string.downloads_global_string_17);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 101:
                String string14 = context.getString(bili.resource.downloads.R.string.downloads_global_string_105);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                return string14;
            case 300:
                String string15 = context.getString(bili.resource.downloads.R.string.downloads_global_string_34);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return string15;
            case 301:
                String string16 = context.getString(bili.resource.downloads.R.string.downloads_global_string_28);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                return string16;
            case 400:
            case 402:
            case 500:
            case 603:
            case 604:
            case 1001:
            case IjkMediaPlayerTracker.BLIJK_EV_TRANSPORT_BUILD /* 2003 */:
            case IjkMediaPlayerTracker.BLIJK_EV_HTTP_BUILD /* 2004 */:
            case IjkMediaPlayerTracker.BLIJK_EV_FIRST_AUDIO_DATA /* 2005 */:
            case IjkMediaPlayerTracker.BLIJK_EV_FIRST_AUDIO_PKG /* 2006 */:
            case IjkMediaPlayerTracker.BLIJK_EV_FIRST_VIDEO_DATA /* 2007 */:
            case IjkMediaPlayerTracker.BLIJK_EV_FIRST_VIDEO_PKG /* 2008 */:
            case IjkMediaPlayerTracker.BLIJK_EV_HTTP_SEEK_BUILD /* 2009 */:
            case IjkMediaPlayerTracker.BLIJK_EV_ASSET_ITEM_START /* 2010 */:
            case 2011:
            case 2012:
            case 2013:
            case IjkMediaPlayerTracker.BLIJK_EV_P2P_STATUS /* 2014 */:
                String string17 = context.getString(bili.resource.downloads.R.string.downloads_global_string_57);
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                return string17;
            case 602:
                String string18 = context.getString(bili.resource.downloads.R.string.downloads_global_string_16);
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                return string18;
            case IjkMediaPlayerTracker.BLIJK_EV_START_PREPARE /* 1002 */:
                String string19 = context.getString(bili.resource.downloads.R.string.downloads_global_string_25);
                Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                return string19;
            case IjkMediaPlayerTracker.BLIJK_EV_HTTP_WILL_REBUILD /* 2001 */:
            case IjkMediaPlayerTracker.BLIJK_EV_DNS_BUILD /* 2002 */:
                return INSTANCE.parseResolveError(context, videoDownloadEntry.mLastErrorCode, videoDownloadEntry.mFdErrorCode);
            case 2015:
                String string20 = context.getString(bili.resource.others.R.string.others_global_string_25);
                Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
                return string20;
            case IjkMediaPlayerTracker.BLIJK_EV_LIVE_HEARTBEAT /* 2016 */:
                String string21 = context.getString(bili.resource.downloads.R.string.downloads_global_string_74);
                Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
                return string21;
            case 3001:
            case 3002:
            case 3003:
                String string22 = context.getString(bili.resource.downloads.R.string.downloads_global_string_8);
                Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                return string22;
            default:
                String string23 = context.getString(bili.resource.downloads.R.string.downloads_global_string_18);
                Intrinsics.checkNotNullExpressionValue(string23, "getString(...)");
                return string23;
        }
    }

    private final String parseResolveError(Context context, int realErrorCode, int fdErrorCode) {
        if (realErrorCode == WrapperErrorCode.UNICON_RESOLVE_UNSUPPORT_THIRD) {
            String string = context.getString(bili.resource.homepage.R.string.homepage_global_string_197);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (realErrorCode == WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_SEGMENT || realErrorCode == WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_IP) {
            return getFdErrorTips(context, fdErrorCode);
        } else {
            if (realErrorCode == WrapperErrorCode.UNICON_RESOLVE_CONDITION_NOT_MATHCED) {
                String string2 = context.getString(com.bilibili.fd_service.wrapper.R.string.unicom_video_download_error_condition);
                Intrinsics.checkNotNull(string2);
                return string2;
            } else if (realErrorCode == WrapperErrorCode.FHD_QUALITY_NOT_LOGIN) {
                String string3 = context.getString(bili.resource.downloads.R.string.downloads_global_string_64);
                Intrinsics.checkNotNull(string3);
                return string3;
            } else {
                return parseMediaResolverError(context, realErrorCode);
            }
        }
    }

    private final String parseMediaResolverError(Context context, int realErrorCode) {
        if (realErrorCode == ErrCode.E_RESOLVE_SUB_CODE_VIP_QUALITY || realErrorCode == ErrCode.E_RESOLVE_SUB_CODE_NO_PAY_UGC) {
            String string = context.getString(bili.resource.downloads.R.string.downloads_global_string_20);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(bili.resource.downloads.R.string.downloads_global_string_9);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    @JvmStatic
    public static final String getFdErrorTips(Context context, int code) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (code) {
            case 2000:
                String string = context.getString(bili.resource.homepage.R.string.homepage_global_string_313);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2036:
                String string2 = context.getString(bili.resource.others.R.string.others_global_string_367);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3026:
                String string3 = context.getString(bili.resource.homepage.R.string.homepage_global_string_263);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 3036:
                String string4 = context.getString(bili.resource.homepage.R.string.homepage_global_string_244);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 4000:
                String string5 = context.getString(bili.resource.homepage.R.string.homepage_global_string_222);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 4002:
                String string6 = context.getString(bili.resource.homepage.R.string.homepage_global_string_142);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 4004:
                String string7 = context.getString(bili.resource.homepage.R.string.homepage_global_string_378);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 5002:
                String string8 = context.getString(bili.resource.homepage.R.string.homepage_global_string_299);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 5004:
                String string9 = context.getString(bili.resource.homepage.R.string.homepage_global_string_293);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            default:
                String string10 = context.getString(bili.resource.others.R.string.others_global_string_107);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
        }
    }

    public final void showDownloadedVipDialog(final FragmentActivity context, OfflinePermissionCode code, final OfflineInfo info) {
        String title;
        String positiveContent;
        final Function0 positiveAction;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(info, "info");
        LogHelper.i(TAG, "code -> " + code + ", id -> " + info.id);
        Neurons.reportExposure$default(false, OfflineReportHelper.SHOW_VIP_DIALOG_DOWNLOADED, (Map) null, (List) null, 12, (Object) null);
        switch (WhenMappings.$EnumSwitchMapping$0[code.ordinal()]) {
            case 1:
                String string = context.getString(bili.resource.others.R.string.others_global_string_334);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                title = string;
                String string2 = context.getString(R.string.playerbaseres_global_string_630);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                positiveContent = string2;
                positiveAction = new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit showDownloadedVipDialog$lambda$0;
                        showDownloadedVipDialog$lambda$0 = OfflineUtil.showDownloadedVipDialog$lambda$0(info, context);
                        return showDownloadedVipDialog$lambda$0;
                    }
                };
                break;
            case 2:
                String string3 = context.getString(bili.resource.common.R.string.common_global_string_248);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                title = string3;
                String string4 = context.getString(bili.resource.common.R.string.common_global_string_205);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                positiveContent = string4;
                positiveAction = new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                break;
            case 3:
            case 4:
            case 5:
                String string5 = context.getString(bili.resource.others.R.string.others_global_string_331);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                title = string5;
                String string6 = context.getString(R.string.playerbaseres_global_string_630);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                positiveContent = string6;
                positiveAction = new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit showDownloadedVipDialog$lambda$2;
                        showDownloadedVipDialog$lambda$2 = OfflineUtil.showDownloadedVipDialog$lambda$2(context);
                        return showDownloadedVipDialog$lambda$2;
                    }
                };
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                String string7 = context.getString(bili.resource.others.R.string.others_global_string_308);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                title = string7;
                String string8 = context.getString(bili.resource.common.R.string.common_global_string_133);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                positiveContent = string8;
                positiveAction = new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit showDownloadedVipDialog$lambda$3;
                        showDownloadedVipDialog$lambda$3 = OfflineUtil.showDownloadedVipDialog$lambda$3(info, context);
                        return showDownloadedVipDialog$lambda$3;
                    }
                };
                break;
            default:
                String string9 = context.getString(bili.resource.common.R.string.common_global_string_248);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                title = string9;
                String string10 = context.getString(bili.resource.common.R.string.common_global_string_205);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                positiveContent = string10;
                positiveAction = new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                break;
        }
        BiliCommonDialog.Builder buttonStyle = new BiliCommonDialog.Builder((Context) context).setTitle(title).setButtonStyle(1);
        String string11 = context.getString(bili.resource.common.R.string.common_global_string_238);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        BiliCommonDialog build = BiliCommonDialog.Builder.setPositiveButton$default(BiliCommonDialog.Builder.setNegativeButton$default(buttonStyle, string11, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda8
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                OfflineReportHelper.reportVipDownloadedDialogClick(1);
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null), positiveContent, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineUtil$$ExternalSyntheticLambda9
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                positiveAction.invoke();
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null).build();
        FragmentManager supportFragmentManager = context.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        build.show(supportFragmentManager, "downloaded_vip_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDownloadedVipDialog$lambda$0(OfflineInfo $info, FragmentActivity $context) {
        Uri parse = Uri.parse("bilibili://user_center/vip/buy/26?appSubId=" + $info.dolbyReportAppSubId);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).build();
        BLRouter.routeTo(request, (Context) $context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDownloadedVipDialog$lambda$2(FragmentActivity $context) {
        Uri parse = Uri.parse("bilibili://user_center/vip/buy/26?appSubId=overdue");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).build();
        BLRouter.routeTo(request, (Context) $context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDownloadedVipDialog$lambda$3(OfflineInfo $info, FragmentActivity $context) {
        String str;
        Object typeInfo = $info.typeInfo;
        if (typeInfo instanceof Page) {
            str = "bilibili://video/" + $info.id;
        } else if (typeInfo instanceof DramaVideo) {
            str = "bilibili://video/" + ((DramaVideo) typeInfo).avid;
        } else if (typeInfo instanceof Episode) {
            str = "bilibili://pgc/season/ep/" + ((Episode) typeInfo).id;
        } else {
            str = "bilibili://video/" + $info.id;
        }
        String url = str;
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).build();
        BLRouter.routeTo(request, (Context) $context);
        return Unit.INSTANCE;
    }

    public final String getOfflineInfoString(Collection<OfflineInfo> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (OfflineInfo offlineInfo : collection) {
            sb.append(offlineInfo.title).append(",");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String getBangumiTypeName(int seasonType) {
        Application context = BiliContext.application();
        if (context == null) {
            return "";
        }
        switch (seasonType) {
            case 1:
                String string = context.getString(R.string.playerbaseres_global_string_575);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = context.getString(bili.resource.following.R.string.following_global_string_304);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = context.getString(R.string.playerbaseres_global_string_1062);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = context.getString(R.string.playerbaseres_global_string_732);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = context.getString(R.string.playerbaseres_global_string_985);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
            default:
                return "";
            case 7:
                String string6 = context.getString(bili.resource.others.R.string.others_global_string_20);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
        }
    }
}