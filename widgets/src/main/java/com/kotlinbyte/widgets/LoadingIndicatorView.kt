package com.kotlinbyte.widgets

import android.content.Context
import android.util.AttributeSet
import com.airbnb.lottie.LottieAnimationView

class LoadingIndicatorView : LottieAnimationView {

    constructor(context: Context?) : super(context) {
        load()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        load()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        load()
    }

    private fun load() {
        //setAnimation(R.raw.tv_loading)
        repeatCount = 1
        playAnimation()
    }
    
}