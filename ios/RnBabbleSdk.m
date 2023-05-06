#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(RnBabbleSdk, NSObject)


RCT_EXTERN_METHOD(configure:(NSString *)userId)

RCT_EXTERN_METHOD(setCustomerId:(NSString *)customerId userDetails:(NSDictionary *)userDetails)

RCT_EXTERN_METHOD(triggerSurvey:(NSString *)trigger properties:(NSDictionary *)properties)

RCT_EXTERN_METHOD(cancelSurvey)

+ (BOOL)requiresMainQueueSetup
{
  return NO;
}

@end
