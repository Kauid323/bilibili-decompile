package faceverify;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.dtf.face.ToygerConfig;
import com.dtf.face.network.model.Meta;
import com.dtf.face.network.request.ValidateParams;
import com.dtf.toyger.base.HandlerThreadPool;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.tencent.smtt.sdk.WebView;
import com.yalantis.ucrop.view.CropImageView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class f {
    public static int a(byte b) {
        return (((b >> 4) & 15) * 16) + (b & 15);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:5|(4:6|7|8|9)|10|(3:12|(1:14)|15)|16|(2:17|(2:19|(1:21)(2:22|23))(2:67|68))|24|(1:26)|27|(2:64|(13:66|33|34|35|36|37|38|39|40|(3:42|(1:44)|45)|46|(1:48)(1:55)|49))(1:31)|32|33|34|35|36|37|38|39|40|(0)|46|(0)(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
        com.dtf.face.log.RecordService.getInstance().recordException(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ca, code lost:
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(TGFrame tGFrame, int i2, float f2, String str, boolean z) {
        byte[] bArr;
        Bitmap a;
        MessageDigest messageDigest;
        boolean z2;
        int i3;
        MessageDigest messageDigest2;
        b0 b0Var = new b0();
        System.currentTimeMillis();
        if (tGFrame == null || (a = b0Var.a(tGFrame, i2, false)) == null) {
            bArr = null;
        } else {
            String valueOf = String.valueOf(System.identityHashCode(a));
            StringBuilder sb = new StringBuilder();
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                try {
                    messageDigest.update(valueOf.getBytes());
                } catch (NoSuchAlgorithmException e2) {
                }
            } catch (NoSuchAlgorithmException e3) {
                messageDigest = null;
            }
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                for (int i4 = 0; i4 < length; i4 = a.a("%02X", new Object[]{Byte.valueOf(digest[i4])}, sb, i4, 1)) {
                }
            }
            String lowerCase = sb.toString().toLowerCase();
            FaceDataFrameInfo.info_cache_bak = lowerCase;
            int i5 = 0;
            while (true) {
                if (i5 >= HandlerThreadPool.result_image_frame_hash.size()) {
                    z2 = false;
                    break;
                } else if (((String) HandlerThreadPool.result_image_frame_hash.get(i5)).equals(lowerCase)) {
                    z2 = true;
                    break;
                } else {
                    i5++;
                }
            }
            SgomInfoManager.updateSgomInfo(1424421581, (Map) null);
            if (!z2) {
                HandlerThreadPool.check_image_frame_result.add(1);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (f2 <= 1.0f && f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                f2 *= 100.0f;
            } else if (f2 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                i3 = 70;
                a.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                StringBuilder sb2 = new StringBuilder();
                messageDigest2 = MessageDigest.getInstance("MD5");
                messageDigest2.update(bArr);
                if (messageDigest2 != null) {
                    byte[] digest2 = messageDigest2.digest();
                    int length2 = digest2.length;
                    for (int i6 = 0; i6 < length2; i6 = a.a("%02X", new Object[]{Byte.valueOf(digest2[i6])}, sb2, i6, 1)) {
                    }
                }
                String lowerCase2 = !TextUtils.isEmpty(tGFrame.md5) ? sb2.toString().toLowerCase() : tGFrame.md5;
                HandlerThreadPool.result_image_frame_hash.add(lowerCase2);
                FaceDataFrameInfo.info_cache = lowerCase2;
                SgomInfoManager.updateSgomInfo(1186066869, (Map) null);
            }
            i3 = (int) f2;
            a.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            StringBuilder sb22 = new StringBuilder();
            messageDigest2 = MessageDigest.getInstance("MD5");
            messageDigest2.update(bArr);
            if (messageDigest2 != null) {
            }
            if (!TextUtils.isEmpty(tGFrame.md5)) {
            }
            HandlerThreadPool.result_image_frame_hash.add(lowerCase2);
            FaceDataFrameInfo.info_cache = lowerCase2;
            SgomInfoManager.updateSgomInfo(1186066869, (Map) null);
        }
        SgomInfoManager.updateSgomInfo(-1574272955, (Map) null);
        if (bArr != null) {
            int length3 = bArr.length;
        }
        return bArr;
    }

    public static void b(Meta meta, ValidateParams validateParams) {
        if (validateParams == null || meta == null) {
            return;
        }
        String ossPhotinusMetaFile = validateParams.getOssPhotinusMetaFile();
        String ossPhotinusVideoFile = validateParams.getOssPhotinusVideoFile();
        Map map = meta.collectInfo;
        if (map != null) {
            if (ossPhotinusMetaFile != null) {
                map.put("photinusMetadataFileId", ossPhotinusMetaFile);
            }
            if (ossPhotinusVideoFile != null) {
                meta.collectInfo.put("photinusVideoFileId", ossPhotinusVideoFile);
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2, boolean z) {
        int i3;
        int[] iArr;
        int i4 = i2;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i4 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i5 = width * height;
        int[] iArr2 = new int[i5];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i6 = width - 1;
        int i7 = height - 1;
        int i8 = i4 + i4 + 1;
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[Math.max(width, height)];
        int i9 = (i8 + 1) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * 256;
        int[] iArr7 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr7[i12] = i12 / i10;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(Integer.TYPE, i8, 3);
        int i13 = i4 + 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < height) {
            Bitmap bitmap2 = copy;
            int i17 = height;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = -i4;
            int i27 = 0;
            while (i26 <= i4) {
                int i28 = i7;
                int[] iArr9 = iArr6;
                int i29 = iArr2[Math.min(i6, Math.max(i26, 0)) + i15];
                int[] iArr10 = iArr8[i26 + i4];
                iArr10[0] = (i29 & 16711680) >> 16;
                iArr10[1] = (i29 & 65280) >> 8;
                iArr10[2] = i29 & WebView.NORMAL_MODE_ALPHA;
                int abs = i13 - Math.abs(i26);
                i18 = (iArr10[0] * abs) + i18;
                i19 = (iArr10[1] * abs) + i19;
                i20 = (iArr10[2] * abs) + i20;
                if (i26 > 0) {
                    i25 += iArr10[0];
                    i24 += iArr10[1];
                    i27 += iArr10[2];
                } else {
                    i23 += iArr10[0];
                    i22 += iArr10[1];
                    i21 += iArr10[2];
                }
                i26++;
                i7 = i28;
                iArr6 = iArr9;
            }
            int i30 = i7;
            int[] iArr11 = iArr6;
            int i31 = i4;
            int i32 = i27;
            int i33 = 0;
            while (i33 < width) {
                iArr3[i15] = iArr7[i18];
                iArr4[i15] = iArr7[i19];
                iArr5[i15] = iArr7[i20];
                int i34 = i18 - i23;
                int i35 = i19 - i22;
                int i36 = i20 - i21;
                int[] iArr12 = iArr8[((i31 - i4) + i8) % i8];
                int i37 = i23 - iArr12[0];
                int i38 = i22 - iArr12[1];
                int i39 = i21 - iArr12[2];
                if (i14 != 0) {
                    iArr = iArr7;
                } else {
                    iArr = iArr7;
                    iArr11[i33] = Math.min(i33 + i4 + 1, i6);
                }
                int i40 = iArr2[i16 + iArr11[i33]];
                iArr12[0] = (i40 & 16711680) >> 16;
                iArr12[1] = (i40 & 65280) >> 8;
                iArr12[2] = i40 & WebView.NORMAL_MODE_ALPHA;
                int i41 = i25 + iArr12[0];
                int i42 = i24 + iArr12[1];
                int i43 = i32 + iArr12[2];
                i18 = i34 + i41;
                i19 = i35 + i42;
                i20 = i36 + i43;
                i31 = (i31 + 1) % i8;
                int[] iArr13 = iArr8[i31 % i8];
                i23 = i37 + iArr13[0];
                i22 = i38 + iArr13[1];
                i21 = i39 + iArr13[2];
                i25 = i41 - iArr13[0];
                i24 = i42 - iArr13[1];
                i32 = i43 - iArr13[2];
                i15++;
                i33++;
                iArr7 = iArr;
            }
            i16 += width;
            i14++;
            copy = bitmap2;
            height = i17;
            i7 = i30;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i44 = i7;
        int[] iArr14 = iArr6;
        int i45 = height;
        int[] iArr15 = iArr7;
        int i46 = 0;
        while (i46 < width) {
            int i47 = -i4;
            int i48 = i8;
            int[] iArr16 = iArr2;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = i47;
            int i57 = i47 * width;
            int i58 = 0;
            int i59 = 0;
            while (i56 <= i4) {
                int i60 = width;
                int max = Math.max(0, i57) + i46;
                int[] iArr17 = iArr8[i56 + i4];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i13 - Math.abs(i56);
                i51 = (iArr3[max] * abs2) + i51;
                i52 = (iArr4[max] * abs2) + i52;
                i58 = (iArr5[max] * abs2) + i58;
                if (i56 > 0) {
                    i55 += iArr17[0];
                    i49 += iArr17[1];
                    i50 += iArr17[2];
                } else {
                    i54 += iArr17[0];
                    i53 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i61 = i44;
                if (i56 < i61) {
                    i57 += i60;
                }
                i56++;
                i44 = i61;
                width = i60;
            }
            int i62 = width;
            int i63 = i44;
            int i64 = i4;
            int i65 = i46;
            int i66 = 0;
            while (true) {
                int i67 = i50;
                i3 = i45;
                if (i66 < i3) {
                    iArr16[i65] = (iArr16[i65] & WebView.NIGHT_MODE_COLOR) | (iArr15[i51] << 16) | (iArr15[i52] << 8) | iArr15[i58];
                    int i68 = i51 - i54;
                    int i69 = i52 - i53;
                    int i70 = i58 - i59;
                    int[] iArr18 = iArr8[((i64 - i4) + i48) % i48];
                    int i71 = i54 - iArr18[0];
                    int i72 = i53 - iArr18[1];
                    int i73 = i59 - iArr18[2];
                    if (i46 == 0) {
                        iArr14[i66] = Math.min(i66 + i13, i63) * i62;
                    }
                    int i74 = iArr14[i66] + i46;
                    iArr18[0] = iArr3[i74];
                    iArr18[1] = iArr4[i74];
                    iArr18[2] = iArr5[i74];
                    int i75 = i55 + iArr18[0];
                    int i76 = i49 + iArr18[1];
                    int i77 = i67 + iArr18[2];
                    i51 = i68 + i75;
                    i52 = i69 + i76;
                    i58 = i70 + i77;
                    i64 = (i64 + 1) % i48;
                    int[] iArr19 = iArr8[i64];
                    i54 = i71 + iArr19[0];
                    i53 = i72 + iArr19[1];
                    i59 = i73 + iArr19[2];
                    i55 = i75 - iArr19[0];
                    i49 = i76 - iArr19[1];
                    i65 += i62;
                    i66++;
                    i45 = i3;
                    i50 = i77 - iArr19[2];
                    i4 = i2;
                }
            }
            i46++;
            i4 = i2;
            i45 = i3;
            i44 = i63;
            i8 = i48;
            iArr2 = iArr16;
            width = i62;
        }
        int i78 = width;
        bitmap3.setPixels(iArr2, 0, i78, 0, 0, i78, i45);
        return bitmap3;
    }

    public static String a(String str) {
        String mainBucketName = ToygerConfig.getInstance().getMainBucketName();
        String finalBucket = ToygerConfig.getInstance().getFinalBucket();
        return (mainBucketName == null || finalBucket == null || TextUtils.equals(mainBucketName, finalBucket)) ? str : str.replace(mainBucketName, finalBucket);
    }

    public static void a(Meta meta, ValidateParams validateParams) {
        List<Pair> ossOptionalFiles;
        if (validateParams == null || meta == null) {
            return;
        }
        if (meta.collectInfo != null && (ossOptionalFiles = validateParams.getOssOptionalFiles()) != null) {
            for (Pair pair : ossOptionalFiles) {
                meta.collectInfo.put(pair.first, pair.second);
            }
        }
        if (TextUtils.isEmpty(validateParams.getVerifyCollectSig())) {
            return;
        }
        meta.collectInfoSig = validateParams.getVerifyCollectSig();
    }

    public static void a(Map<String, Object> map, ValidateParams validateParams) {
        if (validateParams.getChameleonFileName() != null) {
            map.put("chameleonFrameFile", validateParams.getChameleonFileName());
        } else {
            map.remove("chameleonFrameFile");
        }
        if (validateParams.getChameleonMetaInfo() != null) {
            map.put("chameleonMetaInfo", validateParams.getChameleonMetaInfo());
        } else {
            map.remove("chameleonMetaInfo");
        }
    }
}