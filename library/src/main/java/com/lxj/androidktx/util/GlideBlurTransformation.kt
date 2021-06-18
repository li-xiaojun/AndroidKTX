package com.lxj.androidktx.util

import android.graphics.Bitmap
import com.blankj.utilcode.util.ImageUtils
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import java.security.MessageDigest

class GlideBlurTransformation(var scale: Float = 0.5f): CenterCrop() {

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        val bmp = super.transform(pool, toTransform, outWidth, outHeight)
        return ImageUtils.fastBlur(bmp, scale, 25f)
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update("com.lxj.androidktx.util.GlideBlurTransformation".toByteArray(CHARSET))
    }
}