import BabbleiOS
@objc(RnBabbleSdk)
class RnBabbleSdk: NSObject {
  
    @objc(multiply:withB:withResolver:withRejecter:)
    func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
      resolve(a*b)
    }
    
    @objc(configure:)
    func configure(userId: String) -> Void {
        BabbleSdk.configure(userId)
    }
        
    @objc(setCustomerId:userDetails:)
    func setCustomerId(customerId: String,userDetails: [String: Any]? = nil) -> Void {
        BabbleSdk.setCustomerId(customerId, userDetails: userDetails)
    }
    
    @objc(triggerSurvey:properties:)
    func triggerSurvey(trigger: String,properties: [String: Any]? = nil) -> Void {
        DispatchQueue.main.async {
            BabbleSdk.trigger(trigger, properties: properties)
        }
    }
}
