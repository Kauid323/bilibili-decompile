package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.comm.list.common.utils.BLRemoteConfigUtilKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageBubble;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.dialog.publish.BubbleShowHistory;
import tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt;

/* compiled from: TopTabBubbleDialogWrapper.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\u001c\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015\u001a\u0018\u0010%\u001a\u0004\u0018\u00010\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0002\u001a.\u0010&\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\"\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"TAG", "", TopTabBubbleDialogWrapperKt.KEY_TOP_BUBBLE_SHOW_TIMES_IN_SEVEN_DAYS, TopTabBubbleDialogWrapperKt.KEY_TOP_BUBBLE_SHOW_HISTORY, "mTopTabBubbleConfig", "Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubbleConfig;", "getMTopTabBubbleConfig", "()Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubbleConfig;", "mTopTabBubbleConfig$delegate", "Lkotlin/Lazy;", "mValidShowTimesSet", "", "getMValidShowTimesSet", "()Ljava/util/Set;", "mShowTimesInSevenDays", "", "getMShowTimesInSevenDays", "()I", "saveShowTimesInSevenDays", "", "mShowHistory", "", "Ltv/danmaku/bili/ui/main2/basic/dialog/publish/BubbleShowHistory;", "getMShowHistory", "()Ljava/util/List;", "saveItemShowHistory", "bubble", "Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "value", "showingPopupItem", "getShowingPopupItem", "()Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "showTopTabBubble", "", "anchor", "Landroid/view/View;", "list", "findSuitableItem", "loadImage", "item", "onSuccess", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabBubbleDialogWrapperKt {
    private static final String KEY_TOP_BUBBLE_SHOW_HISTORY = "KEY_TOP_BUBBLE_SHOW_HISTORY";
    private static final String KEY_TOP_BUBBLE_SHOW_TIMES_IN_SEVEN_DAYS = "KEY_TOP_BUBBLE_SHOW_TIMES_IN_SEVEN_DAYS";
    private static final String TAG = "TopTabBubbleDialogWrapper";
    private static final Lazy mTopTabBubbleConfig$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            TopTabBubbleConfig mTopTabBubbleConfig_delegate$lambda$0;
            mTopTabBubbleConfig_delegate$lambda$0 = TopTabBubbleDialogWrapperKt.mTopTabBubbleConfig_delegate$lambda$0();
            return mTopTabBubbleConfig_delegate$lambda$0;
        }
    });
    private static SecondaryPageBubble showingPopupItem;

    public static final TopTabBubbleConfig getMTopTabBubbleConfig() {
        return (TopTabBubbleConfig) mTopTabBubbleConfig$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TopTabBubbleConfig mTopTabBubbleConfig_delegate$lambda$0() {
        return (TopTabBubbleConfig) BLRemoteConfigUtilKt.getFawkesConfigJsonObject("main.top_tab_bubble_config", TopTabBubbleConfig.class, new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                TopTabBubbleConfig mTopTabBubbleConfig_delegate$lambda$0$0;
                mTopTabBubbleConfig_delegate$lambda$0$0 = TopTabBubbleDialogWrapperKt.mTopTabBubbleConfig_delegate$lambda$0$0();
                return mTopTabBubbleConfig_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TopTabBubbleConfig mTopTabBubbleConfig_delegate$lambda$0$0() {
        return new TopTabBubbleConfig(0L, 0L, 0, 0, 15, null);
    }

    private static final Set<String> getMValidShowTimesSet() {
        Iterable stringSet;
        long sevenDayStartTime = ((PublishBubbleDialogKt.getLocalNow() - PublishBubbleDialogKt.SEVEN_DAYS) / 86400000) * 86400000;
        Set $this$_get_mValidShowTimesSet__u24lambda_u240 = new LinkedHashSet();
        SharedPreferences kv = PublishBubbleDialogKt.getKv();
        if (kv != null && (stringSet = kv.getStringSet(KEY_TOP_BUBBLE_SHOW_TIMES_IN_SEVEN_DAYS, null)) != null) {
            Iterable $this$forEach$iv = stringSet;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                Intrinsics.checkNotNull(it);
                Long longOrNull = StringsKt.toLongOrNull(it);
                if (sevenDayStartTime < (longOrNull != null ? longOrNull.longValue() : 0L)) {
                    $this$_get_mValidShowTimesSet__u24lambda_u240.add(it);
                }
            }
        }
        return $this$_get_mValidShowTimesSet__u24lambda_u240;
    }

    private static final int getMShowTimesInSevenDays() {
        Set it = getMValidShowTimesSet();
        BLog.i(TAG, "valid show times:" + CollectionsKt.joinToString$default(it, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        return it.size();
    }

    public static final void saveShowTimesInSevenDays() {
        SharedPreferences.Editor edit;
        SharedPreferences kv = PublishBubbleDialogKt.getKv();
        if (kv != null && (edit = kv.edit()) != null) {
            Set $this$saveShowTimesInSevenDays_u24lambda_u240 = getMValidShowTimesSet();
            $this$saveShowTimesInSevenDays_u24lambda_u240.add(String.valueOf(PublishBubbleDialogKt.getLocalNow()));
            Unit unit = Unit.INSTANCE;
            SharedPreferences.Editor putStringSet = edit.putStringSet(KEY_TOP_BUBBLE_SHOW_TIMES_IN_SEVEN_DAYS, $this$saveShowTimesInSevenDays_u24lambda_u240);
            if (putStringSet != null) {
                putStringSet.apply();
            }
        }
    }

    private static final List<BubbleShowHistory> getMShowHistory() {
        String str;
        SharedPreferences kv = PublishBubbleDialogKt.getKv();
        if (kv == null || (str = kv.getString(KEY_TOP_BUBBLE_SHOW_HISTORY, null)) == null) {
            return CollectionsKt.emptyList();
        }
        try {
            List<BubbleShowHistory> parseArray = JSON.parseArray(str, BubbleShowHistory.class);
            Intrinsics.checkNotNull(parseArray);
            return parseArray;
        } catch (Exception e) {
            BLog.e(TAG, "getShowHistory failed", e);
            return CollectionsKt.emptyList();
        }
    }

    public static final void saveItemShowHistory(SecondaryPageBubble bubble) {
        Object obj;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        BubbleShowHistory it;
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        List showHistory = CollectionsKt.toMutableList(getMShowHistory());
        Iterator it2 = showHistory.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            BubbleShowHistory it3 = (BubbleShowHistory) obj;
            if (it3.getId() == bubble.getId()) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        BubbleShowHistory history = (BubbleShowHistory) obj;
        if (history == null) {
            BubbleShowHistory item = new BubbleShowHistory();
            item.setId(bubble.getId());
            item.setShowCount(1);
            showHistory.add(item);
        } else {
            history.setShowCount(history.getShowCount() + 1);
        }
        int pruneSize = showHistory.size() - 5;
        if (pruneSize > 0) {
            for (int i = 0; i < pruneSize; i++) {
                showHistory.remove(0);
            }
        }
        SharedPreferences kv = PublishBubbleDialogKt.getKv();
        if (kv == null || (edit = kv.edit()) == null || (putString = edit.putString(KEY_TOP_BUBBLE_SHOW_HISTORY, JSON.toJSONString(showHistory))) == null) {
            return;
        }
        putString.apply();
    }

    public static final SecondaryPageBubble getShowingPopupItem() {
        return showingPopupItem;
    }

    public static final boolean showTopTabBubble(final View anchor, List<SecondaryPageBubble> list) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(list, "list");
        BLog.i(TAG, "prepare show top tab bubble item:" + list + " anchor:" + anchor);
        final SecondaryPageBubble showItem = findSuitableItem(list);
        if (showItem != null) {
            WeakReference<TopTabBubbleMainDialog> mMainDialog = TopTabBubbleMainDialogKt.getMMainDialog();
            if ((mMainDialog != null ? mMainDialog.get() : null) != null || TopTabBubbleMainDialogKt.isDialogAdded()) {
                return false;
            }
            loadImage(anchor, showItem, new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit showTopTabBubble$lambda$0;
                    showTopTabBubble$lambda$0 = TopTabBubbleDialogWrapperKt.showTopTabBubble$lambda$0(anchor, showItem, (Drawable) obj);
                    return showTopTabBubble$lambda$0;
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTopTabBubble$lambda$0(final View $anchor, final SecondaryPageBubble $showItem, Drawable it) {
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(it, "it");
        final TopTabBubbleMainDialog mainDialog = new TopTabBubbleMainDialog($anchor, $showItem, it);
        Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TopTabBubbleDialogWrapperKt.showTopTabBubble$lambda$0$0(TopTabBubbleMainDialog.this, $anchor, $showItem);
            }
        };
        if (PublishBubbleDialogKt.getSplashExitTime() == 0) {
            coerceAtLeast = getMTopTabBubbleConfig().getDialogDelayShowTimeMillis();
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast((PublishBubbleDialogKt.getSplashExitTime() + getMTopTabBubbleConfig().getDialogDelayShowTimeMillis()) - System.currentTimeMillis(), 0L);
        }
        HandlerThreads.postDelayed(0, runnable, coerceAtLeast);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTopTabBubble$lambda$0$0(TopTabBubbleMainDialog $mainDialog, View $anchor, SecondaryPageBubble $showItem) {
        MainDialogManager.addDialog(new MainDialogManager.DialogManagerInfo("top_tab_bubble", $mainDialog, 2300), $anchor.getContext());
        TopTabBubbleMainDialogKt.setDialogAdded(true);
        showingPopupItem = $showItem;
        TopTabBubbleMainDialogKt.setMMainDialog(new WeakReference($mainDialog));
    }

    private static final SecondaryPageBubble findSuitableItem(List<SecondaryPageBubble> list) {
        Object obj;
        boolean it;
        Object obj2;
        List showHistory;
        BubbleShowHistory history;
        Object obj3 = null;
        if (list.isEmpty()) {
            return null;
        }
        if (getMShowTimesInSevenDays() >= getMTopTabBubbleConfig().getDialogMaxShowTimes()) {
            BLog.i(TAG, "has show " + getMTopTabBubbleConfig().getDialogMaxShowTimes() + " times in seven day.");
            return null;
        }
        List showHistory2 = getMShowHistory();
        BLog.i(TAG, "has show history:" + CollectionsKt.joinToString$default(showHistory2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj4) {
                CharSequence findSuitableItem$lambda$0;
                findSuitableItem$lambda$0 = TopTabBubbleDialogWrapperKt.findSuitableItem$lambda$0((BubbleShowHistory) obj4);
                return findSuitableItem$lambda$0;
            }
        }, 31, (Object) null));
        long serverTime = PublishBubbleDialogKt.getServerNow();
        if (serverTime < 0) {
            serverTime = PublishBubbleDialogKt.getLocalNow();
        }
        long serverTime2 = serverTime / 1000;
        List<SecondaryPageBubble> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SecondaryPageBubble bubble = (SecondaryPageBubble) element$iv$iv;
            Iterator<T> it2 = showHistory2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = obj3;
                    break;
                }
                obj2 = it2.next();
                BubbleShowHistory history2 = (BubbleShowHistory) obj2;
                if (history2.getId() == bubble.getId()) {
                    history = 1;
                    continue;
                } else {
                    history = null;
                    continue;
                }
                if (history != null) {
                    break;
                }
            }
            BubbleShowHistory bubbleShowHistory = (BubbleShowHistory) obj2;
            boolean it3 = (bubbleShowHistory != null ? bubbleShowHistory.getShowCount() : 0) < getMTopTabBubbleConfig().getSameIdDialogMaxShowTimes();
            if (it3) {
                showHistory = showHistory2;
            } else {
                showHistory = showHistory2;
                BLog.i(TAG, bubble.getId() + " has passed because of show count");
            }
            if (it3) {
                destination$iv$iv.add(element$iv$iv);
            }
            showHistory2 = showHistory;
            obj3 = null;
        }
        Iterator it4 = ((List) destination$iv$iv).iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj = null;
                break;
            }
            obj = it4.next();
            SecondaryPageBubble bubble2 = (SecondaryPageBubble) obj;
            if (bubble2.getStartTime() > 0 && bubble2.getEndTime() > 0) {
                it = serverTime2 > bubble2.getStartTime() && serverTime2 < bubble2.getEndTime();
                if (it) {
                    continue;
                } else {
                    BLog.i(TAG, bubble2.getId() + " has passed because of time gap");
                    continue;
                }
            } else {
                BLog.i(TAG, bubble2.getId() + " has found because of not has time gap");
                it = true;
                continue;
            }
            if (it) {
                break;
            }
        }
        SecondaryPageBubble it5 = (SecondaryPageBubble) obj;
        if (it5 != null) {
            BLog.i(TAG, it5.getId() + " is suitable item.");
        } else {
            BLog.i(TAG, "not found suitable item.");
        }
        return (SecondaryPageBubble) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findSuitableItem$lambda$0(BubbleShowHistory it) {
        Intrinsics.checkNotNullParameter(it, "it");
        long id = it.getId();
        return "[id:" + id + ":" + it.getShowCount() + "]";
    }

    private static final void loadImage(View anchor, SecondaryPageBubble item, final Function1<? super Drawable, Unit> function1) {
        BiliImageLoader.INSTANCE.acquire(anchor).useRaw().asDrawable().url(item.getIcon()).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt$loadImage$1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                DrawableHolder drawableHolder;
                Drawable drawable = (imageDataSource == null || (drawableHolder = (DrawableHolder) imageDataSource.getResult()) == null) ? null : drawableHolder.get();
                if (drawable == null || drawable.getIntrinsicWidth() < 1 || drawable.getIntrinsicHeight() < 1) {
                    BLog.i("TopTabBubbleDialogWrapper", "drawable is null");
                    return;
                }
                Function1<Drawable, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(drawable);
                }
                BLog.i("TopTabBubbleDialogWrapper", "download drawable success");
            }

            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                BLog.i("TopTabBubbleDialogWrapper", "download drawable onFailure", imageDataSource != null ? imageDataSource.getFailureCause() : null);
            }

            public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
                BLog.i("TopTabBubbleDialogWrapper", "download drawable onCancellation", imageDataSource != null ? imageDataSource.getFailureCause() : null);
            }
        });
    }
}