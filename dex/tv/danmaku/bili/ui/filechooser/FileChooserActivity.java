package tv.danmaku.bili.ui.filechooser;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bili.resource.homepage.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.utils.DebugUtilsKt;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.ui.filechooser.FileListFragment;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;

public class FileChooserActivity extends FragmentActivity implements FragmentManager.OnBackStackChangedListener, FileListFragment.Callbacks, View.OnClickListener {
    public static final String EDIT_DIR_NAME = "edit_dir_name";
    public static final String EXTERNAL_BASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String EXTRA_CURRENT_BASE_PATH = "extra_current_base_path";
    public static final String PATH = "path";
    public static final int REQUEST_CODE_DOCUMENT_PROVIDER_CREATE_FILE = 8874;
    public static final int REQUEST_CODE_DOCUMENT_PROVIDER_MK_DIR = 8891;
    private static final String TAG = "FileChooserActivity";
    private String mEditDirName;
    private FragmentManager mFragmentManager;
    private String mPath;
    private BroadcastReceiver mStorageListener = new BroadcastReceiver() { // from class: tv.danmaku.bili.ui.filechooser.FileChooserActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ToastHelper.showToastLong(context.getApplicationContext(), R.string.homepage_global_string_283);
            FileChooserActivity.this.finishWithResult(null);
        }
    };
    private TextView mTitleView;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ void onBackStackChangeCancelled() {
        FragmentManager.OnBackStackChangedListener.-CC.$default$onBackStackChangeCancelled(this);
    }

    public /* synthetic */ void onBackStackChangeCommitted(Fragment fragment, boolean z) {
        FragmentManager.OnBackStackChangedListener.-CC.$default$onBackStackChangeCommitted(this, fragment, z);
    }

    public /* synthetic */ void onBackStackChangeProgressed(BackEventCompat backEventCompat) {
        FragmentManager.OnBackStackChangedListener.-CC.$default$onBackStackChangeProgressed(this, backEventCompat);
    }

    public /* synthetic */ void onBackStackChangeStarted(Fragment fragment, boolean z) {
        FragmentManager.OnBackStackChangedListener.-CC.$default$onBackStackChangeStarted(this, fragment, z);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_filechooser);
        this.mTitleView = (TextView) findViewById(tv.danmaku.bili.R.id.title);
        findViewById(tv.danmaku.bili.R.id.cancel).setOnClickListener(this);
        findViewById(tv.danmaku.bili.R.id.ok).setOnClickListener(this);
        findViewById(tv.danmaku.bili.R.id.new_folder).setOnClickListener(this);
        this.mFragmentManager = getSupportFragmentManager();
        this.mFragmentManager.addOnBackStackChangedListener(this);
        String extra = getIntent().getStringExtra(EXTRA_CURRENT_BASE_PATH);
        if (savedInstanceState == null) {
            this.mPath = extra == null ? EXTERNAL_BASE_PATH : extra;
            addFragment();
        } else {
            this.mPath = savedInstanceState.getString(PATH);
            this.mEditDirName = savedInstanceState.getString(EDIT_DIR_NAME);
        }
        setTitle(this.mPath);
    }

    protected void onPause() {
        super.onPause();
        unregisterStorageListener();
    }

    protected void onResume() {
        super.onResume();
        registerStorageListener();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PATH, this.mPath);
        if (!TextUtils.isEmpty(this.mEditDirName)) {
            outState.putString(EDIT_DIR_NAME, this.mEditDirName);
        }
    }

    public void onBackStackChanged() {
        int count = this.mFragmentManager.getBackStackEntryCount();
        if (count > 0) {
            FragmentManager.BackStackEntry fragment = this.mFragmentManager.getBackStackEntryAt(count - 1);
            this.mPath = fragment.getName();
        } else {
            this.mPath = EXTERNAL_BASE_PATH;
        }
        setTitle(this.mPath);
    }

    public void setTitle(CharSequence path) {
        this.mTitleView.setText(getString(R.string.homepage_global_string_307, new Object[]{path}));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                this.mFragmentManager.popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addFragment() {
        FileListFragment fragment = FileListFragment.newInstance(this.mPath);
        this.mFragmentManager.beginTransaction().add(tv.danmaku.bili.R.id.content, fragment).commit();
    }

    private void replaceFragment(File file) {
        this.mPath = file.getAbsolutePath();
        if (this.mPath.endsWith("..")) {
            this.mPath = file.getParentFile().getParent();
        }
        FileListFragment fragment = FileListFragment.newInstance(this.mPath);
        this.mFragmentManager.beginTransaction().replace(tv.danmaku.bili.R.id.content, fragment).setTransition(4097).addToBackStack(this.mPath).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithResult(File file) {
        if (file != null) {
            Uri uri = Uri.fromFile(file);
            setResult(-1, new Intent().setData(uri));
            finish();
            return;
        }
        setResult(0);
        finish();
    }

    @Override // tv.danmaku.bili.ui.filechooser.FileListFragment.Callbacks
    public void onFileSelected(File file) {
        if (file != null) {
            replaceFragment(file);
        } else {
            ToastHelper.showToastShort(getApplicationContext(), R.string.homepage_global_string_314);
        }
    }

    private void registerStorageListener() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MEDIA_REMOVED");
        registerReceiver(this.mStorageListener, filter);
    }

    private void unregisterStorageListener() {
        unregisterReceiver(this.mStorageListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == tv.danmaku.bili.R.id.cancel) {
            setResult(0);
            finish();
        } else if (v.getId() == tv.danmaku.bili.R.id.ok) {
            DocumentProviderCompatHelper.obtainExternalPathStoragePermission(this, this.mPath, (int) REQUEST_CODE_DOCUMENT_PROVIDER_CREATE_FILE, new DocumentProviderCompatHelper.AuthorizedCallback() { // from class: tv.danmaku.bili.ui.filechooser.FileChooserActivity.2
                public void onHasBeenAuthorized() {
                    BLog.d(FileChooserActivity.TAG, "been authorized callback confirm directory");
                    FileChooserActivity.this.confirmDirectory();
                }

                public void onAuthorizeStartFail() {
                    FileChooserActivity.this.warnDialog();
                }

                public void onAuthorizedCancel() {
                }
            });
        } else if (v.getId() == tv.danmaku.bili.R.id.new_folder) {
            showInputDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean confirmDirectory() {
        if (debugHook() || verifyDirectoryPermission(this.mPath)) {
            setResult(-1, new Intent().setData(Uri.fromFile(new File(this.mPath))));
            finish();
            return true;
        }
        warnDialog();
        return false;
    }

    private boolean debugHook() {
        if (BuildConfig.DEBUG) {
            return DebugUtilsKt.isSkipFileChooserPermissionCheck();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void warnDialog() {
        if (isFinishing()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.homepage_global_string_314).setMessage(R.string.homepage_global_string_261).setPositiveButton(bili.resource.common.R.string.common_global_string_202, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showInputDialog() {
        this.mEditDirName = "";
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle(R.string.homepage_global_string_225).setView(editText).setPositiveButton(bili.resource.common.R.string.common_global_string_202, new ConfirmListener(this, editText)).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ConfirmListener implements DialogInterface.OnClickListener {
        EditText mEdit;
        WeakReference<FileChooserActivity> mRef;

        public ConfirmListener(FileChooserActivity activity, EditText editText) {
            this.mRef = new WeakReference<>(activity);
            this.mEdit = editText;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.ui.filechooser.FileChooserActivity, android.app.Activity] */
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            if (this.mRef == null) {
                return;
            }
            final FileChooserActivity fileChooserActivity = this.mRef.get();
            fileChooserActivity.mEditDirName = this.mEdit.getText().toString();
            DocumentProviderCompatHelper.obtainExternalPathStoragePermission(fileChooserActivity, fileChooserActivity.mPath, (int) FileChooserActivity.REQUEST_CODE_DOCUMENT_PROVIDER_MK_DIR, new DocumentProviderCompatHelper.AuthorizedCallback() { // from class: tv.danmaku.bili.ui.filechooser.FileChooserActivity.ConfirmListener.1
                public void onHasBeenAuthorized() {
                    BLog.d(FileChooserActivity.TAG, "been authorized callback create directory");
                    fileChooserActivity.createDirectory(fileChooserActivity.mEditDirName);
                }

                public void onAuthorizeStartFail() {
                    fileChooserActivity.warnDialog();
                }

                public void onAuthorizedCancel() {
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (DocumentProviderCompatHelper.onSuccessDocumentProviderActivityResult(this, data)) {
                if (requestCode == 8891) {
                    createDirectory(this.mEditDirName);
                    return;
                } else if (requestCode == 8874 && confirmDirectory()) {
                    ToastHelper.showToastShort(this, bili.resource.downloads.R.string.downloads_global_string_21);
                    return;
                } else {
                    return;
                }
            }
            ToastHelper.showToastShort(this, bili.resource.downloads.R.string.downloads_global_string_72);
            return;
        }
        ToastHelper.showToastShort(this, bili.resource.downloads.R.string.downloads_global_string_86);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void createDirectory(String dir) {
        boolean result;
        if (!TextUtils.isEmpty(dir)) {
            File newdir = new File(this.mPath, dir);
            if (newdir.exists()) {
                ToastHelper.showToastShort(getApplicationContext(), R.string.homepage_global_string_189);
                return;
            }
            boolean z = true;
            if (StorageHelper.isPrimary(this, this.mPath)) {
                if (!newdir.mkdir() || !newdir.isDirectory()) {
                    z = false;
                }
                result = z;
            } else {
                VideoFile videoDir = DocumentProviderCompatHelper.getVideoFileFromFile(this, newdir);
                if (videoDir == null || !videoDir.mkdirs() || !videoDir.isDirectory()) {
                    z = false;
                }
                result = z;
            }
            ToastHelper.showToastShort(getApplicationContext(), result ? R.string.homepage_global_string_311 : R.string.homepage_global_string_199);
            if (result) {
                onFileSelected(new File(this.mPath));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean verifyDirectoryPermission(String path) {
        if (StorageHelper.isPrimary(this, path)) {
            File newDir = new File(path);
            return newDir.canRead() && newDir.canWrite();
        }
        String secondaryPath = StorageHelper.getSecondaryPath(this);
        String canonicalPath = null;
        try {
            canonicalPath = new File(path).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(secondaryPath) || TextUtils.isEmpty(canonicalPath) || !canonicalPath.startsWith(secondaryPath)) {
            return false;
        }
        VideoFile dir = DocumentProviderCompatHelper.getVideoFileFromFile(this, new File(canonicalPath));
        return dir != null && dir.canRead() && dir.canWrite();
    }
}