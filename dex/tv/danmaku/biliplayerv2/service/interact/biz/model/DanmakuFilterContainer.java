package tv.danmaku.biliplayerv2.service.interact.biz.model;

import android.content.Context;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockedKeywords;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.GlobalBlockedKeywords;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UserKeywordItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuFilterContainer.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J;\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJM\u0010\u001d\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001f\u0018\u00010\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010 JA\u0010!\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\"\u001a\u00020\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010#JJ\u0010$\u001a\u00020\r\"\b\b\u0000\u0010%*\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H%0\u000fH\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer;", "", "<init>", "()V", "mResolveToken", "Lbolts/CancellationTokenSource;", "mFilterChangedListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer$DanmakuFilterChangedListener;", "mDmviewRegexfilters", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setDmViewRegexFilters", "", "filters", "", "clear", "", "loadLocalFilters", "context", "Landroid/content/Context;", "appendFilters", "shieldUserId", "regexFilter", "nativeId", "", "onSuccess", "Ljava/lang/Runnable;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Runnable;)V", "resolveDanamkuFilters", "Lkotlin/Triple;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)Lkotlin/Triple;", "resolveDanmakuFilter", "force", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Runnable;)V", "filterData", "T", "Ltv/danmaku/biliplayerv2/widget/function/danmaku/filter/BaseKeywordItem;", "userHashList", "contentList", "regexList", "data", "compileRegexKeyWord", "ori", "setDanmakuFilterChangedListener", "listener", "release", "DanmakuFilterChangedListener", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuFilterContainer {
    private final ArrayList<String> mDmviewRegexfilters = new ArrayList<>();
    private DanmakuFilterChangedListener mFilterChangedListener;
    private CancellationTokenSource mResolveToken;

    public final void setDmViewRegexFilters(List<String> list, boolean clear) {
        List filters = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(filters, "filters");
        if (!clear && this.mDmviewRegexfilters.size() > 0) {
            return;
        }
        this.mDmviewRegexfilters.clear();
        this.mDmviewRegexfilters.addAll(filters);
    }

    public final void loadLocalFilters(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        resolveDanmakuFilter$default(this, context, null, null, false, null, 28, null);
    }

    public final void appendFilters(Context context, String shieldUserId, String regexFilter, Long nativeId, Runnable onSuccess) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (regexFilter != null) {
            this.mDmviewRegexfilters.add(regexFilter);
        }
        resolveDanmakuFilter(context, shieldUserId, nativeId, true, onSuccess);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:3:0x001b, B:5:0x0025, B:7:0x0032, B:13:0x003f, B:15:0x004c, B:17:0x0053, B:18:0x005a, B:22:0x0066, B:24:0x006a, B:25:0x006f, B:27:0x0076, B:28:0x0082, B:19:0x005f), top: B:33:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Triple<List<String>, List<String>, List<String>> resolveDanamkuFilters(Context context, String shieldUserId, Long nativeId) {
        BlockedKeywords readDefaultBlockedKeywords;
        List it;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        List userHashList = new ArrayList();
        List contentList = new ArrayList();
        List regexList = new ArrayList();
        try {
            if (BiliAccounts.get(context).isLogin()) {
                long mid = BiliAccounts.get(context).mid();
                String str = shieldUserId;
                if (str != null && !StringsKt.isBlank(str)) {
                    z = false;
                    if (!z) {
                        UserKeywordItem $this$resolveDanamkuFilters_u24lambda_u240 = new UserKeywordItem(mid, 2, shieldUserId);
                        $this$resolveDanamkuFilters_u24lambda_u240.id = nativeId != null ? nativeId.longValue() : 0L;
                        BlockListStorageUtils.appendUserBlockedKeyword(context, $this$resolveDanamkuFilters_u24lambda_u240);
                    }
                    readDefaultBlockedKeywords = BlockListStorageUtils.readUserBlockedKeywords(context);
                }
                z = true;
                if (!z) {
                }
                readDefaultBlockedKeywords = BlockListStorageUtils.readUserBlockedKeywords(context);
            } else {
                readDefaultBlockedKeywords = BlockListStorageUtils.readDefaultBlockedKeywords(context);
            }
            BlockedKeywords userFilters = readDefaultBlockedKeywords;
            if (userFilters != null && (it = userFilters.mKeywordItems) != null) {
                filterData(userHashList, contentList, regexList, it);
            }
            GlobalBlockedKeywords it2 = BlockListStorageUtils.readGlobalBlockedKeywords(context);
            if (it2 != null) {
                Collection collection = it2.mKeywordItems;
                Intrinsics.checkNotNullExpressionValue(collection, "mKeywordItems");
                filterData(userHashList, contentList, regexList, collection);
            }
            regexList.addAll(this.mDmviewRegexfilters);
            return new Triple<>(userHashList, regexList, contentList);
        } catch (Exception e) {
            return null;
        }
    }

    static /* synthetic */ void resolveDanmakuFilter$default(DanmakuFilterContainer danmakuFilterContainer, Context context, String str, Long l, boolean z, Runnable runnable, int i, Object obj) {
        danmakuFilterContainer.resolveDanmakuFilter(context, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : runnable);
    }

    private final void resolveDanmakuFilter(final Context context, final String shieldUserId, final Long nativeId, final boolean force, final Runnable onSuccess) {
        CancellationTokenSource cancellationTokenSource = this.mResolveToken;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        this.mResolveToken = new CancellationTokenSource();
        Callable callable = new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Triple resolveDanamkuFilters;
                resolveDanamkuFilters = DanmakuFilterContainer.this.resolveDanamkuFilters(context, shieldUserId, nativeId);
                return resolveDanamkuFilters;
            }
        };
        CancellationTokenSource cancellationTokenSource2 = this.mResolveToken;
        Intrinsics.checkNotNull(cancellationTokenSource2);
        Executor executor = Task.UI_THREAD_EXECUTOR;
        CancellationTokenSource cancellationTokenSource3 = this.mResolveToken;
        Intrinsics.checkNotNull(cancellationTokenSource3);
        Task.callInBackground(callable, cancellationTokenSource2.getToken()).continueWith(new Continuation<Triple<? extends List<String>, ? extends List<String>, ? extends List<String>>, Unit>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer$resolveDanmakuFilter$2
            public /* bridge */ /* synthetic */ Object then(Task p0) {
                m2260then((Task<Triple<List<String>, List<String>, List<String>>>) p0);
                return Unit.INSTANCE;
            }

            /* renamed from: then  reason: collision with other method in class */
            public void m2260then(Task<Triple<List<String>, List<String>, List<String>>> task) {
                Triple result;
                DanmakuFilterContainer.DanmakuFilterChangedListener danmakuFilterChangedListener;
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isFaulted() || task.isCancelled() || (result = (Triple) task.getResult()) == null) {
                    return;
                }
                if (shieldUserId != null) {
                    BLog.i(ChronosApiResolver.TAG, ": resolve danmaku filter succeed, add new shield user id (" + shieldUserId + ").");
                } else {
                    BLog.i(ChronosApiResolver.TAG, ": resolve danmaku filter succeed, without new shield user id.");
                }
                danmakuFilterChangedListener = this.mFilterChangedListener;
                if (danmakuFilterChangedListener != null) {
                    danmakuFilterChangedListener.onDanmakuFilterChanged((List) result.getFirst(), (List) result.getSecond(), (List) result.getThird(), force);
                }
                Runnable runnable = onSuccess;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, executor, cancellationTokenSource3.getToken());
    }

    private final <T extends BaseKeywordItem> void filterData(List<String> list, List<String> list2, List<String> list3, List<? extends T> list4) {
        Iterable data = EnhancedUnmodifiabilityKt.unmodifiable(list4);
        Iterable $this$forEach$iv = data;
        for (Object element$iv : $this$forEach$iv) {
            BaseKeywordItem it = (BaseKeywordItem) element$iv;
            switch (it.type) {
                case 0:
                    String str = it.data;
                    Intrinsics.checkNotNullExpressionValue(str, "data");
                    list2.add(str);
                    break;
                case 1:
                    String regexString = compileRegexKeyWord(it.data);
                    if (regexString != null) {
                        list3.add(regexString);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    String str2 = it.data;
                    Intrinsics.checkNotNullExpressionValue(str2, "data");
                    list.add(str2);
                    break;
            }
        }
    }

    private final String compileRegexKeyWord(String ori) {
        String str = ori;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Pattern pattern = Pattern.compile(BaseKeywordItem.LEGAL_REGULAR_EXPRESSION);
            Matcher matcher = pattern.matcher(ori);
            if (matcher.matches()) {
                return matcher.group(2);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public final void setDanmakuFilterChangedListener(DanmakuFilterChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mFilterChangedListener = listener;
    }

    public final void release() {
        CancellationTokenSource cancellationTokenSource = this.mResolveToken;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        this.mResolveToken = null;
    }

    /* compiled from: DanmakuFilterContainer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer$DanmakuFilterChangedListener;", "", "onDanmakuFilterChanged", "", "userHashList", "", "", "regexList", "contentList", "force", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DanmakuFilterChangedListener {
        void onDanmakuFilterChanged(List<String> list, List<String> list2, List<String> list3, boolean z);

        /* compiled from: DanmakuFilterContainer.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer$DanmakuFilterChangedListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void onDanmakuFilterChanged$default(DanmakuFilterChangedListener danmakuFilterChangedListener, List list, List list2, List list3, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDanmakuFilterChanged");
                }
                if ((i & 8) != 0) {
                    z = false;
                }
                danmakuFilterChangedListener.onDanmakuFilterChanged(list, list2, list3, z);
            }
        }
    }
}