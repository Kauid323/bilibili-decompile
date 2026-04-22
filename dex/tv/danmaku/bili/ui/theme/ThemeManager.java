package tv.danmaku.bili.ui.theme;

import android.content.Context;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bilibili.api.BiliConfig;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.nativelibrary.LibBili;
import com.bilibili.okretro.BiliApiCallback;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import tv.danmaku.bili.ui.theme.api.BiliSkin;
import tv.danmaku.bili.ui.theme.api.BiliSkinList;
import tv.danmaku.bili.ui.theme.api.ThemeApiLoader;

public class ThemeManager {
    static final String ACCOUNT_THEME_FILE = "theme2-account";
    static final String DEFAULT_THEME_FILE = "theme2-default";
    static final String THEME_FILE_PREFIX = "theme2-";
    static final long UPDATE_ACCOUNT_INTERVAL = 0;
    static final long UPDATE_DEFAULT_INTERVAL = 86400000;
    static ThemeManager instance;
    BiliSkinList accountThemeList;
    Context context;
    BiliSkinList defaultThemeList;
    File rootFileDir;
    ThemeListener themeListener;
    BiliApiCallback<BiliSkinList> defaultThemeCallBack = new BiliApiCallback<BiliSkinList>() { // from class: tv.danmaku.bili.ui.theme.ThemeManager.1
        public void onSuccess(BiliSkinList response) {
            ThemeManager.this.saveDefaultThemeList(response);
        }

        public void onError(Throwable t) {
        }
    };
    BiliApiCallback<BiliSkinList> accountThemeCallBack = new BiliApiCallback<BiliSkinList>() { // from class: tv.danmaku.bili.ui.theme.ThemeManager.2
        public void onError(Throwable error) {
        }

        public void onSuccess(BiliSkinList response) {
            if (!BiliAccounts.get(ThemeManager.this.context).isLogin()) {
                ThemeManager.this.clearThemeFiles();
            } else {
                ThemeManager.this.saveAccountThemeList(response);
            }
        }
    };

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ThemeListener {
        void onThemeExpired();

        void onThemeFaked();

        void onThemeInvalid();
    }

    public ThemeManager(Context context) {
        this.context = context.getApplicationContext();
        checkRootDir();
    }

    private void checkRootDir() {
        if (this.rootFileDir == null) {
            this.rootFileDir = new File(this.context.getFilesDir().getAbsolutePath() + File.separator + "theme" + File.separator);
        }
        if (!this.rootFileDir.exists()) {
            this.rootFileDir.mkdirs();
        }
    }

    public static ThemeManager getInstance(Context context) {
        if (instance == null) {
            instance = new ThemeManager(context);
        }
        return instance;
    }

    public void setThemeListener(ThemeListener themeListener) {
        this.themeListener = themeListener;
    }

    public void update() {
        checkLoadDefaultThemeList();
        checkLoadAccountThemeList();
    }

    public void saveDefaultThemeList(BiliSkinList response) {
        this.defaultThemeList = response;
        saveThemeList(response, getThemeListFile(DEFAULT_THEME_FILE));
    }

    public void saveAccountThemeList(BiliSkinList response) {
        this.accountThemeList = response;
        saveThemeList(response, getThemeListFile(ACCOUNT_THEME_FILE));
    }

