package tv.danmaku.bili.category;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.converter.IParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.InfoEyesOperatingDataPublicQueryString;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
public final class CategoryLoader {
    private String mAssetPath;
    private String mCacheFileDir;
    private String mCacheFileName;
    private String sApiVersion;
    private final Object sFileLock = new Object();
    private CategoryMeta sRoot;

    public CategoryLoader(String cacheFileDir, String cacheFileName) {
        this.mCacheFileDir = cacheFileDir;
        this.mCacheFileName = cacheFileName;
        this.mAssetPath = "data/" + cacheFileName;
    }

    public CategoryMeta getRootCategory(Context context) {
        if (this.sRoot != null) {
            return this.sRoot;
        }
        this.sRoot = retrieveFromCache(context);
        if (this.sRoot == null) {
            this.sRoot = loadFromAssets(context);
        }
        if (this.sRoot == null) {
            throw new AssertionError("null root category");
        }
        tryUpdate(context);
        return this.sRoot;
    }

    public void autoRefresh(Context context) {
        fetchRemote(context);
    }

    public CategoryMeta getCachedRootCategory() {
        return this.sRoot;
    }

    CategoryMeta retrieveFromCache(Context context) {
        File file = getCateJsonFile(context);
        if (file.exists() && file.isFile()) {
            String json = null;
            synchronized (this.sFileLock) {
                FileInputStream fin = null;
                try {
                    fin = new FileInputStream(file);
                    json = IOUtils.toString(fin);
                    IOUtils.closeQuietly(fin);
                } catch (IOException e) {
                    BLog.w("Error read disk region.json!", e);
                    IOUtils.closeQuietly(fin);
                }
            }
            if (TextUtils.isEmpty(json)) {
                return null;
            }
            try {
                JSONObject jobj = JSON.parseObject(json);
                if (jobj == null) {
                    return null;
                }
                return getResult(jobj);
            } catch (Exception e2) {
                BLog.w("Error parse disk region.json!");
                file.delete();
                return null;
            }
        }
        return null;
    }

    CategoryMeta loadFromAssets(Context context) {
        BLog.d("load from assets!");
        InputStream input = null;
        try {
            try {
                input = context.getAssets().open(this.mAssetPath);
                String json = IOUtils.toString(input);
                CategoryMeta root = new CategoryMeta(0, null, 0);
                root.mChildren = JSON.parseArray(json, CategoryMeta.class);
                return root;
            } finally {
                IOUtils.closeQuietly((InputStream) null);
            }
        } catch (IOException | RuntimeException e) {
            BLog.w("Error parse region json str!", e);
            return null;
        }
    }

    File getCateJsonFile(Context context) {
        File appFilesDir = new File(context.getFilesDir(), this.mCacheFileDir);
        if (!appFilesDir.exists()) {
            appFilesDir.mkdirs();
        }
        return new File(appFilesDir, this.mCacheFileName);
    }

    CategoryMeta getResult(JSONObject json) {
        if (json == null) {
            return null;
        }
        this.sApiVersion = json.getString(InfoEyesOperatingDataPublicQueryString.KEY_VER);
        try {
            JSONArray rootArray = json.getJSONArray("data");
            if (rootArray == null) {
                return null;
            }
            CategoryMeta root = new CategoryMeta(0, null, 0);
            int n = rootArray.size();
            for (int i = 0; i < n; i++) {
                root.addChild((CategoryMeta) rootArray.getObject(i, CategoryMeta.class));
            }
            return root;
        } catch (Exception e) {
            BLog.e("CategoryLoader", "Fail to parse category meta", e);
            return null;
        }
    }

    private void tryUpdate(Context context) {
        File file = getCateJsonFile(context);
        if (file.exists() && file.isFile() && file.length() > 1024) {
            long lastModified = file.lastModified();
            if (System.currentTimeMillis() - lastModified < 120000) {
                return;
            }
        }
        fetchRemote(context);
    }

    void fetchRemote(Context context) {
        final Context appContext = context.getApplicationContext();
        BiliCall<CategoryMeta> biliCall = ((RegionService) ServiceGenerator.createService(RegionService.class)).getRegionV2List(this.sApiVersion);
        biliCall.setParser(new IParser<CategoryMeta>() { // from class: tv.danmaku.bili.category.CategoryLoader.1
            public CategoryMeta convert(ResponseBody responseBody) throws IOException {
                String value = responseBody.string();
                JSONObject json = JSON.parseObject(value);
                if (json.getIntValue(LoginReporterV2.Show.SIGNUP_KEY_CODE) == 0) {
                    saveToFile(value);
                }
                return CategoryLoader.this.getResult(json);
            }

            private void saveToFile(String value) {
                synchronized (CategoryLoader.this.sFileLock) {
                    String filepath = CategoryLoader.this.getCateJsonFile(appContext).getAbsolutePath();
                    try {
                        FileUtils.stringToFile(filepath, value);
                    } catch (IOException e) {
                        BLog.e("write region.json failed.", e);
                    }
                }
            }
        });
        biliCall.enqueue(new BiliApiCallback<CategoryMeta>() { // from class: tv.danmaku.bili.category.CategoryLoader.2
            public void onSuccess(CategoryMeta newMeta) {
                if (newMeta != null && CategoryLoader.this.sRoot != null) {
                    CategoryLoader.this.sRoot.mChildren = newMeta.mChildren;
                }
            }

            public void onError(Throwable t) {
            }
        });
    }
}