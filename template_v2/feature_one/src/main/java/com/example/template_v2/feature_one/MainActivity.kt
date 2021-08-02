package com.example.template_v2.feature_one

import android.app.Activity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.template_v2.feature_one.api.FeatureOneRouteConstant

@Route(path = FeatureOneRouteConstant.Activity.PATH_MAIN)
class MainActivity : Activity()