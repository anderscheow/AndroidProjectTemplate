package com.example.common.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import java.io.*;
import java.net.URLConnection;
import java.util.*;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J9\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001d\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000eJ\u0012\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bJ\u0012\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bJ\u0018\u0010\'\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010(\u001a\u00020)2\b\u0010 \u001a\u0004\u0018\u00010\bJ\u0012\u0010*\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010-\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u000205H\u0002J(\u00106\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0010J \u0010:\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\bJ\u0018\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u000202H\u0002J\u0016\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000e\u00a8\u0006@"}, d2 = {"Lcom/example/common/util/FileUtil;", "", "()V", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "path", "", "rootDir", "copyToFileOrThrow", "inputStream", "Ljava/io/InputStream;", "destFile", "Ljava/io/File;", "deleteDir", "", "dir", "getAbsoluteFile", "context", "Landroid/content/Context;", "getCacheFile", "isExternalCache", "getCacheFilePath", "getDataColumn", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getMimeType", "filePath", "getMimeTypeByFile", "file", "getMimeTypeByFileName", "fileName", "getMimeTypeByUrl", "url", "getPathFromUri", "getPicsWHByFile", "Landroid/graphics/BitmapFactory$Options;", "getSuffix", "isAssetsDir", "isDownloadsDocument", "isExternalStorageDocument", "isGoogleNewPhotosUri", "isGooglePhotosUri", "isMediaDocument", "readBinaryStream", "", "stream", "byteCount", "", "saveBitmapToCacheFile", "bitmap", "Landroid/graphics/Bitmap;", "name", "saveBitmapToFile", "writeFile", "cachedFile", "data", "writeStreamToFile", "input", "common_debug"})
public final class FileUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.common.util.FileUtil INSTANCE = null;
    
    private FileUtil() {
        super();
    }
    
    public final boolean deleteDir(@org.jetbrains.annotations.Nullable()
    java.io.File dir) {
        return false;
    }
    
    public final void copyAssets(@org.jetbrains.annotations.NotNull()
    android.content.res.AssetManager assets, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String rootDir) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMimeTypeByFile(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMimeTypeByUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMimeType(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.BitmapFactory.Options getPicsWHByFile(@org.jetbrains.annotations.Nullable()
    java.lang.String filePath) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSuffix(@org.jetbrains.annotations.Nullable()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMimeTypeByFileName(@org.jetbrains.annotations.Nullable()
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File getAbsoluteFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String saveBitmapToFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String saveBitmapToCacheFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    java.lang.String name, boolean isExternalCache) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File getCacheFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isExternalCache) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCacheFilePath(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPathFromUri(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDataColumn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs) {
        return null;
    }
    
    public final boolean isExternalStorageDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public final boolean isDownloadsDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public final boolean isMediaDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public final boolean isGooglePhotosUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public final boolean isGoogleNewPhotosUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public final void writeStreamToFile(@org.jetbrains.annotations.NotNull()
    java.io.InputStream input, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
    }
    
    private final boolean isAssetsDir(android.content.res.AssetManager assets, java.lang.String path) {
        return false;
    }
    
    private final void copyToFileOrThrow(java.io.InputStream inputStream, java.io.File destFile) {
    }
    
    private final byte[] readBinaryStream(java.io.InputStream stream, int byteCount) {
        return null;
    }
    
    private final boolean writeFile(java.io.File cachedFile, byte[] data) {
        return false;
    }
}