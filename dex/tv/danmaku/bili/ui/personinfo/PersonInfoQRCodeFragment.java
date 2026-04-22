package tv.danmaku.bili.ui.personinfo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bili.resource.profile.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.comm.supermenu.share.v2.ShareContentProvider;
import com.bilibili.app.comm.supermenu.share.v2.SharePanelWrapper;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.MediaUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.sharewrapper.basic.ThirdPartyExtraBuilder;
import com.bilibili.lib.sharewrapper.online.ShareOnlineParams;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.PermissionsChecker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonInfoQRCodeFragment extends BaseFragment {
    private static final int PERMISSION_REQUEST_STORAGE_CODE = 1;
    private static final String QR_URL = "https://space.bilibili.com/";
    public static final String TAG = "PersonInfoQRCodeFragment";
    AccountInfo myInfo;
    private RelativeLayout qrBackground;
    boolean isSaving = false;
    private Bitmap bitmap = null;
    private ShareContentProvider mShareContentProvider = new ShareContentProvider() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoQRCodeFragment.3
        public Bundle getShareContent(String target) {
            String targetUrl = PersonInfoQRCodeFragment.QR_URL + String.valueOf(PersonInfoQRCodeFragment.this.myInfo.getMid());
            return new ThirdPartyExtraBuilder().title(PersonInfoQRCodeFragment.this.getString(R.string.profile_global_string_42)).content(targetUrl).targetUrl(targetUrl).shareType("type_image").imageBmp(PersonInfoQRCodeFragment.this.bitmap).build();
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(com.bilibili.app.personinfo.R.layout.bili_app_fragment_perinfo_qrcode, container, false);
        this.qrBackground = (RelativeLayout) view2.findViewById(com.bilibili.app.personinfo.R.id.qr_background);
        this.myInfo = PersonInfoLoadHelper.getLocalAccountInfo(getActivity());
        if (this.myInfo != null) {
            ImageView qrCode = (ImageView) view2.findViewById(com.bilibili.app.personinfo.R.id.qr_code);
            StaticImageView2 avatar = view2.findViewById(com.bilibili.app.personinfo.R.id.avatar);
            TextView userName = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.user_name);
            TextView userId = (TextView) view2.findViewById(com.bilibili.app.personinfo.R.id.uid);
            BiliImageLoader.INSTANCE.with(avatar.getContext()).url(this.myInfo.getAvatar()).into(avatar);
            String userNameStr = this.myInfo.getUserName();
            if (!TextUtils.isEmpty(userNameStr) && userNameStr.getBytes().length > 36) {
                userName.setTextSize(12.0f);
            } else {
                userName.setTextSize(15.0f);
            }
            userName.setText(userNameStr);
            int sex = this.myInfo.getSex();
            switch (sex) {
                case 1:
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.bilibili.app.personinfo.R.drawable.ic_user_male, 0);
                    break;
                case 2:
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.bilibili.app.personinfo.R.drawable.ic_user_female, 0);
                    break;
                default:
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    break;
            }
            userId.setText(getString(com.bilibili.app.personinfo.R.string.qrcode_uid_format, new Object[]{String.valueOf(this.myInfo.getMid())}));
            Bitmap bitmap = encodeAsBitmap(QR_URL + String.valueOf(this.myInfo.getMid()));
            if (bitmap != null) {
                qrCode.setImageBitmap(bitmap);
            }
        }
        return view2;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == com.bilibili.app.personinfo.R.id.menu_share) {
            saveToLocal(true);
        } else if (item.getItemId() == com.bilibili.app.personinfo.R.id.menu_download) {
            saveToLocal(false);
        }
        return true;
    }

    private void saveToLocal(final boolean share) {
        FragmentActivity activity;
        if (this.isSaving || (activity = getActivity()) == null) {
            return;
        }
        PermissionsChecker.grantPermission(activity, getLifecycle(), PermissionsChecker.STORAGE_PERMISSIONS, 1, bili.resource.common.R.string.common_global_string_334, getString(bili.resource.common.R.string.common_global_string_316)).continueWith(new Continuation<Void, Boolean>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoQRCodeFragment.2
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1427then(Task task) throws Exception {
                return then((Task<Void>) task);
            }

            public Boolean then(Task<Void> task) throws Exception {
                if (task.isFaulted() || task.isCancelled() || PersonInfoQRCodeFragment.this.qrBackground == null || PersonInfoQRCodeFragment.this.myInfo == null || PersonInfoQRCodeFragment.this.isSaving) {
                    return false;
                }
                PersonInfoQRCodeFragment.this.isSaving = true;
                PersonInfoQRCodeFragment.this.bitmap = PersonInfoQRCodeHelper.getBitmapFromView(PersonInfoQRCodeFragment.this.qrBackground);
                boolean result = PersonInfoQRCodeFragment.this.saveBitmap(PersonInfoQRCodeFragment.this.bitmap, share);
                PersonInfoQRCodeFragment.this.isSaving = false;
                return Boolean.valueOf(result);
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<Boolean, Void>() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoQRCodeFragment.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1426then((Task<Boolean>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1426then(Task<Boolean> task) throws Exception {
                Boolean result = (Boolean) task.getResult();
                if (result == null || !result.booleanValue()) {
                    ToastHelper.showToast(PersonInfoQRCodeFragment.this.getApplicationContext(), bili.resource.common.R.string.common_global_string_110, 0);
                    return null;
                } else if (!share || PersonInfoQRCodeFragment.this.getActivity() == null || PersonInfoQRCodeFragment.this.isDetached()) {
                    ToastHelper.showToast(PersonInfoQRCodeFragment.this.getApplicationContext(), bili.resource.common.R.string.common_global_string_28, 0);
                    return null;
                } else {
                    PersonInfoQRCodeFragment.this.showSharePanel();
                    return null;
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (1 == requestCode) {
            PermissionsChecker.onPermissionResult(requestCode, permissions, grantResults);
        }
    }

    Bitmap encodeAsBitmap(String str) {
        int length = (int) TypedValue.applyDimension(1, 145.0f, getApplicationContext().getResources().getDisplayMetrics());
        return QrCodeHelper.generate(str, length, length, -13807472);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveBitmap(Bitmap bitmap, boolean share) {
        String name;
        File dir;
        if (share) {
            name = this.myInfo.getUserName() + getString(R.string.profile_global_string_9) + ".png";
            dir = getApplicationContext().getCacheDir();
        } else {
            name = this.myInfo.getUserName() + getString(R.string.profile_global_string_9) + System.currentTimeMillis() + ".png";
            dir = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_PICTURES);
        }
        File file = new File(dir, name);
        FileOutputStream fOut = null;
        try {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                if (!share) {
                    MediaUtils.insertMediaToPictureFolderSync(getContext(), file, file.getName());
                }
                IOUtils.closeQuietly(fOut);
                return true;
            } catch (IOException e) {
                file.delete();
                IOUtils.closeQuietly(fOut);
                return false;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(fOut);
            throw th;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSharePanel() {
        SharePanelWrapper.with(getActivity()).shareOnlineParams(ShareOnlineParams.builder().shareMode(21).oid(String.valueOf(this.myInfo.getMid())).shareId("main.account-information.share.0.click").spmId("main.account-information.share.0").build()).shareContentProvider(this.mShareContentProvider).show();
    }
}