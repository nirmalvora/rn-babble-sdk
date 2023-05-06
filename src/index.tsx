import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'rn-babble-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const RnBabbleSdk = NativeModules.RnBabbleSdk
  ? NativeModules.RnBabbleSdk
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

// export function multiply(a: number, b: number): Promise<number> {
//   return RnBabbleSdk.multiply(a, b);
// }
export default class BabbleSdk {
  static async init(user_id: String) {
    return RnBabbleSdk.configure(user_id);
  }
  static async setCustomerId(customerId: String, userDetails?: any) {
    return RnBabbleSdk.setCustomerId(customerId, userDetails);
  }
  static async triggerSurvey(trigger: String, properties?: any) {
    return RnBabbleSdk.triggerSurvey(trigger, properties);
  }
  static async cancelSurvey() {
    return RnBabbleSdk.cancelSurvey();
  }
}
