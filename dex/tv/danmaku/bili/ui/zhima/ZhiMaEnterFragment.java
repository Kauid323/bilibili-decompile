package tv.danmaku.bili.ui.zhima;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.ui.zhima.ZhiMaEnterContract;
import tv.danmaku.bili.ui.zhima.impl.AuthCheckListener;

public class ZhiMaEnterFragment extends BaseFragment implements ZhiMaEnterContract.View, View.OnClickListener {
    public static final String TAG = "ZhiMaEnterFragment";
    private AuthCheckListener mAuthCheckListener;
    private ZhiMaEnterContract.Presenter mPresenter;
    private TintProgressDialog mProgressDialog;
    private TextView mTipsAuth;

    public static ZhiMaEnterFragment newInstance(AuthCheckListener authCheckListener) {
        ZhiMaEnterFragment fragment = new ZhiMaEnterFragment();
        fragment.mAuthCheckListener = authCheckListener;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mPresenter = new ZhiMaEnterPresenter(this, this.mAuthCheckListener);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.bili_app_fragment_auth_enter, container, false);
        this.mTipsAuth = (TextView) view2.findViewById(R.id.tv_tips_manual);
        this.mTipsAuth.setOnClickListener(this);
        Button btnAuth = (Button) view2.findViewById(R.id.btn_auth_ali);
        btnAuth.setOnClickListener(this);
        this.mProgressDialog = new TintProgressDialog(getActivity());
        this.mProgressDialog.setIndeterminate(true);
        this.mProgressDialog.setCancelable(true);
        renderTips();
        BiliImageLoader.INSTANCE.with(inflater.getContext()).url(AppResUtil.getImageUrl("bili_2233_real_auth_secure.webp")).into(view2.findViewById(R.id.iv_bg));
        view2.findViewById(R.id.nav_top_bar).setVisibility(8);
        return view2;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        super.onViewCreated(view2, savedInstanceState);
        if (this.mPresenter != null) {
            this.mPresenter.reportShow();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.mPresenter != null) {
            this.mPresenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (this.mPresenter == null) {
            return;
        }
        int i = v.getId();
        if (i == R.id.tv_tips_manual) {
            this.mPresenter.manualAuth();
        } else if (i == R.id.btn_auth_ali) {
            this.mPresenter.aliAuth();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.View
    public void showTip(int resId) {
        ToastHelper.showToastShort(getContext(), resId);
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.View
    public boolean isActivityDie() {
        return activityDie();
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.View
    public void showProgressDialog(String message, boolean cancel) {
        if (this.mProgressDialog == null) {
            return;
        }
        this.mProgressDialog.setCanceledOnTouchOutside(cancel);
        this.mProgressDialog.setMessage(message);
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.View
    public void dismissProgress() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.View
    public BaseFragment getSelf() {
        return this;
    }

    private void renderTips() {
        String subTips = getString(bili.resource.account.R.string.account_global_string_325);
        String frameTips = String.format(getString(bili.resource.account.R.string.account_global_string_464), subTips);
        SpannableString spTips = new SpannableString(frameTips);
        int renderStart = frameTips.indexOf(subTips);
        int renderEnd = frameTips.indexOf(subTips) + subTips.length();
        spTips.setSpan(new ForegroundColorSpan(getResources().getColor(com.bilibili.app.comm.baseres.R.color.daynight_color_theme_pink)), renderStart, renderEnd, 33);
        this.mTipsAuth.setText(spTips);
    }
}