/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.developers.androidify.customize

import androidx.compose.ui.geometry.Size
import com.android.developers.androidify.results.R

enum class CustomizeTool(val icon: Int, val displayName: String) {
    Size(R.drawable.size_tool_icon, "Size tool"),
    Background(R.drawable.outline_background_replace_24, "Background tool"),
}

interface ToolOption {
    val displayName: String
    val key: String
}

sealed class SizeOption(
    val aspectRatio: Float,
    val dimensions: Size,
    override val displayName: String,
    override val key: String,
) : ToolOption {

    object Square : SizeOption(1f, Size(2000f, 2000f), "1:1", "square")
    object Banner : SizeOption(4f, Size(4000f, 1000f), "Banner", "banner")
    object Wallpaper : SizeOption(9 / 16f, Size(900f, 1600f), "Wallpaper", "wallpaper")
    object SocialHeader : SizeOption(3f, Size(3000f, 1000f), "3:1", "social_header")
    object WallpaperTablet : SizeOption(1280 / 800f, Size(1280f, 800f), "Large wallpaper", "wallpaper_large")

    object Sticker: SizeOption(1f, Size(2000f, 2000f), "Sticker", "sticker")
}

sealed class BackgroundOption(
    override val displayName: String,
    override val key: String,
    val previewDrawableInt: Int?,
) : ToolOption {
    object None : BackgroundOption("None", "None", null)
    object Plain : BackgroundOption("Plain", "Plain", null)
    object Lightspeed : BackgroundOption(
        "Lightspeed",
        "Lightspeed",
        R.drawable.light_speed_dots,
    )
    object IO : BackgroundOption(
        "I/O",
        "IO",
        R.drawable.background_option_io,
    )
    // todo add Create with AI background option
    /* object Create : BackgroundOption("Create", "Create", R.drawable.background_create)*/
}
