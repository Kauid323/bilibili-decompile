package j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.web.WebActivity;
import f.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class e extends b {
    public WeiboMultiMessage c;
    public String d;
    public String e;
    public String f;
    public byte[] g;
    public String h;

    public e(Context context) {
        this.a = context;
    }

    @Override // j.b
    public final String a() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.f);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.b.a.getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.d)) {
            buildUpon.appendQueryParameter("access_token", this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            buildUpon.appendQueryParameter("packagename", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            buildUpon.appendQueryParameter("picinfo", this.h);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    @Override // j.b
    public final boolean b() {
        byte[] bArr = this.g;
        return bArr != null && bArr.length > 0;
    }

    @Override // j.b
    public final void a(Bundle bundle) {
        byte[] bArr;
        FileInputStream fileInputStream;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.c = weiboMultiMessage;
        weiboMultiMessage.readFromBundle(bundle);
        this.d = bundle.getString("token");
        this.e = bundle.getString("packageName");
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.c.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        ImageObject imageObject = this.c.imageObject;
        if (imageObject != null) {
            String str = imageObject.imagePath;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.g = g.e.a(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        bArr = imageObject.imageData;
                        if (bArr != null) {
                            this.g = g.e.a(bArr);
                        }
                        this.f = sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.g = g.e.a(bArr);
            }
        }
        this.f = sb.toString();
    }

    @Override // j.b
    public final void a(WebActivity.a aVar) {
        b.a.a.a(new f.e(this.a, new String(this.g), this.b.a.getAppKey(), this.d, new d(this, aVar)));
    }
}