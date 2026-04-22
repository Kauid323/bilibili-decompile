package tv.danmaku.bili.auth;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.facialrecognition.FacialBizType;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: BiliFacialCompat.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0082\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"Ltv/danmaku/bili/auth/BiliFacialCompat;", "", "<init>", "()V", "TAG", "", "ID_NAME_NULL", "ID_CARD_NULL", "facialCompat", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "idName", "idNumber", "sourceEvent", "bizType", "onSuccess", "Lkotlin/Function1;", "onFailure", "Lkotlin/Function2;", "", "onRequest", "", "auth_debug", "helper", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper;"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliFacialCompat {
    public static final String ID_CARD_NULL = "";
    public static final String ID_NAME_NULL = "";
    private static final String TAG = "BiliFacialCompatHelper";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(BiliFacialCompat.class, "helper", "<v#0>", 0))};
    public static final BiliFacialCompat INSTANCE = new BiliFacialCompat();

    private BiliFacialCompat() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
        if ((r19.length() == 0) != false) goto L22;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void facialCompat(FragmentActivity activity, String idName, String idNumber, String sourceEvent, String bizType, final Function1<? super String, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2, Function1<? super Boolean, Unit> function12) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(idName, "idName");
        Intrinsics.checkNotNullParameter(idNumber, "idNumber");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function2, "onFailure");
        Intrinsics.checkNotNullParameter(function12, "onRequest");
        if (!(idName.length() == 0)) {
        }
        if (FacialBizType.INSTANCE.disallowCardNull(bizType == null ? "" : bizType)) {
            BLog.w(TAG, "参数有误, idName=" + idName + ", idNumber=" + idNumber);
            function2.invoke(-100001, "参数为空, idName=" + idName + ", idNumber=" + idNumber);
            return;
        }
        if (BiliContext.isMainProcess()) {
            String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
            ReadWriteProperty helper$delegate = Delegates.INSTANCE.notNull();
            BiliFacialCompat$facialCompat$internalCallback$1 internalCallback = new BiliFacialCompat$facialCompat$internalCallback$1(idName, idNumber, bizType, sourceEvent, helper$delegate, function2, function1, function12);
            facialCompat$lambda$1(helper$delegate, new FacialRecognitionHelper((Context) activity, accessKey, BuvidHelper.getBuvid(), internalCallback));
            facialCompat$lambda$0(helper$delegate).init();
        } else if (!activity.isFinishing() && !activity.isDestroyed()) {
            final Fragment companion = BiliAuthWebCompatFragment.Companion.getInstance(idName, idNumber, bizType, sourceEvent);
            final FragmentManager fm = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(fm, "getSupportFragmentManager(...)");
            companion.setCallback(new BiliAuthWebCompatCallback() { // from class: tv.danmaku.bili.auth.BiliFacialCompat$facialCompat$1
                @Override // tv.danmaku.bili.auth.BiliAuthWebCompatCallback
                public void onSuccess(String requestId) {
                    BLog.d("BiliFacialCompatHelper", "SubProcess::: facial onSuccess");
                    function1.invoke(requestId);
                    fm.beginTransaction().remove(companion).commitAllowingStateLoss();
                }

                @Override // tv.danmaku.bili.auth.BiliAuthWebCompatCallback
                public void onFailure(int errorCode, String msg) {
                    BLog.e("BiliFacialCompatHelper", "SubProcess::: facial onFailure, errorCode = " + errorCode + ", msg = " + msg);
                    function2.invoke(Integer.valueOf(errorCode), msg);
                    fm.beginTransaction().remove(companion).commitAllowingStateLoss();
                }
            });
            fm.beginTransaction().add(companion, BiliAuthWebCompatFragment.TAG).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FacialRecognitionHelper facialCompat$lambda$0(ReadWriteProperty<Object, FacialRecognitionHelper> readWriteProperty) {
        return (FacialRecognitionHelper) readWriteProperty.getValue((Object) null, $$delegatedProperties[0]);
    }

    private static final void facialCompat$lambda$1(ReadWriteProperty<Object, FacialRecognitionHelper> readWriteProperty, FacialRecognitionHelper facialRecognitionHelper) {
        readWriteProperty.setValue((Object) null, $$delegatedProperties[0], facialRecognitionHelper);
    }
}