package com.rnbabblesdk

import com.babble.babblesdk.BabbleSDK
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableMap

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
      val hashMap = if(userDetails != null)
        DataTypeUtils.recursivelyDeconstructReadableMap(userDetails)
      else
        HashMap()
      BabbleSDK.setCustomerId(customerId = customerId,userDetails = hashMap)
    } catch (_: Exception) {
      BabbleSDK.setCustomerId(customerId = customerId,userDetails = null)
    }
  }

  @ReactMethod
  fun triggerSurvey(trigger: String,properties:  ReadableMap?) {
    try{
      val hashMap = if(properties != null)
        DataTypeUtils.recursivelyDeconstructReadableMap(properties)
      else
        HashMap()
      BabbleSDK.triggerSurvey(trigger= trigger, properties = hashMap)
    } catch (_: Exception) {
      BabbleSDK.triggerSurvey(trigger= trigger, properties = null)
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
