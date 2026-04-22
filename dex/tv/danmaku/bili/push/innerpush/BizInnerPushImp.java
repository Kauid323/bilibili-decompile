package tv.danmaku.bili.push.innerpush;

import com.bilibili.module.main.innerpush.BizInnerPushService;
import com.bilibili.module.main.innerpush.BizStateTrigger;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.module.main.innerpush.InnerPushRule;
import com.bilibili.module.main.innerpush.PushBizType;
import com.bilibili.module.main.innerpush.PushContext;
import com.bilibili.module.main.innerpush.ShowContent;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BizInnerPushImp.kt */
@Singleton
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2<\u0010\n\u001a8\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000b¢\u0006\u0002\b\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J$\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016¨\u0006 "}, d2 = {"Ltv/danmaku/bili/push/innerpush/BizInnerPushImp;", "Lcom/bilibili/module/main/innerpush/BizInnerPushService;", "<init>", "()V", "register", "Lcom/bilibili/module/main/innerpush/BizStateTrigger;", "biz", "Lcom/bilibili/module/main/innerpush/PushBizType;", "cacheRule", "Lcom/bilibili/module/main/innerpush/InnerPushRule;", "onReceive", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bilibili/module/main/innerpush/PushContext;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "context", "Lkotlin/coroutines/Continuation;", "Lcom/bilibili/module/main/innerpush/ShowContent;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/bilibili/module/main/innerpush/PushBizType;Lcom/bilibili/module/main/innerpush/InnerPushRule;Lkotlin/jvm/functions/Function3;)Lcom/bilibili/module/main/innerpush/BizStateTrigger;", "consume", "", "jobs", "", "", "trimBizPush", "predicate", "Lkotlin/Function1;", "Lcom/bilibili/module/main/innerpush/InnerPush;", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BizInnerPushImp implements BizInnerPushService {
    public static final int $stable = 0;

    public BizStateTrigger register(PushBizType biz, InnerPushRule cacheRule, Function3<? super CoroutineScope, ? super PushContext, ? super Continuation<? super ShowContent>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        Intrinsics.checkNotNullParameter(cacheRule, "cacheRule");
        Intrinsics.checkNotNullParameter(function3, "onReceive");
        return AppInnerPushManagerV2.Companion.getInstance().registerBizPush(biz.getType(), cacheRule, function3);
    }

    public void consume(PushBizType biz, List<Long> list) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        Intrinsics.checkNotNullParameter(list, "jobs");
        AppInnerPushManagerV2.Companion.getInstance().consumeBizPush(biz.getType(), list);
    }

    public void trimBizPush(PushBizType biz, Function1<? super InnerPush, Boolean> function1) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        AppInnerPushManagerV2.Companion.getInstance().trimBizPush(biz.getType(), function1);
    }
}