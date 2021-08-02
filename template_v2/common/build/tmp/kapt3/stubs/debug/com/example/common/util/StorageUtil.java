package com.example.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0002JJ\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/common/util/StorageUtil;", "", "()V", "SAVE_FILENAME_PREFIX", "", "createFileName", "getFilePath", "context", "Landroid/content/Context;", "isSDCARDMounted", "", "storeImage", "", "bitmap", "Landroid/graphics/Bitmap;", "isSaveToCache", "onSuccess", "Lkotlin/Function1;", "Landroid/net/Uri;", "onError", "common_debug"})
public final class StorageUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.common.util.StorageUtil INSTANCE = null;
    private static final java.lang.String SAVE_FILENAME_PREFIX = "Yippi_";
    
    private StorageUtil() {
        super();
    }
    
    public final void storeImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, boolean isSaveToCache, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String createFileName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilePath(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final boolean isSDCARDMounted() {
        return false;
    }
}