    private void saveThemeList(final BiliSkinList response, final File themeListFile) {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ThemeManager.this.m1687lambda$saveThemeList$0$tvdanmakubiliuithemeThemeManager(response, themeListFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveThemeList$0$tv-danmaku-bili-ui-theme-ThemeManager  reason: not valid java name */
    public /* synthetic */ Object m1687lambda$saveThemeList$0$tvdanmakubiliuithemeThemeManager(BiliSkinList response, File themeListFile) throws Exception {
        BiliSkinList serialize = (BiliSkinList) response.clone();
        String json = JSON.toJSONString(serialize);
        writeFile(json, themeListFile);
        return null;
    }

    public void clearThemeFiles() {
        if (this.accountThemeList != null && this.accountThemeList.mList != null) {
            this.accountThemeList.mList.clear();
        }
        this.accountThemeList = null;
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ThemeManager.this.m1686lambda$clearThemeFiles$1$tvdanmakubiliuithemeThemeManager();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$clearThemeFiles$1$tv-danmaku-bili-ui-theme-ThemeManager  reason: not valid java name */
    public /* synthetic */ Boolean m1686lambda$clearThemeFiles$1$tvdanmakubiliuithemeThemeManager() throws Exception {
        return Boolean.valueOf(getThemeListFile(ACCOUNT_THEME_FILE).delete());
    }

    public BiliSkinList getDefaultThemeList() {
        if (this.defaultThemeList != null) {
            return (BiliSkinList) this.defaultThemeList.clone();
        }
        return null;
    }

    public BiliSkinList getAccountThemeList() {
        if (this.accountThemeList != null) {
            return (BiliSkinList) this.accountThemeList.clone();
        }
        return null;
    }

    public void updateAccountThemeStatus(BiliSkin skin) {
        if (skin != null && this.accountThemeList != null && this.accountThemeList.mList != null) {
            ArrayList<BiliSkin> list = this.accountThemeList.mList;
            for (int i = 0; i < list.size(); i++) {
                BiliSkin mSkin = list.get(i);
                if (mSkin != null && mSkin.mId == skin.mId) {
                    list.set(i, skin);
                    saveThemeList(this.accountThemeList, getThemeListFile(ACCOUNT_THEME_FILE));
                    return;
                }
            }
        }
    }

    private void checkLoadDefaultThemeList() {
        final File defaultThemeListFile = getThemeListFile(DEFAULT_THEME_FILE);
        if (!defaultThemeListFile.exists()) {
            return;
        }
        if (!isFileReadWriteable(this.rootFileDir) || !isFileReadWriteable(defaultThemeListFile)) {
            callBackThemeFaked();
        } else {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ThemeManager.this.m1684lambda$checkLoadDefaultThemeList$2$tvdanmakubiliuithemeThemeManager(defaultThemeListFile);
                }
            }).onSuccess(new Continuation() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda5
                public final Object then(Task task) {
                    return ThemeManager.this.m1685lambda$checkLoadDefaultThemeList$3$tvdanmakubiliuithemeThemeManager(defaultThemeListFile, task);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkLoadDefaultThemeList$3$tv-danmaku-bili-ui-theme-ThemeManager  reason: not valid java name */
    public /* synthetic */ Object m1685lambda$checkLoadDefaultThemeList$3$tvdanmakubiliuithemeThemeManager(File defaultThemeListFile, Task task) throws Exception {
        this.defaultThemeList = (BiliSkinList) task.getResult();
        boolean needUpdate = this.defaultThemeList == null || System.currentTimeMillis() - defaultThemeListFile.lastModified() > UPDATE_DEFAULT_INTERVAL;
        if (needUpdate) {
            ThemeApiLoader.getList(null, this.defaultThemeCallBack);
        }
        return null;
    }

    private void checkLoadAccountThemeList() {
        int themeId = BiliTheme.readThemeId(this.context);
        if (!BiliAccounts.get(this.context).isLogin() && themeId != 2 && themeId != 1 && themeId != 8) {
            callBackThemeInvalid();
            return;
        }
        final File accountThemeListFile = getThemeListFile(ACCOUNT_THEME_FILE);
        if (!accountThemeListFile.exists()) {
            return;
        }
        if (!isFileReadWriteable(this.rootFileDir) || !isFileReadWriteable(accountThemeListFile)) {
            callBackThemeFaked();
        } else {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ThemeManager.this.m1682lambda$checkLoadAccountThemeList$4$tvdanmakubiliuithemeThemeManager(accountThemeListFile);
                }
            }).onSuccess(new Continuation() { // from class: tv.danmaku.bili.ui.theme.ThemeManager$$ExternalSyntheticLambda2
                public final Object then(Task task) {
                    return ThemeManager.this.m1683lambda$checkLoadAccountThemeList$5$tvdanmakubiliuithemeThemeManager(accountThemeListFile, task);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkLoadAccountThemeList$5$tv-danmaku-bili-ui-theme-ThemeManager  reason: not valid java name */
    public /* synthetic */ Void m1683lambda$checkLoadAccountThemeList$5$tvdanmakubiliuithemeThemeManager(File accountThemeListFile, Task task) throws Exception {
        this.accountThemeList = (BiliSkinList) task.getResult();
        if (BiliAccounts.get(this.context).isLogin()) {
            boolean needUpdate = this.accountThemeList == null || System.currentTimeMillis() - accountThemeListFile.lastModified() > 0;
            if (needUpdate) {
                ThemeApiLoader.getList(BiliAccounts.get(this.context).getAccessKey(), this.accountThemeCallBack);
                return null;
            }
            return null;
        }
        return null;
    }

    void callBackThemeInvalid() {
        if (this.themeListener != null) {
            this.themeListener.onThemeInvalid();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void callbackThemeExpired() {
        if (this.themeListener != null) {
            this.themeListener.onThemeExpired();
        }
    }

    private void callBackThemeFaked() {
        if (this.themeListener != null) {
            this.themeListener.onThemeFaked();
        }
    }

    boolean isFileReadWriteable(File file) {
        return file.canRead() && file.canWrite();
    }

    private File getThemeListFile(String fileName) {
        checkRootDir();
        File defaultTheme = new File(this.rootFileDir, fileName);
        if (!defaultTheme.exists()) {
            try {
                defaultTheme.createNewFile();
            } catch (IOException e) {
            }
        }
        return defaultTheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: readThemeListFromFile */
    public BiliSkinList m1684lambda$checkLoadDefaultThemeList$2$tvdanmakubiliuithemeThemeManager(File file) {
        try {
            byte[] bytes = readBytesFromFile(file);
            return (BiliSkinList) JSON.parseObject(bytes, BiliSkinList.class, new Feature[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] sign(byte[] content) {
        try {
            return LibBili.aesEncrypt(BiliConfig.getAppKey(), content);
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    private byte[] unsign(byte[] content) {
        try {
            return LibBili.aesDecrypt(BiliConfig.getAppKey(), content);
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    byte[] readBytesFromFile(File file) {
        FileInputStream fis = null;
        DataInputStream dis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[204800];
            while (true) {
                int length = fis.read(buffer);
                if (length <= 0) {
                    break;
                }
                bos.write(buffer, 0, length);
                bos.flush();
            }
            byte[] unsign = unsign(bos.toByteArray());
            try {
                bos.close();
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return unsign;
        } catch (Exception e2) {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            if (dis != null) {
                dis.close();
            }
            if (fis != null) {
                fis.close();
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
            if (dis != null) {
                dis.close();
            }
            if (fis != null) {
                fis.close();
            }
            throw th;
        }
    }

    void writeFile(String content, File file) {
        byte[] buffer = content.getBytes();
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            try {
                try {
                    byte[] buffer2 = sign(buffer);
                    fos = new FileOutputStream(file, false);
                    dos = new DataOutputStream(fos);
                    dos.write(buffer2);
                    dos.close();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (dos != null) {
                        dos.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (fos != null) {
                fos.close();
            }
            throw th;
        }
    }
}