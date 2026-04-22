package tv.danmaku.bili.ui.personinfo;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.personinfo.R;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.BaseDialog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoOfficialDialog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/PersonInfoOfficialDialog;", "Ltv/danmaku/bili/widget/BaseDialog;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoOfficialDialog extends BaseDialog<PersonInfoOfficialDialog> {
    public static final int $stable = 8;
    private final Activity activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoOfficialDialog(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Override // tv.danmaku.bili.widget.BaseDialog
    public View onCreateView() {
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_layout_perinfo_official_dialiog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(view2, "inflate(...)");
        TextView cancelView = (TextView) view2.findViewById(R.id.cancel);
        cancelView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoOfficialDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PersonInfoOfficialDialog.this.dismiss();
            }
        });
        TextView confirmView = (TextView) view2.findViewById(R.id.change);
        confirmView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoOfficialDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PersonInfoOfficialDialog.onCreateView$lambda$1(PersonInfoOfficialDialog.this, view3);
            }
        });
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(PersonInfoOfficialDialog this$0, View it) {
        Uri parse = Uri.parse("https://account.bilibili.com/official/mobile/condition?update=1");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest routeRequest = new RouteRequest.Builder(parse).build();
        BLRouter.routeTo(routeRequest, this$0.activity);
        this$0.dismiss();
    }

    @Override // tv.danmaku.bili.widget.BaseDialog
    public void setUiBeforeShow() {
    }
}