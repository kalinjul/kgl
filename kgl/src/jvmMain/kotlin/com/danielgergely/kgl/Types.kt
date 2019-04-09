package com.danielgergely.kgl

import java.io.InputStream

actual typealias Shader = Int

actual typealias Program = Int

actual typealias UniformLocation = Int

actual typealias GlBuffer = Int

actual typealias Texture = Int

//This is because of a LWJGL segmentation fault on linux
//TODO investigate, change to raw byte buffer
actual class TextureResource(@JvmField val encodedPng: InputStream)
actual fun TextureResource.dispose() = encodedPng.close()