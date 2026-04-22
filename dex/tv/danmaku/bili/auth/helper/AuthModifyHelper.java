package tv.danmaku.bili.auth.helper;

import android.text.TextUtils;
import bili.resource.account.R;
import com.bilibili.api.BiliApiException;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.okretro.BiliApiDataCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.CardPictureBean;
import tv.danmaku.bili.api.bean.ChangeRealnamePersonBean;
import tv.danmaku.bili.api.bean.CheckIDCradBean;
import tv.danmaku.bili.api.bean.ModifyStatusBean;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AuthModifyHelper.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u000eH\u0016J#\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0017H\u0016JH\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001dj\b\u0012\u0004\u0012\u00020\r`\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u001fH\u0016J#\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0012J#\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0012R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Ltv/danmaku/bili/auth/helper/AuthModifyHelper;", "Ltv/danmaku/bili/auth/helper/ModifyHelper;", "<init>", "()V", "requestCheckStatus", "", "requestType", "", "listener", "Ltv/danmaku/bili/auth/helper/CheckStatusListener;", "(Ljava/lang/Integer;Ltv/danmaku/bili/auth/helper/CheckStatusListener;)V", "requestCheckIDCardDigits", "digits", "", "Ltv/danmaku/bili/auth/helper/CheckCardDigitsLitener;", "checkCodeToMessage", LoginReporterV2.Show.SIGNUP_KEY_CODE, AuthResultCbHelper.ARGS_MSG, "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "requestUploadPhoto", "accessKey", "photo", "Ljava/io/File;", "Ltv/danmaku/bili/auth/helper/RequestUploadPhotoListener;", "requestChangePerson", "token_new", "token_old", "reason", "tokenList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ltv/danmaku/bili/auth/helper/RequestChangePersonListener;", "personCodeToMessage", "codeToMessage", "realnameModifyErrorCode", "", "getRealnameModifyErrorCode", "()Ljava/util/List;", "realnameModifyErrorCode$delegate", "Lkotlin/Lazy;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthModifyHelper implements ModifyHelper {
    private final Lazy realnameModifyErrorCode$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.helper.AuthModifyHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            List realnameModifyErrorCode_delegate$lambda$0;
            realnameModifyErrorCode_delegate$lambda$0 = AuthModifyHelper.realnameModifyErrorCode_delegate$lambda$0();
            return realnameModifyErrorCode_delegate$lambda$0;
        }
    });

    @Override // tv.danmaku.bili.auth.helper.ModifyHelper
    public void requestCheckStatus(Integer requestType, final CheckStatusListener listener) {
        if (requestType == null) {
            return;
        }
        BiliAuthServiceHelper.getBiliPassportServiceHelper().checkModifyStatus(requestType.intValue(), new BiliApiDataCallback<ModifyStatusBean>() { // from class: tv.danmaku.bili.auth.helper.AuthModifyHelper$requestCheckStatus$1
            public void onDataSuccess(ModifyStatusBean data) {
                if (data != null) {
                    ArrayList<String> arrayList = data.reasons;
                    boolean z = false;
                    if (arrayList != null && arrayList.isEmpty()) {
                        z = true;
                    }
                    if (z && data.status == -1) {
                        CheckStatusListener checkStatusListener = CheckStatusListener.this;
                        if (checkStatusListener != null) {
                            checkStatusListener.onPassed();
                            return;
                        }
                        return;
                    } else if (data.status == 0) {
                        CheckStatusListener checkStatusListener2 = CheckStatusListener.this;
                        if (checkStatusListener2 != null) {
                            checkStatusListener2.onApplying();
                            return;
                        }
                        return;
                    } else {
                        CheckStatusListener checkStatusListener3 = CheckStatusListener.this;
                        if (checkStatusListener3 != null) {
                            checkStatusListener3.onReject(data.reasons);
                            return;
                        }
                        return;
                    }
                }
                CheckStatusListener checkStatusListener4 = CheckStatusListener.this;
                if (checkStatusListener4 != null) {
                    checkStatusListener4.onError();
                }
            }

            public void onError(Throwable t) {
                CheckStatusListener checkStatusListener = CheckStatusListener.this;
                if (checkStatusListener != null) {
                    checkStatusListener.onError();
                }
            }
        });
    }

    @Override // tv.danmaku.bili.auth.helper.ModifyHelper
    public void requestCheckIDCardDigits(String digits, final CheckCardDigitsLitener listener) {
        String str = digits;
        if (str == null || str.length() == 0) {
            return;
        }
        BiliAuthServiceHelper.getBiliPassportServiceHelper().checkIDCardDigits(digits, new BiliApiDataCallback<CheckIDCradBean>() { // from class: tv.danmaku.bili.auth.helper.AuthModifyHelper$requestCheckIDCardDigits$1
            public void onDataSuccess(CheckIDCradBean data) {
                CheckCardDigitsLitener checkCardDigitsLitener = CheckCardDigitsLitener.this;
                if (checkCardDigitsLitener != null) {
                    checkCardDigitsLitener.onSuccess();
                }
            }

            public void onError(Throwable t) {
                String msg;
                if (t instanceof BiliApiException) {
                    msg = this.checkCodeToMessage(Integer.valueOf(((BiliApiException) t).mCode), ((BiliApiException) t).getMessage());
                    CheckCardDigitsLitener checkCardDigitsLitener = CheckCardDigitsLitener.this;
                    if (checkCardDigitsLitener != null) {
                        checkCardDigitsLitener.onError(msg);
                        return;
                    }
                    return;
                }
                CheckCardDigitsLitener checkCardDigitsLitener2 = CheckCardDigitsLitener.this;
                if (checkCardDigitsLitener2 != null) {
                    checkCardDigitsLitener2.onError(FoundationAlias.getFapp().getString(R.string.account_global_string_478));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String checkCodeToMessage(Integer code, String msg) {
        if (code == null) {
            return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
        }
        switch (code.intValue()) {
            case -400:
            case 40142:
                if (msg == null) {
                    String string = FoundationAlias.getFapp().getString(R.string.account_global_string_478);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                return msg;
            default:
                return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
        }
    }

    @Override // tv.danmaku.bili.auth.helper.ModifyHelper
    public void requestUploadPhoto(String accessKey, File photo, final RequestUploadPhotoListener listener) {
        if (photo != null) {
            RequestBody photoContent = RequestBody.create(MediaType.parse("application/octet-stream"), photo);
            BiliAuthServiceHelper.getBiliPassportServiceHelper().uploadAuthFile(accessKey == null ? "" : accessKey, photoContent, new BiliApiDataCallback<CardPictureBean>() { // from class: tv.danmaku.bili.auth.helper.AuthModifyHelper$requestUploadPhoto$1
                public void onDataSuccess(CardPictureBean data) {
                    if (data != null && !TextUtils.isEmpty(data.mToken)) {
                        RequestUploadPhotoListener requestUploadPhotoListener = RequestUploadPhotoListener.this;
                        if (requestUploadPhotoListener != null) {
                            requestUploadPhotoListener.onSuccess(data.mToken);
                            return;
                        }
                        return;
                    }
                    RequestUploadPhotoListener requestUploadPhotoListener2 = RequestUploadPhotoListener.this;
                    if (requestUploadPhotoListener2 != null) {
                        requestUploadPhotoListener2.onError();
                    }
                }

                public void onError(Throwable t) {
                    RequestUploadPhotoListener requestUploadPhotoListener = RequestUploadPhotoListener.this;
                    if (requestUploadPhotoListener != null) {
                        requestUploadPhotoListener.onError();
                    }
                }

                public boolean isCancel() {
                    RequestUploadPhotoListener requestUploadPhotoListener = RequestUploadPhotoListener.this;
                    if (requestUploadPhotoListener != null) {
                        return requestUploadPhotoListener.onCancel();
                    }
                    return false;
                }
            });
        }
    }

    @Override // tv.danmaku.bili.auth.helper.ModifyHelper
    public void requestChangePerson(String token_new, String token_old, String reason, ArrayList<String> arrayList, final RequestChangePersonListener listener) {
        Intrinsics.checkNotNullParameter(arrayList, "tokenList");
        if (!arrayList.isEmpty() && arrayList.size() >= 7) {
            if (arrayList.size() >= 7 && arrayList.size() < 9) {
                for (int i = arrayList.size(); i < 9; i++) {
                    arrayList.add("");
                }
            }
            int i2 = arrayList.size();
            if (i2 < 9) {
                return;
            }
            BiliAuthServiceHelper.getBiliPassportServiceHelper().changeRealnamePerson(token_new == null ? "" : token_new, token_old == null ? "" : token_old, reason == null ? "" : reason, arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7), arrayList.get(8), new BiliApiDataCallback<ChangeRealnamePersonBean>() { // from class: tv.danmaku.bili.auth.helper.AuthModifyHelper$requestChangePerson$1
                public void onDataSuccess(ChangeRealnamePersonBean data) {
                    RequestChangePersonListener requestChangePersonListener = RequestChangePersonListener.this;
                    if (requestChangePersonListener != null) {
                        requestChangePersonListener.OnSuccess();
                    }
                }

                public void onError(Throwable e) {
                    String msg;
                    if (e instanceof BiliApiException) {
                        msg = this.codeToMessage(Integer.valueOf(((BiliApiException) e).mCode), ((BiliApiException) e).getMessage());
                        RequestChangePersonListener requestChangePersonListener = RequestChangePersonListener.this;
                        if (requestChangePersonListener != null) {
                            requestChangePersonListener.onError(msg);
                            return;
                        }
                        return;
                    }
                    RequestChangePersonListener requestChangePersonListener2 = RequestChangePersonListener.this;
                    if (requestChangePersonListener2 != null) {
                        requestChangePersonListener2.onError(FoundationAlias.getFapp().getString(R.string.account_global_string_478));
                    }
                }
            });
        }
    }

    private final String personCodeToMessage(Integer code, String msg) {
        if (code == null) {
            return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
        }
        if (code.intValue() == 74010) {
            if (msg == null) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_478);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            return msg;
        }
        return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String codeToMessage(Integer code, String msg) {
        if (code == null) {
            return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
        }
        if (getRealnameModifyErrorCode().contains(String.valueOf(code.intValue()))) {
            if (msg == null) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_478);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            return msg;
        }
        return FoundationAlias.getFapp().getString(R.string.account_global_string_478);
    }

    public final List<String> getRealnameModifyErrorCode() {
        return (List) this.realnameModifyErrorCode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List realnameModifyErrorCode_delegate$lambda$0() {
        String str = (String) ConfigManager.Companion.config().get("auth.modify.errorcode", "40142,74010,74036,74037");
        String str2 = str != null ? str : "40142,74010,74036,74037";
        if (str2.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = StringsKt.split$default(str2, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }
}