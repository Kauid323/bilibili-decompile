package tv.danmaku.bili.ui.personinfo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;

public class PersonInfoLoadHelper {
    private static final int MAX_LENGTH = 500;
    private static final int MAX_SIZE = 16777216;
    public static final String PHOTO_DIR = "bili";
    private static final String PHOTO_SUFFIX = ".jpg";
    private static final String RANDOM_AVATAR_NAME_PREFIX = "person_info_random_avatar_";
    private static Random random;
    private static final String PHOTO_TAKE_NAME = "avatar.temp";
    private static String mAvatarName = PHOTO_TAKE_NAME;

    public static AccountInfo getLocalAccountInfo(Context context) {
        BiliAccounts client;
        if (context == null || (client = BiliAccounts.get(context)) == null) {
            return null;
        }
        AccountInfo info = BiliAccountInfo.get().getAccountInfoFromCache();
        if (!client.isLogin()) {
            return null;
        }
        return info;
    }

    public static void setLocalAccountInfo(Context context, AccountInfo info, boolean shouldNotify) {
        BiliAccounts client;
        if (context == null || (client = BiliAccounts.get(context)) == null) {
            return;
        }
        boolean isValid = client.isTokenValid();
        if (isValid && info != null) {
            BiliAccountInfo.get().saveAccountInfo(info, shouldNotify);
        }
    }

    public static String convertUriToUriStr(Context context, Uri uri) {
        String picPath = queryFilePathFromProvider(context, uri);
        if (picPath != null && isAnImage(picPath)) {
            return convertFilePathToUriStr(picPath);
        }
        return null;
    }

    private static String queryFilePathFromProvider(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        String urlPath = uri.toString();
        if (urlPath.startsWith(BusinessSplashDefine.FILE_URI_PREFIX)) {
            return urlPath.replaceFirst(BusinessSplashDefine.FILE_URI_PREFIX, "");
        }
        String[] colunms = {"_data"};
        Cursor cursor = context.getContentResolver().query(uri, colunms, null, null, null);
        if (cursor == null) {
            return null;
        }
        String picPath = null;
        if (cursor.moveToFirst()) {
            picPath = cursor.getString(0);
        }
        cursor.close();
        return picPath;
    }

    private static boolean isAnImage(String picPath) {
        if (TextUtils.isEmpty(picPath)) {
            return false;
        }
        String picPathLc = picPath.toLowerCase().trim();
        return picPathLc.endsWith(PHOTO_SUFFIX) || picPathLc.endsWith(".jpeg") || picPathLc.endsWith(".png") || picPathLc.endsWith(".heif") || picPathLc.endsWith(".heic");
    }

    public static String convertFilePathToUriStr(String filePath) {
        if (filePath == null) {
            return null;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        return Uri.fromFile(file).toString();
    }

    public static String getTempFile(Context context) {
        File filesDir = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            filesDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), PHOTO_DIR);
        }
        if (filesDir == null) {
            return null;
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        String cacheDir = filesDir.getAbsolutePath();
        return cacheDir + File.separator + mAvatarName + PHOTO_SUFFIX;
    }

    public static void setAvatarName(String name) {
        mAvatarName = name;
    }

    public static Bitmap readImage(Context context, Uri originalUri) {
        Bitmap bitmap = null;
        FileInputStream inputStream = null;
        try {
            if (originalUri == null) {
                return null;
            }
            try {
                String picPath = queryFilePathFromProvider(context, originalUri);
                if (isAnImage(picPath)) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(picPath, options);
                    BitmapFactory.Options options2 = getBitmapScaleOption(options.outHeight, options.outWidth, MAX_LENGTH);
                    inputStream = new FileInputStream(picPath);
                    bitmap = BitmapFactory.decodeStream(inputStream, null, options2);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return bitmap;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static Bitmap readImageRandom() {
        Response response;
        ResponseBody body;
        String randomName = getRandomImageUriStr();
        InputStream inputStream = null;
        Bitmap bitmap = null;
        try {
            Request request = new Request.Builder().url(randomName).build();
            response = new OkHttpClient.Builder().build().newCall(request).execute();
            body = response.body();
        } catch (Exception e) {
        } catch (Throwable th) {
            IOUtils.closeQuietly((InputStream) null);
            throw th;
        }
        if (!response.isSuccessful() || body == null) {
            throw new IOException("http connect failed");
        }
        inputStream = body.byteStream();
        bitmap = BitmapFactory.decodeStream(inputStream);
        IOUtils.closeQuietly(inputStream);
        return bitmap;
    }

    public static String getRandomImageUriStr() {
        if (random == null) {
            random = new Random();
        }
        int randomIndex = Math.abs(random.nextInt(11)) + 1;
        return AppResUtil.getImageUrl(RANDOM_AVATAR_NAME_PREFIX + randomIndex + ".webp");
    }

    private static BitmapFactory.Options getBitmapScaleOption(int bitmapHeight, int bitmapWidth, int length) {
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        int scale = 1;
        while (true) {
            if (length < bitmapHeight || length < bitmapWidth) {
                bitmapWidth /= 2;
                bitmapHeight /= 2;
                scale *= 2;
            } else {
                newOptions.inSampleSize = scale;
                return newOptions;
            }
        }
    }

    public static boolean isGif(Context context, Uri uri) {
        String[] colunms = {"_data"};
        Cursor cursor = context.getContentResolver().query(uri, colunms, null, null, null);
        if (cursor == null) {
            return false;
        }
        String picPath = null;
        if (cursor.moveToFirst()) {
            picPath = cursor.getString(0);
        }
        cursor.close();
        if (picPath != null) {
            return picPath.endsWith(".gif") || picPath.endsWith(".GIF");
        }
        return false;
    }
}