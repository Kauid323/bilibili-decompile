package tv.danmaku.bili.auth;

import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliFacialCompat.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"tv/danmaku/bili/auth/BiliFacialCompat$facialCompat$internalCallback$1", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "onInitSuccess", "", "onFailure", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "", "causeCode", "onSuccess", "requestID", "onRequestStart", "onRequestEnd", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliFacialCompat$facialCompat$internalCallback$1 implements FacialRecognitionHelper.IFacialCallback {
    final /* synthetic */ String $bizType;
    final /* synthetic */ ReadWriteProperty<Object, FacialRecognitionHelper> $helper$delegate;
    final /* synthetic */ String $idName;
    final /* synthetic */ String $idNumber;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailure;
    final /* synthetic */ Function1<Boolean, Unit> $onRequest;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ String $sourceEvent;

    public /* synthetic */ void onDetectStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
    }

    public /* synthetic */ void onFailure(FacialErrorInfo facialErrorInfo) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, facialErrorInfo);
    }

    public /* synthetic */ void onSuccess(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, str, str2);
    }

    public /* synthetic */ void onSuccessForOverride(String str, String str2) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccessForOverride(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BiliFacialCompat$facialCompat$internalCallback$1(String $idName, String $idNumber, String $bizType, String $sourceEvent, ReadWriteProperty<Object, FacialRecognitionHelper> readWriteProperty, Function2<? super Integer, ? super String, Unit> function2, Function1<? super String, Unit> function1, Function1<? super Boolean, Unit> function12) {
        this.$idName = $idName;
        this.$idNumber = $idNumber;
        this.$bizType = $bizType;
        this.$sourceEvent = $sourceEvent;
        this.$helper$delegate = readWriteProperty;
        this.$onFailure = function2;
        this.$onSuccess = function1;
        this.$onRequest = function12;
    }

    public void onInitSuccess() {
        FacialRecognitionHelper facialCompat$lambda$0;
        BLog.d("BiliFacialCompatHelper", "MainProcess::: facial onInitSuccess");
        facialCompat$lambda$0 = BiliFacialCompat.facialCompat$lambda$0(this.$helper$delegate);
        String str = this.$idName;
        String str2 = this.$idNumber;
        String str3 = this.$bizType;
        if (str3 == null) {
            str3 = "";
        }
        facialCompat$lambda$0.beginDetect(str, str2, str3, this.$sourceEvent);
    }

    public void onFailure(final int errorCode, final String msg, final int causeCode) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
        final Function2<Integer, String, Unit> function2 = this.$onFailure;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliFacialCompat$facialCompat$internalCallback$1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BiliFacialCompat$facialCompat$internalCallback$1.onFailure$lambda$0(errorCode, msg, causeCode, function2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(int $errorCode, String $msg, int $causeCode, Function2 $onFailure) {
        BLog.e("BiliFacialCompatHelper", "MainProcess::: facial onFailure, errorCode = " + $errorCode + ", msg = " + $msg + ", causeCode = " + $causeCode);
        $onFailure.invoke(Integer.valueOf($causeCode), $msg);
    }

    public void onSuccess(final String requestID) {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
        final Function1<String, Unit> function1 = this.$onSuccess;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliFacialCompat$facialCompat$internalCallback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliFacialCompat$facialCompat$internalCallback$1.onSuccess$lambda$1(function1, requestID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$1(Function1 $onSuccess, String $requestID) {
        BLog.d("BiliFacialCompatHelper", "MainProcess::: facial onSuccess");
        $onSuccess.invoke($requestID);
    }

    public void onRequestStart() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
        final Function1<Boolean, Unit> function1 = this.$onRequest;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliFacialCompat$facialCompat$internalCallback$1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BiliFacialCompat$facialCompat$internalCallback$1.onRequestStart$lambda$2(function1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestStart$lambda$2(Function1 $onRequest) {
        $onRequest.invoke(true);
    }

    public void onRequestEnd() {
        FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
        final Function1<Boolean, Unit> function1 = this.$onRequest;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliFacialCompat$facialCompat$internalCallback$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BiliFacialCompat$facialCompat$internalCallback$1.onRequestEnd$lambda$3(function1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestEnd$lambda$3(Function1 $onRequest) {
        $onRequest.invoke(false);
    }
}