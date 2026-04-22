package tv.danmaku.bili.ui.garb.digital;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bili.resource.common.R;
import com.bilibili.app.authorspace.ui.nft.utils.NftExtensionKt;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarUploader;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.playset.PlaySetErrorHelper;
import com.bilibili.video.story.helper.StoryExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: DigitalCardDetailActivity.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"tv/danmaku/bili/ui/garb/digital/DigitalCardDetailActivity$mUploadCallback$1", "Lcom/bilibili/app/comm/list/avatarcommon/changeavatar/AvatarUploader$UploadCallback;", "ERROR_CODE_MODIFY_FORBIDDEN", "", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "onUploadBegin", "", "onUploadSuccess", "url", "", "onUploadFailed", "errCode", AuthResultCbHelper.ARGS_MSG, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailActivity$mUploadCallback$1 implements AvatarUploader.UploadCallback {
    private final int ERROR_CODE_MODIFY_FORBIDDEN = 10000;
    private TintProgressDialog mProgressDialog;
    final /* synthetic */ DigitalCardDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DigitalCardDetailActivity$mUploadCallback$1(DigitalCardDetailActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onUploadBegin() {
        if (!StoryExtensionKt.activityDie((Activity) this.this$0)) {
            this.mProgressDialog = TintProgressDialog.show((Context) this.this$0, (CharSequence) null, this.this$0.getString(R.string.common_global_string_227), true);
            TintProgressDialog tintProgressDialog = this.mProgressDialog;
            if (tintProgressDialog != null) {
                tintProgressDialog.setCanceledOnTouchOutside(false);
            }
        }
    }

    public void onUploadSuccess(String url) {
        if (StoryExtensionKt.activityDie((Activity) this.this$0)) {
            return;
        }
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.dismiss();
        }
        final DigitalCardDetailActivity digitalCardDetailActivity = this.this$0;
        NftExtensionKt.postOnMainThreadDelayed(500L, new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$mUploadCallback$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onUploadSuccess$lambda$0;
                onUploadSuccess$lambda$0 = DigitalCardDetailActivity$mUploadCallback$1.onUploadSuccess$lambda$0(DigitalCardDetailActivity.this);
                return onUploadSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUploadSuccess$lambda$0(DigitalCardDetailActivity this$0) {
        this$0.setResult(-1);
        this$0.finish();
        return Unit.INSTANCE;
    }

    public void onUploadFailed(int errCode, String msg) {
        if (StoryExtensionKt.activityDie((Activity) this.this$0)) {
            return;
        }
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.dismiss();
        }
        String errorStr = msg;
        if (PlaySetErrorHelper.isRealName(errCode)) {
            PlaySetErrorHelper.showDialog((Activity) this.this$0, errCode, errorStr == null ? "" : errorStr);
            return;
        }
        if (TextUtils.isEmpty(errorStr)) {
            errorStr = this.this$0.getResources().getString(R.string.common_global_string_196);
            if (errCode == -653) {
                errorStr = this.this$0.getResources().getString(com.bilibili.app.comm.list.avatarcommon.R.string.avatar_failed);
            } else if (errCode == this.ERROR_CODE_MODIFY_FORBIDDEN) {
                errorStr = this.this$0.getResources().getString(com.bilibili.app.comm.list.avatarcommon.R.string.modify_forbidden);
            }
        }
        ToastHelper.showToastShort(BiliContext.application(), errorStr);
        final DigitalCardDetailActivity digitalCardDetailActivity = this.this$0;
        NftExtensionKt.postOnMainThreadDelayed(500L, new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$mUploadCallback$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onUploadFailed$lambda$1;
                onUploadFailed$lambda$1 = DigitalCardDetailActivity$mUploadCallback$1.onUploadFailed$lambda$1(DigitalCardDetailActivity.this);
                return onUploadFailed$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUploadFailed$lambda$1(DigitalCardDetailActivity this$0) {
        this$0.setResult(-1);
        this$0.finish();
        return Unit.INSTANCE;
    }
}