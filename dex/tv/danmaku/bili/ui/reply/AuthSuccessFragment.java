package tv.danmaku.bili.ui.reply;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.auth.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.ui.BaseFragment;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.report.AuthReportHelper;

public class AuthSuccessFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "AuthSuccessFragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_success_show", "show"));
        View view2 = inflater.inflate(R.layout.bili_app_fragment_auth_success, container, false);
        view2.findViewById(R.id.btn_back).setOnClickListener(this);
        StaticImageView2 imageView = view2.findViewById(R.id.imageView3);
        BiliImageLoader.INSTANCE.with(inflater.getContext()).url(AppResUtil.getImageUrl("img_holder_pay_success.webp")).into(imageView);
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_back) {
            getActivity().finish();
        }
    }
}