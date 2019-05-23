export class PurchaseEvent{
    purchaseId: string;
    timestampAndType: string;
    platform: string;
    eventType: string;
    originalPayload: any;
    ttl: number;

    constructor(purchaseId: string, timestampAndType: string, platform: string, eventType: string, originalPayload: any, ttl: number) {
        this.purchaseId = purchaseId;
        this.timestampAndType = timestampAndType;
        this.platform = platform;
        this.eventType = eventType;
        this.originalPayload = originalPayload;
        this.ttl = ttl;
    }
}