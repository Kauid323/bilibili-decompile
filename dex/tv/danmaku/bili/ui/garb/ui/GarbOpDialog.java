package tv.danmaku.bili.ui.garb.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.app.theme.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: GarbOpDialog.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/garb/ui/GarbOpDialog;", "Ltv/danmaku/bili/widget/BaseDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/app/Activity;", "garbDetail", "Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "<init>", "(Landroid/app/Activity;Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;)V", "getContext", "()Landroid/app/Activity;", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "", "onViewCreated", "view", "buildExpiredStr", "", "onClick", "v", "onConfirmClick", "showProgressDialog", "dismissProgressDialog", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbOpDialog extends BaseDialog<GarbOpDialog> implements View.OnClickListener {
    private final Activity context;
    private final GarbData.GarbDetail garbDetail;
    private TintProgressDialog mProgressDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GarbOpDialog(Activity context, GarbData.GarbDetail garbDetail) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        this.context = context;
        this.garbDetail = garbDetail;
        widthScale(0.85f);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final Activity getContext() {
        return this.context;
    }

    public View onCreateView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bili_app_layout_garb_push_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void setUiBeforeShow() {
    }

    public void onViewCreated(View view) {
        super.onViewCreated(view);
        if (view == null) {
            return;
        }
        ImageView headBg = (ImageView) view.findViewById(R.id.header_bg);
        TextView content = (TextView) view.findViewById(R.id.content);
        TextView action = (TextView) view.findViewById(R.id.action);
        action.setOnClickListener(this);
        ((TextView) view.findViewById(R.id.cancel)).setOnClickListener(this);
        ((ImageView) view.findViewById(R.id.close)).setOnClickListener(this);
        content.setText(this.context.getString(bili.resource.settings.R.string.settings_global_string_216, new Object[]{this.garbDetail.getName(), buildExpiredStr(this.garbDetail)}));
        action.setText(this.context.getString(bili.resource.homepage.R.string.homepage_global_string_241));
        headBg.setImageResource(R.drawable.ic_garb_push_dialog_new_skin);
        GarbStorageHelper.INSTANCE.setShowDialogGarbId(this.context, this.garbDetail.getId());
    }

    private final String buildExpiredStr(GarbData.GarbDetail garbDetail) {
        GarbData.OpConf conf = garbDetail.getConf();
        if (conf != null) {
            long it = conf.getEnd();
            if (it <= 0) {
                return "";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String format = dateFormat.format(new Date(1000 * it));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        boolean z = true;
        if (!(v != null && v.getId() == R.id.close)) {
            if (!(v != null && v.getId() == R.id.cancel)) {
                if (v == null || v.getId() != R.id.action) {
                    z = false;
                }
                if (z) {
                    onConfirmClick();
                    return;
                }
                return;
            }
            dismiss();
            return;
        }
        dismiss();
    }

    private final void onConfirmClick() {
        showProgressDialog();
        GarbStorageHelper.INSTANCE.download(this.garbDetail, new GarbStorageHelper.Listener() { // from class: tv.danmaku.bili.ui.garb.ui.GarbOpDialog$onConfirmClick$1
            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public void onDownloadSuccess() {
                GarbData.GarbDetail garbDetail;
                GarbOpDialog.this.dismissProgressDialog();
                GarbOpDialog.this.dismiss();
                garbDetail = GarbOpDialog.this.garbDetail;
                GarbManagerDelegate.setCurGarb(garbDetail);
            }

            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public void onDownloadError(String errMsg) {
                GarbOpDialog.this.dismissProgressDialog();
                ToastHelper.showToast(GarbOpDialog.this.getContext(), GarbOpDialog.this.getContext().getString(bili.resource.common.R.string.common_global_string_351), 0);
            }

            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public boolean isCanceled() {
                return GarbOpDialog.this.getContext().isFinishing();
            }
        });
    }

    private final void showProgressDialog() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = TintProgressDialog.show(this.context, "", this.context.getString(bili.resource.common.R.string.common_global_string_350), true, false);
        }
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissProgressDialog() {
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.dismiss();
        }
    }
}