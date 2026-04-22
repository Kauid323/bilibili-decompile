package tv.danmaku.bili.ui.zhima;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.bottomoptionsheet.BottomOptionSheet;
import com.bilibili.bottomoptionsheet.SheetItem;
import com.bilibili.bottomoptionsheet.listeners.OnSheetItemClickListener;
import com.bilibili.captcha.CaptchaDialog;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.facebook.drawee.backends.pipeline.Fresco;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.ui.zhima.ZhiMaProfileContract;
import tv.danmaku.bili.utils.PhotoUtil;
import tv.danmaku.bili.utils.TimerCount;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class ZhiMaProfileFragment extends BaseFragment implements ZhiMaProfileContract.View, View.OnClickListener {
    private static final String ARGS_TEL_NUM = "tel_num";
    private static final String ID_SELECT_ALBUM = "id_select_album";
    private static final String ID_SELECT_CAMERA = "id_select_camera";
    public static final String TAG = "ZhiMaProfileFragment";
    private Button mBSubmit;
    private BottomOptionSheet mBottomOptionSheet;
    private String mCaptcha;
    private CaptchaDialog mCaptchaDialog;
    private ScalableImageView2 mCardBack;
    private String mCardNumber;
    private EditText mECaptcha;
    private EditText mECardCode;
    private EditText mEName;
    private StaticImageView2 mExampleImage;
    private ZhiMaProfileContract.Presenter mPresenter;
    private TintProgressDialog mProgressDialog;
    private String mRealName;
    private TextView mTGetAuthCode;
    private TextView mTPhone;
    private String mTelNum;
    private Uri mUri;
    private TimerCount timer;
    private String mImageIdBack = "";
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfileFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            ZhiMaProfileFragment.this.isReady();
        }
    };

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mPresenter = new ZhiMaProfilePresenter(getContext(), this);
        Bundle extra = getArguments();
        if (extra != null) {
            this.mTelNum = extra.getString(ARGS_TEL_NUM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.bili_app_fragment_auth_profile, container, false);
        findViews(view2);
        initViews();
        return view2;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        super.onViewCreated(view2, savedInstanceState);
        if (this.mPresenter != null) {
            this.mPresenter.reportShow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (this.mPresenter == null) {
            return;
        }
        int id = v.getId();
        if (id == R.id.card_back) {
            showSelectPhotoDialog();
        } else if (id == R.id.get_auth_code) {
            if (!TextUtils.isEmpty(this.mTPhone.getText().toString())) {
                this.mPresenter.sendCaptcha(this.timer);
            }
        } else if (id == R.id.submit) {
            this.mCaptcha = this.mECaptcha.getText().toString();
            this.mCardNumber = this.mECardCode.getText().toString();
            this.mRealName = this.mEName.getText().toString();
            this.mPresenter.submitAuthInfo(this.mRealName, this.mCardNumber, this.mCaptcha, this.mImageIdBack);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            switch (requestCode) {
                case PhotoUtil.GALLERY_REQUEST_CODE /* 202 */:
                    if (data != null) {
                        this.mUri = data.getData();
                        showProgressDialog(getString(bili.resource.account.R.string.account_global_string_304), true);
                        if (this.mPresenter != null) {
                            this.mPresenter.uploadCardPic(this.mUri);
                            break;
                        }
                    }
                    break;
                case 301:
                    if (PhotoUtil.hasSdcard()) {
                        this.mUri = Uri.fromFile(PhotoUtil.getTempFile());
                        showProgressDialog(getString(bili.resource.account.R.string.account_global_string_304), true);
                        if (this.mPresenter != null) {
                            this.mPresenter.uploadCardPic(this.mUri);
                            break;
                        }
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void showTip(int resId) {
        ToastHelper.showToast(getActivity(), resId, 0);
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void showTip(String message) {
        ToastHelper.showToast(getActivity(), message, 0);
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
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

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void showCaptchaDialog(String url) {
        if (getActivity() == null) {
            return;
        }
        this.mCaptchaDialog = new CaptchaDialog(getActivity(), url);
        this.mCaptchaDialog.show();
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void dismissProgress() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void hideCaptchaDialog() {
        if (this.mCaptchaDialog != null) {
            this.mCaptchaDialog.dismiss();
            this.mCaptchaDialog = null;
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void updateUIAfterUpPic(String token) {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.mUri != null) {
            this.mImageIdBack = token;
            Fresco.getImagePipeline().evictFromCache(this.mUri);
            this.mCardBack.setImageURI(this.mUri);
        }
        isReady();
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void updateUIAfterConfirmGeeCaptcha() {
        if (this.mPresenter == null) {
            return;
        }
        this.mCaptcha = this.mECaptcha.getText().toString();
        this.mCardNumber = this.mECardCode.getText().toString();
        this.mRealName = this.mEName.getText().toString();
        this.mPresenter.submitAuthInfo(this.mRealName, this.mCardNumber, this.mCaptcha, this.mImageIdBack);
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public void updateUIAfterSubmitSuccess() {
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfileFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ZhiMaProfileFragment.this.m1870lambda$updateUIAfterSubmitSuccess$1$tvdanmakubiliuizhimaZhiMaProfileFragment();
            }
        }, (long) PlayerToastConfig.DURATION_3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateUIAfterSubmitSuccess$1$tv-danmaku-bili-ui-zhima-ZhiMaProfileFragment  reason: not valid java name */
    public /* synthetic */ void m1870lambda$updateUIAfterSubmitSuccess$1$tvdanmakubiliuizhimaZhiMaProfileFragment() {
        if (getActivity() == null) {
            return;
        }
        AlertDialog dialog = new AlertDialog.Builder(getActivity()).setMessage(bili.resource.account.R.string.account_global_string_260).setPositiveButton(bili.resource.account.R.string.account_global_string_247, (DialogInterface.OnClickListener) null).setNegativeButton(bili.resource.account.R.string.account_global_string_233, (DialogInterface.OnClickListener) null).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfileFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ZhiMaProfileFragment.this.m1869lambda$updateUIAfterSubmitSuccess$0$tvdanmakubiliuizhimaZhiMaProfileFragment(dialogInterface);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateUIAfterSubmitSuccess$0$tv-danmaku-bili-ui-zhima-ZhiMaProfileFragment  reason: not valid java name */
    public /* synthetic */ void m1869lambda$updateUIAfterSubmitSuccess$0$tvdanmakubiliuizhimaZhiMaProfileFragment(DialogInterface dialogT) {
        if (this.mPresenter != null) {
            this.mPresenter.confirmAuthResult();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.View
    public boolean isActivityDie() {
        return activityDie();
    }

    public ZhiMaProfileContract.Presenter getPresenter() {
        return this.mPresenter;
    }

    public static ZhiMaProfileFragment newInstance(String telNum) {
        Bundle args = new Bundle();
        args.putString(ARGS_TEL_NUM, telNum);
        ZhiMaProfileFragment fragment = new ZhiMaProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void findViews(View view2) {
        this.mCardBack = view2.findViewById(R.id.card_back);
        this.mEName = (EditText) view2.findViewById(R.id.name);
        this.mECaptcha = (EditText) view2.findViewById(R.id.auth_code);
        this.mECardCode = (EditText) view2.findViewById(R.id.card_code);
        this.mTPhone = (TextView) view2.findViewById(R.id.phone);
        this.mTGetAuthCode = (TextView) view2.findViewById(R.id.get_auth_code);
        this.mBSubmit = (Button) view2.findViewById(R.id.submit);
        this.mExampleImage = view2.findViewById(R.id.img_back_example);
    }

    private void initViews() {
        this.mProgressDialog = new TintProgressDialog(getActivity());
        this.mProgressDialog.setIndeterminate(true);
        this.mProgressDialog.setCancelable(true);
        this.mCardBack.setOnClickListener(this);
        this.mTGetAuthCode.setOnClickListener(this);
        this.mBSubmit.setOnClickListener(this);
        this.timer = new TimerCount(getApplicationContext(), 60000L, 1000L, this.mTGetAuthCode);
        this.mEName.addTextChangedListener(this.mTextWatcher);
        this.mECaptcha.addTextChangedListener(this.mTextWatcher);
        this.mECardCode.addTextChangedListener(this.mTextWatcher);
        this.mTPhone.setText(this.mTelNum);
        BiliImageLoader.INSTANCE.with(this).url(AppResUtil.getImageUrl("auth_ic_card_back.webp")).into(this.mExampleImage);
    }

    private void showSelectPhotoDialog() {
        if (this.mBottomOptionSheet == null) {
            this.mBottomOptionSheet = new BottomOptionSheet(getContext());
            this.mBottomOptionSheet.addSheetItem(new SheetItem(getContext(), ID_SELECT_ALBUM, bili.resource.account.R.string.account_global_string_466));
            this.mBottomOptionSheet.addSheetItem(new SheetItem(getContext(), ID_SELECT_CAMERA, bili.resource.account.R.string.account_global_string_467));
            this.mBottomOptionSheet.sheetItemClickListener(new OnSheetItemClickListener() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfileFragment$$ExternalSyntheticLambda0
                public final void onItemClick(SheetItem sheetItem) {
                    ZhiMaProfileFragment.this.m1868lambda$showSelectPhotoDialog$2$tvdanmakubiliuizhimaZhiMaProfileFragment(sheetItem);
                }
            });
            this.mBottomOptionSheet.show();
        } else if (!this.mBottomOptionSheet.isShowing()) {
            this.mBottomOptionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: lambda$showSelectPhotoDialog$2$tv-danmaku-bili-ui-zhima-ZhiMaProfileFragment  reason: not valid java name */
    public /* synthetic */ void m1868lambda$showSelectPhotoDialog$2$tvdanmakubiliuizhimaZhiMaProfileFragment(SheetItem item) {
        char c;
        String id = item.getId();
        switch (id.hashCode()) {
            case -2019062876:
                if (id.equals(ID_SELECT_CAMERA)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 626076176:
                if (id.equals(ID_SELECT_ALBUM)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (getActivity() != null && this.mPresenter != null && (getActivity() instanceof BaseAppCompatActivity)) {
                    this.mPresenter.openAlbum(this);
                    return;
                }
                return;
            case 1:
                if (getActivity() != null && this.mPresenter != null && (getActivity() instanceof BaseAppCompatActivity)) {
                    this.mPresenter.startCamera(this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isReady() {
        this.mCaptcha = this.mECaptcha.getText().toString();
        this.mCardNumber = this.mECardCode.getText().toString();
        this.mRealName = this.mEName.getText().toString();
        if (!TextUtils.isEmpty(this.mCaptcha) && !TextUtils.isEmpty(this.mTPhone.getText().toString()) && !TextUtils.isEmpty(this.mCardNumber) && !TextUtils.isEmpty(this.mRealName) && !TextUtils.isEmpty(this.mImageIdBack)) {
            this.mBSubmit.setEnabled(true);
        } else {
            this.mBSubmit.setEnabled(false);
        }
    }
}