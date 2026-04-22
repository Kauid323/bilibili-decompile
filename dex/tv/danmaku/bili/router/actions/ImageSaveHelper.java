package tv.danmaku.bili.router.actions;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import bili.resource.share.R;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.commons.security.DigestUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public class ImageSaveHelper {
    private static final String CODE_AUTHORITY_ERROR = "-2";
    private static final String CODE_READ_FILE_ERROR = "-3";
    private static final String CODE_REPEAT_ERROR = "-5";
    private static final String CODE_SAVE_ERROR = "-4";
    private static final String CODE_SUCCESS = "0";
    private static final String CODE_UNKNOWN_ERROR = "-1";
    private static final String FIELD_BASE64 = "base64_data";
    private static final String FIELD_CANCELED = "canceled";
    private static final String FIELD_IMAGE_URL = "image_url";
    private static final String KEY_CODE = "code";
    private static final String KEY_MSG = "errMsg";
    private static final String PATH_NAME = "bili";
    private static final char SYMBOL_COMMA = ',';
    private static final char SYMBOL_SEMICOLON = ';';
    private static final char SYMBOL_SPOT = '.';
    private static final Pattern IMAGE_TYPE = Pattern.compile("data:image/([a-zA-Z]+)", 2);
    private static final Map<String, String> sMsgMap = new HashMap();

    static {
        sMsgMap.put("0", BiliContext.application().getResources().getString(R.string.share_global_string_42));
        sMsgMap.put("-1", BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_8));
        sMsgMap.put(CODE_AUTHORITY_ERROR, BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_297));
        sMsgMap.put(CODE_READ_FILE_ERROR, BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_295));
        sMsgMap.put(CODE_SAVE_ERROR, BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_296));
        sMsgMap.put(CODE_REPEAT_ERROR, BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_298));
    }

    public static JSONObject saveImage(Context context, boolean isCanceled, String imageUrl, String base64Data) {
        File file;
        File file2;
        JSONObject result = new JSONObject();
        if (context == null) {
            return getErrorMsg(result, "-1");
        }
        if (isCanceled) {
            return getErrorMsg(result, CODE_AUTHORITY_ERROR);
        }
        if (TextUtils.isEmpty(imageUrl) && TextUtils.isEmpty(base64Data)) {
            return getErrorMsg(result, CODE_READ_FILE_ERROR);
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            String suffixes = getSuffixesFromUrl(imageUrl);
            String fileName = DigestUtils.md5(imageUrl) + (TextUtils.isEmpty(suffixes) ? "" : SYMBOL_SPOT + suffixes);
            try {
                file2 = new File(buildSavePath(fileName));
            } catch (IOException e) {
                e.printStackTrace();
                getErrorMsg(result, CODE_SAVE_ERROR);
            }
            if (file2.exists()) {
                return getErrorMsg(result, CODE_REPEAT_ERROR);
            }
            downloadImageWithUrl(imageUrl, file2);
            String type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(suffixes);
            notifyScanFile(context, file2, type);
            getErrorMsg(result, "0");
            return result;
        }
        String suffixes2 = getSuffixesFromBase64(base64Data);
        if (TextUtils.isEmpty(suffixes2)) {
            return getErrorMsg(result, CODE_READ_FILE_ERROR);
        }
        String fileName2 = DigestUtils.md5(String.valueOf(System.currentTimeMillis())) + (TextUtils.isEmpty(suffixes2) ? "" : SYMBOL_SPOT + suffixes2);
        try {
            file = new File(buildSavePath(fileName2));
        } catch (Exception e2) {
            e2.printStackTrace();
            getErrorMsg(result, CODE_SAVE_ERROR);
        }
        if (file.exists()) {
            return getErrorMsg(result, CODE_REPEAT_ERROR);
        }
        downloadImageWithBase64(base64Data, file);
        String type2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(suffixes2);
        notifyScanFile(context, file, type2);
        getErrorMsg(result, "0");
        return result;
    }

    private static JSONObject getErrorMsg(JSONObject json, String errorCode) {
        json.put("code", errorCode);
        json.put(KEY_MSG, sMsgMap.get(errorCode));
        return json;
    }

    private static String getSuffixesFromUrl(String imageUrl) {
        return MimeTypeMap.getFileExtensionFromUrl(imageUrl);
    }

    private static String getSuffixesFromBase64(String base64Data) {
        String mineStr = base64Data.substring(0, base64Data.indexOf(59));
        Matcher m = IMAGE_TYPE.matcher(mineStr);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    private static void downloadImageWithUrl(String imageUrl, File file) throws IOException {
        URL url = new URL(imageUrl);
        FileUtils.copyURLToFile(url, file);
    }

    private static void downloadImageWithBase64(String base64Data, File file) throws IOException {
        String base64Str = base64Data.substring(base64Data.indexOf(44) + 1, base64Data.length());
        byte[] data = Base64.decode(base64Str, 0);
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                data[i] = (byte) (data[i] + 256);
            }
        }
        FileUtils.writeByteArrayToFile(file, data);
    }

    private static void notifyScanFile(Context context, File destFile, String type) {
        ContentValues values = initCommonContentValue(destFile);
        values.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        values.put("orientation", (Integer) 0);
        values.put("orientation", (Integer) 0);
        values.put("mime_type", type);
        context.getApplicationContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(destFile)));
    }

    private static ContentValues initCommonContentValue(File destFile) {
        ContentValues values = new ContentValues();
        long currentTimeInSeconds = System.currentTimeMillis();
        values.put(ReportUtilKt.POS_TITLE, destFile.getName());
        values.put("_display_name", destFile.getName());
        values.put("date_modified", Long.valueOf(currentTimeInSeconds));
        values.put("date_added", Long.valueOf(currentTimeInSeconds));
        values.put("_data", destFile.getAbsolutePath());
        values.put("_size", Long.valueOf(destFile.length()));
        return values;
    }

    private static String buildSavePath(String fileName) {
        String dirPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + "bili";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.getAbsolutePath() + File.separator + fileName;
    }
}