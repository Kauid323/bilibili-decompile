package tv.danmaku.bili.ui.answer;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bili.resource.common.R;
import com.alibaba.fastjson.JSON;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.moss.api.NetworkException;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.moduleservice.main.AnswerDialogEvent;
import com.bilibili.moduleservice.main.AnswerService;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.studio.uperbase.router.wrapper.BundleWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.answer.AnswerServiceImp;
import tv.danmaku.bili.ui.answer.api.AnswerApiService;
import tv.danmaku.bili.ui.answer.api.AnswerGuideData;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;

/* compiled from: AnswerServiceImp.kt */
@Singleton
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0002J^\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dH\u0016J^\u0010\u001e\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dH\u0016Jf\u0010!\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0081\u0001\u0010$\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182)\u0010%\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020(0'¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0007\u0018\u00010&2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010#\u001a\u00020\u001bH\u0016J`\u0010!\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerServiceImp;", "Lcom/bilibili/moduleservice/main/AnswerService;", "<init>", "()V", "TAG", "", "showLoading", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/answer/AnswerServiceImp$AnswerDataCallback;", "call", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;", "showAnswerGuideForVideo", "context", "Landroid/content/Context;", LoginSceneProcessor.BIZ_KEY, FavoritesConstsKt.SPMID, "aid", "cid", "requestCode", "", "interceptInvitationEvent", "Lkotlin/Function0;", "", "extraParams", "", "showAnswerGuideForComment", "type", "oid", "showAnswerGuide", "onDialogDismiss", "forceNight", "showAnswerGuideObserveState", "onDialogState", "Lkotlin/Function1;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bilibili/moduleservice/main/AnswerDialogEvent;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "eventFlow", "dialogInfo", "Landroid/os/Bundle;", "AnswerDataCallback", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerServiceImp implements AnswerService {
    public static final int $stable = 0;
    private final String TAG = "AnswerService";

    public /* synthetic */ void showAnswerGuide(Context context, String str, Bundle bundle, int i, Function0 function0) {
        AnswerService.-CC.$default$showAnswerGuide(this, context, str, bundle, i, function0);
    }

    public /* synthetic */ void showAnswerGuide(Context context, String str, String str2, int i) {
        AnswerService.-CC.$default$showAnswerGuide(this, context, str, str2, i);
    }

    public /* synthetic */ void showAnswerGuide(Context context, String str, String str2, int i, Function0 function0) {
        AnswerService.-CC.$default$showAnswerGuide(this, context, str, str2, i, function0);
    }

    public /* synthetic */ void showAnswerGuide(Context context, String str, String str2, int i, Function0 function0, Map map) {
        AnswerService.-CC.$default$showAnswerGuide(this, context, str, str2, i, function0, map);
    }

    public /* synthetic */ void showAnswerGuideForComment(Context context, String str, String str2, String str3, String str4, int i) {
        AnswerService.-CC.$default$showAnswerGuideForComment(this, context, str, str2, str3, str4, i);
    }

    public /* synthetic */ void showAnswerGuideForVideo(Context context, String str, String str2, String str3, String str4, int i) {
        AnswerService.-CC.$default$showAnswerGuideForVideo(this, context, str, str2, str3, str4, i);
    }

    private final void showLoading(FragmentActivity fragmentActivity, AnswerDataCallback callback, BiliCall<GeneralResponse<AnswerGuideData>> biliCall) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new AnswerServiceImp$showLoading$1(fragmentActivity, this, biliCall, callback, null), 3, (Object) null);
    }

    public void showAnswerGuideForVideo(Context context, String business, String spmid, String aid, String cid, int requestCode, Function0<Boolean> function0, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(map, "extraParams");
        FragmentActivity fragmentActivity = UtilKt.findFragmentActivityOrNull(context);
        if (fragmentActivity == null) {
            return;
        }
        AnswerDataCallback answerDataCallback = new AnswerDataCallback(context, requestCode, business, spmid, null, null, null, function0, map, BR.containerVisible, null);
        BiliCall<GeneralResponse<AnswerGuideData>> answerGuide = ((AnswerApiService) ServiceGenerator.createService(AnswerApiService.class)).getAnswerGuide(BiliAccounts.get(BiliContext.application()).getAccessKey(), business, spmid, aid, cid);
        Intrinsics.checkNotNullExpressionValue(answerGuide, "getAnswerGuide(...)");
        showLoading(fragmentActivity, answerDataCallback, answerGuide);
    }

    public void showAnswerGuideForComment(Context context, String business, String spmid, String type, String oid, int requestCode, Function0<Boolean> function0, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(oid, "oid");
        Intrinsics.checkNotNullParameter(map, "extraParams");
        ((AnswerApiService) ServiceGenerator.createService(AnswerApiService.class)).getAnswerGuide(BiliAccounts.get(BiliContext.application()).getAccessKey(), business, spmid, type, oid).enqueue(new AnswerDataCallback(context, requestCode, business, spmid, null, null, null, function0, map, BR.containerVisible, null));
    }

    public void showAnswerGuide(final Context context, final String business, final String spmid, final int requestCode, final Function0<Unit> function0, final Function0<Boolean> function02, final Map<String, String> map, final boolean forceNight) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(map, "extraParams");
        ((AnswerApiService) ServiceGenerator.createService(AnswerApiService.class)).getAnswerGuide(BiliAccounts.get(BiliContext.application()).getAccessKey(), business, spmid, null, null).enqueue(new AnswerDataCallback(context, requestCode, business, spmid, function0, function02, map) { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$showAnswerGuide$1
            @Override // tv.danmaku.bili.ui.answer.AnswerServiceImp.AnswerDataCallback
            public void onDataSuccess(AnswerGuideData data) {
                if (data != null) {
                    data.forceNight = forceNight;
                }
                super.onDataSuccess(data);
            }
        });
    }

    public void showAnswerGuideObserveState(final Context context, final String business, final String spmid, final int requestCode, final Function1<? super Flow<? extends AnswerDialogEvent>, Unit> function1, final Function0<Boolean> function0, final Map<String, String> map, final boolean forceNight) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(map, "extraParams");
        if (function1 != null) {
            function1.invoke(FlowKt.flowOf(AnswerDialogEvent.Request.INSTANCE));
        }
        ((AnswerApiService) ServiceGenerator.createService(AnswerApiService.class)).getAnswerGuide(BiliAccounts.get(BiliContext.application()).getAccessKey(), business, spmid, null, null).enqueue(new AnswerDataCallback(context, requestCode, business, spmid, function1, function0, map) { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$showAnswerGuideObserveState$1
            @Override // tv.danmaku.bili.ui.answer.AnswerServiceImp.AnswerDataCallback
            public void onDataSuccess(AnswerGuideData data) {
                if (data != null) {
                    data.forceNight = forceNight;
                }
                super.onDataSuccess(data);
            }
        });
    }

    public void showAnswerGuide(Context context, String business, Bundle dialogInfo, int requestCode, Function0<Unit> function0, Function0<Boolean> function02, Map<String, String> map) {
        String optString;
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(map, "extraParams");
        String loginExperimentValue = dialogInfo != null ? BundleWrapper.Companion.optString(dialogInfo, LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT_VALUE, "") : null;
        AnswerDataCallback callback = new AnswerDataCallback(context, requestCode, business, (dialogInfo == null || (optString = BundleWrapper.Companion.optString(dialogInfo, "from_spmid", "")) == null) ? "" : optString, loginExperimentValue, function0, null, function02, map);
        if (dialogInfo != null) {
            String dialogLink = BundleWrapper.Companion.optString(dialogInfo, "dialog_link", "");
            String dialogDesc = BundleWrapper.Companion.optString(dialogInfo, "dialog_desc", "");
            String dialogTitle = BundleWrapper.Companion.optString(dialogInfo, "dialog_title", "");
            String dialogButtonConfirm = BundleWrapper.Companion.optString(dialogInfo, "dialog_buttonConfirm", "");
            String dialogButtonCancel = BundleWrapper.Companion.optString(dialogInfo, "dialog_buttonCancel", "");
            String rewardsListStr = BundleWrapper.Companion.optString(dialogInfo, "dialog_guideRewards", "");
            boolean forceNight = BundleWrapper.Companion.optBoolean(dialogInfo, "force_night", false);
            if (!TextUtils.isEmpty(dialogLink)) {
                AnswerGuideData date = new AnswerGuideData();
                date.link = dialogLink;
                date.desc = dialogDesc;
                date.title = dialogTitle;
                date.buttonConfirm = dialogButtonConfirm;
                date.buttonCancel = dialogButtonCancel;
                date.guideRewards = JSON.parseArray(rewardsListStr, AnswerGuideData.GuideReward.class);
                date.forceNight = forceNight;
                callback.onDataSuccess(date);
                return;
            }
            callback.onError(null);
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        callback.onError(null);
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* compiled from: AnswerServiceImp.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u009c\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012+\b\u0002\u0010\u000e\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J$\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u000e\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerServiceImp$AnswerDataCallback;", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;", "context", "Landroid/content/Context;", "requestCode", "", LoginSceneProcessor.BIZ_KEY, "", "fromSpmid", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT_VALUE, "onDialogDismiss", "Lkotlin/Function0;", "", "onDialogState", "Lkotlin/Function1;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bilibili/moduleservice/main/AnswerDialogEvent;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "eventFlow", "interceptInvitationEvent", "", "extraParams", "", "<init>", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/util/Map;)V", "getRequestCode", "()I", "contextR", "Ljava/lang/ref/WeakReference;", "onDataSuccess", "data", "onError", "t", "", "reportShow", "from", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, "activityType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AnswerDataCallback extends BiliApiDataCallback<AnswerGuideData> {
        public static final int $stable = 8;
        private final String business;
        private final WeakReference<Context> contextR;
        private final Map<String, String> extraParams;
        private final String fromSpmid;
        private final Function0<Boolean> interceptInvitationEvent;
        private final String loginExperimentValue;
        private final Function0<Unit> onDialogDismiss;
        private final Function1<Flow<? extends AnswerDialogEvent>, Unit> onDialogState;
        private final int requestCode;

        public AnswerDataCallback(Context context, int requestCode, String business, String fromSpmid, String loginExperimentValue, Function0<Unit> function0, Function1<? super Flow<? extends AnswerDialogEvent>, Unit> function1, Function0<Boolean> function02, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
            Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
            Intrinsics.checkNotNullParameter(map, "extraParams");
            this.requestCode = requestCode;
            this.business = business;
            this.fromSpmid = fromSpmid;
            this.loginExperimentValue = loginExperimentValue;
            this.onDialogDismiss = function0;
            this.onDialogState = function1;
            this.interceptInvitationEvent = function02;
            this.extraParams = map;
            this.contextR = new WeakReference<>(context);
        }

        public /* synthetic */ AnswerDataCallback(Context context, int i, String str, String str2, String str3, Function0 function0, Function1 function1, Function0 function02, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, i, str, str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : function0, (i2 & 64) != 0 ? null : function1, (i2 & BR.cover) != 0 ? null : function02, (i2 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : map);
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        @Override // 
        public void onDataSuccess(AnswerGuideData data) {
            Activity activity = UtilKt.findActivityOrNull(this.contextR.get());
            if (activity != null && data != null) {
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    reportShow(this.business, this.loginExperimentValue, data.activityType);
                    AnswerDialog $this$onDataSuccess_u24lambda_u240 = new AnswerDialog(activity, data, this.requestCode, this.business, this.fromSpmid, this.interceptInvitationEvent, this.extraParams);
                    $this$onDataSuccess_u24lambda_u240.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$AnswerDataCallback$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AnswerServiceImp.AnswerDataCallback.onDataSuccess$lambda$0$0(AnswerServiceImp.AnswerDataCallback.this, dialogInterface);
                        }
                    });
                    $this$onDataSuccess_u24lambda_u240.setOnShowListener(new DialogInterface.OnShowListener() { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$AnswerDataCallback$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            AnswerServiceImp.AnswerDataCallback.onDataSuccess$lambda$0$1(AnswerServiceImp.AnswerDataCallback.this, dialogInterface);
                        }
                    });
                    $this$onDataSuccess_u24lambda_u240.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$AnswerDataCallback$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            AnswerServiceImp.AnswerDataCallback.onDataSuccess$lambda$0$2(AnswerServiceImp.AnswerDataCallback.this, dialogInterface);
                        }
                    });
                    $this$onDataSuccess_u24lambda_u240.show();
                    return;
                }
                BLog.e("AnswerService", "context must be activity");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataSuccess$lambda$0$0(AnswerDataCallback this$0, DialogInterface it) {
            Function0<Unit> function0 = this$0.onDialogDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            Function1<Flow<? extends AnswerDialogEvent>, Unit> function1 = this$0.onDialogState;
            if (function1 != null) {
                function1.invoke(FlowKt.flowOf(AnswerDialogEvent.Dismiss.INSTANCE));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataSuccess$lambda$0$1(AnswerDataCallback this$0, DialogInterface it) {
            Function1<Flow<? extends AnswerDialogEvent>, Unit> function1 = this$0.onDialogState;
            if (function1 != null) {
                function1.invoke(FlowKt.flowOf(AnswerDialogEvent.Show.INSTANCE));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataSuccess$lambda$0$2(AnswerDataCallback this$0, DialogInterface it) {
            Function1<Flow<? extends AnswerDialogEvent>, Unit> function1 = this$0.onDialogState;
            if (function1 != null) {
                function1.invoke(FlowKt.flowOf(AnswerDialogEvent.Cancel.INSTANCE));
            }
        }

        public void onError(Throwable t) {
            if (t instanceof BiliApiException) {
                Context $this$onError_u24lambda_u240 = this.contextR.get();
                if ($this$onError_u24lambda_u240 != null) {
                    ToastHelper.showToastShort($this$onError_u24lambda_u240, ((BiliApiException) t).getMessage());
                }
            } else if (!(t instanceof NetworkException)) {
                ToastHelper.showToastShort(BiliContext.application(), R.string.common_global_string_8);
            } else if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
                ToastHelper.showToastShort(BiliContext.application(), bili.resource.homepage.R.string.homepage_global_string_324);
            } else {
                ToastHelper.showToastShort(BiliContext.application(), R.string.common_global_string_8);
            }
            BLog.d("AnswerService", "on data obtain error = " + (t != null ? t.getMessage() : null));
        }

        static /* synthetic */ void reportShow$default(AnswerDataCallback answerDataCallback, String str, String str2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportShow");
            }
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            answerDataCallback.reportShow(str, str2, i);
        }

        private final void reportShow(String from, String loginExperiment, int activityType) {
            HashMap extension = new HashMap();
            if (Intrinsics.areEqual(from, "yinsitanchuang")) {
                extension.put("ug_test", "privacy_pop_7");
            } else {
                extension.put("re_src", from);
            }
            if (loginExperiment != null) {
                extension.put("scene", loginExperiment);
            }
            extension.put("pop_type", activityType == 1 ? AudioIntentHelper.FROM_ACTIVITY : MineVipServiceKt.VIP_REPORT_VALUE_NORMAL);
            Neurons.reportExposure$default(false, "community.public-community.answer-in.0.show", extension, (List) null, 8, (Object) null);
        }
    }
}