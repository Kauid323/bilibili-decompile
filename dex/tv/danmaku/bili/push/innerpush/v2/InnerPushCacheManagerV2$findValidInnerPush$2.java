package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import com.bilibili.module.main.innerpush.InnerPush;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.PushUpFilterType;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.push.innerpush.model.InnerPushReplayMessage;
import tv.danmaku.bili.push.innerpush.service.InnerPushServiceHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushCacheManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/module/main/innerpush/InnerPush;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$findValidInnerPush$2", f = "InnerPushCacheManagerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerPushCacheManagerV2$findValidInnerPush$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InnerPush>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $pvId;
    final /* synthetic */ List<InnerPush> $valid;
    int label;
    final /* synthetic */ InnerPushCacheManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerPushCacheManagerV2$findValidInnerPush$2(InnerPushCacheManagerV2 innerPushCacheManagerV2, Activity activity, String str, List<InnerPush> list, Continuation<? super InnerPushCacheManagerV2$findValidInnerPush$2> continuation) {
        super(2, continuation);
        this.this$0 = innerPushCacheManagerV2;
        this.$activity = activity;
        this.$pvId = str;
        this.$valid = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerPushCacheManagerV2$findValidInnerPush$2(this.this$0, this.$activity, this.$pvId, this.$valid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InnerPush> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List canShowList;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean z;
        boolean z2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                canShowList = this.this$0.queryCanShowList(this.$activity, this.$pvId, this.$valid);
                BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, canShowList.size = " + canShowList.size());
                Iterator it = canShowList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        InnerPush it2 = (InnerPush) obj2;
                        if (InnerPushExtensionKt.isHighLevel(it2)) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                InnerPush highPushItem = (InnerPush) obj2;
                if (highPushItem != null) {
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, high level push item exists, not need query server, job = " + highPushItem.getJob());
                    return highPushItem;
                }
                List $this$filterTo$iv$iv = canShowList;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    InnerPush it3 = (InnerPush) element$iv$iv;
                    if (!InnerPushExtensionKt.isHighLevel(it3)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List lowLevelShowList = (List) destination$iv$iv;
                if (lowLevelShowList.isEmpty()) {
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, no push item exists, not need query server");
                    return null;
                }
                Iterator it4 = lowLevelShowList.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj3 = it4.next();
                        InnerPush it5 = (InnerPush) obj3;
                        if (it5.getQuery()) {
                        }
                    } else {
                        obj3 = null;
                    }
                }
                if (obj3 == null) {
                    InnerPush lowPushItem = (InnerPush) lowLevelShowList.get(0);
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, low level push item exists, not need query server, job = " + lowPushItem.getJob());
                    return lowPushItem;
                }
                Iterable lowLevelShowList2 = InnerPushServiceHelperKt.requestInnerPushDisplay(this.$pvId, lowLevelShowList);
                BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, display return list = " + new Gson().toJson(lowLevelShowList2));
                Iterable $this$filterTo$iv$iv2 = lowLevelShowList2;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filterTo$iv$iv2) {
                    InnerPushReplayMessage it6 = (InnerPushReplayMessage) element$iv$iv2;
                    if (it6.getType() == 2) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                }
                Iterable discard = (List) destination$iv$iv2;
                Iterable $this$forEach$iv = discard;
                InnerPushCacheManagerV2 innerPushCacheManagerV2 = this.this$0;
                for (Object element$iv : $this$forEach$iv) {
                    InnerPushReplayMessage replay = (InnerPushReplayMessage) element$iv;
                    innerPushCacheManagerV2.remove(replay.getJob(), PushUpFilterType.ServerFilter.getText(), replay.getFilterType());
                }
                Iterator<T> it7 = lowLevelShowList2.iterator();
                while (true) {
                    if (it7.hasNext()) {
                        obj4 = it7.next();
                        InnerPushReplayMessage it8 = (InnerPushReplayMessage) obj4;
                        if (it8.getType() == 0) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                        }
                    } else {
                        obj4 = null;
                    }
                }
                InnerPushReplayMessage show = (InnerPushReplayMessage) obj4;
                Iterator it9 = canShowList.iterator();
                while (true) {
                    if (it9.hasNext()) {
                        obj5 = it9.next();
                        InnerPush it10 = (InnerPush) obj5;
                        if (show == null || it10.getJob() != show.getJob()) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                        }
                    } else {
                        obj5 = null;
                    }
                }
                InnerPush serverShowItem = (InnerPush) obj5;
                BLog.i("[InnerPush]InnerPushCacheManagerV2", "findValidInnerPush, query server show item job = " + (serverShowItem != null ? Boxing.boxLong(serverShowItem.getJob()) : null));
                return serverShowItem;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}