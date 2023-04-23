#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(RnBabbleSdk, NSObject)

RCT_EXTERN_METHOD(multiply:(float)a withB:(float)b
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)


RCT_EXTERN_METHOD(configure:(NSString *)userId)

RCT_EXTERN_METHOD(setCustomerId:(NSString *)customerId userDetails:(NSDictionary *)userDetails)

RCT_EXTERN_METHOD(triggerSurvey:(NSString *)trigger properties:(NSDictionary *)properties)

+ (BOOL)requiresMainQueueSetup
{
  return NO;
}

@end
