package faceverify;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.dtf.toyger.base.HandlerThreadPool;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.tencent.smtt.sdk.WebView;
import com.yalantis.ucrop.view.CropImageView;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class b0 implements a0 {
    public Bitmap a(TGFrame tGFrame, int i2, boolean z) {
        char c;
        String str;
        MessageDigest messageDigest;
        boolean z2;
        int i3;
        Bitmap bitmap;
        MessageDigest messageDigest2;
        int[] iArr;
        Bitmap createBitmap;
        MessageDigest messageDigest3;
        MessageDigest messageDigest4;
        boolean z3;
        MessageDigest messageDigest5;
        MessageDigest messageDigest6;
        boolean z4;
        MessageDigest messageDigest7;
        MessageDigest messageDigest8;
        boolean z5;
        MessageDigest messageDigest9;
        int i4 = i2;
        if (tGFrame != null) {
            switch (tGFrame.frameMode) {
                case 0:
                    c = 0;
                    break;
                case 1:
                    c = 1;
                    break;
                case 2:
                    c = 2;
                    break;
                case 3:
                    c = 3;
                    break;
                case 4:
                case 6:
                    c = 4;
                    break;
                case 5:
                    c = 6;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c >= 0) {
                byte[] bArr = tGFrame.data;
                int i5 = tGFrame.width;
                int i6 = tGFrame.height;
                switch (c) {
                    case 0:
                        str = "%02X";
                        StringBuilder sb = new StringBuilder();
                        try {
                            messageDigest = MessageDigest.getInstance("MD5");
                            try {
                                messageDigest.update(bArr);
                            } catch (NoSuchAlgorithmException e2) {
                            }
                        } catch (NoSuchAlgorithmException e3) {
                            messageDigest = null;
                        }
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest();
                            int length = digest.length;
                            for (int i7 = 0; i7 < length; i7 = a.a(str, new Object[]{Byte.valueOf(digest[i7])}, sb, i7, 1)) {
                            }
                        }
                        String lowerCase = sb.toString().toLowerCase();
                        FaceDataFrameInfo.info_cache_bak = lowerCase;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= HandlerThreadPool.result_image_frame_hash.size()) {
                                z2 = false;
                            } else if (!((String) HandlerThreadPool.result_image_frame_hash.get(i8)).equals(lowerCase)) {
                                i8++;
                            } else {
                                z2 = true;
                            }
                        }
                        SgomInfoManager.updateSgomInfo(47450968, (Map) null);
                        if (!z2) {
                            HandlerThreadPool.check_image_frame_result.add(1);
                        }
                        i3 = -1637885684;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i5, i6, null);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(new Rect(0, 0, i5, i6), 100, byteArrayOutputStream);
                        try {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        } catch (OutOfMemoryError | Error e4) {
                            bitmap = null;
                        }
                        String valueOf = String.valueOf(System.identityHashCode(bitmap));
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            messageDigest2 = MessageDigest.getInstance("MD5");
                            try {
                                messageDigest2.update(valueOf.getBytes());
                            } catch (NoSuchAlgorithmException e5) {
                            }
                        } catch (NoSuchAlgorithmException e6) {
                            messageDigest2 = null;
                        }
                        if (messageDigest2 != null) {
                            byte[] digest2 = messageDigest2.digest();
                            int length2 = digest2.length;
                            for (int i9 = 0; i9 < length2; i9 = a.a(str, new Object[]{Byte.valueOf(digest2[i9])}, sb2, i9, 1)) {
                            }
                        }
                        String lowerCase2 = sb2.toString().toLowerCase();
                        HandlerThreadPool.result_image_frame_hash.add(lowerCase2);
                        FaceDataFrameInfo.info_cache = lowerCase2;
                        SgomInfoManager.updateSgomInfo(-1637885684, (Map) null);
                        break;
                    case 1:
                    case 2:
                    case 5:
                    case 6:
                        str = "%02X";
                        i3 = -1637885684;
                        bitmap = null;
                        break;
                    case 3:
                        str = "%02X";
                        Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                        createBitmap2.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
                        i3 = -1637885684;
                        bitmap = createBitmap2;
                        break;
                    case 4:
                        int length3 = bArr.length;
                        if (length3 == 0) {
                            iArr = null;
                        } else {
                            int i10 = length3 % 3 != 0 ? 1 : 0;
                            int i11 = (length3 / 3) + i10;
                            int[] iArr2 = new int[i11];
                            if (i10 == 0) {
                                for (int i12 = 0; i12 < i11; i12++) {
                                    int i13 = i12 * 3;
                                    iArr2[i12] = (f.a(bArr[i13]) << 16) | (f.a(bArr[i13 + 1]) << 8) | f.a(bArr[i13 + 2]) | WebView.NIGHT_MODE_COLOR;
                                }
                            } else {
                                int i14 = 0;
                                while (true) {
                                    int i15 = i11 - 1;
                                    if (i14 < i15) {
                                        int i16 = i14 * 3;
                                        iArr2[i14] = (f.a(bArr[i16]) << 16) | (f.a(bArr[i16 + 1]) << 8) | f.a(bArr[i16 + 2]) | WebView.NIGHT_MODE_COLOR;
                                        i14++;
                                    } else {
                                        iArr2[i15] = -16777216;
                                    }
                                }
                            }
                            iArr = iArr2;
                        }
                        if (iArr == null) {
                            createBitmap = null;
                            str = "%02X";
                        } else {
                            str = "%02X";
                            createBitmap = Bitmap.createBitmap(iArr, 0, i5, i5, i6, Bitmap.Config.ARGB_8888);
                        }
                        i3 = -1637885684;
                        bitmap = createBitmap;
                        break;
                    default:
                        i3 = -1637885684;
                        str = "%02X";
                        bitmap = null;
                        break;
                }
                SgomInfoManager.updateSgomInfo(-1917552295, (Map) null);
                if (bitmap != null) {
                    String valueOf2 = String.valueOf(System.identityHashCode(bitmap));
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        messageDigest3 = MessageDigest.getInstance("MD5");
                        try {
                            messageDigest3.update(valueOf2.getBytes());
                        } catch (NoSuchAlgorithmException e7) {
                        }
                    } catch (NoSuchAlgorithmException e8) {
                        messageDigest3 = null;
                    }
                    if (messageDigest3 != null) {
                        byte[] digest3 = messageDigest3.digest();
                        int length4 = digest3.length;
                        for (int i17 = 0; i17 < length4; i17 = a.a(str, new Object[]{Byte.valueOf(digest3[i17])}, sb3, i17, 1)) {
                        }
                    }
                    FaceDataFrameInfo.info_cache = sb3.toString().toLowerCase();
                    SgomInfoManager.updateSgomInfo(i3, (Map) null);
                    int i18 = tGFrame.rotation;
                    String valueOf3 = String.valueOf(System.identityHashCode(bitmap));
                    StringBuilder sb4 = new StringBuilder();
                    try {
                        messageDigest4 = MessageDigest.getInstance("MD5");
                        try {
                            messageDigest4.update(valueOf3.getBytes());
                        } catch (NoSuchAlgorithmException e9) {
                        }
                    } catch (NoSuchAlgorithmException e10) {
                        messageDigest4 = null;
                    }
                    if (messageDigest4 != null) {
                        byte[] digest4 = messageDigest4.digest();
                        int length5 = digest4.length;
                        for (int i19 = 0; i19 < length5; i19 = a.a(str, new Object[]{Byte.valueOf(digest4[i19])}, sb4, i19, 1)) {
                        }
                    }
                    String lowerCase3 = sb4.toString().toLowerCase();
                    FaceDataFrameInfo.info_cache_bak = lowerCase3;
                    SgomInfoManager.updateSgomInfo(-888356471, (Map) null);
                    int i20 = 0;
                    while (true) {
                        if (i20 >= HandlerThreadPool.result_image_frame_hash.size()) {
                            z3 = false;
                        } else if (!((String) HandlerThreadPool.result_image_frame_hash.get(i20)).equals(lowerCase3)) {
                            i20++;
                        } else {
                            z3 = true;
                        }
                    }
                    if (!z3) {
                        HandlerThreadPool.check_image_frame_result.add(1);
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i18);
                    Bitmap createBitmap3 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
                    String valueOf4 = String.valueOf(System.identityHashCode(createBitmap3));
                    StringBuilder sb5 = new StringBuilder();
                    try {
                        messageDigest5 = MessageDigest.getInstance("MD5");
                        try {
                            messageDigest5.update(valueOf4.getBytes());
                        } catch (NoSuchAlgorithmException e11) {
                        }
                    } catch (NoSuchAlgorithmException e12) {
                        messageDigest5 = null;
                    }
                    if (messageDigest5 != null) {
                        byte[] digest5 = messageDigest5.digest();
                        int length6 = digest5.length;
                        for (int i21 = 0; i21 < length6; i21 = a.a(str, new Object[]{Byte.valueOf(digest5[i21])}, sb5, i21, 1)) {
                        }
                    }
                    String lowerCase4 = sb5.toString().toLowerCase();
                    FaceDataFrameInfo.info_cache = lowerCase4;
                    SgomInfoManager.updateSgomInfo(47393405, (Map) null);
                    HandlerThreadPool.result_image_frame_hash.add(lowerCase4);
                    if (!createBitmap3.equals(bitmap)) {
                        bitmap.recycle();
                    }
                    SgomInfoManager.updateSgomInfo(2100103573, (Map) null);
                    if (z) {
                        SgomInfoManager.updateSgomInfo(i3, (Map) null);
                        if (createBitmap3 == null) {
                            createBitmap3 = null;
                        } else {
                            String valueOf5 = String.valueOf(System.identityHashCode(createBitmap3));
                            StringBuilder sb6 = new StringBuilder();
                            try {
                                messageDigest8 = MessageDigest.getInstance("MD5");
                                try {
                                    messageDigest8.update(valueOf5.getBytes());
                                } catch (NoSuchAlgorithmException e13) {
                                }
                            } catch (NoSuchAlgorithmException e14) {
                                messageDigest8 = null;
                            }
                            if (messageDigest8 != null) {
                                byte[] digest6 = messageDigest8.digest();
                                int length7 = digest6.length;
                                for (int i22 = 0; i22 < length7; i22 = a.a(str, new Object[]{Byte.valueOf(digest6[i22])}, sb6, i22, 1)) {
                                }
                            }
                            String lowerCase5 = sb6.toString().toLowerCase();
                            FaceDataFrameInfo.info_cache_bak = lowerCase5;
                            SgomInfoManager.updateSgomInfo(-888356471, (Map) null);
                            int i23 = 0;
                            while (true) {
                                if (i23 >= HandlerThreadPool.result_image_frame_hash.size()) {
                                    z5 = false;
                                } else if (!((String) HandlerThreadPool.result_image_frame_hash.get(i23)).equals(lowerCase5)) {
                                    i23++;
                                } else {
                                    z5 = true;
                                }
                            }
                            if (!z5) {
                                HandlerThreadPool.check_image_frame_result.add(1);
                            }
                            float[] fArr = {-1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(fArr);
                            Bitmap createBitmap4 = Bitmap.createBitmap(createBitmap3, 0, 0, createBitmap3.getWidth(), createBitmap3.getHeight(), matrix2, true);
                            createBitmap3.recycle();
                            String valueOf6 = String.valueOf(System.identityHashCode(createBitmap4));
                            StringBuilder sb7 = new StringBuilder();
                            try {
                                messageDigest9 = MessageDigest.getInstance("MD5");
                                try {
                                    messageDigest9.update(valueOf6.getBytes());
                                } catch (NoSuchAlgorithmException e15) {
                                }
                            } catch (NoSuchAlgorithmException e16) {
                                messageDigest9 = null;
                            }
                            if (messageDigest9 != null) {
                                byte[] digest7 = messageDigest9.digest();
                                int length8 = digest7.length;
                                for (int i24 = 0; i24 < length8; i24 = a.a(str, new Object[]{Byte.valueOf(digest7[i24])}, sb7, i24, 1)) {
                                }
                            }
                            String lowerCase6 = sb7.toString().toLowerCase();
                            FaceDataFrameInfo.info_cache = lowerCase6;
                            SgomInfoManager.updateSgomInfo(47393405, (Map) null);
                            HandlerThreadPool.result_image_frame_hash.add(lowerCase6);
                            createBitmap3 = createBitmap4;
                        }
                        SgomInfoManager.updateSgomInfo(2100103573, (Map) null);
                    }
                    if (createBitmap3 == null) {
                        createBitmap3 = null;
                    } else {
                        if (createBitmap3.getWidth() <= i4 || i4 <= 0) {
                            i4 = createBitmap3.getWidth();
                        }
                        if (i4 != tGFrame.width) {
                            String valueOf7 = String.valueOf(System.identityHashCode(createBitmap3));
                            StringBuilder sb8 = new StringBuilder();
                            try {
                                messageDigest6 = MessageDigest.getInstance("MD5");
                                try {
                                    messageDigest6.update(valueOf7.getBytes());
                                } catch (NoSuchAlgorithmException e17) {
                                }
                            } catch (NoSuchAlgorithmException e18) {
                                messageDigest6 = null;
                            }
                            if (messageDigest6 != null) {
                                byte[] digest8 = messageDigest6.digest();
                                int length9 = digest8.length;
                                for (int i25 = 0; i25 < length9; i25 = a.a(str, new Object[]{Byte.valueOf(digest8[i25])}, sb8, i25, 1)) {
                                }
                            }
                            String lowerCase7 = sb8.toString().toLowerCase();
                            FaceDataFrameInfo.info_cache_bak = lowerCase7;
                            int i26 = 0;
                            while (true) {
                                if (i26 >= HandlerThreadPool.result_image_frame_hash.size()) {
                                    z4 = false;
                                } else if (!((String) HandlerThreadPool.result_image_frame_hash.get(i26)).equals(lowerCase7)) {
                                    i26++;
                                } else {
                                    z4 = true;
                                }
                            }
                            SgomInfoManager.updateSgomInfo(-1662748464, (Map) null);
                            if (!z4) {
                                HandlerThreadPool.check_image_frame_result.add(1);
                            }
                            int width2 = createBitmap3.getWidth();
                            int height2 = createBitmap3.getHeight();
                            float f2 = i4 / width2;
                            Matrix matrix3 = new Matrix();
                            matrix3.postScale(f2, f2);
                            Bitmap createBitmap5 = Bitmap.createBitmap(createBitmap3, 0, 0, width2, height2, matrix3, true);
                            if (createBitmap5 != createBitmap3) {
                                createBitmap3.recycle();
                            }
                            String valueOf8 = String.valueOf(System.identityHashCode(createBitmap5));
                            StringBuilder sb9 = new StringBuilder();
                            try {
                                messageDigest7 = MessageDigest.getInstance("MD5");
                                try {
                                    messageDigest7.update(valueOf8.getBytes());
                                } catch (NoSuchAlgorithmException e19) {
                                }
                            } catch (NoSuchAlgorithmException e20) {
                                messageDigest7 = null;
                            }
                            if (messageDigest7 != null) {
                                byte[] digest9 = messageDigest7.digest();
                                int length10 = digest9.length;
                                for (int i27 = 0; i27 < length10; i27 = a.a(str, new Object[]{Byte.valueOf(digest9[i27])}, sb9, i27, 1)) {
                                }
                            }
                            String lowerCase8 = sb9.toString().toLowerCase();
                            FaceDataFrameInfo.info_cache = lowerCase8;
                            SgomInfoManager.updateSgomInfo(537768257, (Map) null);
                            HandlerThreadPool.result_image_frame_hash.add(lowerCase8);
                            createBitmap3 = createBitmap5;
                        }
                    }
                    SgomInfoManager.updateSgomInfo(-1221899931, (Map) null);
                    return createBitmap3;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}