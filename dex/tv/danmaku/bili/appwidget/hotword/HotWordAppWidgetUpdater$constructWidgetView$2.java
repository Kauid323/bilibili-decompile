package tv.danmaku.bili.appwidget.hotword;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.hotword.data.HotWordWidgetData;
import tv.danmaku.bili.appwidget.hotword.data.WidgetButtonData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/widget/RemoteViews;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$constructWidgetView$2", f = "HotWordAppWidgetUpdater.kt", i = {0, 0, 0, 0, 0}, l = {BR.endContent}, m = "invokeSuspend", n = {"remoteView", "buttons", "bitmapMap", "it", "start"}, s = {"L$0", "L$1", "L$2", "L$4", "J$0"}, v = 1)
public final class HotWordAppWidgetUpdater$constructWidgetView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViews>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ HotWordWidgetData $data;
    final /* synthetic */ boolean $withPic;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotWordAppWidgetUpdater$constructWidgetView$2(Context context, HotWordWidgetData hotWordWidgetData, boolean z, Continuation<? super HotWordAppWidgetUpdater$constructWidgetView$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$data = hotWordWidgetData;
        this.$withPic = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hotWordAppWidgetUpdater$constructWidgetView$2 = new HotWordAppWidgetUpdater$constructWidgetView$2(this.$context, this.$data, this.$withPic, continuation);
        hotWordAppWidgetUpdater$constructWidgetView$2.L$0 = obj;
        return hotWordAppWidgetUpdater$constructWidgetView$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RemoteViews> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01c0 -> B:62:0x01c6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object $result;
        List list;
        HotWordAppWidgetUpdater$constructWidgetView$2 hotWordAppWidgetUpdater$constructWidgetView$2;
        RemoteViews remoteView;
        Map bitmapMap;
        Map bitmapTaskMap;
        Iterator it;
        long start;
        RemoteViews remoteView2;
        List buttons;
        Map bitmapMap2;
        Context context;
        Map bitmapTaskMap2;
        Iterable filterNotNull;
        boolean isValid;
        List buttons2;
        PendingIntent createIntent;
        String search;
        PendingIntent intent;
        Uri uri;
        Bitmap it2;
        Map.Entry it3;
        Object $result2;
        Object $result3;
        HotWordAppWidgetUpdater$constructWidgetView$2 hotWordAppWidgetUpdater$constructWidgetView$22;
        Map bitmapMap3;
        Bitmap bitmap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Continuation continuation = null;
        int i = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                $result = obj;
                CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
                long start2 = SystemClock.elapsedRealtime();
                RemoteViews remoteView3 = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_hot_word_widget);
                List<WidgetButtonData> list2 = this.$data.buttons;
                if (list2 == null || (filterNotNull = CollectionsKt.filterNotNull(list2)) == null) {
                    list = null;
                } else {
                    Iterable $this$filterTo$iv$iv = filterNotNull;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        isValid = HotWordAppWidgetUpdaterKt.isValid((WidgetButtonData) element$iv$iv);
                        if (isValid) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    list = (List) destination$iv$iv;
                }
                List buttons3 = list;
                Map bitmapTaskMap3 = new LinkedHashMap();
                Map bitmapMap4 = new LinkedHashMap();
                if (this.$withPic) {
                    if (buttons3 != null) {
                        List $this$map$iv = buttons3;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv2.add(((WidgetButtonData) item$iv$iv).icon);
                        }
                        Iterable $this$filterTo$iv$iv2 = (List) destination$iv$iv2;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filterTo$iv$iv2) {
                            String it4 = (String) element$iv$iv2;
                            if (it4 != null ? !StringsKt.isBlank(it4) : false) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                        }
                        Iterable $this$forEach$iv = (List) destination$iv$iv3;
                        Context context2 = this.$context;
                        for (Object element$iv : $this$forEach$iv) {
                            String it5 = (String) element$iv;
                            if (it5 == null || bitmapTaskMap3.containsKey(it5)) {
                                context = context2;
                                bitmapTaskMap2 = bitmapTaskMap3;
                            } else {
                                context = context2;
                                bitmapTaskMap2 = bitmapTaskMap3;
                                bitmapTaskMap2.put(it5, BuildersKt.async$default($this$withContext, (CoroutineContext) null, (CoroutineStart) null, new HotWordAppWidgetUpdater$constructWidgetView$2$3$1(context2, it5, continuation), 3, (Object) null));
                            }
                            bitmapTaskMap3 = bitmapTaskMap2;
                            context2 = context;
                            continuation = null;
                        }
                        bitmapTaskMap = bitmapTaskMap3;
                    } else {
                        bitmapTaskMap = bitmapTaskMap3;
                    }
                    int size = bitmapTaskMap.size();
                    if (size > 0) {
                        BLog.i("HotWordAppWidgetUpdater", "constructWidgetView start downloading pics " + size);
                        Iterator it6 = bitmapTaskMap.entrySet().iterator();
                        hotWordAppWidgetUpdater$constructWidgetView$2 = this;
                        it = it6;
                        start = start2;
                        remoteView2 = remoteView3;
                        buttons = buttons3;
                        bitmapMap2 = bitmapMap4;
                        if (it.hasNext()) {
                            Object element$iv2 = it.next();
                            it3 = (Map.Entry) element$iv2;
                            hotWordAppWidgetUpdater$constructWidgetView$2.L$0 = remoteView2;
                            hotWordAppWidgetUpdater$constructWidgetView$2.L$1 = buttons;
                            hotWordAppWidgetUpdater$constructWidgetView$2.L$2 = bitmapMap2;
                            hotWordAppWidgetUpdater$constructWidgetView$2.L$3 = it;
                            hotWordAppWidgetUpdater$constructWidgetView$2.L$4 = it3;
                            hotWordAppWidgetUpdater$constructWidgetView$2.J$0 = start;
                            hotWordAppWidgetUpdater$constructWidgetView$2.label = i;
                            Object await = ((Deferred) it3.getValue()).await(hotWordAppWidgetUpdater$constructWidgetView$2);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            HotWordAppWidgetUpdater$constructWidgetView$2 hotWordAppWidgetUpdater$constructWidgetView$23 = hotWordAppWidgetUpdater$constructWidgetView$2;
                            $result2 = $result;
                            $result3 = await;
                            hotWordAppWidgetUpdater$constructWidgetView$22 = hotWordAppWidgetUpdater$constructWidgetView$23;
                            bitmapMap3 = bitmapMap2;
                            bitmap = (Bitmap) $result3;
                            if (bitmap != null) {
                                bitmapMap3.put(it3.getKey(), bitmap);
                            }
                            $result = $result2;
                            hotWordAppWidgetUpdater$constructWidgetView$2 = hotWordAppWidgetUpdater$constructWidgetView$22;
                            i = 1;
                            bitmapMap2 = bitmapMap3;
                            buttons = buttons;
                            if (it.hasNext()) {
                                BLog.i("HotWordAppWidgetUpdater", "constructWidgetView finish downloading pics " + (SystemClock.elapsedRealtime() - start));
                                buttons2 = buttons;
                                remoteView = remoteView2;
                                start2 = start;
                                bitmapMap = bitmapMap2;
                                int i2 = R.id.brand;
                                createIntent = HotWordAppWidgetUpdater.INSTANCE.createIntent(hotWordAppWidgetUpdater$constructWidgetView$2.$context, "", "bilibili", 3335, true);
                                remoteView.setOnClickPendingIntent(i2, createIntent);
                                if (!(buttons2 == null && (buttons2.isEmpty() ^ true))) {
                                    remoteView.removeAllViews(R.id.container_entrances);
                                    List $this$forEachIndexed$iv = buttons2;
                                    Context context3 = hotWordAppWidgetUpdater$constructWidgetView$2.$context;
                                    boolean z = hotWordAppWidgetUpdater$constructWidgetView$2.$withPic;
                                    int index$iv = 0;
                                    for (Object item$iv : $this$forEachIndexed$iv) {
                                        int index$iv2 = index$iv + 1;
                                        if (index$iv < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        WidgetButtonData widgetButtonData = (WidgetButtonData) item$iv;
                                        Object $result4 = $result;
                                        RemoteViews entranceView = new RemoteViews(context3.getPackageName(), R.layout.bili_include_widget_entrance);
                                        entranceView.setTextViewText(R.id.tv_entrance, widgetButtonData.text);
                                        if (z && (it2 = (Bitmap) bitmapMap.get(widgetButtonData.icon)) != null) {
                                            entranceView.setImageViewBitmap(R.id.iv_entrance, it2);
                                        }
                                        String $this$toUri$iv = widgetButtonData.url;
                                        if ($this$toUri$iv != null) {
                                            String position = "";
                                            try {
                                                uri = Uri.parse($this$toUri$iv);
                                            } catch (Exception e) {
                                                e = e;
                                            }
                                            try {
                                                String queryParameter = uri.getQueryParameter("position");
                                                if (queryParameter == null) {
                                                    queryParameter = "";
                                                }
                                                position = queryParameter;
                                            } catch (Exception e2) {
                                                e = e2;
                                                BLog.e("HotWordAppWidgetUpdater", e, new Function0() { // from class: tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$constructWidgetView$2$$ExternalSyntheticLambda0
                                                    public final Object invoke() {
                                                        Object invokeSuspend$lambda$5$1$0;
                                                        invokeSuspend$lambda$5$1$0 = HotWordAppWidgetUpdater$constructWidgetView$2.invokeSuspend$lambda$5$1$0();
                                                        return invokeSuspend$lambda$5$1$0;
                                                    }
                                                });
                                                intent = HotWordAppWidgetUpdater.createIntent$default(HotWordAppWidgetUpdater.INSTANCE, context3, widgetButtonData.url, position, index$iv + 3340, false, 16, null);
                                                entranceView.setOnClickPendingIntent(R.id.ll_entrance, intent);
                                                remoteView.addView(R.id.container_entrances, entranceView);
                                                $result = $result4;
                                                index$iv = index$iv2;
                                            }
                                            intent = HotWordAppWidgetUpdater.createIntent$default(HotWordAppWidgetUpdater.INSTANCE, context3, widgetButtonData.url, position, index$iv + 3340, false, 16, null);
                                        } else {
                                            intent = null;
                                        }
                                        entranceView.setOnClickPendingIntent(R.id.ll_entrance, intent);
                                        remoteView.addView(R.id.container_entrances, entranceView);
                                        $result = $result4;
                                        index$iv = index$iv2;
                                    }
                                }
                                BLog.i("HotWordAppWidgetUpdater", "constructWidgetView end " + (SystemClock.elapsedRealtime() - start2));
                                remoteView.setTextViewText(R.id.tv_hot_word, hotWordAppWidgetUpdater$constructWidgetView$2.$data.hotWord);
                                search = HotWordAppWidgetUpdater.INSTANCE.buildSearchUrl(hotWordAppWidgetUpdater$constructWidgetView$2.$data.searchJumpLink);
                                remoteView.setOnClickPendingIntent(R.id.container_search, HotWordAppWidgetUpdater.createIntent$default(HotWordAppWidgetUpdater.INSTANCE, hotWordAppWidgetUpdater$constructWidgetView$2.$context, search, "search", 3334, false, 16, null));
                                return remoteView;
                            }
                        }
                    }
                }
                hotWordAppWidgetUpdater$constructWidgetView$2 = this;
                remoteView = remoteView3;
                bitmapMap = bitmapMap4;
                buttons2 = buttons3;
                int i22 = R.id.brand;
                createIntent = HotWordAppWidgetUpdater.INSTANCE.createIntent(hotWordAppWidgetUpdater$constructWidgetView$2.$context, "", "bilibili", 3335, true);
                remoteView.setOnClickPendingIntent(i22, createIntent);
                if (!(buttons2 == null && (buttons2.isEmpty() ^ true))) {
                }
                BLog.i("HotWordAppWidgetUpdater", "constructWidgetView end " + (SystemClock.elapsedRealtime() - start2));
                remoteView.setTextViewText(R.id.tv_hot_word, hotWordAppWidgetUpdater$constructWidgetView$2.$data.hotWord);
                search = HotWordAppWidgetUpdater.INSTANCE.buildSearchUrl(hotWordAppWidgetUpdater$constructWidgetView$2.$data.searchJumpLink);
                remoteView.setOnClickPendingIntent(R.id.container_search, HotWordAppWidgetUpdater.createIntent$default(HotWordAppWidgetUpdater.INSTANCE, hotWordAppWidgetUpdater$constructWidgetView$2.$context, search, "search", 3334, false, 16, null));
                return remoteView;
            case 1:
                $result3 = obj;
                start = this.J$0;
                it3 = (Map.Entry) this.L$4;
                it = (Iterator) this.L$3;
                buttons = (List) this.L$1;
                remoteView2 = (RemoteViews) this.L$0;
                ResultKt.throwOnFailure($result3);
                hotWordAppWidgetUpdater$constructWidgetView$22 = this;
                $result2 = $result3;
                bitmapMap3 = (Map) this.L$2;
                bitmap = (Bitmap) $result3;
                if (bitmap != null) {
                }
                $result = $result2;
                hotWordAppWidgetUpdater$constructWidgetView$2 = hotWordAppWidgetUpdater$constructWidgetView$22;
                i = 1;
                bitmapMap2 = bitmapMap3;
                buttons = buttons;
                if (it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$5$1$0() {
        return "parse Exception";
    }
}