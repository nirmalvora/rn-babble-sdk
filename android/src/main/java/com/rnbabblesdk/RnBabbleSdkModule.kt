package com.rnbabblesdk

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.babble.babblesdk.BabbleSDK
import java.util.HashMap
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.ReactMethod
class RnBabbleSdkModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun configure(user_id: String) {
    try{
      BabbleSDK.init(this.getCurrentActivity()!!.getApplicationContext(),user_id)
    } catch (e: Exception) {

    }
  }

  @ReactMethod
  fun setCustomerId(customerId: String,userDetails: ReadableMap?) {
    try{
      val hashMap = DataTypeUtils.recursivelyDeconstructReadableMap(userDetails)
      BabbleSDK.setCustomerId(customerId = customerId,userDetails = hashMap)
    } catch (_: Exception) {

    }
  }

  @ReactMethod
  fun triggerSurvey(trigger: String,properties:  ReadableMap?) {
    try{
      val hashMap = DataTypeUtils.recursivelyDeconstructReadableMap(properties)
      BabbleSDK.triggerSurvey(trigger= trigger, properties = hashMap)
    } catch (_: Exception) {

    }
  }

 @ReactMethod
  fun cancelSurvey() {
    try{
      BabbleSDK.cancelSurvey()
    } catch (_: Exception) {

    }
  }
  companion object {
    const val NAME = "RnBabbleSdk"
  }
}
