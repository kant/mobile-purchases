export interface DeveloperNotification {
    version: string,
    packageName: string,
    eventTimeMillis: number
    subscriptionNotification: SubscriptionNotification
}

export interface SubscriptionNotification {
    version: string,
    notificationType: number,
    purchaseToken: string,
    subscriptionId: string
}