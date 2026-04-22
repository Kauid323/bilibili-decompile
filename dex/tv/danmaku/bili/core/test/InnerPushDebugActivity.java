package tv.danmaku.bili.core.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.module.main.innerpush.BizParams;
import com.bilibili.module.main.innerpush.ISendPushMessage;
import com.bilibili.module.main.innerpush.InnerPush;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.ActivityInnerPushDebugBinding;
import tv.danmaku.bili.databinding.TitleInputItemBinding;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorageKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2Kt;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: InnerPushDebugActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/InnerPushDebugActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/ActivityInnerPushDebugBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initOption", "handleGenerateInnerPushClicked", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushDebugActivity extends BaseToolbarActivity {
    public static final int $stable = 8;
    private ActivityInnerPushDebugBinding binding;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInnerPushDebugBinding inflate = ActivityInnerPushDebugBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding = this.binding;
        if (activityInnerPushDebugBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding = null;
        }
        setContentView(activityInnerPushDebugBinding.getRoot());
        ensureToolbar();
        setTitle("端内Push测试页(new)");
        showBackButton();
        initOption();
    }

    private final void initOption() {
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding = this.binding;
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding2 = null;
        if (activityInnerPushDebugBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding = null;
        }
        activityInnerPushDebugBinding.tvExpInfo.setText("当前端内push是否处于服务端控制状态:" + InnerPushLocalStorageKt.isHitInnerPushV2Exp());
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding3 = this.binding;
        if (activityInnerPushDebugBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding3 = null;
        }
        activityInnerPushDebugBinding3.btnLoadLocalInnerPush.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$0(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding4 = this.binding;
        if (activityInnerPushDebugBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding4 = null;
        }
        activityInnerPushDebugBinding4.btnLoadLocalInnerPushConfig.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$1(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding5 = this.binding;
        if (activityInnerPushDebugBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding5 = null;
        }
        activityInnerPushDebugBinding5.btnLoadLocalCommonExposeCount.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$2(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding6 = this.binding;
        if (activityInnerPushDebugBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding6 = null;
        }
        activityInnerPushDebugBinding6.btnLoadLocalBidExposeCount.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$3(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding7 = this.binding;
        if (activityInnerPushDebugBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding7 = null;
        }
        activityInnerPushDebugBinding7.btnCleanExposeCount.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$4(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding8 = this.binding;
        if (activityInnerPushDebugBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding8 = null;
        }
        activityInnerPushDebugBinding8.btnGeneratePush.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.this.handleGenerateInnerPushClicked();
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding9 = this.binding;
        if (activityInnerPushDebugBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding9 = null;
        }
        activityInnerPushDebugBinding9.btnCleanPush.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InnerPushDebugActivity.initOption$lambda$6(view);
            }
        });
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding10 = this.binding;
        if (activityInnerPushDebugBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding10 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u247 = activityInnerPushDebugBinding10.itemBid;
        $this$initOption_u24lambda_u247.optionKey.setText("bid");
        $this$initOption_u24lambda_u247.optionValue.setHint("Int类型， 不填默认-1");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding11 = this.binding;
        if (activityInnerPushDebugBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding11 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u248 = activityInnerPushDebugBinding11.itemJob;
        $this$initOption_u24lambda_u248.optionKey.setText("job");
        $this$initOption_u24lambda_u248.optionValue.setHint("Long类型， 不填就取时间戳");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding12 = this.binding;
        if (activityInnerPushDebugBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding12 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u249 = activityInnerPushDebugBinding12.itemExpire;
        $this$initOption_u24lambda_u249.optionKey.setText("expire");
        $this$initOption_u24lambda_u249.optionValue.setHint("过期时间，单位秒， 不填随机10min内过期");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding13 = this.binding;
        if (activityInnerPushDebugBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding13 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u2410 = activityInnerPushDebugBinding13.itemDuration;
        $this$initOption_u24lambda_u2410.optionKey.setText("duration");
        $this$initOption_u24lambda_u2410.optionValue.setHint("过期时间，单位秒， 默认5秒");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding14 = this.binding;
        if (activityInnerPushDebugBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding14 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u2411 = activityInnerPushDebugBinding14.itemQuery;
        $this$initOption_u24lambda_u2411.optionKey.setText("query");
        $this$initOption_u24lambda_u2411.optionValue.setHint("true或者false。请求展示时是否询问服务端,不填默认true");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding15 = this.binding;
        if (activityInnerPushDebugBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding15 = null;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u2412 = activityInnerPushDebugBinding15.itemLevel;
        $this$initOption_u24lambda_u2412.optionKey.setText("level");
        $this$initOption_u24lambda_u2412.optionValue.setHint("0或者99。消息优先级，不填默认0");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding16 = this.binding;
        if (activityInnerPushDebugBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityInnerPushDebugBinding2 = activityInnerPushDebugBinding16;
        }
        TitleInputItemBinding $this$initOption_u24lambda_u2413 = activityInnerPushDebugBinding2.itemDisplayType;
        $this$initOption_u24lambda_u2413.optionKey.setText("display_type");
        $this$initOption_u24lambda_u2413.optionValue.setHint("消息类型 0:文本类型 1:全静态图 2:全gif。默认0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$0(View it) {
        SharedPreferences pref;
        pref = InnerPushDebugActivityKt.getPref();
        String string = pref != null ? pref.getString(InnerPushCacheManagerV2Kt.SP_INNER_PUSH_CACHE_KEY_V2, "") : null;
        String it2 = string;
        String str = it2;
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str)) && !Intrinsics.areEqual(it2, "[]") && !Intrinsics.areEqual(it2, "null")) {
            z = true;
        }
        if (!z) {
            string = null;
        }
        final String data = string != null ? string : "";
        if (StringsKt.isBlank(data)) {
            ToastHelper.showToastShort(BiliContext.application(), "本地无缓存数据");
            return;
        }
        RouteRequest request = new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit initOption$lambda$0$1;
                initOption$lambda$0$1 = InnerPushDebugActivity.initOption$lambda$0$1(data, (MutableBundleLike) obj);
                return initOption$lambda$0$1;
            }
        }).build();
        BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOption$lambda$0$1(String $data, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("jsonStr", $data);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$1(View it) {
        SharedPreferences pref;
        pref = InnerPushDebugActivityKt.getPref();
        String string = pref != null ? pref.getString(InnerPushLocalStorage.PREF_INNER_PUSH_CONFIG_KEY, "") : null;
        String it2 = string;
        String str = it2;
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str)) && !Intrinsics.areEqual(it2, "[]") && !Intrinsics.areEqual(it2, "null")) {
            z = true;
        }
        if (!z) {
            string = null;
        }
        final String str2 = string != null ? string : "";
        if (StringsKt.isBlank(str2)) {
            ToastHelper.showToastShort(BiliContext.application(), "本地无配置信息");
        } else {
            BLRouter.routeTo$default(new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit initOption$lambda$1$1;
                    initOption$lambda$1$1 = InnerPushDebugActivity.initOption$lambda$1$1(str2, (MutableBundleLike) obj);
                    return initOption$lambda$1$1;
                }
            }).build(), (Context) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOption$lambda$1$1(String $str, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("jsonStr", $str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$2(View it) {
        int exposeCount = InnerPushLocalStorage.INSTANCE.getInnerPushCommonExposeCount();
        InnerPushDebugActivityKt.toast("今日曝光次数:" + exposeCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$3(View it) {
        final String str;
        str = InnerPushDebugActivityKt.toJson(InnerPushLocalStorage.INSTANCE.getInnerPushBusinessExposeMap());
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str == null) {
            return;
        }
        BLRouter.routeTo$default(new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivity$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit initOption$lambda$3$1;
                initOption$lambda$3$1 = InnerPushDebugActivity.initOption$lambda$3$1(str, (MutableBundleLike) obj);
                return initOption$lambda$3$1;
            }
        }).build(), (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOption$lambda$3$1(String $str, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("jsonStr", $str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$4(View it) {
        SharedPreferences pref;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences.Editor remove2;
        pref = InnerPushDebugActivityKt.getPref();
        if (pref != null && (edit = pref.edit()) != null && (remove = edit.remove(InnerPushLocalStorage.SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT)) != null && (remove2 = remove.remove(InnerPushLocalStorage.SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT)) != null) {
            remove2.apply();
        }
        InnerPushDebugActivityKt.toast("成功清除曝光次数");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOption$lambda$6(View it) {
        SharedPreferences pref;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        pref = InnerPushDebugActivityKt.getPref();
        if (pref != null && (edit = pref.edit()) != null && (remove = edit.remove(InnerPushCacheManagerV2Kt.SP_INNER_PUSH_CACHE_KEY_V2)) != null) {
            remove.apply();
        }
        InnerPushDebugActivityKt.toast("成功清除缓存的push数据");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGenerateInnerPushClicked() {
        int i;
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding = this.binding;
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding2 = null;
        if (activityInnerPushDebugBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding = null;
        }
        long expire = AdExtensions.toLongOrDefault(activityInnerPushDebugBinding.itemExpire.optionValue.getText().toString(), 0L);
        long expire2 = (System.currentTimeMillis() / 1000) + (expire == 0 ? new Random().nextInt(BR.subTitle) : 0L);
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding3 = this.binding;
        if (activityInnerPushDebugBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding3 = null;
        }
        long job = AdExtensions.toLongOrDefault(activityInnerPushDebugBinding3.itemJob.optionValue.getText().toString(), -1L);
        long job2 = job == -1 ? System.currentTimeMillis() : job;
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding4 = this.binding;
        if (activityInnerPushDebugBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding4 = null;
        }
        int intOrDefault = AdExtensions.toIntOrDefault(activityInnerPushDebugBinding4.itemBid.optionValue.getText().toString(), -1);
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding5 = this.binding;
        if (activityInnerPushDebugBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding5 = null;
        }
        long longOrDefault = AdExtensions.toLongOrDefault(activityInnerPushDebugBinding5.itemDuration.optionValue.getText().toString(), 5L);
        String str = "job = " + job2;
        String str2 = "端内push标题 - " + job2;
        String valueOf = String.valueOf(job2);
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding6 = this.binding;
        if (activityInnerPushDebugBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding6 = null;
        }
        int intOrDefault2 = AdExtensions.toIntOrDefault(activityInnerPushDebugBinding6.itemDisplayType.optionValue.getText().toString(), 0);
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding7 = this.binding;
        if (activityInnerPushDebugBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding7 = null;
        }
        boolean z = !Intrinsics.areEqual(activityInnerPushDebugBinding7.itemQuery.optionValue.getText().toString(), "false");
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding8 = this.binding;
        if (activityInnerPushDebugBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInnerPushDebugBinding8 = null;
        }
        int intOrDefault3 = AdExtensions.toIntOrDefault(activityInnerPushDebugBinding8.itemLevel.optionValue.getText().toString(), 0);
        ActivityInnerPushDebugBinding activityInnerPushDebugBinding9 = this.binding;
        if (activityInnerPushDebugBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityInnerPushDebugBinding2 = activityInnerPushDebugBinding9;
        }
        if (AdExtensions.toIntOrDefault(activityInnerPushDebugBinding2.itemLevel.optionValue.getText().toString(), 0) != 0) {
            i = 1;
        } else {
            i = 0;
        }
        InnerPush pushItem = new InnerPush(intOrDefault, 0, str2, str, "https://www.baidu.com", longOrDefault, expire2, "https://i2.hdslb.com/bfs/face/690c342a5ad1f46ec90239a8ebdcab0329ebc198.jpg", valueOf, intOrDefault2, "https://i0.hdslb.com/bfs/dm/f391a2beaad56db3c049528f0a7023bb6e0d21d8.png", 1, (List) null, (List) null, (BizParams) null, 0, 0, job2, (String) null, false, 0, (Map) null, i, intOrDefault3, z, 0L, (String) null, 0, 238415874, (DefaultConstructorMarker) null);
        ISendPushMessage iSendPushMessage = (ISendPushMessage) BLRouter.INSTANCE.getServices(ISendPushMessage.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (iSendPushMessage != null) {
            iSendPushMessage.sendPushMessage(pushItem);
        }
        InnerPushDebugActivityKt.toast("生成push成功， job = " + pushItem.getJob());
    }
}