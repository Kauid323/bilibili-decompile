package tv.danmaku.bili.splash.ad.test;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* compiled from: SplashTestViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Ltv/danmaku/bili/splash/ad/test/SplashTestViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Ltv/danmaku/bili/splash/ad/test/SplashTestItem;", "<set-?>", "", "splashUseNew", "getSplashUseNew", "()Z", "setSplashUseNew", "(Z)V", "splashUseNew$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", AuthResultCbHelper.ARGS_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateTitle", "", "id", "", ReportUtilKt.POS_TITLE, "", "toast", AuthResultCbHelper.ARGS_MSG, "routeToJsonViewer", "data", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTestViewModel extends ViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SplashTestViewModel.class, "splashUseNew", "getSplashUseNew()Z", 0))};
    public static final int $stable = 8;
    private final MutableStateFlow<List<SplashTestItem>> _state = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final SharedPreferencesField splashUseNew$delegate = new SharedPreferencesField("sp_test_splash_use_new_exp", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private final StateFlow<List<SplashTestItem>> state = FlowKt.asStateFlow(this._state);

    public SplashTestViewModel() {
        MutableStateFlow<List<SplashTestItem>> mutableStateFlow = this._state;
        SplashTestItem[] splashTestItemArr = new SplashTestItem[4];
        splashTestItemArr[0] = new SplashTestItem(0, "清除本地缓存闪屏资源", new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestViewModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit _init_$lambda$0;
                _init_$lambda$0 = SplashTestViewModel._init_$lambda$0(SplashTestViewModel.this);
                return _init_$lambda$0;
            }
        });
        splashTestItemArr[1] = new SplashTestItem(1, "展示本地配置信息", new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestViewModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit _init_$lambda$1;
                _init_$lambda$1 = SplashTestViewModel._init_$lambda$1(SplashTestViewModel.this);
                return _init_$lambda$1;
            }
        });
        splashTestItemArr[2] = new SplashTestItem(2, "展示本地订单加载状态信息", new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestViewModel$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit _init_$lambda$2;
                _init_$lambda$2 = SplashTestViewModel._init_$lambda$2(SplashTestViewModel.this);
                return _init_$lambda$2;
            }
        });
        splashTestItemArr[3] = new SplashTestItem(3, "切换闪屏实验(当前:" + (getSplashUseNew() ? "新" : "旧") + ")", new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestViewModel$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit _init_$lambda$3;
                _init_$lambda$3 = SplashTestViewModel._init_$lambda$3(SplashTestViewModel.this);
                return _init_$lambda$3;
            }
        });
        mutableStateFlow.setValue(CollectionsKt.listOf(splashTestItemArr));
    }

    private final boolean getSplashUseNew() {
        return ((Boolean) this.splashUseNew$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setSplashUseNew(boolean z) {
        this.splashUseNew$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final StateFlow<List<SplashTestItem>> getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SplashTestViewModel this$0) {
        Application context = BiliContext.application();
        Intrinsics.checkNotNull(context);
        FileUtils.deleteQuietly(new File(context.getFilesDir() + "/res_cache"));
        this$0.toast("清除成功，请重启");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(SplashTestViewModel this$0) {
        SplashListResponse copy;
        SplashListResponse localConfig = SplashUpdateComponentKt.readConfigFromDisk();
        if (localConfig == null) {
            this$0.toast("本地配置为空");
            return Unit.INSTANCE;
        }
        copy = localConfig.copy((r20 & 1) != 0 ? localConfig.maxCount : 0, (r20 & 2) != 0 ? localConfig.intervalForShow : 0, (r20 & 4) != 0 ? localConfig.intervalForUpdate : 0, (r20 & 8) != 0 ? localConfig.disperseInterval : 0L, (r20 & 16) != 0 ? localConfig.splashList : new ArrayList(), (r20 & 32) != 0 ? localConfig.strategyList : null, (r20 & 64) != 0 ? localConfig.keepIds : null, (r20 & BR.cover) != 0 ? localConfig.splashRequestId : null);
        this$0.routeToJsonViewer(copy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(SplashTestViewModel this$0) {
        ArrayList arrayList;
        Iterable splashList;
        SplashListResponse readConfigFromDisk = SplashUpdateComponentKt.readConfigFromDisk();
        if (readConfigFromDisk == null || (splashList = readConfigFromDisk.getSplashList()) == null) {
            arrayList = null;
        } else {
            Iterable $this$map$iv = splashList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                SplashOrder it = (SplashOrder) item$iv$iv;
                destination$iv$iv.add(SplashLiteDataKt.getLiteData(it));
            }
            arrayList = (List) destination$iv$iv;
        }
        List list = arrayList;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            this$0.toast("本地列表为空");
            return Unit.INSTANCE;
        }
        this$0.routeToJsonViewer(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$3(SplashTestViewModel this$0) {
        this$0.setSplashUseNew(!this$0.getSplashUseNew());
        this$0.toast("切换成功，请重启");
        this$0.updateTitle(3, "切换闪屏实验(当前:" + (this$0.getSplashUseNew() ? "新" : "旧") + ")");
        return Unit.INSTANCE;
    }

    private final void updateTitle(int id, String title) {
        MutableStateFlow<List<SplashTestItem>> mutableStateFlow = this._state;
        List $this$updateTitle_u24lambda_u240 = CollectionsKt.toMutableList((Collection) this._state.getValue());
        List $this$forEachIndexed$iv = $this$updateTitle_u24lambda_u240;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SplashTestItem splashTestItem = (SplashTestItem) item$iv;
            if (splashTestItem.getId() == id) {
                $this$updateTitle_u24lambda_u240.set(index, SplashTestItem.copy$default(splashTestItem, 0, title, null, 5, null));
            }
            index = index$iv;
        }
        mutableStateFlow.setValue($this$updateTitle_u24lambda_u240);
    }

    private final void toast(String msg) {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        ToastHelper.showToast(application, msg, 0);
    }

    private final void routeToJsonViewer(final Object data) {
        if (data == null) {
            return;
        }
        RouteRequest request = new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestViewModel$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit routeToJsonViewer$lambda$0;
                routeToJsonViewer$lambda$0 = SplashTestViewModel.routeToJsonViewer$lambda$0(data, (MutableBundleLike) obj);
                return routeToJsonViewer$lambda$0;
            }
        }).build();
        BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routeToJsonViewer$lambda$0(Object $data, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String json = new Gson().toJson($data);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        $this$extras.put("jsonStr", json);
        return Unit.INSTANCE;
    }
}