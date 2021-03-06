import {hashKey, attribute, rangeKey} from '@aws/dynamodb-data-mapper-annotations';
import {DynamoDbTable} from "@aws/dynamodb-data-mapper";
import {App, Stage} from "../utils/appIdentity";

export class UserSubscription {

    @hashKey()
    userId: string;

    @rangeKey()
    subscriptionId: string;

    @attribute()
    creationTimestamp: string;

    constructor(userId: string, subscriptionId: string, creationTimestamp: string) {
        this.userId = userId;
        this.subscriptionId = subscriptionId;
        this.creationTimestamp = creationTimestamp;
    }

    get[DynamoDbTable]() {
        return `${App}-${Stage}-user-subscriptions`
    }

}

export class ReadUserSubscription extends UserSubscription {

    constructor() {
        super("", "", "");
    }

}

